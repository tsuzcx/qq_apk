import java.util.ArrayList;

public class bfim
{
  protected static bfim a;
  protected ArrayList<bfil> a;
  
  public static bfim a()
  {
    try
    {
      if (jdField_a_of_type_Bfim == null)
      {
        jdField_a_of_type_Bfim = new bfim();
        jdField_a_of_type_Bfim.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      bfim localbfim = jdField_a_of_type_Bfim;
      return localbfim;
    }
    finally {}
  }
  
  public ArrayList<bfil> a()
  {
    return jdField_a_of_type_Bfim.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(bfil parambfil)
  {
    int j = jdField_a_of_type_Bfim.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((bfil)jdField_a_of_type_Bfim.jdField_a_of_type_JavaUtilArrayList.get(i) == parambfil) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Bfim.jdField_a_of_type_JavaUtilArrayList.add(parambfil);
  }
  
  public void b(bfil parambfil)
  {
    int j = jdField_a_of_type_Bfim.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((bfil)jdField_a_of_type_Bfim.jdField_a_of_type_JavaUtilArrayList.get(i) == parambfil) {
          jdField_a_of_type_Bfim.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfim
 * JD-Core Version:    0.7.0.1
 */