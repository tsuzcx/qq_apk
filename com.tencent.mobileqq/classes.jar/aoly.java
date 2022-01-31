import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aoly
  extends aolx
{
  public int a()
  {
    return 170;
  }
  
  public aolr a(String paramString)
  {
    QLog.d("ArkAIDictConfigProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      aomj localaomj = (aomj)aolc.a(paramString, aomj.class);
      return new aols(paramString, localaomj);
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
  
  public void a(aolr paramaolr)
  {
    super.a(paramaolr);
    if (paramaolr == null) {
      QLog.i("ArkAIDictConfigProcessor", 1, "newConf is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("ArkAIDictConfigProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramaolr.a());
          paramaolr = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        } while (paramaolr == null);
        paramaolr = (ArkAppCenter)paramaolr.getManager(121);
      } while (paramaolr == null);
      paramaolr = paramaolr.a();
    } while (paramaolr == null);
    paramaolr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoly
 * JD-Core Version:    0.7.0.1
 */