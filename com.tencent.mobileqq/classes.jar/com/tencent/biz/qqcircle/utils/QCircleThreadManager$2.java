package com.tencent.biz.qqcircle.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

class QCircleThreadManager$2
  implements RejectedExecutionHandler
{
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    QLog.e("QCircleOptimizeAsyncHandlerUtils", 1, "postDataParserThreadPoolExecutor hit max size limit!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleThreadManager.2
 * JD-Core Version:    0.7.0.1
 */