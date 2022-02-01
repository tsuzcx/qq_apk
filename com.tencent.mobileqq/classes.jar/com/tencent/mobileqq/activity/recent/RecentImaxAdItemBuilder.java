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
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772237);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772236);
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
    paramView = a(paramContext, 2131629169, localRecentImaxAdItemBuilderHolder);
    localRecentImaxAdItemBuilderHolder.a = ((RecentDynamicAvatarView)paramView.findViewById(2131435219));
    localRecentImaxAdItemBuilderHolder.e = ((DragTextView)paramView.findViewById(2131449128));
    localRecentImaxAdItemBuilderHolder.d = ((SingleLineTextView)paramView.findViewById(2131447463));
    localRecentImaxAdItemBuilderHolder.g = ((SingleLineTextView)paramView.findViewById(2131431757));
    localRecentImaxAdItemBuilderHolder.g.setGravity(16);
    localRecentImaxAdItemBuilderHolder.i = ((RelativeLayout)paramView.findViewById(2131428358));
    localRecentImaxAdItemBuilderHolder.j = ((ImageView)paramView.findViewById(2131428357));
    Object localObject2 = paramContext.getResources();
    float f = DeviceInfoUtil.A();
    ColorStateList localColorStateList = ((Resources)localObject2).getColorStateList(2131168122);
    Object localObject1 = ((Resources)localObject2).getColorStateList(2131168001);
    localObject2 = ((Resources)localObject2).getColorStateList(2131168123);
    localRecentImaxAdItemBuilderHolder.d.setTextColor((ColorStateList)localObject1);
    if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
      localRecentImaxAdItemBuilderHolder.d.setExtendTextColor((ColorStateList)localObject2, 0);
    } else {
      localRecentImaxAdItemBuilderHolder.d.setExtendTextColor(localColorStateList, 0);
    }
    localRecentImaxAdItemBuilderHolder.d.setExtendTextSize(12.0F, 0);
    localRecentImaxAdItemBuilderHolder.d.setCompoundDrawablePadding((int)(3.0F * f));
    localObject1 = localRecentImaxAdItemBuilderHolder.d;
    int i = (int)(2.0F * f);
    ((SingleLineTextView)localObject1).setIconDrawablePadding(i, (int)(1.0F * f));
    localRecentImaxAdItemBuilderHolder.d.setExtendTextPadding((int)(f * 5.0F), 2);
    localRecentImaxAdItemBuilderHolder.d.setExtendTextColor(localColorStateList, 2);
    localRecentImaxAdItemBuilderHolder.d.setExtendTextSize(17.0F, 2);
    localRecentImaxAdItemBuilderHolder.g.setTextColor(localColorStateList);
    localRecentImaxAdItemBuilderHolder.g.setExtendTextPadding(i, 1);
    localRecentImaxAdItemBuilderHolder.g.setExtendTextSize(14.0F, 1);
    paramView.setTag(localRecentImaxAdItemBuilderHolder);
    if (this.f != null) {
      localRecentImaxAdItemBuilderHolder.e.setOnModeChangeListener(this.f.b());
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
      a(paramContext, localRecentImaxAdItemBuilderHolder.j);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "bindView|param invalidate");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentImaxAdItemBuilder
 * JD-Core Version:    0.7.0.1
 */