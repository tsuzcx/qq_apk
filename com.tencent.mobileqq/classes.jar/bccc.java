import java.util.ArrayList;

public class bccc
{
  protected static bccc a;
  protected ArrayList<bcex> a;
  
  public static bccc a()
  {
    try
    {
      if (jdField_a_of_type_Bccc == null)
      {
        jdField_a_of_type_Bccc = new bccc();
        jdField_a_of_type_Bccc.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      bccc localbccc = jdField_a_of_type_Bccc;
      return localbccc;
    }
    finally {}
  }
  
  public ArrayList<bcex> a()
  {
    return jdField_a_of_type_Bccc.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(bcex parambcex)
  {
    int j = jdField_a_of_type_Bccc.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((bcex)jdField_a_of_type_Bccc.jdField_a_of_type_JavaUtilArrayList.get(i) == parambcex) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Bccc.jdField_a_of_type_JavaUtilArrayList.add(parambcex);
  }
  
  public void b(bcex parambcex)
  {
    int j = jdField_a_of_type_Bccc.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((bcex)jdField_a_of_type_Bccc.jdField_a_of_type_JavaUtilArrayList.get(i) == parambcex) {
          jdField_a_of_type_Bccc.jdField_a_of_type_JavaUtilArrayList.remove(i);
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
 * Qualified Name:     bccc
 * JD-Core Version:    0.7.0.1
 */