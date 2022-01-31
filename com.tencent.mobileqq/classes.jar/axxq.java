import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class axxq
  extends axuq
{
  protected int b()
  {
    return 24;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1;
    axxs localaxxs;
    if ((paramView != null) && ((paramView.getTag() instanceof axxs)))
    {
      localObject1 = (RelativeLayout)paramView;
      ((RelativeLayout)localObject1).removeAllViews();
      localaxxs = (axxs)paramView.getTag();
      localaxxs.a();
      paramView = (View)localObject1;
    }
    try
    {
      localObject1 = this.a.iterator();
      label54:
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (axup)((Iterator)localObject1).next();
        if ("picture".equals(((axup)localObject2).a))
        {
          localObject2 = ((axws)localObject2).a(paramContext, localaxxs.jdField_a_of_type_AndroidViewView, true, paramBundle);
          i = actj.a(30.0F, paramContext.getResources());
          paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(i, i));
          localaxxs.jdField_a_of_type_AndroidViewView = ((View)localObject2);
          ((View)localObject2).setVisibility(0);
          i = 1;
        }
        for (;;)
        {
          break label54;
          paramView = new RelativeLayout(paramContext);
          paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          int j = actj.a(10.0F, paramContext.getResources());
          int k = actj.a(13.0F, paramContext.getResources());
          paramView.setPadding(k, j, k, actj.a(11.0F, paramContext.getResources()));
          localaxxs = new axxs(null);
          break;
          if ("title".equals(((axup)localObject2).a))
          {
            localObject2 = (TextView)((axup)localObject2).a(paramContext, localaxxs.jdField_a_of_type_AndroidWidgetTextView, paramBundle);
            ((TextView)localObject2).setGravity(16);
            paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(-2, actj.a(30.0F, paramContext.getResources())));
            localaxxs.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
          else if ("summary".equals(((axup)localObject2).a))
          {
            ((axzj)localObject2).b(2147483647);
            localObject2 = (TextView)((axup)localObject2).a(paramContext, localaxxs.b, paramBundle);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.topMargin = actj.a(34.0F, paramContext.getResources());
            localLayoutParams.bottomMargin = actj.a(3.0F, paramContext.getResources());
            paramView.addView((View)localObject2, localLayoutParams);
            localaxxs.b = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
        }
      }
      if ((i != 0) && (localaxxs.jdField_a_of_type_AndroidWidgetTextView != null)) {
        ((RelativeLayout.LayoutParams)localaxxs.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).leftMargin = actj.a(38.0F, paramContext.getResources());
      }
      paramView.setTag(localaxxs);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxq
 * JD-Core Version:    0.7.0.1
 */