import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;

public class blao
{
  public static final blao a;
  public static final blao[] a;
  public static final blao b;
  public static final blao[] b;
  public static final blao c;
  public final int a;
  public final String a;
  public final boolean a;
  public final int b;
  public final String b;
  
  static
  {
    jdField_a_of_type_Blao = new blao(-1, "215Config");
    jdField_b_of_type_Blao = new blao(0, "AEBasePackage", "new_qq_android_native_short_filter_", 72);
    c = new blao(1, "AEAdditionalPackage", "new_qq_android_native_ptu_res_", 77);
    jdField_a_of_type_ArrayOfBlao = new blao[] { jdField_a_of_type_Blao, jdField_b_of_type_Blao, c };
    jdField_b_of_type_ArrayOfBlao = a();
  }
  
  private blao(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private blao(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private static blao[] a()
  {
    LinkedList localLinkedList = new LinkedList();
    blao[] arrayOfblao = jdField_a_of_type_ArrayOfBlao;
    int j = arrayOfblao.length;
    int i = 0;
    while (i < j)
    {
      blao localblao = arrayOfblao[i];
      if (localblao.jdField_a_of_type_Boolean) {
        localLinkedList.add(localblao);
      }
      i += 1;
    }
    return (blao[])localLinkedList.toArray(new blao[0]);
  }
  
  @NonNull
  public String toString()
  {
    return "{index:" + this.jdField_a_of_type_Int + ", description:" + this.jdField_a_of_type_JavaLangString + ", resPrefix:" + this.jdField_b_of_type_JavaLangString + ", resVersion:" + this.jdField_b_of_type_Int + ", isPackage:" + this.jdField_a_of_type_Boolean + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blao
 * JD-Core Version:    0.7.0.1
 */