import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.comic.utils.QQComicPluginBridge.PluginInstallCallback;
import cooperation.comic.utils.QQComicPluginBridge.PluginInstallObserver;

class amry
  implements OnPluginInstallListener
{
  amry(amrx paramamrx) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if ((this.a.a != null) && (this.a.a.jdField_a_of_type_CooperationComicUtilsQQComicPluginBridge$PluginInstallCallback != null)) {
      this.a.a.jdField_a_of_type_CooperationComicUtilsQQComicPluginBridge$PluginInstallCallback.a(98, "载入中,（我会越来越快的>_<）");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.a.a != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      this.a.a.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.a.a.jdField_a_of_type_CooperationComicUtilsQQComicPluginBridge$PluginInstallCallback != null)
      {
        paramInt1 = (int)(paramInt1 / paramInt2 * 95.0F);
        this.a.a.jdField_a_of_type_CooperationComicUtilsQQComicPluginBridge$PluginInstallCallback.a(paramInt1, "加载中,（别紧张啊我很小的>_<）");
      }
    }
  }
  
  public void onInstallError(String arg1, int paramInt)
  {
    synchronized ()
    {
      QQComicPluginBridge.a().notifyAll();
      if (this.a.a != null) {
        this.a.a.jdField_a_of_type_Int = paramInt;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic install error");
      }
      return;
    }
  }
  
  public void onInstallFinish(String arg1)
  {
    synchronized ()
    {
      QQComicPluginBridge.a().notifyAll();
      if (this.a.a != null)
      {
        this.a.a.b = System.currentTimeMillis();
        if (this.a.a.jdField_a_of_type_CooperationComicUtilsQQComicPluginBridge$PluginInstallCallback != null) {
          this.a.a.jdField_a_of_type_CooperationComicUtilsQQComicPluginBridge$PluginInstallCallback.a(99, "载入中,（我会越来越快的>_<）");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is installed");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amry
 * JD-Core Version:    0.7.0.1
 */