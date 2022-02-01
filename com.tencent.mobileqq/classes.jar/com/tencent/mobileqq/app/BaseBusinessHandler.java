package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class BaseBusinessHandler
  extends OidbWrapper
{
  public static final String SEQ_KEY = "com.tencent.mobileqq.app.BaseBusinessHandler";
  protected Set<String> allowCmdSet;
  protected AppInterface appRuntime;
  protected Map<Long, BusinessObserver> bgObserverMap = new HashMap();
  protected long seq;
  protected Map<Long, BusinessObserver> uiObserverMap = new HashMap();
  
  protected void addBusinessObserver(ToServiceMsg paramToServiceMsg, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramBusinessObserver != null)
    {
      if (paramBoolean) {
        ??? = this.bgObserverMap;
      }
      synchronized (this.uiObserverMap)
      {
        ???.put(Long.valueOf(this.seq), paramBusinessObserver);
        paramToServiceMsg = paramToServiceMsg.extraData;
        paramBusinessObserver = SEQ_KEY;
        long l = this.seq;
        this.seq = (1L + l);
        paramToServiceMsg.putLong(paramBusinessObserver, l);
        return;
      }
    }
  }
  
  public ToServiceMsg createToServiceMsg(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), paramString);
  }
  
  public ToServiceMsg createToServiceMsg(String paramString, BusinessObserver paramBusinessObserver)
  {
    return createToServiceMsg(paramString, paramBusinessObserver, false);
  }
  
  ToServiceMsg createToServiceMsg(String arg1, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg(???);
    if (paramBusinessObserver != null)
    {
      if (paramBoolean) {
        ??? = this.bgObserverMap;
      }
      synchronized (this.uiObserverMap)
      {
        ???.put(Long.valueOf(this.seq), paramBusinessObserver);
        paramBusinessObserver = localToServiceMsg.extraData;
        String str = SEQ_KEY;
        long l = this.seq;
        this.seq = (1L + l);
        paramBusinessObserver.putLong(str, l);
        return localToServiceMsg;
      }
    }
    return localToServiceMsg;
  }
  
  public final <T> T decodePacket(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte)
    {
      label31:
      break label31;
    }
    return null;
  }
  
  protected abstract Set<String> getCommandList();
  
  public String getCurrentAccountUin()
  {
    return this.appRuntime.getAccount();
  }
  
  protected abstract Set<String> getPushCommandList();
  
  protected abstract Set<String> getPushPBCommandList();
  
  public final boolean isPbReq(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null) {
      return paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
    }
    return false;
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null) {
      this.allowCmdSet = getCommandList();
    }
    Set localSet = this.allowCmdSet;
    boolean bool = false;
    if (localSet == null) {
      return false;
    }
    if (!localSet.contains(paramString)) {
      bool = true;
    }
    return bool;
  }
  
  public abstract void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    this.appRuntime.sendToService(paramToServiceMsg);
  }
  
  public void sendPbReq(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      this.appRuntime.sendToService(paramToServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseBusinessHandler
 * JD-Core Version:    0.7.0.1
 */