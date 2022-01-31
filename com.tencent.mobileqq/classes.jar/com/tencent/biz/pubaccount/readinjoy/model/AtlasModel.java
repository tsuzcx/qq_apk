package com.tencent.biz.pubaccount.readinjoy.model;

import java.io.Serializable;

public class AtlasModel
  implements Serializable
{
  public static final int TYPE_IMAGE = 1;
  public static final int TYPE_IMAGE_LIST = 3;
  public static final int TYPE_RECOMMEND_LIST = 2;
  public static final int TYPE_TOTAL_SIZE = 3;
  public String jumpUrl;
  public long modelEnterTime;
  public long modelExitTime;
  public long modelImageShowTime;
  public int picType;
  public int position;
  public int type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AtlasModel
 * JD-Core Version:    0.7.0.1
 */