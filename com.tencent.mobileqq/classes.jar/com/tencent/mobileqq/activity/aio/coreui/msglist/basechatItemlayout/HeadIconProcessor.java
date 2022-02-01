package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.vas.avatar.VasAvatarLoader;
import com.tencent.mobileqq.widget.MosaicEffect;

public class HeadIconProcessor
  implements IHeadIconProcessor
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BaseChatItemLayout jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
  private BaseChatItemLayoutViewBasicAbility jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewBasicAbility;
  private VasAvatar jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar;
  private ImageView b;
  
  public HeadIconProcessor(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Object localObject = AIOLongShotHelper.a();
    if ((localObject != null) && (((AIOLongShotHelper)localObject).a()) && (((AIOLongShotHelper)localObject).b())) {
      localObject = new MosaicEffect(10);
    } else {
      localObject = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setMosaicEffect((MosaicEffect)localObject);
  }
  
  public BaseChatItemLayoutViewBasicAbility a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewBasicAbility == null)
    {
      VasAvatar localVasAvatar = this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar;
      if (localVasAvatar != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewBasicAbility = new BaseChatItemLayoutViewBasicAbilityImpl(localVasAvatar);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewBasicAbility;
  }
  
  public BaseChatItemLayoutViewBasicAbility a(int paramInt)
  {
    return null;
  }
  
  public VasAvatar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar;
  }
  
  public void a(Object paramObject)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296413);
    int j = AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    a(paramObject, i, BaseChatItemLayout.R, BaseChatItemLayout.R, j, true);
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = new VasAvatar(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setId(2131364530);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject = new RelativeLayout.LayoutParams(paramInt2, paramInt3);
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364529);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b() == 1)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt4;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.getVisibility() != 8)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt4;
        }
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar, (ViewGroup.LayoutParams)localObject);
    }
    else
    {
      localObject = (RelativeLayout.LayoutParams)((VasAvatar)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364529);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b() == 1)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt4;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.getVisibility() != 8)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt4;
        }
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a());
    }
    if ((paramObject instanceof Drawable)) {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setImageDrawable((Drawable)paramObject);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLoader(null, (VasAvatarLoader)paramObject);
    }
    paramObject = this.b;
    if (paramObject != null) {
      paramObject.setVisibility(8);
    }
    if (paramBoolean) {
      a();
    }
  }
  
  public void a(Object paramObject, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000))
    {
      paramChatMessage.isShowQimStyleAvater = QIMUserManager.a().a(paramObject, paramQQAppInterface, paramChatMessage);
      paramChatMessage.isShowQIMStyleGroup = QIMUserManager.a().a(paramObject, paramQQAppInterface, paramChatMessage, false);
      if (paramChatMessage.isShowQimStyleAvater)
      {
        paramObject = QIMUserManager.a().b(1);
        if (paramObject == null) {
          return;
        }
        int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296413);
        int j = AIOUtils.b(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localObject == null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_AndroidWidgetImageView.setId(2131364542);
          this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          int k = AIOUtils.b(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramObject);
          paramObject = new RelativeLayout.LayoutParams(k, k);
          paramObject.topMargin = (i + j);
          paramObject.leftMargin = j;
          paramObject.addRule(7, 2131364530);
          paramObject.addRule(8, 2131364530);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramObject);
        }
        else
        {
          localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = (i + j);
          ((RelativeLayout.LayoutParams)localObject).leftMargin = j;
          ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131364530);
          ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131364530);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramObject);
        }
        if (paramChatMessage.istroop == 1)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80085A6", "0X80085A6", 1, 0, "", "", "", "");
          return;
        }
        if (paramChatMessage.istroop == 3000) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80085A5", "0X80085A5", 1, 0, "", "", "", "");
        }
      }
      else
      {
        paramChatMessage.isShowQimStyleAvater = false;
        paramObject = this.jdField_a_of_type_AndroidWidgetImageView;
        if (paramObject != null) {
          paramObject.setImageDrawable(null);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = MessageForArkApp.dp2px(1.0F);
      if (this.b == null)
      {
        this.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        int j = MessageForArkApp.dp2px(42.0F);
        localObject = new RelativeLayout.LayoutParams(j, j);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(this.b, (ViewGroup.LayoutParams)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131364530);
      i = -i;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c())
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131364530);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364530);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
      }
      this.b.setBackgroundResource(2130844891);
      this.b.requestLayout();
      this.b.setVisibility(0);
      return;
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar;
    if ((localObject != null) && (((VasAvatar)localObject).getVisibility() == 0))
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
      int i = AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (paramBoolean)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.getVisibility() != 8)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
        }
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramInt);
    }
  }
  
  public BaseChatItemLayoutViewBasicAbility b()
  {
    ImageView localImageView = this.b;
    if (localImageView == null) {
      return null;
    }
    return new BaseChatItemLayoutViewBasicAbilityImpl(localImageView);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar;
    if (localObject != null) {
      if (paramBoolean) {
        ((VasAvatar)localObject).setVisibility(0);
      } else {
        ((VasAvatar)localObject).setVisibility(8);
      }
    }
    localObject = (NickNameLayoutViewWrapper)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(NickNameLayoutViewWrapper.class);
    if (localObject != null)
    {
      localObject = ((NickNameLayoutViewWrapper)localObject).a();
      if (localObject != null) {
        if (paramBoolean) {
          ((BaseChatItemLayoutViewBasicAbility)localObject).setViewVisibility(0);
        } else {
          ((BaseChatItemLayoutViewBasicAbility)localObject).setViewVisibility(8);
        }
      }
    }
    localObject = AIOLongShotHelper.a();
    boolean bool = paramBoolean;
    if (localObject != null)
    {
      bool = paramBoolean;
      if (((AIOLongShotHelper)localObject).c()) {
        bool = false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setPendantImageVisible(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconProcessor
 * JD-Core Version:    0.7.0.1
 */