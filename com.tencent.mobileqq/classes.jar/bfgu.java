import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;

public class bfgu
{
  private static void b(String paramString)
  {
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
      localTextView.setOnClickListener(new bfgw(localDialog));
    }
    localTextView = (TextView)localDialog.findViewById(2131299574);
    if (localTextView != null)
    {
      localTextView.setText(2131625971);
      localTextView.setOnClickListener(new bfgx(localDialog, paramString));
    }
    localDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfgu
 * JD-Core Version:    0.7.0.1
 */