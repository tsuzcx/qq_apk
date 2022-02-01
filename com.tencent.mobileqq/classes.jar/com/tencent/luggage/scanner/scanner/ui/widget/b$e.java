package com.tencent.luggage.scanner.scanner.ui.widget;

import java.util.TimerTask;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/scanner/scanner/ui/widget/ScanSharedMaskView$initTitleTimer$1", "Ljava/util/TimerTask;", "run", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b$e
  extends TimerTask
{
  public void run()
  {
    this.a.post((Runnable)new b.e.a(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.b.e
 * JD-Core Version:    0.7.0.1
 */