package com.tencent.mobileqq.apollo.makeup;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQToast;

class CmShowMakeupFragment$2$1
  implements Runnable
{
  CmShowMakeupFragment$2$1(CmShowMakeupFragment.2 param2, int paramInt) {}
  
  public void run()
  {
    if (this.b.a.getActivity() != null)
    {
      FragmentActivity localFragmentActivity = this.b.a.getActivity();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(CmShowErrorCode.a(this.a));
      localStringBuilder.append("[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QQToast.makeText(localFragmentActivity, 1, localStringBuilder.toString(), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.2.1
 * JD-Core Version:    0.7.0.1
 */