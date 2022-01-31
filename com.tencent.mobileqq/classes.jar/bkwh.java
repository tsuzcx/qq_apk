import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;

public class bkwh
{
  public static final bkwh a;
  public static final bkwh[] a;
  public static final bkwh b;
  public static final bkwh[] b;
  public static final bkwh c;
  public final int a;
  public final String a;
  public final boolean a;
  public final int b;
  public final String b;
  
  static
  {
    jdField_a_of_type_Bkwh = new bkwh(-1, "215Config");
    jdField_b_of_type_Bkwh = new bkwh(0, "AEBasePackage", "new_qq_android_native_short_filter_", 72);
    c = new bkwh(1, "AEAdditionalPackage", "new_qq_android_native_ptu_res_", 77);
    jdField_a_of_type_ArrayOfBkwh = new bkwh[] { jdField_a_of_type_Bkwh, jdField_b_of_type_Bkwh, c };
    jdField_b_of_type_ArrayOfBkwh = a();
  }
  
  private bkwh(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private bkwh(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private static bkwh[] a()
  {
    LinkedList localLinkedList = new LinkedList();
    bkwh[] arrayOfbkwh = jdField_a_of_type_ArrayOfBkwh;
    int j = arrayOfbkwh.length;
    int i = 0;
    while (i < j)
    {
      bkwh localbkwh = arrayOfbkwh[i];
      if (localbkwh.jdField_a_of_type_Boolean) {
        localLinkedList.add(localbkwh);
      }
      i += 1;
    }
    return (bkwh[])localLinkedList.toArray(new bkwh[0]);
  }
  
  @NonNull
  public String toString()
  {
    return "{index:" + this.jdField_a_of_type_Int + ", description:" + this.jdField_a_of_type_JavaLangString + ", resPrefix:" + this.jdField_b_of_type_JavaLangString + ", resVersion:" + this.jdField_b_of_type_Int + ", isPackage:" + this.jdField_a_of_type_Boolean + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwh
 * JD-Core Version:    0.7.0.1
 */