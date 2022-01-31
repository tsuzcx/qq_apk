import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amqw
  extends amqr
{
  public int a()
  {
    return 380;
  }
  
  public amql a(String paramString)
  {
    QLog.d("ArkPlatformConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      amrk localamrk = (amrk)ampw.a(paramString, amrk.class);
      return new amqq(paramString, localamrk);
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
  
  public void a(amql paramamql)
  {
    super.a(paramamql);
    if (paramamql == null) {
      QLog.i("ArkPlatformConfProcessor", 1, "newConf is null");
    }
    do
    {
      return;
      QLog.d("ArkPlatformConfProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramamql.a());
      paramamql = paramamql.a();
      altc.a();
    } while ((paramamql == null) || (paramamql.a() == null));
    paramamql = paramamql.a();
    if (paramamql == null)
    {
      QLog.i("ArkPlatformConfProcessor", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
      return;
    }
    ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(paramamql.jdField_a_of_type_Boolean, paramamql.b, paramamql.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqw
 * JD-Core Version:    0.7.0.1
 */