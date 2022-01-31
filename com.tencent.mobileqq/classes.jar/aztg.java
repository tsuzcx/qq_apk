import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;

public class aztg
  extends azqk
{
  private LinearLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i = localResources.getDimensionPixelSize(2131298817);
    int j = localResources.getDimensionPixelSize(2131298818);
    paramContext.setPadding(i, localResources.getDimensionPixelSize(2131298819), j, localResources.getDimensionPixelSize(2131298816));
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  protected int b()
  {
    return 21;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {}
    Resources localResources = paramContext.getResources();
    int i;
    int k;
    label102:
    Object localObject2;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
      i = paramView.getPaddingTop();
      j = paramView.getPaddingBottom();
      k = localResources.getDimensionPixelSize(2131298817);
      int m = localResources.getDimensionPixelSize(2131298818);
      a(paramView);
      d(paramView);
      paramView.setPadding(k, i, m, j);
      k = aekt.a(7.0F, localResources);
      i = 0;
      if (i >= this.a.size()) {
        return paramView;
      }
      localObject2 = (azqj)this.a.get(i);
      if (!(localObject2 instanceof azvk)) {
        break label216;
      }
      localObject1 = (azvk)localObject2;
      localObject2 = ((azvk)localObject1).a(paramContext, null, paramBundle);
      if (localObject2 != null)
      {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.topMargin = ((azvk)localObject1).k;
        localLayoutParams.bottomMargin = ((azvk)localObject1).l;
        paramView.addView((View)localObject2, localLayoutParams);
      }
    }
    label216:
    while (!(localObject2 instanceof azso))
    {
      LinearLayout.LayoutParams localLayoutParams;
      i += 1;
      break label102;
      paramView = a(paramContext);
      break;
    }
    Object localObject1 = ((azqj)localObject2).a(paramContext, null, paramBundle);
    if (((azso)localObject2).a) {}
    for (int j = 0;; j = aekt.a(2.0F, localResources))
    {
      localObject2 = new LinearLayout.LayoutParams(-1, j);
      ((LinearLayout.LayoutParams)localObject2).topMargin = k;
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = k;
      if (localObject1 == null) {
        break;
      }
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      break;
    }
    return paramView;
  }
  
  public String b()
  {
    return "Layout21";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztg
 * JD-Core Version:    0.7.0.1
 */