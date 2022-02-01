package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import anvx;
import bbhm;
import bhcu;
import bhdj;
import bifw;
import bisl;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import sjm;
import uta;
import utt;
import utu;
import utw;

public class PublicAccountH5AbilityPlugin$7
  implements Runnable
{
  public PublicAccountH5AbilityPlugin$7(uta paramuta, String[] paramArrayOfString) {}
  
  public void run()
  {
    if (!bbhm.a()) {
      bhdj.a(this.this$0.jdField_a_of_type_AndroidAppActivity, 230, null, anvx.a(2131708247), null, this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131694399), new utt(this), null).show();
    }
    Object localObject2;
    String str2;
    int i;
    int j;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    label199:
    boolean bool;
    do
    {
      return;
      Object localObject1;
      try
      {
        localObject2 = new JSONObject(this.a[0]);
        if (QLog.isColorLevel()) {
          QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage param json:" + ((JSONObject)localObject2).toString());
        }
        str2 = ((JSONObject)localObject2).optString("topicId");
        i = ((JSONObject)localObject2).optInt("adtag");
        j = ((JSONObject)localObject2).optInt("mode");
        str3 = ((JSONObject)localObject2).optString("vid");
        str4 = ((JSONObject)localObject2).optString("videourl");
        str5 = ((JSONObject)localObject2).optString("coverurl");
        str6 = ((JSONObject)localObject2).optString("md5");
        localObject1 = ((JSONObject)localObject2).optString("topicName");
        str7 = ((JSONObject)localObject2).optString("cookie");
      }
      catch (Exception localException1) {}
      try
      {
        str1 = new String(bhcu.decode((String)localObject1, 0));
        localObject1 = str1;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        break label199;
        if (!QLog.isColorLevel()) {
          break label342;
        }
        QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage isSoReady=" + bool);
        if (bool) {
          break label467;
        }
        localObject2 = new bisl(this.this$0.mRuntime.a(), this.this$0.mRuntime.a().getResources().getDimensionPixelSize(2131299080));
        ((bisl)localObject2).c(2131717929);
        utu localutu = new utu(this, (bisl)localObject2, str2, localException1, i, j, localException2, str3, str4, str5, str6, str7);
        this.this$0.jdField_a_of_type_Sjm.a(localutu);
        this.this$0.jdField_a_of_type_Sjm.a("CMD_CAMERA_CAPTURE_SO_DOWNLOAD", null);
        ((bisl)localObject2).a(new utw(this, localutu));
        ((bisl)localObject2).show();
        return;
        uta.a(this.this$0, str2, localutu, i, j, localException2, str3, str4, str5, str6, str7);
      }
      String str1 = ((JSONObject)localObject2).optString("callback");
      localObject2 = this.this$0.jdField_a_of_type_Sjm.a("CMD_CAMERA_CAPTURE_CHECK_SO_READY", null);
      bool = ((Bundle)localObject2).getBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY");
      if (!((Bundle)localObject2).getBoolean("VALUE_CAMERA_IS_VIDEO_CHATTING")) {
        break;
      }
      QQToast.a(this.this$0.mRuntime.a(), 0, 2131718854, 0).a();
      return;
    } while (!QLog.isColorLevel());
    QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage() Exception=" + localException1.getMessage());
    return;
    label342:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.7
 * JD-Core Version:    0.7.0.1
 */