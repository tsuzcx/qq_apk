import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amqs
  extends amqq
{
  public int a()
  {
    return 186;
  }
  
  public amqk a(String paramString)
  {
    QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    for (;;)
    {
      try
      {
        amrd localamrd = (amrd)ampv.a(paramString, amrd.class);
        amrn localamrn;
        QLog.i("ArkAIKeyWordConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException1);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException1)
      {
        try
        {
          localamrn = (amrn)ampv.a(paramString, amrn.class);
          return new amqm(paramString, localamrd, localamrn);
        }
        catch (QStorageInstantiateException localQStorageInstantiateException2)
        {
          Object localObject;
          break label71;
        }
        localQStorageInstantiateException1 = localQStorageInstantiateException1;
        localamrd = null;
      }
      label71:
      localObject = null;
    }
  }
  
  public void a(amqk paramamqk)
  {
    super.a(paramamqk);
    if (paramamqk == null) {
      QLog.i("ArkAIKeyWordConfigProcessor", 1, "newConf is null");
    }
    alqx localalqx;
    do
    {
      return;
      QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramamqk.a());
      localalqx = ((ArkAppCenter)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(121)).a();
      paramamqk = paramamqk.a();
    } while (paramamqk == null);
    localalqx.a(paramamqk.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqs
 * JD-Core Version:    0.7.0.1
 */