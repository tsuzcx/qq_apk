import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class awdi
  implements Callable<Bundle>
{
  awdi(awde paramawde, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public Bundle a()
  {
    avzd localavzd = new avzd();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Bundle[] arrayOfBundle = new Bundle[1];
    localavzd.a(this.jdField_a_of_type_Awde.a.c(), this.jdField_a_of_type_JavaLangString, this.b, this.c, new awdj(this, localavzd, arrayOfBundle, localCountDownLatch), true, this.d);
    localCountDownLatch.await();
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdi
 * JD-Core Version:    0.7.0.1
 */