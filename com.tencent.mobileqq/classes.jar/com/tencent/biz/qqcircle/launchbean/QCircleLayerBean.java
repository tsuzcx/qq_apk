package com.tencent.biz.qqcircle.launchbean;

import android.widget.ImageView.ScaleType;

public class QCircleLayerBean
  extends QCircleInitBean
{
  private int imageHeight;
  private String imageUrl;
  private int imageWidth;
  private boolean isUseLoadingPic;
  private ImageView.ScaleType scaleType;
  private QCircleLayerBean.SourceRect sourceRect;
  
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
  
  public ImageView.ScaleType getScaleType()
  {
    return this.scaleType;
  }
  
  public QCircleLayerBean.SourceRect getSourceRect()
  {
    return this.sourceRect;
  }
  
  public boolean isUseLoadingPic()
  {
    return this.isUseLoadingPic;
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
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    this.scaleType = paramScaleType;
  }
  
  public void setSourceRect(QCircleLayerBean.SourceRect paramSourceRect)
  {
    this.sourceRect = paramSourceRect;
  }
  
  public void setUseLoadingPic(boolean paramBoolean)
  {
    this.isUseLoadingPic = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launchbean.QCircleLayerBean
 * JD-Core Version:    0.7.0.1
 */