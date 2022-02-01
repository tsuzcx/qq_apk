import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class apvs
  extends apvq
{
  public apvk a(String paramString)
  {
    QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    for (;;)
    {
      try
      {
        apwd localapwd = (apwd)apul.a(paramString, apwd.class);
        apwn localapwn;
        QLog.i("ArkAIKeyWordConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException1);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException1)
      {
        try
        {
          localapwn = (apwn)apul.a(paramString, apwn.class);
          return new apvm(paramString, localapwd, localapwn);
        }
        catch (QStorageInstantiateException localQStorageInstantiateException2)
        {
          Object localObject;
          break label71;
        }
        localQStorageInstantiateException1 = localQStorageInstantiateException1;
        localapwd = null;
      }
      label71:
      localObject = null;
    }
  }
  
  public void a(apvk paramapvk)
  {
    super.a(paramapvk);
    if (paramapvk == null) {
      QLog.i("ArkAIKeyWordConfigProcessor", 1, "newConf is null");
    }
    aoth localaoth;
    do
    {
      return;
      QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramapvk.a());
      localaoth = ((ArkAppCenter)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(121)).a();
      paramapvk = paramapvk.a();
    } while (paramapvk == null);
    localaoth.a(paramapvk.a());
  }
  
  public int type()
  {
    return 186;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apvs
 * JD-Core Version:    0.7.0.1
 */