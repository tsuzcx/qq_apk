package com.tencent.biz.qqcircle;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.manager.QFSPictureReloadManager;
import com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager;
import com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue;
import com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity;
import com.tencent.biz.qqcircle.richframework.helper.VideoPreloadHelper;
import com.tencent.biz.qqcircle.richframework.outbox.BaseOutboxTaskQueue;
import com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.IQCircleColdBootService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.relation.QCircleRelationGroupManager;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.lang.reflect.Field;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCirclePluginUtil
{
  private static long a;
  
  public static int a()
  {
    return b(QCircleCommonUtil.isInNightMode());
  }
  
  public static int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4) {
            return 0;
          }
          return 2;
        }
        return 3;
      }
      return 1;
    }
    return 0;
  }
  
  public static int a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.startsWith("https://")) {
        return 0;
      }
      if (paramString.startsWith("mqqapi://")) {
        return 1;
      }
    }
    return -1;
  }
  
  public static int a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static QCircleInitBean a(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      if ((paramContext.getIntent() != null) && (paramContext.getIntent().hasExtra("key_bundle_common_init_bean"))) {
        return (QCircleInitBean)paramContext.getIntent().getSerializableExtra("key_bundle_common_init_bean");
      }
    }
    return null;
  }
  
  public static FeedCloudMeta.StComment a(FeedCloudMeta.StComment paramStComment)
  {
    if (paramStComment == null)
    {
      QLog.e("QCirclePluginUtil", 1, "getSimpleComment param comment is null");
      return null;
    }
    FeedCloudMeta.StComment localStComment = new FeedCloudMeta.StComment();
    localStComment.id.set(paramStComment.id.get());
    if (paramStComment.postUser != null)
    {
      paramStComment = new FeedCloudMeta.StUser();
      paramStComment.id.set(localStComment.postUser.id.get());
      localStComment.postUser.set(paramStComment);
      return localStComment;
    }
    QLog.e("QCirclePluginUtil", 1, "getSimpleComment poster is null");
    return localStComment;
  }
  
  public static FeedCloudMeta.StFeed a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.e("QCirclePluginUtil", 1, "getSimpleFeed param feed is null");
      return null;
    }
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    localStFeed.id.set(paramStFeed.id.get());
    localStFeed.createTime.set(paramStFeed.createTime.get());
    if (paramStFeed.poster != null)
    {
      FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
      localStUser.id.set(paramStFeed.poster.id.get());
      localStFeed.poster.set(localStUser);
      return localStFeed;
    }
    QLog.e("QCirclePluginUtil", 1, "getSimpleFeed poster is null");
    return localStFeed;
  }
  
  public static FeedCloudMeta.StLike a(FeedCloudMeta.StLike paramStLike)
  {
    FeedCloudMeta.StLike localStLike = new FeedCloudMeta.StLike();
    if (paramStLike == null) {
      return localStLike;
    }
    try
    {
      localStLike.mergeFrom(paramStLike.toByteArray());
      return localStLike;
    }
    catch (InvalidProtocolBufferMicroException paramStLike)
    {
      paramStLike.printStackTrace();
    }
    return localStLike;
  }
  
  public static FeedCloudMeta.StReply a(FeedCloudMeta.StReply paramStReply)
  {
    FeedCloudMeta.StReply localStReply = new FeedCloudMeta.StReply();
    if (paramStReply == null) {
      return localStReply;
    }
    try
    {
      localStReply.mergeFrom(paramStReply.toByteArray());
      return localStReply;
    }
    catch (InvalidProtocolBufferMicroException paramStReply)
    {
      paramStReply.printStackTrace();
    }
    return localStReply;
  }
  
  public static String a(long paramLong)
  {
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd");
    if (paramLong == 0L) {
      localObject1 = new Date();
    } else {
      localObject1 = new Date(paramLong);
    }
    localObject2 = ((SimpleDateFormat)localObject2).format((Date)localObject1);
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    paramLong = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(paramLong);
    int i = localTime2.yearDay - 1;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(" ");
    ((StringBuilder)localObject3).append(localTime1.hour);
    ((StringBuilder)localObject3).append(":");
    if (localTime1.minute < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(localTime1.minute);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = Integer.valueOf(localTime1.minute);
    }
    ((StringBuilder)localObject3).append(localObject1);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject1 = localObject2;
    if (localTime1.year == localTime2.year)
    {
      if (localTime2.yearDay < localTime1.yearDay) {
        return localObject2;
      }
      if (localTime2.yearDay == localTime1.yearDay)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131917319));
        ((StringBuilder)localObject1).append((String)localObject3);
        return ((StringBuilder)localObject1).toString();
      }
      if (localTime1.yearDay == i)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131918208));
        ((StringBuilder)localObject1).append((String)localObject3);
        return ((StringBuilder)localObject1).toString();
      }
      if (localTime1.yearDay + 1 == i)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131887542));
        ((StringBuilder)localObject1).append((String)localObject3);
        return ((StringBuilder)localObject1).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localTime1.month + 1);
      ((StringBuilder)localObject1).append("-");
      ((StringBuilder)localObject1).append(localTime1.monthDay);
      ((StringBuilder)localObject1).append((String)localObject3);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = HardCodeUtil.a(2131895633);
    } else {
      str = "W";
    }
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      localObject = new DecimalFormat();
      ((DecimalFormat)localObject).setMaximumFractionDigits(1);
      ((DecimalFormat)localObject).setGroupingSize(0);
      ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
      StringBuilder localStringBuilder = new StringBuilder();
      double d = paramLong;
      Double.isNaN(d);
      localStringBuilder.append(((DecimalFormat)localObject).format(d / 10000.0D));
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    if (paramLong < 100000000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong / 10000L);
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("9999");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      if (!f(paramString3))
      {
        if (paramString3.startsWith("http")) {
          return paramString3;
        }
        String str = QCircleConfigHelper.a(paramString1, paramString2);
        QLog.d("QCirclePluginUtil", 1, String.format("convertDomainToIp ips:%s, main:%s,second:%s", new Object[] { str, paramString1, paramString2 }));
        if (str != null)
        {
          paramString2 = new JSONObject(str);
          if (paramString4 != null)
          {
            paramString1 = paramString4;
            if (paramString4.trim().length() != 0) {}
          }
          else
          {
            paramString1 = b(paramString3);
          }
          if ((paramString1 != null) && (paramString2.has(paramString1)))
          {
            paramString4 = paramString2.getJSONArray(paramString1);
            if ((paramString4.length() > 0) && ((paramString4.get(0) instanceof JSONObject)) && (((JSONObject)paramString4.get(0)).has("ip")) && (((JSONObject)paramString4.get(0)).has("port")))
            {
              paramString2 = ((JSONObject)paramString4.get(0)).getString("ip");
              paramString4 = ((JSONObject)paramString4.get(0)).getString("port");
              if ((paramString2.trim().length() > 0) && (paramString4.trim().length() > 0))
              {
                paramString1 = paramString3.replace(paramString1, String.format("%s:%s", new Object[] { paramString2, paramString4 }));
                paramString2 = new StringBuilder();
                paramString2.append("convertDomainToIp newUrl:");
                paramString2.append(paramString1);
                QLog.d("QCirclePluginUtil", 1, paramString2.toString());
                return paramString1;
              }
              QLog.w("QCirclePluginUtil", 1, String.format("convertDomainToIp  IP&Port empty url:%s, ip:%s,  port:%s", new Object[] { paramString3, paramString2, paramString4 }));
            }
          }
        }
        QLog.d("QCirclePluginUtil", 1, "convertDomainToIp use old url");
      }
      return paramString3;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      QLog.d("QCirclePluginUtil", 1, "convertDomainToIp use old url");
    }
    return paramString3;
  }
  
  public static String a(List<FeedCloudCommon.Entry> paramList, String paramString)
  {
    return a(paramList, paramString, "");
  }
  
  public static String a(List<FeedCloudCommon.Entry> paramList, String paramString1, String paramString2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedCloudCommon.Entry localEntry = (FeedCloudCommon.Entry)paramList.next();
        if (localEntry.key.get().equals(paramString1)) {
          return localEntry.value.get();
        }
      }
    }
    return paramString2;
  }
  
  public static List<FeedCloudMeta.StComment> a(String paramString, List<FeedCloudMeta.StComment> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramList.size() > 0)
    {
      if ((paramList.get(0) != null) && (((FeedCloudMeta.StComment)paramList.get(0)).typeFlag.get() == 1)) {
        ((FeedCloudMeta.StComment)paramList.get(0)).typeFlag.set(0);
      }
      Iterator localIterator = paramList.iterator();
      paramList = null;
      while (localIterator.hasNext())
      {
        FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator.next();
        if (localStComment.id.get().equals(paramString))
        {
          localStComment.typeFlag.set(1);
          paramList = localStComment;
        }
        else
        {
          localLinkedList.add(localStComment);
        }
      }
      if (paramList != null) {
        localLinkedList.add(0, paramList);
      }
      return localLinkedList;
    }
    return paramList;
  }
  
  public static QQCircleBase.StUserBusiData a(FeedCloudMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (paramStUser.busiData.get() != null)) {
      try
      {
        QQCircleBase.StUserBusiData localStUserBusiData = new QQCircleBase.StUserBusiData();
        localStUserBusiData.mergeFrom(paramStUser.busiData.get().toByteArray());
        return localStUserBusiData;
      }
      catch (Exception paramStUser)
      {
        paramStUser.printStackTrace();
      }
    }
    return null;
  }
  
  public static QQCircleDitto.StItemContainer a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    QQCircleDitto.StItemContainer localStItemContainer = new QQCircleDitto.StItemContainer();
    if (paramStItemContainer == null) {
      return localStItemContainer;
    }
    try
    {
      localStItemContainer.mergeFrom(paramStItemContainer.toByteArray());
      return localStItemContainer;
    }
    catch (InvalidProtocolBufferMicroException paramStItemContainer)
    {
      QLog.e("deepCopyContainer", 4, " failed", paramStItemContainer);
    }
    return localStItemContainer;
  }
  
  public static QQCircleFeedBase.StPolyLike a(QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    QQCircleFeedBase.StPolyLike localStPolyLike = new QQCircleFeedBase.StPolyLike();
    if (paramStPolyLike == null) {
      return localStPolyLike;
    }
    try
    {
      localStPolyLike.mergeFrom(paramStPolyLike.toByteArray());
      return localStPolyLike;
    }
    catch (InvalidProtocolBufferMicroException paramStPolyLike)
    {
      paramStPolyLike.printStackTrace();
    }
    return localStPolyLike;
  }
  
  public static void a(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "mDismissMessage";
    arrayOfString[1] = "mCancelMessage";
    arrayOfString[2] = "mShowMessage";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      try
      {
        localObject = Dialog.class.getDeclaredField((String)localObject);
        if (localObject != null)
        {
          if (!((Field)localObject).isAccessible()) {
            ((Field)localObject).setAccessible(true);
          }
          localObject = ((Field)localObject).get(paramDialog);
          if ((localObject instanceof Message))
          {
            localObject = (Message)localObject;
            if (((Message)localObject).obj != null)
            {
              ((Message)localObject).obj = null;
              ((Message)localObject).what = 0;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
      }
      i += 1;
    }
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView != null)
    {
      if (!(paramView.getParent() instanceof View)) {
        return;
      }
      ((View)paramView.getParent()).post(new QCirclePluginUtil.4(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  public static void a(VideoPreloadHelper paramVideoPreloadHelper, List<FeedCloudMeta.StFeed> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)localIterator.next();
      if ((localStFeed.type.get() == 3) && (localStFeed != paramList.get(0))) {
        paramVideoPreloadHelper.a(localStFeed);
      }
    }
  }
  
  public static void a(String paramString, MotionEvent paramMotionEvent) {}
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return false;
      }
      float f1 = paramInt2 / paramInt1;
      float f2 = QCircleConfigHelper.a("qqflash", "qqflash_show_vertical_video_max_ratio", Integer.valueOf(30)).intValue() / 10.0F;
      float f3 = QCircleConfigHelper.a("qqflash", "qqflash_show_vertical_video_min_ratio", Integer.valueOf(15)).intValue() / 10.0F;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSize origin size shouldFullScreen():");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("|");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("|");
      localStringBuilder.append(f1);
      localStringBuilder.append("|");
      localStringBuilder.append(f2);
      localStringBuilder.append("|");
      localStringBuilder.append(f3);
      QLog.d("QCirclePluginUtil", 1, localStringBuilder.toString());
      return (f1 > f3) && (f1 < f2);
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    if (localViewGroup != null)
    {
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        localViewGroup.getChildAt(i).getContext().getPackageName();
        if ((localViewGroup.getChildAt(i).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i).getId()))) && (localViewGroup.getChildAt(i).getHeight() != 0)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean a(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    return (!b(paramStGetMainPageRsp.user)) && (paramStGetMainPageRsp.isPenguinUser.get() == 1);
  }
  
  public static boolean a(Object paramObject)
  {
    boolean bool2 = QCircleConfigHelper.aH();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    FeedCloudMeta.StFeed localStFeed = null;
    if ((paramObject instanceof FeedCloudMeta.StFeed)) {
      localStFeed = (FeedCloudMeta.StFeed)paramObject;
    } else if ((paramObject instanceof FeedBlockData)) {
      localStFeed = ((FeedBlockData)paramObject).b();
    }
    if (localStFeed == null)
    {
      QLog.w("QCirclePluginUtil", 1, "isQUIC() false? invalid reportData");
      return false;
    }
    if (localStFeed.video.isQuic.get() != 0) {
      bool1 = true;
    }
    QLog.w("QCirclePluginUtil", 1, "isQUIC() true?");
    return bool1;
  }
  
  public static boolean a(List<Integer> paramList)
  {
    return (paramList != null) && (paramList.contains(Integer.valueOf(1)));
  }
  
  public static boolean a(QQCircleFeedBase.StPolyLike paramStPolyLike, QQCircleFeedBase.StLikeBusiData paramStLikeBusiData)
  {
    paramStLikeBusiData = paramStLikeBusiData.likeIDs.get().iterator();
    while (paramStLikeBusiData.hasNext())
    {
      String str = (String)paramStLikeBusiData.next();
      if (paramStPolyLike.polyLikeID.get().equals(str)) {
        return true;
      }
    }
    return false;
  }
  
  public static int b(int paramInt)
  {
    double d = paramInt & 0xFFFFFF;
    Double.isNaN(d);
    return (int)(d * 0.6D) | 0xFF000000;
  }
  
  public static int b(boolean paramBoolean)
  {
    int j = QCircleSkinHelper.getInstance().getColor(2131167059);
    int i = j;
    if (paramBoolean) {
      i = b(j);
    }
    return i;
  }
  
  public static FeedCloudMeta.StComment b(FeedCloudMeta.StComment paramStComment)
  {
    FeedCloudMeta.StComment localStComment = new FeedCloudMeta.StComment();
    if (paramStComment == null) {
      return localStComment;
    }
    try
    {
      localStComment.mergeFrom(paramStComment.toByteArray());
      return localStComment;
    }
    catch (InvalidProtocolBufferMicroException paramStComment)
    {
      paramStComment.printStackTrace();
    }
    return localStComment;
  }
  
  public static String b(long paramLong)
  {
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd");
    if (paramLong == 0L) {
      localObject1 = new Date();
    } else {
      localObject1 = new Date(paramLong);
    }
    localObject2 = ((SimpleDateFormat)localObject2).format((Date)localObject1);
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    paramLong = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(paramLong);
    int i = localTime2.yearDay - 1;
    Object localObject1 = localObject2;
    if (localTime1.year == localTime2.year)
    {
      if (localTime2.yearDay < localTime1.yearDay) {
        return localObject2;
      }
      if (localTime2.yearDay == localTime1.yearDay) {
        return HardCodeUtil.a(2131917319);
      }
      if (localTime1.yearDay == i) {
        return HardCodeUtil.a(2131918208);
      }
      if (localTime1.yearDay + 1 == i) {
        return HardCodeUtil.a(2131887542);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localTime1.month + 1);
      ((StringBuilder)localObject1).append("-");
      ((StringBuilder)localObject1).append(localTime1.monthDay);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  public static String b(Context paramContext)
  {
    paramContext = a(paramContext);
    if ((paramContext != null) && (paramContext.getUser() != null)) {
      return paramContext.getUser().id.get();
    }
    return "";
  }
  
  public static String b(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = paramStFeed.tagInfos.get();
    paramStFeed = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FeedCloudMeta.StTagInfo localStTagInfo = (FeedCloudMeta.StTagInfo)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(paramStFeed)) {
        paramStFeed.append("|");
      }
      paramStFeed.append(localStTagInfo.tagName.get());
    }
    return paramStFeed.toString();
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString).getHost();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void b()
  {
    ((IQCircleColdBootService)QRoute.api(IQCircleColdBootService.class)).release();
    QCircleFolderCacheHelper.b();
    QCircleFolderTabInfoManager.b();
    QCircleEeveeMananger.releaseInstance();
    QCircleTaskQueue.a().c();
    QCircleOutboxTaskQueue.b().a();
    QCircleHostQzoneHelper.closeDbCacheService();
    QCircleRelationGroupManager.instance().releaseCache();
    QFSPictureReloadManager.a().b();
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return false;
      }
      float f1 = paramInt2 / paramInt1;
      float f2 = QCircleConfigHelper.a("qqflash", "qqflash_show_vertical_video_max_ratio", Integer.valueOf(30)).intValue() / 10.0F;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSize origin size shouldFullScreen():");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("|");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("|");
      localStringBuilder.append(f1);
      localStringBuilder.append("|");
      localStringBuilder.append(f2);
      QLog.d("QCirclePluginUtil", 1, localStringBuilder.toString());
      return f1 >= f2;
    }
    return false;
  }
  
  public static boolean b(FeedCloudMeta.StUser paramStUser)
  {
    return (paramStUser != null) && (HostDataTransUtils.getAccount().equals(paramStUser.id.get()));
  }
  
  public static boolean b(List<Integer> paramList)
  {
    return (paramList != null) && (paramList.contains(Integer.valueOf(3)));
  }
  
  public static long c()
  {
    return QCircleCommonUtil.getCurrentAccountLongUin();
  }
  
  public static FeedCloudMeta.StUser c(Context paramContext)
  {
    paramContext = a(paramContext);
    if ((paramContext != null) && (paramContext.getUser() != null)) {
      return paramContext.getUser();
    }
    return null;
  }
  
  public static String c(long paramLong)
  {
    Object localObject = new Time();
    ((Time)localObject).set(paramLong);
    paramLong = System.currentTimeMillis();
    new Time().set(paramLong);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(" ");
    localStringBuilder1.append(((Time)localObject).hour);
    localStringBuilder1.append(":");
    if (((Time)localObject).minute < 10)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("0");
      localStringBuilder2.append(((Time)localObject).minute);
      localObject = localStringBuilder2.toString();
    }
    else
    {
      localObject = Integer.valueOf(((Time)localObject).minute);
    }
    localStringBuilder1.append(localObject);
    return localStringBuilder1.toString();
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        return paramString;
      }
      int i = paramString.indexOf("?");
      if (i == -1) {
        return paramString;
      }
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static boolean c(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean c(FeedCloudMeta.StUser paramStUser)
  {
    boolean bool = true;
    if ((paramStUser != null) && (!b(paramStUser)))
    {
      if (paramStUser.followState.get() == 1) {
        return bool;
      }
      if (paramStUser.followState.get() == 3) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public static boolean c(List<Integer> paramList)
  {
    return (paramList != null) && (paramList.contains(Integer.valueOf(4)));
  }
  
  public static int[] c(FeedCloudMeta.StFeed paramStFeed)
  {
    int[] arrayOfInt = new int[2];
    if (paramStFeed != null)
    {
      if (paramStFeed.dittoFeed.dittoId.get() != 0)
      {
        arrayOfInt[0] = 3;
        arrayOfInt[1] = 1;
        return arrayOfInt;
      }
      if (paramStFeed.type.get() == 2)
      {
        arrayOfInt[0] = 1;
        arrayOfInt[1] = 1;
        return arrayOfInt;
      }
      if (paramStFeed.type.get() == 3)
      {
        arrayOfInt[0] = 1;
        arrayOfInt[1] = 2;
      }
    }
    return arrayOfInt;
  }
  
  public static FeedCloudMeta.StFeed d(Context paramContext)
  {
    paramContext = a(paramContext);
    if ((paramContext != null) && (paramContext.getFeed() != null)) {
      return paramContext.getFeed();
    }
    return null;
  }
  
  public static String d(long paramLong)
  {
    return a(paramLong, false);
  }
  
  public static boolean d()
  {
    return QCircleConfigHelper.a(HostDataTransUtils.isStudyMode());
  }
  
  public static boolean d(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        if (paramInt == 91) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean d(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return false;
    }
    if (paramStFeed.isRecomFd.get()) {
      return b((FeedCloudMeta.StUser)paramStFeed.recomForward.poster.get());
    }
    return b((FeedCloudMeta.StUser)paramStFeed.poster.get());
  }
  
  public static boolean d(FeedCloudMeta.StUser paramStUser)
  {
    paramStUser = a(paramStUser);
    return (paramStUser != null) && (paramStUser.certification.get() >= 1);
  }
  
  public static boolean d(String paramString)
  {
    return QCircleCommonUtil.isOwner(paramString);
  }
  
  public static int e(FeedCloudMeta.StUser paramStUser)
  {
    paramStUser = a(paramStUser);
    if (paramStUser != null) {
      return paramStUser.certification.get();
    }
    return 0;
  }
  
  public static boolean e()
  {
    return ASInject.g().getAsEngineDelegate().isOnThirdTab("qcircle-app");
  }
  
  public static boolean e(Context paramContext)
  {
    return d(b(paramContext));
  }
  
  public static boolean e(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (!TextUtils.isEmpty(paramStFeed.video.fileId.get()));
  }
  
  public static boolean e(String paramString)
  {
    return QCircleCommonUtil.isFriend(paramString);
  }
  
  public static QCircleBaseFragment f(Context paramContext)
  {
    if (((paramContext instanceof CompatPublicActivity)) && ((((CompatPublicActivity)paramContext).g() instanceof QCircleBaseFragment))) {
      return (QCircleBaseFragment)((QCircleBaseActivity)paramContext).g();
    }
    return null;
  }
  
  private static boolean f(String paramString)
  {
    if (paramString.startsWith("/storage"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNativeUrl local url return:");
      localStringBuilder.append(paramString);
      QLog.d("QCirclePluginUtil", 1, localStringBuilder.toString());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCirclePluginUtil
 * JD-Core Version:    0.7.0.1
 */