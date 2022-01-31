import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

public class arjc
{
  public static ProgressDialog a(Context paramContext, String paramString)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130848317);
    paramContext = new ProgressDialog(paramContext, 2131690181);
    paramContext.show();
    paramContext.getWindow().setContentView(2131492892);
    paramContext.setContentView(2131492892);
    ((TextView)paramContext.findViewById(2131299579)).setText(paramString);
    ((ProgressBar)paramContext.findViewById(2131300960)).setIndeterminateDrawable(localDrawable);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     arjc
 * JD-Core Version:    0.7.0.1
 */