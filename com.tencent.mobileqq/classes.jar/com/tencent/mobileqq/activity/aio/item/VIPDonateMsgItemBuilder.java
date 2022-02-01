package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.mobileqq.qwallet.widget.QQWalletTransferBubbleView;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;

public class VIPDonateMsgItemBuilder
  extends BaseBubbleBuilder
{
  private static int a;
  private static int w;
  private static int x;
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private Context F;
  private View.OnClickListener G = new VIPDonateMsgItemBuilder.1(this);
  private int y;
  private int z;
  
  public VIPDonateMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.F = paramContext;
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.y = ((int)(1.0F * f + 0.5F));
    this.z = ((int)(6.0F * f + 0.5F));
    this.A = ((int)(7.0F * f + 0.5F));
    this.C = ((int)(15.0F * f + 0.5F));
    this.E = ((int)(21.0F * f + 0.5F));
    this.D = ((int)(42.0F * f + 0.5F));
    this.B = ((int)(f * 230.0F + 0.5F));
    int i = this.y;
    a = i * 2;
    w = i * 2;
    x = this.A;
  }
  
  private RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localQQWalletTransferBubbleView.setLayoutParams(new RelativeLayout.LayoutParams(this.B, this.C * 5));
    localQQWalletTransferBubbleView.setId(2131449922);
    Object localObject1 = new ImageView(paramContext);
    int i = this.D;
    Object localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.E;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject1).setId(2131449918);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localObject1 = new LinearLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131449918);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.E;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.z;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((LinearLayout)localObject1).setOrientation(1);
    localObject2 = new TextView(paramContext);
    ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(20.0F);
    ((TextView)localObject2).setId(2131449921);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject2 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.y;
    ((TextView)localObject2).setLayoutParams(localLayoutParams);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(14.0F);
    ((TextView)localObject2).setId(2131449920);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(this.B, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131449922);
    localQQWalletTransferBubbleView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localQQWalletTransferBubbleView.setBackgroundResource(2130849134);
    localQQWalletTransferBubbleView.setId(2131449917);
    paramContext = new TextView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    i = this.E;
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = i;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = i;
    i = this.C;
    ((RelativeLayout.LayoutParams)localObject1).topMargin = i;
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = i;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131449919);
    localQQWalletTransferBubbleView.addView(paramContext);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    return localRelativeLayout;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = (VIPDonateMsgItemBuilder.VIPDonateMsgHolder)paramViewHolder;
    if (paramView.a == null) {
      paramView.a = a(this.F);
    }
    if ((paramChatMessage instanceof MessageForVIPDonate)) {
      paramViewHolder = (MessageForVIPDonate)paramChatMessage;
    } else {
      paramViewHolder = null;
    }
    if (paramViewHolder == null)
    {
      QLog.e("VIPDonateMsgItemBuilder", 1, "vipdonate msg empty");
      return null;
    }
    paramViewHolder.parse();
    paramViewHolder = paramViewHolder.donateMsg;
    if (paramViewHolder == null)
    {
      QLog.e("VIPDonateMsgItemBuilder", 1, "donateMsg empty");
      return null;
    }
    paramBaseChatItemLayout = (TextView)paramView.a.findViewById(2131449921);
    paramBaseChatItemLayout.setText(paramViewHolder.title);
    paramBaseChatItemLayout.setTextColor(-1);
    paramBaseChatItemLayout = (TextView)paramView.a.findViewById(2131449920);
    paramBaseChatItemLayout.setText(paramViewHolder.subTitle);
    paramBaseChatItemLayout.setTextColor(-1);
    ((TextView)paramView.a.findViewById(2131449919)).setText(paramViewHolder.footer);
    ((ImageView)paramView.a.findViewById(2131449918)).setImageResource(2130853477);
    paramBaseChatItemLayout = (QQWalletTransferBubbleView)paramView.a.findViewById(2131449917);
    ((QQWalletTransferBubbleView)paramView.a.findViewById(2131449922)).setBubbleBackground(2130849133, Color.rgb(255, 170, 57), paramChatMessage.isSend() ^ true);
    paramBaseChatItemLayout.setBubbleBackground(2130849134, Color.rgb(255, 255, 255), paramChatMessage.isSend() ^ true);
    if (v)
    {
      paramChatMessage = paramView.a;
      paramBaseChatItemLayout = new StringBuilder();
      paramBaseChatItemLayout.append(paramViewHolder.subTitle);
      paramBaseChatItemLayout.append(paramViewHolder.title);
      paramChatMessage.setContentDescription(paramBaseChatItemLayout.toString());
    }
    paramView.a.setOnClickListener(this.G);
    paramView.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramView.a.setOnTouchListener(paramOnLongClickAndTouchListener);
    return paramView.a;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new VIPDonateMsgItemBuilder.VIPDonateMsgHolder(this, null);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.F, this.d, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(w, x, a, 0);
      return;
    }
    paramView.setPadding(a, x, w, 0);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.F, 2131444634, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.F, this.f.a);
    a(localQQCustomMenu, this.F, 2131444651, paramView, null);
    super.a(localQQCustomMenu, this.F, 2131439015, null, null);
    super.a(localQQCustomMenu, this.F, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.VIPDonateMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */