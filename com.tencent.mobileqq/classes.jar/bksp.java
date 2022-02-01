import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.qphone.base.util.QLog;

class bksp
  implements DialogInterface.OnClickListener
{
  bksp(bksl parambksl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("minisdk_X5UpdateGuard", 2, "confirm");
    AppBrandProxy.g().sendCmd("cmd_exit_qq", new Bundle(), null);
    AppLoaderFactory.getMiniAppInterface().exitProcess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksp
 * JD-Core Version:    0.7.0.1
 */