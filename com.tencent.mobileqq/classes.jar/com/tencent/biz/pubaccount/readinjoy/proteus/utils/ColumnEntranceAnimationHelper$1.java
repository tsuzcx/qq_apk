package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import android.animation.AnimatorSet;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class ColumnEntranceAnimationHelper$1
  implements Runnable
{
  ColumnEntranceAnimationHelper$1(ColumnEntranceAnimationHelper paramColumnEntranceAnimationHelper, AbsListView paramAbsListView) {}
  
  public void run()
  {
    if ((!ColumnEntranceAnimationHelper.a(this.this$0)) && (ColumnEntranceAnimationHelper.a(this.this$0, (ReadInJoyXListView)this.a)))
    {
      ColumnEntranceAnimationHelper.a(this.this$0).start();
      ColumnEntranceAnimationHelper.a(this.this$0).setVisibility(0);
      if (ColumnEntranceAnimationHelper.a(this.this$0) != null) {
        ColumnEntranceAnimationHelper.a(this.this$0).isColumnAnimationPlay = true;
      }
      this.this$0.a((ReadInJoyXListView)this.a);
      QLog.i("ColumnEntranceAnimationHelper", 1, "AnimationSet.start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.utils.ColumnEntranceAnimationHelper.1
 * JD-Core Version:    0.7.0.1
 */