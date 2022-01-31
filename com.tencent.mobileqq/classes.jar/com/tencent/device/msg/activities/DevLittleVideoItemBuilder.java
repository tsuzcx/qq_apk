package com.tencent.device.msg.activities;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewCallback;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewData;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.ChatVideoView;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import qag;
import qah;
import qai;
import qaj;
import qak;
import qal;
import qam;

public class DevLittleVideoItemBuilder
  extends ShortVideoRealItemBuilder
  implements DeviceAVFileMsgObserver.DevMsgViewCallback
{
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = new qah(this);
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  
  public DevLittleVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static void a(Context paramContext, MessageForShortVideo paramMessageForShortVideo, ImageView paramImageView, SessionInfo paramSessionInfo)
  {
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramMessageForShortVideo;
    Object localObject3 = paramMessageForShortVideo.videoFileName;
    Object localObject1 = paramMessageForShortVideo.mThumbFilePath;
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      localObject2 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      localObject1 = localObject2;
      if (!FileUtils.b((String)localObject3))
      {
        localObject3 = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
        localObject1 = localObject2;
      }
    }
    for (Object localObject2 = localObject3;; localObject2 = localObject3)
    {
      if (ShortVideoUtils.a())
      {
        paramImageView = new Bundle();
        paramImageView.putInt("uintype", paramMessageForShortVideo.istroop);
        paramImageView.putString("from_uin", ShortVideoUtils.b(paramMessageForShortVideo));
        paramImageView.putInt("from_uin_type", paramSessionInfo.jdField_a_of_type_Int);
        paramImageView.putInt("from_busi_type", paramMessageForShortVideo.busiType);
        paramImageView.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
        paramImageView.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
        paramImageView.putString("file_name", paramMessageForShortVideo.videoFileName);
        paramImageView.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
        paramImageView.putString("file_send_path", (String)localObject2);
        paramImageView.putString("thumbfile_send_path", (String)localObject1);
        paramImageView.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
        paramImageView.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
        paramImageView.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
        paramImageView.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
        paramImageView.putString("file_source", paramMessageForShortVideo.fileSource);
        paramImageView.putString("file_uuid", paramMessageForShortVideo.uuid);
        paramImageView.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
        paramImageView.putInt("video_play_caller", 0);
        paramImageView.putLong("message_click_start", System.currentTimeMillis());
        paramImageView.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
        paramMessageForShortVideo = new Intent(paramContext, ShortVideoPlayActivity.class);
        paramMessageForShortVideo.putExtras(paramImageView);
        paramContext.startActivity(paramMessageForShortVideo);
        return;
      }
      paramImageView = AnimationUtils.a(paramImageView);
      paramMessageForShortVideo = new Bundle();
      paramMessageForShortVideo.putParcelable("KEY_THUMBNAL_BOUND", paramImageView);
      if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity))) {
        paramMessageForShortVideo.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().f());
      }
      paramMessageForShortVideo.putBoolean("extra.IS_FROM_MULTI_MSG", false);
      paramImageView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramImageView.hasNext())
      {
        localObject3 = (ActivityManager.RunningAppProcessInfo)paramImageView.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject3).processName.endsWith("mobileqq")) {
          paramMessageForShortVideo.putInt("extra.MOBILE_QQ_PROCESS_ID", ((ActivityManager.RunningAppProcessInfo)localObject3).pid);
        }
      }
      paramMessageForShortVideo.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      paramMessageForShortVideo.putString("uin", localMessageForDevLittleVideo.frienduin);
      paramImageView = new AIODevLittleVideoData();
      paramImageView.a = ((String)localObject1);
      paramImageView.b = ((String)localObject2);
      PeakUtils.a(paramContext, paramMessageForShortVideo, new AIOImageProviderService(localMessageForDevLittleVideo.selfuin, localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo), paramImageView, -1);
      return;
    }
  }
  
  private void a(ShortVideoRealItemBuilder.ChatVideoView paramChatVideoView, String paramString)
  {
    if (paramChatVideoView.a(paramString))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions));
    }
    do
    {
      return;
      paramString = paramChatVideoView.b;
    } while ((paramString == null) || (paramString.getStatus() != 1));
    paramChatVideoView.setURLDrawable(paramString);
  }
  
  private void a(ShortVideoRealItemBuilder.ChatVideoView paramChatVideoView, String paramString, int paramInt1, int paramInt2)
  {
    if (paramChatVideoView.a(paramString))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (paramInt1 > 0)
      {
        if (paramInt2 <= 0) {
          break label148;
        }
        label26:
        paramInt1 = AIOUtils.a(paramInt1, (Resources)localObject);
        paramInt2 = AIOUtils.a(paramInt2, (Resources)localObject);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
        localVideoDrawableParams.mPlayVideoFrame = true;
        localVideoDrawableParams.mVideoRoundCorner = 0;
        localVideoDrawableParams.mRequestedFPS = ShortVideoUtils.ShortVideoPlayConfig.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = localVideoDrawableParams;
        paramString = URLDrawable.getDrawable(new File(paramString), (URLDrawable.URLDrawableOptions)localObject);
        if (paramString.getStatus() != 1) {
          break label155;
        }
        paramChatVideoView.setURLDrawable(paramString);
      }
    }
    label148:
    label155:
    do
    {
      return;
      paramInt1 = 100;
      break;
      paramInt2 = 100;
      break label26;
      paramChatVideoView.setVideoDrawable(paramString);
      return;
      paramString = paramChatVideoView.b;
    } while ((paramString == null) || (paramString.getStatus() != 1));
    paramChatVideoView.setURLDrawable(paramString);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramView, this);
    paramBaseChatItemLayout = (ShortVideoRealItemBuilder.Holder)paramViewHolder;
    paramOnLongClickAndTouchListener = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView;
    paramViewHolder = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    Object localObject = paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView;
    localObject = (MessageForDevLittleVideo)paramChatMessage;
    paramOnLongClickAndTouchListener.d = ((MessageForDevLittleVideo)localObject).isSend();
    if (((MessageForDevLittleVideo)localObject).isSendFromLocal()) {
      if ((((MessageForDevLittleVideo)localObject).md5 == null) || (((MessageForDevLittleVideo)localObject).md5.length() == 0))
      {
        paramChatMessage = ((MessageForDevLittleVideo)localObject).mThumbFilePath;
        if (FileUtils.b(paramChatMessage))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: 占坑");
          }
          a(paramOnLongClickAndTouchListener, paramChatMessage);
          a((MessageForShortVideo)localObject, paramBaseChatItemLayout, ((MessageForDevLittleVideo)localObject).videoFileProgress, false);
          ThreadManager.postImmediately(new qag(this, (MessageForDevLittleVideo)localObject), null, true);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return paramView;
          paramOnLongClickAndTouchListener.setImageDrawable(URLDrawableHelper.a());
          paramViewHolder.setVisibility(4);
        } while (!QLog.isColorLevel());
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView:You must get thumb before send video.");
        return paramView;
        String str = ShortVideoUtils.a(((MessageForDevLittleVideo)localObject).thumbMD5, "jpg");
        paramViewHolder = ((MessageForDevLittleVideo)localObject).videoFileName;
        paramChatMessage = paramViewHolder;
        if (!FileUtils.b(paramViewHolder)) {
          paramChatMessage = ShortVideoUtils.a((MessageForShortVideo)localObject, "mp4");
        }
        if (((MessageForDevLittleVideo)localObject).videoFileStatus == 1003)
        {
          if ((ShortVideoUtils.ShortVideoPlayConfig.b) && (ShortVideoUtils.a()) && (FileUtils.b(paramChatMessage)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showVideo(video send finished)");
            }
            a(paramOnLongClickAndTouchListener, paramChatMessage, ((MessageForDevLittleVideo)localObject).thumbWidth, ((MessageForDevLittleVideo)localObject).thumbHeight);
            return paramView;
          }
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb(video send finished)");
          }
          a(paramOnLongClickAndTouchListener, str);
          return paramView;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb (video not send finished)");
        }
        a(paramOnLongClickAndTouchListener, str);
      } while (((MessageForDevLittleVideo)localObject).videoFileStatus != 1002);
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showProgress (video sending)");
      }
      a((MessageForShortVideo)localObject, paramBaseChatItemLayout, ((MessageForDevLittleVideo)localObject).videoFileProgress, false);
      return paramView;
      paramChatMessage = ((MessageForDevLittleVideo)localObject).videoFileName;
      paramViewHolder = ((MessageForDevLittleVideo)localObject).mThumbFilePath;
      if (FileUtils.b(paramChatMessage))
      {
        if ((ShortVideoUtils.ShortVideoPlayConfig.b) && (ShortVideoUtils.a()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showVideo(video recv finished)");
          }
          a(paramOnLongClickAndTouchListener, paramChatMessage, ((MessageForDevLittleVideo)localObject).thumbWidth, ((MessageForDevLittleVideo)localObject).thumbHeight);
          return paramView;
        }
        if (FileUtils.b(paramViewHolder))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb(video recv finished)");
          }
          a(paramOnLongClickAndTouchListener, paramViewHolder);
          return paramView;
        }
        c((MessageForDevLittleVideo)localObject);
        return paramView;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showLoading(video not recv finished)");
      }
      paramOnLongClickAndTouchListener.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: downloadLittleVideo(video not recv finished)");
      }
      if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
      {
        paramOnLongClickAndTouchListener.setImageDrawable(URLDrawableHelper.a());
        ((MessageForDevLittleVideo)localObject).videoFileStatus = 2005;
        ((MessageForDevLittleVideo)localObject).videoFileProgress = 0;
        ((MessageForDevLittleVideo)localObject).serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForDevLittleVideo)localObject).frienduin, ((MessageForDevLittleVideo)localObject).istroop, ((MessageForDevLittleVideo)localObject).uniseq, ((MessageForDevLittleVideo)localObject).msgData);
        return paramView;
      }
    } while (((MessageForDevLittleVideo)localObject).videoFileStatus != 2001);
    ((MessageForDevLittleVideo)localObject).videoFileStatus = 2002;
    ((MessageForDevLittleVideo)localObject).videoFileProgress = 0;
    ((MessageForDevLittleVideo)localObject).serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForDevLittleVideo)localObject).frienduin, ((MessageForDevLittleVideo)localObject).istroop, ((MessageForDevLittleVideo)localObject).uniseq, ((MessageForDevLittleVideo)localObject).msgData);
    a((MessageForShortVideo)localObject, paramBaseChatItemLayout, ((MessageForDevLittleVideo)localObject).videoFileProgress, false);
    if (!FileUtils.b(paramViewHolder))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: downloadLittleVideoThumb(video not recv finished)");
      }
      c((MessageForDevLittleVideo)localObject);
    }
    b((MessageForDevLittleVideo)localObject);
    return paramView;
  }
  
  protected void a(View paramView)
  {
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForDevLittleVideo.isSendFromLocal())
    {
      localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.a(2131433635, 5);
      localActionSheet.c(2131433015);
      localActionSheet.a(new qai(this, localMessageForDevLittleVideo, paramView, localActionSheet));
      localActionSheet.show();
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.a(2131433633, 5);
    localActionSheet.c(2131433015);
    localActionSheet.a(new qaj(this, localMessageForDevLittleVideo, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(View paramView, DeviceAVFileMsgObserver.DevMsgViewData paramDevMsgViewData)
  {
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq != paramDevMsgViewData.jdField_a_of_type_Long) {}
    MessageForDevLittleVideo localMessageForDevLittleVideo;
    ShortVideoRealItemBuilder.ChatVideoView localChatVideoView;
    int i;
    do
    {
      do
      {
        do
        {
          return;
          localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if (QLog.isColorLevel()) {
            QLog.d("DevLittleVideoItemBuilder", 2, "updateView msg.uniseq:" + paramDevMsgViewData.jdField_a_of_type_Long + " ===> fileStatus:" + ShortVideoUtils.b(paramDevMsgViewData.jdField_a_of_type_Int));
          }
          localChatVideoView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView;
          i = (int)(paramDevMsgViewData.jdField_a_of_type_Float * 100.0F);
          switch (paramDevMsgViewData.jdField_a_of_type_Int)
          {
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_START progress " + localMessageForDevLittleVideo.videoFileProgress);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_FINISHED");
        }
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        a(paramView);
      } while (!ShortVideoUtils.ShortVideoPlayConfig.b);
      paramDevMsgViewData = localMessageForDevLittleVideo.videoFileName;
      paramView = paramDevMsgViewData;
      if (!FileUtils.b(paramDevMsgViewData)) {
        paramView = ShortVideoUtils.a(localMessageForDevLittleVideo, "mp4");
      }
    } while ((!ShortVideoUtils.a()) || (!FileUtils.b(paramView)));
    a(localChatVideoView, paramView, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_ERROR");
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    a(paramView);
    b();
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_PROCESS " + i);
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    a(localMessageForDevLittleVideo, paramView, i, true);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_FINISHED");
    }
    paramDevMsgViewData = localMessageForDevLittleVideo.videoFileName;
    String str = localMessageForDevLittleVideo.mThumbFilePath;
    if ((ShortVideoUtils.ShortVideoPlayConfig.b) && (ShortVideoUtils.a()) && (FileUtils.b(paramDevMsgViewData)))
    {
      a(localChatVideoView, paramDevMsgViewData, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    }
    for (;;)
    {
      a(paramView);
      return;
      if (FileUtils.b(str))
      {
        a(localChatVideoView, str);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
      else
      {
        localChatVideoView.setImageDrawable(URLDrawableHelper.a());
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        b();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_PROCESS " + i);
    }
    a(localMessageForDevLittleVideo, paramView, i, true);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_ERROR");
    }
    localChatVideoView.setImageDrawable(URLDrawableHelper.a());
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    a(paramView);
    b();
  }
  
  public void a(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new qak(this, paramMessageForDevLittleVideo));
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramChatMessage = (MessageForDevLittleVideo)paramChatMessage;
    return (paramChatMessage.videoFileStatus == 1005) || (paramChatMessage.videoFileStatus == 2005);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return paramView.a();
  }
  
  public void b(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    if (paramMessageForDevLittleVideo.isSendFromLocal()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new qal(this, paramMessageForDevLittleVideo));
  }
  
  public void c(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    if (paramMessageForDevLittleVideo.isSendFromLocal()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new qam(this, paramMessageForDevLittleVideo));
  }
  
  public void onClick(View paramView)
  {
    ShortVideoRealItemBuilder.Holder localHolder = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() == 2131361903) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131428992, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      return;
    }
    if (paramView.getId() == 2131361877)
    {
      String str2 = localMessageForDevLittleVideo.videoFileName;
      paramView = localMessageForDevLittleVideo.mThumbFilePath;
      String str1 = str2;
      if (localMessageForDevLittleVideo.isSendFromLocal())
      {
        String str3 = ShortVideoUtils.a(localMessageForDevLittleVideo.thumbMD5, "jpg");
        paramView = str3;
        str1 = str2;
        if (!FileUtils.b(str2))
        {
          str1 = ShortVideoUtils.a(localMessageForDevLittleVideo, "mp4");
          paramView = str3;
        }
      }
      if (!FileUtils.b(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "downloadLittleVideo ");
        }
        b(localMessageForDevLittleVideo);
        return;
      }
      if (!FileUtils.b(paramView))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "downloadLittleVideoThumb ");
        }
        c(localMessageForDevLittleVideo);
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
      a(this.jdField_a_of_type_AndroidContentContext, localMessageForDevLittleVideo, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */