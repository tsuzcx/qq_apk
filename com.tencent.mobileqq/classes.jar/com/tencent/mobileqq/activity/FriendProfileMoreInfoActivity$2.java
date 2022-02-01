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
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)))
    {
      String str = this.a.app.getCurrentAccountUin();
      paramObject = (Card)paramObject;
      if (Utils.a(str, paramObject.uin))
      {
        FriendProfileMoreInfoActivity.a(this.a, paramObject, true);
        if (!this.a.I)
        {
          paramObject = (BusinessCardManager)this.a.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
          FriendProfileMoreInfoActivity.a(this.a, paramObject.b());
        }
      }
    }
  }
  
  protected void onGetProfileDetail(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (Utils.a(this.a.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
    }
  }
  
  protected void onSetProfileDetail(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, String.format("onSetProfileDetail success=%s resultCode=%s mDelayRemoveCardObserver=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.a.w) }));
    }
    if (FriendProfileMoreInfoActivity.a(this.a))
    {
      FriendProfileMoreInfoActivity.a(this.a, paramBoolean, paramCard);
      return;
    }
    if (((!paramBoolean) || (paramInt != 0)) && ((paramBoolean) || (paramInt != 34))) {
      if (paramInt == 40) {
        FriendProfileMoreInfoActivity.a(this.a, 2131916320, 1);
      } else {
        FriendProfileMoreInfoActivity.a(this.a, 2131892847, 1);
      }
    }
    Object localObject;
    if (this.a.w)
    {
      localObject = this.a;
      ((FriendProfileMoreInfoActivity)localObject).removeObserver(((FriendProfileMoreInfoActivity)localObject).M);
      localObject = this.a;
      ((FriendProfileMoreInfoActivity)localObject).removeObserver(FriendProfileMoreInfoActivity.b((FriendProfileMoreInfoActivity)localObject));
      this.a.w = false;
    }
    if ((this.a.v) && (this.a.u != null))
    {
      if (paramBoolean)
      {
        ReportController.b(this.a.app, "dc00898", "", "", "0X8007EC3", "0X8007EC3", 0, 0, "", "", "", "");
        if (this.a.l.b)
        {
          paramCard = this.a.f.getText().toString();
          if ((!TextUtils.isEmpty(paramCard)) && (!TextUtils.isEmpty(paramCard.trim()))) {
            ReportController.b(this.a.app, "dc00898", "", "", "0X8007EC7", "0X8007EC7", 0, 0, "", "", "", "");
          }
        }
        if (this.a.z) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007EC8", "0X8007EC8", 0, 0, "", "", "", "");
        }
        if (this.a.A) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007EC9", "0X8007EC9", 0, 0, "", "", "", "");
        }
        if (this.a.B) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECA", "0X8007ECA", 0, 0, "", "", "", "");
        }
        if (this.a.m.b) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECB", "0X8007ECB", 0, 0, "", "", "", "");
        }
        if (this.a.n.b) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECC", "0X8007ECC", 0, 0, "", "", "", "");
        }
        if (this.a.C) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECD", "0X8007ECD", 0, 0, "", "", "", "");
        }
        if (this.a.D) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECE", "0X8007ECE", 0, 0, "", "", "", "");
        }
        if (this.a.o.b)
        {
          paramCard = this.a.i.getText().toString();
          localObject = SearchBaseActivity.C.matcher(paramCard);
          if ((TextUtils.isEmpty(paramCard)) || (((Matcher)localObject).matches())) {
            ReportController.b(this.a.app, "dc00898", "", "", "0X8007ECF", "0X8007ECF", 0, 0, "", "", "", "");
          }
        }
        if (this.a.E) {
          ReportController.b(this.a.app, "dc00898", "", "", "0X8007ED0", "0X8007ED0", 0, 0, "", "", "", "");
        }
        if (this.a.H == null) {
          this.a.H = new Bundle();
        }
      }
      paramCard = this.a;
      paramCard.v = false;
      paramCard.u.dismiss();
      if (!this.a.isFinishing()) {
        this.a.finish();
      }
    }
    else
    {
      FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.2
 * JD-Core Version:    0.7.0.1
 */