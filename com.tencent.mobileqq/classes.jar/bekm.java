import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class bekm
{
  public static bemn a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131694208, 2131694225, null, null);
  }
  
  public static bemn a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bemn(paramContext, 2131755752);
    paramContext.setContentView(2131559295);
    paramContext.a(paramString1);
    paramContext.a(paramCharSequence);
    paramContext.a(paramString2, paramOnClickListener2);
    paramContext.b(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bemn a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bemn(paramContext, 2131755752);
    paramContext.setContentView(2131559295);
    paramContext.a(paramString1);
    paramContext.a(paramString2);
    paramContext.a(paramInt2, paramOnClickListener2);
    paramContext.b(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bemn a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131694208, 2131694225, paramOnClickListener1, paramOnClickListener2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bekm
 * JD-Core Version:    0.7.0.1
 */