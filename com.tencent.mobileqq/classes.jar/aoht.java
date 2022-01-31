import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aoht
  extends aoho
{
  public int a()
  {
    return 380;
  }
  
  public aohi a(String paramString)
  {
    QLog.d("ArkPlatformConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      aoih localaoih = (aoih)aogt.a(paramString, aoih.class);
      return new aohn(paramString, localaoih);
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
  
  public void a(aohi paramaohi)
  {
    super.a(paramaohi);
    if (paramaohi == null) {
      QLog.i("ArkPlatformConfProcessor", 1, "newConf is null");
    }
    do
    {
      return;
      QLog.d("ArkPlatformConfProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramaohi.a());
      paramaohi = paramaohi.a();
      anju.a();
    } while ((paramaohi == null) || (paramaohi.a() == null));
    paramaohi = paramaohi.a();
    if (paramaohi == null)
    {
      QLog.i("ArkPlatformConfProcessor", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
      return;
    }
    ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(paramaohi.jdField_a_of_type_Boolean, paramaohi.b, paramaohi.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoht
 * JD-Core Version:    0.7.0.1
 */