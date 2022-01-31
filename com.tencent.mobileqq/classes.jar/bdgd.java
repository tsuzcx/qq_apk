import java.util.ArrayList;

public class bdgd
{
  protected static bdgd a;
  protected ArrayList<bdiy> a;
  
  public static bdgd a()
  {
    try
    {
      if (jdField_a_of_type_Bdgd == null)
      {
        jdField_a_of_type_Bdgd = new bdgd();
        jdField_a_of_type_Bdgd.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      bdgd localbdgd = jdField_a_of_type_Bdgd;
      return localbdgd;
    }
    finally {}
  }
  
  public ArrayList<bdiy> a()
  {
    return jdField_a_of_type_Bdgd.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(bdiy parambdiy)
  {
    int j = jdField_a_of_type_Bdgd.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((bdiy)jdField_a_of_type_Bdgd.jdField_a_of_type_JavaUtilArrayList.get(i) == parambdiy) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Bdgd.jdField_a_of_type_JavaUtilArrayList.add(parambdiy);
  }
  
  public void b(bdiy parambdiy)
  {
    int j = jdField_a_of_type_Bdgd.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((bdiy)jdField_a_of_type_Bdgd.jdField_a_of_type_JavaUtilArrayList.get(i) == parambdiy) {
          jdField_a_of_type_Bdgd.jdField_a_of_type_JavaUtilArrayList.remove(i);
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
 * Qualified Name:     bdgd
 * JD-Core Version:    0.7.0.1
 */