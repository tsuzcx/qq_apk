package com.tencent.biz.pubaccount.readinjoy.view.proteus.expand;

import android.support.annotation.Nullable;
import android.view.View;
import java.util.Map;

public abstract interface IProteusDtReporter
{
  public abstract void handleProteusViewClick(View paramView);
  
  public abstract void setDtElementIdWithParams(View paramView, String paramString, @Nullable Map<String, Object> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.expand.IProteusDtReporter
 * JD-Core Version:    0.7.0.1
 */