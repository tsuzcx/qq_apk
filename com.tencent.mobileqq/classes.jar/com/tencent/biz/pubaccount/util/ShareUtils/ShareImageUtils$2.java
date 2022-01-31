package com.tencent.biz.pubaccount.util.ShareUtils;

import ajed;
import bace;
import bacm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import mqq.os.MqqHandler;
import rvu;

public final class ShareImageUtils$2
  implements Runnable
{
  public void run()
  {
    String str = ajed.ba + Calendar.getInstance().getTime() + ".png";
    if (bace.a(rvu.a(), str))
    {
      QLog.d("ShareImageUtils", 1, "save to sdcard success");
      bacm.a(BaseApplicationImpl.getContext(), str);
      str = BaseApplicationImpl.getContext().getString(2131629509) + " " + str;
      ThreadManager.getUIHandler().post(new ShareImageUtils.2.1(this, str));
      return;
    }
    QLog.d("ShareImageUtils", 1, "save to sdcard fail");
    ThreadManager.getUIHandler().post(new ShareImageUtils.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils.2
 * JD-Core Version:    0.7.0.1
 */