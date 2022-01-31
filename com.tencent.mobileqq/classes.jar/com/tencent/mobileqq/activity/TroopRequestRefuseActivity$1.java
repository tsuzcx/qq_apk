package com.tencent.mobileqq.activity;

import android.graphics.Color;
import android.text.Editable;
import android.widget.TextView;

class TroopRequestRefuseActivity$1
  implements Runnable
{
  TroopRequestRefuseActivity$1(TroopRequestRefuseActivity paramTroopRequestRefuseActivity, Editable paramEditable) {}
  
  public void run()
  {
    if (this.a.length() > 25)
    {
      this.this$0.a.setTextColor(-65536);
      TroopRequestRefuseActivity.a(this.this$0, false);
    }
    for (;;)
    {
      String str2 = "" + (25 - this.a.length());
      String str1 = str2;
      if (str2.length() > 4) {
        str1 = str2.substring(0, 2) + "…";
      }
      this.this$0.a.setText(str1);
      return;
      this.this$0.a.setTextColor(Color.rgb(119, 119, 119));
      TroopRequestRefuseActivity.b(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestRefuseActivity.1
 * JD-Core Version:    0.7.0.1
 */