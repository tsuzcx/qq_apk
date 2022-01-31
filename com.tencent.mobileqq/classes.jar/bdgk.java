import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class bdgk
{
  public static bdik a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131628566, 2131628579, null, null);
  }
  
  public static bdik a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdik(paramContext, 2131690144);
    paramContext.setContentView(2131493726);
    paramContext.a(paramString1);
    paramContext.a(paramCharSequence);
    paramContext.a(paramString2, paramOnClickListener2);
    paramContext.b(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdik a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdik(paramContext, 2131690144);
    paramContext.setContentView(2131493726);
    paramContext.a(paramString1);
    paramContext.a(paramString2);
    paramContext.a(paramInt2, paramOnClickListener2);
    paramContext.b(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdgk
 * JD-Core Version:    0.7.0.1
 */