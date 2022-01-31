import java.util.HashMap;

public class bexb
{
  private static bexb jdField_a_of_type_Bexb;
  private HashMap<Integer, bewy> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bexb a()
  {
    if (jdField_a_of_type_Bexb == null) {
      jdField_a_of_type_Bexb = new bexb();
    }
    return jdField_a_of_type_Bexb;
  }
  
  public bewy a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      return null;
    }
    return (bewy)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, bewy parambewy)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), parambewy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexb
 * JD-Core Version:    0.7.0.1
 */