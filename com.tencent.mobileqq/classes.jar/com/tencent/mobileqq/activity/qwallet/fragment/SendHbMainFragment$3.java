package com.tencent.mobileqq.activity.qwallet.fragment;

import android.view.View;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class SendHbMainFragment$3
  implements Runnable
{
  SendHbMainFragment$3(SendHbMainFragment paramSendHbMainFragment, View paramView, int paramInt) {}
  
  public void run()
  {
    int i = ImmersiveUtils.getStatusBarHeight(this.this$0.mActivity);
    SendHbMainFragment.a(this.this$0).setFitsSystemWindows(true);
    SendHbMainFragment.a(this.this$0).setPadding(0, i, 0, 0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131303730).setFitsSystemWindows(true);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131303730).setPadding(0, i, 0, 0);
    if (QLog.isColorLevel()) {
      QLog.i("SendHbMainFragment", 2, "initImmersive:" + this.jdField_a_of_type_Int + " barHeight: " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment.3
 * JD-Core Version:    0.7.0.1
 */