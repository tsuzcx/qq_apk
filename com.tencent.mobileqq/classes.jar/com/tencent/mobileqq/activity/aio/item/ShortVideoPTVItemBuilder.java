package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
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
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.api.IShortVideoForwardProcessor;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
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
import mqq.app.AppRuntime;

public class ShortVideoPTVItemBuilder
  extends BaseBubbleBuilder
  implements Callback, ShortVideoConstants
{
  static int jdField_a_of_type_Int;
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new EmptyDrawable(-10065297, jdField_a_of_type_Int, d);
  public static WeakReference<VideoDrawable> a;
  private static WeakReference<MessageForShortVideo> jdField_b_of_type_JavaLangRefWeakReference;
  static int d;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_a_of_type_Int = AIOUtils.b(160.0F, localResources);
    d = AIOUtils.b(160.0F, localResources);
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
      if (FileUtils.fileExistsAndNotEmpty(str))
      {
        if (paramChatVideoView.a(str))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getBubbleView: 占坑 msgSeq: ");
            ((StringBuilder)localObject).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject).toString());
          }
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          ColorDrawable localColorDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
          paramChatVideoView.b(URLDrawable.getDrawable(new File(str), (URLDrawable.URLDrawableOptions)localObject));
          a(paramHolder);
          Utils.executeAsyncTaskOnSerialExcuter(new ShortVideoPTVItemBuilder.EncodeTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo), new Void[] { (Void)null });
          return paramView;
        }
      }
      else
      {
        paramChatVideoView.setImageDrawable(URLDrawableHelper.getFailedDrawable());
        b(paramHolder);
        if (QLog.isColorLevel())
        {
          paramChatVideoView = new StringBuilder();
          paramChatVideoView.append("getBubbleView():You must get thumb before send video. msgSeq: ");
          paramChatVideoView.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          QLog.i("ShortVideoPTVItemBuilder", 2, paramChatVideoView.toString());
        }
      }
    }
    return paramView;
  }
  
  private View a(View paramView, ShortVideoPTVItemBuilder.Holder paramHolder, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    Object localObject;
    if (paramChatVideoView.a(paramString1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getBubbleView: 刷缩略图 ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" msgSeq: ");
        ((StringBuilder)localObject).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      paramChatVideoView.b(URLDrawable.getDrawable(new File(paramString1), (URLDrawable.URLDrawableOptions)localObject));
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getBubbleView: 刷缩略图用缓存 ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" msgSeq: ");
        ((StringBuilder)localObject).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      paramString1 = paramChatVideoView.b;
      if ((paramString1 != null) && (paramString1.getStatus() == 1)) {
        paramChatVideoView.b(paramString1);
      }
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
    if (FileUtils.fileExistsAndNotEmpty(paramString2))
    {
      if ((paramMessageForShortVideo.isSendFromLocal()) && (paramMessageForShortVideo.videoFileProgress <= 100) && (paramMessageForShortVideo.videoFileStatus != 1003))
      {
        a(paramHolder, paramMessageForShortVideo.videoFileProgress);
        return paramView;
      }
      if ((ShortVideoUtils.isVideoSoLibLoaded()) && (ShortVideoPTVItemBuilder.PtvPlayConfig.b))
      {
        b(paramHolder);
        return paramView;
      }
      c(paramHolder);
      return paramView;
    }
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel())
      {
        paramChatVideoView = new StringBuilder();
        paramChatVideoView.append("getBubbleView():短视频已过期不启动下载流程 1 msgSeq: ");
        paramChatVideoView.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        QLog.d("ShortVideoPTVItemBuilder", 2, paramChatVideoView.toString());
      }
      b(paramHolder, 2131718343);
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
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("STATUS_RECV_FINISHED: 视频存在,刷缩略图 ");
        ((StringBuilder)localObject).append(paramString1);
        QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      if (ShortVideoUtils.isVideoSoLibLoaded())
      {
        paramString1 = URLDrawable.URLDrawableOptions.obtain();
        paramString1.mRequestWidth = paramInt1;
        paramString1.mRequestHeight = paramInt2;
        localObject = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramString1.mLoadingDrawable = ((Drawable)localObject);
        paramString1.mFailedDrawable = ((Drawable)localObject);
        localObject = new VideoDrawable.VideoDrawableParams();
        ((VideoDrawable.VideoDrawableParams)localObject).mPlayVideoFrame = true;
        ((VideoDrawable.VideoDrawableParams)localObject).mVideoRoundCorner = 0;
        ((VideoDrawable.VideoDrawableParams)localObject).mRequestedFPS = ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_a_of_type_Int;
        paramString1.mExtraInfo = localObject;
        paramChatVideoView.b(URLDrawable.getDrawable(new File(paramString2), paramString1));
      }
    }
    else
    {
      paramString1 = paramChatVideoView.b;
      if ((paramString1 != null) && (paramString1.getStatus() == 1)) {
        paramChatVideoView.b(paramString1);
      }
    }
    b(paramHolder);
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719079, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719103, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
  }
  
  private void a(ShortVideoPTVItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, URLDrawable paramURLDrawable)
  {
    paramURLDrawable = (VideoDrawable)paramURLDrawable.getCurrDrawable();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" videoDrawable.isAudioPlaying(): ");
      ((StringBuilder)localObject).append(paramURLDrawable.isAudioPlaying());
      QLog.d("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject).toString());
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
    Object localObject = jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != paramURLDrawable) && (((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).isAudioPlaying()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "onCLick sPlayingAudioDrawable.get() not null && isAudioPlaying, need stop audio.");
      }
      ((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).stopAudio();
      localObject = jdField_b_of_type_JavaLangRefWeakReference;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
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
    if (FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      if (paramChatVideoView.a(paramString1))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("STATUS_RECV_FINISHED: 缩略图存在，刷缩略图 ");
          ((StringBuilder)localObject).append(paramString1);
          QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
        ColorDrawable localColorDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        paramChatVideoView.b(URLDrawable.getDrawable(new File(paramString1), (URLDrawable.URLDrawableOptions)localObject));
        if (!FileUtils.fileExistsAndNotEmpty(paramString2))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=true, downloadVideo");
            }
            a(paramMessageForShortVideo, true);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=false, showPauseProgress");
          }
          c(paramHolder);
          return;
        }
        if (ShortVideoUtils.isVideoSoLibLoaded())
        {
          b(paramHolder);
          return;
        }
        c(paramHolder);
      }
    }
    else {
      paramChatVideoView.setImageDrawable(URLDrawableHelper.getFailedDrawable());
    }
  }
  
  private void a(ShortVideoPTVItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, String paramString, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, int paramInt1, int paramInt2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("VIDEO STATUS_RECV_FINISHED");
      QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    if (ShortVideoPTVItemBuilder.PtvPlayConfig.b)
    {
      localObject1 = SVUtils.a(paramMessageForShortVideo, "mp4");
      if (paramChatVideoView.a((String)localObject1))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("handleMessage: 刷视频 ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject2).toString());
        if ((ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.fileExistsAndNotEmpty((String)localObject1)))
        {
          paramString = URLDrawable.URLDrawableOptions.obtain();
          paramString.mRequestWidth = paramInt1;
          paramString.mRequestHeight = paramInt2;
          localObject2 = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramString.mLoadingDrawable = ((Drawable)localObject2);
          paramString.mFailedDrawable = ((Drawable)localObject2);
          localObject2 = new VideoDrawable.VideoDrawableParams();
          ((VideoDrawable.VideoDrawableParams)localObject2).mPlayVideoFrame = true;
          ((VideoDrawable.VideoDrawableParams)localObject2).mVideoRoundCorner = 0;
          ((VideoDrawable.VideoDrawableParams)localObject2).mRequestedFPS = ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_a_of_type_Int;
          paramString.mExtraInfo = localObject2;
          paramString = URLDrawable.getDrawable(new File((String)localObject1), paramString);
          if (paramString.getStatus() == 1) {
            paramChatVideoView.b(paramString);
          } else {
            paramChatVideoView.a(paramString);
          }
          if (!paramMessageForShortVideo.isSend()) {
            new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
          }
          if (paramMessageForShortVideo.subBusiType == 1)
          {
            paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            paramChatVideoView = new StringBuilder();
            paramChatVideoView.append("");
            paramChatVideoView.append(paramMessageForShortVideo.uuid);
            paramChatVideoView = paramChatVideoView.toString();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(paramMessageForShortVideo.isSend());
            ReportController.b(paramString, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", paramChatVideoView, ((StringBuilder)localObject1).toString());
          }
        }
      }
      b(paramHolder);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(0);
      return;
    }
    paramMessageForShortVideo = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo)) {
      if (paramChatVideoView.a(paramMessageForShortVideo))
      {
        paramString = URLDrawable.URLDrawableOptions.obtain();
        paramString.mRequestWidth = paramInt1;
        paramString.mRequestHeight = paramInt2;
        localObject1 = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramString.mLoadingDrawable = ((Drawable)localObject1);
        paramString.mFailedDrawable = ((Drawable)localObject1);
        paramChatVideoView.b(URLDrawable.getDrawable(new File(paramMessageForShortVideo), paramString));
      }
      else
      {
        paramMessageForShortVideo = paramChatVideoView.b;
        if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.getStatus() == 1)) {
          paramChatVideoView.b(paramMessageForShortVideo);
        }
      }
    }
    c(paramHolder);
  }
  
  private void a(FileMsg paramFileMsg, ShortVideoPTVItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView)
  {
    if (QLog.isColorLevel()) {
      if (paramFileMsg.status == 2005) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_ERROR");
      } else {
        QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_EXPIRED");
      }
    }
    paramMessageForShortVideo = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo))
    {
      Object localObject;
      if (paramChatVideoView.a(paramMessageForShortVideo))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("STATUS_FILE_EXPIRED: 刷缩略图 ");
          ((StringBuilder)localObject).append(paramMessageForShortVideo);
          QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        paramChatVideoView.b(URLDrawable.getDrawable(new File(paramMessageForShortVideo), (URLDrawable.URLDrawableOptions)localObject));
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("STATUS_FILE_EXPIRED: 刷缩略图用缓存 ");
          ((StringBuilder)localObject).append(paramMessageForShortVideo);
          QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
        paramMessageForShortVideo = paramChatVideoView.b;
        if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.getStatus() == 1)) {
          paramChatVideoView.b(paramMessageForShortVideo);
        }
      }
    }
    if (paramFileMsg.status == 2005)
    {
      b(paramHolder, 2131718347);
      return;
    }
    b(paramHolder, 2131718343);
  }
  
  public static void a(ListView paramListView)
  {
    WeakReference localWeakReference = jdField_a_of_type_JavaLangRefWeakReference;
    boolean bool1;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).isAudioPlaying()))
    {
      ((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).stopAudio();
      boolean bool2 = true;
      localWeakReference = jdField_b_of_type_JavaLangRefWeakReference;
      bool1 = bool2;
      if (localWeakReference != null)
      {
        bool1 = bool2;
        if (localWeakReference.get() != null)
        {
          a(paramListView, (ChatMessage)jdField_b_of_type_JavaLangRefWeakReference.get());
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramListView = new StringBuilder();
      paramListView.append("stopAudioIfPlaying(), stopSuccess = ");
      paramListView.append(bool1);
      QLog.d("ShortVideoPTVItemBuilder", 2, paramListView.toString());
    }
  }
  
  static void a(ListView paramListView, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (paramListView != null))
    {
      int i = AIOUtils.a(paramChatMessage.uniseq, paramListView.getAdapter());
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
    else if (QLog.isColorLevel())
    {
      paramListView = new StringBuilder();
      paramListView.append("stopAudioAnimByMsg(), message = ");
      paramListView.append(paramChatMessage);
      QLog.e("ShortVideoPTVItemBuilder", 2, paramListView.toString());
    }
  }
  
  private View b(View paramView, ShortVideoPTVItemBuilder.Holder paramHolder, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
    }
    Object localObject1;
    if (paramChatVideoView.a(paramString2))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getBubbleView: 刷视频 ");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(" msgSeq: ");
        ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      Object localObject2 = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      if (!paramChatVideoView.a(paramString1)) {
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramChatVideoView.b;
      }
      localObject2 = new VideoDrawable.VideoDrawableParams();
      ((VideoDrawable.VideoDrawableParams)localObject2).mPlayVideoFrame = true;
      ((VideoDrawable.VideoDrawableParams)localObject2).mPlayAudioFrame = false;
      ((VideoDrawable.VideoDrawableParams)localObject2).mVideoRoundCorner = 0;
      ((VideoDrawable.VideoDrawableParams)localObject2).mRequestedFPS = ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
      localObject1 = URLDrawable.getDrawable(new File(paramString2), (URLDrawable.URLDrawableOptions)localObject1);
      paramChatVideoView.b((URLDrawable)localObject1);
      if ((((URLDrawable)localObject1).getCurrDrawable() instanceof VideoDrawable))
      {
        boolean bool = ((VideoDrawable)((URLDrawable)localObject1).getCurrDrawable()).isAudioPlaying();
        if (bool) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
        } else {
          paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
        }
        if (QLog.isColorLevel())
        {
          paramChatVideoView = new StringBuilder();
          paramChatVideoView.append("getBubbleView: 刷视频, isAudioPlaying= ");
          paramChatVideoView.append(bool);
          paramChatVideoView.append(", videoPath:");
          paramChatVideoView.append(paramString2);
          paramChatVideoView.append(" msgSeq: ");
          paramChatVideoView.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          QLog.i("ShortVideoPTVItemBuilder", 2, paramChatVideoView.toString());
        }
      }
    }
    else
    {
      localObject1 = paramChatVideoView.b;
      if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
      {
        paramChatVideoView.b((URLDrawable)localObject1);
        if ((((URLDrawable)localObject1).getCurrDrawable() instanceof VideoDrawable))
        {
          paramChatVideoView = (VideoDrawable)((URLDrawable)localObject1).getCurrDrawable();
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getBubbleView: 刷视频用缓存, isAudioPlaying= ");
            ((StringBuilder)localObject1).append(paramChatVideoView.isAudioPlaying());
            ((StringBuilder)localObject1).append(", videoPath:");
            ((StringBuilder)localObject1).append(paramString2);
            ((StringBuilder)localObject1).append(" msgSeq: ");
            ((StringBuilder)localObject1).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject1).toString());
          }
          if (paramChatVideoView.isAudioPlaying()) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
          } else {
            paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
          }
        }
      }
    }
    if (!FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      a(paramMessageForShortVideo);
      if (QLog.isColorLevel())
      {
        paramChatVideoView = new StringBuilder();
        paramChatVideoView.append("getBubbleView: Video file exist and status finish. Thumb not exist. msgSeq: ");
        paramChatVideoView.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        QLog.i("ShortVideoPTVItemBuilder", 2, paramChatVideoView.toString());
      }
    }
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      paramChatVideoView = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if (BaseTransProcessor.class.isInstance(paramChatVideoView))
      {
        if (((BaseTransProcessor)paramChatVideoView).getFileStatus() == 1002L)
        {
          a(paramHolder, paramMessageForShortVideo.videoFileProgress);
          return paramView;
        }
      }
      else
      {
        b(paramHolder);
        return paramView;
      }
    }
    else
    {
      b(paramHolder);
    }
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
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (ShortVideoPTVItemBuilder.Holder)paramViewHolder;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject2 = ((Context)localObject1).getResources();
    if (QLog.isColorLevel())
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("getBubbleView(), message = ");
      paramViewHolder.append(paramChatMessage);
      QLog.d("ShortVideoPTVItemBuilder", 2, paramViewHolder.toString());
    }
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout((Context)localObject1);
      int i = AIOUtils.b(160.0F, (Resources)localObject2);
      int j = AIOUtils.b(160.0F, (Resources)localObject2);
      paramView = new ShortVideoPTVItemBuilder.ChatVideoView((Context)localObject1);
      paramView.setId(2131372696);
      paramView.setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject3 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new CircleProgressView((Context)localObject1);
      ((CircleProgressView)localObject3).setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.addRule(13);
      paramViewHolder.addView((View)localObject3, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(8, 2131372696);
      localLayoutParams.bottomMargin = AIOUtils.b(6.0F, (Resources)localObject2);
      localObject2 = new AudioAnimationView((Context)localObject1);
      ((AudioAnimationView)localObject2).setRectCount(7);
      ((AudioAnimationView)localObject2).setSyle(1);
      ((AudioAnimationView)localObject2).setIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838164));
      paramViewHolder.addView((View)localObject2, localLayoutParams);
      localObject1 = new ImageView((Context)localObject1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      ((ImageView)localObject1).setVisibility(8);
      paramViewHolder.addView((View)localObject1, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView = ((CircleProgressView)localObject3);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView = ((AudioAnimationView)localObject2);
    }
    else
    {
      paramViewHolder = paramView;
    }
    paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView;
    paramOnLongClickAndTouchListener = (MessageForShortVideo)paramChatMessage;
    paramView.c = paramOnLongClickAndTouchListener.isSend();
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIsSend(paramOnLongClickAndTouchListener.isSend());
    if (e)
    {
      localObject1 = new StringBuilder();
      if (paramChatMessage.isSend())
      {
        ((StringBuilder)localObject1).append("你发出视频对讲消息,");
      }
      else
      {
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        ((StringBuilder)localObject1).append("发出视频对讲消息,");
      }
      float f = paramOnLongClickAndTouchListener.videoFileSize / 1000;
      ((StringBuilder)localObject1).append("文件大小:");
      ((StringBuilder)localObject1).append(f);
      ((StringBuilder)localObject1).append("K ");
      ((StringBuilder)localObject1).append("视频时长:");
      ((StringBuilder)localObject1).append(String.valueOf(paramOnLongClickAndTouchListener.videoFileTime));
      ((StringBuilder)localObject1).append("秒");
      paramViewHolder.setContentDescription(((StringBuilder)localObject1).toString());
    }
    if (paramOnLongClickAndTouchListener.md5 == null) {
      return a(paramViewHolder, paramBaseChatItemLayout, paramView, paramOnLongClickAndTouchListener);
    }
    paramChatMessage = SVUtils.a(paramOnLongClickAndTouchListener.thumbMD5, "jpg");
    localObject1 = SVUtils.a(paramOnLongClickAndTouchListener, "mp4");
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getBubbleView() videoPath");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("thumbPath=");
      ((StringBuilder)localObject2).append(paramChatMessage);
      QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject2).toString());
    }
    if ((ShortVideoPTVItemBuilder.PtvPlayConfig.b) && (ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.fileExistsAndNotEmpty((String)localObject1)) && ((!paramOnLongClickAndTouchListener.isSendFromLocal()) || (paramOnLongClickAndTouchListener.videoFileStatus == 1003) || (paramOnLongClickAndTouchListener.videoFileStatus == 2003))) {
      return b(paramViewHolder, paramBaseChatItemLayout, paramView, paramOnLongClickAndTouchListener, paramChatMessage, (String)localObject1);
    }
    if (FileUtils.fileExistsAndNotEmpty(paramChatMessage)) {
      return a(paramViewHolder, paramBaseChatItemLayout, paramView, paramOnLongClickAndTouchListener, paramChatMessage, (String)localObject1);
    }
    if (paramOnLongClickAndTouchListener.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel())
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append("getBubbleView():短视频已过期不启动下载流程 2 msgSeq: ");
        paramChatMessage.append(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        QLog.d("ShortVideoPTVItemBuilder", 2, paramChatMessage.toString());
      }
      paramView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(paramBaseChatItemLayout, 2131718343);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      return paramViewHolder;
    }
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("getBubbleView: 下占位图 msgSeq: ");
      paramChatMessage.append(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      QLog.i("ShortVideoPTVItemBuilder", 2, paramChatMessage.toString());
    }
    paramView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    a(paramOnLongClickAndTouchListener);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
    return paramViewHolder;
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
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoPTVItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131713945);
    }
    return HardCodeUtil.a(2131713934);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt == 2131365480)
      {
        ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
        return;
      }
      if (paramInt == 2131367180)
      {
        paramInt = ((IPicPreDownload)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).calcUinType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
        if (paramInt == 3) {
          paramContext = "1";
        }
        for (;;)
        {
          break;
          if (paramInt == 2) {
            paramContext = "2";
          } else if (paramInt == 0) {
            paramContext = "3";
          } else {
            paramContext = "4";
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
        b(localMessageForShortVideo);
        return;
      }
      if (paramInt == 2131366494)
      {
        QfavBuilder.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
        return;
      }
      if (paramInt == 2131371562)
      {
        if (localMessageForShortVideo.md5 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPTVItemBuilder", 2, "onMenuItemClicked: msg_revoke => md5 = null");
          }
        }
        else
        {
          int i = 1;
          paramContext = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          paramInt = i;
          if (paramContext != null) {
            if (!IShortVideoUploadProcessor.class.isInstance(paramContext))
            {
              paramInt = i;
              if (!IShortVideoForwardProcessor.class.isInstance(paramContext)) {}
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
                AioVideoTransFileController.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MSG_FACADE)).a(localMessageForShortVideo.istroop).g(localMessageForShortVideo);
                if (QLog.isColorLevel()) {
                  QLog.d("ShortVideoPTVItemBuilder", 2, "onMenuItemClicked: stop uploading short video");
                }
                paramInt = 0;
              }
            }
          }
          if (paramInt != 0) {
            super.a(2131371562, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo);
          }
        }
      }
      else {
        super.a(paramInt, paramContext, paramChatMessage);
      }
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (ShortVideoPTVItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.addButton(2131689933, 5);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new ShortVideoPTVItemBuilder.1(this, localMessageForShortVideo, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, BaseChatItemLayout.h, 0, BaseChatItemLayout.i);
  }
  
  void a(ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showLoading() msgSeq: ");
      localStringBuilder.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      QLog.d("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIndeterminate(true);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(ShortVideoPTVItemBuilder.Holder paramHolder, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showProgress(), progress = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" msgSeq: ");
      ((StringBuilder)localObject).append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      QLog.d("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView;
    int i = paramInt;
    if (paramInt > 100)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startShowProgress, illegal process:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" msgSeq: ");
        localStringBuilder.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        QLog.d("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
      }
      i = 100;
    }
    ((CircleProgressView)localObject).setIndeterminate(false);
    ((CircleProgressView)localObject).setProgress(i);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(2, 3);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
    localShortVideoDownloadInfo.i = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadThumb thumbPath");
      localStringBuilder.append(localShortVideoDownloadInfo.i);
      QLog.e("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startUploadVideo：");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.toString());
      QLog.d("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = SVUtils.a(paramMessageForShortVideo, "mp4");
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
    localObject = SVBusiUtil.a(1, 3);
    ((ShortVideoReq)localObject).a(ShortVideoBusiManager.a(((ShortVideoReq)localObject).b, paramMessageForShortVideo, (ShortVideoReq)localObject));
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((paramMessageForShortVideo.isSendFromLocal()) && (paramMessageForShortVideo.videoFileStatus == 1005) && (paramMessageForShortVideo.videoFileProgress == 0)) {
      a(paramHolder, 3);
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "downloadVideo():STATUS_FILE_EXPIRED 短视频已过期不启动下载流程");
      }
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    boolean bool = ((File)localObject).exists();
    int j = 1;
    if ((bool) && (((File)localObject).canWrite())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (i != 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718574, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    localObject = SVBusiUtil.a(2, 3);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(((ShortVideoReq)localObject).b);
    localShortVideoDownloadInfo.h = SVUtils.a(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 0);
    int i = j;
    if (paramBoolean) {
      i = 2;
    }
    localShortVideoDownloadInfo.f = i;
    localShortVideoDownloadInfo.g = 2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" startDownloadVideo downloadvideo fileType==");
      localStringBuilder.append(localShortVideoDownloadInfo.e);
      localStringBuilder.append(", uniseq:");
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      localStringBuilder.append("localPath=");
      localStringBuilder.append(localShortVideoDownloadInfo.h);
      QLog.d("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
    }
    ((ShortVideoReq)localObject).a(localShortVideoDownloadInfo);
    ((ShortVideoReq)localObject).a(paramMessageForShortVideo);
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void a(FileMsg paramFileMsg, ShortVideoPTVItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, String paramString, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, int paramInt1, int paramInt2)
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
          if (QLog.isColorLevel())
          {
            paramFileMsg = new StringBuilder();
            paramFileMsg.append(paramString);
            paramFileMsg.append("THUMB STATUS_FILE_EXPIRED");
            QLog.i("ShortVideoPTVItemBuilder", 2, paramFileMsg.toString());
          }
        }
        if (QLog.isColorLevel())
        {
          paramFileMsg = new StringBuilder();
          paramFileMsg.append(paramString);
          paramFileMsg.append("THUMB STATUS_RECV_ERROR");
          QLog.i("ShortVideoPTVItemBuilder", 2, paramFileMsg.toString());
        }
        paramFileMsg = SVUtils.a(paramMessageForShortVideo, "mp4");
        if (FileUtils.fileExistsAndNotEmpty(paramFileMsg))
        {
          if (paramChatVideoView.a(paramFileMsg))
          {
            paramMessageForShortVideo = new StringBuilder();
            paramMessageForShortVideo.append(paramString);
            paramMessageForShortVideo.append("STATUS_RECV_ERROR: 缩略图下载失败刷视频 ");
            paramMessageForShortVideo.append(paramFileMsg);
            QLog.i("ShortVideoPTVItemBuilder", 2, paramMessageForShortVideo.toString());
            if (ShortVideoUtils.isVideoSoLibLoaded())
            {
              paramMessageForShortVideo = URLDrawable.URLDrawableOptions.obtain();
              paramMessageForShortVideo.mRequestWidth = paramInt1;
              paramMessageForShortVideo.mRequestHeight = paramInt2;
              paramString = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              paramMessageForShortVideo.mLoadingDrawable = paramString;
              paramMessageForShortVideo.mFailedDrawable = paramString;
              paramString = new VideoDrawable.VideoDrawableParams();
              paramString.mPlayVideoFrame = true;
              paramString.mVideoRoundCorner = 0;
              paramString.mRequestedFPS = ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_a_of_type_Int;
              paramMessageForShortVideo.mExtraInfo = paramString;
              paramChatVideoView.b(URLDrawable.getDrawable(new File(paramFileMsg), paramMessageForShortVideo));
            }
          }
          else
          {
            paramFileMsg = paramChatVideoView.b;
            if ((paramFileMsg != null) && (paramFileMsg.getStatus() == 1)) {
              paramChatVideoView.b(paramFileMsg);
            }
          }
        }
        else {
          paramChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        }
        b(paramHolder);
        return;
      }
      paramFileMsg = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      paramString = SVUtils.a(paramMessageForShortVideo, "mp4");
      boolean bool = FileUtils.fileExistsAndNotEmpty(paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("THUMB STATUS_RECV_FINISHED: videoExists=");
        localStringBuilder.append(bool);
        localStringBuilder.append(", sAutoPlayInAIO=");
        localStringBuilder.append(ShortVideoPTVItemBuilder.PtvPlayConfig.b);
        QLog.i("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
      }
      if ((bool) && (ShortVideoPTVItemBuilder.PtvPlayConfig.b))
      {
        a(paramHolder, paramChatVideoView, paramInt1, paramInt2, paramFileMsg, paramString);
        return;
      }
      a(paramHolder, paramMessageForShortVideo, paramChatVideoView, paramInt1, paramInt2, paramFileMsg, paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_START");
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool2 = paramChatMessage.isSendFromLocal();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    if (paramChatMessage.md5 == null) {
      return false;
    }
    if (paramChatMessage.videoFileStatus == 5002) {
      return false;
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
    return (paramChatMessage.videoFileProgress != 100) && (paramChatMessage.videoFileStatus != 1003) && (paramChatMessage.videoFileStatus != 2003);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    Object localObject = (ShortVideoPTVItemBuilder.Holder)AIOUtils.a(paramView);
    paramView = (MessageForShortVideo)((ShortVideoPTVItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.md5 != null)
    {
      String str = SVUtils.a(paramView.thumbMD5, "jpg");
      SVUtils.a(paramView, "mp4");
      if (FileUtils.fileExistsAndNotEmpty(str))
      {
        int i;
        if ((((ShortVideoPTVItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView != null) && (((ShortVideoPTVItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a())) {
          i = 1;
        } else {
          i = 0;
        }
        int j;
        if ((((ShortVideoPTVItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView != null) && (((ShortVideoPTVItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
          j = 1;
        } else {
          j = 0;
        }
        if ((paramView.isSendFromLocal()) && (j == 0)) {
          localQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
        }
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramView, null);
        if ((i == 0) && (j == 0)) {
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, paramView, new Bundle());
        }
      }
    }
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, paramView, new Bundle());
    if (paramView.md5 != null)
    {
      localObject = SVUtils.a(paramView.thumbMD5, "jpg");
      if (FileUtils.fileExistsAndNotEmpty(SVUtils.a(paramView, "mp4"))) {
        localQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131692184), 2130838911);
      }
      if (FileUtils.fileExistsAndNotEmpty((String)localObject)) {
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramView, null);
      }
    }
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
  
  void b(ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideProgress() msgSeq: ");
      localStringBuilder.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      QLog.d("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void b(ShortVideoPTVItemBuilder.Holder paramHolder, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showWarnProgress() msgSeq: ");
      localStringBuilder.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      QLog.d("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845885);
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
    localBundle.putInt("selection_mode", this.c);
    String str2 = ShortVideoUtils.findVideoPathIfExists(paramMessageForShortVideo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Forward menu clicked, thumbPath=");
      localStringBuilder.append(str1);
      localStringBuilder.append(",videoPath = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramMessageForShortVideo.toLogString());
      QLog.d("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
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
    if (paramMessageForShortVideo.checkIsHotVideo())
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
    if (paramMessageForShortVideo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startUploadVideo：");
      localStringBuilder.append(paramMessageForShortVideo.toString());
      QLog.d("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
    }
    if (!FileUtils.fileExistsAndNotEmpty(SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719111, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      paramHolder = SVBusiUtil.a(4, 3);
      paramHolder.a(ShortVideoBusiManager.a(paramHolder.b, paramMessageForShortVideo, paramHolder));
      ShortVideoBusiManager.a(paramHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
    }
  }
  
  protected void b(FileMsg paramFileMsg, ShortVideoPTVItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, String paramString, ShortVideoPTVItemBuilder.ChatVideoView paramChatVideoView, int paramInt1, int paramInt2)
  {
    int i = paramFileMsg.status;
    if (i != 5001)
    {
      if (i != 5002) {
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            return;
          case 2004: 
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_CANCEL");
            return;
          case 2003: 
            a(paramHolder, paramMessageForShortVideo, paramString, paramChatVideoView, paramInt1, paramInt2);
            return;
          case 2002: 
            paramInt1 = paramMessageForShortVideo.videoFileProgress;
            if (QLog.isColorLevel())
            {
              paramFileMsg = new StringBuilder();
              paramFileMsg.append("VIDEO STATUS_RECV_PROCESS ");
              paramFileMsg.append(paramInt1);
              QLog.i("ShortVideoPTVItemBuilder", 2, paramFileMsg.toString());
            }
            a(paramHolder, paramInt1);
            return;
          case 2001: 
            if (QLog.isColorLevel())
            {
              paramFileMsg = new StringBuilder();
              paramFileMsg.append(paramString);
              paramFileMsg.append("VIDEO STATUS_RECV_START");
              QLog.i("ShortVideoPTVItemBuilder", 2, paramFileMsg.toString());
            }
            a(paramHolder, paramMessageForShortVideo.videoFileProgress);
            return;
          }
          break;
        case 1005: 
          if (QLog.isColorLevel())
          {
            paramFileMsg = new StringBuilder();
            paramFileMsg.append(paramString);
            paramFileMsg.append("VIDEO STATUS_SEND_ERROR");
            QLog.i("ShortVideoPTVItemBuilder", 2, paramFileMsg.toString());
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          b(paramHolder);
          paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(8);
          return;
        case 1004: 
          if (QLog.isColorLevel())
          {
            paramFileMsg = new StringBuilder();
            paramFileMsg.append(paramString);
            paramFileMsg.append("VIDEO STATUS_SEND_CANCEL");
            QLog.i("ShortVideoPTVItemBuilder", 2, paramFileMsg.toString());
          }
          b(paramHolder);
          return;
        case 1003: 
          if (QLog.isColorLevel())
          {
            paramFileMsg = new StringBuilder();
            paramFileMsg.append(paramString);
            paramFileMsg.append("VIDEO STATUS_SEND_FINISHED");
            QLog.i("ShortVideoPTVItemBuilder", 2, paramFileMsg.toString());
          }
          b(paramHolder);
          return;
        case 1002: 
          paramInt1 = paramMessageForShortVideo.videoFileProgress;
          if (QLog.isColorLevel())
          {
            paramFileMsg = new StringBuilder();
            paramFileMsg.append(paramString);
            paramFileMsg.append("VIDEO STATUS_SEND_PROCESS ");
            paramFileMsg.append(paramInt1);
            QLog.i("ShortVideoPTVItemBuilder", 2, paramFileMsg.toString());
          }
          a(paramHolder, paramInt1);
          return;
        case 1001: 
          if (QLog.isColorLevel())
          {
            paramFileMsg = new StringBuilder();
            paramFileMsg.append(paramString);
            paramFileMsg.append("VIDEO STATUS_SEND_START progress ");
            paramFileMsg.append(paramMessageForShortVideo.videoFileProgress);
            QLog.i("ShortVideoPTVItemBuilder", 2, paramFileMsg.toString());
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
          return;
        }
      } else {
        a(paramFileMsg, paramHolder, paramMessageForShortVideo, paramChatVideoView);
      }
    }
    else {
      a(paramHolder, paramMessageForShortVideo);
    }
  }
  
  void c(ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showPauseProgress() msgSeq: ");
      localStringBuilder.append(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      QLog.d("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845884);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ShortVideoPTVItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleMessage() msgSeq: ");
    ((StringBuilder)localObject).append(localMessageForShortVideo.uniseq);
    ((StringBuilder)localObject).append(" ");
    localObject = ((StringBuilder)localObject).toString();
    if (localMessageForShortVideo.uniseq != paramFileMsg.uniseq) {
      return;
    }
    ShortVideoPTVItemBuilder.ChatVideoView localChatVideoView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    float f = ' ';
    paramInt1 = AIOUtils.b(f, localResources);
    paramInt2 = AIOUtils.b(f, localResources);
    if ((paramFileMsg.fileType != 6) && (paramFileMsg.fileType != 17) && (paramFileMsg.fileType != 9) && (paramFileMsg.fileType != 20))
    {
      if ((paramFileMsg.fileType == 7) || (paramFileMsg.fileType == 18) || (paramFileMsg.fileType == 16)) {
        a(paramFileMsg, paramView, localMessageForShortVideo, (String)localObject, localChatVideoView, paramInt1, paramInt2);
      }
    }
    else {
      b(paramFileMsg, paramView, localMessageForShortVideo, (String)localObject, localChatVideoView, paramInt1, paramInt2);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (ShortVideoPTVItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((ShortVideoPTVItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() != 2131364567) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695889, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      }
      else
      {
        if (paramView.getId() == 2131364521)
        {
          if (localMessageForShortVideo.md5 == null) {
            break label540;
          }
          Object localObject2 = SVUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
          Object localObject3 = SVUtils.a(localMessageForShortVideo, "mp4");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onClick videoPath=");
            localStringBuilder.append((String)localObject3);
            localStringBuilder.append("thumbPath=");
            localStringBuilder.append((String)localObject2);
            QLog.e("ptvitem", 2, localStringBuilder.toString());
          }
          if (!FileUtils.fileExistsAndNotEmpty((String)localObject3))
          {
            a(localMessageForShortVideo, false);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E96", "0X8005E96", 0, 0, "", "", "", "");
          }
          else if (FileUtils.fileExistsAndNotEmpty((String)localObject2))
          {
            if ((ShortVideoPTVItemBuilder.PtvPlayConfig.b) && (ShortVideoUtils.isVideoSoLibLoaded()))
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E95", "0X8005E95", 0, 0, "", "", "", "");
              if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
                break label540;
              }
              if ((((ShortVideoPTVItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView.getDrawable() != null) && ((((ShortVideoPTVItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView.getDrawable() instanceof URLDrawable)))
              {
                localObject2 = (URLDrawable)((ShortVideoPTVItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView.getDrawable();
                if ((((URLDrawable)localObject2).getStatus() == 1) && ((((URLDrawable)localObject2).getCurrDrawable() instanceof VideoDrawable))) {
                  a((ShortVideoPTVItemBuilder.Holder)localObject1, localMessageForShortVideo, (URLDrawable)localObject2);
                }
              }
            }
            else
            {
              ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo, ((ShortVideoPTVItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$ChatVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, true, null);
            }
          }
          if (!localMessageForShortVideo.isSend()) {
            new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
          }
          if (localMessageForShortVideo.isBlessMsg)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(localMessageForShortVideo.uuid);
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(localMessageForShortVideo.isSend());
            ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", (String)localObject2, ((StringBuilder)localObject3).toString());
          }
        }
        super.onClick(paramView);
      }
    }
    label540:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder
 * JD-Core Version:    0.7.0.1
 */