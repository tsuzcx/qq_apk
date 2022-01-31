import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.concurrent.ConcurrentHashMap;

public class aptw
{
  private static int a;
  public ConcurrentHashMap<Long, aptz> a;
  
  static
  {
    jdField_a_of_type_Int = 900000;
  }
  
  private aptw()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static final aptw a()
  {
    return apty.a();
  }
  
  public aptz a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return (aptz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void a()
  {
    apsm.a().a().a(" LongVideoUrlCacheManager", 4, "LongVideoUrlCacheManager,clearCache");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(long paramLong1, String[] paramArrayOfString, long paramLong2, MessageForShortVideo paramMessageForShortVideo, int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), new aptz(this, paramArrayOfString, paramLong2, paramMessageForShortVideo, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aptw
 * JD-Core Version:    0.7.0.1
 */