package c.t.m.g;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public final class aa
{
  public ThreadPoolExecutor a;
  
  private aa()
  {
    StringBuilder localStringBuilder = new StringBuilder("halley_");
    localStringBuilder.append(m.c());
    localStringBuilder.append("_");
    localStringBuilder.append("BusinessTaskPool");
    this.a = ((ThreadPoolExecutor)Executors.newCachedThreadPool(new o(localStringBuilder.toString())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.aa
 * JD-Core Version:    0.7.0.1
 */