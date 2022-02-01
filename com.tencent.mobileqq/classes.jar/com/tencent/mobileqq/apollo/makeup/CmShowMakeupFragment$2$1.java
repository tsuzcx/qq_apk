package com.tencent.mobileqq.apollo.makeup;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQToast;

class CmShowMakeupFragment$2$1
  implements Runnable
{
  CmShowMakeupFragment$2$1(CmShowMakeupFragment.2 param2, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowMakeupFragment$2.a.getActivity() != null)
    {
      FragmentActivity localFragmentActivity = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowMakeupFragment$2.a.getActivity();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(CmShowErrorCode.a(this.jdField_a_of_type_Int));
      localStringBuilder.append("[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("]");
      QQToast.a(localFragmentActivity, 1, localStringBuilder.toString(), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.2.1
 * JD-Core Version:    0.7.0.1
 */