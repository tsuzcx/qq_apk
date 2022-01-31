import android.os.Handler;
import android.os.Looper;

class asgo
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  asgo(asgn paramasgn)
  {
    Looper localLooper2 = Looper.myLooper();
    Looper localLooper1 = localLooper2;
    if (localLooper2 == null) {
      localLooper1 = Looper.getMainLooper();
    }
    if (localLooper1 != null)
    {
      this.jdField_a_of_type_AndroidOsHandler = new asgp(this, localLooper1, paramasgn);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asgo
 * JD-Core Version:    0.7.0.1
 */