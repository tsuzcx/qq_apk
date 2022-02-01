package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoPackageUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GroupVideoWrapper;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

public class QQGAudioMsgHandler
  implements Handler.Callback
{
  static ArrayList<QQGAudioMsgHandler.DoubleMeetingMsgWapper> jdField_a_of_type_JavaUtilArrayList = null;
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
      label28:
      b = null;
      try
      {
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
      break label28;
    }
  }
  
  public QQGAudioMsgHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter();
  }
  
  public static QQGAudioMsgHandler.SubCmd0x8DMsg a(byte[] paramArrayOfByte)
  {
    QQGAudioMsgHandler.SubCmd0x8DMsg localSubCmd0x8DMsg = new QQGAudioMsgHandler.SubCmd0x8DMsg();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 40)) {
      return localSubCmd0x8DMsg;
    }
    int i = paramArrayOfByte.length;
    byte[] arrayOfByte1 = new byte[2];
    byte[] arrayOfByte2 = new byte[4];
    byte[] arrayOfByte3 = new byte[8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 2);
    localSubCmd0x8DMsg.jdField_a_of_type_Int = VideoPackageUtils.a(VideoPackageUtils.a(arrayOfByte1, 2));
    System.arraycopy(paramArrayOfByte, 2, arrayOfByte3, 0, 8);
    localSubCmd0x8DMsg.jdField_a_of_type_Long = VideoPackageUtils.b(arrayOfByte3, 8);
    localSubCmd0x8DMsg.jdField_b_of_type_Int = VideoPackageUtils.a(paramArrayOfByte[10]);
    int j = localSubCmd0x8DMsg.jdField_b_of_type_Int + 11;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localSubCmd0x8DMsg.jdField_b_of_type_Long = VideoPackageUtils.a(VideoPackageUtils.a(arrayOfByte2, 4));
    j += 4;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localSubCmd0x8DMsg.jdField_c_of_type_Long = VideoPackageUtils.a(VideoPackageUtils.a(arrayOfByte2, 4));
    j += 4;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte3, 0, 8);
    localSubCmd0x8DMsg.jdField_d_of_type_Long = VideoPackageUtils.b(arrayOfByte3, 8);
    j += 8;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localSubCmd0x8DMsg.jdField_c_of_type_Int = VideoPackageUtils.a(arrayOfByte2, 4);
    j += 4;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
    localSubCmd0x8DMsg.jdField_d_of_type_Int = VideoPackageUtils.a(VideoPackageUtils.a(arrayOfByte1, 2));
    j += 2;
    localSubCmd0x8DMsg.jdField_e_of_type_Int = VideoPackageUtils.a(paramArrayOfByte[j]);
    j += 1;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localSubCmd0x8DMsg.jdField_e_of_type_Long = VideoPackageUtils.a(arrayOfByte2, 4);
    j += localSubCmd0x8DMsg.jdField_e_of_type_Int;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
    localSubCmd0x8DMsg.jdField_f_of_type_Int = VideoPackageUtils.a(VideoPackageUtils.a(arrayOfByte1, 2));
    j = j + 2 + localSubCmd0x8DMsg.jdField_f_of_type_Int * 8;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localSubCmd0x8DMsg.jdField_f_of_type_Long = VideoPackageUtils.a(VideoPackageUtils.a(arrayOfByte2, 4));
    j += 4;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
    localSubCmd0x8DMsg.jdField_g_of_type_Int = VideoPackageUtils.a(VideoPackageUtils.a(arrayOfByte1, 2));
    j += 2;
    if ((localSubCmd0x8DMsg.jdField_g_of_type_Int >= 16) && (localSubCmd0x8DMsg.jdField_g_of_type_Int + j <= i))
    {
      System.arraycopy(paramArrayOfByte, j + 9, arrayOfByte1, 0, 2);
      i = VideoPackageUtils.a(VideoPackageUtils.a(arrayOfByte1, 2)) + 11;
      if (localSubCmd0x8DMsg.jdField_d_of_type_Int != 3) {
        break label414;
      }
    }
    for (;;)
    {
      i = localSubCmd0x8DMsg.jdField_g_of_type_Int;
      return localSubCmd0x8DMsg;
      label414:
      localSubCmd0x8DMsg.h = VideoPackageUtils.a(paramArrayOfByte[(j + i)]);
      i += 1;
      if (i + 4 <= localSubCmd0x8DMsg.jdField_g_of_type_Int)
      {
        System.arraycopy(paramArrayOfByte, j + i, arrayOfByte2, 0, 4);
        localSubCmd0x8DMsg.jdField_g_of_type_Long = VideoPackageUtils.a(VideoPackageUtils.a(arrayOfByte2, 4));
      }
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    Object localObject1;
    Object localObject2;
    byte[] arrayOfByte1;
    long l;
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
          localObject1 = (QQGAudioMsgHandler.DoubleMeetingMsgWapper)jdField_a_of_type_JavaUtilArrayList.get(paramInt);
          if ((localObject1 != null) && (((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject1).jdField_a_of_type_Long == paramLong) && (((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)))
          {
            localObject2 = new byte[8];
            arrayOfByte1 = ((im_msg_body.MsgBody)((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject1).jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_body.get()).msg_content.get().toByteArray();
            System.arraycopy(arrayOfByte1, (arrayOfByte1[10] & 0xFF) + 19, localObject2, 0, 8);
            l = VideoPackageUtils.b((byte[])localObject2, 8);
            VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, 6, true, Long.toString(paramLong), Long.toString(l), false, null, false, new Object[] { ((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject1).jdField_a_of_type_MsfMsgcommMsg_comm$Msg });
          }
          paramInt += 1;
        }
      }
    }
    else {
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        break label227;
      }
    }
    label227:
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
          localObject1 = new ArrayList();
          paramInt = 0;
          while (paramInt < jdField_a_of_type_JavaUtilArrayList.size())
          {
            localObject2 = (QQGAudioMsgHandler.DoubleMeetingMsgWapper)jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            if ((localObject2 != null) && (((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject2).jdField_a_of_type_Long == paramLong) && (((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject2).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))) {
              ((ArrayList)localObject1).add(localObject2);
            }
            paramInt += 1;
          }
          Collections.sort((List)localObject1, new QQGAudioMsgHandler.SortByTime());
          paramInt = 0;
          while (paramInt < ((ArrayList)localObject1).size() - 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->list =" + ((QQGAudioMsgHandler.DoubleMeetingMsgWapper)((ArrayList)localObject1).get(paramInt)).jdField_b_of_type_Long);
            }
            localObject2 = (QQGAudioMsgHandler.DoubleMeetingMsgWapper)((ArrayList)localObject1).get(paramInt);
            arrayOfByte1 = new byte[8];
            byte[] arrayOfByte2 = ((im_msg_body.MsgBody)((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject2).jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_body.get()).msg_content.get().toByteArray();
            System.arraycopy(arrayOfByte2, (arrayOfByte2[10] & 0xFF) + 19, arrayOfByte1, 0, 8);
            l = VideoPackageUtils.b(arrayOfByte1, 8);
            VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, 6, true, Long.toString(paramLong), Long.toString(l), false, null, false, new Object[] { ((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject2).jdField_a_of_type_MsfMsgcommMsg_comm$Msg });
            paramInt += 1;
          }
        } while (((ArrayList)localObject1).size() <= 0);
        localObject1 = ((im_msg_body.MsgBody)((QQGAudioMsgHandler.DoubleMeetingMsgWapper)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_body.get()).msg_content.get().toByteArray();
      } while (this.jdField_a_of_type_ArrayOfByte == null);
      paramInt = localObject1.length;
    } while (paramInt < 40);
    if (this.jdField_a_of_type_ArrayOfByte.length < paramInt) {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
    }
    System.arraycopy(localObject1, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramInt);
    f(this.jdField_a_of_type_ArrayOfByte);
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt)
  {
    long l = 0L;
    int i = 0;
    int j = 0;
    while (j < paramInt)
    {
      int n = paramByteBuffer.getShort();
      long[] arrayOfLong = null;
      int k = 0;
      if (k < n)
      {
        int m = paramByteBuffer.getShort();
        int i1 = paramByteBuffer.getShort();
        switch (m)
        {
        default: 
          paramByteBuffer.get(new byte[i1], 0, i1);
        }
        for (;;)
        {
          k += 1;
          break;
          l = paramByteBuffer.getInt();
          continue;
          i = paramByteBuffer.getInt();
          continue;
          paramByteBuffer.getInt();
          continue;
          arrayOfLong = new long[i1 / 8];
          m = 0;
          while (m < i1 / 8)
          {
            arrayOfLong[m] = paramByteBuffer.getLong();
            m += 1;
          }
          continue;
          paramByteBuffer.getInt();
          continue;
          paramByteBuffer.getInt();
        }
      }
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(9, 2, l, arrayOfLong, i);
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 2, l, 0L);
      j += 1;
    }
  }
  
  private void b(ByteBuffer paramByteBuffer, int paramInt)
  {
    long l = 0L;
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      int n = paramByteBuffer.getShort();
      int k = 0;
      if (k < n)
      {
        int m = paramByteBuffer.getShort();
        int i1 = paramByteBuffer.getShort();
        switch (m)
        {
        default: 
          paramByteBuffer.get(new byte[i1], 0, i1);
        }
        for (;;)
        {
          k += 1;
          break;
          l = VideoPackageUtils.a(paramByteBuffer.getInt());
          continue;
          i = paramByteBuffer.getInt();
          continue;
          paramByteBuffer.getInt();
          continue;
          long[] arrayOfLong = new long[i1 / 8];
          m = 0;
          while (m < i1 / 8)
          {
            arrayOfLong[m] = paramByteBuffer.getLong();
            m += 1;
          }
          continue;
          paramByteBuffer.getInt();
          continue;
          paramByteBuffer.getInt();
        }
      }
      GVideoGrayConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), new QQGAudioMsgHandler.1(this, l, i));
      j += 1;
    }
  }
  
  private void c(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i = 0;
    long l = 0L;
    int k = 0;
    if (k < paramInt)
    {
      int i3 = paramByteBuffer.getShort();
      Object localObject1 = null;
      int i2 = -1;
      Object localObject2 = null;
      int i1 = -1;
      int n = -1;
      int m = 0;
      int j = i;
      i = i2;
      if (m < i3)
      {
        i2 = paramByteBuffer.getShort();
        int i4 = paramByteBuffer.getShort();
        switch (i2)
        {
        default: 
          paramByteBuffer.get(new byte[i4], 0, i4);
        }
        for (;;)
        {
          m += 1;
          break;
          l = VideoPackageUtils.a(paramByteBuffer.getInt());
          continue;
          j = paramByteBuffer.getInt();
          continue;
          i = paramByteBuffer.getInt();
          continue;
          localObject1 = new long[i4 / 8];
          i2 = 0;
          while (i2 < i4 / 8)
          {
            localObject1[i2] = paramByteBuffer.getLong();
            i2 += 1;
          }
          continue;
          n = paramByteBuffer.getInt();
          continue;
          i1 = paramByteBuffer.getInt();
          continue;
          localObject2 = new byte[i4];
          paramByteBuffer.get((byte[])localObject2, 0, i4);
        }
      }
      if (AudioHelper.e())
      {
        StringBuilder localStringBuilder1 = new StringBuilder().append("onRecvMultiVideoS2C_0x95, index[").append(k).append("], GroupId[").append(l).append("], roomUserNum[").append(j).append("], busitype[").append(i).append("], shortnum[").append(n).append("], createtime[").append(i1).append("], ppt[");
        if (localObject2 != null) {
          break label441;
        }
        localObject2 = "null";
        localObject2 = localStringBuilder1.append((String)localObject2).append("], uinList[");
        if (localObject1 != null) {
          break label500;
        }
      }
      label441:
      label500:
      for (localObject1 = "null";; localObject1 = Integer.valueOf(localObject1.length))
      {
        QLog.w("QQGAudioMsgHandler", 1, localObject1 + "]");
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(11, 1, l, null, j);
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(6, l, 10, 0, 0, 21, j);
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, l, 0L);
        k += 1;
        i = j;
        break;
        StringBuilder localStringBuilder2 = new StringBuilder().append(localObject2.length).append("|");
        if (localObject2.length == 0) {}
        for (localObject2 = "";; localObject2 = Byte.valueOf(localObject2[0]))
        {
          localObject2 = localObject2;
          break;
        }
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
      new GroupVideoWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(new QQGAudioMsgHandler.5(this, paramArrayOfByte));
      return;
    }
    new QavWrapper((Context)localObject).a(new QQGAudioMsgHandler.6(this, paramArrayOfByte));
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, long paramLong1, String paramString, int paramInt3, long paramLong2)
  {
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    int i = 0;
    while (i < paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, 8);
      int k = paramInt1 + 8;
      long l = VideoPackageUtils.b(arrayOfByte, 8);
      paramArrayOfLong[i] = l;
      paramInt1 = j;
      if (l == paramLong1)
      {
        paramInt1 = j;
        if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.b() == 0L)
        {
          paramInt1 = j;
          if (0L == this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(paramInt3, paramLong2)) {
            paramInt1 = 1;
          }
        }
      }
      i += 1;
      j = paramInt1;
      paramInt1 = k;
    }
    if (j != 0)
    {
      paramArrayOfByte = Long.toString(paramLong2);
      if (paramInt3 != 2) {
        break label156;
      }
    }
    label156:
    for (paramInt2 = 3000;; paramInt2 = 1)
    {
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2, 13, false, paramArrayOfByte, paramString, true, null, true, new Object[0]);
      return paramInt1;
    }
  }
  
  public int a(byte[] paramArrayOfByte1, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    int[] arrayOfInt = new int[paramInt2];
    int i = 0;
    if (i < paramInt3)
    {
      System.arraycopy(paramArrayOfByte1, paramInt1, paramArrayOfByte2, 0, 2);
      int j = paramInt1 + 2;
      paramInt1 = paramArrayOfByte2[0];
      int m = paramArrayOfByte2[1];
      System.arraycopy(paramArrayOfByte1, j, paramArrayOfByte2, 0, 2);
      j += 2;
      int k = (paramArrayOfByte2[0] & 0xFF) << 8 | (paramArrayOfByte2[1] & 0xFF) << 0;
      switch ((paramInt1 & 0xFF) << 8 | (m & 0xFF) << 0)
      {
      default: 
        paramInt1 = j + k;
      }
      for (;;)
      {
        i += 1;
        break;
        paramInt1 = j;
        if (k == paramInt2)
        {
          System.arraycopy(paramArrayOfByte1, j, paramArrayOfByte2, 0, k);
          paramInt1 = 0;
          while (paramInt1 < k)
          {
            paramArrayOfInt[paramInt1] = paramArrayOfByte2[paramInt1];
            paramInt1 += 1;
          }
          paramInt1 = j + k;
          continue;
          paramInt1 = j;
          if (k == paramInt2)
          {
            System.arraycopy(paramArrayOfByte1, j, paramArrayOfByte2, 0, k);
            paramInt1 = 0;
            while (paramInt1 < k)
            {
              arrayOfInt[paramInt1] = paramArrayOfByte2[paramInt1];
              paramInt1 += 1;
            }
            paramInt1 = j + k;
          }
        }
      }
    }
    return paramInt1;
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramString, paramInt3);
      i = paramInt3;
      if (paramInt3 != 14) {
        break label168;
      }
      i = 2;
      paramInt3 = 21;
      if (paramInt2 > 0) {
        break label180;
      }
      paramInt3 = 23;
      AVNotifyCenter.VideoRoomInfo localVideoRoomInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l1);
      if ((localVideoRoomInfo == null) || (localVideoRoomInfo.jdField_a_of_type_Int <= 0) || (paramInt2 != 0)) {
        break label229;
      }
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(5, 1, l1, null, localVideoRoomInfo.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l1, i, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(4, l1, i, paramInt4, paramInt5, paramInt6, paramInt3, paramInt2);
      if (paramInt2 != 0) {
        break label379;
      }
    }
    if (l1 == 0L) {
      return;
    }
    int i;
    label168:
    label180:
    label229:
    a(l1, i);
    this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, l1, 0L);
    label293:
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c(paramString) != 14)
    {
      paramString = new Intent();
      paramString.setAction("tencent.video.q2v.membersChange");
      paramString.putExtra("relationType", 1);
      paramString.putExtra("avtype", i);
      paramString.putExtra("relationId", l1);
      if (paramInt2 != 0) {
        break label469;
      }
      paramString.putExtra("Exit", true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramString);
      return;
      label379:
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(6, 1, l1, paramArrayOfLong, paramInt2);
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.b(10, l1, i);
      if ((i == 2) && (paramInt1 == 1) && (((TroopVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER)).a(paramString) == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(l1, true);
      }
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, 1, l1, 0L);
      break label293;
      break;
      label469:
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
      l = VideoPackageUtils.a(arrayOfByte, 4);
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 18, false, String.valueOf(l), paramArrayOfByte, false, null, false, new Object[0]);
    }
    while (paramInt != 7) {
      return;
    }
    paramInt = (paramArrayOfByte[10] & 0xFF) + 19;
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, 8);
    VideoPackageUtils.b(arrayOfByte, 8);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, paramInt + 12, arrayOfByte, 0, 4);
    long l = VideoPackageUtils.a(arrayOfByte, 4);
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
    AVLog.printAllUserLog("QQGAudioMsgHandler", String.format("queryRoomMemberNum| discussId=%d, dataType= %d, wReserve=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Byte.valueOf(paramByte) }));
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), VideoConfigServlet.class);
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
      i = VideoPackageUtils.a(VideoPackageUtils.a((byte[])localObject, 2));
      if (i != 141) {
        break label630;
      }
      QQGAudioMsgHandler.SubCmd0x8DMsg localSubCmd0x8DMsg = a(paramArrayOfByte);
      i = localSubCmd0x8DMsg.jdField_d_of_type_Int;
      l1 = localSubCmd0x8DMsg.jdField_d_of_type_Long;
      l2 = localSubCmd0x8DMsg.jdField_e_of_type_Long;
      j = localSubCmd0x8DMsg.jdField_c_of_type_Int;
      l3 = localSubCmd0x8DMsg.jdField_f_of_type_Long;
      l4 = localSubCmd0x8DMsg.jdField_g_of_type_Long;
      str = Long.toString(l2);
      localObject = Long.toString(l1);
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "GAudioOfflineMsg relationShip[" + i + "], groupUin[" + str + "], inviteUin[" + l1 + "], subCmd0x8DMsg[" + localSubCmd0x8DMsg + "]");
      }
      if (1 == i)
      {
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 13, false, str, (String)localObject, false, null, false, j, new Object[] { Long.valueOf(l3), Long.valueOf(l4) });
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(l2, 1, 10, true);
        return;
      }
      if (3 != i) {
        break label471;
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
        l2 = MessageCache.a();
      }
      if ((jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_AndroidOsHandler == null)) {
        break;
      }
      jdField_a_of_type_JavaUtilArrayList.add(new QQGAudioMsgHandler.DoubleMeetingMsgWapper(paramMsg, Long.valueOf(paramArrayOfByte).longValue(), l2));
      a(Long.valueOf(paramArrayOfByte).longValue(), 4, (byte)8);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10000L);
      return;
      label471:
      paramMsg = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
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
          paramMsg.a(3000, str, (String)localObject);
        }
      }
      if (this.jdField_a_of_type_JavaUtilVector == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilVector.add(paramArrayOfByte);
      return;
      label630:
      if (i != 7) {
        break;
      }
      i = (paramArrayOfByte[10] & 0xFF) + 19;
      paramMsg = new byte[8];
      System.arraycopy(paramArrayOfByte, i, paramMsg, 0, 8);
      l1 = VideoPackageUtils.b(paramMsg, 8);
      i += 8;
      paramMsg = new byte[4];
      System.arraycopy(paramArrayOfByte, i, paramMsg, 0, 4);
      j = VideoPackageUtils.a(paramMsg, 4);
      paramMsg = new byte[4];
      System.arraycopy(paramArrayOfByte, i + 4, paramMsg, 0, 4);
      l2 = VideoPackageUtils.b(paramMsg, 4);
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 13, true, Long.toString(l2), Long.toString(l1), false, null, false, j, new Object[0]);
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.b(11, l2, j);
      ((TroopVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER)).a(l2);
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(l2, 1, 2, true);
      return;
    }
  }
  
  boolean a()
  {
    if (!VcSystemInfo.isSupportSharpAudio())
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
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(paramLong);
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
          VideoPackageUtils.b(arrayOfByte1, 4);
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
        VideoPackageUtils.b(arrayOfByte2, 8);
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
    long l = VideoPackageUtils.b((byte[])localObject, j);
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->uin=" + l);
    }
    a(paramInt, l);
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    AVLog.printAllUserLog("QQGAudioMsgHandler", "onRecvAppTipMsgData.");
    if (!a()) {}
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    Object localObject1;
    int i3;
    do
    {
      do
      {
        return;
        arrayOfByte1 = new byte[2];
        arrayOfByte2 = new byte[4];
        arrayOfByte3 = new byte[8];
        localObject1 = null;
      } while ((arrayOfByte1 == null) || (arrayOfByte2 == null) || (arrayOfByte3 == null));
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 2);
      i3 = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
    } while (i3 < 4);
    int j = 2;
    long l1 = 0L;
    int i = 0;
    int k = 0;
    int n = 0;
    label102:
    int m;
    if (n < i3)
    {
      System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
      m = j + 2;
      switch ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0)
      {
      default: 
        j = m;
      }
    }
    for (;;)
    {
      n += 1;
      break label102;
      j = m + 2;
      System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
      l1 = VideoPackageUtils.b(arrayOfByte2, 4);
      j += 4;
      continue;
      i = m + 2;
      System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, 4);
      j = i + 4;
      i = VideoPackageUtils.a(arrayOfByte2, 4);
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
        j = m + 6;
        continue;
        System.arraycopy(paramArrayOfByte, m, arrayOfByte1, 0, 2);
        j = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
        if (j <= 0) {
          break;
        }
        int i2 = j / 8;
        Object localObject2 = new long[i2];
        j = m + 2;
        int i1 = 0;
        for (;;)
        {
          m = j;
          k = i2;
          localObject1 = localObject2;
          if (i1 >= i2) {
            break;
          }
          System.arraycopy(paramArrayOfByte, j, arrayOfByte3, 0, 8);
          localObject2[i1] = VideoPackageUtils.b(arrayOfByte3, 8);
          i1 += 1;
          j += 8;
        }
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
        m = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "TLV-NUMBER = " + m);
        }
        localObject2 = new int[k];
        a(paramArrayOfByte, j + 2, (int[])localObject2, k, m, arrayOfByte1);
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
    }
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    AVLog.printAllUserLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31.");
    if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) {}
    long l2;
    Object localObject2;
    int j;
    label285:
    do
    {
      return;
      l2 = 0L;
      Object localObject1 = null;
      long l1 = l2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        l1 = l2;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          l1 = Long.valueOf((String)localObject2).longValue();
          localObject1 = localObject2;
        }
      }
      j = 2;
      byte[] arrayOfByte1 = new byte[2];
      byte[] arrayOfByte2 = new byte[4];
      System.arraycopy(paramArrayOfByte, 2, arrayOfByte2, 0, 4);
      int i = VideoPackageUtils.a(arrayOfByte2, 4);
      if (i != 0)
      {
        localObject1 = new byte[2];
        System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 2, localObject1, 0, 2);
        AVLog.printAllUserLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31| retCode wR0=" + localObject1[0] + " wR1=" + localObject1[1]);
        if (localObject1[0] == 3)
        {
          b(paramArrayOfByte, i);
          return;
        }
        AVLog.printErrorLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31|wrong retCode.");
        return;
      }
      localObject2 = new byte[2];
      System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 2, localObject2, 0, 2);
      AVLog.printAllUserLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31| relation type wR0=" + localObject2[0] + " wR1=" + localObject2[1]);
      int k;
      if (localObject2[0] == 1)
      {
        j = 1;
        System.arraycopy(paramArrayOfByte, 8, arrayOfByte1, 0, 2);
        int m = arrayOfByte1[0];
        int n = arrayOfByte1[1];
        l2 = 0L;
        localObject2 = null;
        k = 0;
        i = 10;
        if (k >= ((m & 0xFF) << 8 | (n & 0xFF) << 0)) {
          continue;
        }
        System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 2);
        i += 2;
        switch ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0)
        {
        }
      }
      for (;;)
      {
        k += 1;
        break label285;
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
        AVLog.printErrorLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31|wrong relation type.");
        break;
        i += 2;
        System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, 4);
        i += 4;
        l2 = VideoPackageUtils.b(arrayOfByte2, 4);
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
        continue;
        System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 2);
        int i1 = ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0) / 8;
        localObject2 = new long[i1];
        i = a(paramArrayOfByte, i + 2, i1, (long[])localObject2, l1, (String)localObject1, j, l2);
      }
    } while ((localObject2 == null) || (localObject2.length <= 0));
    this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(j, l2, (long[])localObject2);
    this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(21, j, l2, 0L);
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    AVLog.printAllUserLog("QQGAudioMsgHandler", "onRecvMultiVideoS2C_0x95.");
    if (!a()) {}
    int i;
    do
    {
      return;
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
      paramArrayOfByte.getShort();
      paramArrayOfByte.getLong();
      i = paramArrayOfByte.getShort();
      if (i > 0) {
        a(paramArrayOfByte, i);
      }
      i = paramArrayOfByte.getShort();
      if (i > 0) {
        b(paramArrayOfByte, i);
      }
      i = paramArrayOfByte.getShort();
      if (i > 0) {
        c(paramArrayOfByte, i);
      }
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_JavaUtilVector == null);
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
    long l1 = VideoPackageUtils.b((byte[])localObject, 8);
    int j = i + 8;
    localObject = new byte[4];
    System.arraycopy(paramArrayOfByte, j, localObject, 0, 4);
    i = VideoPackageUtils.a((byte[])localObject, 4);
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
      l2 = VideoPackageUtils.a((byte[])localObject, 4);
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "onRecvMuitiInvite discussId is" + l2 + "InviteUin:" + l1);
      }
      ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b(l2);
      if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter != null) {
        this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(7, 2, l2, new long[] { l1 }, 1L);
      }
      paramArrayOfByte = Long.toString(l2);
      localObject = Long.toString(l1);
      ((QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE)).a(0, l2, (String)localObject, "");
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a()) {
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 13, false, paramArrayOfByte, (String)localObject, false, null, true, new Object[0]);
      }
    }
    while ((k == 1) && (i == 2))
    {
      new GroupVideoWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(new QQGAudioMsgHandler.2(this));
      return;
      if ((k == 1) && (i == 10))
      {
        localObject = new byte[4];
        System.arraycopy(paramArrayOfByte, j + 3, localObject, 0, 4);
        l2 = VideoPackageUtils.a((byte[])localObject, 4);
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
    new QavWrapper(BaseApplication.getContext()).a(new QQGAudioMsgHandler.3(this));
  }
  
  void g(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvGroupVideoInvite");
    }
    int i = (paramArrayOfByte[10] & 0xFF) + 19;
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, 8);
    long l1 = VideoPackageUtils.b(arrayOfByte, 8);
    i += 8;
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, 4);
    int j = VideoPackageUtils.a(arrayOfByte, 4);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, i + 4, arrayOfByte, 0, 4);
    long l2 = VideoPackageUtils.b(arrayOfByte, 4);
    GVideoGrayConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2), new QQGAudioMsgHandler.4(this, l2, j, l1));
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
      l = VideoPackageUtils.a((byte[])localObject, 4);
      QLog.d("QQGAudioMsgHandler", 1, "dealGAudioOfflineMsg discussId is:" + l);
    } while (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter.a(2, l) <= 0L);
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b(l);
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
    label80:
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
                break label80;
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
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler
 * JD-Core Version:    0.7.0.1
 */