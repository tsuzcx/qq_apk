package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import org.json.JSONArray;

public abstract interface PolymericContainer
{
  public abstract EventCallback getEventCallback();
  
  public abstract void setCellArray(BaseTemplateFactory paramBaseTemplateFactory, JSONArray paramJSONArray);
  
  public abstract void setEventCallback(EventCallback paramEventCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.PolymericContainer
 * JD-Core Version:    0.7.0.1
 */