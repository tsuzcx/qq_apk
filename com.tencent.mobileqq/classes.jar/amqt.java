import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amqt
  extends amqq
{
  public int a()
  {
    return 250;
  }
  
  public amqk a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      amre localamre = (amre)ampv.a(paramString, amre.class);
      return new amqn(paramString, localamre);
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
 * Qualified Name:     amqt
 * JD-Core Version:    0.7.0.1
 */