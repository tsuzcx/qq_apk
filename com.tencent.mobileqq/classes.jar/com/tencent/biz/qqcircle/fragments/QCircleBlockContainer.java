package com.tencent.biz.qqcircle.fragments;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;

public class QCircleBlockContainer
  extends BlockContainer
{
  public QCircleBlockContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleBlockContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleBlockContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QCircleBlockMerger a()
  {
    return new QCircleBlockMerger(this);
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return this.a.canScrollVertically(paramInt);
  }
  
  public QCircleBlockMerger getBlockMerger()
  {
    if ((this.b instanceof QCircleBlockMerger)) {
      return (QCircleBlockMerger)this.b;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBlockContainer
 * JD-Core Version:    0.7.0.1
 */