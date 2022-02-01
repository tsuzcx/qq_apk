package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOCheckBoxUtil;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class MiniChatLinearLayout
  extends LinearLayout
  implements IChatShieldClick
{
  protected boolean a;
  protected boolean b;
  private CheckBox c;
  
  public MiniChatLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return true;
    }
    if (BaseChatItemLayout.ad) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return true;
    }
    if (BaseChatItemLayout.ad)
    {
      AIOCheckBoxUtil.a(this, paramMotionEvent);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckBox(int paramInt, ChatMessage paramChatMessage, MiniChatLinearLayout paramMiniChatLinearLayout, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ViewGroup paramViewGroup)
  {
    if (BaseChatItemLayout.ad)
    {
      if (this.c == null)
      {
        this.c = new CheckBox(getContext());
        this.c.setButtonDrawable(null);
        this.c.setId(2131430605);
        this.c.setOnCheckedChangeListener(BaseChatItemLayout.ao);
        paramMiniChatLinearLayout = new LinearLayout.LayoutParams(1, 1);
        addView(this.c, paramMiniChatLinearLayout);
      }
      else
      {
        paramMiniChatLinearLayout = new LinearLayout.LayoutParams(1, 1);
        this.c.setLayoutParams(paramMiniChatLinearLayout);
      }
      this.c.setTag(paramChatMessage);
      paramMiniChatLinearLayout = AIOLongShotHelper.f();
      if ((paramMiniChatLinearLayout != null) && (paramMiniChatLinearLayout.c())) {
        this.c.setChecked(paramMiniChatLinearLayout.a(paramChatMessage));
      }
    }
    paramChatMessage = this.c;
    if (paramChatMessage != null) {
      paramChatMessage.setVisibility(8);
    }
  }
  
  public void setFrom(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setIsShieldTouchForItem(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatLinearLayout
 * JD-Core Version:    0.7.0.1
 */