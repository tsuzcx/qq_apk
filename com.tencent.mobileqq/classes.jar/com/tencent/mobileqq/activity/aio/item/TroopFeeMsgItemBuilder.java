package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextPaint;
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
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import vjk;
import vjl;

public class TroopFeeMsgItemBuilder
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  protected final int b = 2131362100;
  protected final int c = 2131362101;
  protected final int d = 2131362102;
  protected final int e = 2131362103;
  protected final int f = 2131362104;
  protected final int g = 2131362105;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  protected int u;
  protected int v;
  protected int w;
  
  public TroopFeeMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vjk(this);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.i = ((int)(42.0F * f1 + 0.5F));
    this.j = ((int)(21.0F * f1 + 0.5F));
    this.k = ((int)(15.0F * f1 + 0.5F));
    this.l = ((int)(10.0F * f1 + 0.5F));
    this.m = ((int)(9.0F * f1 + 0.5F));
    this.n = ((int)(6.0F * f1 + 0.5F));
    this.o = ((int)(4.0F * f1 + 0.5F));
    this.p = ((int)(1.0F * f1 + 0.5F));
    this.h = (this.l * 23);
    this.q = ((int)(157.0F * f1 + 0.5F));
    this.r = ((int)(65.0F * f1 + 0.5F));
    this.s = ((int)(7.0F * f1 + 0.5F));
    this.t = ((int)(152.0F * f1 + 0.5F));
    this.u = ((int)(5.0F * f1 + 0.5F));
    this.v = ((int)(61.0F * f1 + 0.5F));
    this.w = ((int)(f1 * 19.0F + 0.5F));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (vjl)paramViewHolder;
    paramBaseChatItemLayout = (MessageForTroopFee)paramChatMessage;
    if ((paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramViewHolder.jdField_a_of_type_Long == paramChatMessage.uniseq)) {
      return paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    QQWalletTransferBubbleView localQQWalletTransferBubbleView;
    float f1;
    label210:
    int i1;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
      paramViewHolder.b = paramChatMessage.frienduin;
      paramViewHolder.jdField_a_of_type_Long = paramChatMessage.uniseq;
      paramView = (TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362102);
      TextView localTextView1 = (TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362103);
      ImageView localImageView = (ImageView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362101);
      TextView localTextView2 = (TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362105);
      localQQWalletTransferBubbleView = (QQWalletTransferBubbleView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362100);
      if (paramBaseChatItemLayout.title != null)
      {
        paramView.setTextSize(24.0F);
        TextPaint localTextPaint = paramView.getPaint();
        if (localTextPaint != null)
        {
          f1 = localTextPaint.measureText(paramBaseChatItemLayout.title);
          if (this.h <= BaseChatItemLayout.d) {
            break label378;
          }
          if (f1 > BaseChatItemLayout.d - this.l * 9) {
            paramView.setTextSize(14.0F);
          }
        }
      }
      paramView.setText(paramBaseChatItemLayout.title);
      paramView.setTextColor(-1);
      localTextView1.setText(paramBaseChatItemLayout.summary);
      localTextView1.setTextColor(-1);
      localTextView2.setText(paramBaseChatItemLayout.source);
      localImageView.setImageResource(2130844053);
      i1 = Color.parseColor(paramBaseChatItemLayout.backgroundColor);
      if (paramChatMessage.isSend()) {
        break label401;
      }
    }
    label401:
    for (boolean bool = true;; bool = false)
    {
      localQQWalletTransferBubbleView.setBubbleBackground(2130844051, i1, bool);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramBaseChatItemLayout.title + paramBaseChatItemLayout.summary + paramBaseChatItemLayout.source);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
      return paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = a(this.jdField_a_of_type_AndroidContentContext);
      break;
      label378:
      if (f1 <= this.l * 14) {
        break label210;
      }
      paramView.setTextSize(14.0F);
      break label210;
    }
  }
  
  protected RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    Object localObject1 = new QQWalletTransferBubbleView(paramContext);
    ((QQWalletTransferBubbleView)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.h, this.k * 5));
    ((QQWalletTransferBubbleView)localObject1).setId(2131362100);
    Object localObject2 = new ImageView(paramContext);
    Object localObject3 = new RelativeLayout.LayoutParams(this.i, this.i);
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.j;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject2).setId(2131362101);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localObject2 = new LinearLayout(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131362101);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = this.j;
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.n;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextSize(24.0F);
    ((TextView)localObject3).setId(2131362102);
    ((LinearLayout)localObject2).addView((View)localObject3);
    localObject3 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.p;
    ((TextView)localObject3).setLayoutParams(localLayoutParams);
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextSize(13.0F);
    ((TextView)localObject3).setId(2131362103);
    ((LinearLayout)localObject2).addView((View)localObject3);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localObject1 = new RelativeLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(this.h, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131362100);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).setBackgroundResource(2130844052);
    ((RelativeLayout)localObject1).setId(2131362104);
    paramContext = new TextView(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.j;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.j;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131362105);
    ((RelativeLayout)localObject1).addView(paramContext);
    localRelativeLayout.addView((View)localObject1);
    return localRelativeLayout;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new vjl(this, null);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopFee)paramChatMessage;
    return paramChatMessage.title + paramChatMessage.summary + paramChatMessage.source;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131375567: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.c(paramChatMessage);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    a(AIOUtils.a(paramView), localQQCustomMenu);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFeeMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */