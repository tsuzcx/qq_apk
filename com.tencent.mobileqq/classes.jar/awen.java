import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class awen
  implements DownloadParams.DecodeHandler
{
  private static final HashMap<String, ArrayList<Integer>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  Object jdField_a_of_type_JavaLangObject;
  String jdField_a_of_type_JavaLangString;
  WeakReference<aweo> jdField_a_of_type_JavaLangRefWeakReference;
  
  public awen(String paramString, aweo paramaweo, Object paramObject)
  {
    if (paramaweo != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaweo);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public static List<Integer> a(String paramString)
  {
    return (List)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (paramDownloadParams = null;; paramDownloadParams = (aweo)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      if (paramDownloadParams != null)
      {
        int[] arrayOfInt = aweq.a(Bitmap.createBitmap(paramBitmap, 0, paramBitmap.getHeight() / 2, paramBitmap.getWidth(), paramBitmap.getHeight() / 2));
        if ((arrayOfInt != null) && (arrayOfInt.length >= 2))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Integer.valueOf(arrayOfInt[0]));
          localArrayList.add(Integer.valueOf(arrayOfInt[1]));
          if (!jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_JavaLangString)) {
            jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, localArrayList);
          }
        }
        paramDownloadParams.a(this.jdField_a_of_type_JavaLangString, arrayOfInt[0], arrayOfInt[1], this.jdField_a_of_type_JavaLangObject);
      }
      return paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awen
 * JD-Core Version:    0.7.0.1
 */