import android.os.Handler;
import android.os.Looper;

class awvl
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  awvl(awvk paramawvk)
  {
    Looper localLooper2 = Looper.myLooper();
    Looper localLooper1 = localLooper2;
    if (localLooper2 == null) {
      localLooper1 = Looper.getMainLooper();
    }
    if (localLooper1 != null)
    {
      this.jdField_a_of_type_AndroidOsHandler = new awvm(this, localLooper1, paramawvk);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvl
 * JD-Core Version:    0.7.0.1
 */