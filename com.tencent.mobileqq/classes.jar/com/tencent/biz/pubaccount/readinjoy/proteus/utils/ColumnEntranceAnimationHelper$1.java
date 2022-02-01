package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import android.animation.AnimatorSet;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import qgb;

public class ColumnEntranceAnimationHelper$1
  implements Runnable
{
  public ColumnEntranceAnimationHelper$1(qgb paramqgb, AbsListView paramAbsListView) {}
  
  public void run()
  {
    if ((!qgb.a(this.this$0)) && (qgb.a(this.this$0, (ReadInJoyXListView)this.a)))
    {
      qgb.a(this.this$0).start();
      qgb.a(this.this$0).setVisibility(0);
      if (qgb.a(this.this$0) != null) {
        qgb.a(this.this$0).isColumnAnimationPlay = true;
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