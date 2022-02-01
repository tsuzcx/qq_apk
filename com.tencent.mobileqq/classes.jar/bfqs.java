import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.util.CustomLruCache;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class bfqs
{
  private CustomLruCache<String, Drawable> jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache;
  private final HashMap<String, WeakReference<Drawable>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public bfqs(int paramInt)
  {
    paramInt = Math.max(paramInt, 5);
    if (QLog.isColorLevel()) {
      QLog.d("ImageCache", 2, "Memory cache size = " + paramInt + "MB");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache = new bfqt(this, paramInt * 1024 * 1024);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.evictAll();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(String paramString, Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.get(paramString) == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.put(paramString, paramDrawable);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new WeakReference(paramDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqs
 * JD-Core Version:    0.7.0.1
 */