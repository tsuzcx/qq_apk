import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class bgow
{
  public static bgrb a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131694328, 2131694352, null, null);
  }
  
  public static bgrb a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgrb(paramContext, 2131755761);
    paramContext.setContentView(2131559341);
    paramContext.a(paramString1);
    paramContext.a(paramCharSequence);
    paramContext.a(paramString2, paramOnClickListener2);
    paramContext.b(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bgrb a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgrb(paramContext, 2131755761);
    paramContext.setContentView(2131559341);
    paramContext.a(paramString1);
    paramContext.a(paramString2);
    paramContext.a(paramInt2, paramOnClickListener2);
    paramContext.b(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bgrb a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131694328, 2131694352, paramOnClickListener1, paramOnClickListener2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgow
 * JD-Core Version:    0.7.0.1
 */