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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("RoomAdminList {max=");
    ((StringBuilder)localObject1).append(this.max);
    ((StringBuilder)localObject1).append("\nisAnchorInRoom=");
    ((StringBuilder)localObject1).append(this.isAnchorInRoom);
    ((StringBuilder)localObject1).append("\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = this.adminInfoList;
    Object localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (RoomAdminInfo)((Iterator)localObject3).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(((RoomAdminInfo)localObject2).toString());
        localStringBuilder.append("\n");
        localObject1 = localStringBuilder.toString();
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.model.RoomAdminList
 * JD-Core Version:    0.7.0.1
 */