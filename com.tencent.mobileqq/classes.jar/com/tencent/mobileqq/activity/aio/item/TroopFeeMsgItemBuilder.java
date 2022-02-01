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

public class TroopFeeMsgItemBuilder
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  protected final int c = 2131379879;
  protected final int d = 2131379875;
  protected final int e = 2131379878;
  protected final int f = 2131379877;
  protected final int g = 2131379874;
  protected final int h = 2131379876;
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
  protected int x;
  
  public TroopFeeMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TroopFeeMsgItemBuilder.1(this);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.j = ((int)(42.0F * f1 + 0.5F));
    this.k = ((int)(21.0F * f1 + 0.5F));
    this.l = ((int)(15.0F * f1 + 0.5F));
    this.m = ((int)(10.0F * f1 + 0.5F));
    this.n = ((int)(9.0F * f1 + 0.5F));
    this.o = ((int)(6.0F * f1 + 0.5F));
    this.p = ((int)(4.0F * f1 + 0.5F));
    this.q = ((int)(1.0F * f1 + 0.5F));
    this.i = (this.m * 23);
    this.r = ((int)(157.0F * f1 + 0.5F));
    this.s = ((int)(65.0F * f1 + 0.5F));
    this.t = ((int)(7.0F * f1 + 0.5F));
    this.u = ((int)(152.0F * f1 + 0.5F));
    this.v = ((int)(5.0F * f1 + 0.5F));
    this.w = ((int)(61.0F * f1 + 0.5F));
    this.x = ((int)(f1 * 19.0F + 0.5F));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (TroopFeeMsgItemBuilder.TroopFeeMsgHolder)paramViewHolder;
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
      paramView = (TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379878);
      TextView localTextView1 = (TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379877);
      ImageView localImageView = (ImageView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379875);
      TextView localTextView2 = (TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379876);
      localQQWalletTransferBubbleView = (QQWalletTransferBubbleView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379879);
      if (paramBaseChatItemLayout.title != null)
      {
        paramView.setTextSize(24.0F);
        TextPaint localTextPaint = paramView.getPaint();
        if (localTextPaint != null)
        {
          f1 = localTextPaint.measureText(paramBaseChatItemLayout.title);
          if (this.i <= BaseChatItemLayout.e) {
            break label378;
          }
          if (f1 > BaseChatItemLayout.e - this.m * 9) {
            paramView.setTextSize(14.0F);
          }
        }
      }
      paramView.setText(paramBaseChatItemLayout.title);
      paramView.setTextColor(-1);
      localTextView1.setText(paramBaseChatItemLayout.summary);
      localTextView1.setTextColor(-1);
      localTextView2.setText(paramBaseChatItemLayout.source);
      localImageView.setImageResource(2130847613);
      i1 = Color.parseColor(paramBaseChatItemLayout.backgroundColor);
      if (paramChatMessage.isSend()) {
        break label401;
      }
    }
    label401:
    for (boolean bool = true;; bool = false)
    {
      localQQWalletTransferBubbleView.setBubbleBackground(2130847611, i1, bool);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramBaseChatItemLayout.title + paramBaseChatItemLayout.summary + paramBaseChatItemLayout.source);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
      return paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = a(this.jdField_a_of_type_AndroidContentContext);
      break;
      label378:
      if (f1 <= this.m * 14) {
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
    ((QQWalletTransferBubbleView)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.i, this.l * 5));
    ((QQWalletTransferBubbleView)localObject1).setId(2131379879);
    Object localObject2 = new ImageView(paramContext);
    Object localObject3 = new RelativeLayout.LayoutParams(this.j, this.j);
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject2).setId(2131379875);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localObject2 = new LinearLayout(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131379875);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.o;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextSize(24.0F);
    ((TextView)localObject3).setId(2131379878);
    ((LinearLayout)localObject2).addView((View)localObject3);
    localObject3 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.q;
    ((TextView)localObject3).setLayoutParams(localLayoutParams);
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextSize(13.0F);
    ((TextView)localObject3).setId(2131379877);
    ((LinearLayout)localObject2).addView((View)localObject3);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localObject1 = new RelativeLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(this.i, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131379879);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).setBackgroundResource(2130847612);
    ((RelativeLayout)localObject1).setId(2131379874);
    paramContext = new TextView(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131379876);
    ((RelativeLayout)localObject1).addView(paramContext);
    localRelativeLayout.addView((View)localObject1);
    return localRelativeLayout;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopFeeMsgItemBuilder.TroopFeeMsgHolder(this, null);
  }
  
  public String a(ChatMessage paramChatMessage)
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
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFeeMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */