import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.List;

public class bhus
{
  public static Dialog a(Context paramContext, View paramView)
  {
    return a(paramContext, paramView, -1, null);
  }
  
  public static Dialog a(Context paramContext, View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramContext = bhuf.a(paramContext, paramInt, paramLayoutParams);
    paramContext.a(paramView, null);
    return paramContext;
  }
  
  public static bhuf a(Context paramContext, bhuf parambhuf, List<bhue> paramList, bhuk parambhuk)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    int i;
    if (parambhuf == null)
    {
      parambhuf = (bhuf)a(paramContext, null);
      i = 0;
      label35:
      if (i >= paramList.size()) {
        break label116;
      }
      paramContext = (bhue)paramList.get(i);
      if (paramContext.d == 0)
      {
        if (paramContext.a != 1) {
          break label99;
        }
        parambhuf.a(paramContext, 1);
      }
    }
    for (;;)
    {
      i += 1;
      break label35;
      parambhuf.c();
      parambhuf.a();
      break;
      label99:
      if (paramContext.a == 2) {
        parambhuf.a(paramContext, 3);
      }
    }
    label116:
    parambhuf.a(parambhuk);
    return parambhuf;
  }
  
  public static bhuf a(Context paramContext, List<bhue> paramList, bhuk parambhuk)
  {
    return a(paramContext, null, paramList, parambhuk);
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getString(paramInt);
  }
  
  public static void a(Activity paramActivity, bhuf parambhuf)
  {
    if ((paramActivity == null) || (parambhuf == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambhuf.show();
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
    paramContext = bhuf.b(paramContext);
    paramContext.a(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static void b(Activity paramActivity, bhuf parambhuf)
  {
    if ((paramActivity == null) || (parambhuf == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambhuf.dismiss();
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
 * Qualified Name:     bhus
 * JD-Core Version:    0.7.0.1
 */