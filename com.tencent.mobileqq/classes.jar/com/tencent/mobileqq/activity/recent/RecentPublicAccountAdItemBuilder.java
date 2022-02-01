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
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;

public class RecentPublicAccountAdItemBuilder
  extends RecentEfficientItemBuilder
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772237);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772236);
    localAnimation.setAnimationListener(new RecentPublicAccountAdItemBuilder.1(paramView, paramContext));
    paramContext.setAnimationListener(new RecentPublicAccountAdItemBuilder.2(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof RecentPublicAccountAdItemBuilder.RecentPublicAccountAdItemBuilderHolder))) {
      break label376;
    }
    RecentPublicAccountAdItemBuilder.RecentPublicAccountAdItemBuilderHolder localRecentPublicAccountAdItemBuilderHolder = new RecentPublicAccountAdItemBuilder.RecentPublicAccountAdItemBuilderHolder(null);
    paramView = a(paramContext, 2131629169, localRecentPublicAccountAdItemBuilderHolder);
    localRecentPublicAccountAdItemBuilderHolder.a = ((RecentDynamicAvatarView)paramView.findViewById(2131435219));
    localRecentPublicAccountAdItemBuilderHolder.e = ((DragTextView)paramView.findViewById(2131449128));
    localRecentPublicAccountAdItemBuilderHolder.d = ((SingleLineTextView)paramView.findViewById(2131447463));
    localRecentPublicAccountAdItemBuilderHolder.g = ((SingleLineTextView)paramView.findViewById(2131431757));
    localRecentPublicAccountAdItemBuilderHolder.g.setGravity(16);
    localRecentPublicAccountAdItemBuilderHolder.i = ((RelativeLayout)paramView.findViewById(2131428358));
    localRecentPublicAccountAdItemBuilderHolder.j = ((ImageView)paramView.findViewById(2131428357));
    Object localObject2 = paramContext.getResources();
    float f = DeviceInfoUtil.A();
    ColorStateList localColorStateList = ((Resources)localObject2).getColorStateList(2131168122);
    Object localObject1 = ((Resources)localObject2).getColorStateList(2131168001);
    localObject2 = ((Resources)localObject2).getColorStateList(2131168123);
    localRecentPublicAccountAdItemBuilderHolder.d.setTextColor((ColorStateList)localObject1);
    if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
      localRecentPublicAccountAdItemBuilderHolder.d.setExtendTextColor((ColorStateList)localObject2, 0);
    } else {
      localRecentPublicAccountAdItemBuilderHolder.d.setExtendTextColor(localColorStateList, 0);
    }
    localRecentPublicAccountAdItemBuilderHolder.d.setExtendTextSize(12.0F, 0);
    localRecentPublicAccountAdItemBuilderHolder.d.setCompoundDrawablePadding((int)(3.0F * f));
    localObject1 = localRecentPublicAccountAdItemBuilderHolder.d;
    int i = (int)(2.0F * f);
    ((SingleLineTextView)localObject1).setIconDrawablePadding(i, (int)(1.0F * f));
    localRecentPublicAccountAdItemBuilderHolder.d.setExtendTextPadding((int)(f * 5.0F), 2);
    localRecentPublicAccountAdItemBuilderHolder.d.setExtendTextColor(localColorStateList, 2);
    localRecentPublicAccountAdItemBuilderHolder.d.setExtendTextSize(17.0F, 2);
    localRecentPublicAccountAdItemBuilderHolder.g.setTextColor(localColorStateList);
    localRecentPublicAccountAdItemBuilderHolder.g.setExtendTextPadding(i, 1);
    localRecentPublicAccountAdItemBuilderHolder.g.setExtendTextSize(14.0F, 1);
    paramView.setTag(localRecentPublicAccountAdItemBuilderHolder);
    if (this.f != null) {
      localRecentPublicAccountAdItemBuilderHolder.e.setOnModeChangeListener(this.f.b());
    }
    label376:
    return super.a(paramInt, paramObject, paramRecentFaceDecoder, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramOnDragModeChangedListener);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      RecentPublicAccountAdItemBuilder.RecentPublicAccountAdItemBuilderHolder localRecentPublicAccountAdItemBuilderHolder = null;
      if ((paramView.getTag() instanceof RecentPublicAccountAdItemBuilder.RecentPublicAccountAdItemBuilderHolder)) {
        localRecentPublicAccountAdItemBuilderHolder = (RecentPublicAccountAdItemBuilder.RecentPublicAccountAdItemBuilderHolder)paramView.getTag();
      }
      if (localRecentPublicAccountAdItemBuilderHolder == null)
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
      paramView = (RelativeLayout.LayoutParams)localRecentPublicAccountAdItemBuilderHolder.i.getLayoutParams();
      paramView.height = localRecentPublicAccountAdItemBuilderHolder.g.getMeasuredHeight();
      localRecentPublicAccountAdItemBuilderHolder.i.setLayoutParams(paramView);
      a(paramContext, localRecentPublicAccountAdItemBuilderHolder.j);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "bindView|param invalidate");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPublicAccountAdItemBuilder
 * JD-Core Version:    0.7.0.1
 */