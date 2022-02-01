package com.tencent.mm.ui.widget.dialog;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.ui.base.j;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class MMTipsBar
{
  public static final int BAR_BG_COLOR_RED = 1;
  public static final int BAR_BG_COLOR_WHITE = 0;
  public static final long DURATION_SHORT = 2000L;
  
  public static j showConstantNotice(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, View.OnClickListener paramOnClickListener1, PopupWindow.OnDismissListener paramOnDismissListener, View.OnClickListener paramOnClickListener2)
  {
    View localView = View.inflate(paramActivity, 2131629537, null);
    Object localObject = (LinearLayout)localView.findViewById(2131429308);
    if (paramInt1 == 1) {
      ((LinearLayout)localObject).setBackgroundResource(2130853237);
    }
    localObject = (TextView)localView.findViewById(2131447457);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setOnClickListener(paramOnClickListener1);
    paramString = (WeImageView)localView.findViewById(2131447452);
    if (paramInt2 == 0)
    {
      paramString.setVisibility(8);
      paramInt1 = g.a(paramActivity, 16);
      ((TextView)localObject).setPadding(paramInt1, 0, paramInt1, 0);
    }
    else
    {
      paramString.setImageResource(paramInt2);
      paramString.setIconColor(paramInt3);
    }
    paramString = new j(localView);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    paramOnClickListener1 = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(paramOnClickListener1);
    paramInt2 = paramOnClickListener1.top;
    paramInt3 = h.a(paramActivity);
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = h.b(paramActivity);
    }
    paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, paramInt1 + paramInt3);
    paramActivity = (ImageView)localView.findViewById(2131447456);
    if (paramInt4 == 0) {
      paramActivity.setVisibility(8);
    } else {
      paramActivity.setImageResource(paramInt4);
    }
    paramActivity.setOnClickListener(new MMTipsBar.2(paramString, paramOnClickListener2));
    if (paramOnDismissListener != null) {
      paramString.setOnDismissListener(paramOnDismissListener);
    }
    return paramString;
  }
  
  public static j showNotice(Activity paramActivity, int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    Object localObject1 = View.inflate(paramActivity, 2131629536, null);
    Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131447450);
    localObject2 = (TextView)((View)localObject1).findViewById(2131447457);
    ((TextView)localObject2).setText(paramString);
    paramString = (WeImageView)((View)localObject1).findViewById(2131447452);
    if (paramInt1 == 0)
    {
      paramString.setVisibility(8);
      paramInt1 = g.a(paramActivity, 16);
      ((TextView)localObject2).setPadding(paramInt1, 0, paramInt1, 0);
    }
    else
    {
      paramString.setImageResource(paramInt1);
      paramString.setIconColor(paramInt2);
    }
    paramString = new j((View)localObject1);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject1 = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    paramInt2 = ((Rect)localObject1).top;
    int i = h.a(paramActivity);
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = h.b(paramActivity);
    }
    paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, paramInt1 + i);
    new MMTipsBar.1(paramString).sendEmptyMessageDelayed(0, paramLong);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMTipsBar
 * JD-Core Version:    0.7.0.1
 */