import cooperation.qzone.statistic.access.concept.Statistic;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bjtf
{
  protected volatile ConcurrentLinkedQueue<Statistic> a = new ConcurrentLinkedQueue();
  
  public int a()
  {
    return this.a.size();
  }
  
  public Statistic a()
  {
    return (Statistic)this.a.poll();
  }
  
  public List<Statistic> a()
  {
    return a(a());
  }
  
  public List<Statistic> a(int paramInt)
  {
    Object localObject;
    if (paramInt < 1)
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i = Math.min(paramInt, a());
    paramInt = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (paramInt >= i) {
        break;
      }
      localObject = a();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramInt += 1;
    }
  }
  
  public void a(Statistic paramStatistic)
  {
    this.a.add(paramStatistic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjtf
 * JD-Core Version:    0.7.0.1
 */