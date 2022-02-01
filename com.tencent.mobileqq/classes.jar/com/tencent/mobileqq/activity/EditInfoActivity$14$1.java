package com.tencent.mobileqq.activity;

import android.graphics.Color;
import android.widget.TextView;

class EditInfoActivity$14$1
  implements Runnable
{
  EditInfoActivity$14$1(EditInfoActivity.14 param14) {}
  
  public void run()
  {
    this.a.a.b.setText(this.a.a.c);
    this.a.a.b.setTextColor(Color.rgb(119, 119, 119));
    if (this.a.a.e)
    {
      this.a.a.rightViewText.setEnabled(true);
      return;
    }
    this.a.a.rightViewText.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.14.1
 * JD-Core Version:    0.7.0.1
 */