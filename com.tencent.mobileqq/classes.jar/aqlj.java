import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aqlj
  extends BroadcastReceiver
{
  aqlj(aqli paramaqli) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    if (aqli.a(this.a)) {
      aqli.a(this.a, j);
    }
    if (paramContext.equals(aqlr.a(aqli.a(this.a))))
    {
      paramContext = (aqlk)aqli.a(this.a).get();
      if (paramContext != null) {
        paramContext.a(j, paramIntent.getExtras());
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupVideoManager.IVPluginLoader", 2, "state:" + j);
        }
        paramContext = aqli.jdField_a_of_type_ArrayOfInt;
        int k = paramContext.length;
        int i = 0;
        while (i < k)
        {
          if ((j == paramContext[i]) && (aqli.b(this.a)))
          {
            aqli.a(this.a).unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
            aqli.a(this.a, false);
          }
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.e("GroupVideoManager.IVPluginLoader", 2, "loadListener null");
        }
      }
      if ((aqli.c(this.a)) && (j == 4))
      {
        aqli.a(this.a).unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
        aqli.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqlj
 * JD-Core Version:    0.7.0.1
 */