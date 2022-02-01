package com.tencent.mobileqq.activity.recent;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import cooperation.qzone.util.QZLog;

public class QbossADBannerConfigInfo$ResourceInfo
{
  public String a;
  public String b;
  public String c;
  
  public void a(boolean paramBoolean)
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QbossADBannerConfigInfo", 2, " qboss resources down response resUrl = " + this.a + " isSuccess = " + paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.c)) {
      return false;
    }
    return FileUtil.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo.ResourceInfo
 * JD-Core Version:    0.7.0.1
 */