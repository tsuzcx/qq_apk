package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import bccy;
import bcgl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import pxh;

class ADVideoAppDownloadManager$2
  implements Runnable
{
  ADVideoAppDownloadManager$2(ADVideoAppDownloadManager paramADVideoAppDownloadManager, pxh parampxh, WeakReference paramWeakReference) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_Pxh.d;
    String str1 = this.jdField_a_of_type_Pxh.a;
    String str2 = this.jdField_a_of_type_Pxh.e;
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
        if ((TextUtils.isEmpty(this.jdField_a_of_type_Pxh.c)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Pxh.b))) {
          this.jdField_a_of_type_Pxh.c = ADVideoAppDownloadManager.a(this.this$0, this.jdField_a_of_type_Pxh.b, 1);
        }
        str3 = this.jdField_a_of_type_Pxh.c;
        if (!TextUtils.isEmpty(str3)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "downloadUrl null");
      return;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString(bcgl.f, (String)localObject1);
      ((Bundle)localObject2).putString(bcgl.b, str1);
      ((Bundle)localObject2).putString(bcgl.j, str3);
      ((Bundle)localObject2).putString(bcgl.l, str2);
      ((Bundle)localObject2).putInt(bcgl.k, 2);
      ((Bundle)localObject2).putInt(bcgl.E, 0);
      ((Bundle)localObject2).putBoolean(bcgl.x, false);
      ((Bundle)localObject2).putInt(bcgl.H, 0);
      ((Bundle)localObject2).putBoolean(bcgl.y, true);
      ((Bundle)localObject2).putBoolean(bcgl.h, true);
      ((Bundle)localObject2).putBoolean(bcgl.r, false);
      ((Bundle)localObject2).putBoolean(bcgl.J, false);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Pxh.f)) {
        ((Bundle)localObject2).putString(bcgl.i, this.jdField_a_of_type_Pxh.f);
      }
      ((Bundle)localObject2).putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, "startRealDownload pkg:" + (String)localObject1 + ", appid:" + str1 + ", name:" + str2 + ", url:" + str3);
      }
      if (this.this$0.a.contains(this.jdField_a_of_type_Pxh)) {
        this.this$0.a.remove(this.jdField_a_of_type_Pxh);
      }
      this.this$0.a.add(this.jdField_a_of_type_Pxh);
      localObject1 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject1 != null) && (!((Activity)localObject1).isFinishing())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "ac=null");
    return;
    bccy.a().a((Activity)localObject1, (Bundle)localObject2, "biz_src_feeds_kandianads", null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */