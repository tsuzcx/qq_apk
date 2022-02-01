package com.tencent.biz.pubaccount.readinjoy.reward.mvp;

import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlClientRedPacketModule;
import org.jetbrains.annotations.NotNull;

public class RIJRewardTaskTimingModelForTool
  implements IRIJRewardTaskTimingContract.IModel
{
  public int a()
  {
    return RIJAidlClientRedPacketModule.a();
  }
  
  @Nullable
  public RIJRewardTask a()
  {
    return RIJAidlClientRedPacketModule.a();
  }
  
  public void a(int paramInt)
  {
    RIJAidlClientRedPacketModule.a(paramInt);
  }
  
  public void a(@Nullable RIJRewardTask paramRIJRewardTask)
  {
    RIJAidlClientRedPacketModule.a(paramRIJRewardTask);
  }
  
  public void a(@NotNull String paramString)
  {
    RIJAidlClientRedPacketModule.a(paramString);
  }
  
  public void a(String paramString, int paramInt, RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    RIJAidlClientRedPacketModule.a(paramString, paramInt, paramIReportTaskProgressCallback);
  }
  
  public boolean a(@NotNull String paramString)
  {
    return RIJAidlClientRedPacketModule.a(paramString);
  }
  
  public int b()
  {
    return RIJAidlClientRedPacketModule.b();
  }
  
  @Nullable
  public RIJRewardTask b()
  {
    return RIJAidlClientRedPacketModule.b();
  }
  
  public void b(RIJRewardTask paramRIJRewardTask)
  {
    RIJAidlClientRedPacketModule.b(paramRIJRewardTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.mvp.RIJRewardTaskTimingModelForTool
 * JD-Core Version:    0.7.0.1
 */