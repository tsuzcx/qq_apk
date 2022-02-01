package com.tencent.biz.qqcircle.fragments;

import android.os.Handler;
import com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.qphone.base.util.QLog;

public class QCircleBlockMerger
  extends BlockMerger
{
  public QCircleBlockMerger(BlockContainer paramBlockContainer)
  {
    super(paramBlockContainer);
    a(new RefreshHeaderView(paramBlockContainer.getContext()));
  }
  
  public void a()
  {
    if ((this.k != null) && (r() != null))
    {
      QLog.d("CMADebugTAG", 4, "onShowRefreshAnim");
      r().setState(4);
      this.a.post(new QCircleBlockMerger.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBlockMerger
 * JD-Core Version:    0.7.0.1
 */