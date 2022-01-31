import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aztw
  extends azqk
{
  protected int b()
  {
    return 3;
  }
  
  @TargetApi(16)
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    int j = 0;
    Resources localResources = paramContext.getResources();
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      if (!((azqj)((Iterator)localObject1).next() instanceof azsg)) {
        break label944;
      }
      i += 1;
    }
    label428:
    label944:
    for (;;)
    {
      break;
      paramBundle.putInt("Layout3ButtonCount", i);
      int m;
      int k;
      Object localObject2;
      if ((paramView != null) && ((paramView instanceof LinearLayout)))
      {
        localObject1 = (LinearLayout)paramView;
        m = this.jdField_a_of_type_JavaUtilArrayList.size();
        i = 0;
        j = 0;
        k = i;
        paramView = (View)localObject1;
        if (j >= m) {
          break label798;
        }
        paramView = (azqj)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        paramView.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject2 = paramView.jdField_a_of_type_JavaLangString;
        if (("picture".equals(localObject2)) || ("video".equals(localObject2)))
        {
          paramView.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          paramView = paramView.a(paramContext, ((LinearLayout)localObject1).getChildAt(j), paramBundle);
          if ((paramView instanceof PAHighLightImageView)) {
            paramView = (PAHighLightImageView)paramView;
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        if ("button".equals(localObject2))
        {
          paramBundle.putInt("Layout3ButtonIndex", j);
          paramView.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          paramView.a(paramContext, ((LinearLayout)localObject1).getChildAt(j * 2), paramBundle);
          if (i == 0)
          {
            i = 1;
            continue;
            paramView = new LinearLayout(paramContext);
            localObject1 = new ArrayList();
            int n = this.jdField_a_of_type_JavaUtilArrayList.size();
            k = 0;
            m = 0;
            i = j;
            String str;
            if (m < n)
            {
              localObject2 = (azqj)this.jdField_a_of_type_JavaUtilArrayList.get(m);
              ((azqj)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
              str = ((azqj)localObject2).jdField_a_of_type_JavaLangString;
              if ((!"picture".equals(str)) && (!"video".equals(str))) {
                break label488;
              }
              if (k < 3) {}
            }
            else
            {
              if (((ArrayList)localObject1).size() != 0) {
                break label595;
              }
              if (QLog.isColorLevel()) {
                QLog.e("StructMsg", 2, "generate 3 item failed,item is:" + this.jdField_a_of_type_JavaUtilArrayList);
              }
              return null;
            }
            ((azqj)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
            localObject2 = ((azqj)localObject2).a(paramContext, null, paramBundle);
            j = 0;
            if (m == 0)
            {
              j = 2131377061;
              ((View)localObject2).setId(j);
              ((ArrayList)localObject1).add(localObject2);
              j = k + 1;
            }
            label595:
            for (;;)
            {
              m += 1;
              k = j;
              break;
              if (m == 1)
              {
                j = 2131377062;
                break label428;
              }
              if (m != 2) {
                break label428;
              }
              j = 2131377063;
              break label428;
              label488:
              if ("button".equals(str))
              {
                paramBundle.putInt("Layout3ButtonIndex", m);
                ((azqj)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
                localObject2 = ((azqj)localObject2).a(paramContext, null, paramBundle);
                j = 0;
                if (m == 0) {
                  j = 2131377061;
                }
                for (;;)
                {
                  ((View)localObject2).setId(j);
                  ((ArrayList)localObject1).add(localObject2);
                  j = k + 1;
                  if (i != 0) {
                    break label931;
                  }
                  i = 1;
                  break;
                  if (m == 1) {
                    j = 2131377062;
                  } else if (m == 2) {
                    j = 2131377063;
                  }
                }
                j = aekt.a(10.0F, localResources);
                n = ((ArrayList)localObject1).size();
                j = (int)((BaseChatItemLayout.e - j - j - 2) / 3.0F);
                k = 0;
                if (k < n)
                {
                  paramBundle = (View)((ArrayList)localObject1).get(k);
                  localObject2 = new LinearLayout.LayoutParams(-1, -2);
                  ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
                  ((LinearLayout.LayoutParams)localObject2).width = 0;
                  ((LinearLayout.LayoutParams)localObject2).height = j;
                  if ((paramBundle instanceof TextView))
                  {
                    m = aekt.a(45.0F, localResources);
                    ((LinearLayout.LayoutParams)localObject2).height = m;
                    paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
                    j = m;
                    if (k == n - 1) {
                      break label791;
                    }
                    paramBundle = new ImageView(paramContext);
                    paramBundle.setLayoutParams(new ViewGroup.LayoutParams(1, m - 2));
                    paramBundle.setBackgroundColor(-2170912);
                    paramView.addView(paramBundle);
                    j = m;
                  }
                  for (;;)
                  {
                    k += 1;
                    break;
                    if (k > 0) {
                      ((LinearLayout.LayoutParams)localObject2).leftMargin = 1;
                    }
                    paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
                  }
                }
                k = i;
                a(paramView);
                d(paramView);
                if (k == 0)
                {
                  i = aekt.a(10.0F, localResources);
                  if (a(1))
                  {
                    j = i;
                    if (!a(2)) {
                      break label888;
                    }
                    m = i;
                    n = i;
                    k = j;
                    j = i;
                    i = n;
                  }
                }
                for (;;)
                {
                  paramView.setPadding(m, k, i, j);
                  return paramView;
                  j = aekt.a(5.0F, localResources);
                  break;
                  label888:
                  k = aekt.a(5.0F, localResources);
                  m = i;
                  n = j;
                  j = k;
                  k = n;
                  continue;
                  j = 0;
                  i = 0;
                  k = 0;
                  m = 0;
                }
              }
              else
              {
                j = k;
              }
            }
          }
        }
      }
    }
  }
  
  public String b()
  {
    return "Layout3";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztw
 * JD-Core Version:    0.7.0.1
 */