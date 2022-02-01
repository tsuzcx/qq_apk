package com.tencent.biz.qqcircle.fragments.content;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class QCircleContentVerticalAdapter$VerticalVH
  extends RecyclerView.ViewHolder
{
  public final QCircleContentOperationView a;
  public QCircleContentHorizontalAdapter b;
  public RecyclerView c;
  private int d;
  
  public QCircleContentVerticalAdapter$VerticalVH(View paramView)
  {
    super(paramView);
    paramView = (FrameLayout)paramView;
    this.c = ((RecyclerView)paramView.getChildAt(0));
    this.b = ((QCircleContentHorizontalAdapter)this.c.getAdapter());
    this.a = ((QCircleContentOperationView)paramView.getChildAt(1));
    this.b.a(this.a);
  }
  
  public QCircleContentHorizontalAdapter a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public RecyclerView b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVerticalAdapter.VerticalVH
 * JD-Core Version:    0.7.0.1
 */