import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aqyy
  extends aqyt
{
  public aqyn a(String paramString)
  {
    QLog.d("ArkPlatformConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      aqzm localaqzm = (aqzm)aqxo.a(paramString, aqzm.class);
      return new aqys(paramString, localaqzm);
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
  
  public void a(aqyn paramaqyn)
  {
    super.a(paramaqyn);
    if (paramaqyn == null) {
      QLog.i("ArkPlatformConfProcessor", 1, "newConf is null");
    }
    do
    {
      return;
      QLog.d("ArkPlatformConfProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramaqyn.a());
      paramaqyn = paramaqyn.a();
      apyo.a();
    } while ((paramaqyn == null) || (paramaqyn.a() == null));
    paramaqyn = paramaqyn.a();
    if (paramaqyn == null)
    {
      QLog.i("ArkPlatformConfProcessor", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
      return;
    }
    ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(paramaqyn.jdField_a_of_type_Boolean, paramaqyn.b, paramaqyn.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public int type()
  {
    return 380;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyy
 * JD-Core Version:    0.7.0.1
 */