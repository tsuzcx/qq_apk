package com.tencent.mobileqq.activity.contacts.device;

import QQService.EVIPSPEC;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.widget.SingleLineTextView;

public class BuddyListDevices
  extends BuddyListFriends
{
  public BuddyListDevices(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.b = 0;
  }
  
  private void a(ImageView paramImageView)
  {
    Object localObject = ((IRedTouchManager)this.d.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("100701.100702");
    if (localObject == null) {
      return;
    }
    if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0) {
      return;
    }
    localObject = (FrameLayout.LayoutParams)paramImageView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = ((int)DisplayUtils.a(this.e, 9.0F));
    ((FrameLayout.LayoutParams)localObject).height = ((int)DisplayUtils.a(this.e, 9.0F));
    ((FrameLayout.LayoutParams)localObject).topMargin = ((int)DisplayUtils.a(this.e, 11.0F));
    paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramImageView.setVisibility(0);
    paramImageView.setBackgroundResource(2130852588);
    paramImageView = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enable_public_device_");
    ((StringBuilder)localObject).append(this.d.getCurrentAccountUin());
    paramImageView.putBoolean(((StringBuilder)localObject).toString(), true).commit();
  }
  
  @TargetApi(11)
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject1;
    if ((paramView != null) && ((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) && ((!(paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) || (!((BuddyListFriends.BuddyChildTag)paramView.getTag()).m)))
    {
      localObject1 = (BuddyListFriends.BuddyChildTag)paramView.getTag();
      ((BuddyListFriends.BuddyChildTag)localObject1).a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      ((BuddyListFriends.BuddyChildTag)localObject1).b.setCompoundDrawables(null, null);
      paramOnClickListener = paramView;
    }
    else
    {
      paramOnClickListener = LayoutInflater.from(this.e).inflate(2131624553, paramViewGroup, false);
      localObject1 = ((FriendItemLayout)paramOnClickListener).a();
      paramOnClickListener.setTag(localObject1);
      a(paramOnClickListener.findViewById(2131435219));
    }
    paramView = (FrameLayout.LayoutParams)((BuddyListFriends.BuddyChildTag)localObject1).i.getLayoutParams();
    paramView.leftMargin = AIOUtils.b(68.0F, this.e.getResources());
    ((BuddyListFriends.BuddyChildTag)localObject1).i.setLayoutParams(paramView);
    paramView = (FrameLayout.LayoutParams)((BuddyListFriends.BuddyChildTag)localObject1).d.getLayoutParams();
    paramView.leftMargin = AIOUtils.b(68.0F, this.e.getResources());
    ((BuddyListFriends.BuddyChildTag)localObject1).d.setLayoutParams(paramView);
    paramView = (FrameLayout.LayoutParams)((BuddyListFriends.BuddyChildTag)localObject1).r.getLayoutParams();
    paramView.leftMargin = AIOUtils.b(16.0F, this.e.getResources());
    ((BuddyListFriends.BuddyChildTag)localObject1).r.setLayoutParams(paramView);
    ((BuddyListFriends.BuddyChildTag)localObject1).c = this.m;
    ((BuddyListFriends.BuddyChildTag)localObject1).p = this.m.uin;
    ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(0);
    if (!AppConstants.SMARTDEVICE_SEARCH_UIN.equals(this.m.uin))
    {
      paramView = (FrameLayout.LayoutParams)((BuddyListFriends.BuddyChildTag)localObject1).h.getLayoutParams();
      paramView.width = ((int)DisplayUtils.a(this.e, 16.0F));
      paramView.height = ((int)DisplayUtils.a(this.e, 16.0F));
      paramView.topMargin = ((int)DisplayUtils.a(this.e, 8.5F));
      ((BuddyListFriends.BuddyChildTag)localObject1).h.setLayoutParams(paramView);
    }
    boolean bool = AppConstants.DATALINE_PC_UIN.equals(this.m.uin);
    paramInt1 = 2131916781;
    if (bool)
    {
      ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(0);
      if (this.m.status == 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramView = this.e;
      if (paramInt2 == 0) {
        paramInt1 = 2131916782;
      }
      paramViewGroup = paramView.getString(paramInt1);
      paramView = ((BuddyListFriends.BuddyChildTag)localObject1).d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(paramViewGroup);
      ((StringBuilder)localObject2).append("]");
      paramView.setText(((StringBuilder)localObject2).toString());
      localObject2 = ((BuddyListFriends.BuddyChildTag)localObject1).r;
      if (paramInt2 != 0) {
        paramView = g();
      } else {
        paramView = null;
      }
      ((ImageView)localObject2).setImageDrawable(paramView);
      localObject2 = this.e.getString(2131888329);
      ((BuddyListFriends.BuddyChildTag)localObject1).b.setText((CharSequence)localObject2);
      ((BuddyListFriends.BuddyChildTag)localObject1).b.setExtendText("", 1);
      ((BuddyListFriends.BuddyChildTag)localObject1).h.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).f.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).g.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).a.setTextColor(a(this.e, 2131168001));
      paramView = paramViewGroup;
      paramViewGroup = (ViewGroup)localObject2;
    }
    else if (AppConstants.DATALINE_IPAD_UIN.equals(this.m.uin))
    {
      ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(0);
      if (this.m.status == 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramView = this.e;
      if (paramInt2 == 0) {
        paramInt1 = 2131916782;
      }
      paramViewGroup = paramView.getString(paramInt1);
      paramView = ((BuddyListFriends.BuddyChildTag)localObject1).d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(paramViewGroup);
      ((StringBuilder)localObject2).append("]");
      paramView.setText(((StringBuilder)localObject2).toString());
      localObject2 = ((BuddyListFriends.BuddyChildTag)localObject1).r;
      if (paramInt2 != 0) {
        paramView = g();
      } else {
        paramView = null;
      }
      ((ImageView)localObject2).setImageDrawable(paramView);
      localObject2 = this.e.getString(2131888330);
      ((BuddyListFriends.BuddyChildTag)localObject1).b.setText((CharSequence)localObject2);
      ((BuddyListFriends.BuddyChildTag)localObject1).b.setExtendText("", 1);
      ((BuddyListFriends.BuddyChildTag)localObject1).h.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).f.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).g.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).a.setTextColor(a(this.e, 2131168001));
      paramView = paramViewGroup;
      paramViewGroup = (ViewGroup)localObject2;
    }
    else
    {
      if (this.m.uin.equals(QFileAssistantUtils.b(this.d)))
      {
        paramViewGroup = this.e.getString(2131896188);
        ((BuddyListFriends.BuddyChildTag)localObject1).b.setText(paramViewGroup);
        ((BuddyListFriends.BuddyChildTag)localObject1).b.setExtendText("", 1);
        ((BuddyListFriends.BuddyChildTag)localObject1).h.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).f.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).g.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).a.setTextColor(a(this.e, 2131168001));
      }
      for (;;)
      {
        paramView = null;
        break label1548;
        if (AppConstants.SMARTDEVICE_UIN.equals(this.m.uin))
        {
          if (this.m.status == 0) {
            paramInt2 = 1;
          } else {
            paramInt2 = 0;
          }
          if (this.m.status == 11)
          {
            ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).d.setText("");
            paramView = null;
            paramInt2 = 0;
          }
          else if (this.m.status == 12)
          {
            ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(0);
            paramView = this.e.getString(2131896218);
            paramViewGroup = ((BuddyListFriends.BuddyChildTag)localObject1).d;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(paramView);
            ((StringBuilder)localObject2).append("]");
            paramViewGroup.setText(((StringBuilder)localObject2).toString());
          }
          else
          {
            ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(0);
            paramView = this.e;
            if (paramInt2 == 0) {
              paramInt1 = 2131916782;
            }
            paramView = paramView.getString(paramInt1);
            paramViewGroup = ((BuddyListFriends.BuddyChildTag)localObject1).d;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(paramView);
            ((StringBuilder)localObject2).append("]");
            paramViewGroup.setText(((StringBuilder)localObject2).toString());
          }
          localObject2 = ((BuddyListFriends.BuddyChildTag)localObject1).r;
          if (paramInt2 != 0) {
            paramViewGroup = g();
          } else {
            paramViewGroup = null;
          }
          ((ImageView)localObject2).setImageDrawable(paramViewGroup);
          paramViewGroup = this.e.getString(2131916699);
          ((BuddyListFriends.BuddyChildTag)localObject1).b.setText(paramViewGroup);
          ((BuddyListFriends.BuddyChildTag)localObject1).b.setExtendText("", 1);
          ((BuddyListFriends.BuddyChildTag)localObject1).h.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).f.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).g.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).a.setTextColor(a(this.e, 2131168001));
          break label1548;
        }
        if (AppConstants.DATALINE_PRINTER_UIN.equals(this.m.uin))
        {
          ((BuddyListFriends.BuddyChildTag)localObject1).d.setText("");
          ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).r.setImageDrawable(null);
          paramViewGroup = this.e.getString(2131888328);
          ((BuddyListFriends.BuddyChildTag)localObject1).b.setText(paramViewGroup);
          ((BuddyListFriends.BuddyChildTag)localObject1).b.setExtendText("", 1);
          ((BuddyListFriends.BuddyChildTag)localObject1).h.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).f.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).g.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).a.setTextColor(a(this.e, 2131168001));
        }
        else
        {
          if (!AppConstants.SMARTDEVICE_SEARCH_UIN.equals(this.m.uin)) {
            break;
          }
          ((BuddyListFriends.BuddyChildTag)localObject1).d.setText("");
          ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).r.setImageDrawable(null);
          paramViewGroup = this.e.getString(2131888326);
          ((BuddyListFriends.BuddyChildTag)localObject1).b.setText(paramViewGroup);
          ((BuddyListFriends.BuddyChildTag)localObject1).b.setExtendText("", 1);
          ((BuddyListFriends.BuddyChildTag)localObject1).f.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).g.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).h.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).a.setTextColor(a(this.e, 2131168001));
          a(((BuddyListFriends.BuddyChildTag)localObject1).h);
        }
      }
      paramViewGroup = null;
      paramView = paramViewGroup;
    }
    label1548:
    Object localObject2 = this.m.getFriendNickWithAlias();
    ((BuddyListFriends.BuddyChildTag)localObject1).a.setText((CharSequence)localObject2);
    ((BuddyListFriends.BuddyChildTag)localObject1).b.setVisibility(0);
    if (AppSetting.e)
    {
      localObject1 = ((BuddyListFriends.BuddyChildTag)localObject1).l;
      if (localObject1 == null) {
        localObject1 = new StringBuilder(24);
      } else {
        ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
      }
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(".");
      if (!TextUtils.isEmpty(paramView))
      {
        ((StringBuilder)localObject1).append(paramView);
        ((StringBuilder)localObject1).append(".");
      }
      if ((this.m.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.m.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))
      {
        ((StringBuilder)localObject1).append("QQ会员");
        ((StringBuilder)localObject1).append(".");
      }
      if (!TextUtils.isEmpty(paramViewGroup))
      {
        ((StringBuilder)localObject1).append(paramViewGroup);
        ((StringBuilder)localObject1).append(".");
      }
      if (!TextUtils.isEmpty("")) {
        ((StringBuilder)localObject1).append("");
      }
      paramOnClickListener.setContentDescription((CharSequence)localObject1);
    }
    paramView = (SmartDeviceProxyMgr)this.d.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if (paramView != null)
    {
      paramViewGroup = paramView.l();
      if ((!TextUtils.isEmpty(paramViewGroup)) && (this.m.name.equals(paramViewGroup)))
      {
        if (paramOnClickListener.getAnimation() != null)
        {
          paramView = paramOnClickListener.getAnimation();
          paramView.cancel();
          paramView.reset();
          paramView.startNow();
          return paramOnClickListener;
        }
        paramOnClickListener.setBackgroundResource(2130839781);
        paramViewGroup = new ScaleAnimation(0.8F, 1.2F, 0.8F, 1.2F, 1, 0.5F, 1, 0.5F);
        paramViewGroup.setDuration(1000L);
        paramViewGroup.setRepeatCount(3);
        paramViewGroup.setInterpolator(new DecelerateInterpolator());
        paramViewGroup.setRepeatMode(2);
        paramViewGroup.setFillAfter(false);
        paramViewGroup.startNow();
        paramViewGroup.setAnimationListener(new BuddyListDevices.1(this, paramView, paramOnClickListener));
        paramOnClickListener.setAnimation(paramViewGroup);
        return paramOnClickListener;
      }
      paramOnClickListener.setBackgroundResource(2130839577);
      paramOnClickListener.setAnimation(null);
    }
    return paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.BuddyListDevices
 * JD-Core Version:    0.7.0.1
 */