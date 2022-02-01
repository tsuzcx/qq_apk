package com.tencent.mobileqq.activity.contacts.publicaccount;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class PublicAccountFragment$5
  implements ThreadExcutor.IThreadListener
{
  PublicAccountFragment$5(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    ThreadManager.getUIHandler().post(new PublicAccountFragment.5.1(this));
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.5
 * JD-Core Version:    0.7.0.1
 */