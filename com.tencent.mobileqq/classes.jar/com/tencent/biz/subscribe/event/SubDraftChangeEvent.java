package com.tencent.biz.subscribe.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class SubDraftChangeEvent
  extends SimpleBaseEvent
{
  private String draftID;
  private boolean mIsSave;
  
  public String getDraftID()
  {
    return this.draftID;
  }
  
  public boolean getIsSave()
  {
    return this.mIsSave;
  }
  
  public void setDraftID(String paramString)
  {
    this.draftID = paramString;
  }
  
  public void setIsSave(boolean paramBoolean)
  {
    this.mIsSave = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.SubDraftChangeEvent
 * JD-Core Version:    0.7.0.1
 */