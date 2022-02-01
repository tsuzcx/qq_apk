package com.tencent.mobileqq.activity.contacts.publicaccount;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicAccountSearchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountFragment$4
  implements View.OnClickListener
{
  PublicAccountFragment$4(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void onClick(View paramView)
  {
    PublicAccountSearchActivity.a(PublicAccountFragment.d(this.a), null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.4
 * JD-Core Version:    0.7.0.1
 */