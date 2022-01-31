import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;

public class bgqc
{
  public static boolean a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl == null) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(localBaseApplicationImpl)))
    {
      bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131709608), 1).a();
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
    Dialog localDialog = new Dialog(BaseApplicationImpl.getApplication(), 2131755791);
    localDialog.getWindow().setType(2003);
    localDialog.setContentView(2131558883);
    TextView localTextView = (TextView)localDialog.findViewById(2131365150);
    if (localTextView != null) {
      localTextView.setText("dump文件保存地址");
    }
    localTextView = (TextView)localDialog.findViewById(2131365146);
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
    localTextView = (TextView)localDialog.findViewById(2131365135);
    if (localTextView != null)
    {
      localTextView.setText(2131690596);
      localTextView.setOnClickListener(new bgqe(localDialog));
    }
    localTextView = (TextView)localDialog.findViewById(2131365141);
    if (localTextView != null)
    {
      localTextView.setText(2131691547);
      localTextView.setOnClickListener(new bgqf(localDialog, paramString));
    }
    localDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqc
 * JD-Core Version:    0.7.0.1
 */