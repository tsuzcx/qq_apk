import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class arcd
  extends arca
{
  public arbu a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      arco localarco = (arco)arax.a(paramString, arco.class);
      return new arbx(paramString, localarco);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("ArkConfProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException);
        Object localObject = null;
      }
    }
  }
  
  public int type()
  {
    return 250;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcd
 * JD-Core Version:    0.7.0.1
 */