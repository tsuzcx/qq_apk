import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;

public class bfht
{
  public static boolean a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl == null) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(localBaseApplicationImpl)))
    {
      bbmy.a(BaseApplicationImpl.getApplication(), ajjy.a(2131643812), 1).a();
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
    Dialog localDialog = new Dialog(BaseApplicationImpl.getApplication(), 2131690181);
    localDialog.getWindow().setType(2003);
    localDialog.setContentView(2131493323);
    TextView localTextView = (TextView)localDialog.findViewById(2131299583);
    if (localTextView != null) {
      localTextView.setText("dump文件保存地址");
    }
    localTextView = (TextView)localDialog.findViewById(2131299579);
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
    localTextView = (TextView)localDialog.findViewById(2131299568);
    if (localTextView != null)
    {
      localTextView.setText(2131625035);
      localTextView.setOnClickListener(new bfhv(localDialog));
    }
    localTextView = (TextView)localDialog.findViewById(2131299574);
    if (localTextView != null)
    {
      localTextView.setText(2131625971);
      localTextView.setOnClickListener(new bfhw(localDialog, paramString));
    }
    localDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfht
 * JD-Core Version:    0.7.0.1
 */