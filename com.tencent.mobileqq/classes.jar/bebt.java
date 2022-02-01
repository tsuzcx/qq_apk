import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class bebt
  extends ReportDialog
{
  public bebt(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    super(paramContext, 2131755824);
    setContentView(2131563003);
    paramContext = (TextView)findViewById(2131378936);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramContext.setVisibility(0);
      paramContext.setText(paramString1);
      paramContext = (TextView)findViewById(2131365046);
      if (TextUtils.isEmpty(paramString2)) {
        break label142;
      }
      paramContext.setVisibility(0);
      paramContext.setMovementMethod(LinkMovementMethod.getInstance());
      paramContext.setText(new beac(paramString2, 8));
    }
    for (;;)
    {
      ((Button)findViewById(2131364961)).setOnClickListener(new bebu(this, paramOnClickListener1));
      ((ImageView)findViewById(2131364593)).setOnClickListener(new bebv(this, paramOnClickListener2));
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
 * Qualified Name:     bebt
 * JD-Core Version:    0.7.0.1
 */