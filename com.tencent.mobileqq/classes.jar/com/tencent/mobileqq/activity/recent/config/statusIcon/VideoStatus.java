package com.tencent.mobileqq.activity.recent.config.statusIcon;

import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.utils.UIToolsTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;

public class VideoStatus
  extends AbsRecentStatus
{
  public int a()
  {
    return AbsRecentStatus.a;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return false;
    }
    paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    int k = paramRecentBaseData.getRecentUserType();
    int i;
    Object localObject;
    if ((k != 3000) && (k != 1))
    {
      if ((!paramBaseQQAppInterface.isVideoChatting()) || ((paramBaseQQAppInterface.getAVNotifyCenter().e() != 1) && (paramBaseQQAppInterface.getAVNotifyCenter().e() != 2))) {
        break label290;
      }
      i = paramBaseQQAppInterface.getAVNotifyCenter().f();
      localObject = paramBaseQQAppInterface.getAVNotifyCenter().c();
      String str = paramBaseQQAppInterface.getAVNotifyCenter().d();
      if ((k != i) || ((!paramRecentBaseData.getRecentUserUin().equals(localObject)) && (!paramRecentBaseData.getRecentUserUin().equals(str)))) {
        break label290;
      }
      paramRecentBaseData.mStatus = 1;
    }
    try
    {
      l = Long.parseLong(paramRecentBaseData.getRecentUserUin());
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      label142:
      int m;
      int j;
      break label142;
    }
    l = 0L;
    m = UIToolsTemp.a(k);
    if (paramBaseQQAppInterface.getAVNotifyCenter().a(m, l) > 0L)
    {
      if (paramBaseQQAppInterface.getAVNotifyCenter().a(m, l)) {
        paramRecentBaseData.mStatus = 2;
      } else {
        paramRecentBaseData.mStatus = 3;
      }
    }
    else
    {
      localObject = paramBaseQQAppInterface.getAVNotifyCenter().a(l, 2);
      if (localObject != null) {
        i = ((AVNotifyCenter.VideoRoomInfo)localObject).a + 0;
      } else {
        i = 0;
      }
      localObject = paramBaseQQAppInterface.getAVNotifyCenter().a(l, 10);
      j = i;
      if (localObject != null) {
        j = i + ((AVNotifyCenter.VideoRoomInfo)localObject).a;
      }
      if (j > 0) {
        if (paramBaseQQAppInterface.getAVNotifyCenter().a(m, l)) {
          paramRecentBaseData.mStatus = 2;
        } else {
          paramRecentBaseData.mStatus = 3;
        }
      }
    }
    label290:
    if ((k == 0) && (paramBaseQQAppInterface.getAVNotifyCenter().d(paramRecentBaseData.getRecentUserUin()))) {
      paramRecentBaseData.mStatus = 5;
    }
    return false;
  }
  
  public boolean a(RecentBaseData paramRecentBaseData, BaseQQAppInterface paramBaseQQAppInterface)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.statusIcon.VideoStatus
 * JD-Core Version:    0.7.0.1
 */