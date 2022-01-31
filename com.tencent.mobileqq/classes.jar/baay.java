import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuImageLayout;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuLayout;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.widget.BubblePopupWindow;

public class baay
{
  public static boolean a;
  
  public static View a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, bakh parambakh, View.OnClickListener paramOnClickListener)
  {
    return a(paramBubblePopupWindow, paramContext, parambakh, paramOnClickListener, false);
  }
  
  public static View a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, bakh parambakh, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    int i;
    int n;
    int j;
    label21:
    int k;
    if (paramBoolean)
    {
      i = 8;
      int m = 1;
      n = parambakh.a();
      j = 0;
      k = m;
      if (j < n)
      {
        if (parambakh.a(j).b() != 0) {
          break label182;
        }
        k = 0;
      }
      if (!paramBoolean) {
        break label191;
      }
      if (QQCustomMenuNoIconLayout.jdField_a_of_type_Int == 0)
      {
        localObject = paramContext.getResources();
        QQCustomMenuNoIconLayout.jdField_a_of_type_Int = ((Resources)localObject).getDisplayMetrics().widthPixels;
        QQCustomMenuNoIconLayout.jdField_a_of_type_Float = ((Resources)localObject).getDisplayMetrics().density;
        QQCustomMenuNoIconLayout.c = aciy.a(QQCustomMenuNoIconLayout.c, (Resources)localObject);
        QQCustomMenuNoIconLayout.f = aciy.a(QQCustomMenuNoIconLayout.f, (Resources)localObject);
      }
    }
    for (;;)
    {
      if ((paramBoolean) || (k == 0) || (QQCustomMenuImageLayout.jdField_a_of_type_Int < 480)) {
        break label281;
      }
      paramContext = new QQCustomMenuImageLayout(paramContext);
      paramContext.setGravity(17);
      paramContext.setPadding(QQCustomMenuImageLayout.c, 0, 0, 0);
      paramContext.setPopup(paramBubblePopupWindow);
      paramContext.setMenu(parambakh);
      paramContext.setMenuIconClickListener(paramOnClickListener);
      paramContext.a();
      return paramContext;
      i = 6;
      break;
      label182:
      j += 1;
      break label21;
      label191:
      if (QQCustomMenuImageLayout.jdField_a_of_type_Int == 0)
      {
        localObject = paramContext.getResources();
        QQCustomMenuImageLayout.jdField_a_of_type_Int = ((Resources)localObject).getDisplayMetrics().widthPixels;
        QQCustomMenuImageLayout.jdField_a_of_type_Float = ((Resources)localObject).getDisplayMetrics().density;
        QQCustomMenuImageLayout.c = aciy.a(QQCustomMenuImageLayout.c, (Resources)localObject);
        QQCustomMenuImageLayout.d = aciy.a(QQCustomMenuImageLayout.d, (Resources)localObject);
        QQCustomMenuImageLayout.e = aciy.a(QQCustomMenuImageLayout.e, (Resources)localObject);
        QQCustomMenuImageLayout.f = (QQCustomMenuImageLayout.jdField_a_of_type_Int - aciy.a(36.0F, (Resources)localObject)) / i;
      }
    }
    label281:
    if (paramBoolean)
    {
      paramContext = new QQCustomMenuNoIconLayout(paramContext);
      paramContext.setGravity(17);
      paramContext.setPadding(0, 0, 0, 0);
      paramContext.setPopup(paramBubblePopupWindow);
      paramContext.setMenu(parambakh);
      paramContext.setMenuIconClickListener(paramOnClickListener);
      paramContext.a();
      return paramContext;
    }
    Object localObject = new QQCustomMenuLayout(paramContext);
    ((QQCustomMenuLayout)localObject).setGravity(17);
    a(paramBubblePopupWindow, paramContext, parambakh, paramOnClickListener, (QQCustomMenuLayout)localObject, n);
    return localObject;
  }
  
  private static QQCustomMenuLayout a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, bakh parambakh, View.OnClickListener paramOnClickListener, QQCustomMenuLayout paramQQCustomMenuLayout, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      Object localObject = parambakh.a(i);
      baaz localbaaz = new baaz(paramContext, paramBubblePopupWindow);
      localbaaz.setText(((bakj)localObject).a());
      localbaaz.setTextSize(13.0F);
      Resources localResources = paramContext.getResources();
      TextPaint localTextPaint = new TextPaint(1);
      localTextPaint.density = localResources.getDisplayMetrics().density;
      int k = (int)Layout.getDesiredWidth(((bakj)localObject).a(), localTextPaint);
      int j = 5;
      if (localTextPaint.density >= 2.0F) {
        j = 10;
      }
      j = (int)(j * localTextPaint.density);
      localbaaz.setMinimumWidth(j * 2 + k);
      localbaaz.setPadding(j, 0, j, 0);
      localbaaz.setContentDescription(((bakj)localObject).a());
      localbaaz.setId(((bakj)localObject).a());
      localbaaz.setTextColor(-1);
      localbaaz.setBackgroundDrawable(null);
      localbaaz.setIncludeFontPadding(true);
      localbaaz.setOnClickListener(paramOnClickListener);
      localbaaz.setGravity(17);
      paramQQCustomMenuLayout.addView(localbaaz, new LinearLayout.LayoutParams(-2, -2, 1.0F));
      if (i != paramInt - 1)
      {
        localObject = new ImageView(paramContext);
        ((ImageView)localObject).setBackgroundResource(2130838585);
        paramQQCustomMenuLayout.addView((View)localObject, -2, -2);
      }
      i += 1;
    }
    paramQQCustomMenuLayout.a();
    return paramQQCustomMenuLayout;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, int paramInt3, bakh parambakh, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambakh, paramOnClickListener));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(false);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.c(1);
    localBubblePopupWindow.b(2);
    localBubblePopupWindow.e(false);
    localBubblePopupWindow.g(paramInt3);
    localBubblePopupWindow.a(0);
    localBubblePopupWindow.b(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, bakh parambakh)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambakh, null));
    localBubblePopupWindow.a(null);
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(false);
    localBubblePopupWindow.a(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, bakh parambakh, View.OnClickListener paramOnClickListener)
  {
    return a(paramView, paramInt1, paramInt2, parambakh, paramOnClickListener, false);
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, bakh parambakh, View.OnClickListener paramOnClickListener, behy parambehy)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambakh, paramOnClickListener));
    localBubblePopupWindow.a(parambehy);
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.a(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, bakh parambakh, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambakh, paramOnClickListener, paramBoolean));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.c(1);
    localBubblePopupWindow.b(2);
    localBubblePopupWindow.a(paramView, paramInt1, paramInt2, paramBoolean);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, bakh parambakh, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambakh, paramOnClickListener));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.b(paramView);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, bakh parambakh, View.OnClickListener paramOnClickListener, behy parambehy)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambakh, paramOnClickListener));
    localBubblePopupWindow.a(parambehy);
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.b(paramView);
    return localBubblePopupWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baay
 * JD-Core Version:    0.7.0.1
 */