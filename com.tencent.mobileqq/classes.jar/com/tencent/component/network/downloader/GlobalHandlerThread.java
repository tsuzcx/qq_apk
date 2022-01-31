package com.tencent.component.network.downloader;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class GlobalHandlerThread
{
  private static volatile GlobalHandlerThread jdField_a_of_type_ComTencentComponentNetworkDownloaderGlobalHandlerThread = null;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  
  private GlobalHandlerThread(Context paramContext)
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("download_async");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return;
    }
    catch (Exception paramContext)
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
  }
  
  public static GlobalHandlerThread a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentComponentNetworkDownloaderGlobalHandlerThread == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentComponentNetworkDownloaderGlobalHandlerThread == null) {
        jdField_a_of_type_ComTencentComponentNetworkDownloaderGlobalHandlerThread = new GlobalHandlerThread(paramContext);
      }
      return jdField_a_of_type_ComTencentComponentNetworkDownloaderGlobalHandlerThread;
    }
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.GlobalHandlerThread
 * JD-Core Version:    0.7.0.1
 */