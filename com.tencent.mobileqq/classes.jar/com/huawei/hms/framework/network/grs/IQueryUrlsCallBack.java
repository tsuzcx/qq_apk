package com.huawei.hms.framework.network.grs;

import java.util.Map;

public abstract interface IQueryUrlsCallBack
{
  public abstract void onCallBackFail(int paramInt);
  
  public abstract void onCallBackSuccess(Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.IQueryUrlsCallBack
 * JD-Core Version:    0.7.0.1
 */