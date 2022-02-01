package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.adapter.MayKnowAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;

public class RecentMayKnowFriendItemBuilder
  extends RecentItemBaseBuilder
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new RecentMayKnowFriendItemBuilder.1(this);
  protected String a;
  private WeakReference<MayKnowAdapter> jdField_a_of_type_JavaLangRefWeakReference;
  
  RecentMayKnowFriendItemBuilder()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentMayKnowFriendItemBuilder", 0, "RecentMayKnowFriendItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof RecentMayKnowFriendItemBuilder.RecentMayKnowFriendItemHolder))) {
      paramViewGroup = (RecentMayKnowFriendItemBuilder.RecentMayKnowFriendItemHolder)paramView.getTag();
    } else {
      paramViewGroup = null;
    }
    if (paramViewGroup == null)
    {
      paramView = (RecentItemMayKnowFriendData)paramObject;
      paramViewGroup = new RecentMayKnowFriendItemBuilder.RecentMayKnowFriendItemHolder();
      paramViewGroup.jdField_a_of_type_JavaLangString = paramView.curUin;
      paramView = a(paramContext, 2131558941, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376248));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131370726));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(AIOUtils.b(9.0F, paramContext.getResources()));
      paramOnLongClickListener = new MayKnowAdapter((Activity)paramContext, paramRecentFaceDecoder.a(), paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView, null, 25, 0);
      paramOnDragModeChangedListener = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (paramOnDragModeChangedListener != null)
      {
        paramOnDragModeChangedListener = (MayKnowAdapter)paramOnDragModeChangedListener.get();
        if (paramOnDragModeChangedListener != null) {
          paramOnDragModeChangedListener.d();
        }
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnLongClickListener);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(paramOnLongClickListener);
      paramView.setTag(paramViewGroup);
    }
    else if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, ThemeUtil.curThemeId))
    {
      paramOnLongClickListener = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (paramOnLongClickListener != null)
      {
        paramOnLongClickListener = (MayKnowAdapter)paramOnLongClickListener.get();
        if (paramOnLongClickListener != null) {
          paramOnLongClickListener.notifyDataSetChanged();
        }
      }
    }
    this.jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
    if (AppSetting.d) {
      paramView.setContentDescription(null);
    }
    if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData))) {
      a(paramView, (RecentBaseData)paramObject, paramContext, paramRecentFaceDecoder.a());
    }
    a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
    paramView.setTag(-1, Integer.valueOf(paramInt));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTag(-1, Integer.valueOf(paramInt));
    return paramView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("destroy : ");
      WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      boolean bool;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.i("RecentMayKnowFriendItemBuilder", 0, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (MayKnowAdapter)((WeakReference)localObject).get();
      if (localObject != null) {
        ((MayKnowAdapter)localObject).d();
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      Object localObject = paramView.getTag();
      paramView = null;
      if ((localObject instanceof RecentMayKnowFriendItemBuilder.RecentMayKnowFriendItemHolder)) {
        paramView = (RecentMayKnowFriendItemBuilder.RecentMayKnowFriendItemHolder)localObject;
      }
      if (paramView == null)
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("updateView|holder is null, tag = ");
          paramView.append(localObject);
          QLog.i("RecentMayKnowFriendItemBuilder", 0, paramView.toString());
        }
        return;
      }
      if ((paramRecentBaseData instanceof RecentItemMayKnowFriendData))
      {
        paramRecentBaseData = (RecentItemMayKnowFriendData)paramRecentBaseData;
        if (QLog.isColorLevel()) {
          QLog.i("RecentMayKnowFriendItemBuilder", 0, "updateView");
        }
        if ((!TextUtils.isEmpty(paramRecentBaseData.curUin)) && (!paramRecentBaseData.curUin.equals(paramView.jdField_a_of_type_JavaLangString)))
        {
          paramContext = new MayKnowAdapter((Activity)paramContext, paramQQAppInterface, paramView.jdField_a_of_type_ComTencentWidgetHorizontalListView, null, 25, 0);
          paramQQAppInterface = this.jdField_a_of_type_JavaLangRefWeakReference;
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = (MayKnowAdapter)paramQQAppInterface.get();
            if (paramQQAppInterface != null) {
              paramQQAppInterface.d();
            }
          }
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
          paramView.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(paramContext);
          paramView.jdField_a_of_type_JavaLangString = paramRecentBaseData.curUin;
          if (QLog.isColorLevel()) {
            QLog.i("RecentMayKnowFriendItemBuilder", 0, "updateView1");
          }
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentMayKnowFriendItemBuilder", 0, "updateView|param invalidate");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentMayKnowFriendItemBuilder
 * JD-Core Version:    0.7.0.1
 */