import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class bjbz
  implements Downloader.DownloadListener
{
  bjbz(bjby parambjby, bjca parambjca) {}
  
  public void onDownloadCanceled(String paramString)
  {
    bjby.a(this.jdField_a_of_type_Bjby, false);
    if (bjby.a(this.jdField_a_of_type_Bjby).size() > 0)
    {
      bjca localbjca = (bjca)bjby.a(this.jdField_a_of_type_Bjby).get(0);
      bjby.a(this.jdField_a_of_type_Bjby).remove(0);
      bjby.a(this.jdField_a_of_type_Bjby, localbjca);
    }
    if (this.jdField_a_of_type_Bjca.a != null) {
      this.jdField_a_of_type_Bjca.a.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    bjby.a(this.jdField_a_of_type_Bjby, false);
    if (bjby.a(this.jdField_a_of_type_Bjby).size() > 0)
    {
      bjca localbjca = (bjca)bjby.a(this.jdField_a_of_type_Bjby).get(0);
      bjby.a(this.jdField_a_of_type_Bjby).remove(0);
      bjby.a(this.jdField_a_of_type_Bjby, localbjca);
    }
    if (this.jdField_a_of_type_Bjca.a != null) {
      this.jdField_a_of_type_Bjca.a.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Bjca.a != null) {
      this.jdField_a_of_type_Bjca.a.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    bjby.a(this.jdField_a_of_type_Bjby, false);
    if (bjby.a(this.jdField_a_of_type_Bjby).size() > 0)
    {
      bjca localbjca = (bjca)bjby.a(this.jdField_a_of_type_Bjby).get(0);
      bjby.a(this.jdField_a_of_type_Bjby).remove(0);
      bjby.a(this.jdField_a_of_type_Bjby, localbjca);
    }
    if (this.jdField_a_of_type_Bjca.a != null) {
      this.jdField_a_of_type_Bjca.a.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjbz
 * JD-Core Version:    0.7.0.1
 */