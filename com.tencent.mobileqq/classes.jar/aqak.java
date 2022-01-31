import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class aqak
  extends QIPCModule
{
  private static volatile aqak a;
  
  private aqak(String paramString)
  {
    super(paramString);
  }
  
  public static aqak a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aqak("FlutterMainQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("ACTION_INSTALL_ENGINE".equals(paramString))
    {
      aqaa.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new aqal(this));
      return EIPCResult.createSuccessResult(null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqak
 * JD-Core Version:    0.7.0.1
 */