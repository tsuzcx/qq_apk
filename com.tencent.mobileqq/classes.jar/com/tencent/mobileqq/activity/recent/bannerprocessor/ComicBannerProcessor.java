package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class ComicBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public ComicBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public int a()
  {
    return super.a();
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    paramBanner = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).inflate(2131558688, null);
    paramBanner.findViewById(2131362573).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 1134039)) {
      if (QLog.isColorLevel()) {
        QLog.d("ComicBar", 2, "updateComicBar msg " + paramMessage);
      }
    }
    TextView localTextView;
    String str;
    int j;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ComicBar", 2, "updateComicBar msg.obj = " + paramMessage.obj);
        }
        localTextView = (TextView)paramBanner.a.findViewById(2131362554);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("comicName");
      str = ((Bundle)localObject).getString("comicId");
      j = ((Bundle)localObject).getInt("type", -1);
    } while (TextUtils.isEmpty(paramMessage));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDisplayMetrics();
    int k = (int)(localTextView.getPaint().measureText(paramMessage) / paramMessage.length());
    int i;
    if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels)
    {
      i = ((DisplayMetrics)localObject).heightPixels;
      i = (int)((i - ((DisplayMetrics)localObject).density * 65.0F) / k) - 8;
      if (paramMessage.length() <= i) {
        break label429;
      }
      paramMessage = paramMessage.substring(0, i) + "...";
    }
    label429:
    for (;;)
    {
      if ((j >= 100) && (j <= 300)) {
        localTextView.setText(HardCodeUtil.a(2131700991) + paramMessage + "》");
      }
      for (;;)
      {
        paramBanner.a.setOnClickListener(new ComicBannerProcessor.1(this, str));
        paramBanner.a.findViewById(2131362573).setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1000);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1000, 900000L);
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDF", "0X8009EDF", 2, 0, "", "", "", "");
        return;
        i = ((DisplayMetrics)localObject).widthPixels;
        break;
        localTextView.setText(HardCodeUtil.a(2131701002) + paramMessage + "》");
      }
    }
  }
  
  public void b() {}
  
  public void b(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      BannerManager.a().a(33, 0, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ComicBannerProcessor
 * JD-Core Version:    0.7.0.1
 */