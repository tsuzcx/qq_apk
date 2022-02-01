package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qidian.QidianManager;

public class MiniPieForStranger
  extends MiniPie
{
  private QidianManager a;
  
  public MiniPieForStranger(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
    this.c = true;
  }
  
  protected void A()
  {
    if (!this.d) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
      if ((!ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1))
      {
        if ((this.jdField_a_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getText().length() < 6)) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        } else {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      else if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698601));
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public QidianManager a()
  {
    if (this.jdField_a_of_type_ComTencentQidianQidianManager == null) {
      this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
    return this.jdField_a_of_type_ComTencentQidianQidianManager;
  }
  
  protected void f()
  {
    if (!this.d) {
      return;
    }
    if ((this.c) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025) || (!a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006))
    {
      Object localObject = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (OnlineStatusUtils.a(((PhoneContact)localObject).detalStatusFlag, ((PhoneContact)localObject).iTermType) != 0))
      {
        localObject = ContactUtils.a((PhoneContact)localObject);
        e(true);
        this.b.setText((CharSequence)localObject);
        if (AppSetting.d) {
          this.b.setContentDescription((CharSequence)localObject);
        }
      }
      else if (this.b.getVisibility() == 0)
      {
        e(false);
      }
    }
  }
  
  protected void g()
  {
    super.g();
    if (this.d)
    {
      f();
      A();
    }
  }
  
  protected void y()
  {
    this.jdField_a_of_type_JavaLangString = "MiniPieForStranger";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieForStranger
 * JD-Core Version:    0.7.0.1
 */