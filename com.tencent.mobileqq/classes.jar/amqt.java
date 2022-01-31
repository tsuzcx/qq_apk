import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amqt
  extends amqr
{
  public int a()
  {
    return 186;
  }
  
  public amql a(String paramString)
  {
    QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    for (;;)
    {
      try
      {
        amre localamre = (amre)ampw.a(paramString, amre.class);
        amro localamro;
        QLog.i("ArkAIKeyWordConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException1);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException1)
      {
        try
        {
          localamro = (amro)ampw.a(paramString, amro.class);
          return new amqn(paramString, localamre, localamro);
        }
        catch (QStorageInstantiateException localQStorageInstantiateException2)
        {
          Object localObject;
          break label71;
        }
        localQStorageInstantiateException1 = localQStorageInstantiateException1;
        localamre = null;
      }
      label71:
      localObject = null;
    }
  }
  
  public void a(amql paramamql)
  {
    super.a(paramamql);
    if (paramamql == null) {
      QLog.i("ArkAIKeyWordConfigProcessor", 1, "newConf is null");
    }
    alqy localalqy;
    do
    {
      return;
      QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramamql.a());
      localalqy = ((ArkAppCenter)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(121)).a();
      paramamql = paramamql.a();
    } while (paramamql == null);
    localalqy.a(paramamql.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqt
 * JD-Core Version:    0.7.0.1
 */