package com.tencent.ilivesdk.coverservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface CoverServiceInterface
  extends ServiceBaseInterface
{
  public abstract void UploadCover(String paramString1, String paramString2, String paramString3, UploadCoverCallback paramUploadCoverCallback);
  
  public abstract void init(CoverServiceAdapter paramCoverServiceAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.coverservice_interface.CoverServiceInterface
 * JD-Core Version:    0.7.0.1
 */