package com.tencent.mobileqq.activity.photo.album.preview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

public class AlbumItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  
  public AlbumItemDecoration(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = this.a;
    paramRect.left = i;
    paramRect.right = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.AlbumItemDecoration
 * JD-Core Version:    0.7.0.1
 */