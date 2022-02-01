import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;

public class borf
{
  public static final borf a;
  public static final borf[] a;
  public static final borf b;
  public static final borf[] b;
  public static final borf c;
  public final int a;
  public final String a;
  public final boolean a;
  public final int b;
  public final String b;
  public boolean b;
  public final int c;
  
  static
  {
    jdField_a_of_type_Borf = new borf(-1, "215Config");
    jdField_b_of_type_Borf = new borf(0, "AEBasePackage", "new_qq_android_native_short_filter_", 84503, 845);
    jdField_c_of_type_Borf = new borf(1, "AEAdditionalPackage", "new_qq_android_native_ptu_res_", 84503, 845);
    jdField_a_of_type_ArrayOfBorf = new borf[] { jdField_a_of_type_Borf, jdField_b_of_type_Borf, jdField_c_of_type_Borf };
    jdField_b_of_type_ArrayOfBorf = a();
  }
  
  private borf(int paramInt, String paramString)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private borf(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private static borf[] a()
  {
    LinkedList localLinkedList = new LinkedList();
    borf[] arrayOfborf = jdField_a_of_type_ArrayOfBorf;
    int j = arrayOfborf.length;
    int i = 0;
    while (i < j)
    {
      borf localborf = arrayOfborf[i];
      if (localborf.jdField_a_of_type_Boolean) {
        localLinkedList.add(localborf);
      }
      i += 1;
    }
    return (borf[])localLinkedList.toArray(new borf[0]);
  }
  
  @NonNull
  public String toString()
  {
    return "{index:" + this.jdField_a_of_type_Int + ", description:" + this.jdField_a_of_type_JavaLangString + ", resPrefix:" + this.jdField_b_of_type_JavaLangString + ", resVersionLimit:" + this.jdField_b_of_type_Int + ", resVersion:" + this.jdField_c_of_type_Int + ", isPackage:" + this.jdField_a_of_type_Boolean + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     borf
 * JD-Core Version:    0.7.0.1
 */