package com.tencent.biz.subscribe.event;

public class SubDraftChangeEvent
  extends SimpleBaseEvent
{
  private String draftID;
  
  public String getDraftID()
  {
    return this.draftID;
  }
  
  public void setDraftID(String paramString)
  {
    this.draftID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.SubDraftChangeEvent
 * JD-Core Version:    0.7.0.1
 */