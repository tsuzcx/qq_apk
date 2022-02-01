package com.tencent.hippy.qq.module.tkd;

import android.os.Bundle;
import android.text.TextUtils;
import bfuc;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import pb.unite.search.DynamicDiscovery.RspBody;

public class TKDWupModule$HippyWupCallbackManager
  implements Serializable
{
  private final HashMap<Integer, TKDWupModule.HippyWupCallbackModule> mWupCallbacks = new HashMap();
  
  public void onWUPTaskFail(int paramInt, Promise paramPromise)
  {
    QLog.e("WupModule", 0, "Sending Hippy WUP Requeset onWUPTaskFail");
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("code", paramInt);
    paramPromise.reject(localHippyMap);
  }
  
  public void onWUPTaskSuccess(ToServiceMsg paramToServiceMsg, int paramInt, Object paramObject)
  {
    QLog.e("HippyQQWupModule", 0, "Sending Hippy WUP Requeset onWUPTaskSuccess");
    int i = paramToServiceMsg.extraData.getInt("searchHippyRequestId");
    TKDWupModule.HippyWupCallbackModule localHippyWupCallbackModule = (TKDWupModule.HippyWupCallbackModule)this.mWupCallbacks.get(Integer.valueOf(i));
    if (localHippyWupCallbackModule == null) {
      return;
    }
    if ((paramInt != 1000) || (!(paramObject instanceof byte[])))
    {
      onWUPTaskFail(paramInt, localHippyWupCallbackModule.promise);
      return;
    }
    paramToServiceMsg = new DynamicDiscovery.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramInt = paramToServiceMsg.result_code.get();
      if (paramToServiceMsg.error_msg.get() != null) {
        paramToServiceMsg.error_msg.get().toStringUtf8();
      }
      if (paramInt != 0) {
        break label343;
      }
      Object localObject = localHippyWupCallbackModule.rspName;
      paramToServiceMsg = paramToServiceMsg.jce_rsp_buffer.get().toByteArray();
      TKDWupUniPacket localTKDWupUniPacket = new TKDWupUniPacket();
      if (paramToServiceMsg.length > 4) {
        localTKDWupUniPacket.decode(paramToServiceMsg);
      }
      paramObject = localTKDWupUniPacket.getRawResponseData((String)localObject, localHippyWupCallbackModule.rspClassName);
      paramToServiceMsg = paramObject;
      if (TextUtils.isEmpty(localHippyWupCallbackModule.rspClassName))
      {
        localObject = localTKDWupUniPacket.getRspDataMap((String)localObject);
        paramToServiceMsg = paramObject;
        if (localObject != null)
        {
          localObject = ((HashMap)localObject).entrySet().iterator();
          paramToServiceMsg = paramObject;
          if (((Iterator)localObject).hasNext())
          {
            paramToServiceMsg = (Map.Entry)((Iterator)localObject).next();
            localHippyWupCallbackModule.rspClassName = ((String)paramToServiceMsg.getKey());
            paramToServiceMsg = (byte[])paramToServiceMsg.getValue();
          }
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.length > 0))
      {
        paramObject = new HippyMap();
        paramObject.pushInt("code", paramInt);
        paramObject.pushString("className", localHippyWupCallbackModule.rspClassName);
        paramObject.pushString("body", bfuc.encodeToString(paramToServiceMsg, 2));
        localHippyWupCallbackModule.promise.resolve(paramObject);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      onWUPTaskFail(1007, localHippyWupCallbackModule.promise);
      return;
    }
    onWUPTaskFail(paramInt, localHippyWupCallbackModule.promise);
    return;
    label343:
    onWUPTaskFail(paramInt, localHippyWupCallbackModule.promise);
  }
  
  public void registerWupCallback(String paramString1, String paramString2, Promise paramPromise, Integer paramInteger)
  {
    TKDWupModule.HippyWupCallbackModule localHippyWupCallbackModule = new TKDWupModule.HippyWupCallbackModule();
    localHippyWupCallbackModule.rspName = paramString1;
    localHippyWupCallbackModule.promise = paramPromise;
    localHippyWupCallbackModule.rspClassName = paramString2;
    this.mWupCallbacks.put(paramInteger, localHippyWupCallbackModule);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDWupModule.HippyWupCallbackManager
 * JD-Core Version:    0.7.0.1
 */