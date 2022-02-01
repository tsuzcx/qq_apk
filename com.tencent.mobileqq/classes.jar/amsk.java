import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class amsk
{
  private static amsk jdField_a_of_type_Amsk;
  private Map<Long, amsl> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<Long, Long> b = new HashMap();
  
  public static amsk a()
  {
    if (jdField_a_of_type_Amsk == null) {
      jdField_a_of_type_Amsk = new amsk();
    }
    return jdField_a_of_type_Amsk;
  }
  
  public int a(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      amsl localamsl = (amsl)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      if (l - localamsl.jdField_a_of_type_Long < 3600000L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AntiFraud", 4, "Found from local cache, the fraud flag is true");
        }
        return localamsl.jdField_a_of_type_Int;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AntiFraud", 4, "Found from local cache, timestamp is out of data");
      }
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return 0;
    }
    if (this.b.containsKey(Long.valueOf(paramLong)))
    {
      if (l - ((Long)this.b.get(Long.valueOf(paramLong))).longValue() < 43200000L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AntiFraud", 4, "Found from local cache, the fraud flag is false");
        }
        return 0;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AntiFraud", 4, "Found from local cache, timestamp is out of data");
      }
      this.b.remove(Long.valueOf(paramLong));
      return 0;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AntiFraud", 4, "use default value, false");
    }
    return 0;
  }
  
  public void a(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (this.b.size() > 500) {
      this.b.clear();
    }
    this.b.put(Long.valueOf(paramLong), Long.valueOf(l));
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    long l = System.currentTimeMillis();
    amsl localamsl = new amsl(this);
    localamsl.jdField_a_of_type_Int = paramInt;
    localamsl.jdField_a_of_type_Long = l;
    if (this.jdField_a_of_type_JavaUtilMap.size() > 500) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localamsl);
    if (this.b.containsKey(Long.valueOf(paramLong))) {
      this.b.remove(Long.valueOf(paramLong));
    }
  }
  
  public boolean a(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      if (l - ((amsl)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Long > 3600000L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AntiFraud", 4, "FraudUin, Found from local cache, timestamp is out of data");
        }
        this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
        return true;
      }
      return false;
    }
    if (this.b.containsKey(Long.valueOf(paramLong)))
    {
      if (l - ((Long)this.b.get(Long.valueOf(paramLong))).longValue() > 43200000L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AntiFraud", 4, "NonFraudUin, Found from local cache, timestamp is out of data");
        }
        this.b.remove(Long.valueOf(paramLong));
        return true;
      }
      return false;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AntiFraud", 4, "Out of date, use default value, true!");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsk
 * JD-Core Version:    0.7.0.1
 */