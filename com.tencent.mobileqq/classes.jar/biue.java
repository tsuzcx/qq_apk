import java.util.ArrayList;

public class biue
{
  protected static biue a;
  protected ArrayList<biud> a;
  
  public static biue a()
  {
    try
    {
      if (jdField_a_of_type_Biue == null)
      {
        jdField_a_of_type_Biue = new biue();
        jdField_a_of_type_Biue.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      biue localbiue = jdField_a_of_type_Biue;
      return localbiue;
    }
    finally {}
  }
  
  public ArrayList<biud> a()
  {
    return jdField_a_of_type_Biue.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(biud parambiud)
  {
    int j = jdField_a_of_type_Biue.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((biud)jdField_a_of_type_Biue.jdField_a_of_type_JavaUtilArrayList.get(i) == parambiud) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Biue.jdField_a_of_type_JavaUtilArrayList.add(parambiud);
  }
  
  public void b(biud parambiud)
  {
    int j = jdField_a_of_type_Biue.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((biud)jdField_a_of_type_Biue.jdField_a_of_type_JavaUtilArrayList.get(i) == parambiud) {
          jdField_a_of_type_Biue.jdField_a_of_type_JavaUtilArrayList.remove(i);
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
 * Qualified Name:     biue
 * JD-Core Version:    0.7.0.1
 */