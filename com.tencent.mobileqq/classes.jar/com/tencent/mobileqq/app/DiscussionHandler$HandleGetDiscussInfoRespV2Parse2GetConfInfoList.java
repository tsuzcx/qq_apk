package com.tencent.mobileqq.app;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0x58b.cmd0x58b.CmdErrorCode;
import tencent.im.oidb.cmd0x58b.cmd0x58b.GetConfInfoRsp;
import tencent.im.oidb.cmd0x58b.cmd0x58b.GetMultiConfInfoRsp;
import tencent.im.oidb.cmd0x58b.cmd0x58b.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class DiscussionHandler$HandleGetDiscussInfoRespV2Parse2GetConfInfoList
{
  private boolean b;
  private byte[] c;
  private ArrayList<Object> d;
  private HashMap<String, DiscussionHandler.ReqDiscussInfo> e;
  private List<cmd0x58b.GetConfInfoRsp> f;
  
  public DiscussionHandler$HandleGetDiscussInfoRespV2Parse2GetConfInfoList(byte[] paramArrayOfByte, ArrayList<Object> paramArrayList, HashMap<String, DiscussionHandler.ReqDiscussInfo> paramHashMap)
  {
    this.c = paramArrayList;
    this.d = paramHashMap;
    Object localObject;
    this.e = localObject;
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public List<cmd0x58b.GetConfInfoRsp> b()
  {
    return this.f;
  }
  
  public HandleGetDiscussInfoRespV2Parse2GetConfInfoList c()
  {
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    try
    {
      localObject1 = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom(this.c);
      if ((((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.has()) && (((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.get() == 0) && (((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.get() != null))
      {
        cmd0x58b.RspBody localRspBody = new cmd0x58b.RspBody();
        try
        {
          localRspBody.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.get().toByteArray());
          if (localRspBody.msg_cmd_error_code.uint32_code.get() != 0)
          {
            this.a.a(this.e.values());
            this.a.notifyUI(1001, false, this.d);
            this.b = true;
            return this;
          }
          boolean bool = localRspBody.msg_get_multi_conf_info.has();
          localObject2 = null;
          if (bool) {
            localObject1 = (cmd0x58b.GetMultiConfInfoRsp)localRspBody.msg_get_multi_conf_info.get();
          } else {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            if (((cmd0x58b.GetMultiConfInfoRsp)localObject1).msg_get_conf_info.has()) {
              localObject2 = ((cmd0x58b.GetMultiConfInfoRsp)localObject1).msg_get_conf_info.get();
            }
            this.f = ((List)localObject2);
          }
          else
          {
            this.f = null;
          }
          this.b = false;
          return this;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("rspBody merge fail ");
            ((StringBuilder)localObject2).append(localInvalidProtocolBufferMicroException1.toString());
            QLog.e("Q.contacttab.dscs", 2, ((StringBuilder)localObject2).toString());
          }
          this.a.notifyUI(1001, false, this.d);
          this.b = true;
          return this;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sso check fail ");
        ((StringBuilder)localObject2).append(localInvalidProtocolBufferMicroException1.uint32_result.get());
        QLog.e("Q.contacttab.dscs", 2, ((StringBuilder)localObject2).toString());
      }
      this.a.notifyUI(1001, false, this.d);
      this.b = true;
      return this;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("merge fail ");
        ((StringBuilder)localObject2).append(localInvalidProtocolBufferMicroException2.toString());
        QLog.e("Q.contacttab.dscs", 2, ((StringBuilder)localObject2).toString());
      }
      this.a.notifyUI(1001, false, this.d);
      this.b = true;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionHandler.HandleGetDiscussInfoRespV2Parse2GetConfInfoList
 * JD-Core Version:    0.7.0.1
 */