package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEClassManager
  extends QRouteApi
{
  public abstract Class getAECMShowQConfigProcessorClass();
  
  public abstract Class getAECoverSelectFragmentClass();
  
  public abstract Class getAEEditorActivityClass();
  
  public abstract Class getAEEditorDataServiceHandlerClass();
  
  public abstract Class getAEEditorEffectConfigProcessorClass();
  
  public abstract Class getAEPituCameraUnitClass();
  
  public abstract Class getArtFilterBridgeActivityClass();
  
  public abstract Class getCameraDataServiceClass();
  
  public abstract Class getCameraDataServiceHandlerClass();
  
  public abstract Class getCameraPeakServiceHandlerClass();
  
  public abstract Class getMusicProviderViewClass();
  
  public abstract Class getPeakServiceClass();
  
  public abstract Class getQIMCameraCaptureActivity();
  
  public abstract Class getQIMDoodleConfigProcessorClass();
  
  public abstract Class getQIMDynamicTextConfigProcessorClass();
  
  public abstract Class getQIMFilterConfigProcessorClass();
  
  public abstract Class getQIMMusicConfigProcessorClass();
  
  public abstract Class getQIMPasterConfigProcessorClass();
  
  public abstract Class getQIMTemplateConfigProcessorClass();
  
  public abstract Class getQIMTribeEffectsCameraCaptureUnitClass();
  
  public abstract Class getQIMWebEffectCameraCaptureUnitClass();
  
  public abstract Class getQzoneEditPictureActivityClass();
  
  public abstract Class getVideoPreviewFragmentClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.IAEClassManager
 * JD-Core Version:    0.7.0.1
 */