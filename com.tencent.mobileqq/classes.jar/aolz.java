import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aolz
  extends aolx
{
  public int a()
  {
    return 186;
  }
  
  public aolr a(String paramString)
  {
    QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    for (;;)
    {
      try
      {
        aomk localaomk = (aomk)aolc.a(paramString, aomk.class);
        aomu localaomu;
        QLog.i("ArkAIKeyWordConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException1);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException1)
      {
        try
        {
          localaomu = (aomu)aolc.a(paramString, aomu.class);
          return new aolt(paramString, localaomk, localaomu);
        }
        catch (QStorageInstantiateException localQStorageInstantiateException2)
        {
          Object localObject;
          break label71;
        }
        localQStorageInstantiateException1 = localQStorageInstantiateException1;
        localaomk = null;
      }
      label71:
      localObject = null;
    }
  }
  
  public void a(aolr paramaolr)
  {
    super.a(paramaolr);
    if (paramaolr == null) {
      QLog.i("ArkAIKeyWordConfigProcessor", 1, "newConf is null");
    }
    anly localanly;
    do
    {
      return;
      QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramaolr.a());
      localanly = ((ArkAppCenter)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(121)).a();
      paramaolr = paramaolr.a();
    } while (paramaolr == null);
    localanly.a(paramaolr.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aolz
 * JD-Core Version:    0.7.0.1
 */