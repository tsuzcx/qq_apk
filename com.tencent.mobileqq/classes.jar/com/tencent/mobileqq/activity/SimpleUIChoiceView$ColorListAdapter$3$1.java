package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.theme.DarkModeManager.ActionResult;

class SimpleUIChoiceView$ColorListAdapter$3$1
  implements DarkModeManager.ActionResult
{
  SimpleUIChoiceView$ColorListAdapter$3$1(SimpleUIChoiceView.ColorListAdapter.3 param3) {}
  
  public void onCancel() {}
  
  public void onConfirm()
  {
    if (SimpleUIChoiceView.c(this.a.b.b) != null) {
      SimpleUIChoiceView.c(this.a.b.b).a();
    }
    SimpleUIChoiceView.ColorListAdapter.a(this.a.b, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView.ColorListAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */