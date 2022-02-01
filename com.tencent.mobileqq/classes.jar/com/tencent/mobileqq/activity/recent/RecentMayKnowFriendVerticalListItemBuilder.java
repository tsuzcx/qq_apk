package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class RecentMayKnowFriendVerticalListItemBuilder
  extends RecentItemBaseBuilder
{
  protected int a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new RecentMayKnowFriendVerticalListItemBuilder.1(this);
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public RecentMayKnowFriendVerticalListItemBuilder()
  {
    this.jdField_a_of_type_Int = 2131562731;
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)))
    {
      paramOnDragModeChangedListener = (RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramOnDragModeChangedListener;
    }
    else
    {
      paramView = new RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder();
      paramViewGroup = a(paramContext, this.jdField_a_of_type_Int, paramView);
      paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramViewGroup.findViewById(2131361799));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131371877));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131376485));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131362299));
      paramView.c = ((TextView)paramViewGroup.findViewById(2131376487));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131376477));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131376248));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131376260));
      paramView.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131376249));
      paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramViewGroup.findViewById(2131379273));
      paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      paramView.e = ((TextView)paramViewGroup.findViewById(2131370723));
      Object localObject2 = paramContext.getResources();
      float f = DeviceInfoUtil.a();
      paramOnDragModeChangedListener = ((Resources)localObject2).getColorStateList(2131167142);
      localObject1 = ((Resources)localObject2).getColorStateList(2131167063);
      localObject2 = ((Resources)localObject2).getColorStateList(2131167143);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject1);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject2, 0);
      } else {
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramOnDragModeChangedListener, 0);
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 5.0F), 2);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramOnDragModeChangedListener, 2);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      paramViewGroup.setTag(paramView);
    }
    Object localObject1 = paramContext.getResources();
    paramOnDragModeChangedListener = ((Resources)localObject1).getColorStateList(2131167142);
    localObject1 = ((Resources)localObject1).getColorStateList(2131167143);
    if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 0);
    } else {
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramOnDragModeChangedListener, 0);
    }
    paramView.d.setOnClickListener(paramOnClickListener);
    paramView.d.setTag(-1, Integer.valueOf(paramInt));
    paramView.d.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramOnClickListener);
    paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(-1, Integer.valueOf(paramInt));
    paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
    paramView.jdField_a_of_type_AndroidWidgetButton.setTag(-1, Integer.valueOf(paramInt));
    if (AppSetting.d) {
      paramViewGroup.setContentDescription(null);
    }
    if ((paramObject instanceof RecentBaseData))
    {
      paramOnDragModeChangedListener = (RecentBaseData)paramObject;
      if ((paramObject instanceof RecentItemMayKnowFriendVerticalListData))
      {
        localObject1 = ((RecentItemMayKnowFriendVerticalListData)paramObject).mUser;
        if (((RecentUser)localObject1).uin.equals("sp_uin_for_title"))
        {
          paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        else
        {
          paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          paramOnDragModeChangedListener.getRecentUserUin();
          paramOnDragModeChangedListener.getRecentUserType();
          if (paramRecentFaceDecoder != null) {
            paramRecentFaceDecoder = paramRecentFaceDecoder.a(paramOnDragModeChangedListener);
          } else {
            paramRecentFaceDecoder = null;
          }
          if ((((RecentUser)localObject1).extraInfo instanceof MayKnowRecommend))
          {
            localObject1 = (MayKnowRecommend)((RecentUser)localObject1).extraInfo;
            a(paramViewGroup, paramOnDragModeChangedListener, paramContext, paramRecentFaceDecoder, (MayKnowRecommend)localObject1);
            if (localObject1 != null) {
              if (((MayKnowRecommend)localObject1).friendStatus == 0)
              {
                paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
                paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
                paramView.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131689589));
                paramView.jdField_a_of_type_AndroidWidgetButton.setTag(localObject1);
                paramRecentFaceDecoder = paramContext.getResources().getColorStateList(2131167091);
                if (paramRecentFaceDecoder != null) {
                  paramView.jdField_a_of_type_AndroidWidgetButton.setTextColor(paramRecentFaceDecoder);
                }
                paramView.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839314);
                paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
                if (AppSetting.d) {
                  paramView.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131689589));
                }
              }
              else if (((MayKnowRecommend)localObject1).friendStatus == 1)
              {
                paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
                paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131718222);
                if (AppSetting.d) {
                  paramView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131713126));
                }
              }
              else
              {
                paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
                paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131689988);
                if (AppSetting.d) {
                  paramView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131713125));
                }
              }
            }
          }
          else
          {
            a(paramViewGroup, paramOnDragModeChangedListener, paramContext, paramRecentFaceDecoder);
          }
        }
      }
    }
    else
    {
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramView.c.setText("");
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
      if ((i & 0xF) == 1) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      if ((paramView.getTag() instanceof RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)) {
        localObject1 = (RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)paramView.getTag();
      } else {
        localObject1 = null;
      }
      if (localObject1 == null)
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
      int i;
      if (a(paramRecentBaseData))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("bindview user:");
          ((StringBuilder)localObject2).append(paramRecentBaseData.getRecentUserUin());
          QLog.i("RecentMayKnowFriendVerticalListItemBuilder", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = ((BaseActivity)paramContext).app;
        i = ((Integer)RecentFaceDecoder.a((QQAppInterface)localObject2, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin()).first).intValue();
        if (i == 103) {
          i = 1;
        }
        RecentDynamicAvatarView localRecentDynamicAvatarView = ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
        String str = paramRecentBaseData.getRecentUserUin();
        boolean bool;
        if (((QQAppInterface)localObject2).mAutomator.a() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        localRecentDynamicAvatarView.setFaceDrawable((AppInterface)localObject2, paramDrawable, i, str, 100, false, bool, 0);
      }
      else
      {
        ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
      }
      a(((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
      float f = DeviceInfoUtil.a();
      if (paramRecentBaseData.mAuthenIconId != 0)
      {
        ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(f * 3.0F));
        ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("bindView: item.authId=");
          paramContext.append(paramRecentBaseData.mAuthenIconId);
          QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, paramContext.toString());
        }
      }
      else if (a(paramRecentBaseData))
      {
        i = VipUtils.a(((BaseActivity)paramContext).app, paramRecentBaseData.getRecentUserUin(), false);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("bindView: vip=");
          paramContext.append(i);
          QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, paramContext.toString());
        }
        if (i == 3)
        {
          ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(f * 5.0F));
          ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847298);
        }
        else
        {
          ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: drawable is null");
        }
        ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      }
      paramContext = paramRecentBaseData.mExtraInfo;
      if (paramContext != null) {
        paramContext = paramContext.toString();
      } else {
        paramContext = "";
      }
      ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramContext, 2);
      ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
      ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
      if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
        ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleNameCs);
      }
      ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
      try
      {
        ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).c.setText(paramRecentBaseData.mLastMsg);
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      paramContext = (INewFriendApi)QRoute.api(INewFriendApi.class);
      paramDrawable = ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView;
      Object localObject1 = (RecentItemMayKnowFriendVerticalListData)paramRecentBaseData;
      paramContext.showGenderAge(paramDrawable, ((RecentItemMayKnowFriendVerticalListData)localObject1).gender, ((RecentItemMayKnowFriendVerticalListData)localObject1).age, null);
      if (AppSetting.d) {
        paramView.setContentDescription(paramRecentBaseData.mContentDesc);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "bindView|param invalidate");
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable, MayKnowRecommend paramMayKnowRecommend)
  {
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder localRecentMayKnowFriendVerticalListItemBuilderHolder;
      if ((paramView.getTag() instanceof RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)) {
        localRecentMayKnowFriendVerticalListItemBuilderHolder = (RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)paramView.getTag();
      } else {
        localRecentMayKnowFriendVerticalListItemBuilderHolder = null;
      }
      if (localRecentMayKnowFriendVerticalListItemBuilderHolder == null)
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
      int i;
      if (a(paramRecentBaseData))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("bindview user:");
          ((StringBuilder)localObject).append(paramRecentBaseData.getRecentUserUin());
          QLog.i("RecentMayKnowFriendVerticalListItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = ((BaseActivity)paramContext).app;
        i = ((Integer)RecentFaceDecoder.a((QQAppInterface)localObject, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin()).first).intValue();
        if (i == 103) {
          i = 1;
        }
        RecentDynamicAvatarView localRecentDynamicAvatarView = localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
        String str = paramRecentBaseData.getRecentUserUin();
        boolean bool;
        if (((QQAppInterface)localObject).mAutomator.a() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        localRecentDynamicAvatarView.setFaceDrawable((AppInterface)localObject, paramDrawable, i, str, 100, false, bool, 0);
      }
      else
      {
        localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
      }
      a(localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
      float f = DeviceInfoUtil.a();
      if (paramRecentBaseData.mAuthenIconId != 0)
      {
        localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(f * 3.0F));
        localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("bindView: item.authId=");
          paramContext.append(paramRecentBaseData.mAuthenIconId);
          QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, paramContext.toString());
        }
      }
      else if (a(paramRecentBaseData))
      {
        i = VipUtils.a(((BaseActivity)paramContext).app, paramRecentBaseData.getRecentUserUin(), false);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("bindView: vip=");
          paramContext.append(i);
          QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, paramContext.toString());
        }
        if (i == 3)
        {
          localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(f * 5.0F));
          localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847298);
        }
        else
        {
          localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: drawable is null");
        }
        localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      }
      paramContext = paramRecentBaseData.mExtraInfo;
      if (paramContext != null) {
        paramContext = paramContext.toString();
      } else {
        paramContext = "";
      }
      localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramContext, 2);
      localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
      localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
      if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
        localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleNameCs);
      }
      localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
      try
      {
        localRecentMayKnowFriendVerticalListItemBuilderHolder.e.setText(paramRecentBaseData.mLastMsg);
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      localRecentMayKnowFriendVerticalListItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(RecommendLabel.convertToRecommendLabel(paramMayKnowRecommend.msgLabel), paramMayKnowRecommend.gender, paramMayKnowRecommend.age);
      if (AppSetting.d) {
        paramView.setContentDescription(paramRecentBaseData.mContentDesc);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "bindView|param invalidate");
    }
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.getRecentUserType();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentMayKnowFriendVerticalListItemBuilder
 * JD-Core Version:    0.7.0.1
 */