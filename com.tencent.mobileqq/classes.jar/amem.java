import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class amem
{
  public int a;
  public long a;
  public String a;
  public final HashMap<Integer, ameo> a;
  public final List<ameo> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public List<amen> b;
  public long c;
  public String c;
  public List<amen> c;
  public String d;
  public String e;
  
  public amem()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static String a(int paramInt)
  {
    if (paramInt > 999999) {
      return String.valueOf(999999) + "+";
    }
    return String.valueOf(paramInt);
  }
  
  public static String b(int paramInt)
  {
    if (paramInt > 99999) {
      return String.valueOf(99999) + "+";
    }
    return String.valueOf(paramInt);
  }
  
  public static String c(int paramInt)
  {
    if (paramInt > 9999) {
      return String.valueOf(9999) + "+";
    }
    return String.valueOf(paramInt);
  }
  
  public void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    label40:
    amen localamen;
    ameo localameo;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localamen = (amen)localIterator.next();
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(String.valueOf(localamen.jdField_a_of_type_Long))))
        {
          if (localamen.jdField_a_of_type_Short > 4) {
            break label165;
          }
          localameo = (ameo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
          if (localameo != null)
          {
            localameo.c += 1;
            this.jdField_b_of_type_Int += 1;
          }
        }
      }
    }
    for (;;)
    {
      if (this.c == null) {
        this.c = new ArrayList();
      }
      this.c.add(localamen);
      break label40;
      break;
      label165:
      localameo = (ameo)this.jdField_a_of_type_JavaUtilHashMap.get(Short.valueOf(localamen.jdField_a_of_type_Short));
      if (localameo != null)
      {
        localameo.c += localamen.f;
        this.jdField_b_of_type_Int += localamen.f;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amem
 * JD-Core Version:    0.7.0.1
 */