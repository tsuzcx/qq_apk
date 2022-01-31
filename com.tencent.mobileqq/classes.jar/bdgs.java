import java.util.ArrayList;

public class bdgs
{
  protected static bdgs a;
  protected ArrayList<bdjn> a;
  
  public static bdgs a()
  {
    try
    {
      if (jdField_a_of_type_Bdgs == null)
      {
        jdField_a_of_type_Bdgs = new bdgs();
        jdField_a_of_type_Bdgs.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      bdgs localbdgs = jdField_a_of_type_Bdgs;
      return localbdgs;
    }
    finally {}
  }
  
  public ArrayList<bdjn> a()
  {
    return jdField_a_of_type_Bdgs.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(bdjn parambdjn)
  {
    int j = jdField_a_of_type_Bdgs.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((bdjn)jdField_a_of_type_Bdgs.jdField_a_of_type_JavaUtilArrayList.get(i) == parambdjn) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Bdgs.jdField_a_of_type_JavaUtilArrayList.add(parambdjn);
  }
  
  public void b(bdjn parambdjn)
  {
    int j = jdField_a_of_type_Bdgs.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((bdjn)jdField_a_of_type_Bdgs.jdField_a_of_type_JavaUtilArrayList.get(i) == parambdjn) {
          jdField_a_of_type_Bdgs.jdField_a_of_type_JavaUtilArrayList.remove(i);
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
 * Qualified Name:     bdgs
 * JD-Core Version:    0.7.0.1
 */