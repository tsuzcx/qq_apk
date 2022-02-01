package com.tencent.mobileqq.ar.view;

import android.widget.LinearLayout;

class ScanEntryProviderContainerView$7
  implements Runnable
{
  ScanEntryProviderContainerView$7(ScanEntryProviderContainerView paramScanEntryProviderContainerView, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.e != null)
    {
      LinearLayout localLinearLayout = this.this$0.e;
      int i;
      if (this.a) {
        i = 0;
      } else {
        i = 8;
      }
      localLinearLayout.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.7
 * JD-Core Version:    0.7.0.1
 */