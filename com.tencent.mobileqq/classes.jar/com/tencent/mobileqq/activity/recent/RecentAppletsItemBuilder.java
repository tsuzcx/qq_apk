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
  protected int a;
  private List<String> a;
  
  public RecentAppletsItemBuilder()
  {
    this.jdField_a_of_type_Int = 2131562727;
  }
  
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
      localObject1 = a(paramContext, this.jdField_a_of_type_Int, paramOnDragModeChangedListener);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)((View)localObject1).findViewById(2131368343));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject1).findViewById(2131378784));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131380210));
      paramOnDragModeChangedListener.b = ((SingleLineTextView)((View)localObject1).findViewById(2131365536));
      Object localObject2 = paramContext.getResources();
      float f = DeviceInfoUtil.a();
      paramView = ((Resources)localObject2).getColorStateList(2131167142);
      paramViewGroup = ((Resources)localObject2).getColorStateList(2131167063);
      localObject2 = ((Resources)localObject2).getColorStateList(2131167143);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject2, 0);
      } else {
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      paramViewGroup = paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView;
      int i = (int)(2.0F * f);
      paramViewGroup.setIconDrawablePadding(i, (int)(1.0F * f));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 5.0F), 2);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      paramOnDragModeChangedListener.b.setTextColor(paramView);
      paramOnDragModeChangedListener.b.setExtendTextPadding(i, 1);
      paramOnDragModeChangedListener.b.setExtendTextSize(14.0F, 1);
      ((View)localObject1).setTag(paramOnDragModeChangedListener);
      paramView = paramOnDragModeChangedListener;
      paramViewGroup = (ViewGroup)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
        paramViewGroup = (ViewGroup)localObject1;
        paramView = paramOnDragModeChangedListener;
      }
    }
    Object localObject1 = paramContext.getResources();
    paramOnDragModeChangedListener = ((Resources)localObject1).getColorStateList(2131167142);
    localObject1 = ((Resources)localObject1).getColorStateList(2131167143);
    if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 0);
    } else {
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramOnDragModeChangedListener, 0);
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    if (AppSetting.d) {
      paramViewGroup.setContentDescription(null);
    }
    if ((paramObject instanceof RecentItemAppletsFolderData))
    {
      paramOnDragModeChangedListener = (RecentItemAppletsFolderData)paramObject;
      if (paramRecentFaceDecoder != null) {
        a(paramViewGroup, paramOnDragModeChangedListener, paramContext, paramRecentFaceDecoder.a(paramOnDragModeChangedListener.mUser.uin, paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getMeasuredWidth(), paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getMeasuredHeight(), paramOnDragModeChangedListener.iconUrl, paramOnDragModeChangedListener.iconUrlSimple));
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
      paramContext = this.jdField_a_of_type_JavaUtilList;
      if (paramContext == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      } else {
        paramContext.clear();
      }
      int j = i & 0xF0;
      if (j == 32) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[2]));
      } else if (j == 16) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[3]));
      }
      if ((i & 0xF) == 1) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
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
      localRecentAppletsItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
      a(localRecentAppletsItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
      localRecentAppletsItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
      localRecentAppletsItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
      try
      {
        localRecentAppletsItemBuilderHolder.b.setText(paramRecentBaseData.mLastMsg);
      }
      catch (Exception paramDrawable)
      {
        paramDrawable.printStackTrace();
        paramDrawable = localRecentAppletsItemBuilderHolder.b;
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
          localRecentAppletsItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
        }
        else
        {
          if (i == 2)
          {
            localRecentAppletsItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            i = 1;
            break label289;
          }
          localRecentAppletsItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
          localRecentAppletsItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167189));
          i = 3;
          k = 2130850770;
          break label295;
        }
      }
      i = 0;
      label289:
      j = 0;
      int k = 0;
      label295:
      CustomWidgetUtil.a(localRecentAppletsItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
      if ((paramRecentBaseData.mMenuFlag & 0xF0) != 32) {}
    }
    try
    {
      localRecentAppletsItemBuilderHolder.leftView.setBackgroundResource(2130839394);
    }
    catch (Throwable paramContext)
    {
      break label350;
    }
    localRecentAppletsItemBuilderHolder.leftView.setBackgroundResource(2130839393);
    label350:
    if (AppSetting.d) {
      paramView.setContentDescription(paramRecentBaseData.mContentDesc);
    }
    return;
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "bindView|param invalidate");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAppletsItemBuilder
 * JD-Core Version:    0.7.0.1
 */