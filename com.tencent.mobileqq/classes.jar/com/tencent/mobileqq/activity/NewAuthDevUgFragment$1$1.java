package com.tencent.mobileqq.activity;

import adrw;
import android.support.v4.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;

public class NewAuthDevUgFragment$1$1
  implements Runnable
{
  public NewAuthDevUgFragment$1$1(adrw paramadrw) {}
  
  public void run()
  {
    if (this.a.a.getActivity() == null)
    {
      QLog.d("NewAuthDevUgFragment", 1, "activity is null");
      return;
    }
    this.a.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewAuthDevUgFragment.1.1
 * JD-Core Version:    0.7.0.1
 */