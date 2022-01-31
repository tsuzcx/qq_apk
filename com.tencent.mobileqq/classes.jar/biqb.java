import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;

public class biqb
{
  private static void b(String paramString)
  {
    Dialog localDialog = new Dialog(BaseApplicationImpl.getApplication(), 2131755801);
    localDialog.getWindow().setType(2003);
    localDialog.setContentView(2131558920);
    TextView localTextView = (TextView)localDialog.findViewById(2131365235);
    if (localTextView != null) {
      localTextView.setText("dump文件保存地址");
    }
    localTextView = (TextView)localDialog.findViewById(2131365231);
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
    localTextView = (TextView)localDialog.findViewById(2131365220);
    if (localTextView != null)
    {
      localTextView.setText(2131690648);
      localTextView.setOnClickListener(new biqd(localDialog));
    }
    localTextView = (TextView)localDialog.findViewById(2131365226);
    if (localTextView != null)
    {
      localTextView.setText(2131691602);
      localTextView.setOnClickListener(new biqe(localDialog, paramString));
    }
    localDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biqb
 * JD-Core Version:    0.7.0.1
 */