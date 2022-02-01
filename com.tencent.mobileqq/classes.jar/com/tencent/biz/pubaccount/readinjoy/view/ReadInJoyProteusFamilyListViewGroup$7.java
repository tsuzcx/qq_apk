package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyProteusFamilyListViewGroup$7
  extends FriendListObserver
{
  ReadInJoyProteusFamilyListViewGroup$7(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (((this.a.a == 0) || (this.a.a == 70)) && (paramBoolean))
    {
      QLog.d("ReadinJoyProteusFamilyListViewGroup", 1, "onUpdateFriendInfo uin:" + paramString);
      this.a.k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup.7
 * JD-Core Version:    0.7.0.1
 */