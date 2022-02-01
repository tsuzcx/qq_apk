package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FriendProfileMoreInfoActivity$2
  extends ProfileCardObserver
{
  FriendProfileMoreInfoActivity$2(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)) && (Utils.a(this.a.app.getCurrentAccountUin(), ((Card)paramObject).uin)))
    {
      FriendProfileMoreInfoActivity.a(this.a, (Card)paramObject, true);
      if (!this.a.i)
      {
        paramObject = (BusinessCardManager)this.a.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
        FriendProfileMoreInfoActivity.a(this.a, paramObject.a());
      }
    }
  }
  
  public void onGetProfileDetail(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (Utils.a(this.a.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
    }
  }
  
  public void onSetProfileDetail(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, String.format("onSetProfileDetail success=%s resultCode=%s mDelayRemoveCardObserver=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.a.jdField_b_of_type_Boolean) }));
    }
    if (FriendProfileMoreInfoActivity.a(this.a))
    {
      FriendProfileMoreInfoActivity.a(this.a, paramBoolean, paramCard);
      return;
    }
    if (((paramBoolean) && (paramInt == 0)) || ((!paramBoolean) && (paramInt == 34)))
    {
      label86:
      if (this.a.jdField_b_of_type_Boolean)
      {
        this.a.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        this.a.removeObserver(FriendProfileMoreInfoActivity.a(this.a));
        this.a.jdField_b_of_type_Boolean = false;
      }
      if ((!this.a.jdField_a_of_type_Boolean) || (this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)) {
        break label765;
      }
      if (paramBoolean)
      {
        ReportController.b(this.a.app, "dc00898", "", "", "0X8007EC3", "0X8007EC3", 0, 0, "", "", "", "");
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean)
        {
          paramCard = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if ((!TextUtils.isEmpty(paramCard)) && (!TextUtils.isEmpty(paramCard.trim()))) {
            break label699;
          }
        }
        label230:
        if (this.a.jdField_c_of_type_Boolean) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007EC8", "0X8007EC8", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_d_of_type_Boolean) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007EC9", "0X8007EC9", 0, 0, "", "", "", "");
        }
        if (this.a.e) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECA", "0X8007ECA", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECB", "0X8007ECB", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECC", "0X8007ECC", 0, 0, "", "", "", "");
        }
        if (this.a.f) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECD", "0X8007ECD", 0, 0, "", "", "", "");
        }
        if (this.a.g) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECE", "0X8007ECE", 0, 0, "", "", "", "");
        }
        if (this.a.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$MaxBytesTextWatcher.jdField_b_of_type_Boolean)
        {
          paramCard = this.a.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
          Matcher localMatcher = SearchBaseActivity.a.matcher(paramCard);
          if ((TextUtils.isEmpty(paramCard)) || (localMatcher.matches())) {
            break label732;
          }
        }
      }
    }
    for (;;)
    {
      if (this.a.h) {
        ReportController.b(this.a.app, "dc00898", "", "", "0X8007ED0", "0X8007ED0", 0, 0, "", "", "", "");
      }
      if (this.a.jdField_a_of_type_AndroidOsBundle == null) {
        this.a.jdField_a_of_type_AndroidOsBundle = new Bundle();
      }
      this.a.jdField_a_of_type_Boolean = false;
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      if (this.a.isFinishing()) {
        break;
      }
      this.a.finish();
      return;
      if (paramInt == 40)
      {
        FriendProfileMoreInfoActivity.a(this.a, 2131719095, 1);
        break label86;
      }
      FriendProfileMoreInfoActivity.a(this.a, 2131695129, 1);
      break label86;
      label699:
      ReportController.b(this.a.app, "dc00898", "", "", "0X8007EC7", "0X8007EC7", 0, 0, "", "", "", "");
      break label230;
      label732:
      ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECF", "0X8007ECF", 0, 0, "", "", "", "");
    }
    label765:
    FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.2
 * JD-Core Version:    0.7.0.1
 */