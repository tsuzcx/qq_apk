import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

public class ayvp
{
  public static void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    a(paramInt1, paramInt2, paramView, false, paramInt3, true);
  }
  
  public static void a(int paramInt1, int paramInt2, View paramView, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    int i = ((Integer)paramView.getTag(2131379972)).intValue();
    Object localObject;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    int k;
    if ((paramView instanceof LinearLayout))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeView(paramView.findViewById(2131373631));
      paramView.removeView(paramView.findViewById(2131373632));
      if (paramView.getChildCount() == 1)
      {
        localObject = paramView.getContext();
        localView = paramView.getChildAt(0);
        localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        int j = ((Context)localObject).getResources().getDimensionPixelSize(2131298304);
        k = ((Context)localObject).getResources().getDimensionPixelSize(2131298305);
        switch (paramInt2)
        {
        default: 
          localView.setLayoutParams(localLayoutParams);
          if (paramBoolean2)
          {
            if (paramInt1 <= 1) {
              break label341;
            }
            localView.setPadding(localView.getPaddingLeft(), j, localView.getPaddingRight(), j);
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (ayog.a(paramInt3))
      {
        localObject = new aywm((Context)localObject, paramInt3).a();
        ((View)localObject).setId(2131373632);
        paramView.addView((View)localObject, 0);
      }
      if (((paramInt2 == 0) || (paramInt1 == 1)) && (paramBoolean1) && (i != 1))
      {
        localObject = new View(paramView.getContext());
        ((View)localObject).setId(2131373631);
        ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, paramView.getContext().getResources().getDimensionPixelSize(2131298298)));
        paramView.addView((View)localObject, 0);
        if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
          break label363;
        }
        ((View)localObject).setBackgroundColor(Color.parseColor("#080808"));
      }
      return;
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = 0;
      break;
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = 0;
      break;
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = 0;
      break;
      label341:
      localView.setPadding(localView.getPaddingLeft(), k, localView.getPaddingRight(), k);
    }
    label363:
    ((View)localObject).setBackgroundColor(Color.parseColor("#f2f2f2"));
  }
  
  public static void a(aynu paramaynu, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = j;
    if (paramInt1 > 1)
    {
      if (paramInt2 != 0) {
        break label26;
      }
      i = 0;
    }
    for (;;)
    {
      paramaynu.a(paramInt1, i);
      return;
      label26:
      i = j;
      if (paramInt2 == paramInt1 - 1) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvp
 * JD-Core Version:    0.7.0.1
 */