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
  protected int a = 2131629167;
  View.OnTouchListener b = new RecentMayKnowFriendVerticalListItemBuilder.1(this);
  private List<String> h;
  
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
      paramViewGroup = a(paramContext, this.a, paramView);
      paramView.a = ((RecentDynamicAvatarView)paramViewGroup.findViewById(2131427337));
      paramView.b = ((SingleLineTextView)paramViewGroup.findViewById(2131439320));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131444726));
      paramView.e = ((TextView)paramViewGroup.findViewById(2131427898));
      paramView.f = ((TextView)paramViewGroup.findViewById(2131444728));
      paramView.c = ((Button)paramViewGroup.findViewById(2131444718));
      paramView.g = ((TextView)paramViewGroup.findViewById(2131444456));
      paramView.h = ((RelativeLayout)paramViewGroup.findViewById(2131444468));
      paramView.i = ((RelativeLayout)paramViewGroup.findViewById(2131444457));
      paramView.j = ((TroopLabelLayout)paramViewGroup.findViewById(2131448010));
      paramView.j.setLabelType(1);
      paramView.k = ((TextView)paramViewGroup.findViewById(2131438023));
      Object localObject2 = paramContext.getResources();
      float f = DeviceInfoUtil.A();
      paramOnDragModeChangedListener = ((Resources)localObject2).getColorStateList(2131168122);
      localObject1 = ((Resources)localObject2).getColorStateList(2131168001);
      localObject2 = ((Resources)localObject2).getColorStateList(2131168123);
      paramView.b.setTextColor((ColorStateList)localObject1);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramView.b.setExtendTextColor((ColorStateList)localObject2, 0);
      } else {
        paramView.b.setExtendTextColor(paramOnDragModeChangedListener, 0);
      }
      paramView.b.setExtendTextSize(12.0F, 0);
      paramView.b.setCompoundDrawablePadding((int)(3.0F * f));
      paramView.b.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
      paramView.b.setExtendTextPadding((int)(f * 5.0F), 2);
      paramView.b.setExtendTextColor(paramOnDragModeChangedListener, 2);
      paramView.b.setExtendTextSize(17.0F, 2);
      paramViewGroup.setTag(paramView);
    }
    Object localObject1 = paramContext.getResources();
    paramOnDragModeChangedListener = ((Resources)localObject1).getColorStateList(2131168122);
    localObject1 = ((Resources)localObject1).getColorStateList(2131168123);
    if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
      paramView.b.setExtendTextColor((ColorStateList)localObject1, 0);
    } else {
      paramView.b.setExtendTextColor(paramOnDragModeChangedListener, 0);
    }
    paramView.g.setOnClickListener(paramOnClickListener);
    paramView.g.setTag(-1, Integer.valueOf(paramInt));
    paramView.g.setOnTouchListener(this.b);
    paramView.i.setOnClickListener(paramOnClickListener);
    paramView.i.setTag(-1, Integer.valueOf(paramInt));
    paramView.c.setOnClickListener(paramOnClickListener);
    paramView.c.setTag(-1, Integer.valueOf(paramInt));
    if (AppSetting.e) {
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
          paramView.h.setVisibility(0);
          paramView.i.setVisibility(8);
        }
        else
        {
          paramView.h.setVisibility(8);
          paramView.i.setVisibility(0);
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
                paramView.c.setOnClickListener(paramOnClickListener);
                paramView.c.setVisibility(0);
                paramView.c.setText(HardCodeUtil.a(2131886199));
                paramView.c.setTag(localObject1);
                paramRecentFaceDecoder = paramContext.getResources().getColorStateList(2131168043);
                if (paramRecentFaceDecoder != null) {
                  paramView.c.setTextColor(paramRecentFaceDecoder);
                }
                paramView.c.setBackgroundResource(2130839494);
                paramView.d.setVisibility(8);
                if (AppSetting.e) {
                  paramView.c.setContentDescription(HardCodeUtil.a(2131886199));
                }
              }
              else if (((MayKnowRecommend)localObject1).friendStatus == 1)
              {
                paramView.c.setVisibility(8);
                paramView.d.setVisibility(0);
                paramView.d.setText(2131915704);
                if (AppSetting.e) {
                  paramView.d.setContentDescription(HardCodeUtil.a(2131910685));
                }
              }
              else
              {
                paramView.c.setVisibility(8);
                paramView.d.setVisibility(0);
                paramView.d.setText(2131886630);
                if (AppSetting.e) {
                  paramView.d.setContentDescription(HardCodeUtil.a(2131910684));
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
      paramView.b.setText("");
      paramView.f.setText("");
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
      paramContext = this.h;
      if (paramContext == null) {
        this.h = new ArrayList();
      } else {
        paramContext.clear();
      }
      if ((i & 0xF) == 1) {
        this.h.add(paramRecentBaseData.getString(c[0]));
      }
      return this.h;
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
        RecentDynamicAvatarView localRecentDynamicAvatarView = ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).a;
        String str = paramRecentBaseData.getRecentUserUin();
        boolean bool;
        if (((QQAppInterface)localObject2).mAutomator.f() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        localRecentDynamicAvatarView.setFaceDrawable((AppInterface)localObject2, paramDrawable, i, str, 100, false, bool, 0);
      }
      else
      {
        ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).a.setImageDrawable(paramDrawable);
      }
      a(((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).a);
      float f = DeviceInfoUtil.A();
      if (paramRecentBaseData.mAuthenIconId != 0)
      {
        ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).b.setCompoundDrawablePadding((int)(f * 3.0F));
        ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).b.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
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
          ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).b.setCompoundDrawablePadding((int)(f * 5.0F));
          ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).b.setCompoundDrawablesWithIntrinsicBounds(0, 2130848949);
        }
        else
        {
          ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).b.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: drawable is null");
        }
        ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).b.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      }
      paramContext = paramRecentBaseData.mExtraInfo;
      if (paramContext != null) {
        paramContext = paramContext.toString();
      } else {
        paramContext = "";
      }
      ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).b.setExtendText(paramContext, 2);
      ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).b.setExtendText(paramRecentBaseData.mShowTime, 0);
      ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).b.setText(paramRecentBaseData.mTitleName);
      if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
        ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).b.setText(paramRecentBaseData.mTitleNameCs);
      }
      ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).b.setIconDrawablesWithIntrinsicBounds(null);
      try
      {
        ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).f.setText(paramRecentBaseData.mLastMsg);
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      paramContext = (INewFriendApi)QRoute.api(INewFriendApi.class);
      paramDrawable = ((RecentMayKnowFriendVerticalListItemBuilder.RecentMayKnowFriendVerticalListItemBuilderHolder)localObject1).e;
      Object localObject1 = (RecentItemMayKnowFriendVerticalListData)paramRecentBaseData;
      paramContext.showGenderAge(paramDrawable, ((RecentItemMayKnowFriendVerticalListData)localObject1).gender, ((RecentItemMayKnowFriendVerticalListData)localObject1).age, null);
      if (AppSetting.e) {
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
        RecentDynamicAvatarView localRecentDynamicAvatarView = localRecentMayKnowFriendVerticalListItemBuilderHolder.a;
        String str = paramRecentBaseData.getRecentUserUin();
        boolean bool;
        if (((QQAppInterface)localObject).mAutomator.f() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        localRecentDynamicAvatarView.setFaceDrawable((AppInterface)localObject, paramDrawable, i, str, 100, false, bool, 0);
      }
      else
      {
        localRecentMayKnowFriendVerticalListItemBuilderHolder.a.setImageDrawable(paramDrawable);
      }
      a(localRecentMayKnowFriendVerticalListItemBuilderHolder.a);
      float f = DeviceInfoUtil.A();
      if (paramRecentBaseData.mAuthenIconId != 0)
      {
        localRecentMayKnowFriendVerticalListItemBuilderHolder.b.setCompoundDrawablePadding((int)(f * 3.0F));
        localRecentMayKnowFriendVerticalListItemBuilderHolder.b.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
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
          localRecentMayKnowFriendVerticalListItemBuilderHolder.b.setCompoundDrawablePadding((int)(f * 5.0F));
          localRecentMayKnowFriendVerticalListItemBuilderHolder.b.setCompoundDrawablesWithIntrinsicBounds(0, 2130848949);
        }
        else
        {
          localRecentMayKnowFriendVerticalListItemBuilderHolder.b.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: drawable is null");
        }
        localRecentMayKnowFriendVerticalListItemBuilderHolder.b.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      }
      paramContext = paramRecentBaseData.mExtraInfo;
      if (paramContext != null) {
        paramContext = paramContext.toString();
      } else {
        paramContext = "";
      }
      localRecentMayKnowFriendVerticalListItemBuilderHolder.b.setExtendText(paramContext, 2);
      localRecentMayKnowFriendVerticalListItemBuilderHolder.b.setExtendText(paramRecentBaseData.mShowTime, 0);
      localRecentMayKnowFriendVerticalListItemBuilderHolder.b.setText(paramRecentBaseData.mTitleName);
      if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
        localRecentMayKnowFriendVerticalListItemBuilderHolder.b.setText(paramRecentBaseData.mTitleNameCs);
      }
      localRecentMayKnowFriendVerticalListItemBuilderHolder.b.setIconDrawablesWithIntrinsicBounds(null);
      try
      {
        localRecentMayKnowFriendVerticalListItemBuilderHolder.k.setText(paramRecentBaseData.mLastMsg);
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      localRecentMayKnowFriendVerticalListItemBuilderHolder.j.a(RecommendLabel.convertToRecommendLabel(paramMayKnowRecommend.msgLabel), paramMayKnowRecommend.gender, paramMayKnowRecommend.age);
      if (AppSetting.e) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentMayKnowFriendVerticalListItemBuilder
 * JD-Core Version:    0.7.0.1
 */