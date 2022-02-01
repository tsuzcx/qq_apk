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
import com.tencent.common.app.AppInterface;
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
  protected int a = 2131625376;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnLongClickListener = null;
    if ((paramView != null) && ((paramView.getTag() instanceof MiniMsgTabAdapter.RecentItemBuilderHolder)))
    {
      paramViewGroup = (MiniMsgTabAdapter.RecentItemBuilderHolder)paramView.getTag();
    }
    else
    {
      paramViewGroup = new MiniMsgTabAdapter.RecentItemBuilderHolder();
      paramView = LayoutInflater.from(paramContext).inflate(this.a, null);
      paramViewGroup.a = ((RecentDynamicAvatarView)paramView.findViewById(2131435219));
      paramViewGroup.c = ((DragTextView)paramView.findViewById(2131449128));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131447463));
      paramViewGroup.d = ((SingleLineTextView)paramView.findViewById(2131431757));
      paramViewGroup.d.setGravity(16);
      paramContext.getResources();
      float f = DeviceInfoUtil.A();
      paramViewGroup.b.setTextColor(paramContext.getResources().getColor(2131166495));
      paramViewGroup.b.setExtendTextColor(ColorStateList.valueOf(paramContext.getResources().getColor(2131166494)), 0);
      paramViewGroup.b.setExtendTextSize(12.0F, 0);
      paramViewGroup.b.setCompoundDrawablePadding((int)(3.0F * f));
      paramOnDragModeChangedListener = paramViewGroup.b;
      int i = (int)(2.0F * f);
      paramOnDragModeChangedListener.setIconDrawablePadding(i, (int)(1.0F * f));
      paramViewGroup.b.setExtendTextPadding((int)(f * 5.0F), 2);
      paramViewGroup.b.setExtendTextColor(ColorStateList.valueOf(paramContext.getResources().getColor(2131166494)), 2);
      paramViewGroup.b.setExtendTextSize(17.0F, 2);
      paramViewGroup.d.setTextColor(paramContext.getResources().getColor(2131166494));
      paramViewGroup.d.setExtendTextPadding(i, 1);
      paramViewGroup.d.setExtendTextSize(14.0F, 1);
      paramView.setTag(paramViewGroup);
    }
    paramViewGroup.c.setTag(Integer.valueOf(paramInt));
    paramView.setOnClickListener(paramOnClickListener);
    if ((paramObject instanceof RecentBaseData))
    {
      paramViewGroup = (RecentBaseData)paramObject;
      paramObject = paramOnLongClickListener;
      if (paramRecentFaceDecoder != null) {
        paramObject = paramRecentFaceDecoder.a(paramViewGroup);
      }
      a(paramView, paramViewGroup, paramContext, paramObject);
    }
    else
    {
      paramViewGroup.b.setText("");
      paramViewGroup.d.setText("");
      paramViewGroup.c.setVisibility(4);
    }
    paramView.setTag(-1, Integer.valueOf(paramInt));
    return paramView;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      MiniMsgTabAdapter.RecentItemBuilderHolder localRecentItemBuilderHolder;
      if ((paramView.getTag() instanceof MiniMsgTabAdapter.RecentItemBuilderHolder)) {
        localRecentItemBuilderHolder = (MiniMsgTabAdapter.RecentItemBuilderHolder)paramView.getTag();
      } else {
        localRecentItemBuilderHolder = null;
      }
      if (localRecentItemBuilderHolder == null)
      {
        if (QLog.isColorLevel())
        {
          paramRecentBaseData = new StringBuilder();
          paramRecentBaseData.append("bindView|holder is null, tag = ");
          paramRecentBaseData.append(paramView.getTag());
          QLog.i("MiniMsgTabDafultItemBulder", 2, paramRecentBaseData.toString());
        }
        return;
      }
      String str = paramRecentBaseData.getRecentUserUin();
      int j = paramRecentBaseData.getRecentUserType();
      boolean bool2 = a(paramRecentBaseData);
      Object localObject;
      if (bool2)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("bindview user:");
          ((StringBuilder)localObject).append(str);
          QLog.i("MiniMsgTabDafultItemBulder", 2, ((StringBuilder)localObject).toString());
        }
        localObject = ((BaseActivity)paramContext).app;
        i = ((Integer)RecentFaceDecoder.a((QQAppInterface)localObject, j, str).first).intValue();
        if (i == 103) {
          i = 1;
        }
        RecentDynamicAvatarView localRecentDynamicAvatarView = localRecentItemBuilderHolder.a;
        boolean bool1;
        if (((QQAppInterface)localObject).mAutomator.f() == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localRecentDynamicAvatarView.setFaceDrawable((AppInterface)localObject, paramDrawable, i, str, 100, false, bool1, 0);
      }
      else
      {
        localRecentItemBuilderHolder.a.setImageDrawable(paramDrawable);
      }
      float f = DeviceInfoUtil.A();
      if (paramRecentBaseData.mAuthenIconId != 0)
      {
        localRecentItemBuilderHolder.b.setCompoundDrawablePadding((int)(3.0F * f));
        localRecentItemBuilderHolder.b.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
        if (QLog.isColorLevel())
        {
          paramDrawable = new StringBuilder();
          paramDrawable.append("bindView: item.authId=");
          paramDrawable.append(paramRecentBaseData.mAuthenIconId);
          QLog.d("MiniMsgTabDafultItemBulder", 2, paramDrawable.toString());
        }
      }
      else if (bool2)
      {
        i = VipUtils.a(((BaseActivity)paramContext).app, str, false);
        if (QLog.isColorLevel())
        {
          paramDrawable = new StringBuilder();
          paramDrawable.append("bindView: vip=");
          paramDrawable.append(i);
          QLog.d("MiniMsgTabDafultItemBulder", 2, paramDrawable.toString());
        }
        if (i == 3)
        {
          localRecentItemBuilderHolder.b.setCompoundDrawablePadding((int)(5.0F * f));
          localRecentItemBuilderHolder.b.setCompoundDrawablesWithIntrinsicBounds(0, 2130848949);
        }
        else
        {
          localRecentItemBuilderHolder.b.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniMsgTabDafultItemBulder", 2, "bindView: drawable is null");
        }
        localRecentItemBuilderHolder.b.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      }
      paramDrawable = paramRecentBaseData.mExtraInfo;
      str = "";
      if (paramDrawable != null) {
        paramDrawable = paramDrawable.toString();
      } else {
        paramDrawable = "";
      }
      localRecentItemBuilderHolder.b.setExtendText(paramDrawable, 2);
      localRecentItemBuilderHolder.b.setExtendText(paramRecentBaseData.mShowTime, 0);
      localRecentItemBuilderHolder.b.setText(paramRecentBaseData.mTitleName);
      if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
        localRecentItemBuilderHolder.b.setText(paramRecentBaseData.mTitleNameCs);
      }
      if ((j == 0) && ((paramRecentBaseData instanceof RecentItemChatMsgData)))
      {
        paramDrawable = (RecentItemChatMsgData)paramRecentBaseData;
        paramContext = ((BaseActivity)paramContext).app;
        localObject = MutualMarkDataCenter.a(paramContext, paramDrawable.mUser.uin, false, 5);
        paramContext = MutualMarkDataCenter.a(paramContext, paramDrawable.mUser.uin, (ArrayList)localObject);
        localRecentItemBuilderHolder.b.setIconDrawablesWithIntrinsicBounds(paramContext);
        localRecentItemBuilderHolder.b.setIconDrawablePadding(0, (int)(f * 1.0F));
      }
      else if ((j == 1) && ((paramRecentBaseData instanceof RecentItemTroopMsgData)))
      {
        paramDrawable = (RecentItemTroopMsgData)paramRecentBaseData;
        paramContext = RecentTroopIconUtil.a(((BaseActivity)paramContext).app, paramDrawable);
        localRecentItemBuilderHolder.b.setIconDrawablesWithIntrinsicBounds(paramContext);
        localRecentItemBuilderHolder.b.setIconDrawablePadding(0, (int)(f * 1.0F));
      }
      else
      {
        localRecentItemBuilderHolder.b.setIconDrawablesWithIntrinsicBounds(null);
        localRecentItemBuilderHolder.b.setIconDrawablePadding((int)(2.0F * f), (int)(f * 1.0F));
      }
      j = paramRecentBaseData.mStatus;
      int i = 2130843134;
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            if (j != 4) {
              if (j != 5)
              {
                i = 0;
                break label815;
              }
            }
          }
          while (!paramRecentBaseData.mIsGroupVideo)
          {
            i = 2130843135;
            break;
            i = 2130839732;
            break;
          }
        }
        else if (paramRecentBaseData.mIsGroupVideo) {}
      }
      else {
        i = 2130843124;
      }
      label815:
      localRecentItemBuilderHolder.d.setCompoundDrawablesWithIntrinsicBounds(i, 0);
      i = paramRecentBaseData.mExtraInfoColor;
      paramDrawable = paramRecentBaseData.mMsgExtroInfo;
      paramContext = str;
      if (paramDrawable != null) {
        paramContext = paramDrawable.toString();
      }
      paramDrawable = paramContext;
      if (paramContext != null)
      {
        paramDrawable = paramContext;
        if (paramContext.length() > 0)
        {
          paramDrawable = paramContext;
          if (!paramContext.endsWith(" "))
          {
            paramDrawable = new StringBuilder();
            paramDrawable.append(paramContext);
            paramDrawable.append(" ");
            paramDrawable = paramDrawable.toString();
          }
        }
      }
      if ((!TextUtils.isEmpty(paramDrawable)) && (i != 0)) {
        localRecentItemBuilderHolder.d.setExtendTextColor(ColorStateList.valueOf(i), 1);
      }
      localRecentItemBuilderHolder.d.setExtendText(paramDrawable, 1);
      try
      {
        localRecentItemBuilderHolder.d.setText(paramRecentBaseData.mLastMsg);
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        paramContext = localRecentItemBuilderHolder.d;
        paramDrawable = new StringBuilder();
        paramDrawable.append(paramRecentBaseData.mLastMsg);
        paramDrawable.append(" ");
        paramContext.setText(paramDrawable.toString());
      }
      j = paramRecentBaseData.mUnreadNum;
      i = paramRecentBaseData.mUnreadFlag;
      if (j > 0) {
        if (i == 0)
        {
          localRecentItemBuilderHolder.c.setDragViewType(-1, paramView);
        }
        else
        {
          if (i == 2)
          {
            localRecentItemBuilderHolder.c.setDragViewType(-1, paramView);
            i = 1;
            break label1125;
          }
          if (i == 3)
          {
            localRecentItemBuilderHolder.c.setDragViewType(1, paramView);
            i = 3;
            k = 2130852596;
            break label1131;
          }
          localRecentItemBuilderHolder.c.setDragViewType(0, paramView);
          i = 3;
          k = 2130852592;
          break label1131;
        }
      }
      i = 0;
      label1125:
      j = 0;
      int k = 0;
      label1131:
      CustomWidgetUtil.a(localRecentItemBuilderHolder.c, i, j, k, 99, null);
      if (AppSetting.e) {
        paramView.setContentDescription(paramRecentBaseData.mContentDesc);
      }
      localRecentItemBuilderHolder.a.showTroopCreditStatus(paramRecentBaseData.getFaceExtraFlag());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniMsgTabDafultItemBulder", 2, "bindView|param invalidate");
    }
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.getRecentUserType();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008) || (i == 10010) || (i == 10013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabDafultItemBulder
 * JD-Core Version:    0.7.0.1
 */