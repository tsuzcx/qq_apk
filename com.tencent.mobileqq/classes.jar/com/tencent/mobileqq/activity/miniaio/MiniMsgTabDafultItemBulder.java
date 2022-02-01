package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.troop.utils.RecentTroopIconUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;

public class MiniMsgTabDafultItemBulder
  extends RecentItemBaseBuilder
{
  protected int a = 2131559533;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof MiniMsgTabAdapter.RecentItemBuilderHolder)))
    {
      paramViewGroup = (MiniMsgTabAdapter.RecentItemBuilderHolder)paramView.getTag();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      paramView.setOnClickListener(paramOnClickListener);
      if (!(paramObject instanceof RecentBaseData)) {
        break label384;
      }
      paramViewGroup = (RecentBaseData)paramObject;
      paramObject = null;
      if (paramRecentFaceDecoder != null) {
        paramObject = paramRecentFaceDecoder.a(paramViewGroup);
      }
      a(paramView, paramViewGroup, paramContext, paramObject);
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramViewGroup = new MiniMsgTabAdapter.RecentItemBuilderHolder();
      paramView = LayoutInflater.from(paramContext).inflate(this.a, null);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368603));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380944));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131379432));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131365699));
      paramViewGroup.b.setGravity(16);
      paramContext.getResources();
      float f = DeviceInfoUtil.a();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131165849));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(paramContext.getResources().getColor(2131165848)), 0);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(paramContext.getResources().getColor(2131165848)), 2);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      paramViewGroup.b.setTextColor(paramContext.getResources().getColor(2131165848));
      paramViewGroup.b.setExtendTextPadding((int)(f * 2.0F), 1);
      paramViewGroup.b.setExtendTextSize(14.0F, 1);
      paramView.setTag(paramViewGroup);
      break;
      label384:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramViewGroup.b.setText("");
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniMsgTabDafultItemBulder", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof MiniMsgTabAdapter.RecentItemBuilderHolder)) {}
    for (MiniMsgTabAdapter.RecentItemBuilderHolder localRecentItemBuilderHolder = (MiniMsgTabAdapter.RecentItemBuilderHolder)paramView.getTag();; localRecentItemBuilderHolder = null)
    {
      if (localRecentItemBuilderHolder == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MiniMsgTabDafultItemBulder", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      Object localObject = paramRecentBaseData.getRecentUserUin();
      int k = paramRecentBaseData.getRecentUserType();
      boolean bool2 = a(paramRecentBaseData);
      QQAppInterface localQQAppInterface;
      int j;
      int i;
      RecentDynamicAvatarView localRecentDynamicAvatarView;
      boolean bool1;
      if (bool2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MiniMsgTabDafultItemBulder", 2, "bindview user:" + (String)localObject);
        }
        localQQAppInterface = ((BaseActivity)paramContext).app;
        j = ((Integer)RecentFaceDecoder.a(localQQAppInterface, k, (String)localObject).first).intValue();
        i = j;
        if (j == 103) {
          i = 1;
        }
        localRecentDynamicAvatarView = localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
        if (localQQAppInterface.mAutomator.a() == 1) {
          bool1 = true;
        }
      }
      for (;;)
      {
        localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, (String)localObject, 100, false, bool1, 0);
        label222:
        float f = DeviceInfoUtil.a();
        if (paramRecentBaseData.mAuthenIconId != 0)
        {
          localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
          localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
          if (QLog.isColorLevel()) {
            QLog.d("MiniMsgTabDafultItemBulder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
          }
          label295:
          paramDrawable = paramRecentBaseData.mExtraInfo;
          if (paramDrawable == null) {
            break label869;
          }
          paramDrawable = paramDrawable.toString();
          label315:
          localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 2);
          localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
          localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
          if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
            localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleNameCs);
          }
          if ((k != 0) || (!(paramRecentBaseData instanceof RecentItemChatMsgData))) {
            break label876;
          }
          paramDrawable = (RecentItemChatMsgData)paramRecentBaseData;
          paramContext = ((BaseActivity)paramContext).app;
          localObject = MutualMarkDataCenter.a(paramContext, paramDrawable.mUser.uin, false, 5);
          paramContext = MutualMarkDataCenter.a(paramContext, paramDrawable.mUser.uin, (ArrayList)localObject);
          localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramContext);
          localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(f * 1.0F));
          label453:
          switch (paramRecentBaseData.mStatus)
          {
          default: 
            i = 0;
            label495:
            localRecentItemBuilderHolder.b.setCompoundDrawablesWithIntrinsicBounds(i, 0);
            i = paramRecentBaseData.mExtraInfoColor;
            paramContext = paramRecentBaseData.mMsgExtroInfo;
            if (paramContext != null)
            {
              paramContext = paramContext.toString();
              paramDrawable = paramContext;
              if (paramContext != null)
              {
                paramDrawable = paramContext;
                if (paramContext.length() > 0)
                {
                  paramDrawable = paramContext;
                  if (!paramContext.endsWith(" ")) {
                    paramDrawable = paramContext + " ";
                  }
                }
              }
              if ((!TextUtils.isEmpty(paramDrawable)) && (i != 0)) {
                localRecentItemBuilderHolder.b.setExtendTextColor(ColorStateList.valueOf(i), 1);
              }
              localRecentItemBuilderHolder.b.setExtendText(paramDrawable, 1);
            }
            break;
          }
        }
        try
        {
          localRecentItemBuilderHolder.b.setText(paramRecentBaseData.mLastMsg);
          k = paramRecentBaseData.mUnreadNum;
          i = 0;
          j = 0;
          m = paramRecentBaseData.mUnreadFlag;
          if (k > 0) {
            if (m == 0)
            {
              i = 0;
              j = 0;
              k = 0;
              localRecentItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              CustomWidgetUtil.a(localRecentItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, k, j, 99, null);
              if (AppSetting.d) {
                paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              }
              localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.a(paramRecentBaseData.getFaceExtraFlag());
              return;
              bool1 = false;
              continue;
              localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
              break label222;
              if (bool2)
              {
                i = VipUtils.a(((BaseActivity)paramContext).app, (String)localObject, false);
                if (QLog.isColorLevel()) {
                  QLog.d("MiniMsgTabDafultItemBulder", 2, "bindView: vip=" + i);
                }
                if (i == 3)
                {
                  localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(5.0F * f));
                  localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847429);
                  break label295;
                }
                localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
                break label295;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MiniMsgTabDafultItemBulder", 2, "bindView: drawable is null");
              }
              localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
              break label295;
              label869:
              paramDrawable = "";
              break label315;
              label876:
              if ((k == 1) && ((paramRecentBaseData instanceof RecentItemTroopMsgData)))
              {
                paramDrawable = (RecentItemTroopMsgData)paramRecentBaseData;
                paramContext = RecentTroopIconUtil.a(((BaseActivity)paramContext).app, paramDrawable);
                localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramContext);
                localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(f * 1.0F));
                break label453;
              }
              localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
              localRecentItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(f * 1.0F));
              break label453;
              i = 2130842291;
              break label495;
              if (paramRecentBaseData.mIsGroupVideo)
              {
                i = 2130842301;
                break label495;
              }
              i = 2130842291;
              break label495;
              if (paramRecentBaseData.mIsGroupVideo)
              {
                i = 2130842301;
                break label495;
              }
              i = 2130842302;
              break label495;
              i = 2130842302;
              break label495;
              i = 2130839676;
              break label495;
              paramContext = "";
            }
          }
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            int m;
            paramContext.printStackTrace();
            localRecentItemBuilderHolder.b.setText(paramRecentBaseData.mLastMsg + " ");
            continue;
            if (m == 2)
            {
              i = 1;
              j = 0;
              k = 0;
              localRecentItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            }
            else if (m == 3)
            {
              i = 3;
              j = 2130850838;
              localRecentItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
            }
            else
            {
              i = 3;
              j = 2130850834;
              localRecentItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              continue;
              k = 0;
            }
          }
        }
      }
    }
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.getRecentUserType();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008) || (i == 10010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabDafultItemBulder
 * JD-Core Version:    0.7.0.1
 */