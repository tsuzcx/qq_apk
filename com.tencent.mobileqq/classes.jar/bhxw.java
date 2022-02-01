import java.util.ArrayList;

public class bhxw
{
  protected static bhxw a;
  protected ArrayList<biao> a;
  
  public static bhxw a()
  {
    try
    {
      if (jdField_a_of_type_Bhxw == null)
      {
        jdField_a_of_type_Bhxw = new bhxw();
        jdField_a_of_type_Bhxw.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      bhxw localbhxw = jdField_a_of_type_Bhxw;
      return localbhxw;
    }
    finally {}
  }
  
  public ArrayList<biao> a()
  {
    return jdField_a_of_type_Bhxw.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(biao parambiao)
  {
    int j = jdField_a_of_type_Bhxw.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((biao)jdField_a_of_type_Bhxw.jdField_a_of_type_JavaUtilArrayList.get(i) == parambiao) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Bhxw.jdField_a_of_type_JavaUtilArrayList.add(parambiao);
  }
  
  public void b(biao parambiao)
  {
    int j = jdField_a_of_type_Bhxw.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((biao)jdField_a_of_type_Bhxw.jdField_a_of_type_JavaUtilArrayList.get(i) == parambiao) {
          jdField_a_of_type_Bhxw.jdField_a_of_type_JavaUtilArrayList.remove(i);
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
 * Qualified Name:     bhxw
 * JD-Core Version:    0.7.0.1
 */