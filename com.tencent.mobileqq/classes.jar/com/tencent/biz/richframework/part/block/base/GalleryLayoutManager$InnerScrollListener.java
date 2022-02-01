package com.tencent.biz.richframework.part.block.base;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

class GalleryLayoutManager$InnerScrollListener
  extends RecyclerView.OnScrollListener
{
  int a;
  boolean b;
  
  private GalleryLayoutManager$InnerScrollListener(GalleryLayoutManager paramGalleryLayoutManager) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    this.a = paramInt;
    if (this.a == 0)
    {
      View localView = GalleryLayoutManager.a(this.c).findSnapView(paramRecyclerView.getLayoutManager());
      if (localView != null)
      {
        paramInt = paramRecyclerView.getLayoutManager().getPosition(localView);
        if (paramInt != this.c.a)
        {
          if (this.c.b != null) {
            this.c.b.setSelected(false);
          }
          GalleryLayoutManager localGalleryLayoutManager = this.c;
          localGalleryLayoutManager.b = localView;
          localGalleryLayoutManager.b.setSelected(true);
          localGalleryLayoutManager = this.c;
          localGalleryLayoutManager.a = paramInt;
          if (GalleryLayoutManager.c(localGalleryLayoutManager) != null) {
            GalleryLayoutManager.c(this.c).a(paramRecyclerView, localView, this.c.a);
          }
        }
        else if ((!GalleryLayoutManager.b(this.c)) && (GalleryLayoutManager.c(this.c) != null) && (this.b))
        {
          this.b = false;
          GalleryLayoutManager.c(this.c).a(paramRecyclerView, localView, this.c.a);
        }
      }
      else
      {
        Log.e("GalleryLayoutManager", "onScrollStateChanged: snap null");
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    View localView = GalleryLayoutManager.a(this.c).findSnapView(paramRecyclerView.getLayoutManager());
    if (localView != null)
    {
      paramInt1 = paramRecyclerView.getLayoutManager().getPosition(localView);
      if (paramInt1 != this.c.a)
      {
        if (this.c.b != null) {
          this.c.b.setSelected(false);
        }
        GalleryLayoutManager localGalleryLayoutManager = this.c;
        localGalleryLayoutManager.b = localView;
        localGalleryLayoutManager.b.setSelected(true);
        localGalleryLayoutManager = this.c;
        localGalleryLayoutManager.a = paramInt1;
        if ((!GalleryLayoutManager.b(localGalleryLayoutManager)) && (this.a != 0))
        {
          this.b = true;
          return;
        }
        if (GalleryLayoutManager.c(this.c) != null) {
          GalleryLayoutManager.c(this.c).a(paramRecyclerView, localView, this.c.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.GalleryLayoutManager.InnerScrollListener
 * JD-Core Version:    0.7.0.1
 */