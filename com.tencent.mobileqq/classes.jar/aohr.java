import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aohr
  extends aoho
{
  public int a()
  {
    return 250;
  }
  
  public aohi a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      aoic localaoic = (aoic)aogt.a(paramString, aoic.class);
      return new aohl(paramString, localaoic);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aohr
 * JD-Core Version:    0.7.0.1
 */