import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

class bkpp
  implements IActivityResultListener
{
  bkpp(bkpb parambkpb, IActivityResultManager paramIActivityResultManager) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 9527) {
      return false;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
    QLog.d("MiniAppProxyImpl", 1, "set isMiniMsgTabShow false");
    bkpb.a(this.jdField_a_of_type_Bkpb, false);
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
      bkpb.a(this.jdField_a_of_type_Bkpb, bkpb.a(this.jdField_a_of_type_Bkpb), paramIntent);
      ActionBridge.UpdateUIActionBridge.updateRedDot(bkpb.a(this.jdField_a_of_type_Bkpb));
      return true;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(2);
      paramIntent = str;
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(6);
      paramIntent = str;
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(7);
      paramIntent = "share_WX";
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(8);
      paramIntent = "share_Moments";
      continue;
      Message localMessage = new Message();
      localMessage.what = 13;
      localMessage.setData(paramIntent.getExtras());
      bkpb.a(this.jdField_a_of_type_Bkpb).sendMessage(localMessage);
      paramIntent = str;
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(3);
      paramIntent = str;
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(4);
      paramIntent = "about";
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(5);
      paramIntent = str;
      continue;
      paramIntent = "cancel";
      continue;
      paramIntent = "cancel_system";
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(9);
      paramIntent = str;
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(11);
      paramIntent = str;
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(10);
      paramIntent = "back_home";
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(12);
      paramIntent = str;
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(14);
      paramIntent = str;
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(15);
      paramIntent = str;
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(16);
      paramIntent = str;
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(17);
      paramIntent = str;
      continue;
      bkpb.a(this.jdField_a_of_type_Bkpb).sendEmptyMessage(18);
      paramIntent = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpp
 * JD-Core Version:    0.7.0.1
 */