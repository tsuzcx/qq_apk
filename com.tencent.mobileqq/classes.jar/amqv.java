import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amqv
  extends amqq
{
  public int a()
  {
    return 380;
  }
  
  public amqk a(String paramString)
  {
    QLog.d("ArkPlatformConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      amrj localamrj = (amrj)ampv.a(paramString, amrj.class);
      return new amqp(paramString, localamrj);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("ArkPlatformConfProcessor", 1, "readJsonOrXml:" + paramString + "fail", localQStorageInstantiateException);
        Object localObject = null;
      }
    }
  }
  
  public void a(amqk paramamqk)
  {
    super.a(paramamqk);
    if (paramamqk == null) {
      QLog.i("ArkPlatformConfProcessor", 1, "newConf is null");
    }
    do
    {
      return;
      QLog.d("ArkPlatformConfProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramamqk.a());
      paramamqk = paramamqk.a();
      altb.a();
    } while ((paramamqk == null) || (paramamqk.a() == null));
    paramamqk = paramamqk.a();
    if (paramamqk == null)
    {
      QLog.i("ArkPlatformConfProcessor", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
      return;
    }
    ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(paramamqk.jdField_a_of_type_Boolean, paramamqk.b, paramamqk.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqv
 * JD-Core Version:    0.7.0.1
 */