import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;

public class bnkt
{
  public static final bnkt a;
  public static final bnkt[] a;
  public static final bnkt b;
  public static final bnkt[] b;
  public static final bnkt c;
  public final int a;
  public final String a;
  public final boolean a;
  public final int b;
  public final String b;
  public boolean b;
  public final int c;
  
  static
  {
    jdField_a_of_type_Bnkt = new bnkt(-1, "215Config");
    jdField_b_of_type_Bnkt = new bnkt(0, "AEBasePackage", "new_qq_android_native_short_filter_", 841033, 8410);
    jdField_c_of_type_Bnkt = new bnkt(1, "AEAdditionalPackage", "new_qq_android_native_ptu_res_", 841033, 8410);
    jdField_a_of_type_ArrayOfBnkt = new bnkt[] { jdField_a_of_type_Bnkt, jdField_b_of_type_Bnkt, jdField_c_of_type_Bnkt };
    jdField_b_of_type_ArrayOfBnkt = a();
  }
  
  private bnkt(int paramInt, String paramString)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private bnkt(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private static bnkt[] a()
  {
    LinkedList localLinkedList = new LinkedList();
    bnkt[] arrayOfbnkt = jdField_a_of_type_ArrayOfBnkt;
    int j = arrayOfbnkt.length;
    int i = 0;
    while (i < j)
    {
      bnkt localbnkt = arrayOfbnkt[i];
      if (localbnkt.jdField_a_of_type_Boolean) {
        localLinkedList.add(localbnkt);
      }
      i += 1;
    }
    return (bnkt[])localLinkedList.toArray(new bnkt[0]);
  }
  
  @NonNull
  public String toString()
  {
    return "{index:" + this.jdField_a_of_type_Int + ", description:" + this.jdField_a_of_type_JavaLangString + ", resPrefix:" + this.jdField_b_of_type_JavaLangString + ", resVersionLimit:" + this.jdField_b_of_type_Int + ", resVersion:" + this.jdField_c_of_type_Int + ", isPackage:" + this.jdField_a_of_type_Boolean + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkt
 * JD-Core Version:    0.7.0.1
 */