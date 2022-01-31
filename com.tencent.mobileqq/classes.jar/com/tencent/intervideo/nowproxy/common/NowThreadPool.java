package com.tencent.intervideo.nowproxy.common;

public class NowThreadPool
{
  public static NowThreadPool.ThreadPoolProvider sThreadPoolProvider = new NowThreadPool.1();
  
  public static void setThreadPoolProvider(NowThreadPool.ThreadPoolProvider paramThreadPoolProvider)
  {
    sThreadPoolProvider = paramThreadPoolProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.NowThreadPool
 * JD-Core Version:    0.7.0.1
 */