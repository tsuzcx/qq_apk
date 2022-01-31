package com.tencent.mobileqq.adapter;

import aiba;
import android.os.Handler;
import atay;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import mmy;

public class LebaListViewAdapter$3
  implements Runnable
{
  public LebaListViewAdapter$3(aiba paramaiba, Handler paramHandler, RedTouch paramRedTouch) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = (mmy)this.this$0.a.getManager(70);
    localObject = ((mmy)localObject).a(((mmy)localObject).a(), false);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.redpoint", 2, "updateNearbyRedPointAsync, getNearbyRedPoint costTime=" + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new LebaListViewAdapter.3.1(this, (atay)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.LebaListViewAdapter.3
 * JD-Core Version:    0.7.0.1
 */