package com.tencent.device.msg.activities;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewCallback;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewData;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
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
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.shortvideo.ResultListener;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class DevLittleVideoItemBuilder
  extends ShortVideoRealItemBuilder
  implements DeviceAVFileMsgObserver.DevMsgViewCallback
{
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ResultListener jdField_a_of_type_ComTencentMobileqqShortvideoResultListener = new DevLittleVideoItemBuilder.2(this);
  
  public DevLittleVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static void a(Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo)
  {
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramMessageForShortVideo;
    Object localObject3 = paramMessageForShortVideo.videoFileName;
    Object localObject2 = paramMessageForShortVideo.mThumbFilePath;
    Object localObject1 = localObject3;
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      String str = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      localObject1 = localObject3;
      localObject2 = str;
      if (!FileUtils.fileExistsAndNotEmpty((String)localObject3))
      {
        localObject1 = SVUtils.a(paramMessageForShortVideo, "mp4");
        localObject2 = str;
      }
    }
    if (ShortVideoUtils.isVideoSoLibLoaded())
    {
      paramView = new Bundle();
      paramView.putInt("uintype", paramMessageForShortVideo.istroop);
      paramView.putString("from_uin", SVUtils.a(paramMessageForShortVideo));
      paramView.putInt("from_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      paramView.putInt("from_busi_type", paramMessageForShortVideo.busiType);
      paramView.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
      paramView.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
      paramView.putString("file_name", paramMessageForShortVideo.videoFileName);
      paramView.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
      paramView.putString("file_send_path", (String)localObject1);
      paramView.putString("thumbfile_send_path", (String)localObject2);
      paramView.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
      paramView.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
      paramView.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
      paramView.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
      paramView.putString("file_source", paramMessageForShortVideo.fileSource);
      paramView.putString("file_uuid", paramMessageForShortVideo.uuid);
      paramView.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
      paramView.putInt("video_play_caller", 0);
      paramView.putLong("message_click_start", System.currentTimeMillis());
      paramView.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
      paramMessageForShortVideo = new Intent(paramContext, ShortVideoPlayActivity.class);
      paramMessageForShortVideo.putExtras(paramView);
      paramContext.startActivity(paramMessageForShortVideo);
      return;
    }
    paramView = AnimationUtils.a(paramView);
    paramMessageForShortVideo = new Bundle();
    paramMessageForShortVideo.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.n)) {
      paramMessageForShortVideo.putInt("extra.AIO_CURRENT_PANEL_STATE", ((BaseActivity)paramContext).getChatFragment().a().c());
    }
    paramMessageForShortVideo.putBoolean("extra.IS_FROM_MULTI_MSG", false);
    paramView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramView.hasNext())
    {
      localObject3 = (ActivityManager.RunningAppProcessInfo)paramView.next();
      if (((ActivityManager.RunningAppProcessInfo)localObject3).processName.endsWith("mobileqq")) {
        paramMessageForShortVideo.putInt("extra.MOBILE_QQ_PROCESS_ID", ((ActivityManager.RunningAppProcessInfo)localObject3).pid);
      }
    }
    paramMessageForShortVideo.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    paramMessageForShortVideo.putString("uin", localMessageForDevLittleVideo.frienduin);
    paramView = new AIODevLittleVideoData();
    paramView.a = ((String)localObject2);
    paramView.b = ((String)localObject1);
    paramMessageForShortVideo.putBoolean("extra.ENTER_NEW_GALLERY", true);
    PeakUtils.a(paramContext, paramMessageForShortVideo, new AIOImageProviderService(localMessageForDevLittleVideo.selfuin, localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo), paramView, -1, -1);
  }
  
  private void a(CropBubbleVideoView paramCropBubbleVideoView, String paramString)
  {
    if (a(paramCropBubbleVideoView, paramString))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramCropBubbleVideoView.showCover(URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions));
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (ShortVideoRealItemBuilder.Holder)paramViewHolder;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    paramViewHolder = ((Context)localObject1).getResources();
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramChatMessage;
    paramChatMessage = ShortVideoUtils.adjustSize(localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
    int i = paramChatMessage[0];
    int j = paramChatMessage[1];
    boolean bool = localMessageForDevLittleVideo.isSend();
    if (paramView == null)
    {
      paramChatMessage = new RelativeLayout((Context)localObject1);
      paramView = (CropBubbleVideoView)QQVideoViewFactory.a(this.jdField_a_of_type_AndroidContentContext, localMessageForDevLittleVideo.uniseq, null, bool);
      paramView.setId(2131362339);
      paramView.setVisibility(0);
      paramView.setContentDescription(HardCodeUtil.a(2131703406));
      paramChatMessage.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject1);
      paramChatMessage.addView(localMessageProgressView);
      ImageView localImageView = new ImageView((Context)localObject1);
      localImageView.setImageResource(2130838002);
      localImageView.setVisibility(8);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131372696);
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131372696);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.b(10.0F, paramViewHolder);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(10.0F, paramViewHolder);
      paramChatMessage.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new LinearLayout((Context)localObject1);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setGravity(17);
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramChatMessage.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject1 = new TextView((Context)localObject1);
      localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(70.0F, paramViewHolder);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131364565);
      ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    }
    else
    {
      paramChatMessage = paramView;
    }
    paramViewHolder = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getLayoutParams();
    if (paramViewHolder == null)
    {
      paramViewHolder = new RelativeLayout.LayoutParams(i, j);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramViewHolder);
    }
    else if ((paramViewHolder.width != i) || (paramViewHolder.height != j))
    {
      paramViewHolder.width = i;
      paramViewHolder.height = j;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramViewHolder);
    }
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramChatMessage, this);
    paramOnLongClickAndTouchListener = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView;
    paramViewHolder = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    paramView = paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView;
    if (localMessageForDevLittleVideo.isSendFromLocal())
    {
      if ((localMessageForDevLittleVideo.md5 != null) && (localMessageForDevLittleVideo.md5.length() != 0))
      {
        localObject1 = SVUtils.a(localMessageForDevLittleVideo.thumbMD5, "jpg");
        paramView = localMessageForDevLittleVideo.videoFileName;
        paramViewHolder = paramView;
        if (!FileUtils.fileExistsAndNotEmpty(paramView)) {
          paramViewHolder = SVUtils.a(localMessageForDevLittleVideo, "mp4");
        }
        if (localMessageForDevLittleVideo.videoFileStatus == 1003)
        {
          if ((ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO) && (ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.fileExistsAndNotEmpty(paramViewHolder)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showVideo(video send finished)");
            }
            a(paramOnLongClickAndTouchListener, paramViewHolder, (String)localObject1, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
            return paramChatMessage;
          }
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb(video send finished)");
          }
          a(paramOnLongClickAndTouchListener, (String)localObject1);
          return paramChatMessage;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb (video not send finished)");
        }
        a(paramOnLongClickAndTouchListener, (String)localObject1);
        if (localMessageForDevLittleVideo.videoFileStatus == 1002)
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showProgress (video sending)");
          }
          a(localMessageForDevLittleVideo, paramBaseChatItemLayout, localMessageForDevLittleVideo.videoFileProgress, false);
          return paramChatMessage;
        }
      }
      else
      {
        paramView = localMessageForDevLittleVideo.mThumbFilePath;
        if (FileUtils.fileExistsAndNotEmpty(paramView))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: 占坑");
          }
          a(paramOnLongClickAndTouchListener, paramView);
          a(localMessageForDevLittleVideo, paramBaseChatItemLayout, localMessageForDevLittleVideo.videoFileProgress, false);
          ThreadManager.postImmediately(new DevLittleVideoItemBuilder.1(this, localMessageForDevLittleVideo), null, true);
          return paramChatMessage;
        }
        paramOnLongClickAndTouchListener.showCover(URLDrawableHelper.getFailedDrawable());
        paramViewHolder.setVisibility(4);
        if (QLog.isColorLevel())
        {
          QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView:You must get thumb before send video.");
          return paramChatMessage;
        }
      }
    }
    else
    {
      paramViewHolder = localMessageForDevLittleVideo.videoFileName;
      paramView = localMessageForDevLittleVideo.mThumbFilePath;
      if (FileUtils.fileExistsAndNotEmpty(paramViewHolder))
      {
        if ((ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO) && (ShortVideoUtils.isVideoSoLibLoaded()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showVideo(video recv finished)");
          }
          a(paramOnLongClickAndTouchListener, paramViewHolder, paramView, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
          return paramChatMessage;
        }
        if (FileUtils.fileExistsAndNotEmpty(paramView))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb(video recv finished)");
          }
          a(paramOnLongClickAndTouchListener, paramView);
          return paramChatMessage;
        }
        c(localMessageForDevLittleVideo);
        return paramChatMessage;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showLoading(video not recv finished)");
      }
      paramOnLongClickAndTouchListener.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: downloadLittleVideo(video not recv finished)");
      }
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
      {
        localMessageForDevLittleVideo.videoFileStatus = 2005;
        localMessageForDevLittleVideo.videoFileProgress = 0;
        localMessageForDevLittleVideo.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
        return paramChatMessage;
      }
      if (localMessageForDevLittleVideo.videoFileStatus == 2001)
      {
        localMessageForDevLittleVideo.videoFileStatus = 2002;
        localMessageForDevLittleVideo.videoFileProgress = 0;
        localMessageForDevLittleVideo.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
        a(localMessageForDevLittleVideo, paramBaseChatItemLayout, localMessageForDevLittleVideo.videoFileProgress, false);
        if (!FileUtils.fileExistsAndNotEmpty(paramView))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: downloadLittleVideoThumb(video not recv finished)");
          }
          c(localMessageForDevLittleVideo);
        }
        b(localMessageForDevLittleVideo);
      }
    }
    return paramChatMessage;
  }
  
  protected void a(View paramView)
  {
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForDevLittleVideo.isSendFromLocal())
    {
      localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.addButton(2131689933, 5);
      localActionSheet.addCancelButton(2131690728);
      localActionSheet.setOnButtonClickListener(new DevLittleVideoItemBuilder.3(this, localMessageForDevLittleVideo, paramView, localActionSheet));
      localActionSheet.show();
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.addButton(2131689935, 5);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new DevLittleVideoItemBuilder.4(this, localMessageForDevLittleVideo, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(View paramView, DeviceAVFileMsgObserver.DevMsgViewData paramDevMsgViewData)
  {
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq != paramDevMsgViewData.jdField_a_of_type_Long) {
      return;
    }
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateView msg.uniseq:");
      ((StringBuilder)localObject).append(paramDevMsgViewData.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(" ===> fileStatus:");
      ((StringBuilder)localObject).append(SVUtils.b(paramDevMsgViewData.jdField_a_of_type_Int));
      QLog.d("DevLittleVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView;
    int i = (int)(paramDevMsgViewData.jdField_a_of_type_Float * 100.0F);
    int j = paramDevMsgViewData.jdField_a_of_type_Int;
    if (j != 1005)
    {
      if (j != 2005)
      {
        if (j != 2002)
        {
          if (j != 2003)
          {
            switch (j)
            {
            default: 
              return;
            case 1003: 
              if (QLog.isColorLevel()) {
                QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_FINISHED");
              }
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
              a(paramView);
              if (!ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO) {
                break;
              }
              paramDevMsgViewData = localMessageForDevLittleVideo.videoFileName;
              paramView = paramDevMsgViewData;
              if (!FileUtils.fileExistsAndNotEmpty(paramDevMsgViewData)) {
                paramView = SVUtils.a(localMessageForDevLittleVideo, "mp4");
              }
              if ((!ShortVideoUtils.isVideoSoLibLoaded()) || (!FileUtils.fileExistsAndNotEmpty(paramView))) {
                break;
              }
              a((CropBubbleVideoView)localObject, paramView, localMessageForDevLittleVideo.mThumbFilePath, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
              return;
            case 1002: 
              if (QLog.isColorLevel())
              {
                paramDevMsgViewData = new StringBuilder();
                paramDevMsgViewData.append("VIDEO STATUS_SEND_PROCESS ");
                paramDevMsgViewData.append(i);
                QLog.i("DevLittleVideoItemBuilder", 2, paramDevMsgViewData.toString());
              }
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
              a(localMessageForDevLittleVideo, paramView, i, true);
              return;
            case 1001: 
              if (!QLog.isColorLevel()) {
                break;
              }
              paramView = new StringBuilder();
              paramView.append("VIDEO STATUS_SEND_START progress ");
              paramView.append(localMessageForDevLittleVideo.videoFileProgress);
              QLog.i("DevLittleVideoItemBuilder", 2, paramView.toString());
              return;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_FINISHED");
            }
            paramDevMsgViewData = localMessageForDevLittleVideo.videoFileName;
            String str = localMessageForDevLittleVideo.mThumbFilePath;
            if ((ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO) && (ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.fileExistsAndNotEmpty(paramDevMsgViewData)))
            {
              a((CropBubbleVideoView)localObject, paramDevMsgViewData, str, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
            }
            else if (FileUtils.fileExistsAndNotEmpty(str))
            {
              a((CropBubbleVideoView)localObject, str);
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
            }
            else
            {
              ((CropBubbleVideoView)localObject).showCover(URLDrawableHelper.getFailedDrawable());
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              b();
            }
            a(paramView);
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramDevMsgViewData = new StringBuilder();
            paramDevMsgViewData.append("VIDEO STATUS_SEND_PROCESS ");
            paramDevMsgViewData.append(i);
            QLog.i("DevLittleVideoItemBuilder", 2, paramDevMsgViewData.toString());
          }
          a(localMessageForDevLittleVideo, paramView, i, true);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_ERROR");
        }
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        a(paramView);
        b();
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_ERROR");
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      a(paramView);
      b();
    }
  }
  
  void a(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new DevLittleVideoItemBuilder.5(this, paramMessageForDevLittleVideo));
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
  
  void b(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    if (paramMessageForDevLittleVideo.isSendFromLocal()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new DevLittleVideoItemBuilder.6(this, paramMessageForDevLittleVideo));
  }
  
  void c(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    if (paramMessageForDevLittleVideo.isSendFromLocal()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new DevLittleVideoItemBuilder.7(this, paramMessageForDevLittleVideo));
  }
  
  public void onClick(View paramView)
  {
    ShortVideoRealItemBuilder.Holder localHolder = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() != 2131364567) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695889, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      }
      else if (paramView.getId() == 2131364521)
      {
        String str2 = localMessageForDevLittleVideo.videoFileName;
        Object localObject = localMessageForDevLittleVideo.mThumbFilePath;
        String str1 = str2;
        if (localMessageForDevLittleVideo.isSendFromLocal())
        {
          String str3 = SVUtils.a(localMessageForDevLittleVideo.thumbMD5, "jpg");
          str1 = str2;
          localObject = str3;
          if (!FileUtils.fileExistsAndNotEmpty(str2))
          {
            str1 = SVUtils.a(localMessageForDevLittleVideo, "mp4");
            localObject = str3;
          }
        }
        if (!FileUtils.fileExistsAndNotEmpty(str1))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "downloadLittleVideo ");
          }
          b(localMessageForDevLittleVideo);
        }
        else if (!FileUtils.fileExistsAndNotEmpty((String)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "downloadLittleVideoThumb ");
          }
          c(localMessageForDevLittleVideo);
        }
        else
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
          a(this.jdField_a_of_type_AndroidContentContext, localMessageForDevLittleVideo, localHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      }
      else
      {
        super.onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */