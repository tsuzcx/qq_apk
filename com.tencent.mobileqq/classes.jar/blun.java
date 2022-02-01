import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class blun
  implements Downloader.DownloadListener
{
  blun(blum paramblum, bluo parambluo) {}
  
  public void onDownloadCanceled(String paramString)
  {
    blum.a(this.jdField_a_of_type_Blum, false);
    if (blum.a(this.jdField_a_of_type_Blum).size() > 0)
    {
      bluo localbluo = (bluo)blum.a(this.jdField_a_of_type_Blum).get(0);
      blum.a(this.jdField_a_of_type_Blum).remove(0);
      blum.a(this.jdField_a_of_type_Blum, localbluo);
    }
    if (this.jdField_a_of_type_Bluo.a != null) {
      this.jdField_a_of_type_Bluo.a.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    blum.a(this.jdField_a_of_type_Blum, false);
    if (blum.a(this.jdField_a_of_type_Blum).size() > 0)
    {
      bluo localbluo = (bluo)blum.a(this.jdField_a_of_type_Blum).get(0);
      blum.a(this.jdField_a_of_type_Blum).remove(0);
      blum.a(this.jdField_a_of_type_Blum, localbluo);
    }
    if (this.jdField_a_of_type_Bluo.a != null) {
      this.jdField_a_of_type_Bluo.a.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Bluo.a != null) {
      this.jdField_a_of_type_Bluo.a.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    blum.a(this.jdField_a_of_type_Blum, false);
    if (blum.a(this.jdField_a_of_type_Blum).size() > 0)
    {
      bluo localbluo = (bluo)blum.a(this.jdField_a_of_type_Blum).get(0);
      blum.a(this.jdField_a_of_type_Blum).remove(0);
      blum.a(this.jdField_a_of_type_Blum, localbluo);
    }
    if (this.jdField_a_of_type_Bluo.a != null) {
      this.jdField_a_of_type_Bluo.a.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blun
 * JD-Core Version:    0.7.0.1
 */