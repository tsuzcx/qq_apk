import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amqr
  extends amqq
{
  public int a()
  {
    return 170;
  }
  
  public amqk a(String paramString)
  {
    QLog.d("ArkAIDictConfigProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      amrc localamrc = (amrc)ampv.a(paramString, amrc.class);
      return new amql(paramString, localamrc);
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
  
  public void a(amqk paramamqk)
  {
    super.a(paramamqk);
    if (paramamqk == null) {
      QLog.i("ArkAIDictConfigProcessor", 1, "newConf is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("ArkAIDictConfigProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramamqk.a());
          paramamqk = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        } while (paramamqk == null);
        paramamqk = (ArkAppCenter)paramamqk.getManager(121);
      } while (paramamqk == null);
      paramamqk = paramamqk.a();
    } while (paramamqk == null);
    paramamqk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqr
 * JD-Core Version:    0.7.0.1
 */