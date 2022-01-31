import android.support.annotation.NonNull;

public class bjox
{
  private final bjoz jdField_a_of_type_Bjoz;
  private final bjpb jdField_a_of_type_Bjpb;
  
  public bjox(@NonNull bjpb parambjpb, @NonNull bjoz parambjoz)
  {
    this.jdField_a_of_type_Bjoz = parambjoz;
    this.jdField_a_of_type_Bjpb = parambjpb;
  }
  
  public bjox(@NonNull bjpc parambjpc, @NonNull bjoz parambjoz)
  {
    this(parambjpc.a(), parambjoz);
  }
  
  @NonNull
  public <T extends bjow> T a(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + str, paramClass);
  }
  
  @NonNull
  public <T extends bjow> T a(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    bjow localbjow = this.jdField_a_of_type_Bjpb.a(paramString);
    if (paramClass.isInstance(localbjow)) {
      return localbjow;
    }
    if (localbjow != null) {}
    paramClass = this.jdField_a_of_type_Bjoz.a(paramClass);
    this.jdField_a_of_type_Bjpb.a(paramString, paramClass);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjox
 * JD-Core Version:    0.7.0.1
 */