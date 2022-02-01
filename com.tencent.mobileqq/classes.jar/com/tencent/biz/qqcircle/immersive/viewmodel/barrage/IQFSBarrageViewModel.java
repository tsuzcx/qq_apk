package com.tencent.biz.qqcircle.immersive.viewmodel.barrage;

import android.content.Context;
import android.view.TextureView;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public abstract interface IQFSBarrageViewModel<T>
{
  public abstract void a();
  
  public abstract void a(Context paramContext, TextureView paramTextureView);
  
  public abstract void a(IQFSBarrageViewModel.OnBarrageLoadMoreListener paramOnBarrageLoadMoreListener);
  
  public abstract void a(IQFSBarrageViewModel.OnMeasureBarrageListener paramOnMeasureBarrageListener);
  
  public abstract void a(FeedCloudMeta.StFeed paramStFeed);
  
  public abstract void a(List<T> paramList, int paramInt, long paramLong);
  
  public abstract void a(List<T> paramList, int paramInt1, long paramLong, int paramInt2);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract int e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.IQFSBarrageViewModel
 * JD-Core Version:    0.7.0.1
 */