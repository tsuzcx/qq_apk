package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;

public class TroopEggLottieAnimHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  
  public TroopEggLottieAnimHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    if (this.a == null) {}
    String str;
    do
    {
      return;
      str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("chat_inputBarContent");
    } while ((str == null) || (str.isEmpty()));
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(str);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
    InputMethodManager localInputMethodManager = (InputMethodManager)this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, 1);
    }
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.post(new TroopEggLottieAnimHelper.1(this, str));
  }
  
  public String getTag()
  {
    return "TroopEggLottieAnimHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopEggLottieAnimHelper
 * JD-Core Version:    0.7.0.1
 */