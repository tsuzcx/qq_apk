package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import bhys;
import bibw;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import twp;
import txh;

class ADVideoAppDownloadManager$3
  implements Runnable
{
  ADVideoAppDownloadManager$3(ADVideoAppDownloadManager paramADVideoAppDownloadManager, txh paramtxh, WeakReference paramWeakReference) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_Txh.d;
    String str1 = this.jdField_a_of_type_Txh.a;
    String str2 = this.jdField_a_of_type_Txh.e;
    Object localObject2;
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startRealDownload packageName:").append((String)localObject1).append(", appid:").append(str1).append(", appName:").append(str2);
        QLog.d("ADVideoAppDownloadManager", 2, ((StringBuilder)localObject2).toString());
      }
    }
    do
    {
      String str3;
      do
      {
        return;
        if ((TextUtils.isEmpty(this.jdField_a_of_type_Txh.c)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Txh.b))) {
          this.jdField_a_of_type_Txh.c = ADVideoAppDownloadManager.a(this.this$0, this.jdField_a_of_type_Txh.b, 1);
        }
        str3 = this.jdField_a_of_type_Txh.c;
        if (!TextUtils.isEmpty(str3)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "downloadUrl null");
      return;
      twp.a("ADVideoAppDownloadManager", "VideoDownloadUrl : " + str3);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString(bibw.f, (String)localObject1);
      ((Bundle)localObject2).putString(bibw.b, str1);
      ((Bundle)localObject2).putString(bibw.j, str3);
      ((Bundle)localObject2).putString(bibw.l, str2);
      ((Bundle)localObject2).putInt(bibw.k, 2);
      ((Bundle)localObject2).putInt(bibw.E, 0);
      ((Bundle)localObject2).putBoolean(bibw.x, false);
      ((Bundle)localObject2).putInt(bibw.H, 0);
      ((Bundle)localObject2).putBoolean(bibw.y, true);
      ((Bundle)localObject2).putBoolean(bibw.h, true);
      ((Bundle)localObject2).putBoolean(bibw.r, false);
      ((Bundle)localObject2).putBoolean(bibw.J, false);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Txh.f)) {
        ((Bundle)localObject2).putString(bibw.i, this.jdField_a_of_type_Txh.f);
      }
      ((Bundle)localObject2).putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, "startRealDownload pkg:" + (String)localObject1 + ", appid:" + str1 + ", name:" + str2 + ", url:" + str3);
      }
      this.this$0.a.remove(this.jdField_a_of_type_Txh);
      this.this$0.a.add(this.jdField_a_of_type_Txh);
      localObject1 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject1 != null) && (!((Activity)localObject1).isFinishing())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "ac=null");
    return;
    bhys.a().a((Activity)localObject1, (Bundle)localObject2, "biz_src_feeds_kandianads", null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */