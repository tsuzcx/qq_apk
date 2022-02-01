package com.tencent.mobileqq.auto.engine.lib;

import java.io.Serializable;
import java.util.HashMap;

public class ASEnterBean
  implements Serializable
{
  private static final long serialVersionUID = 5838484954956837978L;
  private HashMap<String, String> mAttrs;
  private String mBusinessKey;
  private HashMap<String, byte[]> mByteAttrs;
  private int mLoadAction;
  private String mSchemeAction;
  private long mStartTime;
  
  public ASEnterBean(String paramString)
  {
    this.mBusinessKey = paramString;
  }
  
  public HashMap<String, String> getAttrs()
  {
    return this.mAttrs;
  }
  
  public String getBusinessKey()
  {
    return this.mBusinessKey;
  }
  
  public HashMap<String, byte[]> getByteAttrs()
  {
    return this.mByteAttrs;
  }
  
  public int getLoadAction()
  {
    return this.mLoadAction;
  }
  
  public String getSchemeAction()
  {
    return this.mSchemeAction;
  }
  
  public long getStartTime()
  {
    return this.mStartTime;
  }
  
  public ASEnterBean setAttrs(HashMap<String, String> paramHashMap)
  {
    this.mAttrs = paramHashMap;
    return this;
  }
  
  public ASEnterBean setByteAttrs(HashMap<String, byte[]> paramHashMap)
  {
    this.mByteAttrs = paramHashMap;
    return this;
  }
  
  public ASEnterBean setLoadAction(int paramInt)
  {
    this.mLoadAction = paramInt;
    return this;
  }
  
  public ASEnterBean setSchemeAction(String paramString)
  {
    this.mSchemeAction = paramString;
    return this;
  }
  
  public ASEnterBean setStartTime(long paramLong)
  {
    this.mStartTime = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.lib.ASEnterBean
 * JD-Core Version:    0.7.0.1
 */