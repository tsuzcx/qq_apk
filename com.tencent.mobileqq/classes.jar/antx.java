import android.os.RemoteException;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

public class antx
  implements bgaz
{
  public static volatile antx a;
  private bfzg jdField_a_of_type_Bfzg;
  private String jdField_a_of_type_JavaLangString = "qzone_live_video_plugin_hack.apk";
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static antx a()
  {
    if (jdField_a_of_type_Antx == null) {}
    try
    {
      if (jdField_a_of_type_Antx == null) {
        jdField_a_of_type_Antx = new antx();
      }
      return jdField_a_of_type_Antx;
    }
    finally {}
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (bgbf.a() != 1) {}
    }
    else
    {
      return;
    }
    bgax.a(BaseApplicationImpl.getContext(), this);
  }
  
  public void onQzonePluginClientReady(bfzg parambfzg)
  {
    QLog.i("ECPreInstallLiveVideoApk", 1, "onQzonePluginClientReady start");
    if (parambfzg == null) {
      bgax.a(BaseApplicationImpl.getContext(), this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      QQAppInterface localQQAppInterface2 = (QQAppInterface)QQStoryContext.a();
      QQAppInterface localQQAppInterface1 = localQQAppInterface2;
      if (localQQAppInterface2 == null)
      {
        QLog.i("ECPreInstallLiveVideoApk", 1, "onQzonePluginClientReady: getAppRuntime return null.");
        localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
      if (localQQAppInterface1 != null) {
        bgbh.a().a(localQQAppInterface1);
      }
      this.jdField_a_of_type_Bfzg = parambfzg;
      parambfzg = this.jdField_a_of_type_Bfzg.a(this.jdField_a_of_type_JavaLangString);
      if (parambfzg != null)
      {
        if (parambfzg.state == 4)
        {
          this.jdField_a_of_type_Boolean = false;
          QLog.i("ECPreInstallLiveVideoApk", 1, "onQzonePluginClientReady installed");
          return;
        }
        if (parambfzg.state == 2)
        {
          try
          {
            this.jdField_a_of_type_Bfzg.a(this.jdField_a_of_type_JavaLangString, null, 0);
          }
          catch (RemoteException parambfzg)
          {
            QLog.e("ECPreInstallLiveVideoApk", 1, parambfzg, new Object[0]);
          }
        }
        else
        {
          QLog.d("ECPreInstallLiveVideoApk", 1, " has not installed");
          if (bgau.b()) {
            try
            {
              this.jdField_a_of_type_Bfzg.a(this.jdField_a_of_type_JavaLangString, null, 0);
            }
            catch (RemoteException parambfzg)
            {
              QLog.e("ECPreInstallLiveVideoApk", 1, "installPluginSilence", parambfzg);
            }
          }
        }
      }
      else
      {
        QLog.d("ECPreInstallLiveVideoApk", 1, "record is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     antx
 * JD-Core Version:    0.7.0.1
 */