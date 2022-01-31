import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class blzj
  extends blzo
{
  private static volatile blzj jdField_a_of_type_Blzj;
  @NonNull
  private static final Executor jdField_a_of_type_JavaUtilConcurrentExecutor = new blzk();
  @NonNull
  private static final Executor jdField_b_of_type_JavaUtilConcurrentExecutor = new blzl();
  @NonNull
  private blzo jdField_a_of_type_Blzo = this.jdField_b_of_type_Blzo;
  @NonNull
  private blzo jdField_b_of_type_Blzo = new blzm();
  
  @NonNull
  public static blzj a()
  {
    if (jdField_a_of_type_Blzj != null) {
      return jdField_a_of_type_Blzj;
    }
    try
    {
      if (jdField_a_of_type_Blzj == null) {
        jdField_a_of_type_Blzj = new blzj();
      }
      return jdField_a_of_type_Blzj;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Blzo.a(paramRunnable);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Blzo.a();
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Blzo.b(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzj
 * JD-Core Version:    0.7.0.1
 */