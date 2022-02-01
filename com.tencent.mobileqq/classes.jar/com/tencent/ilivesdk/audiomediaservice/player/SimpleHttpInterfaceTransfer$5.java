package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.base.libapi.http.DownloadCallback;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreDownloadCallback;
import java.io.File;

class SimpleHttpInterfaceTransfer$5
  implements DownloadCallback
{
  SimpleHttpInterfaceTransfer$5(SimpleHttpInterfaceTransfer paramSimpleHttpInterfaceTransfer, SimpleCoreDownloadCallback paramSimpleCoreDownloadCallback) {}
  
  public void onFail(int paramInt)
  {
    this.a.onFail(paramInt);
  }
  
  public void onProgress(long paramLong1, long paramLong2, int paramInt)
  {
    this.a.onProgress(paramLong1, paramLong2, paramInt);
  }
  
  public void onSuccess(File paramFile)
  {
    this.a.onSuccess(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.SimpleHttpInterfaceTransfer.5
 * JD-Core Version:    0.7.0.1
 */