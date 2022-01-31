import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.FixRatioPAHighLightImageView;
import com.tencent.mobileqq.widget.PAImageView;
import java.util.ArrayList;
import java.util.Iterator;

public class azuc
  extends azqk
{
  public static int o = 100;
  public static int p = 200;
  public static int q = 300;
  public static int r = 400;
  private boolean a;
  
  private LinearLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setPadding(localResources.getDimensionPixelSize(2131298817), 0, localResources.getDimensionPixelSize(2131298818), 0);
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  private void a(Context paramContext, Resources paramResources, LinearLayout paramLinearLayout, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    int k = paramResources.getDimensionPixelSize(2131296355);
    int m = paramResources.getDimensionPixelSize(2131296356);
    Object localObject1 = paramBundle.getString("sType");
    Object localObject2;
    label157:
    Object localObject3;
    int i;
    int j;
    label222:
    Object localObject4;
    if (((localObject1 == null) || (!((String)localObject1).equals("1"))) || (paramLinearLayout.getChildCount() == this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramInt = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (azqj)((Iterator)localObject1).next();
        ((azqj)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        if ((localObject2 instanceof StructMsgItemTitle))
        {
          ((StructMsgItemTitle)localObject2).a(a(), this.l);
          ((StructMsgItemTitle)localObject2).a(false);
          if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).c())) {
            ((StructMsgItemTitle)localObject2).c(String.valueOf(36));
          }
          localObject3 = paramLinearLayout.getChildAt(paramInt);
          ((azqj)localObject2).a(paramContext, (View)localObject3, paramBundle);
          i = ((View)localObject3).getPaddingTop();
          j = ((View)localObject3).getPaddingBottom();
          if (paramBoolean)
          {
            if ((!(localObject2 instanceof azsm)) && (!(localObject2 instanceof azso))) {
              break label431;
            }
            ((View)localObject3).setPadding(0, i, 0, j);
          }
          if (!(localObject2 instanceof StructMsgItemTitle)) {
            break label467;
          }
          if ((paramBoolean) && (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).e()))) {
            ((TextView)localObject3).setTypeface(Typeface.DEFAULT, 1);
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if (!(localObject2 instanceof azvd)) {
            break label157;
          }
          localObject3 = (azvd)localObject2;
          ((azvd)localObject3).a();
          if ((localObject3 != null) && ((((azvd)localObject3).c() == null) || (((azvd)localObject3).c().equals("")))) {
            ((azvd)localObject3).c(String.valueOf(28));
          }
          localObject4 = ((azvd)localObject3).f();
          if ((localObject4 != null) && (((String)localObject4).equals("1")))
          {
            ((azvd)localObject3).c(String.valueOf(24));
            if ((!paramBoolean) || (!TextUtils.isEmpty(((azvd)localObject3).d()))) {
              break label157;
            }
            ((azvd)localObject3).b("#8e8e8e");
            break label157;
          }
          if (!paramBoolean) {
            break label157;
          }
          if (TextUtils.isEmpty(((azvd)localObject3).c())) {
            ((azvd)localObject3).c(String.valueOf(32));
          }
          if (!TextUtils.isEmpty(((azvd)localObject3).d())) {
            break label157;
          }
          ((azvd)localObject3).b("#000000");
          break label157;
          label431:
          if ((localObject2 instanceof azrm))
          {
            ((View)localObject3).setPadding(0, 0, 0, 0);
            break label222;
          }
          ((View)localObject3).setPadding(k, i, m, j);
          break label222;
          label467:
          if (((localObject2 instanceof azvd)) && (paramBoolean)) {
            ((TextView)localObject3).setLineSpacing(aekt.a(2.0F, paramResources), 1.0F);
          }
        }
      }
    }
    else
    {
      paramLinearLayout.removeAllViews();
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (azqj)((Iterator)localObject2).next();
        ((azqj)localObject1).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject3 = ((azqj)localObject1).jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject3))
        {
          if ((localObject1 instanceof StructMsgItemTitle))
          {
            ((StructMsgItemTitle)localObject1).a(a(), this.l);
            ((StructMsgItemTitle)localObject1).a(false);
            if (TextUtils.isEmpty(((StructMsgItemTitle)localObject1).c())) {
              ((StructMsgItemTitle)localObject1).c(String.valueOf(36));
            }
          }
          localObject3 = ((azqj)localObject1).a(paramContext, null, paramBundle);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).topMargin = aekt.a(2.5F, paramResources);
          ((LinearLayout.LayoutParams)localObject4).bottomMargin = aekt.a(1.5F, paramResources);
          if ((a(1)) && (i == 0)) {
            ((LinearLayout.LayoutParams)localObject4).topMargin = aekt.a(20.0F, paramResources);
          }
          if (paramBoolean)
          {
            ((View)localObject3).setPadding(k, ((View)localObject3).getPaddingTop(), m, ((View)localObject3).getPaddingBottom());
            if (TextUtils.isEmpty(((StructMsgItemTitle)localObject1).e())) {
              ((TextView)localObject3).setTypeface(Typeface.DEFAULT, 1);
            }
          }
          paramLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
        }
        for (;;)
        {
          i += 1;
          break;
          if ("hr".equals(localObject3))
          {
            localObject1 = ((azqj)localObject1).a(paramContext, null, paramBundle);
            localObject3 = new LinearLayout.LayoutParams(-1, 1);
            if (i > 0) {
              ((LinearLayout.LayoutParams)localObject3).topMargin = aekt.a(7.5F, paramResources);
            }
            if (paramBoolean)
            {
              ((LinearLayout.LayoutParams)localObject3).leftMargin = k;
              ((LinearLayout.LayoutParams)localObject3).rightMargin = m;
            }
            if (localObject1 != null) {
              paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
            }
          }
          else
          {
            if ("summary".equals(localObject3))
            {
              if ((localObject1 instanceof azql))
              {
                localObject3 = (azvd)localObject1;
                ((azvd)localObject3).a();
                if ((localObject3 != null) && ((((azvd)localObject3).c() == null) || (((azvd)localObject3).c().equals("")))) {
                  ((azvd)localObject3).c(String.valueOf(28));
                }
                localObject4 = ((azvd)localObject1).f();
                if ((localObject4 == null) || (!((String)localObject4).equals("1"))) {
                  break label1100;
                }
                ((azvd)localObject3).c(String.valueOf(24));
                if ((paramBoolean) && (TextUtils.isEmpty(((azvd)localObject3).d()))) {
                  ((azvd)localObject3).b("#8e8e8e");
                }
              }
              for (;;)
              {
                localObject1 = ((azqj)localObject1).a(paramContext, null, paramBundle);
                if (paramBoolean) {
                  ((TextView)localObject1).setLineSpacing(aekt.a(2.0F, paramResources), 1.0F);
                }
                localObject3 = new LinearLayout.LayoutParams(-2, -2);
                ((LinearLayout.LayoutParams)localObject3).topMargin = aekt.a(4.5F, paramResources);
                ((LinearLayout.LayoutParams)localObject3).bottomMargin = aekt.a(5.5F, paramResources);
                if ((a(2)) && (i == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = aekt.a(13.0F, paramResources);
                }
                if (paramBoolean) {
                  ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
                break;
                label1100:
                if (paramBoolean)
                {
                  if (TextUtils.isEmpty(((azvd)localObject3).c())) {
                    ((azvd)localObject3).c(String.valueOf(32));
                  }
                  if (TextUtils.isEmpty(((azvd)localObject3).d())) {
                    ((azvd)localObject3).b("#000000");
                  }
                }
              }
            }
            if ("timer".equals(localObject3))
            {
              localObject1 = ((azqj)localObject1).a(paramContext, null, paramBundle);
              localObject3 = new LinearLayout.LayoutParams(-2, -2);
              if (i > 0) {
                ((LinearLayout.LayoutParams)localObject3).topMargin = paramInt;
              }
              if (paramBoolean) {
                ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
              }
              paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
            }
            else
            {
              if (("picture".equals(localObject3)) || ("video".equals(localObject3)))
              {
                localObject4 = ((azqj)localObject1).a(paramContext, null, paramBundle);
                localObject1 = ((View)localObject4).findViewById(2131368083);
                if (("picture".equals(localObject3)) && (paramBoolean) && (a(1)) && (i == 0) && (paramBundle != null)) {
                  paramBundle.putBoolean("pa_should_change", true);
                }
                if ((localObject1 != null) && ((localObject1 instanceof AnyScaleTypeImageView)) && ("picture".equals(localObject3))) {
                  AnyScaleTypeImageView localAnyScaleTypeImageView = (AnyScaleTypeImageView)localObject1;
                }
                if (paramBoolean)
                {
                  ((View)localObject4).setPadding(0, ((View)localObject4).getPaddingTop(), 0, ((View)localObject4).getPaddingBottom());
                  if ((localObject1 instanceof FixRatioPAHighLightImageView))
                  {
                    ((FixRatioPAHighLightImageView)localObject1).setRatio(1.8F);
                    localObject1 = new LinearLayout.LayoutParams(-1, -2);
                    label1395:
                    if (i > 0) {
                      ((LinearLayout.LayoutParams)localObject1).topMargin = paramInt;
                    }
                    if ((!"picture".equals(localObject3)) || (!paramBoolean) || (!a(1)) || (i != 0)) {
                      break label1602;
                    }
                    ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
                    if ((localObject4 != null) && ((localObject4 instanceof PAImageView))) {
                      ((PAImageView)localObject4).setUseRadiusRound(true, paramResources.getDimensionPixelSize(2131296357));
                    }
                  }
                }
                for (;;)
                {
                  ((LinearLayout.LayoutParams)localObject1).bottomMargin = aekt.a(7.5F, paramResources);
                  paramLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject1);
                  break;
                  j = BaseChatItemLayout.z;
                  if (!paramBundle.getBoolean("hasHeadIcon", true)) {
                    j = BaseChatItemLayout.A;
                  }
                  localObject1 = new LinearLayout.LayoutParams(-1, (int)(j / 1.8D));
                  break label1395;
                  if ((!paramBundle.getBoolean("hasHeadIcon", true)) && (paramBundle.getInt("serviceID", 0) == 21))
                  {
                    localObject1 = new LinearLayout.LayoutParams(-1, aekt.a(105.0F, paramResources));
                    break label1395;
                  }
                  localObject1 = new LinearLayout.LayoutParams(-1, aekt.a(175.0F, paramResources));
                  break label1395;
                  label1602:
                  ((LinearLayout.LayoutParams)localObject1).topMargin = aekt.a(7.5F, paramResources);
                }
              }
              if ("more".equals(localObject3))
              {
                localObject1 = ((azqj)localObject1).a(paramContext, null, paramBundle);
                localObject3 = new LinearLayout.LayoutParams(-1, aekt.a(36.0F, paramResources));
                if (paramBoolean) {
                  ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
              }
              else if ("item".equals(localObject3))
              {
                localObject1 = ((azqj)localObject1).a(paramContext, null, paramBundle);
                if (paramBoolean) {
                  ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1);
              }
              else if ("price".equals(localObject3))
              {
                localObject1 = ((azqj)localObject1).a(paramContext, null, paramBundle);
                if (paramBoolean) {
                  ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1);
              }
              else if ("pavideo".equals(localObject3))
              {
                localObject1 = ((azqj)localObject1).a(paramContext, null, paramBundle);
                ((AnyScaleTypeImageView)localObject1).setImageResource(2130841361);
                localObject3 = new LinearLayout.LayoutParams(-1, (int)(BaseChatItemLayout.jdField_a_of_type_Int / 1.8D));
                if (paramBoolean)
                {
                  ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                  ((LinearLayout.LayoutParams)localObject3).topMargin = aekt.a(7.5F, paramResources);
                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = aekt.a(7.5F, paramResources);
                }
                paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
              }
              else if ("asyncmsg".equals(localObject3))
              {
                localObject1 = ((azqj)localObject1).a(paramContext, null, paramBundle);
                if (paramBoolean) {
                  ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1);
              }
              else if ("group".equals(localObject3))
              {
                localObject1 = ((azqj)localObject1).a(paramContext, null, paramBundle);
                ((View)localObject1).setPadding(0, 0, 0, 0);
                localObject3 = new LinearLayout.LayoutParams(-1, -2);
                ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
                ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
                ((LinearLayout.LayoutParams)localObject3).topMargin = 0;
                ((LinearLayout.LayoutParams)localObject3).bottomMargin = 0;
                paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
                this.jdField_a_of_type_Boolean = true;
              }
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      paramLinearLayout.setPadding(0, 0, 0, 0);
    }
  }
  
  private void a(Context paramContext, Resources paramResources, LinearLayout paramLinearLayout, int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject1 = new StringBuffer();
    Object localObject2 = new ArrayList();
    Object localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = -1;
    if (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (azqj)((Iterator)localObject3).next();
      ((azqj)localObject4).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      int j = i;
      if ((localObject4 instanceof azql))
      {
        localObject4 = (azql)localObject4;
        if (paramBoolean)
        {
          if (!(localObject4 instanceof azvd)) {
            break label216;
          }
          if (TextUtils.isEmpty(((azql)localObject4).c())) {
            ((azql)localObject4).c(String.valueOf(32));
          }
          if (TextUtils.isEmpty(((azql)localObject4).d())) {
            ((azql)localObject4).b("#000000");
          }
        }
      }
      for (;;)
      {
        localObject4 = ((azql)localObject4).a(paramResources);
        j = i;
        if (localObject4 != null)
        {
          ((azqm)localObject4).e = (i + 1);
          ((azqm)localObject4).f = (((azqm)localObject4).e + ((azqm)localObject4).jdField_a_of_type_JavaLangString.length());
          j = i + ((azqm)localObject4).jdField_a_of_type_JavaLangString.length();
          ((StringBuffer)localObject1).append(((azqm)localObject4).jdField_a_of_type_JavaLangString);
          ((ArrayList)localObject2).add(localObject4);
        }
        i = j;
        break;
        label216:
        if (((localObject4 instanceof StructMsgItemTitle)) && (TextUtils.isEmpty(((azql)localObject4).c()))) {
          ((azql)localObject4).c(String.valueOf(36));
        }
      }
    }
    localObject1 = new SpannableStringBuilder(((StringBuffer)localObject1).toString());
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (azqm)((Iterator)localObject2).next();
      ((SpannableStringBuilder)localObject1).setSpan(new TextAppearanceSpan(null, ((azqm)localObject3).b, (int)TypedValue.applyDimension(2, ((azqm)localObject3).c, paramResources.getDisplayMetrics()), ColorStateList.valueOf(((azqm)localObject3).jdField_a_of_type_Int), null), ((azqm)localObject3).e, ((azqm)localObject3).f, 33);
    }
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      paramContext = (TextView)paramView;
      paramContext.setText((CharSequence)localObject1);
      paramContext.requestLayout();
      return;
    }
    paramView = new LinearLayout.LayoutParams(-2, -2);
    paramContext = new TextView(paramContext);
    if (paramBoolean)
    {
      paramContext.setLineSpacing(aekt.a(2.0F, paramResources), 1.0F);
      paramView.topMargin = aekt.a(4.5F, paramResources);
      paramView.bottomMargin = aekt.a(5.5F, paramResources);
    }
    for (;;)
    {
      paramLinearLayout.addView(paramContext, paramView);
      break;
      paramContext.setLineSpacing(paramInt, 1.0F);
      if (a(2)) {
        paramView.bottomMargin = aekt.a(10.0F, paramResources);
      }
      if (a(1)) {
        paramView.topMargin = aekt.a(10.0F, paramResources);
      }
    }
  }
  
  protected int b()
  {
    return 6;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool;
    Resources localResources;
    label38:
    int k;
    int m;
    int i;
    if (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA)
    {
      bool = true;
      localResources = paramContext.getResources();
      if ((paramView == null) || (!(paramView instanceof LinearLayout))) {
        break label159;
      }
      paramView = (LinearLayout)paramView;
      k = paramView.getPaddingTop();
      m = paramView.getPaddingBottom();
      j = localResources.getDimensionPixelSize(2131298817);
      i = localResources.getDimensionPixelSize(2131298818);
      a(paramView);
      d(paramView);
      if (bool)
      {
        if (this.k != 1) {
          break label168;
        }
        i = localResources.getDimensionPixelSize(2131296355);
      }
    }
    for (int j = i;; j = 0)
    {
      paramView.setPadding(j, k, i, m);
      i = aekt.a(8.0F, localResources);
      if (this.k != 1) {
        break label177;
      }
      a(paramContext, localResources, paramView, i, paramView.getChildAt(0), bool);
      return paramView;
      bool = false;
      break;
      label159:
      paramView = a(paramContext);
      break label38;
      label168:
      i = 0;
    }
    label177:
    a(paramContext, localResources, paramView, i, paramBundle, bool);
    return paramView;
  }
  
  public String b()
  {
    return "Layout6";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azuc
 * JD-Core Version:    0.7.0.1
 */