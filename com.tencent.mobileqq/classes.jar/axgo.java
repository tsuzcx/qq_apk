import android.content.Context;
import com.tencent.mobileqq.utils.NetworkUtil;

public class axgo
{
  public static int a(Context paramContext)
  {
    int i = NetworkUtil.getNetworkType(paramContext);
    if (i == 1) {
      return 2;
    }
    if (i == 2) {
      return 3;
    }
    if (i == 3) {
      return 4;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axgo
 * JD-Core Version:    0.7.0.1
 */