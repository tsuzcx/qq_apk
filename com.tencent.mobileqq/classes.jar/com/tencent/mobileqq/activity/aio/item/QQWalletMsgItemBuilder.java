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
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.mobileqq.utils.QQTheme;
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
  public static Map<MessageForQQWalletMsg, Long> M = new HashMap();
  private static int N = 0;
  private static int O = 0;
  private static int P = 0;
  public static final String a = "QQWalletMsgItemBuilder";
  protected int A;
  protected int B;
  protected int C;
  protected int D;
  protected int E;
  protected int F;
  protected String G = "";
  BaseChatPie H = null;
  protected float I = 1.0F;
  IQQWalletHbItemApi J = (IQQWalletHbItemApi)QRoute.api(IQQWalletHbItemApi.class);
  int K;
  int L;
  private View.OnClickListener Q = new QQWalletMsgItemBuilder.2(this);
  protected final int w = 2131443089;
  protected int x;
  protected int y;
  protected int z;
  
  public QQWalletMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.G = paramContext.getString(2131914264);
    this.I = paramContext.getResources().getDisplayMetrics().density;
    float f = this.I;
    this.x = ((int)(42.0F * f + 0.5F));
    this.y = ((int)(10.0F * f + 0.5F));
    this.z = ((int)(9.0F * f + 0.5F));
    this.A = ((int)(6.5F * f + 0.5F));
    this.B = ((int)(4.0F * f + 0.5F));
    this.C = ((int)(1.0F * f + 0.5F));
    this.D = ((int)(7.0F * f + 0.5F));
    this.E = ((int)(173.0F * f + 0.5F));
    this.F = ((int)(f * 255.0F + 0.5F));
    int i = this.C;
    N = i * 2;
    O = i * 2;
    P = this.D;
    paramQQAppInterface = (BaseActivity)paramContext;
    if (paramQQAppInterface.getChatFragment() != null) {
      this.H = paramQQAppInterface.getChatFragment().k();
    }
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.y;
    localLayoutParams.bottomMargin = this.A;
    int i = this.x;
    int j = this.B;
    localLayoutParams.leftMargin = (i + j);
    localLayoutParams.rightMargin = (i + j);
    localLayoutParams.addRule(3, 2131430578);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130846198);
    i = this.z;
    paramContext.setPadding(i, this.B, i, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.B, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131443089);
    return paramContext;
  }
  
  private void a(QWalletMsgHolder paramQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    IFBaseViewHolder localIFBaseViewHolder = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).createViewHolder(this.d, this.f, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, 0, this);
    paramMessageForQQWalletMsg.specifyIcon = null;
    try
    {
      localIFBaseViewHolder.a();
      localIFBaseViewHolder.c();
      localIFBaseViewHolder.e();
      localIFBaseViewHolder.b();
      localIFBaseViewHolder.f();
      localIFBaseViewHolder.g();
      localIFBaseViewHolder.i();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "handleOldRedPacketLayout exception", localThrowable);
      }
    }
    paramQWalletMsgHolder.c().setOnClickListener(null);
    paramQWalletMsgHolder.b().setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramQWalletMsgHolder.b().setOnTouchListener(paramOnLongClickAndTouchListener);
    paramQWalletMsgHolder.b().setTag(paramMessageForQQWalletMsg);
    paramMessageForQQWalletMsg = this.J;
    paramQWalletMsgHolder = paramQWalletMsgHolder.b();
    paramOnLongClickAndTouchListener = new StringBuilder();
    paramOnLongClickAndTouchListener.append(paramQQWalletBaseMsgElem.c);
    paramOnLongClickAndTouchListener.append(this.G);
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
        String str = a;
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
      int i = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).getRedPkgType(paramMessageForQQWalletMsg.messageType);
      if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel == 1000004) {
        i = 16;
      }
      int j = i;
      if (i == 4)
      {
        j = i;
        if (paramQQWalletBaseMsgElem.v > 0) {
          j = 0;
        }
      }
      Object localObject = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).createViewHolder(this.d, this.f, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, j, this);
      try
      {
        ((IFBaseViewHolder)localObject).a();
        ((IFBaseViewHolder)localObject).c();
        ((IFBaseViewHolder)localObject).d();
        ((IFBaseViewHolder)localObject).e();
        ((IFBaseViewHolder)localObject).b();
        ((IFBaseViewHolder)localObject).f();
        ((IFBaseViewHolder)localObject).g();
        ((IFBaseViewHolder)localObject).h();
        ((IFBaseViewHolder)localObject).i();
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "handleRedPacketLayout exception", localThrowable);
        }
      }
      if (paramBoolean) {
        return;
      }
      this.K = paramQQWalletBaseMsgElem.v;
      this.L = paramMessageForQQWalletMsg.messageType;
      paramQWalletMsgHolder.c().setOnClickListener(this.Q);
      paramQWalletMsgHolder.d().setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramQWalletMsgHolder.d().setOnTouchListener(paramOnLongClickAndTouchListener);
      paramQWalletMsgHolder.d().setTag(paramMessageForQQWalletMsg);
      paramOnLongClickAndTouchListener = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).createBaseChatPie(this.H);
      this.J.setHbOnClickListener(this.d, paramOnLongClickAndTouchListener, paramQWalletMsgHolder.d(), this.f, j, paramQQWalletBaseMsgElem.v, this.G);
      if (j == 1)
      {
        paramQWalletMsgHolder = paramQWalletMsgHolder.b();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908782));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908787));
        paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (j == 2)
      {
        paramQWalletMsgHolder = paramQWalletMsgHolder.b();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908789));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908777));
        paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (j == 8)
      {
        paramQWalletMsgHolder = paramQWalletMsgHolder.b();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append("K歌红包:");
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908796));
        paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (j == 9)
      {
        paramQWalletMsgHolder = paramQWalletMsgHolder.b();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908779));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908788));
        paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (j == 10)
      {
        paramQWalletMsgHolder = paramQWalletMsgHolder.b();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908795));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908798));
        paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      if (j == 11)
      {
        paramQWalletMsgHolder = paramQWalletMsgHolder.b();
        paramQQWalletBaseMsgElem = new StringBuilder();
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908785));
        paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
        paramQQWalletBaseMsgElem.append(HardCodeUtil.a(2131908784));
        paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
        return;
      }
      paramQWalletMsgHolder = paramQWalletMsgHolder.b();
      paramQQWalletBaseMsgElem = new StringBuilder();
      paramQQWalletBaseMsgElem.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
      paramQQWalletBaseMsgElem.append(this.G);
      paramQWalletMsgHolder.setContentDescription(paramQQWalletBaseMsgElem.toString());
    }
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
      if ((localQWalletMsgHolder.b() == null) || ((localQWalletMsgHolder.b() != null) && (localQWalletMsgHolder.m() != paramChatMessage.uniseq)))
      {
        IQQWalletHbItemApi localIQQWalletHbItemApi = this.J;
        Context localContext = this.e;
        int i;
        if (this.f == null) {
          i = 0;
        } else {
          i = this.f.a;
        }
        localQWalletMsgHolder.a(localIQQWalletHbItemApi.createRedPacketBubbleView(localQWalletMsgHolder, localContext, i));
        paramBaseChatItemLayout.addView(a(this.e));
      }
      localQWalletMsgHolder.a(paramChatMessage.uniseq);
      if (paramViewHolder.mQQWalletRedPacketMsg != null)
      {
        paramChatMessage = paramViewHolder.mQQWalletRedPacketMsg.elem;
        if (paramChatMessage == null) {
          return localQWalletMsgHolder.b();
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
            return localQWalletMsgHolder.b();
          }
          a(localQWalletMsgHolder, paramChatMessage, paramViewHolder, paramOnLongClickAndTouchListener);
        }
      }
      paramViewHolder = (TextView)paramBaseChatItemLayout.findViewById(2131443089);
      if (paramViewHolder != null) {
        if ((paramChatMessage != null) && (!TextUtils.isEmpty(paramChatMessage.g)))
        {
          paramViewHolder.setText(paramChatMessage.g);
          paramViewHolder.setVisibility(0);
        }
        else
        {
          paramViewHolder.setVisibility(8);
        }
      }
      return localQWalletMsgHolder.b();
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new QWalletMsgHolder();
  }
  
  protected void a(int paramInt)
  {
    ThreadManager.post(new QQWalletMsgItemBuilder.1(this, paramInt), 8, null, true);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.e, this.d, paramChatMessage);
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
              a(paramRedPacketInfo.a);
            }
            if ((paramRedPacketInfo.skinType == 3) && (paramRedPacketInfo.specailBackgroundAnimInfo != null)) {
              a(paramRedPacketInfo.a);
            }
          }
          else if (paramRedPacketInfo.animInfo != null)
          {
            a(paramRedPacketInfo.a);
          }
        }
        else if ((paramRedPacketInfo.a()) || (paramRedPacketInfo.e != null)) {
          a(paramRedPacketInfo.a);
        }
      }
      else if (paramRedPacketInfo.background != null) {
        a(paramRedPacketInfo.a);
      }
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i;
    if (QQTheme.isNowSimpleUI()) {
      i = BaseChatItemLayout.getBubblePaddingAlignError();
    } else {
      i = O;
    }
    int j;
    if (QQTheme.isNowSimpleUI()) {
      j = BaseChatItemLayout.getBubblePaddingAlignHead();
    } else {
      j = N;
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(i, P, j, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      int k = paramView.getResources().getDimensionPixelSize(2131296613);
      paramView.setPadding(j, P, i, k);
      return;
    }
    paramView.setPadding(j, P, i, 0);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
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
        if (paramChatMessage.d() != null) {
          paramView = paramChatMessage.d().getTag();
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
    paramContext = paramBaseChatItemLayout.findViewById(2131443002);
    if (paramChatMessage.l() != null)
    {
      paramInt2 = paramChatMessage.h.getPaddingLeft();
      int i = paramChatMessage.h.getPaddingRight();
      int j = paramChatMessage.h.getPaddingTop();
      int k = paramChatMessage.h.getPaddingBottom();
      if (QQTheme.isNowSimpleUI()) {
        paramInt1 = 0;
      } else {
        paramInt1 = this.A;
      }
      paramChatMessage.h.setPadding(paramInt2 + paramInt1, j, i + paramInt1, k);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.E, this.F);
      paramBaseChatItemLayout.addRule(5, 2131430578);
      paramBaseChatItemLayout.addRule(6, 2131430578);
      paramBaseChatItemLayout.leftMargin = paramInt2;
      paramBaseChatItemLayout.topMargin = (-this.C);
      if (paramContext != null)
      {
        paramChatMessage.j.removeView(paramContext);
        paramChatMessage.j.addView(paramChatMessage.l(), paramBaseChatItemLayout);
        return;
      }
      paramChatMessage.j.addView(paramChatMessage.l(), paramBaseChatItemLayout);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.d != null))
    {
      MqqHandler localMqqHandler = this.d.getHandler(ChatActivity.class);
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
    a(localQQCustomMenu, this.e, 2131444634, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    a(localQQCustomMenu, this.e, 2131444651, paramView, null);
    super.a(localQQCustomMenu, this.e, 2131439015, null, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public void b()
  {
    super.b();
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().b();
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).voiceRecognizerDestroy();
    M.clear();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
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
        if (MessageRecordInfo.b(paramChatMessage.issend)) {
          ((StringBuilder)localObject).append("发出");
        } else {
          ((StringBuilder)localObject).append("发来");
        }
        ((StringBuilder)localObject).append(localQQWalletBaseMsgElem.e);
        ((StringBuilder)localObject).append(localQQWalletBaseMsgElem.c);
        ((StringBuilder)localObject).append("按钮");
        return ((StringBuilder)localObject).toString();
      }
      return paramChatMessage.msg;
    }
    return paramChatMessage.msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */