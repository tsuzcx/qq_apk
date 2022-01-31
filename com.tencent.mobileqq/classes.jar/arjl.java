import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class arjl
  implements Callable<Bundle>
{
  arjl(arjh paramarjh, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public Bundle a()
  {
    arei localarei = new arei();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Bundle[] arrayOfBundle = new Bundle[1];
    localarei.a(this.jdField_a_of_type_Arjh.a.c(), this.jdField_a_of_type_JavaLangString, this.b, this.c, new arjm(this, localarei, arrayOfBundle, localCountDownLatch), true, this.d);
    localCountDownLatch.await();
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arjl
 * JD-Core Version:    0.7.0.1
 */