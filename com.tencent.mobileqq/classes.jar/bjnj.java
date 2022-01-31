import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bjnj
  extends bjno
{
  private static volatile bjnj jdField_a_of_type_Bjnj;
  @NonNull
  private static final Executor jdField_a_of_type_JavaUtilConcurrentExecutor = new bjnk();
  @NonNull
  private static final Executor jdField_b_of_type_JavaUtilConcurrentExecutor = new bjnl();
  @NonNull
  private bjno jdField_a_of_type_Bjno = this.jdField_b_of_type_Bjno;
  @NonNull
  private bjno jdField_b_of_type_Bjno = new bjnm();
  
  @NonNull
  public static bjnj a()
  {
    if (jdField_a_of_type_Bjnj != null) {
      return jdField_a_of_type_Bjnj;
    }
    try
    {
      if (jdField_a_of_type_Bjnj == null) {
        jdField_a_of_type_Bjnj = new bjnj();
      }
      return jdField_a_of_type_Bjnj;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Bjno.a(paramRunnable);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bjno.a();
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Bjno.b(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnj
 * JD-Core Version:    0.7.0.1
 */