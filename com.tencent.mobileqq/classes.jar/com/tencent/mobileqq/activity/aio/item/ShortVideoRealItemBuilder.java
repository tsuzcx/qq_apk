package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
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
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.ShortVideoMtaReport;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import vle;
import vlf;
import vlg;
import vlh;
import vli;
import vlj;
import vlk;
import vll;
import vlm;
import vln;
import vlo;
import vlq;

public class ShortVideoRealItemBuilder
  extends QIMTailItemBubbleBuilder
  implements QQLiveDrawable.OnStateListener, FileTransferManager.Callback, ShortVideoConstants
{
  public static ColorDrawable a;
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  private static Map jdField_a_of_type_JavaUtilMap;
  public static int b;
  public static int c;
  public static boolean c;
  static int jdField_d_of_type_Int;
  private static boolean jdField_d_of_type_Boolean;
  static int jdField_e_of_type_Int;
  private static boolean jdField_e_of_type_Boolean;
  static int f;
  static int g;
  static int h;
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = new vlq(this);
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Handler b;
  public long c;
  
  static
  {
    URLDrawableHelper.b();
    jdField_c_of_type_Boolean = true;
    jdField_b_of_type_Int = 960;
    jdField_c_of_type_Int = 720;
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_f_of_type_Int = BaseChatItemLayout.jdField_e_of_type_Int;
    jdField_f_of_type_Int = Math.min(AIOUtils.a(320.0F, localResources), jdField_f_of_type_Int);
    g = AIOUtils.a(100.0F, localResources);
    h = AIOUtils.a(100.0F, localResources);
    jdField_d_of_type_Int = AIOUtils.a(CodecParam.l, localResources);
    jdField_e_of_type_Int = AIOUtils.a(CodecParam.m, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new EmptyDrawable(-10065297, jdField_d_of_type_Int, jdField_e_of_type_Int);
  }
  
  public ShortVideoRealItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_c_of_type_Long = 0L;
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView;
    }
    ShortVideoUtils.a(paramQQAppInterface);
    ShortVideoUtils.ShortVideoPlayConfig.a();
    e();
  }
  
  private URLDrawable a(String paramString1, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    localQQLiveDrawableParams.mPreviewWidth = paramMessageForShortVideo.thumbWidth;
    localQQLiveDrawableParams.mPreviewHeight = paramMessageForShortVideo.thumbHeight;
    localQQLiveDrawableParams.mDataSourceType = 3;
    localQQLiveDrawableParams.mDataSource = paramString1;
    localQQLiveDrawableParams.mLoopback = true;
    localQQLiveDrawableParams.mPlayType = 2;
    localQQLiveDrawableParams.mListener = this;
    localQQLiveDrawableParams.msgUniseq = paramMessageForShortVideo.uniseq;
    localQQLiveDrawableParams.mCoverUrl = ShortVideoUtils.a(paramString2).toString();
    localQQLiveDrawableParams.mCoverLoadingDrawable = new EmptyDrawable(-10065297, 100, 100);
    paramString1 = URLDrawable.URLDrawableOptions.obtain();
    paramString1.mExtraInfo = localQQLiveDrawableParams;
    paramString1.mLoadingDrawable = new EmptyDrawable(-10065297, 100, 100);
    return URLDrawable.getDrawable(ShortVideoItemBuilder.a(paramMessageForShortVideo.uniseq), paramString1);
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(this.jdField_a_of_type_AndroidContentContext);
    localProgressPieDrawable.a(AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.f(-1);
    localProgressPieDrawable.e(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.g(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.a(new vlo(this));
    return localProgressPieDrawable;
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, ImageView paramImageView, SessionInfo paramSessionInfo)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007429", "0X8007429", 0, 0, "", "", "", "");
    if (MediaPlayerManager.a(paramQQAppInterface).b()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    paramImageView = AnimationUtils.a(paramImageView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramImageView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity))) {
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().f());
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
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
      paramImageView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramImageView.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramImageView.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).processName.endsWith("mobileqq")) {
          localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", ((ActivityManager.RunningAppProcessInfo)localObject).pid);
        }
      }
      localObject = paramMessageForShortVideo.selfuin;
      paramImageView = (ImageView)localObject;
      if (!paramMessageForShortVideo.isMultiMsg) {}
    }
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramImageView = (ImageView)localObject;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramImageView = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramImageView)
    {
      for (;;)
      {
        paramImageView = (ImageView)localObject;
      }
    }
    localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    if ((paramMessageForShortVideo.istroop == 0) && (com.tencent.mobileqq.util.Utils.b(paramMessageForShortVideo.senderuin)) && (!TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"))))
    {
      localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
      PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramImageView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), 13007);
    }
    for (;;)
    {
      if (!paramMessageForShortVideo.isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
      }
      ShortVideoUtils.a(paramQQAppInterface, "0X8008E53", paramSessionInfo, paramMessageForShortVideo, paramContext);
      return;
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
      break;
      PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramImageView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), -1);
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
  
  private void c(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.progressTask != null))
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
      paramMessageForShortVideo.progressTask = null;
    }
  }
  
  private void e()
  {
    int j = 720;
    int k = 540;
    Object localObject;
    int i;
    if (!jdField_d_of_type_Boolean)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.ShortVideoHDConfig.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "initVideoHDConfig(), shortVideoHDConfig=" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 3))
        {
          if (!TextUtils.isEmpty(localObject[0])) {
            jdField_c_of_type_Boolean = localObject[0].equals("1");
          }
          i = j;
          if (TextUtils.isEmpty(localObject[1])) {}
        }
      }
    }
    try
    {
      i = Integer.parseInt(localObject[1]);
      j = k;
      if (!TextUtils.isEmpty(localObject[2])) {}
      try
      {
        j = Integer.parseInt(localObject[2]);
        jdField_b_of_type_Int = Math.max(i, j);
        jdField_c_of_type_Int = Math.min(i, j);
        jdField_d_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "initVideoHDConfig(), sReadHDConfig=" + jdField_d_of_type_Boolean + ", sHDEnable:" + jdField_c_of_type_Boolean + ", sHDMaxLength:" + jdField_b_of_type_Int + ", sHDMinLength:" + jdField_c_of_type_Int);
        }
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          j = k;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)))) {
      jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask != null)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask = null;
    }
    jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
    if (jdField_a_of_type_JavaUtilMap.size() != 0)
    {
      localObject = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label227;
      }
    }
    label227:
    for (Object localObject = (MessageForShortVideo)((Map.Entry)((Iterator)localObject).next()).getValue();; localObject = null)
    {
      if (localObject != null)
      {
        ThreadManager.postImmediately(new vlf(this, (MessageForShortVideo)localObject), null, true);
        jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + jdField_a_of_type_JavaUtilMap.size() + ", [" + ((MessageForShortVideo)localObject).uniseq + "] start upload!");
        }
      }
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramView != null) {
      paramView.a(paramChatMessage, this);
    }
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ShortVideoRealItemBuilder.Holder localHolder = (ShortVideoRealItemBuilder.Holder)paramViewHolder;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = localContext.getResources();
    paramViewHolder = paramView;
    Object localObject1;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(localContext);
      paramView = new ShortVideoRealItemBuilder.ChatVideoView(localContext);
      paramView.setId(2131366638);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.d(true);
      paramView.setSharpCornerCor(BubbleImageView.a);
      if ((paramChatMessage instanceof MessageForDevLittleVideo))
      {
        paramView.setAdjustViewBounds(true);
        paramView.setMinimumWidth(g);
        paramView.setMinimumHeight(h);
        paramView.setMaxWidth(jdField_f_of_type_Int);
      }
      paramViewHolder.addView(paramView);
      localObject1 = new MessageProgressView(localContext);
      paramViewHolder.addView((View)localObject1);
      ImageView localImageView = new ImageView(localContext);
      localImageView.setImageResource(2130837598);
      localImageView.setVisibility(8);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131366638);
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131366638);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.a(10.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(10.0F, localResources);
      paramViewHolder.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new LinearLayout(localContext);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setGravity(17);
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(localContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = AIOUtils.a(70.0F, localResources);
      ((TextView)localObject3).setTextColor(-1);
      ((TextView)localObject3).setTextSize(2, 12.0F);
      ((TextView)localObject3).setId(2131361904);
      ((LinearLayout)localObject2).addView((View)localObject3, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView = paramView;
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = ((MessageProgressView)localObject1);
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      localHolder.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    }
    if ((paramChatMessage instanceof MessageForDevLittleVideo)) {}
    label627:
    int i;
    int j;
    label695:
    label729:
    label1006:
    do
    {
      do
      {
        do
        {
          do
          {
            return paramViewHolder;
            localObject1 = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView;
            if (jdField_b_of_type_Boolean) {
              ((ShortVideoRealItemBuilder.ChatVideoView)localObject1).setContentDescription("小视频");
            }
            paramOnLongClickAndTouchListener = (MessageForShortVideo)paramChatMessage;
            paramView = paramOnLongClickAndTouchListener.mProgressPie;
            ((ShortVideoRealItemBuilder.ChatVideoView)localObject1).jdField_d_of_type_Boolean = paramOnLongClickAndTouchListener.isSend();
            ((ShortVideoRealItemBuilder.ChatVideoView)localObject1).setTag(Long.valueOf(paramOnLongClickAndTouchListener.uniseq));
            AIOSingleReporter.a().a(Long.valueOf(paramOnLongClickAndTouchListener.uniseq), paramOnLongClickAndTouchListener);
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(paramOnLongClickAndTouchListener.isSend());
            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
            if ((paramOnLongClickAndTouchListener.fileType == 6) || (paramOnLongClickAndTouchListener.fileType == 17) || (paramOnLongClickAndTouchListener.fileType == 9) || (paramOnLongClickAndTouchListener.fileType == 20))
            {
              if ((paramOnLongClickAndTouchListener.videoFileStatus == 1003) || (paramOnLongClickAndTouchListener.videoFileStatus == 2003)) {
                b(localHolder);
              }
            }
            else
            {
              localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              paramView = ShortVideoUtils.a(paramOnLongClickAndTouchListener.thumbWidth, paramOnLongClickAndTouchListener.thumbHeight);
              i = paramView[0];
              j = paramView[1];
              paramView = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.getLayoutParams();
              if (paramView != null) {
                break label1119;
              }
              paramView = new RelativeLayout.LayoutParams(i, j);
              localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.setLayoutParams(paramView);
              paramView = localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
              if (paramView != null) {
                break label1161;
              }
              paramView = new RelativeLayout.LayoutParams(i, j);
              localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramView);
              if (paramBaseChatItemLayout != null)
              {
                a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
                if (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity))
                {
                  a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, localHolder, paramChatMessage);
                  RedBagVideoManager.a(paramViewHolder, localHolder, paramChatMessage, localContext);
                }
              }
              if (!AIOSingleReporter.a().a(paramOnLongClickAndTouchListener, "0X8007428"))
              {
                AIOSingleReporter.a().a(paramOnLongClickAndTouchListener, "0X8007428");
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007428", "0X8007428", 0, 0, "", "", "", "");
              }
              if ((paramOnLongClickAndTouchListener.CheckIsHotVideo()) && (!AIOSingleReporter.a().a(paramOnLongClickAndTouchListener, "0X8007EDB")))
              {
                AIOSingleReporter.a().a(paramOnLongClickAndTouchListener, "0X8007EDB");
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
              }
              int k = Math.max(paramOnLongClickAndTouchListener.thumbWidth, paramOnLongClickAndTouchListener.thumbHeight);
              int m = Math.min(paramOnLongClickAndTouchListener.thumbWidth, paramOnLongClickAndTouchListener.thumbHeight);
              if ((!jdField_c_of_type_Boolean) || (k < jdField_b_of_type_Int) || (m < jdField_c_of_type_Int)) {
                break label1218;
              }
              paramChatMessage = (RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
              if (!((ShortVideoRealItemBuilder.ChatVideoView)localObject1).jdField_d_of_type_Boolean) {
                break label1203;
              }
              paramChatMessage.rightMargin = AIOUtils.a(8.0F + localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.a, localResources);
              localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            for (;;)
            {
              if ((!TextUtils.isEmpty(paramOnLongClickAndTouchListener.md5)) || (paramOnLongClickAndTouchListener.videoFileStatus == 1005) || (paramOnLongClickAndTouchListener.extraflag == 32768)) {
                break label1625;
              }
              if (!paramOnLongClickAndTouchListener.isSendFromLocal()) {
                break;
              }
              paramView = paramOnLongClickAndTouchListener.mThumbFilePath;
              paramChatMessage = paramView;
              if (FileUtils.b(paramView)) {
                break label1243;
              }
              if (!TextUtils.isEmpty(paramOnLongClickAndTouchListener.thumbMD5)) {
                break label1231;
              }
              ((ShortVideoRealItemBuilder.ChatVideoView)localObject1).setImageDrawable(URLDrawableHelper.a());
              a(localHolder);
              a(paramOnLongClickAndTouchListener, "getBubbleView():You must get thumb before send video.");
              return paramViewHolder;
              localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
              break label627;
              if ((paramView.width == i) && (paramView.height == j)) {
                break label695;
              }
              paramView.width = i;
              paramView.height = j;
              localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.setLayoutParams(paramView);
              break label695;
              if ((paramView.width == i) && (paramView.height == j)) {
                break label729;
              }
              paramView.width = i;
              paramView.height = j;
              localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramView);
              break label729;
              paramChatMessage.rightMargin = AIOUtils.a(8.0F, localResources);
              break label1006;
              localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            }
            paramChatMessage = ShortVideoUtils.a(paramOnLongClickAndTouchListener.thumbMD5, "jpg");
          } while (!((ShortVideoRealItemBuilder.ChatVideoView)localObject1).a(paramChatMessage));
          a(paramOnLongClickAndTouchListener, "getBubbleView: 占坑");
          paramView = URLDrawable.URLDrawableOptions.obtain();
          paramView.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramView.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((ShortVideoRealItemBuilder.ChatVideoView)localObject1).setURLDrawable(URLDrawable.getDrawable(new File(paramChatMessage), paramView));
          if (paramOnLongClickAndTouchListener.busiType == 1) {
            if (paramOnLongClickAndTouchListener.progressTask == null)
            {
              paramOnLongClickAndTouchListener.progressTask = new vle(this, paramOnLongClickAndTouchListener, localHolder);
              this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramOnLongClickAndTouchListener.progressTask);
              this.jdField_b_of_type_AndroidOsHandler.post(paramOnLongClickAndTouchListener.progressTask);
            }
          }
          for (;;)
          {
            a(paramOnLongClickAndTouchListener, "getBubbleView,judge mr status. mr = " + paramOnLongClickAndTouchListener);
            if ((paramOnLongClickAndTouchListener.mPreUpload) || (!TextUtils.isEmpty(paramOnLongClickAndTouchListener.mLocalMd5))) {
              break;
            }
            if (paramOnLongClickAndTouchListener.busiType != 1) {
              break label1592;
            }
            if (jdField_e_of_type_Boolean) {
              break label1486;
            }
            ThreadManager.postImmediately(new vlj(this, paramOnLongClickAndTouchListener), null, true);
            return paramViewHolder;
            if (paramOnLongClickAndTouchListener.mShowProgressTask == null) {
              paramOnLongClickAndTouchListener.mShowProgressTask = new vli(this, paramOnLongClickAndTouchListener, localHolder);
            }
            this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramOnLongClickAndTouchListener.mShowProgressTask);
            this.jdField_b_of_type_AndroidOsHandler.post(paramOnLongClickAndTouchListener.mShowProgressTask);
          }
        } while (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramOnLongClickAndTouchListener.uniseq)));
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramOnLongClickAndTouchListener.uniseq), paramOnLongClickAndTouchListener);
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + jdField_a_of_type_JavaUtilMap.size() + ", [" + paramOnLongClickAndTouchListener.uniseq + "] added, mEncoding:" + jdField_e_of_type_Boolean);
      return paramViewHolder;
      com.tencent.image.Utils.executeAsyncTaskOnSerialExcuter(new ShortVideoRealItemBuilder.EncodeTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramOnLongClickAndTouchListener), new Void[] { (Void)null });
      return paramViewHolder;
      paramChatMessage = ShortVideoUtils.a(paramOnLongClickAndTouchListener.thumbMD5, "jpg");
      paramView = ShortVideoUtils.a(paramOnLongClickAndTouchListener, "mp4");
      if ((FileUtils.b(paramChatMessage)) && (FileUtils.b(paramView))) {
        a(localHolder);
      }
      if ((!ShortVideoUtils.ShortVideoPlayConfig.jdField_b_of_type_Boolean) || (!FileUtils.b(paramView)) || ((paramOnLongClickAndTouchListener.isSendFromLocal()) && (paramOnLongClickAndTouchListener.videoFileStatus != 1003) && (paramOnLongClickAndTouchListener.videoFileStatus != 2003) && (paramOnLongClickAndTouchListener.isMultiMsg != true))) {
        break;
      }
      if (!paramOnLongClickAndTouchListener.isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
      }
      a(paramOnLongClickAndTouchListener, "getBubbleView: 刷视频 " + paramView);
      paramView = a(paramView, paramChatMessage, paramOnLongClickAndTouchListener, i, j);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "short video uniseq=" + paramOnLongClickAndTouchListener.uniseq + " d=" + paramView);
      }
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.setURLDrawable(paramView);
      b(localHolder);
      if ((TroopStoryUtil.a(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!AIOSingleReporter.a().a(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video")))
      {
        AIOSingleReporter.a().a(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video");
        StoryReportor.a("aio_msg", "play_msg_video", 0, 0, new String[] { "", "", "", TroopStoryUtil.a((MessageForShortVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage) });
      }
    } while (FileUtils.b(paramChatMessage));
    label1119:
    a(paramOnLongClickAndTouchListener);
    label1161:
    label1203:
    label1218:
    label1231:
    label1243:
    a(paramOnLongClickAndTouchListener, "getBubbleView: Video file exist and status finish. Thumb not exist.");
    label1486:
    label1625:
    return paramViewHolder;
    label1592:
    if (FileUtils.b(paramChatMessage))
    {
      if (((ShortVideoRealItemBuilder.ChatVideoView)localObject1).a(paramChatMessage))
      {
        a(paramOnLongClickAndTouchListener, "getBubbleView: 刷缩略图 " + paramChatMessage);
        paramBaseChatItemLayout = URLDrawable.URLDrawableOptions.obtain();
        paramBaseChatItemLayout.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramBaseChatItemLayout.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((ShortVideoRealItemBuilder.ChatVideoView)localObject1).setURLDrawable(URLDrawable.getDrawable(new File(paramChatMessage), paramBaseChatItemLayout));
      }
      while (FileUtils.b(paramView))
      {
        i = 0;
        if ((paramOnLongClickAndTouchListener.videoFileStatus == 1005) || (paramOnLongClickAndTouchListener.extraflag == 32768)) {
          i = 1;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramOnLongClickAndTouchListener.frienduin, paramOnLongClickAndTouchListener.uniseq);
        j = i;
        if (paramOnLongClickAndTouchListener.isSendFromLocal())
        {
          j = i;
          if (paramOnLongClickAndTouchListener.videoFileProgress < 100)
          {
            j = i;
            if (paramOnLongClickAndTouchListener.videoFileStatus != 1003)
            {
              j = i;
              if (paramOnLongClickAndTouchListener.videoFileStatus != 1004)
              {
                j = i;
                if (paramChatMessage == null) {
                  j = 1;
                }
              }
            }
          }
        }
        if (j != 0)
        {
          b(paramOnLongClickAndTouchListener, localHolder, 2131432999);
          return paramViewHolder;
          a(paramOnLongClickAndTouchListener, "getBubbleView: 刷缩略图用缓存 " + paramChatMessage);
          paramChatMessage = ((ShortVideoRealItemBuilder.ChatVideoView)localObject1).b;
          if ((paramChatMessage != null) && (paramChatMessage.getStatus() == 1)) {
            ((ShortVideoRealItemBuilder.ChatVideoView)localObject1).setURLDrawable(paramChatMessage);
          }
        }
        else
        {
          if ((!ShortVideoUtils.a()) || (!ShortVideoUtils.ShortVideoPlayConfig.jdField_b_of_type_Boolean))
          {
            c(paramOnLongClickAndTouchListener, localHolder);
            return paramViewHolder;
          }
          if (ShortVideoUtils.a(paramOnLongClickAndTouchListener.videoFileProgress, 10) <= 60) {}
          for (i = 1; (paramOnLongClickAndTouchListener.busiType == 1) && (i != 0); i = 0)
          {
            if (paramOnLongClickAndTouchListener.progress > 60) {
              paramOnLongClickAndTouchListener.progress = 60;
            }
            a(paramOnLongClickAndTouchListener, localHolder, paramOnLongClickAndTouchListener.videoFileProgress, paramOnLongClickAndTouchListener.progress, false);
            return paramViewHolder;
          }
          a(paramOnLongClickAndTouchListener, localHolder, paramOnLongClickAndTouchListener.videoFileProgress, false);
          return paramViewHolder;
        }
      }
      if (paramOnLongClickAndTouchListener.videoFileStatus == 2005) {
        c(paramOnLongClickAndTouchListener, localHolder);
      }
      if (paramOnLongClickAndTouchListener.videoFileStatus == 5002)
      {
        a(paramOnLongClickAndTouchListener, "getBubbleView():短视频已过期不启动下载流程 1");
        b(paramOnLongClickAndTouchListener, localHolder, 2131432996);
        return paramViewHolder;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramOnLongClickAndTouchListener, true))
      {
        a(paramOnLongClickAndTouchListener, true);
        return paramViewHolder;
      }
      if ((paramOnLongClickAndTouchListener.videoFileStatus == 2001) || (paramOnLongClickAndTouchListener.videoFileStatus == 2002) || (paramOnLongClickAndTouchListener.videoFileStatus == 2000))
      {
        a(paramOnLongClickAndTouchListener, localHolder, paramOnLongClickAndTouchListener.videoFileProgress, false);
        return paramViewHolder;
      }
      c(paramOnLongClickAndTouchListener, localHolder);
      return paramViewHolder;
    }
    if (paramOnLongClickAndTouchListener.videoFileStatus == 5002)
    {
      a(paramOnLongClickAndTouchListener, "getBubbleView():短视频已过期不启动下载流程 2");
      ((ShortVideoRealItemBuilder.ChatVideoView)localObject1).setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(paramOnLongClickAndTouchListener, localHolder, 2131432996);
      return paramViewHolder;
    }
    a(paramOnLongClickAndTouchListener, "getBubbleView: 下占位图");
    ((ShortVideoRealItemBuilder.ChatVideoView)localObject1).setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    a(paramOnLongClickAndTouchListener);
    return paramViewHolder;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ShortVideoRealItemBuilder.Holder)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView;
      }
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoRealItemBuilder.Holder(this);
  }
  
  public ShortVideoRealItemBuilder.Holder a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int i = AIOUtils.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (i <= -1) {
        break label225;
      }
      Object localObject = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, i);
      if (localObject != null)
      {
        localObject = AIOUtils.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof ShortVideoRealItemBuilder.Holder))) {
          return (ShortVideoRealItemBuilder.Holder)localObject;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + i + ", view = null");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + i + ", firstVisblePosi=" + k + ",lastVisblePosi=" + m + ",headerCount=" + j);
      }
    }
    for (;;)
    {
      return null;
      label225:
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi<= -1");
      }
    }
  }
  
  public ProgressPieDrawable a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.mProgressPie != null) {
      return paramMessageForShortVideo.mProgressPie;
    }
    ProgressPieDrawable localProgressPieDrawable = a();
    paramMessageForShortVideo.mProgressPie = localProgressPieDrawable;
    return localProgressPieDrawable;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "视频消息";
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
        break label98;
      }
      paramMessageForShortVideo = paramMessageForShortVideo.replaceAll("[\\t\\n\\r]", "");
      boolean bool = TextUtils.isEmpty(paramMessageForShortVideo);
      if (bool) {
        break label98;
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
    Object localObject = jdField_a_of_type_JavaUtilMap.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((Iterator)localObject).next();
      if (localMessageForShortVideo.progressTask != null) {
        localMessageForShortVideo.progressTask = null;
      }
    }
    jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidContentContext = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if ((localObject != null) && (((MessageForShortVideo)localObject).progressTask != null)) {
      ((MessageForShortVideo)localObject).progressTask = null;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt == 2131375633)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
        StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131375643)
    {
      super.c(paramChatMessage);
      StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
      return;
    }
    if (paramInt == 2131363536)
    {
      paramInt = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
      if (paramInt == 3) {
        paramContext = "1";
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
        StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "1", "", "", "" });
        b(localMessageForShortVideo);
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
    if (paramInt == 2131366774)
    {
      QfavBuilder.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
      StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      return;
    }
    if (paramInt == 2131361906)
    {
      super.a(localMessageForShortVideo);
      StoryReportor.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    if (paramInt == 2131375634)
    {
      paramContext = new StringBuilder();
      paramContext.append("uniseq:").append(localMessageForShortVideo.uniseq).append("\n");
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.a(2131433649, 5);
    localActionSheet.c(2131433029);
    localActionSheet.a(new vll(this, localMessageForShortVideo, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558623);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.uniseq != paramFileMsg.jdField_b_of_type_Long) {}
    ShortVideoRealItemBuilder.ChatVideoView localChatVideoView;
    Object localObject;
    label93:
    int i;
    int j;
    label349:
    label1403:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localChatVideoView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView;
              this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.mShowProgressTask);
              if (localMessageForShortVideo.mShowProgressTask != null) {
                localMessageForShortVideo.mShowProgressTask = null;
              }
            } while (this.jdField_a_of_type_AndroidContentContext == null);
            localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
            if (localMessageForShortVideo.thumbWidth > 0)
            {
              paramInt1 = localMessageForShortVideo.thumbWidth;
              if (localMessageForShortVideo.thumbHeight <= 0) {
                break label349;
              }
            }
            for (paramInt2 = localMessageForShortVideo.thumbHeight;; paramInt2 = 100)
            {
              i = AIOUtils.a(paramInt1, (Resources)localObject);
              j = AIOUtils.a(paramInt2, (Resources)localObject);
              if ((paramFileMsg.jdField_b_of_type_Int != 6) && (paramFileMsg.jdField_b_of_type_Int != 17) && (paramFileMsg.jdField_b_of_type_Int != 9) && (paramFileMsg.jdField_b_of_type_Int != 20)) {
                break label1214;
              }
              switch (paramFileMsg.jdField_d_of_type_Int)
              {
              default: 
                return;
              case 1001: 
                a(localMessageForShortVideo, "VIDEO STATUS_SEND_START progress " + localMessageForShortVideo.videoFileProgress);
                if (localMessageForShortVideo.busiType != 1) {
                  a(localMessageForShortVideo, paramView, localMessageForShortVideo.videoFileProgress, true);
                }
                paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
                return;
                paramInt1 = 100;
                break label93;
              }
            }
            a(localMessageForShortVideo, "VIDEO STATUS_UPLOAD_FINISHED progress " + localMessageForShortVideo.videoFileProgress);
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_SEND_FINISHED");
            c(localMessageForShortVideo);
            a(localMessageForShortVideo.mVideoFileSourceDir);
            a(localMessageForShortVideo, paramView, 100, true);
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_SEND_ERROR");
            c(localMessageForShortVideo);
            b(localMessageForShortVideo, paramView, 2131432999);
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_SEND_CANCEL");
            c(localMessageForShortVideo);
            a(paramView);
            return;
            paramInt1 = localMessageForShortVideo.videoFileProgress;
            a(localMessageForShortVideo, "VIDEO STATUS_SEND_PROCESS " + paramInt1);
            a(localMessageForShortVideo, paramView, paramInt1);
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_RECV_START");
            a(localMessageForShortVideo, paramView, localMessageForShortVideo.videoFileProgress, true);
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_RECV_FINISHED");
            if (!ShortVideoUtils.ShortVideoPlayConfig.jdField_b_of_type_Boolean) {
              break;
            }
            paramFileMsg = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
            a(localMessageForShortVideo, "handleMessage: 刷视频 " + paramFileMsg);
            if ((ShortVideoUtils.a()) && (FileUtils.b(paramFileMsg)))
            {
              a(localMessageForShortVideo, "getBubbleView: 刷视频 " + paramFileMsg);
              paramFileMsg = a(paramFileMsg, ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg"), localMessageForShortVideo, paramInt1, paramInt2);
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.setURLDrawable(paramFileMsg);
              b(paramView);
              if (!localMessageForShortVideo.isSend()) {
                new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
              }
            }
            a(localMessageForShortVideo, paramView, 100, true);
          } while (!localMessageForShortVideo.isMultiMsg);
          a(paramView);
          return;
          paramFileMsg = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
          if (FileUtils.b(paramFileMsg))
          {
            if (!localChatVideoView.a(paramFileMsg)) {
              break label824;
            }
            localObject = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
            ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = j;
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            localChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramFileMsg), (URLDrawable.URLDrawableOptions)localObject));
          }
          for (;;)
          {
            c(localMessageForShortVideo, paramView);
            return;
            paramFileMsg = localChatVideoView.b;
            if ((paramFileMsg != null) && (paramFileMsg.getStatus() == 1)) {
              localChatVideoView.setURLDrawable(paramFileMsg);
            }
          }
          a(localMessageForShortVideo, "VIDEO STATUS_FILE_UNSAFE");
          b(localMessageForShortVideo, paramView, 2131432997);
          if (localMessageForShortVideo.uiOperatorFlag == 2)
          {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437400, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
            return;
          }
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437388, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
          return;
          a(localMessageForShortVideo, "VIDEO STATUS_RECV_ERROR");
          a(paramView);
          c(localMessageForShortVideo, paramView);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437387, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
          return;
          a(localMessageForShortVideo, "VIDEO STATUS_FILE_EXPIRED");
          paramFileMsg = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
          if (FileUtils.b(paramFileMsg))
          {
            if (!localChatVideoView.a(paramFileMsg)) {
              break label1109;
            }
            a(localMessageForShortVideo, "STATUS_FILE_EXPIRED: 刷缩略图 " + paramFileMsg);
            localObject = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            localChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramFileMsg), (URLDrawable.URLDrawableOptions)localObject));
          }
          for (;;)
          {
            b(localMessageForShortVideo, paramView, 2131432996);
            return;
            a(localMessageForShortVideo, "STATUS_FILE_EXPIRED: 刷缩略图用缓存 " + paramFileMsg);
            paramFileMsg = localChatVideoView.b;
            if ((paramFileMsg != null) && (paramFileMsg.getStatus() == 1)) {
              localChatVideoView.setURLDrawable(paramFileMsg);
            }
          }
          a(localMessageForShortVideo, "VIDEO STATUS_RECV_CANCEL");
          return;
          paramInt1 = localMessageForShortVideo.videoFileProgress;
          a(localMessageForShortVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
          a(localMessageForShortVideo, paramView, paramInt1, true);
          return;
        } while ((paramFileMsg.jdField_b_of_type_Int != 7) && (paramFileMsg.jdField_b_of_type_Int != 18) && (paramFileMsg.jdField_b_of_type_Int != 16));
        switch (paramFileMsg.jdField_d_of_type_Int)
        {
        default: 
          return;
        case 2001: 
          a(localMessageForShortVideo, "THUMB STATUS_RECV_START");
          return;
        case 2003: 
          a(localMessageForShortVideo, "THUMB STATUS_RECV_FINISHED");
          paramFileMsg = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
          localObject = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
          if ((!FileUtils.b((String)localObject)) || (!ShortVideoUtils.ShortVideoPlayConfig.jdField_b_of_type_Boolean)) {
            break label1403;
          }
          a(localMessageForShortVideo, "STATUS_RECV_FINISHED: 刷缩略图视频存在 " + paramFileMsg);
        }
      } while (!ShortVideoUtils.a());
      paramFileMsg = a((String)localObject, paramFileMsg, localMessageForShortVideo, paramInt1, paramInt2);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.setURLDrawable(paramFileMsg);
      b(paramView);
      return;
      if (!FileUtils.b(paramFileMsg)) {
        break;
      }
    } while (!localChatVideoView.a(paramFileMsg));
    label824:
    label1109:
    a(localMessageForShortVideo, "STATUS_RECV_FINISHED: 刷缩略图 " + paramFileMsg);
    label1214:
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = j;
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramFileMsg), localURLDrawableOptions));
    if (!FileUtils.b((String)localObject))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo, true))
      {
        a(localMessageForShortVideo, true);
        return;
      }
      c(localMessageForShortVideo, paramView);
      return;
    }
    if (ShortVideoUtils.a())
    {
      a(paramView);
      return;
    }
    c(localMessageForShortVideo, paramView);
    return;
    localChatVideoView.setImageDrawable(URLDrawableHelper.a());
    return;
    a(localMessageForShortVideo, "THUMB STATUS_FILE_EXPIRED");
    a(localMessageForShortVideo, "THUMB STATUS_RECV_ERROR");
    paramFileMsg = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (FileUtils.b(paramFileMsg)) {
      if (localChatVideoView.a(paramFileMsg))
      {
        a(localMessageForShortVideo, "STATUS_RECV_ERROR: 缩略图下载失败刷视频 " + paramFileMsg);
        if (ShortVideoUtils.a())
        {
          paramFileMsg = a(paramFileMsg, ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg"), localMessageForShortVideo, paramInt1, paramInt2);
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.setURLDrawable(paramFileMsg);
          b(paramView);
        }
      }
    }
    for (;;)
    {
      a(paramView);
      return;
      paramFileMsg = localChatVideoView.b;
      if ((paramFileMsg != null) && (paramFileMsg.getStatus() == 1))
      {
        localChatVideoView.setURLDrawable(paramFileMsg);
        continue;
        localChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
    }
  }
  
  public void a(ShortVideoRealItemBuilder.Holder paramHolder)
  {
    if (!paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[hideProgress] set ProgressPieDrawable visible");
      }
      return;
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new vlm(this, paramHolder));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, ShortVideoRealItemBuilder.Holder paramHolder, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      if (paramMessageRecord.redBagType != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label108;
      }
      if (paramHolder.jdField_e_of_type_Int != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label40;
      }
    }
    label40:
    label108:
    do
    {
      do
      {
        return;
        paramHolder.jdField_e_of_type_Int = LocalMediaInfo.REDBAG_TYPE_GET;
        paramQQAppInterface = new vlg(this, paramQQAppInterface);
        paramHolder = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131439154));
        paramHolder.setSpan(new ForegroundColorSpan(-1), 0, paramHolder.length(), 17);
        paramBaseChatItemLayout.setTailMessage(true, paramHolder, paramQQAppInterface, RedBagVideoManager.a());
        return;
        if ((!paramMessageRecord.CheckIsDanceVideo()) || (!DanceGameVideoManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
          break;
        }
      } while (paramHolder.jdField_e_of_type_Int == 2);
      paramHolder.jdField_e_of_type_Int = 2;
      boolean bool3 = CaptureUtil.a();
      boolean bool4 = ShortVideoGuideUtil.h(paramQQAppInterface);
      paramQQAppInterface = new vlh(this, bool3, bool4, paramQQAppInterface);
      paramHolder = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131439157));
      paramHolder.setSpan(new ForegroundColorSpan(-1), 0, paramHolder.length(), 17);
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      paramBaseChatItemLayout.setTailMessage(true, paramHolder, paramQQAppInterface, bool1);
      return;
    } while (paramHolder.jdField_e_of_type_Int == 0);
    paramHolder.jdField_e_of_type_Int = 0;
    paramBaseChatItemLayout.setTailMessage(false, null, null);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(2, 2);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.jdField_b_of_type_Int);
    localShortVideoDownloadInfo.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
    localShortVideoDownloadInfo.jdField_f_of_type_Int = 2;
    localShortVideoDownloadInfo.g = 2;
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder)
  {
    a(paramMessageForShortVideo, "startUploadVideo：" + paramMessageForShortVideo.toString());
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.b((String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131437377, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!FileUtils.b(str))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131437378, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    localObject = ShortVideoBusiManager.a(1, 2);
    ((ShortVideoReq)localObject).a(ShortVideoBusiManager.a(2, paramMessageForShortVideo, (ShortVideoReq)localObject));
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, true);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt)
  {
    int i = ShortVideoUtils.a(paramInt, 10);
    if (paramMessageForShortVideo.busiType == 1)
    {
      if (i < 60) {
        return;
      }
      if (paramMessageForShortVideo.progressTask != null)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
        paramMessageForShortVideo.progressTask = null;
        a(paramMessageForShortVideo, "VIDEO STATUS_SEND_PROCESS CLOSE_TASK PROCESS:" + i);
      }
    }
    a(paramMessageForShortVideo, paramHolder, paramInt, true);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((ShortVideoUtils.a(paramMessageForShortVideo.videoFileProgress, 10) > 60) || (paramInt2 > 60)) {
      return;
    }
    ProgressPieDrawable localProgressPieDrawable = a(paramMessageForShortVideo);
    localProgressPieDrawable.a();
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramInt2 = ShortVideoUtils.a(paramInt2, 0);
    if (paramBoolean) {
      localProgressPieDrawable.b(paramInt2);
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt2, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt1 + ", current:" + localProgressPieDrawable.a() + ", progress:" + paramInt2);
      }
      localProgressPieDrawable.b(true);
      localProgressPieDrawable.d(false);
      localProgressPieDrawable.e(1426063360);
      localProgressPieDrawable.a(String.valueOf(paramInt2) + "%");
      if ((paramMessageForShortVideo.progressTask == null) || (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))) {
        break;
      }
      paramMessageForShortVideo.progress += 3;
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(paramMessageForShortVideo.progressTask, 1000L);
      return;
      localProgressPieDrawable.c(paramInt2);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt, boolean paramBoolean)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    ProgressPieDrawable localProgressPieDrawable = a(paramMessageForShortVideo);
    localProgressPieDrawable.a();
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramInt = ShortVideoUtils.a(paramInt, 10);
    if (paramBoolean) {
      localProgressPieDrawable.b(paramInt);
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt + ", current:" + localProgressPieDrawable.a());
      }
      localProgressPieDrawable.b(true);
      localProgressPieDrawable.d(false);
      localProgressPieDrawable.e(1426063360);
      localProgressPieDrawable.a(String.valueOf(paramInt) + "%");
      return;
      localProgressPieDrawable.c(paramInt);
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    int j = 1;
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, "downloadVideo():短视频已过期不启动下载流程");
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label102;
      }
    }
    label102:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label107;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131434786, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      return;
      i = 0;
      break;
    }
    label107:
    localObject = ShortVideoBusiManager.a(2, 2);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(((ShortVideoReq)localObject).jdField_b_of_type_Int);
    localShortVideoDownloadInfo.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 0);
    i = j;
    if (paramBoolean) {
      i = 2;
    }
    localShortVideoDownloadInfo.jdField_f_of_type_Int = i;
    localShortVideoDownloadInfo.g = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localShortVideoDownloadInfo.jdField_e_of_type_Int + ", uniseq:" + paramMessageForShortVideo.uniseq);
    }
    ((ShortVideoReq)localObject).a(localShortVideoDownloadInfo);
    ((ShortVideoReq)localObject).a(paramMessageForShortVideo);
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  void a(String paramString)
  {
    ThreadManager.post(new vlk(this, paramString), 5, null, false);
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
      } while ((paramChatMessage.md5 == null) || (paramChatMessage.videoFileStatus == 5002));
      paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramBaseChatItemLayout instanceof BaseTransProcessor))
      {
        if (((BaseTransProcessor)paramBaseChatItemLayout).c() == 1005L) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      if (paramChatMessage.videoFileStatus == 1005) {
        return true;
      }
    } while ((paramChatMessage.videoFileProgress == 100) || (paramChatMessage.videoFileStatus == 1003) || (paramChatMessage.videoFileStatus == 2003));
    return true;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    String str2;
    if ((!TextUtils.isEmpty(localMessageForShortVideo.md5)) && ((!localMessageForShortVideo.mPreUpload) || (!TextUtils.isEmpty(localMessageForShortVideo.mLocalMd5))))
    {
      String str1 = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      str2 = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      if (FileUtils.b(str1)) {
        if ((paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
          break label217;
        }
      }
    }
    label217:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localQQCustomMenu.a(2131363536, this.jdField_a_of_type_AndroidContentContext.getString(2131435099), 2130838318);
        a(localMessageForShortVideo, localQQCustomMenu);
        if (FileUtils.b(str2)) {
          localQQCustomMenu.a(2131366774, this.jdField_a_of_type_AndroidContentContext.getString(2131431574), 2130838317);
        }
      }
      if (i == 0) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
    }
  }
  
  protected void b(ShortVideoRealItemBuilder.Holder paramHolder)
  {
    if (!paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new vln(this, paramHolder));
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      a(paramMessageForShortVideo, "Forward menu clicked, md5 is empty.");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putString("from_uin", ShortVideoUtils.b(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo);
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
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    a(paramMessageForShortVideo, "startUploadVideo：" + paramMessageForShortVideo.toString());
    if (!FileUtils.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131437378, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
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
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130845666);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    paramMessageForShortVideo = a(paramMessageForShortVideo);
    paramMessageForShortVideo.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845666));
    paramMessageForShortVideo.c(0);
    paramMessageForShortVideo.d(true);
    paramMessageForShortVideo.a();
    paramMessageForShortVideo.e(0);
    paramMessageForShortVideo.b(false);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showWarnProgress] set ProgressPieDrawable visible,ppd = " + paramMessageForShortVideo);
    }
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  void c(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramMessageForShortVideo = a(paramMessageForShortVideo);
    paramMessageForShortVideo.setVisible(true, true);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showPauseProgress] set ProgressPieDrawable visible,ppd = " + paramMessageForShortVideo);
    }
    paramMessageForShortVideo.c(0);
    paramMessageForShortVideo.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843035));
    paramMessageForShortVideo.a();
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramMessageForShortVideo.b(false);
    paramMessageForShortVideo.d(true);
    paramMessageForShortVideo.e(0);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView.getId() == 2131361860)
    {
      localObject = (MessageRecord)paramView.getTag();
      if (localObject != null) {
        ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).a(paramView.getContext(), (MessageRecord)localObject);
      }
    }
    MessageForShortVideo localMessageForShortVideo;
    do
    {
      do
      {
        return;
        localObject = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
        localMessageForShortVideo = (MessageForShortVideo)((ShortVideoRealItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while (paramView.getId() == 2131361903);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131428992, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        return;
      }
      if (paramView.getId() != 2131361877) {
        break;
      }
    } while (localMessageForShortVideo.md5 == null);
    if (localMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
      RedBagVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    }
    FlowCameraMqqAction.b("", "0X8006A1C");
    ShortVideoMtaReport.a("shortvideo_bubble", null);
    StoryReportor.a("story_grp", "aio_msg", 0, 0, new String[] { "", "", "", "" });
    String str = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))
    {
      a(localMessageForShortVideo, false);
      a(localMessageForShortVideo, (ShortVideoRealItemBuilder.Holder)localObject, localMessageForShortVideo.videoFileProgress, false);
      if (!localMessageForShortVideo.isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
      }
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if (FileUtils.b(str))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
        if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext)) {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo, ((ShortVideoRealItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        } else {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430812), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131558448));
        }
      }
    }
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onStateChange => " + QQLiveImage.getStateStr(paramInt) + ", msgUniseq=" + paramQQLiveDrawableParams.msgUniseq + ", extra = " + paramObject);
    }
    if (paramInt == 2)
    {
      paramString = AIOSingleReporter.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq));
      if ((paramString != null) && (!AIOSingleReporter.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq))))
      {
        ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        if (!AIOSingleReporter.a().b(Long.valueOf(paramString.uniseq)))
        {
          AIOSingleReporter.a().a(Long.valueOf(paramString.uniseq));
          ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        }
        AIOSingleReporter.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq), true);
      }
    }
    paramString = a(paramQQLiveDrawableParams.msgUniseq);
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "holder == null, msgUniseq=" + paramQQLiveDrawableParams.msgUniseq);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt == 3);
      if ((paramInt == 5) || (paramInt == 6))
      {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        paramString.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        a(paramString);
        return;
      }
      if (paramInt == 2)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        b(paramString);
        return;
      }
    } while (paramInt != 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder
 * JD-Core Version:    0.7.0.1
 */