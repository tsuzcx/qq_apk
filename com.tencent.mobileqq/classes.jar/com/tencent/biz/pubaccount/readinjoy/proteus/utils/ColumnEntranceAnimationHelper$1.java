package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import android.animation.AnimatorSet;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import ppy;

public class ColumnEntranceAnimationHelper$1
  implements Runnable
{
  public ColumnEntranceAnimationHelper$1(ppy paramppy, AbsListView paramAbsListView) {}
  
  public void run()
  {
    if ((!ppy.a(this.this$0)) && (ppy.a(this.this$0, (ReadInJoyXListView)this.a)))
    {
      ppy.a(this.this$0).start();
      ppy.a(this.this$0).setVisibility(0);
      if (ppy.a(this.this$0) != null) {
        ppy.a(this.this$0).isColumnAnimationPlay = true;
      }
      this.this$0.a((ReadInJoyXListView)this.a);
      QLog.i("ColumnEntranceAnimationHelper", 1, "AnimationSet.start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.utils.ColumnEntranceAnimationHelper.1
 * JD-Core Version:    0.7.0.1
 */