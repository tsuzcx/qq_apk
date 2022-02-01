package com.tencent.biz.pubaccount.readinjoy.reward.mvp;

import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskLocalRepo;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskRemoteRepo;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskRemoteRepo.IReportTaskProgressCallback;
import org.jetbrains.annotations.NotNull;

public class RIJRewardTaskTimingModel
  implements IRIJRewardTaskTimingContract.IModel
{
  public int a()
  {
    return RIJRewardTaskLocalRepo.b().b();
  }
  
  @Nullable
  public RIJRewardTask a()
  {
    return RIJRewardTaskLocalRepo.b().a();
  }
  
  public void a(int paramInt)
  {
    RIJRewardTaskLocalRepo.b().b(paramInt);
  }
  
  public void a(RIJRewardTask paramRIJRewardTask)
  {
    RIJRewardTaskLocalRepo.b().a(paramRIJRewardTask);
  }
  
  public void a(@NotNull String paramString)
  {
    RIJRewardTaskLocalRepo.b().a(paramString);
  }
  
  public void a(String paramString, int paramInt, RIJRewardTaskRemoteRepo.IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    RIJRewardTaskRemoteRepo.b().a(paramString, paramInt, new RIJRewardTaskTimingModel.1(this, paramIReportTaskProgressCallback));
  }
  
  public boolean a(@NotNull String paramString)
  {
    return RIJRewardTaskLocalRepo.b().a(paramString);
  }
  
  public int b()
  {
    return RIJRewardTaskLocalRepo.b().a();
  }
  
  @Nullable
  public RIJRewardTask b()
  {
    return RIJRewardTaskLocalRepo.b().b();
  }
  
  public void b(RIJRewardTask paramRIJRewardTask)
  {
    RIJRewardTaskLocalRepo.b().b(paramRIJRewardTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.mvp.RIJRewardTaskTimingModel
 * JD-Core Version:    0.7.0.1
 */