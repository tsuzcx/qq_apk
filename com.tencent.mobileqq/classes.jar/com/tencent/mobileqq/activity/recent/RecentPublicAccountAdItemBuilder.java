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

public class RecentPublicAccountAdItemBuilder
  extends RecentEfficientItemBuilder
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772143);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772142);
    localAnimation.setAnimationListener(new RecentPublicAccountAdItemBuilder.1(paramView, paramContext));
    paramContext.setAnimationListener(new RecentPublicAccountAdItemBuilder.2(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    RecentPublicAccountAdItemBuilder.RecentPublicAccountAdItemBuilderHolder localRecentPublicAccountAdItemBuilderHolder;
    if ((paramView == null) || (!(paramView.getTag() instanceof RecentPublicAccountAdItemBuilder.RecentPublicAccountAdItemBuilderHolder)))
    {
      localRecentPublicAccountAdItemBuilderHolder = new RecentPublicAccountAdItemBuilder.RecentPublicAccountAdItemBuilderHolder(null);
      View localView = a(paramContext, 2131562917, localRecentPublicAccountAdItemBuilderHolder);
      localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131368603));
      localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131380944));
      localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131379432));
      localRecentPublicAccountAdItemBuilderHolder.b = ((SingleLineTextView)localView.findViewById(2131365699));
      localRecentPublicAccountAdItemBuilderHolder.b.setGravity(16);
      localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362733));
      localRecentPublicAccountAdItemBuilderHolder.c = ((ImageView)localView.findViewById(2131362732));
      Object localObject = paramContext.getResources();
      float f = DeviceInfoUtil.a();
      paramView = ((Resources)localObject).getColorStateList(2131167117);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131167040);
      localObject = ((Resources)localObject).getColorStateList(2131167118);
      localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject, 0);
        localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        localRecentPublicAccountAdItemBuilderHolder.b.setTextColor(paramView);
        localRecentPublicAccountAdItemBuilderHolder.b.setExtendTextPadding((int)(f * 2.0F), 1);
        localRecentPublicAccountAdItemBuilderHolder.b.setExtendTextSize(14.0F, 1);
        localView.setTag(localRecentPublicAccountAdItemBuilderHolder);
        paramView = localView;
        if (this.a != null)
        {
          localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramRecentFaceDecoder, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramOnDragModeChangedListener);
      localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
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
    if ((paramView.getTag() instanceof RecentPublicAccountAdItemBuilder.RecentPublicAccountAdItemBuilderHolder)) {}
    for (RecentPublicAccountAdItemBuilder.RecentPublicAccountAdItemBuilderHolder localRecentPublicAccountAdItemBuilderHolder = (RecentPublicAccountAdItemBuilder.RecentPublicAccountAdItemBuilderHolder)paramView.getTag();; localRecentPublicAccountAdItemBuilderHolder = null)
    {
      if (localRecentPublicAccountAdItemBuilderHolder == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
      paramView = (RelativeLayout.LayoutParams)localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.height = localRecentPublicAccountAdItemBuilderHolder.b.getMeasuredHeight();
      localRecentPublicAccountAdItemBuilderHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      a(paramContext, localRecentPublicAccountAdItemBuilderHolder.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPublicAccountAdItemBuilder
 * JD-Core Version:    0.7.0.1
 */