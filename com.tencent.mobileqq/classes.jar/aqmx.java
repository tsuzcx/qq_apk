import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aqmx
  extends aqmv
{
  public aqmp a(String paramString)
  {
    QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    for (;;)
    {
      try
      {
        aqni localaqni = (aqni)aqlu.a(paramString, aqni.class);
        aqns localaqns;
        QLog.i("ArkAIKeyWordConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException1);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException1)
      {
        try
        {
          localaqns = (aqns)aqlu.a(paramString, aqns.class);
          return new aqmr(paramString, localaqni, localaqns);
        }
        catch (QStorageInstantiateException localQStorageInstantiateException2)
        {
          Object localObject;
          break label71;
        }
        localQStorageInstantiateException1 = localQStorageInstantiateException1;
        localaqni = null;
      }
      label71:
      localObject = null;
    }
  }
  
  public void a(aqmp paramaqmp)
  {
    super.a(paramaqmp);
    if (paramaqmp == null) {
      QLog.i("ArkAIKeyWordConfigProcessor", 1, "newConf is null");
    }
    apme localapme;
    do
    {
      return;
      QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramaqmp.a());
      localapme = ((ArkAppCenter)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(121)).a();
      paramaqmp = paramaqmp.a();
    } while (paramaqmp == null);
    localapme.a(paramaqmp.a());
  }
  
  public int type()
  {
    return 186;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqmx
 * JD-Core Version:    0.7.0.1
 */