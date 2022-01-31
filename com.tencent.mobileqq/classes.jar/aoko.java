import android.os.RemoteException;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

public class aoko
  implements bhkb
{
  public static volatile aoko a;
  private bhii jdField_a_of_type_Bhii;
  private String jdField_a_of_type_JavaLangString = "qzone_live_video_plugin_hack.apk";
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static aoko a()
  {
    if (jdField_a_of_type_Aoko == null) {}
    try
    {
      if (jdField_a_of_type_Aoko == null) {
        jdField_a_of_type_Aoko = new aoko();
      }
      return jdField_a_of_type_Aoko;
    }
    finally {}
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (bhkh.a() != 1) {}
    }
    else
    {
      return;
    }
    bhjz.a(BaseApplicationImpl.getContext(), this);
  }
  
  public void onQzonePluginClientReady(bhii parambhii)
  {
    QLog.i("ECPreInstallLiveVideoApk", 1, "onQzonePluginClientReady start");
    if (parambhii == null) {
      bhjz.a(BaseApplicationImpl.getContext(), this);
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
        bhkj.a().a(localQQAppInterface1);
      }
      this.jdField_a_of_type_Bhii = parambhii;
      parambhii = this.jdField_a_of_type_Bhii.a(this.jdField_a_of_type_JavaLangString);
      if (parambhii != null)
      {
        if (parambhii.state == 4)
        {
          this.jdField_a_of_type_Boolean = false;
          QLog.i("ECPreInstallLiveVideoApk", 1, "onQzonePluginClientReady installed");
          return;
        }
        if (parambhii.state == 2)
        {
          try
          {
            this.jdField_a_of_type_Bhii.a(this.jdField_a_of_type_JavaLangString, null, 0);
          }
          catch (RemoteException parambhii)
          {
            QLog.e("ECPreInstallLiveVideoApk", 1, parambhii, new Object[0]);
          }
        }
        else
        {
          QLog.d("ECPreInstallLiveVideoApk", 1, " has not installed");
          if (bhjw.b()) {
            try
            {
              this.jdField_a_of_type_Bhii.a(this.jdField_a_of_type_JavaLangString, null, 0);
            }
            catch (RemoteException parambhii)
            {
              QLog.e("ECPreInstallLiveVideoApk", 1, "installPluginSilence", parambhii);
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
 * Qualified Name:     aoko
 * JD-Core Version:    0.7.0.1
 */