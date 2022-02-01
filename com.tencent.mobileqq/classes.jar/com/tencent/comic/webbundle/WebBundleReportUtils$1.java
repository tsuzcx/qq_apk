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
    int i = HttpUtil.getNetWorkType();
    if (i != -1)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4) {
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
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append('|');
    localStringBuffer.append(this.jdField_b_of_type_JavaLangString);
    localStringBuffer.append('|');
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append('|');
    localStringBuffer.append(this.jdField_b_of_type_Int);
    localStringBuffer.append('|');
    localStringBuffer.append(this.jdField_c_of_type_Int);
    localStringBuffer.append('|');
    localStringBuffer.append(this.jdField_d_of_type_Int);
    localStringBuffer.append('|');
    localStringBuffer.append(this.jdField_c_of_type_JavaLangString);
    localStringBuffer.append('|');
    localStringBuffer.append(this.jdField_d_of_type_JavaLangString);
    localStringBuffer.append('|');
    localStringBuffer.append(this.e);
    localStringBuffer.append('|');
    localStringBuffer.append(this.f);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_sng_qq_comic|sng_mobileqq_times_statistics", localStringBuffer.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.webbundle.WebBundleReportUtils.1
 * JD-Core Version:    0.7.0.1
 */