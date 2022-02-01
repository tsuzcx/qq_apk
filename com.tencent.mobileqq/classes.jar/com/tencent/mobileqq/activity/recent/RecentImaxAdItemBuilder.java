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
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;

public class RecentImaxAdItemBuilder
  extends RecentEfficientItemBuilder
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772171);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772170);
    localAnimation.setAnimationListener(new RecentImaxAdItemBuilder.1(paramView, paramContext));
    paramContext.setAnimationListener(new RecentImaxAdItemBuilder.2(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof RecentImaxAdItemBuilder.RecentImaxAdItemBuilderHolder))) {
      break label376;
    }
    RecentImaxAdItemBuilder.RecentImaxAdItemBuilderHolder localRecentImaxAdItemBuilderHolder = new RecentImaxAdItemBuilder.RecentImaxAdItemBuilderHolder(null);
    paramView = a(paramContext, 2131562732, localRecentImaxAdItemBuilderHolder);
    localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368343));
    localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380210));
    localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378784));
    localRecentImaxAdItemBuilderHolder.b = ((SingleLineTextView)paramView.findViewById(2131365536));
    localRecentImaxAdItemBuilderHolder.b.setGravity(16);
    localRecentImaxAdItemBuilderHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362689));
    localRecentImaxAdItemBuilderHolder.c = ((ImageView)paramView.findViewById(2131362688));
    Object localObject2 = paramContext.getResources();
    float f = DeviceInfoUtil.a();
    ColorStateList localColorStateList = ((Resources)localObject2).getColorStateList(2131167142);
    Object localObject1 = ((Resources)localObject2).getColorStateList(2131167063);
    localObject2 = ((Resources)localObject2).getColorStateList(2131167143);
    localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject1);
    if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
      localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject2, 0);
    } else {
      localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(localColorStateList, 0);
    }
    localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
    localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
    localObject1 = localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView;
    int i = (int)(2.0F * f);
    ((SingleLineTextView)localObject1).setIconDrawablePadding(i, (int)(1.0F * f));
    localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 5.0F), 2);
    localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(localColorStateList, 2);
    localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
    localRecentImaxAdItemBuilderHolder.b.setTextColor(localColorStateList);
    localRecentImaxAdItemBuilderHolder.b.setExtendTextPadding(i, 1);
    localRecentImaxAdItemBuilderHolder.b.setExtendTextSize(14.0F, 1);
    paramView.setTag(localRecentImaxAdItemBuilderHolder);
    if (this.a != null) {
      localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
    }
    label376:
    return super.a(paramInt, paramObject, paramRecentFaceDecoder, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramOnDragModeChangedListener);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      RecentImaxAdItemBuilder.RecentImaxAdItemBuilderHolder localRecentImaxAdItemBuilderHolder = null;
      if ((paramView.getTag() instanceof RecentImaxAdItemBuilder.RecentImaxAdItemBuilderHolder)) {
        localRecentImaxAdItemBuilderHolder = (RecentImaxAdItemBuilder.RecentImaxAdItemBuilderHolder)paramView.getTag();
      }
      if (localRecentImaxAdItemBuilderHolder == null)
      {
        if (QLog.isColorLevel())
        {
          paramRecentBaseData = new StringBuilder();
          paramRecentBaseData.append("bindView|holder is null, tag = ");
          paramRecentBaseData.append(paramView.getTag());
          QLog.i("Q.recent", 2, paramRecentBaseData.toString());
        }
        return;
      }
      super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
      a(paramContext, localRecentImaxAdItemBuilderHolder.c);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "bindView|param invalidate");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentImaxAdItemBuilder
 * JD-Core Version:    0.7.0.1
 */