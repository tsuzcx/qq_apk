import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class artm
  extends QIPCModule
{
  private static volatile artm a;
  
  private artm(String paramString)
  {
    super(paramString);
  }
  
  public static artm a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new artm("FlutterMainQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("ACTION_INSTALL_ENGINE".equals(paramString))
    {
      artf.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new artn(this));
      return EIPCResult.createSuccessResult(null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artm
 * JD-Core Version:    0.7.0.1
 */