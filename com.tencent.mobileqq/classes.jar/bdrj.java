import java.util.HashMap;

public class bdrj
{
  private static bdrj jdField_a_of_type_Bdrj;
  private HashMap<Integer, bdrg> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bdrj a()
  {
    if (jdField_a_of_type_Bdrj == null) {
      jdField_a_of_type_Bdrj = new bdrj();
    }
    return jdField_a_of_type_Bdrj;
  }
  
  public bdrg a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      return null;
    }
    return (bdrg)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, bdrg parambdrg)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), parambdrg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdrj
 * JD-Core Version:    0.7.0.1
 */