package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.WriteTogetherHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.jetbrains.annotations.NotNull;

public class WriteTogetherItemBuilder
  extends TextItemBuilder
{
  private boolean a;
  private boolean w;
  
  public WriteTogetherItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    a(paramQQAppInterface);
  }
  
  private int a(String paramString, Context paramContext)
  {
    int i = DisplayUtil.a(this.e, 55.0F);
    int j = DisplayUtil.a(this.e, 5.0F);
    int k = paramContext.getResources().getDimensionPixelOffset(2131300095);
    int m = paramContext.getResources().getDimensionPixelOffset(2131300095);
    paramContext = new Paint();
    paramContext.setColor(-1);
    paramContext.setTextSize(ViewUtils.spToPx(12.0F));
    return i + j + k + (int)paramContext.measureText(paramString) + m;
  }
  
  private View a(Context paramContext, View paramView, MessageRecord paramMessageRecord, String paramString, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new TextView(paramContext);
      ((TextView)localObject).setSingleLine(true);
      ((TextView)localObject).setGravity(16);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setTextSize(2, 12.0F);
      ((TextView)localObject).setBackgroundResource(2130838395);
    }
    paramView = (TextView)localObject;
    paramView.setEnabled(paramBoolean);
    paramView.setText(paramString);
    paramView.setId(2131430607);
    int i = paramContext.getResources().getDimensionPixelOffset(2131300095);
    int j = paramContext.getResources().getDimensionPixelOffset(2131300096);
    paramView.setPadding(i, j, i, j);
    ((View)localObject).setTag(paramMessageRecord);
    ((View)localObject).setOnClickListener(paramOnClickListener);
    return localObject;
  }
  
  @NotNull
  private RelativeLayout a(BaseChatItemLayout paramBaseChatItemLayout, RelativeLayout paramRelativeLayout)
  {
    RelativeLayout localRelativeLayout = paramRelativeLayout;
    if (paramRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(paramBaseChatItemLayout.getContext());
      localRelativeLayout.setId(2131450255);
      localRelativeLayout.setVisibility(8);
      paramBaseChatItemLayout.addView(localRelativeLayout, new RelativeLayout.LayoutParams(-2, -2));
    }
    return localRelativeLayout;
  }
  
  private void a(Context paramContext, ChatMessage paramChatMessage, RelativeLayout paramRelativeLayout)
  {
    if ((paramContext != null) && (paramChatMessage != null))
    {
      if (paramRelativeLayout == null) {
        return;
      }
      MessageForWriteTogether localMessageForWriteTogether = (MessageForWriteTogether)paramChatMessage;
      View localView = paramRelativeLayout.getChildAt(0);
      String str = "";
      Object localObject = localView;
      if (localView == null)
      {
        if (localMessageForWriteTogether.partCnt <= 2)
        {
          localObject = "";
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localMessageForWriteTogether.partCnt);
          ((StringBuilder)localObject).append("人");
          localObject = ((StringBuilder)localObject).toString();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("一起写");
        localObject = a(paramContext, localView, paramChatMessage, localStringBuilder.toString(), true, new WriteTogetherItemBuilder.3(this));
        paramRelativeLayout.addView((View)localObject);
      }
      if ((localObject instanceof TextView))
      {
        paramChatMessage = new StringBuilder();
        if (localMessageForWriteTogether.partCnt <= 0)
        {
          paramContext = str;
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append(localMessageForWriteTogether.partCnt);
          paramContext.append("人");
          paramContext = paramContext.toString();
        }
        paramChatMessage.append(paramContext);
        paramChatMessage.append("一起写");
        paramContext = paramChatMessage.toString();
        ((TextView)localObject).setText(paramContext);
      }
    }
  }
  
  private void a(Context paramContext, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, RelativeLayout paramRelativeLayout)
  {
    if (!(paramChatMessage instanceof MessageForWriteTogether)) {
      return;
    }
    if (paramBaseChatItemLayout == null) {
      return;
    }
    paramRelativeLayout = a(paramBaseChatItemLayout, paramRelativeLayout);
    if (paramRelativeLayout == null) {
      return;
    }
    a(paramChatMessage, paramBaseChatItemLayout, paramRelativeLayout);
    a(paramContext, paramChatMessage, paramRelativeLayout);
    paramBaseChatItemLayout.requestLayout();
  }
  
  private void a(View paramView, RelativeLayout paramRelativeLayout)
  {
    if (paramView != null)
    {
      if (paramRelativeLayout == null) {
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams == null)
      {
        paramView.setVisibility(8);
        paramRelativeLayout.setVisibility(8);
        return;
      }
      a(localLayoutParams);
      int i = this.e.getResources().getDimensionPixelSize(2131296615);
      int j = DisplayUtil.a(this.e, 10.0F);
      localLayoutParams.addRule(7, 2131430578);
      localLayoutParams.addRule(3, 2131430578);
      localLayoutParams.topMargin = -4;
      localLayoutParams.rightMargin = (i + j + DisplayUtil.a(this.e, 3.0F));
      paramView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
      if (localLayoutParams == null)
      {
        paramView.setVisibility(8);
        paramRelativeLayout.setVisibility(8);
        return;
      }
      a(localLayoutParams);
      localLayoutParams.rightMargin = DisplayUtil.a(this.e, 5.0F);
      localLayoutParams.addRule(3, 2131430578);
      localLayoutParams.addRule(0, 2131447938);
      localLayoutParams.addRule(1, 0);
      paramRelativeLayout.setLayoutParams(localLayoutParams);
      paramRelativeLayout.setVisibility(0);
      paramView.setVisibility(0);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.C = new WriteTogetherItemBuilder.1(this);
    this.E = new WriteTogetherItemBuilder.ChildDoubleClickListener(this, paramQQAppInterface, (Activity)this.e);
  }
  
  private void a(ChatMessage paramChatMessage, int paramInt)
  {
    if ((this.e instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.e).getChatFragment();
      if (localObject == null)
      {
        QLog.e("WriteTogetherItemBuilder", 1, "[launchWriteTogether] ChatFragment is null");
        return;
      }
      localObject = ((ChatFragment)localObject).k();
      if (localObject != null)
      {
        localObject = (WriteTogetherHelper)((BaseChatPie)localObject).q(74);
        if ((localObject != null) && ((paramChatMessage instanceof MessageForWriteTogether))) {
          ((WriteTogetherHelper)localObject).a(((MessageForWriteTogether)paramChatMessage).padId, paramInt);
        }
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, RelativeLayout paramRelativeLayout)
  {
    if ((paramChatMessage != null) && (paramBaseChatItemLayout != null))
    {
      if (paramRelativeLayout == null) {
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      }
      paramBaseChatItemLayout = paramBaseChatItemLayout.getResources();
      localLayoutParams1.topMargin = AIOUtils.b(-2.0F, paramBaseChatItemLayout);
      localLayoutParams1.addRule(5, 2131430578);
      localLayoutParams1.addRule(3, 2131430578);
      if ((paramChatMessage.isSend() ^ true)) {
        localLayoutParams1.leftMargin = AIOUtils.b(11.0F, paramBaseChatItemLayout);
      } else {
        localLayoutParams1.leftMargin = AIOUtils.b(9.0F, paramBaseChatItemLayout);
      }
      paramRelativeLayout.setLayoutParams(localLayoutParams1);
      paramRelativeLayout.setVisibility(0);
    }
  }
  
  private void a(ChatMessage paramChatMessage, TextItemBuilder.Holder paramHolder)
  {
    if ((paramHolder.h != null) && (paramHolder.A != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)paramHolder.j.findViewById(2131450255);
      localRelativeLayout = a(paramHolder.j, localRelativeLayout);
      if (localRelativeLayout == null) {
        return;
      }
      a(this.e, paramChatMessage, localRelativeLayout);
      int j = a("1000人一起写", this.e);
      Object localObject = localRelativeLayout.getChildAt(0);
      int i = j;
      if ((localObject instanceof TextView))
      {
        localObject = ((TextView)localObject).getText().toString();
        i = j;
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
          i = a((String)localObject, this.e);
        }
      }
      paramHolder.h.post(new WriteTogetherItemBuilder.2(this, paramHolder, i, paramChatMessage, localRelativeLayout, paramChatMessage));
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = (MessageForWriteTogether)paramChatMessage;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[getBubbleView] cvtView: ");
      if (paramView == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(paramView.hashCode());
      }
      ((StringBuilder)localObject3).append(localObject1);
      ((StringBuilder)localObject3).append(", isLong: ");
      ((StringBuilder)localObject3).append(((MessageForWriteTogether)localObject2).isLongMsg);
      QLog.d("WriteTogetherItemBuilder", 2, ((StringBuilder)localObject3).toString());
    }
    boolean bool = paramChatMessage instanceof MessageForWriteTogether;
    Object localObject2 = null;
    if (!bool) {
      return null;
    }
    Context localContext = paramBaseChatItemLayout.getContext();
    Object localObject3 = (TextItemBuilder.Holder)paramViewHolder;
    MessageForWriteTogether localMessageForWriteTogether = (MessageForWriteTogether)paramChatMessage;
    localMessageForWriteTogether.parse();
    if ((this.f != null) && (this.f.b != null)) {
      localObject1 = this.f.b;
    } else {
      localObject1 = "";
    }
    bool = TroopEssenceUtil.a(this.d, paramChatMessage, (String)localObject1);
    if ((!bool) || (localMessageForWriteTogether.isLongMsg))
    {
      localObject1 = ((TextItemBuilder.Holder)localObject3).j;
      a(localContext, paramChatMessage, (BaseChatItemLayout)localObject1, (RelativeLayout)((BaseChatItemLayout)localObject1).findViewById(2131450255));
    }
    if (!localMessageForWriteTogether.isLongMsg)
    {
      if ((paramView instanceof TextView)) {
        paramViewHolder = super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
      } else {
        paramViewHolder = super.a(paramChatMessage, paramViewHolder, null, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
      }
      if (((TextItemBuilder.Holder)localObject3).v != null) {
        ((TextItemBuilder.Holder)localObject3).v.setPadding(0, 0, 0, 0);
      }
      ((TextItemBuilder.Holder)localObject3).A = super.a(((TextItemBuilder.Holder)localObject3).A, (BaseBubbleBuilder.ViewHolder)localObject3, ((TextItemBuilder.Holder)localObject3).j, paramChatMessage, -2, DisplayUtil.a(this.e, 21.0F));
      if ((((TextItemBuilder.Holder)localObject3).A != null) && (bool))
      {
        a(paramChatMessage, (TextItemBuilder.Holder)localObject3);
        paramView = this.d;
        paramBaseChatItemLayout = ((TextItemBuilder.Holder)localObject3).A;
        paramChatMessage = (ChatMessage)localObject2;
        if (this.f != null) {
          paramChatMessage = this.f.b;
        }
        TroopEssenceReportUtil.a(paramView, paramBaseChatItemLayout, paramChatMessage);
      }
      return paramViewHolder;
    }
    if ((paramView != null) && (!(paramView instanceof TextView)))
    {
      paramViewHolder = paramView;
    }
    else
    {
      paramView = localContext.getResources();
      paramViewHolder = (RelativeLayout)LayoutInflater.from(localContext).inflate(2131629708, null);
      localObject1 = new RelativeLayout.LayoutParams(BaseChatItemLayout.e, -2);
      int i = paramView.getDimensionPixelSize(2131299800);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(i, 0, i, 0);
      paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView = (LinearLayout)paramViewHolder.findViewById(2131450253);
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(BaseChatItemLayout.f, -2));
      paramView.setOrientation(1);
      paramView = paramViewHolder.findViewById(2131450307);
      localObject1 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = BaseChatItemLayout.f;
      ((ViewGroup.LayoutParams)localObject1).height = localContext.getResources().getDimensionPixelSize(2131300081);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView = (TextView)paramViewHolder.findViewById(2131450256);
      paramView.setTextColor(-16777216);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramView);
      ((TextItemBuilder.Holder)localObject3).v = paramView;
    }
    localObject2 = paramViewHolder.findViewById(2131450253);
    paramView = (TextView)paramViewHolder.findViewById(2131450256);
    Object localObject1 = (TextView)paramViewHolder.findViewById(2131450254);
    if (!android.text.TextUtils.isEmpty(localMessageForWriteTogether.sb))
    {
      if (!android.text.TextUtils.isEmpty(localMessageForWriteTogether.sb2)) {
        ((TextItemBuilder.Holder)localObject3).v.setText(localMessageForWriteTogether.sb2);
      } else {
        ((TextItemBuilder.Holder)localObject3).v.setText(localMessageForWriteTogether.sb);
      }
    }
    else {
      paramView.setText(localMessageForWriteTogether.msg);
    }
    ((View)localObject2).setOnTouchListener(paramOnLongClickAndTouchListener);
    ((View)localObject2).setOnLongClickListener(paramOnLongClickAndTouchListener);
    ((TextView)localObject1).setClickable(false);
    ((View)localObject2).setTag(localMessageForWriteTogether);
    ((View)localObject2).setOnClickListener(this);
    ((View)localObject2).setClickable(false);
    ((View)localObject2).setVisibility(0);
    paramOnLongClickAndTouchListener = VasShieldFont.a(paramChatMessage);
    paramView.setTypeface(paramOnLongClickAndTouchListener);
    ((TextView)localObject1).setTypeface(paramOnLongClickAndTouchListener);
    ((TextView)localObject1).setTextColor(paramView.getTextColors());
    ((TextItemBuilder.Holder)localObject3).A = super.a(((TextItemBuilder.Holder)localObject3).A, (BaseBubbleBuilder.ViewHolder)localObject3, ((TextItemBuilder.Holder)localObject3).j, paramChatMessage, -2, DisplayUtil.a(this.e, 21.0F));
    super.a(((TextItemBuilder.Holder)localObject3).A, paramBaseChatItemLayout, Integer.valueOf(2131450253), paramChatMessage, -4, Boolean.valueOf(true));
    paramView = this.d;
    paramBaseChatItemLayout = ((TextItemBuilder.Holder)localObject3).A;
    if (this.f != null) {
      paramChatMessage = this.f.b;
    } else {
      paramChatMessage = null;
    }
    TroopEssenceReportUtil.a(paramView, paramBaseChatItemLayout, paramChatMessage);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return super.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131450309)
    {
      a(paramChatMessage, 8);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    MessageForWriteTogether localMessageForWriteTogether = (MessageForWriteTogether)paramChatMessage;
    if (!localMessageForWriteTogether.getExtInfoFromExtStr("long_text_recv_state").equals("2"))
    {
      if (localMessageForWriteTogether.getExtInfoFromExtStr("long_text_recv_state").equals("3")) {
        return;
      }
      super.a(paramView, paramChatMessage);
    }
  }
  
  protected void a(Integer paramInteger, MessageRecord paramMessageRecord, Boolean paramBoolean, RelativeLayout.LayoutParams paramLayoutParams, ViewGroup paramViewGroup)
  {
    if (paramInteger != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.findViewById(paramInteger.intValue()).getLayoutParams();
      localLayoutParams.rightMargin = 0;
      localLayoutParams.addRule(0, 0);
      super.a(paramInteger, paramMessageRecord, paramBoolean, paramLayoutParams, paramViewGroup);
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return super.c(paramChatMessage);
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return super.d(paramChatMessage);
  }
  
  protected boolean h()
  {
    return super.h();
  }
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (paramView.getId() == 2131450253) {
      a(localChatMessage, 6);
    } else if (paramView.getId() == 2131450255) {
      a(localChatMessage, 5);
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.WriteTogetherItemBuilder
 * JD-Core Version:    0.7.0.1
 */