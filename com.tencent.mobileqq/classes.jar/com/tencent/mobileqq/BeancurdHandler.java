package com.tencent.mobileqq;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.beancurd.IBeancurdUpdater;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.oidb.cmd0xf7e.oidb_cmd0xf7e.ReqBody;
import com.tencent.mobileqq.oidb.cmd0xf7e.oidb_cmd0xf7e.RspBody;
import com.tencent.mobileqq.oidb.tofuCommon.TofuCommon.Content;
import com.tencent.mobileqq.oidb.tofuCommon.TofuCommon.TofuCubeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class BeancurdHandler
  extends BusinessHandler
{
  private IBeancurdUpdater a;
  
  protected BeancurdHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private boolean a(oidb_cmd0xf7e.RspBody paramRspBody)
  {
    if (!paramRspBody.msg_tofu_cube_info.has())
    {
      QLog.d("BeancurdHandler", 1, "rsp is invalid");
      return true;
    }
    return false;
  }
  
  protected long a(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("next_requestTime");
    return ((Long)BaseSharedPreUtil.a(paramContext, paramString1, localStringBuilder.toString(), Long.valueOf(0L))).longValue();
  }
  
  public String a(TofuCommon.TofuCubeInfo paramTofuCubeInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("busiid", paramTofuCubeInfo.uint64_busi_id.get());
      localJSONObject1.put("busi_uuid", paramTofuCubeInfo.string_busi_uuid.get());
      localJSONObject1.put("beancurd_style", paramTofuCubeInfo.uint32_style.get());
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("detail", paramTofuCubeInfo.busi_desc.title.get());
      ((JSONObject)localObject1).put("color", paramTofuCubeInfo.busi_desc.color.get());
      localJSONObject1.put("description", localObject1);
      if (paramTofuCubeInfo.string_backgroud.has()) {
        localJSONObject1.put("background", paramTofuCubeInfo.string_backgroud.get());
      }
      if (paramTofuCubeInfo.string_resource.has()) {
        localJSONObject1.put("busiicon", paramTofuCubeInfo.string_resource.get());
      }
      if (paramTofuCubeInfo.busi_detail.has())
      {
        Object localObject2 = paramTofuCubeInfo.busi_detail.get();
        localObject1 = new JSONArray();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          TofuCommon.Content localContent = (TofuCommon.Content)((Iterator)localObject2).next();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("detail", localContent.title.get());
          localJSONObject2.put("color", localContent.color.get());
          ((JSONArray)localObject1).put(localJSONObject2);
        }
        localJSONObject1.put("content_list", localObject1);
      }
      if (paramTofuCubeInfo.uint64_uin.has())
      {
        localObject1 = new JSONArray();
        paramTofuCubeInfo = paramTofuCubeInfo.uint64_uin.get().iterator();
        while (paramTofuCubeInfo.hasNext()) {
          ((JSONArray)localObject1).put(String.valueOf(((Long)paramTofuCubeInfo.next()).longValue()));
        }
        localJSONObject1.put("frd_uin", localObject1);
      }
    }
    catch (JSONException paramTofuCubeInfo)
    {
      QLog.d("BeancurdHandler", 1, "getBeancurdExInfoStr err: ", paramTofuCubeInfo);
    }
    return localJSONObject1.toString();
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    if (!a(paramContext, paramString1, paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BeancurdHandler", 2, "can not request before next requestTime");
      }
      return;
    }
    b(paramContext, paramString1, paramString2);
  }
  
  protected void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("next_requestTime");
    BaseSharedPreUtil.a(paramContext, paramString1, true, localStringBuilder.toString(), Long.valueOf(paramLong));
  }
  
  public void a(IBeancurdUpdater paramIBeancurdUpdater)
  {
    this.a = paramIBeancurdUpdater;
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BeancurdHandler", 2, "handleGetBeancurd | data is null");
      }
      return;
    }
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("friendUin", "");
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null) && (paramFromServiceMsg.uint32_result.get() == 0))
      {
        paramObject = new oidb_cmd0xf7e.RspBody();
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        a(this.appRuntime.getApp(), this.appRuntime.getCurrentAccountUin(), paramToServiceMsg, paramObject.uint64_next_pull_time.get());
        b(this.appRuntime.getApp(), this.appRuntime.getCurrentAccountUin(), paramToServiceMsg, NetConnInfoCenter.getServerTime());
        if (a(paramObject)) {
          return;
        }
        paramFromServiceMsg = paramObject.msg_tofu_cube_info;
        paramObject = new NewBeancurdMsg();
        paramObject.busiid = paramFromServiceMsg.uint64_busi_id.get();
        paramObject.frienduin = paramToServiceMsg;
        paramObject.busiUuid = paramFromServiceMsg.string_busi_uuid.get();
        paramObject.extensionInfoStr = a(paramFromServiceMsg);
        if (this.a != null) {
          this.a.a(paramObject);
        }
      }
      else
      {
        QLog.e("BeancurdHandler", 1, "handleGetBeancurd oidb error");
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BeancurdHandler", 2, "handleGetBeancurd err", paramToServiceMsg);
      }
    }
  }
  
  protected boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return NetConnInfoCenter.getServerTime() >= a(paramContext, paramString1, paramString2);
  }
  
  protected long b(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("last_requestTime");
    return ((Long)BaseSharedPreUtil.a(paramContext, paramString1, localStringBuilder.toString(), Long.valueOf(0L))).longValue();
  }
  
  protected void b(Context paramContext, String paramString1, String paramString2)
  {
    oidb_cmd0xf7e.ReqBody localReqBody = new oidb_cmd0xf7e.ReqBody();
    localReqBody.uint64_frd_uin.set(Long.valueOf(paramString2).longValue());
    localReqBody.uint64_last_pull_time.set(b(paramContext, paramString1, paramString2));
    paramContext = makeOIDBPkg("OidbSvc.0xf7e_1", 3966, 1, localReqBody.toByteArray(), 30000L);
    paramContext.addAttribute("friendUin", paramString2);
    sendPbReq(paramContext);
  }
  
  protected void b(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("last_requestTime");
    BaseSharedPreUtil.a(paramContext, paramString1, true, localStringBuilder.toString(), Long.valueOf(paramLong));
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xf7e_1");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BeancurdHandler", 2, "onReceive,resp == null");
      }
      return;
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      return;
    }
    if (str.equals("OidbSvc.0xf7e_1")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.BeancurdHandler
 * JD-Core Version:    0.7.0.1
 */