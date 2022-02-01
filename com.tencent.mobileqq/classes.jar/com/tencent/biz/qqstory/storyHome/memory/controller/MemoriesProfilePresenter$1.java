package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.FriendListObserver;
import friendlist.GetOnlineInfoResp;

class MemoriesProfilePresenter$1
  extends FriendListObserver
{
  MemoriesProfilePresenter$1(MemoriesProfilePresenter paramMemoriesProfilePresenter) {}
  
  public void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((!paramBoolean) || (this.a.a == null) || (paramGetOnlineInfoResp == null) || (!TextUtils.equals(paramString, this.a.a.qq))) {}
    while (MemoriesProfilePresenter.a(this.a) == null) {
      return;
    }
    paramString = MemoriesProfilePresenter.a(this.a);
    if (paramGetOnlineInfoResp.eIconType == 11) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.b(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.1
 * JD-Core Version:    0.7.0.1
 */