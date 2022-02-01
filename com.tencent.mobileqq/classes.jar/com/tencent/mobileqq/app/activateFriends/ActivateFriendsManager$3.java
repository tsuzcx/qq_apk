package com.tencent.mobileqq.app.activateFriends;

import acvv;
import acwc;
import android.os.Bundle;
import anen;
import aneo;
import anep;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;

public class ActivateFriendsManager$3
  implements Runnable
{
  public ActivateFriendsManager$3(aneo paramaneo, int paramInt1, long[] paramArrayOfLong1, String paramString, int paramInt2, long[] paramArrayOfLong2) {}
  
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
        localSessionInfo.curFriendUin = String.valueOf(l);
        localSessionInfo.curType = 0;
        localSessionInfo.curFriendNick = ContactUtils.getFriendShowName(aneo.a(this.this$0), String.valueOf(l));
        localacwc = new acwc();
        localacwc.a = false;
        acvv.a(aneo.a(this.this$0), aneo.a(this.this$0).getApp(), localSessionInfo, this.jdField_a_of_type_JavaLangString, null, localacwc);
        i += 1;
      }
      this.this$0.a(this.jdField_a_of_type_ArrayOfLong, 1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_rt_type", 0);
      aneo.a(this.this$0).notifyObservers(anep.class, 113, true, (Bundle)localObject);
    }
    while ((this.jdField_a_of_type_Int != 2) || (this.jdField_b_of_type_Int == -1) || (anen.a(aneo.a(this.this$0), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfLong, this.jdField_b_of_type_ArrayOfLong, this.jdField_b_of_type_Int)))
    {
      int j;
      int i;
      long l;
      SessionInfo localSessionInfo;
      acwc localacwc;
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_rt_type", 2);
    aneo.a(this.this$0).notifyObservers(anep.class, 113, false, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.3
 * JD-Core Version:    0.7.0.1
 */