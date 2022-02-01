package com.tencent.biz.subscribe.fragments;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;

class SubscribeBaseFragment$3
  implements OnColorNoteAnimFinishListener
{
  SubscribeBaseFragment$3(SubscribeBaseFragment paramSubscribeBaseFragment) {}
  
  public void onColorNoteAnimFinish()
  {
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */