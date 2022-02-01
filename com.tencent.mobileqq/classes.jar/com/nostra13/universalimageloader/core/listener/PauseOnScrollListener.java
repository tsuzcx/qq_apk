package com.nostra13.universalimageloader.core.listener;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PauseOnScrollListener
  implements AbsListView.OnScrollListener
{
  private final AbsListView.OnScrollListener externalListener;
  private ImageLoader imageLoader;
  private final boolean pauseOnFling;
  private final boolean pauseOnScroll;
  
  public PauseOnScrollListener(ImageLoader paramImageLoader, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramImageLoader, paramBoolean1, paramBoolean2, null);
  }
  
  public PauseOnScrollListener(ImageLoader paramImageLoader, boolean paramBoolean1, boolean paramBoolean2, AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.imageLoader = paramImageLoader;
    this.pauseOnScroll = paramBoolean1;
    this.pauseOnFling = paramBoolean2;
    this.externalListener = paramOnScrollListener;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.externalListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt == 2) && (this.pauseOnFling)) {
          this.imageLoader.pause();
        }
      }
      else if (this.pauseOnScroll) {
        this.imageLoader.pause();
      }
    }
    else {
      this.imageLoader.resume();
    }
    AbsListView.OnScrollListener localOnScrollListener = this.externalListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.listener.PauseOnScrollListener
 * JD-Core Version:    0.7.0.1
 */