package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.miniaio.MiniChatLinearLayout;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;

public abstract class AbstractChatItemBuilder
  extends ChatItemBuilder
{
  public Context a;
  protected BaseAdapter a;
  public SessionInfo a;
  public QQAppInterface a;
  
  public AbstractChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject1 = paramViewGroup.getContext();
    AbstractChatItemBuilder.ViewHolder localViewHolder;
    if (paramView == null)
    {
      paramView = new MiniChatLinearLayout((Context)localObject1);
      ((LinearLayout)paramView).setOrientation(1);
      localViewHolder = a();
      paramView.setTag(localViewHolder);
    }
    try
    {
      localViewHolder = (AbstractChatItemBuilder.ViewHolder)paramView.getTag();
      localViewHolder.jdField_a_of_type_Int = paramInt1;
      localViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      if (paramChatMessage.mNeedTimeStamp)
      {
        if (localViewHolder.jdField_a_of_type_AndroidWidgetTextView == null)
        {
          localObject2 = new TextView((Context)localObject1);
          ((TextView)localObject2).setId(2131364552);
          paramInt2 = AIOUtils.b(14.0F, ((Context)localObject1).getResources());
          ((TextView)localObject2).setTextSize(2, 11.0F);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a != null) {
            ((TextView)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a);
          }
          ((TextView)localObject2).setPadding(paramInt2, 0, paramInt2, 0);
          ((TextView)localObject2).setGravity(17);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 1;
          localLayoutParams.topMargin = BaseChatItemLayout.G;
          localLayoutParams.bottomMargin = BaseChatItemLayout.G;
          ((ViewGroup)paramView).addView((View)localObject2, 0, localLayoutParams);
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
          ((TextView)localObject2).setTag(Long.valueOf(0L));
        }
        Object localObject2 = (LinearLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (paramChatMessage.isFirstMsg) {
          ((LinearLayout.LayoutParams)localObject2).topMargin = (BaseChatItemLayout.G * 2);
        } else {
          ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.G;
        }
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (((Long)localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getTag()).longValue() != paramChatMessage.time)
        {
          localObject1 = TimeFormatterUtils.a((Context)localObject1, 3, paramChatMessage.time * 1000L);
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        }
        TimestampReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
      else if (localViewHolder.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      paramOnLongClickAndTouchListener = a(paramChatMessage, localViewHolder, localViewHolder.jdField_a_of_type_AndroidViewView, (LinearLayout)paramView, paramOnLongClickAndTouchListener);
      if (paramOnLongClickAndTouchListener == null)
      {
        paramOnLongClickAndTouchListener = new StringBuilder();
        paramOnLongClickAndTouchListener.append("getItemView return null, builder: ");
        paramOnLongClickAndTouchListener.append(getClass());
        paramOnLongClickAndTouchListener.append(", position: ");
        paramOnLongClickAndTouchListener.append(paramInt1);
        paramOnLongClickAndTouchListener.append(", msgtype: ");
        paramOnLongClickAndTouchListener.append(paramChatMessage.msgtype);
        paramOnLongClickAndTouchListener = paramOnLongClickAndTouchListener.toString();
        new IllegalArgumentException(paramOnLongClickAndTouchListener);
        QLog.e("ChatItemBuilder", 1, paramOnLongClickAndTouchListener);
      }
      else if (localViewHolder.jdField_a_of_type_AndroidViewView != paramOnLongClickAndTouchListener)
      {
        if (localViewHolder.jdField_a_of_type_AndroidViewView != null) {
          ((ViewGroup)paramView).removeView(localViewHolder.jdField_a_of_type_AndroidViewView);
        }
        if (paramOnLongClickAndTouchListener.getLayoutParams() == null) {
          ((ViewGroup)paramView).addView(paramOnLongClickAndTouchListener, -1, -2);
        } else {
          ((ViewGroup)paramView).addView(paramOnLongClickAndTouchListener);
        }
        localViewHolder.jdField_a_of_type_AndroidViewView = paramOnLongClickAndTouchListener;
      }
      a(paramInt1, paramChatMessage, (MiniChatLinearLayout)paramView, paramViewGroup);
      return paramView;
    }
    catch (ClassCastException paramChatMessage)
    {
      if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("AbstractChatItemBuilder getview  e");
        paramViewGroup.append(paramChatMessage);
        paramViewGroup.append("position=");
        paramViewGroup.append(paramInt1);
        paramViewGroup.append("size=");
        paramViewGroup.append(this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount());
        QLog.d("ChatItemBuilder", 2, paramViewGroup.toString());
      }
    }
    return paramView;
  }
  
  protected abstract View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  protected abstract AbstractChatItemBuilder.ViewHolder a();
  
  public void a() {}
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131362480) {
      return;
    }
    a(paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage, MiniChatLinearLayout paramMiniChatLinearLayout, ViewGroup paramViewGroup)
  {
    AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
    int i;
    if ((localAIOLongShotHelper != null) && (localAIOLongShotHelper.a())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramMiniChatLinearLayout.setCheckBox(paramInt, paramChatMessage, paramMiniChatLinearLayout, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramViewGroup);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void a(ChatMessage paramChatMessage)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
    if ((localBaseActivity != null) && (localBaseActivity.getChatFragment() != null))
    {
      localObject = localBaseActivity.getChatFragment().a();
      ((AIOLongShotHelper)((BaseChatPie)localObject).a(15)).a(paramChatMessage);
      ((BaseChatPie)localObject).f(true);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", true);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClickScreenShot Error:");
    if (localBaseActivity != null) {
      paramChatMessage = localBaseActivity.toString();
    } else {
      paramChatMessage = "ca is null ";
    }
    ((StringBuilder)localObject).append(paramChatMessage);
    QLog.e("AbstractChatItemBuilder", 1, ((StringBuilder)localObject).toString());
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu)
  {
    paramQQCustomMenu.a(2131362480, this.jdField_a_of_type_AndroidContentContext.getString(2131689936), 2130838922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */