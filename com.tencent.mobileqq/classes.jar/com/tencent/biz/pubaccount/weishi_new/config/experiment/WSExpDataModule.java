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
    WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, "", false);
    if (!paramWeishiTask.a())
    {
      WSLog.d("WSExpDataModule", "[WSExpDataModule.java][handleOnSubThread] failCode:" + paramWeishiTask.jdField_a_of_type_Int + ", failMsg:" + paramWeishiTask.jdField_a_of_type_JavaLangString);
      WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
      if (paramIGetExperimentListener != null) {
        paramIGetExperimentListener.a(paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      do
      {
        return;
        if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stGetAllABTestPolicyRsp)) {
          break;
        }
        WSLog.d("WSExpDataModule", "[WSExpDataModule.java][handleOnSubThread] task.mResultBean instanceof stGetAllABTestPolicyRsp: false! task.mResultBean:" + paramWeishiTask.jdField_a_of_type_JavaLangObject);
        WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, -1, "数据无法解析或为空");
      } while (paramIGetExperimentListener == null);
      paramIGetExperimentListener.a(-1, "数据无法解析或为空");
      return;
      paramWeishiTask = (stGetAllABTestPolicyRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
    } while (paramIGetExperimentListener == null);
    paramIGetExperimentListener.a(new WSExpPolicyEntities(paramString, paramWeishiTask));
  }
  
  public void a(String paramString, IGetExperimentListener paramIGetExperimentListener)
  {
    ThreadManager.executeOnSubThread(new WSExpDataModule.1(this, paramString, paramIGetExperimentListener));
  }
  
  public void b(String paramString, IGetExperimentListener paramIGetExperimentListener)
  {
    WSLog.e("WSExpDataModule", "[WSExpDataModule.java][fetchData] uin:" + paramString);
    paramIGetExperimentListener = new WSExpDataModule.2(this, paramString, paramIGetExperimentListener, SystemClock.uptimeMillis());
    paramString = new WeishiTask(new WSGetABTestPolicyRequest(paramString), null, paramIGetExperimentListener, 4016);
    WeishiBusinessLooper.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpDataModule
 * JD-Core Version:    0.7.0.1
 */