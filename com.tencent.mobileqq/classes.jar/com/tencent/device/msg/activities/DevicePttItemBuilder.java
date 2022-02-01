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
  protected int a = 18;
  
  public DevicePttItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
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
          if (c(paramMessageForPtt)) {
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
      localStringBuilder.append(this.f.b);
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
    ((DeviceMsgHandle)this.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public void a(View paramView, DeviceAVFileMsgObserver.DevMsgViewData paramDevMsgViewData)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    if (localMessageForPtt != null)
    {
      if (localMessageForPtt.uniseq != paramDevMsgViewData.a) {
        return;
      }
      int j = paramDevMsgViewData.b;
      paramView = (PttItemBuilder.Holder)AIOUtils.b(paramView);
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
          this.c.notifyDataSetChanged();
          i = j;
        }
      }
      else
      {
        d();
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
      a(paramView, localMessageForPtt, i, f(localMessageForPtt));
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
      if ((paramBubbleInfo.a != 0) && (paramBubbleInfo.b()))
      {
        if (paramBubbleInfo.l == 0)
        {
          paramViewHolder.d.setTextColor(-16777216);
          if (paramViewHolder.f != null) {
            paramViewHolder.f.setTextColor(-16777216);
          }
          if (paramViewHolder.A != null) {
            paramViewHolder.A.setTextColor(-16777216);
          }
        }
        else
        {
          paramViewHolder.d.setTextColor(paramBubbleInfo.l);
          if (paramViewHolder.f != null) {
            paramViewHolder.f.setTextColor(paramBubbleInfo.l);
          }
          if (paramViewHolder.A != null) {
            paramViewHolder.A.setTextColor(paramBubbleInfo.l);
          }
        }
        if ((paramBubbleInfo.p) && (((ChatBackgroundManager)this.d.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.e, this.f, paramViewHolder.d.getCurrentTextColor(), paramViewHolder.i.q * 10000.0D) == 1))
        {
          float f2 = paramViewHolder.d.getTextSize() * 3.0F / 16.0F;
          float f1 = f2;
          if (f2 > 25.0F) {
            f1 = 25.0F;
          }
          paramViewHolder.d.setTextColor(-1);
          paramViewHolder.d.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.n);
        }
        return;
      }
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend()) {
        i = 2131168020;
      } else {
        i = 2131168016;
      }
      paramView = paramView.getColorStateList(i);
      if ((paramViewHolder.d != null) && (paramView != null)) {
        paramViewHolder.d.setTextColor(paramView);
      }
      if ((paramViewHolder.f != null) && (paramView != null)) {
        paramViewHolder.f.setTextColor(paramView);
      }
      if ((paramViewHolder.A != null) && (paramView != null)) {
        paramViewHolder.A.setTextColor(paramView);
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
    this.d.execute(new DevicePttItemBuilder.3(this, paramMessageForPtt));
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
      paramHolder.d.setText(paramMessageForPtt.timeStr);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.e, this.f.a);
    super.a(paramView, this.e, 2131428089, null, null);
    return paramView.d();
  }
  
  protected View b(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (PttItemBuilder.Holder)paramViewHolder;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new BreathAnimationLayout(this.e);
      paramView = new ImageView(this.e);
      paramView.setId(2131442192);
      TextView localTextView = new TextView(this.e);
      localTextView.setId(2131442197);
      localTextView.setTextColor(this.e.getResources().getColorStateList(2131168016));
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(this.e);
      ((RelativeLayout)localObject).setId(2131442193);
      ((RelativeLayout)localObject).addView(paramView);
      ((RelativeLayout)localObject).addView(localTextView);
      paramViewHolder.addView((View)localObject);
      paramBaseChatItemLayout.v = paramViewHolder;
      paramBaseChatItemLayout.d = localTextView;
      paramBaseChatItemLayout.b = paramView;
      paramBaseChatItemLayout.B = ((RelativeLayout)localObject);
    }
    paramBaseChatItemLayout.D = paramOnLongClickAndTouchListener;
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.b.getLayoutParams()).addRule(1, 2131442197);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.d.getLayoutParams()).addRule(1, -1);
    }
    else
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.d.getLayoutParams()).addRule(1, 2131442192);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.b.getLayoutParams()).addRule(1, -1);
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
    a(paramBaseChatItemLayout, localMessageForPtt, i, f(localMessageForPtt));
    return paramViewHolder;
  }
  
  protected void b(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    if (localMessageForPtt == null) {
      return;
    }
    paramView = (PttItemBuilder.Holder)AIOUtils.b(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ActionSheet.create(this.e);
      paramView.addButton(2131886574);
      paramView.addCancelButton(2131887648);
      paramView.setOnButtonClickListener(new DevicePttItemBuilder.1(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(this.e);
    localActionSheet.setMainTitle(2131888511);
    localActionSheet.addButton(2131888510);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new DevicePttItemBuilder.2(this, paramView, localMessageForPtt, localActionSheet));
    localActionSheet.show();
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
    Object localObject1 = paramHolder.j;
    int i = 0;
    ((BaseChatItemLayout)localObject1).setUnread(false);
    localObject1 = (RelativeLayout.LayoutParams)paramHolder.B.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    if (paramHolder.w != null)
    {
      paramHolder.w.setVisibility(8);
      paramHolder.w.setOnClickListener(null);
      paramHolder.x.setVisibility(8);
    }
    if (paramHolder.f != null)
    {
      paramHolder.f.setVisibility(8);
      paramHolder.f.setOnClickListener(null);
      paramHolder.y.setVisibility(8);
      paramHolder.z.setVisibility(8);
    }
    paramHolder.j.setTailMessage(false, null, null);
    paramHolder.B.setOnTouchListener(paramHolder.D);
    paramHolder.B.setOnLongClickListener(paramHolder.D);
    Object localObject6 = this.e.getResources();
    boolean bool3 = a(paramMessageForPtt, paramHolder);
    boolean bool1;
    if (paramMessageForPtt.voiceChangeFlag != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = a(this.d, this.e, this.c, paramHolder, paramMessageForPtt);
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
        paramHolder.d.setText("");
        paramHolder.d.setPadding(AIOUtils.b(10.0F, (Resources)localObject6), BaseChatItemLayout.n, AIOUtils.b(10.0F, (Resources)localObject6), BaseChatItemLayout.o);
        if (paramHolder.c != null) {
          paramHolder.c.setVisibility(8);
        }
        a(paramHolder, bool2, bool1, paramMessageForPtt.isSend());
        paramHolder.v.setAnimating(false);
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
        paramHolder.b.setImageDrawable(null);
        paramHolder.b.setPadding(0, 0, 0, 0);
        paramHolder.d.setText("");
        paramHolder.d.setPadding(AIOUtils.b(10.0F, (Resources)localObject6), BaseChatItemLayout.n, AIOUtils.b(10.0F, (Resources)localObject6), BaseChatItemLayout.o);
        if (paramHolder.c != null) {
          paramHolder.c.setVisibility(8);
        }
        return;
      }
      if (paramMessageForPtt.voiceLength > PttItemBuilder.a(this.d, "Normal_MaxPtt"))
      {
        if (paramMessageForPtt.longPttVipFlag == 1)
        {
          if (this.w == null)
          {
            this.w = new SpannableString("[v] QQ会员专享长语音");
            localObject1 = ((Resources)localObject6).getDrawable(2130841176);
            ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
            localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).setOffset(0.05F);
            this.w.setSpan(localObject1, 0, 3, 17);
          }
          paramHolder.j.setTailMessage(true, this.w, this);
          localObject1 = "QQ会员专享长语音";
        }
        else if (paramMessageForPtt.longPttVipFlag == 2)
        {
          if (this.x == null)
          {
            this.x = new SpannableString(HardCodeUtil.a(2131901334));
            localObject1 = ((Resources)localObject6).getDrawable(2130841175);
            ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
            localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).setOffset(0.05F);
            this.x.setSpan(localObject1, 0, 3, 17);
          }
          localObject1 = HardCodeUtil.a(2131901331);
          paramHolder.j.setTailMessage(true, this.x, this);
        }
        else
        {
          localObject1 = null;
        }
        if (VasUtil.b(this.d).getVipStatus().isSVip())
        {
          localObject4 = this.d.getCurrentAccountUin();
          localObject5 = HttpUtil.getNetWorkTypeByStr();
          if (VasUtil.b(this.d).getVipStatus().isSVip()) {
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
      if (paramMessageForPtt.voiceLength > a(this.d, "ConvertText_MaxPtt")) {
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
      paramHolder.d.setText((CharSequence)localObject4);
      a(paramHolder, bool2, bool1, paramMessageForPtt.isSend());
      paramHolder.v.setAnimating(false);
      paramHolder.B.setOnClickListener(this);
      a(paramMessageForPtt, paramBoolean, bool2, bool1, paramHolder);
      if (paramMessageForPtt.isSend())
      {
        if (paramMessageForPtt.mRobotFlag == 1)
        {
          localObject2 = ((TroopRobotManager)this.d.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.d, paramMessageForPtt);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramHolder.j.setTailMessage(true, (CharSequence)localObject2, null);
          }
        }
      }
      else
      {
        localObject2 = ((TroopRobotManager)this.d.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.d, paramMessageForPtt);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramHolder.j.setTailMessage(true, (CharSequence)localObject2, null);
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
          paramHolder.j.setUnread(true);
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
        m = ((Resources)localObject6).getDrawable(2130846265).getIntrinsicHeight();
      }
      catch (Exception localException)
      {
        m = AIOUtils.b(24.0F, (Resources)localObject6);
        QLog.e("DevicePttItemBuilder", 1, "", localException);
      }
      int i1 = AIOUtils.b(1.0F, (Resources)localObject6);
      if (k == 1)
      {
        m = a(this.e, paramMessageForPtt.voiceLength, null, null, 0);
        if (paramMessageForPtt.isSend())
        {
          paramHolder.b.setPadding(0, 0, j, 0);
          localObject3 = paramHolder.d;
          n = BaseChatItemLayout.n;
          if (bool2) {
            k = j;
          } else {
            k = BaseChatItemLayout.q;
          }
          ((TextView)localObject3).setPadding(0, n, k, BaseChatItemLayout.o);
        }
        else
        {
          paramHolder.b.setPadding(j, 0, 0, 0);
          localObject3 = paramHolder.d;
          if (bool2) {
            k = j;
          } else {
            k = BaseChatItemLayout.q;
          }
          ((TextView)localObject3).setPadding(k, BaseChatItemLayout.n, 0, BaseChatItemLayout.o);
        }
        localObject3 = VoicePrintUtils.a(this.d, bool2, bool1, m + j, paramHolder);
      }
      else
      {
        if (paramHolder.f == null)
        {
          localObject3 = new ImageView(this.e);
          ((ImageView)localObject3).setImageDrawable(new ColorDrawable(838860800));
          localObject5 = new RelativeLayout.LayoutParams(-1, i1);
          ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject5);
          ((ImageView)localObject3).setId(2131442213);
          ETTextView localETTextView = new ETTextView(this.e);
          if (paramMessageForPtt.isSend()) {
            k = 2131168020;
          } else {
            k = 2131168016;
          }
          Object localObject7 = ((Resources)localObject6).getColorStateList(k);
          if (localObject7 != null) {
            localETTextView.setTextColor((ColorStateList)localObject7);
          }
          localETTextView.setId(2131442212);
          localObject7 = new RelativeLayout.LayoutParams(-2, -2);
          localETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject7);
          ImageView localImageView = new ImageView(this.e);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localImageView.setLayoutParams(localLayoutParams);
          localImageView.setImageResource(2130846265);
          localImageView.setScaleType(ImageView.ScaleType.FIT_END);
          ((RelativeLayout.LayoutParams)localObject5).addRule(3, 2131442193);
          ((RelativeLayout.LayoutParams)localObject5).addRule(14);
          ((RelativeLayout.LayoutParams)localObject7).addRule(3, 2131442213);
          localLayoutParams.addRule(3, 2131442213);
          localLayoutParams.addRule(14);
          localLayoutParams.addRule(6, 2131442212);
          localLayoutParams.addRule(8, 2131442212);
          paramHolder.v.addView((View)localObject3);
          paramHolder.v.addView(localETTextView);
          paramHolder.v.addView(localImageView);
          paramHolder.y = ((ImageView)localObject3);
          paramHolder.f = localETTextView;
          paramHolder.z = localImageView;
        }
        else
        {
          paramHolder.y.setVisibility(0);
          paramHolder.f.setVisibility(0);
          paramHolder.z.setVisibility(0);
        }
        paramHolder.f.setOnClickListener(this);
        paramHolder.f.setOnTouchListener(paramHolder.D);
        paramHolder.f.setOnLongClickListener(paramHolder.D);
        paramHolder.g = new AIOSelectableDelegateProxy();
        paramHolder.g.a(paramHolder.f);
        paramHolder.g.a(paramHolder.j, paramHolder.j);
        paramHolder.g.b(paramMessageForPtt);
        localObject5 = paramMessageForPtt.sttText;
        localObject3 = localObject5;
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          localObject3 = this.e.getString(2131916817);
        }
        if (this.y == null) {
          this.y = new TextView(this.e);
        }
        this.y.setTextSize(0, this.f.r);
        k = a(this.e, paramMessageForPtt.voiceLength, (String)localObject3, this.y.getPaint(), 0);
        localObject5 = VoicePrintUtils.a(this.d, bool2, bool1, k + j, paramHolder);
        paramHolder.f.setTextSize(0, this.f.r);
        k = AIOUtils.b(22.0F, (Resources)localObject6) + m;
        if (paramMessageForPtt.isSend())
        {
          localObject3 = (RelativeLayout.LayoutParams)paramHolder.y.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131442193);
          ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131442193);
          localObject3 = (RelativeLayout.LayoutParams)paramHolder.f.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131442193);
          ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131442193);
          paramHolder.b.setPadding(0, 0, j, 0);
          paramHolder.d.setPadding(0, BaseChatItemLayout.n, BaseChatItemLayout.q, BaseChatItemLayout.o);
          paramHolder.y.setPadding(j, 0, j, 0);
          paramHolder.f.setPadding(j, BaseChatItemLayout.n, j, k);
          paramHolder.z.setPadding(0, 0, 0, n);
        }
        else
        {
          localObject3 = (RelativeLayout.LayoutParams)paramHolder.y.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131442193);
          ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131442193);
          localObject3 = (RelativeLayout.LayoutParams)paramHolder.f.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131442193);
          ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131442193);
          paramHolder.b.setPadding(j, 0, 0, 0);
          paramHolder.d.setPadding(BaseChatItemLayout.q, BaseChatItemLayout.n, 0, BaseChatItemLayout.o);
          paramHolder.y.setPadding(j, 0, j, 0);
          paramHolder.f.setPadding(j, BaseChatItemLayout.n, j, k);
          paramHolder.z.setPadding(0, 0, 0, n);
        }
        localObject6 = paramMessageForPtt.sttText;
        localObject3 = localObject6;
        if (TextUtils.isEmpty((CharSequence)localObject6)) {
          localObject3 = this.e.getString(2131916817);
        }
        paramHolder.f.setText((CharSequence)localObject3);
        localObject3 = localObject5;
      }
      if (paramHolder.c != null)
      {
        localObject5 = (RelativeLayout.LayoutParams)paramHolder.c.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject5).width = (localObject3[0] + localObject3[1] + localObject3[2]);
        ((RelativeLayout.LayoutParams)localObject5).height = VoicePrintUtils.a(this.d, bool2, paramHolder);
        if (QLog.isColorLevel())
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("message seq=");
          ((StringBuilder)localObject6).append(paramMessageForPtt.uniseq);
          ((StringBuilder)localObject6).append(", VpLp.width=");
          ((StringBuilder)localObject6).append(((RelativeLayout.LayoutParams)localObject5).width);
          ((StringBuilder)localObject6).append(", flagTimeContainer.getLeft()=");
          ((StringBuilder)localObject6).append(paramHolder.B.getLeft());
          QLog.d("DevicePttItemBuilder", 2, ((StringBuilder)localObject6).toString());
        }
        if ((bool2) && (((RelativeLayout.LayoutParams)localObject5).height > 0))
        {
          paramHolder.c.setVisibility(0);
          localObject6 = paramHolder.i.a(this.d, 7);
          if ((((BubbleInfo.CommonAttrs)((Pair)localObject6).first).k != null) && (((BubbleInfo.CommonAttrs)((Pair)localObject6).first).k.length > 0))
          {
            paramHolder.c.setBitmap((BubbleInfo.CommonAttrs)((Pair)localObject6).first, localObject3[0], ((RelativeLayout.LayoutParams)localObject5).height, localObject3[1], localObject3[2], paramMessageForPtt.isSend() ^ true);
            if (paramBoolean) {
              paramHolder.c.a(false);
            } else {
              paramHolder.c.a(true);
            }
          }
        }
        else
        {
          paramHolder.c.setVisibility(4);
        }
      }
      localObject3 = localObject4;
      j = paramInt;
      localObject4 = "";
      paramInt = i;
      i = j;
      break;
    }
    paramHolder.b.setImageDrawable(null);
    paramHolder.b.setPadding(0, 0, 0, 0);
    paramHolder.d.setText("");
    paramHolder.d.setPadding(AIOUtils.b(40.0F, (Resources)localObject6), BaseChatItemLayout.n, AIOUtils.b(40.0F, (Resources)localObject6), BaseChatItemLayout.o);
    if (paramHolder.c != null) {
      paramHolder.c.setVisibility(8);
    }
    paramHolder.v.setAnimating(true);
    Object localObject4 = "";
    Object localObject3 = "";
    localObject1 = null;
    paramInt = 0;
    i = 0;
    int j = paramInt;
    if (paramMessageForPtt.sttAbility == 1)
    {
      j = paramInt;
      if (((ISttManagerService)this.d.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt)) {
        j = 4;
      }
    }
    if (j != 1)
    {
      if (j != 4)
      {
        paramHolder.j.setFailedIconVisable(false, null);
        if (paramHolder.j.ah != null) {
          paramHolder.j.ah.setBackgroundDrawable(null);
        }
      }
      else
      {
        paramHolder.j.setFailedIconResource(2130839590, null);
        paramHolder.j.ah.setBackgroundDrawable(null);
        ((Animatable)paramHolder.j.ah.getDrawable()).start();
      }
    }
    else
    {
      paramHolder.j.setFailedIconVisable(true, this);
      paramHolder.j.ah.setBackgroundDrawable(null);
      localObject5 = paramHolder.j.ah;
      if (paramMessageForPtt.isSendFromLocal()) {
        paramInt = 2131901335;
      } else {
        paramInt = 2131901332;
      }
      ((ImageView)localObject5).setContentDescription(HardCodeUtil.a(paramInt));
    }
    if (bool3)
    {
      paramMessageForPtt = (IQWalletConfigService)this.d.getRuntimeService(IQWalletConfigService.class, (String)localObject4);
      if (paramMessageForPtt != null) {
        paramMessageForPtt = paramMessageForPtt.getString("voice_pwd", HardCodeUtil.a(2131901336), new String[] { "lowTipStr" });
      } else {
        paramMessageForPtt = HardCodeUtil.a(2131901336);
      }
      paramHolder.j.setTailMessage(true, paramMessageForPtt, null);
    }
    if (AppSetting.e)
    {
      paramMessageForPtt = HardCodeUtil.a(2131901338);
      if (i != 0)
      {
        localObject4 = paramHolder.B;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(paramMessageForPtt);
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append(HardCodeUtil.a(2131901340));
        ((StringBuilder)localObject5).append(HardCodeUtil.a(2131901339));
        ((RelativeLayout)localObject4).setContentDescription(((StringBuilder)localObject5).toString());
      }
      else
      {
        localObject4 = paramHolder.B;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(paramMessageForPtt);
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append(HardCodeUtil.a(2131901337));
        ((RelativeLayout)localObject4).setContentDescription(((StringBuilder)localObject5).toString());
      }
      if (paramHolder.a != null)
      {
        paramMessageForPtt = paramHolder.a;
        paramMessageForPtt.append("发送了语音.");
        paramMessageForPtt.append((String)localObject3);
        if (localObject1 != null)
        {
          paramHolder = paramHolder.a;
          paramHolder.append(" ");
          paramHolder.append((String)localObject1);
        }
      }
    }
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
  
  public void onClick(View paramView)
  {
    AIOUtils.q = true;
    int i = paramView.getId();
    if ((AppSetting.e) && (i == 2131429332))
    {
      paramView.findViewById(2131442193).performClick();
    }
    else
    {
      Object localObject2 = (PttItemBuilder.Holder)AIOUtils.b(paramView);
      if (localObject2 != null)
      {
        Object localObject1 = (MessageForPtt)((PttItemBuilder.Holder)localObject2).q;
        Object localObject3;
        if (i == 2131442193)
        {
          if (f((ChatMessage)localObject1)) {
            MediaPlayerManager.a(this.d).a(false);
          } else if ((localObject1 != MediaPlayerManager.a(this.d).f()) && (((MessageForPtt)localObject1).isReady())) {
            if (this.d.isVideoChatting()) {
              QQToast.makeText(this.e, 1, 2131892896, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
            } else if (!MediaPlayerManager.a(this.d).a(AIOUtils.a(paramView))) {
              QQToast.makeText(this.e, 1, 2131892895, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
            }
          }
          if (((MessageForPtt)localObject1).istroop == 1008) {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.d, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject1).timeStr, "", false);
          }
          if (((MessageForPtt)localObject1).voiceChangeFlag == 1)
          {
            localObject2 = this.d;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(((MessageForPtt)localObject1).istroop);
            ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, ((StringBuilder)localObject3).toString(), "", "", "");
          }
        }
        else if (i == 2131442212)
        {
          if (((MessageForPtt)localObject1).expandStt)
          {
            ((MessageForPtt)localObject1).expandStt = false;
            ((MessageForPtt)localObject1).serial();
            this.d.getMessageFacade().a(this.f.b, this.f.a, ((MessageForPtt)localObject1).uniseq, ((MessageForPtt)localObject1).msgData);
            a((PttItemBuilder.Holder)localObject2, (MessageForPtt)localObject1, a(this.d, (MessageForPtt)localObject1), f((ChatMessage)localObject1));
            ReportController.b(this.d, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
          }
        }
        else if (i == 2131430608)
        {
          localObject2 = this.d.getCurrentAccountUin();
          localObject3 = HttpUtil.getNetWorkTypeByStr();
          if (VasUtil.b(this.d).getVipStatus().isSVip()) {
            localObject1 = "svip";
          } else {
            localObject1 = "vip";
          }
          VasWebviewUtil.a((String)localObject2, "LongVoice", "TailClick", "0", 1, 0, 0, (String)localObject3, "", (String)localObject1);
          localObject1 = new Intent(this.e, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("uin", this.d.getCurrentAccountUin());
          ((Intent)localObject1).putExtra("url", "https://m.vip.qq.com/freedom/xhycyy.html?_nav_alpha=0");
          this.e.startActivity((Intent)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevicePttItemBuilder
 * JD-Core Version:    0.7.0.1
 */