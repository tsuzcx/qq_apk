import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bmdv
  extends bmea
{
  private static volatile bmdv jdField_a_of_type_Bmdv;
  @NonNull
  private static final Executor jdField_a_of_type_JavaUtilConcurrentExecutor = new bmdw();
  @NonNull
  private static final Executor jdField_b_of_type_JavaUtilConcurrentExecutor = new bmdx();
  @NonNull
  private bmea jdField_a_of_type_Bmea = this.jdField_b_of_type_Bmea;
  @NonNull
  private bmea jdField_b_of_type_Bmea = new bmdy();
  
  @NonNull
  public static bmdv a()
  {
    if (jdField_a_of_type_Bmdv != null) {
      return jdField_a_of_type_Bmdv;
    }
    try
    {
      if (jdField_a_of_type_Bmdv == null) {
        jdField_a_of_type_Bmdv = new bmdv();
      }
      return jdField_a_of_type_Bmdv;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Bmea.a(paramRunnable);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bmea.a();
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Bmea.b(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdv
 * JD-Core Version:    0.7.0.1
 */