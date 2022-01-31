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
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import vql;
import vqm;

public class VIPDonateMsgItemBuilder
  extends BaseBubbleBuilder
{
  private static int jdField_b_of_type_Int;
  private static int c;
  private static int d;
  private View.OnClickListener a;
  private Context jdField_b_of_type_AndroidContentContext;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public VIPDonateMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vql(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.e = ((int)(1.0F * f1 + 0.5F));
    this.f = ((int)(6.0F * f1 + 0.5F));
    this.g = ((int)(7.0F * f1 + 0.5F));
    this.i = ((int)(15.0F * f1 + 0.5F));
    this.k = ((int)(21.0F * f1 + 0.5F));
    this.j = ((int)(42.0F * f1 + 0.5F));
    this.h = ((int)(f1 * 230.0F + 0.5F));
    jdField_b_of_type_Int = this.e * 2;
    c = this.e * 2;
    d = this.g;
  }
  
  private RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localQQWalletTransferBubbleView.setLayoutParams(new RelativeLayout.LayoutParams(this.h, this.i * 5));
    localQQWalletTransferBubbleView.setId(2131362208);
    Object localObject1 = new ImageView(paramContext);
    Object localObject2 = new RelativeLayout.LayoutParams(this.j, this.j);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject1).setId(2131362209);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localObject1 = new LinearLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131362209);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.f;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((LinearLayout)localObject1).setOrientation(1);
    localObject2 = new TextView(paramContext);
    ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(20.0F);
    ((TextView)localObject2).setId(2131362210);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject2 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.e;
    ((TextView)localObject2).setLayoutParams(localLayoutParams);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(14.0F);
    ((TextView)localObject2).setId(2131362211);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(this.h, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131362208);
    localQQWalletTransferBubbleView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localQQWalletTransferBubbleView.setBackgroundResource(2130844118);
    localQQWalletTransferBubbleView.setId(2131362212);
    paramContext = new TextView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.k;
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.i;
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.i;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131362213);
    localQQWalletTransferBubbleView.addView(paramContext);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    return localRelativeLayout;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    boolean bool2 = true;
    paramView = (vqm)paramViewHolder;
    if (paramView.a == null) {
      paramView.a = a(this.jdField_b_of_type_AndroidContentContext);
    }
    if ((paramChatMessage instanceof MessageForVIPDonate)) {}
    for (paramViewHolder = (MessageForVIPDonate)paramChatMessage;; paramViewHolder = null)
    {
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
      paramBaseChatItemLayout = (TextView)paramView.a.findViewById(2131362210);
      paramBaseChatItemLayout.setText(paramViewHolder.title);
      paramBaseChatItemLayout.setTextColor(-1);
      paramBaseChatItemLayout = (TextView)paramView.a.findViewById(2131362211);
      paramBaseChatItemLayout.setText(paramViewHolder.subTitle);
      paramBaseChatItemLayout.setTextColor(-1);
      ((TextView)paramView.a.findViewById(2131362213)).setText(paramViewHolder.footer);
      ((ImageView)paramView.a.findViewById(2131362209)).setImageResource(2130846451);
      paramBaseChatItemLayout = (QQWalletTransferBubbleView)paramView.a.findViewById(2131362212);
      QQWalletTransferBubbleView localQQWalletTransferBubbleView = (QQWalletTransferBubbleView)paramView.a.findViewById(2131362208);
      int m = Color.rgb(255, 170, 57);
      if (!paramChatMessage.isSend())
      {
        bool1 = true;
        localQQWalletTransferBubbleView.setBubbleBackground(2130844117, m, bool1);
        m = Color.rgb(255, 255, 255);
        if (paramChatMessage.isSend()) {
          break label346;
        }
      }
      label346:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramBaseChatItemLayout.setBubbleBackground(2130844118, m, bool1);
        if (jdField_b_of_type_Boolean) {
          paramView.a.setContentDescription(paramViewHolder.subTitle + paramViewHolder.title);
        }
        paramView.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
        paramView.a.setOnTouchListener(paramOnLongClickAndTouchListener);
        return paramView.a;
        bool1 = false;
        break;
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new vqm(this, null);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131375633: 
      ChatActivityFacade.a(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.c(paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(c, d, jdField_b_of_type_Int, 0);
      return;
    }
    paramView.setPadding(jdField_b_of_type_Int, d, c, 0);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    a(AIOUtils.a(paramView), localQQCustomMenu);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.b(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.VIPDonateMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */