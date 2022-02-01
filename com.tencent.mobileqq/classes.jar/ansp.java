import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc1.submsgtype0xc1.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xcf.submsgtype0xcf.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdb.submsgtype0xdb.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe9.SubMsgType0xe9.MsgBody;

public class ansp
  implements Handler.Callback
{
  static ArrayList<ansy> jdField_a_of_type_JavaUtilArrayList;
  static ArrayList<String> b;
  Handler jdField_a_of_type_AndroidOsHandler;
  AVNotifyCenter jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  Vector<byte[]> jdField_a_of_type_JavaUtilVector = new Vector();
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = new byte['ª'];
  
  static
  {
    try
    {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg create successful!");
      }
      try
      {
        label24:
        b = new ArrayList();
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "sCacheMsgList create successful!");
        }
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label24;
    }
  }
  
  public ansp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  public static anta a(byte[] paramArrayOfByte)
  {
    anta localanta = new anta();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 40)) {
      return localanta;
    }
    int i = paramArrayOfByte.length;
    byte[] arrayOfByte1 = new byte[2];
    byte[] arrayOfByte2 = new byte[4];
    byte[] arrayOfByte3 = new byte[8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 2);
    localanta.jdField_a_of_type_Int = lcr.a(lcr.a(arrayOfByte1, 2));
    System.arraycopy(paramArrayOfByte, 2, arrayOfByte3, 0, 8);
    localanta.jdField_a_of_type_Long = lcr.b(arrayOfByte3, 8);
    localanta.jdField_b_of_type_Int = lcr.a(paramArrayOfByte[10]);
    int j = localanta.jdField_b_of_type_Int + 11;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localanta.jdField_b_of_type_Long = lcr.a(lcr.a(arrayOfByte2, 4));
    j += 4;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localanta.jdField_c_of_type_Long = lcr.a(lcr.a(arrayOfByte2, 4));
    j += 4;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte3, 0, 8);
    localanta.jdField_d_of_type_Long = lcr.b(arrayOfByte3, 8);
    j += 8;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localanta.jdField_c_of_type_Int = lcr.a(arrayOfByte2, 4);
    j += 4;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
    localanta.jdField_d_of_type_Int = lcr.a(lcr.a(arrayOfByte1, 2));
    j += 2;
    localanta.jdField_e_of_type_Int = lcr.a(paramArrayOfByte[j]);
    j += 1;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localanta.jdField_e_of_type_Long = lcr.a(arrayOfByte2, 4);
    j += localanta.jdField_e_of_type_Int;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
    localanta.jdField_f_of_type_Int = lcr.a(lcr.a(arrayOfByte1, 2));
    j = j + 2 + localanta.jdField_f_of_type_Int * 8;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localanta.jdField_f_of_type_Long = lcr.a(lcr.a(arrayOfByte2, 4));
    j += 4;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
    localanta.jdField_g_of_type_Int = lcr.a(lcr.a(arrayOfByte1, 2));
    j += 2;
    if ((localanta.jdField_g_of_type_Int >= 16) && (localanta.jdField_g_of_type_Int + j <= i))
    {
      System.arraycopy(paramArrayOfByte, j + 9, arrayOfByte1, 0, 2);
      i = lcr.a(lcr.a(arrayOfByte1, 2)) + 11;
      if (localanta.jdField_d_of_type_Int != 3) {
        break label414;
      }
    }
    for (;;)
    {
      i = localanta.jdField_g_of_type_Int;
      return localanta;
      label414:
      localanta.h = lcr.a(paramArrayOfByte[(j + i)]);
      i += 1;
      if (i + 4 <= localanta.jdField_g_of_type_Int)
      {
        System.arraycopy(paramArrayOfByte, j + i, arrayOfByte2, 0, 4);
        localanta.jdField_g_of_type_Long = lcr.a(lcr.a(arrayOfByte2, 4));
      }
    }
  }
  
  private void j(byte[] paramArrayOfByte)
  {
    int i = 0;
    Object localObject = new byte[1];
    System.arraycopy(paramArrayOfByte, 11, localObject, 0, 1);
    if (QLog.isColorLevel()) {
      QLog.w("QQGAudioMsgHandler", 1, "onRecvRoomDestroy, cAuthType[" + localObject[0] + "]");
    }
    if (localObject[0] != 3) {
      return;
    }
    localObject = BaseApplication.getContext();
    long l = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.b();
    int j = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a();
    if (l > 0L) {
      i = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.b(l);
    }
    if ((j == 1) && (i == 2))
    {
      new bldk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(new answ(this, paramArrayOfByte));
      return;
    }
    new lxd((Context)localObject).a(new ansx(this, paramArrayOfByte));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilVector != null) {
      this.jdField_a_of_type_JavaUtilVector.clear();
    }
    if ((jdField_a_of_type_JavaUtilArrayList == null) || (jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is empty!");
      }
    }
    do
    {
      return;
      jdField_a_of_type_JavaUtilArrayList.clear();
    } while (!QLog.isColorLevel());
    QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is clear in clearOnLineQueue");
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoLevelUpgrade");
      localIntent.putExtra("type", paramInt1);
      localIntent.putExtra("fromUin", paramLong1);
      localIntent.putExtra("toUin", paramLong2);
      localIntent.putExtra("enable", paramInt2);
      localIntent.putExtra("level", paramInt3);
      localIntent.putExtra("seq", paramLong3);
      localIntent.putExtra("groupId", paramLong4);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoGift");
      localIntent.putExtra("type", paramInt1);
      localIntent.putExtra("fromUin", paramLong1);
      localIntent.putExtra("toUin", paramLong2);
      localIntent.putExtra("count", paramInt2);
      localIntent.putExtra("seq", paramLong3);
      localIntent.putExtra("groupId", paramLong4);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long[] paramArrayOfLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    QLog.w("QQGAudioMsgHandler", 1, "onRecvGroupVideoMemberNumber, relationType[" + paramInt1 + "], relationId[" + paramString + "], memberNum[" + paramInt2 + "], avtype[" + paramInt3 + "], gameId[" + paramInt5 + "], liveExtraMode[" + paramInt6 + "],memberList[" + Arrays.toString(paramArrayOfLong) + "]");
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.e("QQGAudioMsgHandler", 1, "onRecvGroupVideoMemberNumber", localException);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt3);
      i = paramInt3;
      if (paramInt3 != 14) {
        break label167;
      }
      i = 2;
      paramInt3 = 21;
      if (paramInt2 > 0) {
        break label179;
      }
      paramInt3 = 23;
      lmm locallmm = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
      if ((locallmm == null) || (locallmm.jdField_a_of_type_Int <= 0) || (paramInt2 != 0)) {
        break label228;
      }
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(5, 1, l1, null, locallmm.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1, i, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4, l1, i, paramInt4, paramInt5, paramInt6, paramInt3, paramInt2);
      if (paramInt2 != 0) {
        break label378;
      }
    }
    if (l1 == 0L) {
      return;
    }
    int i;
    label167:
    label179:
    label228:
    a(l1, i);
    this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, l1, 0L);
    label292:
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString) != 14)
    {
      paramString = new Intent();
      paramString.setAction("tencent.video.q2v.membersChange");
      paramString.putExtra("relationType", 1);
      paramString.putExtra("avtype", i);
      paramString.putExtra("relationId", l1);
      if (paramInt2 != 0) {
        break label468;
      }
      paramString.putExtra("Exit", true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramString);
      return;
      label378:
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(6, 1, l1, paramArrayOfLong, paramInt2);
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.b(10, l1, i);
      if ((i == 2) && (paramInt1 == 1) && (((bfus)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164)).a(paramString) == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l1, true);
      }
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, l1, 0L);
      break label292;
      break;
      label468:
      paramString.putExtra("Exit", false);
    }
  }
  
  void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "showDevNotSurportMsg-->MsgType" + paramInt);
    }
    if (paramInt == 141)
    {
      paramInt = paramArrayOfByte[10];
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, (paramInt & 0xFF) + 34, arrayOfByte, 0, 4);
      l = lcr.a(arrayOfByte, 4);
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 18, false, String.valueOf(l), paramArrayOfByte, false, null, false, new Object[0]);
    }
    while (paramInt != 7) {
      return;
    }
    paramInt = (paramArrayOfByte[10] & 0xFF) + 19;
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, 8);
    lcr.b(arrayOfByte, 8);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, paramInt + 12, arrayOfByte, 0, 4);
    long l = lcr.a(arrayOfByte, 4);
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 18, false, String.valueOf(l), paramArrayOfByte, false, null, false, new Object[0]);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoRankListUpdate");
      localIntent.putExtra("groupId", paramLong);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioMsgHandler", 2, "onGroupChatRoomDestroy-->can not get mNotifycenter or mapp");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(1, paramLong) > 0L)
      {
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(3, 1, paramLong, null, 0L);
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 14, false, String.valueOf(paramLong), str, false, null, false, paramInt, new Object[0]);
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, paramLong, 0L);
      }
      while (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.b(paramLong, false);
        return;
        if (QLog.isColorLevel()) {
          QLog.w("QQGAudioMsgHandler", 2, "MultiRoomMemberNum is 0");
        }
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(23, 1, paramLong, 0L);
      }
    }
  }
  
  void a(long paramLong, int paramInt, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    lbc.d("QQGAudioMsgHandler", String.format("queryRoomMemberNum| discussId=%d, dataType= %d, wReserve=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Byte.valueOf(paramByte) }));
    byte[] arrayOfByte = new byte[33];
    arrayOfByte[0] = ((byte)0);
    arrayOfByte[1] = ((byte)48);
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[(i + 2)] = ((byte)(int)(l >> (7 - i) * 8 & 0xFF));
      i += 1;
    }
    arrayOfByte[10] = 0;
    arrayOfByte[11] = 0;
    arrayOfByte[12] = 0;
    arrayOfByte[13] = 0;
    arrayOfByte[14] = 0;
    arrayOfByte[15] = ((byte)paramInt);
    arrayOfByte[16] = 4;
    paramInt = 0;
    while (paramInt < 4)
    {
      arrayOfByte[(paramInt + 17)] = ((byte)(int)(paramLong >> (3 - paramInt) * 8 & 0xFF));
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < 8)
    {
      arrayOfByte[(paramInt + 21)] = ((byte)(int)(531L >> (7 - paramInt) * 8 & 0xFF));
      paramInt += 1;
    }
    arrayOfByte[29] = 0;
    arrayOfByte[30] = 0;
    arrayOfByte[31] = 0;
    arrayOfByte[32] = paramByte;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), bcdi.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)462);
    localNewIntent.putExtra("selfuin", l);
    localNewIntent.putExtra("toUin", paramLong);
    localNewIntent.putExtra("vMsg", arrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoMemRejectInvite");
      localIntent.putExtra("groupId", paramLong1);
      localIntent.putExtra("dealMemUin", paramLong2);
      localIntent.putExtra("invitedId", paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.KickOutVisitor");
      localIntent.putExtra("groupId", paramLong);
      localIntent.putExtra("isAllVisitor", paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GVideoMedalChange");
      localIntent.putExtra("jsonString", paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(submsgtype0xc1.MsgBody paramMsgBody)
  {
    Intent localIntent = new Intent("tencent.video.q2v.randomMultiOwnerOnlinePush").putExtra("group_id", paramMsgBody.uint64_groupid.get()).putExtra("member_num", paramMsgBody.uint32_member_num.get());
    if (TextUtils.isEmpty(paramMsgBody.string_data.get())) {}
    for (paramMsgBody = "";; paramMsgBody = paramMsgBody.string_data.get())
    {
      paramMsgBody = localIntent.putExtra("string_data", paramMsgBody);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramMsgBody);
      return;
    }
  }
  
  public void a(submsgtype0xcf.MsgBody paramMsgBody)
  {
    Intent localIntent = new Intent("tencent.video.q2v.random1V1OnlinePush").putExtra("rsptype", paramMsgBody.uint32_rsptype.get());
    if (TextUtils.isEmpty(paramMsgBody.string_rspbody.get())) {}
    for (paramMsgBody = "";; paramMsgBody = paramMsgBody.string_rspbody.get())
    {
      paramMsgBody = localIntent.putExtra("rspbody", paramMsgBody);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramMsgBody);
      return;
    }
  }
  
  public void a(submsgtype0xdb.MsgBody paramMsgBody)
  {
    Intent localIntent = new Intent("tencent.video.q2v.avreportOnlinePush").putExtra("rsptype", paramMsgBody.uint32_rsptype.get());
    if (TextUtils.isEmpty(paramMsgBody.string_rspbody.get())) {}
    for (paramMsgBody = "";; paramMsgBody = paramMsgBody.string_rspbody.get())
    {
      paramMsgBody = localIntent.putExtra("rspbody", paramMsgBody);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramMsgBody);
      return;
    }
  }
  
  public void a(SubMsgType0xe9.MsgBody paramMsgBody)
  {
    int i = paramMsgBody.uint32_business_type.get();
    Intent localIntent = new Intent();
    if (i == 3) {
      localIntent.setAction("tencent.peak.q2v.AudioTransPush");
    }
    for (;;)
    {
      localIntent.putExtra("rsptype", paramMsgBody.uint32_business_type.get());
      localIntent.putExtra("rspbody", paramMsgBody.bytes_business.get().toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
      return;
      localIntent.setAction("tencent.video.q2v.AudioTransPush");
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 2);
    int i = arrayOfByte[0];
    i = (arrayOfByte[1] & 0xFF) << 0 | (i & 0xFF) << 8;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, String.format("onRecvMultiVideoS2CData msgType=0x%X", new Object[] { Integer.valueOf(i) }));
    }
    if (!a()) {
      if ((141 == i) || (7 == i)) {
        a(i, paramArrayOfByte);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (i)
            {
            default: 
              return;
            }
          } while (this.jdField_a_of_type_ArrayOfByte == null);
          i = paramArrayOfByte.length;
        } while (i < 40);
        if (this.jdField_a_of_type_ArrayOfByte.length < i) {
          this.jdField_a_of_type_ArrayOfByte = new byte[i];
        }
        System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, i);
        g(paramArrayOfByte);
        return;
        a(paramArrayOfByte, 27);
        return;
      } while (this.jdField_a_of_type_ArrayOfByte == null);
      i = paramArrayOfByte.length;
    } while (i < 40);
    if (this.jdField_a_of_type_ArrayOfByte.length < i) {
      this.jdField_a_of_type_ArrayOfByte = new byte[i];
    }
    System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, i);
    f(this.jdField_a_of_type_ArrayOfByte);
    return;
    e(paramArrayOfByte);
    return;
    j(paramArrayOfByte);
  }
  
  void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, String.format("sendRoomInfoBroadcast, type[%s]", new Object[] { Integer.valueOf(paramInt) }));
    }
    Intent localIntent = new Intent("tencent.video.q2v.MultiVideo");
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localIntent.putExtra("type", paramInt);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("buffer", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
  }
  
  public void a(byte[] paramArrayOfByte, msg_comm.Msg paramMsg)
  {
    if (!a()) {}
    Object localObject;
    long l2;
    int j;
    long l3;
    long l4;
    String str;
    do
    {
      return;
      localObject = new byte[2];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, 2);
      i = lcr.a(lcr.a((byte[])localObject, 2));
      if (i != 141) {
        break label625;
      }
      anta localanta = a(paramArrayOfByte);
      i = localanta.jdField_d_of_type_Int;
      l1 = localanta.jdField_d_of_type_Long;
      l2 = localanta.jdField_e_of_type_Long;
      j = localanta.jdField_c_of_type_Int;
      l3 = localanta.jdField_f_of_type_Long;
      l4 = localanta.jdField_g_of_type_Long;
      str = Long.toString(l2);
      localObject = Long.toString(l1);
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "GAudioOfflineMsg relationShip[" + i + "], groupUin[" + str + "], inviteUin[" + l1 + "], subCmd0x8DMsg[" + localanta + "]");
      }
      if (1 == i)
      {
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 13, false, str, (String)localObject, false, null, false, j, new Object[] { Long.valueOf(l3), Long.valueOf(l4) });
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(l2, 1, 10, true);
        return;
      }
      if (3 != i) {
        break label470;
      }
      paramArrayOfByte = str;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject)) {
        paramArrayOfByte = (byte[])localObject;
      }
      if (!TextUtils.isEmpty(paramArrayOfByte)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQGAudioMsgHandler", 2, "GAudioOfflineMsg friendUin is empty!");
    return;
    long l1 = 0L;
    if (paramMsg != null) {
      l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    }
    if ((l1 > 0L) && (l1 - NetConnInfoCenter.getServerTime() - 60000L > 0L)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, 6, true, paramArrayOfByte, (String)localObject, false, null, false, new Object[] { paramMsg });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "GAudioOfflineMsg double meeting friendUin is:" + paramArrayOfByte);
      }
      l2 = l1;
      if (l1 == 0L) {
        l2 = bbyp.a();
      }
      if ((jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_AndroidOsHandler == null)) {
        break;
      }
      jdField_a_of_type_JavaUtilArrayList.add(new ansy(paramMsg, Long.valueOf(paramArrayOfByte).longValue(), l2));
      a(Long.valueOf(paramArrayOfByte).longValue(), 4, (byte)8);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10000L);
      return;
      label470:
      paramMsg = (azwe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject))) {
        paramMsg.a(1, l2, (String)localObject);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(l2, 2, 0, true);
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 13, false, str, (String)localObject, false, null, false, new Object[] { Long.valueOf(l3), Long.valueOf(l4) });
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        h(paramArrayOfByte);
        return;
        if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, l2) <= 0L) {
          paramMsg.a(str, (String)localObject);
        }
      }
      if (this.jdField_a_of_type_JavaUtilVector == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilVector.add(paramArrayOfByte);
      return;
      label625:
      if (i != 7) {
        break;
      }
      i = (paramArrayOfByte[10] & 0xFF) + 19;
      paramMsg = new byte[8];
      System.arraycopy(paramArrayOfByte, i, paramMsg, 0, 8);
      l1 = lcr.b(paramMsg, 8);
      i += 8;
      paramMsg = new byte[4];
      System.arraycopy(paramArrayOfByte, i, paramMsg, 0, 4);
      j = lcr.a(paramMsg, 4);
      paramMsg = new byte[4];
      System.arraycopy(paramArrayOfByte, i + 4, paramMsg, 0, 4);
      l2 = lcr.b(paramMsg, 4);
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 13, true, Long.toString(l2), Long.toString(l1), false, null, false, j, new Object[0]);
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.b(11, l2, j);
      ((bfus)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164)).a(l2);
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(l2, 1, 2, true);
      return;
    }
  }
  
  boolean a()
  {
    if (!lkw.c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "device not surpport Sharp audio");
      }
      return false;
    }
    return true;
  }
  
  void b(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    long l;
    do
    {
      return;
      l = this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, paramLong);
      QLog.w("QQGAudioMsgHandler", 1, "onMultiRoomDestroy, discussId[" + paramLong + "], roomMemberNum[" + l + "]");
    } while (l <= 0L);
    this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(4, 2, paramLong, null, 0L);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 2, paramLong, 0L);
    ((anks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(paramLong);
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 14, false, String.valueOf(paramLong), str, false, null, false, new Object[0]);
  }
  
  public void b(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoMemUntInvite");
      localIntent.putExtra("groupId", paramLong1);
      localIntent.putExtra("dealMemUin", paramLong2);
      localIntent.putExtra("invitedId", paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.ChangeVisitorSpeakMode");
      localIntent.putExtra("groupId", paramLong);
      localIntent.putExtra("visitorSpeakEnabled", paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    Object localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, 2);
    int i = localObject[0];
    if (((localObject[1] & 0xFF) << 0 | (i & 0xFF) << 8) == 49) {
      d(paramArrayOfByte);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = new Intent("tencent.video.q2v.MultiVideo");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      ((Intent)localObject).putExtra("type", 30);
      ((Intent)localObject).putExtra("buffer", paramArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (localObject != null) {
        Long.valueOf((String)localObject).longValue();
      }
    }
    Object localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, 8, localObject, 0, 2);
    int n = (localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->tlvNum=" + n);
    }
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[8];
    int i = 10;
    int k = 0;
    if (k < n)
    {
      System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
      i += 2;
      switch ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0)
      {
      default: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        for (;;)
        {
          k += 1;
          break;
          i += 2;
          System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 4);
          i += 4;
          lcr.b(arrayOfByte1, 4);
          continue;
          i += 6;
          continue;
          System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
          i = i + 2 + ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0);
          continue;
          i += 10;
          continue;
          i += 6;
          continue;
          i += 6;
          continue;
          i += 6;
          continue;
          System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
          i = i + 2 + ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0);
          continue;
          i += 6;
        }
      }
      System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
      int i1 = ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0) / 8;
      long[] arrayOfLong = new long[i1];
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->userNum=" + i1);
      }
      j = i + 2;
      int m = 0;
      for (;;)
      {
        i = j;
        if (m >= i1) {
          break;
        }
        System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 8);
        lcr.b(arrayOfByte2, 8);
        m += 1;
        j += 8;
      }
    }
    System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
    int j = (localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->wReverseLen=" + j);
    }
    localObject = new byte[j];
    System.arraycopy(paramArrayOfByte, i + 2, localObject, 0, j);
    long l1 = lcr.b((byte[])localObject, j);
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->uin=" + l1);
    }
    long l2;
    if (paramInt != 0)
    {
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->msgList size=" + jdField_a_of_type_JavaUtilArrayList.size());
        }
        paramInt = 0;
        while (paramInt < jdField_a_of_type_JavaUtilArrayList.size())
        {
          paramArrayOfByte = (ansy)jdField_a_of_type_JavaUtilArrayList.get(paramInt);
          if ((paramArrayOfByte != null) && (paramArrayOfByte.jdField_a_of_type_Long == l1) && (paramArrayOfByte.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)))
          {
            localObject = new byte[8];
            arrayOfByte1 = ((im_msg_body.MsgBody)paramArrayOfByte.jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_body.get()).msg_content.get().toByteArray();
            System.arraycopy(arrayOfByte1, (arrayOfByte1[10] & 0xFF) + 19, localObject, 0, 8);
            l2 = lcr.b((byte[])localObject, 8);
            VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, 6, true, Long.toString(l1), Long.toString(l2), false, null, false, new Object[] { paramArrayOfByte.jdField_a_of_type_MsfMsgcommMsg_comm$Msg });
          }
          paramInt += 1;
        }
      }
    }
    else {
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        break label856;
      }
    }
    label856:
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->msgList size=" + jdField_a_of_type_JavaUtilArrayList.size());
          }
          paramArrayOfByte = new ArrayList();
          paramInt = 0;
          while (paramInt < jdField_a_of_type_JavaUtilArrayList.size())
          {
            localObject = (ansy)jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            if ((localObject != null) && (((ansy)localObject).jdField_a_of_type_Long == l1) && (((ansy)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))) {
              paramArrayOfByte.add(localObject);
            }
            paramInt += 1;
          }
          Collections.sort(paramArrayOfByte, new ansz());
          paramInt = 0;
          while (paramInt < paramArrayOfByte.size() - 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->list =" + ((ansy)paramArrayOfByte.get(paramInt)).jdField_b_of_type_Long);
            }
            localObject = (ansy)paramArrayOfByte.get(paramInt);
            arrayOfByte1 = new byte[8];
            arrayOfByte2 = ((im_msg_body.MsgBody)((ansy)localObject).jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_body.get()).msg_content.get().toByteArray();
            System.arraycopy(arrayOfByte2, (arrayOfByte2[10] & 0xFF) + 19, arrayOfByte1, 0, 8);
            l2 = lcr.b(arrayOfByte1, 8);
            VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, 6, true, Long.toString(l1), Long.toString(l2), false, null, false, new Object[] { ((ansy)localObject).jdField_a_of_type_MsfMsgcommMsg_comm$Msg });
            paramInt += 1;
          }
        } while (paramArrayOfByte.size() <= 0);
        paramArrayOfByte = ((im_msg_body.MsgBody)((ansy)paramArrayOfByte.get(paramArrayOfByte.size() - 1)).jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_body.get()).msg_content.get().toByteArray();
      } while (this.jdField_a_of_type_ArrayOfByte == null);
      paramInt = paramArrayOfByte.length;
    } while (paramInt < 40);
    if (this.jdField_a_of_type_ArrayOfByte.length < paramInt) {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
    }
    System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramInt);
    f(this.jdField_a_of_type_ArrayOfByte);
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    lbc.d("QQGAudioMsgHandler", "onRecvAppTipMsgData.");
    if (!a()) {}
    byte[] arrayOfByte1;
    Object localObject3;
    byte[] arrayOfByte2;
    int i3;
    do
    {
      do
      {
        return;
        arrayOfByte1 = new byte[2];
        localObject3 = new byte[4];
        arrayOfByte2 = new byte[8];
      } while ((arrayOfByte1 == null) || (localObject3 == null) || (arrayOfByte2 == null));
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 2);
      i3 = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
    } while (i3 < 4);
    long l1 = 0L;
    int i = 0;
    int n = 0;
    int k = 0;
    int j = 2;
    Object localObject1 = null;
    label102:
    if (n < i3)
    {
      System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
      j += 2;
      switch ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0)
      {
      }
    }
    for (;;)
    {
      n += 1;
      break label102;
      j += 2;
      System.arraycopy(paramArrayOfByte, j, localObject3, 0, 4);
      l1 = lcr.b((byte[])localObject3, 4);
      j += 4;
      continue;
      j += 2;
      System.arraycopy(paramArrayOfByte, j, localObject3, 0, 4);
      i = lcr.a((byte[])localObject3, 4);
      if (i == 0)
      {
        b(l1);
        paramArrayOfByte = new Intent();
        paramArrayOfByte.setAction("tencent.video.q2v.membersChange");
        paramArrayOfByte.putExtra("relationType", 2);
        paramArrayOfByte.putExtra("relationId", l1);
        paramArrayOfByte.putExtra("Exit", true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramArrayOfByte);
        return;
        j += 6;
        continue;
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
        k = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
        if (k <= 0) {
          break;
        }
        int i2 = k / 8;
        Object localObject2 = new long[i2];
        int m = j + 2;
        int i1 = 0;
        for (;;)
        {
          k = i2;
          j = m;
          localObject1 = localObject2;
          if (i1 >= i2) {
            break;
          }
          System.arraycopy(paramArrayOfByte, m, arrayOfByte2, 0, 8);
          localObject2[i1] = lcr.b(arrayOfByte2, 8);
          i1 += 1;
          m += 8;
        }
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
        i1 = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "TLV-NUMBER = " + i1);
        }
        localObject2 = new int[k];
        localObject3 = new int[k];
        m = 0;
        j += 2;
        if (m < i1)
        {
          System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
          n = j + 2;
          j = arrayOfByte1[0];
          i3 = arrayOfByte1[1];
          System.arraycopy(paramArrayOfByte, n, arrayOfByte1, 0, 2);
          n += 2;
          i2 = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
          switch ((j & 0xFF) << 8 | (i3 & 0xFF) << 0)
          {
          default: 
            j = n + i2;
          }
          for (;;)
          {
            m += 1;
            break;
            j = n;
            if (i2 == k)
            {
              System.arraycopy(paramArrayOfByte, n, arrayOfByte1, 0, i2);
              j = 0;
              while (j < i2)
              {
                localObject2[j] = arrayOfByte1[j];
                j += 1;
              }
              j = n + i2;
              continue;
              j = n;
              if (i2 == k)
              {
                System.arraycopy(paramArrayOfByte, n, arrayOfByte1, 0, i2);
                j = 0;
                while (j < i2)
                {
                  localObject3[j] = arrayOfByte1[j];
                  j += 1;
                }
                j = n + i2;
              }
            }
          }
        }
        QLog.w("QQGAudioMsgHandler", 1, "onRecvAppTipMsgData, roomUserNum[" + i + "], qqUserLen[" + k + "]");
        if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) {
          break;
        }
        long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
        if ((i == 1) && (localObject1 != null) && (localObject1.length >= 1) && (l2 == localObject1[0]) && (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.b() == 0L))
        {
          if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, l1) != 0L) {
            break;
          }
          a(l1, 1, (byte)1);
          return;
        }
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, l1, localObject1, (int[])localObject2, i);
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 2, l1, 0L);
        paramArrayOfByte = new Intent();
        paramArrayOfByte.setAction("tencent.video.q2v.membersChange");
        paramArrayOfByte.putExtra("relationType", 2);
        paramArrayOfByte.putExtra("relationId", l1);
        paramArrayOfByte.putExtra("Exit", false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramArrayOfByte);
        return;
      }
      j += 4;
    }
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    lbc.d("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31.");
    if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) {
      return;
    }
    Object localObject1 = null;
    Object localObject2;
    long l2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        l2 = Long.valueOf((String)localObject2).longValue();
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      byte[] arrayOfByte1 = new byte[2];
      byte[] arrayOfByte2 = new byte[4];
      byte[] arrayOfByte3 = new byte[8];
      System.arraycopy(paramArrayOfByte, 2, arrayOfByte2, 0, 4);
      int i = lcr.a(arrayOfByte2, 4);
      if (i != 0)
      {
        localObject1 = new byte[2];
        System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 2, localObject1, 0, 2);
        lbc.d("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31| retCode wR0=" + localObject1[0] + " wR1=" + localObject1[1]);
        if (localObject1[0] == 3)
        {
          b(paramArrayOfByte, i);
          return;
        }
        lbc.e("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31|wrong retCode.");
        return;
      }
      localObject2 = new byte[2];
      System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 2, localObject2, 0, 2);
      lbc.d("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31| relation type wR0=" + localObject2[0] + " wR1=" + localObject2[1]);
      int j;
      long l1;
      int k;
      if (localObject2[0] == 1)
      {
        j = 1;
        System.arraycopy(paramArrayOfByte, 8, arrayOfByte1, 0, 2);
        int i2 = arrayOfByte1[0];
        int i3 = arrayOfByte1[1];
        l1 = 0L;
        k = 0;
        localObject2 = null;
        i = 10;
        label278:
        if (k < ((i2 & 0xFF) << 8 | (i3 & 0xFF) << 0))
        {
          System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 2);
          i += 2;
        }
      }
      else
      {
        switch ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0)
        {
        default: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
          for (;;)
          {
            k += 1;
            break label278;
            if (localObject2[0] == 2)
            {
              j = 2;
              break;
            }
            if (localObject2[0] == 3)
            {
              b(paramArrayOfByte, i);
              return;
            }
            lbc.e("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31|wrong relation type.");
            j = 2;
            break;
            i += 2;
            System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, 4);
            i += 4;
            l1 = lcr.b(arrayOfByte2, 4);
            continue;
            i += 6;
            continue;
            System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 2);
            i = i + 2 + ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0);
            continue;
            i += 10;
            continue;
            i += 6;
            continue;
            i += 6;
            continue;
            i += 6;
            continue;
            System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 2);
            i = i + 2 + ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0);
            continue;
            i += 6;
          }
        }
        System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 2);
        i += 2;
        int i4 = ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0) / 8;
        localObject2 = new long[i4];
        int n = 0;
        int m = 0;
        while (m < i4)
        {
          System.arraycopy(paramArrayOfByte, i, arrayOfByte3, 0, 8);
          int i1 = i + 8;
          long l3 = lcr.b(arrayOfByte3, 8);
          localObject2[m] = l3;
          i = n;
          if (l3 == l2)
          {
            i = n;
            if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.b() == 0L)
            {
              i = n;
              if (0L == this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(j, l1)) {
                i = 1;
              }
            }
          }
          m += 1;
          n = i;
          i = i1;
        }
        String str;
        if (n != 0)
        {
          str = Long.toString(l1);
          if (j != 2) {
            break label796;
          }
        }
        label796:
        for (m = 3000;; m = 1)
        {
          VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, 13, false, str, (String)localObject1, true, null, true, new Object[0]);
          break;
        }
      }
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(j, l1, (long[])localObject2);
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, j, l1, 0L);
      return;
      l2 = 0L;
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    lbc.d("QQGAudioMsgHandler", "onRecvMultiVideoS2C_0x95.");
    if (!a()) {}
    int i;
    label974:
    do
    {
      return;
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
      localByteBuffer.getShort();
      localByteBuffer.getLong();
      int n = localByteBuffer.getShort();
      long l = 0L;
      i = 0;
      int i1;
      int k;
      int m;
      int i2;
      if (n > 0)
      {
        j = 0;
        while (j < n)
        {
          i1 = localByteBuffer.getShort();
          paramArrayOfByte = null;
          k = 0;
          if (k < i1)
          {
            m = localByteBuffer.getShort();
            i2 = localByteBuffer.getShort();
            switch (m)
            {
            default: 
              localByteBuffer.get(new byte[i2], 0, i2);
            }
            for (;;)
            {
              k += 1;
              break;
              l = localByteBuffer.getInt();
              continue;
              i = localByteBuffer.getInt();
              continue;
              localByteBuffer.getInt();
              continue;
              paramArrayOfByte = new long[i2 / 8];
              m = 0;
              while (m < i2 / 8)
              {
                paramArrayOfByte[m] = localByteBuffer.getLong();
                m += 1;
              }
              continue;
              localByteBuffer.getInt();
              continue;
              localByteBuffer.getInt();
            }
          }
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(9, 2, l, paramArrayOfByte, i);
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 2, l, 0L);
          j += 1;
        }
      }
      n = localByteBuffer.getShort();
      l = 0L;
      i = 0;
      if (n > 0)
      {
        j = 0;
        while (j < n)
        {
          i1 = localByteBuffer.getShort();
          k = 0;
          if (k < i1)
          {
            m = localByteBuffer.getShort();
            i2 = localByteBuffer.getShort();
            switch (m)
            {
            default: 
              localByteBuffer.get(new byte[i2], 0, i2);
            }
            for (;;)
            {
              k += 1;
              break;
              l = lcr.a(localByteBuffer.getInt());
              continue;
              i = localByteBuffer.getInt();
              continue;
              localByteBuffer.getInt();
              continue;
              paramArrayOfByte = new long[i2 / 8];
              m = 0;
              while (m < i2 / 8)
              {
                paramArrayOfByte[m] = localByteBuffer.getLong();
                m += 1;
              }
              continue;
              localByteBuffer.getInt();
              continue;
              localByteBuffer.getInt();
            }
          }
          mrf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), new ansq(this, l, i));
          j += 1;
        }
      }
      int i3 = localByteBuffer.getShort();
      l = 0L;
      i = 0;
      if (i3 > 0)
      {
        k = 0;
        if (k < i3)
        {
          int i4 = localByteBuffer.getShort();
          paramArrayOfByte = null;
          i2 = -1;
          Object localObject = null;
          i1 = -1;
          n = -1;
          m = 0;
          j = i;
          i = i2;
          if (m < i4)
          {
            i2 = localByteBuffer.getShort();
            int i5 = localByteBuffer.getShort();
            switch (i2)
            {
            default: 
              localByteBuffer.get(new byte[i5], 0, i5);
            }
            for (;;)
            {
              m += 1;
              break;
              l = lcr.a(localByteBuffer.getInt());
              continue;
              j = localByteBuffer.getInt();
              continue;
              i = localByteBuffer.getInt();
              continue;
              paramArrayOfByte = new long[i5 / 8];
              i2 = 0;
              while (i2 < i5 / 8)
              {
                paramArrayOfByte[i2] = localByteBuffer.getLong();
                i2 += 1;
              }
              continue;
              n = localByteBuffer.getInt();
              continue;
              i1 = localByteBuffer.getInt();
              continue;
              localObject = new byte[i5];
              localByteBuffer.get((byte[])localObject, 0, i5);
            }
          }
          if (AudioHelper.f())
          {
            StringBuilder localStringBuilder1 = new StringBuilder().append("onRecvMultiVideoS2C_0x95, index[").append(k).append("], GroupId[").append(l).append("], roomUserNum[").append(j).append("], busitype[").append(i).append("], shortnum[").append(n).append("], createtime[").append(i1).append("], ppt[");
            if (localObject != null) {
              break label974;
            }
            localObject = "null";
            localObject = localStringBuilder1.append((String)localObject).append("], uinList[");
            if (paramArrayOfByte != null) {
              break label1033;
            }
          }
          for (paramArrayOfByte = "null";; paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length))
          {
            QLog.w("QQGAudioMsgHandler", 1, paramArrayOfByte + "]");
            this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(11, 1, l, null, j);
            this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(6, l, 10, 0, 0, 21, j);
            this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, l, 0L);
            k += 1;
            i = j;
            break;
            StringBuilder localStringBuilder2 = new StringBuilder().append(localObject.length).append("|");
            if (localObject.length == 0) {}
            for (localObject = "";; localObject = Byte.valueOf(localObject[0]))
            {
              localObject = localObject;
              break;
            }
          }
        }
      }
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_JavaUtilVector == null);
    label1033:
    int j = this.jdField_a_of_type_JavaUtilVector.size();
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        h((byte[])this.jdField_a_of_type_JavaUtilVector.elementAt(i));
        i += 1;
      }
    }
    this.jdField_a_of_type_JavaUtilVector.clear();
  }
  
  void f(byte[] paramArrayOfByte)
  {
    int i = (paramArrayOfByte[10] & 0xFF) + 19;
    Object localObject = new byte[8];
    System.arraycopy(paramArrayOfByte, i, localObject, 0, 8);
    long l1 = lcr.b((byte[])localObject, 8);
    int j = i + 8;
    localObject = new byte[4];
    System.arraycopy(paramArrayOfByte, j, localObject, 0, 4);
    i = lcr.a((byte[])localObject, 4);
    j += 4;
    localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, j, localObject, 0, 2);
    int k = (localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0;
    if ((k != 3) && (k != 2) && (k == 2) && (i != 10))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "Current version is only surpport discussion and friend. RelationType=" + k);
      }
      return;
    }
    long l2;
    if (k == 2)
    {
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, j + 3, localObject, 0, 4);
      l2 = lcr.a((byte[])localObject, 4);
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "onRecvMuitiInvite discussId is" + l2 + "InviteUin:" + l1);
      }
      ((anks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).b(l2);
      if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter != null) {
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(7, 2, l2, new long[] { l1 }, 1L);
      }
      paramArrayOfByte = Long.toString(l2);
      localObject = Long.toString(l1);
      ((azwe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38)).a(0, l2, (String)localObject, "");
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) {
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 13, false, paramArrayOfByte, (String)localObject, false, null, true, new Object[0]);
      }
    }
    while ((k == 1) && (i == 2))
    {
      new bldk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(new ansr(this));
      return;
      if ((k == 1) && (i == 10))
      {
        localObject = new byte[4];
        System.arraycopy(paramArrayOfByte, j + 3, localObject, 0, 4);
        l2 = lcr.a((byte[])localObject, 4);
        if (QLog.isColorLevel()) {
          QLog.w("QQGAudioMsgHandler", 1, "onRecvMuitiInvite, groupUin[" + l2 + "], InviteUin[" + l1 + "]");
        }
        if ((this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter != null) && (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(1, l2) == 0L))
        {
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(5, l2, 10, 0, 0, 20, 1);
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(8, 1, l2, new long[] { l1 }, 1L);
          this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, Long.valueOf(l2).longValue(), 0L);
        }
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 13, false, Long.toString(l2), Long.toString(l1), false, null, false, i, new Object[0]);
      }
    }
    new lxd(BaseApplication.getContext()).a(new anss(this));
  }
  
  void g(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvGroupVideoInvite");
    }
    int i = (paramArrayOfByte[10] & 0xFF) + 19;
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, 8);
    long l1 = lcr.b(arrayOfByte, 8);
    i += 8;
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, 4);
    int j = lcr.a(arrayOfByte, 4);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, i + 4, arrayOfByte, 0, 4);
    long l2 = lcr.b(arrayOfByte, 4);
    mrf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2), new anst(this, l2, j, l1));
  }
  
  void h(byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    long l;
    do
    {
      return;
      int i = paramArrayOfByte[10];
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, (i & 0xFF) + 34, localObject, 0, 4);
      l = lcr.a((byte[])localObject, 4);
      QLog.d("QQGAudioMsgHandler", 1, "dealGAudioOfflineMsg discussId is:" + l);
    } while (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, l) <= 0L);
    ((anks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).b(l);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Intent localIntent = new Intent("tencent.video.q2v.RecvMultiVideoCall");
    localIntent.putExtra("uin", (String)localObject);
    localIntent.putExtra("buffer", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    QLog.d("QQGAudioMsgHandler", 1, "dealGAudioOfflineMsg sendBroadcast discussId is:" + l);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage == null) || (jdField_a_of_type_JavaUtilArrayList == null)) {}
    label79:
    do
    {
      do
      {
        for (;;)
        {
          return true;
          try
          {
            switch (paramMessage.what)
            {
            case 1: 
              if (!jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
                break label79;
              }
              if (QLog.isColorLevel())
              {
                QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is empty!");
                return true;
              }
              break;
            }
          }
          catch (Exception paramMessage) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQGAudioMsgHandler", 2, "handleMessage sDoubleMeetingMsg error!");
      return true;
      jdField_a_of_type_JavaUtilArrayList.clear();
    } while (!QLog.isColorLevel());
    QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is clear after 10 seconds");
    return true;
    return true;
  }
  
  public void i(byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent("tencent.video.q2v.VisitorSendGift");
    localIntent.putExtra("data", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ansp
 * JD-Core Version:    0.7.0.1
 */