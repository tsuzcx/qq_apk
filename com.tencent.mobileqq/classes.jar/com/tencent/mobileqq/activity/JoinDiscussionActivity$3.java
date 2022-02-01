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
    Object localObject1 = StringUtil.a(this.this$0.c, 0, 32);
    String str = StringUtil.a(this.this$0.e, 0, 32);
    if (this.this$0.jdField_a_of_type_JavaUtilList != null)
    {
      localObject2 = this.this$0.jdField_a_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(String.format("(%d人)", new Object[] { Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()) }));
      ((TextView)localObject2).setText(localStringBuilder.toString());
    }
    else
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    }
    localObject1 = this.this$0.jdField_b_of_type_AndroidWidgetTextView;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131705953));
    ((StringBuilder)localObject2).append(DateFormat.format("yy-M-d", this.this$0.jdField_b_of_type_Long));
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity.3
 * JD-Core Version:    0.7.0.1
 */