import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class avtf
  extends BroadcastReceiver
{
  avtf(avte paramavte) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    if (avte.a(this.a)) {
      avte.a(this.a, j);
    }
    if (paramContext.equals(avts.a(avte.a(this.a))))
    {
      paramContext = (avtg)avte.a(this.a).get();
      if (paramContext != null) {
        paramContext.a(j, paramIntent.getExtras());
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupVideoManager.IVPluginLoader", 2, "state:" + j);
        }
        paramContext = avte.jdField_a_of_type_ArrayOfInt;
        int k = paramContext.length;
        int i = 0;
        while (i < k)
        {
          if ((j == paramContext[i]) && (avte.b(this.a)))
          {
            avte.a().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
            avte.a(this.a, false);
          }
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.e("GroupVideoManager.IVPluginLoader", 2, "loadListener null");
        }
      }
      if ((avte.c(this.a)) && (j == 4))
      {
        avte.a().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
        avte.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avtf
 * JD-Core Version:    0.7.0.1
 */