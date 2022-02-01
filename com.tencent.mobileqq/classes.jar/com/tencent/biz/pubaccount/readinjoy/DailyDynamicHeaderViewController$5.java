package com.tencent.biz.pubaccount.readinjoy;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class DailyDynamicHeaderViewController$5
  extends LbsManagerServiceOnLocationChangeListener
{
  DailyDynamicHeaderViewController$5(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    QLog.i("DailyHeaderViewController", 1, "[onLocationFinish] errCode=" + paramInt + "");
    ThreadManagerV2.getUIHandlerV2().post(new DailyDynamicHeaderViewController.5.1(this, paramInt, paramSosoLbsInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.5
 * JD-Core Version:    0.7.0.1
 */