import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class awjt
{
  public final String a;
  public final ArrayList<awjv> a;
  
  public awjt(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  }
  
  public static boolean a(awjv paramawjv)
  {
    return (paramawjv != null) && (!TextUtils.isEmpty(paramawjv.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramawjv.b));
  }
  
  public String a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      awjv localawjv = (awjv)localIterator.next();
      if ((a(localawjv)) && (paramString != null) && (paramString.equals(localawjv.jdField_a_of_type_JavaLangString))) {
        return localawjv.b;
      }
    }
    return null;
  }
  
  public void a(bdkz parambdkz)
  {
    if (parambdkz == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        awjv localawjv = (awjv)localIterator.next();
        if (a(localawjv)) {
          parambdkz.a(2131364910, localawjv.jdField_a_of_type_JavaLangString, 0);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new awjv(paramString1, paramString2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjt
 * JD-Core Version:    0.7.0.1
 */