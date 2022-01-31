import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class atab
  implements Callable<Bundle>
{
  atab(aszx paramaszx, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public Bundle a()
  {
    asuy localasuy = new asuy();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Bundle[] arrayOfBundle = new Bundle[1];
    localasuy.a(this.jdField_a_of_type_Aszx.a.c(), this.jdField_a_of_type_JavaLangString, this.b, this.c, new atac(this, localasuy, arrayOfBundle, localCountDownLatch), true, this.d);
    localCountDownLatch.await();
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atab
 * JD-Core Version:    0.7.0.1
 */