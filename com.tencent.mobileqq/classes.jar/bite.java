import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;

public class bite
{
  private static void b(String paramString)
  {
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
      localTextView.setOnClickListener(new bitg(localDialog));
    }
    localTextView = (TextView)localDialog.findViewById(2131365228);
    if (localTextView != null)
    {
      localTextView.setText(2131691603);
      localTextView.setOnClickListener(new bith(localDialog, paramString));
    }
    localDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bite
 * JD-Core Version:    0.7.0.1
 */