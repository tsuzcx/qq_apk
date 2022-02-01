package com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl;

import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class GameMsgBoxABTestApiImpl
  implements IGameMsgBoxABTestApi
{
  public static final String TAG = "GameMsgBoxABTestApiImpl";
  
  public boolean isGameMsgAddTab()
  {
    ExpEntityInfo localExpEntityInfo = ABTestController.a().a("game_box1");
    boolean bool2 = localExpEntityInfo.i();
    boolean bool1 = true;
    int i;
    if ((bool2) && (localExpEntityInfo.a("game_box1_B"))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      bool1 = false;
    }
    return bool1;
  }
  
  public void reportGameTabExposure(MqqHandler paramMqqHandler)
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (paramMqqHandler == null) {
        bool = true;
      }
      QLog.d("GameMsgBoxABTestApiImpl", 2, new Object[] { "reportGameTabExp-handler is null: ", Boolean.valueOf(bool), "is exp: ", Boolean.valueOf(isGameMsgAddTab()) });
    }
    ExpEntityInfo localExpEntityInfo = ABTestController.a().a("game_box1");
    if (paramMqqHandler != null)
    {
      paramMqqHandler.post(new GameMsgBoxABTestApiImpl.1(this, localExpEntityInfo));
      return;
    }
    localExpEntityInfo.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxABTestApiImpl
 * JD-Core Version:    0.7.0.1
 */