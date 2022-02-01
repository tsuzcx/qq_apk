package com.tencent.biz.qqcircle.utils;

import java.util.concurrent.ThreadFactory;

final class QCircleThreadManager$1
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("data-parser-pool-");
    localStringBuilder.append(paramRunnable.getId());
    paramRunnable.setName(localStringBuilder.toString());
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleThreadManager.1
 * JD-Core Version:    0.7.0.1
 */