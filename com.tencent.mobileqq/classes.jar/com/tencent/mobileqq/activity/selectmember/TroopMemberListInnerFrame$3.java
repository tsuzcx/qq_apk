package com.tencent.mobileqq.activity.selectmember;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class TroopMemberListInnerFrame$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TroopMemberListInnerFrame$3(TroopMemberListInnerFrame paramTroopMemberListInnerFrame, ViewGroup paramViewGroup) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.c);
    Bitmap localBitmap = TroopMemberListInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.c);
    if (localBitmap == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.c.setTag(localBitmap);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.a == null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame.3
 * JD-Core Version:    0.7.0.1
 */