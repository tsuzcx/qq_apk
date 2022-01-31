import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class awyk
  extends awum
{
  protected int b()
  {
    return 0;
  }
  
  @TargetApi(16)
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("sType");
    int i;
    Resources localResources;
    int k;
    int j;
    int m;
    if (((localObject1 == null) || (!((String)localObject1).equals("1"))) || (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA))
    {
      i = 1;
      localResources = paramContext.getResources();
      k = localResources.getDimensionPixelSize(2131167690);
      j = localResources.getDimensionPixelSize(2131167691);
      m = aciy.a(2.0F, localResources);
      if (i == 0) {
        break label1962;
      }
      k = aciy.a(12.0F, localResources);
      j = k;
    }
    label794:
    label1181:
    label1576:
    label1962:
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof LinearLayout)))
      {
        localObject1 = (LinearLayout)paramView;
        label105:
        if (!a(1)) {
          break label1959;
        }
        m += a(paramContext, 10);
      }
      for (;;)
      {
        int n;
        if (!TextUtils.isEmpty(this.c))
        {
          ((LinearLayout)localObject1).setBackgroundResource(2130838124);
          n = aciy.a(1.0F, localResources);
          paramView = (LinearLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
          paramView.leftMargin = n;
          paramView.rightMargin = n;
          ((LinearLayout)localObject1).setLayoutParams(paramView);
        }
        ((LinearLayout)localObject1).setPadding(k, 0, j, 0);
        int i1;
        View localView;
        if (((LinearLayout)localObject1).getChildCount() == this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
          n = 0;
          if (n < i1)
          {
            paramView = (awul)this.jdField_a_of_type_JavaUtilArrayList.get(n);
            paramView.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
            if ((paramView instanceof StructMsgItemTitle)) {
              ((StructMsgItemTitle)paramView).a(a(), this.j);
            }
            localView = paramView.a(paramContext, ((LinearLayout)localObject1).getChildAt(n), paramBundle);
            if (localView != null) {
              break label328;
            }
          }
        }
        label328:
        Object localObject2;
        label639:
        do
        {
          return localObject1;
          i = 0;
          break;
          localObject1 = new LinearLayout(paramContext);
          ((LinearLayout)localObject1).setOrientation(1);
          ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          break label105;
          i2 = aciy.a(10.0F, localResources);
          i3 = aciy.a(5.0F, localResources);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          if (n > 0) {
            ((LinearLayout.LayoutParams)localObject2).topMargin = i3;
          }
          str = paramView.jdField_a_of_type_JavaLangString;
          if ("picture".equals(str))
          {
            localView.setId(-1);
            ((LinearLayout.LayoutParams)localObject2).height = (BaseChatItemLayout.e - i2 - i2);
          }
          for (;;)
          {
            n += 1;
            break;
            if ("video".equals(str))
            {
              ((LinearLayout.LayoutParams)localObject2).height = (BaseChatItemLayout.e - i2 - i2);
            }
            else if ("title".equals(str))
            {
              if (i != 0)
              {
                if (TextUtils.isEmpty(((StructMsgItemTitle)paramView).c())) {
                  ((TextView)localView).setTextSize(18.0F);
                }
                if (TextUtils.isEmpty(((StructMsgItemTitle)paramView).e())) {
                  ((TextView)localView).setTypeface(Typeface.DEFAULT, 1);
                }
              }
              localView.setId(-1);
            }
            else
            {
              if ("summary".equals(str))
              {
                if (this.i == 1)
                {
                  ((TextView)localView).setTextSize(12.0F);
                  ((TextView)localView).setTextColor(-4473925);
                }
                if (i != 0)
                {
                  localObject2 = ((awzf)paramView).f();
                  if ((localObject2 == null) || (!((String)localObject2).equals("1"))) {
                    break label639;
                  }
                  if (TextUtils.isEmpty(((awzf)paramView).c())) {
                    ((TextView)localView).setTextSize(12.0F);
                  }
                  if (TextUtils.isEmpty(((awzf)paramView).d())) {
                    ((TextView)localView).setTextColor(Color.parseColor("#8e8e8e"));
                  }
                }
                for (;;)
                {
                  localView.setId(-1);
                  break;
                  if (TextUtils.isEmpty(((awzf)paramView).c())) {
                    ((TextView)localView).setTextSize(16.0F);
                  }
                  if (TextUtils.isEmpty(((awzf)paramView).d())) {
                    ((TextView)localView).setTextColor(-16777216);
                  }
                  ((TextView)localView).setLineSpacing(4.0F, 1.0F);
                }
              }
              if ("hr".equals(str))
              {
                if (((awwq)paramView).a)
                {
                  ((LinearLayout.LayoutParams)localObject2).height = 0;
                  if ((i != 0) && (n != 0)) {
                    ((LinearLayout.LayoutParams)localObject2).topMargin += aciy.a(6.0F, localResources);
                  }
                  localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                  if (i == 0) {
                    break label794;
                  }
                  ((LinearLayout)localObject1).setPadding(k, 0, j, 0);
                }
                for (;;)
                {
                  localView.setVisibility(0);
                  break;
                  ((LinearLayout.LayoutParams)localObject2).height = 1;
                  break label725;
                  if (i1 == 1) {
                    ((LinearLayout)localObject1).setPadding(2, 0, 2, 0);
                  } else if (n == i1 - 1) {
                    ((LinearLayout)localObject1).setPadding(k, m, j, 0);
                  }
                }
              }
              if ("image".equals(str))
              {
                ((LinearLayout.LayoutParams)localObject2).gravity = 1;
                ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
              }
              else if ("progress".equals(str))
              {
                ((LinearLayout.LayoutParams)localObject2).height = aciy.a(4.0F, localResources);
                if ((i1 == 1) && (localView.getVisibility() == 8))
                {
                  ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
                  if (a(1)) {
                    ((LinearLayout)localObject1).setPadding(0, a(paramContext, 10), 0, 0);
                  }
                  if (a(2)) {
                    ((LinearLayout)localObject1).setPadding(0, 0, 0, a(paramContext, 10));
                  }
                }
              }
              else if ("more".equals(str))
              {
                localView.setVisibility(0);
              }
            }
          }
          ((LinearLayout)localObject1).removeAllViews();
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
          n = 0;
          if (n >= i1) {
            break label1181;
          }
          localObject2 = (awul)this.jdField_a_of_type_JavaUtilArrayList.get(n);
          ((awul)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          if ((localObject2 instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localObject2).a(a(), this.j);
          }
          localView = ((awul)localObject2).a(paramContext, null, paramBundle);
        } while (localView == null);
        label725:
        label997:
        int i2 = aciy.a(10.0F, localResources);
        int i3 = aciy.a(5.0F, localResources);
        paramView = new LinearLayout.LayoutParams(-1, -2);
        if (n > 0) {
          paramView.topMargin = i3;
        }
        String str = ((awul)localObject2).jdField_a_of_type_JavaLangString;
        if ("picture".equals(str))
        {
          localView.setId(-1);
          paramView.height = (BaseChatItemLayout.e - i2 - i2);
          paramView.topMargin = aciy.a(9.5F, localResources);
          paramView.bottomMargin = aciy.a(9.5F, localResources);
        }
        for (;;)
        {
          ((LinearLayout)localObject1).addView(localView, paramView);
          n += 1;
          break label997;
          break;
          if ("video".equals(str))
          {
            paramView.height = (BaseChatItemLayout.e - i2 - i2);
            paramView.topMargin = aciy.a(9.5F, localResources);
            paramView.bottomMargin = aciy.a(9.5F, localResources);
          }
          else if ("title".equals(str))
          {
            if (i != 0)
            {
              if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).c())) {
                ((TextView)localView).setTextSize(18.0F);
              }
              if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).e())) {
                ((TextView)localView).setTypeface(Typeface.DEFAULT, 1);
              }
            }
            paramView.topMargin = aciy.a(3.0F, localResources);
            paramView.bottomMargin = aciy.a(3.0F, localResources);
            if ((a(1)) && (n == 0)) {
              paramView.topMargin += aciy.a(14.0F, localResources);
            }
            localView.setId(-1);
          }
          else
          {
            if ("summary".equals(str))
            {
              if (i != 0)
              {
                str = ((awzf)localObject2).f();
                if ((str == null) || (!str.equals("1"))) {
                  break label1576;
                }
                if (TextUtils.isEmpty(((awzf)localObject2).c())) {
                  ((TextView)localView).setTextSize(12.0F);
                }
                if (TextUtils.isEmpty(((awzf)localObject2).d())) {
                  ((TextView)localView).setTextColor(Color.parseColor("#8e8e8e"));
                }
              }
              label1452:
              localObject2 = ((awzf)localObject2).f();
              if ((localObject2 != null) && (((String)localObject2).equals("1")))
              {
                paramView.topMargin = aciy.a(3.0F, localResources);
                paramView.bottomMargin = aciy.a(8.0F, localResources);
                label1501:
                if (this.i == 1)
                {
                  ((TextView)localView).setTextSize(12.0F);
                  ((TextView)localView).setTextColor(-4473925);
                }
                if ((a(2)) && (n == i1 - 1)) {
                  if (i == 0) {
                    break label1663;
                  }
                }
              }
              label1663:
              for (paramView.bottomMargin += aciy.a(12.0F, localResources);; paramView.bottomMargin += aciy.a(16.0F, localResources))
              {
                localView.setId(-1);
                break;
                if (TextUtils.isEmpty(((awzf)localObject2).c())) {
                  ((TextView)localView).setTextSize(16.0F);
                }
                if (TextUtils.isEmpty(((awzf)localObject2).d())) {
                  ((TextView)localView).setTextColor(-16777216);
                }
                ((TextView)localView).setLineSpacing(4.0F, 1.0F);
                break label1452;
                paramView.topMargin = aciy.a(5.0F, localResources);
                paramView.bottomMargin = aciy.a(5.0F, localResources);
                break label1501;
              }
            }
            if ("hr".equals(str))
            {
              if (((awwq)localObject2).a) {}
              for (paramView.height = 0;; paramView.height = 1)
              {
                if ((i != 0) && (n != 0)) {
                  paramView.topMargin += aciy.a(6.0F, localResources);
                }
                if (i == 0) {
                  break label1761;
                }
                ((LinearLayout)localObject1).setPadding(k, 0, j, 0);
                break;
              }
              label1761:
              if (i1 == 1) {
                ((LinearLayout)localObject1).setPadding(2, 0, 2, 0);
              } else if (n == i1 - 1) {
                ((LinearLayout)localObject1).setPadding(k, m, j, 0);
              }
            }
            else if ("image".equals(str))
            {
              paramView.gravity = 1;
              ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
            }
            else if ("progress".equals(str))
            {
              paramView.height = aciy.a(4.0F, localResources);
              if ((i1 == 1) && (localView.getVisibility() == 8))
              {
                ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
                if (a(1)) {
                  ((LinearLayout)localObject1).setPadding(0, a(paramContext, 10), 0, 0);
                }
                if (a(2)) {
                  ((LinearLayout)localObject1).setPadding(0, 0, 0, a(paramContext, 10));
                }
              }
            }
            else if ("more".equals(str))
            {
              paramView = new LinearLayout.LayoutParams(-1, aciy.a(36.0F, localResources));
            }
          }
        }
      }
    }
  }
  
  public String b()
  {
    return "Layout0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awyk
 * JD-Core Version:    0.7.0.1
 */