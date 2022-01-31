import android.os.Bundle;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;

class bbda
  implements bbcr
{
  bbda(bbcz parambbcz) {}
  
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
      if (!bbca.s)
      {
        bbca.s = true;
        if ((WebProcessReceiver.a > 0L) && (WebProcessReceiver.b > 0L))
        {
          bbca.U = WebProcessReceiver.b - WebProcessReceiver.a;
          bbca.V = System.currentTimeMillis() - WebProcessReceiver.b;
          int i = (int)bbca.U;
          int j = (int)bbca.V;
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
    } while (bbca.t);
    bbca.t = true;
    if ((WebProcessReceiver.a > 0L) && (WebProcessReceiver.b > 0L))
    {
      bbca.W = System.currentTimeMillis() - WebProcessReceiver.b;
      QLog.i("WebLog_SwiftWebAccelerator", 1, "WebProcessReceiver.onReceive cost: " + bbca.U + "ms, complete preload cost: " + bbca.W + "ms.");
    }
    QLog.i("WebLog_SwiftWebAccelerator", 1, "well done, all preload task execute success!");
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbda
 * JD-Core Version:    0.7.0.1
 */