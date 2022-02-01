import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class arcf
  extends arca
{
  public arbu a(String paramString)
  {
    QLog.d("ArkPlatformConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      arct localarct = (arct)arax.a(paramString, arct.class);
      return new arbz(paramString, localarct);
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
  
  public void a(arbu paramarbu)
  {
    super.a(paramarbu);
    if (paramarbu == null) {
      QLog.i("ArkPlatformConfProcessor", 1, "newConf is null");
    }
    do
    {
      return;
      QLog.d("ArkPlatformConfProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramarbu.a());
      paramarbu = paramarbu.a();
      aqbz.a();
    } while ((paramarbu == null) || (paramarbu.a() == null));
    paramarbu = paramarbu.a();
    if (paramarbu == null)
    {
      QLog.i("ArkPlatformConfProcessor", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
      return;
    }
    ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(paramarbu.jdField_a_of_type_Boolean, paramarbu.b, paramarbu.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public int type()
  {
    return 380;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcf
 * JD-Core Version:    0.7.0.1
 */