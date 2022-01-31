import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class arfq
  extends BroadcastReceiver
{
  arfq(arfp paramarfp) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    if (arfp.a(this.a)) {
      arfp.a(this.a, j);
    }
    if (paramContext.equals(arfy.a(arfp.a(this.a))))
    {
      paramContext = (arfr)arfp.a(this.a).get();
      if (paramContext != null) {
        paramContext.a(j, paramIntent.getExtras());
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupVideoManager.IVPluginLoader", 2, "state:" + j);
        }
        paramContext = arfp.jdField_a_of_type_ArrayOfInt;
        int k = paramContext.length;
        int i = 0;
        while (i < k)
        {
          if ((j == paramContext[i]) && (arfp.b(this.a)))
          {
            arfp.a().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
            arfp.a(this.a, false);
          }
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.e("GroupVideoManager.IVPluginLoader", 2, "loadListener null");
        }
      }
      if ((arfp.c(this.a)) && (j == 4))
      {
        arfp.a().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
        arfp.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arfq
 * JD-Core Version:    0.7.0.1
 */