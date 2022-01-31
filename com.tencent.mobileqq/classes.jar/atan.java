import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class atan
  extends BroadcastReceiver
{
  atan(atam paramatam) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    if (atam.a(this.a)) {
      atam.a(this.a, j);
    }
    if (paramContext.equals(atav.a(atam.a(this.a))))
    {
      paramContext = (atao)atam.a(this.a).get();
      if (paramContext != null) {
        paramContext.a(j, paramIntent.getExtras());
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupVideoManager.IVPluginLoader", 2, "state:" + j);
        }
        paramContext = atam.jdField_a_of_type_ArrayOfInt;
        int k = paramContext.length;
        int i = 0;
        while (i < k)
        {
          if ((j == paramContext[i]) && (atam.b(this.a)))
          {
            atam.a().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
            atam.a(this.a, false);
          }
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.e("GroupVideoManager.IVPluginLoader", 2, "loadListener null");
        }
      }
      if ((atam.c(this.a)) && (j == 4))
      {
        atam.a().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
        atam.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atan
 * JD-Core Version:    0.7.0.1
 */