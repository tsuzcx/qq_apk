import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Collection;

public class axwu
  extends axuo
{
  public axwu() {}
  
  public axwu(Collection<axun> paramCollection)
  {
    super(paramCollection);
  }
  
  protected int a(Resources paramResources, int paramInt, axun paramaxun)
  {
    return actn.a(5.0F, paramResources);
  }
  
  protected ArrayList<axun> a(ArrayList<axun> paramArrayList)
  {
    return paramArrayList;
  }
  
  protected int b()
  {
    return 1;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    int n = localResources.getDimensionPixelSize(2131298789);
    int i1 = localResources.getDimensionPixelSize(2131298790);
    int i = actn.a(5.0F, localResources);
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID == 35)) {}
    for (int k = 6;; k = 10)
    {
      Object localObject1;
      Object localObject2;
      View localView;
      if ((paramView != null) && ((paramView instanceof LinearLayout)))
      {
        paramView = (LinearLayout)paramView;
        if (!TextUtils.isEmpty(this.c)) {
          paramView.setBackgroundResource(2130839169);
        }
        d(paramView);
        localObject1 = a(this.jdField_a_of_type_JavaUtilArrayList);
        if (paramView.getChildCount() != ((ArrayList)localObject1).size()) {
          break label529;
        }
        k = ((ArrayList)localObject1).size();
        j = 0;
        if (j < k)
        {
          localObject2 = (axun)((ArrayList)localObject1).get(j);
          ((axun)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          if ((localObject2 instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localObject2).a(a(), this.l);
          }
          localView = ((axun)localObject2).a(paramContext, paramView.getChildAt(j), paramBundle);
          if (localView != null) {}
        }
        else
        {
          label197:
          return paramView;
        }
      }
      else
      {
        paramView = new LinearLayout(paramContext);
        paramView.setOrientation(1);
        localObject1 = new LinearLayout.LayoutParams(-1, -2);
        if (!a(1)) {
          break label853;
        }
      }
      label529:
      label543:
      label705:
      label853:
      for (int j = a(paramContext, k) + i;; j = i)
      {
        int m = i;
        if (a(2)) {
          m = i + a(paramContext, k);
        }
        paramView.setPadding(n, j, i1, m);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        i = j;
        break;
        m = actn.a(10.0F, localResources);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (j > 0) {
          localLayoutParams.topMargin = a(localResources, j, (axun)localObject2);
        }
        localObject2 = ((axun)localObject2).jdField_a_of_type_JavaLangString;
        if ("picture".equals(localObject2))
        {
          localView.setId(-1);
          localLayoutParams.height = (BaseChatItemLayout.e - m - m);
        }
        for (;;)
        {
          j += 1;
          break;
          if ("video".equals(localObject2))
          {
            localLayoutParams.height = (BaseChatItemLayout.e - m - m);
          }
          else if ("title".equals(localObject2))
          {
            localView.setId(-1);
          }
          else if ("summary".equals(localObject2))
          {
            localView.setId(-1);
          }
          else if ("hr".equals(localObject2))
          {
            localLayoutParams.height = 1;
            if (k == 1) {
              paramView.setPadding(0, 0, 0, 0);
            } else if (j == k - 1) {
              paramView.setPadding(n, i, i1, 0);
            }
          }
          else if ("image".equals(localObject2))
          {
            localLayoutParams.gravity = 1;
            paramView.setPadding(0, 0, 0, 0);
          }
        }
        paramView.removeAllViews();
        k = ((ArrayList)localObject1).size();
        j = 0;
        if (j < k)
        {
          localObject2 = (axun)((ArrayList)localObject1).get(j);
          ((axun)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          if ((localObject2 instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localObject2).a(a(), this.l);
          }
          localView = ((axun)localObject2).a(paramContext, null, paramBundle);
          if (localView == null) {
            break label197;
          }
          m = actn.a(10.0F, localResources);
          localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          if (j > 0) {
            localLayoutParams.topMargin = a(localResources, j, (axun)localObject2);
          }
          localObject2 = ((axun)localObject2).jdField_a_of_type_JavaLangString;
          if (!"picture".equals(localObject2)) {
            break label705;
          }
          localView.setId(-1);
          localLayoutParams.height = (BaseChatItemLayout.e - m - m);
        }
        for (;;)
        {
          paramView.addView(localView, localLayoutParams);
          j += 1;
          break label543;
          break;
          if ("video".equals(localObject2))
          {
            localLayoutParams.height = (BaseChatItemLayout.e - m - m);
          }
          else if ("title".equals(localObject2))
          {
            localView.setId(-1);
          }
          else if ("summary".equals(localObject2))
          {
            localView.setId(-1);
          }
          else if ("hr".equals(localObject2))
          {
            localLayoutParams.height = 1;
            if (k == 1) {
              paramView.setPadding(0, 0, 0, 0);
            } else if (j == k - 1) {
              paramView.setPadding(n, i, i1, 0);
            }
          }
          else if ("image".equals(localObject2))
          {
            localLayoutParams.gravity = 1;
            paramView.setPadding(0, 0, 0, 0);
          }
        }
      }
    }
  }
  
  public String b()
  {
    return "Layout1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwu
 * JD-Core Version:    0.7.0.1
 */