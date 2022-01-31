package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.ArrayList;
import java.util.List;

public class AtlasModelRecommend
  extends AtlasModel
{
  public List recommendGalleryList;
  
  public AtlasModelRecommend(List paramList)
  {
    this.type = 2;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.recommendGalleryList = ((List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AtlasModelRecommend
 * JD-Core Version:    0.7.0.1
 */