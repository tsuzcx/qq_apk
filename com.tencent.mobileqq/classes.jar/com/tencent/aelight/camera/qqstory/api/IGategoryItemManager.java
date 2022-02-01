package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGategoryItemManager
  extends QRouteApi
{
  public abstract String getItemName(Object paramObject);
  
  public abstract String getJumApp(Object paramObject);
  
  public abstract boolean isCombo(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IGategoryItemManager
 * JD-Core Version:    0.7.0.1
 */