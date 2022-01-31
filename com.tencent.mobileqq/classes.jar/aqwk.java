import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.bigbrother.ServerApi.ErrorInfo;
import com.tencent.mobileqq.bigbrother.ServerApi.RspDownloadCheckRecmd;
import com.tencent.mobileqq.bigbrother.ServerApi.RspJumpCheckRecmd;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.CheckShareExtensionRsp;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.RspBody;
import tencent.im.oidb.jump_url_check.jump_url_check.RspJumpUrlCheckRecmd;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aqwk
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = 2;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("CheckForwardServlet", 2, "onReceive with code: " + paramFromServiceMsg.getResultCode());
    }
    Object localObject1 = paramIntent.getStringExtra("CMD");
    if ("OidbSvc.0xc78_1".equals(localObject1)) {
      i = 1;
    }
    for (;;)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("ext_info", paramIntent.getStringExtra("ext_info"));
      ((Bundle)localObject1).putInt("req_id", paramIntent.getIntExtra("req_id", 0));
      bool1 = paramFromServiceMsg.isSuccess();
      if (!bool1) {
        break label637;
      }
      try
      {
        localObject2 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject2).getInt() - 4];
        ((ByteBuffer)localObject2).get(paramFromServiceMsg);
        switch (i)
        {
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        for (;;)
        {
          Object localObject2;
          label164:
          QLog.e("CheckForwardServlet", 1, paramFromServiceMsg, new Object[0]);
          bool1 = bool2;
        }
      }
      notifyObserver(paramIntent, i, bool1, (Bundle)localObject1, aqwj.class);
      return;
      if (!"QQApkSvc.check_jump_url".equals(localObject1)) {
        if ("QQApkSvc.check_download_apk".equals(localObject1))
        {
          i = 3;
        }
        else
        {
          if (!"QQApkSvc.check_jump_apk".equals(localObject1)) {
            break label640;
          }
          i = 4;
        }
      }
    }
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom(paramFromServiceMsg);
    if (((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get() == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1)
      {
        paramFromServiceMsg = new oidb_cmd0xc78.RspBody();
        paramFromServiceMsg.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg = (oidb_cmd0xc78.CheckShareExtensionRsp)paramFromServiceMsg.check_share_extension_rsp.get();
        if (QLog.isColorLevel()) {
          QLog.i("CheckForwardServlet", 2, "onreceive result: " + paramFromServiceMsg.result.get() + ", jump: " + paramFromServiceMsg.jump_result.get());
        }
        ((Bundle)localObject1).putInt("result", paramFromServiceMsg.result.get());
        ((Bundle)localObject1).putInt("jump_result", paramFromServiceMsg.jump_result.get());
        ((Bundle)localObject1).putString("jump_url", paramFromServiceMsg.jump_url.get());
        break label645;
        localObject2 = new jump_url_check.RspJumpUrlCheckRecmd();
        ((jump_url_check.RspJumpUrlCheckRecmd)localObject2).mergeFrom(paramFromServiceMsg);
        ((Bundle)localObject1).putInt("err_code", ((jump_url_check.RspJumpUrlCheckRecmd)localObject2).err_code.get());
        ((Bundle)localObject1).putString("err_msg", ((jump_url_check.RspJumpUrlCheckRecmd)localObject2).err_msg.get());
        ((Bundle)localObject1).putBoolean("can_jump", ((jump_url_check.RspJumpUrlCheckRecmd)localObject2).can_jump.get());
        break label164;
        localObject2 = new ServerApi.RspDownloadCheckRecmd();
        ((ServerApi.RspDownloadCheckRecmd)localObject2).mergeFrom(paramFromServiceMsg);
        ((Bundle)localObject1).putBoolean("allow_download", ((ServerApi.RspDownloadCheckRecmd)localObject2).check_pass.get());
        paramFromServiceMsg = (ServerApi.ErrorInfo)((ServerApi.RspDownloadCheckRecmd)localObject2).err_info.get();
        if (paramFromServiceMsg == null) {
          break label164;
        }
        ((Bundle)localObject1).putInt("err_code", paramFromServiceMsg.err_code.get());
        ((Bundle)localObject1).putString("err_msg", paramFromServiceMsg.err_msg.get());
        ((Bundle)localObject1).putString("jump_url", paramFromServiceMsg.jump_url.get());
        break label164;
        localObject2 = new ServerApi.RspJumpCheckRecmd();
        ((ServerApi.RspJumpCheckRecmd)localObject2).mergeFrom(paramFromServiceMsg);
        ((Bundle)localObject1).putInt("jump", ((ServerApi.RspJumpCheckRecmd)localObject2).jump_method.get());
        paramFromServiceMsg = (ServerApi.ErrorInfo)((ServerApi.RspJumpCheckRecmd)localObject2).err_info.get();
        if (paramFromServiceMsg == null) {
          break label164;
        }
        ((Bundle)localObject1).putInt("err_code", paramFromServiceMsg.err_code.get());
        ((Bundle)localObject1).putString("err_msg", paramFromServiceMsg.err_msg.get());
        break label164;
        label637:
        break label164;
        label640:
        i = 0;
        break;
      }
      label645:
      break label164;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getStringExtra("CMD");
    paramPacket.setSSOCommand(str);
    if (str.equals("QQApkSvc.check_jump_url")) {
      paramPacket.setTimeout(10000L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CheckForwardServlet", 2, "onSend with cmd: " + str);
      }
      paramPacket.putSendData(bblm.a(paramIntent.getByteArrayExtra("RequestBytes")));
      return;
      if (str.equals("QQApkSvc.check_download_apk")) {
        paramPacket.setTimeout(((amax)ampm.a().a(416)).a);
      } else if (str.equals("QQApkSvc.check_jump_apk")) {
        paramPacket.setTimeout(((amax)ampm.a().a(416)).b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqwk
 * JD-Core Version:    0.7.0.1
 */