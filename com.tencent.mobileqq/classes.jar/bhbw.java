import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.turingfd.sdk.xq.TuringFdConfig;
import com.tencent.turingfd.sdk.xq.TuringFdConfig.Builder;
import com.tencent.turingfd.sdk.xq.TuringFdService;

public class bhbw
{
  private static boolean a;
  
  public static void a()
  {
    Context localContext = BaseApplicationImpl.getContext().getApplicationContext();
    if (!a) {
      QLog.d("TuringSdkInitHelper", 1, "init TuringSDK");
    }
    try
    {
      TuringFdService.init(TuringFdConfig.newBuilder(localContext, "").appid("1109803375").build());
      a = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TuringSdkInitHelper", 1, localThrowable, new Object[] { "Turing init crash fail" });
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbw
 * JD-Core Version:    0.7.0.1
 */