package com.tencent.biz.qqcircle.beans;

import android.widget.ImageView.ScaleType;

public class QCircleLayerBean
  extends QCircleInitBean
{
  private String globalViewModelKey;
  private int imageHeight;
  private String imageUrl;
  private int imageWidth;
  private boolean isUseLoadingPic;
  private QCircleInitBean mTransInitBean;
  private int picPos;
  private ImageView.ScaleType scaleType;
  private QCircleLayerBean.SourceRect sourceRect;
  
  public String getGlobalViewModelKey()
  {
    return this.globalViewModelKey;
  }
  
  public int getImageHeight()
  {
    return this.imageHeight;
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public int getImageWidth()
  {
    return this.imageWidth;
  }
  
  public int getPicPos()
  {
    return this.picPos;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.scaleType;
  }
  
  public QCircleLayerBean.SourceRect getSourceRect()
  {
    return this.sourceRect;
  }
  
  public QCircleInitBean getTransInitBean()
  {
    return this.mTransInitBean;
  }
  
  public boolean isUseLoadingPic()
  {
    return this.isUseLoadingPic;
  }
  
  public void setGlobalViewModelKey(String paramString)
  {
    this.globalViewModelKey = paramString;
  }
  
  public void setImageHeight(int paramInt)
  {
    this.imageHeight = paramInt;
  }
  
  public void setImageUrl(String paramString)
  {
    this.imageUrl = paramString;
  }
  
  public void setImageWidth(int paramInt)
  {
    this.imageWidth = paramInt;
  }
  
  public void setPicPos(int paramInt)
  {
    this.picPos = paramInt;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    this.scaleType = paramScaleType;
  }
  
  public void setSourceRect(QCircleLayerBean.SourceRect paramSourceRect)
  {
    this.sourceRect = paramSourceRect;
  }
  
  public void setTransInitBean(QCircleInitBean paramQCircleInitBean)
  {
    this.mTransInitBean = paramQCircleInitBean;
  }
  
  public void setUseLoadingPic(boolean paramBoolean)
  {
    this.isUseLoadingPic = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCircleLayerBean
 * JD-Core Version:    0.7.0.1
 */