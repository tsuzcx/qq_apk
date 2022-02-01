package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import com.tencent.mobileqq.widget.FormSimpleItem;
import java.lang.ref.WeakReference;

class LoginInfoActivity$RefreshPIMStatus
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private WeakReference<FormSimpleItem> jdField_a_of_type_JavaLangRefWeakReference;
  
  public LoginInfoActivity$RefreshPIMStatus(int paramInt, WeakReference<FormSimpleItem> paramWeakReference)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localFormSimpleItem != null) {
        localFormSimpleItem.setRightText(localFormSimpleItem.getResources().getString(this.jdField_a_of_type_Int));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.RefreshPIMStatus
 * JD-Core Version:    0.7.0.1
 */