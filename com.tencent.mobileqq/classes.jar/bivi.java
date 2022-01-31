import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class bivi
{
  public static boolean a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl == null) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(localBaseApplicationImpl)))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), alud.a(2131709992), 1).a();
      localBaseApplicationImpl.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
      return false;
    }
    return true;
  }
  
  private static void b(String paramString)
  {
    if (!a()) {
      return;
    }
    Dialog localDialog = new Dialog(BaseApplicationImpl.getApplication(), 2131755801);
    localDialog.getWindow().setType(2003);
    localDialog.setContentView(2131558919);
    TextView localTextView = (TextView)localDialog.findViewById(2131365237);
    if (localTextView != null) {
      localTextView.setText("dump文件保存地址");
    }
    localTextView = (TextView)localDialog.findViewById(2131365233);
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
    localTextView = (TextView)localDialog.findViewById(2131365222);
    if (localTextView != null)
    {
      localTextView.setText(2131690648);
      localTextView.setOnClickListener(new bivk(localDialog));
    }
    localTextView = (TextView)localDialog.findViewById(2131365228);
    if (localTextView != null)
    {
      localTextView.setText(2131691603);
      localTextView.setOnClickListener(new bivl(localDialog, paramString));
    }
    localDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bivi
 * JD-Core Version:    0.7.0.1
 */