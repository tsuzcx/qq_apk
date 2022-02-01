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
import com.tencent.mobileqq.shortvideo.SVUtils;
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
    this.a = 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (paramChatMessage == null) {
      return null;
    }
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    ((DeviceMsgHandle)this.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramView, this);
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramViewGroup = (ShortVideoItemBuilder.Holder)AIOUtils.b(paramView);
    if (paramChatMessage.videoFileStatus == 1005)
    {
      paramViewGroup.j.setFailedIconVisable(true, this);
      return paramView;
    }
    if (paramChatMessage.videoFileStatus == 1002)
    {
      paramViewGroup.j.setFailedIconVisable(false, this);
      a(paramViewGroup, ShortVideoUtils.getDisplayProgress(paramChatMessage.videoFileProgress, 10), false);
      return paramView;
    }
    a(paramViewGroup);
    paramViewGroup.j.setFailedIconVisable(false, this);
    return paramView;
  }
  
  public void a(View paramView, DeviceAVFileMsgObserver.DevMsgViewData paramDevMsgViewData)
  {
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.b(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.q;
    if (localMessageForShortVideo.uniseq != paramDevMsgViewData.a) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateView msg.uniseq:");
      localStringBuilder.append(localMessageForShortVideo.uniseq);
      localStringBuilder.append(" ===> fileStatus:");
      localStringBuilder.append(SVUtils.b(paramDevMsgViewData.b));
      QLog.d("DeviceShortVideo", 2, localStringBuilder.toString());
    }
    int i = (int)(paramDevMsgViewData.c * 100.0F);
    int j = paramDevMsgViewData.b;
    if (j != 2005) {}
    switch (j)
    {
    default: 
      switch (j)
      {
      default: 
        return;
      case 2003: 
        b(paramView);
        d();
        return;
      case 2002: 
        b(paramView);
        paramView.j.setFailedIconVisable(false, this);
        return;
      }
      b(paramView);
      paramView.j.setFailedIconVisable(false, this);
      return;
    case 1005: 
      b(paramView);
      paramView.j.setFailedIconVisable(true, this);
      return;
    case 1003: 
      a(paramView);
      d();
      return;
    case 1002: 
      if (localMessageForShortVideo.isSendFromLocal())
      {
        a(paramView, ShortVideoUtils.getDisplayProgress(i, 10), true);
        if (QLog.isColorLevel())
        {
          paramDevMsgViewData = new StringBuilder();
          paramDevMsgViewData.append("handleMessage VIDEO ==> STATUS_SEND_PROCESS, progress=");
          paramDevMsgViewData.append(i);
          QLog.d("DeviceShortVideo", 2, paramDevMsgViewData.toString());
        }
        paramView.j.setFailedIconVisable(false, this);
        return;
      }
      break;
    case 1001: 
      a(paramView, ShortVideoUtils.getDisplayProgress(i, 10), true);
      paramView.j.setFailedIconVisable(false, this);
      return;
      b(paramView);
      QQToast.makeText(this.e, 2131916641, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
    }
  }
  
  protected void a(ShortVideoItemBuilder.Holder paramHolder)
  {
    paramHolder.c.setVisibility(8);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      paramMessageForShortVideo = Looper.getMainLooper();
      if (Thread.currentThread() == paramMessageForShortVideo.getThread())
      {
        FMToastUtil.a(2131891334);
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
  
  protected void b(View paramView)
  {
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.b(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.q;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.e, null);
      localActionSheet.addButton(2131886574, 5);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new DevShortVideoItemBuilder.3(this, localMessageForShortVideo, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */