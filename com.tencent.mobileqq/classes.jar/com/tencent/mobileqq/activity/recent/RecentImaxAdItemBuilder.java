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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;

public class RecentImaxAdItemBuilder
  extends RecentEfficientItemBuilder
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772143);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772142);
    localAnimation.setAnimationListener(new RecentImaxAdItemBuilder.1(paramView, paramContext));
    paramContext.setAnimationListener(new RecentImaxAdItemBuilder.2(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    RecentImaxAdItemBuilder.RecentImaxAdItemBuilderHolder localRecentImaxAdItemBuilderHolder;
    if ((paramView == null) || (!(paramView.getTag() instanceof RecentImaxAdItemBuilder.RecentImaxAdItemBuilderHolder)))
    {
      localRecentImaxAdItemBuilderHolder = new RecentImaxAdItemBuilder.RecentImaxAdItemBuilderHolder(null);
      View localView = a(paramContext, 2131562917, localRecentImaxAdItemBuilderHolder);
      localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131368603));
      localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131380944));
      localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131379432));
      localRecentImaxAdItemBuilderHolder.b = ((SingleLineTextView)localView.findViewById(2131365699));
      localRecentImaxAdItemBuilderHolder.b.setGravity(16);
      localRecentImaxAdItemBuilderHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362733));
      localRecentImaxAdItemBuilderHolder.c = ((ImageView)localView.findViewById(2131362732));
      Object localObject = paramContext.getResources();
      float f = DeviceInfoUtil.a();
      paramView = ((Resources)localObject).getColorStateList(2131167117);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131167040);
      localObject = ((Resources)localObject).getColorStateList(2131167118);
      localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject, 0);
        localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        localRecentImaxAdItemBuilderHolder.b.setTextColor(paramView);
        localRecentImaxAdItemBuilderHolder.b.setExtendTextPadding((int)(f * 2.0F), 1);
        localRecentImaxAdItemBuilderHolder.b.setExtendTextSize(14.0F, 1);
        localView.setTag(localRecentImaxAdItemBuilderHolder);
        paramView = localView;
        if (this.a != null)
        {
          localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramRecentFaceDecoder, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramOnDragModeChangedListener);
      localRecentImaxAdItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      break;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
    }
    RecentImaxAdItemBuilder.RecentImaxAdItemBuilderHolder localRecentImaxAdItemBuilderHolder;
    do
    {
      return;
      localRecentImaxAdItemBuilderHolder = null;
      if ((paramView.getTag() instanceof RecentImaxAdItemBuilder.RecentImaxAdItemBuilderHolder)) {
        localRecentImaxAdItemBuilderHolder = (RecentImaxAdItemBuilder.RecentImaxAdItemBuilderHolder)paramView.getTag();
      }
      if (localRecentImaxAdItemBuilderHolder != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
    return;
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramContext, localRecentImaxAdItemBuilderHolder.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentImaxAdItemBuilder
 * JD-Core Version:    0.7.0.1
 */