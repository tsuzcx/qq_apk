import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class bmvp
  implements Downloader.DownloadListener
{
  bmvp(bmvo parambmvo, bmvq parambmvq) {}
  
  public void onDownloadCanceled(String paramString)
  {
    bmvo.a(this.jdField_a_of_type_Bmvo, false);
    if (bmvo.a(this.jdField_a_of_type_Bmvo).size() > 0)
    {
      bmvq localbmvq = (bmvq)bmvo.a(this.jdField_a_of_type_Bmvo).get(0);
      bmvo.a(this.jdField_a_of_type_Bmvo).remove(0);
      bmvo.a(this.jdField_a_of_type_Bmvo, localbmvq);
    }
    if (this.jdField_a_of_type_Bmvq.a != null) {
      this.jdField_a_of_type_Bmvq.a.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    bmvo.a(this.jdField_a_of_type_Bmvo, false);
    if (bmvo.a(this.jdField_a_of_type_Bmvo).size() > 0)
    {
      bmvq localbmvq = (bmvq)bmvo.a(this.jdField_a_of_type_Bmvo).get(0);
      bmvo.a(this.jdField_a_of_type_Bmvo).remove(0);
      bmvo.a(this.jdField_a_of_type_Bmvo, localbmvq);
    }
    if (this.jdField_a_of_type_Bmvq.a != null) {
      this.jdField_a_of_type_Bmvq.a.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Bmvq.a != null) {
      this.jdField_a_of_type_Bmvq.a.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    bmvo.a(this.jdField_a_of_type_Bmvo, false);
    if (bmvo.a(this.jdField_a_of_type_Bmvo).size() > 0)
    {
      bmvq localbmvq = (bmvq)bmvo.a(this.jdField_a_of_type_Bmvo).get(0);
      bmvo.a(this.jdField_a_of_type_Bmvo).remove(0);
      bmvo.a(this.jdField_a_of_type_Bmvo, localbmvq);
    }
    if (this.jdField_a_of_type_Bmvq.a != null) {
      this.jdField_a_of_type_Bmvq.a.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvp
 * JD-Core Version:    0.7.0.1
 */