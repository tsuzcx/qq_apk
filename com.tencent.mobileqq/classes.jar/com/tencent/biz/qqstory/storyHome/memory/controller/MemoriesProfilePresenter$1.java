package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.FriendListObserver;
import friendlist.GetOnlineInfoResp;

class MemoriesProfilePresenter$1
  extends FriendListObserver
{
  MemoriesProfilePresenter$1(MemoriesProfilePresenter paramMemoriesProfilePresenter) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (this.a.b != null) && (paramGetOnlineInfoResp != null))
    {
      if (!TextUtils.equals(paramString, this.a.b.qq)) {
        return;
      }
      if (MemoriesProfilePresenter.a(this.a) != null)
      {
        paramString = MemoriesProfilePresenter.a(this.a);
        if (paramGetOnlineInfoResp.eIconType == 11) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramString.b(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.1
 * JD-Core Version:    0.7.0.1
 */