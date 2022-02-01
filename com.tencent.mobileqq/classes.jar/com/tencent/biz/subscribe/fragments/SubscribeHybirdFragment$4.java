package com.tencent.biz.subscribe.fragments;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;

class SubscribeHybirdFragment$4
  extends OnColorNoteCurdListener
{
  SubscribeHybirdFragment$4(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    if (this.a.getQBaseActivity() != null)
    {
      this.a.getQBaseActivity().finish();
      this.a.getQBaseActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment.4
 * JD-Core Version:    0.7.0.1
 */