package com.tencent.aladdin.config.network;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.aladdin.config.utils.DeviceInfoUtils;
import com.tencent.aladdin.config.utils.SpUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AladdinRequestHandler
{
  private static final String KEY_CACHE = "key_cache";
  public static final String KEY_CONFIG_COUNT = "key_config_count";
  public static final String KEY_FAILED_COUNT = "key_failed_count";
  public static final String KEY_REQUEST_TIMESTAMP = "key_request_timestamp";
  public static final String KEY_RESPONSE_TIMESTAMP = "key_response_timestamp";
  public static final String KEY_RET_CODE = "key_ret_code";
  public static final String KEY_RSP_TYPE = "key_rsp_type";
  private static final int REQ_TYPE_ACK = 1;
  private static final int REQ_TYPE_NORMAL = 0;
  private static final int RSP_TYPE_ACK = 1;
  private static final int RSP_TYPE_NORMAL = 0;
  private static final String TAG = "AladdinRequestHandler";
  private final AladdinResponseHandler responseHandler = new AladdinRequestHandler.1(this);
  
  private void ackConfigResults(String paramString, ArrayList<AladdinRequestHandler.ConfigResult> paramArrayList)
  {
    paramString = makeAckBody(paramString, paramArrayList).toByteArray();
    paramArrayList = new Bundle();
    paramArrayList.putLong("key_request_timestamp", System.currentTimeMillis());
    onSend(paramString, paramArrayList, this.responseHandler);
  }
  
  private static void handleAckRsp(oidb_cmd0xbf8.RspBodyType2 paramRspBodyType2)
  {
    if (com.tencent.aladdin.config.utils.Log.isDebugVersion())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleAckRsp: ");
      localStringBuilder.append(com.tencent.aladdin.config.utils.Log.pbToString(paramRspBodyType2));
      android.util.Log.d("AladdinRequestHandler", localStringBuilder.toString());
    }
    paramRspBodyType2 = paramRspBodyType2.msg.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleAckRsp: msg=");
    localStringBuilder.append(paramRspBodyType2);
    com.tencent.aladdin.config.utils.Log.d("AladdinRequestHandler", localStringBuilder.toString());
  }
  
  private ArrayList<AladdinRequestHandler.ConfigResult> handleRspBody(oidb_cmd0xbf8.RspBodyType1 paramRspBodyType1)
  {
    if (com.tencent.aladdin.config.utils.Log.isDebugVersion())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleRspBody: ");
      ((StringBuilder)localObject1).append(com.tencent.aladdin.config.utils.Log.pbToString(paramRspBodyType1));
      com.tencent.aladdin.config.utils.Log.d("AladdinRequestHandler", ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = paramRspBodyType1.rpt_config_list.get();
    Object localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    for (;;)
    {
      boolean bool = ((Iterator)localObject2).hasNext();
      int i = 1;
      if (!bool) {
        break;
      }
      oidb_cmd0xbf8.Config localConfig = (oidb_cmd0xbf8.Config)((Iterator)localObject2).next();
      int j = localConfig.id.get();
      int k = localConfig.version.get();
      String str = localConfig.content.get();
      int m = localConfig.wipe_flag.get();
      try
      {
        bool = handleSingleConfigRsp(j, k, str, m);
        i = true ^ bool;
      }
      catch (Exception localException)
      {
        com.tencent.aladdin.config.utils.Log.e("AladdinRequestHandler", "handleRspBody: ", localException);
      }
      ((ArrayList)localObject1).add(new AladdinRequestHandler.ConfigResult(j, k, i));
    }
    if (!Aladdin.getVersionManager().flush()) {
      com.tencent.aladdin.config.utils.Log.e("AladdinRequestHandler", "handleRspBody: failed to flush version info");
    }
    ackConfigResults(paramRspBodyType1.cookie.get(), (ArrayList)localObject1);
    if ((paramRspBodyType1.cache.has()) && (paramRspBodyType1.cache.get() != null))
    {
      paramRspBodyType1 = paramRspBodyType1.cache.get().toStringUtf8();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[handleRspBody], cache = ");
      ((StringBuilder)localObject2).append(paramRspBodyType1);
      com.tencent.aladdin.config.utils.Log.i("AladdinRequestHandler", ((StringBuilder)localObject2).toString());
      SpUtils.updateSpValue("key_cache", paramRspBodyType1, true);
    }
    return localObject1;
  }
  
  private boolean handleSingleConfigRsp(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleSingleConfigRsp] id = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", version = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", content = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", wipeFlag = ");
    ((StringBuilder)localObject).append(paramInt3);
    com.tencent.aladdin.config.utils.Log.d("AladdinRequestHandler", ((StringBuilder)localObject).toString());
    localObject = Aladdin.getVersionManager();
    ((AladdinConfigVersionManager)localObject).getConfigVersionById(paramInt1);
    try
    {
      SimpleConfigHandler localSimpleConfigHandler = Aladdin.getConfigHandlerById(paramInt1);
      if (paramInt3 != 0)
      {
        localSimpleConfigHandler.onWipeConfig(paramInt3);
        ((AladdinConfigVersionManager)localObject).setConfigVersionById(paramInt1, 0);
        return true;
      }
      boolean bool = localSimpleConfigHandler.onReceiveConfig(paramInt1, paramInt2, paramString);
      ((AladdinConfigVersionManager)localObject).setConfigVersionById(paramInt1, paramInt2);
      return bool;
    }
    catch (Exception paramString)
    {
      com.tencent.aladdin.config.utils.Log.e("AladdinRequestHandler", "handleSingleConfigRsp: ", paramString);
    }
    return false;
  }
  
  private static oidb_cmd0xbf8.ReqBody makeAckBody(String paramString, List<AladdinRequestHandler.ConfigResult> paramList)
  {
    oidb_cmd0xbf8.ReqBody localReqBody = new oidb_cmd0xbf8.ReqBody();
    localReqBody.appId.set(Aladdin.getAppId().intValue());
    localReqBody.uin.set(Aladdin.getCurrentUserId());
    oidb_cmd0xbf8.ReqBodyType2 localReqBodyType2 = new oidb_cmd0xbf8.ReqBodyType2();
    localReqBodyType2.cookie.set(paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (AladdinRequestHandler.ConfigResult)paramString.next();
      oidb_cmd0xbf8.ConfigResult localConfigResult = new oidb_cmd0xbf8.ConfigResult();
      localConfigResult.id.set(AladdinRequestHandler.ConfigResult.access$300(paramList));
      localConfigResult.ret_code.set(AladdinRequestHandler.ConfigResult.access$400(paramList));
      localConfigResult.version.set(AladdinRequestHandler.ConfigResult.access$500(paramList));
      localReqBodyType2.rpt_ret_list.add(localConfigResult);
    }
    localReqBody.req_type.set(1);
    localReqBody.body_type_2.set(localReqBodyType2);
    if (com.tencent.aladdin.config.utils.Log.isDebugVersion())
    {
      paramString = new StringBuilder();
      paramString.append("makeAckBody: ");
      paramString.append(com.tencent.aladdin.config.utils.Log.pbToString(localReqBody));
      com.tencent.aladdin.config.utils.Log.d("AladdinRequestHandler", paramString.toString());
    }
    return localReqBody;
  }
  
  private static oidb_cmd0xbf8.DeviceInfo makeDeviceInfo()
  {
    oidb_cmd0xbf8.DeviceInfo localDeviceInfo = new oidb_cmd0xbf8.DeviceInfo();
    localDeviceInfo.os.set(new oidb_cmd0xbf8.OS());
    localDeviceInfo.os.type.set(2);
    localDeviceInfo.os.version.set(DeviceInfoUtils.getDeviceOSVersion());
    localDeviceInfo.os.sdk.set(String.valueOf(DeviceInfoUtils.getOsVersion()));
    localDeviceInfo.os.kernel.set(System.getProperty("os.version"));
    localDeviceInfo.cpu.set(new oidb_cmd0xbf8.CPU());
    localDeviceInfo.cpu.model.set(DeviceInfoUtils.getCpuType());
    localDeviceInfo.cpu.cores.set(DeviceInfoUtils.getCpuNumber());
    localDeviceInfo.cpu.frequency.set((int)DeviceInfoUtils.getCpuFrequency());
    localDeviceInfo.memory.set(new oidb_cmd0xbf8.Memory());
    localDeviceInfo.memory.total.set(DeviceInfoUtils.getSystemTotalMemory());
    localDeviceInfo.storage.set(new oidb_cmd0xbf8.Storage());
    localDeviceInfo.storage.builtin.set(DeviceInfoUtils.getRomMemroy()[0]);
    localDeviceInfo.storage.external.set(DeviceInfoUtils.getSDCardMemory()[0]);
    localDeviceInfo.screen.set(new oidb_cmd0xbf8.Screen());
    localDeviceInfo.screen.dpi.set(DeviceInfoUtils.getDispalyDpi());
    localDeviceInfo.screen.width.set((int)DeviceInfoUtils.getScreenWidth());
    localDeviceInfo.screen.height.set((int)DeviceInfoUtils.getScreenHeight());
    localDeviceInfo.camera.set(new oidb_cmd0xbf8.Camera());
    localDeviceInfo.brand.set(new oidb_cmd0xbf8.BrandInfo());
    localDeviceInfo.brand.brand.set(DeviceInfoUtils.getDeviceBrand());
    localDeviceInfo.brand.model.set(DeviceInfoUtils.getDeviceModel());
    localDeviceInfo.brand.manufacturer.set(DeviceInfoUtils.getDeviceManufacturer());
    return localDeviceInfo;
  }
  
  private static oidb_cmd0xbf8.ReqBody makeReqBody(@NonNull int[] paramArrayOfInt)
  {
    oidb_cmd0xbf8.ReqBody localReqBody = new oidb_cmd0xbf8.ReqBody();
    localReqBody.appId.set(Aladdin.getAppId().intValue());
    localReqBody.uin.set(Aladdin.getCurrentUserId());
    oidb_cmd0xbf8.ReqBodyType1 localReqBodyType1 = new oidb_cmd0xbf8.ReqBodyType1();
    localReqBodyType1.app_version.set(Aladdin.getAppVersion());
    localReqBodyType1.device_info.set(makeDeviceInfo());
    localReqBodyType1.app_id.set(Aladdin.getAppFlavorId());
    Object localObject = Aladdin.getVersionManager();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      oidb_cmd0xbf8.ConfigSeq localConfigSeq = new oidb_cmd0xbf8.ConfigSeq();
      localConfigSeq.id.set(k);
      localConfigSeq.version.set(((AladdinConfigVersionManager)localObject).getConfigVersionById(k));
      localReqBodyType1.rpt_config_list.add(localConfigSeq);
      i += 1;
    }
    paramArrayOfInt = (String)SpUtils.getSpValue("key_cache", "", true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[makeReqBody] cache = ");
    ((StringBuilder)localObject).append(paramArrayOfInt);
    com.tencent.aladdin.config.utils.Log.i("AladdinRequestHandler", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramArrayOfInt)) {
      localReqBodyType1.cache.set(ByteStringMicro.copyFromUtf8(paramArrayOfInt));
    }
    localReqBody.req_type.set(0);
    localReqBody.body_type_1.set(localReqBodyType1);
    if (com.tencent.aladdin.config.utils.Log.isDebugVersion())
    {
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("makeReqBody: ");
      paramArrayOfInt.append(com.tencent.aladdin.config.utils.Log.pbToString(localReqBody));
      com.tencent.aladdin.config.utils.Log.d("AladdinRequestHandler", paramArrayOfInt.toString());
    }
    return localReqBody;
  }
  
  protected abstract void onSend(byte[] paramArrayOfByte, Bundle paramBundle, AladdinResponseHandler paramAladdinResponseHandler);
  
  public void requestForUpdate(@NonNull int[] paramArrayOfInt)
  {
    paramArrayOfInt = makeReqBody(paramArrayOfInt).toByteArray();
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_request_timestamp", System.currentTimeMillis());
    onSend(paramArrayOfInt, localBundle, this.responseHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.network.AladdinRequestHandler
 * JD-Core Version:    0.7.0.1
 */