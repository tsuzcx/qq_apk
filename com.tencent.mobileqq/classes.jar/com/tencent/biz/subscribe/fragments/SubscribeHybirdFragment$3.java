package com.tencent.biz.subscribe.fragments;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;

class SubscribeHybirdFragment$3
  implements OnColorNoteAnimFinishListener
{
  SubscribeHybirdFragment$3(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public void onColorNoteAnimFinish()
  {
    if (this.a.getQBaseActivity() != null)
    {
      this.a.getQBaseActivity().finish();
      this.a.getQBaseActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment.3
 * JD-Core Version:    0.7.0.1
 */