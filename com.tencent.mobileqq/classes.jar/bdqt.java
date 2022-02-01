import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class bdqt
  extends bdnv
{
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 17;
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  protected int b()
  {
    return 23;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject2;
    if ((paramView != null) && ((paramView instanceof LinearLayout)) && ((paramView.getTag() instanceof bdqu)))
    {
      localbdqu = (bdqu)paramView.getTag();
      localIterator = this.a.iterator();
      for (;;)
      {
        localObject1 = paramView;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (bdnu)localIterator.next();
        if ("button".equals(((bdnu)localObject1).a))
        {
          localObject2 = (TextView)((bdnu)localObject1).a(paramContext, localbdqu.a, paramBundle);
          if (TextUtils.isEmpty(((bdpr)localObject1).c())) {
            ((TextView)localObject2).setTextSize(16.0F);
          }
          if (TextUtils.isEmpty(((bdpr)localObject1).d())) {
            ((TextView)localObject2).setTextColor(Color.parseColor("#12b7f5"));
          }
        }
      }
    }
    Object localObject1 = a(paramContext);
    bdqu localbdqu = new bdqu();
    Iterator localIterator = this.a.iterator();
    paramView = null;
    while (localIterator.hasNext())
    {
      localObject2 = (bdnu)localIterator.next();
      if ("button".equals(((bdnu)localObject2).a))
      {
        paramView = (TextView)((bdnu)localObject2).a(paramContext, null, paramBundle);
        if (TextUtils.isEmpty(((bdpr)localObject2).c())) {
          paramView.setTextSize(16.0F);
        }
        if (TextUtils.isEmpty(((bdpr)localObject2).d())) {
          paramView.setTextColor(Color.parseColor("#12b7f5"));
        }
        localObject2 = new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(41.0F, paramContext.getResources()));
        ((LinearLayout.LayoutParams)localObject2).gravity = 17;
        ((LinearLayout)localObject1).addView(paramView, (ViewGroup.LayoutParams)localObject2);
      }
    }
    if (paramView != null) {
      localbdqu.a = paramView;
    }
    ((LinearLayout)localObject1).setTag(localbdqu);
    return localObject1;
  }
  
  public String b()
  {
    return "layout23";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqt
 * JD-Core Version:    0.7.0.1
 */