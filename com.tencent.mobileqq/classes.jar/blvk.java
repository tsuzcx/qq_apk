import android.support.annotation.NonNull;
import java.util.List;

public class blvk
{
  public final int a;
  public final String a;
  public final List<String> a;
  public final String b;
  
  public blvk(@NonNull String paramString1, int paramInt, @NonNull String paramString2, @NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  @NonNull
  public String toString()
  {
    return "{packageName:" + this.jdField_a_of_type_JavaLangString + ", packageVersion:" + this.jdField_a_of_type_Int + ", packageZipPath:" + this.b + ", packageContentList:" + this.jdField_a_of_type_JavaUtilList + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvk
 * JD-Core Version:    0.7.0.1
 */