package com.tencent.biz.pubaccount.readinjoyAd.ad.atlas;

import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImage;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImageList;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

public class AtlasAdImageList
  extends AtlasModelImageList
{
  public AdvertisementInfo adInfo;
  public List<String> titles = new ArrayList();
  
  public AtlasAdImageList(gallery.GalleryInfo paramGalleryInfo, List<AtlasModelImage> paramList, boolean paramBoolean, int paramInt, String paramString)
  {
    super(paramGalleryInfo, paramList, paramBoolean, paramInt, paramString);
  }
  
  public void setImageList(List<AtlasModelImage> paramList)
  {
    this.imageList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.atlas.AtlasAdImageList
 * JD-Core Version:    0.7.0.1
 */