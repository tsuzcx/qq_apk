package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.callback.IFloatMapCallback;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;

class LocationShareHelper$2
  implements IFloatMapCallback
{
  LocationShareHelper$2(LocationShareHelper paramLocationShareHelper) {}
  
  public void a() {}
  
  public boolean a(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey)
  {
    if ((LocationShareHelper.c(this.a) != null) && (LocationShareHelper.c(this.a).equals(paramRoomKey)) && (LocationShareHelper.a(this.a) == LocationShareHelper.b(this.a).J().a())) {
      LocationShareHelper.b(this.a).J().c();
    }
    return true;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.LocationShareHelper.2
 * JD-Core Version:    0.7.0.1
 */