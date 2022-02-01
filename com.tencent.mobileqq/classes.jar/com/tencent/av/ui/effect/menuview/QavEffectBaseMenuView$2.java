package com.tencent.av.ui.effect.menuview;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;

class QavEffectBaseMenuView$2
  extends VideoObserver
{
  QavEffectBaseMenuView$2(QavEffectBaseMenuView paramQavEffectBaseMenuView) {}
  
  protected void b(long paramLong)
  {
    this.b.a("onResumeVideo");
  }
  
  protected void c()
  {
    this.b.a("onPauseVideo");
  }
  
  protected void c(String paramString, boolean paramBoolean)
  {
    int i = QavEffectBaseMenuView.b(this.b).b().k().g;
    if (((i == 2) || (i == 1)) && (paramBoolean)) {
      this.b.a("onPeerSwitchTerminal");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView.2
 * JD-Core Version:    0.7.0.1
 */