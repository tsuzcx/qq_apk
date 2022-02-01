import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.img.ImageCache;

public class bhvs
{
  protected static bhvs a;
  protected static byte[] a;
  protected LruCache<String, Bitmap> a;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected bhvs()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
  }
  
  public static bhvs a()
  {
    if (jdField_a_of_type_Bhvs == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bhvs == null) {
        jdField_a_of_type_Bhvs = new bhvs();
      }
      return jdField_a_of_type_Bhvs;
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
  
  public void a(String paramString, bhvu parambhvu)
  {
    ImageCache.a("app", paramString, new bhvt(this, parambhvu, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvs
 * JD-Core Version:    0.7.0.1
 */