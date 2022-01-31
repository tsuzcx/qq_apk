import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;

public class azst
  extends azqk
{
  protected int b()
  {
    return 11;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject4 = paramContext.getResources();
    float f;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof azsu)))
    {
      localObject1 = (azsu)paramView.getTag();
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (azqj)((Iterator)localObject2).next();
        ((azqj)localObject3).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject4 = ((azqj)localObject3).jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject4))
        {
          localObject3 = (StructMsgItemTitle)localObject3;
          ((StructMsgItemTitle)localObject3).b("#ffffff");
          f = alnq.a() / 16.0F;
          if (f > 1.0F) {
            ((StructMsgItemTitle)localObject3).c("" + (int)(36 / f));
          }
          for (;;)
          {
            ((StructMsgItemTitle)localObject3).a(paramContext, ((azsu)localObject1).b, paramBundle);
            break;
            ((StructMsgItemTitle)localObject3).c(String.valueOf(36));
          }
        }
        if ("pavideo".equals(localObject4)) {
          ((azqj)localObject3).a(paramContext, ((azsu)localObject1).a, paramBundle);
        }
      }
      if ((localObject1 != null) && (((azsu)localObject1).b != null)) {
        ((TextView)((azsu)localObject1).b).setMaxLines(2);
      }
      return paramView;
    }
    Object localObject2 = new RelativeLayout(paramContext);
    int i = (int)((BaseChatItemLayout.a - aekt.a(46.0F, (Resources)localObject4)) / 1.8D) + aekt.a(30.0F, (Resources)localObject4);
    ((RelativeLayout)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, i));
    int j = aekt.a(15.0F, (Resources)localObject4);
    ((RelativeLayout)localObject2).setPadding(j, j, j, j);
    Object localObject3 = new azsu();
    Object localObject1 = null;
    paramView = null;
    Object localObject5 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    azqj localazqj;
    String str;
    if (((Iterator)localObject5).hasNext())
    {
      localazqj = (azqj)((Iterator)localObject5).next();
      localazqj.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      str = localazqj.jdField_a_of_type_JavaLangString;
      if ("title".equals(str))
      {
        localObject1 = (StructMsgItemTitle)localazqj;
        ((StructMsgItemTitle)localObject1).b("#ffffff");
        f = alnq.a() / 16.0F;
        if (f > 1.0F)
        {
          ((StructMsgItemTitle)localObject1).c("" + (int)(36 / f));
          label439:
          localObject1 = ((StructMsgItemTitle)localObject1).a(paramContext, null, paramBundle);
          ((View)localObject1).setId(1001);
        }
      }
    }
    for (;;)
    {
      break;
      ((StructMsgItemTitle)localObject1).c(String.valueOf(36));
      break label439;
      if ("pavideo".equals(str))
      {
        paramView = localazqj.a(paramContext, null, paramBundle);
        paramView.setId(1003);
        continue;
        if (paramView != null) {
          ((RelativeLayout)localObject2).addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
        }
        paramBundle = new View(paramContext);
        i = (int)(i * 0.32D);
        paramBundle.setBackgroundResource(2130841429);
        localObject5 = new RelativeLayout.LayoutParams(-1, i);
        ((RelativeLayout.LayoutParams)localObject5).addRule(12, -1);
        ((RelativeLayout)localObject2).addView(paramBundle, (ViewGroup.LayoutParams)localObject5);
        if (localObject1 != null)
        {
          paramBundle = new RelativeLayout.LayoutParams(-1, -2);
          paramBundle.addRule(12, -1);
          paramBundle.bottomMargin = aekt.a(11.5F, (Resources)localObject4);
          paramBundle.leftMargin = aekt.a(20.0F, (Resources)localObject4);
          paramBundle.rightMargin = aekt.a(20.0F, (Resources)localObject4);
          ((RelativeLayout)localObject2).addView((View)localObject1, paramBundle);
        }
        paramBundle = new RelativeLayout.LayoutParams(aekt.a(52.5F, (Resources)localObject4), aekt.a(52.5F, (Resources)localObject4));
        paramBundle.addRule(15, -1);
        paramContext = new ImageView(paramContext);
        paramContext.setImageResource(2130841361);
        paramContext.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        paramBundle.addRule(14, -1);
        ((RelativeLayout)localObject2).addView(paramContext, paramBundle);
        if (paramView != null) {
          ((azsu)localObject3).a = paramView;
        }
        if (localObject1 != null)
        {
          ((azsu)localObject3).b = ((View)localObject1);
          ((TextView)((azsu)localObject3).b).setMaxLines(1);
        }
        ((RelativeLayout)localObject2).setTag(localObject3);
        return localObject2;
      }
    }
  }
  
  public String b()
  {
    return "Layout11";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azst
 * JD-Core Version:    0.7.0.1
 */