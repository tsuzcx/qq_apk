import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.open.base.img.ImageCache;

public class bdeo
{
  protected static bdeo a;
  protected static byte[] a;
  protected LruCache<String, Bitmap> a;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected bdeo()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
  }
  
  public static bdeo a()
  {
    if (jdField_a_of_type_Bdeo == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bdeo == null) {
        jdField_a_of_type_Bdeo = new bdeo();
      }
      return jdField_a_of_type_Bdeo;
    }
  }
  
  public Bitmap a(String arg1)
  {
    Object localObject1 = bdik.b(???);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      localObject1 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localObject1);
      return localObject1;
    }
  }
  
  public void a(String paramString)
  {
    String str = bdik.b(paramString);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(str);
      ImageCache.a(paramString);
      return;
    }
  }
  
  public void a(String paramString, bdeq parambdeq)
  {
    ImageCache.a("app", paramString, new bdep(this, parambdeq, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdeo
 * JD-Core Version:    0.7.0.1
 */