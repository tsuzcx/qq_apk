import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Messenger;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

class aojw
  implements ServiceConnection
{
  aojw(aoju paramaoju) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    aoju.a(this.a, 2);
    aoju.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("UploadPhoto", 2, "onServiceConnected()...");
    }
    this.a.jdField_a_of_type_AndroidOsMessenger = new Messenger(paramIBinder);
    this.a.b = new Messenger(this.a.jdField_a_of_type_AndroidOsHandler);
    aoju.b(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadPhoto", 2, "onServiceDisconnected()...");
    }
    this.a.jdField_a_of_type_AndroidOsMessenger = null;
    aoju.a(this.a, 4);
    this.a.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.a.b = null;
    aoju.a(this.a, true);
    if (aoju.a(this.a) != null) {
      aoju.a(this.a).interrupt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojw
 * JD-Core Version:    0.7.0.1
 */