import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class badl
  extends Dialog
{
  public badl(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    super(paramContext, 2131755801);
    setContentView(2131562712);
    paramContext = (TextView)findViewById(2131377884);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramContext.setVisibility(0);
      paramContext.setText(paramString1);
      paramContext = (TextView)findViewById(2131364770);
      if (TextUtils.isEmpty(paramString2)) {
        break label142;
      }
      paramContext.setVisibility(0);
      paramContext.setMovementMethod(LinkMovementMethod.getInstance());
      paramContext.setText(new babu(paramString2, 8));
    }
    for (;;)
    {
      ((Button)findViewById(2131364693)).setOnClickListener(new badm(this, paramOnClickListener1));
      ((ImageView)findViewById(2131364335)).setOnClickListener(new badn(this, paramOnClickListener2));
      setCanceledOnTouchOutside(false);
      return;
      paramContext.setVisibility(8);
      break;
      label142:
      paramContext.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badl
 * JD-Core Version:    0.7.0.1
 */