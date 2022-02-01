package com.tencent.device.msg.activities;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewCallback;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewData;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import mqq.os.MqqHandler;

public class DevShortVideoItemBuilder
  extends ShortVideoItemBuilder
  implements DeviceAVFileMsgObserver.DevMsgViewCallback
{
  public DevShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (paramChatMessage == null) {
      return null;
    }
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramView, this);
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramViewGroup = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramChatMessage.videoFileStatus == 1005) {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    }
    for (;;)
    {
      return paramView;
      if (paramChatMessage.videoFileStatus == 1002)
      {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        a(paramViewGroup, ShortVideoUtils.getDisplayProgress(paramChatMessage.videoFileProgress, 10), false);
      }
      else
      {
        a(paramViewGroup);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.addButton(2131690018, 5);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new DevShortVideoItemBuilder.3(this, localMessageForShortVideo, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
  
  public void a(View paramView, DeviceAVFileMsgObserver.DevMsgViewData paramDevMsgViewData)
  {
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.uniseq != paramDevMsgViewData.jdField_a_of_type_Long) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DeviceShortVideo", 2, "updateView msg.uniseq:" + localMessageForShortVideo.uniseq + " ===> fileStatus:" + ShortVideoUtils.getFileStatusStr(paramDevMsgViewData.jdField_a_of_type_Int));
      }
      i = (int)(100.0F * paramDevMsgViewData.jdField_a_of_type_Float);
      switch (paramDevMsgViewData.jdField_a_of_type_Int)
      {
      case 1004: 
      default: 
        return;
      case 1001: 
        a(paramView, ShortVideoUtils.getDisplayProgress(i, 10), true);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
      case 1003: 
        a(paramView);
        b();
        return;
      case 1005: 
        b(paramView);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        return;
      }
    } while (!localMessageForShortVideo.isSendFromLocal());
    a(paramView, ShortVideoUtils.getDisplayProgress(i, 10), true);
    if (QLog.isColorLevel()) {
      QLog.d("DeviceShortVideo", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS, progress=" + i);
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    return;
    b(paramView);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    return;
    b(paramView);
    b();
    return;
    b(paramView);
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131719387, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
    return;
    b(paramView);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
  }
  
  public void a(ShortVideoItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      paramMessageForShortVideo = Looper.getMainLooper();
      if (Thread.currentThread() == paramMessageForShortVideo.getThread())
      {
        FMToastUtil.a(2131693806);
        return;
      }
      new Handler(paramMessageForShortVideo).post(new DevShortVideoItemBuilder.1(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceShortVideo", 2, "startUploadVideo");
    }
    ThreadManager.getFileThreadHandler().post(new DevShortVideoItemBuilder.2(this, paramMessageForShortVideo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */