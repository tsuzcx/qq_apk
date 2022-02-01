package com.tencent.mobileqq.bigbrother;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.QFragmentActivity;
import com.tencent.mobileqq.haoliyou.JefsClass;

class JumpConfirmFragment$3
  implements DialogInterface.OnDismissListener
{
  JumpConfirmFragment$3(JumpConfirmFragment paramJumpConfirmFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    JefsClass.getInstance().b(JumpConfirmFragment.a(this.a), JumpConfirmFragment.a(this.a), JumpConfirmFragment.b(this.a));
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.JumpConfirmFragment.3
 * JD-Core Version:    0.7.0.1
 */