import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.open.base.img.ImageCache;

public class bbzz
{
  protected static bbzz a;
  protected static byte[] a;
  protected LruCache<String, Bitmap> a;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected bbzz()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
  }
  
  public static bbzz a()
  {
    if (jdField_a_of_type_Bbzz == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bbzz == null) {
        jdField_a_of_type_Bbzz = new bbzz();
      }
      return jdField_a_of_type_Bbzz;
    }
  }
  
  public Bitmap a(String arg1)
  {
    Object localObject1 = bcdu.b(???);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      localObject1 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localObject1);
      return localObject1;
    }
  }
  
  public void a(String paramString)
  {
    String str = bcdu.b(paramString);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(str);
      ImageCache.a(paramString);
      return;
    }
  }
  
  public void a(String paramString, bcab parambcab)
  {
    ImageCache.a("app", paramString, new bcaa(this, parambcab, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbzz
 * JD-Core Version:    0.7.0.1
 */