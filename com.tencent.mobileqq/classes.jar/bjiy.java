import java.util.ArrayList;

public class bjiy
{
  protected static bjiy a;
  protected ArrayList<bjlq> a;
  
  public static bjiy a()
  {
    try
    {
      if (jdField_a_of_type_Bjiy == null)
      {
        jdField_a_of_type_Bjiy = new bjiy();
        jdField_a_of_type_Bjiy.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      bjiy localbjiy = jdField_a_of_type_Bjiy;
      return localbjiy;
    }
    finally {}
  }
  
  public ArrayList<bjlq> a()
  {
    return jdField_a_of_type_Bjiy.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(bjlq parambjlq)
  {
    int j = jdField_a_of_type_Bjiy.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((bjlq)jdField_a_of_type_Bjiy.jdField_a_of_type_JavaUtilArrayList.get(i) == parambjlq) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Bjiy.jdField_a_of_type_JavaUtilArrayList.add(parambjlq);
  }
  
  public void b(bjlq parambjlq)
  {
    int j = jdField_a_of_type_Bjiy.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((bjlq)jdField_a_of_type_Bjiy.jdField_a_of_type_JavaUtilArrayList.get(i) == parambjlq) {
          jdField_a_of_type_Bjiy.jdField_a_of_type_JavaUtilArrayList.remove(i);
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
 * Qualified Name:     bjiy
 * JD-Core Version:    0.7.0.1
 */