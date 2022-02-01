package com.tencent.mobileqq.activity.messagesearch;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

class BaseMessageSearchDialog$1
  implements Runnable
{
  BaseMessageSearchDialog$1(BaseMessageSearchDialog paramBaseMessageSearchDialog, View paramView, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen((int[])localObject);
    int i = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rootView post : x -> ");
      localStringBuilder.append(localObject[0]);
      localStringBuilder.append(", y -> ");
      localStringBuilder.append(localObject[1]);
      localStringBuilder.append(", notchHeight -> ");
      localStringBuilder.append(i);
      QLog.d("BaseMessageSearchDialog", 2, localStringBuilder.toString());
    }
    if (localObject[1] < i)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), i, this.jdField_a_of_type_AndroidViewView.getPaddingRight(), this.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    }
    BaseAIOUtils.a(this.this$0.findViewById(2131366333));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.BaseMessageSearchDialog.1
 * JD-Core Version:    0.7.0.1
 */