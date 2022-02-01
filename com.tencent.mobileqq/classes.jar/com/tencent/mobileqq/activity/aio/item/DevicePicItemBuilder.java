package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceGroupChatMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceFile.DeviceFileItemCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DevicePicItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate, MessageForDeviceFile.DeviceFileItemCallback
{
  protected final float a;
  
  public DevicePicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.a = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramChatMessage = (MessageForDeviceFile)paramChatMessage;
    if (("device_groupchat".equals(paramChatMessage.extStr)) && (paramView != null) && ((TextUtils.isEmpty(paramChatMessage.filePath)) || (FileManagerUtil.h(paramChatMessage.filePath) == 0L)))
    {
      paramViewGroup = (DeviceMsgHandle)this.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      if (!TextUtils.isEmpty(paramChatMessage.strMediaKey)) {
        paramViewGroup.d().a(paramChatMessage, paramView, this);
      }
    }
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    DevicePicItemBuilder.Holder localHolder = (DevicePicItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.e);
      paramView = new AsyncImageView(this.e);
      paramView.setId(2131440242);
      if (!m) {
        paramView.setAdjustViewBounds(true);
      }
      paramView.setMaxWidth((int)(this.a * 100.0F + 0.5F));
      paramView.setMaxHeight((int)(this.a * 100.0F + 0.5F));
      float f = this.a;
      paramView.setAsyncClipSize((int)(f * 100.0F + 0.5F), (int)(f * 100.0F + 0.5F));
      paramView.setDefaultImageByMargin();
      paramView.setIsDrawRound(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      paramViewHolder.addView(paramView, localLayoutParams);
      localHolder.a = paramView;
      paramView = new MessageProgressTextView(this.e);
      paramView.setTextColor(-1);
      int i = (int)TypedValue.applyDimension(2, 15.0F, this.e.getResources().getDisplayMetrics());
      paramView.setTextSize(2, 15.0F);
      paramView.setGravity(17);
      if (m) {
        paramView.setDisplayInTextView(false, i, -1);
      }
      paramView.setBackgroundDrawable(new AIOSendMask(2130706432, this.a * 12.0F));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131440242);
      localLayoutParams.addRule(8, 2131440242);
      localLayoutParams.addRule(5, 2131440242);
      localLayoutParams.addRule(7, 2131440242);
      paramViewHolder.addView(paramView, localLayoutParams);
      paramView.setVisibility(8);
      localHolder.b = paramView;
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    paramBaseChatItemLayout.setTag(localHolder);
    paramChatMessage = (MessageForDeviceFile)paramChatMessage;
    if (("device_groupchat".equals(paramChatMessage.extStr)) && (paramChatMessage.msgStatus == 2))
    {
      paramView = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramView instanceof QQAppInterface))
      {
        paramView = (QQAppInterface)paramView;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          paramChatMessage.nFileStatus = 6;
          paramChatMessage.msgStatus = 1;
          paramChatMessage.serial();
          paramView.getMessageFacade().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq, paramChatMessage.msgData);
        }
      }
    }
    a(paramBaseChatItemLayout, paramChatMessage, localHolder);
    ((DeviceMsgHandle)this.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).b().a(paramViewHolder, this);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new DevicePicItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt == 2131431695)
      {
        ChatActivityFacade.b(this.e, this.d, paramChatMessage);
        return;
      }
      if (paramInt == 2131439015)
      {
        super.a(paramInt, this.e, paramChatMessage);
        return;
      }
      if (paramInt == 2131433636)
      {
        paramChatMessage = new Bundle();
        paramChatMessage.putInt("forward_type", 1);
        paramChatMessage.putInt("forward_source_uin_type", this.f.a);
        paramChatMessage.putInt("selection_mode", this.u);
        Intent localIntent = new Intent();
        localIntent.putExtra("forward_filepath", paramContext.filePath);
        localIntent.putExtra("BUSI_TYPE", 1009);
        localIntent.putExtra("forward_download_image_org_uin", paramContext.frienduin);
        localIntent.putExtra("forward_download_image_org_uin_type", paramContext.istroop);
        localIntent.putExtra("forward_photo_isSend", paramContext.issend);
        localIntent.putExtras(paramChatMessage);
        ForwardBaseOption.a((Activity)this.e, localIntent, 21);
      }
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 1) && (i != 3)) {
      return;
    }
    paramView = paramView.getBackground();
    if (paramView != null)
    {
      paramView.setColorFilter(null);
      paramView.invalidateSelf();
    }
  }
  
  public void a(View paramView, MessageForDeviceFile paramMessageForDeviceFile)
  {
    paramView = (DevicePicItemBuilder.Holder)AIOUtils.b(paramView);
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevicePicItemBuilder", 2, "error get holder in updateview");
      }
      return;
    }
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramView.q;
    if (localMessageForDeviceFile.uniseq == paramMessageForDeviceFile.uniseq)
    {
      localMessageForDeviceFile.msgStatus = paramMessageForDeviceFile.msgStatus;
      localMessageForDeviceFile.nFileStatus = paramMessageForDeviceFile.nFileStatus;
      localMessageForDeviceFile.progress = paramMessageForDeviceFile.progress;
      localMessageForDeviceFile.msg = paramMessageForDeviceFile.msg;
      a(paramView.j, localMessageForDeviceFile, paramView);
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null)
    {
      if (paramBoolean) {
        paramView = null;
      } else {
        paramView = n;
      }
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
    }
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, DevicePicItemBuilder.Holder paramHolder)
  {
    String str = paramMessageForDeviceFile.filePath;
    int i = paramMessageForDeviceFile.nFileStatus;
    boolean bool = false;
    switch (i)
    {
    default: 
      break;
    case 6: 
      paramHolder.b.setVisibility(4);
      bool = true;
      break;
    case 5: 
      paramHolder.b.setVisibility(4);
      break;
    case 4: 
      paramHolder.b.setVisibility(4);
      break;
    case 3: 
      paramHolder.b.setVisibility(0);
      paramHolder.b.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
      break;
    case 1: 
    case 2: 
      if (paramMessageForDeviceFile.issend == 0)
      {
        paramHolder.b.setVisibility(4);
      }
      else
      {
        paramHolder.b.setVisibility(0);
        paramHolder.b.setProgress(0);
      }
      break;
    }
    if (!TextUtils.isEmpty(str)) {
      paramHolder.a.setAsyncImage(str);
    } else {
      paramHolder.a.setImageDrawableDefault();
    }
    paramBaseChatItemLayout.setFailedIconVisable(bool, this);
  }
  
  void a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!NetworkUtil.isNetSupport(this.e))
    {
      FMToastUtil.a(2131889577);
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceFile.filePath)) {
      ((DeviceMsgHandle)this.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).b().a(DeviceMsgHandle.d, paramMessageForDeviceFile);
    }
    d();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((DevicePicItemBuilder.Holder)AIOUtils.b(paramView)).q).filePath)) {
      localQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
    }
    super.a(localQQCustomMenu, this.e, 2131439015, null, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {
      return;
    }
    paramView = (MessageForDeviceFile)((DevicePicItemBuilder.Holder)AIOUtils.b(paramView)).q;
    if (paramView.isSendFromLocal())
    {
      localActionSheet = (ActionSheet)ActionSheetHelper.b(this.e, null);
      localActionSheet.addButton(2131886574, 5);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new DevicePicItemBuilder.1(this, paramView, localActionSheet));
      localActionSheet.show();
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(this.e);
    localActionSheet.setMainTitle(2131888511);
    localActionSheet.addButton(2131888510);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new DevicePicItemBuilder.2(this, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!NetworkUtil.isNetSupport(this.e))
    {
      FMToastUtil.a(2131889577);
      return;
    }
    ((DeviceMsgHandle)this.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).b().a(paramMessageForDeviceFile);
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected void c(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {
      return;
    }
    if (localChatMessage.istroop == 9501)
    {
      if (localChatMessage.isSendFromLocal())
      {
        super.c(paramView);
        return;
      }
      if ("device_groupchat".equals(localChatMessage.extStr)) {
        super.c(paramView);
      }
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    Object localObject = null;
    paramView = localObject;
    if (localChatMessage != null)
    {
      paramView = localObject;
      if (localChatMessage.vipBubbleID == 0L) {
        paramView = this;
      }
    }
    return paramView;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131901324);
  }
  
  public void f()
  {
    super.f();
  }
  
  public void onClick(View paramView)
  {
    if (!super.c())
    {
      if (paramView.getId() == 2131430578) {
        try
        {
          Object localObject2 = (MessageForDeviceFile)AIOUtils.a(paramView);
          FileManagerEntity localFileManagerEntity = FileManagerUtil.a((MessageForDeviceFile)localObject2);
          Object localObject1 = new ForwardFileInfo();
          ((ForwardFileInfo)localObject1).b(10009);
          ((ForwardFileInfo)localObject1).d(8);
          ((ForwardFileInfo)localObject1).b(localFileManagerEntity.nSessionId);
          ((ForwardFileInfo)localObject1).d(localFileManagerEntity.fileName);
          ((ForwardFileInfo)localObject1).c(localFileManagerEntity.uniseq);
          ((ForwardFileInfo)localObject1).d(localFileManagerEntity.fileSize);
          ((ForwardFileInfo)localObject1).a(localFileManagerEntity.getFilePath());
          Intent localIntent = new Intent(this.e, FileBrowserActivity.class);
          localIntent.putExtra("fileinfo", (Parcelable)localObject1);
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(String.valueOf(localFileManagerEntity.nSessionId));
          if (localFileManagerEntity.nFileType == 0)
          {
            localObject2 = this.d.getMessageFacade().o(((MessageForDeviceFile)localObject2).frienduin, ((MessageForDeviceFile)localObject2).istroop);
            if ((localObject2 != null) && (((List)localObject2).size() != 0))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                Object localObject3 = (ChatMessage)((Iterator)localObject2).next();
                if (((ChatMessage)localObject3).msgtype == -4500)
                {
                  localObject3 = (MessageForDeviceFile)localObject3;
                  if (FileManagerUtil.c(((MessageForDeviceFile)localObject3).filePath) == localFileManagerEntity.nFileType)
                  {
                    localObject3 = FileManagerUtil.a((MessageForDeviceFile)localObject3);
                    if (!((ArrayList)localObject1).contains(String.valueOf(((FileManagerEntity)localObject3).nSessionId))) {
                      ((ArrayList)localObject1).add(String.valueOf(((FileManagerEntity)localObject3).nSessionId));
                    }
                  }
                }
              }
            }
          }
          localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
          ((Activity)this.e).startActivityForResult(localIntent, 102);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      super.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DevicePicItemBuilder
 * JD-Core Version:    0.7.0.1
 */