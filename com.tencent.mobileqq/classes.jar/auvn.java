import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;

public class auvn
{
  private static void b(String paramString)
  {
    int j = 1;
    int i = j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = BaseApplicationImpl.getApplication();
      i = j;
      if (localObject != null)
      {
        i = j;
        if (!Settings.canDrawOverlays((Context)localObject))
        {
          i = 0;
          ((Context)localObject).startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
        }
      }
    }
    if (i == 0) {
      return;
    }
    Object localObject = new Dialog(BaseApplicationImpl.getApplication(), 2131755801);
    ((Dialog)localObject).getWindow().setType(2003);
    ((Dialog)localObject).setContentView(2131558919);
    TextView localTextView = (TextView)((Dialog)localObject).findViewById(2131365237);
    if (localTextView != null) {
      localTextView.setText("dump文件保存地址");
    }
    localTextView = (TextView)((Dialog)localObject).findViewById(2131365233);
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
    localTextView = (TextView)((Dialog)localObject).findViewById(2131365222);
    if (localTextView != null)
    {
      localTextView.setText(2131690648);
      localTextView.setOnClickListener(new auvp((Dialog)localObject));
    }
    localTextView = (TextView)((Dialog)localObject).findViewById(2131365228);
    if (localTextView != null)
    {
      localTextView.setText(alud.a(2131707588));
      localTextView.setOnClickListener(new auvq((Dialog)localObject, paramString));
    }
    ((Dialog)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auvn
 * JD-Core Version:    0.7.0.1
 */