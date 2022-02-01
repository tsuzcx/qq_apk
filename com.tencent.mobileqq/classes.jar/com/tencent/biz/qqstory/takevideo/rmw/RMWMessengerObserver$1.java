package com.tencent.biz.qqstory.takevideo.rmw;

import android.os.IBinder.DeathRecipient;

class RMWMessengerObserver$1
  implements IBinder.DeathRecipient
{
  public void binderDied()
  {
    RMWLog.c(this.a.jdField_a_of_type_JavaLangString, "binderDied");
    this.a.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWMessengerObserver.1
 * JD-Core Version:    0.7.0.1
 */