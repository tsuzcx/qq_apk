package com.tencent.mobileqq.activity;

import android.text.format.DateFormat;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;

class JoinDiscussionActivity$3
  implements Runnable
{
  JoinDiscussionActivity$3(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  public void run()
  {
    String str1 = StringUtil.a(this.this$0.c, 0, 32);
    String str2 = StringUtil.a(this.this$0.e, 0, 32);
    if (this.this$0.jdField_a_of_type_JavaUtilList != null) {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(str1 + String.format("(%d人)", new Object[] { Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()) }));
    }
    for (;;)
    {
      this.this$0.jdField_b_of_type_AndroidWidgetTextView.setText(str2 + HardCodeUtil.a(2131705901) + DateFormat.format("yy-M-d", this.this$0.jdField_b_of_type_Long));
      return;
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity.3
 * JD-Core Version:    0.7.0.1
 */