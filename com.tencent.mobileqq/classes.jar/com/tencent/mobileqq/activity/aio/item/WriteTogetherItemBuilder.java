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
  private boolean f;
  private boolean g;
  
  public WriteTogetherItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    a(paramQQAppInterface);
  }
  
  private int a(String paramString, Context paramContext)
  {
    int i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
    int j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
    int k = paramContext.getResources().getDimensionPixelOffset(2131299300);
    int m = paramContext.getResources().getDimensionPixelOffset(2131299300);
    paramContext = new Paint();
    paramContext.setColor(-1);
    paramContext.setTextSize(ViewUtils.d(12.0F));
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
      ((TextView)localObject).setBackgroundResource(2130838346);
    }
    paramView = (TextView)localObject;
    paramView.setEnabled(paramBoolean);
    paramView.setText(paramString);
    paramView.setId(2131364549);
    int i = paramContext.getResources().getDimensionPixelOffset(2131299300);
    int j = paramContext.getResources().getDimensionPixelOffset(2131299301);
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
      localRelativeLayout.setId(2131381207);
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
      int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296383);
      int j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      localLayoutParams.addRule(7, 2131364521);
      localLayoutParams.addRule(3, 2131364521);
      localLayoutParams.topMargin = -4;
      localLayoutParams.rightMargin = (i + j + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 3.0F));
      paramView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
      if (localLayoutParams == null)
      {
        paramView.setVisibility(8);
        paramRelativeLayout.setVisibility(8);
        return;
      }
      a(localLayoutParams);
      localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      localLayoutParams.addRule(3, 2131364521);
      localLayoutParams.addRule(0, 2131379201);
      localLayoutParams.addRule(1, 0);
      paramRelativeLayout.setLayoutParams(localLayoutParams);
      paramRelativeLayout.setVisibility(0);
      paramView.setVisibility(0);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new WriteTogetherItemBuilder.1(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new WriteTogetherItemBuilder.ChildDoubleClickListener(this, paramQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(ChatMessage paramChatMessage, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject == null)
      {
        QLog.e("WriteTogetherItemBuilder", 1, "[launchWriteTogether] ChatFragment is null");
        return;
      }
      localObject = ((ChatFragment)localObject).a();
      if (localObject != null)
      {
        localObject = (WriteTogetherHelper)((BaseChatPie)localObject).a(74);
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
      localLayoutParams1.addRule(5, 2131364521);
      localLayoutParams1.addRule(3, 2131364521);
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
    if ((paramHolder.jdField_a_of_type_AndroidViewView != null) && (paramHolder.jdField_d_of_type_AndroidViewView != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.findViewById(2131381207);
      localRelativeLayout = a(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localRelativeLayout);
      if (localRelativeLayout == null) {
        return;
      }
      a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, localRelativeLayout);
      int j = a("1000人一起写", this.jdField_a_of_type_AndroidContentContext);
      Object localObject = localRelativeLayout.getChildAt(0);
      int i = j;
      if ((localObject instanceof TextView))
      {
        localObject = ((TextView)localObject).getText().toString();
        i = j;
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
          i = a((String)localObject, this.jdField_a_of_type_AndroidContentContext);
        }
      }
      paramHolder.jdField_a_of_type_AndroidViewView.post(new WriteTogetherItemBuilder.2(this, paramHolder, i, paramChatMessage, localRelativeLayout, paramChatMessage));
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return super.a(paramChatMessage);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    } else {
      localObject1 = "";
    }
    bool = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, (String)localObject1);
    if ((!bool) || (localMessageForWriteTogether.isLongMsg))
    {
      localObject1 = ((TextItemBuilder.Holder)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      a(localContext, paramChatMessage, (BaseChatItemLayout)localObject1, (RelativeLayout)((BaseChatItemLayout)localObject1).findViewById(2131381207));
    }
    if (!localMessageForWriteTogether.isLongMsg)
    {
      if ((paramView instanceof TextView)) {
        paramViewHolder = super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
      } else {
        paramViewHolder = super.a(paramChatMessage, paramViewHolder, null, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
      }
      if (((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidWidgetTextView != null) {
        ((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
      }
      ((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidViewView = super.a(((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidViewView, (BaseBubbleBuilder.ViewHolder)localObject3, ((TextItemBuilder.Holder)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      if ((((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidViewView != null) && (bool))
      {
        a(paramChatMessage, (TextItemBuilder.Holder)localObject3);
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        paramBaseChatItemLayout = ((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidViewView;
        paramChatMessage = (ChatMessage)localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
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
      paramViewHolder = (RelativeLayout)LayoutInflater.from(localContext).inflate(2131563070, null);
      localObject1 = new RelativeLayout.LayoutParams(BaseChatItemLayout.e, -2);
      int i = paramView.getDimensionPixelSize(2131299072);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(i, 0, i, 0);
      paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView = (LinearLayout)paramViewHolder.findViewById(2131381205);
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(BaseChatItemLayout.f, -2));
      paramView.setOrientation(1);
      paramView = paramViewHolder.findViewById(2131381259);
      localObject1 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = BaseChatItemLayout.f;
      ((ViewGroup.LayoutParams)localObject1).height = localContext.getResources().getDimensionPixelSize(2131299286);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView = (TextView)paramViewHolder.findViewById(2131381208);
      paramView.setTextColor(-16777216);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramView);
      ((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidWidgetTextView = paramView;
    }
    localObject2 = paramViewHolder.findViewById(2131381205);
    paramView = (TextView)paramViewHolder.findViewById(2131381208);
    Object localObject1 = (TextView)paramViewHolder.findViewById(2131381206);
    if (!android.text.TextUtils.isEmpty(localMessageForWriteTogether.sb))
    {
      if (!android.text.TextUtils.isEmpty(localMessageForWriteTogether.sb2)) {
        ((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidWidgetTextView.setText(localMessageForWriteTogether.sb2);
      } else {
        ((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidWidgetTextView.setText(localMessageForWriteTogether.sb);
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
    ((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidViewView = super.a(((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidViewView, (BaseBubbleBuilder.ViewHolder)localObject3, ((TextItemBuilder.Holder)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
    super.a(((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidViewView, paramBaseChatItemLayout, Integer.valueOf(2131381205), paramChatMessage, -4, Boolean.valueOf(true));
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramBaseChatItemLayout = ((TextItemBuilder.Holder)localObject3).jdField_d_of_type_AndroidViewView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
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
  
  protected String a(ChatMessage paramChatMessage)
  {
    return super.a(paramChatMessage);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131381261)
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
  
  protected boolean b()
  {
    return super.b();
  }
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (paramView.getId() == 2131381205) {
      a(localChatMessage, 6);
    } else if (paramView.getId() == 2131381207) {
      a(localChatMessage, 5);
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.WriteTogetherItemBuilder
 * JD-Core Version:    0.7.0.1
 */