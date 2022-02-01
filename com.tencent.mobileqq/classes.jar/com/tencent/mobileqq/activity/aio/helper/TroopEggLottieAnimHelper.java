package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
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
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((BaseChatPie)localObject).f.getIntent().getStringExtra("chat_inputBarContent");
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      this.a.Y.setText((CharSequence)localObject);
      this.a.Y.requestFocus();
      InputMethodManager localInputMethodManager = (InputMethodManager)this.a.f.getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(this.a.Y, 1);
      }
      this.a.Y.post(new TroopEggLottieAnimHelper.1(this, (String)localObject));
    }
  }
  
  public String getTag()
  {
    return "TroopEggLottieAnimHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 8) {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopEggLottieAnimHelper
 * JD-Core Version:    0.7.0.1
 */