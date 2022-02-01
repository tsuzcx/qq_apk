import android.os.Bundle;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;

class birx
  implements biro
{
  birx(birw parambirw) {}
  
  public int a(Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_Boolean) {
      QLog.i("WebLog_SwiftWebAccelerator", 1, "mScheduler.next:is in real world, stop the preload task.");
    }
    do
    {
      do
      {
        return -1;
        if ((this.a.b & 0x2) != 0)
        {
          if ((this.a.jdField_a_of_type_Int & 0x400) == 0) {
            this.a.b(paramBundle);
          }
          if ((this.a.jdField_a_of_type_Int & 0x800) == 0) {
            this.a.c(paramBundle);
          }
          if ((this.a.jdField_a_of_type_Int & 0x1000) == 0) {
            this.a.d(paramBundle);
          }
          if ((this.a.jdField_a_of_type_Int & 0x1) == 0) {
            return this.a.a(paramBundle);
          }
        }
      } while ((this.a.b & 0x1) == 0);
      if ((this.a.jdField_a_of_type_Int & 0x2) == 0) {
        return this.a.b(paramBundle);
      }
      if (!biqx.s)
      {
        biqx.s = true;
        if ((WebProcessReceiver.a > 0L) && (WebProcessReceiver.b > 0L))
        {
          biqx.U = WebProcessReceiver.b - WebProcessReceiver.a;
          biqx.V = System.currentTimeMillis() - WebProcessReceiver.b;
          int i = (int)biqx.U;
          int j = (int)biqx.V;
          QLog.i("WebLog_SwiftWebAccelerator", 1, "cross process cost: " + i + "ms, preload cost: " + j + "ms.");
          VasWebviewUtil.reportVasStatus("Preload_Web_Process", "", "", i, j);
        }
      }
      if ((this.a.jdField_a_of_type_Int & 0x4) == 0) {
        return this.a.c(paramBundle);
      }
      if ((this.a.jdField_a_of_type_Int & 0x8) == 0) {
        return this.a.e(paramBundle);
      }
      if ((paramBundle.getBoolean("_should_set_cookie_", false)) && ((this.a.jdField_a_of_type_Int & 0x10) == 0)) {
        return this.a.d(paramBundle);
      }
    } while (biqx.t);
    biqx.t = true;
    if ((WebProcessReceiver.a > 0L) && (WebProcessReceiver.b > 0L))
    {
      biqx.W = System.currentTimeMillis() - WebProcessReceiver.b;
      QLog.i("WebLog_SwiftWebAccelerator", 1, "WebProcessReceiver.onReceive cost: " + biqx.U + "ms, complete preload cost: " + biqx.W + "ms.");
    }
    QLog.i("WebLog_SwiftWebAccelerator", 1, "well done, all preload task execute success!");
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     birx
 * JD-Core Version:    0.7.0.1
 */