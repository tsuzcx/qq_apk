import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class apvr
  extends apvq
{
  public apvk a(String paramString)
  {
    QLog.d("ArkAIDictConfigProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      apwc localapwc = (apwc)apul.a(paramString, apwc.class);
      return new apvl(paramString, localapwc);
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
  
  public void a(apvk paramapvk)
  {
    super.a(paramapvk);
    if (paramapvk == null) {
      QLog.i("ArkAIDictConfigProcessor", 1, "newConf is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("ArkAIDictConfigProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramapvk.a());
          paramapvk = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        } while (paramapvk == null);
        paramapvk = (ArkAppCenter)paramapvk.getManager(121);
      } while (paramapvk == null);
      paramapvk = paramapvk.a();
    } while (paramapvk == null);
    paramapvk.a();
  }
  
  public int type()
  {
    return 170;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apvr
 * JD-Core Version:    0.7.0.1
 */