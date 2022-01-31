package com.tencent.biz.qqcircle;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public final class QCircleUtil$1
  implements Runnable
{
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof QQAppInterface));
      localObject = (WebProcessManager)((QQAppInterface)localObject).getManager(13);
    } while (localObject == null);
    ((WebProcessManager)localObject).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleUtil.1
 * JD-Core Version:    0.7.0.1
 */