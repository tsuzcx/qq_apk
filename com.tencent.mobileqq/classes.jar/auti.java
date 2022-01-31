import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public class auti
  implements ServiceConnection
{
  private WeakReference<auth> jdField_a_of_type_JavaLangRefWeakReference;
  
  public auti(autg paramautg, auth paramauth)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramauth);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    autg.a(this.jdField_a_of_type_Autg, lzb.a(paramIBinder));
    paramComponentName = (auth)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bw();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    autg.a(this.jdField_a_of_type_Autg, null);
    paramComponentName = (auth)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auti
 * JD-Core Version:    0.7.0.1
 */