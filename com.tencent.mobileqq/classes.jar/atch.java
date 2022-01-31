import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public class atch
  implements ServiceConnection
{
  private WeakReference<atcg> jdField_a_of_type_JavaLangRefWeakReference;
  
  public atch(atcf paramatcf, atcg paramatcg)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramatcg);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    atcf.a(this.jdField_a_of_type_Atcf, lwr.a(paramIBinder));
    paramComponentName = (atcg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bt();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    atcf.a(this.jdField_a_of_type_Atcf, null);
    paramComponentName = (atcg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atch
 * JD-Core Version:    0.7.0.1
 */