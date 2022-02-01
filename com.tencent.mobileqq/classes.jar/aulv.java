import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aulv
  extends BusinessHandler
{
  public aulv(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "handleReqSetSwitch ");
    }
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          int i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("FlashChat", 2, "handleReqSetSwitch ret=" + i);
          }
          if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            i = paramFromServiceMsg.length;
            boolean bool2 = true;
            bool1 = bool2;
            if (4 > i) {
              break label215;
            }
            paramFromServiceMsg = String.valueOf(PkgTools.getLongData(paramFromServiceMsg, 0));
            if (paramFromServiceMsg != null)
            {
              bool1 = bool2;
              if (paramFromServiceMsg.equals(this.app.getAccount())) {
                break label215;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.w("FlashChat", 2, "handleReqSetSwitch uin error");
            }
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = paramObject;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    label215:
    paramToServiceMsg.extraData.getByte("lightalk_switch", (byte)0).byteValue();
    if (bool1) {}
    notifyUI(2, bool1, null);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "requestGetSwitch begin...");
    }
    try
    {
      long l = Long.parseLong(this.app.getAccount());
      Object localObject = new byte[9];
      PkgTools.DWord2Byte((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.Word2Byte((byte[])localObject, 5, (short)1);
      PkgTools.DWordTo2Bytes((byte[])localObject, 7, 40352);
      localObject = makeOIDBPkg("OidbSvc.0x480_9", 1152, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putBoolean("FlashChatHanlder", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("FlashChat", 2, "send_oidb_0x480_9 error", localException);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      int i;
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        paramFromServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramToServiceMsg.uint32_result.has())
        {
          i = paramToServiceMsg.uint32_result.get();
          if (i == 0)
          {
            long l = paramFromServiceMsg.getInt();
            paramFromServiceMsg.get();
            int j = paramFromServiceMsg.getShort();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("FlashChat", 2, "handleReqGetSwitch, request success, tlvCount = " + j + " uin:" + Long.valueOf(l));
            continue;
            if ((!paramFromServiceMsg.hasRemaining()) || (i >= j)) {
              break label356;
            }
            int k = paramFromServiceMsg.getShort();
            int m = paramFromServiceMsg.getShort();
            if (QLog.isColorLevel()) {
              QLog.d("FlashChat", 2, "handleReqGetSwitch, TLV type: " + k + ",legnth: " + m);
            }
            if (k == -25184)
            {
              i = paramFromServiceMsg.getShort();
              if (!QLog.isColorLevel()) {
                break label356;
              }
              QLog.i("FlashChat", 2, "handleReqGetSwitch switchValue" + i);
              return;
            }
            if (!QLog.isColorLevel()) {
              break label357;
            }
            QLog.i("FlashChat", 2, "handleReqGetSwitch" + k);
            break label357;
          }
          if (!QLog.isColorLevel()) {
            break label356;
          }
          QLog.d("FlashChat", 2, "handleReqGetSwitch" + i);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("FlashChat", 2, "handleReqGetSwitch exception: " + paramToServiceMsg.getMessage());
          return;
          i = -1;
          continue;
          i = 0;
          continue;
        }
      }
      label356:
      return;
      label357:
      i += 1;
    }
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x4ff_9");
      this.allowCmdSet.add("OidbSvc.0x480_9");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return aulu.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if (!"OidbSvc.0x4ff_9".equals(str)) {
          break;
        }
      } while (!paramToServiceMsg.extraData.getBoolean("FlashChatHanlder", false));
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    } while ((!"OidbSvc.0x480_9".equals(str)) || (!paramToServiceMsg.extraData.getBoolean("FlashChatHanlder", false)));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aulv
 * JD-Core Version:    0.7.0.1
 */