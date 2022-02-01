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
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131720439, 2130851259 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131720438, 2130851258 };
  private static final int[] c = { 2131720437, 2130851257 };
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private WSPopupMenuDialog.MenuItem jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$MenuItem = null;
  private WSPopupMenuDialog.OnClickActionListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$OnClickActionListener;
  private WSPopupMenuDialog.OnDismissListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$OnDismissListener;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  
  private WSPopupMenuDialog(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    a();
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getDimensionPixelSize(paramInt);
  }
  
  private static int a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int j = a(paramContext, 2131298903) * paramInt + a(paramContext, 2131298901);
    int i = j;
    if (paramBoolean) {
      i = j + (paramInt - 1) * 1;
    }
    return i;
  }
  
  private static View a(Activity paramActivity, List<WSPopupMenuDialog.MenuItem> paramList)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131560022, null);
    a(paramActivity, localView, paramList);
    return localView;
  }
  
  private static WSPopupMenuDialog.MenuItem a(Context paramContext, int[] paramArrayOfInt, boolean paramBoolean)
  {
    WSPopupMenuDialog.MenuItem localMenuItem = new WSPopupMenuDialog.MenuItem();
    localMenuItem.jdField_a_of_type_Int = paramArrayOfInt[0];
    localMenuItem.jdField_a_of_type_JavaLangString = paramContext.getResources().getString(paramArrayOfInt[0]);
    localMenuItem.jdField_b_of_type_Int = paramArrayOfInt[1];
    localMenuItem.jdField_a_of_type_Boolean = paramBoolean;
    return localMenuItem;
  }
  
  public static WSPopupMenuDialog a(Activity paramActivity, boolean paramBoolean, WSPopupMenuDialog.OnClickActionListener paramOnClickActionListener, WSPopupMenuDialog.OnDismissListener paramOnDismissListener)
  {
    List localList = a(paramActivity, paramBoolean);
    if ((localList != null) && (localList.size() != 0))
    {
      int i = b(paramActivity, localList.size());
      int j = ViewUtils.a(145.0F);
      paramActivity = new WSPopupMenuDialog(paramActivity, a(paramActivity, localList), j, i, true);
      paramActivity.setAnimationStyle(2131755035);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setOutsideTouchable(false);
      a(paramActivity, 1002);
      if (AppSetting.d) {
        a(paramActivity);
      }
      paramActivity.a(paramActivity.getContentView());
      paramActivity.jdField_b_of_type_Int = i;
      paramActivity.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$OnClickActionListener = paramOnClickActionListener;
      paramActivity.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$OnDismissListener = paramOnDismissListener;
      paramActivity.jdField_a_of_type_Boolean = false;
      return paramActivity;
    }
    throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
  }
  
  private static List<WSPopupMenuDialog.MenuItem> a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(paramContext, jdField_a_of_type_ArrayOfInt, paramBoolean));
    localArrayList.add(a(paramContext, jdField_b_of_type_ArrayOfInt, false));
    localArrayList.add(a(paramContext, c, false));
    return localArrayList;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      localLayoutParams.type = 1000;
      localLayoutParams.format = -3;
      localLayoutParams.flags = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
        localLayoutParams.flags |= 0x4000000;
      }
      localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      int j = -1;
      localLayoutParams.width = -1;
      int i = j;
      if (this.jdField_a_of_type_AndroidAppActivity.getWindow() != null)
      {
        i = j;
        if (this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView() != null)
        {
          i = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getHeight();
          if (i <= 0) {
            i = j;
          }
        }
      }
      localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      localLayoutParams.height = i;
      localLayoutParams.windowAnimations = 2131755514;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165476));
      this.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131708330));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new WSPopupMenuDialog.1(this));
    }
    if ((AppSetting.d) && (Build.VERSION.SDK_INT >= 14)) {
      getContentView().setAccessibilityDelegate(new WSPopupMenuDialog.2(this));
    }
  }
  
  private static void a(Context paramContext, View paramView, List<WSPopupMenuDialog.MenuItem> paramList)
  {
    paramView = (LinearLayout)paramView.findViewById(2131370288);
    paramView.removeAllViews();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WSPopupMenuDialog.MenuItem localMenuItem = (WSPopupMenuDialog.MenuItem)paramList.next();
      View localView = LayoutInflater.from(paramContext).inflate(2131560021, null);
      ImageView localImageView1 = (ImageView)localView.findViewById(2131381222);
      ImageView localImageView2 = (ImageView)localView.findViewById(2131369396);
      TextView localTextView = (TextView)localView.findViewById(2131379739);
      localImageView2.setBackgroundResource(localMenuItem.jdField_b_of_type_Int);
      localTextView.setText(localMenuItem.jdField_a_of_type_JavaLangString);
      if (localMenuItem.jdField_a_of_type_Boolean) {
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
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    if (!AppSetting.d) {
      return;
    }
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
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
      i += 1;
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
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
      i += 1;
    }
  }
  
  public static int b(Context paramContext, int paramInt)
  {
    int i = paramInt - 2;
    if (i > 0) {
      paramInt = i * AIOUtils.b(52.0F, paramContext.getResources()) + AIOUtils.b(62.0F, paramContext.getResources()) * 2;
    } else {
      paramInt = AIOUtils.b(62.0F, paramContext.getResources()) * paramInt;
    }
    return paramInt + a(paramContext, 2131298901);
  }
  
  public void dismiss()
  {
    try
    {
      if (LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).removeView(this.jdField_a_of_type_AndroidViewView);
      } else {
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_a_of_type_AndroidViewView);
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
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$OnClickActionListener;
      if (localObject != null)
      {
        WSPopupMenuDialog.MenuItem localMenuItem = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$MenuItem;
        if (localMenuItem != null) {
          ((WSPopupMenuDialog.OnClickActionListener)localObject).a(localMenuItem);
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$MenuItem = null;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$OnDismissListener;
      if (localObject != null) {
        ((WSPopupMenuDialog.OnDismissListener)localObject).a();
      }
    }
    else if (isShowing())
    {
      localObject = this.jdField_a_of_type_AndroidViewAnimationAnimation;
      if ((localObject != null) && (!((Animation)localObject).hasEnded())) {
        return;
      }
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772372);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      }
      getContentView().startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WSPopupMenuDialog", 2, "onAnimationEnd");
    }
    paramAnimation = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$OnClickActionListener;
    if (paramAnimation != null)
    {
      WSPopupMenuDialog.MenuItem localMenuItem = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$MenuItem;
      if (localMenuItem != null) {
        paramAnimation.a(localMenuItem);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$MenuItem = null;
    paramAnimation = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$OnDismissListener;
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
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog$MenuItem = ((WSPopupMenuDialog.MenuItem)paramView.getTag());
    dismiss();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int j = getMaxAvailableHeight(paramView, paramInt2);
    if (j != this.jdField_a_of_type_Int)
    {
      int i = 0;
      if (j < this.jdField_b_of_type_Int) {
        i = (1 - a(this.jdField_a_of_type_AndroidAppActivity, 2131298901) + j) / (a(this.jdField_a_of_type_AndroidAppActivity, 2131298903) + 1);
      }
      if (i > 0) {
        setHeight(a(this.jdField_a_of_type_AndroidAppActivity, i, this.jdField_a_of_type_Boolean));
      } else {
        setHeight(this.jdField_b_of_type_Int);
      }
      this.jdField_a_of_type_Int = j;
    }
    try
    {
      if (LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      } else {
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
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
      if (LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      } else {
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSPopupMenuDialog
 * JD-Core Version:    0.7.0.1
 */