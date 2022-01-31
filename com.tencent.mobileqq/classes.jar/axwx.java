import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;

public class axwx
  extends axuq
{
  private void a(Context paramContext, View paramView, axwy paramaxwy, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramContext = paramContext.getResources();
      if (paramaxwy.a != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        paramaxwy.a.setId(2131362849);
        paramBundle.addRule(9, -1);
        ((RelativeLayout)paramView).addView(paramaxwy.a);
      }
      if (paramaxwy.b != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -2);
        paramBundle.addRule(9);
        if (ajwc.a() <= 16.0F) {
          break label146;
        }
      }
    }
    label146:
    for (int i = actj.a(5.0F, paramContext);; i = actj.a(10.0F, paramContext))
    {
      paramBundle.setMargins(actj.a(20.0F, paramContext), 0, actj.a(20.0F, paramContext), i);
      paramBundle.addRule(12);
      ((RelativeLayout)paramView).addView(paramaxwy.b, paramBundle);
      return;
    }
  }
  
  protected int b()
  {
    return 10;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    axwy localaxwy;
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof axwy)))
    {
      localaxwy = (axwy)paramView.getTag();
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      axup localaxup;
      Object localObject2;
      String str;
      int j;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        localaxup = (axup)((Iterator)localObject1).next();
        localaxup.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject2 = localaxup.jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject2))
        {
          localObject2 = (StructMsgItemTitle)localaxup;
          str = ((StructMsgItemTitle)localObject2).c();
          j = ((StructMsgItemTitle)localObject2).f();
          i = j;
          if (TextUtils.isEmpty(str)) {}
        }
      }
      try
      {
        i = Integer.parseInt(str);
        f = ajwc.a() / 16.0F;
        if (i * f > 36.0F) {
          ((StructMsgItemTitle)localObject2).c("" + (int)(36.0F / f));
        }
        for (;;)
        {
          localaxwy.b = localaxup.a(paramContext, localaxwy.b, paramBundle);
          break;
          ((StructMsgItemTitle)localObject2).c(str);
        }
        if (!"paaudio".equals(localObject2)) {
          continue;
        }
        localaxwy.a = localaxup.a(paramContext, localaxwy.a, paramBundle);
        continue;
        paramContext = localaxwy;
        if (paramContext.b != null) {
          ((TextView)paramContext.b).setMaxLines(1);
        }
        paramView.setTag(paramContext);
        return paramView;
        localObject1 = paramContext.getResources();
        localaxwy = new axwy();
        paramView = new RelativeLayout(paramContext);
        i = actj.a(15.0F, (Resources)localObject1);
        paramView.setPadding(i, i, i, i);
        i = (int)((BaseChatItemLayout.a - actj.a(46.0F, (Resources)localObject1)) * 26.0F / 63.0F);
        paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, actj.a(30.0F, (Resources)localObject1) + i));
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localaxup = (axup)((Iterator)localObject1).next();
          localaxup.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          localObject2 = localaxup.jdField_a_of_type_JavaLangString;
          if ("title".equals(localObject2))
          {
            localObject2 = (StructMsgItemTitle)localaxup;
            str = ((StructMsgItemTitle)localObject2).c();
            j = ((StructMsgItemTitle)localObject2).f();
            i = j;
            if (TextUtils.isEmpty(str)) {}
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(str);
            float f = ajwc.a() / 16.0F;
            if (i * f > 36.0F) {
              ((StructMsgItemTitle)localObject2).c("" + (int)(36.0F / f));
            }
            for (;;)
            {
              localaxwy.b = localaxup.a(paramContext, localaxwy.b, paramBundle);
              break;
              ((StructMsgItemTitle)localObject2).c(str);
            }
            if ("paaudio".equals(localObject2))
            {
              localaxwy.a = localaxup.a(paramContext, localaxwy.a, paramBundle);
              continue;
              a(paramContext, paramView, localaxwy, paramBundle);
              paramContext = localaxwy;
            }
          }
          localException1 = localException1;
          i = j;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            i = j;
          }
        }
      }
    }
  }
  
  public String b()
  {
    return "Layout10";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwx
 * JD-Core Version:    0.7.0.1
 */