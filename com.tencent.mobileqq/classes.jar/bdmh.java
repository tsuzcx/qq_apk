import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.qphone.base.util.QLog;

public class bdmh
  extends bdmg
{
  private static bdmh jdField_a_of_type_Bdmh;
  private boolean jdField_a_of_type_Boolean;
  
  public static bdmh a()
  {
    if (jdField_a_of_type_Bdmh != null) {
      return jdField_a_of_type_Bdmh;
    }
    try
    {
      if (jdField_a_of_type_Bdmh == null) {
        jdField_a_of_type_Bdmh = new bdmh();
      }
      bdmh localbdmh = jdField_a_of_type_Bdmh;
      return localbdmh;
    }
    finally {}
  }
  
  public void a()
  {
    if ((BaseApplicationImpl.sProcessId != 4) && (BaseApplicationImpl.sProcessId != 1) && (bcur.a(BaseApplicationImpl.sProcessId, BaseApplicationImpl.processName))) {}
    for (;;)
    {
      try
      {
        QLog.d("RecordTracer", 1, "SDK Init, processId:" + BaseApplicationImpl.sProcessId + ", processName:" + BaseApplicationImpl.processName);
        RecordTracer.a().step();
        Object localObject = MagnifierSDK.a().a().b().split("\\|");
        if ((localObject.length < 11) || (TextUtils.isEmpty(localObject[10]))) {
          break label173;
        }
        localObject = localObject[10];
        bdme.a().a((String)localObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("RecordTracer", 2, "not init, processId:" + BaseApplicationImpl.sProcessId + ", processName:" + BaseApplicationImpl.processName);
        continue;
        label173:
        String str = "0.1;0.0002;10;5;10;5;2;0;500;1";
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = (PreDownloadScheduler)((QQAppInterface)localObject).getManager(QQManagerFactory.PRE_DOWNLOAD_SCHEDULER_MANAGER);
      if (localObject != null) {
        ((PreDownloadScheduler)localObject).onAppBackground();
      }
    }
    bdme.a().a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    bdme.a().b();
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = (PreDownloadScheduler)((QQAppInterface)localObject).getManager(QQManagerFactory.PRE_DOWNLOAD_SCHEDULER_MANAGER);
      if (localObject != null) {
        ((PreDownloadScheduler)localObject).onAppForground();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdmh
 * JD-Core Version:    0.7.0.1
 */