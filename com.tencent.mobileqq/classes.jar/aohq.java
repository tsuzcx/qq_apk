import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aohq
  extends aoho
{
  public int a()
  {
    return 186;
  }
  
  public aohi a(String paramString)
  {
    QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    for (;;)
    {
      try
      {
        aoib localaoib = (aoib)aogt.a(paramString, aoib.class);
        aoil localaoil;
        QLog.i("ArkAIKeyWordConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException1);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException1)
      {
        try
        {
          localaoil = (aoil)aogt.a(paramString, aoil.class);
          return new aohk(paramString, localaoib, localaoil);
        }
        catch (QStorageInstantiateException localQStorageInstantiateException2)
        {
          Object localObject;
          break label71;
        }
        localQStorageInstantiateException1 = localQStorageInstantiateException1;
        localaoib = null;
      }
      label71:
      localObject = null;
    }
  }
  
  public void a(aohi paramaohi)
  {
    super.a(paramaohi);
    if (paramaohi == null) {
      QLog.i("ArkAIKeyWordConfigProcessor", 1, "newConf is null");
    }
    anhp localanhp;
    do
    {
      return;
      QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramaohi.a());
      localanhp = ((ArkAppCenter)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(121)).a();
      paramaohi = paramaohi.a();
    } while (paramaohi == null);
    localanhp.a(paramaohi.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aohq
 * JD-Core Version:    0.7.0.1
 */