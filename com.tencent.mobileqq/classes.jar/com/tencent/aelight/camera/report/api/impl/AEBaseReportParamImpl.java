package com.tencent.aelight.camera.report.api.impl;

import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import org.jetbrains.annotations.Nullable;

public class AEBaseReportParamImpl
  implements IAEBaseReportParam
{
  public void clearLatestPostMd5()
  {
    AEBaseReportParam.a().C();
  }
  
  public boolean getGifMode()
  {
    return AEBaseReportParam.a().g();
  }
  
  public String getIntentUidKey()
  {
    return "intent_key_uid_for_report";
  }
  
  public void resetEditInfo()
  {
    AEBaseReportParam.a().h();
  }
  
  public void setContentType(long paramLong)
  {
    AEBaseReportParam.a().b(paramLong);
  }
  
  public void setEditHasCut(boolean paramBoolean)
  {
    AEBaseReportParam.a().c(paramBoolean);
  }
  
  public void setEditHasGraffiti(boolean paramBoolean) {}
  
  public void setEditMusicId(String paramString)
  {
    AEBaseReportParam.a().o(paramString);
  }
  
  public void setEditSpeedChanged(boolean paramBoolean)
  {
    AEBaseReportParam.a().d(paramBoolean);
  }
  
  public void setEditStickerIds(String paramString)
  {
    AEBaseReportParam.a().k(paramString);
  }
  
  public void setEditTextIds(String paramString)
  {
    AEBaseReportParam.a().l(paramString);
  }
  
  public void setEntry(int paramInt, String paramString)
  {
    AEBaseReportParam.a().a(paramInt, paramString);
  }
  
  public void setExperimentID(String paramString)
  {
    AEBaseReportParam.a().d(paramString);
  }
  
  public void setFilterId(String paramString)
  {
    AEBaseReportParam.a().j(paramString);
  }
  
  public void setNetWork()
  {
    AEBaseReportParam.a().d();
  }
  
  public void setOprationTime()
  {
    AEBaseReportParam.a().b();
  }
  
  public void setShootTime()
  {
    AEBaseReportParam.a().m();
  }
  
  public void setUin(@Nullable String paramString)
  {
    AEBaseReportParam.a().c(paramString);
  }
  
  public void setVideoDuration(long paramLong)
  {
    AEBaseReportParam.a().a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.report.api.impl.AEBaseReportParamImpl
 * JD-Core Version:    0.7.0.1
 */