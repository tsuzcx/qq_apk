import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class atuh
{
  public final String a;
  public final ArrayList<atuj> a;
  
  public atuh(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  }
  
  public static boolean a(atuj paramatuj)
  {
    return (paramatuj != null) && (!TextUtils.isEmpty(paramatuj.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramatuj.b));
  }
  
  public String a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      atuj localatuj = (atuj)localIterator.next();
      if ((a(localatuj)) && (paramString != null) && (paramString.equals(localatuj.jdField_a_of_type_JavaLangString))) {
        return localatuj.b;
      }
    }
    return null;
  }
  
  public void a(bakh parambakh)
  {
    if (parambakh == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        atuj localatuj = (atuj)localIterator.next();
        if (a(localatuj)) {
          parambakh.a(2131299262, localatuj.jdField_a_of_type_JavaLangString, 0);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new atuj(paramString1, paramString2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atuh
 * JD-Core Version:    0.7.0.1
 */