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

public class azsr
  extends azqk
{
  private void a(Context paramContext, View paramView, azss paramazss, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramContext = paramContext.getResources();
      if (paramazss.a != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        paramazss.a.setId(2131362884);
        paramBundle.addRule(9, -1);
        ((RelativeLayout)paramView).addView(paramazss.a);
      }
      if (paramazss.b != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -2);
        paramBundle.addRule(9);
        if (alnq.a() <= 16.0F) {
          break label146;
        }
      }
    }
    label146:
    for (int i = aekt.a(5.0F, paramContext);; i = aekt.a(10.0F, paramContext))
    {
      paramBundle.setMargins(aekt.a(20.0F, paramContext), 0, aekt.a(20.0F, paramContext), i);
      paramBundle.addRule(12);
      ((RelativeLayout)paramView).addView(paramazss.b, paramBundle);
      return;
    }
  }
  
  protected int b()
  {
    return 10;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    azss localazss;
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof azss)))
    {
      localazss = (azss)paramView.getTag();
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      azqj localazqj;
      Object localObject2;
      String str;
      int j;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        localazqj = (azqj)((Iterator)localObject1).next();
        localazqj.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject2 = localazqj.jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject2))
        {
          localObject2 = (StructMsgItemTitle)localazqj;
          str = ((StructMsgItemTitle)localObject2).c();
          j = ((StructMsgItemTitle)localObject2).f();
          i = j;
          if (TextUtils.isEmpty(str)) {}
        }
      }
      try
      {
        i = Integer.parseInt(str);
        f = alnq.a() / 16.0F;
        if (i * f > 36.0F) {
          ((StructMsgItemTitle)localObject2).c("" + (int)(36.0F / f));
        }
        for (;;)
        {
          localazss.b = localazqj.a(paramContext, localazss.b, paramBundle);
          break;
          ((StructMsgItemTitle)localObject2).c(str);
        }
        if (!"paaudio".equals(localObject2)) {
          continue;
        }
        localazss.a = localazqj.a(paramContext, localazss.a, paramBundle);
        continue;
        paramContext = localazss;
        if (paramContext.b != null) {
          ((TextView)paramContext.b).setMaxLines(1);
        }
        paramView.setTag(paramContext);
        return paramView;
        localObject1 = paramContext.getResources();
        localazss = new azss();
        paramView = new RelativeLayout(paramContext);
        i = aekt.a(15.0F, (Resources)localObject1);
        paramView.setPadding(i, i, i, i);
        i = (int)((BaseChatItemLayout.a - aekt.a(46.0F, (Resources)localObject1)) * 26.0F / 63.0F);
        paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, aekt.a(30.0F, (Resources)localObject1) + i));
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localazqj = (azqj)((Iterator)localObject1).next();
          localazqj.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          localObject2 = localazqj.jdField_a_of_type_JavaLangString;
          if ("title".equals(localObject2))
          {
            localObject2 = (StructMsgItemTitle)localazqj;
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
            float f = alnq.a() / 16.0F;
            if (i * f > 36.0F) {
              ((StructMsgItemTitle)localObject2).c("" + (int)(36.0F / f));
            }
            for (;;)
            {
              localazss.b = localazqj.a(paramContext, localazss.b, paramBundle);
              break;
              ((StructMsgItemTitle)localObject2).c(str);
            }
            if ("paaudio".equals(localObject2))
            {
              localazss.a = localazqj.a(paramContext, localazss.a, paramBundle);
              continue;
              a(paramContext, paramView, localazss, paramBundle);
              paramContext = localazss;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azsr
 * JD-Core Version:    0.7.0.1
 */