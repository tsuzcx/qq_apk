package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import UserGrowth.stGetAllABTestPolicyRsp;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.request.WSGetABTestPolicyRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class WSExpDataModule
{
  private void a(WeishiTask paramWeishiTask, String paramString, IGetExperimentListener paramIGetExperimentListener, long paramLong)
  {
    ThreadManager.getSubThreadHandler().post(new WSExpDataModule.3(this, paramWeishiTask, paramString, paramIGetExperimentListener, paramLong));
  }
  
  private void b(WeishiTask paramWeishiTask, String paramString, IGetExperimentListener paramIGetExperimentListener, long paramLong)
  {
    paramLong = SystemClock.uptimeMillis() - paramLong;
    WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.g, "", false);
    if (!paramWeishiTask.b())
    {
      paramString = new StringBuilder();
      paramString.append("[WSExpDataModule.java][handleOnSubThread] failCode:");
      paramString.append(paramWeishiTask.d);
      paramString.append(", failMsg:");
      paramString.append(paramWeishiTask.c);
      WSLog.d("WSExpDataModule", paramString.toString());
      WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.g, paramWeishiTask.d, paramWeishiTask.c);
      if (paramIGetExperimentListener != null) {
        paramIGetExperimentListener.a(paramWeishiTask.d, paramWeishiTask.c);
      }
      return;
    }
    if (!(paramWeishiTask.m instanceof stGetAllABTestPolicyRsp))
    {
      paramString = new StringBuilder();
      paramString.append("[WSExpDataModule.java][handleOnSubThread] task.mResultBean instanceof stGetAllABTestPolicyRsp: false! task.mResultBean:");
      paramString.append(paramWeishiTask.m);
      WSLog.d("WSExpDataModule", paramString.toString());
      WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.g, -1, "数据无法解析或为空");
      if (paramIGetExperimentListener != null) {
        paramIGetExperimentListener.a(-1, "数据无法解析或为空");
      }
      return;
    }
    paramWeishiTask = (stGetAllABTestPolicyRsp)paramWeishiTask.m;
    if (paramIGetExperimentListener != null) {
      paramIGetExperimentListener.a(new WSExpPolicyEntities(paramString, paramWeishiTask));
    }
  }
  
  public void a(String paramString, IGetExperimentListener paramIGetExperimentListener)
  {
    ThreadManager.executeOnSubThread(new WSExpDataModule.1(this, paramString, paramIGetExperimentListener));
  }
  
  public void b(String paramString, IGetExperimentListener paramIGetExperimentListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSExpDataModule.java][fetchData] uin:");
    localStringBuilder.append(paramString);
    WSLog.e("WSExpDataModule", localStringBuilder.toString());
    paramIGetExperimentListener = new WSExpDataModule.2(this, paramString, paramIGetExperimentListener, SystemClock.uptimeMillis());
    paramString = new WeishiTask(new WSGetABTestPolicyRequest(paramString), null, paramIGetExperimentListener, 4016);
    WeishiBusinessLooper.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpDataModule
 * JD-Core Version:    0.7.0.1
 */