package com.tencent.biz.pubaccount.readinjoy.model;

import tencent.im.oidb.gallery.gallery.PictureInfo;

public class AtlasModelImage
  extends AtlasModel
{
  public gallery.PictureInfo pictureInfo;
  public String rowKey;
  
  public AtlasModelImage(String paramString, gallery.PictureInfo paramPictureInfo)
  {
    this.type = 1;
    this.rowKey = paramString;
    this.pictureInfo = paramPictureInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof AtlasModel))
    {
      paramObject = (AtlasModel)paramObject;
      if (((paramObject.type == this.type) && (paramObject.position == this.position) && (this.jumpUrl == paramObject.jumpUrl)) || ((this.jumpUrl != null) && (this.jumpUrl.equals(paramObject.jumpUrl)))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImage
 * JD-Core Version:    0.7.0.1
 */