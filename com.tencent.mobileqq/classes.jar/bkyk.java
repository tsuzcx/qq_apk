import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

class bkyk
  implements IActivityResultListener
{
  bkyk(bkxx parambkxx, IActivityResultManager paramIActivityResultManager) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 9527) {
      return false;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
    QLog.d("MiniAppProxyImpl", 1, "set isMiniMsgTabShow false");
    bkxx.a(this.jdField_a_of_type_Bkxx, false);
    if (paramInt2 != -1)
    {
      QLog.w("MiniAppProxyImpl", 1, "onShareActivityResult, resultCode not Activity.RESULT_OK, but " + paramInt2);
      return true;
    }
    paramInt1 = paramIntent.getIntExtra("clickID", -1);
    String str = "";
    switch (paramInt1)
    {
    default: 
      paramIntent = str;
    }
    for (;;)
    {
      bkxx.a(this.jdField_a_of_type_Bkxx, bkxx.a(this.jdField_a_of_type_Bkxx), paramIntent);
      ActionBridge.UpdateUIActionBridge.updateRedDot(bkxx.a(this.jdField_a_of_type_Bkxx));
      return true;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(2);
      paramIntent = str;
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(6);
      paramIntent = str;
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(7);
      paramIntent = "share_WX";
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(8);
      paramIntent = "share_Moments";
      continue;
      Message localMessage = new Message();
      localMessage.what = 13;
      localMessage.setData(paramIntent.getExtras());
      bkxx.a(this.jdField_a_of_type_Bkxx).sendMessage(localMessage);
      paramIntent = str;
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(3);
      paramIntent = str;
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(4);
      paramIntent = "about";
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(5);
      paramIntent = str;
      continue;
      paramIntent = "cancel";
      continue;
      paramIntent = "cancel_system";
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(9);
      paramIntent = str;
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(11);
      paramIntent = str;
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(10);
      paramIntent = "back_home";
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(12);
      paramIntent = str;
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(14);
      paramIntent = str;
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(15);
      paramIntent = str;
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(16);
      paramIntent = str;
      continue;
      bkxx.a(this.jdField_a_of_type_Bkxx).sendEmptyMessage(17);
      paramIntent = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyk
 * JD-Core Version:    0.7.0.1
 */