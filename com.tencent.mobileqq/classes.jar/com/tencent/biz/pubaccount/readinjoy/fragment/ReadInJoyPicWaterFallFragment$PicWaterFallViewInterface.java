package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.ExposureReportItem;
import java.util.Map;
import java.util.Set;

public abstract interface ReadInJoyPicWaterFallFragment$PicWaterFallViewInterface
  extends ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface<BaseArticleInfo>
{
  public abstract void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean);
  
  public abstract void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString);
  
  public abstract void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, String paramString);
  
  public abstract void b(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface
 * JD-Core Version:    0.7.0.1
 */