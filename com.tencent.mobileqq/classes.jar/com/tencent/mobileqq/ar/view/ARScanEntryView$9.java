package com.tencent.mobileqq.ar.view;

import android.widget.RelativeLayout;
import android.widget.TextView;

class ARScanEntryView$9
  implements Runnable
{
  ARScanEntryView$9(ARScanEntryView paramARScanEntryView, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = ARScanEntryView.a(this.this$0);
    if (this.a)
    {
      i = 0;
      ((RelativeLayout)localObject).setVisibility(i);
      if ((!this.a) || (ARScanEntryView.c(this.this$0)) || (ARScanEntryView.d(this.this$0))) {
        break label79;
      }
      i = 1;
      label53:
      localObject = this.this$0.d;
      if (i == 0) {
        break label84;
      }
    }
    label79:
    label84:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      return;
      i = 8;
      break;
      i = 0;
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.9
 * JD-Core Version:    0.7.0.1
 */