import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bpct
{
  private List<bpcu> a = Collections.synchronizedList(new ArrayList());
  
  void a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bpcu)localIterator.next()).a(paramLong);
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bpcu)localIterator.next()).a(paramLong, paramInt);
    }
  }
  
  public void a(bpcu parambpcu)
  {
    if (parambpcu == null)
    {
      bpam.c("LyricScrollHelper", "registerListener() lyricScrollListener == null.");
      return;
    }
    if (this.a == null)
    {
      bpam.c("LyricScrollHelper", "registerListener() mScrollListener == null.");
      return;
    }
    this.a.add(parambpcu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpct
 * JD-Core Version:    0.7.0.1
 */