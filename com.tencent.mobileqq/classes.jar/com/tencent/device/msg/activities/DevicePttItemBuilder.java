package com.tencent.device.msg.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewCallback;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewData;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import mqq.app.AppRuntime;

public class DevicePttItemBuilder
  extends PttItemBuilder
  implements DeviceAVFileMsgObserver.DevMsgViewCallback
{
  protected int a;
  
  public DevicePttItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.jdField_a_of_type_Int = 18;
  }
  
  protected int a(MessageForPtt paramMessageForPtt)
  {
    int i = 0;
    if (paramMessageForPtt == null) {
      return 0;
    }
    if (paramMessageForPtt.isSendFromLocal())
    {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(AppConstants.SDCARD_ROOT)))
      {
        if (paramMessageForPtt.fileSize > 0L) {
          return 1003;
        }
        if (paramMessageForPtt.fileSize == -1L) {}
        for (;;)
        {
          return 1005;
          if (paramMessageForPtt.fileSize != -2L) {
            break;
          }
          if (a(paramMessageForPtt)) {
            return 999;
          }
          paramMessageForPtt.fileSize = -1L;
        }
        long l = paramMessageForPtt.fileSize;
        return 1001;
      }
      return 1004;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handlePttItem recieve friendUin ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" url ");
      localStringBuilder.append(paramMessageForPtt.url);
      localStringBuilder.append(" urlAtServer ");
      localStringBuilder.append(paramMessageForPtt.urlAtServer);
      localStringBuilder.append(" uniseq ");
      localStringBuilder.append(paramMessageForPtt.uniseq);
      QLog.d("DevicePttItemBuilder", 2, localStringBuilder.toString());
    }
    if (paramMessageForPtt != null)
    {
      if (paramMessageForPtt.url == null) {}
      do
      {
        return 2005;
        if ((paramMessageForPtt.url.startsWith(AppConstants.SDCARD_ROOT)) && (FileUtils.fileExists(paramMessageForPtt.url))) {}
        while ((paramMessageForPtt.url.startsWith("/data/data")) && (FileUtils.fileExists(paramMessageForPtt.url))) {
          return 2003;
        }
      } while (paramMessageForPtt.fileSize == -1L);
      int j = 2002;
      i = j;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handlePttItem recieve status ");
        localStringBuilder.append(2002);
        localStringBuilder.append("   url ");
        localStringBuilder.append(paramMessageForPtt.url);
        localStringBuilder.append(" uniseq ");
        localStringBuilder.append(paramMessageForPtt.uniseq);
        QLog.d("DevicePttItemBuilder", 2, localStringBuilder.toString());
        i = j;
      }
    }
    return i;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "getBubbleView fileStatus");
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    PttItemBuilder.Holder localHolder = (PttItemBuilder.Holder)paramViewHolder;
    if (!FileUtils.fileExistsAndNotEmpty(localMessageForPtt.url)) {
      a(localHolder, localMessageForPtt);
    }
    paramChatMessage = b(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  protected void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    if (localMessageForPtt == null) {
      return;
    }
    paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
      paramView.addButton(2131689933);
      paramView.addCancelButton(2131690728);
      paramView.setOnButtonClickListener(new DevicePttItemBuilder.1(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
    localActionSheet.setMainTitle(2131691549);
    localActionSheet.addButton(2131691548);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new DevicePttItemBuilder.2(this, paramView, localMessageForPtt, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(View paramView, DeviceAVFileMsgObserver.DevMsgViewData paramDevMsgViewData)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    if (localMessageForPtt != null)
    {
      if (localMessageForPtt.uniseq != paramDevMsgViewData.jdField_a_of_type_Long) {
        return;
      }
      int j = paramDevMsgViewData.jdField_a_of_type_Int;
      paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
      int i;
      if ((j != 1003) && (j != 2003))
      {
        if ((j != 1005) && (j != 1004))
        {
          if (localMessageForPtt.fileSize == -2L)
          {
            i = 999;
          }
          else if (localMessageForPtt.fileSize == -3L)
          {
            i = 1001;
          }
          else if (localMessageForPtt.fileSize == -1L)
          {
            i = 1005;
          }
          else
          {
            i = j;
            if (j == 2005)
            {
              localMessageForPtt.fileSize = -4L;
              i = j;
            }
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          i = j;
        }
      }
      else
      {
        b();
        i = j;
      }
      if (QLog.isColorLevel())
      {
        paramDevMsgViewData = new StringBuilder();
        paramDevMsgViewData.append("fileStatus:");
        paramDevMsgViewData.append(i);
        paramDevMsgViewData.append("|url ");
        paramDevMsgViewData.append(localMessageForPtt.url);
        paramDevMsgViewData.append("|uniseq ");
        paramDevMsgViewData.append(localMessageForPtt.uniseq);
        QLog.d("PTTItem->handleMessage", 2, paramDevMsgViewData.toString());
      }
      a(paramView, localMessageForPtt, i, c(localMessageForPtt));
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    paramViewHolder = (PttItemBuilder.Holder)paramViewHolder;
    if (paramViewHolder != null)
    {
      if (paramBubbleInfo == null) {
        return;
      }
      if ((paramBubbleInfo.jdField_a_of_type_Int != 0) && (paramBubbleInfo.a()))
      {
        if (paramBubbleInfo.jdField_b_of_type_Int == 0)
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          if (paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
            paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
          }
          if (paramViewHolder.b != null) {
            paramViewHolder.b.setTextColor(-16777216);
          }
        }
        else
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
          if (paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
            paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
          }
          if (paramViewHolder.b != null) {
            paramViewHolder.b.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
          }
        }
        if ((paramBubbleInfo.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double * 10000.0D) == 1))
        {
          float f2 = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
          float f1 = f2;
          if (f2 > 25.0F) {
            f1 = 25.0F;
          }
          paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
          paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.d);
        }
        return;
      }
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend()) {
        i = 2131167079;
      } else {
        i = 2131167075;
      }
      paramView = paramView.getColorStateList(i);
      if ((paramViewHolder.jdField_a_of_type_AndroidWidgetTextView != null) && (paramView != null)) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
      }
      if ((paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramView != null)) {
        paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramView);
      }
      if ((paramViewHolder.b != null) && (paramView != null)) {
        paramViewHolder.b.setTextColor(paramView);
      }
    }
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt)
  {
    paramHolder = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramHolder instanceof QQAppInterface))
    {
      paramHolder = (QQAppInterface)paramHolder;
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramMessageForPtt.fileSize = -1L;
        paramMessageForPtt.extraflag = 32768;
        paramMessageForPtt.serial();
        paramHolder.getMessageFacade().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new DevicePttItemBuilder.3(this, paramMessageForPtt));
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    b(paramHolder, paramMessageForPtt, paramInt, paramBoolean);
    if (paramInt == 2005)
    {
      if (TextUtils.isEmpty(paramMessageForPtt.timeStr))
      {
        paramMessageForPtt.timeStr = PttItemBuilder.a(paramMessageForPtt.voiceLength);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("voiceLength showPttItem voice:");
          localStringBuilder.append(paramMessageForPtt.voiceLength);
          QLog.d("DevicePttItemBuilder", 2, localStringBuilder.toString());
        }
      }
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessageForPtt.timeStr);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return paramView.a();
  }
  
  protected View b(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (PttItemBuilder.Holder)paramViewHolder;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131374097);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131374102);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167075));
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject).setId(2131374098);
      ((RelativeLayout)localObject).addView(paramView);
      ((RelativeLayout)localObject).addView(localTextView);
      paramViewHolder.addView((View)localObject);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramViewHolder;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
    }
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374102);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, -1);
    }
    else
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374097);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
    int j = a(localMessageForPtt);
    int i = j;
    if (j == -1)
    {
      a(paramBaseChatItemLayout, localMessageForPtt);
      i = 2001;
    }
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("fileStatus = ");
      paramChatMessage.append(i);
      paramChatMessage.append(" url ");
      paramChatMessage.append(localMessageForPtt.url);
      paramChatMessage.append(" uniseq ");
      paramChatMessage.append(localMessageForPtt.uniseq);
      QLog.d("PTTItem->getBubbleView", 2, paramChatMessage.toString());
    }
    a(paramBaseChatItemLayout, localMessageForPtt, i, c(localMessageForPtt));
    return paramViewHolder;
  }
  
  protected void b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {
      return;
    }
    if (localChatMessage.istroop == 9501)
    {
      if (localChatMessage.isSendFromLocal())
      {
        super.b(paramView);
        return;
      }
      if ("device_groupchat".equals(localChatMessage.extStr)) {
        super.b(paramView);
      }
    }
  }
  
  protected void b(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fileStatus is:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",url is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.url);
      ((StringBuilder)localObject1).append(",uniseq is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.uniseq);
      ((StringBuilder)localObject1).append(",stt is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.sttAbility);
      ((StringBuilder)localObject1).append(",long is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.longPttVipFlag);
      ((StringBuilder)localObject1).append(", voiceLength is: ");
      ((StringBuilder)localObject1).append(paramMessageForPtt.voiceLength);
      QLog.d("DevicePttItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    int i = 0;
    ((BaseChatItemLayout)localObject1).setUnread(false);
    localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    if (paramHolder.c != null)
    {
      paramHolder.c.setVisibility(8);
      paramHolder.c.setOnClickListener(null);
      paramHolder.d.setVisibility(8);
    }
    if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(null);
      paramHolder.e.setVisibility(8);
      paramHolder.f.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    Object localObject6 = this.jdField_a_of_type_AndroidContentContext.getResources();
    boolean bool3 = a(paramMessageForPtt, paramHolder);
    boolean bool1;
    if (paramMessageForPtt.voiceChangeFlag != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramHolder, paramMessageForPtt);
    Object localObject2 = "";
    if (paramInt != -1) {}
    Object localObject5;
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        break;
      case 2004: 
      case 2005: 
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(10.0F, (Resources)localObject6), BaseChatItemLayout.m, AIOUtils.b(10.0F, (Resources)localObject6), BaseChatItemLayout.n);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
        }
        a(paramHolder, bool2, bool1, paramMessageForPtt.isSend());
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
        a(paramMessageForPtt, bool1, paramHolder);
        localObject4 = "";
        localObject1 = null;
        paramInt = 1;
      }
      break;
    case 999: 
    case 1000: 
      break;
    case 1001: 
    case 1002: 
    case 1003: 
    case 1004: 
    case 1005: 
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("voiceLength showPttItem builder");
        ((StringBuilder)localObject1).append(paramMessageForPtt.voiceLength);
        QLog.d("DevicePttItemBuilder", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramMessageForPtt.voiceLength <= 1) {
        paramMessageForPtt.voiceLength = ((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(paramMessageForPtt);
      }
      if (paramMessageForPtt.voiceLength <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevicePttItemBuilder", 2, "get a amr file length = 0 return now");
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(10.0F, (Resources)localObject6), BaseChatItemLayout.m, AIOUtils.b(10.0F, (Resources)localObject6), BaseChatItemLayout.n);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
        }
        return;
      }
      if (paramMessageForPtt.voiceLength > PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt"))
      {
        if (paramMessageForPtt.longPttVipFlag == 1)
        {
          if (this.jdField_a_of_type_AndroidTextSpannableString == null)
          {
            this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
            localObject1 = ((Resources)localObject6).getDrawable(2130840420);
            ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
            localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).setOffset(0.05F);
            this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
          localObject1 = "QQ会员专享长语音";
        }
        else if (paramMessageForPtt.longPttVipFlag == 2)
        {
          if (this.b == null)
          {
            this.b = new SpannableString(HardCodeUtil.a(2131703374));
            localObject1 = ((Resources)localObject6).getDrawable(2130840419);
            ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
            localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).setOffset(0.05F);
            this.b.setSpan(localObject1, 0, 3, 17);
          }
          localObject1 = HardCodeUtil.a(2131703371);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.b, this);
        }
        else
        {
          localObject1 = null;
        }
        if (VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isSVip())
        {
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localObject5 = HttpUtil.getNetWorkTypeByStr();
          if (VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isSVip()) {
            localObject2 = "svip";
          } else {
            localObject2 = "vip";
          }
          VasWebviewUtil.a((String)localObject4, "LongVoice", "TailView", "0", 1, 0, 0, (String)localObject5, "", (String)localObject2);
        }
      }
      else
      {
        localObject1 = null;
      }
      if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
        paramMessageForPtt.sttAbility = 0;
      }
      if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
        paramMessageForPtt.timeStr = a(paramMessageForPtt.voiceLength);
      }
      localObject4 = paramMessageForPtt.timeStr;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showPttItem, msgText = ");
        ((StringBuilder)localObject2).append((String)localObject4);
        ((StringBuilder)localObject2).append(", message.voiceLength");
        ((StringBuilder)localObject2).append(paramMessageForPtt.voiceLength);
        QLog.d("DevicePttItemBuilder", 2, ((StringBuilder)localObject2).toString());
      }
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
      a(paramHolder, bool2, bool1, paramMessageForPtt.isSend());
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      a(paramMessageForPtt, paramBoolean, bool2, bool1, paramHolder);
      if (paramMessageForPtt.isSend())
      {
        if (paramMessageForPtt.mRobotFlag == 1)
        {
          localObject2 = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject2, null);
          }
        }
      }
      else
      {
        localObject2 = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject2, null);
        }
      }
      int k;
      if ((paramInt != 2003) && (paramInt != 1003))
      {
        if ((paramInt != 1005) && (paramInt != 1004)) {
          i = 4;
        } else {
          i = 1;
        }
        k = 1;
        paramInt = 0;
      }
      else
      {
        if ((!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt))
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true);
          paramInt = 1;
        }
        else
        {
          paramInt = 0;
        }
        if ((paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.voiceChangeFlag != 1) && (paramMessageForPtt.expandStt)) {
          j = 2;
        } else {
          j = 1;
        }
        i = 0;
        k = j;
      }
      j = AIOUtils.b(9.0F, (Resources)localObject6);
      int n = AIOUtils.b(12.0F, (Resources)localObject6);
      int m;
      try
      {
        m = ((Resources)localObject6).getDrawable(2130844831).getIntrinsicHeight();
      }
      catch (Exception localException)
      {
        m = AIOUtils.b(24.0F, (Resources)localObject6);
        QLog.e("DevicePttItemBuilder", 1, "", localException);
      }
      int i1 = AIOUtils.b(1.0F, (Resources)localObject6);
      if (k == 1)
      {
        m = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, null, null, 0);
        if (paramMessageForPtt.isSend())
        {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, j, 0);
          localObject3 = paramHolder.jdField_a_of_type_AndroidWidgetTextView;
          n = BaseChatItemLayout.m;
          if (bool2) {
            k = j;
          } else {
            k = BaseChatItemLayout.r;
          }
          ((TextView)localObject3).setPadding(0, n, k, BaseChatItemLayout.n);
        }
        else
        {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(j, 0, 0, 0);
          localObject3 = paramHolder.jdField_a_of_type_AndroidWidgetTextView;
          if (bool2) {
            k = j;
          } else {
            k = BaseChatItemLayout.r;
          }
          ((TextView)localObject3).setPadding(k, BaseChatItemLayout.m, 0, BaseChatItemLayout.n);
        }
        localObject3 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool2, bool1, m + j, paramHolder);
      }
      else
      {
        if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null)
        {
          localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject3).setImageDrawable(new ColorDrawable(838860800));
          localObject5 = new RelativeLayout.LayoutParams(-1, i1);
          ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject5);
          ((ImageView)localObject3).setId(2131374118);
          ETTextView localETTextView = new ETTextView(this.jdField_a_of_type_AndroidContentContext);
          if (paramMessageForPtt.isSend()) {
            k = 2131167079;
          } else {
            k = 2131167075;
          }
          Object localObject7 = ((Resources)localObject6).getColorStateList(k);
          if (localObject7 != null) {
            localETTextView.setTextColor((ColorStateList)localObject7);
          }
          localETTextView.setId(2131374117);
          localObject7 = new RelativeLayout.LayoutParams(-2, -2);
          localETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject7);
          ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localImageView.setLayoutParams(localLayoutParams);
          localImageView.setImageResource(2130844831);
          localImageView.setScaleType(ImageView.ScaleType.FIT_END);
          ((RelativeLayout.LayoutParams)localObject5).addRule(3, 2131374098);
          ((RelativeLayout.LayoutParams)localObject5).addRule(14);
          ((RelativeLayout.LayoutParams)localObject7).addRule(3, 2131374118);
          localLayoutParams.addRule(3, 2131374118);
          localLayoutParams.addRule(14);
          localLayoutParams.addRule(6, 2131374117);
          localLayoutParams.addRule(8, 2131374117);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject3);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localETTextView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
          paramHolder.e = ((ImageView)localObject3);
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView = localETTextView;
          paramHolder.f = localImageView;
        }
        else
        {
          paramHolder.e.setVisibility(0);
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
          paramHolder.f.setVisibility(0);
        }
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = new AIOSelectableDelegateProxy();
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.b(paramMessageForPtt);
        localObject5 = paramMessageForPtt.sttText;
        localObject3 = localObject5;
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131719265);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
          this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        k = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, (String)localObject3, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), 0);
        localObject5 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool2, bool1, k + j, paramHolder);
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        k = AIOUtils.b(22.0F, (Resources)localObject6) + m;
        if (paramMessageForPtt.isSend())
        {
          localObject3 = (RelativeLayout.LayoutParams)paramHolder.e.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131374098);
          ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131374098);
          localObject3 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131374098);
          ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131374098);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, j, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.m, BaseChatItemLayout.r, BaseChatItemLayout.n);
          paramHolder.e.setPadding(j, 0, j, 0);
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, BaseChatItemLayout.m, j, k);
          paramHolder.f.setPadding(0, 0, 0, n);
        }
        else
        {
          localObject3 = (RelativeLayout.LayoutParams)paramHolder.e.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131374098);
          ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131374098);
          localObject3 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131374098);
          ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131374098);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(j, 0, 0, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.r, BaseChatItemLayout.m, 0, BaseChatItemLayout.n);
          paramHolder.e.setPadding(j, 0, j, 0);
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, BaseChatItemLayout.m, j, k);
          paramHolder.f.setPadding(0, 0, 0, n);
        }
        localObject6 = paramMessageForPtt.sttText;
        localObject3 = localObject6;
        if (TextUtils.isEmpty((CharSequence)localObject6)) {
          localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131719265);
        }
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText((CharSequence)localObject3);
        localObject3 = localObject5;
      }
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null)
      {
        localObject5 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject5).width = (localObject3[0] + localObject3[1] + localObject3[2]);
        ((RelativeLayout.LayoutParams)localObject5).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool2, paramHolder);
        if (QLog.isColorLevel())
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("message seq=");
          ((StringBuilder)localObject6).append(paramMessageForPtt.uniseq);
          ((StringBuilder)localObject6).append(", VpLp.width=");
          ((StringBuilder)localObject6).append(((RelativeLayout.LayoutParams)localObject5).width);
          ((StringBuilder)localObject6).append(", flagTimeContainer.getLeft()=");
          ((StringBuilder)localObject6).append(paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
          QLog.d("DevicePttItemBuilder", 2, ((StringBuilder)localObject6).toString());
        }
        if ((bool2) && (((RelativeLayout.LayoutParams)localObject5).height > 0))
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
          localObject6 = paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7);
          if ((((BubbleInfo.CommonAttrs)((Pair)localObject6).first).a != null) && (((BubbleInfo.CommonAttrs)((Pair)localObject6).first).a.length > 0))
          {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setBitmap((BubbleInfo.CommonAttrs)((Pair)localObject6).first, localObject3[0], ((RelativeLayout.LayoutParams)localObject5).height, localObject3[1], localObject3[2], paramMessageForPtt.isSend() ^ true);
            if (paramBoolean) {
              paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
            } else {
              paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
            }
          }
        }
        else
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
        }
      }
      localObject3 = localObject4;
      j = paramInt;
      localObject4 = "";
      paramInt = i;
      i = j;
      break;
    }
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(40.0F, (Resources)localObject6), BaseChatItemLayout.m, AIOUtils.b(40.0F, (Resources)localObject6), BaseChatItemLayout.n);
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
    Object localObject4 = "";
    Object localObject3 = "";
    localObject1 = null;
    paramInt = 0;
    i = 0;
    int j = paramInt;
    if (paramMessageForPtt.sttAbility == 1)
    {
      j = paramInt;
      if (((ISttManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt)) {
        j = 4;
      }
    }
    if (j != 1)
    {
      if (j != 4)
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView != null) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
      }
      else
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839406, null);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((Animatable)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
      }
    }
    else
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localObject5 = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView;
      if (paramMessageForPtt.isSendFromLocal()) {
        paramInt = 2131703375;
      } else {
        paramInt = 2131703372;
      }
      ((ImageView)localObject5).setContentDescription(HardCodeUtil.a(paramInt));
    }
    if (bool3)
    {
      paramMessageForPtt = (IQWalletConfigService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQWalletConfigService.class, (String)localObject4);
      if (paramMessageForPtt != null) {
        paramMessageForPtt = paramMessageForPtt.getString("voice_pwd", HardCodeUtil.a(2131703376), new String[] { "lowTipStr" });
      } else {
        paramMessageForPtt = HardCodeUtil.a(2131703376);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
    }
    if (AppSetting.d)
    {
      paramMessageForPtt = HardCodeUtil.a(2131703378);
      if (i != 0)
      {
        localObject4 = paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(paramMessageForPtt);
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append(HardCodeUtil.a(2131703380));
        ((StringBuilder)localObject5).append(HardCodeUtil.a(2131703379));
        ((RelativeLayout)localObject4).setContentDescription(((StringBuilder)localObject5).toString());
      }
      else
      {
        localObject4 = paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(paramMessageForPtt);
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append(HardCodeUtil.a(2131703377));
        ((RelativeLayout)localObject4).setContentDescription(((StringBuilder)localObject5).toString());
      }
      if (paramHolder.jdField_a_of_type_JavaLangStringBuilder != null)
      {
        paramMessageForPtt = paramHolder.jdField_a_of_type_JavaLangStringBuilder;
        paramMessageForPtt.append("发送了语音.");
        paramMessageForPtt.append((String)localObject3);
        if (localObject1 != null)
        {
          paramHolder = paramHolder.jdField_a_of_type_JavaLangStringBuilder;
          paramHolder.append(" ");
          paramHolder.append((String)localObject1);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.o = true;
    int i = paramView.getId();
    if ((AppSetting.d) && (i == 2131363435))
    {
      paramView.findViewById(2131374098).performClick();
    }
    else
    {
      Object localObject2 = (PttItemBuilder.Holder)AIOUtils.a(paramView);
      if (localObject2 != null)
      {
        Object localObject1 = (MessageForPtt)((PttItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        Object localObject3;
        if (i == 2131374098)
        {
          if (c((ChatMessage)localObject1)) {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          } else if ((localObject1 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject1).isReady())) {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695163, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
            } else if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.a(paramView))) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695162, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
            }
          }
          if (((MessageForPtt)localObject1).istroop == 1008) {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject1).timeStr, "", false);
          }
          if (((MessageForPtt)localObject1).voiceChangeFlag == 1)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(((MessageForPtt)localObject1).istroop);
            ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, ((StringBuilder)localObject3).toString(), "", "", "");
          }
        }
        else if (i == 2131374117)
        {
          if (((MessageForPtt)localObject1).expandStt)
          {
            ((MessageForPtt)localObject1).expandStt = false;
            ((MessageForPtt)localObject1).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForPtt)localObject1).uniseq, ((MessageForPtt)localObject1).msgData);
            a((PttItemBuilder.Holder)localObject2, (MessageForPtt)localObject1, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject1), c((ChatMessage)localObject1));
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
          }
        }
        else if (i == 2131364550)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localObject3 = HttpUtil.getNetWorkTypeByStr();
          if (VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isSVip()) {
            localObject1 = "svip";
          } else {
            localObject1 = "vip";
          }
          VasWebviewUtil.a((String)localObject2, "LongVoice", "TailClick", "0", 1, 0, 0, (String)localObject3, "", (String)localObject1);
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((Intent)localObject1).putExtra("url", "https://m.vip.qq.com/freedom/xhycyy.html?_nav_alpha=0");
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        }
        else
        {
          super.onClick(paramView);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevicePttItemBuilder
 * JD-Core Version:    0.7.0.1
 */