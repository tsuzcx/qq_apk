import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aqmw
  extends aqmv
{
  public aqmp a(String paramString)
  {
    QLog.d("ArkAIDictConfigProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      aqnh localaqnh = (aqnh)aqlu.a(paramString, aqnh.class);
      return new aqmq(paramString, localaqnh);
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
  
  public void a(aqmp paramaqmp)
  {
    super.a(paramaqmp);
    if (paramaqmp == null) {
      QLog.i("ArkAIDictConfigProcessor", 1, "newConf is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("ArkAIDictConfigProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramaqmp.a());
          paramaqmp = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        } while (paramaqmp == null);
        paramaqmp = (ArkAppCenter)paramaqmp.getManager(121);
      } while (paramaqmp == null);
      paramaqmp = paramaqmp.a();
    } while (paramaqmp == null);
    paramaqmp.a();
  }
  
  public int type()
  {
    return 170;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqmw
 * JD-Core Version:    0.7.0.1
 */