import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class azxt
  extends azut
{
  protected int b()
  {
    return 24;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1;
    azxv localazxv;
    if ((paramView != null) && ((paramView.getTag() instanceof azxv)))
    {
      localObject1 = (RelativeLayout)paramView;
      ((RelativeLayout)localObject1).removeAllViews();
      localazxv = (azxv)paramView.getTag();
      localazxv.a();
      paramView = (View)localObject1;
    }
    try
    {
      localObject1 = this.a.iterator();
      label54:
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (azus)((Iterator)localObject1).next();
        if ("picture".equals(((azus)localObject2).a))
        {
          localObject2 = ((azwv)localObject2).a(paramContext, localazxv.jdField_a_of_type_AndroidViewView, true, paramBundle);
          i = aepi.a(30.0F, paramContext.getResources());
          paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(i, i));
          localazxv.jdField_a_of_type_AndroidViewView = ((View)localObject2);
          ((View)localObject2).setVisibility(0);
          i = 1;
        }
        for (;;)
        {
          break label54;
          paramView = new RelativeLayout(paramContext);
          paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          int j = aepi.a(10.0F, paramContext.getResources());
          int k = aepi.a(13.0F, paramContext.getResources());
          paramView.setPadding(k, j, k, aepi.a(11.0F, paramContext.getResources()));
          localazxv = new azxv(null);
          break;
          if ("title".equals(((azus)localObject2).a))
          {
            localObject2 = (TextView)((azus)localObject2).a(paramContext, localazxv.jdField_a_of_type_AndroidWidgetTextView, paramBundle);
            ((TextView)localObject2).setGravity(16);
            paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(-2, aepi.a(30.0F, paramContext.getResources())));
            localazxv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
          else if ("summary".equals(((azus)localObject2).a))
          {
            ((azzm)localObject2).b(2147483647);
            localObject2 = (TextView)((azus)localObject2).a(paramContext, localazxv.b, paramBundle);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.topMargin = aepi.a(34.0F, paramContext.getResources());
            localLayoutParams.bottomMargin = aepi.a(3.0F, paramContext.getResources());
            paramView.addView((View)localObject2, localLayoutParams);
            localazxv.b = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
        }
      }
      if ((i != 0) && (localazxv.jdField_a_of_type_AndroidWidgetTextView != null)) {
        ((RelativeLayout.LayoutParams)localazxv.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).leftMargin = aepi.a(38.0F, paramContext.getResources());
      }
      paramView.setTag(localazxv);
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
 * Qualified Name:     azxt
 * JD-Core Version:    0.7.0.1
 */