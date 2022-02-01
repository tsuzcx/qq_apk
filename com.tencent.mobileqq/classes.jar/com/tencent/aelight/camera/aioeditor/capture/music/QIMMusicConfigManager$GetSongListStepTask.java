package com.tencent.aelight.camera.aioeditor.capture.music;

import com.tencent.aelight.camera.qqstory.api.IAsyncControl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.TicketManagerImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class QIMMusicConfigManager$GetSongListStepTask
  extends QIMMusicConfigManager.LoadMusicStepTask
{
  String a;
  
  QIMMusicConfigManager$GetSongListStepTask(QIMMusicConfigManager paramQIMMusicConfigManager1, QIMMusicConfigManager paramQIMMusicConfigManager2)
  {
    super(paramQIMMusicConfigManager2);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mHttpCode == 200)
    {
      if (paramNetResp.mRespData != null)
      {
        paramNetResp = new String(paramNetResp.mRespData);
        ((IAsyncControl)QRoute.api(IAsyncControl.class)).startAsyncStep(String.valueOf(1008), new Object[] { paramNetResp });
        return;
      }
      QIMMusicConfigManager.a(this.this$0, false);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager.a(1, false, "have no data.");
      return;
    }
    QIMMusicConfigManager.a(this.this$0, false);
    QIMMusicConfigManager localQIMMusicConfigManager = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Http Request fail, code=");
    localStringBuilder.append(paramNetResp.mHttpCode);
    localQIMMusicConfigManager.a(1, false, localStringBuilder.toString());
  }
  
  public void run()
  {
    try
    {
      localObject1 = new JSONObject(this.jdField_a_of_type_JavaLangString);
      if (((JSONObject)localObject1).optInt("ret", -1) != 0) {
        break label406;
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("data");
      if (localObject1 == null) {
        break label406;
      }
      i = 0;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1;
        int i;
        Object localObject2;
        long l2;
        HashMap localHashMap;
        label406:
        continue;
        i += 1;
        continue;
        long l1 = -1L;
      }
    }
    if (i < ((JSONArray)localObject1).length())
    {
      localObject2 = ((JSONArray)localObject1).optJSONObject(i);
      if ((localObject2 != null) && ("我喜欢".equals(((JSONObject)localObject2).optString("diss_name"))))
      {
        l1 = ((JSONObject)localObject2).optLong("diss_id", -1L);
        if (l1 != -1L)
        {
          localObject1 = new HttpNetReq();
          ((HttpNetReq)localObject1).mHttpMethod = 0;
          ((HttpNetReq)localObject1).mPrioty = 1;
          ((HttpNetReq)localObject1).mCallback = this;
          l2 = System.currentTimeMillis() / 1000L;
          localObject2 = ((TicketManagerImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2)).getSkey(this.c);
          localHashMap = new HashMap();
          localHashMap.put("app_id", "2000000228");
          localHashMap.put("app_key", "TCOHANTCNlddnsTY");
          localHashMap.put("device_id", DeviceInfoUtil.a());
          localHashMap.put("timestamp", String.valueOf(l2));
          localHashMap.put("sign", a(l2));
          localHashMap.put("dissid", String.valueOf(l1));
          localHashMap.putAll(a(this.c, (String)localObject2));
          ((HttpNetReq)localObject1).mReqUrl = a("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_songlist_detail.fcg", localHashMap);
          this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.sendReq((NetReq)localObject1);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("QQMusicReq GetSongListStepTask req url=");
            ((StringBuilder)localObject2).append(((HttpNetReq)localObject1).mReqUrl);
            QLog.d("QIMMusicConfigManager", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          QIMMusicConfigManager.a(this.this$0, true);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager.a(1, false, "can not find myFav diss.");
          return;
          QIMMusicConfigManager.a(this.this$0, false);
          localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parsed json error, json=");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          ((QIMMusicConfigManager)localObject1).a(1, false, ((StringBuilder)localObject2).toString());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager.GetSongListStepTask
 * JD-Core Version:    0.7.0.1
 */