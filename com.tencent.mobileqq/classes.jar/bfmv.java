import java.util.ArrayList;

public class bfmv
{
  protected static bfmv a;
  protected ArrayList<bfmu> a;
  
  public static bfmv a()
  {
    try
    {
      if (jdField_a_of_type_Bfmv == null)
      {
        jdField_a_of_type_Bfmv = new bfmv();
        jdField_a_of_type_Bfmv.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      bfmv localbfmv = jdField_a_of_type_Bfmv;
      return localbfmv;
    }
    finally {}
  }
  
  public ArrayList<bfmu> a()
  {
    return jdField_a_of_type_Bfmv.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(bfmu parambfmu)
  {
    int j = jdField_a_of_type_Bfmv.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((bfmu)jdField_a_of_type_Bfmv.jdField_a_of_type_JavaUtilArrayList.get(i) == parambfmu) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_Bfmv.jdField_a_of_type_JavaUtilArrayList.add(parambfmu);
  }
  
  public void b(bfmu parambfmu)
  {
    int j = jdField_a_of_type_Bfmv.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((bfmu)jdField_a_of_type_Bfmv.jdField_a_of_type_JavaUtilArrayList.get(i) == parambfmu) {
          jdField_a_of_type_Bfmv.jdField_a_of_type_JavaUtilArrayList.remove(i);
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
 * Qualified Name:     bfmv
 * JD-Core Version:    0.7.0.1
 */