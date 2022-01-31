import android.support.annotation.NonNull;

public class bjog
{
  private final bjoi jdField_a_of_type_Bjoi;
  private final bjok jdField_a_of_type_Bjok;
  
  public bjog(@NonNull bjok parambjok, @NonNull bjoi parambjoi)
  {
    this.jdField_a_of_type_Bjoi = parambjoi;
    this.jdField_a_of_type_Bjok = parambjok;
  }
  
  public bjog(@NonNull bjol parambjol, @NonNull bjoi parambjoi)
  {
    this(parambjol.a(), parambjoi);
  }
  
  @NonNull
  public <T extends bjof> T a(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + str, paramClass);
  }
  
  @NonNull
  public <T extends bjof> T a(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    bjof localbjof = this.jdField_a_of_type_Bjok.a(paramString);
    if (paramClass.isInstance(localbjof)) {
      return localbjof;
    }
    if (localbjof != null) {}
    paramClass = this.jdField_a_of_type_Bjoi.a(paramClass);
    this.jdField_a_of_type_Bjok.a(paramString, paramClass);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjog
 * JD-Core Version:    0.7.0.1
 */