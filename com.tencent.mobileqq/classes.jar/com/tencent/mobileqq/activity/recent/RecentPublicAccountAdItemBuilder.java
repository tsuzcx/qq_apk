package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import xlc;
import xld;
import xle;

public class RecentPublicAccountAdItemBuilder
  extends RecentEfficientItemBuilder
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2131034220);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2131034219);
    localAnimation.setAnimationListener(new xlc(paramView, paramContext));
    paramContext.setAnimationListener(new xld(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    xle localxle;
    if ((paramView == null) || (!(paramView.getTag() instanceof xle)))
    {
      localxle = new xle(null);
      View localView = a(paramContext, 2130971488, localxle);
      localxle.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131362719));
      localxle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131363207));
      localxle.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131363378));
      localxle.b = ((SingleLineTextView)localView.findViewById(2131365659));
      localxle.b.setGravity(16);
      localxle.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131374902));
      localxle.c = ((ImageView)localView.findViewById(2131374903));
      Object localObject = paramContext.getResources();
      float f = DeviceInfoUtil.a();
      paramView = ((Resources)localObject).getColorStateList(2131494267);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131494219);
      localObject = ((Resources)localObject).getColorStateList(2131494268);
      localxle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        localxle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject, 0);
        localxle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        localxle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        localxle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        localxle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        localxle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        localxle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        localxle.b.setTextColor(paramView);
        localxle.b.setExtendTextPadding((int)(f * 2.0F), 1);
        localxle.b.setExtendTextSize(14.0F, 1);
        localView.setTag(localxle);
        paramView = localView;
        if (this.a != null)
        {
          localxle.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramRecentFaceDecoder, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramOnDragModeChangedListener);
      localxle.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      break;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof xle)) {}
    for (xle localxle = (xle)paramView.getTag();; localxle = null)
    {
      if (localxle == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
      paramView = (RelativeLayout.LayoutParams)localxle.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.height = localxle.b.getMeasuredHeight();
      localxle.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      a(paramContext, localxle.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPublicAccountAdItemBuilder
 * JD-Core Version:    0.7.0.1
 */