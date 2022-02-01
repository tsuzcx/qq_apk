import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.json.JSONObject;
import tencent.im.cs.cmd0x6ff.subcmd0x501.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.IpAddr;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;
import tencent.im.msg.im_msg_head.TransOidbHead;
import tencent.im.oidb.cmd0x6b2.oidb_cmd0x6b2.ReqBody;
import tencent.im.oidb.cmd0x6b2.oidb_cmd0x6b2.RspBody;

public class axnv
  extends MSFServlet
{
  private static int jdField_a_of_type_Int;
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  static HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap;
  
  private static int a()
  {
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    return i;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 8 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 16 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 24 & 0xFF);
    return a(localStringBuilder.toString(), paramInt2);
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    localStringBuffer.append("http://").append(paramString);
    if (paramInt != 80) {
      localStringBuffer.append(":").append(paramInt);
    }
    localStringBuffer.append("/");
    return localStringBuffer.toString();
  }
  
  private void a(Intent paramIntent, int paramInt, byte[] paramArrayOfByte1, byte[] arg4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAlumniServlet", 2, "respGetNearbyAlumni, errorCode = " + paramInt);
    }
    paramIntent.getStringExtra("param_req_json_string");
    String str2 = paramIntent.getStringExtra("param_callback_key");
    String str1 = paramIntent.getStringExtra("param_callback_id");
    Object localObject1 = null;
    paramIntent = localObject1;
    int i = paramInt;
    int k;
    if (paramInt == 0) {
      try
      {
        k = paramArrayOfByte1.length;
        if ((paramArrayOfByte1[0] != 40) || (paramArrayOfByte1[(k - 1)] != 41))
        {
          paramIntent = "unexpected body data, len=" + k + ", data=";
          paramArrayOfByte1 = paramArrayOfByte1.toString();
          ??? = new StringBuilder().append(paramIntent);
          paramIntent = paramArrayOfByte1;
          if (paramArrayOfByte1.length() > 20) {
            paramIntent = paramArrayOfByte1.substring(0, 20);
          }
          throw new RuntimeException(paramIntent);
        }
      }
      catch (Exception paramArrayOfByte1)
      {
        paramInt = -10;
        paramIntent = localObject1;
        i = paramInt;
        if (QLog.isColorLevel())
        {
          QLog.i("NearbyAlumniServlet", 2, "respGetNearbyAlumni | Exception:" + paramArrayOfByte1.getMessage());
          i = paramInt;
          paramIntent = localObject1;
        }
      }
    }
    for (;;)
    {
      paramArrayOfByte1 = null;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilHashMap != null) {
          paramArrayOfByte1 = jdField_a_of_type_JavaUtilHashMap.remove(str2);
        }
        if (axql.b()) {
          axql.a("NearbyAlumniServlet", new Object[] { "respGetNearbyAlumni", Integer.valueOf(i), paramArrayOfByte1 });
        }
        if ((paramArrayOfByte1 instanceof aaqc)) {
          paramArrayOfByte1 = (aaqc)paramArrayOfByte1;
        }
      }
      try
      {
        ??? = new JSONObject();
        ???.put("resultCode", i);
        ???.put("data", paramIntent);
        paramIntent = ???.toString();
        paramArrayOfByte1.callJs(str1, new String[] { paramIntent });
        return;
        paramIntent = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte1));
        paramIntent.readByte();
        i = paramIntent.readInt();
        int j = paramIntent.readInt();
        if ((i > k) || (j > k)) {
          throw new RuntimeException("unexpected length, headLen=" + i + ", bodyLen=" + j);
        }
        if (QLog.isColorLevel()) {
          QLog.i("NearbyAlumniServlet", 2, "respGetNearbyAlumni | headLen=" + i + " | bodyLen=" + j);
        }
        if (i > 0)
        {
          paramArrayOfByte1 = new byte[i];
          paramIntent.read(paramArrayOfByte1);
          Object localObject2 = new im_msg_head.Head();
          ((im_msg_head.Head)localObject2).mergeFrom(paramArrayOfByte1);
          localObject2 = (im_msg_head.HttpConnHead)((im_msg_head.Head)localObject2).msg_httpconn_head.get();
          i = ((im_msg_head.HttpConnHead)localObject2).uint32_error_code.get();
          paramInt = i;
          if (QLog.isDevelopLevel())
          {
            paramArrayOfByte1 = new StringBuilder();
            paramArrayOfByte1.append("uint64_uin=").append(((im_msg_head.HttpConnHead)localObject2).uint64_uin.get()).append(", uint32_command=").append(((im_msg_head.HttpConnHead)localObject2).uint32_command.get()).append(", uint32_sub_command=").append(((im_msg_head.HttpConnHead)localObject2).uint32_sub_command.get()).append(", uint32_seq=").append(((im_msg_head.HttpConnHead)localObject2).uint32_seq.get()).append(", uint32_version=").append(((im_msg_head.HttpConnHead)localObject2).uint32_version.get()).append(", uint32_retry_times=").append(((im_msg_head.HttpConnHead)localObject2).uint32_retry_times.get()).append(", uint32_client_type=").append(((im_msg_head.HttpConnHead)localObject2).uint32_client_type.get()).append(", uint32_pub_no=").append(((im_msg_head.HttpConnHead)localObject2).uint32_pub_no.get()).append(", uint32_local_id=").append(((im_msg_head.HttpConnHead)localObject2).uint32_local_id.get()).append(", uint32_time_zone=").append(((im_msg_head.HttpConnHead)localObject2).uint32_time_zone.get()).append(", uint32_client_ip=").append(((im_msg_head.HttpConnHead)localObject2).uint32_client_ip.get()).append(", uint32_client_port=").append(((im_msg_head.HttpConnHead)localObject2).uint32_client_port.get()).append(", uint32_qzhttp_ip=").append(((im_msg_head.HttpConnHead)localObject2).uint32_qzhttp_ip.get()).append(", uint32_qzhttp_port=").append(((im_msg_head.HttpConnHead)localObject2).uint32_qzhttp_port.get()).append(", uint32_spp_ip=").append(((im_msg_head.HttpConnHead)localObject2).uint32_spp_ip.get()).append(", uint32_spp_port=").append(((im_msg_head.HttpConnHead)localObject2).uint32_spp_port.get()).append(", uint32_flag=").append(((im_msg_head.HttpConnHead)localObject2).uint32_flag.get()).append(", bytes_key=").append(((im_msg_head.HttpConnHead)localObject2).bytes_key.get()).append(", uint32_compress_type=").append(((im_msg_head.HttpConnHead)localObject2).uint32_compress_type.get()).append(", uint32_origin_size=").append(((im_msg_head.HttpConnHead)localObject2).uint32_origin_size.get()).append(", uint32_error_code=").append(((im_msg_head.HttpConnHead)localObject2).uint32_error_code.get()).append(", uint32_command_id=").append(((im_msg_head.HttpConnHead)localObject2).uint32_command_id.get()).append(", uint32_service_cmdid=").append(((im_msg_head.HttpConnHead)localObject2).uint32_service_cmdid.get());
            localObject2 = (im_msg_head.TransOidbHead)((im_msg_head.HttpConnHead)localObject2).msg_oidbhead.get();
            if (localObject2 != null) {
              paramArrayOfByte1.append(", TransOidbHead=[").append("uint32_command=").append(((im_msg_head.TransOidbHead)localObject2).uint32_command.get()).append("|uint32_service_type=").append(((im_msg_head.TransOidbHead)localObject2).uint32_service_type.get()).append("|uint32_result=").append(((im_msg_head.TransOidbHead)localObject2).uint32_result.get()).append("|str_error_msg=").append(((im_msg_head.TransOidbHead)localObject2).str_error_msg.get()).append("]");
            }
            QLog.i("NearbyAlumniServlet", 4, "HttpConnHead=" + paramArrayOfByte1.toString());
            paramInt = i;
          }
        }
        if ((j > 0) && (paramInt == 0))
        {
          paramArrayOfByte1 = new byte[j];
          paramIntent.read(paramArrayOfByte1);
          paramIntent = new Cryptor().decrypt(paramArrayOfByte1, ???);
          paramArrayOfByte1 = new oidb_cmd0x6b2.RspBody();
          paramArrayOfByte1.mergeFrom(paramIntent);
          paramIntent = paramArrayOfByte1.bytes_body.get().toStringUtf8();
          i = paramInt;
          continue;
          paramIntent = finally;
          throw paramIntent;
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
          paramIntent = "";
          continue;
          paramIntent = null;
        }
      }
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess()) {
      localObject1 = new subcmd0x501.RspBody();
    }
    try
    {
      paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      localObject2 = new byte[paramFromServiceMsg.getInt() - 4];
      paramFromServiceMsg.get((byte[])localObject2);
      ((subcmd0x501.RspBody)localObject1).mergeFrom((byte[])localObject2);
      localObject2 = (subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject1).msg_subcmd_0x501_rsp_body.get();
      paramFromServiceMsg = ((subcmd0x501.SubCmd0x501Rspbody)localObject2).bytes_session_key.get();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.toByteArray().length <= 0)) {
        break label341;
      }
      paramFromServiceMsg = paramFromServiceMsg.toByteArray();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        int i;
        if (QLog.isColorLevel())
        {
          QLog.i("NearbyAlumniServlet", 2, paramFromServiceMsg.getMessage());
          continue;
          localObject2 = null;
          continue;
          localObject1 = null;
          continue;
          paramFromServiceMsg = null;
        }
      }
    }
    localObject1 = ((subcmd0x501.SubCmd0x501Rspbody)localObject2).bytes_httpconn_sig_session.get();
    if ((localObject1 != null) && (((ByteStringMicro)localObject1).toByteArray().length > 0))
    {
      localObject1 = ((ByteStringMicro)localObject1).toByteArray();
      localObject2 = ((subcmd0x501.SubCmd0x501Rspbody)localObject2).rpt_msg_httpconn_addrs.get();
      if ((localObject2 != null) && (((List)localObject2).size() != 0))
      {
        localObject2 = ((List)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)((Iterator)localObject2).next();
        } while (((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject3).uint32_service_type.get() != 5);
        localObject3 = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject3).rpt_msg_addrs.get();
        if ((localObject3 != null) && (((List)localObject3).size() != 0))
        {
          localObject2 = new String[((List)localObject3).size()];
          i = 0;
          while (i < ((List)localObject3).size())
          {
            subcmd0x501.SubCmd0x501Rspbody.IpAddr localIpAddr = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)((List)localObject3).get(i);
            localObject2[i] = a(localIpAddr.uint32_ip.get(), localIpAddr.uint32_port.get());
            i += 1;
          }
          localObject3 = a();
          if (localObject3 != null) {
            ((axqp)localObject3).a(paramFromServiceMsg, (byte[])localObject1, (String[])localObject2);
          }
          a(paramIntent, null, true);
          return;
        }
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString1, Object paramObject, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("reqJsonStr can not be null!");
    }
    String str = String.valueOf(SystemClock.elapsedRealtime()) + "_" + paramString1;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilHashMap == null) {
        jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
      }
      jdField_a_of_type_JavaUtilHashMap.put(str, paramObject);
      paramObject = new NewIntent(paramAppInterface.getApplication(), axnv.class);
      paramObject.putExtra("param_cmd", paramInt1);
      paramObject.putExtra("param_subcmd", paramInt2);
      paramObject.putExtra("param_uin", Long.parseLong(paramAppInterface.getCurrentAccountUin()));
      paramObject.putExtra("param_req_json_string", paramString1);
      paramObject.putExtra("param_callback_key", str);
      paramObject.putExtra("param_callback_id", paramString2);
      paramAppInterface.startServlet(paramObject);
      return;
    }
  }
  
  private boolean a(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAlumniServlet", 2, "request get ip list");
    }
    long l = paramIntent.getLongExtra("param_uin", 0L);
    if (l == 0L) {
      return false;
    }
    paramIntent = new subcmd0x501.SubCmd0x501ReqBody();
    paramIntent.uint64_uin.set(l);
    paramIntent.uint32_idc_id.set(0);
    paramIntent.uint32_appid.set(16);
    paramIntent.uint32_login_sig_type.set(1);
    paramIntent.uint32_request_flag.set(3);
    Object localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(5));
    paramIntent.rpt_uint32_service_types.set((List)localObject);
    localObject = new subcmd0x501.ReqBody();
    ((subcmd0x501.ReqBody)localObject).msg_subcmd_0x501_req_body.set(paramIntent);
    paramPacket.setSSOCommand("HttpConn.0x6ff_501");
    paramIntent = ((subcmd0x501.ReqBody)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
    return true;
  }
  
  protected axqp a()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof NearbyAppInterface)) {
      return (axqp)localAppRuntime.getManager(axoc.l);
    }
    if ((localAppRuntime instanceof BrowserAppInterface)) {
      return ((BrowserAppInterface)localAppRuntime).a();
    }
    return null;
  }
  
  protected void a(Intent paramIntent, Packet paramPacket, boolean paramBoolean)
  {
    long l = paramIntent.getLongExtra("param_uin", 0L);
    int i = paramIntent.getIntExtra("param_subcmd", 0);
    if (axql.b()) {
      axql.a("NearbyAlumniServlet", new Object[] { "reqBigData", Integer.valueOf(i), Long.valueOf(l) });
    }
    Object localObject2 = paramIntent.getStringExtra("param_req_json_string");
    if ((l == 0L) || (TextUtils.isEmpty((CharSequence)localObject2))) {}
    Object localObject1;
    label567:
    do
    {
      do
      {
        return;
        Object localObject3 = a();
        if (localObject3 == null) {
          localObject1 = null;
        }
        while (localObject1 == null) {
          if (paramBoolean)
          {
            a(null, -1, null, null);
            return;
            localObject1 = ((axqp)localObject3).a();
          }
          else
          {
            a(paramIntent, paramPacket);
            return;
          }
        }
        Object localObject4 = new oidb_cmd0x6b2.ReqBody();
        ((oidb_cmd0x6b2.ReqBody)localObject4).bytes_body.set(ByteStringMicro.copyFromUtf8((String)localObject2));
        localObject4 = new Cryptor().encrypt(((oidb_cmd0x6b2.ReqBody)localObject4).toByteArray(), (byte[])localObject1);
        Object localObject5 = new im_msg_head.Head();
        ((im_msg_head.Head)localObject5).uint32_head_type.set(4);
        Object localObject6 = new im_msg_head.LoginSig();
        ((im_msg_head.LoginSig)localObject6).uint32_type.set(22);
        if (localObject3 == null) {
          localObject2 = null;
        }
        for (;;)
        {
          if (localObject2 != null)
          {
            ((im_msg_head.LoginSig)localObject6).bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject2));
            ((im_msg_head.Head)localObject5).msg_login_sig.set((MessageMicro)localObject6);
            localObject2 = new im_msg_head.HttpConnHead();
            ((im_msg_head.HttpConnHead)localObject2).uint64_uin.set(l);
            ((im_msg_head.HttpConnHead)localObject2).uint32_command.set(1791);
            ((im_msg_head.HttpConnHead)localObject2).uint32_sub_command.set(3088);
            ((im_msg_head.HttpConnHead)localObject2).uint32_seq.set(a());
            ((im_msg_head.HttpConnHead)localObject2).uint32_version.set(4643);
            ((im_msg_head.HttpConnHead)localObject2).uint32_flag.set(1);
            ((im_msg_head.HttpConnHead)localObject2).uint32_compress_type.set(0);
            ((im_msg_head.HttpConnHead)localObject2).uint32_error_code.set(0);
            localObject6 = new im_msg_head.TransOidbHead();
            ((im_msg_head.TransOidbHead)localObject6).uint32_command.set(1714);
            ((im_msg_head.TransOidbHead)localObject6).uint32_service_type.set(i);
            ((im_msg_head.HttpConnHead)localObject2).msg_oidbhead.set((MessageMicro)localObject6);
            ((im_msg_head.Head)localObject5).msg_httpconn_head.set((MessageMicro)localObject2);
            localObject2 = ((im_msg_head.Head)localObject5).toByteArray();
            localObject5 = new ByteArrayOutputStream();
          }
          try
          {
            localObject6 = new DataOutputStream((OutputStream)localObject5);
            ((DataOutputStream)localObject6).write(40);
            ((DataOutputStream)localObject6).writeInt(localObject2.length);
            ((DataOutputStream)localObject6).writeInt(localObject4.length);
            ((DataOutputStream)localObject6).write((byte[])localObject2);
            ((DataOutputStream)localObject6).write((byte[])localObject4);
            ((DataOutputStream)localObject6).write(41);
            ((DataOutputStream)localObject6).flush();
            if (localObject3 == null)
            {
              localObject2 = null;
              if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
                break;
              }
              if (!paramBoolean) {
                break label567;
              }
              a(null, -1, null, null);
              return;
              localObject2 = ((axqp)localObject3).b();
              continue;
              if (paramBoolean)
              {
                a(null, -1, null, null);
                return;
              }
              a(paramIntent, paramPacket);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("NearbyAlumniServlet", 2, localException.getMessage());
              }
              a(paramIntent, -10, null, null);
              continue;
              str = ((axqp)localObject3).a();
            }
            a(paramIntent, paramPacket);
            return;
          }
        }
        String str = str + "cgi-bin/httpconn";
        localObject3 = ((ByteArrayOutputStream)localObject5).toByteArray();
        paramPacket = new HttpNetReq();
        paramPacket.mSendData = ((byte[])localObject3);
        paramPacket.mCallback = new axnw(this, paramIntent, (byte[])localObject1);
        paramPacket.mReqUrl = str;
        paramPacket.mHttpMethod = 1;
        paramPacket.mFileType = 131080;
        paramPacket.mReqProperties.put("Accept-Encoding", "identity");
        paramPacket.mContinuErrorLimit = 2;
        paramPacket.mExcuteTimeLimit = 15000L;
        paramIntent = getAppRuntime();
      } while (!(paramIntent instanceof AppInterface));
      paramIntent = (AppInterface)paramIntent;
      localObject1 = paramIntent.getNetEngine(0);
      ((INetEngine)localObject1).sendReq(paramPacket);
    } while (!axql.b());
    axql.a("NearbyAlumniServlet", new Object[] { "getBigData", localObject1, paramIntent });
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (str2 == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      localStringBuilder = new StringBuilder().append("resp:").append(str2).append(" is ");
      if (!bool) {
        break label98;
      }
    }
    label98:
    for (String str1 = "";; str1 = "not")
    {
      QLog.i("NearbyAlumniServlet", 2, str1 + " success");
      if (!str2.equals("HttpConn.0x6ff_501")) {
        break;
      }
      a(paramIntent, paramFromServiceMsg);
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("param_cmd", 0) == 1714)) {
      a(paramIntent, paramPacket, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axnv
 * JD-Core Version:    0.7.0.1
 */