import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class apvv
  extends apvq
{
  public apvk a(String paramString)
  {
    QLog.d("ArkPlatformConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      apwj localapwj = (apwj)apul.a(paramString, apwj.class);
      return new apvp(paramString, localapwj);
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
  
  public void a(apvk paramapvk)
  {
    super.a(paramapvk);
    if (paramapvk == null) {
      QLog.i("ArkPlatformConfProcessor", 1, "newConf is null");
    }
    do
    {
      return;
      QLog.d("ArkPlatformConfProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramapvk.a());
      paramapvk = paramapvk.a();
      aovk.a();
    } while ((paramapvk == null) || (paramapvk.a() == null));
    paramapvk = paramapvk.a();
    if (paramapvk == null)
    {
      QLog.i("ArkPlatformConfProcessor", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
      return;
    }
    ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(paramapvk.jdField_a_of_type_Boolean, paramapvk.b, paramapvk.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public int type()
  {
    return 380;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apvv
 * JD-Core Version:    0.7.0.1
 */