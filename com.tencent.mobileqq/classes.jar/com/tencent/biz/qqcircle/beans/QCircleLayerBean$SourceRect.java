package com.tencent.biz.qqcircle.beans;

import java.io.Serializable;

public class QCircleLayerBean$SourceRect
  implements Serializable
{
  int bottom;
  int left;
  int right;
  int top;
  
  public QCircleLayerBean$SourceRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.left = paramInt1;
    this.top = paramInt2;
    this.right = paramInt3;
    this.bottom = paramInt4;
  }
  
  public int getBottom()
  {
    return this.bottom;
  }
  
  public int getLeft()
  {
    return this.left;
  }
  
  public int getRight()
  {
    return this.right;
  }
  
  public int getTop()
  {
    return this.top;
  }
  
  public void setBottom(int paramInt)
  {
    this.bottom = paramInt;
  }
  
  public void setLeft(int paramInt)
  {
    this.left = paramInt;
  }
  
  public void setRight(int paramInt)
  {
    this.right = paramInt;
  }
  
  public void setTop(int paramInt)
  {
    this.top = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCircleLayerBean.SourceRect
 * JD-Core Version:    0.7.0.1
 */