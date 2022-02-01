import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public class awlb
  implements ServiceConnection
{
  private WeakReference<awla> jdField_a_of_type_JavaLangRefWeakReference;
  
  public awlb(awkz paramawkz, awla paramawla)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramawla);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    awkz.a(this.jdField_a_of_type_Awkz, lwg.a(paramIBinder));
    paramComponentName = (awla)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.g();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    awkz.a(this.jdField_a_of_type_Awkz, null);
    paramComponentName = (awla)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlb
 * JD-Core Version:    0.7.0.1
 */