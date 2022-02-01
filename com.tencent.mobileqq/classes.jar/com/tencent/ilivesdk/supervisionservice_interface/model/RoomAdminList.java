package com.tencent.ilivesdk.supervisionservice_interface.model;

import java.util.Iterator;
import java.util.List;

public class RoomAdminList
{
  public List<RoomAdminInfo> adminInfoList;
  public boolean isAnchorInRoom;
  public int max;
  
  public String toString()
  {
    String str = "RoomAdminList {max=" + this.max + "\nisAnchorInRoom=" + this.isAnchorInRoom + "\n";
    if (this.adminInfoList != null)
    {
      Iterator localIterator = this.adminInfoList.iterator();
      for (;;)
      {
        localObject = str;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (RoomAdminInfo)localIterator.next();
        str = str + ((RoomAdminInfo)localObject).toString() + "\n";
      }
    }
    Object localObject = str;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.model.RoomAdminList
 * JD-Core Version:    0.7.0.1
 */