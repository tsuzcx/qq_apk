package com.tencent.mobileqq.app;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_PAIR.sweet_pair_check_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class LoveZoneInfoHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  protected LoveZoneInfoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.a = ((QQAppInterface)paramAppInterface);
    }
  }
  
  protected LoveZoneInfoHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.a;
    if ((localObject != null) && (paramLong > 0L))
    {
      localObject = ((QQAppInterface)localObject).getPreferences();
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putLong("love_uin_for_current_user", paramLong).apply();
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getPreferences();
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("love_state_for_current_uin");
        localStringBuilder.append(this.a.getCurrentUin());
        ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt).apply();
      }
    }
    notifyUI(1, true, Integer.valueOf(paramInt));
  }
  
  public void a(boolean paramBoolean, sweet_pair_check_rsp paramsweet_pair_check_rsp)
  {
    if ((paramBoolean) && (paramsweet_pair_check_rsp != null))
    {
      int i;
      if (paramsweet_pair_check_rsp.host_state == 3) {
        i = 1;
      } else {
        i = 0;
      }
      a(i);
      if (paramsweet_pair_check_rsp.req_comm != null) {
        a(paramsweet_pair_check_rsp.req_comm.loveuin);
      }
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return LoveZoneInfoObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.LoveZoneInfoHandler
 * JD-Core Version:    0.7.0.1
 */