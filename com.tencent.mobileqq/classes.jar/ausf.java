import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class ausf
{
  public final String a;
  public final ArrayList<aush> a;
  
  public ausf(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  }
  
  public static boolean a(aush paramaush)
  {
    return (paramaush != null) && (!TextUtils.isEmpty(paramaush.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramaush.b));
  }
  
  public String a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aush localaush = (aush)localIterator.next();
      if ((a(localaush)) && (paramString != null) && (paramString.equals(localaush.jdField_a_of_type_JavaLangString))) {
        return localaush.b;
      }
    }
    return null;
  }
  
  public void a(bblr parambblr)
  {
    if (parambblr == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aush localaush = (aush)localIterator.next();
        if (a(localaush)) {
          parambblr.a(2131364825, localaush.jdField_a_of_type_JavaLangString, 0);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new aush(paramString1, paramString2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausf
 * JD-Core Version:    0.7.0.1
 */