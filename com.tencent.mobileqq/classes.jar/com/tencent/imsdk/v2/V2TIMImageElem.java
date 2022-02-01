package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.ImageElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class V2TIMImageElem
  extends V2TIMElem
{
  public static final int V2TIM_IMAGE_TYPE_LARGE = 2;
  public static final int V2TIM_IMAGE_TYPE_ORIGIN = 0;
  public static final int V2TIM_IMAGE_TYPE_THUMB = 1;
  private ImageElement timImageElem;
  
  public List<V2TIMImageElem.V2TIMImage> getImageList()
  {
    if (getElement() == null) {
      return null;
    }
    this.timImageElem = ((ImageElement)getElement());
    ArrayList localArrayList = new ArrayList();
    V2TIMImageElem.V2TIMImage localV2TIMImage = new V2TIMImageElem.V2TIMImage(this);
    localV2TIMImage.setUUID(this.timImageElem.getOriginImageUUID());
    localV2TIMImage.setType(0);
    localV2TIMImage.setSize(this.timImageElem.getOriginImageFileSize());
    localV2TIMImage.setWidth(this.timImageElem.getOriginImageWidth());
    localV2TIMImage.setHeight(this.timImageElem.getOriginImageHeight());
    localV2TIMImage.setUrl(this.timImageElem.getOriginImageUrl());
    localArrayList.add(localV2TIMImage);
    localV2TIMImage = new V2TIMImageElem.V2TIMImage(this);
    localV2TIMImage.setUUID(this.timImageElem.getLargeImageUUID());
    localV2TIMImage.setType(2);
    localV2TIMImage.setSize(this.timImageElem.getLargeImageFileSize());
    localV2TIMImage.setWidth(this.timImageElem.getLargeImageWidth());
    localV2TIMImage.setHeight(this.timImageElem.getLargeImageHeight());
    localV2TIMImage.setUrl(this.timImageElem.getLargeImageUrl());
    localArrayList.add(localV2TIMImage);
    localV2TIMImage = new V2TIMImageElem.V2TIMImage(this);
    localV2TIMImage.setUUID(this.timImageElem.getThumbImageUUID());
    localV2TIMImage.setType(1);
    localV2TIMImage.setSize(this.timImageElem.getThumbImageFileSize());
    localV2TIMImage.setWidth(this.timImageElem.getThumbImageWidth());
    localV2TIMImage.setHeight(this.timImageElem.getThumbImageHeight());
    localV2TIMImage.setUrl(this.timImageElem.getThumbImageUrl());
    localArrayList.add(localV2TIMImage);
    return localArrayList;
  }
  
  public String getPath()
  {
    if (getElement() == null) {
      return null;
    }
    this.timImageElem = ((ImageElement)getElement());
    return this.timImageElem.getOriginImageFilePath();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("V2TIMImageElem--->");
    localStringBuilder1.append(", localPath=");
    localStringBuilder1.append(getPath());
    Iterator localIterator = getImageList().iterator();
    while (localIterator.hasNext())
    {
      V2TIMImageElem.V2TIMImage localV2TIMImage = (V2TIMImageElem.V2TIMImage)localIterator.next();
      localStringBuilder1.append(", type:");
      localStringBuilder1.append(localV2TIMImage.getType());
      localStringBuilder1.append(", uuid:");
      localStringBuilder1.append(localV2TIMImage.getUUID());
      localStringBuilder1.append(", height:");
      localStringBuilder1.append(localV2TIMImage.getHeight());
      localStringBuilder1.append(", width:");
      localStringBuilder1.append(localV2TIMImage.getWidth());
      localStringBuilder1.append(", size:");
      localStringBuilder1.append(localV2TIMImage.getSize());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", url:");
      localStringBuilder2.append(localV2TIMImage.getUrl());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMImageElem
 * JD-Core Version:    0.7.0.1
 */