import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public class atcj
  implements ServiceConnection
{
  private WeakReference<atci> jdField_a_of_type_JavaLangRefWeakReference;
  
  public atcj(atch paramatch, atci paramatci)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramatci);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    atch.a(this.jdField_a_of_type_Atch, lwm.a(paramIBinder));
    paramComponentName = (atci)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bt();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    atch.a(this.jdField_a_of_type_Atch, null);
    paramComponentName = (atci)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atcj
 * JD-Core Version:    0.7.0.1
 */