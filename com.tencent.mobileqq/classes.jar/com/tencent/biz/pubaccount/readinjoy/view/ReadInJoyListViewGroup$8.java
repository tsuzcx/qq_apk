package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyListViewGroup$8
  extends FriendListObserver
{
  ReadInJoyListViewGroup$8(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (((this.a.a == 0) || (this.a.a == 70)) && (paramBoolean))
    {
      QLog.d("ReadInJoyListViewGroup", 1, "onUpdateFriendInfo uin:" + paramString);
      this.a.m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.8
 * JD-Core Version:    0.7.0.1
 */