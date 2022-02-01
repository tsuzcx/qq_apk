package com.tencent.mobileqq.activity.aio.item;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.ArraySet;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIORelatedEmotionHelper;
import com.tencent.mobileqq.activity.contact.connections.TriangleView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor;
import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.doutu.DoutuConfigReporter;
import com.tencent.mobileqq.doutu.DoutuMsgUtil;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.IEmoticonHandler;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedHandlerConstant;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedCallback;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryTask;
import com.tencent.mobileqq.emoticonview.api.IEmoAddedAuthCallbackService;
import com.tencent.mobileqq.emoticonview.api.IPicEmoticonInfoService;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.magicface.drawable.PngFrameDrawable;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class MarketFaceItemBuilder
  extends BaseBubbleBuilder
  implements MediaPlayerManager.Callback
{
  static long C = 0L;
  public static int a = 1;
  public static IPicEmoticonInfo w;
  public static ChatMessage x;
  public Context A;
  public List<MarketFaceItemBuilder.Holder> B;
  IEmojiManagerService D;
  boolean E = false;
  Set<Long> F = new HashSet();
  Set<MarketFaceItemBuilder.Holder> G = new HashSet();
  Set<Long> H = new ArraySet();
  MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars I = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
  EmoticonPackageDownloadListener J = new MarketFaceItemBuilder.7(this);
  private long K;
  public int y = 320;
  public int z = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
  
  public MarketFaceItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.A = paramContext;
    this.B = new ArrayList();
    this.D = ((IEmojiManagerService)paramQQAppInterface.getRuntimeService(IEmojiManagerService.class));
    if ((this.A instanceof SplashActivity)) {
      this.E = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    IFavroamingDBManagerService localIFavroamingDBManagerService = (IFavroamingDBManagerService)paramQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localIFavroamingDBManagerService.getEmoticonDataList();
    boolean bool = true;
    int j;
    int i;
    if (localList != null)
    {
      j = 0;
      int m = 0;
      int n;
      for (i = 1; j < localList.size(); i = n)
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        int k;
        if (!TextUtils.isEmpty(localCustomEmotionData.RomaingType))
        {
          k = m;
          if ("needDel".equals(localCustomEmotionData.RomaingType)) {}
        }
        else
        {
          k = m + 1;
        }
        if ((localCustomEmotionData.isMarkFace) && (localCustomEmotionData.emoPath.equals(paramEmoticon.epId)) && (localCustomEmotionData.eId.equals(paramEmoticon.eId)))
        {
          if (localIFavroamingDBManagerService.updateDeletedEmoticon(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.15(paramContext));
            }
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
            if (paramQQAppInterface != null)
            {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
              return 0;
            }
          }
          else
          {
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.16(paramContext));
            }
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2003", 1);
          }
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= FavEmoConstant.a) {
        j = -2;
      } else {
        j = 0;
      }
    }
    else
    {
      j = 0;
      i = 1;
    }
    paramHandler = new CustomEmotionData();
    paramHandler.uin = paramQQAppInterface.getCurrentAccountUin();
    paramHandler.emoId = (i + 1);
    paramHandler.isMarkFace = true;
    paramHandler.emoPath = paramEmoticon.epId;
    paramHandler.eId = paramEmoticon.eId;
    paramHandler.checkMarketFace("addEmotionToFavorite");
    paramEmoticon = ((IEmoticonManagerService)paramQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramEmoticon.epId);
    if (paramEmoticon != null)
    {
      if (paramEmoticon.isAPNG != 2) {
        bool = false;
      }
      paramHandler.isAPNG = bool;
    }
    paramEmoticon = (IFavroamingManagerService)paramQQAppInterface.getRuntimeService(IFavroamingManagerService.class);
    if (paramEmoticon != null) {
      paramEmoticon.syncUpload(paramHandler, ((IEmoAddedAuthCallbackService)QRoute.api(IEmoAddedAuthCallbackService.class)).createEmoAddedAuthCallback(paramQQAppInterface, paramContext, paramHandler, null, 0));
    }
    paramContext = x;
    if (paramContext != null) {
      a(paramQQAppInterface, paramContext.frienduin, "ep_mall", "Clk_collect_suc", 0);
    }
    return j;
  }
  
  private SpannableString a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      i = 2131887967;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              paramString2 = "";
              paramInt = i;
            }
            else
            {
              paramString2 = HardCodeUtil.a(2131904388);
              paramInt = i;
            }
          }
          else
          {
            paramString2 = HardCodeUtil.a(2131904378);
            paramInt = i;
          }
        }
        else
        {
          paramString2 = HardCodeUtil.a(2131904381);
          paramInt = i;
        }
      }
      else
      {
        paramInt = 2131887968;
        paramString2 = HardCodeUtil.a(2131904386);
      }
      localObject = this.A.getString(paramInt, new Object[] { paramString2 });
    }
    paramString2 = new StringBuilder();
    paramString2.append((String)localObject);
    paramString2.append(paramString1);
    paramString2 = paramString2.toString();
    localObject = new SpannableString(paramString2);
    paramInt = paramString2.indexOf(paramString1);
    int i = paramString1.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-31676), paramInt, i + paramInt, 33);
    return localObject;
  }
  
  private void a(int paramInt)
  {
    this.I.a(paramInt, this.d, this.A, w, this.f, j());
    this.D.getEmojiListenerManager().addEmotionJsonDownloadListener(this.I);
    this.D.startDownloadEmosmJson(w.getEmoticon().epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
  }
  
  public static void a(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, int paramInt2, String paramString, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramEmoticon == null)
    {
      QLog.d("MarketFaceItemBuilder", 1, "can not find emoticon");
      return;
    }
    if (!a(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "context is not in the top");
      }
      return;
    }
    Handler localHandler = new Handler(Looper.getMainLooper());
    if (paramInt2 == 0)
    {
      paramInt1 %= 1000;
      if (7 == paramInt1) {
        try
        {
          paramQQAppInterface = new Bundle();
          paramQQAppInterface.putInt("forward_type", 9);
          paramQQAppInterface.putBoolean("forward_emotion_from_preview", paramBoolean);
          paramEmoticon = new Intent();
          paramEmoticon.putExtras(paramQQAppInterface);
          ForwardBaseOption.a((BaseActivity)paramContext, paramEmoticon, 21, 100500, "biz_src_jc_gif");
          return;
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
          }
          return;
        }
      }
      if (6 == paramInt1)
      {
        ThreadManager.post(new MarketFaceItemBuilder.12(paramContext, paramQQAppInterface, paramEmoticon, localHandler), 5, null, true);
        return;
      }
      if (107 == paramInt1)
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
        ((IPicEmoticonInfoService)QRoute.api(IPicEmoticonInfoService.class)).send(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      }
    }
    else
    {
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.13(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2001", 1);
        }
        paramContext = new StringBuilder();
        paramContext.append("opType: ");
        paramContext.append(paramInt1);
        paramContext.append(",result:");
        paramContext.append(paramInt2);
        QLog.i("MarketFaceItemBuilder", 1, paramContext.toString());
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.14(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
      if (6 == paramInt1 % 1000) {
        EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2002", 1);
      }
    }
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, IPicEmoticonInfo paramIPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramIPicEmoticonInfo, paramSessionInfo, paramQQProgressDialog, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, IPicEmoticonInfo paramIPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog, boolean paramBoolean)
  {
    if (paramIPicEmoticonInfo == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramIPicEmoticonInfo.getEmoticon(), 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((NetworkUtil.isNetworkAvailable(paramContext)) && (paramInt <= 1000))
    {
      ((IEmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(paramInt, Integer.valueOf(paramIPicEmoticonInfo.getEmoticon().epId).intValue(), paramIPicEmoticonInfo.getEmoticon().eId);
      return;
    }
    if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
      paramQQProgressDialog.dismiss();
    }
    a(paramInt, paramContext, paramQQAppInterface, paramIPicEmoticonInfo.getEmoticon(), -404, HardCodeUtil.a(2131904385), paramSessionInfo, paramBoolean);
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, int paramInt, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong)
  {
    paramHolder.s.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    if (paramMessageForMarketFace.mMarkFaceMessage != null) {
      a(paramHolder.a, paramInt, paramMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    }
    PicItemBuilder.h();
    long l = paramHolder.q.uniseq;
    paramHolder.y = paramHolder.q.uniseq;
    if (paramHolder.a == null)
    {
      paramHolder.s.setImageResource(2130837994);
    }
    else
    {
      Object localObject = paramHolder.s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131904387));
      localStringBuilder.append(paramHolder.a.getEmoticon().name);
      ((ImageView)localObject).setContentDescription(localStringBuilder.toString());
      if (2 == paramHolder.a.getEmoticon().jobType)
      {
        localObject = (PngFrameManager)this.d.getManager(QQManagerFactory.PNG_FRAME_DRAWABLE_MANAGER);
        boolean bool = false;
        if (paramHolder.l == paramHolder.m - 1) {
          bool = ((PngFrameManager)localObject).a(paramHolder.q.uniseq);
        }
        if (paramMessageForMarketFace.mMarkFaceMessage != null)
        {
          if ((paramMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (paramMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
          {
            paramMessageForMarketFace = new String(paramMessageForMarketFace.mMarkFaceMessage.mobileparam);
            break label271;
          }
          QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
        }
        else
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
        }
        paramMessageForMarketFace = "";
        label271:
        ((PngFrameManager)localObject).a(paramMessageForMarketFace, paramHolder, l, bool, true, new MarketFaceItemBuilder.5(this, paramChatMessage, paramHolder));
        paramHolder.f.setVisibility(8);
        paramHolder.e.setVisibility(8);
        paramHolder.g.setVisibility(8);
        paramHolder.d.setVisibility(8);
        paramHolder.H.setVisibility(8);
        paramHolder.c.setVisibility(8);
        paramHolder.t.setVisibility(8);
        d(paramHolder);
      }
      else if (4 == paramHolder.a.getEmoticon().jobType)
      {
        if (!paramChatMessage.isSend()) {
          ReportController.b(this.d, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, paramHolder.a.getEmoticon().epId, "", "", "");
        }
        a(paramChatMessage, paramHolder);
        c(paramHolder);
      }
      else
      {
        a(paramChatMessage, paramHolder);
      }
      if (((2 == paramHolder.a.getEmoticon().jobType) || (4 == paramHolder.a.getEmoticon().jobType)) && (paramHolder.g != null))
      {
        paramHolder.g.setVisibility(8);
        paramHolder.g.f();
      }
      if (this.E) {
        e(paramHolder);
      }
    }
    l = System.currentTimeMillis();
    if ((QLog.isColorLevel()) && (paramHolder.a != null) && (paramHolder.a.getEmoticon() != null))
    {
      paramMessageForMarketFace = new StringBuilder();
      paramMessageForMarketFace.append("epId = ");
      paramMessageForMarketFace.append(paramHolder.a.getEmoticon().epId);
      paramMessageForMarketFace.append(":view time = ");
      paramMessageForMarketFace.append(l - paramLong);
      QLog.d("MarketFaceItemBuilder", 1, paramMessageForMarketFace.toString());
    }
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramHolder.G.getDrawable();
    if (this.F.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramHolder.B.setVisibility(4);
      paramHolder.G.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramHolder.B.setVisibility(0);
    paramHolder.G.setVisibility(4);
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, Rect paramRect)
  {
    AIOEmotionFragment.a(this.A, paramHolder.q, this.f, paramRect);
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramURLDrawable != null)
    {
      int i = paramURLDrawable.getStatus();
      if (i != 1)
      {
        if (i != 2)
        {
          paramHolder.v.setVisibility(0);
          paramBaseChatItemLayout.setProgressVisable(true);
          return;
        }
        paramHolder.v.setVisibility(8);
        paramBaseChatItemLayout.setProgressVisable(false);
        if (AppSetting.e) {
          paramHolder.u.setContentDescription(HardCodeUtil.a(2131904382));
        }
      }
      else
      {
        if (!MagicfaceViewController.b()) {
          paramHolder.v.setVisibility(8);
        }
        if ((!EmoticonPanelUtils.a()) || (2 != paramHolder.a.getEmoticon().jobType) || (this.D.verifyMagicFacePackageIntact(paramHolder.a.getEmoticon().epId)) || (EmoticonPanelUtils.c()))
        {
          float f = this.D.getEmoticonPackageLoadingProgress(paramHolder.a.getEmoticon().epId);
          if ((f < 0.0F) || (1.0F == f))
          {
            paramHolder.v.setVisibility(8);
            paramBaseChatItemLayout.setProgressVisable(false);
          }
        }
      }
    }
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    if ((paramHolder.a != null) && (paramHolder.a.getEmoticon() != null) && (paramHolder.a.getEmoticon().jobType != 0) && (paramHolder.a.getEmoticon().jobType != 2) && (paramHolder.a.getEmoticon().jobType != 4))
    {
      paramHolder.v.setVisibility(8);
      if ("big_sound".equals(paramString))
      {
        if ((paramHolder.a.getEmoticon() != null) && (paramHolder.a.getEmoticon().isSound))
        {
          if (g(paramHolder.q))
          {
            MediaPlayerManager.a(this.d).a(false);
            return;
          }
          if (this.d.isVideoChatting())
          {
            QQToast.makeText(this.d.getApp(), 2131892896, 0).show(this.A.getResources().getDimensionPixelSize(2131299920));
            return;
          }
          MediaPlayerManager.a(this.d).a(paramHolder.q);
        }
      }
      else if ("aio_preview".equals(paramString))
      {
        paramString = paramHolder.a.getLoadingDrawable("fromAIO", true);
        if (paramString != null)
        {
          paramHolder.s.setImageDrawable(paramString);
          paramHolder.v.setVisibility(0);
          a(paramHolder, paramString);
          if (paramHolder.a.isSound()) {
            C = paramHolder.q.uniseq;
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, IEmoBatchAddedCallback paramIEmoBatchAddedCallback)
  {
    Object localObject = (IFavroamingDBManagerService)paramQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("EmoBatchAdded", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = ((IFavroamingDBManagerService)localObject).getEmoticonDataList();
    boolean bool = false;
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if ((localCustomEmotionData.isMarkFace) && (localCustomEmotionData.emoPath.equals(paramEmoticon.epId)) && (localCustomEmotionData.eId.equals(paramEmoticon.eId)))
        {
          if (((IFavroamingDBManagerService)localObject).updateDeletedEmoticon(localCustomEmotionData, i))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            EmoBatchAddedHandlerConstant.a(paramIEmoBatchAddedCallback, 4);
            return;
          }
          EmoBatchAddedHandlerConstant.a(paramIEmoBatchAddedCallback, 2);
          EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2003", 1);
          return;
        }
        i += 1;
      }
    }
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = paramIEmoBatchAddedCallback.c();
    ((CustomEmotionData)localObject).isMarkFace = true;
    ((CustomEmotionData)localObject).emoPath = paramEmoticon.epId;
    ((CustomEmotionData)localObject).eId = paramEmoticon.eId;
    ((CustomEmotionData)localObject).checkMarketFace("addEmotionToFavorite");
    paramEmoticon = ((IEmoticonManagerService)paramQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramEmoticon.epId);
    if (paramEmoticon != null)
    {
      if (paramEmoticon.isAPNG == 2) {
        bool = true;
      }
      ((CustomEmotionData)localObject).isAPNG = bool;
    }
    paramIEmoBatchAddedCallback.a((CustomEmotionData)localObject);
    paramQQAppInterface = (IFavroamingManagerService)paramQQAppInterface.getRuntimeService(IFavroamingManagerService.class);
    if (paramQQAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoBatchAdded", 1, "addBatchEmotionToFavorite fm.syncUpload");
      }
      paramQQAppInterface.syncUpload((CustomEmotionData)localObject, paramIEmoBatchAddedCallback);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, IPicEmoticonInfo paramIPicEmoticonInfo, IEmoBatchAddedCallback paramIEmoBatchAddedCallback)
  {
    if (paramIPicEmoticonInfo == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      a(paramQQAppInterface, paramIPicEmoticonInfo.getEmoticon(), paramIEmoBatchAddedCallback);
      return;
    }
    ((IEmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(6, Integer.valueOf(paramIPicEmoticonInfo.getEmoticon().epId).intValue(), paramIPicEmoticonInfo.getEmoticon().eId);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder)
  {
    a(paramChatMessage, paramHolder, "");
  }
  
  private void a(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    boolean bool;
    if ((paramHolder.a.isSound()) && (!g(paramChatMessage))) {
      bool = false;
    } else {
      bool = true;
    }
    URLDrawable localURLDrawable = paramHolder.a.getLoadingDrawable("fromAIO", bool);
    Object localObject;
    String str2;
    if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1))
    {
      String str1;
      if ((localURLDrawable.getStateTag() instanceof Bundle)) {
        str1 = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
      } else {
        str1 = "";
      }
      localObject = localURLDrawable;
      str2 = str1;
      if (!TextUtils.isEmpty(str1))
      {
        localObject = localURLDrawable;
        str2 = str1;
        if (str1.equals("aio_preview"))
        {
          localObject = paramHolder.b;
          if ((localObject != null) && (((EmoticonPackage)localObject).status == 2))
          {
            URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
            localObject = paramHolder.a.getLoadingDrawable("fromAIO", bool);
            str2 = str1;
          }
          else
          {
            localObject = localURLDrawable;
            str2 = str1;
            if ((paramString.equals("") ^ true))
            {
              URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
              localObject = paramHolder.a.getLoadingDrawable("fromAIO", bool, true, paramHolder);
              str2 = str1;
            }
          }
        }
      }
    }
    else
    {
      str2 = "";
      localObject = localURLDrawable;
    }
    b(paramHolder, (URLDrawable)localObject);
    paramHolder.f.setVisibility(8);
    paramHolder.e.setVisibility(8);
    paramHolder.g.setVisibility(8);
    c(paramChatMessage, paramHolder);
    b(paramChatMessage, paramHolder);
    if (localObject != null) {
      a(paramHolder, (URLDrawable)localObject, str2);
    }
    d(paramHolder);
  }
  
  private void a(IPicEmoticonInfo paramIPicEmoticonInfo, int paramInt, String paramString)
  {
    String str1 = "";
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        if (paramInt != 4) {
          return;
        }
        str2 = this.d.getCurrentUin();
        str3 = i();
        if (paramIPicEmoticonInfo != null) {
          str1 = paramIPicEmoticonInfo.getEmoticon().epId;
        }
        VasWebviewUtil.a(str2, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str3, str1, paramString, "1", "", "", "", 0, 0, 0, 0);
        return;
      }
      paramString = this.d;
      if (paramIPicEmoticonInfo != null) {
        str1 = paramIPicEmoticonInfo.getEmoticon().epId;
      }
      ReportController.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, str1, "", "", "");
      return;
    }
    String str2 = this.d.getCurrentUin();
    String str3 = i();
    if (paramIPicEmoticonInfo != null) {
      str1 = paramIPicEmoticonInfo.getEmoticon().epId;
    }
    VasWebviewUtil.a(str2, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str3, str1, paramString);
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    boolean bool2 = true;
    localObject = ((ActivityManager)localObject).getRunningTasks(1);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((List)localObject).size() > 0)
      {
        localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((ComponentName)localObject).getClassName();
          bool1 = paramContext.getClass().getName().equals(localObject);
        }
      }
    }
    return bool1;
  }
  
  private static void b(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, String paramString1, String paramString2)
  {
    try
    {
      DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131887648, 2131888569, new MarketFaceItemBuilder.17(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new MarketFaceItemBuilder.18()).show();
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
      }
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder)
  {
    if (!this.D.isMagicFacePackageIntact(paramHolder.a.getEmoticon().epId, Boolean.valueOf(false)))
    {
      this.D.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.J);
      EmoticonPackage localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramHolder.a.getEmoticon().name;
      localEmoticonPackage.epId = paramHolder.a.getEmoticon().epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramHolder.z == -1) {
        localEmoticonPackage.rscType = PngFrameUtil.b(paramHolder.a.getEmoticon().magicValue);
      } else {
        localEmoticonPackage.rscType = paramHolder.z;
      }
      ((IEmoticonManagerService)this.d.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramHolder.a.getEmoticon());
      paramHolder.x = false;
      ((MessageForMarketFace)paramHolder.q).needToPlay = true;
      this.B.add(paramHolder);
      paramHolder.t.setVisibility(8);
      paramHolder.v.setVisibility(0);
      this.D.pullEmoticonPackage(localEmoticonPackage, false);
      ReportController.b(this.d, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramHolder.a.getEmoticon() != null))
    {
      int i = paramHolder.a.getEmoticon().width;
      int m = 200;
      if (i == 0) {
        j = 200;
      } else {
        j = paramHolder.a.getEmoticon().width;
      }
      if (paramHolder.a.getEmoticon().height != 0) {
        m = paramHolder.a.getEmoticon().height;
      }
      int k = j;
      i = m;
      if (paramHolder.a.getEmoticon().extensionWidth != 0)
      {
        k = j;
        i = m;
        if (paramHolder.a.getEmoticon().extensionHeight != 0)
        {
          k = paramHolder.a.getEmoticon().extensionWidth;
          i = paramHolder.a.getEmoticon().extensionHeight;
        }
      }
      int j = k;
      if (k != i) {
        j = i;
      }
      k = this.z;
      int n = this.y;
      m = (j * k + (n >> 1)) / n;
      i = (i * k + (n >> 1)) / n;
      paramHolder.s.setLayoutParams(new FrameLayout.LayoutParams(m, i));
      Object localObject1 = paramHolder.w.getTag();
      if ((localObject1 instanceof Integer)) {
        i = ((Integer)localObject1).intValue();
      } else {
        i = -1;
      }
      if ((paramHolder.w.getVisibility() == 0) && (i != -1))
      {
        String str = (String)paramHolder.w.getTag(2131430109);
        Object localObject2 = (String)paramHolder.w.getTag(2131430108);
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(AIOUtils.b(12.0F, this.A.getResources()));
        localPaint.setTextAlign(Paint.Align.LEFT);
        n = (int)localPaint.measureText("...");
        float f;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131904383));
          ((StringBuilder)localObject1).append(str);
          f = localPaint.measureText(((StringBuilder)localObject1).toString());
        }
        else
        {
          f = localPaint.measureText(HardCodeUtil.a(2131904379));
        }
        int i1 = (int)f;
        j = ((String)localObject2).length();
        k = (int)localPaint.measureText((String)localObject2) + i1;
        localObject1 = "";
        while ((k > m) && (j > 0))
        {
          j -= 1;
          localObject1 = ((String)localObject2).substring(0, j);
          k = (int)localPaint.measureText((String)localObject1) + n + i1;
        }
        if (!((String)localObject1).equals(""))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("...");
          localObject1 = a(i, ((StringBuilder)localObject2).toString(), str);
          paramHolder.w.setText((CharSequence)localObject1);
        }
      }
    }
    paramHolder.s.setImageDrawable(paramURLDrawable);
    a(paramHolder, paramURLDrawable, paramHolder.j);
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable, String paramString)
  {
    String str;
    if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
      str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
    } else {
      str = "";
    }
    paramURLDrawable.restartDownload();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgOnclickListener| URLDrawable restartDownload status=");
      localStringBuilder.append(paramURLDrawable.getStatus());
      QLog.d("MarketFaceItemBuilder", 2, localStringBuilder.toString());
    }
    a(paramHolder, paramURLDrawable, str);
    paramHolder.v.setVisibility(0);
    if ((paramHolder.a != null) && (paramHolder.a.isSound()) && ("big_sound".equals(paramString))) {
      C = paramHolder.q.uniseq;
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.6(this, paramString, paramHolder), 5, null, true);
  }
  
  private void b(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((paramHolder.a.isSound()) && (paramHolder.a.isNewSoundType()) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (paramHolder.a.getWaveformArray() != null)
      {
        paramChatMessage = (RelativeLayout.LayoutParams)paramHolder.C.getLayoutParams();
        paramChatMessage.width = AIOUtils.b(39.0F, this.A.getResources());
        paramHolder.C.setAudioData(paramHolder.a.getWaveformArray(), paramChatMessage.width, paramHolder.a.getVoiceLength());
        if (Build.VERSION.SDK_INT < 19)
        {
          paramChatMessage = (RelativeLayout.LayoutParams)paramHolder.D.getLayoutParams();
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramHolder.H.getLayoutParams();
          paramChatMessage.width = AIOUtils.b(92.0F, this.A.getResources());
          localLayoutParams.width = AIOUtils.b(92.0F, this.A.getResources());
        }
      }
      int i = paramHolder.a.getWaveBackgroundColor();
      int j = paramHolder.a.getWaveForegroundColor();
      paramChatMessage = new RoundedColorDrawable(i, 1, 1, AIOUtils.b(22.0F, this.A.getResources()));
      paramHolder.D.setBackgroundDrawable(paramChatMessage);
      paramHolder.F.setDrawColor(i);
      paramHolder.F.postInvalidate();
      paramHolder.C.setProgressColor(j);
      paramHolder.B.setThemeColor(j);
    }
  }
  
  private void c(MarketFaceItemBuilder.Holder paramHolder)
  {
    if (4 == paramHolder.a.getEmoticon().jobType)
    {
      if (((MessageForMarketFace)paramHolder.q).mMarkFaceMessage == null) {
        return;
      }
      Object localObject;
      if (!this.D.isH5MagicIntact(paramHolder.a.getEmoticon().epId, true, true))
      {
        if (!EmoticonPanelUtils.a())
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = ");
            ((StringBuilder)localObject).append(paramHolder.a.getEmoticon().epId);
            QLog.d("MarketFaceItemBuilder", 2, ((StringBuilder)localObject).toString());
          }
          paramHolder.t.setVisibility(8);
          return;
        }
        if (-1.0F == this.D.getEmoticonPackageLoadingProgress(paramHolder.a.getEmoticon().epId))
        {
          this.D.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.J);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramHolder.a.getEmoticon().name;
          ((EmoticonPackage)localObject).epId = paramHolder.a.getEmoticon().epId;
          ((EmoticonPackage)localObject).jobType = 5;
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((IEmoticonManagerService)this.d.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramHolder.a.getEmoticon());
          this.B.add(paramHolder);
          paramHolder.x = ((MessageForMarketFace)paramHolder.q).needToPlay;
          paramHolder.t.setVisibility(8);
          paramHolder.v.setVisibility(0);
          ((MessageForMarketFace)paramHolder.q).needToPlay = false;
          this.D.pullEmoticonPackage((EmoticonPackage)localObject, false);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("magicFaceIcon gone,start download epId = ");
            localStringBuilder.append(paramHolder.a.getEmoticon().epId);
            QLog.d("MarketFaceItemBuilder", 2, localStringBuilder.toString());
          }
          ReportController.b(this.d, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, ((EmoticonPackage)localObject).epId, "", "", "");
        }
      }
      else
      {
        if ((this.E) && (this.D.isDPCSupportH5Magic()))
        {
          if (!this.o) {
            paramHolder.t.setVisibility(0);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("magicFaceIcon visible,h5source intacat epId = ");
            ((StringBuilder)localObject).append(paramHolder.a.getEmoticon().epId);
            QLog.d("MarketFaceItemBuilder", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          paramHolder.t.setVisibility(8);
        }
        paramHolder.t.setImageResource(2130837998);
        if ((!((MessageForMarketFace)paramHolder.q).isSend()) && (((MessageForMarketFace)paramHolder.q).needToPlay) && (this.D.canPlayH5Magic()) && (System.currentTimeMillis() - this.K > 3000L) && (((BaseActivity)this.A).getChatFragment() != null) && (((BaseActivity)this.A).getChatFragment().k() != null) && (!((BaseActivity)this.A).getChatFragment().k().at()))
        {
          this.K = System.currentTimeMillis();
          ((MessageForMarketFace)paramHolder.q).needToPlay = false;
          b(paramHolder, "1");
          ReportController.b(this.d, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.a.getEmoticon().epId, "", "", "");
        }
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((paramChatMessage.isFlowMessage) && (a(paramHolder)) && (paramHolder.a.getEmoticon().jobType == 0))
    {
      if (!(this.A instanceof MultiForwardActivity))
      {
        if (paramChatMessage.isSend())
        {
          paramHolder.e.setImageResource(2130848998);
          paramHolder.e.setVisibility(0);
          return;
        }
        paramHolder.f.setImageResource(2130848998);
        paramHolder.f.setVisibility(0);
      }
    }
    else if ((paramChatMessage.isDui) && (DuiButtonImageView.b) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramChatMessage)))
    {
      paramHolder.g.f = DoutuMsgUtil.a(paramChatMessage);
      if ((!paramChatMessage.isSend()) && ((!a(paramHolder)) || (!paramHolder.a.isSound())))
      {
        if ((a(paramHolder)) && (paramHolder.a.getEmoticon() != null) && ((2 == paramHolder.a.getEmoticon().jobType) || (4 == paramHolder.a.getEmoticon().jobType)))
        {
          paramHolder.g.setVisibility(8);
          paramHolder.g.f();
          return;
        }
        if (!paramChatMessage.hasPlayedDui) {
          paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramHolder.g);
        } else if (paramHolder.g.g()) {
          DoutuConfigReporter.a(paramChatMessage);
        }
        if (DuiButtonImageView.b)
        {
          paramHolder.g.setOnClickListener(this);
          paramHolder.g.setVisibility(0);
          return;
        }
        paramHolder.g.setOnClickListener(null);
        paramHolder.g.setVisibility(8);
        return;
      }
      paramHolder.g.setVisibility(8);
      paramHolder.g.f();
    }
  }
  
  private void d(MarketFaceItemBuilder.Holder paramHolder)
  {
    paramHolder.x = false;
    if ((2 == paramHolder.a.getEmoticon().jobType) && (((MessageForMarketFace)paramHolder.q).mMarkFaceMessage != null))
    {
      if (!MagicfaceViewController.b()) {
        return;
      }
      Object localObject1;
      if (!this.D.verifyMagicFacePackageIntact(paramHolder.a.getEmoticon().epId))
      {
        if (!EmoticonPanelUtils.a())
        {
          paramHolder.t.setVisibility(8);
          return;
        }
        if (EmoticonPanelUtils.c()) {
          return;
        }
        if ((!this.D.isMagicFacePackageIntact(paramHolder.a.getEmoticon().epId, Boolean.valueOf(false))) && (-1.0F == this.D.getEmoticonPackageLoadingProgress(paramHolder.a.getEmoticon().epId)))
        {
          this.D.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.J);
          localObject1 = new EmoticonPackage();
          ((EmoticonPackage)localObject1).name = paramHolder.a.getEmoticon().name;
          ((EmoticonPackage)localObject1).epId = paramHolder.a.getEmoticon().epId;
          ((EmoticonPackage)localObject1).jobType = 3;
          ((EmoticonPackage)localObject1).rscType = PngFrameUtil.b(paramHolder.a.getEmoticon().magicValue);
          ((EmoticonPackage)localObject1).type = 1;
          ((EmoticonPackage)localObject1).isMagicFaceDownloading = true;
          ((IEmoticonManagerService)this.d.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramHolder.a.getEmoticon());
          this.B.add(paramHolder);
          paramHolder.x = ((MessageForMarketFace)paramHolder.q).needToPlay;
          paramHolder.t.setVisibility(8);
          paramHolder.v.setVisibility(0);
          ((MessageForMarketFace)paramHolder.q).needToPlay = false;
          this.D.pullEmoticonPackage((EmoticonPackage)localObject1, false);
          ReportController.b(this.d, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramHolder.a.getEmoticon().epId, "", "", "");
        }
      }
      else
      {
        if (PngFrameUtil.b(paramHolder.a.getEmoticon().magicValue) == 1)
        {
          paramHolder.t.setVisibility(8);
        }
        else if (!this.o)
        {
          paramHolder.t.setImageResource(2130837998);
          paramHolder.t.setVisibility(0);
        }
        if (((MessageForMarketFace)paramHolder.q).needToPlay)
        {
          ((MessageForMarketFace)paramHolder.q).needToPlay = false;
          localObject1 = new Emoticon();
          ((Emoticon)localObject1).eId = paramHolder.a.getEmoticon().eId;
          ((Emoticon)localObject1).epId = paramHolder.a.getEmoticon().epId;
          ((Emoticon)localObject1).magicValue = paramHolder.a.getEmoticon().magicValue;
          ((Emoticon)localObject1).jobType = paramHolder.a.getEmoticon().jobType;
          Object localObject2 = ((BaseActivity)this.A).getChatFragment();
          if (localObject2 != null)
          {
            localObject2 = ((ChatFragment)localObject2).k();
            if ((localObject2 != null) && (MagicfaceViewController.b()))
            {
              localObject2 = (AIOEmoticonUIHelper)((BaseChatPie)localObject2).q(105);
              if (localObject2 != null) {
                ((AIOEmoticonUIHelper)localObject2).a((Emoticon)localObject1, 1, ((MessageForMarketFace)paramHolder.q).senderuin, false);
              }
            }
          }
          ReportController.b(this.d, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.a.getEmoticon().epId, "", "", "");
        }
      }
    }
  }
  
  private void e(MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((paramHolder != null) && (paramHolder.a != null) && (paramHolder.a.isNewSoundType()) && (paramHolder.q != null) && (!this.H.contains(Long.valueOf(paramHolder.q.uniseq))))
    {
      EmoticonOperateReport.reportNewSoundEvent(this.d, "0X800AB51", this.f.a, paramHolder.a.getEmoticon().epId);
      this.H.add(Long.valueOf(paramHolder.q.uniseq));
    }
  }
  
  private boolean g(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    if (paramChatMessage == null) {
      return false;
    }
    ChatMessage localChatMessage = MediaPlayerManager.a(this.d).f();
    boolean bool1;
    if (localChatMessage != paramChatMessage)
    {
      bool1 = bool2;
      if ((localChatMessage instanceof MessageForMarketFace))
      {
        bool1 = bool2;
        if (localChatMessage.frienduin != null)
        {
          bool1 = bool2;
          if (localChatMessage.frienduin.equals(paramChatMessage.frienduin))
          {
            bool1 = bool2;
            if (localChatMessage.uniseq != paramChatMessage.uniseq) {}
          }
        }
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private void h(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    Object localObject;
    if ((paramView.a != null) && (paramView.a.getEmoticon() != null) && (2 == paramView.a.getEmoticon().jobType))
    {
      if (!this.D.isMagicFacePackageIntact(paramView.a.getEmoticon().epId, Boolean.valueOf(false)))
      {
        this.D.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.J);
        localObject = new EmoticonPackage();
        ((EmoticonPackage)localObject).name = paramView.a.getEmoticon().name;
        ((EmoticonPackage)localObject).epId = paramView.a.getEmoticon().epId;
        ((EmoticonPackage)localObject).jobType = 3;
        ((EmoticonPackage)localObject).type = 1;
        ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
        paramView.x = false;
        ((MessageForMarketFace)paramView.q).needToPlay = false;
        ((IEmoticonManagerService)this.d.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramView.a.getEmoticon());
        this.B.add(paramView);
        paramView.t.setVisibility(8);
        paramView.v.setVisibility(0);
        this.D.pullEmoticonPackage((EmoticonPackage)localObject, false);
      }
      else
      {
        localObject = ((BaseActivity)this.A).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).k();
          if ((localObject != null) && (MagicfaceViewController.b()))
          {
            localObject = (AIOEmoticonUIHelper)((BaseChatPie)localObject).q(105);
            if (localObject != null) {
              ((AIOEmoticonUIHelper)localObject).a(paramView.a.getEmoticon(), 1, paramView.q.senderuin, true);
            }
          }
        }
      }
      ReportController.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, paramView.a.getEmoticon().epId, "", "", "");
    }
    if ((paramView.a != null) && (paramView.a.getEmoticon() != null) && (4 == paramView.a.getEmoticon().jobType) && (System.currentTimeMillis() - this.K > 3000L) && (this.D.canPlayH5Magic()))
    {
      this.K = System.currentTimeMillis();
      if (this.D.isH5MagicIntact(paramView.a.getEmoticon().epId, true, true))
      {
        b(paramView, "0");
      }
      else
      {
        this.D.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.J);
        localObject = new EmoticonPackage();
        ((EmoticonPackage)localObject).name = paramView.a.getEmoticon().name;
        ((EmoticonPackage)localObject).epId = paramView.a.getEmoticon().epId;
        ((EmoticonPackage)localObject).jobType = 5;
        ((EmoticonPackage)localObject).type = 1;
        ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
        paramView.x = false;
        ((MessageForMarketFace)paramView.q).needToPlay = false;
        ((IEmoticonManagerService)this.d.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramView.a.getEmoticon());
        this.B.add(paramView);
        paramView.t.setVisibility(8);
        paramView.v.setVisibility(0);
        this.D.pullEmoticonPackage((EmoticonPackage)localObject, false);
      }
      ReportController.b(this.d, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, paramView.a.getEmoticon().epId, "", "", "");
    }
  }
  
  private String i()
  {
    try
    {
      i = NetworkUtil.getSystemNetwork(this.A);
    }
    catch (Exception localException)
    {
      int i;
      label11:
      break label11;
    }
    i = 0;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return "";
          }
          return "4G";
        }
        return "3G";
      }
      return "2G";
    }
    return "wifi";
  }
  
  private void i(View paramView)
  {
    MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    if ((localHolder.a != null) && (localHolder.a.isSound()) && (localHolder.a.isNewSoundType()))
    {
      boolean bool = g(localHolder.q);
      paramView = "";
      int i;
      if (bool)
      {
        MediaPlayerManager.a(this.d).a(false);
        localObject = this.d;
        i = this.f.a;
        if (localHolder.a.getEmoticon() != null) {
          paramView = localHolder.a.getEmoticon().epId;
        }
        EmoticonOperateReport.reportNewSoundEvent((AppInterface)localObject, "0X800A934", i, paramView);
        return;
      }
      if (this.d.isVideoChatting())
      {
        QQToast.makeText(this.d.getApp(), 2131892896, 0).show(this.A.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      if ((localHolder.q instanceof MessageForMarketFace)) {
        ((MessageForMarketFace)localHolder.q).playProgress = 0.0F;
      }
      localHolder.C.setProgress(0.0F);
      if (MediaPlayerManager.a(this.d).a(localHolder.q))
      {
        localHolder.B.setPlayState(true);
        QQAppInterface localQQAppInterface = this.d;
        i = this.f.a;
        if (localHolder.a.getEmoticon() != null) {
          localObject = localHolder.a.getEmoticon().epId;
        } else {
          localObject = "";
        }
        EmoticonOperateReport.reportNewSoundEvent(localQQAppInterface, "0X800A933", i, (String)localObject);
        bool = true;
      }
      else
      {
        bool = false;
      }
      if (!bool)
      {
        localObject = this.d;
        if (localHolder.a.getEmoticon() != null) {
          paramView = localHolder.a.getEmoticon().epId;
        }
        EmoticonOperateReport.reportNewSoundEvent((AppInterface)localObject, "0X800A935", -1, paramView);
      }
      Object localObject = new HashMap();
      if (bool) {
        paramView = "0";
      } else {
        paramView = "1";
      }
      ((HashMap)localObject).put("playResult", paramView);
      ((HashMap)localObject).put("playType", "1");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject, null);
    }
  }
  
  private QQProgressDialog j()
  {
    if (((BaseActivity)this.A).getChatFragment().k() != null)
    {
      if (((BaseActivity)this.A).getChatFragment().k().af == null) {
        ((BaseActivity)this.A).getChatFragment().k().af = new QQProgressDialog(this.A);
      }
      return ((BaseActivity)this.A).getChatFragment().k().af;
    }
    return null;
  }
  
  private void j(View paramView)
  {
    MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    Object localObject = localHolder.s.getDrawable();
    if ((localObject instanceof URLDrawable))
    {
      URLDrawable localURLDrawable = (URLDrawable)localObject;
      localObject = localURLDrawable.getURL().getHost();
      if ((localURLDrawable.getTag() instanceof Bundle)) {
        localObject = ((Bundle)localURLDrawable.getTag()).getString("display_type");
      }
      int i = localURLDrawable.getStatus();
      if (i != 1)
      {
        if (i == 2) {
          b(localHolder, localURLDrawable, (String)localObject);
        }
      }
      else {
        a(localHolder, (String)localObject);
      }
      if ((localHolder.a != null) && (localHolder.a.getEmoticon() != null) && (localHolder.a.getEmoticon().jobType == 2) && (MagicfaceViewController.b())) {
        b(localHolder);
      }
      if ((localURLDrawable.getStatus() == 1) || ((localHolder.a != null) && (localHolder.a.getEmoticon() != null) && (localHolder.a.isAioPreviewExists()))) {
        a(localHolder, AnimationUtils.a(paramView));
      }
    }
    else if (((localObject instanceof PngFrameDrawable)) && (localHolder.a != null) && (localHolder.a.getEmoticon() != null) && (localHolder.a.isAioPreviewExists()))
    {
      a(localHolder, AnimationUtils.a(paramView));
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)paramViewHolder;
    this.G.add(localHolder);
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.A);
      Object localObject2 = new RelativeLayout(this.A);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131437966);
      paramView = new ImageView(this.A);
      paramView.setId(2131433475);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131430578);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131430578);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.A);
      ((FrameLayout)localObject1).setId(2131429435);
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131433475);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((FrameLayout)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramOnLongClickAndTouchListener = new MarketFaceItemBuilder.MarketFaceView(this, this.A);
      ((FrameLayout)localObject1).addView(paramOnLongClickAndTouchListener, -2, -2);
      localObject3 = new ImageView(this.A);
      Object localObject4 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject4).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new ImageView(this.A);
      ((ImageView)localObject4).setId(2131449970);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131429435);
      ((RelativeLayout.LayoutParams)localObject5).addRule(8, 2131429435);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      ((ImageView)localObject4).setOnClickListener(this);
      localObject5 = new BreathAnimationLayout(this.A);
      ((BreathAnimationLayout)localObject5).setId(2131439262);
      PttAudioPlayView localPttAudioPlayView = new PttAudioPlayView(this.A, 10);
      localPttAudioPlayView.setThemeColor(this.A.getResources().getColorStateList(2131168016).getDefaultColor());
      localPttAudioPlayView.setId(2131439264);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838205);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = AIOUtils.b(5.0F, this.A.getResources());
      ((RelativeLayout.LayoutParams)localObject6).width = AIOUtils.b(25.0F, this.A.getResources());
      ((RelativeLayout.LayoutParams)localObject6).height = AIOUtils.b(25.0F, this.A.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject6);
      localPttAudioPlayView.setOnClickListener(this);
      localObject6 = new ImageView(this.A);
      Object localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = AIOUtils.b(5.0F, this.A.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = AIOUtils.b(20.0F, this.A.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = AIOUtils.b(20.0F, this.A.getResources());
      ((ImageView)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      ((ImageView)localObject6).setImageDrawable((Drawable)this.A.getResources().getDrawable(2130839583));
      ((ImageView)localObject6).setVisibility(4);
      localObject7 = new PttAudioWaveView(this.A);
      ((PttAudioWaveView)localObject7).setShowProgressLine(false);
      ((PttAudioWaveView)localObject7).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject7).setProgressColor(this.A.getResources().getColorStateList(2131168016).getDefaultColor());
      ((PttAudioWaveView)localObject7).setId(2131439265);
      Object localObject8 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).addRule(1, 2131439264);
      ((RelativeLayout.LayoutParams)localObject8).width = AIOUtils.b(39.0F, this.A.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = AIOUtils.b(45.0F, this.A.getResources());
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = ViewUtils.dip2px(9.0F);
      ((RelativeLayout.LayoutParams)localObject8).rightMargin = ViewUtils.dip2px(12.0F);
      ((PttAudioWaveView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      ((PttAudioWaveView)localObject7).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject7).setOnClickListener(this);
      localObject8 = new SyncParentPressedRelativeLayout(this.A);
      ((RelativeLayout)localObject8).setId(2131439263);
      ((RelativeLayout)localObject8).addView((View)localObject7);
      ((RelativeLayout)localObject8).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject8).addView((View)localObject6);
      RelativeLayout localRelativeLayout = new RelativeLayout(this.A);
      TriangleView localTriangleView = new TriangleView(this.A);
      Object localObject9 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(9.0F), ViewUtils.dip2px(5.0F));
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = ViewUtils.dip2px(2.0F);
      ((RelativeLayout.LayoutParams)localObject9).addRule(14);
      ((RelativeLayout.LayoutParams)localObject9).addRule(10);
      localTriangleView.setId(2131440422);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(ViewUtils.dip2px(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject9);
      localRelativeLayout.addView(localTriangleView);
      localObject9 = new RelativeLayout.LayoutParams(-2, ViewUtils.dip2px(29.0F));
      ((RelativeLayout.LayoutParams)localObject9).addRule(3, 2131440422);
      localRelativeLayout.addView((View)localObject8, (ViewGroup.LayoutParams)localObject9);
      ((BreathAnimationLayout)localObject5).addView(localRelativeLayout);
      localObject9 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject9).addRule(14, 2131429435);
      ((RelativeLayout.LayoutParams)localObject9).addRule(3, 2131429435);
      ((RelativeLayout.LayoutParams)localObject9).bottomMargin = ViewUtils.dip2px(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject9);
      localObject9 = new ImageView(this.A);
      ((ImageView)localObject9).setId(2131433476);
      Object localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(1, 2131429435);
      ((RelativeLayout.LayoutParams)localObject10).addRule(15, 2131429435);
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((ImageView)localObject9).setOnClickListener(this);
      localObject10 = new DuiButtonImageView(this.A, this.d, DoutuMsgUtil.a(paramChatMessage));
      ((DuiButtonImageView)localObject10).setId(2131432263);
      Object localObject11 = new RelativeLayout.LayoutParams(AIOUtils.b(50.0F, this.A.getResources()), AIOUtils.b(50.0F, this.A.getResources()));
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131429435);
      ((RelativeLayout.LayoutParams)localObject11).addRule(8, 2131429435);
      ((RelativeLayout.LayoutParams)localObject11).setMargins(0, 0, 0, -AIOUtils.b(6.5F, this.A.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      localObject11 = new ImageView(this.A);
      ((ImageView)localObject11).setId(2131437876);
      Object localObject12 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131429435);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131429435);
      ((RelativeLayout.LayoutParams)localObject12).leftMargin = AIOUtils.b(10.0F, this.A.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new TextView(this.A);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject12).setTextSize(12.0F);
      ((TextView)localObject12).setTextColor(-1);
      localLayoutParams2.topMargin = AIOUtils.b(8.0F, this.A.getResources());
      ((TextView)localObject12).setGravity(17);
      localLayoutParams2.addRule(3, 2131437966);
      try
      {
        ((TextView)localObject12).setBackgroundDrawable(this.A.getResources().getDrawable(2130846198));
      }
      catch (Exception localException2)
      {
        QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
      }
      ((TextView)localObject12).setPadding(AIOUtils.b(9.0F, this.A.getResources()), AIOUtils.b(4.0F, this.A.getResources()), AIOUtils.b(9.0F, this.A.getResources()), AIOUtils.b(4.0F, this.A.getResources()));
      paramViewHolder.addView((View)localObject2, localLayoutParams1);
      paramViewHolder.addView((View)localObject12, localLayoutParams2);
      ((ImageView)localObject11).setOnClickListener(this);
      localObject2 = new ProgressBar(this.A, null, 0);
      ((ProgressBar)localObject2).setId(2131430606);
      try
      {
        ((ProgressBar)localObject2).setIndeterminateDrawable(this.A.getResources().getDrawable(2130839585));
      }
      catch (Exception localException1)
      {
        QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
      }
      int i = AIOUtils.b(16.0F, this.A.getResources());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
      localLayoutParams.gravity = 17;
      ((FrameLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localHolder.s = paramOnLongClickAndTouchListener;
      localHolder.c = ((ImageView)localObject3);
      localHolder.d = ((ImageView)localObject4);
      localHolder.e = paramView;
      localHolder.f = ((ImageView)localObject9);
      localHolder.g = ((DuiButtonImageView)localObject10);
      localHolder.t = ((ImageView)localObject11);
      localHolder.u = ((FrameLayout)localObject1);
      localHolder.v = ((ProgressBar)localObject2);
      localHolder.w = ((TextView)localObject12);
      localHolder.H = ((BreathAnimationLayout)localObject5);
      localHolder.B = localPttAudioPlayView;
      localHolder.C = ((PttAudioWaveView)localObject7);
      localHolder.D = ((RelativeLayout)localObject8);
      localHolder.E = localRelativeLayout;
      localHolder.F = localTriangleView;
      localHolder.G = ((ImageView)localObject6);
    }
    else
    {
      if ((localHolder.a != null) && (localHolder.a.isSound()) && (localHolder.d != null) && ((localHolder.d.getDrawable() instanceof AnimationDrawable))) {
        localHolder.d.setImageResource(2130849016);
      }
      if (AppSetting.e) {
        localHolder.u.setContentDescription("");
      }
      paramViewHolder = paramView;
    }
    paramView = paramBaseChatItemLayout;
    if (!g(paramChatMessage)) {
      paramView.playProgress = 0.0F;
    }
    a(localHolder, paramChatMessage.uniseq);
    localHolder.w.setVisibility(8);
    localHolder.C.setProgress(paramView.playProgress);
    if ((AppSetting.e) && (a(paramChatMessage, localHolder.j)) && (localHolder.j.ah != null)) {
      localHolder.j.ah.setContentDescription(HardCodeUtil.a(2131904384));
    }
    new QueryTask(new MarketFaceItemBuilder.3(this, localHolder), new MarketFaceItemBuilder.4(this, localHolder, paramView, paramChatMessage, l)).execute(paramView.mMarkFaceMessage);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new MarketFaceItemBuilder.Holder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    IPicEmoticonInfo localIPicEmoticonInfo = w;
    if ((localIPicEmoticonInfo != null) && (localIPicEmoticonInfo.getEmoticon() != null))
    {
      if ((paramInt != 2131431695) && (paramInt != 2131427822) && (paramInt != 2131433653) && (paramInt != 2131433419) && (paramInt != 2131438942))
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      a(paramInt, paramChatMessage);
      return;
    }
    QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    ((IEmoticonManagerService)this.d.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(w.getEmoticon().epId, new MarketFaceItemBuilder.2(this, paramInt, paramChatMessage));
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, ScreenUtil.dip2px(10.0F), 0);
  }
  
  void a(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable)
  {
    a(paramHolder, paramURLDrawable, "");
  }
  
  void a(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable, String paramString)
  {
    paramHolder.d.setVisibility(8);
    paramHolder.H.setVisibility(8);
    paramHolder.c.setVisibility(8);
    paramHolder.t.setVisibility(8);
    paramHolder.A = false;
    int i = paramURLDrawable.getStatus();
    if (paramURLDrawable.getHeader("2g_use_gif") != null) {
      i = 1;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
        str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
      }
    }
    if ("aio_preview".equals(str))
    {
      if (paramHolder.a.isSound())
      {
        if (paramHolder.a.isNewSoundType())
        {
          paramHolder.H.setVisibility(0);
          return;
        }
        paramHolder.d.setImageResource(2130849016);
        paramHolder.d.setVisibility(0);
        return;
      }
      if ((i == 1) && (paramHolder.a.getImageType() == 3))
      {
        paramHolder.c.setImageResource(2130837995);
        paramHolder.c.setVisibility(0);
        paramHolder.A = true;
      }
    }
    else if ("big_sound".equals(str))
    {
      if (g(paramHolder.q))
      {
        if (paramHolder.a.isNewSoundType())
        {
          paramHolder.H.setVisibility(0);
          paramHolder.B.setPlayState(true);
          return;
        }
        paramHolder.d.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.A.getResources().getDrawable(2130772400);
        paramHolder.d.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramHolder.a.isNewSoundType())
      {
        paramHolder.H.setVisibility(0);
        paramHolder.B.setPlayState(false);
        return;
      }
      paramHolder.d.setImageResource(2130849016);
      paramHolder.d.setVisibility(0);
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt)
  {
    QQProgressDialog localQQProgressDialog = j();
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.a(this.A.getString(2131888894));
      localQQProgressDialog.show();
    }
    a(this.d, x.frienduin, "ep_mall", "Clk_collect", 0);
    Object localObject = w;
    if ((localObject != null) && (((IPicEmoticonInfo)localObject).getEmoticon() != null)) {
      EmoticonOperateReport.reportFavAddEmotionEvent(this.d, 1, null, w.getEmoticon().eId);
    }
    QQAppInterface localQQAppInterface = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localObject = "";
    localStringBuilder.append("");
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", paramString, localStringBuilder.toString(), "");
    paramString = w;
    if ((paramString != null) && (paramString.isNewSoundType()))
    {
      localQQAppInterface = this.d;
      paramInt = this.f.a;
      paramString = (String)localObject;
      if (w.getEmoticon() != null) {
        paramString = w.getEmoticon().epId;
      }
      EmoticonOperateReport.reportNewSoundEvent(localQQAppInterface, "0X800A939", paramInt, paramString);
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.name != null) && ((paramEmoticonPackage.mobileFeetype != 0) || (paramEmoticonPackage.downloadCount != 0)))
    {
      paramInt = this.d.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ((i - paramInt <= 86400) && (i >= paramInt))
      {
        a(6, this.A, this.d, paramEmoticonPackage, w, this.f, localQQProgressDialog);
        return;
      }
      a(6);
      return;
    }
    a(6);
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt1, int paramInt2)
  {
    QQProgressDialog localQQProgressDialog = j();
    if (paramInt2 == 2131433653)
    {
      QQAppInterface localQQAppInterface = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("");
      ReportController.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", paramString, localStringBuilder.toString(), "");
      if ((2 == w.getEmoticon().jobType) && (!this.D.getMagicFaceSendAccessControl()))
      {
        ChatActivityUtils.a(this.A, 2131886573, 0);
        return;
      }
      a = 1;
      a(this.d, x.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
      paramInt1 = 7;
      paramString = this.A.getString(2131888897);
    }
    else
    {
      ReportController.b(this.d, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
      if ((this.f.a == 1) && (((TroopGagMgr)this.d.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.f.b, true).b))
      {
        ChatActivityUtils.a(this.A, 2131895180, 0);
        return;
      }
      paramInt1 = 107;
      paramString = this.A.getString(2131888896);
      ReportController.b(this.d, "CliOper", "", this.d.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", w.getEmoticon().epId, "", "");
    }
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.a(paramString);
      localQQProgressDialog.show();
    }
    if (paramEmoticonPackage == null)
    {
      a(paramInt1);
      return;
    }
    a(paramInt1, this.A, this.d, paramEmoticonPackage, w, this.f, localQQProgressDialog);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, IPicEmoticonInfo paramIPicEmoticonInfo)
  {
    if ((paramMessageForMarketFace != null) && (paramIPicEmoticonInfo != null) && (paramIPicEmoticonInfo.getEmoticon() != null))
    {
      if (paramIPicEmoticonInfo.getEmoticon().epId == null) {
        return;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.A, null);
      localActionSheet.setMainTitle(this.A.getString(2131888892));
      localActionSheet.addButton(this.A.getResources().getString(2131888891), 1);
      localActionSheet.addButton(this.A.getResources().getString(2131888893), 1);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new MarketFaceItemBuilder.11(this, paramIPicEmoticonInfo, localActionSheet, paramMessageForMarketFace));
      localActionSheet.show();
    }
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu)
  {
    if (x != null)
    {
      if (w.getEmoticon() == null) {
        return;
      }
      int i;
      if (w.getEmoticon().jobType == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (EmoticonPanelUtils.d(this.f.a)))
      {
        AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean localRelatedEmotionConfigBean = AIORelatedEmotionConfProcessor.a();
        if ((localRelatedEmotionConfigBean != null) && (localRelatedEmotionConfigBean.a()))
        {
          paramQQCustomMenu.a(2131438942, this.A.getString(2131915659), 2130839074);
          ReportController.b(this.d, "dc00898", "", this.f.b, "0X800B114", "0X800B114", EmoticonPanelUtils.e(this.f.a), 0, "", "", "", "");
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
      if ((paramXListView != null) && (paramXListView.a != null) && (paramXListView.a.isSound()) && (paramXListView.a.isNewSoundType()) && (g(paramChatMessage)))
      {
        paramView = new StringBuilder();
        paramView.append("AudioPlayer onPlayProgress progress_ratio = ");
        paramView.append(paramFloat);
        QLog.i("MarketFaceItemBuilder", 2, paramView.toString());
        paramXListView.C.setProgress(paramFloat);
        if ((paramChatMessage instanceof MessageForMarketFace)) {
          ((MessageForMarketFace)paramChatMessage).playProgress = paramFloat;
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
      if (paramXListView.a.isNewSoundType())
      {
        paramXListView.C.setProgress(0.0F);
        if (paramXListView.B != null) {
          paramXListView.B.setPlayState(false);
        }
      }
      else
      {
        paramXListView.d.setImageResource(2130849016);
      }
      paramView = paramXListView.a.getLoadingDrawable("fromAIO", false);
      paramXListView.s.setImageDrawable(paramView);
    }
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof MarketFaceItemBuilder.Holder;
  }
  
  public boolean a(MarketFaceItemBuilder.Holder paramHolder)
  {
    return paramHolder.a != null;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    if ((paramXListView != null) && (paramXListView.a != null))
    {
      if (paramXListView.a.getEmoticon() == null) {
        return false;
      }
      if (paramXListView.a.isSound())
      {
        paramView = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", paramXListView.a.getEmoticon().epId).replace("[eId]", paramXListView.a.getEmoticon().eId);
        if (!FileUtils.fileExistsAndNotEmpty(paramView))
        {
          if (this.F.contains(Long.valueOf(paramChatMessage.uniseq))) {
            return false;
          }
          this.F.add(Long.valueOf(paramChatMessage.uniseq));
          a(paramXListView, paramChatMessage.uniseq);
          ThreadManager.getFileThreadHandler().post(new MarketFaceItemBuilder.8(this, paramXListView, paramChatMessage));
          return false;
        }
        paramAudioPlayerBase.a(4);
        if (paramAudioPlayerBase.a(paramView))
        {
          paramView = paramXListView.a.getLoadingDrawable("fromAIO", true);
          paramXListView.s.setImageDrawable(paramView);
          ((IPicEmoticonInfoService)QRoute.api(IPicEmoticonInfoService.class)).startSoundDrawablePlay(paramView);
          if (paramXListView.a.isNewSoundType())
          {
            if (paramXListView.B != null)
            {
              paramXListView.B.setPlayState(true);
              return true;
            }
          }
          else
          {
            paramView = (AnimationDrawable)this.A.getResources().getDrawable(2130772400);
            paramXListView.d.setImageDrawable(paramView);
            paramView.start();
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    x = paramView.q;
    Object localObject = x;
    if ((localObject instanceof MessageForMarketFace))
    {
      localObject = (MessageForMarketFace)localObject;
      if ((((MessageForMarketFace)localObject).mMarkFaceMessage != null) && (((MessageForMarketFace)localObject).mMarkFaceMessage.stickerInfo != null))
      {
        i = 1;
        break label69;
      }
    }
    int i = 0;
    label69:
    if (i == 0)
    {
      if (paramView.a.getEmoticon().jobType != 1)
      {
        w = paramView.a;
        if (AIOUtils.a(1) == 1) {
          localQQCustomMenu.a(2131427822, this.A.getString(2131890796), 2130839064);
        }
        a(localQQCustomMenu);
        localQQCustomMenu.a(2131433653, this.A.getString(2131889668), 2130839066);
        a(localQQCustomMenu, this.A, 2131444634, x, null);
        if ((paramView.a.getEmoticon().jobType != 2) && (paramView.a.getEmoticon().jobType != 4)) {
          localQQCustomMenu.a(2131433419, this.A.getString(2131890803), 2130839042);
        }
        a(this.d, x.frienduin, "ep_mall", "Ap_show_forward", 0);
      }
      if ((paramView.q.extraflag != 32768) && (!this.d.getMsgCache().f(paramView.q))) {
        a(localQQCustomMenu, this.A, 2131438943, paramView.q, new Bundle());
      }
      a(localQQCustomMenu, this.A, 2131431695, paramView.q, new Bundle());
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("isSearch", false);
      super.a(localQQCustomMenu, this.A, 2131449133, x, (Bundle)localObject);
      if (paramView.a.getEmoticon().jobType != 1) {
        a(localQQCustomMenu, this.A, 2131444651, x, null);
      }
      super.a(localQQCustomMenu, this.A, 2131439015, null, null);
      super.a(localQQCustomMenu, this.A, 2131428089, null, null);
    }
    else
    {
      w = paramView.a;
      ChatActivityFacade.a(localQQCustomMenu, this.A, this.f.a);
    }
    return localQQCustomMenu.d();
  }
  
  public void b()
  {
    Object localObject = ((IEmojiManagerService)this.d.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager();
    ((IEmojiListenerManager)localObject).removeEmoticonPackageDownloadListener(this.J);
    ((IEmojiListenerManager)localObject).removeEmotionJsonDownloadListener(this.I);
    localObject = this.G.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((MarketFaceItemBuilder.Holder)((Iterator)localObject).next()).a();
    }
    this.G.clear();
    this.F.clear();
    this.G = null;
  }
  
  protected void b(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    if (paramView.q.isSendFromLocal())
    {
      String str1 = this.A.getString(2131886574);
      String str2 = this.A.getString(2131886575);
      if ((paramView.q.sendFailCode == 41) && (paramView.a != null) && (paramView.a.getEmoticon() != null))
      {
        a((MessageForMarketFace)paramView.q, paramView.a);
        return;
      }
      DialogUtil.a(this.A, 230, str1, str2, new MarketFaceItemBuilder.9(this, paramView), new MarketFaceItemBuilder.10(this)).show();
      return;
    }
    paramView = paramView.s.getDrawable();
    if ((paramView instanceof URLDrawable)) {
      ((URLDrawable)paramView).restartDownload();
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (MessageRecordInfo.b(paramChatMessage.issend)) {
        localStringBuilder.append("发出表情");
      } else {
        localStringBuilder.append("发来表情");
      }
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = (IPicEmoticonInfo)((IEmoticonManagerService)this.d.getRuntimeService(IEmoticonManagerService.class)).syncGetEmoticonInfo(paramChatMessage.mMarkFaceMessage);
        if (paramChatMessage != null)
        {
          paramChatMessage = paramChatMessage.getEmoticon();
          if ((paramChatMessage != null) && (paramChatMessage.name != null)) {
            localStringBuilder.append(paramChatMessage.name);
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void e(View paramView)
  {
    AIOUtils.q = true;
    if (super.c()) {
      return;
    }
    if (paramView.getId() == 2131429435)
    {
      j(paramView);
      return;
    }
    if (paramView.getId() == 2131449970) {
      g(paramView);
    } else if ((paramView.getId() != 2131439264) && (paramView.getId() != 2131439265))
    {
      if ((paramView.getId() != 2131433476) && (paramView.getId() != 2131433475))
      {
        if (paramView.getId() == 2131432263) {
          h();
        } else if (paramView.getId() == 2131437876) {
          h(paramView);
        }
      }
      else {
        f(paramView);
      }
    }
    else {
      i(paramView);
    }
    super.onClick(paramView);
  }
  
  protected void f(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    QQProgressDialog localQQProgressDialog = j();
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.a(this.A.getString(2131888896));
      localQQProgressDialog.show();
    }
    ((IEmoticonManagerService)this.d.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(paramView.a.getEmoticon().epId, new MarketFaceItemBuilder.1(this, paramView, localQQProgressDialog));
  }
  
  protected void f(ChatMessage paramChatMessage)
  {
    Object localObject = ((BaseActivity)this.A).getChatFragment();
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).k();
      if (localObject != null)
      {
        ((AIORelatedEmotionHelper)((BaseChatPie)localObject).q(72)).a(paramChatMessage, w.getLoadingDrawable("fromAIO", false));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "[Related_Emotion] curPie is null.");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MarketFaceItemBuilder", 2, "[Related_Emotion] chatFragment is null.");
    }
  }
  
  protected void g(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    if ((paramView.a != null) && (paramView.a.isSound()))
    {
      if (g(paramView.q))
      {
        MediaPlayerManager.a(this.d).a(false);
        return;
      }
      if (this.d.isVideoChatting())
      {
        QQToast.makeText(this.d.getApp(), 2131892896, 0).show(this.A.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      MediaPlayerManager.a(this.d).a(paramView.q);
    }
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    Object localObject = ((BaseActivity)this.A).getChatFragment();
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).k();
      if (localObject != null)
      {
        ((BaseChatPie)localObject).j().obtainMessage(79, null).sendToTarget();
        DoutuConfigReporter.b();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "[Doutu] curPie is null.");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MarketFaceItemBuilder", 2, "[Doutu] chatFragment is null.");
    }
  }
  
  public void onClick(View paramView)
  {
    e(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder
 * JD-Core Version:    0.7.0.1
 */