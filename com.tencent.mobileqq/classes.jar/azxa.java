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

public class azxa
  extends azut
{
  private void a(Context paramContext, View paramView, azxb paramazxb, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramContext = paramContext.getResources();
      if (paramazxb.a != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        paramazxb.a.setId(2131362884);
        paramBundle.addRule(9, -1);
        ((RelativeLayout)paramView).addView(paramazxb.a);
      }
      if (paramazxb.b != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -2);
        paramBundle.addRule(9);
        if (alsf.a() <= 16.0F) {
          break label146;
        }
      }
    }
    label146:
    for (int i = aepi.a(5.0F, paramContext);; i = aepi.a(10.0F, paramContext))
    {
      paramBundle.setMargins(aepi.a(20.0F, paramContext), 0, aepi.a(20.0F, paramContext), i);
      paramBundle.addRule(12);
      ((RelativeLayout)paramView).addView(paramazxb.b, paramBundle);
      return;
    }
  }
  
  protected int b()
  {
    return 10;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    azxb localazxb;
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof azxb)))
    {
      localazxb = (azxb)paramView.getTag();
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      azus localazus;
      Object localObject2;
      String str;
      int j;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        localazus = (azus)((Iterator)localObject1).next();
        localazus.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject2 = localazus.jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject2))
        {
          localObject2 = (StructMsgItemTitle)localazus;
          str = ((StructMsgItemTitle)localObject2).c();
          j = ((StructMsgItemTitle)localObject2).f();
          i = j;
          if (TextUtils.isEmpty(str)) {}
        }
      }
      try
      {
        i = Integer.parseInt(str);
        f = alsf.a() / 16.0F;
        if (i * f > 36.0F) {
          ((StructMsgItemTitle)localObject2).c("" + (int)(36.0F / f));
        }
        for (;;)
        {
          localazxb.b = localazus.a(paramContext, localazxb.b, paramBundle);
          break;
          ((StructMsgItemTitle)localObject2).c(str);
        }
        if (!"paaudio".equals(localObject2)) {
          continue;
        }
        localazxb.a = localazus.a(paramContext, localazxb.a, paramBundle);
        continue;
        paramContext = localazxb;
        if (paramContext.b != null) {
          ((TextView)paramContext.b).setMaxLines(1);
        }
        paramView.setTag(paramContext);
        return paramView;
        localObject1 = paramContext.getResources();
        localazxb = new azxb();
        paramView = new RelativeLayout(paramContext);
        i = aepi.a(15.0F, (Resources)localObject1);
        paramView.setPadding(i, i, i, i);
        i = (int)((BaseChatItemLayout.a - aepi.a(46.0F, (Resources)localObject1)) * 26.0F / 63.0F);
        paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, aepi.a(30.0F, (Resources)localObject1) + i));
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localazus = (azus)((Iterator)localObject1).next();
          localazus.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          localObject2 = localazus.jdField_a_of_type_JavaLangString;
          if ("title".equals(localObject2))
          {
            localObject2 = (StructMsgItemTitle)localazus;
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
            float f = alsf.a() / 16.0F;
            if (i * f > 36.0F) {
              ((StructMsgItemTitle)localObject2).c("" + (int)(36.0F / f));
            }
            for (;;)
            {
              localazxb.b = localazus.a(paramContext, localazxb.b, paramBundle);
              break;
              ((StructMsgItemTitle)localObject2).c(str);
            }
            if ("paaudio".equals(localObject2))
            {
              localazxb.a = localazus.a(paramContext, localazxb.a, paramBundle);
              continue;
              a(paramContext, paramView, localazxb, paramBundle);
              paramContext = localazxb;
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
 * Qualified Name:     azxa
 * JD-Core Version:    0.7.0.1
 */