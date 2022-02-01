package com.tencent.mobileqq.activity.bless;

import android.text.Layout;
import android.text.TextPaint;
import android.widget.TextView;
import java.util.ArrayList;

class BlessSelectMemberActivity$4
  implements Runnable
{
  BlessSelectMemberActivity$4(BlessSelectMemberActivity paramBlessSelectMemberActivity, TextView paramTextView, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    int i = 0;
    String str1;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getLineCount() >= 4)
    {
      int j = this.jdField_a_of_type_AndroidWidgetTextView.getLayout().getLineEnd(3);
      if (j < this.jdField_a_of_type_JavaLangStringBuilder.length())
      {
        str1 = String.format(this.this$0.getString(2131690566), new Object[] { "...", Integer.valueOf(this.this$0.a.size()) });
        float f = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(str1);
        if (i < this.jdField_a_of_type_JavaLangStringBuilder.length())
        {
          String str2 = this.jdField_a_of_type_JavaLangStringBuilder.substring(j - i, j);
          if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(str2) < f) {
            break label233;
          }
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(j - i);
        }
        BlessSelectMemberActivity.a(this.this$0, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        if (!BlessSelectMemberActivity.b(this.this$0).endsWith("、 ")) {
          break label240;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(this.jdField_a_of_type_JavaLangStringBuilder.length() - 2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(str1);
      BlessSelectMemberActivity.a(this.this$0, this.jdField_a_of_type_JavaLangStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(null);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(BlessSelectMemberActivity.b(this.this$0));
      return;
      label233:
      i += 1;
      break;
      label240:
      if (BlessSelectMemberActivity.b(this.this$0).endsWith("、")) {
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(this.jdField_a_of_type_JavaLangStringBuilder.length() - 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity.4
 * JD-Core Version:    0.7.0.1
 */