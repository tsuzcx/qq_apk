package com.tencent.mobileqq.app;

import aluj;
import auxp;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class HotChatHandler$2
  implements Runnable
{
  public HotChatHandler$2(aluj paramaluj, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if ((!auxp.a().jdField_a_of_type_Boolean) && (!auxp.a().c))
    {
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        break label110;
      }
      localHotChatInfo = (HotChatInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    label110:
    while (auxp.a().a() != 1) {
      try
      {
        long l = Long.parseLong(localHotChatInfo.troopUin);
        auxp.a().a(1, null, l, localHotChatInfo.name);
        return;
      }
      catch (Exception localException)
      {
        HotChatInfo localHotChatInfo;
        while (!QLog.isColorLevel()) {}
        QLog.e("HotChatHandler", 2, "handleGetMyHostChatListRespError hc.troopUin: " + localHotChatInfo.troopUin);
        return;
      }
    }
    auxp.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatHandler.2
 * JD-Core Version:    0.7.0.1
 */