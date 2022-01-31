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

public class azyq
  extends azut
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
          localObject1 = (azus)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          ((azus)localObject1).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          localObject2 = ((azus)localObject1).jdField_a_of_type_JavaLangString;
          if ("summary".equals(localObject2))
          {
            localObject1 = (azzm)localObject1;
            if (paramBoolean)
            {
              ((azzm)localObject1).b("black");
              label122:
              localObject2 = ((azzm)localObject1).f();
              if ((localObject2 == null) || (!((String)localObject2).equals("1"))) {
                break label189;
              }
              ((azzm)localObject1).c("22");
              ((azzm)localObject1).a(true);
              ((azzm)localObject1).a(paramContext, paramView.findViewById(2), paramBundle);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            ((azzm)localObject1).b(null);
            break label122;
            label189:
            if ((localObject2 != null) && (((String)localObject2).equals("2")))
            {
              ((azzm)localObject1).c("44");
              ((azzm)localObject1).a(true);
              ((azzm)localObject1).a(paramContext, paramView.findViewById(3), paramBundle);
            }
            else
            {
              ((azzm)localObject1).c("30");
              ((azzm)localObject1).b(20);
              ((azzm)localObject1).a(paramContext, paramView.findViewById(4), paramBundle);
              continue;
              if ("picture".equals(localObject2))
              {
                localObject1 = (azwv)localObject1;
                if ((((azwv)localObject1).c != null) && (!((azwv)localObject1).c.equals("")))
                {
                  localObject2 = ((azwv)localObject1).a(paramContext, paramView.findViewById(6), true, paramBundle);
                  ((View)localObject2).setClickable(true);
                  ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
                }
                else
                {
                  ((azwv)localObject1).a(paramContext, paramView.findViewById(5), true, paramBundle);
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
      paramView.rightMargin = aepi.a(20.0F, localResources);
      ((RelativeLayout)localObject1).addView(localLinearLayout, paramView);
      paramView = null;
      i = 0;
      Object localObject3;
      if (i < j)
      {
        localObject2 = (azus)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ((azus)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject3 = ((azus)localObject2).jdField_a_of_type_JavaLangString;
        if ("summary".equals(localObject3))
        {
          localObject2 = (azzm)localObject2;
          if (paramBoolean)
          {
            ((azzm)localObject2).b("black");
            label527:
            localObject3 = ((azzm)localObject2).f();
            if ((localObject3 == null) || (!((String)localObject3).equals("1"))) {
              break label621;
            }
            ((azzm)localObject2).c("22");
            ((azzm)localObject2).a(true);
            localObject2 = ((azzm)localObject2).a(paramContext, null, paramBundle);
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
        ((azzm)localObject2).b(null);
        break label527;
        label621:
        if ((localObject3 != null) && (((String)localObject3).equals("2")))
        {
          ((azzm)localObject2).c("44");
          ((azzm)localObject2).a(true);
          localObject2 = ((azzm)localObject2).a(paramContext, null, paramBundle);
          ((View)localObject2).setId(3);
          localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject3).topMargin = aepi.a(-3.5F, localResources);
          localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
        else
        {
          ((azzm)localObject2).c("30");
          ((azzm)localObject2).b(20);
          localObject2 = ((azzm)localObject2).a(paramContext, null, paramBundle);
          ((View)localObject2).setId(4);
          localObject3 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject3).addRule(1, 1);
          ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          continue;
          if ("picture".equals(localObject3))
          {
            localObject3 = (azwv)localObject2;
            localObject2 = ((azwv)localObject3).a(paramContext, null, true, paramBundle);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(aepi.a(40.0F, localResources), aepi.a(40.0F, localResources));
            if ((((azwv)localObject3).c != null) && (!((azwv)localObject3).c.equals("")))
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
                paramContext = new RelativeLayout.LayoutParams(aepi.a(40.0F, localResources), aepi.a(40.0F, localResources));
                if (((RelativeLayout)localObject1).findViewById(6) != null)
                {
                  paramContext.addRule(0, 6);
                  paramContext.rightMargin = aepi.a(7.5F, localResources);
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
                i = aepi.a(22.5F, localResources);
                j = aepi.a(22.5F, localResources);
                ((RelativeLayout)localObject1).setPadding(i, aepi.a(10.75F, localResources), j, aepi.a(11.75F, localResources));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azyq
 * JD-Core Version:    0.7.0.1
 */