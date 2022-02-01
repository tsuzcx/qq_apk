import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

public class bcnh
  extends bdpx
{
  private boolean jdField_a_of_type_Boolean;
  
  public bcnh(bcnd parambcnd) {}
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("postSwitch %d", new Object[] { Integer.valueOf(paramInt) }));
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_a_of_type_Boolean = true;
    switch (paramInt)
    {
    case 3: 
    default: 
      paramInt = 3;
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        if (!AppNetConnInfo.isNetSupport())
        {
          this.jdField_a_of_type_Bcnd.notifyUI(3, false, new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.jdField_a_of_type_Bcnd.jdField_a_of_type_Boolean), Integer.valueOf(6) });
          bool1 = this.jdField_a_of_type_Bcnd.a(false, "211", bcnj.b(), true, bcnj.a(bcnj.c()));
          if (!bool1) {
            bcnd.a(this.jdField_a_of_type_Bcnd, bcnd.a(this.jdField_a_of_type_Bcnd), -2147483648, bcnd.b(this.jdField_a_of_type_Bcnd), -2147483648, null, -2147483648);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("postSwitch net_err revert theme bStartSwtich=%b", new Object[] { Boolean.valueOf(bool1) }));
          return true;
          paramInt = 0;
          continue;
          paramInt = 3;
          continue;
          paramInt = 1;
          continue;
        }
        bcnd localbcnd = (bcnd)this.jdField_a_of_type_Bcnd.app.a(154);
        if (bcnd.a(this.jdField_a_of_type_Bcnd, bcnd.a(this.jdField_a_of_type_Bcnd)) == 1) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          paramInt = bcnd.a(this.jdField_a_of_type_Bcnd, bcnd.b(this.jdField_a_of_type_Bcnd));
          if (bcnd.a(this.jdField_a_of_type_Bcnd, bcnd.c(this.jdField_a_of_type_Bcnd)) == 1) {
            bool2 = true;
          }
          try
          {
            long l = localbcnd.a(bool1, paramInt, this.jdField_a_of_type_Bcnd.jdField_a_of_type_Boolean, bool2);
            bcnd.a(this.jdField_a_of_type_Bcnd).set(l);
            return true;
          }
          catch (Exception localException)
          {
            return true;
          }
        }
      }
    }
    bcnd.a(this.jdField_a_of_type_Bcnd, bcnd.a(this.jdField_a_of_type_Bcnd), -2147483648, bcnd.b(this.jdField_a_of_type_Bcnd), -2147483648, bcnd.c(this.jdField_a_of_type_Bcnd), -2147483648);
    this.jdField_a_of_type_Bcnd.notifyUI(3, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.jdField_a_of_type_Bcnd.jdField_a_of_type_Boolean), Integer.valueOf(paramInt) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnh
 * JD-Core Version:    0.7.0.1
 */