import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.List;

public class behe
{
  public static Dialog a(Context paramContext, View paramView)
  {
    paramContext = begr.a(paramContext);
    paramContext.a(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static begr a(Context paramContext, begr parambegr, List<begq> paramList, begw parambegw)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    int i;
    if (parambegr == null)
    {
      parambegr = (begr)a(paramContext, null);
      i = 0;
      label35:
      if (i >= paramList.size()) {
        break label116;
      }
      paramContext = (begq)paramList.get(i);
      if (paramContext.d == 0)
      {
        if (paramContext.a != 1) {
          break label99;
        }
        parambegr.a(paramContext, 1);
      }
    }
    for (;;)
    {
      i += 1;
      break label35;
      parambegr.c();
      parambegr.a();
      break;
      label99:
      if (paramContext.a == 2) {
        parambegr.a(paramContext, 3);
      }
    }
    label116:
    parambegr.a(parambegw);
    return parambegr;
  }
  
  public static begr a(Context paramContext, List<begq> paramList, begw parambegw)
  {
    return a(paramContext, null, paramList, parambegw);
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getString(paramInt);
  }
  
  public static void a(Activity paramActivity, begr parambegr)
  {
    if ((paramActivity == null) || (parambegr == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambegr.show();
        return;
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    LogUtils.e("ActionSheetHelper", "showActionSheet when activity(" + paramActivity + ") is finish!");
  }
  
  public static Dialog b(Context paramContext, View paramView)
  {
    paramContext = begr.b(paramContext);
    paramContext.a(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static void b(Activity paramActivity, begr parambegr)
  {
    if ((paramActivity == null) || (parambegr == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambegr.dismiss();
        return;
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    LogUtils.e("ActionSheetHelper", "dismissActionSheet when activity(" + paramActivity + ") is finish!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     behe
 * JD-Core Version:    0.7.0.1
 */