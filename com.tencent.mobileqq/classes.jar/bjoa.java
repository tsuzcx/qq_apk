import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bjoa
  extends bjof
{
  private static volatile bjoa jdField_a_of_type_Bjoa;
  @NonNull
  private static final Executor jdField_a_of_type_JavaUtilConcurrentExecutor = new bjob();
  @NonNull
  private static final Executor jdField_b_of_type_JavaUtilConcurrentExecutor = new bjoc();
  @NonNull
  private bjof jdField_a_of_type_Bjof = this.jdField_b_of_type_Bjof;
  @NonNull
  private bjof jdField_b_of_type_Bjof = new bjod();
  
  @NonNull
  public static bjoa a()
  {
    if (jdField_a_of_type_Bjoa != null) {
      return jdField_a_of_type_Bjoa;
    }
    try
    {
      if (jdField_a_of_type_Bjoa == null) {
        jdField_a_of_type_Bjoa = new bjoa();
      }
      return jdField_a_of_type_Bjoa;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Bjof.a(paramRunnable);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bjof.a();
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Bjof.b(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjoa
 * JD-Core Version:    0.7.0.1
 */