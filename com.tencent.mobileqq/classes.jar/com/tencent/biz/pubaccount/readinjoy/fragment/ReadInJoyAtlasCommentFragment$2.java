package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import vms;

class ReadInJoyAtlasCommentFragment$2
  implements Runnable
{
  ReadInJoyAtlasCommentFragment$2(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void run()
  {
    if ((!this.this$0.a) && (this.this$0.getView() != null))
    {
      int i = this.this$0.getView().getHeight() - vms.e(this.this$0.getActivity());
      View localView = this.this$0.getView().findViewById(2131309040);
      if (localView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        if ((localLayoutParams != null) && (i > 0))
        {
          localLayoutParams.height = i;
          localView.setLayoutParams(localLayoutParams);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment.2
 * JD-Core Version:    0.7.0.1
 */