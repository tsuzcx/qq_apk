package com.tencent.mobileqq.app.activateFriends;

import acjm;
import acjt;
import amfz;
import amga;
import amgd;
import android.os.Bundle;
import bdgc;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class ActivateFriendsManager$3
  implements Runnable
{
  public ActivateFriendsManager$3(amga paramamga, int paramInt1, long[] paramArrayOfLong1, String paramString, int paramInt2, long[] paramArrayOfLong2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      localObject = this.jdField_a_of_type_ArrayOfLong;
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        l = localObject[i];
        localSessionInfo = new SessionInfo();
        localSessionInfo.jdField_a_of_type_JavaLangString = String.valueOf(l);
        localSessionInfo.jdField_a_of_type_Int = 0;
        localSessionInfo.d = bdgc.m(amga.a(this.this$0), String.valueOf(l));
        localacjt = new acjt();
        localacjt.a = false;
        acjm.a(amga.a(this.this$0), amga.a(this.this$0).getApp(), localSessionInfo, this.jdField_a_of_type_JavaLangString, null, localacjt);
        i += 1;
      }
      this.this$0.a(this.jdField_a_of_type_ArrayOfLong, 1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_rt_type", 0);
      amga.a(this.this$0).notifyObservers(amgd.class, 113, true, (Bundle)localObject);
    }
    while ((this.jdField_a_of_type_Int != 2) || (this.jdField_b_of_type_Int == -1) || (amfz.a(amga.a(this.this$0), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfLong, this.jdField_b_of_type_ArrayOfLong, this.jdField_b_of_type_Int)))
    {
      int j;
      int i;
      long l;
      SessionInfo localSessionInfo;
      acjt localacjt;
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_rt_type", 2);
    amga.a(this.this$0).notifyObservers(amgd.class, 113, false, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.3
 * JD-Core Version:    0.7.0.1
 */