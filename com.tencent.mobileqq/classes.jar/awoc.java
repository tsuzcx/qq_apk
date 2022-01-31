import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class awoc
{
  public final String a;
  public final ArrayList<awoe> a;
  
  public awoc(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  }
  
  public static boolean a(awoe paramawoe)
  {
    return (paramawoe != null) && (!TextUtils.isEmpty(paramawoe.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramawoe.b));
  }
  
  public String a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      awoe localawoe = (awoe)localIterator.next();
      if ((a(localawoe)) && (paramString != null) && (paramString.equals(localawoe.jdField_a_of_type_JavaLangString))) {
        return localawoe.b;
      }
    }
    return null;
  }
  
  public void a(bdpi parambdpi)
  {
    if (parambdpi == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        awoe localawoe = (awoe)localIterator.next();
        if (a(localawoe)) {
          parambdpi.a(2131364912, localawoe.jdField_a_of_type_JavaLangString, 0);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new awoe(paramString1, paramString2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awoc
 * JD-Core Version:    0.7.0.1
 */