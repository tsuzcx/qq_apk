package com.tencent.aelight.camera.report.api.impl;

import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import org.jetbrains.annotations.Nullable;

public class AEBaseReportParamImpl
  implements IAEBaseReportParam
{
  public void clearLatestPostMd5()
  {
    AEBaseReportParam.a().f();
  }
  
  public boolean getGifMode()
  {
    return AEBaseReportParam.a().b();
  }
  
  public String getIntentUidKey()
  {
    return "intent_key_uid_for_report";
  }
  
  public void resetEditInfo()
  {
    AEBaseReportParam.a().c();
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
    AEBaseReportParam.a().l(paramString);
  }
  
  public void setEditSpeedChanged(boolean paramBoolean)
  {
    AEBaseReportParam.a().d(paramBoolean);
  }
  
  public void setEditStickerIds(String paramString)
  {
    AEBaseReportParam.a().h(paramString);
  }
  
  public void setEditTextIds(String paramString)
  {
    AEBaseReportParam.a().i(paramString);
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
    AEBaseReportParam.a().g(paramString);
  }
  
  public void setNetWork()
  {
    AEBaseReportParam.a().b();
  }
  
  public void setOprationTime()
  {
    AEBaseReportParam.a().a();
  }
  
  public void setShootTime()
  {
    AEBaseReportParam.a().e();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.report.api.impl.AEBaseReportParamImpl
 * JD-Core Version:    0.7.0.1
 */