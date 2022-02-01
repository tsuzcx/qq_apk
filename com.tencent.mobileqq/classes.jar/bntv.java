import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bntv
{
  private List<bntw> a = Collections.synchronizedList(new ArrayList());
  
  void a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bntw)localIterator.next()).a(paramLong);
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((bntw)localIterator.next()).a(paramLong, paramInt);
    }
  }
  
  public void a(bntw parambntw)
  {
    if (parambntw == null)
    {
      bnrh.c("LyricScrollHelper", "registerListener() lyricScrollListener == null.");
      return;
    }
    if (this.a == null)
    {
      bnrh.c("LyricScrollHelper", "registerListener() mScrollListener == null.");
      return;
    }
    this.a.add(parambntw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntv
 * JD-Core Version:    0.7.0.1
 */