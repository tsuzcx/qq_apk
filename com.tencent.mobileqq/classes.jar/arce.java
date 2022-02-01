import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class arce
  extends arca
{
  public arbu a(String paramString)
  {
    QLog.d("ArkMsgAIDisableConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      arcs localarcs = (arcs)arax.a(paramString, arcs.class);
      return new arby(paramString, localarcs);
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
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public int type()
  {
    return 159;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arce
 * JD-Core Version:    0.7.0.1
 */