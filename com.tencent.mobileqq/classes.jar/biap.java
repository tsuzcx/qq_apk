import java.util.ArrayList;

public class biap
{
  protected static biap a;
  protected ArrayList<biao> a;
  
  public static biap a()
  {
    try
    {
      if (jdField_a_of_type_Biap == null)
      {
        jdField_a_of_type_Biap = new biap();
        jdField_a_of_type_Biap.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      biap localbiap = jdField_a_of_type_Biap;
      return localbiap;
    }
    finally {}
  }
  
  public ArrayList<biao> a()
  {
    return jdField_a_of_type_Biap.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(biao parambiao)
  {
    int j = jdField_a_of_type_Biap.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((biao)jdField_a_of_type_Biap.jdField_a_of_type_JavaUtilArrayList.get(i) == parambiao) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Biap.jdField_a_of_type_JavaUtilArrayList.add(parambiao);
  }
  
  public void b(biao parambiao)
  {
    int j = jdField_a_of_type_Biap.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((biao)jdField_a_of_type_Biap.jdField_a_of_type_JavaUtilArrayList.get(i) == parambiao) {
          jdField_a_of_type_Biap.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biap
 * JD-Core Version:    0.7.0.1
 */