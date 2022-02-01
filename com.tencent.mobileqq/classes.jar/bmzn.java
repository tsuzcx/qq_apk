import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;

class bmzn
  implements MovieExporter.VideoCompressListener
{
  bmzn(bmzm parambmzm, MovieExporter.VideoCompressListener paramVideoCompressListener, String paramString) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzn
 * JD-Core Version:    0.7.0.1
 */