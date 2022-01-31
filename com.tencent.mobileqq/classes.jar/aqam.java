import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class aqam
  extends QIPCModule
{
  private static volatile aqam a;
  
  private aqam(String paramString)
  {
    super(paramString);
  }
  
  public static aqam a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aqam("FlutterMainQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("ACTION_INSTALL_ENGINE".equals(paramString))
    {
      aqac.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new aqan(this));
      return EIPCResult.createSuccessResult(null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqam
 * JD-Core Version:    0.7.0.1
 */