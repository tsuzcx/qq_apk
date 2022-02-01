package com.tencent.avgame.gameresult;

import com.tencent.avgame.business.observer.UserInfoObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class GameResultPKPresenterImp$1
  extends UserInfoObserver
{
  GameResultPKPresenterImp$1(GameResultPKPresenterImp paramGameResultPKPresenterImp) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPKPresenterImp", 2, String.format("onUserHeadUpdated", new Object[0]));
    }
    if ((this.a.a instanceof GamePKResultFragment)) {
      ((GamePKResultFragment)this.a.a).aD_();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, HashMap<String, String> paramHashMap)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameResultPKPresenterImp", 2, String.format("onUserNickUpdated", new Object[0]));
      }
      if ((this.a.a instanceof GamePKResultFragment)) {
        ((GamePKResultFragment)this.a.a).aD_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultPKPresenterImp.1
 * JD-Core Version:    0.7.0.1
 */