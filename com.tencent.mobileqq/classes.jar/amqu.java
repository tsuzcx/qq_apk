import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amqu
  extends amqq
{
  public int a()
  {
    return 159;
  }
  
  public amqk a(String paramString)
  {
    QLog.d("ArkMsgAIDisableConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      amri localamri = (amri)ampv.a(paramString, amri.class);
      return new amqo(paramString, localamri);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("ArkMsgAIDisableConfProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException);
        Object localObject = null;
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqu
 * JD-Core Version:    0.7.0.1
 */