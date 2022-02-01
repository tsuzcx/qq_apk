package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.LocationShareTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.LocationShareServiceHolder;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class LocationShareHelper$1
  implements OnUpdateUserLocationListener
{
  LocationShareHelper$1(LocationShareHelper paramLocationShareHelper) {}
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if ((LocationShareHelper.a(this.a) == LocationShareHelper.b(this.a).J().a()) && (LocationShareHelper.a(this.a, paramRoomKey.a(), paramRoomKey.b()))) {
      LocationShareHelper.b(this.a).J().c();
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2) {}
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    if (QLog.isColorLevel())
    {
      paramVenue = new StringBuilder();
      paramVenue.append("[queryLocationRoom] onUpdateUserLocations: invoked. sessionUin: ");
      paramVenue.append(paramRoomKey.b());
      paramVenue.append(" itemList: ");
      paramVenue.append(paramList.size());
      QLog.d("LocationShareHelper", 2, paramVenue.toString());
    }
    paramVenue = LocationShareServiceHolder.b(LocationShareHelper.b(this.a).d).currentFloatWindowVisibleRoomKey();
    if ((paramVenue != null) && (paramVenue.equals(paramRoomKey)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramRoomKey, " currentFloatWindowVisibleRoomKey: ", paramVenue });
      }
      return;
    }
    if (!LocationShareHelper.a(this.a, paramRoomKey.a(), paramRoomKey.b())) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramVenue = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        paramVenue.add(((LocationItem)paramList.get(i)).c());
        i += 1;
      }
      boolean bool = paramVenue.contains(LocationShareHelper.b(this.a).d.getCurrentUin());
      LocationShareHelper.a(this.a).a(bool, LocationShareHelper.a(this.a, paramRoomKey, (String)paramVenue.get(0)), paramList.size(), paramVenue);
      LocationShareHelper.b(this.a).J().a(LocationShareHelper.a(this.a), new Object[0]);
      return;
    }
    if (LocationShareHelper.a(this.a) == LocationShareHelper.b(this.a).J().a()) {
      LocationShareHelper.b(this.a).J().c();
    }
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if ((LocationShareHelper.a(this.a) == LocationShareHelper.b(this.a).J().a()) && (LocationShareHelper.a(this.a, paramRoomKey.a(), paramRoomKey.b()))) {
      LocationShareHelper.b(this.a).J().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.LocationShareHelper.1
 * JD-Core Version:    0.7.0.1
 */