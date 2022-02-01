import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class arcc
  extends arca
{
  public arbu a(String paramString)
  {
    QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    for (;;)
    {
      try
      {
        arcn localarcn = (arcn)arax.a(paramString, arcn.class);
        arcx localarcx;
        QLog.i("ArkAIKeyWordConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException1);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException1)
      {
        try
        {
          localarcx = (arcx)arax.a(paramString, arcx.class);
          return new arbw(paramString, localarcn, localarcx);
        }
        catch (QStorageInstantiateException localQStorageInstantiateException2)
        {
          Object localObject;
          break label71;
        }
        localQStorageInstantiateException1 = localQStorageInstantiateException1;
        localarcn = null;
      }
      label71:
      localObject = null;
    }
  }
  
  public void a(arbu paramarbu)
  {
    super.a(paramarbu);
    if (paramarbu == null) {
      QLog.i("ArkAIKeyWordConfigProcessor", 1, "newConf is null");
    }
    apzu localapzu;
    do
    {
      return;
      QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramarbu.a());
      localapzu = ((ArkAppCenter)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(121)).a();
      paramarbu = paramarbu.a();
    } while (paramarbu == null);
    localapzu.a(paramarbu.a());
  }
  
  public int type()
  {
    return 186;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcc
 * JD-Core Version:    0.7.0.1
 */