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
import com.tencent.mobileqq.activity.BaseChatPie;
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
import com.tencent.mobileqq.activity.aio.qwallet.BaseViewHolder;
import com.tencent.mobileqq.activity.aio.qwallet.IFBaseViewHolder;
import com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils;
import com.tencent.mobileqq.activity.aio.qwallet.QWalletMsgHolder;
import com.tencent.mobileqq.activity.aio.qwallet.SpecifyRedPkgViewHolder;
import com.tencent.mobileqq.activity.aio.qwallet.ViewHolderFactory;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRecognizer;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import mqq.os.MqqHandler;
import viz;
import vja;

public class QQWalletMsgItemBuilder
  extends BaseBubbleBuilder
  implements CustomizeStrategyFactory.OnCustomizeListener
{
  public static final String a;
  private static int l;
  private static int m;
  private static int n;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new vja(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
  QQWalletHbItemUtils jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils;
  private IndividualRedPacketManager jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager;
  protected float b;
  protected final int b;
  protected String b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  
  static
  {
    jdField_a_of_type_JavaLangString = QQWalletMsgItemBuilder.class.getSimpleName();
  }
  
  public QQWalletMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Int = 2131372494;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils = new QQWalletHbItemUtils(paramContext);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131432233);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.c = ((int)(42.0F * this.jdField_b_of_type_Float + 0.5F));
    this.d = ((int)(10.0F * this.jdField_b_of_type_Float + 0.5F));
    this.e = ((int)(9.0F * this.jdField_b_of_type_Float + 0.5F));
    this.f = ((int)(6.5F * this.jdField_b_of_type_Float + 0.5F));
    this.g = ((int)(4.0F * this.jdField_b_of_type_Float + 0.5F));
    this.h = ((int)(this.jdField_b_of_type_Float * 1.0F + 0.5F));
    this.i = ((int)(7.0F * this.jdField_b_of_type_Float + 0.5F));
    this.j = ((int)(173.0F * this.jdField_b_of_type_Float + 0.5F));
    this.k = ((int)(255.0F * this.jdField_b_of_type_Float + 0.5F));
    l = this.h * 2;
    m = this.h * 2;
    n = this.i;
    paramBaseAdapter = (FragmentActivity)paramContext;
    if (paramBaseAdapter.getChatFragment() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseAdapter.getChatFragment().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager = ((IndividualRedPacketManager)paramQQAppInterface.getManager(130));
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.d;
    localLayoutParams.bottomMargin = this.f;
    localLayoutParams.leftMargin = (this.c + this.g);
    localLayoutParams.rightMargin = (this.c + this.g);
    localLayoutParams.addRule(3, 2131361877);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130842213);
    paramContext.setPadding(this.e, this.g, this.e, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.g, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131372494);
    return paramContext;
  }
  
  private void a(QWalletMsgHolder paramQWalletMsgHolder, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    BaseViewHolder localBaseViewHolder = new BaseViewHolder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, 0, this);
    paramMessageForQQWalletMsg.specifyIcon = null;
    try
    {
      localBaseViewHolder.a();
      localBaseViewHolder.d();
      localBaseViewHolder.e();
      localBaseViewHolder.b();
      localBaseViewHolder.f();
      localBaseViewHolder.b();
      localBaseViewHolder.g();
      paramQWalletMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramMessageForQQWalletMsg);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.a(paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, paramQQWalletTransferMsgElem.title + this.jdField_b_of_type_JavaLangString);
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
  
  private void a(QWalletMsgHolder paramQWalletMsgHolder, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, boolean paramBoolean)
  {
    if ((paramQQWalletTransferMsgElem == null) || (paramMessageForQQWalletMsg == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleRedPacketLayout holder=" + paramQWalletMsgHolder + ",elem=" + paramQQWalletTransferMsgElem + ",qqWalletMsg=" + paramMessageForQQWalletMsg + ",fromItemRefresh=" + paramBoolean);
      }
      int i2 = ViewHolderFactory.a(paramMessageForQQWalletMsg.messageType);
      int i1 = i2;
      if (i2 == 4)
      {
        i1 = i2;
        if (paramQQWalletTransferMsgElem.skinId > 0) {
          i1 = 0;
        }
      }
      IFBaseViewHolder localIFBaseViewHolder = ViewHolderFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, i1, this);
      if ((localIFBaseViewHolder instanceof SpecifyRedPkgViewHolder)) {
        ((SpecifyRedPkgViewHolder)localIFBaseViewHolder).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
      }
      try
      {
        localIFBaseViewHolder.a();
        localIFBaseViewHolder.d();
        localIFBaseViewHolder.e();
        localIFBaseViewHolder.b();
        localIFBaseViewHolder.f();
        localIFBaseViewHolder.b();
        localIFBaseViewHolder.g();
        if (!paramBoolean)
        {
          paramQWalletMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
          paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramMessageForQQWalletMsg);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQQWalletHbItemUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1, paramQQWalletTransferMsgElem.skinId, this.jdField_b_of_type_JavaLangString);
          if (i1 == 1)
          {
            paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("口令:" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ",点击领取口令");
            return;
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
          paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("语音口令:" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ",点击录制口令");
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
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = null;
    QWalletMsgHolder localQWalletMsgHolder = (QWalletMsgHolder)paramViewHolder;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (paramViewHolder = (MessageForQQWalletMsg)paramChatMessage;; paramViewHolder = null)
    {
      if ((paramViewHolder == null) || ((paramViewHolder.mQQWalletTransferMsg == null) && (paramViewHolder.mQQWalletRedPacketMsg == null))) {
        return null;
      }
      if (QWalletHelper.graphbSpeedEnable) {
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
        paramViewHolder = (TextView)paramBaseChatItemLayout.findViewById(2131372494);
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
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new QWalletMsgHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
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
          if (MsgUtils.a(paramChatMessage.issend)) {
            localStringBuilder.append("发出");
          }
          for (;;)
          {
            localStringBuilder.append(((QQWalletTransferMsgElem)localObject).content).append(((QQWalletTransferMsgElem)localObject).title).append("按钮");
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
  }
  
  protected void a(int paramInt)
  {
    ThreadManager.post(new viz(this, paramInt), 8, null, true);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131375633: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.c(paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(m, n, l, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramView.setPadding(l, n, m, paramView.getResources().getDimensionPixelSize(2131558600));
      return;
    }
    paramView.setPadding(l, n, m, 0);
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
        if (paramChatMessage.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
          break label117;
        }
      }
      label117:
      for (paramView = paramChatMessage.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag();; paramView = null)
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
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramChatMessage = (QWalletMsgHolder)paramViewHolder;
    paramContext = paramBaseChatItemLayout.findViewById(2131372483);
    if (paramChatMessage.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView != null)
    {
      paramInt1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingLeft();
      paramInt2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingRight();
      int i1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingTop();
      int i2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingBottom();
      paramChatMessage.jdField_a_of_type_AndroidViewView.setPadding(this.f + paramInt1, i1, paramInt2 + this.f, i2);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.j, this.k);
      paramBaseChatItemLayout.addRule(5, 2131361877);
      paramBaseChatItemLayout.addRule(6, 2131361877);
      paramBaseChatItemLayout.leftMargin = paramInt1;
      paramBaseChatItemLayout.topMargin = (-this.h);
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
    a(AIOUtils.a(paramView), localQQCustomMenu);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
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