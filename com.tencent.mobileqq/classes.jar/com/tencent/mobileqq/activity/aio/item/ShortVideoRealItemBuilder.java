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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;
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
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
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
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener, ContextMenuBuilder2, FileTransferManager.Callback, ShortVideoConstants
{
  protected static ColorDrawable a;
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private static Map<Long, MessageForShortVideo> jdField_a_of_type_JavaUtilMap;
  protected static CopyOnWriteArraySet<CropBubbleVideoView> a;
  public static int c;
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
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = new ShortVideoRealItemBuilder.8(this);
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Handler b;
  
  static
  {
    URLDrawableHelper.initVideoAIOSizeByDpc();
    jdField_f_of_type_Boolean = true;
    jdField_c_of_type_Int = 960;
    d = 720;
    jdField_g_of_type_Boolean = false;
    jdField_h_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_g_of_type_Int = BaseChatItemLayout.jdField_f_of_type_Int;
    jdField_g_of_type_Int = Math.min(AIOUtils.a(320.0F, localResources), jdField_g_of_type_Int);
    jdField_h_of_type_Int = AIOUtils.a(100.0F, localResources);
    i = AIOUtils.a(100.0F, localResources);
    jdField_e_of_type_Int = AIOUtils.a(CodecParam.FINAL_DST_VIDEO_WIDTH, localResources);
    jdField_f_of_type_Int = AIOUtils.a(CodecParam.FINAL_DST_VIDEO_HEIGHT, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new EmptyDrawable(-10065297, jdField_e_of_type_Int, jdField_f_of_type_Int);
    jdField_c_of_type_Long = 0L;
  }
  
  public ShortVideoRealItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doEncodeNext, curMsg:");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
      {
        localObject = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        QLog.i("ShortVideoRealItemBuilder", 2, localObject + ", seq:" + paramLong + ", contains:" + EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)));
      }
    }
    else
    {
      EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
        jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask = null;
      }
      jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
      if (jdField_a_of_type_JavaUtilMap.size() != 0)
      {
        localObject = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label303;
        }
      }
    }
    label303:
    for (Object localObject = (MessageForShortVideo)((Map.Entry)((Iterator)localObject).next()).getValue();; localObject = null)
    {
      if (localObject != null)
      {
        ThreadManager.postImmediately(new ShortVideoRealItemBuilder.9(this, (MessageForShortVideo)localObject), null, true);
        jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + jdField_a_of_type_JavaUtilMap.size() + ", [" + ((MessageForShortVideo)localObject).uniseq + "] start upload!");
        }
      }
      return;
      localObject = "";
      break;
    }
  }
  
  private void a(ShortVideoRealItemBuilder.Holder paramHolder, View paramView)
  {
    if (a(paramHolder))
    {
      if (paramHolder.b == null)
      {
        paramHolder.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramHolder.b.setImageResource(2130838392);
        paramHolder.b.setId(2131364653);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364634);
        localLayoutParams.addRule(0, 2131364634);
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
    if (paramMessageForShortVideo.md5 == null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719353, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
    }
    String str;
    do
    {
      for (;;)
      {
        return;
        if (paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          RedBagVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
        }
        FlowCameraMqqAction.b("", "0X8006A1C");
        StoryReportor.a("story_grp", "aio_msg", 0, 0, new String[] { "", "", "", "" });
        str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
        if (FileUtils.b(ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4"))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "onClick, video file not exist");
        }
        if (paramMessageForShortVideo.videoFileStatus == 5002)
        {
          b(paramMessageForShortVideo, paramHolder, 2131718625);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719386, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
        }
        while (!paramMessageForShortVideo.isSend())
        {
          new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
          return;
          a(paramMessageForShortVideo, false);
          a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, false);
        }
      }
    } while (!FileUtils.b(str));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBoolean, false, true, true, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onClick, sdk is not installed");
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697732), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299166));
  }
  
  private void a(ShortVideoRealItemBuilder.Holder paramHolder, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramHolder.b != null)
      {
        paramHolder.b.setVisibility(0);
        paramHolder.b.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramHolder.b == null) {
      return;
    }
    paramHolder.b.setVisibility(8);
    paramHolder.b.setOnClickListener(null);
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
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().g());
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000))
    {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      if (paramMessageForReplyText == null) {
        break label575;
      }
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
      label230:
      localBundle.putLong("click_video_bubble_time", System.currentTimeMillis());
      paramView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramView.hasNext())
      {
        paramMessageForReplyText = (ActivityManager.RunningAppProcessInfo)paramView.next();
        if (paramMessageForReplyText.processName.endsWith("mobileqq")) {
          localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", paramMessageForReplyText.pid);
        }
      }
      paramView = paramMessageForShortVideo.selfuin;
      if (!paramMessageForShortVideo.isMultiMsg) {
        break label684;
      }
    }
    label684:
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        paramMessageForReplyText = paramView;
        if ((localAppRuntime instanceof QQAppInterface)) {
          paramMessageForReplyText = localAppRuntime.getAccount();
        }
        paramView = paramMessageForReplyText;
      }
      catch (Exception paramMessageForReplyText)
      {
        int k;
        label575:
        continue;
        if (!(paramContext instanceof ChatHistoryActivity)) {
          continue;
        }
        int j = 2;
        continue;
        j = k;
        if (!(paramContext instanceof PublicFragmentActivity)) {
          continue;
        }
        j = k;
        if (!(((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
          continue;
        }
        j = 2;
        continue;
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), -1, j);
        continue;
      }
      localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      localBundle.putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      k = -1;
      if ((paramContext instanceof SplashActivity))
      {
        j = 1;
        localBundle.putBoolean("muate_play", paramBoolean1);
        localBundle.putBoolean("is_one_item", paramBoolean2);
        localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean3);
        localBundle.putBoolean(PeakUtils.b, paramBoolean4);
        if ((paramMessageForShortVideo.istroop != 0) || (!com.tencent.mobileqq.util.Utils.b(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), 13007, j);
        if (!paramMessageForShortVideo.isSend()) {
          new DCShortVideo(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
        }
        ShortVideoUtils.reportVideoPlay(paramQQAppInterface, "0X8008E53", paramSessionInfo, paramMessageForShortVideo, paramContext);
        return;
        localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
        break;
        localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
        break label230;
      }
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
    }
    a(paramMessageForShortVideo, HardCodeUtil.a(2131713998) + paramString2);
    a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramString2, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((TroopStoryUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!AIOSingleReporter.a().a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video")))
    {
      AIOSingleReporter.a().a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video");
      StoryReportor.a("aio_msg", "play_msg_video", 0, 0, new String[] { "", "", "", TroopStoryUtil.a((MessageForShortVideo)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage) });
    }
    if (!FileUtils.b(paramString1))
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
      ((EncodeVideoTask)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener);
      ((EncodeVideoTask)localObject).a(false);
      com.tencent.image.Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
      ThreadManager.getUIHandler().post(new ShortVideoRealItemBuilder.10(this, paramBoolean1, paramHolder, paramMessageForShortVideo, paramBoolean2));
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramMessageRecord = "ShortVideoRealItemBuilder" + "[" + paramMessageRecord.uniseq + "]";
      QLog.i("ShortVideoRealItemBuilder", 2, paramMessageRecord + ":content " + paramString);
    }
  }
  
  private void a(boolean paramBoolean, CropBubbleVideoView paramCropBubbleVideoView, MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramHolder, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((FileUtils.b(paramString2)) || ((paramMessageForShortVideo.isSend()) && (paramMessageForShortVideo.md5 == null) && (paramMessageForShortVideo.videoFileStatus == 1004))) {
      if ((paramMessageForShortVideo.videoFileStatus != 1005) && (paramMessageForShortVideo.extraflag != 32768) && (paramMessageForShortVideo.videoFileStatus != 1004)) {
        break label400;
      }
    }
    label400:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
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
      if (paramInt2 != 0) {
        b(paramMessageForShortVideo, paramHolder, 2131718630);
      }
      do
      {
        return;
        if ((!ShortVideoUtils.isVideoSoLibLoaded()) || (!paramBoolean))
        {
          c(paramMessageForShortVideo, paramHolder);
          return;
        }
      } while (paramMessageForShortVideo.videoFileStatus == 1003);
      if (ShortVideoUtils.getDisplayProgress(paramMessageForShortVideo.videoFileProgress, 10) <= 60) {}
      for (paramInt1 = 1; (paramMessageForShortVideo.busiType == 1) && (paramInt1 != 0); paramInt1 = 0)
      {
        if (paramMessageForShortVideo.progress > 60) {
          paramMessageForShortVideo.progress = 60;
        }
        a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, paramMessageForShortVideo.progress);
        return;
      }
      a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, false);
      return;
      if (paramMessageForShortVideo.videoFileStatus == 2005) {
        c(paramMessageForShortVideo, paramHolder);
      }
      if (paramMessageForShortVideo.videoFileStatus == 5002)
      {
        a(paramMessageForShortVideo, HardCodeUtil.a(2131713989));
        b(paramMessageForShortVideo, paramHolder, 2131718625);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
      {
        a(paramMessageForShortVideo, true);
        return;
      }
      if ((paramMessageForShortVideo.videoFileStatus == 2001) || (paramMessageForShortVideo.videoFileStatus == 2002) || (paramMessageForShortVideo.videoFileStatus == 2000))
      {
        a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, false);
        return;
      }
      c(paramMessageForShortVideo, paramHolder);
      return;
    }
  }
  
  private boolean a(ShortVideoRealItemBuilder.Holder paramHolder)
  {
    boolean bool2 = true;
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int j;
      int k;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        j = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 1) || (!localMessageForShortVideo.isSendFromLocal()) || (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.e())) {
          break label204;
        }
        k = 1;
        label110:
        if (QLog.isColorLevel())
        {
          paramHolder = new StringBuilder().append("shortVideoCancel needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
          if ((j == 0) || (k == 0)) {
            break label209;
          }
          bool1 = true;
          QLog.i("ShortVideoRealItemBuilder", 2, bool1);
        }
        label169:
        if ((j == 0) || (k == 0)) {
          break label215;
        }
      }
      label204:
      label209:
      label215:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        return bool1;
        j = 0;
        break;
        k = 0;
        break label110;
        bool1 = false;
        break label169;
      }
    }
  }
  
  private boolean a(ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, CropBubbleVideoView paramCropBubbleVideoView)
  {
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramMessageForShortVideo.videoFileStatus != 1005) && (paramMessageForShortVideo.extraflag != 32768) && (paramMessageForShortVideo.videoFileStatus != 1004))
    {
      String str1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        String str2 = paramMessageForShortVideo.mThumbFilePath;
        str1 = str2;
        if (FileUtils.b(str2)) {
          break label119;
        }
        if (!TextUtils.isEmpty(paramMessageForShortVideo.thumbMD5)) {
          break label107;
        }
        paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
        paramCropBubbleVideoView.showCover(URLDrawableHelper.getFailedDrawable());
        a(paramHolder);
        a(paramMessageForShortVideo, "getBubbleView():You must get thumb before send video.");
      }
      label107:
      label119:
      do
      {
        do
        {
          for (;;)
          {
            return true;
            str1 = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
            if (a(paramCropBubbleVideoView, str1))
            {
              a(paramHolder, str1, paramMessageForShortVideo, paramInt1, paramInt2);
              b(paramHolder, paramMessageForShortVideo);
              if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != paramMessageForShortVideo.uniseq) && (!jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq))))) {}
              for (paramInt1 = 1; (!paramMessageForShortVideo.mPreUpload) && (TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramInt1 != 0) && (paramMessageForShortVideo.busiType == 1); paramInt1 = 0)
              {
                if (jdField_h_of_type_Boolean) {
                  break label239;
                }
                a(paramMessageForShortVideo, null, false, true);
                return true;
              }
            }
          }
        } while (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq)));
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramMessageForShortVideo.uniseq), paramMessageForShortVideo);
      } while (!QLog.isColorLevel());
      label239:
      QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + jdField_a_of_type_JavaUtilMap.size() + ", [" + paramMessageForShortVideo.uniseq + "] added, mEncoding:" + jdField_h_of_type_Boolean);
      return true;
    }
    return false;
  }
  
  private boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = (MultiRichMediaSaveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
    if (localMultiRichMediaSaveManager != null)
    {
      paramMessageForShortVideo = localMultiRichMediaSaveManager.a(localMultiRichMediaSaveManager.a(paramMessageForShortVideo));
      if ((paramMessageForShortVideo != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoRealItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      return paramMessageForShortVideo != null;
    }
    return false;
  }
  
  private void b(ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    paramHolder = new WeakReference(paramHolder);
    if (paramMessageForShortVideo.busiType == 1)
    {
      if (paramMessageForShortVideo.progressTask == null)
      {
        paramMessageForShortVideo.progressTask = new ShortVideoRealItemBuilder.1(this, paramMessageForShortVideo, paramHolder);
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
        this.jdField_b_of_type_AndroidOsHandler.post(paramMessageForShortVideo.progressTask);
      }
      return;
    }
    if (paramMessageForShortVideo.mShowProgressTask == null) {
      paramMessageForShortVideo.mShowProgressTask = new ShortVideoRealItemBuilder.2(this, paramHolder, paramMessageForShortVideo);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.mShowProgressTask);
    this.jdField_b_of_type_AndroidOsHandler.post(paramMessageForShortVideo.mShowProgressTask);
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
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
      paramMessageForShortVideo.progressTask = null;
    }
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "pauseAllVideo");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
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
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
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
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
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
    Object localObject;
    if (!jdField_g_of_type_Boolean)
    {
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.ShortVideoHDConfig.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "initVideoHDConfig(), shortVideoHDConfig=" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 3))
        {
          if (!TextUtils.isEmpty(localObject[0])) {
            jdField_f_of_type_Boolean = localObject[0].equals("1");
          }
          if (TextUtils.isEmpty(localObject[1])) {
            break label253;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt(localObject[1]);
        if (TextUtils.isEmpty(localObject[2])) {}
      }
      catch (Exception localException2)
      {
        try
        {
          k = Integer.parseInt(localObject[2]);
          jdField_c_of_type_Int = Math.max(j, k);
          d = Math.min(j, k);
          jdField_g_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoRealItemBuilder", 2, "initVideoHDConfig(), sReadHDConfig=" + jdField_g_of_type_Boolean + ", sHDEnable:" + jdField_f_of_type_Boolean + ", sHDMaxLength:" + jdField_c_of_type_Int + ", sHDMinLength:" + d);
          }
          return;
          localException2 = localException2;
          j = 720;
        }
        catch (Exception localException1)
        {
          k = 540;
          continue;
        }
        int k = 540;
        continue;
      }
      label253:
      int j = 720;
    }
  }
  
  private void i()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
      {
        Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if (localObject != null) {
            ((BaseChatPie)localObject).c(false, false);
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
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ShortVideoRealItemBuilder.Holder localHolder = (ShortVideoRealItemBuilder.Holder)paramViewHolder;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = localContext.getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramViewHolder = ShortVideoUtils.adjustSize(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
    int j = paramViewHolder[0];
    int k = paramViewHolder[1];
    boolean bool = localMessageForShortVideo.isSend();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(localContext);
      paramView = (CropBubbleVideoView)QQVideoViewFactory.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.uniseq, null, bool);
      paramView.setId(2131362383);
      paramView.setVisibility(0);
      paramView.setContentDescription(HardCodeUtil.a(2131714022));
      paramViewHolder.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView(localContext);
      paramViewHolder.addView(localMessageProgressView);
      ImageView localImageView = new ImageView(localContext);
      localImageView.setImageResource(2130838161);
      localImageView.setVisibility(8);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131362383);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131362383);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.a(10.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.a(10.0F, localResources);
      paramViewHolder.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      localObject1 = new LinearLayout(localContext);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setGravity(17);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramViewHolder.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(localContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = AIOUtils.a(70.0F, localResources);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131364678);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      super.a(paramViewHolder, paramOnLongClickAndTouchListener);
      localHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = paramView;
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      localHolder.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    }
    paramView = localHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView;
    if (jdField_e_of_type_Boolean) {
      paramView.setContentDescription(HardCodeUtil.a(2131713984));
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
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(j, k);
      localHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramOnLongClickAndTouchListener);
      paramOnLongClickAndTouchListener = localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramOnLongClickAndTouchListener != null) {
        break label701;
      }
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(j, k);
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramOnLongClickAndTouchListener);
    }
    for (;;)
    {
      if (paramBaseChatItemLayout != null)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
        if ((!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n))
        {
          a(paramBaseChatItemLayout, localHolder, paramChatMessage);
          RedBagVideoManager.a(paramViewHolder, localHolder, paramChatMessage, localContext);
        }
      }
      a(localMessageForShortVideo);
      a(localMessageForShortVideo, localHolder, localResources, bool);
      if (!a(localHolder, localMessageForShortVideo, j, k, paramView)) {
        break label748;
      }
      return paramViewHolder;
      if ((paramOnLongClickAndTouchListener.width == j) && (paramOnLongClickAndTouchListener.height == k)) {
        break;
      }
      paramOnLongClickAndTouchListener.width = j;
      paramOnLongClickAndTouchListener.height = k;
      localHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramOnLongClickAndTouchListener);
      break;
      label701:
      if ((paramOnLongClickAndTouchListener.width != j) || (paramOnLongClickAndTouchListener.height != k))
      {
        paramOnLongClickAndTouchListener.width = j;
        paramOnLongClickAndTouchListener.height = k;
        localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramOnLongClickAndTouchListener);
      }
    }
    label748:
    paramChatMessage = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForShortVideo.thumbMD5, "jpg");
    paramBaseChatItemLayout = ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4");
    bool = b(localMessageForShortVideo);
    if ((bool) && (FileUtils.b(paramBaseChatItemLayout)) && ((!localMessageForShortVideo.isSendFromLocal()) || (localMessageForShortVideo.videoFileStatus == 1003) || (localMessageForShortVideo.videoFileStatus == 2003) || (localMessageForShortVideo.isMultiMsg == true)))
    {
      a(localMessageForShortVideo, localHolder, paramChatMessage, paramBaseChatItemLayout, j, k);
      return paramViewHolder;
    }
    if (FileUtils.b(paramChatMessage))
    {
      a(bool, paramView, localMessageForShortVideo, localHolder, paramChatMessage, paramBaseChatItemLayout, j, k);
      return paramViewHolder;
    }
    if (localMessageForShortVideo.videoFileStatus == 5002)
    {
      a(localMessageForShortVideo, HardCodeUtil.a(2131714015));
      paramView.setID(localMessageForShortVideo.uniseq);
      paramView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(localMessageForShortVideo, localHolder, 2131718625);
      return paramViewHolder;
    }
    a(localMessageForShortVideo, HardCodeUtil.a(2131714036));
    paramView.setID(localMessageForShortVideo.uniseq);
    paramView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    b(localMessageForShortVideo);
    return paramViewHolder;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    return null;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoRealItemBuilder.Holder(this);
  }
  
  public ShortVideoRealItemBuilder.Holder a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int j = AIOUtils.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (j <= -1) {
        break label223;
      }
      Object localObject = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, j);
      if (localObject != null)
      {
        localObject = AIOUtils.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof ShortVideoRealItemBuilder.Holder))) {
          return (ShortVideoRealItemBuilder.Holder)localObject;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + j + ", view = null");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + j + ", firstVisblePosi=" + m + ",lastVisblePosi=" + n + ",headerCount=" + k);
      }
    }
    for (;;)
    {
      return null;
      label223:
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi<= -1");
      }
    }
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramBaseHolder = (ShortVideoRealItemBuilder.Holder)paramBaseHolder;
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131372063, null, null);
    if ((!TextUtils.isEmpty(paramChatMessage.md5)) && ((!paramChatMessage.mPreUpload) || (!TextUtils.isEmpty(paramChatMessage.mLocalMd5))))
    {
      String str = ShortVideoUtils.getShortVideoThumbPicPath(paramChatMessage.thumbMD5, "jpg");
      paramChatMessage = ShortVideoUtils.getShortVideoSavePath(paramChatMessage, "mp4");
      if (FileUtils.b(str)) {
        if ((paramBaseHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramBaseHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
          break label173;
        }
      }
    }
    label173:
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        paramQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
        if (!FileUtils.b(paramChatMessage)) {}
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          paramQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131692258), 2130839058);
        }
        return paramQQCustomMenu;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131714037);
  }
  
  public String a(MessageForShortVideo paramMessageForShortVideo)
  {
    paramMessageForShortVideo = paramMessageForShortVideo.mVideoFileSourceDir + File.separator + "configure.txt";
    if (!FileUtils.b(paramMessageForShortVideo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoRealItemBuilder", 2, "configure file empty!");
      }
      return null;
    }
    try
    {
      paramMessageForShortVideo = FileUtils.b(new File(paramMessageForShortVideo));
      if (paramMessageForShortVideo == null) {
        break label97;
      }
      paramMessageForShortVideo = paramMessageForShortVideo.replaceAll("[\\t\\n\\r]", "");
      boolean bool = TextUtils.isEmpty(paramMessageForShortVideo);
      if (bool) {
        break label97;
      }
    }
    catch (Exception paramMessageForShortVideo)
    {
      for (;;)
      {
        paramMessageForShortVideo.printStackTrace();
        paramMessageForShortVideo = null;
      }
    }
    return paramMessageForShortVideo;
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
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
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
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidContentContext = null;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if ((localObject1 != null) && (((MessageForShortVideo)localObject1).progressTask != null)) {
      ((MessageForShortVideo)localObject1).progressTask = null;
    }
    this.jdField_a_of_type_ComTencentWidgetListView = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt != 2131365636) {
        break label77;
      }
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
      StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
    }
    label77:
    do
    {
      do
      {
        return;
        if (paramInt == 2131371997)
        {
          super.a(paramInt, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
          StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
          return;
        }
        if (paramInt == 2131367398)
        {
          paramInt = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
            StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "1", "", "", "" });
            c(localMessageForShortVideo);
            if (!paramChatMessage.isMultiMsg) {
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 5, 0, "5", "", "", "");
            return;
            if (paramInt == 2) {
              paramContext = "2";
            } else if (paramInt == 0) {
              paramContext = "3";
            } else {
              paramContext = "4";
            }
          }
        }
        if (paramInt != 2131366625) {
          break;
        }
        QfavBuilder.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
        StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      } while (!paramChatMessage.isMultiMsg);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 5, 0, "5", "", "", "");
      return;
      if (paramInt == 2131371954)
      {
        super.a(2131371954, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo);
        StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
        return;
      }
      if (paramInt == 2131365599)
      {
        paramContext = new StringBuilder();
        paramContext.append("uniseq:").append(localMessageForShortVideo.uniseq).append("\n");
        Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
        return;
      }
      if (paramInt != 2131372063) {
        break label676;
      }
      paramContext = a(localMessageForShortVideo.uniseq);
      if (paramContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoRealItemBuilder", 2, "onMenuItemClicked(), mute_play, holder == null, mr.uniseq = " + localMessageForShortVideo.uniseq);
    return;
    a(paramContext, localMessageForShortVideo, true);
    ReportController.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 1, 0, "", "", "", "");
    return;
    label676:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {}
    do
    {
      return;
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.addButton(2131690018, 5);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new ShortVideoRealItemBuilder.5(this, localMessageForShortVideo, paramView, localActionSheet));
      localActionSheet.show();
    } while (localMessageForShortVideo.videoFileStatus != 1004);
    ShortVideoUtils.reportCancelSendVideo("0X800A7EF", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296407);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.jdField_h_of_type_Int, j, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(j, BaseChatItemLayout.jdField_h_of_type_Int, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.a(paramView);
    if (!(paramView instanceof ShortVideoRealItemBuilder.Holder)) {}
    MessageForShortVideo localMessageForShortVideo;
    int j;
    int k;
    label188:
    label195:
    do
    {
      do
      {
        do
        {
          return;
          paramView = (ShortVideoRealItemBuilder.Holder)paramView;
          localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        } while (localMessageForShortVideo.uniseq != paramFileMsg.uniseq);
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.mShowProgressTask);
        if (localMessageForShortVideo.mShowProgressTask != null) {
          localMessageForShortVideo.mShowProgressTask = null;
        }
      } while (this.jdField_a_of_type_AndroidContentContext == null);
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (localMessageForShortVideo.thumbWidth > 0)
      {
        paramInt1 = localMessageForShortVideo.thumbWidth;
        if (localMessageForShortVideo.thumbHeight <= 0) {
          break label188;
        }
      }
      for (paramInt2 = localMessageForShortVideo.thumbHeight;; paramInt2 = 100)
      {
        j = AIOUtils.a(paramInt1, localResources);
        k = AIOUtils.a(paramInt2, localResources);
        if ((paramFileMsg.fileType != 6) && (paramFileMsg.fileType != 17) && (paramFileMsg.fileType != 9) && (paramFileMsg.fileType != 20)) {
          break label195;
        }
        a(paramFileMsg, paramView, localMessageForShortVideo, paramInt1, paramInt2, j, k);
        return;
        paramInt1 = 100;
        break;
      }
    } while ((paramFileMsg.fileType != 7) && (paramFileMsg.fileType != 18) && (paramFileMsg.fileType != 16));
    b(paramFileMsg, paramView, localMessageForShortVideo, paramInt1, paramInt2, j, k);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, ShortVideoRealItemBuilder.Holder paramHolder, MessageRecord paramMessageRecord)
  {
    if ((!(paramMessageRecord instanceof MessageForShortVideo)) || (paramHolder.jdField_e_of_type_Int == 0)) {
      return;
    }
    paramHolder.jdField_e_of_type_Int = 0;
    paramBaseChatItemLayout.setTailMessage(false, null, null);
  }
  
  protected void a(ShortVideoRealItemBuilder.Holder paramHolder)
  {
    if (!paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[hideProgress] set mProgressView gone");
      }
      return;
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new ShortVideoRealItemBuilder.6(this, paramHolder));
    }
  }
  
  protected void a(ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(paramMessageForShortVideo.isSend());
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9) || (paramMessageForShortVideo.fileType == 20))
    {
      if ((paramMessageForShortVideo.videoFileStatus == 1003) || (paramMessageForShortVideo.videoFileStatus == 2003)) {
        b(paramHolder);
      }
    }
    else {
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
  }
  
  public void a(ShortVideoRealItemBuilder.Holder paramHolder, String paramString, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    if ((FileUtils.b(paramString)) && (a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramString)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
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
    if ((paramMessageForShortVideo.CheckIsHotVideo()) && (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8007EDB")))
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
    a(paramMessageForShortVideo, "startUploadVideo：" + paramMessageForShortVideo.toString());
    Object localObject = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.b((String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719392, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!FileUtils.b(str))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719393, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((OrderMediaMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    localObject = ShortVideoBusiManager.a(1, 2);
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
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
        paramMessageForShortVideo.progressTask = null;
        a(paramMessageForShortVideo, "VIDEO STATUS_SEND_PROCESS CLOSE_TASK PROCESS:" + j);
      }
    }
    a(paramMessageForShortVideo, paramHolder, paramInt, true);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt1, int paramInt2)
  {
    if ((ShortVideoUtils.getDisplayProgress(paramMessageForShortVideo.videoFileProgress, 10) > 60) || (paramInt2 > 60)) {}
    do
    {
      return;
      paramInt2 = ShortVideoUtils.getDisplayProgress(paramInt2, 0);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt2, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((paramMessageForShortVideo.progressTask != null) && (NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext)))
      {
        paramMessageForShortVideo.progress += 3;
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(paramMessageForShortVideo.progressTask, 1000L);
      }
    } while (!QLog.isColorLevel());
    QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt1 + ", progress:" + paramInt2);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt, boolean paramBoolean)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, Resources paramResources, boolean paramBoolean)
  {
    int j = Math.max(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    int k = Math.min(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    if ((jdField_f_of_type_Boolean) && (j >= jdField_c_of_type_Int) && (k >= d))
    {
      paramMessageForShortVideo = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramBoolean) {}
      for (paramMessageForShortVideo.rightMargin = AIOUtils.a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth() + 8.0F, paramResources);; paramMessageForShortVideo.rightMargin = AIOUtils.a(8.0F, paramResources))
      {
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
    }
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, HardCodeUtil.a(2131713996));
      return;
    }
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(2, 2);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.jdField_b_of_type_Int);
    localShortVideoDownloadInfo.h = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 0);
    if (paramBoolean) {}
    for (int j = 2;; j = 1)
    {
      localShortVideoDownloadInfo.jdField_f_of_type_Int = j;
      localShortVideoDownloadInfo.jdField_g_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localShortVideoDownloadInfo.jdField_e_of_type_Int + ", uniseq:" + paramMessageForShortVideo.uniseq);
      }
      localShortVideoReq.a(localShortVideoDownloadInfo);
      localShortVideoReq.a(paramMessageForShortVideo);
      ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
  }
  
  public void a(FileMsg paramFileMsg, ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (paramFileMsg.status)
    {
    default: 
    case 1007: 
    case 1001: 
    case 1003: 
    case 1005: 
    case 1004: 
    case 1002: 
    case 2001: 
    case 2003: 
    case 5001: 
    case 2005: 
      do
      {
        do
        {
          return;
          a(paramHolder, false, null);
          EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          a(paramMessageForShortVideo, "VIDEO STATUS_UPLOAD_FINISHED progress " + paramMessageForShortVideo.videoFileProgress);
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_START progress " + paramMessageForShortVideo.videoFileProgress);
          if (paramMessageForShortVideo.busiType != 1) {
            a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, true);
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
          EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_FINISHED");
          d(paramMessageForShortVideo);
          a(paramMessageForShortVideo.mVideoFileSourceDir);
          a(paramMessageForShortVideo, paramHolder, 100, true);
          a(paramHolder, false, null);
          EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_ERROR");
          d(paramMessageForShortVideo);
          b(paramMessageForShortVideo, paramHolder, 2131718630);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_CANCEL");
          paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          d(paramMessageForShortVideo);
          a(paramHolder);
          b(paramMessageForShortVideo, paramHolder, 2131718630);
          b(paramHolder, true, this);
          EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          paramInt1 = paramMessageForShortVideo.videoFileProgress;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_PROCESS " + paramInt1);
          a(paramMessageForShortVideo, paramHolder, paramInt1);
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_RECV_START");
          a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, true);
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_RECV_FINISHED , getAIOState() = " + a());
          if ((!b(paramMessageForShortVideo)) || (a() != 4)) {
            break;
          }
          paramFileMsg = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
          a(paramMessageForShortVideo, HardCodeUtil.a(2131714019) + paramFileMsg);
          if ((ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.b(paramFileMsg)))
          {
            a(paramMessageForShortVideo, HardCodeUtil.a(2131714031) + paramFileMsg);
            String str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
            a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramFileMsg, str, paramMessageForShortVideo, paramInt1, paramInt2);
            if (!paramMessageForShortVideo.isSend()) {
              new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
            }
          }
          a(paramMessageForShortVideo, paramHolder, 100, true);
        } while (!paramMessageForShortVideo.isMultiMsg);
        a(paramHolder);
        return;
        a(paramHolder, ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
        c(paramMessageForShortVideo, paramHolder);
        return;
        a(paramMessageForShortVideo, "VIDEO STATUS_FILE_UNSAFE");
        b(paramMessageForShortVideo, paramHolder, 2131718624);
        if (paramMessageForShortVideo.uiOperatorFlag == 2)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719361, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719385, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
        return;
        a(paramMessageForShortVideo, "VIDEO STATUS_RECV_ERROR");
        a(paramHolder);
        c(paramMessageForShortVideo, paramHolder);
      } while (paramFileMsg.errorCode == -5100528);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719387, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      return;
    case 5002: 
      a(paramMessageForShortVideo, "VIDEO STATUS_FILE_EXPIRED");
      a(paramHolder, ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
      b(paramMessageForShortVideo, paramHolder, 2131718625);
      return;
    case 2004: 
      a(paramMessageForShortVideo, "VIDEO STATUS_RECV_CANCEL");
      return;
    }
    paramInt1 = paramMessageForShortVideo.videoFileProgress;
    a(paramMessageForShortVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
    a(paramMessageForShortVideo, paramHolder, paramInt1, true);
  }
  
  protected void a(CropBubbleVideoView paramCropBubbleVideoView, String paramString1, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("playShortVideoByPath uniseq=").append(paramMessageForShortVideo.uniseq).append(", videoPath = ");
      if (paramString1 != null)
      {
        localObject = paramString1;
        localStringBuilder = localStringBuilder.append((String)localObject).append(", thumbPath = ");
        if (paramString2 == null) {
          break label223;
        }
        localObject = paramString2;
        label64:
        QLog.d("ShortVideoRealItemBuilder", 2, (String)localObject);
      }
    }
    else
    {
      paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      localObject = new VideoPlayParam();
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
      if (!TextUtils.isEmpty(paramString2)) {
        break label231;
      }
      paramCropBubbleVideoView.setCoverDrawable(paramString1);
    }
    for (;;)
    {
      if (c()) {
        paramCropBubbleVideoView.play();
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramCropBubbleVideoView);
      return;
      localObject = "null";
      break;
      label223:
      localObject = "null";
      break label64;
      label231:
      paramCropBubbleVideoView.setCoverDrawable(URLDrawable.getDrawable(ShortVideoUtils.getThumbUrl(paramString2).toString(), paramInt1, paramInt2, paramString1, paramString1));
    }
  }
  
  void a(String paramString)
  {
    ThreadManager.post(new ShortVideoRealItemBuilder.4(this, paramString), 5, null, false);
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (!paramChatMessage.isSendFromLocal());
        paramChatMessage = (MessageForShortVideo)paramChatMessage;
        if ((paramChatMessage.md5 == null) && (paramChatMessage.videoFileStatus == 1004)) {
          return true;
        }
      } while ((paramChatMessage.md5 == null) || (paramChatMessage.videoFileStatus == 5002));
      if ((paramChatMessage.busiType == 1) && (paramChatMessage.uiOperatorFlag == 1) && (paramChatMessage.videoFileStatus == 1004)) {
        return true;
      }
      paramBaseChatItemLayout = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramBaseChatItemLayout instanceof BaseTransProcessor))
      {
        if (((BaseTransProcessor)paramBaseChatItemLayout).getFileStatus() == 1005L) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      if (paramChatMessage.videoFileStatus == 1005) {
        return true;
      }
    } while ((paramChatMessage.videoFileProgress == 100) || (paramChatMessage.videoFileStatus == 1003) || (paramChatMessage.videoFileStatus == 2003) || (paramChatMessage.isAllowAutoDown != true));
    return true;
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
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localQQCustomMenu, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      label48:
      b(localQQCustomMenu, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramBaseHolder = (ShortVideoRealItemBuilder.Holder)paramBaseHolder;
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131372063, null, null);
    int n = 0;
    int j = 0;
    int m;
    int k;
    label173:
    int i1;
    if ((!TextUtils.isEmpty(paramChatMessage.md5)) && ((!paramChatMessage.mPreUpload) || (!TextUtils.isEmpty(paramChatMessage.mLocalMd5))))
    {
      String str1 = ShortVideoUtils.getShortVideoThumbPicPath(paramChatMessage.thumbMD5, "jpg");
      String str2 = ShortVideoUtils.getShortVideoSavePath(paramChatMessage, "mp4");
      if (FileUtils.b(str1)) {
        if ((paramBaseHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) && (paramBaseHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0))
        {
          m = 1;
          if (m == 0)
          {
            n = 1;
            paramQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
            a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, paramChatMessage, null);
            k = n;
            if (FileUtils.b(str2))
            {
              j = 1;
              k = n;
            }
            n = j;
            i1 = k;
            if (m == 0)
            {
              a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramChatMessage, new Bundle());
              i1 = k;
              n = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramChatMessage, new Bundle());
      if (n != 0) {
        paramQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131692258), 2130839058);
      }
      paramBaseHolder = new Bundle();
      paramBaseHolder.putBoolean("isSearch", false);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380949, paramChatMessage, paramBaseHolder);
      if (i1 != 0) {
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramChatMessage, null);
      }
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      return paramQQCustomMenu;
      k = 0;
      break label173;
      m = 0;
      break;
      i1 = 0;
    }
  }
  
  protected void b(ShortVideoRealItemBuilder.Holder paramHolder)
  {
    if (!paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[disProgress] set mProgressView gone");
      }
      return;
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new ShortVideoRealItemBuilder.7(this, paramHolder));
    }
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (a(paramMessageForShortVideo)) {
      return;
    }
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(2, 2);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.jdField_b_of_type_Int);
    localShortVideoDownloadInfo.i = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
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
    a(paramMessageForShortVideo, "reForwardVideo：" + paramMessageForShortVideo.toString());
    if (!FileUtils.b(ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719393, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((OrderMediaMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      paramHolder = ShortVideoBusiManager.a(4, 2);
      paramHolder.a(ShortVideoBusiManager.a(2, paramMessageForShortVideo, paramHolder));
      ShortVideoBusiManager.a(paramHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    a(paramMessageForShortVideo, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130850170);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showWarnProgress] set mProgressView visible");
    }
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void b(FileMsg paramFileMsg, ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str;
    switch (paramFileMsg.status)
    {
    default: 
    case 2001: 
    case 2003: 
      do
      {
        do
        {
          return;
          a(paramMessageForShortVideo, "THUMB STATUS_RECV_START");
          return;
          a(paramMessageForShortVideo, "THUMB STATUS_RECV_FINISHED");
          paramFileMsg = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
          str = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
          if ((!FileUtils.b(str)) || (!b(paramMessageForShortVideo))) {
            break;
          }
          a(paramMessageForShortVideo, HardCodeUtil.a(2131713991) + paramFileMsg);
        } while (!ShortVideoUtils.isVideoSoLibLoaded());
        a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, str, paramFileMsg, paramMessageForShortVideo, paramInt1, paramInt2);
        return;
        a(paramHolder, paramFileMsg, paramMessageForShortVideo, paramInt3, paramInt4);
        if (!FileUtils.b(paramFileMsg)) {
          break;
        }
      } while (!a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramFileMsg));
      a(paramMessageForShortVideo, HardCodeUtil.a(2131713979) + paramFileMsg);
      if (!FileUtils.b(str))
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
      return;
      paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(URLDrawableHelper.getFailedDrawable());
      return;
    case 5002: 
      a(paramMessageForShortVideo, "THUMB STATUS_FILE_EXPIRED");
    }
    a(paramMessageForShortVideo, "THUMB STATUS_RECV_ERROR");
    paramFileMsg = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    if (FileUtils.b(paramFileMsg))
    {
      a(paramMessageForShortVideo, HardCodeUtil.a(2131713976) + paramFileMsg);
      if (ShortVideoUtils.isVideoSoLibLoaded())
      {
        str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
        a(paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramFileMsg, str, paramMessageForShortVideo, paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      a(paramHolder);
      return;
      paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    }
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5)) {
      a(paramMessageForShortVideo, "Forward menu clicked, md5 is empty.");
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 21);
      localBundle.putBoolean("forward_need_sendmsg", true);
      String str1 = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
      localBundle.putString("forward_thumb", str1);
      localBundle.putString("from_uin", ShortVideoUtils.getFromUinForForward(paramMessageForShortVideo));
      localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
      localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
      localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
      localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
      localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
      localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
      String str2 = ShortVideoUtils.findVideoPathIfExists(paramMessageForShortVideo);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "Forward menu clicked, videoPath=" + str2 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
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
      if (paramMessageForShortVideo.CheckIsHotVideo())
      {
        localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
        localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
        localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
        localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
      }
      if ((paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) && (paramMessageForShortVideo.isSend()))
      {
        localBundle.putInt("param_key_redbag_type", paramMessageForShortVideo.redBagType);
        localBundle.putString("param_key_redbag_video_id", paramMessageForShortVideo.shortVideoId);
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.templateId))
      {
        localBundle.putString("widgetinfo", paramMessageForShortVideo.templateId);
        localBundle.putString("key_camera_material_name", paramMessageForShortVideo.templateName);
      }
      if (FileUtils.b(str2))
      {
        localBundle.putBoolean("k_dataline", true);
        localBundle.putString("forward_extra", str2);
        localBundle.putBoolean("direct_send_if_dataline_forward", true);
        localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      paramMessageForShortVideo = new Intent();
      paramMessageForShortVideo.putExtras(localBundle);
    } while (this.jdField_a_of_type_AndroidContentContext == null);
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  void c(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - jdField_c_of_type_Long < 500L) && (l > jdField_c_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoRealItemBuilder", 2, "click too offen, please try again later!");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      jdField_c_of_type_Long = l;
      Object localObject;
      if (paramView.getId() == 2131364662)
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
        if (paramView.getId() != 2131364680) {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695877, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
          }
          else
          {
            if (paramView.getId() == 2131364634) {
              a(localHolder, localMessageForShortVideo, false);
            }
            if (paramView.getId() == 2131364653)
            {
              if (!localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg)
              {
                localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
                if (((localObject instanceof ShortVideoUploadProcessor)) && (((ShortVideoUploadProcessor)localObject).isBDHSuccess))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator BDHSuccess!");
                  }
                }
                else
                {
                  StringBuilder localStringBuilder1 = new StringBuilder();
                  localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
                  if ((localObject instanceof ShortVideoUploadProcessor))
                  {
                    ((ShortVideoUploadProcessor)localObject).pause();
                    localStringBuilder1.append("\n shortVideoCancel uploadProcess pause!");
                    ShortVideoUtils.reportCancelSendVideo("0X800A7EE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                    if (QLog.isColorLevel()) {
                      QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator info:" + localStringBuilder1.toString());
                    }
                  }
                  else
                  {
                    EncodeVideoTask localEncodeVideoTask = (EncodeVideoTask)EncodeVideoTask.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
                    StringBuilder localStringBuilder2 = localStringBuilder1.append("\n shortVideoCancel uniseq:");
                    if (localEncodeVideoTask != null)
                    {
                      localObject = Long.valueOf(localEncodeVideoTask.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
                      label455:
                      localObject = localStringBuilder2.append(localObject).append(", msgUniseq:").append(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq).append(", encodeFinish:");
                      if ((localEncodeVideoTask == null) || (!localEncodeVideoTask.jdField_a_of_type_Boolean)) {
                        break label652;
                      }
                    }
                    label652:
                    for (boolean bool = true;; bool = false)
                    {
                      ((StringBuilder)localObject).append(bool);
                      if ((localEncodeVideoTask == null) || (localEncodeVideoTask.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) || (!localEncodeVideoTask.a())) {
                        break;
                      }
                      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.progressTask);
                      localMessageForShortVideo.progressTask = null;
                      localMessageForShortVideo.videoFileStatus = 1004;
                      localMessageForShortVideo.md5 = null;
                      localMessageForShortVideo.serial();
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
                      OrderMediaMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                      i();
                      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
                      jdField_h_of_type_Boolean = false;
                      break;
                      localObject = "-1";
                      break label455;
                    }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder
 * JD-Core Version:    0.7.0.1
 */