package com.tencent.mobileqq.apollo.barrage;

import java.util.List;

public abstract interface BarrageUI
{
  public abstract void a(List<Barrage> paramList, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract AbsBarrageCache getBarrageCache();
  
  public abstract int getUIHeight();
  
  public abstract int getUIWidth();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.BarrageUI
 * JD-Core Version:    0.7.0.1
 */