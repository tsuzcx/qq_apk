import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aztc
  extends azqk
{
  protected boolean a;
  
  private TextViewWrapLayout a(Context paramContext)
  {
    paramContext = new TextViewWrapLayout(paramContext);
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    if (!TextUtils.isEmpty(this.c)) {
      paramContext.setBackgroundResource(2130839253);
    }
    d(paramContext);
    return paramContext;
  }
  
  private void a(Context paramContext, ViewGroup paramViewGroup)
  {
    Resources localResources = paramContext.getResources();
    int m = localResources.getDimensionPixelSize(2131298817);
    int n = localResources.getDimensionPixelSize(2131298818);
    int i = aekt.a(5.0F, localResources);
    if (a(1)) {}
    for (int j = a(paramContext, 10) + i;; j = i)
    {
      int k = i;
      if (a(2)) {
        k = i + a(paramContext, 10);
      }
      paramViewGroup.setPadding(m, j, n, k);
      return;
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    paramView.setVisibility(paramInt);
  }
  
  private void a(ViewGroup paramViewGroup, View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if ((paramViewGroup == null) || (paramView == null) || (paramLayoutParams == null)) {
      return;
    }
    paramViewGroup.addView(paramView, paramLayoutParams);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {}
    while (paramInt <= 0) {
      return;
    }
    paramTextView.setMaxLines(paramInt);
  }
  
  private void b(Context paramContext, ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      paramContext = paramContext.getResources();
      int i = aekt.a(11.0F, paramContext);
      int j = aekt.a(14.0F, paramContext);
      paramViewGroup.setPadding(j, i, j, aekt.a(12.0F, paramContext));
    }
  }
  
  protected int b()
  {
    return 2;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject9 = paramContext.getResources();
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("pre_dialog", false);
    Object localObject8 = null;
    Object localObject3 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    Object localObject7 = null;
    Object localObject1 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject10 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject10).hasNext())
    {
      Object localObject11 = (azqj)((Iterator)localObject10).next();
      if ((localObject11 instanceof azsm))
      {
        localObject11 = (azsm)localObject11;
        if (((azsm)localObject11).p == azsm.o) {
          ((azsm)localObject11).p = azsm.m;
        }
      }
    }
    if ((paramView != null) && ((paramView instanceof TextViewWrapLayout)))
    {
      localObject8 = (TextViewWrapLayout)paramView;
      localObject9 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramView = (View)localObject4;
      localObject5 = localObject2;
      localObject7 = paramView;
      localObject6 = localObject1;
      localObject4 = localObject8;
      if (!((Iterator)localObject9).hasNext()) {
        break label966;
      }
      localObject4 = (azqj)((Iterator)localObject9).next();
      ((azqj)localObject4).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      localObject5 = ((azqj)localObject4).jdField_a_of_type_JavaLangString;
      if ((("picture".equals(localObject5)) || ("vote".equals(localObject5)) || ("video".equals(localObject5))) && (localObject3 == null)) {
        localObject3 = ((azqj)localObject4).a(paramContext, ((TextViewWrapLayout)localObject8).findViewById(2131368083), paramBundle);
      }
    }
    for (;;)
    {
      break;
      if (("title".equals(localObject5)) && (localObject2 == null))
      {
        if ((localObject4 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject4).a(a(), this.l);
        }
        localObject2 = (TextView)((azqj)localObject4).a(paramContext, ((TextViewWrapLayout)localObject8).findViewById(2131378985), paramBundle);
      }
      else if (localObject1 == null)
      {
        if (("summary".equals(localObject5)) || ("timer".equals(localObject5)))
        {
          localObject1 = (TextView)((azqj)localObject4).a(paramContext, ((TextViewWrapLayout)localObject8).findViewById(2131378960), paramBundle);
        }
        else if ("checklist".equals(localObject5))
        {
          paramView = (LinearLayout)((azqj)localObject4).a(paramContext, ((TextViewWrapLayout)localObject8).findViewById(2131378645), paramBundle);
          continue;
          localObject4 = a(paramContext);
          localObject10 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          localObject3 = localObject8;
          localObject1 = localObject7;
          paramView = (View)localObject6;
          localObject2 = localObject5;
          if (((Iterator)localObject10).hasNext())
          {
            localObject5 = (azqj)((Iterator)localObject10).next();
            ((azqj)localObject5).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
            localObject6 = ((azqj)localObject5).jdField_a_of_type_JavaLangString;
            if ((("picture".equals(localObject6)) || ("vote".equals(localObject6)) || ("video".equals(localObject6))) && (localObject3 == null)) {
              localObject3 = ((azqj)localObject5).a(paramContext, null, paramBundle);
            }
          }
          for (;;)
          {
            break;
            if (("title".equals(localObject6)) && (localObject2 == null))
            {
              if ((localObject5 instanceof StructMsgItemTitle)) {
                ((StructMsgItemTitle)localObject5).a(a(), this.l);
              }
              localObject2 = (TextView)((azqj)localObject5).a(paramContext, null, paramBundle);
            }
            else if (localObject1 == null)
            {
              if (("summary".equals(localObject6)) || ("timer".equals(localObject6)))
              {
                localObject1 = (TextView)((azqj)localObject5).a(paramContext, null, paramBundle);
              }
              else if ("checklist".equals(localObject6))
              {
                paramView = (LinearLayout)((azqj)localObject5).a(paramContext, null, paramBundle);
                continue;
                if (localObject3 == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("StructMsg", 2, "generate 2 item failure.");
                  }
                  paramContext = null;
                  return paramContext;
                }
                localObject5 = localObject2;
                if (localObject2 == null)
                {
                  localObject5 = localObject2;
                  if (localObject1 != null) {
                    localObject5 = (TextView)new StructMsgItemTitle(((TextView)localObject1).getText().toString()).a(paramContext, null, paramBundle);
                  }
                }
                if (localObject5 == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("StructMsg", 2, "generate 2 item titleview failure.");
                  }
                  return null;
                }
                localObject6 = new RelativeLayout.LayoutParams(-1, -2);
                ((RelativeLayout.LayoutParams)localObject6).topMargin = 0;
                ((RelativeLayout.LayoutParams)localObject6).addRule(10);
                localObject7 = new RelativeLayout.LayoutParams(-1, -2);
                ((RelativeLayout.LayoutParams)localObject7).addRule(3, ((TextView)localObject5).getId());
                label819:
                label881:
                int i;
                label966:
                label989:
                int j;
                if ((this.k == 1) || (this.k == 3)) {
                  if (this.k == 1)
                  {
                    localObject2 = new RelativeLayout.LayoutParams(aekt.a(50.0F, (Resources)localObject9), aekt.a(50.0F, (Resources)localObject9));
                    ((RelativeLayout.LayoutParams)localObject2).topMargin = aekt.a(3.0F, (Resources)localObject9);
                    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
                    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                    localObject8 = new RelativeLayout(paramContext);
                    localObject10 = new RelativeLayout.LayoutParams(-1, -2);
                    if (this.k != 3) {
                      break label1399;
                    }
                    ((RelativeLayout.LayoutParams)localObject10).topMargin = aekt.a(12.0F, (Resources)localObject9);
                    ((RelativeLayout.LayoutParams)localObject7).topMargin = 5;
                    ((RelativeLayout.LayoutParams)localObject10).addRule(10);
                    ((RelativeLayout.LayoutParams)localObject10).addRule(1, ((View)localObject3).getId());
                    ((RelativeLayout.LayoutParams)localObject10).leftMargin = aekt.a(10.0F, (Resources)localObject9);
                    a((ViewGroup)localObject4, (View)localObject3, (RelativeLayout.LayoutParams)localObject2);
                    a((ViewGroup)localObject8, (View)localObject5, (RelativeLayout.LayoutParams)localObject6);
                    a((ViewGroup)localObject8, (View)localObject1, (RelativeLayout.LayoutParams)localObject7);
                    a((ViewGroup)localObject8, paramView, (RelativeLayout.LayoutParams)localObject7);
                    ((TextViewWrapLayout)localObject4).addView((View)localObject8, (ViewGroup.LayoutParams)localObject10);
                    localObject6 = localObject1;
                    localObject7 = paramView;
                    if ((this.k != 1) && (this.k != 3)) {
                      break label1713;
                    }
                    a(paramContext, (ViewGroup)localObject4);
                    i = 0;
                    int k = 0;
                    j = i;
                    if (localObject5 != null)
                    {
                      paramContext = ((TextView)localObject5).getTag();
                      j = i;
                      if ((paramContext instanceof StructMsgItemTitle))
                      {
                        paramContext = (StructMsgItemTitle)paramContext;
                        j = i;
                        if (paramContext != null)
                        {
                          if (TextUtils.isEmpty(paramContext.b())) {
                            break label1723;
                          }
                          i = 1;
                          label1047:
                          j = i;
                        }
                      }
                    }
                    i = k;
                    if (localObject6 != null)
                    {
                      paramContext = ((TextView)localObject6).getTag();
                      i = k;
                      if ((paramContext instanceof azvd))
                      {
                        paramContext = (azvd)paramContext;
                        i = k;
                        if (paramContext != null)
                        {
                          if (TextUtils.isEmpty(paramContext.b())) {
                            break label1729;
                          }
                          i = 1;
                        }
                      }
                    }
                    label1103:
                    if (localObject7 == null) {
                      break label1809;
                    }
                    paramContext = ((LinearLayout)localObject7).getTag();
                    if (!(paramContext instanceof azvv)) {
                      break label1809;
                    }
                    paramContext = ((azvv)paramContext).jdField_a_of_type_JavaUtilArrayList;
                    if ((paramContext == null) || (paramContext.isEmpty())) {
                      break label1735;
                    }
                    i = 1;
                  }
                }
                label1799:
                label1809:
                for (;;)
                {
                  label1143:
                  if (j != 0)
                  {
                    a((TextView)localObject5, 2);
                    a((View)localObject5, 0);
                    a((TextView)localObject6, 2);
                    if ((this.k == 1) || (this.k == 3))
                    {
                      ((TextView)localObject5).setTextSize(16.0F);
                      if (i == 0) {
                        break label1788;
                      }
                      a((View)localObject6, 0);
                      if ((this.k != 1) && (this.k != 3)) {
                        break label1799;
                      }
                      if (localObject6 != null) {
                        ((TextView)localObject6).setSingleLine(true);
                      }
                      if (localObject5 != null)
                      {
                        ((TextView)localObject5).setSingleLine(true);
                        ((TextView)localObject5).setMaxLines(1);
                      }
                    }
                  }
                  for (;;)
                  {
                    label1193:
                    label1205:
                    paramContext = (Context)localObject4;
                    if (!AppSetting.c) {
                      break;
                    }
                    paramContext = new StringBuilder();
                    if (localObject5 != null) {
                      paramContext.append(((TextView)localObject5).getText());
                    }
                    i = paramBundle.getInt("serviceID", 0);
                    if ((localObject6 != null) && ((i == 32) || (i == 14) || (i == 15) || (i == 16) || (i == 17))) {
                      paramContext.append(",").append(((TextView)localObject6).getText());
                    }
                    ((TextViewWrapLayout)localObject4).setContentDescription(paramContext.toString());
                    return localObject4;
                    localObject2 = new RelativeLayout.LayoutParams(aekt.a(115.0F, (Resources)localObject9), aekt.a(70.0F, (Resources)localObject9));
                    ((RelativeLayout.LayoutParams)localObject2).topMargin = aekt.a(3.0F, (Resources)localObject9);
                    break label819;
                    label1399:
                    ((RelativeLayout.LayoutParams)localObject10).topMargin = aekt.a(7.0F, (Resources)localObject9);
                    ((RelativeLayout.LayoutParams)localObject7).topMargin = 0;
                    break label881;
                    if (!this.jdField_a_of_type_Boolean)
                    {
                      if (localObject1 != null) {
                        ((TextView)localObject1).setLineSpacing(aekt.a(1.0F, (Resources)localObject9), 1.0F);
                      }
                      localObject2 = new RelativeLayout.LayoutParams(aekt.a(50.0F, (Resources)localObject9), aekt.a(50.0F, (Resources)localObject9));
                      ((RelativeLayout.LayoutParams)localObject2).topMargin = aekt.a(7.0F, (Resources)localObject9);
                      ((RelativeLayout.LayoutParams)localObject2).leftMargin = aekt.a(10.0F, (Resources)localObject9);
                      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((TextView)localObject5).getId());
                      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                      ((RelativeLayout.LayoutParams)localObject7).topMargin = aekt.a(5.0F, (Resources)localObject9);
                      ((RelativeLayout.LayoutParams)localObject7).addRule(0, ((View)localObject3).getId());
                      a((ViewGroup)localObject4, (View)localObject5, (RelativeLayout.LayoutParams)localObject6);
                      a((ViewGroup)localObject4, (View)localObject3, (RelativeLayout.LayoutParams)localObject2);
                      a((ViewGroup)localObject4, (View)localObject1, (RelativeLayout.LayoutParams)localObject7);
                      a((ViewGroup)localObject4, paramView, (RelativeLayout.LayoutParams)localObject7);
                      localObject7 = paramView;
                      localObject6 = localObject1;
                      break label966;
                    }
                    localObject2 = new RelativeLayout.LayoutParams(aekt.a(32.0F, (Resources)localObject9), aekt.a(32.0F, (Resources)localObject9));
                    ((RelativeLayout.LayoutParams)localObject2).leftMargin = aekt.a(6.0F, (Resources)localObject9);
                    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
                    i = bdkf.a(20.0F);
                    ((RelativeLayout.LayoutParams)localObject6).topMargin = i;
                    ((RelativeLayout.LayoutParams)localObject6).bottomMargin = i;
                    ((RelativeLayout.LayoutParams)localObject6).addRule(0, ((View)localObject3).getId());
                    ((RelativeLayout.LayoutParams)localObject6).addRule(9);
                    ((RelativeLayout.LayoutParams)localObject6).addRule(15);
                    a((ViewGroup)localObject4, (View)localObject3, (RelativeLayout.LayoutParams)localObject2);
                    a((ViewGroup)localObject4, (View)localObject5, (RelativeLayout.LayoutParams)localObject6);
                    localObject7 = paramView;
                    localObject6 = localObject1;
                    break label966;
                    label1713:
                    b(paramContext, (ViewGroup)localObject4);
                    break label989;
                    label1723:
                    i = 0;
                    break label1047;
                    label1729:
                    i = 0;
                    break label1103;
                    label1735:
                    i = 0;
                    break label1143;
                    if (!this.jdField_a_of_type_Boolean) {}
                    for (float f = 17.0F;; f = 14.0F)
                    {
                      ((TextView)localObject5).setTextSize(f);
                      break;
                    }
                    a((View)localObject5, 8);
                    a((TextView)localObject6, 4);
                    break label1193;
                    label1788:
                    a((View)localObject6, 8);
                    break label1205;
                    a((TextView)localObject6, 3);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public String b()
  {
    return "Layout2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztc
 * JD-Core Version:    0.7.0.1
 */