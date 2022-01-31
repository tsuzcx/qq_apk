import java.util.HashMap;

public class bhar
{
  private static bhar jdField_a_of_type_Bhar;
  private HashMap<Integer, bhao> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bhar a()
  {
    if (jdField_a_of_type_Bhar == null) {
      jdField_a_of_type_Bhar = new bhar();
    }
    return jdField_a_of_type_Bhar;
  }
  
  public bhao a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      return null;
    }
    return (bhao)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, bhao parambhao)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), parambhao);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhar
 * JD-Core Version:    0.7.0.1
 */