import android.content.Context;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class auwx
  implements INativeRouter
{
  private static auwx a;
  
  public static auwx a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new auwx();
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
 * Qualified Name:     auwx
 * JD-Core Version:    0.7.0.1
 */