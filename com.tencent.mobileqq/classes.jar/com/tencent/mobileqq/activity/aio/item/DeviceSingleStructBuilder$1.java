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
    MessageForDeviceSingleStruct localMessageForDeviceSingleStruct = (MessageForDeviceSingleStruct)AIOUtils.a(paramView);
    if (localMessageForDeviceSingleStruct != null)
    {
      Object localObject1;
      if ((TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaFileName)) && (localMessageForDeviceSingleStruct.nMediaChannelType == 2) && (!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaKey)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(MD5Utils.toMD5(localMessageForDeviceSingleStruct.strMediaKey));
        ((StringBuilder)localObject1).append(localMessageForDeviceSingleStruct.strMediaKey.substring(localMessageForDeviceSingleStruct.strMediaKey.lastIndexOf(".")));
        localMessageForDeviceSingleStruct.strMediaFileName = ((StringBuilder)localObject1).toString();
      }
      DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(localMessageForDeviceSingleStruct.senderuin));
      if (localDeviceInfo != null)
      {
        int i;
        if (localDeviceInfo.isAdmin == 1) {
          i = 1;
        } else {
          i = 0;
        }
        Intent localIntent = null;
        Object localObject2;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("title", localMessageForDeviceSingleStruct.strTitle);
          localJSONObject.put("digest", localMessageForDeviceSingleStruct.strDigest);
          if (localMessageForDeviceSingleStruct.nMediaFileStatus == 5) {
            localObject1 = localMessageForDeviceSingleStruct.strMediaPath;
          } else {
            localObject1 = localMessageForDeviceSingleStruct.strCoverPath;
          }
          localJSONObject.put("file_path_url", localObject1);
          localJSONObject.put("thumb_path_url", localMessageForDeviceSingleStruct.strCoverPath);
          localJSONObject.put("guide_words", localMessageForDeviceSingleStruct.strGuideWords);
          localJSONObject.put("appear_time", localMessageForDeviceSingleStruct.nAppearTime);
          localJSONObject.put("data_type", localMessageForDeviceSingleStruct.nDataType);
          localJSONObject.put("face", localMessageForDeviceSingleStruct.faceRect);
          localJSONObject.put("cover_session_id", localMessageForDeviceSingleStruct.nCoverSessionID);
          localJSONObject.put("media_session_id", localMessageForDeviceSingleStruct.nMediaSessionID);
          if (localMessageForDeviceSingleStruct.nCoverChannelType == 1)
          {
            localJSONObject.put("cover_key", localMessageForDeviceSingleStruct.strCoverKey);
          }
          else if (localMessageForDeviceSingleStruct.nCoverChannelType == 3)
          {
            localJSONObject.put("cover_mini", localMessageForDeviceSingleStruct.strCoverKey);
            localJSONObject.put("ckey2", localMessageForDeviceSingleStruct.strCoverKey2);
          }
          else
          {
            localJSONObject.put("cover_url", localMessageForDeviceSingleStruct.strCoverKey);
          }
          if (localMessageForDeviceSingleStruct.nMediaChannelType == 1)
          {
            localJSONObject.put("media_key", localMessageForDeviceSingleStruct.strMediaKey);
          }
          else if (localMessageForDeviceSingleStruct.nMediaChannelType == 3)
          {
            localJSONObject.put("media_mini", localMessageForDeviceSingleStruct.strMediaKey);
            localJSONObject.put("fkey2", localMessageForDeviceSingleStruct.strCoverKey2);
          }
          else
          {
            localJSONObject.put("media_url", localMessageForDeviceSingleStruct.strMediaKey);
          }
          localJSONObject.put("jump_url", localMessageForDeviceSingleStruct.url);
          localJSONObject.put("msg_time", localMessageForDeviceSingleStruct.time);
          localJSONObject.put("ext", localMessageForDeviceSingleStruct.ext);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("struct_msg", localJSONObject);
          localObject1 = ((JSONObject)localObject1).toString();
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          localObject2 = localIntent;
        }
        if (!TextUtils.isEmpty(localMessageForDeviceSingleStruct.url))
        {
          DeviceSingleStructBuilder.a(this.a, localMessageForDeviceSingleStruct, localDeviceInfo, (String)localObject2);
        }
        else if ((i != 0) && (!TextUtils.isEmpty(localMessageForDeviceSingleStruct.faceRect)) && (DeviceSingleStructBuilder.a(this.a, localMessageForDeviceSingleStruct.faceRect)) && (!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strCoverPath)))
        {
          localIntent = new Intent();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localDeviceInfo.din);
          ((StringBuilder)localObject2).append("");
          localIntent.putExtra("device_id", ((StringBuilder)localObject2).toString());
          if (localMessageForDeviceSingleStruct.nMediaFileStatus == 5) {
            localObject2 = localMessageForDeviceSingleStruct.strMediaPath;
          } else {
            localObject2 = localMessageForDeviceSingleStruct.strCoverPath;
          }
          localIntent.putExtra("filepath", (String)localObject2);
          localIntent.putExtra("rect", localMessageForDeviceSingleStruct.faceRect);
          localIntent.putExtra("from", 0);
          SmartDevicePluginLoader.a().a((Activity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.face.FaceRegisterActivity", -1, null, SmartDevicePluginProxyActivity.class);
        }
        else
        {
          DeviceSingleStructBuilder.a(this.a, localMessageForDeviceSingleStruct);
        }
        if (localMessageForDeviceSingleStruct.nDataType == 2) {
          i = 4;
        } else {
          i = 3;
        }
        long l = Long.parseLong(localMessageForDeviceSingleStruct.senderuin);
        int j = localDeviceInfo.productId;
        SmartDeviceReport.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_ReceiveMsg_Click", i, 0, j);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceSingleStructBuilder.1
 * JD-Core Version:    0.7.0.1
 */