package com.tencent.mobileqq.adapter;

import alid;
import alie;
import android.view.View;

public class BaseWhatASmoothAdapter$1
  implements Runnable
{
  public BaseWhatASmoothAdapter$1(alid paramalid, View paramView, Object paramObject1, Object paramObject2, int paramInt, alie paramalie) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((this.jdField_a_of_type_JavaLangObject != null) && (this.b != null) && ((this.b.equals(localObject)) || (localObject == null)))
    {
      this.this$0.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidViewView.setTag(this.this$0.a + this.jdField_a_of_type_Int);
    }
    alie.a(this.jdField_a_of_type_Alie, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter.1
 * JD-Core Version:    0.7.0.1
 */