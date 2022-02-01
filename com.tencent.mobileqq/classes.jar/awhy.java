import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;

public class awhy
{
  public static ProgressDialog a(Context paramContext, String paramString)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130849596);
    paramContext = new ReportProgressDialog(paramContext, 2131755823);
    paramContext.show();
    paramContext.getWindow().setContentView(2131558434);
    paramContext.setContentView(2131558434);
    ((TextView)paramContext.findViewById(2131365475)).setText(paramString);
    ((ProgressBar)paramContext.findViewById(2131366957)).setIndeterminateDrawable(localDrawable);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhy
 * JD-Core Version:    0.7.0.1
 */