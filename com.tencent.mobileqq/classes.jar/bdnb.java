import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.qphone.base.util.QLog;

public class bdnb
  extends bdna
{
  private static bdnb jdField_a_of_type_Bdnb;
  private boolean jdField_a_of_type_Boolean;
  
  public static bdnb a()
  {
    if (jdField_a_of_type_Bdnb != null) {
      return jdField_a_of_type_Bdnb;
    }
    try
    {
      if (jdField_a_of_type_Bdnb == null) {
        jdField_a_of_type_Bdnb = new bdnb();
      }
      bdnb localbdnb = jdField_a_of_type_Bdnb;
      return localbdnb;
    }
    finally {}
  }
  
  public void a()
  {
    if ((BaseApplicationImpl.sProcessId != 4) && (BaseApplicationImpl.sProcessId != 1) && (bcun.a(BaseApplicationImpl.sProcessId, BaseApplicationImpl.processName))) {}
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
        bdmy.a().a((String)localObject);
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
      localObject = (bezz)((QQAppInterface)localObject).getManager(233);
      if (localObject != null) {
        ((bezz)localObject).c();
      }
    }
    bdmy.a().a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    bdmy.a().b();
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = (bezz)((QQAppInterface)localObject).getManager(233);
      if (localObject != null) {
        ((bezz)localObject).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdnb
 * JD-Core Version:    0.7.0.1
 */