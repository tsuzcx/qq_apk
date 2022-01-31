import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bhvo
  extends bhvt
{
  private static volatile bhvo jdField_a_of_type_Bhvo;
  @NonNull
  private static final Executor jdField_a_of_type_JavaUtilConcurrentExecutor = new bhvp();
  @NonNull
  private static final Executor jdField_b_of_type_JavaUtilConcurrentExecutor = new bhvq();
  @NonNull
  private bhvt jdField_a_of_type_Bhvt = this.jdField_b_of_type_Bhvt;
  @NonNull
  private bhvt jdField_b_of_type_Bhvt = new bhvr();
  
  @NonNull
  public static bhvo a()
  {
    if (jdField_a_of_type_Bhvo != null) {
      return jdField_a_of_type_Bhvo;
    }
    try
    {
      if (jdField_a_of_type_Bhvo == null) {
        jdField_a_of_type_Bhvo = new bhvo();
      }
      return jdField_a_of_type_Bhvo;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Bhvt.a(paramRunnable);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bhvt.a();
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Bhvt.b(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhvo
 * JD-Core Version:    0.7.0.1
 */