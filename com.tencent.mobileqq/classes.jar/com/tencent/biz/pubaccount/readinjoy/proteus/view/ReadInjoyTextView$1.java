package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ReadInjoyTextView$1
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ReadInjoyTextView$1(ReadInjoyTextView paramReadInjoyTextView, String paramString1, String paramString2) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(this.jdField_a_of_type_JavaLangString))) {
      ThreadManager.getUIHandler().post(new ReadInjoyTextView.1.2(this));
    }
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_JavaLangString))) {
      ThreadManager.getUIHandler().post(new ReadInjoyTextView.1.1(this, paramReadInJoyUserInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView.1
 * JD-Core Version:    0.7.0.1
 */