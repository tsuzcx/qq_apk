package com.tencent.mobileqq.ar.arengine;

public abstract interface ARCloudPretreatmentManager$ARCloudPretreatmentCallback
{
  public abstract void a(int paramInt, ARCloudReqFileInfo paramARCloudReqFileInfo, long paramLong);
  
  public abstract void a(ARCloudRecogReqFaceInfo paramARCloudRecogReqFaceInfo);
  
  public abstract void a(ARCloudRecogReqObjectClassifyInfo paramARCloudRecogReqObjectClassifyInfo);
  
  public abstract void a(ARCloudRecogReqPreOcrInfo paramARCloudRecogReqPreOcrInfo);
  
  public abstract void a(ARCloudRecogReqSceneRecogInfo paramARCloudRecogReqSceneRecogInfo);
  
  public abstract void a(ARCloudReqMarkerInfo paramARCloudReqMarkerInfo);
  
  public abstract void b(ARCloudRecogReqObjectClassifyInfo paramARCloudRecogReqObjectClassifyInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.ARCloudPretreatmentCallback
 * JD-Core Version:    0.7.0.1
 */