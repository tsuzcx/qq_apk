import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class bhas
  implements Downloader.DownloadListener
{
  bhas(bhar parambhar, bhat parambhat) {}
  
  public void onDownloadCanceled(String paramString)
  {
    bhar.a(this.jdField_a_of_type_Bhar, false);
    if (bhar.a(this.jdField_a_of_type_Bhar).size() > 0)
    {
      bhat localbhat = (bhat)bhar.a(this.jdField_a_of_type_Bhar).get(0);
      bhar.a(this.jdField_a_of_type_Bhar).remove(0);
      bhar.a(this.jdField_a_of_type_Bhar, localbhat);
    }
    if (this.jdField_a_of_type_Bhat.a != null) {
      this.jdField_a_of_type_Bhat.a.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    bhar.a(this.jdField_a_of_type_Bhar, false);
    if (bhar.a(this.jdField_a_of_type_Bhar).size() > 0)
    {
      bhat localbhat = (bhat)bhar.a(this.jdField_a_of_type_Bhar).get(0);
      bhar.a(this.jdField_a_of_type_Bhar).remove(0);
      bhar.a(this.jdField_a_of_type_Bhar, localbhat);
    }
    if (this.jdField_a_of_type_Bhat.a != null) {
      this.jdField_a_of_type_Bhat.a.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Bhat.a != null) {
      this.jdField_a_of_type_Bhat.a.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    bhar.a(this.jdField_a_of_type_Bhar, false);
    if (bhar.a(this.jdField_a_of_type_Bhar).size() > 0)
    {
      bhat localbhat = (bhat)bhar.a(this.jdField_a_of_type_Bhar).get(0);
      bhar.a(this.jdField_a_of_type_Bhar).remove(0);
      bhar.a(this.jdField_a_of_type_Bhar, localbhat);
    }
    if (this.jdField_a_of_type_Bhat.a != null) {
      this.jdField_a_of_type_Bhat.a.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhas
 * JD-Core Version:    0.7.0.1
 */