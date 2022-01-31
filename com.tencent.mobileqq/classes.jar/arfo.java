import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class arfo
  extends BroadcastReceiver
{
  arfo(arfn paramarfn) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    if (arfn.a(this.a)) {
      arfn.a(this.a, j);
    }
    if (paramContext.equals(arfw.a(arfn.a(this.a))))
    {
      paramContext = (arfp)arfn.a(this.a).get();
      if (paramContext != null) {
        paramContext.a(j, paramIntent.getExtras());
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupVideoManager.IVPluginLoader", 2, "state:" + j);
        }
        paramContext = arfn.jdField_a_of_type_ArrayOfInt;
        int k = paramContext.length;
        int i = 0;
        while (i < k)
        {
          if ((j == paramContext[i]) && (arfn.b(this.a)))
          {
            arfn.a().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
            arfn.a(this.a, false);
          }
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.e("GroupVideoManager.IVPluginLoader", 2, "loadListener null");
        }
      }
      if ((arfn.c(this.a)) && (j == 4))
      {
        arfn.a().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
        arfn.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arfo
 * JD-Core Version:    0.7.0.1
 */