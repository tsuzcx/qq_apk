import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aunk
  extends BroadcastReceiver
{
  aunk(aunj paramaunj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    if (aunj.a(this.a)) {
      aunj.a(this.a, j);
    }
    if (paramContext.equals(aunx.a(aunj.a(this.a))))
    {
      paramContext = (aunl)aunj.a(this.a).get();
      if (paramContext != null) {
        paramContext.a(j, paramIntent.getExtras());
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupVideoManager.IVPluginLoader", 2, "state:" + j);
        }
        paramContext = aunj.jdField_a_of_type_ArrayOfInt;
        int k = paramContext.length;
        int i = 0;
        while (i < k)
        {
          if ((j == paramContext[i]) && (aunj.b(this.a)))
          {
            aunj.a().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
            aunj.a(this.a, false);
          }
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.e("GroupVideoManager.IVPluginLoader", 2, "loadListener null");
        }
      }
      if ((aunj.c(this.a)) && (j == 4))
      {
        aunj.a().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
        aunj.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunk
 * JD-Core Version:    0.7.0.1
 */