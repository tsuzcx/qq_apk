import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class aztk
  extends azqk
{
  protected int b()
  {
    return 24;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1;
    aztm localaztm;
    if ((paramView != null) && ((paramView.getTag() instanceof aztm)))
    {
      localObject1 = (RelativeLayout)paramView;
      ((RelativeLayout)localObject1).removeAllViews();
      localaztm = (aztm)paramView.getTag();
      localaztm.a();
      paramView = (View)localObject1;
    }
    try
    {
      localObject1 = this.a.iterator();
      label54:
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (azqj)((Iterator)localObject1).next();
        if ("picture".equals(((azqj)localObject2).a))
        {
          localObject2 = ((azsm)localObject2).a(paramContext, localaztm.jdField_a_of_type_AndroidViewView, true, paramBundle);
          i = aekt.a(30.0F, paramContext.getResources());
          paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(i, i));
          localaztm.jdField_a_of_type_AndroidViewView = ((View)localObject2);
          ((View)localObject2).setVisibility(0);
          i = 1;
        }
        for (;;)
        {
          break label54;
          paramView = new RelativeLayout(paramContext);
          paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          int j = aekt.a(10.0F, paramContext.getResources());
          int k = aekt.a(13.0F, paramContext.getResources());
          paramView.setPadding(k, j, k, aekt.a(11.0F, paramContext.getResources()));
          localaztm = new aztm(null);
          break;
          if ("title".equals(((azqj)localObject2).a))
          {
            localObject2 = (TextView)((azqj)localObject2).a(paramContext, localaztm.jdField_a_of_type_AndroidWidgetTextView, paramBundle);
            ((TextView)localObject2).setGravity(16);
            paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(-2, aekt.a(30.0F, paramContext.getResources())));
            localaztm.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
          else if ("summary".equals(((azqj)localObject2).a))
          {
            ((azvd)localObject2).b(2147483647);
            localObject2 = (TextView)((azqj)localObject2).a(paramContext, localaztm.b, paramBundle);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.topMargin = aekt.a(34.0F, paramContext.getResources());
            localLayoutParams.bottomMargin = aekt.a(3.0F, paramContext.getResources());
            paramView.addView((View)localObject2, localLayoutParams);
            localaztm.b = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
        }
      }
      if ((i != 0) && (localaztm.jdField_a_of_type_AndroidWidgetTextView != null)) {
        ((RelativeLayout.LayoutParams)localaztm.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).leftMargin = aekt.a(38.0F, paramContext.getResources());
      }
      paramView.setTag(localaztm);
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
 * Qualified Name:     aztk
 * JD-Core Version:    0.7.0.1
 */