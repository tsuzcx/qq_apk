import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.List;

public class bfoy
{
  public static Dialog a(Context paramContext, View paramView)
  {
    return a(paramContext, paramView, -1, null);
  }
  
  public static Dialog a(Context paramContext, View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramContext = bfol.a(paramContext, paramInt, paramLayoutParams);
    paramContext.a(paramView, null);
    return paramContext;
  }
  
  public static bfol a(Context paramContext, bfol parambfol, List<bfok> paramList, bfoq parambfoq)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    int i;
    if (parambfol == null)
    {
      parambfol = (bfol)a(paramContext, null);
      i = 0;
      label35:
      if (i >= paramList.size()) {
        break label116;
      }
      paramContext = (bfok)paramList.get(i);
      if (paramContext.d == 0)
      {
        if (paramContext.a != 1) {
          break label99;
        }
        parambfol.a(paramContext, 1);
      }
    }
    for (;;)
    {
      i += 1;
      break label35;
      parambfol.c();
      parambfol.a();
      break;
      label99:
      if (paramContext.a == 2) {
        parambfol.a(paramContext, 3);
      }
    }
    label116:
    parambfol.a(parambfoq);
    return parambfol;
  }
  
  public static bfol a(Context paramContext, List<bfok> paramList, bfoq parambfoq)
  {
    return a(paramContext, null, paramList, parambfoq);
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getString(paramInt);
  }
  
  public static void a(Activity paramActivity, bfol parambfol)
  {
    if ((paramActivity == null) || (parambfol == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambfol.show();
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
    paramContext = bfol.b(paramContext);
    paramContext.a(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static void b(Activity paramActivity, bfol parambfol)
  {
    if ((paramActivity == null) || (parambfol == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambfol.dismiss();
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
 * Qualified Name:     bfoy
 * JD-Core Version:    0.7.0.1
 */