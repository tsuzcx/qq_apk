package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class SubAccountBindActivity$2
  extends SubAccountBindObserver
{
  SubAccountBindActivity$2(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.jdField_a_of_type_Int + " errMsg=" + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.e();
    Object localObject2;
    if (paramBoolean)
    {
      this.a.c(this.a.getString(2131719586));
      SubAccountAssistantForward.a(this.a.app);
      this.a.getActivity().setTitle("");
      this.a.finish();
      if ((QLog.isColorLevel()) && (paramSubAccountBackProtocData != null))
      {
        localObject2 = new StringBuilder().append("onBindSubAccount:");
        if (!paramBoolean) {
          break label915;
        }
      }
    }
    label915:
    for (Object localObject1 = "..success";; localObject1 = "...failed..")
    {
      QLog.d("SUB_ACCOUNT", 2, (String)localObject1 + " ...errorMsg = " + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString + "...errorType = " + paramSubAccountBackProtocData.jdField_a_of_type_Int);
      do
      {
        return;
      } while (paramSubAccountBackProtocData == null);
      switch (paramSubAccountBackProtocData.jdField_a_of_type_Int)
      {
      default: 
        localObject2 = this.a.getString(2131719577);
        localObject1 = localObject2;
        if (paramSubAccountBackProtocData != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString)) {
            localObject1 = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
          }
        }
        this.a.b((String)localObject1);
        break;
      case 1002: 
        SubAccountControll.a(this.a.app, this.a);
        break;
      case 1003: 
        this.a.b(this.a.getString(2131719578));
        break;
      case 1004: 
        switch (paramSubAccountBackProtocData.jdField_b_of_type_Int)
        {
        default: 
          localObject2 = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onBindSubAccount:bind error happen but msg is null shit, ");
            }
            localObject1 = this.a.getString(2131719577);
          }
          this.a.b((String)localObject1);
          break;
        case 1200: 
        case 1214: 
        case 1215: 
          localObject1 = this.a.getString(2131719611);
          localObject2 = this.a.getString(2131719580);
          this.a.a((String)localObject1, (String)localObject2, new SubAccountBindActivity.2.1(this, paramSubAccountBackProtocData));
          break;
        case 1218: 
          localObject2 = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = this.a.app.getApp().getResources().getString(2131718684);
          }
          this.a.b((String)localObject1);
          break;
        case 1232: 
          localObject2 = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = this.a.app.getApp().getResources().getString(2131719581);
          }
          this.a.b((String)localObject1);
          break;
        case 1233: 
          localObject2 = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = this.a.app.getApp().getResources().getString(2131719576);
          }
          this.a.b((String)localObject1);
          break;
        case 1240: 
          localObject2 = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = this.a.app.getApp().getResources().getString(2131719582);
          }
          this.a.b((String)localObject1);
          break;
        case 1241: 
          localObject2 = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = this.a.app.getApp().getResources().getString(2131719575);
          }
          this.a.b((String)localObject1);
          break;
        case 1242: 
          localObject2 = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = this.a.app.getApp().getResources().getString(2131719584);
          }
          this.a.b((String)localObject1);
        }
        break;
      case 1011: 
        localObject2 = this.a.getString(2131719577);
        localObject1 = localObject2;
        if (paramSubAccountBackProtocData != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString)) {
            localObject1 = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
          }
        }
        this.a.b((String)localObject1);
        localObject1 = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject1).putExtra("subuin", paramSubAccountBackProtocData.c);
        ((Intent)localObject1).putExtra("fromWhere", this.a.jdField_b_of_type_JavaLangString);
        this.a.startActivity((Intent)localObject1);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.2
 * JD-Core Version:    0.7.0.1
 */