import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class becj
  extends ReportDialog
{
  public becj(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    super(paramContext, 2131755829);
    setContentView(2131562954);
    paramContext = (TextView)findViewById(2131379001);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramContext.setVisibility(0);
      paramContext.setText(paramString1);
      paramContext = (TextView)findViewById(2131365157);
      if (TextUtils.isEmpty(paramString2)) {
        break label142;
      }
      paramContext.setVisibility(0);
      paramContext.setMovementMethod(LinkMovementMethod.getInstance());
      paramContext.setText(new beas(paramString2, 8));
    }
    for (;;)
    {
      ((Button)findViewById(2131365072)).setOnClickListener(new beck(this, paramOnClickListener1));
      ((ImageView)findViewById(2131364708)).setOnClickListener(new becl(this, paramOnClickListener2));
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
 * Qualified Name:     becj
 * JD-Core Version:    0.7.0.1
 */