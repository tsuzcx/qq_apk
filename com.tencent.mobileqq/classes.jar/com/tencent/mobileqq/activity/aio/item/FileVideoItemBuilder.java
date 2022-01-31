package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavBuilder;
import java.io.File;
import java.net.URL;
import vcf;
import vch;
import vcj;
import vck;
import vcm;

public class FileVideoItemBuilder
  extends BaseBubbleBuilder
{
  final String a;
  public Handler b = new Handler();
  
  public FileVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaLangString = "FileVideoItemBuilder<FileAssistant>";
  }
  
  private void a(String paramString1, String paramString2, vcm paramvcm, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramvcm.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramvcm.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramvcm.jdField_a_of_type_AndroidViewView).removeView(paramvcm.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131361963);
    localRelativeLayout.setBackgroundResource(2130838370);
    paramvcm.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131366638);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131366638);
      if (paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
        int i = QFileUtils.a(paramvcm.e, paramvcm.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131361963);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        localRelativeLayout.addView(paramViewGroup, (ViewGroup.LayoutParams)localObject);
        localObject = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject).setId(2131361962);
        ((TextView)localObject).setTextSize(2, 14.0F);
        ((TextView)localObject).setTextColor(-1);
        ((TextView)localObject).setSingleLine();
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label513;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131361963);
        label412:
        localRelativeLayout.addView((View)localObject, localLayoutParams);
        paramString1 = QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, i, paramvcm.e, (TextView)localObject, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject).setText(paramString1);
      paramViewGroup.setText(paramString2);
      return;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      break;
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      break;
      label513:
      localLayoutParams.addRule(12);
      break label412;
      ((TextView)localObject).setLines(2);
      ((TextView)localObject).setMaxLines(2);
      paramViewGroup.setGravity(3);
      continue;
      ((TextView)localObject).setLines(1);
      ((TextView)localObject).setMaxLines(1);
      paramViewGroup.setGravity(5);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    vcm localvcm;
    if (vcm.class.isInstance(paramViewHolder)) {
      localvcm = (vcm)paramViewHolder;
    }
    for (paramViewHolder = paramView;; paramViewHolder = null)
    {
      this.jdField_a_of_type_AndroidContentContext.getResources();
      Object localObject = paramViewHolder;
      if (paramViewHolder == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder.setId(2131366638);
        paramViewHolder.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramViewHolder.setRadius(15.0F);
        paramViewHolder.d(true);
        paramViewHolder.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramViewHolder);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131361903);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramViewHolder.setOnClickListener(this);
        paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
        localvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramViewHolder;
        localvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      boolean bool = paramChatMessage.isSend();
      if (localvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        localvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
        localvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      localvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      localvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnTouchListener(paramOnLongClickAndTouchListener);
      localvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
      localvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
      localvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
      localvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      localvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
      localvcm.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramChatMessage, localvcm, paramView, paramBaseChatItemLayout);
      return localObject;
      localvcm = new vcm(this);
      localvcm.jdField_b_of_type_JavaLangStringBuilder = paramViewHolder.jdField_b_of_type_JavaLangStringBuilder;
      localvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localvcm.jdField_a_of_type_AndroidViewView = paramViewHolder.jdField_a_of_type_AndroidViewView;
      localvcm.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
      localvcm.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localvcm.jdField_a_of_type_Int = paramViewHolder.jdField_a_of_type_Int;
      localvcm.jdField_b_of_type_Int = paramViewHolder.jdField_b_of_type_Int;
      localvcm.c = paramViewHolder.c;
      localvcm.d = paramViewHolder.d;
      localvcm.jdField_a_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (paramView != null)
    {
      paramView = AIOUtils.a(paramView);
      if ((paramView != null) && (vcm.class.isInstance(paramView)))
      {
        paramView = (vcm)paramView;
        if (paramView != null) {
          return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
        }
      }
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new vcm(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出视频文件";
    }
    return "发来视频文件";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    super.a(paramInt, paramContext, paramChatMessage);
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131361906: 
      long l1 = MessageCache.a();
      long l2 = paramChatMessage.time;
      if ((paramChatMessage.msgtype == -2005) && (paramChatMessage.istroop == 3000) && (l1 - l2 > 604800L))
      {
        FMToastUtil.a("该文件发送超过7天，撤回失败。");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
        return;
      }
      a(paramChatMessage);
      FileManagerReporter.a("0X8005E4B");
      return;
    case 2131375653: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
      if (FileModel.a((MessageForFile)paramChatMessage).a(false))
      {
        FMDialogUtil.a(paramContext, 2131428241, 2131428238, new vcj(this, paramChatMessage, paramContext));
        return;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramContext);
      return;
    case 2131366774: 
      paramContext = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
      new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, paramChatMessage, false);
      return;
    case 2131375660: 
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramContext);
      return;
    case 2131375654: 
      paramContext = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
      Object localObject = new FileManagerReporter.fileAssistantReportData();
      ((FileManagerReporter.fileAssistantReportData)localObject).b = "file_forward";
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 9;
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Long = paramContext.fileSize;
      ((FileManagerReporter.fileAssistantReportData)localObject).c = FileUtil.a(paramContext.fileName);
      ((FileManagerReporter.fileAssistantReportData)localObject).d = FileManagerUtil.a(paramContext.getCloudType(), paramContext.peerType);
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.fileAssistantReportData)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("forward_type", 0);
      ((Bundle)localObject).putBoolean("not_forward", true);
      ((Bundle)localObject).putParcelable("fileinfo", ForwardFileOption.a(paramContext, paramChatMessage));
      paramChatMessage = new Intent();
      paramChatMessage.putExtras((Bundle)localObject);
      paramChatMessage.putExtra("forward_text", "已选择" + FileManagerUtil.d(paramContext.fileName) + "，大小" + FileUtil.a(paramContext.fileSize) + "。");
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      paramChatMessage.putExtra("forward _key_nojump", true);
      if (!NetworkUtil.d(BaseApplication.getContext())) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131434629, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
        return;
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      }
    case 2131375633: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      paramContext = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext);
      return;
    case 2131375643: 
      super.c(paramChatMessage);
      return;
    }
    paramContext = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.nSessionId);
    b();
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForFile)AIOUtils.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131428109);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131428107);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.c(str1);
    localActionSheet.d(this.jdField_a_of_type_AndroidContentContext.getString(2131433029));
    localActionSheet.a(str2);
    localActionSheet.a(new vck(this, paramView, localActionSheet));
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
  
  protected void a(ChatMessage paramChatMessage, vcm paramvcm, View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    int i = 480;
    int j = 640;
    paramView = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    paramChatMessage.fileName = paramView.fileName;
    if ((paramView.cloudType == 1) && (FileManagerUtil.a(paramView))) {
      paramView.status = 16;
    }
    if ((paramView.isSend()) && (paramView.status == 0))
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "Id[" + paramView.nSessionId + "] FileEntity,size(wh)[" + paramView.imgWidth + ":" + paramView.imgHeight + "]");
      }
      if (paramView.imgHeight > 0) {
        i = paramView.imgHeight;
      }
      if (paramView.imgWidth > 0) {
        j = paramView.imgWidth;
      }
      paramChatMessage = ShortVideoUtils.a(j, i);
      i = paramChatMessage[0];
      j = paramChatMessage[1];
      paramChatMessage = paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (paramChatMessage != null) {
        break label440;
      }
      paramChatMessage = new RelativeLayout.LayoutParams(i, j);
      paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramChatMessage);
      label217:
      paramChatMessage = paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramChatMessage != null) {
        break label481;
      }
      paramChatMessage = new LinearLayout.LayoutParams(i, j);
      paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramChatMessage);
      label249:
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "Id[" + paramView.nSessionId + "]show AIOFileVideoItem,use size(wh)[" + i + ":" + j + "]");
      }
      paramvcm.e = i;
      paramvcm.f = j;
      if (paramvcm.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramvcm.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        ((RelativeLayout)paramvcm.jdField_a_of_type_AndroidViewView).removeView(paramvcm.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      paramChatMessage = new EmptyDrawable(Color.rgb(214, 214, 214), i, j);
      paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      if (paramView.status != 2) {
        break label522;
      }
      a(paramvcm, (int)(paramView.fProgress * 100.0F), true);
      label407:
      if ((!paramView.bCannotPlay) && (paramView.status != 16)) {
        break label800;
      }
      a(paramView, paramvcm);
    }
    for (;;)
    {
      return;
      paramBaseChatItemLayout.setFailedIconVisable(false, this);
      break;
      label440:
      if ((paramChatMessage.width == i) && (paramChatMessage.height == j)) {
        break label217;
      }
      paramChatMessage.width = i;
      paramChatMessage.height = j;
      paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramChatMessage);
      break label217;
      label481:
      if ((paramChatMessage.width == i) && (paramChatMessage.height == j)) {
        break label249;
      }
      paramChatMessage.width = i;
      paramChatMessage.height = j;
      paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramChatMessage);
      break label249;
      label522:
      if (paramView.status == 0)
      {
        paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130845665);
        paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription("恢复按钮");
        paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
        break label407;
      }
      if (paramView.status == 3)
      {
        paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription("恢复按钮");
        if (paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
        {
          paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130845665);
          paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          break label407;
        }
        paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130845665);
        paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        break label407;
      }
      if (paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
        paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        break label407;
      }
      paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      break label407;
      label800:
      paramBaseChatItemLayout = FileUtils.a(paramView.fileSize);
      a(paramView.fileName, paramBaseChatItemLayout, paramvcm, (RelativeLayout)paramvcm.jdField_a_of_type_AndroidViewView, false);
      paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
      if (FileUtil.b(paramView.strLargeThumPath))
      {
        paramBaseChatItemLayout = ShortVideoUtils.a(paramView.strLargeThumPath);
        if ((paramvcm.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramvcm.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramBaseChatItemLayout)))
        {
          paramChatMessage = URLDrawable.getDrawable(paramBaseChatItemLayout, i, j, paramChatMessage, paramChatMessage);
          paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramChatMessage);
          paramvcm.jdField_a_of_type_ComTencentImageURLDrawable = paramChatMessage;
          paramChatMessage = URLDrawable.URLDrawableOptions.obtain();
          paramChatMessage.mLoadingDrawable = new ColorDrawable(-16777216);
          URLDrawable.getDrawable(new File(paramView.strLargeThumPath), paramChatMessage);
        }
        while ((paramView != null) && ((paramView.imgWidth <= 0) || (paramView.imgHeight <= 0)))
        {
          FileManagerUtil.e(paramView);
          return;
          if (paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getDrawable() != paramvcm.jdField_a_of_type_ComTencentImageURLDrawable) {
            paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramvcm.jdField_a_of_type_ComTencentImageURLDrawable);
          }
        }
      }
      else
      {
        paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130841676);
        if ((FileUtil.b(paramView.getFilePath())) && (FileManagerUtil.b(paramView)))
        {
          ThreadManager.executeOnSubThread(new vcf(this, paramView));
          return;
        }
        if (paramView.peerType == 3000) {}
        for (paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView); FileUtils.b(paramChatMessage); paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView))
        {
          ThreadManager.executeOnSubThread(new vch(this, paramView, paramChatMessage));
          return;
        }
      }
    }
  }
  
  protected void a(FileManagerEntity paramFileManagerEntity, vcm paramvcm)
  {
    if (paramvcm.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    float f = this.jdField_a_of_type_Float;
    Object localObject = new AIOFilePicMask(Color.parseColor("#D8DAE0"), 255, f * 8.0F);
    if (Build.VERSION.SDK_INT >= 16)
    {
      localRelativeLayout.setBackground((Drawable)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      if (paramFileManagerEntity.status != 16) {
        break label265;
      }
      ((TextView)localObject).setText("视频已失效");
    }
    for (;;)
    {
      ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130845666, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramvcm.e, paramvcm.f - 40);
      ((RelativeLayout)paramvcm.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = FileUtils.a(paramFileManagerEntity.fileSize);
      a(paramFileManagerEntity.fileName, (String)localObject, paramvcm, localRelativeLayout, true);
      paramvcm.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable((Drawable)localObject);
      break;
      label265:
      ((TextView)localObject).setText("该视频格式已损坏");
    }
  }
  
  protected void a(vcm paramvcm, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramvcm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvcm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForFile)((BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((paramView.isSendFromLocal()) && (localFileManagerEntity.status == 2)) {
      localQQCustomMenu.a(2131375635, this.jdField_a_of_type_AndroidContentContext.getString(2131433653), 2130838308);
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      if (localFileManagerEntity == null) {
        return localQQCustomMenu.a();
      }
      if (localFileManagerEntity.status != 16)
      {
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          localQQCustomMenu.a(2131375654, "转发", 2130838318);
        }
        a(paramView, localQQCustomMenu);
        if (FileManagerUtil.c(localFileManagerEntity)) {
          localQQCustomMenu.a(2131366774, "收藏", 2130838317);
        }
        if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && ((localFileManagerEntity.nOpType == 1) || (localFileManagerEntity.nOpType == 8)))) {
          a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
        }
      }
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.m = true;
    if (super.a()) {}
    do
    {
      do
      {
        return;
        if ((paramView.getId() != 2131366638) && (paramView.getId() != 2131361903))
        {
          super.onClick(paramView);
          return;
        }
        paramView = (MessageForFile)AIOUtils.a(paramView);
        paramView = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        if (paramView == null)
        {
          QLog.e("FileVideoItemBuilder<FileAssistant>", 1, "get Entity by Msg faild!");
          return;
        }
      } while (paramView.status == 16);
      if (QFileUtils.a(paramView)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileVideoItemBuilder<FileAssistant>", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    if ((paramView.sendCloudUnsuccessful()) && (!FileUtil.b(paramView.getFilePath())))
    {
      FMToastUtil.a("请在视频发送完查看。");
      return;
    }
    FileManagerReporter.fileAssistantReportData localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
    localfileAssistantReportData.b = "file_viewer_in";
    localfileAssistantReportData.jdField_a_of_type_Int = 9;
    localfileAssistantReportData.c = FileUtil.a(paramView.fileName);
    localfileAssistantReportData.d = FileManagerUtil.a(paramView.getCloudType(), paramView.peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localfileAssistantReportData);
    FileManagerReporter.a("0X8004AE3");
    FileModel.a(paramView).a((Activity)this.jdField_a_of_type_AndroidContentContext);
    ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E53", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */