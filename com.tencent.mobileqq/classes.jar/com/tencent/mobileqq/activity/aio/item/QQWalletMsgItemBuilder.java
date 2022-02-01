package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.qwallet.BaseViewHolder;
import com.tencent.mobileqq.activity.aio.qwallet.IFBaseViewHolder;
import com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils;
import com.tencent.mobileqq.activity.aio.qwallet.QWalletMsgHolder;
import com.tencent.mobileqq.activity.aio.qwallet.SpecifyRedPkgViewHolder;
import com.tencent.mobileqq.activity.aio.qwallet.ViewHolderFactory;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRecognizer;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class QQWalletMsgItemBuilder
  extends BaseBubbleBuilder
  implements CustomizeStrategyFactory.OnCustomizeListener
{
  public static final String a;
  public static Map<MessageForQQWalletMsg, Long> a;
  private static int o;
  private static int p;
  private static int q;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new QQWalletMsgItemBuilder.2(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
  QQWalletHbItemUtils jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils;
  private IndividualRedPacketManager jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager;
  protected float b;
  protected String b;
  protected final int c = 2131375395;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  int m;
  int n;
  
  static
  {
    jdField_a_of_type_JavaLangString = QQWalletMsgItemBuilder.class.getSimpleName();
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public QQWalletMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils = new QQWalletHbItemUtils(paramContext);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131717133);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.d = ((int)(42.0F * this.jdField_b_of_type_Float + 0.5F));
    this.e = ((int)(10.0F * this.jdField_b_of_type_Float + 0.5F));
    this.f = ((int)(9.0F * this.jdField_b_of_type_Float + 0.5F));
    this.g = ((int)(6.5F * this.jdField_b_of_type_Float + 0.5F));
    this.h = ((int)(4.0F * this.jdField_b_of_type_Float + 0.5F));
    this.i = ((int)(this.jdField_b_of_type_Float * 1.0F + 0.5F));
    this.j = ((int)(7.0F * this.jdField_b_of_type_Float + 0.5F));
    this.k = ((int)(173.0F * this.jdField_b_of_type_Float + 0.5F));
    this.l = ((int)(255.0F * this.jdField_b_of_type_Float + 0.5F));
    o = this.i * 2;
    p = this.i * 2;
    q = this.j;
    paramBaseAdapter = (FragmentActivity)paramContext;
    if (paramBaseAdapter.getChatFragment() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseAdapter.getChatFragment().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager = ((IndividualRedPacketManager)paramQQAppInterface.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER));
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.e;
    localLayoutParams.bottomMargin = this.g;
    localLayoutParams.leftMargin = (this.d + this.h);
    localLayoutParams.rightMargin = (this.d + this.h);
    localLayoutParams.addRule(3, 2131364634);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130844888);
    paramContext.setPadding(this.f, this.h, this.f, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.h, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131375395);
    return paramContext;
  }
  
  private void a(QWalletMsgHolder paramQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    BaseViewHolder localBaseViewHolder = new BaseViewHolder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, 0, this);
    paramMessageForQQWalletMsg.specifyIcon = null;
    try
    {
      localBaseViewHolder.a();
      localBaseViewHolder.e();
      localBaseViewHolder.f();
      localBaseViewHolder.b();
      localBaseViewHolder.g();
      localBaseViewHolder.b();
      localBaseViewHolder.h();
      paramQWalletMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramMessageForQQWalletMsg);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.a(paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, paramQQWalletBaseMsgElem.title + this.jdField_b_of_type_JavaLangString);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleOldRedPacketLayout exception", localThrowable);
        }
      }
    }
  }
  
  private void a(QWalletMsgHolder paramQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, boolean paramBoolean)
  {
    if ((paramQQWalletBaseMsgElem == null) || (paramMessageForQQWalletMsg == null)) {}
    for (;;)
    {
      return;
      Object localObject;
      int i1;
      if (QLog.isColorLevel())
      {
        if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
        {
          localObject = ",QQWalletAioBodyReserve=" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body;
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleRedPacketLayout holder=" + paramQWalletMsgHolder + ",elem=" + paramQQWalletBaseMsgElem + ",qqWalletMsg=" + paramMessageForQQWalletMsg + (String)localObject + ",fromItemRefresh=" + paramBoolean);
        }
      }
      else
      {
        int i2 = ViewHolderFactory.a(paramMessageForQQWalletMsg.messageType);
        i1 = i2;
        if (i2 == 4)
        {
          i1 = i2;
          if (paramQQWalletBaseMsgElem.skinId > 0) {
            i1 = 0;
          }
        }
        localObject = ViewHolderFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, i1, this);
        if ((localObject instanceof SpecifyRedPkgViewHolder)) {
          ((SpecifyRedPkgViewHolder)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
        }
      }
      try
      {
        ((IFBaseViewHolder)localObject).a();
        ((IFBaseViewHolder)localObject).e();
        ((IFBaseViewHolder)localObject).f();
        ((IFBaseViewHolder)localObject).b();
        ((IFBaseViewHolder)localObject).g();
        ((IFBaseViewHolder)localObject).b();
        ((IFBaseViewHolder)localObject).c();
        ((IFBaseViewHolder)localObject).h();
        if (!paramBoolean)
        {
          this.m = paramQQWalletBaseMsgElem.skinId;
          this.n = paramMessageForQQWalletMsg.messageType;
          paramQWalletMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramQWalletMsgHolder.c.setOnLongClickListener(paramOnLongClickAndTouchListener);
          paramQWalletMsgHolder.c.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramQWalletMsgHolder.c.setTag(paramMessageForQQWalletMsg);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramQWalletMsgHolder.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1, paramQQWalletBaseMsgElem.skinId, this.jdField_b_of_type_JavaLangString);
          if (i1 == 1)
          {
            paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131711142) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + HardCodeUtil.a(2131711147));
            return;
            localObject = "";
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "handleRedPacketLayout exception", localThrowable);
          }
        }
        if (i1 == 2)
        {
          paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131711149) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + HardCodeUtil.a(2131711137));
          return;
        }
        if (i1 == 8)
        {
          paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("K歌红包:" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + HardCodeUtil.a(2131711156));
          return;
        }
        if (i1 == 9)
        {
          paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131711139) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + HardCodeUtil.a(2131711148));
          return;
        }
        if (i1 == 10)
        {
          paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131711155) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + HardCodeUtil.a(2131711158));
          return;
        }
        if (i1 == 11)
        {
          paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131711145) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + HardCodeUtil.a(2131711144));
          return;
        }
        paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = null;
    QWalletMsgHolder localQWalletMsgHolder = (QWalletMsgHolder)paramViewHolder;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (paramViewHolder = (MessageForQQWalletMsg)paramChatMessage;; paramViewHolder = null)
    {
      if ((paramViewHolder == null) || ((paramViewHolder.mQQWalletTransferMsg == null) && (paramViewHolder.mQQWalletRedPacketMsg == null))) {
        return null;
      }
      if (QWalletHelperImpl.graphbSpeedEnable) {
        a(paramViewHolder.istroop);
      }
      if ((localQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || ((localQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (localQWalletMsgHolder.jdField_a_of_type_Long != paramChatMessage.uniseq)))
      {
        localQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.a(localQWalletMsgHolder, this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
      }
      localQWalletMsgHolder.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (paramViewHolder.mQQWalletRedPacketMsg != null)
      {
        paramChatMessage = paramViewHolder.mQQWalletRedPacketMsg.elem;
        if (paramChatMessage == null) {
          return localQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
        a(localQWalletMsgHolder, paramChatMessage, paramViewHolder, paramOnLongClickAndTouchListener, false);
        paramViewHolder = (TextView)paramBaseChatItemLayout.findViewById(2131375395);
        if (paramViewHolder != null)
        {
          if ((paramChatMessage == null) || (TextUtils.isEmpty(paramChatMessage.blackStripe))) {
            break label247;
          }
          paramViewHolder.setText(paramChatMessage.blackStripe);
          paramViewHolder.setVisibility(0);
        }
      }
      for (;;)
      {
        return localQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
        paramChatMessage = paramView;
        if (paramViewHolder.mQQWalletTransferMsg == null) {
          break;
        }
        paramChatMessage = paramViewHolder.mQQWalletTransferMsg.elem;
        if (paramChatMessage == null) {
          return localQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
        a(localQWalletMsgHolder, paramChatMessage, paramViewHolder, paramOnLongClickAndTouchListener);
        break;
        label247:
        paramViewHolder.setVisibility(8);
      }
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new QWalletMsgHolder();
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (Object localObject = (MessageForQQWalletMsg)paramChatMessage;; localObject = null)
    {
      if ((localObject == null) || ((((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg == null) && (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg == null))) {
        return paramChatMessage.msg;
      }
      if (((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg != null) {
        localObject = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg.elem;
      }
      for (;;)
      {
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          if (MessageRecordInfo.a(paramChatMessage.issend)) {
            localStringBuilder.append("发出");
          }
          for (;;)
          {
            localStringBuilder.append(((QQWalletBaseMsgElem)localObject).content).append(((QQWalletBaseMsgElem)localObject).title).append("按钮");
            return localStringBuilder.toString();
            if (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg == null) {
              break label141;
            }
            localObject = ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem;
            break;
            localStringBuilder.append("发来");
          }
        }
        return paramChatMessage.msg;
        label141:
        localObject = null;
      }
    }
  }
  
  public void a()
  {
    super.a();
    CustomizeStrategyFactory.a().a();
    VoiceRecognizer.a().c();
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  protected void a(int paramInt)
  {
    ThreadManager.post(new QQWalletMsgItemBuilder.1(this, paramInt), 8, null, true);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(p, q, o, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramView.setPadding(o, q, p, paramView.getResources().getDimensionPixelSize(2131296402));
      return;
    }
    paramView.setPadding(o, q, p, 0);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateView type=" + paramInt + ",message=" + paramChatMessage);
    }
    if (paramInt == 888)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof QWalletMsgHolder))
      {
        paramChatMessage = (QWalletMsgHolder)paramView;
        if (paramChatMessage.c == null) {
          break label117;
        }
      }
      label117:
      for (paramView = paramChatMessage.c.getTag();; paramView = null)
      {
        if ((paramView instanceof MessageForQQWalletMsg))
        {
          paramView = (MessageForQQWalletMsg)paramView;
          if (paramView.mQQWalletRedPacketMsg != null) {
            a(paramChatMessage, paramView.mQQWalletRedPacketMsg.elem, paramView, null, true);
          }
        }
        return;
      }
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramChatMessage = (QWalletMsgHolder)paramViewHolder;
    paramContext = paramBaseChatItemLayout.findViewById(2131375298);
    if (paramChatMessage.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView != null)
    {
      paramInt1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingLeft();
      paramInt2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingRight();
      int i1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingTop();
      int i2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingBottom();
      paramChatMessage.jdField_a_of_type_AndroidViewView.setPadding(this.g + paramInt1, i1, paramInt2 + this.g, i2);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.k, this.l);
      paramBaseChatItemLayout.addRule(5, 2131364634);
      paramBaseChatItemLayout.addRule(6, 2131364634);
      paramBaseChatItemLayout.leftMargin = paramInt1;
      paramBaseChatItemLayout.topMargin = (-this.i);
      if (paramContext != null)
      {
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.removeView(paramContext);
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView, paramBaseChatItemLayout);
      }
    }
    else
    {
      return;
    }
    paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView, paramBaseChatItemLayout);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        Message localMessage = new Message();
        localMessage.what = 78;
        localMessage.arg1 = 888;
        Bundle localBundle = new Bundle();
        localBundle.putLong("messageUniseq", paramMessageRecord.uniseq);
        localMessage.setData(localBundle);
        localMqqHandler.sendMessage(localMessage);
      }
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return localQQCustomMenu.a();
  }
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null) {
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramRedPacketInfo.skinType == 1) && ((paramRedPacketInfo.background != null) || (paramRedPacketInfo.animInfo != null))) {
              a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          } while ((paramRedPacketInfo.skinType != 3) || (paramRedPacketInfo.specailBackgroundAnimInfo == null));
          a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          return;
        } while (paramRedPacketInfo.animInfo == null);
        a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        return;
      } while (paramRedPacketInfo.background == null);
      a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      return;
    } while ((!paramRedPacketInfo.a()) && (paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap == null));
    a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */