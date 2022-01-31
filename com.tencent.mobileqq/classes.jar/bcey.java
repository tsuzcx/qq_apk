import java.util.ArrayList;

public class bcey
{
  protected static bcey a;
  protected ArrayList<bcex> a;
  
  public static bcey a()
  {
    try
    {
      if (jdField_a_of_type_Bcey == null)
      {
        jdField_a_of_type_Bcey = new bcey();
        jdField_a_of_type_Bcey.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      bcey localbcey = jdField_a_of_type_Bcey;
      return localbcey;
    }
    finally {}
  }
  
  public ArrayList<bcex> a()
  {
    return jdField_a_of_type_Bcey.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(bcex parambcex)
  {
    int j = jdField_a_of_type_Bcey.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((bcex)jdField_a_of_type_Bcey.jdField_a_of_type_JavaUtilArrayList.get(i) == parambcex) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Bcey.jdField_a_of_type_JavaUtilArrayList.add(parambcex);
  }
  
  public void b(bcex parambcex)
  {
    int j = jdField_a_of_type_Bcey.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((bcex)jdField_a_of_type_Bcey.jdField_a_of_type_JavaUtilArrayList.get(i) == parambcex) {
          jdField_a_of_type_Bcey.jdField_a_of_type_JavaUtilArrayList.remove(i);
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
 * Qualified Name:     bcey
 * JD-Core Version:    0.7.0.1
 */