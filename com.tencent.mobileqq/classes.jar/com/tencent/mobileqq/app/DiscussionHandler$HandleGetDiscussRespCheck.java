package com.tencent.mobileqq.app;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x58a.cmd0x58a.ConfBaseInfo;
import tencent.im.oidb.cmd0x58a.cmd0x58a.GetConfListRsp;
import tencent.im.oidb.cmd0x58a.cmd0x58a.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class DiscussionHandler$HandleGetDiscussRespCheck
{
  private boolean b;
  private oidb_sso.OIDBSSOPkg c;
  private List<cmd0x58a.ConfBaseInfo> d;
  private List<Long> e;
  
  public DiscussionHandler$HandleGetDiscussRespCheck(DiscussionHandler paramDiscussionHandler, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    this.c = paramOIDBSSOPkg;
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public List<cmd0x58a.ConfBaseInfo> b()
  {
    return this.d;
  }
  
  public List<Long> c()
  {
    return this.e;
  }
  
  public HandleGetDiscussRespCheck d()
  {
    Object localObject1 = this.c;
    if ((localObject1 != null) && (((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.has()) && (this.c.uint32_result.get() == 0) && (this.c.bytes_bodybuffer.has()) && (this.c.bytes_bodybuffer.get() != null))
    {
      localObject1 = new cmd0x58a.RspBody();
      try
      {
        ((cmd0x58a.RspBody)localObject1).mergeFrom(this.c.bytes_bodybuffer.get().toByteArray());
        if (((cmd0x58a.RspBody)localObject1).msg_get_conf_list.has()) {
          localObject1 = (cmd0x58a.GetConfListRsp)((cmd0x58a.RspBody)localObject1).msg_get_conf_list.get();
        } else {
          localObject1 = null;
        }
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.contacttab.dscs", 2, "getConfInfoRsp is null");
          }
          this.a.notifyUI(1000, true, null);
          this.b = true;
          return this;
        }
        if (((cmd0x58a.GetConfListRsp)localObject1).rpt_msg_conf_base_info.has()) {
          localObject3 = ((cmd0x58a.GetConfListRsp)localObject1).rpt_msg_conf_base_info.get();
        } else {
          localObject3 = null;
        }
        this.d = ((List)localObject3);
        if (((cmd0x58a.GetConfListRsp)localObject1).rpt_uint64_other_conf_list.has()) {
          localObject1 = ((cmd0x58a.GetConfListRsp)localObject1).rpt_uint64_other_conf_list.get();
        } else {
          localObject1 = null;
        }
        this.e = ((List)localObject1);
        if (this.d == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.contacttab.dscs", 2, "baseInfo is null");
          }
          this.a.notifyUI(1000, false, null);
          this.b = true;
          return this;
        }
        this.b = false;
        return this;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        Object localObject3;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("rspBody merge fail ");
          ((StringBuilder)localObject3).append(localInvalidProtocolBufferMicroException.toString());
          QLog.e("Q.contacttab.dscs", 2, ((StringBuilder)localObject3).toString());
        }
        this.a.notifyUI(1000, false, null);
        this.b = true;
        return this;
      }
    }
    if (QLog.isColorLevel())
    {
      Object localObject2 = this.c;
      int i;
      if (localObject2 != null) {
        i = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get();
      } else {
        i = -1;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sso check fail ");
      ((StringBuilder)localObject2).append(i);
      QLog.e("Q.contacttab.dscs", 2, ((StringBuilder)localObject2).toString());
    }
    this.a.notifyUI(1000, false, null);
    this.b = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionHandler.HandleGetDiscussRespCheck
 * JD-Core Version:    0.7.0.1
 */