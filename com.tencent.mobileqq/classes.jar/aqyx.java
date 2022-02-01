import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aqyx
  extends aqyt
{
  public aqyn a(String paramString)
  {
    QLog.d("ArkMsgAIDisableConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      aqzl localaqzl = (aqzl)aqxo.a(paramString, aqzl.class);
      return new aqyr(paramString, localaqzl);
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
 * Qualified Name:     aqyx
 * JD-Core Version:    0.7.0.1
 */