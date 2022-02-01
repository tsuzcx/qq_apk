package com.huawei.updatesdk.service.appmgr.bean;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.c.d;
import com.huawei.updatesdk.a.a.c.g;
import com.huawei.updatesdk.a.b.d.a.b;
import com.huawei.updatesdk.service.e.c;
import java.util.Locale;

public class a$b
  extends b
{
  private static final String FILE_SHA_KEY = "fileshakey";
  private static final String PACKAGE_KEY = "packagekey";
  private String fSha2_;
  private int isPre_;
  private int maple_;
  private String oldVersion_;
  private String package_;
  private String sSha2_;
  private int targetSdkVersion_;
  private int versionCode_;
  
  public a$b() {}
  
  public a$b(PackageInfo paramPackageInfo)
  {
    this.package_ = paramPackageInfo.packageName;
    this.versionCode_ = paramPackageInfo.versionCode;
    if (paramPackageInfo.versionName == null) {}
    String str2;
    for (String str1 = "null";; str1 = paramPackageInfo.versionName)
    {
      this.oldVersion_ = str1;
      this.targetSdkVersion_ = paramPackageInfo.applicationInfo.targetSdkVersion;
      this.isPre_ = a.a(paramPackageInfo);
      this.maple_ = c.b(this.package_);
      if (paramPackageInfo.signatures != null)
      {
        str1 = g.c(com.huawei.updatesdk.a.a.c.a.a(g.d(paramPackageInfo.signatures[0].toCharsString())));
        if (!TextUtils.isEmpty(str1)) {
          this.sSha2_ = str1.toLowerCase(Locale.getDefault());
        }
      }
      str1 = "packagekey" + this.package_;
      str2 = "fileshakey" + this.package_;
      if (!TextUtils.isEmpty(paramPackageInfo.applicationInfo.sourceDir)) {
        break;
      }
      this.fSha2_ = null;
      com.huawei.updatesdk.service.a.a.a().d(str1);
      com.huawei.updatesdk.service.a.a.a().d(str2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPackageInfo.lastUpdateTime).append(paramPackageInfo.versionCode).append(this.package_);
    if (!TextUtils.equals(localStringBuilder.toString(), com.huawei.updatesdk.service.a.a.a().c(str1))) {
      i = 1;
    }
    if (i != 0) {
      com.huawei.updatesdk.service.a.a.a().a(str1, localStringBuilder.toString());
    }
    str1 = com.huawei.updatesdk.service.a.a.a().c(str2);
    if ((TextUtils.isEmpty(str1)) || (i != 0))
    {
      str1 = d.a(paramPackageInfo.applicationInfo.sourceDir, "SHA-256");
      com.huawei.updatesdk.service.a.a.a().a(str2, str1);
    }
    this.fSha2_ = str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.appmgr.bean.a.b
 * JD-Core Version:    0.7.0.1
 */