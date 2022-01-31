import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class atek
  implements Callable<Bundle>
{
  atek(ateg paramateg, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public Bundle a()
  {
    aszh localaszh = new aszh();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Bundle[] arrayOfBundle = new Bundle[1];
    localaszh.a(this.jdField_a_of_type_Ateg.a.c(), this.jdField_a_of_type_JavaLangString, this.b, this.c, new atel(this, localaszh, arrayOfBundle, localCountDownLatch), true, this.d);
    localCountDownLatch.await();
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atek
 * JD-Core Version:    0.7.0.1
 */