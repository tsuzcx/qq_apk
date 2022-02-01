package com.tencent.mobileqq.ark.dict.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.ark.dict.ArkAiDictMgr;
import com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr;
import com.tencent.mobileqq.ark.dict.ArkRecommendLogic;
import com.tencent.mobileqq.ark.dict.TestSupport;
import com.tencent.mobileqq.ark.dict.WordSegmentResult;
import com.tencent.mobileqq.ark.dict.api.IArkDictManager;
import mqq.app.AppRuntime;

public class ArkDictManagerImpl
  implements IArkDictManager
{
  private AppRuntime appRuntime;
  private ArkAiDictMgr mDictMgr;
  private ArkAiDictUpdateMgr mDictUpdateMgr;
  
  public void clearDict()
  {
    this.mDictMgr.b();
  }
  
  public Handler getAnalysisThread()
  {
    return ArkRecommendLogic.a();
  }
  
  public void initWordData()
  {
    ArkAiDictMgr.a(this.appRuntime);
  }
  
  public boolean isUseTestDict()
  {
    return TestSupport.a();
  }
  
  public void loadTestDict()
  {
    this.mDictMgr.a();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
    this.mDictMgr = new ArkAiDictMgr();
    this.mDictUpdateMgr = new ArkAiDictUpdateMgr(paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void reloadWordData()
  {
    ArkAiDictMgr localArkAiDictMgr = this.mDictMgr;
    ArkAiDictMgr.b(this.appRuntime);
  }
  
  public void setUseTestDict(boolean paramBoolean)
  {
    TestSupport.a(paramBoolean);
  }
  
  public void updateLocalDict()
  {
    this.mDictUpdateMgr.a();
  }
  
  public WordSegmentResult wordSegment(String paramString)
  {
    return ArkAiDictMgr.a(this.appRuntime, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.api.impl.ArkDictManagerImpl
 * JD-Core Version:    0.7.0.1
 */