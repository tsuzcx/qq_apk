package com.tencent.mobileqq.app.avgameshare;

import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class AVGameShareUtil$5
  extends AvGameRoomListObserver
{
  AVGameShareUtil$5(AVGameShareUtil paramAVGameShareUtil, long paramLong, Map paramMap, AppInterface paramAppInterface, AVGameShareUtil.AVGameShareProxy paramAVGameShareProxy) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong3 != this.jdField_a_of_type_Long) {
      QLog.e("AvGameRoomListObserver", 1, "onShareInviteBackflow fail: observer not match");
    }
    do
    {
      return;
      QLog.d("AvGameRoomListObserver", 1, "onShareInviteBackflow isSuccess: " + paramBoolean + " roomId: " + paramLong1 + " shareUin: " + paramLong2 + " mark: " + paramLong3 + " shareType: " + paramLong4);
      AvGameRoomListObserver localAvGameRoomListObserver = (AvGameRoomListObserver)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
      if (localAvGameRoomListObserver == null)
      {
        QLog.e("AvGameRoomListObserver", 1, "onShareInviteBackflow fail: observer not exist");
        return;
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(localAvGameRoomListObserver);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppAvgameshareAVGameShareUtil$AVGameShareProxy == null);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAvgameshareAVGameShareUtil$AVGameShareProxy.a(paramBoolean, paramLong1, paramLong2, paramLong4);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AvGameRoomListObserver", 1, "onShareInviteBackflow exception: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.5
 * JD-Core Version:    0.7.0.1
 */