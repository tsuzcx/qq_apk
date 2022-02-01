import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bczv
{
  private static bczv jdField_a_of_type_Bczv;
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public static bczv a()
  {
    if (jdField_a_of_type_Bczv == null) {
      jdField_a_of_type_Bczv = new bczv();
    }
    return jdField_a_of_type_Bczv;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
  
  public static boolean b()
  {
    boolean bool1 = QmcfManager.getInstance().hasQmcfEntrance(2);
    boolean bool2 = bool1;
    int i;
    if (bool1)
    {
      i = bdcu.a();
      if (i <= 0) {
        break label77;
      }
    }
    label77:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1)
      {
        QmcfManager.getInstance().setQmcfMobileNotSupport(bdcu.jdField_a_of_type_JavaLangString);
        QLog.d("DanceGameVideoManager", 1, String.format("isDanceGameSupport supportFrameType[%d], gpuinfo[%s], model[%s]", new Object[] { Integer.valueOf(i), bdcu.jdField_a_of_type_JavaLangString, Build.MODEL }));
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getRuntime().getApplication().getSharedPreferences("danceConfig", 4).edit();
    localEditor.putInt(paramString + "_max_score", paramInt);
    localEditor.commit();
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("DanceGameVideoManager", 2, "updateDanceMaxScore maxScore:" + this.jdField_a_of_type_Int + " ,new:" + paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    try
    {
      if ((!paramFromServiceMsg.isSuccess()) || (paramArrayOfByte == null)) {
        break label290;
      }
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom(paramArrayOfByte);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label248;
      }
      j = paramFromServiceMsg.uint32_result.get();
      if (j != 0) {
        break label195;
      }
      paramArrayOfByte = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = new oidb_0x5eb.RspBody();
      paramFromServiceMsg.mergeFrom(paramArrayOfByte.array());
      k = paramFromServiceMsg.rpt_msg_uin_data.size();
      i = 0;
    }
    catch (Exception paramFromServiceMsg)
    {
      for (;;)
      {
        int j;
        int k;
        int i;
        String str;
        int m;
        label195:
        label248:
        this.jdField_a_of_type_JavaLangString = paramFromServiceMsg.getMessage();
        QLog.e("DanceGameVideoManager", 1, "handleGetDanceMaxScore exception: ", paramFromServiceMsg);
        continue;
        paramFromServiceMsg = "no pkg result";
        continue;
        label290:
        this.jdField_a_of_type_JavaLangString = ("msg fail " + paramFromServiceMsg.getBusinessFailCode());
        continue;
        i += 1;
      }
    }
    if (i < k)
    {
      paramArrayOfByte = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(i);
      str = String.valueOf(paramArrayOfByte.uint64_uin.get());
      if (paramArrayOfByte.uint32_dance_max_score.has())
      {
        m = paramArrayOfByte.uint32_dance_max_score.get();
        a(m, str);
        if (QLog.isColorLevel()) {
          QLog.d("DanceGameVideoManager", 2, new Object[] { "handleGetDanceMaxScore uin:", str, " maxScore:", Integer.valueOf(m) });
        }
      }
    }
    else
    {
      for (this.jdField_a_of_type_JavaLangString = ("error ret " + j);; this.jdField_a_of_type_JavaLangString = paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DanceGameVideoManager", 2, new Object[] { "handleGetDanceMaxScore result: ", this.jdField_a_of_type_JavaLangString });
        }
        return;
        if (paramFromServiceMsg != null) {
          break;
        }
        paramFromServiceMsg = "no pkg";
      }
    }
  }
  
  public void a(Packet paramPacket, String paramString)
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_dance_max_score.set(1);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(1515);
    paramString.uint32_service_type.set(203);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    paramString = paramString.toByteArray();
    localObject = ByteBuffer.allocate(paramString.length + 4);
    ((ByteBuffer)localObject).putInt(paramString.length + 4);
    ((ByteBuffer)localObject).put(paramString);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
    paramPacket.setSSOCommand("OidbSvc.0x5eb_203");
  }
  
  public void a(Packet paramPacket, String paramString, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(13);
    long l = Long.parseLong(paramString);
    this.jdField_b_of_type_Int = paramInt;
    localByteBuffer.putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)27245).putShort((short)2).putShort((short)paramInt);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(1279);
    paramString.uint32_service_type.set(9);
    paramString.uint32_result.set(0);
    paramString.str_client_version.set(AppSetting.f());
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString = paramString.toByteArray();
    localByteBuffer = ByteBuffer.allocate(paramString.length + 4);
    localByteBuffer.putInt(paramString.length + 4);
    localByteBuffer.put(paramString);
    paramPacket.putSendData(localByteBuffer.array());
    paramPacket.setSSOCommand("OidbSvc.0x4ff_203");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        if ((!paramFromServiceMsg.isSuccess()) || (paramArrayOfByte == null)) {
          continue;
        }
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom(paramArrayOfByte);
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
          continue;
        }
        int i = paramFromServiceMsg.uint32_result.get();
        if (i == 0)
        {
          long l = bhbx.a(ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt());
          if (this.jdField_b_of_type_Int > this.jdField_a_of_type_Int)
          {
            a(this.jdField_b_of_type_Int, String.valueOf(Long.valueOf(l)));
            this.jdField_b_of_type_Boolean = true;
          }
        }
        this.jdField_a_of_type_JavaLangString = ("error ret " + i);
      }
      catch (Exception paramFromServiceMsg)
      {
        this.jdField_a_of_type_JavaLangString = paramFromServiceMsg.getMessage();
        QLog.e("DanceGameVideoManager", 1, "handleSetDanceMaxScore exception: ", paramFromServiceMsg);
        continue;
        paramFromServiceMsg = "no pkg result";
        continue;
        this.jdField_a_of_type_JavaLangString = ("msg fail " + paramFromServiceMsg.getBusinessFailCode());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DanceGameVideoManager", 2, new Object[] { "handleSetDanceMaxScore result: ", this.jdField_a_of_type_JavaLangString });
      }
      return;
      if (paramFromServiceMsg != null) {
        continue;
      }
      paramFromServiceMsg = "no pkg";
      this.jdField_a_of_type_JavaLangString = paramFromServiceMsg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczv
 * JD-Core Version:    0.7.0.1
 */