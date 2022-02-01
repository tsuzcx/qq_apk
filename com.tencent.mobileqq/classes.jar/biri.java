import java.util.ArrayList;

public class biri
{
  protected static biri a;
  protected ArrayList<biud> a;
  
  public static biri a()
  {
    try
    {
      if (jdField_a_of_type_Biri == null)
      {
        jdField_a_of_type_Biri = new biri();
        jdField_a_of_type_Biri.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      biri localbiri = jdField_a_of_type_Biri;
      return localbiri;
    }
    finally {}
  }
  
  public ArrayList<biud> a()
  {
    return jdField_a_of_type_Biri.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(biud parambiud)
  {
    int j = jdField_a_of_type_Biri.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((biud)jdField_a_of_type_Biri.jdField_a_of_type_JavaUtilArrayList.get(i) == parambiud) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Biri.jdField_a_of_type_JavaUtilArrayList.add(parambiud);
  }
  
  public void b(biud parambiud)
  {
    int j = jdField_a_of_type_Biri.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((biud)jdField_a_of_type_Biri.jdField_a_of_type_JavaUtilArrayList.get(i) == parambiud) {
          jdField_a_of_type_Biri.jdField_a_of_type_JavaUtilArrayList.remove(i);
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
 * Qualified Name:     biri
 * JD-Core Version:    0.7.0.1
 */