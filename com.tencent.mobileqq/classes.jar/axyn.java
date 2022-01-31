import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;

public class axyn
  extends axuq
{
  public View a(Context paramContext, View paramView, boolean paramBoolean, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (paramView != null)
    {
      localObject1 = localObject2;
      if ((paramView instanceof RelativeLayout))
      {
        paramView = (RelativeLayout)paramView;
        if (paramView.getChildCount() == j)
        {
          i = 0;
          localObject1 = paramView;
          if (i >= j) {
            break label1053;
          }
          localObject1 = (axup)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          ((axup)localObject1).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          localObject2 = ((axup)localObject1).jdField_a_of_type_JavaLangString;
          if ("summary".equals(localObject2))
          {
            localObject1 = (axzj)localObject1;
            if (paramBoolean)
            {
              ((axzj)localObject1).b("black");
              label122:
              localObject2 = ((axzj)localObject1).f();
              if ((localObject2 == null) || (!((String)localObject2).equals("1"))) {
                break label189;
              }
              ((axzj)localObject1).c("22");
              ((axzj)localObject1).a(true);
              ((axzj)localObject1).a(paramContext, paramView.findViewById(2), paramBundle);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            ((axzj)localObject1).b(null);
            break label122;
            label189:
            if ((localObject2 != null) && (((String)localObject2).equals("2")))
            {
              ((axzj)localObject1).c("44");
              ((axzj)localObject1).a(true);
              ((axzj)localObject1).a(paramContext, paramView.findViewById(3), paramBundle);
            }
            else
            {
              ((axzj)localObject1).c("30");
              ((axzj)localObject1).b(20);
              ((axzj)localObject1).a(paramContext, paramView.findViewById(4), paramBundle);
              continue;
              if ("picture".equals(localObject2))
              {
                localObject1 = (axws)localObject1;
                if ((((axws)localObject1).c != null) && (!((axws)localObject1).c.equals("")))
                {
                  localObject2 = ((axws)localObject1).a(paramContext, paramView.findViewById(6), true, paramBundle);
                  ((View)localObject2).setClickable(true);
                  ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
                }
                else
                {
                  ((axws)localObject1).a(paramContext, paramView.findViewById(5), true, paramBundle);
                }
              }
            }
          }
        }
        paramView.removeAllViews();
        localObject1 = paramView;
      }
    }
    if (localObject1 == null)
    {
      localObject1 = new RelativeLayout(paramContext);
      ((RelativeLayout)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    }
    for (;;)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setGravity(3);
      localLinearLayout.setId(1);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(9, -1);
      paramView.rightMargin = actj.a(20.0F, localResources);
      ((RelativeLayout)localObject1).addView(localLinearLayout, paramView);
      paramView = null;
      i = 0;
      Object localObject3;
      if (i < j)
      {
        localObject2 = (axup)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ((axup)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject3 = ((axup)localObject2).jdField_a_of_type_JavaLangString;
        if ("summary".equals(localObject3))
        {
          localObject2 = (axzj)localObject2;
          if (paramBoolean)
          {
            ((axzj)localObject2).b("black");
            label527:
            localObject3 = ((axzj)localObject2).f();
            if ((localObject3 == null) || (!((String)localObject3).equals("1"))) {
              break label621;
            }
            ((axzj)localObject2).c("22");
            ((axzj)localObject2).a(true);
            localObject2 = ((axzj)localObject2).a(paramContext, null, paramBundle);
            ((View)localObject2).setId(2);
            ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            localLinearLayout.addView((View)localObject2, 0);
          }
        }
      }
      label1053:
      label1066:
      for (;;)
      {
        i += 1;
        break;
        ((axzj)localObject2).b(null);
        break label527;
        label621:
        if ((localObject3 != null) && (((String)localObject3).equals("2")))
        {
          ((axzj)localObject2).c("44");
          ((axzj)localObject2).a(true);
          localObject2 = ((axzj)localObject2).a(paramContext, null, paramBundle);
          ((View)localObject2).setId(3);
          localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject3).topMargin = actj.a(-3.5F, localResources);
          localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
        else
        {
          ((axzj)localObject2).c("30");
          ((axzj)localObject2).b(20);
          localObject2 = ((axzj)localObject2).a(paramContext, null, paramBundle);
          ((View)localObject2).setId(4);
          localObject3 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject3).addRule(1, 1);
          ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          continue;
          if ("picture".equals(localObject3))
          {
            localObject3 = (axws)localObject2;
            localObject2 = ((axws)localObject3).a(paramContext, null, true, paramBundle);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(actj.a(40.0F, localResources), actj.a(40.0F, localResources));
            if ((((axws)localObject3).c != null) && (!((axws)localObject3).c.equals("")))
            {
              ((View)localObject2).setId(6);
              localLayoutParams.addRule(11, -1);
              ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
              ((View)localObject2).setClickable(true);
              ((View)localObject2).setOnClickListener((View.OnClickListener)localObject3);
            }
            else
            {
              ((View)localObject2).setId(5);
              paramView = (View)localObject2;
              continue;
              if (localLinearLayout.getChildCount() == 0) {
                localLinearLayout.setVisibility(8);
              }
              if (paramView != null)
              {
                paramContext = new RelativeLayout.LayoutParams(actj.a(40.0F, localResources), actj.a(40.0F, localResources));
                if (((RelativeLayout)localObject1).findViewById(6) != null)
                {
                  paramContext.addRule(0, 6);
                  paramContext.rightMargin = actj.a(7.5F, localResources);
                  ((RelativeLayout)localObject1).addView(paramView, paramContext);
                }
              }
              else
              {
                paramContext = ((RelativeLayout)localObject1).findViewById(4);
                if (paramContext != null)
                {
                  paramView = (RelativeLayout.LayoutParams)paramContext.getLayoutParams();
                  if (((RelativeLayout)localObject1).findViewById(5) == null) {
                    break label1066;
                  }
                  paramView.addRule(0, 5);
                }
              }
              for (;;)
              {
                paramContext.setLayoutParams(paramView);
                a((View)localObject1);
                i = actj.a(22.5F, localResources);
                j = actj.a(22.5F, localResources);
                ((RelativeLayout)localObject1).setPadding(i, actj.a(10.75F, localResources), j, actj.a(11.75F, localResources));
                return localObject1;
                paramContext.addRule(11, -1);
                break;
                if (((RelativeLayout)localObject1).findViewById(6) != null) {
                  paramView.addRule(0, 6);
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected int b()
  {
    return 9;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    return a(paramContext, paramView, false, paramBundle);
  }
  
  public String b()
  {
    return "Layout9";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axyn
 * JD-Core Version:    0.7.0.1
 */