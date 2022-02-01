package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;

class AutoRemarkActivity$InternalFriendListObserver
  extends FriendListObserver
{
  private AutoRemarkActivity$InternalFriendListObserver(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((this.a.jdField_a_of_type_Int == 1) && (TextUtils.equals(paramString1, this.a.jdField_a_of_type_JavaLangString)))
    {
      this.a.getIntent().getLongExtra("k_msg_key", 0L);
      if ((paramBoolean) && (NetworkUtil.isNetSupport(this.a)))
      {
        paramString2 = this.a;
        paramString2.d = 0;
        paramString2.jdField_a_of_type_JavaLangString = paramString1;
        paramString2.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.moveFriendToGroup(this.a.jdField_a_of_type_JavaLangString, (byte)this.a.c, (byte)0);
        return;
      }
      if ((this.a.d != 2) && (NetworkUtil.isNetSupport(this.a)))
      {
        paramString2 = this.a;
        paramString2.d += 1;
        this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setFriendComment(paramString1, this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), false);
        return;
      }
      AutoRemarkActivity.f(this.a);
      paramString1 = this.a;
      AutoRemarkActivity.a(paramString1, paramString1.getString(2131718220));
    }
  }
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.a.jdField_a_of_type_Int == 1)
    {
      if (paramString == null)
      {
        AutoRemarkActivity.g(this.a);
        paramString = this.a;
        AutoRemarkActivity.a(paramString, paramString.getString(2131718220));
        return;
      }
      if (paramString.equals(this.a.jdField_a_of_type_JavaLangString))
      {
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).openProfileCardNeedTrackBack(this.a, paramString);
        this.a.setResult(-1);
        this.a.finish();
        this.a.overridePendingTransition(2130772004, 2130772344);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity.InternalFriendListObserver
 * JD-Core Version:    0.7.0.1
 */