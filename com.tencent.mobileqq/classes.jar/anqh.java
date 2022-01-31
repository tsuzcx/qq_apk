import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.share.FilterComboSharePlugin;

public class anqh
  extends Client.onRemoteRespObserver
{
  public anqh(FilterComboSharePlugin paramFilterComboSharePlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    boolean bool1;
    boolean bool2;
    if (paramBundle != null)
    {
      paramBundle.getInt("respkey", 0);
      String str = paramBundle.getString("cmd");
      if (QLog.isColorLevel()) {
        QLog.i("FilterComboShare", 2, "onresp cmd" + str);
      }
      if ((str != null) && ("ipc_f_c_s".equals(str)))
      {
        if ((FilterComboSharePlugin.a(this.a) != null) && (FilterComboSharePlugin.a(this.a).isShowing())) {
          FilterComboSharePlugin.a(this.a).dismiss();
        }
        bool1 = paramBundle.getBoolean("k_r");
        paramBundle = paramBundle.getString("k_s_p_c");
        bool2 = FileUtils.a(paramBundle);
        if (QLog.isColorLevel()) {
          QLog.i("FilterComboShare", 2, "onresp result" + bool1 + " path " + paramBundle + " exist " + bool2);
        }
        if (this.a.a != -1) {
          break label190;
        }
        QLog.i("FilterComboShare", 1, "skip -1 resp");
      }
    }
    label190:
    int i;
    do
    {
      return;
      i = this.a.a;
      this.a.a = -1;
    } while ((!bool1) || (!bool2));
    this.a.a(i, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqh
 * JD-Core Version:    0.7.0.1
 */