import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class bfru
  implements Downloader.DownloadListener
{
  bfru(bfrt parambfrt, bfrv parambfrv) {}
  
  public void onDownloadCanceled(String paramString)
  {
    bfrt.a(this.jdField_a_of_type_Bfrt, false);
    if (bfrt.a(this.jdField_a_of_type_Bfrt).size() > 0)
    {
      bfrv localbfrv = (bfrv)bfrt.a(this.jdField_a_of_type_Bfrt).get(0);
      bfrt.a(this.jdField_a_of_type_Bfrt).remove(0);
      bfrt.a(this.jdField_a_of_type_Bfrt, localbfrv);
    }
    if (this.jdField_a_of_type_Bfrv.a != null) {
      this.jdField_a_of_type_Bfrv.a.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    bfrt.a(this.jdField_a_of_type_Bfrt, false);
    if (bfrt.a(this.jdField_a_of_type_Bfrt).size() > 0)
    {
      bfrv localbfrv = (bfrv)bfrt.a(this.jdField_a_of_type_Bfrt).get(0);
      bfrt.a(this.jdField_a_of_type_Bfrt).remove(0);
      bfrt.a(this.jdField_a_of_type_Bfrt, localbfrv);
    }
    if (this.jdField_a_of_type_Bfrv.a != null) {
      this.jdField_a_of_type_Bfrv.a.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Bfrv.a != null) {
      this.jdField_a_of_type_Bfrv.a.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    bfrt.a(this.jdField_a_of_type_Bfrt, false);
    if (bfrt.a(this.jdField_a_of_type_Bfrt).size() > 0)
    {
      bfrv localbfrv = (bfrv)bfrt.a(this.jdField_a_of_type_Bfrt).get(0);
      bfrt.a(this.jdField_a_of_type_Bfrt).remove(0);
      bfrt.a(this.jdField_a_of_type_Bfrt, localbfrv);
    }
    if (this.jdField_a_of_type_Bfrv.a != null) {
      this.jdField_a_of_type_Bfrv.a.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfru
 * JD-Core Version:    0.7.0.1
 */