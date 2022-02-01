package com.tencent.mobileqq.activity.recent.parcelUtils.processor;

import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class ParcelProcessorFactory
{
  public static BaseParcelProcessor a(Object paramObject)
  {
    if ((paramObject instanceof RecentBaseData)) {
      return new RecentDataParcelProcessor();
    }
    return new ParcelProcessor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.parcelUtils.processor.ParcelProcessorFactory
 * JD-Core Version:    0.7.0.1
 */