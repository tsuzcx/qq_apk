import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x6ff.subcmd0x501.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.IpAddr;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs;

public class bfvc
  extends alko
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int c;
  
  public bfvc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 8 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 16 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 24 & 0xFF);
    return a(localStringBuilder.toString(), paramInt2);
  }
  
  private static String a(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    localStringBuffer.append("http://").append(paramString);
    if (paramInt != 80) {
      localStringBuffer.append(":").append(paramInt);
    }
    localStringBuffer.append("/");
    return localStringBuffer.toString();
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = this.jdField_a_of_type_JavaLangObject;
        boolean bool1 = bool2;
        if (paramArrayOfByte1 != null) {
          bool1 = bool2;
        }
        try
        {
          if (paramArrayOfByte1.length > 0)
          {
            this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
            bool1 = true;
          }
          bool2 = bool1;
          if (paramArrayOfByte2 != null)
          {
            bool2 = bool1;
            if (paramArrayOfByte2.length > 0)
            {
              this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
              bool2 = true;
            }
          }
          if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
            break label154;
          }
          this.jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
          bool2 = bool3;
        }
        finally {}
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 2, "saveSrvParam | changed = " + bool2 + " | usingIndex = " + this.jdField_a_of_type_Int);
        }
        return;
      }
      finally {}
      label154:
      if (!bool2) {}
    }
  }
  
  public String a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString;
      if ((localObject2 != null) && (localObject2.length != 0))
      {
        this.jdField_a_of_type_Int %= localObject2.length;
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 2, "getSrvUrl | usingIndex = " + this.jdField_a_of_type_Int + " | count = " + localObject2.length + " | result = " + localObject2[this.jdField_a_of_type_Int]);
        }
        localObject2 = localObject2[this.jdField_a_of_type_Int];
        return localObject2;
      }
      return null;
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Boolean = false;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
      {
        i = 1;
        int j = paramToServiceMsg.extraData.getInt("big_data_cmd", -1);
        paramToServiceMsg.extraData.getInt("big_data_sub_cmd", -1);
        int k = paramToServiceMsg.extraData.getInt("big_data_cmd_seq", -1);
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 1, "handleGetIPList " + j + " handler: " + getClass().getSimpleName() + " reqSeq = " + k);
        }
        if (i == 0) {
          break label456;
        }
        if (paramObject == null) {
          break label402;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new subcmd0x501.RspBody();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = (subcmd0x501.SubCmd0x501Rspbody)paramToServiceMsg.msg_subcmd_0x501_rsp_body.get();
        paramToServiceMsg = paramObject.bytes_session_key.get();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.toByteArray().length <= 0)) {
          break label533;
        }
        paramToServiceMsg = paramToServiceMsg.toByteArray();
        paramFromServiceMsg = paramObject.bytes_httpconn_sig_session.get();
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.toByteArray().length <= 0)) {
          break label528;
        }
        paramFromServiceMsg = paramFromServiceMsg.toByteArray();
        paramObject = paramObject.rpt_msg_httpconn_addrs.get();
        if ((paramObject == null) || (paramObject.size() == 0)) {
          break label523;
        }
        paramObject = paramObject.iterator();
        if (!paramObject.hasNext()) {
          break label523;
        }
        ??? = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)paramObject.next();
        if (((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)???).uint32_service_type.get() != 1) {
          continue;
        }
        ??? = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)???).rpt_msg_addrs.get();
        if ((??? == null) || (((List)???).size() == 0)) {
          break label523;
        }
        paramObject = new String[((List)???).size()];
        i = 0;
        if (i < ((List)???).size())
        {
          subcmd0x501.SubCmd0x501Rspbody.IpAddr localIpAddr = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)((List)???).get(i);
          paramObject[i] = a(localIpAddr.uint32_ip.get(), localIpAddr.uint32_port.get());
          i += 1;
          continue;
          paramToServiceMsg = finally;
          throw paramToServiceMsg;
          i = 0;
          break;
        }
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        notifyUI(2001, true, null);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        label402:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BigDataGetIpHandler", 1, "handleGetIPList fail, because exception", paramToServiceMsg);
        paramToServiceMsg.printStackTrace();
        notifyUI(2001, false, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BigDataGetIpHandler", 1, "handleRefreshGetAllTags fail, because data is null");
      }
      notifyUI(2001, false, null);
      return;
      label456:
      if (paramFromServiceMsg == null) {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 1, "getAllTags handleGetIPList fail, because res is null");
        }
      }
      for (;;)
      {
        notifyUI(2001, false, null);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 1, "getAllTags handleGetIPList fail, because res code: " + paramFromServiceMsg.getResultCode());
        }
      }
      label523:
      paramObject = null;
      continue;
      label528:
      paramFromServiceMsg = null;
      continue;
      label533:
      paramToServiceMsg = null;
    }
  }
  
  public boolean a(int paramInt1, MessageMicro<?> arg2, int paramInt2, Object paramObject)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean) {
        return true;
      }
      long l1 = System.currentTimeMillis();
      if (l1 - this.jdField_a_of_type_Long > 30000L) {
        this.c = 0;
      }
      if (this.c > 5)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 2, "req get ip too frequently");
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BigDataGetIpHandler", 2, "req get ip list");
      }
      long l2;
      try
      {
        l2 = Long.parseLong(this.app.getCurrentAccountUin());
        if (l2 <= 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BigDataGetIpHandler", 2, "uin illegal");
          }
          return false;
        }
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 2, "req get ip list case long fail");
        }
        return false;
      }
      this.jdField_a_of_type_Long = l1;
      this.c += 1;
      this.jdField_a_of_type_Boolean = true;
      paramObject = new subcmd0x501.SubCmd0x501ReqBody();
      paramObject.uint64_uin.set(l2);
      paramObject.uint32_idc_id.set(0);
      paramObject.uint32_appid.set(16);
      paramObject.uint32_login_sig_type.set(1);
      paramObject.uint32_request_flag.set(3);
      Object localObject = new ArrayList();
      ((List)localObject).add(Integer.valueOf(1));
      paramObject.rpt_uint32_service_types.set((List)localObject);
      localObject = new subcmd0x501.ReqBody();
      ((subcmd0x501.ReqBody)localObject).msg_subcmd_0x501_req_body.set(paramObject);
      paramObject = createToServiceMsg("HttpConn.0x6ff_501");
      paramObject.putWupBuffer(((subcmd0x501.ReqBody)localObject).toByteArray());
      paramObject.extraData.putInt("big_data_cmd", paramInt1);
      paramObject.extraData.putInt("big_data_sub_cmd", paramInt2);
      paramInt2 = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = (paramInt2 + 1);
      paramObject.extraData.putInt("big_data_cmd_seq", paramInt2);
      sendPbReq(paramObject);
      if (QLog.isColorLevel()) {
        QLog.d("BigDataGetIpHandler", 1, "getIPList " + paramInt1 + " handler: " + getClass().getSimpleName() + " reqSeq = " + this.jdField_b_of_type_Int + " curSeq = " + paramInt2);
      }
      return true;
    }
  }
  
  public byte[] a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      return arrayOfByte;
    }
  }
  
  public byte[] b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
      return arrayOfByte;
    }
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return bfvh.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("HttpConn.0x6ff_501".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataGetIpHandler", 2, "CMD_GET_IP_LIST");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfvc
 * JD-Core Version:    0.7.0.1
 */