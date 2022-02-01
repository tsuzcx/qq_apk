import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.open.base.img.ImageCache;

public class bjqd
{
  protected static bjqd a;
  protected static byte[] a;
  protected LruCache<String, Bitmap> a;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected bjqd()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
  }
  
  public static bjqd a()
  {
    if (jdField_a_of_type_Bjqd == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bjqd == null) {
        jdField_a_of_type_Bjqd = new bjqd();
      }
      return jdField_a_of_type_Bjqd;
    }
  }
  
  public Bitmap a(String arg1)
  {
    Object localObject1 = bjtz.b(???);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      localObject1 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localObject1);
      return localObject1;
    }
  }
  
  public void a(String paramString)
  {
    String str = bjtz.b(paramString);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(str);
      ImageCache.a(paramString);
      return;
    }
  }
  
  public void a(String paramString, bjqf parambjqf)
  {
    ImageCache.a("app", paramString, new bjqe(this, parambjqf, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjqd
 * JD-Core Version:    0.7.0.1
 */