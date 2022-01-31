import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aohp
  extends aoho
{
  public int a()
  {
    return 170;
  }
  
  public aohi a(String paramString)
  {
    QLog.d("ArkAIDictConfigProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      aoia localaoia = (aoia)aogt.a(paramString, aoia.class);
      return new aohj(paramString, localaoia);
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
  
  public void a(aohi paramaohi)
  {
    super.a(paramaohi);
    if (paramaohi == null) {
      QLog.i("ArkAIDictConfigProcessor", 1, "newConf is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("ArkAIDictConfigProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramaohi.a());
          paramaohi = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        } while (paramaohi == null);
        paramaohi = (ArkAppCenter)paramaohi.getManager(121);
      } while (paramaohi == null);
      paramaohi = paramaohi.a();
    } while (paramaohi == null);
    paramaohi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aohp
 * JD-Core Version:    0.7.0.1
 */