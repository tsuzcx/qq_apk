package com.tencent.gamecenter.wadl.api.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.GameNoticeInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.GameCenterListener;
import com.tencent.gamecenter.wadl.biz.listener.WadlCmdListener;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGameNoticeServiceImpl
  extends CopyOnWriteArrayList<GameNoticeInfo>
  implements Handler.Callback, IQQGameNoticeService, GameCenterListener, WadlCmdListener
{
  private static final Comparator<GameNoticeInfo> COMPARATOR = new QQGameNoticeServiceImpl.1();
  public static final long HOUR_3 = 10800000L;
  public static final long MIN_1 = 60000L;
  public static final long ONE_DAY = 86400000L;
  public static final long SEVEN_DAY = 604800000L;
  public static final String TAG = "Wadl_QQGameNoticeServiceImpl";
  public static final long TWO_DAY = 172800000L;
  public static final int WHAT_CLICK_BANNER = 2;
  public static final int WHAT_CLOSE_BANNER = 1;
  static HashSet<String> cmdMap = new HashSet();
  private final int arkTypeCare = 2;
  private final int arkTypeNormal = 0;
  private final int arkTypeTemptation = 1;
  private Runnable mCheckBanner = new QQGameNoticeServiceImpl.2(this);
  private volatile AtomicBoolean mCheckBannerPosted = new AtomicBoolean(false);
  private GameNoticeInfo mCurrentBanner;
  private EntityManager mEntityManager;
  private MqqHandler mHandler;
  private volatile AtomicBoolean mInit = new AtomicBoolean(false);
  private long mLastRefreshTime;
  private final int typeDelete = 2;
  private final int typeInstall = 1;
  
  static
  {
    cmdMap.add("12855");
  }
  
  private void checkBanner()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkBanner now=");
    ((StringBuilder)localObject1).append(l1);
    ((StringBuilder)localObject1).append(",mLastRefreshTime=");
    ((StringBuilder)localObject1).append(this.mLastRefreshTime);
    ((StringBuilder)localObject1).append(",size=");
    ((StringBuilder)localObject1).append(size());
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, ((StringBuilder)localObject1).toString());
    if (l1 - this.mLastRefreshTime < 60000L)
    {
      QLog.w("Wadl_QQGameNoticeServiceImpl", 1, "checkBanner time limit!");
      return;
    }
    this.mLastRefreshTime = l1;
    if (!this.mInit.getAndSet(true)) {
      loadGameNoticeInfos();
    }
    Object localObject2 = null;
    label489:
    for (;;)
    {
      try
      {
        Iterator localIterator = iterator();
        localObject1 = localObject2;
        if (localIterator.hasNext())
        {
          localObject1 = (GameNoticeInfo)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkBanner info=");
          localStringBuilder.append(localObject1);
          QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
          if (!((GameNoticeInfo)localObject1).isValid())
          {
            remove(localObject1);
            continue;
          }
          if (((GameNoticeInfo)localObject1).bannerType == 1)
          {
            long l2 = new File(((GameNoticeInfo)localObject1).filePath).lastModified();
            requestRedPointIfNeed(l2, l1, (GameNoticeInfo)localObject1);
            requestPushArkIfNeed(l2, l1, (GameNoticeInfo)localObject1);
          }
          if (l1 < ((GameNoticeInfo)localObject1).startTime)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkBanner  is not time, info=");
            localStringBuilder.append(localObject1);
            QLog.w("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
            continue;
          }
          if (((GameNoticeInfo)localObject1).bannerType == 1) {
            break label489;
          }
          if (((GameNoticeInfo)localObject1).bannerType != 2) {
            continue;
          }
          if (requestGameRegisterInfo((GameNoticeInfo)localObject1))
          {
            QLog.d("Wadl_QQGameNoticeServiceImpl", 1, "request register info, break! ");
            localObject1 = localObject2;
          }
          else
          {
            if ((!TextUtils.isEmpty(((GameNoticeInfo)localObject1).title)) && (!TextUtils.isEmpty(((GameNoticeInfo)localObject1).jumpUrl))) {
              break label489;
            }
            QLog.d("Wadl_QQGameNoticeServiceImpl", 1, "title or jumpUrl is empty, break! ");
            remove(localObject1);
            continue;
          }
        }
        if (localObject1 == null)
        {
          QLog.d("Wadl_QQGameNoticeServiceImpl", 1, "getting no banner to show");
          hideBanner();
          return;
        }
        if (((GameNoticeInfo)localObject1).equals(this.mCurrentBanner))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mCurrentBanner not changed, mCurrentBanner=");
          ((StringBuilder)localObject1).append(this.mCurrentBanner);
          QLog.w("Wadl_QQGameNoticeServiceImpl", 1, ((StringBuilder)localObject1).toString());
          return;
        }
        this.mCurrentBanner = ((GameNoticeInfo)((GameNoticeInfo)localObject1).clone());
        showBanner(this.mCurrentBanner);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Wadl_QQGameNoticeServiceImpl", 1, "checkBanner exception!", localThrowable);
        return;
      }
    }
  }
  
  private GameNoticeInfo getByAppId(String paramString)
  {
    Object localObject = iterator();
    while (((Iterator)localObject).hasNext())
    {
      localGameNoticeInfo = (GameNoticeInfo)((Iterator)localObject).next();
      if ((!TextUtils.isEmpty(localGameNoticeInfo.appId)) && (localGameNoticeInfo.appId.equals(paramString))) {
        break label50;
      }
    }
    GameNoticeInfo localGameNoticeInfo = null;
    label50:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getByAppId appId=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",noticeInfo=");
    ((StringBuilder)localObject).append(localGameNoticeInfo);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, ((StringBuilder)localObject).toString());
    return localGameNoticeInfo;
  }
  
  private boolean handleTaskChange(WadlResult paramWadlResult)
  {
    Object localObject1 = getByAppId(paramWadlResult.a.e);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("processTaskInfo find info=");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(",taskInfo=");
    ((StringBuilder)localObject2).append(paramWadlResult);
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool2 = true;
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, (String)localObject2);
    int i = paramWadlResult.d;
    if ((i != 6) && (i != 9)) {
      i = 0;
    } else {
      i = GameNoticeInfo.convertToBannerType(paramWadlResult);
    }
    if (i == 0)
    {
      if (localObject1 != null)
      {
        remove(localObject1);
        return true;
      }
      return false;
    }
    boolean bool1;
    if ((localObject1 != null) && ((((GameNoticeInfo)localObject1).bannerType != i) || (((GameNoticeInfo)localObject1).createTime != paramWadlResult.h)))
    {
      remove(localObject1);
      QLog.d("Wadl_QQGameNoticeServiceImpl", 1, new Object[] { "processTaskInfo: remove GameNoticeInfo: ", localObject1 });
      localObject1 = null;
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    if (localObject1 == null)
    {
      localObject1 = MobileQQ.sMobileQQ;
      paramWadlResult = new GameNoticeInfo(paramWadlResult, MobileQQ.getContext());
      if (paramWadlResult.isValid())
      {
        add(paramWadlResult);
        QLog.d("Wadl_QQGameNoticeServiceImpl", 1, new Object[] { "processTaskInfo: add GameNoticeInfo: ", paramWadlResult });
        bool1 = bool2;
        if (i == 2)
        {
          requestGameRegisterInfo(paramWadlResult);
          return true;
        }
      }
      else
      {
        QLog.e("Wadl_QQGameNoticeServiceImpl", 1, new Object[] { "processTaskInfo: invalid GameNoticeInfo: ", paramWadlResult });
      }
    }
    return bool1;
  }
  
  private void loadGameNoticeInfos()
  {
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)this.mEntityManager.query(GameNoticeInfo.class);
        if (localArrayList != null)
        {
          localObject = localArrayList.iterator();
          if (((Iterator)localObject).hasNext())
          {
            GameNoticeInfo localGameNoticeInfo = (GameNoticeInfo)((Iterator)localObject).next();
            if (!localGameNoticeInfo.isValid())
            {
              ((Iterator)localObject).remove();
              continue;
            }
            MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
            localGameNoticeInfo.setTipsInfo(MobileQQ.getContext());
            continue;
          }
          addAll(localArrayList);
          sort();
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadGameNoticeInfos size=");
        if (localArrayList != null)
        {
          i = localArrayList.size();
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", cache size=");
          ((StringBuilder)localObject).append(size());
          QLog.d("Wadl_QQGameNoticeServiceImpl", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Wadl_QQGameNoticeServiceImpl", 1, "loadGameNoticeInfos exception", localThrowable);
        return;
      }
      int i = 0;
    }
  }
  
  private void refreshBanner(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshBanner type=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",appId=");
    localStringBuilder.append(paramString);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
    for (;;)
    {
      try
      {
        if ((this.mCurrentBanner != null) && (this.mCurrentBanner.appId.equals(paramString)))
        {
          int i = 0;
          if (paramInt != 1) {
            break label126;
          }
          paramInt = i;
          if (this.mCurrentBanner.bannerType == 1) {
            break label126;
          }
          if (paramInt != 0)
          {
            remove(this.mCurrentBanner);
            hideBanner();
            return;
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("Wadl_QQGameNoticeServiceImpl", 1, "refreshBanner exception!", paramString);
      }
      return;
      label126:
      paramInt = 1;
    }
  }
  
  private final boolean requestGameRegisterInfo(GameNoticeInfo paramGameNoticeInfo)
  {
    if (!paramGameNoticeInfo.infoRequested)
    {
      paramGameNoticeInfo.infoRequested = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestGameRegisterInfo appId=");
      localStringBuilder.append(paramGameNoticeInfo.appId);
      QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
      ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).getGameRegisterInfo(paramGameNoticeInfo.appId);
      return true;
    }
    return false;
  }
  
  private void requestPushArkIfNeed(long paramLong1, long paramLong2, GameNoticeInfo paramGameNoticeInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("REQUEST_ARK_TIME_");
    localStringBuilder.append(paramGameNoticeInfo.appId);
    long l = GameCenterSpUtils.c(localStringBuilder.toString());
    int i = 0;
    boolean bool;
    if ((paramLong2 - l <= 86400000L) && (l <= paramLong2)) {
      bool = false;
    } else {
      bool = true;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("lastRequestArkTime=");
    localStringBuilder.append(l);
    localStringBuilder.append(",now=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(",fileLastModifiedTime=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(",bRequestArk=");
    localStringBuilder.append(bool);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
    if (bool)
    {
      paramLong1 = paramLong2 - paramLong1;
      if ((paramLong1 <= 300000L) || (paramLong1 > 10800000L)) {
        if ((paramLong1 > 10800000L) && (paramLong1 <= 86400000L)) {
          i = 1;
        } else if (paramLong1 > 86400000L) {
          i = 2;
        } else {
          i = -1;
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestPushArkIfNeed lostTime=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",arkType=");
      localStringBuilder.append(i);
      QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
      if (i > -1)
      {
        ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).requestArk(paramGameNoticeInfo.appId, i);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("REQUEST_ARK_TIME_");
        localStringBuilder.append(paramGameNoticeInfo.appId);
        GameCenterSpUtils.a(localStringBuilder.toString(), paramLong2);
      }
    }
  }
  
  private void requestRedPointIfNeed(long paramLong1, long paramLong2, GameNoticeInfo paramGameNoticeInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KEY_RED_POINT_TIME_");
    localStringBuilder.append(paramGameNoticeInfo.appId);
    long l = GameCenterSpUtils.c(localStringBuilder.toString());
    boolean bool;
    if ((paramLong2 - l <= 604800000L) && (l <= paramLong2)) {
      bool = false;
    } else {
      bool = true;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestRedPointIfNeed lastReqRedDotTime=");
    localStringBuilder.append(l);
    localStringBuilder.append(",now=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(",fileLastModifiedTime=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(",bRequestRedDot=");
    localStringBuilder.append(bool);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
    if (bool)
    {
      paramLong1 = paramLong2 - paramLong1;
      if ((paramLong1 > 86400000L) && (paramLong1 < 172800000L))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("KEY_RED_POINT_TIME_");
        localStringBuilder.append(paramGameNoticeInfo.appId);
        GameCenterSpUtils.a(localStringBuilder.toString(), paramLong2);
        if (!PackageUtil.a(MobileQQ.sMobileQQ, paramGameNoticeInfo.packageName)) {
          ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).requestRedPoint(9);
        }
      }
    }
  }
  
  private void showBanner(GameNoticeInfo paramGameNoticeInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("showBanner banner=");
    ((StringBuilder)localObject1).append(paramGameNoticeInfo);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, ((StringBuilder)localObject1).toString());
    if (paramGameNoticeInfo == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramGameNoticeInfo.appId);
    String str = paramGameNoticeInfo.title;
    Object localObject2 = str;
    if (paramGameNoticeInfo.bannerType == 1)
    {
      localObject2 = (WadlCommConfig)((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).getConfig("comminfo");
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = ((WadlCommConfig)localObject2).a(paramGameNoticeInfo.downloadType);
      } else if (paramGameNoticeInfo.downloadType == 1) {
        localObject1 = CommonDataAdapter.a().b().getString(2131892180);
      } else if (paramGameNoticeInfo.downloadType == 3) {
        localObject1 = CommonDataAdapter.a().b().getString(2131892181);
      }
      localObject2 = str;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(str);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    localBundle.putString("tips", (String)localObject2);
    if (!TextUtils.isEmpty(paramGameNoticeInfo.iconUrl)) {
      localBundle.putString("iconURL", paramGameNoticeInfo.iconUrl);
    }
    localObject1 = new Message();
    ((Message)localObject1).what = 1134071;
    ((Message)localObject1).obj = localBundle;
    BannerManager.a().a(BannerTypeCollections.I, 2, (Message)localObject1);
    if (paramGameNoticeInfo.bannerType == 1)
    {
      localObject1 = new WadlReportBuilder();
      ((WadlReportBuilder)localObject1).a("dc00087").b(paramGameNoticeInfo.appId).h("81706").c("205431").a(4, "8").a(35, paramGameNoticeInfo.apkChannel).a(10, paramGameNoticeInfo.getReportType());
      if (paramGameNoticeInfo.isGray)
      {
        ((WadlReportBuilder)localObject1).i(paramGameNoticeInfo.expeKey);
        ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).reportTianJi("59", paramGameNoticeInfo.expeKey, "", "205431", "1000", "1000", "0", "0");
      }
      ((WadlReportBuilder)localObject1).a();
      return;
    }
    if (paramGameNoticeInfo.bannerType == 2)
    {
      localObject1 = new WadlReportBuilder();
      ((WadlReportBuilder)localObject1).a("dc00087").b(paramGameNoticeInfo.appId).h("81707").c("205433").a(4, "8").a(35, paramGameNoticeInfo.apkChannel).a(10, paramGameNoticeInfo.getReportType());
      ((WadlReportBuilder)localObject1).a();
    }
  }
  
  private void sort()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this);
      Collections.sort(localArrayList, COMPARATOR);
      clear();
      addAll(localArrayList);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Wadl_QQGameNoticeServiceImpl", 1, "sort exception", localThrowable);
    }
  }
  
  private static void startActivityWithUrl(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startActivityWithUrl url=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, ((StringBuilder)localObject).toString());
    localObject = new ActivityURIRequest(MobileQQ.getContext(), "/base/activity/GameCenterActivity");
    ((ActivityURIRequest)localObject).extra().putString("url", paramString);
    ((ActivityURIRequest)localObject).extra().putString("big_brother_source_key", "biz_src_zf_games");
    ((ActivityURIRequest)localObject).extra().putLong("startOpenPageTime", System.currentTimeMillis());
    ((ActivityURIRequest)localObject).setFlags(268435456);
    QRoute.startUri((URIRequest)localObject, null);
  }
  
  public boolean add(GameNoticeInfo paramGameNoticeInfo)
  {
    boolean bool = super.add(paramGameNoticeInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add ret=");
    localStringBuilder.append(bool);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
    if (bool) {
      this.mEntityManager.persist(paramGameNoticeInfo);
    }
    return bool;
  }
  
  public void checkBannerFromResume()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkBannerFromResume mCheckBannerPosted=");
    localStringBuilder.append(this.mCheckBannerPosted);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
    if (!this.mCheckBannerPosted.getAndSet(true))
    {
      int i;
      if (Looper.getMainLooper() == Looper.myLooper()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        ThreadManagerV2.excute(this.mCheckBanner, 16, null, true);
      } else {
        this.mCheckBanner.run();
      }
    }
    ((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).setReadyToPreloadHippy(true);
    ((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).preloadNewQQGamePaHippy();
  }
  
  public HashSet<String> getFilterCmds()
  {
    return cmdMap;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleMessage msg=");
    ((StringBuilder)localObject).append(paramMessage.what);
    ((StringBuilder)localObject).append(",appid=");
    ((StringBuilder)localObject).append(paramMessage.obj);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, ((StringBuilder)localObject).toString());
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2)
      {
        hideBanner();
        if ((paramMessage.obj instanceof String))
        {
          localObject = (String)paramMessage.obj;
          paramMessage = getByAppId((String)localObject);
          if (paramMessage != null)
          {
            remove(paramMessage);
            if (paramMessage.bannerType == 1)
            {
              if (paramMessage.isGray)
              {
                ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).reportTianJi("59", paramMessage.expeKey, "", "205432", "1000", "1000", "0", "0");
                localObject = new WadlParams((String)localObject, paramMessage.packageName);
                ((WadlParams)localObject).A = "biz_src_zf_games";
                ((WadlParams)localObject).d(1);
                WadlProxyServiceUtil.a().c((WadlParams)localObject);
              }
              else
              {
                startActivityWithUrl(paramMessage.jumpUrl);
              }
              localObject = new WadlReportBuilder();
              ((WadlReportBuilder)localObject).a("dc00087").b(paramMessage.appId).h("81706").c("205432").a(4, "20").a(35, paramMessage.apkChannel).a(10, paramMessage.getReportType());
              if (paramMessage.isGray) {
                ((WadlReportBuilder)localObject).i(paramMessage.expeKey);
              }
              ((WadlReportBuilder)localObject).a();
            }
            else if (paramMessage.bannerType == 2)
            {
              localObject = new WadlReportBuilder();
              ((WadlReportBuilder)localObject).a("dc00087").b(paramMessage.appId).h("81707").c("205434").a(4, "20").a(35, paramMessage.apkChannel).a(10, paramMessage.getReportType());
              ((WadlReportBuilder)localObject).a();
              startActivityWithUrl(paramMessage.jumpUrl);
            }
          }
        }
      }
    }
    else
    {
      hideBanner();
      if ((paramMessage.obj instanceof String))
      {
        paramMessage = getByAppId((String)paramMessage.obj);
        if (paramMessage != null)
        {
          remove(paramMessage);
          if (paramMessage.bannerType == 1)
          {
            localObject = new WadlReportBuilder();
            ((WadlReportBuilder)localObject).a("dc00087").b(paramMessage.appId).h("81706").c("205435").a(4, "20").a(35, paramMessage.apkChannel).a(10, paramMessage.getReportType());
            if (paramMessage.isGray) {
              ((WadlReportBuilder)localObject).i(paramMessage.expeKey);
            }
            ((WadlReportBuilder)localObject).a();
          }
          else if (paramMessage.bannerType == 2)
          {
            localObject = new WadlReportBuilder();
            ((WadlReportBuilder)localObject).a("dc00087").b(paramMessage.appId).h("81707").c("205436").a(4, "20").a(35, paramMessage.apkChannel).a(10, paramMessage.getReportType());
            ((WadlReportBuilder)localObject).a();
          }
        }
      }
    }
    return false;
  }
  
  protected void hideBanner()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hideBanner mCurrentBanner=");
    ((StringBuilder)localObject).append(this.mCurrentBanner);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (this.mCurrentBanner != null)
    {
      localObject = new Message();
      ((Message)localObject).what = 1134072;
      BannerManager.a().a(BannerTypeCollections.I, 0, (Message)localObject);
      this.mCurrentBanner = null;
    }
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    if (("12855".equals(paramString)) && (paramLong == 0L))
    {
      paramIntent = paramJSONObject.optString("game_appid");
      paramString = new StringBuilder();
      paramString.append("parseGameRegisterInfo dataJson=");
      paramString.append(paramJSONObject.toString());
      QLog.d("Wadl_QQGameNoticeServiceImpl", 1, paramString.toString());
      paramString = getByAppId(paramIntent);
      int i = 0;
      if (paramString != null)
      {
        if (paramJSONObject.optInt("registered", 0) == 1) {
          i = 1;
        }
        if (i != 0)
        {
          remove(paramString);
        }
        else
        {
          paramLong = paramJSONObject.optLong("bar_delay");
          long l = paramJSONObject.optLong("bar_interval");
          GameCenterSpUtils.a("MILLISECONDS_DELAY", paramLong);
          GameCenterSpUtils.a("MILLISECONDS_INTERVAL", l);
        }
        paramIntent = new StringBuilder();
        paramIntent.append("parseGameRegisterInfo info=");
        paramIntent.append(paramString);
        QLog.d("Wadl_QQGameNoticeServiceImpl", 1, paramIntent.toString());
        checkBanner();
        return;
      }
      QLog.e("Wadl_QQGameNoticeServiceImpl", 1, new Object[] { "parseGameRegisterInfo, GameNoticeInfo for ", paramIntent, " not found!" });
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate appRuntime=");
    localStringBuilder.append(paramAppRuntime);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
    this.mEntityManager = paramAppRuntime.getEntityManagerFactory().createEntityManager();
    this.mHandler = new MqqHandler(Looper.getMainLooper(), this);
    GameCenterReceiver.b();
    GameCenterReceiver.a(this);
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).addListener(this);
  }
  
  public void onDestroy()
  {
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, "onDestroy");
    GameNoticeInfo localGameNoticeInfo = this.mCurrentBanner;
    if (localGameNoticeInfo != null) {
      remove(localGameNoticeInfo);
    }
    GameCenterReceiver.b(this);
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).removeListener(this);
    hideBanner();
    this.mInit.set(false);
  }
  
  public void onTaskComplete(WadlResult paramWadlResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTaskComplete wadlResult=");
    localStringBuilder.append(paramWadlResult);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
    if (handleTaskChange(paramWadlResult)) {
      sort();
    }
  }
  
  public void onTaskDeleted(String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("onTaskDeleted appId=");
    paramString2.append(paramString1);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, paramString2.toString());
    refreshBanner(2, paramString1);
  }
  
  public void onTaskInstall(WadlResult paramWadlResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTaskInstall wadlResult=");
    localStringBuilder.append(paramWadlResult);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
    if (handleTaskChange(paramWadlResult)) {
      sort();
    }
  }
  
  public GameNoticeInfo remove(int paramInt)
  {
    GameNoticeInfo localGameNoticeInfo = (GameNoticeInfo)super.remove(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("remove index=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",info=");
    localStringBuilder.append(localGameNoticeInfo);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
    if (localGameNoticeInfo != null) {
      this.mEntityManager.remove(localGameNoticeInfo);
    }
    return localGameNoticeInfo;
  }
  
  public boolean remove(Object paramObject)
  {
    boolean bool = super.remove(paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("remove ret=");
    localStringBuilder.append(bool);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
    if ((bool) && ((paramObject instanceof Entity))) {
      this.mEntityManager.remove((Entity)paramObject);
    }
    return bool;
  }
  
  public void saveTipInfo(String paramString, JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramJSONObject == null) {
        return;
      }
      QLog.d("Wadl_QQGameNoticeServiceImpl", 1, new Object[] { "saveTipInfo: ", paramJSONObject.toString() });
      JSONObject localJSONObject1 = new JSONObject();
      SharedPreferences.Editor localEditor = MobileQQ.sMobileQQ.getSharedPreferences("wadl_TipInfo", 4).edit();
      try
      {
        JSONObject localJSONObject2 = paramJSONObject.optJSONObject("install_bartips");
        if ((localJSONObject2 != null) && (localJSONObject2.optBoolean("valid", false))) {
          localJSONObject1.put("install_bartips", localJSONObject2);
        }
        localJSONObject2 = paramJSONObject.optJSONObject("register_bartips");
        if ((localJSONObject2 != null) && (localJSONObject2.optBoolean("valid", false))) {
          localJSONObject1.put("register_bartips", localJSONObject2);
        }
        if (paramJSONObject.has("app_icon")) {
          localJSONObject1.put("app_icon", paramJSONObject.optString("app_icon"));
        }
        if (paramJSONObject.has("install_tips_gray")) {
          localJSONObject1.put("install_tips_gray", paramJSONObject.optString("install_tips_gray"));
        }
        if (paramJSONObject.has("default_install_bartips_text")) {
          localEditor.putString("default_install_bartips_text", paramJSONObject.optString("default_install_bartips_text"));
        }
        if (paramJSONObject.has("default_register_bartips_text")) {
          localEditor.putString("default_register_bartips_text", paramJSONObject.optString("default_register_bartips_text"));
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("Wadl_QQGameNoticeServiceImpl", 1, paramJSONObject, new Object[0]);
      }
      if (localJSONObject1.length() > 0) {
        localEditor.putString(paramString.trim(), localJSONObject1.toString());
      }
      localEditor.commit();
    }
  }
  
  public void updateGameCenterBar(View paramView, Message paramMessage)
  {
    if (!(paramView instanceof TipsBar)) {
      return;
    }
    paramView = (TipsBar)paramView;
    if (paramMessage == null)
    {
      QLog.d("Wadl_QQGameNoticeServiceImpl", 1, "updateGameCenterBar msg is null");
      return;
    }
    if ((paramMessage.what != 1134071) && (paramMessage.what != 1134072))
    {
      paramView = new StringBuilder();
      paramView.append("updateGameCenterBar msg.what=");
      paramView.append(paramMessage.what);
      QLog.d("Wadl_QQGameNoticeServiceImpl", 1, paramView.toString());
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("updateGameCenterBar msg.what=");
    ((StringBuilder)localObject1).append(paramMessage.what);
    ((StringBuilder)localObject1).append(",msg.obj = ");
    ((StringBuilder)localObject1).append(paramMessage.obj);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, ((StringBuilder)localObject1).toString());
    if (paramMessage.what == 1134050)
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setTipsIcon(MobileQQ.sMobileQQ.getResources().getDrawable(2130838358));
    paramView.setTipsText("");
    paramView.setVisibility(0);
    if ((paramMessage.obj instanceof Bundle))
    {
      Object localObject2 = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject2).getString("appid");
      localObject1 = ((Bundle)localObject2).getString("tips");
      localObject2 = ((Bundle)localObject2).getString("iconURL");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateGameCenterBar  appid=");
      localStringBuilder.append(paramMessage);
      localStringBuilder.append(",tips= ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(",iconURL= ");
      localStringBuilder.append((String)localObject2);
      QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
      paramView.setOnClickListener(new QQGameNoticeServiceImpl.3(this, paramMessage));
      paramView.setCloseListener(new QQGameNoticeServiceImpl.4(this, paramMessage));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView.setTipsText((CharSequence)localObject1);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramMessage = URLDrawable.getDrawable((String)localObject2, URLDrawable.URLDrawableOptions.obtain());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("urlDrawable status=");
        ((StringBuilder)localObject1).append(paramMessage.getStatus());
        QLog.d("Wadl_QQGameNoticeServiceImpl", 1, ((StringBuilder)localObject1).toString());
        if (paramMessage.getStatus() == 1)
        {
          paramView.setTipsIcon(paramMessage);
          return;
        }
        paramMessage.setURLDrawableListener(new QQGameNoticeServiceImpl.5(this, paramView));
        paramMessage.startDownload();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameNoticeServiceImpl
 * JD-Core Version:    0.7.0.1
 */