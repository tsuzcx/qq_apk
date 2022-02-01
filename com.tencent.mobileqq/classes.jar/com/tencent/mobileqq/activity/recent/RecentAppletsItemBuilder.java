package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemAppletsFolderData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class RecentAppletsItemBuilder
  extends RecentItemBaseBuilder
{
  protected int a = 2131629161;
  private List<String> b;
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof RecentAppletsItemBuilder.RecentAppletsItemBuilderHolder)))
    {
      paramOnDragModeChangedListener = (RecentAppletsItemBuilder.RecentAppletsItemBuilderHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramOnDragModeChangedListener;
    }
    else
    {
      paramOnDragModeChangedListener = new RecentAppletsItemBuilder.RecentAppletsItemBuilderHolder();
      localObject1 = a(paramContext, this.a, paramOnDragModeChangedListener);
      paramOnDragModeChangedListener.a = ((RecentDynamicAvatarView)((View)localObject1).findViewById(2131435219));
      paramOnDragModeChangedListener.b = ((SingleLineTextView)((View)localObject1).findViewById(2131447463));
      paramOnDragModeChangedListener.c = ((DragTextView)((View)localObject1).findViewById(2131449128));
      paramOnDragModeChangedListener.d = ((SingleLineTextView)((View)localObject1).findViewById(2131431757));
      Object localObject2 = paramContext.getResources();
      float f = DeviceInfoUtil.A();
      paramView = ((Resources)localObject2).getColorStateList(2131168122);
      paramViewGroup = ((Resources)localObject2).getColorStateList(2131168001);
      localObject2 = ((Resources)localObject2).getColorStateList(2131168123);
      paramOnDragModeChangedListener.b.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramOnDragModeChangedListener.b.setExtendTextColor((ColorStateList)localObject2, 0);
      } else {
        paramOnDragModeChangedListener.b.setExtendTextColor(paramView, 0);
      }
      paramOnDragModeChangedListener.b.setExtendTextSize(12.0F, 0);
      paramOnDragModeChangedListener.b.setCompoundDrawablePadding((int)(3.0F * f));
      paramViewGroup = paramOnDragModeChangedListener.b;
      int i = (int)(2.0F * f);
      paramViewGroup.setIconDrawablePadding(i, (int)(1.0F * f));
      paramOnDragModeChangedListener.b.setExtendTextPadding((int)(f * 5.0F), 2);
      paramOnDragModeChangedListener.b.setExtendTextColor(paramView, 2);
      paramOnDragModeChangedListener.b.setExtendTextSize(17.0F, 2);
      paramOnDragModeChangedListener.d.setTextColor(paramView);
      paramOnDragModeChangedListener.d.setExtendTextPadding(i, 1);
      paramOnDragModeChangedListener.d.setExtendTextSize(14.0F, 1);
      ((View)localObject1).setTag(paramOnDragModeChangedListener);
      paramView = paramOnDragModeChangedListener;
      paramViewGroup = (ViewGroup)localObject1;
      if (this.f != null)
      {
        paramOnDragModeChangedListener.c.setOnModeChangeListener(this.f.b());
        paramViewGroup = (ViewGroup)localObject1;
        paramView = paramOnDragModeChangedListener;
      }
    }
    Object localObject1 = paramContext.getResources();
    paramOnDragModeChangedListener = ((Resources)localObject1).getColorStateList(2131168122);
    localObject1 = ((Resources)localObject1).getColorStateList(2131168123);
    if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
      paramView.b.setExtendTextColor((ColorStateList)localObject1, 0);
    } else {
      paramView.b.setExtendTextColor(paramOnDragModeChangedListener, 0);
    }
    paramView.c.setTag(Integer.valueOf(paramInt));
    if (AppSetting.e) {
      paramViewGroup.setContentDescription(null);
    }
    if ((paramObject instanceof RecentItemAppletsFolderData))
    {
      paramOnDragModeChangedListener = (RecentItemAppletsFolderData)paramObject;
      if (paramRecentFaceDecoder != null) {
        a(paramViewGroup, paramOnDragModeChangedListener, paramContext, paramRecentFaceDecoder.a(paramOnDragModeChangedListener.mUser.uin, paramView.a.getMeasuredWidth(), paramView.a.getMeasuredHeight(), paramOnDragModeChangedListener.iconUrl, paramOnDragModeChangedListener.iconUrlSimple));
      }
    }
    a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
    paramViewGroup.setOnClickListener(paramOnClickListener);
    paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
    paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
    return paramViewGroup;
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData != null) && (paramContext != null))
    {
      int i = paramRecentBaseData.mMenuFlag;
      paramRecentBaseData = paramContext.getResources();
      paramContext = this.b;
      if (paramContext == null) {
        this.b = new ArrayList();
      } else {
        paramContext.clear();
      }
      int j = i & 0xF0;
      if (j == 32) {
        this.b.add(paramRecentBaseData.getString(c[2]));
      } else if (j == 16) {
        this.b.add(paramRecentBaseData.getString(c[3]));
      }
      if ((i & 0xF) == 1) {
        this.b.add(paramRecentBaseData.getString(c[0]));
      }
      return this.b;
    }
    return null;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    RecentAppletsItemBuilder.RecentAppletsItemBuilderHolder localRecentAppletsItemBuilderHolder;
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      localRecentAppletsItemBuilderHolder = null;
      if ((paramView.getTag() instanceof RecentAppletsItemBuilder.RecentAppletsItemBuilderHolder)) {
        localRecentAppletsItemBuilderHolder = (RecentAppletsItemBuilder.RecentAppletsItemBuilderHolder)paramView.getTag();
      }
      if (localRecentAppletsItemBuilderHolder == null)
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
      localRecentAppletsItemBuilderHolder.a.setImageDrawable(paramDrawable);
      a(localRecentAppletsItemBuilderHolder.a);
      localRecentAppletsItemBuilderHolder.b.setExtendText(paramRecentBaseData.mShowTime, 0);
      localRecentAppletsItemBuilderHolder.b.setText(paramRecentBaseData.mTitleName);
      try
      {
        localRecentAppletsItemBuilderHolder.d.setText(paramRecentBaseData.mLastMsg);
      }
      catch (Exception paramDrawable)
      {
        paramDrawable.printStackTrace();
        paramDrawable = localRecentAppletsItemBuilderHolder.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramRecentBaseData.mLastMsg);
        localStringBuilder.append(" ");
        paramDrawable.setText(localStringBuilder.toString());
      }
      int j = paramRecentBaseData.mUnreadNum;
      int i = paramRecentBaseData.mUnreadFlag;
      if (j > 0) {
        if (i == 0)
        {
          localRecentAppletsItemBuilderHolder.c.setDragViewType(-1, paramView);
        }
        else
        {
          if (i == 2)
          {
            localRecentAppletsItemBuilderHolder.c.setDragViewType(-1, paramView);
            i = 1;
            break label289;
          }
          localRecentAppletsItemBuilderHolder.c.setDragViewType(0, paramView);
          localRecentAppletsItemBuilderHolder.c.setTextColor(paramContext.getResources().getColor(2131168174));
          i = 3;
          k = 2130852592;
          break label295;
        }
      }
      i = 0;
      label289:
      j = 0;
      int k = 0;
      label295:
      CustomWidgetUtil.a(localRecentAppletsItemBuilderHolder.c, i, j, k, 99, null);
      if ((paramRecentBaseData.mMenuFlag & 0xF0) != 32) {}
    }
    try
    {
      localRecentAppletsItemBuilderHolder.leftView.setBackgroundResource(2130839578);
    }
    catch (Throwable paramContext)
    {
      break label350;
    }
    localRecentAppletsItemBuilderHolder.leftView.setBackgroundResource(2130839577);
    label350:
    if (AppSetting.e) {
      paramView.setContentDescription(paramRecentBaseData.mContentDesc);
    }
    return;
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "bindView|param invalidate");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAppletsItemBuilder
 * JD-Core Version:    0.7.0.1
 */