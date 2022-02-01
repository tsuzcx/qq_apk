import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public class axxt
  implements ServiceConnection
{
  private WeakReference<axxs> jdField_a_of_type_JavaLangRefWeakReference;
  
  public axxt(axxr paramaxxr, axxs paramaxxs)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaxxs);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    axxr.a(this.jdField_a_of_type_Axxr, lwv.a(paramIBinder));
    paramComponentName = (axxs)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bt();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    axxr.a(this.jdField_a_of_type_Axxr, null);
    paramComponentName = (axxs)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxt
 * JD-Core Version:    0.7.0.1
 */