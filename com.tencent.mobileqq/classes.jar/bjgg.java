import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class bjgg
  implements Downloader.DownloadListener
{
  bjgg(bjgf parambjgf, bjgh parambjgh) {}
  
  public void onDownloadCanceled(String paramString)
  {
    bjgf.a(this.jdField_a_of_type_Bjgf, false);
    if (bjgf.a(this.jdField_a_of_type_Bjgf).size() > 0)
    {
      bjgh localbjgh = (bjgh)bjgf.a(this.jdField_a_of_type_Bjgf).get(0);
      bjgf.a(this.jdField_a_of_type_Bjgf).remove(0);
      bjgf.a(this.jdField_a_of_type_Bjgf, localbjgh);
    }
    if (this.jdField_a_of_type_Bjgh.a != null) {
      this.jdField_a_of_type_Bjgh.a.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    bjgf.a(this.jdField_a_of_type_Bjgf, false);
    if (bjgf.a(this.jdField_a_of_type_Bjgf).size() > 0)
    {
      bjgh localbjgh = (bjgh)bjgf.a(this.jdField_a_of_type_Bjgf).get(0);
      bjgf.a(this.jdField_a_of_type_Bjgf).remove(0);
      bjgf.a(this.jdField_a_of_type_Bjgf, localbjgh);
    }
    if (this.jdField_a_of_type_Bjgh.a != null) {
      this.jdField_a_of_type_Bjgh.a.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Bjgh.a != null) {
      this.jdField_a_of_type_Bjgh.a.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    bjgf.a(this.jdField_a_of_type_Bjgf, false);
    if (bjgf.a(this.jdField_a_of_type_Bjgf).size() > 0)
    {
      bjgh localbjgh = (bjgh)bjgf.a(this.jdField_a_of_type_Bjgf).get(0);
      bjgf.a(this.jdField_a_of_type_Bjgf).remove(0);
      bjgf.a(this.jdField_a_of_type_Bjgf, localbjgh);
    }
    if (this.jdField_a_of_type_Bjgh.a != null) {
      this.jdField_a_of_type_Bjgh.a.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjgg
 * JD-Core Version:    0.7.0.1
 */