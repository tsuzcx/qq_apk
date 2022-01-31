import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

public class auap
{
  public static ProgressDialog a(Context paramContext, String paramString)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130849056);
    paramContext = new ProgressDialog(paramContext, 2131755801);
    paramContext.show();
    paramContext.getWindow().setContentView(2131558428);
    paramContext.setContentView(2131558428);
    ((TextView)paramContext.findViewById(2131365233)).setText(paramString);
    ((ProgressBar)paramContext.findViewById(2131366695)).setIndeterminateDrawable(localDrawable);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auap
 * JD-Core Version:    0.7.0.1
 */