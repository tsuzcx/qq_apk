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

public class bbcc
{
  public static boolean a;
  
  public static View a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, bblr parambblr, View.OnClickListener paramOnClickListener)
  {
    return a(paramBubblePopupWindow, paramContext, parambblr, paramOnClickListener, false);
  }
  
  public static View a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, bblr parambblr, View.OnClickListener paramOnClickListener, boolean paramBoolean)
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
      n = parambblr.a();
      j = 0;
      k = m;
      if (j < n)
      {
        if (parambblr.a(j).b() != 0) {
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
        QQCustomMenuNoIconLayout.c = actn.a(QQCustomMenuNoIconLayout.c, (Resources)localObject);
        QQCustomMenuNoIconLayout.f = actn.a(QQCustomMenuNoIconLayout.f, (Resources)localObject);
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
      paramContext.setMenu(parambblr);
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
        QQCustomMenuImageLayout.c = actn.a(QQCustomMenuImageLayout.c, (Resources)localObject);
        QQCustomMenuImageLayout.d = actn.a(QQCustomMenuImageLayout.d, (Resources)localObject);
        QQCustomMenuImageLayout.e = actn.a(QQCustomMenuImageLayout.e, (Resources)localObject);
        QQCustomMenuImageLayout.f = (QQCustomMenuImageLayout.jdField_a_of_type_Int - actn.a(36.0F, (Resources)localObject)) / i;
      }
    }
    label281:
    if (paramBoolean)
    {
      paramContext = new QQCustomMenuNoIconLayout(paramContext);
      paramContext.setGravity(17);
      paramContext.setPadding(0, 0, 0, 0);
      paramContext.setPopup(paramBubblePopupWindow);
      paramContext.setMenu(parambblr);
      paramContext.setMenuIconClickListener(paramOnClickListener);
      paramContext.a();
      return paramContext;
    }
    Object localObject = new QQCustomMenuLayout(paramContext);
    ((QQCustomMenuLayout)localObject).setGravity(17);
    a(paramBubblePopupWindow, paramContext, parambblr, paramOnClickListener, (QQCustomMenuLayout)localObject, n);
    return localObject;
  }
  
  private static QQCustomMenuLayout a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, bblr parambblr, View.OnClickListener paramOnClickListener, QQCustomMenuLayout paramQQCustomMenuLayout, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      Object localObject = parambblr.a(i);
      bbcd localbbcd = new bbcd(paramContext, paramBubblePopupWindow);
      localbbcd.setText(((bblt)localObject).a());
      localbbcd.setTextSize(13.0F);
      Resources localResources = paramContext.getResources();
      TextPaint localTextPaint = new TextPaint(1);
      localTextPaint.density = localResources.getDisplayMetrics().density;
      int k = (int)Layout.getDesiredWidth(((bblt)localObject).a(), localTextPaint);
      int j = 5;
      if (localTextPaint.density >= 2.0F) {
        j = 10;
      }
      j = (int)(j * localTextPaint.density);
      localbbcd.setMinimumWidth(j * 2 + k);
      localbbcd.setPadding(j, 0, j, 0);
      localbbcd.setContentDescription(((bblt)localObject).a());
      localbbcd.setId(((bblt)localObject).a());
      localbbcd.setTextColor(-1);
      localbbcd.setBackgroundDrawable(null);
      localbbcd.setIncludeFontPadding(true);
      localbbcd.setOnClickListener(paramOnClickListener);
      localbbcd.setGravity(17);
      paramQQCustomMenuLayout.addView(localbbcd, new LinearLayout.LayoutParams(-2, -2, 1.0F));
      if (i != paramInt - 1)
      {
        localObject = new ImageView(paramContext);
        ((ImageView)localObject).setBackgroundResource(2130838592);
        paramQQCustomMenuLayout.addView((View)localObject, -2, -2);
      }
      i += 1;
    }
    paramQQCustomMenuLayout.a();
    return paramQQCustomMenuLayout;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, int paramInt3, bblr parambblr, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambblr, paramOnClickListener));
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
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, bblr parambblr)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambblr, null));
    localBubblePopupWindow.a(null);
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(false);
    localBubblePopupWindow.a(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, bblr parambblr, View.OnClickListener paramOnClickListener)
  {
    return a(paramView, paramInt1, paramInt2, parambblr, paramOnClickListener, false);
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, bblr parambblr, View.OnClickListener paramOnClickListener, bfps parambfps)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambblr, paramOnClickListener));
    localBubblePopupWindow.a(parambfps);
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.a(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, bblr parambblr, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambblr, paramOnClickListener, paramBoolean));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.c(1);
    localBubblePopupWindow.b(2);
    localBubblePopupWindow.a(paramView, paramInt1, paramInt2, paramBoolean);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, bblr parambblr, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambblr, paramOnClickListener));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.b(paramView);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, bblr parambblr, View.OnClickListener paramOnClickListener, bfps parambfps)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambblr, paramOnClickListener));
    localBubblePopupWindow.a(parambfps);
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.b(paramView);
    return localBubblePopupWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcc
 * JD-Core Version:    0.7.0.1
 */