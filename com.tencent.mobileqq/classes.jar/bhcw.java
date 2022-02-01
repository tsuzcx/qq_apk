import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.widget.BubblePopupWindow;

public class bhcw
{
  public static boolean a;
  
  public static QQCustomMenuNoIconLayout a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, bhjq parambhjq, View.OnClickListener paramOnClickListener)
  {
    bhjt.a(parambhjq);
    paramContext = new QQCustomMenuNoIconLayout(paramContext);
    paramContext.setGravity(17);
    paramContext.setPadding(0, 0, 0, 0);
    paramContext.setPopupWindow(paramBubblePopupWindow);
    paramContext.setMenu(parambhjq);
    paramContext.setMenuIconClickListener(paramOnClickListener);
    paramContext.a();
    return paramContext;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, int paramInt3, bhjq parambhjq, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambhjq, paramOnClickListener));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(false);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.c(1);
    localBubblePopupWindow.b(2);
    localBubblePopupWindow.e(false);
    localBubblePopupWindow.f(paramInt3);
    localBubblePopupWindow.a(0);
    localBubblePopupWindow.b(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, bhjq parambhjq, View.OnClickListener paramOnClickListener, Integer paramInteger)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    parambhjq = a(localBubblePopupWindow, paramView.getContext(), parambhjq, paramOnClickListener);
    parambhjq.setIgnoreTouchLocation(true);
    parambhjq.setContainerBottom(paramInteger);
    localBubblePopupWindow.a(parambhjq);
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.c(1);
    localBubblePopupWindow.b(2);
    localBubblePopupWindow.a(paramView, paramInt1, paramInt2, true);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, bhjq parambhjq, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambhjq, paramOnClickListener));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.b(paramView);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, bhjq parambhjq, View.OnClickListener paramOnClickListener, blak paramblak)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), parambhjq, paramOnClickListener));
    localBubblePopupWindow.a(paramblak);
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.b(paramView);
    return localBubblePopupWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhcw
 * JD-Core Version:    0.7.0.1
 */