package com.tencent.biz.pubaccount.weishi_new.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSPopupMenuDialog
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener
{
  private static final int[] a = { 2131918115, 2130853520 };
  private static final int[] b = { 2131918114, 2130853519 };
  private static final int[] c = { 2131918113, 2130853518 };
  private Activity d;
  private Animation e;
  private WSPopupMenuDialog.OnClickActionListener f;
  private WSPopupMenuDialog.OnDismissListener g;
  private WSPopupMenuDialog.MenuItem h = null;
  private int i = 0;
  private int j = 0;
  private WindowManager.LayoutParams k;
  private View l;
  private boolean m = false;
  
  private WSPopupMenuDialog(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    this.d = paramActivity;
    a();
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getDimensionPixelSize(paramInt);
  }
  
  private static int a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i1 = a(paramContext, 2131299625) * paramInt + a(paramContext, 2131299623);
    int n = i1;
    if (paramBoolean) {
      n = i1 + (paramInt - 1) * 1;
    }
    return n;
  }
  
  private static View a(Activity paramActivity, List<WSPopupMenuDialog.MenuItem> paramList)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131626065, null);
    a(paramActivity, localView, paramList);
    return localView;
  }
  
  private static WSPopupMenuDialog.MenuItem a(Context paramContext, int[] paramArrayOfInt, boolean paramBoolean)
  {
    WSPopupMenuDialog.MenuItem localMenuItem = new WSPopupMenuDialog.MenuItem();
    localMenuItem.a = paramArrayOfInt[0];
    localMenuItem.b = paramContext.getResources().getString(paramArrayOfInt[0]);
    localMenuItem.c = paramArrayOfInt[1];
    localMenuItem.d = paramBoolean;
    return localMenuItem;
  }
  
  public static WSPopupMenuDialog a(Activity paramActivity, boolean paramBoolean, WSPopupMenuDialog.OnClickActionListener paramOnClickActionListener, WSPopupMenuDialog.OnDismissListener paramOnDismissListener)
  {
    List localList = a(paramActivity, paramBoolean);
    if ((localList != null) && (localList.size() != 0))
    {
      int n = b(paramActivity, localList.size());
      int i1 = ViewUtils.dip2px(145.0F);
      paramActivity = new WSPopupMenuDialog(paramActivity, a(paramActivity, localList), i1, n, true);
      paramActivity.setAnimationStyle(2131951650);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setOutsideTouchable(false);
      a(paramActivity, 1002);
      if (AppSetting.e) {
        a(paramActivity);
      }
      paramActivity.a(paramActivity.getContentView());
      paramActivity.j = n;
      paramActivity.f = paramOnClickActionListener;
      paramActivity.g = paramOnDismissListener;
      paramActivity.m = false;
      return paramActivity;
    }
    throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
  }
  
  private static List<WSPopupMenuDialog.MenuItem> a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(paramContext, a, paramBoolean));
    localArrayList.add(a(paramContext, b, false));
    localArrayList.add(a(paramContext, c, false));
    return localArrayList;
  }
  
  private void a()
  {
    if (this.k == null)
    {
      this.k = new WindowManager.LayoutParams();
      WindowManager.LayoutParams localLayoutParams = this.k;
      localLayoutParams.type = 1000;
      localLayoutParams.format = -3;
      localLayoutParams.flags = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localLayoutParams = this.k;
        localLayoutParams.flags |= 0x4000000;
      }
      localLayoutParams = this.k;
      int i1 = -1;
      localLayoutParams.width = -1;
      int n = i1;
      if (this.d.getWindow() != null)
      {
        n = i1;
        if (this.d.getWindow().getDecorView() != null)
        {
          n = this.d.getWindow().getDecorView().getHeight();
          if (n <= 0) {
            n = i1;
          }
        }
      }
      localLayoutParams = this.k;
      localLayoutParams.height = n;
      localLayoutParams.windowAnimations = 2131952300;
    }
    if (this.l == null)
    {
      this.l = new View(this.d);
      this.l.setBackgroundColor(this.d.getResources().getColor(2131165797));
      this.l.setContentDescription(HardCodeUtil.a(2131906118));
      this.l.setOnClickListener(new WSPopupMenuDialog.1(this));
    }
    if ((AppSetting.e) && (Build.VERSION.SDK_INT >= 14)) {
      getContentView().setAccessibilityDelegate(new WSPopupMenuDialog.2(this));
    }
  }
  
  private static void a(Context paramContext, View paramView, List<WSPopupMenuDialog.MenuItem> paramList)
  {
    paramView = (LinearLayout)paramView.findViewById(2131437520);
    paramView.removeAllViews();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WSPopupMenuDialog.MenuItem localMenuItem = (WSPopupMenuDialog.MenuItem)paramList.next();
      View localView = LayoutInflater.from(paramContext).inflate(2131626064, null);
      ImageView localImageView1 = (ImageView)localView.findViewById(2131450270);
      ImageView localImageView2 = (ImageView)localView.findViewById(2131436429);
      TextView localTextView = (TextView)localView.findViewById(2131448544);
      localImageView2.setBackgroundResource(localMenuItem.c);
      localTextView.setText(localMenuItem.b);
      if (localMenuItem.d) {
        localImageView1.setVisibility(0);
      } else {
        localImageView1.setVisibility(8);
      }
      localView.setTag(localMenuItem);
      paramView.addView(localView);
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof WSPopupMenuDialog.MenuItem))) {
      paramView.setOnClickListener(this);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int n = 0;
      while (n < paramView.getChildCount())
      {
        a(paramView.getChildAt(n));
        n += 1;
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    if (!AppSetting.e) {
      return;
    }
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int i1 = arrayOfMethod.length;
    int n = 0;
    while (n < i1)
    {
      Method localMethod = arrayOfMethod[n];
      if (TextUtils.equals(localMethod.getName(), "setTouchModal")) {
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Boolean.valueOf(false) });
          return;
        }
        catch (Exception paramPopupWindow)
        {
          paramPopupWindow.printStackTrace();
          return;
        }
      }
      n += 1;
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int i1 = arrayOfMethod.length;
    int n = 0;
    while (n < i1)
    {
      Method localMethod = arrayOfMethod[n];
      if (TextUtils.equals(localMethod.getName(), "setWindowLayoutType")) {
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow)
        {
          paramPopupWindow.printStackTrace();
          return;
        }
      }
      n += 1;
    }
  }
  
  public static int b(Context paramContext, int paramInt)
  {
    int n = paramInt - 2;
    if (n > 0) {
      paramInt = n * AIOUtils.b(52.0F, paramContext.getResources()) + AIOUtils.b(62.0F, paramContext.getResources()) * 2;
    } else {
      paramInt = AIOUtils.b(62.0F, paramContext.getResources()) * paramInt;
    }
    return paramInt + a(paramContext, 2131299623);
  }
  
  public void dismiss()
  {
    try
    {
      if (LiuHaiUtils.b(this.d)) {
        ((ViewGroup)this.d.getWindow().getDecorView()).removeView(this.l);
      } else {
        this.d.getWindowManager().removeView(this.l);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WSPopupMenuDialog", 2, localException.toString());
      }
    }
    Object localObject;
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.dismiss();
      localObject = this.f;
      if (localObject != null)
      {
        WSPopupMenuDialog.MenuItem localMenuItem = this.h;
        if (localMenuItem != null) {
          ((WSPopupMenuDialog.OnClickActionListener)localObject).a(localMenuItem);
        }
      }
      this.h = null;
      localObject = this.g;
      if (localObject != null) {
        ((WSPopupMenuDialog.OnDismissListener)localObject).a();
      }
    }
    else if (isShowing())
    {
      localObject = this.e;
      if ((localObject != null) && (!((Animation)localObject).hasEnded())) {
        return;
      }
      if (this.e == null)
      {
        this.e = AnimationUtils.loadAnimation(this.d, 2130772464);
        this.e.setAnimationListener(this);
      }
      getContentView().startAnimation(this.e);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WSPopupMenuDialog", 2, "onAnimationEnd");
    }
    paramAnimation = this.f;
    if (paramAnimation != null)
    {
      WSPopupMenuDialog.MenuItem localMenuItem = this.h;
      if (localMenuItem != null) {
        paramAnimation.a(localMenuItem);
      }
    }
    this.h = null;
    paramAnimation = this.g;
    if (paramAnimation != null) {
      paramAnimation.a();
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WSPopupMenuDialog", 2, "onAnimationStart");
    }
  }
  
  public void onClick(View paramView)
  {
    this.h = ((WSPopupMenuDialog.MenuItem)paramView.getTag());
    dismiss();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int i1 = getMaxAvailableHeight(paramView, paramInt2);
    if (i1 != this.i)
    {
      int n = 0;
      if (i1 < this.j) {
        n = (1 - a(this.d, 2131299623) + i1) / (a(this.d, 2131299625) + 1);
      }
      if (n > 0) {
        setHeight(a(this.d, n, this.m));
      } else {
        setHeight(this.j);
      }
      this.i = i1;
    }
    try
    {
      if (LiuHaiUtils.b(this.d)) {
        ((ViewGroup)this.d.getWindow().getDecorView()).addView(this.l, this.k);
      } else {
        this.d.getWindowManager().addView(this.l, this.k);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WSPopupMenuDialog", 2, localException.toString());
      }
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (LiuHaiUtils.b(this.d)) {
        ((ViewGroup)this.d.getWindow().getDecorView()).addView(this.l, this.k);
      } else {
        this.d.getWindowManager().addView(this.l, this.k);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WSPopupMenuDialog", 2, localException.toString());
      }
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSPopupMenuDialog
 * JD-Core Version:    0.7.0.1
 */