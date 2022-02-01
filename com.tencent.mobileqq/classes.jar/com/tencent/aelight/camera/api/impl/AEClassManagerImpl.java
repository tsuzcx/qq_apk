package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.cmshow.config.AECMShowQConfigProcessor;
import com.tencent.aelight.camera.ae.config.CameraDataService;
import com.tencent.aelight.camera.ae.config.CameraDataServiceHandler;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.play.AECoverSelectFragment;
import com.tencent.aelight.camera.ae.play.AEVideoPreviewFragment;
import com.tencent.aelight.camera.aebase.PeakService;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.aebase.QIMTribeEffectsCameraCaptureUnit;
import com.tencent.aelight.camera.aebase.QIMWebEffectCameraCaptureUnit;
import com.tencent.aelight.camera.aeeditor.AEEditorActivity;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorDataServiceHandler;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectConfigProcessor;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.config.QIMDoodleConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMDynamicTextConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMFilterConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMMusicConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMPasterConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMTemplateConfigProcessor;
import com.tencent.aelight.camera.aioeditor.takevideo.artfilter.ArtFilterBridgeActivity;
import com.tencent.aelight.camera.api.IAEClassManager;

public class AEClassManagerImpl
  implements IAEClassManager
{
  public Class getAECMShowQConfigProcessorClass()
  {
    return AECMShowQConfigProcessor.class;
  }
  
  public Class getAECoverSelectFragmentClass()
  {
    return AECoverSelectFragment.class;
  }
  
  public Class getAEEditorActivityClass()
  {
    return AEEditorActivity.class;
  }
  
  public Class getAEEditorDataServiceHandlerClass()
  {
    return AEEditorDataServiceHandler.class;
  }
  
  public Class getAEEditorEffectConfigProcessorClass()
  {
    return AEEditorEffectConfigProcessor.class;
  }
  
  public Class getAEPituCameraUnitClass()
  {
    return AEPituCameraUnit.class;
  }
  
  public Class getArtFilterBridgeActivityClass()
  {
    return ArtFilterBridgeActivity.class;
  }
  
  public Class getCameraDataServiceClass()
  {
    return CameraDataService.class;
  }
  
  public Class getCameraDataServiceHandlerClass()
  {
    return CameraDataServiceHandler.class;
  }
  
  public Class getCameraPeakServiceHandlerClass()
  {
    return CameraPeakServiceHandler.class;
  }
  
  public Class getMusicProviderViewClass()
  {
    return MusicProviderView.class;
  }
  
  public Class getPeakServiceClass()
  {
    return PeakService.class;
  }
  
  public Class getQIMCameraCaptureActivity()
  {
    return QIMCameraCaptureActivity.class;
  }
  
  public Class getQIMDoodleConfigProcessorClass()
  {
    return QIMDoodleConfigProcessor.class;
  }
  
  public Class getQIMDynamicTextConfigProcessorClass()
  {
    return QIMDynamicTextConfigProcessor.class;
  }
  
  public Class getQIMFilterConfigProcessorClass()
  {
    return QIMFilterConfigProcessor.class;
  }
  
  public Class getQIMMusicConfigProcessorClass()
  {
    return QIMMusicConfigProcessor.class;
  }
  
  public Class getQIMPasterConfigProcessorClass()
  {
    return QIMPasterConfigProcessor.class;
  }
  
  public Class getQIMTemplateConfigProcessorClass()
  {
    return QIMTemplateConfigProcessor.class;
  }
  
  public Class getQIMTribeEffectsCameraCaptureUnitClass()
  {
    return QIMTribeEffectsCameraCaptureUnit.class;
  }
  
  public Class getQIMWebEffectCameraCaptureUnitClass()
  {
    return QIMWebEffectCameraCaptureUnit.class;
  }
  
  public Class getQzoneEditPictureActivityClass()
  {
    return QzoneEditPictureActivity.class;
  }
  
  public Class getVideoPreviewFragmentClass()
  {
    return AEVideoPreviewFragment.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AEClassManagerImpl
 * JD-Core Version:    0.7.0.1
 */