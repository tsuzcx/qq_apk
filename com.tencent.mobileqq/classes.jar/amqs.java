import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amqs
  extends amqr
{
  public int a()
  {
    return 170;
  }
  
  public amql a(String paramString)
  {
    QLog.d("ArkAIDictConfigProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      amrd localamrd = (amrd)ampw.a(paramString, amrd.class);
      return new amqm(paramString, localamrd);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("ArkAIDictConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException);
        Object localObject = null;
      }
    }
  }
  
  public void a(amql paramamql)
  {
    super.a(paramamql);
    if (paramamql == null) {
      QLog.i("ArkAIDictConfigProcessor", 1, "newConf is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("ArkAIDictConfigProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramamql.a());
          paramamql = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        } while (paramamql == null);
        paramamql = (ArkAppCenter)paramamql.getManager(121);
      } while (paramamql == null);
      paramamql = paramamql.a();
    } while (paramamql == null);
    paramamql.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqs
 * JD-Core Version:    0.7.0.1
 */