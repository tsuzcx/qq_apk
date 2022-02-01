package com.tencent.mobileqq.apollo.game;

import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.model.StartCheckParam;

public abstract interface OnGameStartCheckListener
{
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong, StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams);
  
  public abstract void a(StartCheckParam paramStartCheckParam);
  
  public abstract void a(StartCheckParam paramStartCheckParam, int paramInt);
  
  public abstract void a(StartCheckParam paramStartCheckParam, long paramLong);
  
  public abstract void a(StartCheckParam paramStartCheckParam, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong);
  
  public abstract void a(StartCheckParam paramStartCheckParam, String paramString);
  
  public abstract void b(long paramLong, StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams);
  
  public abstract void b(StartCheckParam paramStartCheckParam);
  
  public abstract void c(StartCheckParam paramStartCheckParam);
  
  public abstract void d(StartCheckParam paramStartCheckParam);
  
  public abstract void e(StartCheckParam paramStartCheckParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.OnGameStartCheckListener
 * JD-Core Version:    0.7.0.1
 */