package com.tencent.aelight.camera.ae.biz.circle;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;

class AECirclePhotoListLogic$16
  implements MovieExporter.VideoCompressListener
{
  AECirclePhotoListLogic$16(AECirclePhotoListLogic paramAECirclePhotoListLogic, MovieExporter.VideoCompressListener paramVideoCompressListener, String paramString) {}
  
  public void onCompressCanceled()
  {
    FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter$VideoCompressListener.onCompressCanceled();
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter$VideoCompressListener.onCompressError(paramAssetExportSession);
  }
  
  public void onCompressFinish(String paramString)
  {
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter$VideoCompressListener.onCompressFinish(paramString);
  }
  
  public void onCompressStart()
  {
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter$VideoCompressListener.onCompressStart();
  }
  
  public void onCompressing(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter$VideoCompressListener.onCompressing(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.16
 * JD-Core Version:    0.7.0.1
 */