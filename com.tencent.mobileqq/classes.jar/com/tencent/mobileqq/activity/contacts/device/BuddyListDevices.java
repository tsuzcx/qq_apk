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
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(ImageView paramImageView)
  {
    Object localObject = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("100701.100702");
    if (localObject == null) {
      return;
    }
    if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0) {
      return;
    }
    localObject = (FrameLayout.LayoutParams)paramImageView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    ((FrameLayout.LayoutParams)localObject).height = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    ((FrameLayout.LayoutParams)localObject).topMargin = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
    paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramImageView.setVisibility(0);
    paramImageView.setBackgroundResource(2130850766);
    paramImageView = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enable_public_device_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramImageView.putBoolean(((StringBuilder)localObject).toString(), true).commit();
  }
  
  @TargetApi(11)
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject1;
    if ((paramView != null) && ((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) && ((!(paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) || (!((BuddyListFriends.BuddyChildTag)paramView.getTag()).jdField_a_of_type_Boolean)))
    {
      localObject1 = (BuddyListFriends.BuddyChildTag)paramView.getTag();
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      paramOnClickListener = paramView;
    }
    else
    {
      paramOnClickListener = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558923, paramViewGroup, false);
      localObject1 = ((FriendItemLayout)paramOnClickListener).a();
      paramOnClickListener.setTag(localObject1);
      a(paramOnClickListener.findViewById(2131368343));
    }
    paramView = (FrameLayout.LayoutParams)((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramView.leftMargin = AIOUtils.b(68.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramView);
    paramView = (FrameLayout.LayoutParams)((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.getLayoutParams();
    paramView.leftMargin = AIOUtils.b(68.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setLayoutParams(paramView);
    paramView = (FrameLayout.LayoutParams)((BuddyListFriends.BuddyChildTag)localObject1).d.getLayoutParams();
    paramView.leftMargin = AIOUtils.b(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((BuddyListFriends.BuddyChildTag)localObject1).d.setLayoutParams(paramView);
    ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
    ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
    ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
    if (!AppConstants.SMARTDEVICE_SEARCH_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
    {
      paramView = (FrameLayout.LayoutParams)((BuddyListFriends.BuddyChildTag)localObject1).c.getLayoutParams();
      paramView.width = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 16.0F));
      paramView.height = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 16.0F));
      paramView.topMargin = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 8.5F));
      ((BuddyListFriends.BuddyChildTag)localObject1).c.setLayoutParams(paramView);
    }
    boolean bool = AppConstants.DATALINE_PC_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
    paramInt1 = 2131719229;
    if (bool)
    {
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramView = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt2 == 0) {
        paramInt1 = 2131719230;
      }
      paramViewGroup = paramView.getString(paramInt1);
      paramView = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(paramViewGroup);
      ((StringBuilder)localObject2).append("]");
      paramView.setText(((StringBuilder)localObject2).toString());
      localObject2 = ((BuddyListFriends.BuddyChildTag)localObject1).d;
      if (paramInt2 != 0) {
        paramView = a();
      } else {
        paramView = null;
      }
      ((ImageView)localObject2).setImageDrawable(paramView);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131691374);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
      ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167063));
      paramView = paramViewGroup;
      paramViewGroup = (ViewGroup)localObject2;
    }
    else if (AppConstants.DATALINE_IPAD_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
    {
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramView = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt2 == 0) {
        paramInt1 = 2131719230;
      }
      paramViewGroup = paramView.getString(paramInt1);
      paramView = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(paramViewGroup);
      ((StringBuilder)localObject2).append("]");
      paramView.setText(((StringBuilder)localObject2).toString());
      localObject2 = ((BuddyListFriends.BuddyChildTag)localObject1).d;
      if (paramInt2 != 0) {
        paramView = a();
      } else {
        paramView = null;
      }
      ((ImageView)localObject2).setImageDrawable(paramView);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131691375);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
      ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167063));
      paramView = paramViewGroup;
      paramViewGroup = (ViewGroup)localObject2;
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin.equals(QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getString(2131698287);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramViewGroup);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
        ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167063));
      }
      for (;;)
      {
        paramView = null;
        break label1547;
        if (AppConstants.SMARTDEVICE_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 0) {
            paramInt2 = 1;
          } else {
            paramInt2 = 0;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 11)
          {
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("");
            paramView = null;
            paramInt2 = 0;
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 12)
          {
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131698317);
            paramViewGroup = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(paramView);
            ((StringBuilder)localObject2).append("]");
            paramViewGroup.setText(((StringBuilder)localObject2).toString());
          }
          else
          {
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
            paramView = this.jdField_a_of_type_AndroidContentContext;
            if (paramInt2 == 0) {
              paramInt1 = 2131719230;
            }
            paramView = paramView.getString(paramInt1);
            paramViewGroup = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(paramView);
            ((StringBuilder)localObject2).append("]");
            paramViewGroup.setText(((StringBuilder)localObject2).toString());
          }
          localObject2 = ((BuddyListFriends.BuddyChildTag)localObject1).d;
          if (paramInt2 != 0) {
            paramViewGroup = a();
          } else {
            paramViewGroup = null;
          }
          ((ImageView)localObject2).setImageDrawable(paramViewGroup);
          paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getString(2131719163);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramViewGroup);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
          ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167063));
          break label1547;
        }
        if (AppConstants.DATALINE_PRINTER_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("");
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).d.setImageDrawable(null);
          paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getString(2131691373);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramViewGroup);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
          ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167063));
        }
        else
        {
          if (!AppConstants.SMARTDEVICE_SEARCH_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin)) {
            break;
          }
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("");
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).d.setImageDrawable(null);
          paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getString(2131691371);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramViewGroup);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167063));
          a(((BuddyListFriends.BuddyChildTag)localObject1).c);
        }
      }
      paramViewGroup = null;
      paramView = paramViewGroup;
    }
    label1547:
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
    ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
    ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
    if (AppSetting.d)
    {
      localObject1 = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_JavaLangStringBuilder;
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
      if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))
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
    paramView = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if (paramView != null)
    {
      paramViewGroup = paramView.b();
      if ((!TextUtils.isEmpty(paramViewGroup)) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.equals(paramViewGroup)))
      {
        if (paramOnClickListener.getAnimation() != null)
        {
          paramView = paramOnClickListener.getAnimation();
          paramView.cancel();
          paramView.reset();
          paramView.startNow();
          return paramOnClickListener;
        }
        paramOnClickListener.setBackgroundResource(2130839568);
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
      paramOnClickListener.setBackgroundResource(2130839393);
      paramOnClickListener.setAnimation(null);
    }
    return paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.BuddyListDevices
 * JD-Core Version:    0.7.0.1
 */