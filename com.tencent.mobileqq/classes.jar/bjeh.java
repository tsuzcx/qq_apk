import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

class bjeh
  implements IActivityResultListener
{
  bjeh(bjdt parambjdt, IActivityResultManager paramIActivityResultManager) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 9527) {
      return false;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
    QLog.d("MiniAppProxyImpl", 1, "set isMiniMsgTabShow false");
    bjdt.a(this.jdField_a_of_type_Bjdt, false);
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
      bjdt.a(this.jdField_a_of_type_Bjdt, bjdt.a(this.jdField_a_of_type_Bjdt), paramIntent);
      ActionBridge.UpdateUIActionBridge.updateRedDot(bjdt.a(this.jdField_a_of_type_Bjdt));
      return true;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(2);
      paramIntent = str;
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(6);
      paramIntent = str;
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(7);
      paramIntent = "share_WX";
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(8);
      paramIntent = "share_Moments";
      continue;
      Message localMessage = new Message();
      localMessage.what = 13;
      localMessage.setData(paramIntent.getExtras());
      bjdt.a(this.jdField_a_of_type_Bjdt).sendMessage(localMessage);
      paramIntent = str;
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(3);
      paramIntent = str;
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(4);
      paramIntent = "about";
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(5);
      paramIntent = str;
      continue;
      paramIntent = "cancel";
      continue;
      paramIntent = "cancel_system";
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(9);
      paramIntent = str;
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(11);
      paramIntent = str;
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(10);
      paramIntent = "back_home";
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(12);
      paramIntent = str;
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(14);
      paramIntent = str;
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(15);
      paramIntent = str;
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(16);
      paramIntent = str;
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(17);
      paramIntent = str;
      continue;
      bjdt.a(this.jdField_a_of_type_Bjdt).sendEmptyMessage(18);
      paramIntent = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjeh
 * JD-Core Version:    0.7.0.1
 */