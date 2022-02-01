package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.MiniAioShieldItemTouchListener;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.ResultListener;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ShortVideoRealItemBuilder
  extends QIMTailItemBubbleBuilder
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener, Callback, ContextMenuBuilder2, ShortVideoConstants
{
  protected static int A;
  protected static int B;
  protected static int C;
  protected static int D;
  protected static int E;
  private static boolean F;
  private static boolean G;
  private static Map<Long, MessageForShortVideo> H;
  private static HashMap<String, String> I;
  private static long M = 0L;
  public static boolean a;
  public static int w;
  public static int x;
  protected static CopyOnWriteArraySet<CropBubbleVideoView> y;
  protected static ColorDrawable z;
  private Handler J = new Handler(Looper.getMainLooper());
  private ListView K;
  private MessageForShortVideo L;
  private ResultListener N = new ShortVideoRealItemBuilder.8(this);
  
  static
  {
    URLDrawableHelper.initVideoAIOSizeByDpc();
    a = true;
    w = 960;
    x = 720;
    F = false;
    G = false;
    H = new ConcurrentHashMap();
    I = new HashMap();
    y = new CopyOnWriteArraySet();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    C = BaseChatItemLayout.f;
    C = Math.min(AIOUtils.b(320.0F, localResources), C);
    D = AIOUtils.b(100.0F, localResources);
    E = AIOUtils.b(100.0F, localResources);
    A = AIOUtils.b(CodecParam.FINAL_DST_VIDEO_WIDTH, localResources);
    B = AIOUtils.b(CodecParam.FINAL_DST_VIDEO_HEIGHT, localResources);
    z = new EmptyDrawable(-10065297, A, B);
  }
  
  public ShortVideoRealItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.K = paramAIOAnimationConatiner.getListView();
    }
    ShortVideoUtils.loadShortVideoSo(paramQQAppInterface);
    ShortVideoUtils.ShortVideoPlayConfig.initConfig();
    n();
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(ShortVideoRealItemBuilder.Holder paramHolder, View paramView)
  {
    if (c(paramHolder))
    {
      if (paramHolder.e == null)
      {
        paramHolder.e = new ImageView(this.e);
        paramHolder.e.setImageResource(2130838287);
        paramHolder.e.setId(2131430598);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.b(16.0F, this.e.getResources());
        localLayoutParams.addRule(8, 2131430578);
        localLayoutParams.addRule(0, 2131430578);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramHolder.e, localLayoutParams);
        }
      }
      a(paramHolder, true, this);
      return;
    }
    a(paramHolder, false, null);
  }
  
  private void a(ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.md5 == null)
    {
      QQToast.makeText(this.e, 2131916607, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    FlowCameraMqqAction.a("", "0X8006A1C");
    StoryReportor.a("story_grp", "aio_msg", 0, 0, new String[] { "", "", "", "" });
    String str = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.fileExistsAndNotEmpty(SVUtils.a(paramMessageForShortVideo, "mp4")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "onClick, video file not exist");
      }
      if (paramMessageForShortVideo.videoFileStatus == 5002)
      {
        b(paramMessageForShortVideo, paramHolder, 2131915835);
        QQToast.makeText(this.e, 2131916640, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      }
      else
      {
        a(paramMessageForShortVideo, false);
        a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, false);
      }
      if (!paramMessageForShortVideo.isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(this.d, 2001, this.f.a, this.f.b, 1003);
      }
    }
    else if (FileUtils.fileExistsAndNotEmpty(str))
    {
      ReportController.b(this.d, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
      if (TVK_SDKMgr.isInstalled(this.e))
      {
        a(this.d, this.e, paramMessageForShortVideo, paramHolder.a, this.f, paramBoolean, false, true, true, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "onClick, sdk is not installed");
      }
      QQToast.makeText(this.e, this.e.getResources().getString(2131895511), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299920));
    }
  }
  
  private void a(ShortVideoRealItemBuilder.Holder paramHolder, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean)
    {
      if (paramHolder.e != null)
      {
        paramHolder.e.setVisibility(0);
        paramHolder.e.setOnClickListener(paramOnClickListener);
      }
    }
    else if (paramHolder.e != null)
    {
      paramHolder.e.setVisibility(8);
      paramHolder.e.setOnClickListener(null);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageForReplyText paramMessageForReplyText)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007429", "0X8007429", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "enterRichMediaPreview");
    }
    if (MediaPlayerManager.a(paramQQAppInterface).g()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    paramView = AnimationUtils.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.G)) {
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((BaseActivity)paramContext).getChatFragment().k().aR());
    }
    if (paramSessionInfo.a == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.b);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.c);
    }
    if ((paramSessionInfo.a != 1) && (paramSessionInfo.a != 3000)) {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    } else {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    if (paramMessageForReplyText != null) {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    } else {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
    }
    localBundle.putLong("click_video_bubble_time", System.currentTimeMillis());
    paramView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramView.hasNext())
    {
      paramMessageForReplyText = (ActivityManager.RunningAppProcessInfo)paramView.next();
      if (paramMessageForReplyText.processName.endsWith("mobileqq")) {
        localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", paramMessageForReplyText.pid);
      }
    }
    paramMessageForReplyText = paramMessageForShortVideo.selfuin;
    paramView = paramMessageForReplyText;
    if (paramMessageForShortVideo.isMultiMsg) {}
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramView = paramMessageForReplyText;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramView = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        int i;
        paramView = paramMessageForReplyText;
      }
    }
    localBundle.putInt("forward_source_uin_type", paramSessionInfo.a);
    localBundle.putString("uin", paramSessionInfo.b);
    if ((paramContext instanceof SplashActivity))
    {
      i = 1;
    }
    else
    {
      if ((paramContext instanceof ChatHistoryActivity)) {}
      while (((paramContext instanceof PublicFragmentActivity)) && ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)))
      {
        i = 2;
        break;
      }
      i = -1;
    }
    localBundle.putBoolean("muate_play", paramBoolean1);
    localBundle.putBoolean("is_one_item", paramBoolean2);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean3);
    localBundle.putBoolean(PeakUtils.b, paramBoolean4);
    if ((paramMessageForShortVideo.istroop == 0) && (com.tencent.mobileqq.util.Utils.c(paramMessageForShortVideo.senderuin)) && (!TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"))))
    {
      localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
      localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), 13007, i);
    }
    else
    {
      localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), -1, i);
    }
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.a, paramSessionInfo.b, 1001);
    }
    ShortVideoUtils.reportVideoPlay(paramQQAppInterface, "0X8008E53", paramSessionInfo, paramMessageForShortVideo, paramContext);
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(this.d, 2001, this.f.a, this.f.b, 1002);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131911460));
    localStringBuilder.append(paramString2);
    a(paramMessageForShortVideo, localStringBuilder.toString());
    a(paramHolder.a, paramString2, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((TroopStoryUtil.a(paramHolder.q.istroop, paramHolder.q)) && (!AIOSingleReporter.a().a(paramHolder.q, "aio_msg|play_msg_video")))
    {
      AIOSingleReporter.a().b(paramHolder.q, "aio_msg|play_msg_video");
      StoryReportor.a("aio_msg", "play_msg_video", 0, 0, new String[] { "", "", "", TroopStoryUtil.a((MessageForShortVideo)paramHolder.q) });
    }
    if (!FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      b(paramMessageForShortVideo);
      a(paramMessageForShortVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = d(paramMessageForShortVideo);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      G = true;
      this.L = paramMessageForShortVideo;
      EncodeVideoTask.ThumbInfo localThumbInfo = new EncodeVideoTask.ThumbInfo(paramMessageForShortVideo.mThumbFilePath, paramMessageForShortVideo.thumbMD5, null, paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      localObject = new EncodeVideoTask(this.d, this.e, (String)localObject, paramMessageForShortVideo.mediacodecEncode, localThumbInfo, paramMessageForShortVideo);
      EncodeVideoTask.a.put(Long.valueOf(paramMessageForShortVideo.uniseq), localObject);
      ((EncodeVideoTask)localObject).a(this.N);
      ((EncodeVideoTask)localObject).a(false);
      com.tencent.image.Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
      ThreadManager.getUIHandler().post(new ShortVideoRealItemBuilder.10(this, paramBoolean1, paramHolder, paramMessageForShortVideo, paramBoolean2));
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShortVideoRealItemBuilder");
      localStringBuilder.append("[");
      localStringBuilder.append(paramMessageRecord.uniseq);
      localStringBuilder.append("]");
      paramMessageRecord = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageRecord);
      localStringBuilder.append(":content ");
      localStringBuilder.append(paramString);
      QLog.i("ShortVideoRealItemBuilder", 2, localStringBuilder.toString());
    }
  }
  
  private void a(boolean paramBoolean, CropBubbleVideoView paramCropBubbleVideoView, MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramHolder, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((!FileUtils.fileExistsAndNotEmpty(paramString2)) && ((!paramMessageForShortVideo.isSend()) || (paramMessageForShortVideo.md5 != null) || (paramMessageForShortVideo.videoFileStatus != 1004)))
    {
      if (paramMessageForShortVideo.videoFileStatus == 2005) {
        c(paramMessageForShortVideo, paramHolder);
      }
      if (paramMessageForShortVideo.videoFileStatus == 5002)
      {
        a(paramMessageForShortVideo, HardCodeUtil.a(2131911451));
        b(paramMessageForShortVideo, paramHolder, 2131915835);
        return;
      }
      if (this.d.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
      {
        a(paramMessageForShortVideo, true);
        return;
      }
      if ((paramMessageForShortVideo.videoFileStatus != 2001) && (paramMessageForShortVideo.videoFileStatus != 2002) && (paramMessageForShortVideo.videoFileStatus != 2000))
      {
        c(paramMessageForShortVideo, paramHolder);
        return;
      }
      a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, false);
      return;
    }
    if ((paramMessageForShortVideo.videoFileStatus != 1005) && (paramMessageForShortVideo.extraflag != 32768) && (paramMessageForShortVideo.videoFileStatus != 1004)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    paramCropBubbleVideoView = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    paramInt2 = paramInt1;
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      paramInt2 = paramInt1;
      if (paramMessageForShortVideo.videoFileProgress < 100)
      {
        paramInt2 = paramInt1;
        if (paramMessageForShortVideo.videoFileStatus != 1003)
        {
          paramInt2 = paramInt1;
          if (paramCropBubbleVideoView == null) {
            paramInt2 = 1;
          }
        }
      }
    }
    if (paramInt2 != 0)
    {
      b(paramMessageForShortVideo, paramHolder, 2131915840);
      return;
    }
    if ((ShortVideoUtils.isVideoSoLibLoaded()) && (paramBoolean))
    {
      if (paramMessageForShortVideo.videoFileStatus != 1003)
      {
        if (ShortVideoUtils.getDisplayProgress(paramMessageForShortVideo.videoFileProgress, 10) <= 60) {
          paramInt1 = 1;
        } else {
          paramInt1 = 0;
        }
        if ((paramMessageForShortVideo.busiType == 1) && (paramInt1 != 0))
        {
          if (paramMessageForShortVideo.progress > 60) {
            paramMessageForShortVideo.progress = 60;
          }
          a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, paramMessageForShortVideo.progress);
          return;
        }
        a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, false);
      }
    }
    else {
      c(paramMessageForShortVideo, paramHolder);
    }
  }
  
  private boolean a(ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, CropBubbleVideoView paramCropBubbleVideoView)
  {
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramMessageForShortVideo.videoFileStatus != 1005) && (paramMessageForShortVideo.extraflag != 32768) && (paramMessageForShortVideo.videoFileStatus != 1004))
    {
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        String str2 = paramMessageForShortVideo.mThumbFilePath;
        String str1 = str2;
        if (!FileUtils.fileExistsAndNotEmpty(str2))
        {
          if (TextUtils.isEmpty(paramMessageForShortVideo.thumbMD5))
          {
            paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
            paramCropBubbleVideoView.showCover(URLDrawableHelper.getFailedDrawable());
            a(paramHolder);
            a(paramMessageForShortVideo, "getBubbleView():You must get thumb before send video.");
            return true;
          }
          str1 = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        }
        if (a(paramCropBubbleVideoView, str1))
        {
          a(paramHolder, str1, paramMessageForShortVideo, paramInt1, paramInt2);
          b(paramHolder, paramMessageForShortVideo);
          paramHolder = this.L;
          if ((paramHolder != null) && ((paramHolder.uniseq == paramMessageForShortVideo.uniseq) || (H.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq))))) {
            paramInt1 = 0;
          } else {
            paramInt1 = 1;
          }
          if ((!paramMessageForShortVideo.mPreUpload) && (TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramInt1 != 0) && (paramMessageForShortVideo.busiType == 1))
          {
            if (!G)
            {
              a(paramMessageForShortVideo, null, false, true);
              return true;
            }
            if (!H.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq)))
            {
              H.put(Long.valueOf(paramMessageForShortVideo.uniseq), paramMessageForShortVideo);
              if (QLog.isColorLevel())
              {
                paramHolder = new StringBuilder();
                paramHolder.append("messageMap size:");
                paramHolder.append(H.size());
                paramHolder.append(", [");
                paramHolder.append(paramMessageForShortVideo.uniseq);
                paramHolder.append("] added, mEncoding:");
                paramHolder.append(G);
                QLog.i("ShortVideoRealItemBuilder", 2, paramHolder.toString());
              }
            }
          }
        }
      }
      return true;
    }
    return false;
  }
  
  private void b(long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doEncodeNext, curMsg:");
      localObject = this.L;
      if (localObject != null) {
        localObject = Long.valueOf(((MessageForShortVideo)localObject).uniseq);
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(", seq:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", contains:");
      localStringBuilder.append(EncodeVideoTask.a.containsKey(Long.valueOf(paramLong)));
      QLog.i("ShortVideoRealItemBuilder", 2, localStringBuilder.toString());
    }
    EncodeVideoTask.a.remove(Long.valueOf(paramLong));
    Object localObject = this.L;
    if (localObject != null) {
      H.remove(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
    }
    localObject = this.L;
    if ((localObject != null) && (((MessageForShortVideo)localObject).progressTask != null)) {
      this.L.progressTask = null;
    }
    G = false;
    this.L = null;
    if (H.size() != 0)
    {
      localObject = H.entrySet().iterator();
      if (((Iterator)localObject).hasNext()) {
        localObject = (MessageForShortVideo)((Map.Entry)((Iterator)localObject).next()).getValue();
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        ThreadManager.postImmediately(new ShortVideoRealItemBuilder.9(this, (MessageForShortVideo)localObject), null, true);
        H.remove(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("messageMap size:");
          localStringBuilder.append(H.size());
          localStringBuilder.append(", [");
          localStringBuilder.append(((MessageForShortVideo)localObject).uniseq);
          localStringBuilder.append("] start upload!");
          QLog.i("ShortVideoRealItemBuilder", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  private void b(ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    paramHolder = new WeakReference(paramHolder);
    if (paramMessageForShortVideo.busiType == 1)
    {
      if (paramMessageForShortVideo.progressTask == null)
      {
        paramMessageForShortVideo.progressTask = new ShortVideoRealItemBuilder.1(this, paramMessageForShortVideo, paramHolder);
        this.J.removeCallbacks(paramMessageForShortVideo.progressTask);
        this.J.post(paramMessageForShortVideo.progressTask);
      }
    }
    else
    {
      if (paramMessageForShortVideo.mShowProgressTask == null) {
        paramMessageForShortVideo.mShowProgressTask = new ShortVideoRealItemBuilder.2(this, paramHolder, paramMessageForShortVideo);
      }
      this.J.removeCallbacks(paramMessageForShortVideo.mShowProgressTask);
      this.J.post(paramMessageForShortVideo.mShowProgressTask);
    }
  }
  
  private void b(ShortVideoRealItemBuilder.Holder paramHolder, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramHolder != null) && (paramHolder.j != null))
    {
      if (paramBoolean) {
        a(paramHolder, false, null);
      }
      paramHolder.j.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private boolean c(ShortVideoRealItemBuilder.Holder paramHolder)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramHolder.q instanceof MessageForShortVideo)) {
      localMessageForShortVideo = (MessageForShortVideo)paramHolder.q;
    } else {
      localMessageForShortVideo = null;
    }
    boolean bool2 = false;
    if (localMessageForShortVideo == null) {
      return false;
    }
    int i;
    if ((localMessageForShortVideo.videoFileStatus != 998) && (localMessageForShortVideo.videoFileStatus != 1002) && (localMessageForShortVideo.videoFileStatus != 1001)) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if ((!localMessageForShortVideo.isMultiMsg) && (localMessageForShortVideo.uiOperatorFlag != 2) && (localMessageForShortVideo.busiType == 1) && (localMessageForShortVideo.isSendFromLocal()) && (!paramHolder.j.b())) {
      j = 1;
    } else {
      j = 0;
    }
    if (QLog.isColorLevel())
    {
      paramHolder = new StringBuilder();
      paramHolder.append("shortVideoCancel needShowPauseIcon seq:");
      paramHolder.append(localMessageForShortVideo.uniseq);
      paramHolder.append(", videostatus:");
      paramHolder.append(localMessageForShortVideo.videoFileStatus);
      paramHolder.append(", iconshow:");
      if ((i != 0) && (j != 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramHolder.append(bool1);
      QLog.i("ShortVideoRealItemBuilder", 2, paramHolder.toString());
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void e(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.progressTask != null))
    {
      this.J.removeCallbacks(paramMessageForShortVideo.progressTask);
      paramMessageForShortVideo.progressTask = null;
    }
  }
  
  private boolean f(MessageForShortVideo paramMessageForShortVideo)
  {
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = (MultiRichMediaSaveManager)this.d.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localMultiRichMediaSaveManager != null)
    {
      paramMessageForShortVideo = localMultiRichMediaSaveManager.a(localMultiRichMediaSaveManager.a(paramMessageForShortVideo));
      if ((paramMessageForShortVideo != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoRealItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      bool1 = bool2;
      if (paramMessageForShortVideo != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean g(MessageForShortVideo paramMessageForShortVideo)
  {
    return AIOVideoPlayController.a().a(this.e, 2, paramMessageForShortVideo.istroop);
  }
  
  public static void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "pauseAllVideo");
    }
    Object localObject = y;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArraySet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)((Iterator)localObject).next();
        if (localCropBubbleVideoView != null) {
          localCropBubbleVideoView.pause();
        }
      }
    }
  }
  
  public static void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "resumeAllVideo");
    }
    Object localObject = y;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArraySet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)((Iterator)localObject).next();
        if (localCropBubbleVideoView != null) {
          localCropBubbleVideoView.resume();
        }
      }
    }
  }
  
  public static void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "releaseAllVideo");
    }
    Object localObject = y;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArraySet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)((Iterator)localObject).next();
        if (localCropBubbleVideoView != null)
        {
          localCropBubbleVideoView.releasePlayer(false);
          y.remove(localCropBubbleVideoView);
        }
      }
    }
  }
  
  private void n()
  {
    if (!F)
    {
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.ShortVideoHDConfig.name(), null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initVideoHDConfig(), shortVideoHDConfig=");
        localStringBuilder.append((String)localObject);
        QLog.d("ShortVideoRealItemBuilder", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 3))
        {
          if (!TextUtils.isEmpty(localObject[0])) {
            a = localObject[0].equals("1");
          }
          bool = TextUtils.isEmpty(localObject[1]);
          j = 720;
          i = j;
          if (bool) {}
        }
      }
    }
    try
    {
      i = Integer.parseInt(localObject[1]);
    }
    catch (Exception localException2)
    {
      try
      {
        j = Integer.parseInt(localObject[2]);
        w = Math.max(i, j);
        x = Math.min(i, j);
        F = true;
        if (!QLog.isColorLevel()) {
          break label304;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initVideoHDConfig(), sReadHDConfig=");
        ((StringBuilder)localObject).append(F);
        ((StringBuilder)localObject).append(", sHDEnable:");
        ((StringBuilder)localObject).append(a);
        ((StringBuilder)localObject).append(", sHDMaxLength:");
        ((StringBuilder)localObject).append(w);
        ((StringBuilder)localObject).append(", sHDMinLength:");
        ((StringBuilder)localObject).append(x);
        QLog.d("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
        return;
        localException2 = localException2;
        i = j;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          int k;
          j = k;
        }
      }
    }
    boolean bool = TextUtils.isEmpty(localObject[2]);
    k = 540;
    j = k;
    if (bool) {}
  }
  
  private boolean o()
  {
    if ((this.q != null) && ((this.q instanceof ChatXListView))) {
      return ((ChatXListView)this.q).a();
    }
    return true;
  }
  
  private void p()
  {
    try
    {
      if ((this.e != null) && ((this.e instanceof BaseActivity)))
      {
        Object localObject = ((BaseActivity)this.e).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).k();
          if (localObject != null) {
            ((BaseChatPie)localObject).a(false, false);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    a(paramChatMessage, paramView, this);
    a((ShortVideoRealItemBuilder.Holder)paramView.getTag(), paramView);
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ShortVideoRealItemBuilder.Holder localHolder = (ShortVideoRealItemBuilder.Holder)paramViewHolder;
    Object localObject1 = this.e;
    Resources localResources = ((Context)localObject1).getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramViewHolder = ShortVideoUtils.adjustSize(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
    int k = paramViewHolder[0];
    int i = paramViewHolder[1];
    boolean bool = localMessageForShortVideo.isSend();
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout((Context)localObject1);
      paramView = (CropBubbleVideoView)QQVideoViewFactory.createCropBubbleView(this.e, localMessageForShortVideo.uniseq, null, bool);
      paramView.setId(2131427939);
      paramView.setVisibility(0);
      paramView.setContentDescription(HardCodeUtil.a(2131911484));
      paramView.setDrawTri(QQTheme.isNowSimpleUI() ^ true);
      float f;
      if (QQTheme.isNowSimpleUI()) {
        f = 8.0F;
      } else {
        f = 15.0F;
      }
      paramView.setRadius(f);
      paramViewHolder.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject1);
      paramViewHolder.addView(localMessageProgressView);
      ImageView localImageView = new ImageView((Context)localObject1);
      localImageView.setImageResource(2130838044);
      localImageView.setVisibility(8);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131427939);
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131427939);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.b(10.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(10.0F, localResources);
      paramViewHolder.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      y.add(paramView);
      localObject2 = new LinearLayout((Context)localObject1);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setGravity(17);
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject1 = new TextView((Context)localObject1);
      localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(70.0F, localResources);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131430624);
      ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      paramViewHolder.setOnClickListener(this);
      super.a(paramViewHolder, paramOnLongClickAndTouchListener);
      localHolder.a = paramView;
      localHolder.b = localMessageProgressView;
      localHolder.c = ((TextView)localObject1);
      localHolder.d = localImageView;
    }
    else
    {
      paramViewHolder = paramView;
    }
    paramView = localHolder.a;
    if (v) {
      paramView.setContentDescription(HardCodeUtil.a(2131911446));
    }
    localHolder.j.setMiniAioShieldItemTouchListener(this);
    paramView.mIsSend = localMessageForShortVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForShortVideo.uniseq));
    AIOSingleReporter.a().a(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
    localHolder.c.setVisibility(8);
    a(localHolder, localMessageForShortVideo);
    paramOnLongClickAndTouchListener = localHolder.a.getLayoutParams();
    if (paramOnLongClickAndTouchListener == null)
    {
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(k, i);
      localHolder.a.setLayoutParams(paramOnLongClickAndTouchListener);
    }
    else
    {
      int j = i;
      if ((paramOnLongClickAndTouchListener.width != k) || (paramOnLongClickAndTouchListener.height != j))
      {
        paramOnLongClickAndTouchListener.width = k;
        paramOnLongClickAndTouchListener.height = j;
        localHolder.a.setLayoutParams(paramOnLongClickAndTouchListener);
      }
    }
    paramOnLongClickAndTouchListener = localHolder.b.getLayoutParams();
    if (paramOnLongClickAndTouchListener == null)
    {
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(k, i);
      localHolder.b.setLayoutParams(paramOnLongClickAndTouchListener);
    }
    else if ((paramOnLongClickAndTouchListener.width != k) || (paramOnLongClickAndTouchListener.height != i))
    {
      paramOnLongClickAndTouchListener.width = k;
      paramOnLongClickAndTouchListener.height = i;
      localHolder.b.setLayoutParams(paramOnLongClickAndTouchListener);
    }
    if (paramBaseChatItemLayout != null)
    {
      a(this.d, paramBaseChatItemLayout, this.f, paramChatMessage, this);
      if ((!(this.e instanceof MultiForwardActivity)) && (!this.f.G)) {
        a(paramBaseChatItemLayout, localHolder, paramChatMessage);
      }
    }
    a(localMessageForShortVideo);
    a(localMessageForShortVideo, localHolder, localResources, bool);
    if (a(localHolder, localMessageForShortVideo, k, i, paramView)) {
      return paramViewHolder;
    }
    paramChatMessage = SVUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
    paramBaseChatItemLayout = SVUtils.a(localMessageForShortVideo, "mp4");
    bool = g(localMessageForShortVideo);
    if ((bool) && (FileUtils.fileExistsAndNotEmpty(paramBaseChatItemLayout)) && ((!localMessageForShortVideo.isSendFromLocal()) || (localMessageForShortVideo.videoFileStatus == 1003) || (localMessageForShortVideo.videoFileStatus == 2003) || (localMessageForShortVideo.isMultiMsg == true)))
    {
      a(localMessageForShortVideo, localHolder, paramChatMessage, paramBaseChatItemLayout, k, i);
      return paramViewHolder;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramChatMessage))
    {
      a(bool, paramView, localMessageForShortVideo, localHolder, paramChatMessage, paramBaseChatItemLayout, k, i);
      return paramViewHolder;
    }
    if (localMessageForShortVideo.videoFileStatus == 5002)
    {
      a(localMessageForShortVideo, HardCodeUtil.a(2131911477));
      paramView.setID(localMessageForShortVideo.uniseq);
      paramView.showCover(z);
      b(localMessageForShortVideo, localHolder, 2131915835);
      return paramViewHolder;
    }
    a(localMessageForShortVideo, HardCodeUtil.a(2131911498));
    paramView.setID(localMessageForShortVideo.uniseq);
    paramView.showCover(z);
    b(localMessageForShortVideo);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoRealItemBuilder.Holder(this);
  }
  
  public ShortVideoRealItemBuilder.Holder a(long paramLong)
  {
    Object localObject = this.K;
    if ((localObject != null) && (paramLong > 0L))
    {
      int i = AIOUtils.a(paramLong, ((ListView)localObject).getAdapter());
      int j = this.K.getHeaderViewsCount();
      int k = this.K.getFirstVisiblePosition();
      int m = this.K.getLastVisiblePosition();
      if (i > -1)
      {
        localObject = AIOUtils.a(this.K, i);
        if (localObject != null)
        {
          localObject = AIOUtils.b((View)localObject);
          if ((localObject != null) && ((localObject instanceof ShortVideoRealItemBuilder.Holder))) {
            return (ShortVideoRealItemBuilder.Holder)localObject;
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getHolderByMsg() uniseq=");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(", posi =");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", view = null");
          QLog.w("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getHolderByMsg() uniseq=");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(", posi =");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", firstVisblePosi=");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(",lastVisblePosi=");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(",headerCount=");
          ((StringBuilder)localObject).append(j);
          QLog.d("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getHolderByMsg() uniseq=");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", posi<= -1");
        QLog.w("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramBaseHolder = (ShortVideoRealItemBuilder.Holder)paramBaseHolder;
    a(paramQQCustomMenu, this.e, 2131439081, null, null);
    boolean bool = TextUtils.isEmpty(paramChatMessage.md5);
    int j = 1;
    if ((!bool) && ((!paramChatMessage.mPreUpload) || (!TextUtils.isEmpty(paramChatMessage.mLocalMd5))))
    {
      String str = SVUtils.a(paramChatMessage.thumbMD5, "jpg");
      paramChatMessage = SVUtils.a(paramChatMessage, "mp4");
      if (FileUtils.fileExistsAndNotEmpty(str))
      {
        if ((paramBaseHolder.j.ah != null) && (paramBaseHolder.j.ah.getVisibility() == 0)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          paramQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
          if (FileUtils.fileExistsAndNotEmpty(paramChatMessage))
          {
            i = j;
            break label160;
          }
        }
      }
    }
    int i = 0;
    label160:
    if (i != 0) {
      paramQQCustomMenu.a(2131432813, this.e.getString(2131889171), 2130839065);
    }
    return paramQQCustomMenu;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt == 2131431695)
      {
        ChatActivityFacade.b(this.e, this.d, localMessageForShortVideo);
        StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
        return;
      }
      if (paramInt == 2131439015)
      {
        super.a(paramInt, this.e, paramChatMessage);
        StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
        return;
      }
      if (paramInt == 2131433636)
      {
        paramInt = ((IPicPreDownload)this.d.getRuntimeService(IPicPreDownload.class, "")).calcUinType(this.d, paramChatMessage.istroop, paramChatMessage.frienduin);
        if (paramInt == 3) {
          paramContext = "1";
        } else if (paramInt == 2) {
          paramContext = "2";
        } else if (paramInt == 0) {
          paramContext = "3";
        } else {
          paramContext = "4";
        }
        ReportController.b(this.d, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
        StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "1", "", "", "" });
        c(localMessageForShortVideo);
        if (paramChatMessage.isMultiMsg) {
          ReportController.b(this.d, "dc00898", "", "", "0X8009D66", "0X8009D66", 5, 0, "5", "", "", "");
        }
      }
      else if (paramInt == 2131432813)
      {
        QfavBuilder.a(localMessageForShortVideo).b(this.d, paramChatMessage).a((Activity)this.e, this.d.getAccount());
        QfavReport.a(this.d, 3, 0, paramChatMessage.istroop);
        QfavReport.a(this.d, 6, 5);
        StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
        if (paramChatMessage.isMultiMsg) {
          ReportController.b(this.d, "dc00898", "", "", "0X8009D67", "0X8009D67", 5, 0, "5", "", "", "");
        }
      }
      else
      {
        if (paramInt == 2131438943)
        {
          super.a(2131438943, this.e, localMessageForShortVideo);
          StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
          return;
        }
        if (paramInt == 2131431648)
        {
          paramContext = new StringBuilder();
          paramContext.append("uniseq:");
          paramContext.append(localMessageForShortVideo.uniseq);
          paramContext.append("\n");
          Toast.makeText(this.e, paramContext.toString(), 1).show();
          return;
        }
        if (paramInt == 2131439081)
        {
          paramContext = a(localMessageForShortVideo.uniseq);
          if (paramContext == null)
          {
            if (QLog.isColorLevel())
            {
              paramContext = new StringBuilder();
              paramContext.append("onMenuItemClicked(), mute_play, holder == null, mr.uniseq = ");
              paramContext.append(localMessageForShortVideo.uniseq);
              QLog.e("ShortVideoRealItemBuilder", 2, paramContext.toString());
            }
          }
          else
          {
            a(paramContext, localMessageForShortVideo, true);
            ReportController.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 1, 0, "", "", "", "");
          }
        }
        else
        {
          super.a(paramInt, paramContext, paramChatMessage);
        }
      }
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = this.e.getResources().getDimensionPixelSize(2131296618);
    int i;
    if (QQTheme.isNowSimpleUI()) {
      i = BaseChatItemLayout.getBubblePaddingAlignError();
    } else {
      i = j;
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.k, i, BaseChatItemLayout.l);
      return;
    }
    paramView.setPadding(j, BaseChatItemLayout.k, BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.l);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, ShortVideoRealItemBuilder.Holder paramHolder, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      if (paramHolder.f == 0) {
        return;
      }
      paramHolder.f = 0;
      paramBaseChatItemLayout.setTailMessage(false, null, null);
    }
  }
  
  protected void a(ShortVideoRealItemBuilder.Holder paramHolder)
  {
    MessageProgressView localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHolder.q.frienduin);
    localStringBuilder.append(paramHolder.q.uniseq);
    if (!localMessageProgressView.c(localStringBuilder.toString())) {
      paramHolder.b.setVisibility(8);
    } else {
      paramHolder.b.setAnimRunnableListener(new ShortVideoRealItemBuilder.6(this, paramHolder));
    }
    paramHolder.c.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[hideProgress] set mProgressView gone");
    }
  }
  
  protected void a(ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    MessageProgressView localMessageProgressView = paramHolder.b;
    float f;
    if (QQTheme.isNowSimpleUI()) {
      f = 8.0F;
    } else {
      f = 15.0F;
    }
    localMessageProgressView.setRadius(f, true);
    paramHolder.b.setShowCorner(QQTheme.isNowSimpleUI() ^ true);
    paramHolder.b.setSharpCornerCor(BubbleImageView.d);
    paramHolder.b.setCornerDirection(paramMessageForShortVideo.isSend());
    localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localMessageProgressView.a(localStringBuilder.toString());
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9) || (paramMessageForShortVideo.fileType == 20))
    {
      if ((paramMessageForShortVideo.videoFileStatus != 1003) && (paramMessageForShortVideo.videoFileStatus != 2003))
      {
        paramHolder.b.setVisibility(0);
        return;
      }
      b(paramHolder);
    }
  }
  
  public void a(ShortVideoRealItemBuilder.Holder paramHolder, String paramString, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    if ((FileUtils.fileExistsAndNotEmpty(paramString)) && (a(paramHolder.a, paramString)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      ColorDrawable localColorDrawable = z;
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      paramString = URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
      paramHolder.a.setID(paramMessageForShortVideo.uniseq);
      paramHolder.a.showCover(paramString);
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8007428"))
    {
      AIOSingleReporter.a().b(paramMessageForShortVideo, "0X8007428");
      ReportController.b(this.d, "dc00898", "", "", "0X8007428", "0X8007428", 0, 0, "", "", "", "");
    }
    if ((paramMessageForShortVideo.checkIsHotVideo()) && (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8007EDB")))
    {
      AIOSingleReporter.a().b(paramMessageForShortVideo, "0X8007EDB");
      ReportController.b(this.d, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      AIOSingleReporter.a().b(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.reportVideoPlayEvent(this.d, this.f.a, paramMessageForShortVideo.frienduin, 1, 2, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startUploadVideo：");
    ((StringBuilder)localObject).append(paramMessageForShortVideo.toString());
    a(paramMessageForShortVideo, ((StringBuilder)localObject).toString());
    localObject = SVUtils.a(paramMessageForShortVideo, "mp4");
    String str = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      QQToast.makeText(this.e, 1, 2131916646, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      paramHolder.j.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!FileUtils.fileExistsAndNotEmpty(str))
    {
      QQToast.makeText(this.e, 1, 2131916647, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      paramHolder.j.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((IOrderMediaMsgService)this.d.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsgStatus(this.f.b, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    localObject = SVBusiUtil.a(1, 2);
    ((ShortVideoReq)localObject).a(ShortVideoBusiManager.a(2, paramMessageForShortVideo, (ShortVideoReq)localObject));
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.d);
    a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, true);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt)
  {
    int i = ShortVideoUtils.getDisplayProgress(paramInt, 10);
    if (paramMessageForShortVideo.busiType == 1)
    {
      if (i < 60) {
        return;
      }
      if (paramMessageForShortVideo.progressTask != null)
      {
        this.J.removeCallbacks(paramMessageForShortVideo.progressTask);
        paramMessageForShortVideo.progressTask = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VIDEO STATUS_SEND_PROCESS CLOSE_TASK PROCESS:");
        localStringBuilder.append(i);
        a(paramMessageForShortVideo, localStringBuilder.toString());
      }
    }
    a(paramMessageForShortVideo, paramHolder, paramInt, true);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt1, int paramInt2)
  {
    if (ShortVideoUtils.getDisplayProgress(paramMessageForShortVideo.videoFileProgress, 10) <= 60)
    {
      if (paramInt2 > 60) {
        return;
      }
      paramInt2 = ShortVideoUtils.getDisplayProgress(paramInt2, 0);
      paramHolder.b.setDrawStatus(1);
      MessageProgressView localMessageProgressView = paramHolder.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageForShortVideo.frienduin);
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      localMessageProgressView.setAnimProgress(paramInt2, localStringBuilder.toString());
      paramHolder.b.setVisibility(0);
      paramHolder.c.setVisibility(8);
      if ((paramMessageForShortVideo.progressTask != null) && (NetworkUtil.isNetSupport(this.e)))
      {
        paramMessageForShortVideo.progress += 3;
        this.J.postDelayed(paramMessageForShortVideo.progressTask, 1000L);
      }
      if (QLog.isColorLevel())
      {
        paramHolder = new StringBuilder();
        paramHolder.append("[setProgress] uinseq:");
        paramHolder.append(paramMessageForShortVideo.uniseq);
        paramHolder.append(", p:");
        paramHolder.append(paramInt1);
        paramHolder.append(", progress:");
        paramHolder.append(paramInt2);
        QLog.w("ShortVideoRealItemBuilder", 2, paramHolder.toString());
      }
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt, boolean paramBoolean)
  {
    paramHolder.b.setDrawStatus(1);
    MessageProgressView localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localMessageProgressView.setAnimProgress(paramInt, localStringBuilder.toString());
    paramHolder.b.setVisibility(0);
    paramHolder.c.setVisibility(8);
    if (QLog.isColorLevel())
    {
      paramHolder = new StringBuilder();
      paramHolder.append("[setProgress] uinseq:");
      paramHolder.append(paramMessageForShortVideo.uniseq);
      paramHolder.append(", p:");
      paramHolder.append(paramInt);
      QLog.w("ShortVideoRealItemBuilder", 2, paramHolder.toString());
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, Resources paramResources, boolean paramBoolean)
  {
    int i = Math.max(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    int j = Math.min(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    if ((a) && (i >= w) && (j >= x))
    {
      paramMessageForShortVideo = (RelativeLayout.LayoutParams)paramHolder.d.getLayoutParams();
      if (paramBoolean) {
        paramMessageForShortVideo.rightMargin = AIOUtils.b(paramHolder.a.getTriaWidth() + 8.0F, paramResources);
      } else {
        paramMessageForShortVideo.rightMargin = AIOUtils.b(8.0F, paramResources);
      }
      paramHolder.d.setVisibility(0);
      return;
    }
    paramHolder.d.setVisibility(8);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, HardCodeUtil.a(2131911458));
      return;
    }
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(2, 2);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
    localShortVideoDownloadInfo.o = SVUtils.a(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 0);
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    localShortVideoDownloadInfo.r = i;
    localShortVideoDownloadInfo.s = 2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" startDownloadVideo downloadvideo fileType==");
      localStringBuilder.append(localShortVideoDownloadInfo.q);
      localStringBuilder.append(", uniseq:");
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      QLog.d("ShortVideoRealItemBuilder", 2, localStringBuilder.toString());
    }
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(localShortVideoReq, this.d);
  }
  
  public void a(FileMsg paramFileMsg, ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramFileMsg.status;
    if (i != 1007)
    {
      if (i != 5001)
      {
        if (i != 5002)
        {
          Object localObject;
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              return;
            case 2005: 
              a(paramMessageForShortVideo, "VIDEO STATUS_RECV_ERROR");
              a(paramHolder);
              c(paramMessageForShortVideo, paramHolder);
              if (paramFileMsg.errorCode == -5100528) {
                break;
              }
              QQToast.makeText(this.e, 2131916641, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
              return;
            case 2004: 
              a(paramMessageForShortVideo, "VIDEO STATUS_RECV_CANCEL");
              return;
            case 2003: 
              paramFileMsg = new StringBuilder();
              paramFileMsg.append("VIDEO STATUS_RECV_FINISHED , getAIOState() = ");
              paramFileMsg.append(g());
              a(paramMessageForShortVideo, paramFileMsg.toString());
              if ((g(paramMessageForShortVideo)) && (g() == 4))
              {
                paramFileMsg = SVUtils.a(paramMessageForShortVideo, "mp4");
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(HardCodeUtil.a(2131911481));
                ((StringBuilder)localObject).append(paramFileMsg);
                a(paramMessageForShortVideo, ((StringBuilder)localObject).toString());
                if ((ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.fileExistsAndNotEmpty(paramFileMsg)))
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(HardCodeUtil.a(2131911493));
                  ((StringBuilder)localObject).append(paramFileMsg);
                  a(paramMessageForShortVideo, ((StringBuilder)localObject).toString());
                  localObject = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
                  a(paramHolder.a, paramFileMsg, (String)localObject, paramMessageForShortVideo, paramInt1, paramInt2);
                  if (!paramMessageForShortVideo.isSend()) {
                    new DCShortVideo(BaseApplication.getContext()).a(this.d, 2001, this.f.a, this.f.b, 1002);
                  }
                }
                a(paramMessageForShortVideo, paramHolder, 100, true);
                if (!paramMessageForShortVideo.isMultiMsg) {
                  break;
                }
                a(paramHolder);
                return;
              }
              a(paramHolder, SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
              c(paramMessageForShortVideo, paramHolder);
              return;
            case 2002: 
              paramInt1 = paramMessageForShortVideo.videoFileProgress;
              paramFileMsg = new StringBuilder();
              paramFileMsg.append("VIDEO STATUS_RECV_PROCESS ");
              paramFileMsg.append(paramInt1);
              a(paramMessageForShortVideo, paramFileMsg.toString());
              a(paramMessageForShortVideo, paramHolder, paramInt1, true);
              return;
            case 2001: 
              a(paramMessageForShortVideo, "VIDEO STATUS_RECV_START");
              a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, true);
              return;
            }
            break;
          case 1005: 
            a(paramMessageForShortVideo, "VIDEO STATUS_SEND_ERROR");
            e(paramMessageForShortVideo);
            b(paramMessageForShortVideo, paramHolder, 2131915840);
            paramHolder.j.setFailedIconVisable(true, this);
            EncodeVideoTask.a.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
            return;
          case 1004: 
            a(paramMessageForShortVideo, "VIDEO STATUS_SEND_CANCEL");
            paramFileMsg = paramHolder.b;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramHolder.q.frienduin);
            ((StringBuilder)localObject).append(paramHolder.q.uniseq);
            paramFileMsg.b(((StringBuilder)localObject).toString());
            e(paramMessageForShortVideo);
            a(paramHolder);
            b(paramMessageForShortVideo, paramHolder, 2131915840);
            b(paramHolder, true, this);
            EncodeVideoTask.a.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
            return;
          case 1003: 
            a(paramMessageForShortVideo, "VIDEO STATUS_SEND_FINISHED");
            e(paramMessageForShortVideo);
            a(paramMessageForShortVideo.mVideoFileSourceDir);
            a(paramMessageForShortVideo, paramHolder, 100, true);
            a(paramHolder, false, null);
            EncodeVideoTask.a.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
            return;
          case 1002: 
            paramInt1 = paramMessageForShortVideo.videoFileProgress;
            paramFileMsg = new StringBuilder();
            paramFileMsg.append("VIDEO STATUS_SEND_PROCESS ");
            paramFileMsg.append(paramInt1);
            a(paramMessageForShortVideo, paramFileMsg.toString());
            a(paramMessageForShortVideo, paramHolder, paramInt1);
            return;
          case 1001: 
            paramFileMsg = new StringBuilder();
            paramFileMsg.append("VIDEO STATUS_SEND_START progress ");
            paramFileMsg.append(paramMessageForShortVideo.videoFileProgress);
            a(paramMessageForShortVideo, paramFileMsg.toString());
            if (paramMessageForShortVideo.busiType != 1) {
              a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, true);
            }
            paramHolder.j.setFailedIconVisable(false, this);
            EncodeVideoTask.a.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
            return;
          }
        }
        else
        {
          a(paramMessageForShortVideo, "VIDEO STATUS_FILE_EXPIRED");
          a(paramHolder, SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
          b(paramMessageForShortVideo, paramHolder, 2131915835);
        }
      }
      else
      {
        a(paramMessageForShortVideo, "VIDEO STATUS_FILE_UNSAFE");
        b(paramMessageForShortVideo, paramHolder, 2131915834);
        if (paramMessageForShortVideo.uiOperatorFlag == 2)
        {
          paramHolder.j.setFailedIconVisable(true, this);
          QQToast.makeText(this.e, 2131916615, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
          return;
        }
        QQToast.makeText(this.e, 2131916639, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      }
    }
    else
    {
      a(paramHolder, false, null);
      EncodeVideoTask.a.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
      paramFileMsg = new StringBuilder();
      paramFileMsg.append("VIDEO STATUS_UPLOAD_FINISHED progress ");
      paramFileMsg.append(paramMessageForShortVideo.videoFileProgress);
      a(paramMessageForShortVideo, paramFileMsg.toString());
    }
  }
  
  protected void a(CropBubbleVideoView paramCropBubbleVideoView, String paramString1, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playShortVideoByPath uniseq=");
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      localStringBuilder.append(", videoPath = ");
      String str = "null";
      if (paramString1 != null) {
        localObject = paramString1;
      } else {
        localObject = "null";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", thumbPath = ");
      localObject = str;
      if (paramString2 != null) {
        localObject = paramString2;
      }
      localStringBuilder.append((String)localObject);
      QLog.d("ShortVideoRealItemBuilder", 2, localStringBuilder.toString());
    }
    paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    Object localObject = new VideoPlayParam();
    ((VideoPlayParam)localObject).mSceneId = 100;
    ((VideoPlayParam)localObject).mSceneName = SceneID.getSceneStr(100);
    ((VideoPlayParam)localObject).mIsMute = true;
    ((VideoPlayParam)localObject).mCallback = new ShortVideoRealItemBuilder.3(this);
    ((VideoPlayParam)localObject).mIsLocal = true;
    ((VideoPlayParam)localObject).mIsLoop = true;
    ((VideoPlayParam)localObject).mVideoPath = paramString1;
    ((VideoPlayParam)localObject).mFileSize = paramMessageForShortVideo.videoFileSize;
    paramCropBubbleVideoView.setVideoParam((VideoPlayParam)localObject);
    paramString1 = new EmptyDrawable(-10065297, 100, 100);
    if (TextUtils.isEmpty(paramString2)) {
      paramCropBubbleVideoView.setCoverDrawable(paramString1);
    } else {
      paramCropBubbleVideoView.setCoverDrawable(URLDrawable.getDrawable(ShortVideoUtils.getThumbUrl(paramString2).toString(), paramInt1, paramInt2, paramString1, paramString1));
    }
    if (o()) {
      paramCropBubbleVideoView.play();
    }
    y.add(paramCropBubbleVideoView);
  }
  
  void a(String paramString)
  {
    ThreadManager.post(new ShortVideoRealItemBuilder.4(this, paramString), 5, null, false);
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool2 = paramChatMessage.isMultiMsg;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (!paramChatMessage.isSendFromLocal()) {
      return false;
    }
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    if ((paramChatMessage.md5 == null) && (paramChatMessage.videoFileStatus == 1004)) {
      return true;
    }
    if (paramChatMessage.md5 == null) {
      return false;
    }
    if (paramChatMessage.videoFileStatus == 5002) {
      return false;
    }
    if ((paramChatMessage.busiType == 1) && (paramChatMessage.uiOperatorFlag == 1) && (paramChatMessage.videoFileStatus == 1004)) {
      return true;
    }
    paramBaseChatItemLayout = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
    if ((paramBaseChatItemLayout instanceof BaseTransProcessor))
    {
      if (((BaseTransProcessor)paramBaseChatItemLayout).getFileStatus() == 1005L) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramChatMessage.videoFileStatus == 1005) {
      return true;
    }
    return (paramChatMessage.videoFileProgress != 100) && (paramChatMessage.videoFileStatus != 1003) && (paramChatMessage.videoFileStatus != 2003) && (paramChatMessage.isAllowAutoDown == true);
  }
  
  protected boolean a(CropBubbleVideoView paramCropBubbleVideoView, String paramString)
  {
    paramCropBubbleVideoView = paramCropBubbleVideoView.getCoverDrawable();
    if (paramCropBubbleVideoView == null) {
      return true;
    }
    return (!(paramCropBubbleVideoView instanceof URLDrawable)) || (!((URLDrawable)paramCropBubbleVideoView).getURL().getPath().equals(paramString));
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.b(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.q;
    if (localMessageForShortVideo != null) {
      if (localMessageForShortVideo.isMultiMsg) {
        a(localQQCustomMenu, localMessageForShortVideo, paramView);
      } else {
        b(localQQCustomMenu, localMessageForShortVideo, paramView);
      }
    }
    return localQQCustomMenu.d();
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.d, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramBaseHolder = (ShortVideoRealItemBuilder.Holder)paramBaseHolder;
    a(paramQQCustomMenu, this.e, 2131439081, null, null);
    if ((!TextUtils.isEmpty(paramChatMessage.md5)) && ((!paramChatMessage.mPreUpload) || (!TextUtils.isEmpty(paramChatMessage.mLocalMd5))))
    {
      Object localObject = SVUtils.a(paramChatMessage.thumbMD5, "jpg");
      String str = SVUtils.a(paramChatMessage, "mp4");
      if (FileUtils.fileExistsAndNotEmpty((String)localObject))
      {
        localObject = paramBaseHolder.j.ah;
        int j = 1;
        int k;
        if ((localObject != null) && (paramBaseHolder.j.ah.getVisibility() == 0)) {
          k = 1;
        } else {
          k = 0;
        }
        int i;
        if (k == 0)
        {
          paramQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
          a(paramQQCustomMenu, this.e, 2131444634, paramChatMessage, null);
          if (FileUtils.fileExistsAndNotEmpty(str)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        else
        {
          i = 0;
          j = 0;
        }
        n = i;
        m = j;
        if (k != 0) {
          break label234;
        }
        a(paramQQCustomMenu, this.e, 2131438943, paramChatMessage, new Bundle());
        n = i;
        m = j;
        break label234;
      }
    }
    int n = 0;
    int m = 0;
    label234:
    a(paramQQCustomMenu, this.e, 2131431695, paramChatMessage, new Bundle());
    if (n != 0) {
      paramQQCustomMenu.a(2131432813, this.e.getString(2131889171), 2130839065);
    }
    paramBaseHolder = new Bundle();
    paramBaseHolder.putBoolean("isSearch", false);
    super.a(paramQQCustomMenu, this.e, 2131449133, paramChatMessage, paramBaseHolder);
    if (m != 0) {
      a(paramQQCustomMenu, this.e, 2131444651, paramChatMessage, null);
    }
    super.a(paramQQCustomMenu, this.e, 2131439015, null, null);
    super.a(paramQQCustomMenu, this.e, 2131428089, null, null);
    return paramQQCustomMenu;
  }
  
  public void b()
  {
    super.b();
    Object localObject1 = H.values().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageForShortVideo)((Iterator)localObject1).next();
      if (((MessageForShortVideo)localObject2).progressTask != null) {
        ((MessageForShortVideo)localObject2).progressTask = null;
      }
    }
    localObject1 = y;
    if (localObject1 != null)
    {
      localObject1 = ((CopyOnWriteArraySet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CropBubbleVideoView)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          long l = ((CropBubbleVideoView)localObject2).getCurPlayingPos();
          if (l > 0L)
          {
            MessageForShortVideo localMessageForShortVideo = AIOSingleReporter.a().b(Integer.valueOf(((CropBubbleVideoView)localObject2).getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l);
            }
          }
          ((CropBubbleVideoView)localObject2).releasePlayer(false);
          y.remove(localObject2);
        }
      }
    }
    H.clear();
    this.J.removeCallbacksAndMessages(null);
    this.e = null;
    localObject1 = this.L;
    if ((localObject1 != null) && (((MessageForShortVideo)localObject1).progressTask != null)) {
      ((MessageForShortVideo)localObject1).progressTask = null;
    }
    this.K = null;
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.b(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.q;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.e, null);
    localActionSheet.addButton(2131886574, 5);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ShortVideoRealItemBuilder.5(this, localMessageForShortVideo, paramView, localActionSheet));
    localActionSheet.show();
    if (localMessageForShortVideo.videoFileStatus == 1004) {
      ShortVideoUtils.reportCancelSendVideo("0X800A7EF", this.f.a);
    }
  }
  
  protected void b(ShortVideoRealItemBuilder.Holder paramHolder)
  {
    MessageProgressView localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHolder.q.frienduin);
    localStringBuilder.append(paramHolder.q.uniseq);
    if (!localMessageProgressView.c(localStringBuilder.toString())) {
      paramHolder.b.setVisibility(8);
    } else {
      paramHolder.b.setAnimRunnableListener(new ShortVideoRealItemBuilder.7(this, paramHolder));
    }
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[disProgress] set mProgressView gone");
    }
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (f(paramMessageForShortVideo)) {
      return;
    }
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(2, 2);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
    localShortVideoDownloadInfo.p = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
    localShortVideoDownloadInfo.r = 2;
    localShortVideoDownloadInfo.s = 2;
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(localShortVideoReq, this.d);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reForwardVideo：");
    localStringBuilder.append(paramMessageForShortVideo.toString());
    a(paramMessageForShortVideo, localStringBuilder.toString());
    if (!FileUtils.fileExistsAndNotEmpty(SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.makeText(this.e, 1, 2131916647, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      paramHolder.j.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((IOrderMediaMsgService)this.d.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsgStatus(this.f.b, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      paramHolder = SVBusiUtil.a(4, 2);
      paramHolder.a(ShortVideoBusiManager.b(2, paramMessageForShortVideo, paramHolder));
      ShortVideoBusiManager.a(paramHolder, this.d);
      return;
    }
    a(paramMessageForShortVideo, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt)
  {
    MessageProgressView localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localMessageProgressView.b(localStringBuilder.toString());
    paramHolder.b.setVisibility(0);
    paramHolder.b.setImageResource(2130851866);
    paramHolder.b.setDrawStatus(3);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showWarnProgress] set mProgressView visible");
    }
    paramHolder.c.setVisibility(0);
    paramHolder.c.setText(paramInt);
  }
  
  public void b(FileMsg paramFileMsg, ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramFileMsg.status;
    if (i != 2001)
    {
      if (i != 2003)
      {
        if (i != 2005)
        {
          if (i != 5002) {
            return;
          }
          a(paramMessageForShortVideo, "THUMB STATUS_FILE_EXPIRED");
        }
        a(paramMessageForShortVideo, "THUMB STATUS_RECV_ERROR");
        paramFileMsg = SVUtils.a(paramMessageForShortVideo, "mp4");
        if (FileUtils.fileExistsAndNotEmpty(paramFileMsg))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131911438));
          ((StringBuilder)localObject).append(paramFileMsg);
          a(paramMessageForShortVideo, ((StringBuilder)localObject).toString());
          if (ShortVideoUtils.isVideoSoLibLoaded())
          {
            localObject = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
            a(paramHolder.a, paramFileMsg, (String)localObject, paramMessageForShortVideo, paramInt1, paramInt2);
          }
        }
        else
        {
          paramHolder.a.setID(paramMessageForShortVideo.uniseq);
          paramHolder.a.showCover(z);
        }
        a(paramHolder);
        return;
      }
      a(paramMessageForShortVideo, "THUMB STATUS_RECV_FINISHED");
      paramFileMsg = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      Object localObject = SVUtils.a(paramMessageForShortVideo, "mp4");
      StringBuilder localStringBuilder;
      if ((FileUtils.fileExistsAndNotEmpty((String)localObject)) && (g(paramMessageForShortVideo)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131911453));
        localStringBuilder.append(paramFileMsg);
        a(paramMessageForShortVideo, localStringBuilder.toString());
        if (ShortVideoUtils.isVideoSoLibLoaded()) {
          a(paramHolder.a, (String)localObject, paramFileMsg, paramMessageForShortVideo, paramInt1, paramInt2);
        }
      }
      else
      {
        a(paramHolder, paramFileMsg, paramMessageForShortVideo, paramInt3, paramInt4);
        if (FileUtils.fileExistsAndNotEmpty(paramFileMsg))
        {
          if (a(paramHolder.a, paramFileMsg))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(2131911441));
            localStringBuilder.append(paramFileMsg);
            a(paramMessageForShortVideo, localStringBuilder.toString());
            if (!FileUtils.fileExistsAndNotEmpty((String)localObject))
            {
              if (this.d.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
              {
                a(paramMessageForShortVideo, true);
                return;
              }
              c(paramMessageForShortVideo, paramHolder);
              return;
            }
            if (ShortVideoUtils.isVideoSoLibLoaded())
            {
              a(paramHolder);
              return;
            }
            c(paramMessageForShortVideo, paramHolder);
          }
        }
        else
        {
          paramHolder.a.setID(paramMessageForShortVideo.uniseq);
          paramHolder.a.showCover(URLDrawableHelper.getFailedDrawable());
        }
      }
    }
    else
    {
      a(paramMessageForShortVideo, "THUMB STATUS_RECV_START");
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      a(paramMessageForShortVideo, "Forward menu clicked, md5 is empty.");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str1 = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putString("from_uin", SVUtils.a(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", this.f.a);
    localBundle.putString("from_session_uin", this.f.b);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putInt("selection_mode", this.u);
    String str2 = ShortVideoUtils.findVideoPathIfExists(paramMessageForShortVideo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Forward menu clicked, videoPath=");
      localStringBuilder.append(str2);
      localStringBuilder.append(",videoPath = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramMessageForShortVideo.toLogString());
      QLog.d("ShortVideoRealItemBuilder", 2, localStringBuilder.toString());
    }
    localBundle.putString("file_send_path", str2);
    localBundle.putString("thumbfile_send_path", str1);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    if (!TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5)) {
      localBundle.putString("file_shortvideo_local_md5", paramMessageForShortVideo.mLocalMd5);
    }
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
    localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
    localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
    localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
    localBundle.putLong("from_msg_uniseq", paramMessageForShortVideo.uniseq);
    if (paramMessageForShortVideo.checkIsHotVideo())
    {
      localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
      localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
      localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
      localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.templateId))
    {
      localBundle.putString("widgetinfo", paramMessageForShortVideo.templateId);
      localBundle.putString("key_camera_material_name", paramMessageForShortVideo.templateName);
    }
    if (FileUtils.fileExistsAndNotEmpty(str2))
    {
      localBundle.putBoolean("k_dataline", true);
      localBundle.putString("forward_extra", str2);
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
      localBundle.putInt("forward_source_uin_type", this.f.a);
    }
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    if (this.e != null) {
      ForwardBaseOption.a((Activity)this.e, paramMessageForShortVideo, 21);
    }
  }
  
  void c(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder)
  {
    MessageProgressView localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localMessageProgressView.b(localStringBuilder.toString());
    paramHolder.b.setDrawStatus(2);
    paramHolder.b.setVisibility(0);
    paramHolder.c.setVisibility(8);
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    return null;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131911499);
  }
  
  protected String d(MessageForShortVideo paramMessageForShortVideo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.mVideoFileSourceDir);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("configure.txt");
    paramMessageForShortVideo = localStringBuilder.toString();
    if (!FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoRealItemBuilder", 2, "configure file empty!");
      }
      return null;
    }
    try
    {
      paramMessageForShortVideo = FileUtils.readFileToString(new File(paramMessageForShortVideo));
      if (paramMessageForShortVideo != null)
      {
        paramMessageForShortVideo = paramMessageForShortVideo.replaceAll("[\\t\\n\\r]", "");
        boolean bool = TextUtils.isEmpty(paramMessageForShortVideo);
        if (!bool) {
          return paramMessageForShortVideo;
        }
      }
    }
    catch (Exception paramMessageForShortVideo)
    {
      paramMessageForShortVideo.printStackTrace();
    }
    return null;
  }
  
  public void f()
  {
    super.f();
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.b(paramView);
    if (!(paramView instanceof ShortVideoRealItemBuilder.Holder)) {
      return;
    }
    paramView = (ShortVideoRealItemBuilder.Holder)paramView;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.q;
    if (localMessageForShortVideo.uniseq != paramFileMsg.uniseq) {
      return;
    }
    this.J.removeCallbacks(localMessageForShortVideo.mShowProgressTask);
    if (localMessageForShortVideo.mShowProgressTask != null) {
      localMessageForShortVideo.mShowProgressTask = null;
    }
    if (this.e == null) {
      return;
    }
    Resources localResources = this.e.getResources();
    if (localMessageForShortVideo.thumbWidth > 0) {
      paramInt1 = localMessageForShortVideo.thumbWidth;
    } else {
      paramInt1 = 100;
    }
    if (localMessageForShortVideo.thumbHeight > 0) {
      paramInt2 = localMessageForShortVideo.thumbHeight;
    } else {
      paramInt2 = 100;
    }
    int i = AIOUtils.b(paramInt1, localResources);
    int j = AIOUtils.b(paramInt2, localResources);
    if ((paramFileMsg.fileType != 6) && (paramFileMsg.fileType != 17) && (paramFileMsg.fileType != 9) && (paramFileMsg.fileType != 20))
    {
      if ((paramFileMsg.fileType == 7) || (paramFileMsg.fileType == 18) || (paramFileMsg.fileType == 16)) {
        b(paramFileMsg, paramView, localMessageForShortVideo, paramInt1, paramInt2, i, j);
      }
    }
    else {
      a(paramFileMsg, paramView, localMessageForShortVideo, paramInt1, paramInt2, i, j);
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    long l2 = M;
    if ((l1 - l2 < 500L) && (l1 > l2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoRealItemBuilder", 2, "click too offen, please try again later!");
      }
    }
    else
    {
      M = l1;
      Object localObject;
      if (paramView.getId() == 2131430607)
      {
        localObject = (MessageRecord)paramView.getTag();
        if (localObject != null) {
          ((FlashChatManager)this.d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(paramView.getContext(), (MessageRecord)localObject);
        }
      }
      else
      {
        ShortVideoRealItemBuilder.Holder localHolder = (ShortVideoRealItemBuilder.Holder)AIOUtils.b(paramView);
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localHolder.q;
        if (paramView.getId() != 2131430626)
        {
          boolean bool2 = this.d.isVideoChatting();
          boolean bool1 = true;
          if (bool2)
          {
            QQToast.makeText(this.e, 2131893650, 1).show(this.e.getResources().getDimensionPixelSize(2131299920));
          }
          else
          {
            if (paramView.getId() == 2131430578) {
              a(localHolder, localMessageForShortVideo, false);
            }
            if (paramView.getId() == 2131430598)
            {
              if (!localHolder.q.isMultiMsg)
              {
                localObject = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(localHolder.q.frienduin, localHolder.q.uniseq);
                if (((localObject instanceof IShortVideoUploadProcessor)) && (((IShortVideoUploadProcessor)localObject).isBDHSuccess()))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator BDHSuccess!");
                  }
                }
                else
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localObject = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(localHolder.q.frienduin, localHolder.q.uniseq);
                  if ((localObject instanceof IShortVideoUploadProcessor))
                  {
                    ((BaseTransProcessor)localObject).pause();
                    localStringBuilder.append("\n shortVideoCancel uploadProcess pause!");
                  }
                  else
                  {
                    EncodeVideoTask localEncodeVideoTask = (EncodeVideoTask)EncodeVideoTask.a.remove(Long.valueOf(localHolder.q.uniseq));
                    localStringBuilder.append("\n shortVideoCancel uniseq:");
                    if (localEncodeVideoTask != null) {
                      localObject = Long.valueOf(localEncodeVideoTask.c.uniseq);
                    } else {
                      localObject = "-1";
                    }
                    localStringBuilder.append(localObject);
                    localStringBuilder.append(", msgUniseq:");
                    localStringBuilder.append(localHolder.q.uniseq);
                    localStringBuilder.append(", encodeFinish:");
                    if ((localEncodeVideoTask == null) || (!localEncodeVideoTask.d)) {
                      bool1 = false;
                    }
                    localStringBuilder.append(bool1);
                    if ((localEncodeVideoTask != null) && (localEncodeVideoTask.c.uniseq == localHolder.q.uniseq) && (localEncodeVideoTask.b()))
                    {
                      this.J.removeCallbacks(localMessageForShortVideo.progressTask);
                      localMessageForShortVideo.progressTask = null;
                      localMessageForShortVideo.videoFileStatus = 1004;
                      localMessageForShortVideo.md5 = null;
                      localMessageForShortVideo.serial();
                      this.d.getMessageFacade().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
                      ((IOrderMediaMsgService)this.d.getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                      p();
                      this.L = null;
                      G = false;
                    }
                  }
                  ShortVideoUtils.reportCancelSendVideo("0X800A7EE", this.f.a);
                  if (QLog.isColorLevel())
                  {
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("shortVideoCancel pauseOperator info:");
                    ((StringBuilder)localObject).append(localStringBuilder.toString());
                    QLog.d("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
                  }
                }
              }
            }
            else {
              super.onClick(paramView);
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder
 * JD-Core Version:    0.7.0.1
 */