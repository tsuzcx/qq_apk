package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.mobileqq.vip.TMSManager.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class VideoDeviceInfoHelper$1
  implements TMSManager.Callback
{
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoDeviceInfoHelper.a, 2, "queryKingCardType()#callback postQuery, sucess=" + paramBoolean1 + " isKingCard=" + paramBoolean2 + " product=" + paramInt);
    }
    if (paramBoolean1)
    {
      VideoDeviceInfoHelper.a(paramInt);
      try
      {
        JSONObject localJSONObject = VideoDeviceInfoHelper.a();
        if (localJSONObject != null) {}
        try
        {
          VideoDeviceInfoHelper.a().put("simCardType", VideoDeviceInfoHelper.a());
          if (QLog.isColorLevel()) {
            QLog.d(VideoDeviceInfoHelper.a, 2, "queryKingCardType()#callback postQuery, update jsonStr ");
          }
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e(VideoDeviceInfoHelper.a, 2, "queryKingCardType()#callback postQuery, update json error ", localJSONException);
            }
          }
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */