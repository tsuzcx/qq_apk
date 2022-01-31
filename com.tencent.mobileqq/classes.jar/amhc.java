import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.nio.ByteBuffer;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class amhc
  extends ajtb
{
  private short a = -23193;
  
  public amhc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      if (!bool2) {
        break label317;
      }
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0)) {
          if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (paramFromServiceMsg.rpt_msg_uin_data.size() > 0) {
            if (((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0)).uint32_flag_color_note_recent_switch.get() == 1)
            {
              bool1 = true;
              bool2 = true;
              notifyUI(1, bool2, new Object[] { Boolean.valueOf(bool1) });
              return;
              bool2 = false;
              break;
              paramFromServiceMsg = paramFromServiceMsg;
              QLog.e("ColorNoteHandler", 1, "pkg.mergeFrom error: ", paramFromServiceMsg);
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          QLog.e("ColorNoteHandler", 1, "response.mergeFrom error: ", paramToServiceMsg);
          continue;
          bool1 = false;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteHandler", 0, "handleReqGetColorNoteRecentSwitch: response.rpt_msg_uin_data.size() < 0");
          }
          bool1 = true;
          bool2 = false;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteHandler", 0, "handleReqGetColorNoteRecentSwitch: pkg.bytes_bodybuffer is null");
        }
        bool1 = true;
        bool2 = false;
        continue;
        if (QLog.isColorLevel())
        {
          if (!paramToServiceMsg.uint32_result.has()) {
            break label306;
          }
          QLog.d("ColorNoteHandler", 0, "handleReqGetColorNoteRecentSwitch: pkg.uint32_result error code: " + paramToServiceMsg.uint32_result.get());
        }
      }
      for (;;)
      {
        bool1 = true;
        bool2 = false;
        break;
        label306:
        QLog.d("ColorNoteHandler", 0, "handleReqGetColorNoteRecentSwitch: pkg.uint32_result do not have");
      }
      label317:
      boolean bool1 = true;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool3;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool3 = bool1;
      if (!bool1) {
        break label278;
      }
      bool2 = bool1;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool2 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool3 = bool1;
        if (!bool1) {
          break label278;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label278;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label278;
        }
        bool2 = bool1;
        i = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        if (i >= 0) {
          continue;
        }
        l = i + 4294967296L;
        bool2 = bool1;
        if (this.app == null) {
          continue;
        }
        bool2 = bool1;
        if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (!QLog.isColorLevel()) {
          break label278;
        }
        bool2 = bool1;
        QLog.d("ColorNoteHandler", 0, "handleReqSetColorNoteRecentSwitch: set switch success");
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          int i;
          long l;
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteHandler", 0, "handleReqSetColorNoteRecentSwitch: set switch failed");
          }
          bool1 = false;
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            bool1 = false;
          }
        }
        paramToServiceMsg = paramToServiceMsg;
        bool1 = bool2;
      }
      notifyUI(2, bool1, null);
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      l = i;
      continue;
      QLog.e("ColorNoteHandler", 1, "handleReqSetColorNoteRecentSwitch: oidb_sso errors", paramToServiceMsg);
      continue;
      label278:
      bool1 = bool3;
    }
  }
  
  public void a()
  {
    String str;
    Object localObject;
    if (this.app != null)
    {
      str = this.app.getCurrentAccountUin();
      localObject = new oidb_0x5eb.ReqBody();
    }
    try
    {
      long l = Long.parseLong(str);
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      ((oidb_0x5eb.ReqBody)localObject).uint32_flag_color_note_recent_switch.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x5eb_cn_switch", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", str);
      ((ToServiceMsg)localObject).extraData.putBoolean("uint32_flag_color_note_recent_switch", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ColorNoteHandler", 1, "reqGetColorNoteRecentSwitch: parseLongError: ", localException);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    short s = 0;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Object localObject1;
      if (this.app != null) {
        localObject1 = this.app.getCurrentAccountUin();
      }
      try
      {
        long l = Long.parseLong((String)localObject1);
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        Object localObject2 = ByteBuffer.allocate(13);
        if (paramBoolean) {
          s = 1;
        }
        ((ByteBuffer)localObject2).putInt(bbbr.a(l)).put((byte)0).putShort((short)1).putShort(this.a).putShort((short)2).putShort(s);
        ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
        localObject2 = createToServiceMsg("OidbSvc.0x4ff_cn_switch");
        ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
        ((ToServiceMsg)localObject2).setTimeout(30000L);
        sendPbReq((ToServiceMsg)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteHandler", 0, "reqSetColorNoteRecentSwitch: request sent, switch: " + paramBoolean);
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ColorNoteHandler", 1, "reqSetColorNoteRecentSwitch error: ", localException);
      }
    }
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return amhd.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (TextUtils.equals("OidbSvc.0x5eb_cn_switch", paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHandler", 0, "onReceive: receive CMD_REQ_GET_SWITCH message");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!TextUtils.equals("OidbSvc.0x4ff_cn_switch", paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHandler", 0, "onReceive: receive CMD_REQ_SET_SWITCH message");
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amhc
 * JD-Core Version:    0.7.0.1
 */