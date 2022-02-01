package com.tencent.mobileqq.apollo.view.pannel;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.qphone.base.util.QLog;

class ApolloPanelListAdapter$FrameCallback$1
  implements Runnable
{
  ApolloPanelListAdapter$FrameCallback$1(ApolloPanelListAdapter.FrameCallback paramFrameCallback) {}
  
  public void run()
  {
    QLog.i("ApolloPanelListAdapter", 4, "setBackgroundDrawable GetFrameCallback ");
    ApolloPanelListAdapter.FrameCallback.a(this.this$0).a.setBackgroundDrawable(ApolloPanelListAdapter.FrameCallback.a(this.this$0).getPanelDrawable(ApolloPanelListAdapter.FrameCallback.a(this.this$0), ApolloPanelListAdapter.FrameCallback.a(this.this$0).getResources().getDisplayMetrics().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListAdapter.FrameCallback.1
 * JD-Core Version:    0.7.0.1
 */