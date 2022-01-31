import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aohs
  extends aoho
{
  public int a()
  {
    return 159;
  }
  
  public aohi a(String paramString)
  {
    QLog.d("ArkMsgAIDisableConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      aoig localaoig = (aoig)aogt.a(paramString, aoig.class);
      return new aohm(paramString, localaoig);
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
 * Qualified Name:     aohs
 * JD-Core Version:    0.7.0.1
 */