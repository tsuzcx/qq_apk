import android.support.annotation.NonNull;

public class bmet
{
  private final bmev jdField_a_of_type_Bmev;
  private final bmex jdField_a_of_type_Bmex;
  
  public bmet(@NonNull bmex parambmex, @NonNull bmev parambmev)
  {
    this.jdField_a_of_type_Bmev = parambmev;
    this.jdField_a_of_type_Bmex = parambmex;
  }
  
  public bmet(@NonNull bmey parambmey, @NonNull bmev parambmev)
  {
    this(parambmey.a(), parambmev);
  }
  
  @NonNull
  public <T extends bmes> T a(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + str, paramClass);
  }
  
  @NonNull
  public <T extends bmes> T a(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    bmes localbmes = this.jdField_a_of_type_Bmex.a(paramString);
    if (paramClass.isInstance(localbmes)) {
      return localbmes;
    }
    if (localbmes != null) {}
    paramClass = this.jdField_a_of_type_Bmev.a(paramClass);
    this.jdField_a_of_type_Bmex.a(paramString, paramClass);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmet
 * JD-Core Version:    0.7.0.1
 */