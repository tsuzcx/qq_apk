package com.tencent.mobileqq.activity.aio;

import ajpv;
import com.tencent.mobileqq.app.QQAppInterface;

final class ForwardUtils$3
  implements Runnable
{
  ForwardUtils$3(String paramString, SessionInfo paramSessionInfo, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.val$photoUrl;
    int i = this.val$sessionInfo.curType;
    int j = this.val$forwardSourceUinType;
    QQAppInterface localQQAppInterface = this.val$app;
    ajpv.a(new String[] { str }, i, false, true, j, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.3
 * JD-Core Version:    0.7.0.1
 */