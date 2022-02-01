import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public class axfa
  implements ServiceConnection
{
  private WeakReference<axez> jdField_a_of_type_JavaLangRefWeakReference;
  
  public axfa(axey paramaxey, axez paramaxez)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaxez);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    axey.a(this.jdField_a_of_type_Axey, lvz.a(paramIBinder));
    paramComponentName = (axez)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bt();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    axey.a(this.jdField_a_of_type_Axey, null);
    paramComponentName = (axez)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axfa
 * JD-Core Version:    0.7.0.1
 */