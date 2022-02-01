package com.tencent.av.business.servlet.coder;

import android.os.Bundle;
import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeReq;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.business.servlet.CompressUniPacket;
import com.tencent.av.utils.EffectMaterialUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class EffectMaterialJCECoder
  extends BaseJCECoder
{
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetCatMatTreeReq localGetCatMatTreeReq = new GetCatMatTreeReq();
    localGetCatMatTreeReq.ServiceId = paramToServiceMsg.extraData.getString("ServiceId");
    localGetCatMatTreeReq.GroupId = paramToServiceMsg.extraData.getString("GroupId");
    paramToServiceMsg = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShadowBackendSvc.GetCatMatTree");
    localStringBuilder.append(localGetCatMatTreeReq.ServiceId);
    localGetCatMatTreeReq.ETag = EffectMaterialUtil.a(paramToServiceMsg, localStringBuilder.toString());
    localGetCatMatTreeReq.SdkInfos = b();
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetCatMatTree");
    paramUniPacket.put("ShadowBackendSvc.GetCatMatTree", localGetCatMatTreeReq);
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("ShadowBackendSvc.GetCatMatTree".equals(paramToServiceMsg.getServiceCmd())) {
      return a(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetCatMatTree", new GetCatMatTreeRsp());
    }
    return super.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public final <T> T a(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    CompressUniPacket localCompressUniPacket = new CompressUniPacket(true);
    try
    {
      localCompressUniPacket.setEncodeName("utf-8");
      localCompressUniPacket.decode(paramArrayOfByte);
      return localCompressUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte)
    {
      label31:
      break label31;
    }
    return null;
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("ShadowBackendSvc.GetCatMatTree");
    return localArrayList;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if ("ShadowBackendSvc.GetCatMatTree".equals(paramToServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    return super.a(paramToServiceMsg, paramUniPacket);
  }
  
  protected ArrayList<MetaSdkInfo> b()
  {
    ArrayList localArrayList = new ArrayList();
    MetaSdkInfo localMetaSdkInfo = new MetaSdkInfo();
    localMetaSdkInfo.sdk = 0;
    localMetaSdkInfo.sdkVersion = "2.0.0";
    Object localObject = "2.6.0.23";
    if (!TextUtils.isEmpty("2.6.0.23"))
    {
      String[] arrayOfString = "2.6.0.23".split("\\.");
      if (arrayOfString.length > 3)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(arrayOfString[0]);
        ((StringBuilder)localObject).append(".");
        ((StringBuilder)localObject).append(arrayOfString[1]);
        ((StringBuilder)localObject).append(".");
        ((StringBuilder)localObject).append(arrayOfString[2]);
        localObject = ((StringBuilder)localObject).toString();
      }
      localMetaSdkInfo.sdkVersion = ((String)localObject);
    }
    localArrayList.add(localMetaSdkInfo);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.servlet.coder.EffectMaterialJCECoder
 * JD-Core Version:    0.7.0.1
 */