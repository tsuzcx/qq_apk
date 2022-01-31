import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.open.base.img.ImageCache;

public class bfdm
{
  protected static bfdm a;
  protected static byte[] a;
  protected LruCache<String, Bitmap> a;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected bfdm()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
  }
  
  public static bfdm a()
  {
    if (jdField_a_of_type_Bfdm == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bfdm == null) {
        jdField_a_of_type_Bfdm = new bfdm();
      }
      return jdField_a_of_type_Bfdm;
    }
  }
  
  public Bitmap a(String arg1)
  {
    Object localObject1 = bfhi.b(???);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      localObject1 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localObject1);
      return localObject1;
    }
  }
  
  public void a(String paramString)
  {
    String str = bfhi.b(paramString);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(str);
      ImageCache.a(paramString);
      return;
    }
  }
  
  public void a(String paramString, bfdo parambfdo)
  {
    ImageCache.a("app", paramString, new bfdn(this, parambfdo, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfdm
 * JD-Core Version:    0.7.0.1
 */