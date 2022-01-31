import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.Manager;

public class bbhi
  implements Manager
{
  private HashMap<Long, ArrayList<bbhh>> a = new HashMap();
  
  public ArrayList<bbhh> a(long paramLong)
  {
    return (ArrayList)this.a.get(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, ArrayList<bbhh> paramArrayList)
  {
    this.a.put(Long.valueOf(paramLong), paramArrayList);
  }
  
  public void onDestroy()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhi
 * JD-Core Version:    0.7.0.1
 */