import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class bhab
  implements Downloader.DownloadListener
{
  bhab(bhaa parambhaa, bhac parambhac) {}
  
  public void onDownloadCanceled(String paramString)
  {
    bhaa.a(this.jdField_a_of_type_Bhaa, false);
    if (bhaa.a(this.jdField_a_of_type_Bhaa).size() > 0)
    {
      bhac localbhac = (bhac)bhaa.a(this.jdField_a_of_type_Bhaa).get(0);
      bhaa.a(this.jdField_a_of_type_Bhaa).remove(0);
      bhaa.a(this.jdField_a_of_type_Bhaa, localbhac);
    }
    if (this.jdField_a_of_type_Bhac.a != null) {
      this.jdField_a_of_type_Bhac.a.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    bhaa.a(this.jdField_a_of_type_Bhaa, false);
    if (bhaa.a(this.jdField_a_of_type_Bhaa).size() > 0)
    {
      bhac localbhac = (bhac)bhaa.a(this.jdField_a_of_type_Bhaa).get(0);
      bhaa.a(this.jdField_a_of_type_Bhaa).remove(0);
      bhaa.a(this.jdField_a_of_type_Bhaa, localbhac);
    }
    if (this.jdField_a_of_type_Bhac.a != null) {
      this.jdField_a_of_type_Bhac.a.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Bhac.a != null) {
      this.jdField_a_of_type_Bhac.a.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    bhaa.a(this.jdField_a_of_type_Bhaa, false);
    if (bhaa.a(this.jdField_a_of_type_Bhaa).size() > 0)
    {
      bhac localbhac = (bhac)bhaa.a(this.jdField_a_of_type_Bhaa).get(0);
      bhaa.a(this.jdField_a_of_type_Bhaa).remove(0);
      bhaa.a(this.jdField_a_of_type_Bhaa, localbhac);
    }
    if (this.jdField_a_of_type_Bhac.a != null) {
      this.jdField_a_of_type_Bhac.a.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhab
 * JD-Core Version:    0.7.0.1
 */