import java.util.HashMap;

public class bgwk
{
  private static bgwk jdField_a_of_type_Bgwk;
  private HashMap<Integer, bgwh> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bgwk a()
  {
    if (jdField_a_of_type_Bgwk == null) {
      jdField_a_of_type_Bgwk = new bgwk();
    }
    return jdField_a_of_type_Bgwk;
  }
  
  public bgwh a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      return null;
    }
    return (bgwh)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, bgwh parambgwh)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), parambgwh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwk
 * JD-Core Version:    0.7.0.1
 */