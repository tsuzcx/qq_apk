package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;

public class SmallScreenShare
  extends SmallScreenItemBase
{
  protected static int a = 3;
  
  public SmallScreenShare(Context paramContext)
  {
    this.l = "SmallScreenShare";
    this.o = 2013396994;
    this.p = paramContext.getResources().getDimensionPixelSize(2131298635);
    this.q = paramContext.getResources().getDimensionPixelSize(2131298634);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, a);
  }
  
  public void b()
  {
    a = this.m.getCurPosition();
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenShare
 * JD-Core Version:    0.7.0.1
 */