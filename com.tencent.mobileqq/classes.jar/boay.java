import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class boay
{
  private List<boaz> a = Collections.synchronizedList(new ArrayList());
  
  void a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((boaz)localIterator.next()).a(paramLong);
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((boaz)localIterator.next()).a(paramLong, paramInt);
    }
  }
  
  public void a(boaz paramboaz)
  {
    if (paramboaz == null)
    {
      bnzb.c("LyricScrollHelper", "registerListener() lyricScrollListener == null.");
      return;
    }
    if (this.a == null)
    {
      bnzb.c("LyricScrollHelper", "registerListener() mScrollListener == null.");
      return;
    }
    this.a.add(paramboaz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boay
 * JD-Core Version:    0.7.0.1
 */