package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class eu
  extends et
{
  public static final eu a = new eu(Collections.emptyList(), 0L, 0);
  public final List<ScanResult> b;
  private final long c;
  private final int d;
  
  public eu(List<ScanResult> paramList, long paramLong, int paramInt)
  {
    this.c = paramLong;
    this.d = paramInt;
    this.b = new ArrayList(paramList);
  }
  
  public final boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 - this.c < paramLong2;
  }
  
  public final boolean a(eu parameu)
  {
    parameu = parameu.b;
    List localList = this.b;
    if ((parameu.size() == 0) || (localList.size() == 0)) {}
    while (co.a(parameu, localList)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.eu
 * JD-Core Version:    0.7.0.1
 */