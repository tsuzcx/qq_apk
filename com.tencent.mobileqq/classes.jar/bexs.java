import java.util.HashMap;

public class bexs
{
  private static bexs jdField_a_of_type_Bexs;
  private HashMap<Integer, bexp> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bexs a()
  {
    if (jdField_a_of_type_Bexs == null) {
      jdField_a_of_type_Bexs = new bexs();
    }
    return jdField_a_of_type_Bexs;
  }
  
  public bexp a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      return null;
    }
    return (bexp)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, bexp parambexp)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), parambexp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexs
 * JD-Core Version:    0.7.0.1
 */