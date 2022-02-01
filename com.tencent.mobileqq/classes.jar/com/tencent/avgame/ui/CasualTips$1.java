package com.tencent.avgame.ui;

import java.util.ArrayList;

class CasualTips$1
  implements Runnable
{
  CasualTips$1(CasualTips paramCasualTips, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      this.this$0.a = ((int)(System.currentTimeMillis() % this.a.size()));
      CasualTips.a(this.this$0).addAll(this.a);
    }
    CasualTips.a(this.this$0);
    if (CasualTips.a(this.this$0).size() > 1) {
      this.this$0.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.CasualTips.1
 * JD-Core Version:    0.7.0.1
 */