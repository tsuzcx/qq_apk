import android.support.annotation.NonNull;

public class bhwl
{
  private final bhwn jdField_a_of_type_Bhwn;
  private final bhwp jdField_a_of_type_Bhwp;
  
  public bhwl(@NonNull bhwp parambhwp, @NonNull bhwn parambhwn)
  {
    this.jdField_a_of_type_Bhwn = parambhwn;
    this.jdField_a_of_type_Bhwp = parambhwp;
  }
  
  public bhwl(@NonNull bhwq parambhwq, @NonNull bhwn parambhwn)
  {
    this(parambhwq.a(), parambhwn);
  }
  
  @NonNull
  public <T extends bhwk> T a(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + str, paramClass);
  }
  
  @NonNull
  public <T extends bhwk> T a(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    bhwk localbhwk = this.jdField_a_of_type_Bhwp.a(paramString);
    if (paramClass.isInstance(localbhwk)) {
      return localbhwk;
    }
    if (localbhwk != null) {}
    paramClass = this.jdField_a_of_type_Bhwn.a(paramClass);
    this.jdField_a_of_type_Bhwp.a(paramString, paramClass);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhwl
 * JD-Core Version:    0.7.0.1
 */