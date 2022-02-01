package com.tencent.mobileqq.ark.dict.api;

import android.os.Handler;
import com.tencent.mobileqq.ark.dict.WordSegmentResult;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface IArkDictManager
  extends IRuntimeService
{
  public abstract void clearDict();
  
  public abstract Handler getAnalysisThread();
  
  public abstract void initWordData();
  
  public abstract boolean isUseTestDict();
  
  public abstract void loadTestDict();
  
  public abstract void reloadWordData();
  
  public abstract void setUseTestDict(boolean paramBoolean);
  
  public abstract void updateLocalDict();
  
  public abstract WordSegmentResult wordSegment(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.api.IArkDictManager
 * JD-Core Version:    0.7.0.1
 */