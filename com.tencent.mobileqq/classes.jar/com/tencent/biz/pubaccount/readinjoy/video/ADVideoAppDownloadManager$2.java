package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import bfkv;
import bfoh;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import qyj;

class ADVideoAppDownloadManager$2
  implements Runnable
{
  ADVideoAppDownloadManager$2(ADVideoAppDownloadManager paramADVideoAppDownloadManager, qyj paramqyj, WeakReference paramWeakReference) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_Qyj.d;
    String str1 = this.jdField_a_of_type_Qyj.a;
    String str2 = this.jdField_a_of_type_Qyj.e;
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
        if ((TextUtils.isEmpty(this.jdField_a_of_type_Qyj.c)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qyj.b))) {
          this.jdField_a_of_type_Qyj.c = ADVideoAppDownloadManager.a(this.this$0, this.jdField_a_of_type_Qyj.b, 1);
        }
        str3 = this.jdField_a_of_type_Qyj.c;
        if (!TextUtils.isEmpty(str3)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "downloadUrl null");
      return;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString(bfoh.f, (String)localObject1);
      ((Bundle)localObject2).putString(bfoh.b, str1);
      ((Bundle)localObject2).putString(bfoh.j, str3);
      ((Bundle)localObject2).putString(bfoh.l, str2);
      ((Bundle)localObject2).putInt(bfoh.k, 2);
      ((Bundle)localObject2).putInt(bfoh.E, 0);
      ((Bundle)localObject2).putBoolean(bfoh.x, false);
      ((Bundle)localObject2).putInt(bfoh.H, 0);
      ((Bundle)localObject2).putBoolean(bfoh.y, true);
      ((Bundle)localObject2).putBoolean(bfoh.h, true);
      ((Bundle)localObject2).putBoolean(bfoh.r, false);
      ((Bundle)localObject2).putBoolean(bfoh.J, false);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Qyj.f)) {
        ((Bundle)localObject2).putString(bfoh.i, this.jdField_a_of_type_Qyj.f);
      }
      ((Bundle)localObject2).putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, "startRealDownload pkg:" + (String)localObject1 + ", appid:" + str1 + ", name:" + str2 + ", url:" + str3);
      }
      if (this.this$0.a.contains(this.jdField_a_of_type_Qyj)) {
        this.this$0.a.remove(this.jdField_a_of_type_Qyj);
      }
      this.this$0.a.add(this.jdField_a_of_type_Qyj);
      localObject1 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject1 != null) && (!((Activity)localObject1).isFinishing())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "ac=null");
    return;
    bfkv.a().a((Activity)localObject1, (Bundle)localObject2, "biz_src_feeds_kandianads", null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */