package com.tencent.mobileqq.app.activateFriends;

import aael;
import aaes;
import ajvl;
import ajvm;
import ajvp;
import android.os.Bundle;
import babh;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class ActivateFriendsManager$3
  implements Runnable
{
  public ActivateFriendsManager$3(ajvm paramajvm, int paramInt1, long[] paramArrayOfLong1, String paramString, int paramInt2, long[] paramArrayOfLong2) {}
  
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
        localSessionInfo.d = babh.m(ajvm.a(this.this$0), String.valueOf(l));
        localaaes = new aaes();
        localaaes.a = false;
        aael.a(ajvm.a(this.this$0), ajvm.a(this.this$0).getApp(), localSessionInfo, this.jdField_a_of_type_JavaLangString, null, localaaes);
        i += 1;
      }
      this.this$0.a(this.jdField_a_of_type_ArrayOfLong, 1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_rt_type", 0);
      ajvm.a(this.this$0).notifyObservers(ajvp.class, 113, true, (Bundle)localObject);
    }
    while ((this.jdField_a_of_type_Int != 2) || (this.jdField_b_of_type_Int == -1) || (ajvl.a(ajvm.a(this.this$0), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfLong, this.jdField_b_of_type_ArrayOfLong, this.jdField_b_of_type_Int)))
    {
      int j;
      int i;
      long l;
      SessionInfo localSessionInfo;
      aaes localaaes;
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_rt_type", 2);
    ajvm.a(this.this$0).notifyObservers(ajvp.class, 113, false, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.3
 * JD-Core Version:    0.7.0.1
 */