import android.content.Context;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class auoj
  implements INativeRouter
{
  private static auoj a;
  
  public static auoj a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new auoj();
      }
      return a;
    }
    finally {}
  }
  
  public void openContainer(Context paramContext, String paramString, Map<String, Object> paramMap1, int paramInt, Map<String, Object> paramMap2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.router", 2, String.format("openContainer: %s", new Object[] { paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auoj
 * JD-Core Version:    0.7.0.1
 */