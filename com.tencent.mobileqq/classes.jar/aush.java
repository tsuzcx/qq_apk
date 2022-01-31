import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class aush
{
  public final String a;
  public final ArrayList<ausj> a;
  
  public aush(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  }
  
  public static boolean a(ausj paramausj)
  {
    return (paramausj != null) && (!TextUtils.isEmpty(paramausj.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramausj.b));
  }
  
  public String a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ausj localausj = (ausj)localIterator.next();
      if ((a(localausj)) && (paramString != null) && (paramString.equals(localausj.jdField_a_of_type_JavaLangString))) {
        return localausj.b;
      }
    }
    return null;
  }
  
  public void a(bbmf parambbmf)
  {
    if (parambbmf == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ausj localausj = (ausj)localIterator.next();
        if (a(localausj)) {
          parambbmf.a(2131364824, localausj.jdField_a_of_type_JavaLangString, 0);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new ausj(paramString1, paramString2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aush
 * JD-Core Version:    0.7.0.1
 */