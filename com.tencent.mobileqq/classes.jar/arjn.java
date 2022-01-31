import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class arjn
  implements Callable<Bundle>
{
  arjn(arjj paramarjj, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public Bundle a()
  {
    arek localarek = new arek();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Bundle[] arrayOfBundle = new Bundle[1];
    localarek.a(this.jdField_a_of_type_Arjj.a.c(), this.jdField_a_of_type_JavaLangString, this.b, this.c, new arjo(this, localarek, arrayOfBundle, localCountDownLatch), true, this.d);
    localCountDownLatch.await();
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arjn
 * JD-Core Version:    0.7.0.1
 */