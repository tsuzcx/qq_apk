import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.util.Pair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class azom
{
  public int a;
  private long jdField_a_of_type_Long;
  private azoq jdField_a_of_type_Azoq;
  public String a;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private long jdField_b_of_type_Long;
  private azoq jdField_b_of_type_Azoq;
  public String b;
  public String c;
  
  public azom(azok paramazok)
  {
    this.jdField_a_of_type_Azoq = new azoq(azok.a(paramazok), azok.a(paramazok));
    this.jdField_b_of_type_Azoq = new azoq(azok.b(paramazok), azok.b(paramazok));
  }
  
  public long a()
  {
    if (a()) {
      return SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    }
    return this.jdField_b_of_type_Long;
  }
  
  public Pair<Boolean, Long> a(PowerManager.WakeLock paramWakeLock, int paramInt)
  {
    long l;
    boolean bool;
    if ((!paramWakeLock.isHeld()) && (this.jdField_a_of_type_Long != 0L))
    {
      l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = l;
      bool = true;
    }
    for (;;)
    {
      return new Pair(Boolean.valueOf(bool), Long.valueOf(l));
      bool = false;
      l = 0L;
    }
  }
  
  public Pair<Boolean, List<azor>> a(PowerManager.WakeLock paramWakeLock, String paramString, long paramLong)
  {
    boolean bool = false;
    if (!paramWakeLock.isHeld())
    {
      bool = true;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    this.jdField_a_of_type_Azoq.a(paramString);
    return new Pair(Boolean.valueOf(bool), this.jdField_b_of_type_Azoq.a(paramString));
  }
  
  public Pair<Boolean, Integer> a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        paramString = new Pair(Boolean.valueOf(false), this.jdField_a_of_type_JavaUtilMap.get(paramString));
        return paramString;
      }
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(i));
      paramString = new Pair(Boolean.valueOf(true), Integer.valueOf(i));
      return paramString;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Azoq.a();
    this.jdField_b_of_type_Azoq.a();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azom
 * JD-Core Version:    0.7.0.1
 */