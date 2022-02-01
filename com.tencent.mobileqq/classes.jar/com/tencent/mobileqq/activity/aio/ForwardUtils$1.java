package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;

final class ForwardUtils$1
  implements Runnable
{
  ForwardUtils$1(String paramString, SessionInfo paramSessionInfo, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.a;
    int i = this.b.a;
    int j = this.c;
    QQAppInterface localQQAppInterface = this.d;
    StatisticConstants.a(new String[] { str }, i, false, true, j, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.1
 * JD-Core Version:    0.7.0.1
 */