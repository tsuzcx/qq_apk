import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class bcjx
  extends bcgx
{
  protected int b()
  {
    return 24;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1;
    bcjz localbcjz;
    if ((paramView != null) && ((paramView.getTag() instanceof bcjz)))
    {
      localObject1 = (RelativeLayout)paramView;
      ((RelativeLayout)localObject1).removeAllViews();
      localbcjz = (bcjz)paramView.getTag();
      localbcjz.a();
      paramView = (View)localObject1;
    }
    try
    {
      localObject1 = this.a.iterator();
      label54:
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (bcgw)((Iterator)localObject1).next();
        if ("picture".equals(((bcgw)localObject2).a))
        {
          localObject2 = ((bciz)localObject2).a(paramContext, localbcjz.jdField_a_of_type_AndroidViewView, true, paramBundle);
          i = AIOUtils.dp2px(30.0F, paramContext.getResources());
          paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(i, i));
          localbcjz.jdField_a_of_type_AndroidViewView = ((View)localObject2);
          ((View)localObject2).setVisibility(0);
          i = 1;
        }
        for (;;)
        {
          break label54;
          paramView = new RelativeLayout(paramContext);
          paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          int j = AIOUtils.dp2px(10.0F, paramContext.getResources());
          int k = AIOUtils.dp2px(13.0F, paramContext.getResources());
          paramView.setPadding(k, j, k, AIOUtils.dp2px(11.0F, paramContext.getResources()));
          localbcjz = new bcjz(null);
          break;
          if ("title".equals(((bcgw)localObject2).a))
          {
            localObject2 = (TextView)((bcgw)localObject2).a(paramContext, localbcjz.jdField_a_of_type_AndroidWidgetTextView, paramBundle);
            ((TextView)localObject2).setGravity(16);
            paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(-2, AIOUtils.dp2px(30.0F, paramContext.getResources())));
            localbcjz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
          else if ("summary".equals(((bcgw)localObject2).a))
          {
            ((bclv)localObject2).b(2147483647);
            localObject2 = (TextView)((bcgw)localObject2).a(paramContext, localbcjz.b, paramBundle);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.topMargin = AIOUtils.dp2px(34.0F, paramContext.getResources());
            localLayoutParams.bottomMargin = AIOUtils.dp2px(3.0F, paramContext.getResources());
            paramView.addView((View)localObject2, localLayoutParams);
            localbcjz.b = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
        }
      }
      if ((i != 0) && (localbcjz.jdField_a_of_type_AndroidWidgetTextView != null)) {
        ((RelativeLayout.LayoutParams)localbcjz.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).leftMargin = AIOUtils.dp2px(38.0F, paramContext.getResources());
      }
      paramView.setTag(localbcjz);
      return paramView;
    }
    catch (Exception paramContext) {}
    return paramView;
  }
  
  public String b()
  {
    return "layout24";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjx
 * JD-Core Version:    0.7.0.1
 */