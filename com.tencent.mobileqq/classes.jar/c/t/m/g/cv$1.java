package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import java.util.Comparator;

final class cv$1
  implements Comparator<Object>
{
  public final int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (ScanResult)paramObject1;
    paramObject2 = (ScanResult)paramObject2;
    int i = 0;
    if (Build.VERSION.SDK_INT >= 17) {
      i = (int)(paramObject2.timestamp / 1000L / 1000L - paramObject1.timestamp / 1000L / 1000L);
    }
    int j = i;
    if (i == 0) {
      j = paramObject2.level - paramObject1.level;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.cv.1
 * JD-Core Version:    0.7.0.1
 */