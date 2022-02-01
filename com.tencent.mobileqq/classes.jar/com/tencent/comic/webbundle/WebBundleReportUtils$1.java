package com.tencent.comic.webbundle;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.statistics.DcReportUtil;

final class WebBundleReportUtils$1
  implements Runnable
{
  WebBundleReportUtils$1(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    String str2 = Build.BRAND;
    String str1 = "";
    if (str2 == null) {
      str2 = "";
    } else {
      str2 = Build.BRAND;
    }
    String str3;
    if (Build.MODEL == null) {
      str3 = "";
    } else {
      str3 = Build.BOARD;
    }
    String str4;
    if (Build.VERSION.RELEASE == null) {
      str4 = "";
    } else {
      str4 = Build.VERSION.RELEASE;
    }
    int k = HttpUtil.getNetWorkType();
    if (k != -1)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k == 4) {
              str1 = "4G";
            }
          }
          else {
            str1 = "3G";
          }
        }
        else {
          str1 = "2G";
        }
      }
      else {
        str1 = "WIFI";
      }
    }
    else {
      str1 = " UNKNOWN";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(str2);
    localStringBuffer.append('|');
    localStringBuffer.append(str3);
    localStringBuffer.append('|');
    localStringBuffer.append(str4);
    localStringBuffer.append('|');
    localStringBuffer.append(str1);
    localStringBuffer.append('|');
    localStringBuffer.append(this.a);
    localStringBuffer.append('|');
    localStringBuffer.append(this.b);
    localStringBuffer.append('|');
    localStringBuffer.append(this.c);
    localStringBuffer.append('|');
    localStringBuffer.append(this.d);
    localStringBuffer.append('|');
    localStringBuffer.append(this.e);
    localStringBuffer.append('|');
    localStringBuffer.append(this.f);
    localStringBuffer.append('|');
    localStringBuffer.append(this.g);
    localStringBuffer.append('|');
    localStringBuffer.append(this.h);
    localStringBuffer.append('|');
    localStringBuffer.append(this.i);
    localStringBuffer.append('|');
    localStringBuffer.append(this.j);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_sng_qq_comic|sng_mobileqq_times_statistics", localStringBuffer.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.webbundle.WebBundleReportUtils.1
 * JD-Core Version:    0.7.0.1
 */