package com.tencent.mobileqq.ar.view;

import android.widget.RelativeLayout;
import android.widget.TextView;

class ARScanEntryView$10
  implements Runnable
{
  ARScanEntryView$10(ARScanEntryView paramARScanEntryView, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = ARScanEntryView.o(this.this$0);
    boolean bool = this.a;
    int j = 8;
    int i;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    if ((this.a) && (!ARScanEntryView.p(this.this$0)) && (!ARScanEntryView.q(this.this$0))) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = this.this$0.p;
    if (i != 0) {
      j = 0;
    }
    ((TextView)localObject).setVisibility(j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.10
 * JD-Core Version:    0.7.0.1
 */