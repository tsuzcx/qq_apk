package com.tencent.biz.subscribe.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.colornote.ColorNoteCurd.OnColorNoteCurdListener;

class SubscribeHybirdFragment$3
  extends ColorNoteCurd.OnColorNoteCurdListener
{
  SubscribeHybirdFragment$3(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment.3
 * JD-Core Version:    0.7.0.1
 */