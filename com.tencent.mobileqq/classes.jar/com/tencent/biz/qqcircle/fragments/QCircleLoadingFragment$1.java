package com.tencent.biz.qqcircle.fragments;

import android.content.Intent;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;

class QCircleLoadingFragment$1
  implements Runnable
{
  QCircleLoadingFragment$1(QCircleLoadingFragment paramQCircleLoadingFragment, Intent paramIntent, long paramLong, int paramInt, String paramString) {}
  
  public void run()
  {
    QCircleLauncher.a(this.this$0.getActivity(), this.a.getExtras(), String.valueOf(this.b), this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleLoadingFragment.1
 * JD-Core Version:    0.7.0.1
 */