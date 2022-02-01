import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.QQComicPluginBridge.1;

public class bkgv
  implements OnPluginInstallListener
{
  public bkgv(QQComicPluginBridge.1 param1) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if ((this.a.a != null) && (this.a.a.jdField_a_of_type_Bkgw != null)) {
      this.a.a.jdField_a_of_type_Bkgw.a(98, "载入中,（我会越来越快的>_<）");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.a.a != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      this.a.a.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.a.a.jdField_a_of_type_Bkgw != null)
      {
        paramInt1 = (int)(paramInt1 / paramInt2 * 95.0F);
        this.a.a.jdField_a_of_type_Bkgw.a(paramInt1, "加载中,（别紧张啊我很小的>_<）");
      }
    }
  }
  
  public void onInstallError(String arg1, int paramInt)
  {
    synchronized ()
    {
      bkgu.a().notifyAll();
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
      bkgu.a().notifyAll();
      if (this.a.a != null)
      {
        this.a.a.b = System.currentTimeMillis();
        if (this.a.a.jdField_a_of_type_Bkgw != null) {
          this.a.a.jdField_a_of_type_Bkgw.a(99, "载入中,（我会越来越快的>_<）");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is installed");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgv
 * JD-Core Version:    0.7.0.1
 */