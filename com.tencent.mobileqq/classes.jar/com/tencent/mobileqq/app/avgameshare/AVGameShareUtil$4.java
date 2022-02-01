package com.tencent.mobileqq.app.avgameshare;

import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.observer.GameRoomObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class AVGameShareUtil$4
  extends GameRoomObserver
{
  AVGameShareUtil$4(AVGameShareUtil paramAVGameShareUtil, long paramLong, Map paramMap, AVGameAppInterface paramAVGameAppInterface, AVGameShareUtil.AVGameShareProxy paramAVGameShareProxy) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramLong != this.jdField_a_of_type_Long) {
      QLog.e("GameRoomObserver", 1, "onGameShare fail: observer not match");
    }
    do
    {
      return;
      QLog.d("GameRoomObserver", 1, "onGameShare isSuccess: " + paramBoolean + " shareUrl: " + paramString + " mark: " + paramLong);
      GameRoomObserver localGameRoomObserver = (GameRoomObserver)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
      if (localGameRoomObserver == null)
      {
        QLog.e("GameRoomObserver", 1, "onGameShare fail: observer not exist");
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(localGameRoomObserver);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppAvgameshareAVGameShareUtil$AVGameShareProxy == null);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAvgameshareAVGameShareUtil$AVGameShareProxy.a(paramBoolean, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("GameRoomObserver", 1, "onGameShare exception: " + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.4
 * JD-Core Version:    0.7.0.1
 */