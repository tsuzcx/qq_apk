package com.tencent.mobileqq.apollo.cmgame;

import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;

public abstract interface OnGameStartCheckListener
{
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams);
  
  public abstract void a(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt);
  
  public abstract void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong);
  
  public abstract void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong);
  
  public abstract void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, String paramString);
  
  public abstract void b(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams);
  
  public abstract void b(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void c(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void d(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void e(CmGameStartChecker.StartCheckParam paramStartCheckParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.OnGameStartCheckListener
 * JD-Core Version:    0.7.0.1
 */