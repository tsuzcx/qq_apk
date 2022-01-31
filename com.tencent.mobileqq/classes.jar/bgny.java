import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;

public class bgny
{
  private static void b(String paramString)
  {
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
      localTextView.setOnClickListener(new bgoa(localDialog));
    }
    localTextView = (TextView)localDialog.findViewById(2131365141);
    if (localTextView != null)
    {
      localTextView.setText(2131691547);
      localTextView.setOnClickListener(new bgob(localDialog, paramString));
    }
    localDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgny
 * JD-Core Version:    0.7.0.1
 */