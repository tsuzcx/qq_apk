package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.text.TextUtils;
import anhk;
import bgmg;
import bhgg;
import bisz;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ViolaBaseView$6
  implements Runnable
{
  ViolaBaseView$6(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    String str = bhgg.a(anhk.cG + bisz.a(new StringBuilder().append("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559&time=").append(System.currentTimeMillis()).toString()) + ".zip");
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.e(ViolaBaseView.a(), 2, "loadSOFromNet [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559] get localPath error, download cancel");
      }
      return;
    }
    if (new File(str).exists()) {
      bgmg.d(str);
    }
    boolean bool = HttpDownloadUtil.a(null, "https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559", new File(str));
    QLog.d(ViolaBaseView.a(), 2, "loadSOFromNet [ url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559] Download to " + str + ",isSuss:" + bool);
    if ((bool) && (new File(str).exists()))
    {
      ViolaBaseView.a(this.this$0, str);
      return;
    }
    ViolaBaseView.a(this.this$0, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.6
 * JD-Core Version:    0.7.0.1
 */