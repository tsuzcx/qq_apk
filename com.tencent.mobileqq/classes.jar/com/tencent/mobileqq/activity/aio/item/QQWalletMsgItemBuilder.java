package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.qwallet.QWalletMsgHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.IQQWalletHbItemApi;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.IFBaseViewHolder;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.IViewHolderFactory;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class QQWalletMsgItemBuilder
  extends BaseBubbleBuilder
  implements ICustomizeStrategyFactory.OnCustomizeListener
{
  public static final String a = "QQWalletMsgItemBuilder";
  public static Map<MessageForQQWalletMsg, Long> a;
  private static int o;
  private static int p;
  private static int q;
  protected final int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new QQWalletMsgItemBuilder.2(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
  private IndividualRedPacketManager jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager;
  IQQWalletHbItemApi jdField_a_of_type_ComTencentMobileqqQwalletHbAioIQQWalletHbItemApi = (IQQWalletHbItemApi)QRoute.api(IQQWalletHbItemApi.class);
  protected float b;
  protected String b;
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
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public QQWalletMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Int = 2131374904;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131716792);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    float f1 = this.jdField_b_of_type_Float;
    this.d = ((int)(42.0F * f1 + 0.5F));
    this.e = ((int)(10.0F * f1 + 0.5F));
    this.f = ((int)(9.0F * f1 + 0.5F));
    this.g = ((int)(6.5F * f1 + 0.5F));
    this.h = ((int)(4.0F * f1 + 0.5F));
    this.i = ((int)(1.0F * f1 + 0.5F));
    this.j = ((int)(7.0F * f1 + 0.5F));
    this.k = ((int)(173.0F * f1 + 0.5F));
    this.l = ((int)(f1 * 255.0F + 0.5F));
    int i1 = this.i;
    o = i1 * 2;
    p = i1 * 2;
    q = this.j;
    paramBaseAdapter = (BaseActivity)paramContext;
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
    int i1 = this.d;
    int i2 = this.h;
    localLayoutParams.leftMargin = (i1 + i2);
    localLayoutParams.rightMargin = (i1 + i2);
    localLayoutParams.addRule(3, 2131364521);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130844764);
    i1 = this.f;
    paramContext.setPadding(i1, this.h, i1, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.h, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131374904);
    return paramContext;
  }
  
  private void a(QWalletMsgHolder paramQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    IFBaseViewHolder localIFBaseViewHolder = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).createViewHolder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, 0, this);
    paramMessageForQQWalletMsg.specifyIcon = null;
    try
    {
      localIFBaseViewHolder.a();
      localIFBaseViewHolder.c();
      localIFBaseViewHolder.e();
      localIFBaseViewHolder.b();
      localIFBaseViewHolder.f();
      localIFBaseViewHolder.a();
      localIFBaseViewHolder.h();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleOldRedPacketLayout exception", localThrowable);
      }
    }
    paramQWalletMsgHolder.a().setOnClickListener(null);
    paramQWalletMsgHolder.a().setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramQWalletMsgHolder.a().setOnTouchListener(paramOnLongClickAndTouchListener);
    paramQWalletMsgHolder.a().setTag(paramMessageForQQWalletMsg);
    paramMessageForQQWalletMsg = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioIQQWalletHbItemApi;
    paramQWalletMsgHolder = paramQWalletMsgHolder.a();
    paramOnLongClickAndTouchListener = new StringBuilder();
    paramOnLongClickAndTouchListener.append(paramQQWalletBaseMsgElem.jdField_a_of_type_JavaLangString);
    paramOnLongClickAndTouchListener.append(this.jdField_b_of_type_JavaLangString);
    paramMessageForQQWalletMsg.setOldHbOnClickListener(paramQWalletMsgHolder, paramOnLongClickAndTouchListener.toString());
  }
  
  private void a(QWalletMsgHolder paramQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, boolean paramBoolean)
  {
    if (paramQQWalletBaseMsgElem != null)
    {
      if (paramMessageForQQWalletMsg == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(",QQWalletAioBodyReserve=");
          ((StringBuilder)localObject).append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body);
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = "";
        }
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleRedPacketLayout holder=");
        localStringBuilder.append(paramQWalletMsgHolder);
        localStringBuilder.append(",elem=");
        localStringBuilder.append(paramQQWalletBaseMsgElem);
        localStringBuilder.append(",qqWalletMsg=");
        localStringBuilder.append(paramMessageForQQWalletMsg);
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",fromItemRefresh=");
        localStringBuilder.append(paramBoolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      int i2 = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).getRedPkgType(paramMessageForQQWalletMsg.messageType);
      int i1 = i2;
      if (i2 == 4)
      {
        i1 = i2;
        if (paramQQWalletBaseMsgElem.i > 0) {
          i1 = 0;
        }
      }
      Object localObject = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).createViewHolder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, i1, this);
      try
      {
        ((IFBaseViewHolder)localObject).a();
        ((IFBaseViewHolder)localObject).c();
        ((IFBaseViewHolder)localObject).d();
        ((IFBaseViewHolder)localObject).e();
        ((IFBaseViewHolder)localObject).b();
        ((IFBaseViewHolder)localObject).f();
        ((IFBaseViewHolder)localObject).a();
        ((IFBaseViewHolder)localObject).g();
        ((IFBaseViewHolder)localObject).h();
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleRedPacketLayout exception", localThrowable);
        }
      }
      if (paramBoolean) {
        return;
      }
      this.m = paramQQWalletBaseMsgElem.i;
      this.n = paramMessageForQQWalletMsg.messageType;
      paramQWalletMsgHolder.a().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramQWalletMsgHolder.b().setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramQWalletMsgHolder.b().setOnTouchListener(paramOnLongClickAndTouchListener);
      paramQWalletMsgHolder.b().setTag(paramMessageForQQWalletMsg);
      paramOnLongClickAndTouchListener = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).createBaseChatPie(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioIQQWalletHbItemApi.setHbOnClickListener(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramOnLongClickAndTouchListener, paramQWalletMsgHolder.b(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1, paramQQWalletBaseMsgElem.i, this.jdField_b_of_type_JavaLangString);
      if (i1 == 1)
      {
        paramQWalletMsgHolder = paramQWalletMsgHolder.a();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131711117));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131711122));
        paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (i1 == 2)
      {
        paramQWalletMsgHolder = paramQWalletMsgHolder.a();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131711124));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131711112));
        paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (i1 == 8)
      {
        paramQWalletMsgHolder = paramQWalletMsgHolder.a();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append("K歌红包:");
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131711131));
        paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (i1 == 9)
      {
        paramQWalletMsgHolder = paramQWalletMsgHolder.a();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131711114));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131711123));
        paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (i1 == 10)
      {
        paramQWalletMsgHolder = paramQWalletMsgHolder.a();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131711130));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131711133));
        paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (i1 == 11)
      {
        paramQWalletMsgHolder = paramQWalletMsgHolder.a();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131711120));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131711119));
        paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      paramQWalletMsgHolder = paramQWalletMsgHolder.a();
      paramQQWalletBaseMsgElem = new StringBuilder();
      paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
      paramQQWalletBaseMsgElem.append(this.jdField_b_of_type_JavaLangString);
      paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    QWalletMsgHolder localQWalletMsgHolder = (QWalletMsgHolder)paramViewHolder;
    boolean bool = paramChatMessage instanceof MessageForQQWalletMsg;
    paramView = null;
    if (bool) {
      paramViewHolder = (MessageForQQWalletMsg)paramChatMessage;
    } else {
      paramViewHolder = null;
    }
    if (paramViewHolder != null)
    {
      if ((paramViewHolder.mQQWalletTransferMsg == null) && (paramViewHolder.mQQWalletRedPacketMsg == null)) {
        return null;
      }
      if (QWalletHelperDelegate.graphbSpeedEnable) {
        a(paramViewHolder.istroop);
      }
      if ((localQWalletMsgHolder.a() == null) || ((localQWalletMsgHolder.a() != null) && (localQWalletMsgHolder.a() != paramChatMessage.uniseq)))
      {
        localQWalletMsgHolder.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioIQQWalletHbItemApi.createRedPacketBubbleView(localQWalletMsgHolder, this.jdField_a_of_type_AndroidContentContext));
        paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
      }
      localQWalletMsgHolder.a(paramChatMessage.uniseq);
      if (paramViewHolder.mQQWalletRedPacketMsg != null)
      {
        paramChatMessage = paramViewHolder.mQQWalletRedPacketMsg.elem;
        if (paramChatMessage == null) {
          return localQWalletMsgHolder.a();
        }
        a(localQWalletMsgHolder, paramChatMessage, paramViewHolder, paramOnLongClickAndTouchListener, false);
      }
      else
      {
        paramChatMessage = paramView;
        if (paramViewHolder.mQQWalletTransferMsg != null)
        {
          paramChatMessage = paramViewHolder.mQQWalletTransferMsg.elem;
          if (paramChatMessage == null) {
            return localQWalletMsgHolder.a();
          }
          a(localQWalletMsgHolder, paramChatMessage, paramViewHolder, paramOnLongClickAndTouchListener);
        }
      }
      paramViewHolder = (TextView)paramBaseChatItemLayout.findViewById(2131374904);
      if (paramViewHolder != null) {
        if ((paramChatMessage != null) && (!TextUtils.isEmpty(paramChatMessage.e)))
        {
          paramViewHolder.setText(paramChatMessage.e);
          paramViewHolder.setVisibility(0);
        }
        else
        {
          paramViewHolder.setVisibility(8);
        }
      }
      return localQWalletMsgHolder.a();
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new QWalletMsgHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    boolean bool = paramChatMessage instanceof MessageForQQWalletMsg;
    QQWalletBaseMsgElem localQQWalletBaseMsgElem = null;
    Object localObject;
    if (bool) {
      localObject = (MessageForQQWalletMsg)paramChatMessage;
    } else {
      localObject = null;
    }
    if ((localObject != null) && ((((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg != null) || (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg != null)))
    {
      if (((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg != null) {
        localQQWalletBaseMsgElem = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg.elem;
      } else if (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg != null) {
        localQQWalletBaseMsgElem = ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem;
      }
      if (localQQWalletBaseMsgElem != null)
      {
        localObject = new StringBuilder();
        if (MessageRecordInfo.a(paramChatMessage.issend)) {
          ((StringBuilder)localObject).append("发出");
        } else {
          ((StringBuilder)localObject).append("发来");
        }
        ((StringBuilder)localObject).append(localQQWalletBaseMsgElem.c);
        ((StringBuilder)localObject).append(localQQWalletBaseMsgElem.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("按钮");
        return ((StringBuilder)localObject).toString();
      }
      return paramChatMessage.msg;
    }
    return paramChatMessage.msg;
  }
  
  public void a()
  {
    super.a();
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a();
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).voiceRecognizerDestroy();
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  protected void a(int paramInt)
  {
    ThreadManager.post(new QQWalletMsgItemBuilder.1(this, paramInt), 8, null, true);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(int paramInt, RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            if ((paramRedPacketInfo.skinType == 1) && ((paramRedPacketInfo.background != null) || (paramRedPacketInfo.animInfo != null))) {
              a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
            if ((paramRedPacketInfo.skinType == 3) && (paramRedPacketInfo.specailBackgroundAnimInfo != null)) {
              a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          }
          else if (paramRedPacketInfo.animInfo != null)
          {
            a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          }
        }
        else if ((paramRedPacketInfo.a()) || (paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
          a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        }
      }
      else if (paramRedPacketInfo.background != null) {
        a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(p, q, o, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramView.setPadding(o, q, p, paramView.getResources().getDimensionPixelSize(2131296381));
      return;
    }
    paramView.setPadding(o, q, p, 0);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateView type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",message=");
      localStringBuilder.append(paramChatMessage);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt == 888)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof QWalletMsgHolder))
      {
        paramChatMessage = (QWalletMsgHolder)paramView;
        if (paramChatMessage.b() != null) {
          paramView = paramChatMessage.b().getTag();
        } else {
          paramView = null;
        }
        if ((paramView instanceof MessageForQQWalletMsg))
        {
          paramView = (MessageForQQWalletMsg)paramView;
          if (paramView.mQQWalletRedPacketMsg != null) {
            a(paramChatMessage, paramView.mQQWalletRedPacketMsg.elem, paramView, null, true);
          }
        }
      }
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramChatMessage = (QWalletMsgHolder)paramViewHolder;
    paramContext = paramBaseChatItemLayout.findViewById(2131374812);
    if (paramChatMessage.b() != null)
    {
      paramInt1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingLeft();
      paramInt2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingRight();
      int i1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingTop();
      int i2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingBottom();
      paramBaseChatItemLayout = paramChatMessage.jdField_a_of_type_AndroidViewView;
      int i3 = this.g;
      paramBaseChatItemLayout.setPadding(paramInt1 + i3, i1, paramInt2 + i3, i2);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.k, this.l);
      paramBaseChatItemLayout.addRule(5, 2131364521);
      paramBaseChatItemLayout.addRule(6, 2131364521);
      paramBaseChatItemLayout.leftMargin = paramInt1;
      paramBaseChatItemLayout.topMargin = (-this.i);
      if (paramContext != null)
      {
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.removeView(paramContext);
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage.b(), paramBaseChatItemLayout);
        return;
      }
      paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage.b(), paramBaseChatItemLayout);
    }
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
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */