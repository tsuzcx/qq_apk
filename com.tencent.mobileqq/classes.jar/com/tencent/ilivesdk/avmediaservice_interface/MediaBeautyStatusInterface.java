package com.tencent.ilivesdk.avmediaservice_interface;

import com.tencent.ilive.beautyfilter.PTFilterItemInfo;
import java.util.List;

public abstract interface MediaBeautyStatusInterface
{
  public abstract void clearBeautyData();
  
  public abstract void clearFilterData();
  
  public abstract List<PTFilterItemInfo> getBeautyData();
  
  public abstract List<PTFilterItemInfo> getFilterData();
  
  public abstract void init();
  
  public abstract void save();
  
  public abstract void setBeautyData(List<PTFilterItemInfo> paramList);
  
  public abstract void setFilterData(List<PTFilterItemInfo> paramList);
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avmediaservice_interface.MediaBeautyStatusInterface
 * JD-Core Version:    0.7.0.1
 */