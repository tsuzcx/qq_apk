import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.img.ImageCache;

public class bjgt
{
  protected static bjgt a;
  protected static byte[] a;
  protected LruCache<String, Bitmap> a;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected bjgt()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
  }
  
  public static bjgt a()
  {
    if (jdField_a_of_type_Bjgt == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bjgt == null) {
        jdField_a_of_type_Bjgt = new bjgt();
      }
      return jdField_a_of_type_Bjgt;
    }
  }
  
  public Bitmap a(String arg1)
  {
    Object localObject1 = MD5Utils.encodeHexStr(???);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      localObject1 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localObject1);
      return localObject1;
    }
  }
  
  public void a(String paramString)
  {
    String str = MD5Utils.encodeHexStr(paramString);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(str);
      ImageCache.a(paramString);
      return;
    }
  }
  
  public void a(String paramString, bjgv parambjgv)
  {
    ImageCache.a("app", paramString, new bjgu(this, parambjgv, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgt
 * JD-Core Version:    0.7.0.1
 */