import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;

public class bdrj
  extends bdom
{
  private LinearLayout a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i = agej.a(12.0F, paramContext.getResources());
    localLinearLayout.setPadding(i, i, i, i);
    localLinearLayout.setLayoutParams(localLayoutParams);
    return localLinearLayout;
  }
  
  protected int b()
  {
    return 22;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Iterator localIterator;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return paramView;
      }
      Object localObject1 = (bdol)localIterator.next();
      Object localObject2 = ((bdol)localObject1).jdField_a_of_type_JavaLangString;
      ((bdol)localObject1).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ("title".equals(localObject2))
      {
        localObject2 = (StructMsgItemTitle)localObject1;
        ((StructMsgItemTitle)localObject2).a(a(), this.p);
        localObject1 = (TextView)((bdol)localObject1).a(paramContext, null, paramBundle);
        ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject1).setMaxLines(2);
        if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).c())) {
          ((TextView)localObject1).setTextSize(18.0F);
        }
        if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).d())) {
          ((TextView)localObject1).setTextColor(Color.parseColor("#000000"));
        }
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = agej.a(12.0F, paramContext.getResources());
        paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        continue;
        paramView = a(paramContext);
        break;
      }
      if ("picture".equals(localObject2))
      {
        localObject1 = ((bdol)localObject1).a(paramContext, null, paramBundle);
        int i = agej.a(50.0F, paramContext.getResources());
        paramView.addView((View)localObject1, new LinearLayout.LayoutParams(i, i));
      }
    }
    return paramView;
  }
  
  public String b()
  {
    return "layout22";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrj
 * JD-Core Version:    0.7.0.1
 */