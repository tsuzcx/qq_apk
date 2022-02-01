package com.tencent.ilivesdk.avplayerservice;

import com.tencent.falco.base.libapi.http.DownloadCallback;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreDownloadCallback;
import java.io.File;

class SimpleHttpInterfaceTransfer$6
  implements DownloadCallback
{
  SimpleHttpInterfaceTransfer$6(SimpleHttpInterfaceTransfer paramSimpleHttpInterfaceTransfer, SimpleCoreDownloadCallback paramSimpleCoreDownloadCallback) {}
  
  public void onFail(int paramInt)
  {
    SimpleCoreDownloadCallback localSimpleCoreDownloadCallback = this.jdField_a_of_type_ComTencentIliveOpensdkReporterinterfaceSimpleCoreDownloadCallback;
    if (localSimpleCoreDownloadCallback != null) {
      localSimpleCoreDownloadCallback.onFail(paramInt);
    }
  }
  
  public void onProgress(long paramLong1, long paramLong2, int paramInt)
  {
    SimpleCoreDownloadCallback localSimpleCoreDownloadCallback = this.jdField_a_of_type_ComTencentIliveOpensdkReporterinterfaceSimpleCoreDownloadCallback;
    if (localSimpleCoreDownloadCallback != null) {
      localSimpleCoreDownloadCallback.onProgress(paramLong1, paramLong2, paramInt);
    }
  }
  
  public void onSuccess(File paramFile)
  {
    SimpleCoreDownloadCallback localSimpleCoreDownloadCallback = this.jdField_a_of_type_ComTencentIliveOpensdkReporterinterfaceSimpleCoreDownloadCallback;
    if (localSimpleCoreDownloadCallback != null) {
      localSimpleCoreDownloadCallback.onSuccess(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.SimpleHttpInterfaceTransfer.6
 * JD-Core Version:    0.7.0.1
 */