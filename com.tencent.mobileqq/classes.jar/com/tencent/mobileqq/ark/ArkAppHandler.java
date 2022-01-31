package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import com.tencent.ark.ArkAppPanelReport.ReqBody;
import com.tencent.ark.ArkSearchMsg.ReqBody;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Map;
import java.util.Random;

public class ArkAppHandler
  extends BusinessHandler
{
  private static final int[] a = { 95 };
  
  public ArkAppHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      paramToServiceMsg = new String((byte[])paramObject, "UTF-8");
      paramFromServiceMsg = paramToServiceMsg;
      if (paramToServiceMsg == null) {
        paramFromServiceMsg = "";
      }
      return paramFromServiceMsg;
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        ArkAppCenter.b("ArkApp.BusinessHandler", String.format("onReceive_AppMsg, fail convert data to string", new Object[0]));
        paramToServiceMsg = null;
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    paramBusinessObserver = super.a(paramString, paramBusinessObserver);
    paramBusinessObserver.addAttribute("SendTime", Long.valueOf(System.currentTimeMillis()));
    paramBusinessObserver.addAttribute("IsGenericCmd", Boolean.valueOf(paramBoolean));
    paramBusinessObserver.addAttribute("IsPanelRequest", Boolean.valueOf(false));
    paramBusinessObserver.addAttribute("NotifyType", Integer.valueOf(paramInt2));
    paramBusinessObserver.putWupBuffer(paramArrayOfByte);
    if (paramInt1 > 0) {
      paramBusinessObserver.setTimeout(paramInt1);
    }
    if (!Cmd2HandlerMap.a().containsKey(paramString)) {
      Cmd2HandlerMap.a(paramString, a);
    }
    super.b(paramBusinessObserver);
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        paramToServiceMsg = (Proto.EchoRsp)new Proto.EchoRsp().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null) {
          return null;
        }
        if (paramToServiceMsg.msg.has())
        {
          paramToServiceMsg = paramToServiceMsg.msg.get();
          paramFromServiceMsg = paramToServiceMsg;
          if (paramToServiceMsg == null) {
            paramFromServiceMsg = "";
          }
          return paramFromServiceMsg;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        return null;
      }
      paramToServiceMsg = null;
    }
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    long l1 = ((Long)paramToServiceMsg.getAttribute("SendTime")).longValue();
    long l2 = System.currentTimeMillis();
    boolean bool2 = ((Boolean)paramToServiceMsg.getAttribute("IsGenericCmd")).booleanValue();
    boolean bool3 = ((Boolean)paramToServiceMsg.getAttribute("IsPanelRequest")).booleanValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("NotifyType")).intValue();
    String str = paramFromServiceMsg.getServiceCmd();
    ArkAppCenter.b("ArkApp.BusinessHandler", String.format("onReceive, cmd=%s, app-msg=%s, panelRequest=%s, suc=%s, delay=%d, ", new Object[] { str, Boolean.toString(bool2), Boolean.toString(bool3), Boolean.toString(bool1), Long.valueOf(l2 - l1) }));
    if (bool1) {
      if (bool2) {
        if (!bool3) {}
      }
    }
    for (;;)
    {
      if (paramObject != null)
      {
        super.a(paramToServiceMsg, i, true, paramObject);
        return;
        paramObject = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        continue;
        if (str.equalsIgnoreCase("ArkAppSvc.Echo")) {
          paramObject = b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      else
      {
        super.a(paramToServiceMsg, i, false, null);
        return;
      }
      paramObject = null;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt4, int paramInt5)
  {
    if (ArkAiAppCenter.b <= 0)
    {
      ArkAppCenter.a("ArkApp.BusinessHandler", String.format("reportArkSearchData is disabled", new Object[0]));
      return false;
    }
    if ((ArkAiAppCenter.b < 100) && (new Random().nextInt(100) > ArkAiAppCenter.b))
    {
      ArkAppCenter.a("ArkApp.BusinessHandler", String.format("reportArkSearchData not report as rate=%d", new Object[] { Integer.valueOf(ArkAiAppCenter.b) }));
      return false;
    }
    if ((paramInt1 != 100) && ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))))
    {
      ArkAppCenter.a("ArkApp.BusinessHandler", String.format("reportArkSearchData for arkserver msgId or extraInfo is null", new Object[0]));
      return false;
    }
    ArkSearchMsg.ReqBody localReqBody = new ArkSearchMsg.ReqBody();
    localReqBody.uint32_type.set(paramInt1);
    localReqBody.uint32_scene.set(paramInt2);
    localReqBody.uint32_action.set(paramInt3);
    if (!TextUtils.isEmpty(paramString1)) {
      localReqBody.bytes_extra_info.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localReqBody.bytes_msg_id.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localReqBody.bytes_card_type.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localReqBody.bytes_card_view.set(ByteStringMicro.copyFromUtf8(paramString4));
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localReqBody.bytes_text.set(ByteStringMicro.copyFromUtf8(paramString5));
    }
    localReqBody.uint32_flag.set(paramInt4);
    localReqBody.uint32_first_report.set(paramInt5);
    ArkAppCenter.a("ArkApp.BusinessHandler", String.format("reportArkSearchData CMD_ArkSearchReport type=%d, scene=%d, action=%d, extra=%s, msgId=%s, cardType=%s,cardView=%s, msgText=%s, flag=%d, first=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString1, paramString2, paramString3, paramString4, Utils.a(paramString5), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) }));
    paramString1 = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "MQInference.DataRecv");
    paramString1.putWupBuffer(localReqBody.toByteArray());
    paramString1.setNeedCallback(false);
    b(paramString1);
    return true;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBusinessObserver == null)) {
      return false;
    }
    paramBusinessObserver = super.a(paramString, paramBusinessObserver);
    paramBusinessObserver.addAttribute("SendTime", Long.valueOf(System.currentTimeMillis()));
    paramBusinessObserver.addAttribute("IsGenericCmd", Boolean.valueOf(true));
    paramBusinessObserver.addAttribute("IsPanelRequest", Boolean.valueOf(true));
    paramBusinessObserver.addAttribute("NotifyType", Integer.valueOf(paramInt2));
    if (paramInt1 > 0) {
      paramBusinessObserver.setTimeout(paramInt1);
    }
    if (!Cmd2HandlerMap.a().containsKey(paramString)) {
      Cmd2HandlerMap.a(paramString, a);
    }
    super.b(paramBusinessObserver);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBusinessObserver == null)) {
      return false;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    try
    {
      paramString2 = str.getBytes("UTF-8");
      a(paramString1, true, paramString2, paramInt1, paramInt2, paramBusinessObserver);
      return true;
    }
    catch (Exception paramString2)
    {
      ArkAppCenter.b("ArkApp.BusinessHandler", String.format("sendAppMsg, fail convert content to bytes array, cmd=%s, content=%s", new Object[] { paramString1, str }));
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ArkAppPanelReport.ReqBody localReqBody = new ArkAppPanelReport.ReqBody();
    localReqBody.bytes_app_name.set(ByteStringMicro.copyFromUtf8(paramString));
    ArkAppCenter.a("ArkApp.BusinessHandler", String.format("reportArkAppPanelIconClick appName=%s", new Object[] { paramString }));
    paramString = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "ArkAppPanel.Report");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setNeedCallback(false);
    b(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppHandler
 * JD-Core Version:    0.7.0.1
 */