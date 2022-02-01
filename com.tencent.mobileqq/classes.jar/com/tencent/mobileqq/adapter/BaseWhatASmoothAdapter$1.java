package com.tencent.mobileqq.adapter;

import android.view.View;

class BaseWhatASmoothAdapter$1
  implements Runnable
{
  BaseWhatASmoothAdapter$1(BaseWhatASmoothAdapter paramBaseWhatASmoothAdapter, View paramView, Object paramObject1, Object paramObject2, int paramInt, BaseWhatASmoothAdapter.RunningMark paramRunningMark) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      Object localObject2 = this.b;
      if ((localObject2 != null) && ((localObject2.equals(localObject1)) || (localObject1 == null)))
      {
        this.this$0.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangObject);
        localObject1 = this.jdField_a_of_type_AndroidViewView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.this$0.a);
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        ((View)localObject1).setTag(((StringBuilder)localObject2).toString());
      }
    }
    BaseWhatASmoothAdapter.RunningMark.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBaseWhatASmoothAdapter$RunningMark, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter.1
 * JD-Core Version:    0.7.0.1
 */