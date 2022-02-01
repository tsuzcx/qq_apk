import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class avkx
  implements Callable<Bundle>
{
  avkx(avkt paramavkt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public Bundle a()
  {
    avha localavha = new avha();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Bundle[] arrayOfBundle = new Bundle[1];
    localavha.a(this.jdField_a_of_type_Avkt.a.c(), this.jdField_a_of_type_JavaLangString, this.b, this.c, new avky(this, localavha, arrayOfBundle, localCountDownLatch), true, this.d);
    localCountDownLatch.await();
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkx
 * JD-Core Version:    0.7.0.1
 */