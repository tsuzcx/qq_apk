package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ee
  extends ed
{
  public static final ee a = new ee(Collections.emptyList(), 0L);
  private final List<ScanResult> b;
  private final long c;
  
  public ee(List<ScanResult> paramList, long paramLong)
  {
    this.c = paramLong;
    this.b = new ArrayList(paramList);
  }
  
  public final List<ScanResult> a()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public final boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 - this.c < paramLong2;
  }
  
  public final boolean a(ee paramee)
  {
    paramee = paramee.b;
    List localList = this.b;
    if ((paramee == null) || (localList == null)) {}
    while ((paramee.size() == 0) || (localList.size() == 0) || (f.a.a(paramee, localList))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ee
 * JD-Core Version:    0.7.0.1
 */