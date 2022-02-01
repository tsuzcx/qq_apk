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
  private static int jdField_a_of_type_Int;
  private static int d;
  private static int e;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new VIPDonateMsgItemBuilder.1(this);
  private Context b;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public VIPDonateMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.b = paramContext;
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.f = ((int)(1.0F * f1 + 0.5F));
    this.g = ((int)(6.0F * f1 + 0.5F));
    this.h = ((int)(7.0F * f1 + 0.5F));
    this.j = ((int)(15.0F * f1 + 0.5F));
    this.l = ((int)(21.0F * f1 + 0.5F));
    this.k = ((int)(42.0F * f1 + 0.5F));
    this.i = ((int)(f1 * 230.0F + 0.5F));
    int m = this.f;
    jdField_a_of_type_Int = m * 2;
    d = m * 2;
    jdField_e_of_type_Int = this.h;
  }
  
  private RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localQQWalletTransferBubbleView.setLayoutParams(new RelativeLayout.LayoutParams(this.i, this.j * 5));
    localQQWalletTransferBubbleView.setId(2131380932);
    Object localObject1 = new ImageView(paramContext);
    int m = this.k;
    Object localObject2 = new RelativeLayout.LayoutParams(m, m);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject1).setId(2131380928);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localObject1 = new LinearLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131380928);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.g;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((LinearLayout)localObject1).setOrientation(1);
    localObject2 = new TextView(paramContext);
    ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(20.0F);
    ((TextView)localObject2).setId(2131380931);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject2 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.f;
    ((TextView)localObject2).setLayoutParams(localLayoutParams);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(14.0F);
    ((TextView)localObject2).setId(2131380930);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(this.i, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131380932);
    localQQWalletTransferBubbleView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localQQWalletTransferBubbleView.setBackgroundResource(2130847480);
    localQQWalletTransferBubbleView.setId(2131380927);
    paramContext = new TextView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    m = this.l;
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = m;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = m;
    m = this.j;
    ((RelativeLayout.LayoutParams)localObject1).topMargin = m;
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = m;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131380929);
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
    paramView = (VIPDonateMsgItemBuilder.VIPDonateMsgHolder)paramViewHolder;
    if (paramView.a == null) {
      paramView.a = a(this.b);
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
    paramBaseChatItemLayout = (TextView)paramView.a.findViewById(2131380931);
    paramBaseChatItemLayout.setText(paramViewHolder.title);
    paramBaseChatItemLayout.setTextColor(-1);
    paramBaseChatItemLayout = (TextView)paramView.a.findViewById(2131380930);
    paramBaseChatItemLayout.setText(paramViewHolder.subTitle);
    paramBaseChatItemLayout.setTextColor(-1);
    ((TextView)paramView.a.findViewById(2131380929)).setText(paramViewHolder.footer);
    ((ImageView)paramView.a.findViewById(2131380928)).setImageResource(2130851221);
    paramBaseChatItemLayout = (QQWalletTransferBubbleView)paramView.a.findViewById(2131380927);
    ((QQWalletTransferBubbleView)paramView.a.findViewById(2131380932)).setBubbleBackground(2130847479, Color.rgb(255, 170, 57), paramChatMessage.isSend() ^ true);
    paramBaseChatItemLayout.setBubbleBackground(2130847480, Color.rgb(255, 255, 255), paramChatMessage.isSend() ^ true);
    if (jdField_e_of_type_Boolean)
    {
      paramChatMessage = paramView.a;
      paramBaseChatItemLayout = new StringBuilder();
      paramBaseChatItemLayout.append(paramViewHolder.subTitle);
      paramBaseChatItemLayout.append(paramViewHolder.title);
      paramChatMessage.setContentDescription(paramBaseChatItemLayout.toString());
    }
    paramView.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramView.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramView.a.setOnTouchListener(paramOnLongClickAndTouchListener);
    return paramView.a;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new VIPDonateMsgItemBuilder.VIPDonateMsgHolder(this, null);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(d, jdField_e_of_type_Int, jdField_a_of_type_Int, 0);
      return;
    }
    paramView.setPadding(jdField_a_of_type_Int, jdField_e_of_type_Int, d, 0);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.b, 2131376417, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a(localQQCustomMenu, this.b, 2131376430, paramView, null);
    super.a(localQQCustomMenu, this.b, 2131371603, null, null);
    super.a(localQQCustomMenu, this.b, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.VIPDonateMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */