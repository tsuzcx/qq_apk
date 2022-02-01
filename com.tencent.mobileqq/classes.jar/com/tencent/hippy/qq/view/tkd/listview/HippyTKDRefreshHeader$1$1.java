package com.tencent.hippy.qq.view.tkd.listview;

import android.util.Log;

class HippyTKDRefreshHeader$1$1
  implements Runnable
{
  HippyTKDRefreshHeader$1$1(HippyTKDRefreshHeader.1 param1) {}
  
  public void run()
  {
    this.this$1.this$0.mCustomCompleteText = null;
    this.this$1.this$0.gm.getStringWidthHeight(this.this$1.this$0.mPullDownToRefreshTextSuc, this.this$1.this$0.mPullDownToRefreshTextSucTextSize);
    this.this$1.this$0.gm.getStringWidthHeight(this.this$1.this$0.mPullDownToRefreshTextFail, this.this$1.this$0.mPullDownToRefreshTextFailTextSize);
    this.this$1.this$0.mShowRefreshIcon = true;
    Log.d("QBRefreshHeader", "setRefreshState aa");
    this.this$1.this$0.setRefreshState(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.1.1
 * JD-Core Version:    0.7.0.1
 */