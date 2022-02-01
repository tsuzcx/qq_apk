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
  boolean a = false;
  
  public DeviceFileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(DeviceFileItemBuilder.Holder paramHolder)
  {
    int i = AIOUtils.b(10.0F, this.e.getResources());
    int j = AIOUtils.b(50.0F, this.e.getResources());
    int k = AIOUtils.b(70.0F, this.e.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.e);
    localRelativeLayout.setId(2131430578);
    Object localObject2 = new RelativeLayout(this.e);
    ((RelativeLayout)localObject2).setId(2131433127);
    ((RelativeLayout)localObject2).setBackgroundResource(2130845641);
    ((RelativeLayout)localObject2).setPadding(AIOUtils.b(12.0F, this.e.getResources()), i, i, AIOUtils.b(7.0F, this.e.getResources()));
    paramHolder.a = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131430578);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.e);
    ((RelativeLayout)localObject1).setId(2131433128);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131433127);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.e);
    ((AsyncImageView)localObject2).setWidth(k);
    ((AsyncImageView)localObject2).setHeight(k);
    ((AsyncImageView)localObject2).setId(2131430545);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131433128);
    localLayoutParams.addRule(15, 2131433128);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramHolder.f = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.e);
    ((ImageView)localObject2).setId(2131430546);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131433128);
    localLayoutParams.addRule(15, 2131433128);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramHolder.g = ((ImageView)localObject2);
    localObject2 = new TextView(this.e);
    ((TextView)localObject2).setId(2131430547);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.e.getResources().getColorStateList(2131168016));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131430545);
    localLayoutParams.addRule(11, 2131433128);
    localLayoutParams.addRule(10, 2131433128);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramHolder.b = ((TextView)localObject2);
    localObject2 = new TextView(this.e);
    ((TextView)localObject2).setId(2131430544);
    ((TextView)localObject2).setSingleLine();
    if (VersionUtils.e()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131430547);
    localLayoutParams.addRule(6, 2131430549);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramHolder.c = ((TextView)localObject2);
    localObject2 = new TextView(this.e);
    ((TextView)localObject2).setId(2131430549);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131433128);
    localLayoutParams.addRule(12, 2131433128);
    localLayoutParams.addRule(1, 2131430544);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramHolder.d = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, DeviceFileItemBuilder.Holder paramHolder)
  {
    paramHolder.b.setText(FileManagerUtil.j(paramMessageForDeviceFile.srcFileName));
    paramHolder.c.setText(FileUtil.a(paramMessageForDeviceFile.fileSize));
    FileManagerUtil.a(paramHolder.f, paramMessageForDeviceFile.filePath, FileManagerUtil.c(paramMessageForDeviceFile.filePath));
    paramHolder.g.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(DeviceMsgHandle.c) == 0)) {
      this.a = true;
    }
    d(paramHolder, paramMessageForDeviceFile);
    a(paramHolder, paramMessageForDeviceFile);
    paramBaseChatItemLayout.setFailedIconVisable(d(paramMessageForDeviceFile), this);
  }
  
  private void a(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null)
    {
      paramHolder.d.setVisibility(8);
      return;
    }
    c(paramHolder, paramMessageForDeviceFile);
    b(paramHolder, paramMessageForDeviceFile);
  }
  
  private void a(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramHolder.d.setVisibility(0);
    if ((!paramMessageForDeviceFile.isSend()) && (this.a)) {
      paramHolder.d.setText(paramString);
    }
  }
  
  private void a(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile, String paramString, int paramInt1, int paramInt2)
  {
    if (paramMessageForDeviceFile.isSend())
    {
      paramHolder.d.setVisibility(paramInt1);
      return;
    }
    paramHolder.d.setVisibility(0);
    paramHolder = paramHolder.d;
    paramMessageForDeviceFile = new StringBuilder();
    paramMessageForDeviceFile.append(paramString);
    paramMessageForDeviceFile.append(this.e.getString(paramInt2));
    paramHolder.setText(paramMessageForDeviceFile.toString());
  }
  
  private void a(DeviceFileItemBuilder.Holder paramHolder, String paramString)
  {
    paramHolder.d.setVisibility(0);
    if (this.a)
    {
      paramHolder = paramHolder.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(this.e.getString(2131888521));
      paramHolder.setText(localStringBuilder.toString());
    }
  }
  
  private void b(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile)
  {
    StringBuilder localStringBuilder;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    case 0: 
    case 11: 
    default: 
      return;
    case 25: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888520));
      localStringBuilder.append("（错误11）");
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 24: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888520));
      localStringBuilder.append("（错误10）");
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 23: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888519));
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 22: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888520));
      localStringBuilder.append("（错误09）");
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 21: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888520));
      localStringBuilder.append("（错误08）");
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 20: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888520));
      localStringBuilder.append("（错误07）");
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 19: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888515));
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 18: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888520));
      localStringBuilder.append(this.e.getString(2131888518));
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 17: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888520));
      localStringBuilder.append("（错误06）");
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 16: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888520));
      localStringBuilder.append("（错误05）");
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 15: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888520));
      localStringBuilder.append("（错误04）");
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 14: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888520));
      localStringBuilder.append("（错误03）");
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 13: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888520));
      localStringBuilder.append("（错误02）");
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 12: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888520));
      localStringBuilder.append("（错误01）");
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 10: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888518));
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 9: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888513));
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 8: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.getString(2131888514));
      a(paramHolder, paramMessageForDeviceFile, localStringBuilder.toString());
      return;
    case 7: 
      a(paramHolder, "");
      return;
    case 6: 
      c(paramHolder, paramMessageForDeviceFile, "");
      return;
    case 5: 
      b(paramHolder, paramMessageForDeviceFile, "");
      return;
    case 4: 
      d(paramHolder, paramMessageForDeviceFile, "");
      return;
    case 1: 
    case 2: 
    case 3: 
      e(paramHolder, paramMessageForDeviceFile, "");
      return;
    }
    a(paramHolder, paramMessageForDeviceFile, "", 8, 2131889346);
  }
  
  private void b(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramHolder.d.setVisibility(0);
    if (paramMessageForDeviceFile.isSend())
    {
      if (this.a)
      {
        paramHolder = paramHolder.d;
        paramMessageForDeviceFile = new StringBuilder();
        paramMessageForDeviceFile.append(paramString);
        paramMessageForDeviceFile.append(this.e.getString(2131888522));
        paramHolder.setText(paramMessageForDeviceFile.toString());
        return;
      }
      paramHolder = paramHolder.d;
      paramMessageForDeviceFile = new StringBuilder();
      paramMessageForDeviceFile.append(paramString);
      paramMessageForDeviceFile.append(this.e.getString(2131889345));
      paramHolder.setText(paramMessageForDeviceFile.toString());
      return;
    }
    if (this.a)
    {
      paramHolder = paramHolder.d;
      paramMessageForDeviceFile = new StringBuilder();
      paramMessageForDeviceFile.append(paramString);
      paramMessageForDeviceFile.append(this.e.getString(2131888517));
      paramHolder.setText(paramMessageForDeviceFile.toString());
      return;
    }
    paramHolder = paramHolder.d;
    paramMessageForDeviceFile = new StringBuilder();
    paramMessageForDeviceFile.append(paramString);
    paramMessageForDeviceFile.append(this.e.getString(2131889337));
    paramHolder.setText(paramMessageForDeviceFile.toString());
  }
  
  private void c(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if ((this.a) && (paramMessageForDeviceFile.issend == 0))
    {
      paramHolder.d.setMaxLines(3);
      return;
    }
    paramHolder.d.setMaxLines(2);
  }
  
  private void c(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramHolder.d.setVisibility(0);
    if (paramMessageForDeviceFile.isSend())
    {
      paramHolder = paramHolder.d;
      paramMessageForDeviceFile = new StringBuilder();
      paramMessageForDeviceFile.append(paramString);
      paramMessageForDeviceFile.append(this.e.getString(2131889344));
      paramHolder.setText(paramMessageForDeviceFile.toString());
      return;
    }
    if (this.a)
    {
      paramHolder = paramHolder.d;
      paramMessageForDeviceFile = new StringBuilder();
      paramMessageForDeviceFile.append(paramString);
      paramMessageForDeviceFile.append(this.e.getString(2131888512));
      paramHolder.setText(paramMessageForDeviceFile.toString());
      return;
    }
    paramHolder = paramHolder.d;
    paramMessageForDeviceFile = new StringBuilder();
    paramMessageForDeviceFile.append(paramString);
    paramMessageForDeviceFile.append(this.e.getString(2131889343));
    paramHolder.setText(paramMessageForDeviceFile.toString());
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile)
  {
    int j = 1;
    int i;
    if (paramMessageForDeviceFile != null)
    {
      int k = paramMessageForDeviceFile.nFileStatus;
      i = j;
      if (k != 1)
      {
        i = j;
        if (k != 2)
        {
          i = j;
          if (k == 3) {}
        }
      }
    }
    else
    {
      i = 0;
    }
    if (i != 0)
    {
      if (paramHolder.e == null)
      {
        ProgressBar localProgressBar = new ProgressBar(this.e, null, 16842872);
        localProgressBar.setId(2131430548);
        localProgressBar.setMax(100);
        localProgressBar.setMinimumHeight(AIOUtils.b(4.0F, this.e.getResources()));
        localProgressBar.setProgressDrawable(this.e.getResources().getDrawable(2130838011));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.b(4.0F, this.e.getResources()));
        localLayoutParams.addRule(3, 2131433128);
        localLayoutParams.addRule(12, 2131433127);
        localLayoutParams.setMargins(0, AIOUtils.b(2.0F, this.e.getResources()), 0, 0);
        paramHolder.a.addView(localProgressBar, localLayoutParams);
        paramHolder.e = localProgressBar;
      }
      paramHolder.e.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
      paramHolder.e.setVisibility(0);
      return;
    }
    if (paramHolder.e != null) {
      paramHolder.e.setVisibility(8);
    }
  }
  
  private void d(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    if (paramMessageForDeviceFile.isSend())
    {
      paramHolder.d.setVisibility(4);
      return;
    }
    paramHolder.d.setVisibility(0);
    paramHolder = paramHolder.d;
    paramMessageForDeviceFile = new StringBuilder();
    paramMessageForDeviceFile.append(paramString);
    paramMessageForDeviceFile.append(this.e.getString(2131891328));
    paramHolder.setText(paramMessageForDeviceFile.toString());
  }
  
  private boolean d(MessageForDeviceFile paramMessageForDeviceFile)
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
  
  private void e(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)AIOUtils.a(paramView);
    paramView = FileManagerUtil.a((MessageForDeviceFile)localObject2);
    Object localObject1 = new ForwardFileInfo();
    if ((this.a) && (paramView.nFileType != 0)) {
      ((ForwardFileInfo)localObject1).b(10000);
    } else {
      ((ForwardFileInfo)localObject1).b(10009);
    }
    ((ForwardFileInfo)localObject1).d(8);
    ((ForwardFileInfo)localObject1).b(paramView.nSessionId);
    ((ForwardFileInfo)localObject1).d(paramView.fileName);
    ((ForwardFileInfo)localObject1).c(paramView.uniseq);
    ((ForwardFileInfo)localObject1).d(paramView.fileSize);
    ((ForwardFileInfo)localObject1).a(paramView.getFilePath());
    ((ForwardFileInfo)localObject1).b(paramView.Uuid);
    Intent localIntent = new Intent(this.e, FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", (Parcelable)localObject1);
    localObject1 = new ArrayList();
    if ((paramView.nFileType == 0) || (paramView.nFileType == 1))
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
            if (FileManagerUtil.c(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
              ((ArrayList)localObject1).add(String.valueOf(FileManagerUtil.a((MessageForDeviceFile)localObject3).nSessionId));
            }
          }
        }
      }
    }
    localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
    ((Activity)this.e).startActivityForResult(localIntent, 102);
  }
  
  private void e(DeviceFileItemBuilder.Holder paramHolder, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    if (this.a)
    {
      paramHolder.d.setVisibility(0);
      if (paramMessageForDeviceFile.isSend())
      {
        paramHolder = paramHolder.d;
        paramMessageForDeviceFile = new StringBuilder();
        paramMessageForDeviceFile.append(paramString);
        paramMessageForDeviceFile.append(this.e.getString(2131917785));
        paramHolder.setText(paramMessageForDeviceFile.toString());
        return;
      }
      paramHolder = paramHolder.d;
      paramMessageForDeviceFile = new StringBuilder();
      paramMessageForDeviceFile.append(paramString);
      paramMessageForDeviceFile.append(this.e.getString(2131888516));
      paramHolder.setText(paramMessageForDeviceFile.toString());
      return;
    }
    paramHolder.d.setVisibility(4);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    ((DeviceFileItemBuilder.Holder)paramChatMessage.getTag()).h.getLayoutParams().width = BaseChatItemLayout.e;
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (DeviceFileItemBuilder.Holder)paramViewHolder;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a(paramViewHolder);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, paramViewHolder);
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnClickListener(this);
    paramViewHolder.g.setOnClickListener(this);
    ((DeviceMsgHandle)this.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).b().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new DeviceFileItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
      if (paramInt == 2131431695)
      {
        ChatActivityFacade.b(this.e, this.d, paramChatMessage);
        return;
      }
      if (paramInt == 2131439015)
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      if (paramInt == 2131433636)
      {
        paramContext = new Bundle();
        paramContext.putInt("forward_type", 0);
        paramContext.putInt("forward_source_uin_type", this.f.a);
        paramContext.putInt("selection_mode", this.u);
        paramChatMessage = new Intent();
        paramChatMessage.putExtra("forward_filepath", localMessageForDeviceFile.filePath);
        paramChatMessage.putExtra("BUSI_TYPE", 1009);
        paramChatMessage.putExtra("forward_download_image_org_uin", localMessageForDeviceFile.frienduin);
        paramChatMessage.putExtra("forward_download_image_org_uin_type", localMessageForDeviceFile.istroop);
        paramChatMessage.putExtra("forward_photo_isSend", localMessageForDeviceFile.issend);
        paramChatMessage.putExtras(paramContext);
        ForwardBaseOption.a((Activity)this.e, paramChatMessage, 21);
      }
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (DeviceFileItemBuilder.Holder)AIOUtils.b(paramView);
    if (paramView == null) {
      return;
    }
    paramView = paramView.a.getBackground();
    if (paramView == null) {
      return;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return;
      }
      paramView.setColorFilter(null);
      paramView.invalidateSelf();
      return;
    }
    paramView.setColorFilter(BaseBubbleBuilder.n);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, MessageForDeviceFile paramMessageForDeviceFile)
  {
    paramView = (DeviceFileItemBuilder.Holder)AIOUtils.b(paramView);
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "error get holder in updateview");
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
    paramView = (DeviceFileItemBuilder.Holder)AIOUtils.b(paramView);
    if (paramView == null) {
      return;
    }
    Drawable localDrawable = paramView.a.getBackground();
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
  
  void a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!NetworkUtil.isNetSupport(this.e))
    {
      FMToastUtil.a(2131889577);
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceFile.filePath)) {
      ((DeviceMsgHandle)this.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).b().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.d();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((DeviceFileItemBuilder.Holder)AIOUtils.b(paramView)).q).filePath)) {
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
    paramView = (MessageForDeviceFile)((DeviceFileItemBuilder.Holder)AIOUtils.b(paramView)).q;
    ActionSheet localActionSheet;
    if (paramView.isSendFromLocal())
    {
      localActionSheet = (ActionSheet)ActionSheetHelper.b(this.e, null);
      localActionSheet.addButton(2131886574, 5);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new DeviceFileItemBuilder.1(this, paramView, localActionSheet));
      localActionSheet.show();
      return;
    }
    if (!this.a)
    {
      localActionSheet = ActionSheet.create(this.e);
      localActionSheet.setMainTitle(2131888511);
      localActionSheet.addButton(2131888510);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new DeviceFileItemBuilder.2(this, paramView, localActionSheet));
      localActionSheet.show();
    }
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
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    return this;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131901291);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.q = true;
    if (!super.c())
    {
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)AIOUtils.a(paramView);
      if ((paramView.getId() != 2131430587) || (localMessageForDeviceFile == null) || (localMessageForDeviceFile.uint32_src_uin_type != 1))
      {
        super.onClick(paramView);
        int i = paramView.getId();
        if ((i != 2131430546) && (i == 2131430578)) {
          e(paramView);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */