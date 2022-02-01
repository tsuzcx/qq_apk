import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aqna
  extends aqmv
{
  public aqmp a(String paramString)
  {
    QLog.d("ArkPlatformConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      aqno localaqno = (aqno)aqlu.a(paramString, aqno.class);
      return new aqmu(paramString, localaqno);
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
  
  public void a(aqmp paramaqmp)
  {
    super.a(paramaqmp);
    if (paramaqmp == null) {
      QLog.i("ArkPlatformConfProcessor", 1, "newConf is null");
    }
    do
    {
      return;
      QLog.d("ArkPlatformConfProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramaqmp.a());
      paramaqmp = paramaqmp.a();
      apoj.a();
    } while ((paramaqmp == null) || (paramaqmp.a() == null));
    paramaqmp = paramaqmp.a();
    if (paramaqmp == null)
    {
      QLog.i("ArkPlatformConfProcessor", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
      return;
    }
    ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(paramaqmp.jdField_a_of_type_Boolean, paramaqmp.b, paramaqmp.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public int type()
  {
    return 380;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqna
 * JD-Core Version:    0.7.0.1
 */