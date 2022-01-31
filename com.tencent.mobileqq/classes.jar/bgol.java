import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;

public class bgol
{
  private static void b(String paramString)
  {
    Dialog localDialog = new Dialog(BaseApplicationImpl.getApplication(), 2131755791);
    localDialog.getWindow().setType(2003);
    localDialog.setContentView(2131558883);
    TextView localTextView = (TextView)localDialog.findViewById(2131365151);
    if (localTextView != null) {
      localTextView.setText("dump文件保存地址");
    }
    localTextView = (TextView)localDialog.findViewById(2131365147);
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
    localTextView = (TextView)localDialog.findViewById(2131365136);
    if (localTextView != null)
    {
      localTextView.setText(2131690596);
      localTextView.setOnClickListener(new bgon(localDialog));
    }
    localTextView = (TextView)localDialog.findViewById(2131365142);
    if (localTextView != null)
    {
      localTextView.setText(2131691547);
      localTextView.setOnClickListener(new bgoo(localDialog, paramString));
    }
    localDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgol
 * JD-Core Version:    0.7.0.1
 */