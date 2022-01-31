package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.ArrayList;
import java.util.List;

public class AtlasModelImageList
  extends AtlasModel
{
  public List imageList;
  
  public AtlasModelImageList(List paramList)
  {
    this.type = 3;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.imageList = ((List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImageList
 * JD-Core Version:    0.7.0.1
 */