import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.qphone.base.util.QLog;

public class bcfm
  extends bcfl
{
  private static bcfm jdField_a_of_type_Bcfm;
  private boolean jdField_a_of_type_Boolean;
  
  public static bcfm a()
  {
    if (jdField_a_of_type_Bcfm != null) {
      return jdField_a_of_type_Bcfm;
    }
    try
    {
      if (jdField_a_of_type_Bcfm == null) {
        jdField_a_of_type_Bcfm = new bcfm();
      }
      bcfm localbcfm = jdField_a_of_type_Bcfm;
      return localbcfm;
    }
    finally {}
  }
  
  public void a()
  {
    if ((BaseApplicationImpl.sProcessId != 4) && (BaseApplicationImpl.sProcessId != 1) && (bbnx.a(BaseApplicationImpl.sProcessId, BaseApplicationImpl.processName))) {}
    for (;;)
    {
      try
      {
        QLog.d("RecordTracer", 1, "SDK Init, processId:" + BaseApplicationImpl.sProcessId + ", processName:" + BaseApplicationImpl.processName);
        RecordTracer.a().step();
        Object localObject = MagnifierSDK.a().a().a().split("\\|");
        if ((localObject.length < 11) || (TextUtils.isEmpty(localObject[10]))) {
          break label173;
        }
        localObject = localObject[10];
        bcfj.a().a((String)localObject);
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
      localObject = (PreDownloadScheduler)((QQAppInterface)localObject).getManager(233);
      if (localObject != null) {
        ((PreDownloadScheduler)localObject).onAppBackground();
      }
    }
    bcfj.a().a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    bcfj.a().b();
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = (PreDownloadScheduler)((QQAppInterface)localObject).getManager(233);
      if (localObject != null) {
        ((PreDownloadScheduler)localObject).onAppForground();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcfm
 * JD-Core Version:    0.7.0.1
 */