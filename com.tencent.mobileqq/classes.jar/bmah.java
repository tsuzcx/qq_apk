import android.support.annotation.NonNull;

public class bmah
{
  private final bmaj jdField_a_of_type_Bmaj;
  private final bmal jdField_a_of_type_Bmal;
  
  public bmah(@NonNull bmal parambmal, @NonNull bmaj parambmaj)
  {
    this.jdField_a_of_type_Bmaj = parambmaj;
    this.jdField_a_of_type_Bmal = parambmal;
  }
  
  public bmah(@NonNull bmam parambmam, @NonNull bmaj parambmaj)
  {
    this(parambmam.a(), parambmaj);
  }
  
  @NonNull
  public <T extends bmag> T a(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + str, paramClass);
  }
  
  @NonNull
  public <T extends bmag> T a(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    bmag localbmag = this.jdField_a_of_type_Bmal.a(paramString);
    if (paramClass.isInstance(localbmag)) {
      return localbmag;
    }
    if (localbmag != null) {}
    paramClass = this.jdField_a_of_type_Bmaj.a(paramClass);
    this.jdField_a_of_type_Bmal.a(paramString, paramClass);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmah
 * JD-Core Version:    0.7.0.1
 */