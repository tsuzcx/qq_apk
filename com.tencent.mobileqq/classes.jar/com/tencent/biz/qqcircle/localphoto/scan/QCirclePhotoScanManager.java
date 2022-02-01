package com.tencent.biz.qqcircle.localphoto.scan;

import android.app.Application;
import com.tencent.biz.qqcircle.localphoto.scan.datamanager.QCircleScanPhotoInfoManager;
import com.tencent.biz.qqcircle.utils.QCircleABTestUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class QCirclePhotoScanManager
{
  private QCirclePhotoScanner a;
  private boolean b = false;
  
  public static QCirclePhotoScanManager a()
  {
    return QCirclePhotoScanManager.Holder.a();
  }
  
  public static boolean f()
  {
    int i;
    if (QCircleConfigHelper.a("qqcircle", "qqcircle_album_show_video_template_banner", Integer.valueOf(1)).intValue() == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCirclePhotoScanManager", 2, "isPhotoSanAvailable:false, because wns setting close");
      }
      return false;
    }
    if (!QCircleABTestUtils.a("exp_qq_wezone_publisher_smartblockbuster"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCirclePhotoScanManager", 2, "isPhotoSanAvailable:false, because ABTest setting close");
      }
      return false;
    }
    try
    {
      i = Integer.parseInt(QCircleConfigHelper.a("qqcircle", "ae_auto_template_memory_limit", "4096"));
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse auto template limit size error ");
      localStringBuilder.append(localException);
      QLog.e("QCirclePhotoScanManager", 1, localStringBuilder.toString());
      i = 0;
    }
    if (i * 1024L * 1024L > ((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).getSystemTotalMemory())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCirclePhotoScanManager", 2, "isPhotoSanAvailable:false, because memory low");
      }
      return false;
    }
    return true;
  }
  
  private static boolean g()
  {
    boolean bool = "1".equals(QCircleConfigHelper.a("qqcircle", "recommend_video_template_profile_switch", "1"));
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.i("QCirclePhotoScanManager", 2, "isPhotoSanAvailable:false, because user setting close");
    }
    return bool;
  }
  
  public void b()
  {
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = QCircleConfigHelper.a("qqcircle", "qqcircle_local_photo_scan_duration", Integer.valueOf(90)).intValue() * 24 * 60 * 60;
    List localList = Arrays.asList(QCircleConfigHelper.a("qqcircle", "qqcircle_local_photo_scan_forbidden_dir", "MagazineUnlock,Screenshots").split(","));
    LocalPhotoCursor.Builder localBuilder = new LocalPhotoCursor.Builder().a(QCircleApplication.APP.getApplicationContext());
    boolean bool2 = false;
    Integer localInteger = Integer.valueOf(0);
    this.a = new QCirclePhotoScanner(localBuilder.a(QCircleConfigHelper.a("qqcircle", "qqcircle_local_photo_scan_min_size", localInteger).intValue()).b(QCircleConfigHelper.a("qqcircle", "qqcircle_local_photo_scan_max_size", localInteger).intValue()).a(l1 - l2).b(l1).c(QCircleConfigHelper.a("qqcircle", "qqcircle_local_photo_scan_amount", Integer.valueOf(1000)).intValue()).a(localList).a());
    boolean bool1 = bool2;
    if (f())
    {
      bool1 = bool2;
      if (g()) {
        bool1 = true;
      }
    }
    this.b = bool1;
    if (this.b) {
      QCircleScanPhotoInfoManager.a().b();
    }
  }
  
  public void c()
  {
    if (!this.b) {
      return;
    }
    this.a.a();
  }
  
  public void d()
  {
    if (!this.b) {
      return;
    }
    this.a.b();
  }
  
  public void e()
  {
    if (!this.b) {
      return;
    }
    this.a.a(QCirclePhotoScanner.StopReason.DESTROY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.QCirclePhotoScanManager
 * JD-Core Version:    0.7.0.1
 */