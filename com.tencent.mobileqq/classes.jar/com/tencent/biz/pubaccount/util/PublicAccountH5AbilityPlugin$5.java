package com.tencent.biz.pubaccount.util;

import ajjy;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import autt;
import baaw;
import babr;
import bafb;
import bbac;
import bbms;
import bbmy;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import qde;
import rsv;
import rth;
import rti;
import rtk;

public class PublicAccountH5AbilityPlugin$5
  implements Runnable
{
  public PublicAccountH5AbilityPlugin$5(rsv paramrsv, String[] paramArrayOfString) {}
  
  public void run()
  {
    if (!autt.a()) {
      babr.a(this.this$0.jdField_a_of_type_AndroidAppActivity, 230, null, ajjy.a(2131643003), null, this.this$0.jdField_a_of_type_AndroidAppActivity.getString(2131629116), new rth(this), null).show();
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
        str1 = new String(baaw.decode((String)localObject1, 0));
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
        localObject2 = new bbms(this.this$0.mRuntime.a(), this.this$0.mRuntime.a().getResources().getDimensionPixelSize(2131167766));
        ((bbms)localObject2).c(2131652771);
        rti localrti = new rti(this, (bbms)localObject2, str2, localException1, i, j, localException2, str3, str4, str5, str6, str7);
        this.this$0.jdField_a_of_type_Qde.a(localrti);
        this.this$0.jdField_a_of_type_Qde.a("CMD_CAMERA_CAPTURE_SO_DOWNLOAD", null);
        ((bbms)localObject2).a(new rtk(this, localrti));
        ((bbms)localObject2).show();
        return;
        rsv.a(this.this$0, str2, localrti, i, j, localException2, str3, str4, str5, str6, str7);
      }
      String str1 = ((JSONObject)localObject2).optString("callback");
      localObject2 = this.this$0.jdField_a_of_type_Qde.a("CMD_CAMERA_CAPTURE_CHECK_SO_READY", null);
      bool = ((Bundle)localObject2).getBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY");
      if (!((Bundle)localObject2).getBoolean("VALUE_CAMERA_IS_VIDEO_CHATTING")) {
        break;
      }
      bbmy.a(this.this$0.mRuntime.a(), 0, 2131653692, 0).a();
      return;
    } while (!QLog.isColorLevel());
    QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage() Exception=" + localException1.getMessage());
    return;
    label342:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.5
 * JD-Core Version:    0.7.0.1
 */