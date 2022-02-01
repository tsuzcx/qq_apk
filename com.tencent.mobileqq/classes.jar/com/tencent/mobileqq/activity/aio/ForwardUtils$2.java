package com.tencent.mobileqq.activity.aio;

import aklj;
import com.tencent.mobileqq.app.QQAppInterface;

final class ForwardUtils$2
  implements Runnable
{
  ForwardUtils$2(String paramString, SessionInfo paramSessionInfo, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.val$photoUrl;
    int i = this.val$sessionInfo.curType;
    int j = this.val$forwardSourceUinType;
    QQAppInterface localQQAppInterface = this.val$app;
    aklj.a(new String[] { str }, i, false, true, j, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.2
 * JD-Core Version:    0.7.0.1
 */