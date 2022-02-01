import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class avwd
  implements Callable<Bundle>
{
  avwd(avvz paramavvz, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public Bundle a()
  {
    avry localavry = new avry();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Bundle[] arrayOfBundle = new Bundle[1];
    localavry.a(this.jdField_a_of_type_Avvz.a.getCurrentUin(), this.jdField_a_of_type_JavaLangString, this.b, this.c, new avwe(this, localavry, arrayOfBundle, localCountDownLatch), true, this.d);
    localCountDownLatch.await();
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwd
 * JD-Core Version:    0.7.0.1
 */