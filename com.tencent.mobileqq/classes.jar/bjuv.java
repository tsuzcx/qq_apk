import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoButton.9.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoButton.9.2;

public class bjuv
  implements ModuleDownloadListener
{
  bjuv(bjun parambjun) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QLog.i("Q.qqstory.record.EditVideoButton", 2, "onDownloadCanceled " + paramString);
  }
  
  public void onDownloadFailed(String paramString)
  {
    QLog.i("Q.qqstory.record.EditVideoButton", 2, "onDownloadFailed " + paramString);
    if ((this.a.a != null) && (this.a.a.getActivity() != null)) {
      this.a.a.getActivity().runOnUiThread(new EditVideoButton.9.2(this));
    }
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("cyber_clink_version_2.jar")) {}
    while ((this.a.a == null) || (this.a.a.getActivity() == null)) {
      return;
    }
    this.a.a.getActivity().runOnUiThread(new EditVideoButton.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjuv
 * JD-Core Version:    0.7.0.1
 */