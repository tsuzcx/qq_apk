package com.tencent.component.network.module.base;

import com.tencent.component.network.downloader.strategy.KeepAliveStrategy.KeepAlive;

public class Const
{
  public static final long CONN_CLEAN_PERIOD_MILLIS = 30000L;
  public static final long DEFAULT_IP_VALID_TIME = 604800000L;
  public static final KeepAliveStrategy.KeepAlive DEFAULT_KEEP_ALIVE = KeepAliveStrategy.KeepAlive.DISABLE;
  public static final KeepAliveStrategy.KeepAlive DEFAULT_KEEP_ALIVE_PROXY = KeepAliveStrategy.KeepAlive.DISABLE;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_DISABLE = 1;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_ENABLE = 0;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_IGNORE = 2;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.base.Const
 * JD-Core Version:    0.7.0.1
 */