import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xa79.oidb_0xa79.ReqBody;
import tencent.im.oidb.cmd0xa79.oidb_0xa79.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bddg
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {}
    byte[] arrayOfByte;
    int i;
    for (;;)
    {
      return;
      arrayOfByte = null;
      if (paramFromServiceMsg.isSuccess())
      {
        arrayOfByte = bhjl.b(paramFromServiceMsg.getWupBuffer());
        i = paramIntent.getIntExtra("action", 0);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoServlet", 2, new Object[] { "ShortVideoServlet, onReceive action: ", Integer.valueOf(i) });
        }
        switch (i)
        {
        default: 
          return;
        case 1: 
          try
          {
            if (paramFromServiceMsg.isSuccess())
            {
              paramIntent = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom(arrayOfByte);
              if ((paramIntent == null) || (!paramIntent.uint32_result.has())) {
                break label462;
              }
              i = paramIntent.uint32_result.get();
              if (i == 0)
              {
                paramIntent = ByteBuffer.wrap(paramIntent.bytes_bodybuffer.get().toByteArray());
                paramFromServiceMsg = new oidb_0xa79.RspBody();
                paramFromServiceMsg.mergeFrom(paramIntent.array());
                i = paramFromServiceMsg.uint32_real_state.get();
                int j = paramFromServiceMsg.uint32_bind_num.get();
                int k = paramFromServiceMsg.uint32_id_level.get();
                int m = paramFromServiceMsg.enum_upload_cre.get();
                if (QLog.isColorLevel()) {
                  QLog.d("ShortVideoServlet", 2, new Object[] { "onReceive, realname check result:", Integer.valueOf(i), " bindNum:", Integer.valueOf(j), " idLevel:", Integer.valueOf(k), " uploadCreStat:", Integer.valueOf(m) });
                }
                paramIntent = BaseApplicationImpl.sApplication.getRuntime();
                if (!(paramIntent instanceof QQAppInterface)) {
                  continue;
                }
                ((apal)((QQAppInterface)paramIntent).getBusinessHandler(BusinessHandlerFactory.SHORT_VIDEO_HANDLER)).notifyUI(1, true, new Object[] { Integer.valueOf(i) });
                return;
              }
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            paramIntent = paramFromServiceMsg.getMessage();
            QLog.e("ShortVideoServlet", 1, "onReceive, ", paramFromServiceMsg);
          }
        }
      }
    }
    for (;;)
    {
      QLog.d("ShortVideoServlet", 1, new Object[] { "onReceive, realname check fail, ", paramIntent });
      return;
      QLog.e("ShortVideoServlet", 1, new Object[] { "ShortVideoServlet, onReceive failCode:", Integer.valueOf(paramFromServiceMsg.getBusinessFailCode()), " failMsg: %s", paramFromServiceMsg.getBusinessFailMsg() });
      break;
      paramIntent = "error ret " + i;
      continue;
      paramIntent = "msg fail " + paramFromServiceMsg.getBusinessFailCode();
      continue;
      bczv.a().a(paramFromServiceMsg, arrayOfByte);
      return;
      bczv.a().b(paramFromServiceMsg, arrayOfByte);
      return;
      label462:
      if (paramIntent == null) {
        paramIntent = "no pkg";
      } else {
        paramIntent = "no pkg result";
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    String str = ((AppRuntime)localObject).getAccount();
    if (str == null) {
      QLog.d("ShortVideoServlet", 1, "sendRealNameCheckReq, uin is null");
    }
    int i;
    do
    {
      return;
      i = paramIntent.getIntExtra("action", 0);
      QLog.d("ShortVideoServlet", 1, new Object[] { "ShortVideoServlet, onSend action: ", Integer.valueOf(i) });
      switch (i)
      {
      default: 
        return;
      case 1: 
        localObject = ((TicketManager)((AppRuntime)localObject).getManager(2)).getSkey(str);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          if (localObject == null) {}
          for (boolean bool = true;; bool = false)
          {
            QLog.d("ShortVideoServlet", 1, new Object[] { "sendRealNameCheckReq skey error, skeyIsNull", Boolean.valueOf(bool) });
            return;
          }
        }
        paramIntent = new oidb_0xa79.ReqBody();
        paramIntent.bytes_skey.set(ByteStringMicro.copyFromUtf8((String)localObject));
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2681);
        ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.f());
        ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
        paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
        localObject = ByteBuffer.allocate(paramIntent.length + 4);
        ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
        ((ByteBuffer)localObject).put(paramIntent);
        paramPacket.putSendData(((ByteBuffer)localObject).array());
        paramPacket.setSSOCommand("OidbSvc.0xa79");
        return;
      case 2: 
        bczv.a().a(paramPacket, str);
        return;
      }
      i = paramIntent.getIntExtra("key_dance_score", 0);
    } while (i <= 0);
    bczv.a().a(paramPacket, str, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddg
 * JD-Core Version:    0.7.0.1
 */