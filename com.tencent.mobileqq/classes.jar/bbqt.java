import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.util.concurrent.ConcurrentHashMap;

public class bbqt
{
  private static int a;
  public ConcurrentHashMap<Long, bbqw> a;
  
  static
  {
    jdField_a_of_type_Int = 900000;
  }
  
  private bbqt()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static final bbqt a()
  {
    return bbqv.a();
  }
  
  public bbqw a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return (bbqw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void a()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d(" LongVideoUrlCacheManager", 4, "LongVideoUrlCacheManager,clearCache");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(long paramLong1, String[] paramArrayOfString, long paramLong2, MessageForShortVideo paramMessageForShortVideo, int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), new bbqw(this, paramArrayOfString, paramLong2, paramMessageForShortVideo, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqt
 * JD-Core Version:    0.7.0.1
 */