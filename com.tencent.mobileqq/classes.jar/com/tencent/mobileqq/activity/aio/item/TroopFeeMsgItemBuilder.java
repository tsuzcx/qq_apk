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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.qwallet.widget.QQWalletTransferBubbleView;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class TroopFeeMsgItemBuilder
  extends BaseBubbleBuilder
{
  protected final int A = 2131447942;
  protected int B;
  protected int C;
  protected int D;
  protected int E;
  protected int F;
  protected int G;
  protected int H;
  protected int I;
  protected int J;
  protected int K;
  protected int L;
  protected int M;
  protected int N;
  protected int O;
  protected int P;
  protected int Q;
  private View.OnClickListener R = new TroopFeeMsgItemBuilder.1(this);
  protected final int a = 2131447945;
  protected final int w = 2131447941;
  protected final int x = 2131447944;
  protected final int y = 2131447943;
  protected final int z = 2131447940;
  
  public TroopFeeMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.C = ((int)(42.0F * f + 0.5F));
    this.D = ((int)(21.0F * f + 0.5F));
    this.E = ((int)(15.0F * f + 0.5F));
    this.F = ((int)(10.0F * f + 0.5F));
    this.G = ((int)(9.0F * f + 0.5F));
    this.H = ((int)(6.0F * f + 0.5F));
    this.I = ((int)(4.0F * f + 0.5F));
    this.J = ((int)(1.0F * f + 0.5F));
    this.B = (this.F * 23);
    this.K = ((int)(157.0F * f + 0.5F));
    this.L = ((int)(65.0F * f + 0.5F));
    this.M = ((int)(7.0F * f + 0.5F));
    this.N = ((int)(152.0F * f + 0.5F));
    this.O = ((int)(5.0F * f + 0.5F));
    this.P = ((int)(61.0F * f + 0.5F));
    this.Q = ((int)(f * 19.0F + 0.5F));
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (TroopFeeMsgItemBuilder.TroopFeeMsgHolder)paramViewHolder;
    paramBaseChatItemLayout = (MessageForTroopFee)paramChatMessage;
    if ((paramViewHolder.a != null) && (paramViewHolder.c == paramChatMessage.uniseq)) {
      return paramViewHolder.a;
    }
    if ((paramView != null) && ((paramView instanceof RelativeLayout))) {
      paramViewHolder.a = ((RelativeLayout)paramView);
    } else {
      paramViewHolder.a = a(this.e);
    }
    paramViewHolder.b = paramChatMessage.frienduin;
    paramViewHolder.c = paramChatMessage.uniseq;
    paramView = (TextView)paramViewHolder.a.findViewById(2131447944);
    TextView localTextView1 = (TextView)paramViewHolder.a.findViewById(2131447943);
    ImageView localImageView = (ImageView)paramViewHolder.a.findViewById(2131447941);
    TextView localTextView2 = (TextView)paramViewHolder.a.findViewById(2131447942);
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = (QQWalletTransferBubbleView)paramViewHolder.a.findViewById(2131447945);
    if (paramBaseChatItemLayout.title != null)
    {
      paramView.setTextSize(24.0F);
      TextPaint localTextPaint = paramView.getPaint();
      if (localTextPaint != null)
      {
        float f = localTextPaint.measureText(paramBaseChatItemLayout.title);
        if (this.B > BaseChatItemLayout.e)
        {
          if (f > BaseChatItemLayout.e - this.F * 9) {
            paramView.setTextSize(14.0F);
          }
        }
        else if (f > this.F * 14) {
          paramView.setTextSize(14.0F);
        }
      }
    }
    paramView.setText(paramBaseChatItemLayout.title);
    paramView.setTextColor(-1);
    localTextView1.setText(paramBaseChatItemLayout.summary);
    localTextView1.setTextColor(-1);
    localTextView2.setText(paramBaseChatItemLayout.source);
    localImageView.setImageResource(2130849135);
    localQQWalletTransferBubbleView.setBubbleBackground(2130849133, Color.parseColor(paramBaseChatItemLayout.backgroundColor), paramChatMessage.isSend() ^ true);
    paramChatMessage = paramViewHolder.a;
    paramView = new StringBuilder();
    paramView.append(paramBaseChatItemLayout.title);
    paramView.append(paramBaseChatItemLayout.summary);
    paramView.append(paramBaseChatItemLayout.source);
    paramChatMessage.setContentDescription(paramView.toString());
    paramViewHolder.a.setOnClickListener(this.R);
    paramViewHolder.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramViewHolder.a.setOnTouchListener(paramOnLongClickAndTouchListener);
    return paramViewHolder.a;
  }
  
  protected RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    Object localObject1 = new QQWalletTransferBubbleView(paramContext);
    ((QQWalletTransferBubbleView)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.B, this.E * 5));
    ((QQWalletTransferBubbleView)localObject1).setId(2131447945);
    Object localObject2 = new ImageView(paramContext);
    int i = this.C;
    Object localObject3 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.D;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject2).setId(2131447941);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localObject2 = new LinearLayout(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131447941);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = this.D;
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.H;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextSize(24.0F);
    ((TextView)localObject3).setId(2131447944);
    ((LinearLayout)localObject2).addView((View)localObject3);
    localObject3 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.J;
    ((TextView)localObject3).setLayoutParams(localLayoutParams);
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextSize(13.0F);
    ((TextView)localObject3).setId(2131447943);
    ((LinearLayout)localObject2).addView((View)localObject3);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localObject1 = new RelativeLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(this.B, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131447945);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).setBackgroundResource(2130849134);
    ((RelativeLayout)localObject1).setId(2131447940);
    paramContext = new TextView(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    i = this.D;
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = i;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = i;
    i = this.E;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = i;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131447942);
    ((RelativeLayout)localObject1).addView(paramContext);
    localRelativeLayout.addView((View)localObject1);
    return localRelativeLayout;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopFeeMsgItemBuilder.TroopFeeMsgHolder(this, null);
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
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopFee)paramChatMessage;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramChatMessage.title);
    localStringBuilder.append(paramChatMessage.summary);
    localStringBuilder.append(paramChatMessage.source);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFeeMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */