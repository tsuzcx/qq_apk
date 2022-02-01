package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.video.AioVideoTransFileController;
import com.tencent.mobileqq.widget.AudioAnimationView;
import com.tencent.mobileqq.widget.CircleProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.lang.ref.WeakReference;

public class ShortVideoPTVItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback, ShortVideoConstants
{
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new EmptyDrawable(-10065297, c, d);
  public static WeakReference<VideoDrawable> a;
  private static WeakReference<MessageForShortVideo> jdField_b_of_type_JavaLangRefWeakReference;
  static int c;
  static int d;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    c = AIOUtils.a(160.0F, localResources);
    d = AIOUtils.a(160.0F, localResources);
  }
  
  public ShortVideoPTVItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    ShortVideoUtils.loadShortVideoSo(paramQQAppInterface);
    ShortVideoPTVItemBuilder.PtvPlayConfig.a();
  }
  
  private View a(View paramView, ShortVideoPTVItemBuilder.Holder paramHolder, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      String str = paramMessageForShortVideo.mThumbFilePath;
      if (!FileUtils.b(str)) {
        break label146;
      }
      if (paramChatVideoView.a(str))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 占坑 msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramChatVideoView.b(URLDrawable.getDrawable(new File(str), localURLDrawableOptions));
        a(paramHolder);
        Utils.executeAsyncTaskOnSerialExcuter(new ShortVideoPTVItemBuilder.EncodeTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo), new Void[] { (Void)null });
      }
    }
    label146:
    do
    {
      return paramView;
      paramChatVideoView.setImageDrawable(URLDrawableHelper.getFailedDrawable());
      b(paramHolder);
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView():You must get thumb before send video. msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return paramView;
  }
  
  private View a(View paramView, ShortVideoPTVItemBuilder.Holder paramHolder, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    if (paramChatVideoView.a(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图 " + paramString1 + " msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramChatVideoView.b(URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions));
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      if (!FileUtils.b(paramString2)) {
        break label253;
      }
      if ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileProgress > 100) || (paramMessageForShortVideo.videoFileStatus == 1003)) {
        break;
      }
      a(paramHolder, paramMessageForShortVideo.videoFileProgress);
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图用缓存 " + paramString1 + " msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramString1 = paramChatVideoView.b;
      if ((paramString1 != null) && (paramString1.getStatus() == 1)) {
        paramChatVideoView.b(paramString1);
      }
    }
    if ((ShortVideoUtils.isVideoSoLibLoaded()) && (ShortVideoPTVItemBuilder.PtvPlayConfig.b))
    {
      b(paramHolder);
      return paramView;
    }
    c(paramHolder);
    return paramView;
    label253:
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 1 msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      b(paramHolder, 2131718625);
      return paramView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
    {
      a(paramMessageForShortVideo, true);
      a(paramHolder, paramMessageForShortVideo.videoFileProgress);
      return paramView;
    }
    if (BaseTransProcessor.class.isInstance(((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq)))
    {
      a(paramHolder, paramMessageForShortVideo.videoFileProgress);
      return paramView;
    }
    c(paramHolder);
    return paramView;
  }
  
  private void a(ShortVideoPTVItemBuilder.Holder paramHolder, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramChatVideoView.a(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 视频存在,刷缩略图 " + paramString1);
      }
      if (ShortVideoUtils.isVideoSoLibLoaded())
      {
        paramString1 = URLDrawable.URLDrawableOptions.obtain();
        paramString1.mRequestWidth = paramInt1;
        paramString1.mRequestHeight = paramInt2;
        paramString1.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramString1.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
        localVideoDrawableParams.mPlayVideoFrame = true;
        localVideoDrawableParams.mVideoRoundCorner = 0;
        localVideoDrawableParams.mRequestedFPS = ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_a_of_type_Int;
        paramString1.mExtraInfo = localVideoDrawableParams;
        paramChatVideoView.b(URLDrawable.getDrawable(new File(paramString2), paramString1));
      }
    }
    for (;;)
    {
      b(paramHolder);
      return;
      paramString1 = paramChatVideoView.b;
      if ((paramString1 != null) && (paramString1.getStatus() == 1)) {
        paramChatVideoView.b(paramString1);
      }
    }
  }
  
  private void a(ShortVideoPTVItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_UNSAFE");
    }
    b(paramHolder);
    if (paramMessageForShortVideo.uiOperatorFlag == 2)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719361, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719385, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
  }
  
  private void a(ShortVideoPTVItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, URLDrawable paramURLDrawable)
  {
    paramURLDrawable = (VideoDrawable)paramURLDrawable.getCurrDrawable();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " videoDrawable.isAudioPlaying(): " + paramURLDrawable.isAudioPlaying());
    }
    if (paramURLDrawable.isAudioPlaying())
    {
      paramURLDrawable.stopAudio();
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      jdField_b_of_type_JavaLangRefWeakReference = null;
      return;
    }
    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
    }
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != paramURLDrawable) && (((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).isAudioPlaying()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "onCLick sPlayingAudioDrawable.get() not null && isAudioPlaying, need stop audio.");
      }
      ((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).stopAudio();
      if ((jdField_b_of_type_JavaLangRefWeakReference != null) && (jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        a(this.jdField_a_of_type_ComTencentWidgetListView, (ChatMessage)jdField_b_of_type_JavaLangRefWeakReference.get());
        jdField_b_of_type_JavaLangRefWeakReference = null;
      }
    }
    paramURLDrawable.resetAndPlayAudioOnce();
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramURLDrawable);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
    jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramMessageForShortVideo);
    paramURLDrawable.setOnAudioPlayOnceListener(new ShortVideoPTVItemBuilder.2(this));
  }
  
  private void a(ShortVideoPTVItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (FileUtils.b(paramString1))
    {
      if (paramChatVideoView.a(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 缩略图存在，刷缩略图 " + paramString1);
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramInt1;
        localURLDrawableOptions.mRequestHeight = paramInt2;
        localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramChatVideoView.b(URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions));
        if (FileUtils.b(paramString2)) {
          break label169;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=true, downloadVideo");
          }
          a(paramMessageForShortVideo, true);
        }
      }
      else
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=false, showPauseProgress");
      }
      c(paramHolder);
      return;
      label169:
      if (ShortVideoUtils.isVideoSoLibLoaded())
      {
        b(paramHolder);
        return;
      }
      c(paramHolder);
      return;
    }
    paramChatVideoView.setImageDrawable(URLDrawableHelper.getFailedDrawable());
  }
  
  private void a(ShortVideoPTVItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, String paramString, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_RECV_FINISHED");
    }
    if (ShortVideoPTVItemBuilder.PtvPlayConfig.b)
    {
      String str = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
      if (paramChatVideoView.a(str))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "handleMessage: 刷视频 " + str);
        if ((ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.b(str)))
        {
          paramString = URLDrawable.URLDrawableOptions.obtain();
          paramString.mRequestWidth = paramInt1;
          paramString.mRequestHeight = paramInt2;
          paramString.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramString.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
          localVideoDrawableParams.mPlayVideoFrame = true;
          localVideoDrawableParams.mVideoRoundCorner = 0;
          localVideoDrawableParams.mRequestedFPS = ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_a_of_type_Int;
          paramString.mExtraInfo = localVideoDrawableParams;
          paramString = URLDrawable.getDrawable(new File(str), paramString);
          if (paramString.getStatus() != 1) {
            break label337;
          }
          paramChatVideoView.b(paramString);
        }
      }
      for (;;)
      {
        if (!paramMessageForShortVideo.isSend()) {
          new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
        }
        if (paramMessageForShortVideo.subBusiType == 1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + paramMessageForShortVideo.uuid, "" + paramMessageForShortVideo.isSend());
        }
        b(paramHolder);
        paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(0);
        return;
        label337:
        paramChatVideoView.a(paramString);
      }
    }
    paramMessageForShortVideo = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if (FileUtils.b(paramMessageForShortVideo))
    {
      if (!paramChatVideoView.a(paramMessageForShortVideo)) {
        break label426;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestWidth = paramInt1;
      paramString.mRequestHeight = paramInt2;
      paramString.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramString.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramChatVideoView.b(URLDrawable.getDrawable(new File(paramMessageForShortVideo), paramString));
    }
    for (;;)
    {
      c(paramHolder);
      return;
      label426:
      paramMessageForShortVideo = paramChatVideoView.b;
      if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.getStatus() == 1)) {
        paramChatVideoView.b(paramMessageForShortVideo);
      }
    }
  }
  
  private void a(FileMsg paramFileMsg, ShortVideoPTVItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView)
  {
    if (QLog.isColorLevel())
    {
      if (paramFileMsg.status == 2005) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_ERROR");
      }
    }
    else
    {
      paramMessageForShortVideo = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
      if (FileUtils.b(paramMessageForShortVideo))
      {
        if (!paramChatVideoView.a(paramMessageForShortVideo)) {
          break label154;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图 " + paramMessageForShortVideo);
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramChatVideoView.b(URLDrawable.getDrawable(new File(paramMessageForShortVideo), localURLDrawableOptions));
      }
    }
    for (;;)
    {
      if (paramFileMsg.status != 2005) {
        break label213;
      }
      b(paramHolder, 2131718629);
      return;
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_EXPIRED");
      break;
      label154:
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图用缓存 " + paramMessageForShortVideo);
      }
      paramMessageForShortVideo = paramChatVideoView.b;
      if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.getStatus() == 1)) {
        paramChatVideoView.b(paramMessageForShortVideo);
      }
    }
    label213:
    b(paramHolder, 2131718625);
  }
  
  public static void a(ListView paramListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bool1 = bool2;
      if (jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        bool1 = bool2;
        if (((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).isAudioPlaying())
        {
          ((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).stopAudio();
          bool2 = true;
          bool1 = bool2;
          if (jdField_b_of_type_JavaLangRefWeakReference != null)
          {
            bool1 = bool2;
            if (jdField_b_of_type_JavaLangRefWeakReference.get() != null)
            {
              a(paramListView, (ChatMessage)jdField_b_of_type_JavaLangRefWeakReference.get());
              bool1 = bool2;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "stopAudioIfPlaying(), stopSuccess = " + bool1);
    }
  }
  
  static void a(ListView paramListView, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (paramListView != null))
    {
      i = AIOUtils.a(paramChatMessage.uniseq, paramListView.getAdapter());
      if (i > -1)
      {
        paramListView = AIOUtils.a(paramListView, i);
        if (paramListView != null)
        {
          paramListView = AIOUtils.a(paramListView);
          if ((paramListView != null) && ((paramListView instanceof ShortVideoPTVItemBuilder.Holder)))
          {
            paramListView = (ShortVideoPTVItemBuilder.Holder)paramListView;
            if (paramListView != null) {
              paramListView.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
            }
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      return;
    }
    QLog.e("ShortVideoPTVItemBuilder", 2, "stopAudioAnimByMsg(), message = " + paramChatMessage);
  }
  
  private View b(View paramView, ShortVideoPTVItemBuilder.Holder paramHolder, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
    }
    Object localObject;
    if (paramChatVideoView.a(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频 " + paramString2 + " msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      if (!paramChatVideoView.a(paramString1)) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramChatVideoView.b;
      }
      VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
      localVideoDrawableParams.mPlayVideoFrame = true;
      localVideoDrawableParams.mPlayAudioFrame = false;
      localVideoDrawableParams.mVideoRoundCorner = 0;
      localVideoDrawableParams.mRequestedFPS = ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = localVideoDrawableParams;
      localObject = URLDrawable.getDrawable(new File(paramString2), (URLDrawable.URLDrawableOptions)localObject);
      paramChatVideoView.b((URLDrawable)localObject);
      if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))
      {
        boolean bool = ((VideoDrawable)((URLDrawable)localObject).getCurrDrawable()).isAudioPlaying();
        if (!bool) {
          break label425;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频, isAudioPlaying= " + bool + ", videoPath:" + paramString2 + " msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
      }
    }
    for (;;)
    {
      if (!FileUtils.b(paramString1))
      {
        a(paramMessageForShortVideo);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: Video file exist and status finish. Thumb not exist. msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
      }
      if (!paramMessageForShortVideo.isSendFromLocal()) {
        break label576;
      }
      paramChatVideoView = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if (!BaseTransProcessor.class.isInstance(paramChatVideoView)) {
        break label569;
      }
      if (((BaseTransProcessor)paramChatVideoView).getFileStatus() == 1002L) {
        a(paramHolder, paramMessageForShortVideo.videoFileProgress);
      }
      return paramView;
      label425:
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      break;
      localObject = paramChatVideoView.b;
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
      {
        paramChatVideoView.b((URLDrawable)localObject);
        if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))
        {
          paramChatVideoView = (VideoDrawable)((URLDrawable)localObject).getCurrDrawable();
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频用缓存, isAudioPlaying= " + paramChatVideoView.isAudioPlaying() + ", videoPath:" + paramString2 + " msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
          if (paramChatVideoView.isAudioPlaying()) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
          } else {
            paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
          }
        }
      }
    }
    label569:
    b(paramHolder);
    return paramView;
    label576:
    b(paramHolder);
    return paramView;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramOnLongClickAndTouchListener = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramOnLongClickAndTouchListener != null) {
      paramOnLongClickAndTouchListener.a(paramView, this);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) && ((paramViewGroup instanceof ListView))) {
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup);
    }
    try
    {
      paramViewGroup = (ShortVideoPTVItemBuilder.Holder)paramView.getTag();
      float f = ((MessageForShortVideo)paramChatMessage).videoFileSize / 1000;
      paramViewGroup.b.append(f);
      paramViewGroup.b.append("K");
      paramViewGroup.b.append(String.valueOf(((MessageForShortVideo)paramChatMessage).videoFileTime));
      paramViewGroup.b.append("秒");
      paramView.setContentDescription(paramViewGroup.b.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (ShortVideoPTVItemBuilder.Holder)paramViewHolder;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject3 = ((Context)localObject1).getResources();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView(), message = " + paramChatMessage);
    }
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout((Context)localObject1);
      int i = AIOUtils.a(160.0F, (Resources)localObject3);
      int j = AIOUtils.a(160.0F, (Resources)localObject3);
      paramView = new ShortVideoPTVItemBuilder.ChatVideoView((Context)localObject1);
      paramView.setId(2131373117);
      paramView.setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new CircleProgressView((Context)localObject1);
      ((CircleProgressView)localObject2).setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.addRule(13);
      paramViewHolder.addView((View)localObject2, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(8, 2131373117);
      localLayoutParams.bottomMargin = AIOUtils.a(6.0F, (Resources)localObject3);
      localObject3 = new AudioAnimationView((Context)localObject1);
      ((AudioAnimationView)localObject3).setRectCount(7);
      ((AudioAnimationView)localObject3).setSyle(1);
      ((AudioAnimationView)localObject3).setIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838335));
      paramViewHolder.addView((View)localObject3, localLayoutParams);
      localObject1 = new ImageView((Context)localObject1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      ((ImageView)localObject1).setVisibility(8);
      paramViewHolder.addView((View)localObject1, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView = ((CircleProgressView)localObject2);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView = ((AudioAnimationView)localObject3);
    }
    for (;;)
    {
      paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView;
      paramOnLongClickAndTouchListener = (MessageForShortVideo)paramChatMessage;
      paramView.c = paramOnLongClickAndTouchListener.isSend();
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIsSend(paramOnLongClickAndTouchListener.isSend());
      if (e)
      {
        localObject1 = new StringBuilder();
        if (!paramChatMessage.isSend()) {
          break label530;
        }
        ((StringBuilder)localObject1).append("你发出视频对讲消息,");
      }
      for (;;)
      {
        float f = ((MessageForShortVideo)paramChatMessage).videoFileSize / 1000;
        ((StringBuilder)localObject1).append("文件大小:");
        ((StringBuilder)localObject1).append(f);
        ((StringBuilder)localObject1).append("K ");
        ((StringBuilder)localObject1).append("视频时长:");
        ((StringBuilder)localObject1).append(String.valueOf(((MessageForShortVideo)paramChatMessage).videoFileTime));
        ((StringBuilder)localObject1).append("秒");
        paramViewHolder.setContentDescription(((StringBuilder)localObject1).toString());
        if (paramOnLongClickAndTouchListener.md5 != null) {
          break;
        }
        return a(paramViewHolder, paramBaseChatItemLayout, paramView, paramOnLongClickAndTouchListener);
        label530:
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("发出视频对讲消息,");
      }
      paramChatMessage = ShortVideoUtils.getShortVideoThumbPicPath(paramOnLongClickAndTouchListener.thumbMD5, "jpg");
      localObject1 = ShortVideoUtils.getShortVideoSavePath(paramOnLongClickAndTouchListener, "mp4");
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView() videoPath" + (String)localObject1 + "thumbPath=" + paramChatMessage);
      }
      if ((ShortVideoPTVItemBuilder.PtvPlayConfig.b) && (ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.b((String)localObject1)) && ((!paramOnLongClickAndTouchListener.isSendFromLocal()) || (paramOnLongClickAndTouchListener.videoFileStatus == 1003) || (paramOnLongClickAndTouchListener.videoFileStatus == 2003))) {
        return b(paramViewHolder, paramBaseChatItemLayout, paramView, paramOnLongClickAndTouchListener, paramChatMessage, (String)localObject1);
      }
      if (FileUtils.b(paramChatMessage)) {
        return a(paramViewHolder, paramBaseChatItemLayout, paramView, paramOnLongClickAndTouchListener, paramChatMessage, (String)localObject1);
      }
      if (paramOnLongClickAndTouchListener.videoFileStatus == 5002)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 2 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        paramView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        b(paramBaseChatItemLayout, 2131718625);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
        return paramViewHolder;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 下占位图 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      a(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      return paramViewHolder;
      paramViewHolder = paramView;
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ShortVideoPTVItemBuilder.Holder)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView;
      }
    }
    return null;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoPTVItemBuilder.Holder(this);
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131714014);
    }
    return HardCodeUtil.a(2131714003);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt != 2131365636) {
        break label38;
      }
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
    }
    label38:
    do
    {
      do
      {
        return;
        if (paramInt == 2131367398)
        {
          paramInt = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
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
        if (paramInt == 2131366625)
        {
          QfavBuilder.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
          QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
          return;
        }
        if (paramInt != 2131371954) {
          break label422;
        }
        if (localMessageForShortVideo.md5 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoPTVItemBuilder", 2, "onMenuItemClicked: msg_revoke => md5 = null");
      return;
      int i = 1;
      paramContext = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
      paramInt = i;
      if (paramContext != null) {
        if (!ShortVideoUploadProcessor.class.isInstance(paramContext))
        {
          paramInt = i;
          if (!ShortVideoForwardProcessor.class.isInstance(paramContext)) {}
        }
        else
        {
          boolean bool = ((BaseTransProcessor)paramContext).isPause();
          int j = localMessageForShortVideo.videoFileStatus;
          if ((!bool) && (j != 1002))
          {
            paramInt = i;
            if (j != 1001) {}
          }
          else
          {
            i = 0;
            AioVideoTransFileController.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
            ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MSG_FACADE)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
            paramInt = i;
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoPTVItemBuilder", 2, "onMenuItemClicked: stop uploading short video");
              paramInt = i;
            }
          }
        }
      }
    } while (paramInt == 0);
    super.a(2131371954, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo);
    return;
    label422:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ShortVideoPTVItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.addButton(2131690018, 5);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new ShortVideoPTVItemBuilder.1(this, localMessageForShortVideo, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, BaseChatItemLayout.h, 0, BaseChatItemLayout.i);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ShortVideoPTVItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    String str = "handleMessage() msgSeq: " + localMessageForShortVideo.uniseq + " ";
    if (localMessageForShortVideo.uniseq != paramFileMsg.uniseq) {}
    ShortVideoPTVItemBuilder.ChatVideoView localChatVideoView;
    do
    {
      return;
      localChatVideoView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView;
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramInt1 = AIOUtils.a(' ', localResources);
      paramInt2 = AIOUtils.a(' ', localResources);
      if ((paramFileMsg.fileType == 6) || (paramFileMsg.fileType == 17) || (paramFileMsg.fileType == 9) || (paramFileMsg.fileType == 20))
      {
        b(paramFileMsg, paramView, localMessageForShortVideo, str, localChatVideoView, paramInt1, paramInt2);
        return;
      }
    } while ((paramFileMsg.fileType != 7) && (paramFileMsg.fileType != 18) && (paramFileMsg.fileType != 16));
    a(paramFileMsg, paramView, localMessageForShortVideo, str, localChatVideoView, paramInt1, paramInt2);
  }
  
  void a(ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showLoading() msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIndeterminate(true);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(ShortVideoPTVItemBuilder.Holder paramHolder, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showProgress(), progress = " + paramInt + " msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    CircleProgressView localCircleProgressView = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView;
    int i = paramInt;
    if (paramInt > 100)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startShowProgress, illegal process:" + paramInt + " msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      i = 100;
    }
    localCircleProgressView.setIndeterminate(false);
    localCircleProgressView.setProgress(i);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(2, 3);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.jdField_b_of_type_Int);
    localShortVideoDownloadInfo.i = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "downloadThumb thumbPath" + localShortVideoDownloadInfo.i);
    }
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
    localShortVideoDownloadInfo.f = 2;
    localShortVideoDownloadInfo.g = 2;
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    Object localObject = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.b((String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719392, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
    }
    do
    {
      return;
      if (!FileUtils.b(str))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719393, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      localObject = ShortVideoBusiManager.a(1, 3);
      ((ShortVideoReq)localObject).a(ShortVideoBusiManager.a(((ShortVideoReq)localObject).jdField_b_of_type_Int, paramMessageForShortVideo, (ShortVideoReq)localObject));
      ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileStatus != 1005) || (paramMessageForShortVideo.videoFileProgress != 0));
    a(paramHolder, 3);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    int j = 1;
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "downloadVideo():STATUS_FILE_EXPIRED 短视频已过期不启动下载流程");
      }
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label109;
      }
    }
    label109:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label114;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718859, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      return;
      i = 0;
      break;
    }
    label114:
    localObject = ShortVideoBusiManager.a(2, 3);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(((ShortVideoReq)localObject).jdField_b_of_type_Int);
    localShortVideoDownloadInfo.h = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 0);
    i = j;
    if (paramBoolean) {
      i = 2;
    }
    localShortVideoDownloadInfo.f = i;
    localShortVideoDownloadInfo.g = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localShortVideoDownloadInfo.e + ", uniseq:" + paramMessageForShortVideo.uniseq + "localPath=" + localShortVideoDownloadInfo.h);
    }
    ((ShortVideoReq)localObject).a(localShortVideoDownloadInfo);
    ((ShortVideoReq)localObject).a(paramMessageForShortVideo);
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void a(FileMsg paramFileMsg, ShortVideoPTVItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, String paramString, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, int paramInt1, int paramInt2)
  {
    switch (paramFileMsg.status)
    {
    default: 
    case 2001: 
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_START");
      return;
    case 2003: 
      paramFileMsg = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
      paramString = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
      boolean bool = FileUtils.b(paramString);
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_FINISHED: videoExists=" + bool + ", sAutoPlayInAIO=" + ShortVideoPTVItemBuilder.PtvPlayConfig.b);
      }
      if ((bool) && (ShortVideoPTVItemBuilder.PtvPlayConfig.b))
      {
        a(paramHolder, paramChatVideoView, paramInt1, paramInt2, paramFileMsg, paramString);
        return;
      }
      a(paramHolder, paramMessageForShortVideo, paramChatVideoView, paramInt1, paramInt2, paramFileMsg, paramString);
      return;
    case 5002: 
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "THUMB STATUS_FILE_EXPIRED");
      }
      break;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "THUMB STATUS_RECV_ERROR");
    }
    paramFileMsg = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    if (FileUtils.b(paramFileMsg)) {
      if (paramChatVideoView.a(paramFileMsg))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "STATUS_RECV_ERROR: 缩略图下载失败刷视频 " + paramFileMsg);
        if (ShortVideoUtils.isVideoSoLibLoaded())
        {
          paramMessageForShortVideo = URLDrawable.URLDrawableOptions.obtain();
          paramMessageForShortVideo.mRequestWidth = paramInt1;
          paramMessageForShortVideo.mRequestHeight = paramInt2;
          paramMessageForShortVideo.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramMessageForShortVideo.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramString = new VideoDrawable.VideoDrawableParams();
          paramString.mPlayVideoFrame = true;
          paramString.mVideoRoundCorner = 0;
          paramString.mRequestedFPS = ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_a_of_type_Int;
          paramMessageForShortVideo.mExtraInfo = paramString;
          paramChatVideoView.b(URLDrawable.getDrawable(new File(paramFileMsg), paramMessageForShortVideo));
        }
      }
    }
    for (;;)
    {
      b(paramHolder);
      return;
      paramFileMsg = paramChatVideoView.b;
      if ((paramFileMsg != null) && (paramFileMsg.getStatus() == 1))
      {
        paramChatVideoView.b(paramFileMsg);
        continue;
        paramChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {}
    do
    {
      do
      {
        return false;
        paramChatMessage = (MessageForShortVideo)paramChatMessage;
      } while ((paramChatMessage.md5 == null) || (paramChatMessage.videoFileStatus == 5002));
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
    } while ((paramChatMessage.videoFileProgress == 100) || (paramChatMessage.videoFileStatus == 1003) || (paramChatMessage.videoFileStatus == 2003));
    return true;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    Object localObject = (ShortVideoPTVItemBuilder.Holder)AIOUtils.a(paramView);
    paramView = (MessageForShortVideo)((ShortVideoPTVItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.md5 != null)
    {
      String str = ShortVideoUtils.getShortVideoThumbPicPath(paramView.thumbMD5, "jpg");
      ShortVideoUtils.getShortVideoSavePath(paramView, "mp4");
      if (FileUtils.b(str)) {
        if ((((ShortVideoPTVItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView == null) || (!((ShortVideoPTVItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a())) {
          break label309;
        }
      }
    }
    label309:
    for (int i = 1;; i = 0)
    {
      if ((((ShortVideoPTVItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) && (((ShortVideoPTVItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0)) {}
      for (int j = 1;; j = 0)
      {
        if ((paramView.isSendFromLocal()) && (j == 0)) {
          localQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
        }
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, paramView, null);
        if ((i == 0) && (j == 0)) {
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramView, new Bundle());
        }
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramView, new Bundle());
        if (paramView.md5 != null)
        {
          localObject = ShortVideoUtils.getShortVideoThumbPicPath(paramView.thumbMD5, "jpg");
          if (FileUtils.b(ShortVideoUtils.getShortVideoSavePath(paramView, "mp4"))) {
            localQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131692258), 2130839058);
          }
          if (FileUtils.b((String)localObject)) {
            a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramView, null);
          }
        }
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
        return localQQCustomMenu.a();
      }
    }
  }
  
  void b(ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "hideProgress() msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void b(ShortVideoPTVItemBuilder.Holder paramHolder, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showWarnProgress() msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846010);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "Forward menu clicked, md5 is empty.");
      }
      return;
    }
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
      QLog.d("ShortVideoPTVItemBuilder", 2, "Forward menu clicked, thumbPath=" + str1 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
    }
    localBundle.putString("file_send_path", str2);
    localBundle.putString("thumbfile_send_path", str1);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
    localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
    localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
    localBundle.putBoolean("is_forward_ptv", true);
    localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
    if (paramMessageForShortVideo.CheckIsHotVideo())
    {
      localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
      localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
      localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
      localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
    }
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
      }
      if (!FileUtils.b(ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719393, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        paramHolder = ShortVideoBusiManager.a(4, 3);
        paramHolder.a(ShortVideoBusiManager.a(paramHolder.jdField_b_of_type_Int, paramMessageForShortVideo, paramHolder));
        ShortVideoBusiManager.a(paramHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoPTVItemBuilder", 2, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  protected void b(FileMsg paramFileMsg, ShortVideoPTVItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, String paramString, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, int paramInt1, int paramInt2)
  {
    switch (paramFileMsg.status)
    {
    default: 
    case 1001: 
    case 1003: 
    case 1005: 
    case 1004: 
    case 1002: 
    case 2001: 
    case 2003: 
    case 5001: 
    case 2005: 
    case 5002: 
    case 2004: 
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_START progress " + paramMessageForShortVideo.videoFileProgress);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_FINISHED");
        }
        b(paramHolder);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_ERROR");
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        b(paramHolder);
        paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(8);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_CANCEL");
        }
        b(paramHolder);
        return;
        paramInt1 = paramMessageForShortVideo.videoFileProgress;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_PROCESS " + paramInt1);
        }
        a(paramHolder, paramInt1);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_RECV_START");
        }
        a(paramHolder, paramMessageForShortVideo.videoFileProgress);
        return;
        a(paramHolder, paramMessageForShortVideo, paramString, paramChatVideoView, paramInt1, paramInt2);
        return;
        a(paramHolder, paramMessageForShortVideo);
        return;
        a(paramFileMsg, paramHolder, paramMessageForShortVideo, paramChatVideoView);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_CANCEL");
      return;
    }
    paramInt1 = paramMessageForShortVideo.videoFileProgress;
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
    }
    a(paramHolder, paramInt1);
  }
  
  void c(ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showPauseProgress() msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846009);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    ShortVideoPTVItemBuilder.Holder localHolder = (ShortVideoPTVItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() == 2131364680) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
          break;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695877, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      }
      if (paramView.getId() != 2131364634) {
        break;
      }
    } while (localMessageForShortVideo.md5 == null);
    Object localObject = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForShortVideo.thumbMD5, "jpg");
    String str = ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4");
    if (QLog.isColorLevel()) {
      QLog.e("ptvitem", 2, "onClick videoPath=" + str + "thumbPath=" + (String)localObject);
    }
    if (!FileUtils.b(str))
    {
      a(localMessageForShortVideo, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E96", "0X8005E96", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (!localMessageForShortVideo.isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
      }
      if (localMessageForShortVideo.isBlessMsg) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + localMessageForShortVideo.uuid, "" + localMessageForShortVideo.isSend());
      }
      super.onClick(paramView);
      break;
      if (FileUtils.b((String)localObject))
      {
        if ((ShortVideoPTVItemBuilder.PtvPlayConfig.b) && (ShortVideoUtils.isVideoSoLibLoaded()))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E95", "0X8005E95", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
            break;
          }
          if ((localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView.getDrawable() == null) || (!(localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView.getDrawable() instanceof URLDrawable))) {
            continue;
          }
          localObject = (URLDrawable)localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView.getDrawable();
          if ((((URLDrawable)localObject).getStatus() != 1) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))) {
            continue;
          }
          a(localHolder, localMessageForShortVideo, (URLDrawable)localObject);
          continue;
        }
        ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder
 * JD-Core Version:    0.7.0.1
 */