package com.tencent.mobileqq.apollo.cmgame;

import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;

public abstract interface OnGameStartCheckListener
{
  public abstract void onDownloadConfirm(CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong);
  
  public abstract void onDownloadGameResDown(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void onDownloadGameResProgress(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt);
  
  public abstract void onDownloadGameResStart(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void onGameCheckFinish(int paramInt, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams);
  
  public abstract void onGameCheckStart(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void onGameLifeTipShow(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void onSsoCmdRuleRsp(CmGameStartChecker.StartCheckParam paramStartCheckParam, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.OnGameStartCheckListener
 * JD-Core Version:    0.7.0.1
 */