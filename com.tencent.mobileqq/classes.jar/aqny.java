import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.concurrent.ConcurrentHashMap;

public class aqny
{
  private static int a;
  public ConcurrentHashMap<Long, aqob> a;
  
  static
  {
    jdField_a_of_type_Int = 900000;
  }
  
  private aqny()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static final aqny a()
  {
    return aqoa.a();
  }
  
  public aqob a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return (aqob)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void a()
  {
    aqmd.a().a().a(" LongVideoUrlCacheManager", 4, "LongVideoUrlCacheManager,clearCache");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(long paramLong1, String[] paramArrayOfString, long paramLong2, MessageForShortVideo paramMessageForShortVideo, int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), new aqob(this, paramArrayOfString, paramLong2, paramMessageForShortVideo, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqny
 * JD-Core Version:    0.7.0.1
 */