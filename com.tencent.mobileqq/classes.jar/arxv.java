import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class arxv
  extends QIPCModule
{
  private static volatile arxv a;
  
  private arxv(String paramString)
  {
    super(paramString);
  }
  
  public static arxv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new arxv("FlutterMainQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("ACTION_INSTALL_ENGINE".equals(paramString))
    {
      arxo.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new arxw(this));
      return EIPCResult.createSuccessResult(null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxv
 * JD-Core Version:    0.7.0.1
 */