import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.List;

public class bjon
{
  public static Dialog a(Context paramContext, View paramView)
  {
    return a(paramContext, paramView, -1, null);
  }
  
  public static Dialog a(Context paramContext, View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramContext = bjnw.a(paramContext, paramInt, paramLayoutParams);
    paramContext.a(paramView, null);
    return paramContext;
  }
  
  public static bjnw a(Context paramContext, bjnw parambjnw, List<bjnv> paramList, bjoe parambjoe)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    int i;
    if (parambjnw == null)
    {
      parambjnw = (bjnw)a(paramContext, null);
      i = 0;
      label35:
      if (i >= paramList.size()) {
        break label116;
      }
      paramContext = (bjnv)paramList.get(i);
      if (paramContext.d == 0)
      {
        if (paramContext.a != 1) {
          break label99;
        }
        parambjnw.a(paramContext, 1);
      }
    }
    for (;;)
    {
      i += 1;
      break label35;
      parambjnw.c();
      parambjnw.a();
      break;
      label99:
      if (paramContext.a == 2) {
        parambjnw.a(paramContext, 3);
      }
    }
    label116:
    parambjnw.a(parambjoe);
    return parambjnw;
  }
  
  public static bjnw a(Context paramContext, List<bjnv> paramList, bjoe parambjoe)
  {
    return a(paramContext, null, paramList, parambjoe);
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getString(paramInt);
  }
  
  public static void a(Activity paramActivity, bjnw parambjnw)
  {
    if ((paramActivity == null) || (parambjnw == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambjnw.show();
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
    paramContext = bjnw.b(paramContext);
    paramContext.a(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static void b(Activity paramActivity, bjnw parambjnw)
  {
    if ((paramActivity == null) || (parambjnw == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambjnw.dismiss();
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
 * Qualified Name:     bjon
 * JD-Core Version:    0.7.0.1
 */