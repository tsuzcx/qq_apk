import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public class auxr
  implements ServiceConnection
{
  private WeakReference<auxq> jdField_a_of_type_JavaLangRefWeakReference;
  
  public auxr(auxp paramauxp, auxq paramauxq)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramauxq);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    auxp.a(this.jdField_a_of_type_Auxp, lzb.a(paramIBinder));
    paramComponentName = (auxq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bw();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    auxp.a(this.jdField_a_of_type_Auxp, null);
    paramComponentName = (auxq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auxr
 * JD-Core Version:    0.7.0.1
 */