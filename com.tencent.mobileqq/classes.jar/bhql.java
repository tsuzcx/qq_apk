import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.List;

public class bhql
{
  public static Dialog a(Context paramContext, View paramView)
  {
    return a(paramContext, paramView, -1, null);
  }
  
  public static Dialog a(Context paramContext, View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramContext = bhpy.a(paramContext, paramInt, paramLayoutParams);
    paramContext.a(paramView, null);
    return paramContext;
  }
  
  public static bhpy a(Context paramContext, bhpy parambhpy, List<bhpx> paramList, bhqd parambhqd)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    int i;
    if (parambhpy == null)
    {
      parambhpy = (bhpy)a(paramContext, null);
      i = 0;
      label35:
      if (i >= paramList.size()) {
        break label116;
      }
      paramContext = (bhpx)paramList.get(i);
      if (paramContext.d == 0)
      {
        if (paramContext.a != 1) {
          break label99;
        }
        parambhpy.a(paramContext, 1);
      }
    }
    for (;;)
    {
      i += 1;
      break label35;
      parambhpy.c();
      parambhpy.a();
      break;
      label99:
      if (paramContext.a == 2) {
        parambhpy.a(paramContext, 3);
      }
    }
    label116:
    parambhpy.a(parambhqd);
    return parambhpy;
  }
  
  public static bhpy a(Context paramContext, List<bhpx> paramList, bhqd parambhqd)
  {
    return a(paramContext, null, paramList, parambhqd);
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getString(paramInt);
  }
  
  public static void a(Activity paramActivity, bhpy parambhpy)
  {
    if ((paramActivity == null) || (parambhpy == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambhpy.show();
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
    paramContext = bhpy.b(paramContext);
    paramContext.a(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static void b(Activity paramActivity, bhpy parambhpy)
  {
    if ((paramActivity == null) || (parambhpy == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambhpy.dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhql
 * JD-Core Version:    0.7.0.1
 */