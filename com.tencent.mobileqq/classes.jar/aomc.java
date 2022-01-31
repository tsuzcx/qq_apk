import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aomc
  extends aolx
{
  public int a()
  {
    return 380;
  }
  
  public aolr a(String paramString)
  {
    QLog.d("ArkPlatformConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      aomq localaomq = (aomq)aolc.a(paramString, aomq.class);
      return new aolw(paramString, localaomq);
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
  
  public void a(aolr paramaolr)
  {
    super.a(paramaolr);
    if (paramaolr == null) {
      QLog.i("ArkPlatformConfProcessor", 1, "newConf is null");
    }
    do
    {
      return;
      QLog.d("ArkPlatformConfProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramaolr.a());
      paramaolr = paramaolr.a();
      anod.a();
    } while ((paramaolr == null) || (paramaolr.a() == null));
    paramaolr = paramaolr.a();
    if (paramaolr == null)
    {
      QLog.i("ArkPlatformConfProcessor", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
      return;
    }
    ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(paramaolr.jdField_a_of_type_Boolean, paramaolr.b, paramaolr.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aomc
 * JD-Core Version:    0.7.0.1
 */