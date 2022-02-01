import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aqyv
  extends aqyt
{
  public aqyn a(String paramString)
  {
    QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    for (;;)
    {
      try
      {
        aqzg localaqzg = (aqzg)aqxo.a(paramString, aqzg.class);
        aqzq localaqzq;
        QLog.i("ArkAIKeyWordConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException1);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException1)
      {
        try
        {
          localaqzq = (aqzq)aqxo.a(paramString, aqzq.class);
          return new aqyp(paramString, localaqzg, localaqzq);
        }
        catch (QStorageInstantiateException localQStorageInstantiateException2)
        {
          Object localObject;
          break label71;
        }
        localQStorageInstantiateException1 = localQStorageInstantiateException1;
        localaqzg = null;
      }
      label71:
      localObject = null;
    }
  }
  
  public void a(aqyn paramaqyn)
  {
    super.a(paramaqyn);
    if (paramaqyn == null) {
      QLog.i("ArkAIKeyWordConfigProcessor", 1, "newConf is null");
    }
    apwl localapwl;
    do
    {
      return;
      QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramaqyn.a());
      localapwl = ((ArkAppCenter)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER)).a();
      paramaqyn = paramaqyn.a();
    } while (paramaqyn == null);
    localapwl.a(paramaqyn.a());
  }
  
  public int type()
  {
    return 186;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyv
 * JD-Core Version:    0.7.0.1
 */