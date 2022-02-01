import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bmed
{
  private List<bmee> a = Collections.synchronizedList(new ArrayList());
  
  void a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bmee)localIterator.next()).a(paramLong);
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bmee)localIterator.next()).a(paramLong, paramInt);
    }
  }
  
  public void a(bmee parambmee)
  {
    if (parambmee == null)
    {
      bmbx.c("LyricScrollHelper", "registerListener() lyricScrollListener == null.");
      return;
    }
    if (this.a == null)
    {
      bmbx.c("LyricScrollHelper", "registerListener() mScrollListener == null.");
      return;
    }
    this.a.add(parambmee);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmed
 * JD-Core Version:    0.7.0.1
 */