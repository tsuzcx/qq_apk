package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc00307;
import cooperation.qzone.report.lp.LpReportManager;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClassConstructor
public class RunningBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  private boolean a;
  
  public RunningBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RunningBar", 2, "initRunningBar");
    }
    paramBanner = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.setTipsText(HardCodeUtil.a(2131701006));
    paramBanner.b(true);
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130838472));
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(37, 0);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    Object localObject2 = null;
    if (paramMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("runningState", 2, "updateRunningBar msg " + paramMessage);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RunningBar", 2, "updateRunningBar msg.obj = " + paramMessage.obj);
      }
      if ((paramMessage.obj instanceof JSONObject)) {}
      try
      {
        Long localLong = Long.valueOf(((JSONObject)paramMessage.obj).getLong("runningState"));
        Object localObject1 = ((JSONObject)paramMessage.obj).getString("cookieUrl");
        String str = ((JSONObject)paramMessage.obj).optString("title");
        ((JSONObject)paramMessage.obj).optInt("actid");
        int i = ((JSONObject)paramMessage.obj).optInt("appid");
        if (localLong.longValue() == 1L)
        {
          ((TipsBar)paramBanner.a).setTipsText(HardCodeUtil.a(2131701003));
          localObject1 = (String)localObject1 + "&ADTAG=aio.run.click";
        }
        for (;;)
        {
          paramBanner.a.setOnClickListener(new RunningBannerProcessor.1(this, (String)localObject1, localLong, i));
          if (localLong.longValue() == 3L)
          {
            localObject1 = new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_EXPOSURE, i);
            LpReportManager.getInstance().reportToDC00307((LpReportInfo_dc00307)localObject1, false, true);
          }
          if ((paramBanner.a instanceof TipsBar)) {
            ((TipsBar)paramBanner.a).setCloseListener(new RunningBannerProcessor.2(this));
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramBanner = new Bundle();
            paramMessage.obj = paramBanner;
            paramMessage = Message.obtain(paramMessage);
            ImageLoader.a().a((String)localObject2, new RunningBannerProcessor.3(this, paramBanner, paramMessage));
          }
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDF", "0X8009EDF", 9, 0, "", "", "", "");
          return;
          if (localLong.longValue() == 2L)
          {
            ((TipsBar)paramBanner.a).setTipsText(HardCodeUtil.a(2131700995));
            localObject1 = (String)localObject1 + "&ADTAG=aio.run.click";
          }
          else
          {
            if (localLong.longValue() == 3L)
            {
              ((TipsBar)paramBanner.a).setTipsText(str);
              localObject1 = (String)localObject1 + "&ADTAG=qqlist.tongzhi.hongbao.click";
              localObject2 = ((JSONObject)paramMessage.obj).optString("icon");
              continue;
              if (!(paramMessage.obj instanceof Bundle)) {
                break;
              }
              paramMessage = (Bundle)paramMessage.obj;
              if (!paramMessage.containsKey("icon")) {
                break;
              }
              paramMessage = (Bitmap)paramMessage.getParcelable("icon");
              ((TipsBar)paramBanner.a).setTipsIcon(new BitmapDrawable(paramMessage));
              return;
            }
            localObject1 = null;
          }
        }
        return;
      }
      catch (JSONException paramBanner) {}
    }
  }
  
  public void b() {}
  
  public void b(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3000) {
      BannerManager.a().a(37, 0, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.RunningBannerProcessor
 * JD-Core Version:    0.7.0.1
 */