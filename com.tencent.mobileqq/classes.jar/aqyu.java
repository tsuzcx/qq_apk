import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aqyu
  extends aqyt
{
  public aqyn a(String paramString)
  {
    QLog.d("ArkAIDictConfigProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      aqzf localaqzf = (aqzf)aqxo.a(paramString, aqzf.class);
      return new aqyo(paramString, localaqzf);
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
  
  public void a(aqyn paramaqyn)
  {
    super.a(paramaqyn);
    if (paramaqyn == null) {
      QLog.i("ArkAIDictConfigProcessor", 1, "newConf is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("ArkAIDictConfigProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramaqyn.a());
          paramaqyn = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        } while (paramaqyn == null);
        paramaqyn = (ArkAppCenter)paramaqyn.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
      } while (paramaqyn == null);
      paramaqyn = paramaqyn.a();
    } while (paramaqyn == null);
    paramaqyn.a();
  }
  
  public int type()
  {
    return 170;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyu
 * JD-Core Version:    0.7.0.1
 */