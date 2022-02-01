import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class arcb
  extends arca
{
  public arbu a(String paramString)
  {
    QLog.d("ArkAIDictConfigProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      arcm localarcm = (arcm)arax.a(paramString, arcm.class);
      return new arbv(paramString, localarcm);
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
  
  public void a(arbu paramarbu)
  {
    super.a(paramarbu);
    if (paramarbu == null) {
      QLog.i("ArkAIDictConfigProcessor", 1, "newConf is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("ArkAIDictConfigProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramarbu.a());
          paramarbu = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        } while (paramarbu == null);
        paramarbu = (ArkAppCenter)paramarbu.getManager(121);
      } while (paramarbu == null);
      paramarbu = paramarbu.a();
    } while (paramarbu == null);
    paramarbu.a();
  }
  
  public int type()
  {
    return 170;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcb
 * JD-Core Version:    0.7.0.1
 */