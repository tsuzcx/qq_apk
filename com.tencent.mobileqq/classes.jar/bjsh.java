import java.util.ArrayList;

public class bjsh
{
  protected static bjsh a;
  protected ArrayList<bjvc> a;
  
  public static bjsh a()
  {
    try
    {
      if (jdField_a_of_type_Bjsh == null)
      {
        jdField_a_of_type_Bjsh = new bjsh();
        jdField_a_of_type_Bjsh.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      bjsh localbjsh = jdField_a_of_type_Bjsh;
      return localbjsh;
    }
    finally {}
  }
  
  public ArrayList<bjvc> a()
  {
    return jdField_a_of_type_Bjsh.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(bjvc parambjvc)
  {
    int j = jdField_a_of_type_Bjsh.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((bjvc)jdField_a_of_type_Bjsh.jdField_a_of_type_JavaUtilArrayList.get(i) == parambjvc) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Bjsh.jdField_a_of_type_JavaUtilArrayList.add(parambjvc);
  }
  
  public void b(bjvc parambjvc)
  {
    int j = jdField_a_of_type_Bjsh.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((bjvc)jdField_a_of_type_Bjsh.jdField_a_of_type_JavaUtilArrayList.get(i) == parambjvc) {
          jdField_a_of_type_Bjsh.jdField_a_of_type_JavaUtilArrayList.remove(i);
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
 * Qualified Name:     bjsh
 * JD-Core Version:    0.7.0.1
 */