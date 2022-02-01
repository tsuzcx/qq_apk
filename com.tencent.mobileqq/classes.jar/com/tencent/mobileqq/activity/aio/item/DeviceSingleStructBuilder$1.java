package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.open.base.MD5Utils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceSingleStructBuilder$1
  implements View.OnClickListener
{
  DeviceSingleStructBuilder$1(DeviceSingleStructBuilder paramDeviceSingleStructBuilder) {}
  
  public void onClick(View paramView)
  {
    localMessageForDeviceSingleStruct = (MessageForDeviceSingleStruct)AIOUtils.a(paramView);
    if (localMessageForDeviceSingleStruct == null) {}
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaFileName)) && (localMessageForDeviceSingleStruct.nMediaChannelType == 2) && (!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaKey))) {
        localMessageForDeviceSingleStruct.strMediaFileName = (MD5Utils.toMD5(localMessageForDeviceSingleStruct.strMediaKey) + localMessageForDeviceSingleStruct.strMediaKey.substring(localMessageForDeviceSingleStruct.strMediaKey.lastIndexOf(".")));
      }
      localDeviceInfo = ((SmartDeviceProxyMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(localMessageForDeviceSingleStruct.senderuin));
    } while (localDeviceInfo == null);
    if (localDeviceInfo.isAdmin == 1) {
      i = 1;
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("title", localMessageForDeviceSingleStruct.strTitle);
        ((JSONObject)localObject2).put("digest", localMessageForDeviceSingleStruct.strDigest);
        if (localMessageForDeviceSingleStruct.nMediaFileStatus != 5) {
          continue;
        }
        localObject1 = localMessageForDeviceSingleStruct.strMediaPath;
        ((JSONObject)localObject2).put("file_path_url", localObject1);
        ((JSONObject)localObject2).put("thumb_path_url", localMessageForDeviceSingleStruct.strCoverPath);
        ((JSONObject)localObject2).put("guide_words", localMessageForDeviceSingleStruct.strGuideWords);
        ((JSONObject)localObject2).put("appear_time", localMessageForDeviceSingleStruct.nAppearTime);
        ((JSONObject)localObject2).put("data_type", localMessageForDeviceSingleStruct.nDataType);
        ((JSONObject)localObject2).put("face", localMessageForDeviceSingleStruct.faceRect);
        ((JSONObject)localObject2).put("cover_session_id", localMessageForDeviceSingleStruct.nCoverSessionID);
        ((JSONObject)localObject2).put("media_session_id", localMessageForDeviceSingleStruct.nMediaSessionID);
        if (localMessageForDeviceSingleStruct.nCoverChannelType != 1) {
          continue;
        }
        ((JSONObject)localObject2).put("cover_key", localMessageForDeviceSingleStruct.strCoverKey);
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        long l;
        int j;
        localJSONException.printStackTrace();
        String str = null;
        continue;
        ((JSONObject)localObject2).put("cover_url", localMessageForDeviceSingleStruct.strCoverKey);
        continue;
        if (localMessageForDeviceSingleStruct.nMediaChannelType != 3) {
          continue;
        }
        ((JSONObject)localObject2).put("media_mini", localMessageForDeviceSingleStruct.strMediaKey);
        ((JSONObject)localObject2).put("fkey2", localMessageForDeviceSingleStruct.strCoverKey2);
        continue;
        ((JSONObject)localObject2).put("media_url", localMessageForDeviceSingleStruct.strMediaKey);
        continue;
        if ((i == 0) || (TextUtils.isEmpty(localMessageForDeviceSingleStruct.faceRect)) || (!DeviceSingleStructBuilder.a(this.a, localMessageForDeviceSingleStruct.faceRect)) || (TextUtils.isEmpty(localMessageForDeviceSingleStruct.strCoverPath))) {
          continue;
        }
        Object localObject2 = new Intent();
        ((Intent)localObject2).putExtra("device_id", localDeviceInfo.din + "");
        if (localMessageForDeviceSingleStruct.nMediaFileStatus != 5) {
          continue;
        }
        str = localMessageForDeviceSingleStruct.strMediaPath;
        ((Intent)localObject2).putExtra("filepath", str);
        ((Intent)localObject2).putExtra("rect", localMessageForDeviceSingleStruct.faceRect);
        ((Intent)localObject2).putExtra("from", 0);
        SmartDevicePluginLoader.a().a((Activity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject2, "com.tencent.device.face.FaceRegisterActivity", -1, null, SmartDevicePluginProxyActivity.class);
        continue;
        str = localMessageForDeviceSingleStruct.strCoverPath;
        continue;
        DeviceSingleStructBuilder.a(this.a, localMessageForDeviceSingleStruct);
        continue;
        i = 3;
        continue;
      }
      if (localMessageForDeviceSingleStruct.nMediaChannelType != 1) {
        continue;
      }
      ((JSONObject)localObject2).put("media_key", localMessageForDeviceSingleStruct.strMediaKey);
      ((JSONObject)localObject2).put("jump_url", localMessageForDeviceSingleStruct.url);
      ((JSONObject)localObject2).put("msg_time", localMessageForDeviceSingleStruct.time);
      ((JSONObject)localObject2).put("ext", localMessageForDeviceSingleStruct.ext);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("struct_msg", localObject2);
      localObject1 = ((JSONObject)localObject1).toString();
      if (TextUtils.isEmpty(localMessageForDeviceSingleStruct.url)) {
        continue;
      }
      DeviceSingleStructBuilder.a(this.a, localMessageForDeviceSingleStruct, localDeviceInfo, (String)localObject1);
      if (localMessageForDeviceSingleStruct.nDataType != 2) {
        continue;
      }
      i = 4;
      l = Long.parseLong(localMessageForDeviceSingleStruct.senderuin);
      j = localDeviceInfo.productId;
      SmartDeviceReport.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_ReceiveMsg_Click", i, 0, j);
      break;
      i = 0;
      continue;
      localObject1 = localMessageForDeviceSingleStruct.strCoverPath;
      continue;
      if (localMessageForDeviceSingleStruct.nCoverChannelType != 3) {
        continue;
      }
      ((JSONObject)localObject2).put("cover_mini", localMessageForDeviceSingleStruct.strCoverKey);
      ((JSONObject)localObject2).put("ckey2", localMessageForDeviceSingleStruct.strCoverKey2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceSingleStructBuilder.1
 * JD-Core Version:    0.7.0.1
 */