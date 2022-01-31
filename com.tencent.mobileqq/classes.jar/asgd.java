import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public class asgd
  implements ServiceConnection
{
  private WeakReference<asgc> jdField_a_of_type_JavaLangRefWeakReference;
  
  public asgd(asgb paramasgb, asgc paramasgc)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramasgc);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    asgb.a(this.jdField_a_of_type_Asgb, llz.a(paramIBinder));
    paramComponentName = (asgc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.br();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    asgb.a(this.jdField_a_of_type_Asgb, null);
    paramComponentName = (asgc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asgd
 * JD-Core Version:    0.7.0.1
 */