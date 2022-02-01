package com.tencent.mobileqq.activity.miniaio;

import agdv;
import akkq;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class MiniChatLinearLayout
  extends LinearLayout
  implements akkq
{
  private CheckBox a;
  protected boolean a;
  protected boolean b;
  
  public MiniChatLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (BaseChatItemLayout.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    if (BaseChatItemLayout.jdField_a_of_type_Boolean)
    {
      agdv.a(this, paramMotionEvent);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckBox(int paramInt, ChatMessage paramChatMessage, MiniChatLinearLayout paramMiniChatLinearLayout, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ViewGroup paramViewGroup)
  {
    if (BaseChatItemLayout.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetCheckBox != null) {
        break label126;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(getContext());
      this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(null);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setId(2131364449);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(BaseChatItemLayout.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      paramMiniChatLinearLayout = new LinearLayout.LayoutParams(1, 1);
      addView(this.jdField_a_of_type_AndroidWidgetCheckBox, paramMiniChatLinearLayout);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramChatMessage);
      paramMiniChatLinearLayout = AIOLongShotHelper.a();
      if ((paramMiniChatLinearLayout != null) && (paramMiniChatLinearLayout.a())) {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramMiniChatLinearLayout.a(paramChatMessage));
      }
      if (this.jdField_a_of_type_AndroidWidgetCheckBox != null) {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
      return;
      label126:
      paramMiniChatLinearLayout = new LinearLayout.LayoutParams(1, 1);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams(paramMiniChatLinearLayout);
    }
  }
  
  public void setFrom(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setIsShieldTouchForItem(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatLinearLayout
 * JD-Core Version:    0.7.0.1
 */