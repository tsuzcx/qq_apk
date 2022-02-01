import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;

public class axaq
{
  public static ProgressDialog a(Context paramContext, String paramString)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130849606);
    paramContext = new ReportProgressDialog(paramContext, 2131755824);
    paramContext.show();
    paramContext.getWindow().setContentView(2131558434);
    paramContext.setContentView(2131558434);
    ((TextView)paramContext.findViewById(2131365519)).setText(paramString);
    ((ProgressBar)paramContext.findViewById(2131367008)).setIndeterminateDrawable(localDrawable);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axaq
 * JD-Core Version:    0.7.0.1
 */