import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public abstract class bmyl
{
  public final int a;
  public final String a;
  public final int b;
  public String b;
  
  public bmyl(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
  }
  
  @NonNull
  public abstract bmym a(@NonNull Context paramContext, ViewGroup paramViewGroup);
  
  @NonNull
  public abstract Class<? extends bmym> a();
  
  public boolean a()
  {
    return false;
  }
  
  public String toString()
  {
    return "Filter:{" + this.jdField_a_of_type_JavaLangString + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyl
 * JD-Core Version:    0.7.0.1
 */