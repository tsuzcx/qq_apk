package com.tencent.mobileqq.activity.contacts.publicaccount;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class PublicAccountFragment$6
  implements ThreadExcutor.IThreadListener
{
  PublicAccountFragment$6(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    ThreadManager.getUIHandler().post(new PublicAccountFragment.6.1(this));
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.6
 * JD-Core Version:    0.7.0.1
 */