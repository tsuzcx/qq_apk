package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
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
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceFile.DeviceFileItemCallback;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeviceFileItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate, MessageForDeviceFile.DeviceFileItemCallback
{
  boolean f = false;
  
  public DeviceFileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(DeviceFileItemBuilder.Holder paramHolder)
  {
    int i = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131364634);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131366943);
    ((RelativeLayout)localObject2).setBackgroundResource(2130844418);
    ((RelativeLayout)localObject2).setPadding(AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364634);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131366944);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131366943);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
    ((AsyncImageView)localObject2).setWidth(k);
    ((AsyncImageView)localObject2).setHeight(k);
    ((AsyncImageView)localObject2).setId(2131364601);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131366944);
    localLayoutParams.addRule(15, 2131366944);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131364602);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131366944);
    localLayoutParams.addRule(15, 2131366944);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364603);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167052));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131364601);
    localLayoutParams.addRule(11, 2131366944);
    localLayoutParams.addRule(10, 2131366944);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364600);
    ((TextView)localObject2).setSingleLine();
    if (VersionUtils.e()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131364603);
    localLayoutParams.addRule(6, 2131364605);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramHolder.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364605);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131366944);
    localLayoutParams.addRule(12, 2131366944);
    localLayoutParams.addRule(1, 2131364600);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramHolder.c = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, DeviceFileItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(paramMessageForDeviceFile.srcFileName));
    paramHolder.b.setText(FileUtil.a(paramMessageForDeviceFile.fileSize));
    FileManagerUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, FileManagerUtil.a(paramMessageForDeviceFile.filePath));
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(DeviceMsgHandle.c) == 0)) {
      this.f = true;
    }
    d(paramHolder, paramMessageForDeviceFile);
    a(paramHolder, paramMessageForDeviceFile);
    paramBaseChatItemLayout.setFailedIconVisable(a(paramMessageForDeviceFile), this);
  }
  
  private void a(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null)
    {
      paramHolder.c.setVisibility(8);
      return;
    }
    c(paramHolder, paramMessageForDeviceFile);
    b(paramHolder, paramMessageForDeviceFile);
  }
  
  private void a(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramHolder.c.setVisibility(0);
    if ((!paramMessageForDeviceFile.isSend()) && (this.f)) {
      paramHolder.c.setText(paramString);
    }
  }
  
  private void a(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile, String paramString, int paramInt1, int paramInt2)
  {
    if (paramMessageForDeviceFile.isSend())
    {
      paramHolder.c.setVisibility(paramInt1);
      return;
    }
    paramHolder.c.setVisibility(0);
    paramHolder.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(paramInt2));
  }
  
  private void a(DeviceFileItemBuilder.Holder paramHolder, String paramString)
  {
    paramHolder.c.setVisibility(0);
    if (this.f) {
      paramHolder.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691637));
    }
  }
  
  private boolean a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      return false;
    }
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    case 11: 
    default: 
      return false;
    }
    return true;
  }
  
  private void b(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile)
  {
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    case 0: 
    case 11: 
    default: 
      return;
    case -1: 
      a(paramHolder, paramMessageForDeviceFile, "", 8, 2131692426);
      return;
    case 1: 
    case 2: 
    case 3: 
      e(paramHolder, paramMessageForDeviceFile, "");
      return;
    case 4: 
      d(paramHolder, paramMessageForDeviceFile, "");
      return;
    case 6: 
      c(paramHolder, paramMessageForDeviceFile, "");
      return;
    case 5: 
      b(paramHolder, paramMessageForDeviceFile, "");
      return;
    case 9: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691629));
      return;
    case 8: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691630));
      return;
    case 19: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691631));
      return;
    case 10: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691634));
      return;
    case 12: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691636) + "（错误01）");
      return;
    case 13: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691636) + "（错误02）");
      return;
    case 14: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691636) + "（错误03）");
      return;
    case 15: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691636) + "（错误04）");
      return;
    case 16: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691636) + "（错误05）");
      return;
    case 17: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691636) + "（错误06）");
      return;
    case 20: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691636) + "（错误07）");
      return;
    case 21: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691636) + "（错误08）");
      return;
    case 22: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691636) + "（错误09）");
      return;
    case 24: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691636) + "（错误10）");
      return;
    case 25: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691636) + "（错误11）");
      return;
    case 18: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691636) + this.jdField_a_of_type_AndroidContentContext.getString(2131691634));
      return;
    case 23: 
      a(paramHolder, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691635));
      return;
    }
    a(paramHolder, "");
  }
  
  private void b(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramHolder.c.setVisibility(0);
    if (paramMessageForDeviceFile.isSend())
    {
      if (this.f)
      {
        paramHolder.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691638));
        return;
      }
      paramHolder.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692425));
      return;
    }
    if (this.f)
    {
      paramHolder.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691633));
      return;
    }
    paramHolder.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692417));
  }
  
  private void c(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)AIOUtils.a(paramView);
    paramView = FileManagerUtil.a((MessageForDeviceFile)localObject2);
    Object localObject1 = new ForwardFileInfo();
    if ((this.f) && (paramView.nFileType != 0)) {
      ((ForwardFileInfo)localObject1).b(10000);
    }
    Intent localIntent;
    for (;;)
    {
      ((ForwardFileInfo)localObject1).d(8);
      ((ForwardFileInfo)localObject1).b(paramView.nSessionId);
      ((ForwardFileInfo)localObject1).d(paramView.fileName);
      ((ForwardFileInfo)localObject1).c(paramView.uniseq);
      ((ForwardFileInfo)localObject1).d(paramView.fileSize);
      ((ForwardFileInfo)localObject1).a(paramView.getFilePath());
      ((ForwardFileInfo)localObject1).b(paramView.Uuid);
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
      localIntent.putExtra("fileinfo", (Parcelable)localObject1);
      localObject1 = new ArrayList();
      if ((paramView.nFileType != 0) && (paramView.nFileType != 1)) {
        break;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((MessageForDeviceFile)localObject2).frienduin, ((MessageForDeviceFile)localObject2).istroop);
      if ((localObject2 == null) || (((List)localObject2).size() == 0)) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ChatMessage)((Iterator)localObject2).next();
        if (((ChatMessage)localObject3).msgtype == -4500)
        {
          localObject3 = (MessageForDeviceFile)localObject3;
          if (FileManagerUtil.a(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(FileManagerUtil.a((MessageForDeviceFile)localObject3).nSessionId));
          }
        }
      }
      ((ForwardFileInfo)localObject1).b(10009);
    }
    localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 102);
  }
  
  private void c(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if ((this.f) && (paramMessageForDeviceFile.issend == 0))
    {
      paramHolder.c.setMaxLines(3);
      return;
    }
    paramHolder.c.setMaxLines(2);
  }
  
  private void c(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramHolder.c.setVisibility(0);
    if (paramMessageForDeviceFile.isSend())
    {
      paramHolder.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692424));
      return;
    }
    if (this.f)
    {
      paramHolder.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691628));
      return;
    }
    paramHolder.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692423));
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (paramHolder.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131364604);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838138));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131366944);
          localLayoutParams.addRule(12, 2131366943);
          localLayoutParams.setMargins(0, AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    while (paramHolder.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void d(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    if (paramMessageForDeviceFile.isSend())
    {
      paramHolder.c.setVisibility(4);
      return;
    }
    paramHolder.c.setVisibility(0);
    paramHolder.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131693800));
  }
  
  private void e(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    if (this.f)
    {
      paramHolder.c.setVisibility(0);
      if (paramMessageForDeviceFile.isSend())
      {
        paramHolder.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131720416));
        return;
      }
      paramHolder.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691632));
      return;
    }
    paramHolder.c.setVisibility(4);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    ((DeviceFileItemBuilder.Holder)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.e;
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    DeviceFileItemBuilder.Holder localHolder = (DeviceFileItemBuilder.Holder)paramViewHolder;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((DeviceFileItemBuilder.Holder)paramViewHolder);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, localHolder);
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnClickListener(this);
    localHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    return this;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new DeviceFileItemBuilder.Holder(this);
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131703199);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForDeviceFile localMessageForDeviceFile;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131365636) {
        break label37;
      }
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label37:
    do
    {
      return;
      if (paramInt == 2131371997)
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
    } while (paramInt != 2131367398);
    paramContext = new Bundle();
    paramContext.putInt("forward_type", 0);
    paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramContext.putInt("selection_mode", this.b);
    paramChatMessage = new Intent();
    paramChatMessage.putExtra("forward_filepath", localMessageForDeviceFile.filePath);
    paramChatMessage.putExtra("BUSI_TYPE", 1009);
    paramChatMessage.putExtra("forward_download_image_org_uin", localMessageForDeviceFile.frienduin);
    paramChatMessage.putExtra("forward_download_image_org_uin_type", localMessageForDeviceFile.istroop);
    paramChatMessage.putExtra("forward_photo_isSend", localMessageForDeviceFile.issend);
    paramChatMessage.putExtras(paramContext);
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((DeviceFileItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
        localActionSheet.addButton(2131690018, 5);
        localActionSheet.addCancelButton(2131690800);
        localActionSheet.setOnButtonClickListener(new DeviceFileItemBuilder.1(this, paramView, localActionSheet));
        localActionSheet.show();
        return;
      }
    } while (this.f);
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
    localActionSheet.setMainTitle(2131691627);
    localActionSheet.addButton(2131691626);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new DeviceFileItemBuilder.2(this, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (DeviceFileItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground();
    } while (paramView == null);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return;
    case 0: 
      paramView.setColorFilter(BaseBubbleBuilder.jdField_a_of_type_AndroidGraphicsColorFilter);
      paramView.invalidateSelf();
      return;
    }
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, MessageForDeviceFile paramMessageForDeviceFile)
  {
    paramView = (DeviceFileItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "error get holder in updateview");
      }
    }
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (localMessageForDeviceFile.uniseq != paramMessageForDeviceFile.uniseq);
    localMessageForDeviceFile.msgStatus = paramMessageForDeviceFile.msgStatus;
    localMessageForDeviceFile.nFileStatus = paramMessageForDeviceFile.nFileStatus;
    localMessageForDeviceFile.progress = paramMessageForDeviceFile.progress;
    localMessageForDeviceFile.msg = paramMessageForDeviceFile.msg;
    a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForDeviceFile, paramView);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    paramView = (DeviceFileItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView == null) {}
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground();
    } while (localDrawable == null);
    if (paramBoolean) {}
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  void a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      FMToastUtil.a(2131692602);
      return;
    }
    if (FileUtils.b(paramMessageForDeviceFile.filePath)) {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.b();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((DeviceFileItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
    }
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return localQQCustomMenu.a();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      FMToastUtil.a(2131692602);
      return;
    }
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramMessageForDeviceFile);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.o = true;
    if (super.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)AIOUtils.a(paramView);
      if ((paramView.getId() != 2131364643) || (localMessageForDeviceFile == null) || (localMessageForDeviceFile.uint32_src_uin_type != 1))
      {
        super.onClick(paramView);
        switch (paramView.getId())
        {
        case 2131364602: 
        case 2131364642: 
        default: 
          break;
        case 2131364634: 
          c(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */