import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;

final class bfzh
  implements bfzl
{
  public void a(boolean paramBoolean, Context paramContext, bfzm parambfzm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean)
    {
      long l1 = parambfzm.a.getLongExtra("key_launch_time", 0L);
      if (l1 > 0L)
      {
        long l2 = System.currentTimeMillis();
        QZLog.d("plugin_tag", 1, "IPluginManager onPluginReady Open Plugin Activity timedelay=" + (l2 - l1));
      }
      bfzg.b((Activity)paramContext, parambfzm);
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), ajjy.a(2131640061), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfzh
 * JD-Core Version:    0.7.0.1
 */