package com.tencent.imsdk.message;

import java.util.ArrayList;
import java.util.List;

public class MergerElement
  extends MessageBaseElement
{
  private List<String> abstractList = new ArrayList();
  private String compatibleText;
  private boolean layerOverLimit = false;
  private List<Message> messageList = new ArrayList();
  private int messageNumber;
  private byte[] relayBuffer;
  private String relayJsonKey;
  private String relayPbKey;
  private String title;
  
  public MergerElement()
  {
    setElementType(10);
  }
  
  protected void addAbstract(String paramString)
  {
    List localList = this.abstractList;
    if ((localList != null) && (paramString != null)) {
      localList.add(paramString);
    }
  }
  
  public List<String> getAbstractList()
  {
    return this.abstractList;
  }
  
  public String getCompatibleText()
  {
    return this.compatibleText;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public boolean isLayerOverLimit()
  {
    return this.layerOverLimit;
  }
  
  public void setAbstractList(List<String> paramList)
  {
    this.abstractList = paramList;
  }
  
  public void setCompatibleText(String paramString)
  {
    this.compatibleText = paramString;
  }
  
  public void setMessageList(List<Message> paramList)
  {
    this.messageList = paramList;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MergerElement
 * JD-Core Version:    0.7.0.1
 */