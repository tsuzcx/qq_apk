import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.List;

public class bkif
{
  public static Dialog a(Context paramContext, View paramView)
  {
    return a(paramContext, paramView, -1, null);
  }
  
  public static Dialog a(Context paramContext, View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramContext = bkho.a(paramContext, paramInt, paramLayoutParams);
    paramContext.a(paramView, null);
    return paramContext;
  }
  
  public static bkho a(Context paramContext, bkho parambkho, List<bkhn> paramList, bkhw parambkhw)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    int i;
    if (parambkho == null)
    {
      parambkho = (bkho)a(paramContext, null);
      i = 0;
      label35:
      if (i >= paramList.size()) {
        break label116;
      }
      paramContext = (bkhn)paramList.get(i);
      if (paramContext.d == 0)
      {
        if (paramContext.a != 1) {
          break label99;
        }
        parambkho.a(paramContext, 1);
      }
    }
    for (;;)
    {
      i += 1;
      break label35;
      parambkho.c();
      parambkho.a();
      break;
      label99:
      if (paramContext.a == 2) {
        parambkho.a(paramContext, 3);
      }
    }
    label116:
    parambkho.a(parambkhw);
    return parambkho;
  }
  
  public static bkho a(Context paramContext, List<bkhn> paramList, bkhw parambkhw)
  {
    return a(paramContext, null, paramList, parambkhw);
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getString(paramInt);
  }
  
  public static void a(Activity paramActivity, bkho parambkho)
  {
    if ((paramActivity == null) || (parambkho == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambkho.show();
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
    paramContext = bkho.b(paramContext);
    paramContext.a(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static void b(Activity paramActivity, bkho parambkho)
  {
    if ((paramActivity == null) || (parambkho == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambkho.dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkif
 * JD-Core Version:    0.7.0.1
 */