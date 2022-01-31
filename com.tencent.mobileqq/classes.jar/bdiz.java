import java.util.ArrayList;

public class bdiz
{
  protected static bdiz a;
  protected ArrayList<bdiy> a;
  
  public static bdiz a()
  {
    try
    {
      if (jdField_a_of_type_Bdiz == null)
      {
        jdField_a_of_type_Bdiz = new bdiz();
        jdField_a_of_type_Bdiz.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      bdiz localbdiz = jdField_a_of_type_Bdiz;
      return localbdiz;
    }
    finally {}
  }
  
  public ArrayList<bdiy> a()
  {
    return jdField_a_of_type_Bdiz.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(bdiy parambdiy)
  {
    int j = jdField_a_of_type_Bdiz.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((bdiy)jdField_a_of_type_Bdiz.jdField_a_of_type_JavaUtilArrayList.get(i) == parambdiy) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Bdiz.jdField_a_of_type_JavaUtilArrayList.add(parambdiy);
  }
  
  public void b(bdiy parambdiy)
  {
    int j = jdField_a_of_type_Bdiz.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((bdiy)jdField_a_of_type_Bdiz.jdField_a_of_type_JavaUtilArrayList.get(i) == parambdiy) {
          jdField_a_of_type_Bdiz.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdiz
 * JD-Core Version:    0.7.0.1
 */