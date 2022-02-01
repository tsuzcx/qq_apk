package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.MsgTabBannerData;
import com.tencent.mobileqq.activity.springfestival.entry.model.PopBannerData;

public abstract interface ITaskCallback
{
  public abstract void a(long paramLong, BaseActivityData paramBaseActivityData);
  
  public abstract void a(BaseActivityData paramBaseActivityData);
  
  public abstract void a(MsgTabBannerData paramMsgTabBannerData);
  
  public abstract void a(PopBannerData paramPopBannerData);
  
  public abstract void b(long paramLong, BaseActivityData paramBaseActivityData);
  
  public abstract void b(BaseActivityData paramBaseActivityData);
  
  public abstract void b(MsgTabBannerData paramMsgTabBannerData);
  
  public abstract void b(PopBannerData paramPopBannerData);
  
  public abstract void c(BaseActivityData paramBaseActivityData);
  
  public abstract void d(BaseActivityData paramBaseActivityData);
  
  public abstract void e(BaseActivityData paramBaseActivityData);
  
  public abstract void f(BaseActivityData paramBaseActivityData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ITaskCallback
 * JD-Core Version:    0.7.0.1
 */