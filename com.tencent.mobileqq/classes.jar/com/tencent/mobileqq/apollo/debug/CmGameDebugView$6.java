package com.tencent.mobileqq.apollo.debug;

import android.widget.RelativeLayout;

class CmGameDebugView$6
  implements CmGameDebugManager.OnLogViewRefresh
{
  CmGameDebugView$6(CmGameDebugView paramCmGameDebugView) {}
  
  public void a(int paramInt)
  {
    if (CmGameDebugView.a(this.a).getVisibility() != 0)
    {
      CmGameDebugView.b(this.a, true);
      return;
    }
    CmGameDebugView.b(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.CmGameDebugView.6
 * JD-Core Version:    0.7.0.1
 */