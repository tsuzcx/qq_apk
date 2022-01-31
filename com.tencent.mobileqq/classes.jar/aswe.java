import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aswe
  extends BroadcastReceiver
{
  aswe(aswd paramaswd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    if (aswd.a(this.a)) {
      aswd.a(this.a, j);
    }
    if (paramContext.equals(aswm.a(aswd.a(this.a))))
    {
      paramContext = (aswf)aswd.a(this.a).get();
      if (paramContext != null) {
        paramContext.a(j, paramIntent.getExtras());
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupVideoManager.IVPluginLoader", 2, "state:" + j);
        }
        paramContext = aswd.jdField_a_of_type_ArrayOfInt;
        int k = paramContext.length;
        int i = 0;
        while (i < k)
        {
          if ((j == paramContext[i]) && (aswd.b(this.a)))
          {
            aswd.a().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
            aswd.a(this.a, false);
          }
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.e("GroupVideoManager.IVPluginLoader", 2, "loadListener null");
        }
      }
      if ((aswd.c(this.a)) && (j == 4))
      {
        aswd.a().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
        aswd.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswe
 * JD-Core Version:    0.7.0.1
 */