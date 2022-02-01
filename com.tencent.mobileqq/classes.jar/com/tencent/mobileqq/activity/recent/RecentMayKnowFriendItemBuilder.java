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
  protected String a;
  View.OnTouchListener b = new RecentMayKnowFriendItemBuilder.1(this);
  private WeakReference<MayKnowAdapter> h;
  
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
      paramViewGroup.c = paramView.curUin;
      paramView = a(paramContext, 2131624572, paramViewGroup);
      paramViewGroup.b = ((TextView)paramView.findViewById(2131444456));
      paramViewGroup.b.setOnClickListener(paramOnClickListener);
      paramViewGroup.b.setOnTouchListener(this.b);
      paramViewGroup.a = ((HorizontalListView)paramView.findViewById(2131438026));
      paramViewGroup.a.setDividerWidth(AIOUtils.b(9.0F, paramContext.getResources()));
      paramOnLongClickListener = new MayKnowAdapter((Activity)paramContext, paramRecentFaceDecoder.a(), paramViewGroup.a, null, 25, 0);
      paramOnDragModeChangedListener = this.h;
      if (paramOnDragModeChangedListener != null)
      {
        paramOnDragModeChangedListener = (MayKnowAdapter)paramOnDragModeChangedListener.get();
        if (paramOnDragModeChangedListener != null) {
          paramOnDragModeChangedListener.d();
        }
      }
      this.h = new WeakReference(paramOnLongClickListener);
      paramViewGroup.a.setAdapter(paramOnLongClickListener);
      paramView.setTag(paramViewGroup);
    }
    else if (!TextUtils.equals(this.a, ThemeUtil.curThemeId))
    {
      paramOnLongClickListener = this.h;
      if (paramOnLongClickListener != null)
      {
        paramOnLongClickListener = (MayKnowAdapter)paramOnLongClickListener.get();
        if (paramOnLongClickListener != null) {
          paramOnLongClickListener.notifyDataSetChanged();
        }
      }
    }
    this.a = ThemeUtil.curThemeId;
    if (AppSetting.e) {
      paramView.setContentDescription(null);
    }
    if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData))) {
      a(paramView, (RecentBaseData)paramObject, paramContext, paramRecentFaceDecoder.a());
    }
    a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
    paramView.setTag(-1, Integer.valueOf(paramInt));
    paramViewGroup.b.setTag(-1, Integer.valueOf(paramInt));
    return paramView;
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
        if ((!TextUtils.isEmpty(paramRecentBaseData.curUin)) && (!paramRecentBaseData.curUin.equals(paramView.c)))
        {
          paramContext = new MayKnowAdapter((Activity)paramContext, paramQQAppInterface, paramView.a, null, 25, 0);
          paramQQAppInterface = this.h;
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = (MayKnowAdapter)paramQQAppInterface.get();
            if (paramQQAppInterface != null) {
              paramQQAppInterface.d();
            }
          }
          this.h = new WeakReference(paramContext);
          paramView.a.setAdapter(paramContext);
          paramView.c = paramRecentBaseData.curUin;
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
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("destroy : ");
      WeakReference localWeakReference = this.h;
      boolean bool;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.i("RecentMayKnowFriendItemBuilder", 0, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = (MayKnowAdapter)((WeakReference)localObject).get();
      if (localObject != null) {
        ((MayKnowAdapter)localObject).d();
      }
      this.h = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentMayKnowFriendItemBuilder
 * JD-Core Version:    0.7.0.1
 */