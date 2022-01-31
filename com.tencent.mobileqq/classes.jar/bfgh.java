import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashSet;
import java.util.Set;

public class bfgh
{
  private static final Set<Integer> a = new HashSet();
  
  static
  {
    a.add(Integer.valueOf(3001));
    a.add(Integer.valueOf(3002));
    a.add(Integer.valueOf(3003));
    a.add(Integer.valueOf(3004));
    a.add(Integer.valueOf(3005));
    a.add(Integer.valueOf(3006));
    a.add(Integer.valueOf(3007));
    a.add(Integer.valueOf(3008));
    a.add(Integer.valueOf(3009));
    a.add(Integer.valueOf(3010));
    a.add(Integer.valueOf(3011));
    a.add(Integer.valueOf(3012));
    a.add(Integer.valueOf(3013));
    a.add(Integer.valueOf(1001));
    a.add(Integer.valueOf(1022));
  }
  
  public static boolean a(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null) && (a.contains(Integer.valueOf(paramMiniAppInfo.launchParam.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfgh
 * JD-Core Version:    0.7.0.1
 */