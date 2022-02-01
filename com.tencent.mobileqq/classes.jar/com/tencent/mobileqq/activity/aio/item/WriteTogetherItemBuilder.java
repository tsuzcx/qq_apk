package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v4.app.FragmentActivity;
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
    int k = paramContext.getResources().getDimensionPixelOffset(2131299297);
    int m = paramContext.getResources().getDimensionPixelOffset(2131299297);
    paramContext = new Paint();
    paramContext.setColor(-1);
    paramContext.setTextSize(ViewUtils.d(12.0F));
    return i + j + k + (int)paramContext.measureText(paramString) + m;
  }
  
  private View a(Context paramContext, View paramView, MessageRecord paramMessageRecord, String paramString, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramView == null)
    {
      paramView = new TextView(paramContext);
      paramView.setSingleLine(true);
      paramView.setGravity(16);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(2, 12.0F);
      paramView.setBackgroundResource(2130838498);
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView;
      localTextView.setEnabled(paramBoolean);
      localTextView.setText(paramString);
      localTextView.setId(2131364662);
      int i = paramContext.getResources().getDimensionPixelOffset(2131299297);
      int j = paramContext.getResources().getDimensionPixelOffset(2131299298);
      localTextView.setPadding(i, j, i, j);
      paramView.setTag(paramMessageRecord);
      paramView.setOnClickListener(paramOnClickListener);
      return paramView;
    }
  }
  
  @NotNull
  private RelativeLayout a(BaseChatItemLayout paramBaseChatItemLayout, RelativeLayout paramRelativeLayout)
  {
    RelativeLayout localRelativeLayout = paramRelativeLayout;
    if (paramRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(paramBaseChatItemLayout.getContext());
      localRelativeLayout.setId(2131382002);
      localRelativeLayout.setVisibility(8);
      paramBaseChatItemLayout.addView(localRelativeLayout, new RelativeLayout.LayoutParams(-2, -2));
    }
    return localRelativeLayout;
  }
  
  private void a(Context paramContext, ChatMessage paramChatMessage, RelativeLayout paramRelativeLayout)
  {
    if ((paramContext == null) || (paramChatMessage == null) || (paramRelativeLayout == null)) {}
    label195:
    for (;;)
    {
      return;
      MessageForWriteTogether localMessageForWriteTogether = (MessageForWriteTogether)paramChatMessage;
      View localView = paramRelativeLayout.getChildAt(0);
      String str;
      if (localView == null) {
        if (localMessageForWriteTogether.partCnt <= 2)
        {
          str = "";
          paramContext = a(paramContext, localView, paramChatMessage, str + "一起写", true, new WriteTogetherItemBuilder.3(this));
          paramRelativeLayout.addView(paramContext);
        }
      }
      for (;;)
      {
        if (!(paramContext instanceof TextView)) {
          break label195;
        }
        paramRelativeLayout = new StringBuilder();
        if (localMessageForWriteTogether.partCnt <= 0) {}
        for (paramChatMessage = "";; paramChatMessage = localMessageForWriteTogether.partCnt + "人")
        {
          paramChatMessage = paramChatMessage + "一起写";
          ((TextView)paramContext).setText(paramChatMessage);
          return;
          str = localMessageForWriteTogether.partCnt + "人";
          break;
        }
        paramContext = localView;
      }
    }
  }
  
  private void a(Context paramContext, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, RelativeLayout paramRelativeLayout)
  {
    if (!(paramChatMessage instanceof MessageForWriteTogether)) {}
    do
    {
      do
      {
        return;
      } while (paramBaseChatItemLayout == null);
      paramRelativeLayout = a(paramBaseChatItemLayout, paramRelativeLayout);
    } while (paramRelativeLayout == null);
    a(paramChatMessage, paramBaseChatItemLayout, paramRelativeLayout);
    a(paramContext, paramChatMessage, paramRelativeLayout);
    paramBaseChatItemLayout.requestLayout();
  }
  
  private void a(View paramView, RelativeLayout paramRelativeLayout)
  {
    if ((paramView == null) || (paramRelativeLayout == null)) {
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
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296404);
    int j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    localLayoutParams.addRule(7, 2131364634);
    localLayoutParams.addRule(3, 2131364634);
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
    localLayoutParams.addRule(3, 2131364634);
    localLayoutParams.addRule(0, 2131379872);
    localLayoutParams.addRule(1, 0);
    paramRelativeLayout.setLayoutParams(localLayoutParams);
    paramRelativeLayout.setVisibility(0);
    paramView.setVisibility(0);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new WriteTogetherItemBuilder.1(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new WriteTogetherItemBuilder.ChildDoubleClickListener(this, paramQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(ChatMessage paramChatMessage, int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject != null) {
        break label36;
      }
      QLog.e("WriteTogetherItemBuilder", 1, "[launchWriteTogether] ChatFragment is null");
    }
    label36:
    do
    {
      do
      {
        return;
        localObject = ((ChatFragment)localObject).a();
      } while (localObject == null);
      localObject = (WriteTogetherHelper)((BaseChatPie)localObject).a(74);
    } while ((localObject == null) || (!(paramChatMessage instanceof MessageForWriteTogether)));
    ((WriteTogetherHelper)localObject).a(((MessageForWriteTogether)paramChatMessage).padId, paramInt);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, RelativeLayout paramRelativeLayout)
  {
    if ((paramChatMessage == null) || (paramBaseChatItemLayout == null) || (paramRelativeLayout == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    }
    paramBaseChatItemLayout = paramBaseChatItemLayout.getResources();
    localLayoutParams1.topMargin = AIOUtils.a(-2.0F, paramBaseChatItemLayout);
    localLayoutParams1.addRule(5, 2131364634);
    localLayoutParams1.addRule(3, 2131364634);
    int i;
    if (!paramChatMessage.isSend())
    {
      i = 1;
      if (i == 0) {
        break label122;
      }
    }
    label122:
    for (localLayoutParams1.leftMargin = AIOUtils.a(11.0F, paramBaseChatItemLayout);; localLayoutParams1.leftMargin = AIOUtils.a(9.0F, paramBaseChatItemLayout))
    {
      paramRelativeLayout.setLayoutParams(localLayoutParams1);
      paramRelativeLayout.setVisibility(0);
      return;
      i = 0;
      break;
    }
  }
  
  private void a(ChatMessage paramChatMessage, TextItemBuilder.Holder paramHolder)
  {
    RelativeLayout localRelativeLayout;
    if ((paramHolder.jdField_a_of_type_AndroidViewView != null) && (paramHolder.jdField_d_of_type_AndroidViewView != null))
    {
      localRelativeLayout = (RelativeLayout)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.findViewById(2131382002);
      localRelativeLayout = a(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localRelativeLayout);
      if (localRelativeLayout != null) {}
    }
    else
    {
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
  
  public int a(ChatMessage paramChatMessage)
  {
    return super.a(paramChatMessage);
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject2;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject2 = (MessageForWriteTogether)paramChatMessage;
      localObject3 = new StringBuilder().append("[getBubbleView] cvtView: ");
      if (paramView == null)
      {
        localObject1 = "null";
        QLog.d("WriteTogetherItemBuilder", 2, localObject1 + ", isLong: " + ((MessageForWriteTogether)localObject2).isLongMsg);
      }
    }
    else
    {
      if ((paramChatMessage instanceof MessageForWriteTogether)) {
        break label90;
      }
      paramView = null;
    }
    label90:
    boolean bool;
    label218:
    do
    {
      do
      {
        return paramView;
        localObject1 = Integer.valueOf(paramView.hashCode());
        break;
        localObject4 = paramBaseChatItemLayout.getContext();
        localObject2 = (TextItemBuilder.Holder)paramViewHolder;
        localObject3 = (MessageForWriteTogether)paramChatMessage;
        ((MessageForWriteTogether)localObject3).parse();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == null)) {
          break label332;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        bool = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, (String)localObject1);
        if ((!bool) || (((MessageForWriteTogether)localObject3).isLongMsg))
        {
          localObject1 = ((TextItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
          a((Context)localObject4, paramChatMessage, (BaseChatItemLayout)localObject1, (RelativeLayout)((BaseChatItemLayout)localObject1).findViewById(2131382002));
        }
        if (((MessageForWriteTogether)localObject3).isLongMsg) {
          break label359;
        }
        if (!(paramView instanceof TextView)) {
          break label339;
        }
        paramViewHolder = super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
        if (((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidWidgetTextView != null) {
          ((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
        }
        ((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidViewView = super.a(((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidViewView, (BaseBubbleBuilder.ViewHolder)localObject2, ((TextItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
        paramView = paramViewHolder;
      } while (((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidViewView == null);
      paramView = paramViewHolder;
    } while (!bool);
    a(paramChatMessage, (TextItemBuilder.Holder)localObject2);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramBaseChatItemLayout = ((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidViewView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {}
    for (paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;; paramChatMessage = null)
    {
      TroopEssenceReportUtil.a(paramView, paramBaseChatItemLayout, paramChatMessage);
      return paramViewHolder;
      label332:
      localObject1 = "";
      break;
      label339:
      paramViewHolder = super.a(paramChatMessage, paramViewHolder, null, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
      break label218;
    }
    label359:
    if (paramView != null)
    {
      paramViewHolder = paramView;
      if (!(paramView instanceof TextView)) {}
    }
    else
    {
      paramView = ((Context)localObject4).getResources();
      paramViewHolder = (RelativeLayout)LayoutInflater.from((Context)localObject4).inflate(2131563246, null);
      localObject1 = new RelativeLayout.LayoutParams(BaseChatItemLayout.e, -2);
      int i = paramView.getDimensionPixelSize(2131299067);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(i, 0, i, 0);
      paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView = (LinearLayout)paramViewHolder.findViewById(2131382000);
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(BaseChatItemLayout.f, -2));
      paramView.setOrientation(1);
      paramView = paramViewHolder.findViewById(2131382057);
      localObject1 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = BaseChatItemLayout.f;
      ((ViewGroup.LayoutParams)localObject1).height = ((Context)localObject4).getResources().getDimensionPixelSize(2131299283);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView = (TextView)paramViewHolder.findViewById(2131382003);
      paramView.setTextColor(-16777216);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramView);
      ((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidWidgetTextView = paramView;
    }
    Object localObject4 = paramViewHolder.findViewById(2131382000);
    paramView = (TextView)paramViewHolder.findViewById(2131382003);
    Object localObject1 = (TextView)paramViewHolder.findViewById(2131382001);
    if (!android.text.TextUtils.isEmpty(((MessageForWriteTogether)localObject3).sb)) {
      if (!android.text.TextUtils.isEmpty(((MessageForWriteTogether)localObject3).sb2))
      {
        ((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidWidgetTextView.setText(((MessageForWriteTogether)localObject3).sb2);
        ((View)localObject4).setOnTouchListener(paramOnLongClickAndTouchListener);
        ((View)localObject4).setOnLongClickListener(paramOnLongClickAndTouchListener);
        ((TextView)localObject1).setClickable(false);
        ((View)localObject4).setTag(localObject3);
        ((View)localObject4).setOnClickListener(this);
        ((View)localObject4).setClickable(false);
        ((View)localObject4).setVisibility(0);
        paramOnLongClickAndTouchListener = VasShieldFont.a(paramChatMessage);
        paramView.setTypeface(paramOnLongClickAndTouchListener);
        ((TextView)localObject1).setTypeface(paramOnLongClickAndTouchListener);
        ((TextView)localObject1).setTextColor(paramView.getTextColors());
        ((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidViewView = super.a(((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidViewView, (BaseBubbleBuilder.ViewHolder)localObject2, ((TextItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
        super.a(((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidViewView, paramBaseChatItemLayout, Integer.valueOf(2131382000), paramChatMessage, -4, Boolean.valueOf(true));
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        paramBaseChatItemLayout = ((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidViewView;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
          break label800;
        }
      }
    }
    label800:
    for (paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;; paramChatMessage = null)
    {
      TroopEssenceReportUtil.a(paramView, paramBaseChatItemLayout, paramChatMessage);
      return paramViewHolder;
      ((TextItemBuilder.Holder)localObject2).jdField_d_of_type_AndroidWidgetTextView.setText(((MessageForWriteTogether)localObject3).sb);
      break;
      paramView.setText(((MessageForWriteTogether)localObject3).msg);
      break;
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return super.a();
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return super.a(paramChatMessage);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131382059)
    {
      a(paramChatMessage, 8);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    MessageForWriteTogether localMessageForWriteTogether = (MessageForWriteTogether)paramChatMessage;
    if ((localMessageForWriteTogether.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (localMessageForWriteTogether.getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {
      return;
    }
    super.a(paramView, paramChatMessage);
  }
  
  public void a(Integer paramInteger, MessageRecord paramMessageRecord, Boolean paramBoolean, RelativeLayout.LayoutParams paramLayoutParams, ViewGroup paramViewGroup)
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
    if (paramView.getId() == 2131382000) {
      a(localChatMessage, 6);
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131382002) {
        a(localChatMessage, 5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.WriteTogetherItemBuilder
 * JD-Core Version:    0.7.0.1
 */