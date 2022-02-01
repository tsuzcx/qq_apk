import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public class axrd
  implements ServiceConnection
{
  private WeakReference<axrc> jdField_a_of_type_JavaLangRefWeakReference;
  
  public axrd(axrb paramaxrb, axrc paramaxrc)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaxrc);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    axrb.a(this.jdField_a_of_type_Axrb, lwt.a(paramIBinder));
    paramComponentName = (axrc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.g();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    axrb.a(this.jdField_a_of_type_Axrb, null);
    paramComponentName = (axrc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axrd
 * JD-Core Version:    0.7.0.1
 */