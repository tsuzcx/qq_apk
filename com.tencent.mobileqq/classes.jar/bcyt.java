import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class bcyt
  extends bcvt
{
  protected int b()
  {
    return 24;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1;
    bcyv localbcyv;
    if ((paramView != null) && ((paramView.getTag() instanceof bcyv)))
    {
      localObject1 = (RelativeLayout)paramView;
      ((RelativeLayout)localObject1).removeAllViews();
      localbcyv = (bcyv)paramView.getTag();
      localbcyv.a();
      paramView = (View)localObject1;
    }
    try
    {
      localObject1 = this.a.iterator();
      label54:
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (bcvs)((Iterator)localObject1).next();
        if ("picture".equals(((bcvs)localObject2).a))
        {
          localObject2 = ((bcxv)localObject2).a(paramContext, localbcyv.jdField_a_of_type_AndroidViewView, true, paramBundle);
          i = afur.a(30.0F, paramContext.getResources());
          paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(i, i));
          localbcyv.jdField_a_of_type_AndroidViewView = ((View)localObject2);
          ((View)localObject2).setVisibility(0);
          i = 1;
        }
        for (;;)
        {
          break label54;
          paramView = new RelativeLayout(paramContext);
          paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          int j = afur.a(10.0F, paramContext.getResources());
          int k = afur.a(13.0F, paramContext.getResources());
          paramView.setPadding(k, j, k, afur.a(11.0F, paramContext.getResources()));
          localbcyv = new bcyv(null);
          break;
          if ("title".equals(((bcvs)localObject2).a))
          {
            localObject2 = (TextView)((bcvs)localObject2).a(paramContext, localbcyv.jdField_a_of_type_AndroidWidgetTextView, paramBundle);
            ((TextView)localObject2).setGravity(16);
            paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(-2, afur.a(30.0F, paramContext.getResources())));
            localbcyv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
          else if ("summary".equals(((bcvs)localObject2).a))
          {
            ((bdaq)localObject2).b(2147483647);
            localObject2 = (TextView)((bcvs)localObject2).a(paramContext, localbcyv.b, paramBundle);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.topMargin = afur.a(34.0F, paramContext.getResources());
            localLayoutParams.bottomMargin = afur.a(3.0F, paramContext.getResources());
            paramView.addView((View)localObject2, localLayoutParams);
            localbcyv.b = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
        }
      }
      if ((i != 0) && (localbcyv.jdField_a_of_type_AndroidWidgetTextView != null)) {
        ((RelativeLayout.LayoutParams)localbcyv.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).leftMargin = afur.a(38.0F, paramContext.getResources());
      }
      paramView.setTag(localbcyv);
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
 * Qualified Name:     bcyt
 * JD-Core Version:    0.7.0.1
 */