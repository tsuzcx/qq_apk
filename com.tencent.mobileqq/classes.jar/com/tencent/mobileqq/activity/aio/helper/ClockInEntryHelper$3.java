package com.tencent.mobileqq.activity.aio.helper;

import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;

class ClockInEntryHelper$3
  implements Runnable
{
  ClockInEntryHelper$3(ClockInEntryHelper paramClockInEntryHelper, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    i = 1;
    try
    {
      if (TextUtils.isEmpty(ClockInEntryHelper.a(this.this$0)))
      {
        localObject = ClockInEntryHelper.a(this.this$0).a().getAssets().open("troop_sign_in/data.json");
        ClockInEntryHelper.a(this.this$0, Util.a((InputStream)localObject));
        ((InputStream)localObject).close();
      }
      if ((!ClockInEntryHelper.c(this.this$0)) || (ClockInEntryHelper.a(this.this$0) != this.jdField_a_of_type_Int))
      {
        ClockInEntryHelper.a(this.this$0, this.jdField_a_of_type_Int);
        ClockInEntryHelper.a(this.this$0, true);
        if (QLog.isColorLevel()) {
          QLog.d("ClockInEntryHelper.helper", 2, "color change: " + this.jdField_a_of_type_Int);
        }
        double d1 = ((this.jdField_a_of_type_Int & 0xFF000000) >> 20) / 255.0D;
        double d2 = ((this.jdField_a_of_type_Int & 0xFF0000) >> 16) / 255.0D;
        double d3 = ((this.jdField_a_of_type_Int & 0xFF00) >> 8) / 255.0D;
        double d4 = (this.jdField_a_of_type_Int & 0xFF) / 255.0D;
        localObject = new JSONObject(ClockInEntryHelper.a(this.this$0));
        JSONArray localJSONArray1 = ((JSONObject)localObject).getJSONArray("assets").getJSONObject(0).getJSONArray("layers");
        JSONArray localJSONArray2 = localJSONArray1.getJSONObject(1).getJSONArray("shapes").getJSONObject(0).getJSONArray("it").getJSONObject(1).getJSONObject("c").getJSONArray("k");
        localJSONArray2.put(0, d2);
        localJSONArray2.put(1, d3);
        localJSONArray2.put(2, d4);
        localJSONArray2.put(3, d1);
        localJSONArray2 = localJSONArray1.getJSONObject(2).getJSONArray("shapes").getJSONObject(0).getJSONArray("it").getJSONObject(1).getJSONObject("c").getJSONArray("k");
        localJSONArray2.put(0, d2);
        localJSONArray2.put(1, d3);
        localJSONArray2.put(2, d4);
        localJSONArray2.put(3, d1);
        localJSONArray2 = localJSONArray1.getJSONObject(3).getJSONArray("shapes").getJSONObject(0).getJSONArray("it").getJSONObject(3).getJSONObject("c").getJSONArray("k");
        localJSONArray2.put(0, d2);
        localJSONArray2.put(1, d3);
        localJSONArray2.put(2, d4);
        localJSONArray2.put(3, d1);
        localJSONArray1 = localJSONArray1.getJSONObject(4).getJSONArray("shapes").getJSONObject(0).getJSONArray("it").getJSONObject(1).getJSONObject("c").getJSONArray("k");
        localJSONArray1.put(0, d2);
        localJSONArray1.put(1, d3);
        localJSONArray1.put(2, d4);
        localJSONArray1.put(3, d1);
        if (!TextUtils.isEmpty(((JSONObject)localObject).toString())) {
          ClockInEntryHelper.a(this.this$0, ((JSONObject)localObject).toString());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        ClockInEntryHelper.a(this.this$0, "");
        QLog.d("ClockInEntryHelper.helper", 2, "json parse error", localException);
        continue;
        i = 0;
      }
    }
    localObject = new Message();
    ((Message)localObject).what = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      ((Message)localObject).arg1 = i;
      ClockInEntryHelper.a(this.this$0).sendMessage((Message)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ClockInEntryHelper.3
 * JD-Core Version:    0.7.0.1
 */