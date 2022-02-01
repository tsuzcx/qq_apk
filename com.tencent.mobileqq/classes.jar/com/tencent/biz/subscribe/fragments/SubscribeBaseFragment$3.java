package com.tencent.biz.subscribe.fragments;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;

class SubscribeBaseFragment$3
  implements OnColorNoteAnimFinishListener
{
  SubscribeBaseFragment$3(SubscribeBaseFragment paramSubscribeBaseFragment) {}
  
  public void onColorNoteAnimFinish()
  {
    if (this.a.getBaseActivity() != null)
    {
      this.a.getBaseActivity().finish();
      this.a.getBaseActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */