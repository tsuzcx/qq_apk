import OnlinePushPack.MsgInfo;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pushdialog.PushDialogHandler.1;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122.MsgBody;

public class audy
{
  private static volatile audy jdField_a_of_type_Audy;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private atmp jdField_a_of_type_Atmp;
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public static audy a()
  {
    if (jdField_a_of_type_Audy == null) {}
    try
    {
      if (jdField_a_of_type_Audy == null) {
        jdField_a_of_type_Audy = new audy();
      }
      return jdField_a_of_type_Audy;
    }
    finally {}
  }
  
  public void a(submsgtype0x122.MsgBody paramMsgBody, MsgInfo paramMsgInfo, QQAppInterface paramQQAppInterface)
  {
    if (paramMsgBody.uint64_busi_type.has()) {
      paramMsgBody.uint64_busi_type.get();
    }
    if (paramMsgBody.uint64_busi_id.has()) {
      paramMsgBody.uint64_busi_id.get();
    }
    long l;
    if (paramMsgBody.uint32_ctrl_flag.has()) {
      l = paramMsgBody.uint32_ctrl_flag.get();
    }
    if (paramMsgBody.uint32_c2c_type.has()) {
      l = paramMsgBody.uint32_c2c_type.get();
    }
    if (paramMsgBody.uint32_service_type.has()) {
      l = paramMsgBody.uint32_service_type.get();
    }
    byte[] arrayOfByte;
    if (paramMsgBody.bytes_content.has())
    {
      arrayOfByte = paramMsgBody.bytes_content.get().toByteArray();
      if (paramMsgBody.uint64_templ_id.has()) {
        paramMsgBody.uint64_templ_id.get();
      }
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
        break label237;
      }
    }
    for (;;)
    {
      try
      {
        new String(arrayOfByte, "utf-8");
        l = paramMsgInfo.getURealMsgTime();
        paramMsgBody = new PushDialogTemplate(paramMsgBody, paramMsgInfo.lFromUin, l * 1000L);
        if (!a(paramQQAppInterface, paramMsgInfo)) {
          break label254;
        }
        paramMsgInfo = acij.a();
        if (paramMsgInfo == null) {
          break label254;
        }
        a().post(new PushDialogHandler.1(this, paramMsgInfo, paramMsgBody));
        return;
        arrayOfByte = null;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      label237:
      if (QLog.isColorLevel()) {
        QLog.e("PushDialogHandler", 2, "handleC2COnlinePushMsgGrayTipResp fail content is null");
      }
    }
    label254:
    this.jdField_a_of_type_Atmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    audw.a().b(this.jdField_a_of_type_Atmp, paramMsgBody);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.a(0).e(String.valueOf(paramMsgInfo.lFromUin), 0);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!paramQQAppInterface.isEmpty()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     audy
 * JD-Core Version:    0.7.0.1
 */