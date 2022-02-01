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
  public static int a;
  protected static ColorDrawable a;
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private static Map<Long, MessageForShortVideo> jdField_a_of_type_JavaUtilMap;
  protected static CopyOnWriteArraySet<CropBubbleVideoView> a;
  private static long c;
  public static int d;
  protected static int e;
  protected static int f;
  public static boolean f;
  protected static int g;
  private static boolean g;
  protected static int h;
  private static boolean h;
  protected static int i;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ResultListener jdField_a_of_type_ComTencentMobileqqShortvideoResultListener = new ShortVideoRealItemBuilder.8(this);
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Handler b = new Handler(Looper.getMainLooper());
  
  static
  {
    URLDrawableHelper.initVideoAIOSizeByDpc();
    jdField_f_of_type_Boolean = true;
    jdField_a_of_type_Int = 960;
    d = 720;
    jdField_g_of_type_Boolean = false;
    jdField_h_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_g_of_type_Int = BaseChatItemLayout.jdField_f_of_type_Int;
    jdField_g_of_type_Int = Math.min(AIOUtils.b(320.0F, localResources), jdField_g_of_type_Int);
    jdField_h_of_type_Int = AIOUtils.b(100.0F, localResources);
    i = AIOUtils.b(100.0F, localResources);
    jdField_e_of_type_Int = AIOUtils.b(CodecParam.FINAL_DST_VIDEO_WIDTH, localResources);
    jdField_f_of_type_Int = AIOUtils.b(CodecParam.FINAL_DST_VIDEO_HEIGHT, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new EmptyDrawable(-10065297, jdField_e_of_type_Int, jdField_f_of_type_Int);
    jdField_c_of_type_Long = 0L;
  }
  
  public ShortVideoRealItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    ShortVideoUtils.loadShortVideoSo(paramQQAppInterface);
    ShortVideoUtils.ShortVideoPlayConfig.initConfig();
    h();
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doEncodeNext, curMsg:");
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if (localObject != null) {
        localObject = Long.valueOf(((MessageForShortVideo)localObject).uniseq);
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(", seq:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", contains:");
      localStringBuilder.append(EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)));
      QLog.i("ShortVideoRealItemBuilder", 2, localStringBuilder.toString());
    }
    EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if (localObject != null) {
      jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if ((localObject != null) && (((MessageForShortVideo)localObject).progressTask != null)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask = null;
    }
    jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
    if (jdField_a_of_type_JavaUtilMap.size() != 0)
    {
      localObject = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      if (((Iterator)localObject).hasNext()) {
        localObject = (MessageForShortVideo)((Map.Entry)((Iterator)localObject).next()).getValue();
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        ThreadManager.postImmediately(new ShortVideoRealItemBuilder.9(this, (MessageForShortVideo)localObject), null, true);
        jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("messageMap size:");
          localStringBuilder.append(jdField_a_of_type_JavaUtilMap.size());
          localStringBuilder.append(", [");
          localStringBuilder.append(((MessageForShortVideo)localObject).uniseq);
          localStringBuilder.append("] start upload!");
          QLog.i("ShortVideoRealItemBuilder", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  private void a(ShortVideoRealItemBuilder.Holder paramHolder, View paramView)
  {
    if (a(paramHolder))
    {
      if (paramHolder.b == null)
      {
        paramHolder.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramHolder.b.setImageResource(2130838222);
        paramHolder.b.setId(2131364540);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.b(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364521);
        localLayoutParams.addRule(0, 2131364521);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramHolder.b, localLayoutParams);
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719071, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
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
        b(paramMessageForShortVideo, paramHolder, 2131718343);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719104, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      }
      else
      {
        a(paramMessageForShortVideo, false);
        a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, false);
      }
      if (!paramMessageForShortVideo.isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
      }
    }
    else if (FileUtils.fileExistsAndNotEmpty(str))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
      if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBoolean, false, true, true, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "onClick, sdk is not installed");
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697738), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299168));
    }
  }
  
  private void a(ShortVideoRealItemBuilder.Holder paramHolder, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean)
    {
      if (paramHolder.b != null)
      {
        paramHolder.b.setVisibility(0);
        paramHolder.b.setOnClickListener(paramOnClickListener);
      }
    }
    else if (paramHolder.b != null)
    {
      paramHolder.b.setVisibility(8);
      paramHolder.b.setOnClickListener(null);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageForReplyText paramMessageForReplyText)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007429", "0X8007429", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "enterRichMediaPreview");
    }
    if (MediaPlayerManager.a(paramQQAppInterface).a()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    paramView = AnimationUtils.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.n)) {
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((BaseActivity)paramContext).getChatFragment().a().c());
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
    }
    if ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) {
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
        int j;
        paramView = paramMessageForReplyText;
      }
    }
    localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    if ((paramContext instanceof SplashActivity))
    {
      j = 1;
    }
    else
    {
      if ((paramContext instanceof ChatHistoryActivity)) {}
      while (((paramContext instanceof PublicFragmentActivity)) && ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)))
      {
        j = 2;
        break;
      }
      j = -1;
    }
    localBundle.putBoolean("muate_play", paramBoolean1);
    localBundle.putBoolean("is_one_item", paramBoolean2);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean3);
    localBundle.putBoolean(PeakUtils.jdField_a_of_type_JavaLangString, paramBoolean4);
    if ((paramMessageForShortVideo.istroop == 0) && (com.tencent.mobileqq.util.Utils.b(paramMessageForShortVideo.senderuin)) && (!TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"))))
    {
      localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
      localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), 13007, j);
    }
    else
    {
      localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), -1, j);
    }
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
    }
    ShortVideoUtils.reportVideoPlay(paramQQAppInterface, "0X8008E53", paramSessionInfo, paramMessageForShortVideo, paramContext);
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131713929));
    localStringBuilder.append(paramString2);
    a(paramMessageForShortVideo, localStringBuilder.toString());
    a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramString2, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((TroopStoryUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!AIOSingleReporter.a().a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video")))
    {
      AIOSingleReporter.a().a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video");
      StoryReportor.a("aio_msg", "play_msg_video", 0, 0, new String[] { "", "", "", TroopStoryUtil.a((MessageForShortVideo)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage) });
    }
    if (!FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      b(paramMessageForShortVideo);
      a(paramMessageForShortVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramMessageForShortVideo);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
      EncodeVideoTask.ThumbInfo localThumbInfo = new EncodeVideoTask.ThumbInfo(paramMessageForShortVideo.mThumbFilePath, paramMessageForShortVideo.thumbMD5, null, paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      localObject = new EncodeVideoTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramMessageForShortVideo.mediacodecEncode, localThumbInfo, paramMessageForShortVideo);
      EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramMessageForShortVideo.uniseq), localObject);
      ((EncodeVideoTask)localObject).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoResultListener);
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
        a(paramMessageForShortVideo, HardCodeUtil.a(2131713920));
        b(paramMessageForShortVideo, paramHolder, 2131718343);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
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
    paramCropBubbleVideoView = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
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
      b(paramMessageForShortVideo, paramHolder, 2131718348);
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
  
  private boolean a(ShortVideoRealItemBuilder.Holder paramHolder)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {
      localMessageForShortVideo = (MessageForShortVideo)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } else {
      localMessageForShortVideo = null;
    }
    boolean bool2 = false;
    if (localMessageForShortVideo == null) {
      return false;
    }
    int j;
    if ((localMessageForShortVideo.videoFileStatus != 998) && (localMessageForShortVideo.videoFileStatus != 1002) && (localMessageForShortVideo.videoFileStatus != 1001)) {
      j = 0;
    } else {
      j = 1;
    }
    int k;
    if ((!localMessageForShortVideo.isMultiMsg) && (localMessageForShortVideo.uiOperatorFlag != 2) && (localMessageForShortVideo.busiType == 1) && (localMessageForShortVideo.isSendFromLocal()) && (!paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b())) {
      k = 1;
    } else {
      k = 0;
    }
    if (QLog.isColorLevel())
    {
      paramHolder = new StringBuilder();
      paramHolder.append("shortVideoCancel needShowPauseIcon seq:");
      paramHolder.append(localMessageForShortVideo.uniseq);
      paramHolder.append(", videostatus:");
      paramHolder.append(localMessageForShortVideo.videoFileStatus);
      paramHolder.append(", iconshow:");
      if ((j != 0) && (k != 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramHolder.append(bool1);
      QLog.i("ShortVideoRealItemBuilder", 2, paramHolder.toString());
    }
    boolean bool1 = bool2;
    if (j != 0)
    {
      bool1 = bool2;
      if (k != 0) {
        bool1 = true;
      }
    }
    return bool1;
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
          paramHolder = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
          if ((paramHolder != null) && ((paramHolder.uniseq == paramMessageForShortVideo.uniseq) || (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq))))) {
            paramInt1 = 0;
          } else {
            paramInt1 = 1;
          }
          if ((!paramMessageForShortVideo.mPreUpload) && (TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramInt1 != 0) && (paramMessageForShortVideo.busiType == 1))
          {
            if (!jdField_h_of_type_Boolean)
            {
              a(paramMessageForShortVideo, null, false, true);
              return true;
            }
            if (!jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq)))
            {
              jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramMessageForShortVideo.uniseq), paramMessageForShortVideo);
              if (QLog.isColorLevel())
              {
                paramHolder = new StringBuilder();
                paramHolder.append("messageMap size:");
                paramHolder.append(jdField_a_of_type_JavaUtilMap.size());
                paramHolder.append(", [");
                paramHolder.append(paramMessageForShortVideo.uniseq);
                paramHolder.append("] added, mEncoding:");
                paramHolder.append(jdField_h_of_type_Boolean);
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
  
  private boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = (MultiRichMediaSaveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
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
  
  private void b(ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    paramHolder = new WeakReference(paramHolder);
    if (paramMessageForShortVideo.busiType == 1)
    {
      if (paramMessageForShortVideo.progressTask == null)
      {
        paramMessageForShortVideo.progressTask = new ShortVideoRealItemBuilder.1(this, paramMessageForShortVideo, paramHolder);
        this.b.removeCallbacks(paramMessageForShortVideo.progressTask);
        this.b.post(paramMessageForShortVideo.progressTask);
      }
    }
    else
    {
      if (paramMessageForShortVideo.mShowProgressTask == null) {
        paramMessageForShortVideo.mShowProgressTask = new ShortVideoRealItemBuilder.2(this, paramHolder, paramMessageForShortVideo);
      }
      this.b.removeCallbacks(paramMessageForShortVideo.mShowProgressTask);
      this.b.post(paramMessageForShortVideo.mShowProgressTask);
    }
  }
  
  private void b(ShortVideoRealItemBuilder.Holder paramHolder, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramHolder != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        a(paramHolder, false, null);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return AIOVideoPlayController.a().a(this.jdField_a_of_type_AndroidContentContext, 2, paramMessageForShortVideo.istroop);
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && ((this.jdField_a_of_type_AndroidViewViewGroup instanceof ChatXListView))) {
      return ((ChatXListView)this.jdField_a_of_type_AndroidViewViewGroup).a();
    }
    return true;
  }
  
  private void d(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.progressTask != null))
    {
      this.b.removeCallbacks(paramMessageForShortVideo.progressTask);
      paramMessageForShortVideo.progressTask = null;
    }
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "pauseAllVideo");
    }
    Object localObject = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet;
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
  
  public static void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "resumeAllVideo");
    }
    Object localObject = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet;
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
  
  public static void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "releaseAllVideo");
    }
    Object localObject = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArraySet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)((Iterator)localObject).next();
        if (localCropBubbleVideoView != null)
        {
          localCropBubbleVideoView.releasePlayer(false);
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localCropBubbleVideoView);
        }
      }
    }
  }
  
  private void h()
  {
    if (!jdField_g_of_type_Boolean)
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
            jdField_f_of_type_Boolean = localObject[0].equals("1");
          }
          bool = TextUtils.isEmpty(localObject[1]);
          k = 720;
          j = k;
          if (bool) {}
        }
      }
    }
    try
    {
      j = Integer.parseInt(localObject[1]);
    }
    catch (Exception localException2)
    {
      try
      {
        k = Integer.parseInt(localObject[2]);
        jdField_a_of_type_Int = Math.max(j, k);
        d = Math.min(j, k);
        jdField_g_of_type_Boolean = true;
        if (!QLog.isColorLevel()) {
          break label302;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initVideoHDConfig(), sReadHDConfig=");
        ((StringBuilder)localObject).append(jdField_g_of_type_Boolean);
        ((StringBuilder)localObject).append(", sHDEnable:");
        ((StringBuilder)localObject).append(jdField_f_of_type_Boolean);
        ((StringBuilder)localObject).append(", sHDMaxLength:");
        ((StringBuilder)localObject).append(jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(", sHDMinLength:");
        ((StringBuilder)localObject).append(d);
        QLog.d("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
        return;
        localException2 = localException2;
        j = k;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          int m;
          k = m;
        }
      }
    }
    boolean bool = TextUtils.isEmpty(localObject[2]);
    m = 540;
    k = m;
    if (bool) {}
  }
  
  private void i()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)))
      {
        Object localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if (localObject != null) {
            ((BaseChatPie)localObject).a(false, false);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
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
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = ((Context)localObject1).getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramViewHolder = ShortVideoUtils.adjustSize(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
    int m = paramViewHolder[0];
    int j = paramViewHolder[1];
    boolean bool = localMessageForShortVideo.isSend();
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout((Context)localObject1);
      paramView = (CropBubbleVideoView)QQVideoViewFactory.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.uniseq, null, bool);
      paramView.setId(2131362339);
      paramView.setVisibility(0);
      paramView.setContentDescription(HardCodeUtil.a(2131713953));
      paramViewHolder.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject1);
      paramViewHolder.addView(localMessageProgressView);
      ImageView localImageView = new ImageView((Context)localObject1);
      localImageView.setImageResource(2130838002);
      localImageView.setVisibility(8);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131362339);
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131362339);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.b(10.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(10.0F, localResources);
      paramViewHolder.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
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
      ((TextView)localObject1).setId(2131364565);
      ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      paramViewHolder.setOnClickListener(this);
      super.a(paramViewHolder, paramOnLongClickAndTouchListener);
      localHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = paramView;
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      localHolder.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    }
    else
    {
      paramViewHolder = paramView;
    }
    paramView = localHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView;
    if (jdField_e_of_type_Boolean) {
      paramView.setContentDescription(HardCodeUtil.a(2131713915));
    }
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    paramView.mIsSend = localMessageForShortVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForShortVideo.uniseq));
    AIOSingleReporter.a().a(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    a(localHolder, localMessageForShortVideo);
    paramOnLongClickAndTouchListener = localHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getLayoutParams();
    if (paramOnLongClickAndTouchListener == null)
    {
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(m, j);
      localHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramOnLongClickAndTouchListener);
    }
    else
    {
      int k = j;
      if ((paramOnLongClickAndTouchListener.width != m) || (paramOnLongClickAndTouchListener.height != k))
      {
        paramOnLongClickAndTouchListener.width = m;
        paramOnLongClickAndTouchListener.height = k;
        localHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramOnLongClickAndTouchListener);
      }
    }
    paramOnLongClickAndTouchListener = localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
    if (paramOnLongClickAndTouchListener == null)
    {
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(m, j);
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramOnLongClickAndTouchListener);
    }
    else if ((paramOnLongClickAndTouchListener.width != m) || (paramOnLongClickAndTouchListener.height != j))
    {
      paramOnLongClickAndTouchListener.width = m;
      paramOnLongClickAndTouchListener.height = j;
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramOnLongClickAndTouchListener);
    }
    if (paramBaseChatItemLayout != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
      if ((!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n)) {
        a(paramBaseChatItemLayout, localHolder, paramChatMessage);
      }
    }
    a(localMessageForShortVideo);
    a(localMessageForShortVideo, localHolder, localResources, bool);
    if (a(localHolder, localMessageForShortVideo, m, j, paramView)) {
      return paramViewHolder;
    }
    paramChatMessage = SVUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
    paramBaseChatItemLayout = SVUtils.a(localMessageForShortVideo, "mp4");
    bool = b(localMessageForShortVideo);
    if ((bool) && (FileUtils.fileExistsAndNotEmpty(paramBaseChatItemLayout)) && ((!localMessageForShortVideo.isSendFromLocal()) || (localMessageForShortVideo.videoFileStatus == 1003) || (localMessageForShortVideo.videoFileStatus == 2003) || (localMessageForShortVideo.isMultiMsg == true)))
    {
      a(localMessageForShortVideo, localHolder, paramChatMessage, paramBaseChatItemLayout, m, j);
      return paramViewHolder;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramChatMessage))
    {
      a(bool, paramView, localMessageForShortVideo, localHolder, paramChatMessage, paramBaseChatItemLayout, m, j);
      return paramViewHolder;
    }
    if (localMessageForShortVideo.videoFileStatus == 5002)
    {
      a(localMessageForShortVideo, HardCodeUtil.a(2131713946));
      paramView.setID(localMessageForShortVideo.uniseq);
      paramView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(localMessageForShortVideo, localHolder, 2131718343);
      return paramViewHolder;
    }
    a(localMessageForShortVideo, HardCodeUtil.a(2131713967));
    paramView.setID(localMessageForShortVideo.uniseq);
    paramView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    b(localMessageForShortVideo);
    return paramViewHolder;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoRealItemBuilder.Holder(this);
  }
  
  public ShortVideoRealItemBuilder.Holder a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetListView;
    if ((localObject != null) && (paramLong > 0L))
    {
      int j = AIOUtils.a(paramLong, ((ListView)localObject).getAdapter());
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (j > -1)
      {
        localObject = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, j);
        if (localObject != null)
        {
          localObject = AIOUtils.a((View)localObject);
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
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(", view = null");
          QLog.w("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getHolderByMsg() uniseq=");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(", posi =");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(", firstVisblePosi=");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(",lastVisblePosi=");
          ((StringBuilder)localObject).append(n);
          ((StringBuilder)localObject).append(",headerCount=");
          ((StringBuilder)localObject).append(k);
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
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371660, null, null);
    boolean bool = TextUtils.isEmpty(paramChatMessage.md5);
    int k = 1;
    if ((!bool) && ((!paramChatMessage.mPreUpload) || (!TextUtils.isEmpty(paramChatMessage.mLocalMd5))))
    {
      String str = SVUtils.a(paramChatMessage.thumbMD5, "jpg");
      paramChatMessage = SVUtils.a(paramChatMessage, "mp4");
      if (FileUtils.fileExistsAndNotEmpty(str))
      {
        if ((paramBaseHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView != null) && (paramBaseHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
          j = 1;
        } else {
          j = 0;
        }
        if (j == 0)
        {
          paramQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
          if (FileUtils.fileExistsAndNotEmpty(paramChatMessage))
          {
            j = k;
            break label160;
          }
        }
      }
    }
    int j = 0;
    label160:
    if (j != 0) {
      paramQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131692184), 2130838911);
    }
    return paramQQCustomMenu;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131713968);
  }
  
  protected String a(MessageForShortVideo paramMessageForShortVideo)
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
  
  public void a()
  {
    super.a();
    Object localObject1 = jdField_a_of_type_JavaUtilMap.values().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageForShortVideo)((Iterator)localObject1).next();
      if (((MessageForShortVideo)localObject2).progressTask != null) {
        ((MessageForShortVideo)localObject2).progressTask = null;
      }
    }
    localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet;
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
            MessageForShortVideo localMessageForShortVideo = AIOSingleReporter.a().a(Integer.valueOf(((CropBubbleVideoView)localObject2).getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l);
            }
          }
          ((CropBubbleVideoView)localObject2).releasePlayer(false);
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localObject2);
        }
      }
    }
    jdField_a_of_type_JavaUtilMap.clear();
    this.b.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidContentContext = null;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if ((localObject1 != null) && (((MessageForShortVideo)localObject1).progressTask != null)) {
      ((MessageForShortVideo)localObject1).progressTask = null;
    }
    this.jdField_a_of_type_ComTencentWidgetListView = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt == 2131365480)
      {
        ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
        StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
        return;
      }
      if (paramInt == 2131371603)
      {
        super.a(paramInt, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
        StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
        return;
      }
      if (paramInt == 2131367180)
      {
        paramInt = ((IPicPreDownload)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).calcUinType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
        if (paramInt == 3) {
          paramContext = "1";
        } else if (paramInt == 2) {
          paramContext = "2";
        } else if (paramInt == 0) {
          paramContext = "3";
        } else {
          paramContext = "4";
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
        StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "1", "", "", "" });
        c(localMessageForShortVideo);
        if (paramChatMessage.isMultiMsg) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 5, 0, "5", "", "", "");
        }
      }
      else if (paramInt == 2131366494)
      {
        QfavBuilder.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
        StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
        if (paramChatMessage.isMultiMsg) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 5, 0, "5", "", "", "");
        }
      }
      else
      {
        if (paramInt == 2131371562)
        {
          super.a(2131371562, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo);
          StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
          return;
        }
        if (paramInt == 2131365442)
        {
          paramContext = new StringBuilder();
          paramContext.append("uniseq:");
          paramContext.append(localMessageForShortVideo.uniseq);
          paramContext.append("\n");
          Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
          return;
        }
        if (paramInt == 2131371660)
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
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.addButton(2131689933, 5);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new ShortVideoRealItemBuilder.5(this, localMessageForShortVideo, paramView, localActionSheet));
    localActionSheet.show();
    if (localMessageForShortVideo.videoFileStatus == 1004) {
      ShortVideoUtils.reportCancelSendVideo("0X800A7EF", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296386);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.jdField_h_of_type_Int, j, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(j, BaseChatItemLayout.jdField_h_of_type_Int, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, ShortVideoRealItemBuilder.Holder paramHolder, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      if (paramHolder.jdField_e_of_type_Int == 0) {
        return;
      }
      paramHolder.jdField_e_of_type_Int = 0;
      paramBaseChatItemLayout.setTailMessage(false, null, null);
    }
  }
  
  protected void a(ShortVideoRealItemBuilder.Holder paramHolder)
  {
    MessageProgressView localMessageProgressView = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
    localStringBuilder.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    if (!localMessageProgressView.a(localStringBuilder.toString())) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    } else {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new ShortVideoRealItemBuilder.6(this, paramHolder));
    }
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[hideProgress] set mProgressView gone");
    }
  }
  
  protected void a(ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(paramMessageForShortVideo.isSend());
    MessageProgressView localMessageProgressView = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localMessageProgressView.a(localStringBuilder.toString());
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9) || (paramMessageForShortVideo.fileType == 20))
    {
      if ((paramMessageForShortVideo.videoFileStatus != 1003) && (paramMessageForShortVideo.videoFileStatus != 2003))
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        return;
      }
      b(paramHolder);
    }
  }
  
  public void a(ShortVideoRealItemBuilder.Holder paramHolder, String paramString, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    if ((FileUtils.fileExistsAndNotEmpty(paramString)) && (a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramString)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      ColorDrawable localColorDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      paramString = URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
      paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramString);
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8007428"))
    {
      AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8007428");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007428", "0X8007428", 0, 0, "", "", "", "");
    }
    if ((paramMessageForShortVideo.checkIsHotVideo()) && (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8007EDB")))
    {
      AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8007EDB");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.reportVideoPlayEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForShortVideo.frienduin, 1, 2, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719110, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!FileUtils.fileExistsAndNotEmpty(str))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719111, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsgStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    localObject = SVBusiUtil.a(1, 2);
    ((ShortVideoReq)localObject).a(ShortVideoBusiManager.a(2, paramMessageForShortVideo, (ShortVideoReq)localObject));
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, true);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt)
  {
    int j = ShortVideoUtils.getDisplayProgress(paramInt, 10);
    if (paramMessageForShortVideo.busiType == 1)
    {
      if (j < 60) {
        return;
      }
      if (paramMessageForShortVideo.progressTask != null)
      {
        this.b.removeCallbacks(paramMessageForShortVideo.progressTask);
        paramMessageForShortVideo.progressTask = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VIDEO STATUS_SEND_PROCESS CLOSE_TASK PROCESS:");
        localStringBuilder.append(j);
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
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      MessageProgressView localMessageProgressView = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageForShortVideo.frienduin);
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      localMessageProgressView.setAnimProgress(paramInt2, localStringBuilder.toString());
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((paramMessageForShortVideo.progressTask != null) && (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)))
      {
        paramMessageForShortVideo.progress += 3;
        this.b.postDelayed(paramMessageForShortVideo.progressTask, 1000L);
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
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    MessageProgressView localMessageProgressView = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localMessageProgressView.setAnimProgress(paramInt, localStringBuilder.toString());
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
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
    int j = Math.max(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    int k = Math.min(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    if ((jdField_f_of_type_Boolean) && (j >= jdField_a_of_type_Int) && (k >= d))
    {
      paramMessageForShortVideo = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramBoolean) {
        paramMessageForShortVideo.rightMargin = AIOUtils.b(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth() + 8.0F, paramResources);
      } else {
        paramMessageForShortVideo.rightMargin = AIOUtils.b(8.0F, paramResources);
      }
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, HardCodeUtil.a(2131713927));
      return;
    }
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(2, 2);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
    localShortVideoDownloadInfo.h = SVUtils.a(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 0);
    int j;
    if (paramBoolean) {
      j = 2;
    } else {
      j = 1;
    }
    localShortVideoDownloadInfo.jdField_f_of_type_Int = j;
    localShortVideoDownloadInfo.jdField_g_of_type_Int = 2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" startDownloadVideo downloadvideo fileType==");
      localStringBuilder.append(localShortVideoDownloadInfo.jdField_e_of_type_Int);
      localStringBuilder.append(", uniseq:");
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      QLog.d("ShortVideoRealItemBuilder", 2, localStringBuilder.toString());
    }
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(FileMsg paramFileMsg, ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramFileMsg.status;
    if (j != 1007)
    {
      if (j != 5001)
      {
        if (j != 5002)
        {
          Object localObject;
          switch (j)
          {
          default: 
            switch (j)
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
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719105, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
              return;
            case 2004: 
              a(paramMessageForShortVideo, "VIDEO STATUS_RECV_CANCEL");
              return;
            case 2003: 
              paramFileMsg = new StringBuilder();
              paramFileMsg.append("VIDEO STATUS_RECV_FINISHED , getAIOState() = ");
              paramFileMsg.append(a());
              a(paramMessageForShortVideo, paramFileMsg.toString());
              if ((b(paramMessageForShortVideo)) && (a() == 4))
              {
                paramFileMsg = SVUtils.a(paramMessageForShortVideo, "mp4");
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(HardCodeUtil.a(2131713950));
                ((StringBuilder)localObject).append(paramFileMsg);
                a(paramMessageForShortVideo, ((StringBuilder)localObject).toString());
                if ((ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.fileExistsAndNotEmpty(paramFileMsg)))
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(HardCodeUtil.a(2131713962));
                  ((StringBuilder)localObject).append(paramFileMsg);
                  a(paramMessageForShortVideo, ((StringBuilder)localObject).toString());
                  localObject = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
                  a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramFileMsg, (String)localObject, paramMessageForShortVideo, paramInt1, paramInt2);
                  if (!paramMessageForShortVideo.isSend()) {
                    new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
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
            d(paramMessageForShortVideo);
            b(paramMessageForShortVideo, paramHolder, 2131718348);
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
            return;
          case 1004: 
            a(paramMessageForShortVideo, "VIDEO STATUS_SEND_CANCEL");
            paramFileMsg = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
            ((StringBuilder)localObject).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            paramFileMsg.b(((StringBuilder)localObject).toString());
            d(paramMessageForShortVideo);
            a(paramHolder);
            b(paramMessageForShortVideo, paramHolder, 2131718348);
            b(paramHolder, true, this);
            EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
            return;
          case 1003: 
            a(paramMessageForShortVideo, "VIDEO STATUS_SEND_FINISHED");
            d(paramMessageForShortVideo);
            a(paramMessageForShortVideo.mVideoFileSourceDir);
            a(paramMessageForShortVideo, paramHolder, 100, true);
            a(paramHolder, false, null);
            EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
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
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
            EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
            return;
          }
        }
        else
        {
          a(paramMessageForShortVideo, "VIDEO STATUS_FILE_EXPIRED");
          a(paramHolder, SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
          b(paramMessageForShortVideo, paramHolder, 2131718343);
        }
      }
      else
      {
        a(paramMessageForShortVideo, "VIDEO STATUS_FILE_UNSAFE");
        b(paramMessageForShortVideo, paramHolder, 2131718342);
        if (paramMessageForShortVideo.uiOperatorFlag == 2)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719079, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719103, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      }
    }
    else
    {
      a(paramHolder, false, null);
      EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
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
    ((VideoPlayParam)localObject).mSceneName = SceneID.a(100);
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
    if (c()) {
      paramCropBubbleVideoView.play();
    }
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramCropBubbleVideoView);
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
    paramBaseChatItemLayout = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
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
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo != null) {
      if (localMessageForShortVideo.isMultiMsg) {
        a(localQQCustomMenu, localMessageForShortVideo, paramView);
      } else {
        b(localQQCustomMenu, localMessageForShortVideo, paramView);
      }
    }
    return localQQCustomMenu.a();
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramBaseHolder = (ShortVideoRealItemBuilder.Holder)paramBaseHolder;
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371660, null, null);
    if ((!TextUtils.isEmpty(paramChatMessage.md5)) && ((!paramChatMessage.mPreUpload) || (!TextUtils.isEmpty(paramChatMessage.mLocalMd5))))
    {
      Object localObject = SVUtils.a(paramChatMessage.thumbMD5, "jpg");
      String str = SVUtils.a(paramChatMessage, "mp4");
      if (FileUtils.fileExistsAndNotEmpty((String)localObject))
      {
        localObject = paramBaseHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView;
        int k = 1;
        int m;
        if ((localObject != null) && (paramBaseHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
          m = 1;
        } else {
          m = 0;
        }
        int j;
        if (m == 0)
        {
          paramQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
          a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramChatMessage, null);
          if (FileUtils.fileExistsAndNotEmpty(str)) {
            j = 1;
          } else {
            j = 0;
          }
        }
        else
        {
          j = 0;
          k = 0;
        }
        i1 = j;
        n = k;
        if (m != 0) {
          break label234;
        }
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, paramChatMessage, new Bundle());
        i1 = j;
        n = k;
        break label234;
      }
    }
    int i1 = 0;
    int n = 0;
    label234:
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, paramChatMessage, new Bundle());
    if (i1 != 0) {
      paramQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131692184), 2130838911);
    }
    paramBaseHolder = new Bundle();
    paramBaseHolder.putBoolean("isSearch", false);
    super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380215, paramChatMessage, paramBaseHolder);
    if (n != 0) {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramChatMessage, null);
    }
    super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return paramQQCustomMenu;
  }
  
  protected void b(ShortVideoRealItemBuilder.Holder paramHolder)
  {
    MessageProgressView localMessageProgressView = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
    localStringBuilder.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    if (!localMessageProgressView.a(localStringBuilder.toString())) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    } else {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new ShortVideoRealItemBuilder.7(this, paramHolder));
    }
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[disProgress] set mProgressView gone");
    }
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (a(paramMessageForShortVideo)) {
      return;
    }
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(2, 2);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
    localShortVideoDownloadInfo.i = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
    localShortVideoDownloadInfo.jdField_f_of_type_Int = 2;
    localShortVideoDownloadInfo.jdField_g_of_type_Int = 2;
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719111, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsgStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      paramHolder = SVBusiUtil.a(4, 2);
      paramHolder.a(ShortVideoBusiManager.a(2, paramMessageForShortVideo, paramHolder));
      ShortVideoBusiManager.a(paramHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    a(paramMessageForShortVideo, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt)
  {
    MessageProgressView localMessageProgressView = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localMessageProgressView.b(localStringBuilder.toString());
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130850097);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showWarnProgress] set mProgressView visible");
    }
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void b(FileMsg paramFileMsg, ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramFileMsg.status;
    if (j != 2001)
    {
      if (j != 2003)
      {
        if (j != 2005)
        {
          if (j != 5002) {
            return;
          }
          a(paramMessageForShortVideo, "THUMB STATUS_FILE_EXPIRED");
        }
        a(paramMessageForShortVideo, "THUMB STATUS_RECV_ERROR");
        paramFileMsg = SVUtils.a(paramMessageForShortVideo, "mp4");
        if (FileUtils.fileExistsAndNotEmpty(paramFileMsg))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131713907));
          ((StringBuilder)localObject).append(paramFileMsg);
          a(paramMessageForShortVideo, ((StringBuilder)localObject).toString());
          if (ShortVideoUtils.isVideoSoLibLoaded())
          {
            localObject = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
            a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramFileMsg, (String)localObject, paramMessageForShortVideo, paramInt1, paramInt2);
          }
        }
        else
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
          paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        }
        a(paramHolder);
        return;
      }
      a(paramMessageForShortVideo, "THUMB STATUS_RECV_FINISHED");
      paramFileMsg = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      Object localObject = SVUtils.a(paramMessageForShortVideo, "mp4");
      StringBuilder localStringBuilder;
      if ((FileUtils.fileExistsAndNotEmpty((String)localObject)) && (b(paramMessageForShortVideo)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131713922));
        localStringBuilder.append(paramFileMsg);
        a(paramMessageForShortVideo, localStringBuilder.toString());
        if (ShortVideoUtils.isVideoSoLibLoaded()) {
          a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, (String)localObject, paramFileMsg, paramMessageForShortVideo, paramInt1, paramInt2);
        }
      }
      else
      {
        a(paramHolder, paramFileMsg, paramMessageForShortVideo, paramInt3, paramInt4);
        if (FileUtils.fileExistsAndNotEmpty(paramFileMsg))
        {
          if (a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramFileMsg))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(2131713910));
            localStringBuilder.append(paramFileMsg);
            a(paramMessageForShortVideo, localStringBuilder.toString());
            if (!FileUtils.fileExistsAndNotEmpty((String)localObject))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
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
          paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
          paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(URLDrawableHelper.getFailedDrawable());
        }
      }
    }
    else
    {
      a(paramMessageForShortVideo, "THUMB STATUS_RECV_START");
    }
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
    localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putInt("selection_mode", this.jdField_c_of_type_Int);
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
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
    }
  }
  
  void c(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder)
  {
    MessageProgressView localMessageProgressView = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localMessageProgressView.b(localStringBuilder.toString());
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.a(paramView);
    if (!(paramView instanceof ShortVideoRealItemBuilder.Holder)) {
      return;
    }
    paramView = (ShortVideoRealItemBuilder.Holder)paramView;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.uniseq != paramFileMsg.uniseq) {
      return;
    }
    this.b.removeCallbacks(localMessageForShortVideo.mShowProgressTask);
    if (localMessageForShortVideo.mShowProgressTask != null) {
      localMessageForShortVideo.mShowProgressTask = null;
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
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
    int j = AIOUtils.b(paramInt1, localResources);
    int k = AIOUtils.b(paramInt2, localResources);
    if ((paramFileMsg.fileType != 6) && (paramFileMsg.fileType != 17) && (paramFileMsg.fileType != 9) && (paramFileMsg.fileType != 20))
    {
      if ((paramFileMsg.fileType == 7) || (paramFileMsg.fileType == 18) || (paramFileMsg.fileType == 16)) {
        b(paramFileMsg, paramView, localMessageForShortVideo, paramInt1, paramInt2, j, k);
      }
    }
    else {
      a(paramFileMsg, paramView, localMessageForShortVideo, paramInt1, paramInt2, j, k);
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    long l2 = jdField_c_of_type_Long;
    if ((l1 - l2 < 500L) && (l1 > l2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoRealItemBuilder", 2, "click too offen, please try again later!");
      }
    }
    else
    {
      jdField_c_of_type_Long = l1;
      Object localObject;
      if (paramView.getId() == 2131364549)
      {
        localObject = (MessageRecord)paramView.getTag();
        if (localObject != null) {
          ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(paramView.getContext(), (MessageRecord)localObject);
        }
      }
      else
      {
        ShortVideoRealItemBuilder.Holder localHolder = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (paramView.getId() != 2131364567)
        {
          boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting();
          boolean bool1 = true;
          if (bool2)
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695889, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
          }
          else
          {
            if (paramView.getId() == 2131364521) {
              a(localHolder, localMessageForShortVideo, false);
            }
            if (paramView.getId() == 2131364540)
            {
              if (!localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg)
              {
                localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
                if (((localObject instanceof IShortVideoUploadProcessor)) && (((IShortVideoUploadProcessor)localObject).isBDHSuccess()))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator BDHSuccess!");
                  }
                }
                else
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
                  if ((localObject instanceof IShortVideoUploadProcessor))
                  {
                    ((BaseTransProcessor)localObject).pause();
                    localStringBuilder.append("\n shortVideoCancel uploadProcess pause!");
                  }
                  else
                  {
                    EncodeVideoTask localEncodeVideoTask = (EncodeVideoTask)EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
                    localStringBuilder.append("\n shortVideoCancel uniseq:");
                    if (localEncodeVideoTask != null) {
                      localObject = Long.valueOf(localEncodeVideoTask.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
                    } else {
                      localObject = "-1";
                    }
                    localStringBuilder.append(localObject);
                    localStringBuilder.append(", msgUniseq:");
                    localStringBuilder.append(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
                    localStringBuilder.append(", encodeFinish:");
                    if ((localEncodeVideoTask == null) || (!localEncodeVideoTask.jdField_a_of_type_Boolean)) {
                      bool1 = false;
                    }
                    localStringBuilder.append(bool1);
                    if ((localEncodeVideoTask != null) && (localEncodeVideoTask.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq == localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localEncodeVideoTask.a()))
                    {
                      this.b.removeCallbacks(localMessageForShortVideo.progressTask);
                      localMessageForShortVideo.progressTask = null;
                      localMessageForShortVideo.videoFileStatus = 1004;
                      localMessageForShortVideo.md5 = null;
                      localMessageForShortVideo.serial();
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
                      ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                      i();
                      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
                      jdField_h_of_type_Boolean = false;
                    }
                  }
                  ShortVideoUtils.reportCancelSendVideo("0X800A7EE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder
 * JD-Core Version:    0.7.0.1
 */