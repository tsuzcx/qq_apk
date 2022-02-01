import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;

public class bdqc
  extends bdnv
{
  private void a(Context paramContext, View paramView, bdqd parambdqd, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramContext = paramContext.getResources();
      if (parambdqd.a != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        parambdqd.a.setId(2131363050);
        paramBundle.addRule(9, -1);
        ((RelativeLayout)paramView).addView(parambdqd.a);
      }
      if (parambdqd.b != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -2);
        paramBundle.addRule(9);
        if (FontSettingManager.getFontLevel() <= 16.0F) {
          break label146;
        }
      }
    }
    label146:
    for (int i = AIOUtils.dp2px(5.0F, paramContext);; i = AIOUtils.dp2px(10.0F, paramContext))
    {
      paramBundle.setMargins(AIOUtils.dp2px(20.0F, paramContext), 0, AIOUtils.dp2px(20.0F, paramContext), i);
      paramBundle.addRule(12);
      ((RelativeLayout)paramView).addView(parambdqd.b, paramBundle);
      return;
    }
  }
  
  protected int b()
  {
    return 10;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    bdqd localbdqd;
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof bdqd)))
    {
      localbdqd = (bdqd)paramView.getTag();
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      bdnu localbdnu;
      Object localObject2;
      String str;
      int j;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        localbdnu = (bdnu)((Iterator)localObject1).next();
        localbdnu.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject2 = localbdnu.jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject2))
        {
          localObject2 = (StructMsgItemTitle)localbdnu;
          str = ((StructMsgItemTitle)localObject2).c();
          j = ((StructMsgItemTitle)localObject2).f();
          i = j;
          if (TextUtils.isEmpty(str)) {}
        }
      }
      try
      {
        i = Integer.parseInt(str);
        f = FontSettingManager.getFontLevel() / 16.0F;
        if (i * f > 36.0F) {
          ((StructMsgItemTitle)localObject2).c("" + (int)(36.0F / f));
        }
        for (;;)
        {
          localbdqd.b = localbdnu.a(paramContext, localbdqd.b, paramBundle);
          break;
          ((StructMsgItemTitle)localObject2).c(str);
        }
        if (!"paaudio".equals(localObject2)) {
          continue;
        }
        localbdqd.a = localbdnu.a(paramContext, localbdqd.a, paramBundle);
        continue;
        paramContext = localbdqd;
        if (paramContext.b != null) {
          ((TextView)paramContext.b).setMaxLines(1);
        }
        paramView.setTag(paramContext);
        return paramView;
        localObject1 = paramContext.getResources();
        localbdqd = new bdqd();
        paramView = new RelativeLayout(paramContext);
        i = AIOUtils.dp2px(15.0F, (Resources)localObject1);
        paramView.setPadding(i, i, i, i);
        i = (int)((BaseChatItemLayout.b - AIOUtils.dp2px(46.0F, (Resources)localObject1)) * 26.0F / 63.0F);
        paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(30.0F, (Resources)localObject1) + i));
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localbdnu = (bdnu)((Iterator)localObject1).next();
          localbdnu.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          localObject2 = localbdnu.jdField_a_of_type_JavaLangString;
          if ("title".equals(localObject2))
          {
            localObject2 = (StructMsgItemTitle)localbdnu;
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
            float f = FontSettingManager.getFontLevel() / 16.0F;
            if (i * f > 36.0F) {
              ((StructMsgItemTitle)localObject2).c("" + (int)(36.0F / f));
            }
            for (;;)
            {
              localbdqd.b = localbdnu.a(paramContext, localbdqd.b, paramBundle);
              break;
              ((StructMsgItemTitle)localObject2).c(str);
            }
            if ("paaudio".equals(localObject2))
            {
              localbdqd.a = localbdnu.a(paramContext, localbdqd.a, paramBundle);
              continue;
              a(paramContext, paramView, localbdqd, paramBundle);
              paramContext = localbdqd;
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
 * Qualified Name:     bdqc
 * JD-Core Version:    0.7.0.1
 */