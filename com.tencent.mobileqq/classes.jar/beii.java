import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class beii
  extends beit
{
  beii(beih parambeih) {}
  
  public void a()
  {
    if (beih.a(this.a) == null) {}
    for (Activity localActivity = null;; localActivity = (Activity)beih.a(this.a).get())
    {
      if (localActivity != null) {
        this.a.jdField_a_of_type_Beiq.a(localActivity);
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    int i = 100;
    if (paramLong2 <= 0L)
    {
      QLog.e("NightModeLogic", 1, "mThemeDownloadListener onDownloadProgress dwProgressMax <= 0");
      i = 4;
    }
    if (paramLong1 <= paramLong2) {
      i = (int)(100.0D * paramLong1 / paramLong2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("NightModeLogic", 2, "mThemeDownloadListener onDownloadProgress readSize:" + paramLong1 + ", allSize:" + paramLong2 + ", percent:" + i);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("percent", i);
    localBundle.putInt("start_status", 3);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 4099, 1, 0, localBundle));
  }
  
  public boolean a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("start_status", 2);
    if (paramInt == 0) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 4099, 1, 0, localBundle));
    }
    for (;;)
    {
      return super.a(paramInt);
      this.a.jdField_a_of_type_Beiq.b();
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4100);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 4099, -2, 0, localBundle));
    }
  }
  
  public boolean a(beio parambeio)
  {
    this.a.jdField_a_of_type_Beiq.a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beii
 * JD-Core Version:    0.7.0.1
 */