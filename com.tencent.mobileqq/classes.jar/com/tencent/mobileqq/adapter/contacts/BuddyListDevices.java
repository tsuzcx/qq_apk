package com.tencent.mobileqq.adapter.contacts;

import QQService.EVIPSPEC;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.contact.FriendItemLayout;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.widget.SingleLineTextView;
import yoz;

public class BuddyListDevices
  extends BuddyListFriends
{
  private Drawable a;
  
  public BuddyListDevices(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130842403);
      label20:
      this.jdField_a_of_type_Int = 0;
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      break label20;
    }
  }
  
  private void a(ImageView paramImageView)
  {
    Object localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("100701.100702");
    if (localObject == null) {}
    while (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0) {
      return;
    }
    localObject = (FrameLayout.LayoutParams)paramImageView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    ((FrameLayout.LayoutParams)localObject).height = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    ((FrameLayout.LayoutParams)localObject).topMargin = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
    paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramImageView.setVisibility(0);
    paramImageView.setBackgroundResource(2130846133);
    BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("enable_public_device_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true).commit();
  }
  
  @TargetApi(11)
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject1;
    Object localObject2;
    if ((paramView == null) || (!(paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) || (((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) && (((BuddyListFriends.BuddyChildTag)paramView.getTag()).jdField_a_of_type_Boolean)))
    {
      paramOnClickListener = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968818, paramViewGroup, false);
      localObject1 = ((FriendItemLayout)paramOnClickListener).a();
      paramOnClickListener.setTag(localObject1);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      paramView = null;
      paramViewGroup = null;
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
      if (!AppConstants.x.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
      {
        localObject2 = (FrameLayout.LayoutParams)((BuddyListFriends.BuddyChildTag)localObject1).d.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject2).width = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 16.0F));
        ((FrameLayout.LayoutParams)localObject2).height = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 16.0F));
        ((FrameLayout.LayoutParams)localObject2).topMargin = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 8.5F));
        ((BuddyListFriends.BuddyChildTag)localObject1).d.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (!AppConstants.y.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin)) {
        break label683;
      }
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status != 0) {
        break label666;
      }
      paramInt1 = 1;
      label227:
      paramView = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt1 == 0) {
        break label671;
      }
      paramInt2 = 2131436044;
      label239:
      paramViewGroup = paramView.getString(paramInt2);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramViewGroup + "]");
      localObject2 = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      if (paramInt1 == 0) {
        break label678;
      }
      paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label295:
      ((ImageView)localObject2).setImageDrawable(paramView);
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131427534);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
      ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131494225));
    }
    for (;;)
    {
      label379:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
      if (AppSetting.b)
      {
        localObject1 = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_JavaLangStringBuilder;
        if (localObject1 != null) {
          break label1475;
        }
        localObject1 = new StringBuilder(24);
      }
      for (;;)
      {
        ((StringBuilder)localObject1).append((String)localObject2).append(".");
        if (!TextUtils.isEmpty(paramViewGroup)) {
          ((StringBuilder)localObject1).append(paramViewGroup).append(".");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
          ((StringBuilder)localObject1).append("QQ会员").append(".");
        }
        if (!TextUtils.isEmpty(paramView)) {
          ((StringBuilder)localObject1).append(paramView).append(".");
        }
        if (!TextUtils.isEmpty("")) {
          ((StringBuilder)localObject1).append("");
        }
        paramOnClickListener.setContentDescription((CharSequence)localObject1);
        paramView = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        if (paramView != null)
        {
          paramViewGroup = paramView.b();
          if ((TextUtils.isEmpty(paramViewGroup)) || (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.equals(paramViewGroup))) {
            break label1596;
          }
          if (paramOnClickListener.getAnimation() == null) {
            break label1490;
          }
          paramView = paramOnClickListener.getAnimation();
          paramView.cancel();
          paramView.reset();
          paramView.startNow();
        }
        return paramOnClickListener;
        localObject1 = (BuddyListFriends.BuddyChildTag)paramView.getTag();
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        paramOnClickListener = paramView;
        break;
        label666:
        paramInt1 = 0;
        break label227;
        label671:
        paramInt2 = 2131436042;
        break label239;
        label678:
        paramView = null;
        break label295;
        label683:
        if (AppConstants.z.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 0)
          {
            paramInt1 = 1;
            label720:
            paramView = this.jdField_a_of_type_AndroidContentContext;
            if (paramInt1 == 0) {
              break label881;
            }
            paramInt2 = 2131436044;
            label732:
            paramViewGroup = paramView.getString(paramInt2);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramViewGroup + "]");
            localObject2 = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_AndroidWidgetImageView;
            if (paramInt1 == 0) {
              break label888;
            }
          }
          label881:
          label888:
          for (paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;; paramView = null)
          {
            ((ImageView)localObject2).setImageDrawable(paramView);
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131427535);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
            ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131494225));
            break;
            paramInt1 = 0;
            break label720;
            paramInt2 = 2131436042;
            break label732;
          }
        }
        if (AppConstants.W.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 0)
          {
            paramInt1 = 1;
            label921:
            if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status != 11) {
              break label1067;
            }
            paramInt1 = 0;
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
            paramViewGroup = paramView;
            label958:
            localObject2 = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_AndroidWidgetImageView;
            if (paramInt1 == 0) {
              break label1207;
            }
          }
          label1067:
          label1207:
          for (paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;; paramView = null)
          {
            ((ImageView)localObject2).setImageDrawable(paramView);
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131427536);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
            ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131494225));
            break;
            paramInt1 = 0;
            break label921;
            if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 12)
            {
              ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
              paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getString(2131427537);
              ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramViewGroup + "]");
              break label958;
            }
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
            paramView = this.jdField_a_of_type_AndroidContentContext;
            if (paramInt1 != 0) {}
            for (paramInt2 = 2131436044;; paramInt2 = 2131436042)
            {
              paramViewGroup = paramView.getString(paramInt2);
              ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramViewGroup + "]");
              break;
            }
          }
        }
        if (AppConstants.A.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131427530);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
          ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131494225));
          break label379;
        }
        if (!AppConstants.x.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin)) {
          break label1613;
        }
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131427532);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131494225));
        a(((BuddyListFriends.BuddyChildTag)localObject1).d);
        break label379;
        label1475:
        ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
      }
      label1490:
      paramOnClickListener.setBackgroundResource(2130838743);
      paramViewGroup = new ScaleAnimation(0.8F, 1.2F, 0.8F, 1.2F, 1, 0.5F, 1, 0.5F);
      paramViewGroup.setDuration(1000L);
      paramViewGroup.setRepeatCount(3);
      paramViewGroup.setInterpolator(new DecelerateInterpolator());
      paramViewGroup.setRepeatMode(2);
      paramViewGroup.setFillAfter(false);
      paramViewGroup.startNow();
      paramViewGroup.setAnimationListener(new yoz(this, paramView, paramOnClickListener));
      paramOnClickListener.setAnimation(paramViewGroup);
      return paramOnClickListener;
      label1596:
      paramOnClickListener.setBackgroundResource(2130838593);
      paramOnClickListener.setAnimation(null);
      return paramOnClickListener;
      label1613:
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.contacts.BuddyListDevices
 * JD-Core Version:    0.7.0.1
 */