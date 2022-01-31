import android.os.RemoteException;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

public class aokj
  implements bhjk
{
  public static volatile aokj a;
  private bhhr jdField_a_of_type_Bhhr;
  private String jdField_a_of_type_JavaLangString = "qzone_live_video_plugin_hack.apk";
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static aokj a()
  {
    if (jdField_a_of_type_Aokj == null) {}
    try
    {
      if (jdField_a_of_type_Aokj == null) {
        jdField_a_of_type_Aokj = new aokj();
      }
      return jdField_a_of_type_Aokj;
    }
    finally {}
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (bhjq.a() != 1) {}
    }
    else
    {
      return;
    }
    bhji.a(BaseApplicationImpl.getContext(), this);
  }
  
  public void onQzonePluginClientReady(bhhr parambhhr)
  {
    QLog.i("ECPreInstallLiveVideoApk", 1, "onQzonePluginClientReady start");
    if (parambhhr == null) {
      bhji.a(BaseApplicationImpl.getContext(), this);
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
        bhjs.a().a(localQQAppInterface1);
      }
      this.jdField_a_of_type_Bhhr = parambhhr;
      parambhhr = this.jdField_a_of_type_Bhhr.a(this.jdField_a_of_type_JavaLangString);
      if (parambhhr != null)
      {
        if (parambhhr.state == 4)
        {
          this.jdField_a_of_type_Boolean = false;
          QLog.i("ECPreInstallLiveVideoApk", 1, "onQzonePluginClientReady installed");
          return;
        }
        if (parambhhr.state == 2)
        {
          try
          {
            this.jdField_a_of_type_Bhhr.a(this.jdField_a_of_type_JavaLangString, null, 0);
          }
          catch (RemoteException parambhhr)
          {
            QLog.e("ECPreInstallLiveVideoApk", 1, parambhhr, new Object[0]);
          }
        }
        else
        {
          QLog.d("ECPreInstallLiveVideoApk", 1, " has not installed");
          if (bhjf.b()) {
            try
            {
              this.jdField_a_of_type_Bhhr.a(this.jdField_a_of_type_JavaLangString, null, 0);
            }
            catch (RemoteException parambhhr)
            {
              QLog.e("ECPreInstallLiveVideoApk", 1, "installPluginSilence", parambhhr);
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
 * Qualified Name:     aokj
 * JD-Core Version:    0.7.0.1
 */