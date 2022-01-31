import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class axxo
  extends axuo
{
  protected int b()
  {
    return 24;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1;
    axxq localaxxq;
    if ((paramView != null) && ((paramView.getTag() instanceof axxq)))
    {
      localObject1 = (RelativeLayout)paramView;
      ((RelativeLayout)localObject1).removeAllViews();
      localaxxq = (axxq)paramView.getTag();
      localaxxq.a();
      paramView = (View)localObject1;
    }
    try
    {
      localObject1 = this.a.iterator();
      label54:
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (axun)((Iterator)localObject1).next();
        if ("picture".equals(((axun)localObject2).a))
        {
          localObject2 = ((axwq)localObject2).a(paramContext, localaxxq.jdField_a_of_type_AndroidViewView, true, paramBundle);
          i = actn.a(30.0F, paramContext.getResources());
          paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(i, i));
          localaxxq.jdField_a_of_type_AndroidViewView = ((View)localObject2);
          ((View)localObject2).setVisibility(0);
          i = 1;
        }
        for (;;)
        {
          break label54;
          paramView = new RelativeLayout(paramContext);
          paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          int j = actn.a(10.0F, paramContext.getResources());
          int k = actn.a(13.0F, paramContext.getResources());
          paramView.setPadding(k, j, k, actn.a(11.0F, paramContext.getResources()));
          localaxxq = new axxq(null);
          break;
          if ("title".equals(((axun)localObject2).a))
          {
            localObject2 = (TextView)((axun)localObject2).a(paramContext, localaxxq.jdField_a_of_type_AndroidWidgetTextView, paramBundle);
            ((TextView)localObject2).setGravity(16);
            paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(-2, actn.a(30.0F, paramContext.getResources())));
            localaxxq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
          else if ("summary".equals(((axun)localObject2).a))
          {
            ((axzh)localObject2).b(2147483647);
            localObject2 = (TextView)((axun)localObject2).a(paramContext, localaxxq.b, paramBundle);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.topMargin = actn.a(34.0F, paramContext.getResources());
            localLayoutParams.bottomMargin = actn.a(3.0F, paramContext.getResources());
            paramView.addView((View)localObject2, localLayoutParams);
            localaxxq.b = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
        }
      }
      if ((i != 0) && (localaxxq.jdField_a_of_type_AndroidWidgetTextView != null)) {
        ((RelativeLayout.LayoutParams)localaxxq.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).leftMargin = actn.a(38.0F, paramContext.getResources());
      }
      paramView.setTag(localaxxq);
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
 * Qualified Name:     axxo
 * JD-Core Version:    0.7.0.1
 */