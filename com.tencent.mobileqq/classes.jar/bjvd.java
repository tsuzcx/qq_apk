import java.util.ArrayList;

public class bjvd
{
  protected static bjvd a;
  protected ArrayList<bjvc> a;
  
  public static bjvd a()
  {
    try
    {
      if (jdField_a_of_type_Bjvd == null)
      {
        jdField_a_of_type_Bjvd = new bjvd();
        jdField_a_of_type_Bjvd.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      bjvd localbjvd = jdField_a_of_type_Bjvd;
      return localbjvd;
    }
    finally {}
  }
  
  public ArrayList<bjvc> a()
  {
    return jdField_a_of_type_Bjvd.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(bjvc parambjvc)
  {
    int j = jdField_a_of_type_Bjvd.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((bjvc)jdField_a_of_type_Bjvd.jdField_a_of_type_JavaUtilArrayList.get(i) == parambjvc) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Bjvd.jdField_a_of_type_JavaUtilArrayList.add(parambjvc);
  }
  
  public void b(bjvc parambjvc)
  {
    int j = jdField_a_of_type_Bjvd.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((bjvc)jdField_a_of_type_Bjvd.jdField_a_of_type_JavaUtilArrayList.get(i) == parambjvc) {
          jdField_a_of_type_Bjvd.jdField_a_of_type_JavaUtilArrayList.remove(i);
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
 * Qualified Name:     bjvd
 * JD-Core Version:    0.7.0.1
 */