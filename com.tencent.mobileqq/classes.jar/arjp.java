import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import mqq.util.WeakReference;

final class arjp
  implements Callable<Bundle>
{
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<arjj> jdField_a_of_type_MqqUtilWeakReference;
  private final String b;
  
  arjp(arjj paramarjj, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramarjj);
  }
  
  public Bundle a()
  {
    Object localObject = (arjj)this.jdField_a_of_type_MqqUtilWeakReference.get();
    Bundle[] arrayOfBundle = new Bundle[1];
    if (localObject != null)
    {
      arek localarek = new arek();
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localarek.a(((arjj)localObject).a, this.b, BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, new arjq(this, localarek, arrayOfBundle, localCountDownLatch));
      localCountDownLatch.await();
      return arrayOfBundle[0];
    }
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("isSuccess", false);
    ((Bundle)localObject).putInt("code", -1000);
    arrayOfBundle[0] = localObject;
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arjp
 * JD-Core Version:    0.7.0.1
 */