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
import com.tencent.mobileqq.utils.QQAudioHelper;
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
  static ArrayList<QQGAudioMsgHandler.DoubleMeetingMsgWapper> f;
  static ArrayList<String> g;
  QQAppInterface a = null;
  AVNotifyCenter b;
  byte[] c = new byte['ª'];
  boolean d = false;
  Vector<byte[]> e = new Vector();
  Handler h;
  
  static
  {
    try
    {
      f = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg create successful!");
      }
      g = null;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          g = new ArrayList();
          if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, "sCacheMsgList create successful!");
          }
          return;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
      }
    }
  }
  
  public QQGAudioMsgHandler(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.h = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = this.a.getAVNotifyCenter();
  }
  
  private void a(int paramInt, long paramLong)
  {
    Object localObject1;
    Object localObject2;
    byte[] arrayOfByte1;
    long l;
    if (paramInt != 0)
    {
      localObject1 = f;
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onRecvMultiVideoC2SACK_0x31-retCode->msgList size=");
          ((StringBuilder)localObject1).append(f.size());
          QLog.d("QQGAudioMsgHandler", 2, ((StringBuilder)localObject1).toString());
        }
        paramInt = 0;
        while (paramInt < f.size())
        {
          localObject1 = (QQGAudioMsgHandler.DoubleMeetingMsgWapper)f.get(paramInt);
          if ((localObject1 != null) && (((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject1).a == paramLong) && (((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject1).d.compareAndSet(false, true)))
          {
            localObject2 = new byte[8];
            arrayOfByte1 = ((im_msg_body.MsgBody)((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject1).c.msg_body.get()).msg_content.get().toByteArray();
            System.arraycopy(arrayOfByte1, (arrayOfByte1[10] & 0xFF) + 19, localObject2, 0, 8);
            l = VideoPackageUtils.c((byte[])localObject2, 8);
            VideoMsgTools.a(this.a, 0, 6, true, Long.toString(paramLong), Long.toString(l), false, null, false, new Object[] { ((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject1).c });
          }
          paramInt += 1;
        }
      }
    }
    else
    {
      localObject1 = f;
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).isEmpty()) {
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onRecvMultiVideoC2SACK_0x31-retCode->msgList size=");
          ((StringBuilder)localObject1).append(f.size());
          QLog.d("QQGAudioMsgHandler", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = new ArrayList();
        paramInt = 0;
        while (paramInt < f.size())
        {
          localObject2 = (QQGAudioMsgHandler.DoubleMeetingMsgWapper)f.get(paramInt);
          if ((localObject2 != null) && (((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject2).a == paramLong) && (((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject2).d.compareAndSet(false, true))) {
            ((ArrayList)localObject1).add(localObject2);
          }
          paramInt += 1;
        }
        Collections.sort((List)localObject1, new QQGAudioMsgHandler.SortByTime());
        paramInt = 0;
        while (paramInt < ((ArrayList)localObject1).size() - 1)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onRecvMultiVideoC2SACK_0x31-retCode->list =");
            ((StringBuilder)localObject2).append(((QQGAudioMsgHandler.DoubleMeetingMsgWapper)((ArrayList)localObject1).get(paramInt)).b);
            QLog.d("QQGAudioMsgHandler", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = (QQGAudioMsgHandler.DoubleMeetingMsgWapper)((ArrayList)localObject1).get(paramInt);
          arrayOfByte1 = new byte[8];
          byte[] arrayOfByte2 = ((im_msg_body.MsgBody)((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject2).c.msg_body.get()).msg_content.get().toByteArray();
          System.arraycopy(arrayOfByte2, (arrayOfByte2[10] & 0xFF) + 19, arrayOfByte1, 0, 8);
          l = VideoPackageUtils.c(arrayOfByte1, 8);
          VideoMsgTools.a(this.a, 0, 6, true, Long.toString(paramLong), Long.toString(l), false, null, false, new Object[] { ((QQGAudioMsgHandler.DoubleMeetingMsgWapper)localObject2).c });
          paramInt += 1;
        }
        if (((ArrayList)localObject1).size() > 0)
        {
          localObject1 = ((im_msg_body.MsgBody)((QQGAudioMsgHandler.DoubleMeetingMsgWapper)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).c.msg_body.get()).msg_content.get().toByteArray();
          localObject2 = this.c;
          if (localObject2 == null) {
            return;
          }
          paramInt = localObject1.length;
          if (paramInt < 40) {
            return;
          }
          if (localObject2.length < paramInt) {
            this.c = new byte[paramInt];
          }
          System.arraycopy(localObject1, 0, this.c, 0, paramInt);
          f(this.c);
        }
      }
    }
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt)
  {
    long l = 0L;
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      int n = paramByteBuffer.getShort();
      long[] arrayOfLong = null;
      int k = 0;
      while (k < n)
      {
        int m = paramByteBuffer.getShort();
        int i1 = paramByteBuffer.getShort();
        switch (m)
        {
        default: 
          paramByteBuffer.get(new byte[i1], 0, i1);
          break;
        case 6: 
          paramByteBuffer.getInt();
          break;
        case 5: 
          paramByteBuffer.getInt();
          break;
        case 4: 
          i1 /= 8;
          arrayOfLong = new long[i1];
          m = 0;
          while (m < i1)
          {
            arrayOfLong[m] = paramByteBuffer.getLong();
            m += 1;
          }
          break;
        case 3: 
          paramByteBuffer.getInt();
          break;
        case 2: 
          i = paramByteBuffer.getInt();
          break;
        case 1: 
          l = paramByteBuffer.getInt();
        }
        k += 1;
      }
      this.b.a(9, 2, l, arrayOfLong, i);
      this.b.a(21, 2, l, 0L);
      j += 1;
    }
  }
  
  private void b(ByteBuffer paramByteBuffer, int paramInt)
  {
    long l1 = 0L;
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      int i1 = paramByteBuffer.getShort();
      int k = 0;
      while (k < i1)
      {
        int m = paramByteBuffer.getShort();
        int n = paramByteBuffer.getShort();
        long l2;
        switch (m)
        {
        default: 
          paramByteBuffer.get(new byte[n], 0, n);
          l2 = l1;
          m = i;
          break;
        case 6: 
          paramByteBuffer.getInt();
          l2 = l1;
          m = i;
          break;
        case 5: 
          paramByteBuffer.getInt();
          l2 = l1;
          m = i;
          break;
        case 4: 
          int i2 = n / 8;
          long[] arrayOfLong = new long[i2];
          n = 0;
          for (;;)
          {
            l2 = l1;
            m = i;
            if (n >= i2) {
              break;
            }
            arrayOfLong[n] = paramByteBuffer.getLong();
            n += 1;
          }
        case 3: 
          paramByteBuffer.getInt();
          l2 = l1;
          m = i;
          break;
        case 2: 
          m = paramByteBuffer.getInt();
          l2 = l1;
          break;
        case 1: 
          l2 = VideoPackageUtils.a(paramByteBuffer.getInt());
          m = i;
        }
        k += 1;
        l1 = l2;
        i = m;
      }
      GVideoGrayConfig.a().a(this.a, String.valueOf(l1), new QQGAudioMsgHandler.1(this, l1, i));
      j += 1;
    }
  }
  
  private void c(ByteBuffer paramByteBuffer, int paramInt)
  {
    long l1 = 0L;
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      int i7 = paramByteBuffer.getShort();
      int m = -1;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      int n = 0;
      int i1 = -1;
      int k = -1;
      Object localObject3;
      Object localObject4;
      while (n < i7)
      {
        int i2 = paramByteBuffer.getShort();
        int i3 = paramByteBuffer.getShort();
        int i4;
        int i5;
        switch (i2)
        {
        default: 
          paramByteBuffer.get(new byte[i3], 0, i3);
          l2 = l1;
          i2 = i1;
          i3 = m;
          i4 = k;
          localObject3 = localObject2;
          i5 = i;
          break;
        case 7: 
          localObject3 = new byte[i3];
          paramByteBuffer.get((byte[])localObject3, 0, i3);
          l2 = l1;
          i2 = i1;
          i3 = m;
          i4 = k;
          i5 = i;
          break;
        case 6: 
          i4 = paramByteBuffer.getInt();
          l2 = l1;
          i2 = i1;
          i3 = m;
          localObject3 = localObject2;
          i5 = i;
          break;
        case 5: 
          i2 = paramByteBuffer.getInt();
          l2 = l1;
          i3 = m;
          i4 = k;
          localObject3 = localObject2;
          i5 = i;
          break;
        case 4: 
          int i8 = i3 / 8;
          localObject4 = new long[i8];
          int i6 = 0;
          for (;;)
          {
            l2 = l1;
            i2 = i1;
            i3 = m;
            i4 = k;
            localObject3 = localObject2;
            localObject1 = localObject4;
            i5 = i;
            if (i6 >= i8) {
              break;
            }
            localObject4[i6] = paramByteBuffer.getLong();
            i6 += 1;
          }
        case 3: 
          i3 = paramByteBuffer.getInt();
          l2 = l1;
          i2 = i1;
          i4 = k;
          localObject3 = localObject2;
          i5 = i;
          break;
        case 2: 
          i5 = paramByteBuffer.getInt();
          l2 = l1;
          i2 = i1;
          i3 = m;
          i4 = k;
          localObject3 = localObject2;
          break;
        case 1: 
          l2 = VideoPackageUtils.a(paramByteBuffer.getInt());
          i5 = i;
          localObject3 = localObject2;
          i4 = k;
          i3 = m;
          i2 = i1;
        }
        n += 1;
        l1 = l2;
        i1 = i2;
        m = i3;
        k = i4;
        localObject2 = localObject3;
        i = i5;
      }
      if (QQAudioHelper.f())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("onRecvMultiVideoS2C_0x95, index[");
        ((StringBuilder)localObject4).append(j);
        ((StringBuilder)localObject4).append("], GroupId[");
        ((StringBuilder)localObject4).append(l1);
        ((StringBuilder)localObject4).append("], roomUserNum[");
        ((StringBuilder)localObject4).append(i);
        ((StringBuilder)localObject4).append("], busitype[");
        ((StringBuilder)localObject4).append(m);
        ((StringBuilder)localObject4).append("], shortnum[");
        ((StringBuilder)localObject4).append(i1);
        ((StringBuilder)localObject4).append("], createtime[");
        ((StringBuilder)localObject4).append(k);
        ((StringBuilder)localObject4).append("], ppt[");
        localObject3 = "null";
        if (localObject2 == null)
        {
          localObject2 = "null";
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localObject2.length);
          localStringBuilder.append("|");
          if (localObject2.length == 0) {
            localObject2 = "";
          } else {
            localObject2 = Byte.valueOf(localObject2[0]);
          }
          localStringBuilder.append(localObject2);
          localObject2 = localStringBuilder.toString();
        }
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append("], uinList[");
        if (localObject1 == null) {
          localObject1 = localObject3;
        } else {
          localObject1 = Integer.valueOf(localObject1.length);
        }
        ((StringBuilder)localObject4).append(localObject1);
        ((StringBuilder)localObject4).append("]");
        QLog.w("QQGAudioMsgHandler", 1, ((StringBuilder)localObject4).toString());
      }
      localObject1 = this.b;
      long l2 = i;
      ((AVNotifyCenter)localObject1).a(11, 1, l1, null, l2);
      this.b.a(6, l1, 10, 0, 0, 21, i);
      this.b.a(21, 1, l1, 0L);
      j += 1;
    }
  }
  
  public static QQGAudioMsgHandler.SubCmd0x8DMsg j(byte[] paramArrayOfByte)
  {
    QQGAudioMsgHandler.SubCmd0x8DMsg localSubCmd0x8DMsg = new QQGAudioMsgHandler.SubCmd0x8DMsg();
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < 40) {
        return localSubCmd0x8DMsg;
      }
      int i = paramArrayOfByte.length;
      byte[] arrayOfByte1 = new byte[2];
      byte[] arrayOfByte2 = new byte[4];
      byte[] arrayOfByte3 = new byte[8];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 2);
      localSubCmd0x8DMsg.a = VideoPackageUtils.a(VideoPackageUtils.d(arrayOfByte1, 2));
      System.arraycopy(paramArrayOfByte, 2, arrayOfByte3, 0, 8);
      localSubCmd0x8DMsg.b = VideoPackageUtils.c(arrayOfByte3, 8);
      localSubCmd0x8DMsg.c = VideoPackageUtils.a(paramArrayOfByte[10]);
      int j = localSubCmd0x8DMsg.c + 11;
      System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
      localSubCmd0x8DMsg.d = VideoPackageUtils.a(VideoPackageUtils.b(arrayOfByte2, 4));
      j += 4;
      System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
      localSubCmd0x8DMsg.e = VideoPackageUtils.a(VideoPackageUtils.b(arrayOfByte2, 4));
      j += 4;
      System.arraycopy(paramArrayOfByte, j, arrayOfByte3, 0, 8);
      localSubCmd0x8DMsg.f = VideoPackageUtils.c(arrayOfByte3, 8);
      j += 8;
      System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
      localSubCmd0x8DMsg.g = VideoPackageUtils.b(arrayOfByte2, 4);
      j += 4;
      System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
      localSubCmd0x8DMsg.h = VideoPackageUtils.a(VideoPackageUtils.d(arrayOfByte1, 2));
      j += 2;
      localSubCmd0x8DMsg.i = VideoPackageUtils.a(paramArrayOfByte[j]);
      j += 1;
      System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
      localSubCmd0x8DMsg.j = VideoPackageUtils.a(arrayOfByte2, 4);
      j += localSubCmd0x8DMsg.i;
      System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
      localSubCmd0x8DMsg.k = VideoPackageUtils.a(VideoPackageUtils.d(arrayOfByte1, 2));
      j = j + 2 + localSubCmd0x8DMsg.k * 8;
      System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
      localSubCmd0x8DMsg.l = VideoPackageUtils.a(VideoPackageUtils.b(arrayOfByte2, 4));
      j += 4;
      System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
      localSubCmd0x8DMsg.m = VideoPackageUtils.a(VideoPackageUtils.d(arrayOfByte1, 2));
      j += 2;
      if ((localSubCmd0x8DMsg.m >= 16) && (localSubCmd0x8DMsg.m + j <= i))
      {
        System.arraycopy(paramArrayOfByte, j + 9, arrayOfByte1, 0, 2);
        i = 11 + VideoPackageUtils.a(VideoPackageUtils.d(arrayOfByte1, 2));
        if (localSubCmd0x8DMsg.h != 3)
        {
          localSubCmd0x8DMsg.n = VideoPackageUtils.a(paramArrayOfByte[(j + i)]);
          i += 1;
          if (i + 4 <= localSubCmd0x8DMsg.m)
          {
            System.arraycopy(paramArrayOfByte, j + i, arrayOfByte2, 0, 4);
            localSubCmd0x8DMsg.o = VideoPackageUtils.a(VideoPackageUtils.b(arrayOfByte2, 4));
          }
        }
      }
      i = localSubCmd0x8DMsg.m;
    }
    return localSubCmd0x8DMsg;
  }
  
  private void k(byte[] paramArrayOfByte)
  {
    Object localObject = new byte[1];
    int i = 0;
    System.arraycopy(paramArrayOfByte, 11, localObject, 0, 1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvRoomDestroy, cAuthType[");
      localStringBuilder.append(localObject[0]);
      localStringBuilder.append("]");
      QLog.w("QQGAudioMsgHandler", 1, localStringBuilder.toString());
    }
    if (localObject[0] != 3) {
      return;
    }
    localObject = BaseApplication.getContext();
    long l = this.b.g();
    int j = this.b.h();
    if (l > 0L) {
      i = this.b.e(l);
    }
    if ((j == 1) && (i == 2))
    {
      new GroupVideoWrapper(this.a).a(new QQGAudioMsgHandler.5(this, paramArrayOfByte));
      return;
    }
    new QavWrapper((Context)localObject).a(new QQGAudioMsgHandler.6(this, paramArrayOfByte));
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, long paramLong1, String paramString, int paramInt3, long paramLong2)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    int j = 0;
    while (i < paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, 8);
      paramInt1 += 8;
      long l = VideoPackageUtils.c(arrayOfByte, 8);
      paramArrayOfLong[i] = l;
      if ((l == paramLong1) && (this.b.g() == 0L) && (0L == this.b.c(paramInt3, paramLong2))) {
        j = 1;
      }
      i += 1;
    }
    if (j != 0)
    {
      paramArrayOfByte = Long.toString(paramLong2);
      if (paramInt3 == 2) {
        paramInt2 = 3000;
      } else {
        paramInt2 = 1;
      }
      VideoMsgTools.a(this.a, paramInt2, 13, false, paramArrayOfByte, paramString, true, null, true, new Object[0]);
    }
    return paramInt1;
  }
  
  public int a(byte[] paramArrayOfByte1, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    int[] arrayOfInt = new int[paramInt2];
    int i = 0;
    while (i < paramInt3)
    {
      System.arraycopy(paramArrayOfByte1, paramInt1, paramArrayOfByte2, 0, 2);
      int j = paramInt1 + 2;
      paramInt1 = (paramArrayOfByte2[0] & 0xFF) << 8 | (paramArrayOfByte2[1] & 0xFF) << 0;
      System.arraycopy(paramArrayOfByte1, j, paramArrayOfByte2, 0, 2);
      j += 2;
      int k = (paramArrayOfByte2[0] & 0xFF) << 8 | (paramArrayOfByte2[1] & 0xFF) << 0;
      if (paramInt1 != 8) {
        if (paramInt1 == 9) {}
      }
      for (;;)
      {
        paramInt1 = j + k;
        break;
        if (k != paramInt2)
        {
          paramInt1 = j;
        }
        else
        {
          System.arraycopy(paramArrayOfByte1, j, paramArrayOfByte2, 0, k);
          paramInt1 = 0;
          while (paramInt1 < k)
          {
            arrayOfInt[paramInt1] = paramArrayOfByte2[paramInt1];
            paramInt1 += 1;
          }
          continue;
          if (k != paramInt2)
          {
            paramInt1 = j;
          }
          else
          {
            System.arraycopy(paramArrayOfByte1, j, paramArrayOfByte2, 0, k);
            paramInt1 = 0;
            while (paramInt1 < k)
            {
              paramArrayOfInt[paramInt1] = paramArrayOfByte2[paramInt1];
              paramInt1 += 1;
            }
          }
        }
      }
      i += 1;
    }
    return paramInt1;
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    if (this.a != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoLevelUpgrade");
      localIntent.putExtra("type", paramInt1);
      localIntent.putExtra("fromUin", paramLong1);
      localIntent.putExtra("toUin", paramLong2);
      localIntent.putExtra("enable", paramInt2);
      localIntent.putExtra("level", paramInt3);
      localIntent.putExtra("seq", paramLong3);
      localIntent.putExtra("groupId", paramLong4);
      this.a.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    if (this.a != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoGift");
      localIntent.putExtra("type", paramInt1);
      localIntent.putExtra("fromUin", paramLong1);
      localIntent.putExtra("toUin", paramLong2);
      localIntent.putExtra("count", paramInt2);
      localIntent.putExtra("seq", paramLong3);
      localIntent.putExtra("groupId", paramLong4);
      this.a.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long[] paramArrayOfLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecvGroupVideoMemberNumber, relationType[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], relationId[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], memberNum[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], avtype[");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("], gameId[");
    localStringBuilder.append(paramInt5);
    localStringBuilder.append("], liveExtraMode[");
    localStringBuilder.append(paramInt6);
    localStringBuilder.append("],memberList[");
    localStringBuilder.append(Arrays.toString(paramArrayOfLong));
    localStringBuilder.append("]");
    QLog.w("QQGAudioMsgHandler", 1, localStringBuilder.toString());
    long l1;
    try
    {
      l1 = Long.parseLong(paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QQGAudioMsgHandler", 1, "onRecvGroupVideoMemberNumber", localException);
      l1 = 0L;
    }
    if (l1 == 0L) {
      return;
    }
    this.a.getAVNotifyCenter().a(paramString, paramInt3);
    if (paramInt3 == 14) {
      paramInt3 = 2;
    }
    int i;
    if (paramInt2 <= 0) {
      i = 23;
    } else {
      i = 21;
    }
    Object localObject = this.a.getAVNotifyCenter().f(l1);
    if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).c > 0) && (paramInt2 == 0)) {
      this.b.a(5, 1, l1, null, ((AVNotifyCenter.VideoRoomInfo)localObject).c);
    }
    this.a.getAVNotifyCenter().a(l1, paramInt3, paramInt2);
    this.a.getAVNotifyCenter().a(4, l1, paramInt3, paramInt4, paramInt5, paramInt6, i, paramInt2);
    long l2;
    if (paramInt2 == 0)
    {
      l2 = l1;
      paramArrayOfLong = this;
      paramArrayOfLong.a(l2, paramInt3);
      paramArrayOfLong.b.a(21, 1, l2, 0L);
    }
    else
    {
      l2 = l1;
      localObject = this;
      paramInt4 = paramInt3;
      ((QQGAudioMsgHandler)localObject).b.a(6, 1, l2, paramArrayOfLong, paramInt2);
      ((QQGAudioMsgHandler)localObject).b.c(10, l2, paramInt4);
      if ((paramInt4 == 2) && (paramInt1 == 1) && (((TroopVideoManager)((QQGAudioMsgHandler)localObject).a.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER)).a(paramString) == 1)) {
        ((QQGAudioMsgHandler)localObject).a.getAVNotifyCenter().b(l2, true);
      }
      ((QQGAudioMsgHandler)localObject).b.a(21, 1, l2, 0L);
    }
    paramArrayOfLong = this;
    if (paramArrayOfLong.a.getAVNotifyCenter().m(paramString) == 14) {
      return;
    }
    paramString = new Intent();
    paramString.setAction("tencent.video.q2v.membersChange");
    paramString.putExtra("relationType", 1);
    paramString.putExtra("avtype", paramInt3);
    paramString.putExtra("relationId", l1);
    if (paramInt2 == 0) {
      paramString.putExtra("Exit", true);
    } else {
      paramString.putExtra("Exit", false);
    }
    paramArrayOfLong.a.getApp().sendBroadcast(paramString);
  }
  
  void a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showDevNotSurportMsg-->MsgType");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQGAudioMsgHandler", 2, ((StringBuilder)localObject).toString());
    }
    long l;
    if (paramInt == 141)
    {
      paramInt = paramArrayOfByte[10];
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, (paramInt & 0xFF) + 34, localObject, 0, 4);
      l = VideoPackageUtils.a((byte[])localObject, 4);
      paramArrayOfByte = this.a.getCurrentAccountUin();
      VideoMsgTools.a(this.a, 3000, 18, false, String.valueOf(l), paramArrayOfByte, false, null, false, new Object[0]);
      return;
    }
    if (paramInt == 7)
    {
      paramInt = (paramArrayOfByte[10] & 0xFF) + 19;
      localObject = new byte[8];
      System.arraycopy(paramArrayOfByte, paramInt, localObject, 0, 8);
      VideoPackageUtils.c((byte[])localObject, 8);
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, paramInt + 12, localObject, 0, 4);
      l = VideoPackageUtils.a((byte[])localObject, 4);
      paramArrayOfByte = this.a.getCurrentAccountUin();
      VideoMsgTools.a(this.a, 1, 18, false, String.valueOf(l), paramArrayOfByte, false, null, false, new Object[0]);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.a != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoRankListUpdate");
      localIntent.putExtra("groupId", paramLong);
      this.a.getApp().sendBroadcast(localIntent);
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    Object localObject = this.b;
    if ((localObject != null) && (this.a != null))
    {
      if (((AVNotifyCenter)localObject).c(1, paramLong) > 0L)
      {
        this.b.a(3, 1, paramLong, null, 0L);
        localObject = this.a.getCurrentAccountUin();
        VideoMsgTools.a(this.a, 1, 14, false, String.valueOf(paramLong), (String)localObject, false, null, false, paramInt, new Object[0]);
        this.b.a(21, 1, paramLong, 0L);
      }
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          QLog.w("QQGAudioMsgHandler", 2, "MultiRoomMemberNum is 0");
        }
        this.b.a(23, 1, paramLong, 0L);
      }
      if (paramInt == 2) {
        this.b.b(paramLong, false);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQGAudioMsgHandler", 2, "onGroupChatRoomDestroy-->can not get mNotifycenter or mapp");
    }
  }
  
  void a(long paramLong, int paramInt, byte paramByte)
  {
    if (this.a == null) {
      return;
    }
    AVLog.printAllUserLog("QQGAudioMsgHandler", String.format("queryRoomMemberNum| discussId=%d, dataType= %d, wReserve=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Byte.valueOf(paramByte) }));
    byte[] arrayOfByte = new byte[33];
    arrayOfByte[0] = ((byte)0);
    arrayOfByte[1] = ((byte)48);
    long l = Long.valueOf(this.a.getCurrentAccountUin()).longValue();
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[(i + 2)] = ((byte)(int)(0xFF & l >> (7 - i) * 8));
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
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), VideoConfigServlet.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)462);
    localNewIntent.putExtra("selfuin", l);
    localNewIntent.putExtra("toUin", paramLong);
    localNewIntent.putExtra("vMsg", arrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    this.a.startServlet(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.a != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoMemRejectInvite");
      localIntent.putExtra("groupId", paramLong1);
      localIntent.putExtra("dealMemUin", paramLong2);
      localIntent.putExtra("invitedId", paramString);
      this.a.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.a != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.KickOutVisitor");
      localIntent.putExtra("groupId", paramLong);
      localIntent.putExtra("isAllVisitor", paramBoolean);
      this.a.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(String paramString)
  {
    if (this.a != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GVideoMedalChange");
      localIntent.putExtra("jsonString", paramString);
      this.a.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(submsgtype0xc1.MsgBody paramMsgBody)
  {
    Intent localIntent = new Intent("tencent.video.q2v.randomMultiOwnerOnlinePush").putExtra("group_id", paramMsgBody.uint64_groupid.get()).putExtra("member_num", paramMsgBody.uint32_member_num.get());
    if (TextUtils.isEmpty(paramMsgBody.string_data.get())) {
      paramMsgBody = "";
    } else {
      paramMsgBody = paramMsgBody.string_data.get();
    }
    paramMsgBody = localIntent.putExtra("string_data", paramMsgBody);
    this.a.getApp().sendBroadcast(paramMsgBody);
  }
  
  public void a(submsgtype0xcf.MsgBody paramMsgBody)
  {
    Intent localIntent = new Intent("tencent.video.q2v.random1V1OnlinePush").putExtra("rsptype", paramMsgBody.uint32_rsptype.get());
    if (TextUtils.isEmpty(paramMsgBody.string_rspbody.get())) {
      paramMsgBody = "";
    } else {
      paramMsgBody = paramMsgBody.string_rspbody.get();
    }
    paramMsgBody = localIntent.putExtra("rspbody", paramMsgBody);
    this.a.getApp().sendBroadcast(paramMsgBody);
  }
  
  public void a(submsgtype0xdb.MsgBody paramMsgBody)
  {
    Intent localIntent = new Intent("tencent.video.q2v.avreportOnlinePush").putExtra("rsptype", paramMsgBody.uint32_rsptype.get());
    if (TextUtils.isEmpty(paramMsgBody.string_rspbody.get())) {
      paramMsgBody = "";
    } else {
      paramMsgBody = paramMsgBody.string_rspbody.get();
    }
    paramMsgBody = localIntent.putExtra("rspbody", paramMsgBody);
    this.a.getApp().sendBroadcast(paramMsgBody);
  }
  
  public void a(SubMsgType0xe9.MsgBody paramMsgBody)
  {
    int i = paramMsgBody.uint32_business_type.get();
    Intent localIntent = new Intent();
    if (i == 3) {
      localIntent.setAction("tencent.peak.q2v.AudioTransPush");
    } else {
      localIntent.setAction("tencent.video.q2v.AudioTransPush");
    }
    localIntent.putExtra("rsptype", paramMsgBody.uint32_business_type.get());
    localIntent.putExtra("rspbody", paramMsgBody.bytes_business.get().toByteArray());
    this.a.getApp().sendBroadcast(localIntent);
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
    if (!a())
    {
      if ((141 == i) || (7 == i)) {
        a(i, paramArrayOfByte);
      }
      return;
    }
    if (i != 7)
    {
      if (i != 59)
      {
        if (i != 141)
        {
          if (i != 149)
          {
            if (i != 195) {
              return;
            }
            a(paramArrayOfByte, 27);
            return;
          }
          e(paramArrayOfByte);
          return;
        }
        arrayOfByte = this.c;
        if (arrayOfByte == null) {
          return;
        }
        i = paramArrayOfByte.length;
        if (i < 40) {
          return;
        }
        if (arrayOfByte.length < i) {
          this.c = new byte[i];
        }
        System.arraycopy(paramArrayOfByte, 0, this.c, 0, i);
        f(this.c);
        return;
      }
      k(paramArrayOfByte);
      return;
    }
    arrayOfByte = this.c;
    if (arrayOfByte == null) {
      return;
    }
    i = paramArrayOfByte.length;
    if (i < 40) {
      return;
    }
    if (arrayOfByte.length < i) {
      this.c = new byte[i];
    }
    System.arraycopy(paramArrayOfByte, 0, this.c, 0, i);
    g(paramArrayOfByte);
  }
  
  void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, String.format("sendRoomInfoBroadcast, type[%s]", new Object[] { Integer.valueOf(paramInt) }));
    }
    Intent localIntent = new Intent("tencent.video.q2v.MultiVideo");
    String str = this.a.getCurrentAccountUin();
    localIntent.putExtra("type", paramInt);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("buffer", paramArrayOfByte);
    this.a.getApp().sendBroadcast(localIntent);
  }
  
  public void a(byte[] paramArrayOfByte, msg_comm.Msg paramMsg)
  {
    if (!a()) {
      return;
    }
    Object localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, 2);
    int i = VideoPackageUtils.a(VideoPackageUtils.d((byte[])localObject, 2));
    long l1;
    int j;
    long l2;
    if (i == 141)
    {
      QQGAudioMsgHandler.SubCmd0x8DMsg localSubCmd0x8DMsg = j(paramArrayOfByte);
      i = localSubCmd0x8DMsg.h;
      long l4 = localSubCmd0x8DMsg.f;
      l1 = localSubCmd0x8DMsg.j;
      j = localSubCmd0x8DMsg.g;
      l2 = localSubCmd0x8DMsg.l;
      long l3 = localSubCmd0x8DMsg.o;
      String str = Long.toString(l1);
      localObject = Long.toString(l4);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("GAudioOfflineMsg relationShip[");
        localStringBuilder.append(i);
        localStringBuilder.append("], groupUin[");
        localStringBuilder.append(str);
        localStringBuilder.append("], inviteUin[");
        localStringBuilder.append(l4);
        localStringBuilder.append("], subCmd0x8DMsg[");
        localStringBuilder.append(localSubCmd0x8DMsg);
        localStringBuilder.append("]");
        QLog.d("QQGAudioMsgHandler", 2, localStringBuilder.toString());
      }
      if (1 == i)
      {
        VideoMsgTools.a(this.a, 1, 13, false, str, (String)localObject, false, null, false, j, new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
        this.b.a(l1, 1, 10, true);
        return;
      }
      if (3 == i)
      {
        if (!this.a.getCurrentAccountUin().equals(localObject)) {
          paramArrayOfByte = (byte[])localObject;
        } else {
          paramArrayOfByte = str;
        }
        if (TextUtils.isEmpty(paramArrayOfByte))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, "GAudioOfflineMsg friendUin is empty!");
          }
          return;
        }
        if (paramMsg != null) {
          l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        } else {
          l1 = 0L;
        }
        if ((l1 > 0L) && (l1 - NetConnInfoCenter.getServerTime() - 60000L > 0L)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          VideoMsgTools.a(this.a, 0, 6, true, paramArrayOfByte, (String)localObject, false, null, false, new Object[] { paramMsg });
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("GAudioOfflineMsg double meeting friendUin is:");
          ((StringBuilder)localObject).append(paramArrayOfByte);
          QLog.d("QQGAudioMsgHandler", 2, ((StringBuilder)localObject).toString());
        }
        if (l1 == 0L) {
          l1 = MessageCache.c();
        }
        localObject = f;
        if ((localObject != null) && (this.h != null))
        {
          ((ArrayList)localObject).add(new QQGAudioMsgHandler.DoubleMeetingMsgWapper(paramMsg, Long.valueOf(paramArrayOfByte).longValue(), l1));
          a(Long.valueOf(paramArrayOfByte).longValue(), 4, (byte)8);
          this.h.sendEmptyMessageDelayed(1, 10000L);
        }
        return;
      }
      paramMsg = (QCallFacade)this.a.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if ((this.a.getCurrentAccountUin() != null) && (this.a.getCurrentAccountUin().equals(localObject))) {
        paramMsg.a(1, l1, (String)localObject);
      } else if (this.b.c(2, l1) <= 0L) {
        paramMsg.a(3000, str, (String)localObject);
      }
      this.b.a(l1, 2, 0, true);
      VideoMsgTools.a(this.a, 3000, 13, false, str, (String)localObject, false, null, false, new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
      if (this.d)
      {
        h(paramArrayOfByte);
        return;
      }
      paramMsg = this.e;
      if (paramMsg != null) {
        paramMsg.add(paramArrayOfByte);
      }
    }
    else if (i == 7)
    {
      i = (paramArrayOfByte[10] & 0xFF) + 19;
      paramMsg = new byte[8];
      System.arraycopy(paramArrayOfByte, i, paramMsg, 0, 8);
      l1 = VideoPackageUtils.c(paramMsg, 8);
      i += 8;
      paramMsg = new byte[4];
      System.arraycopy(paramArrayOfByte, i, paramMsg, 0, 4);
      j = VideoPackageUtils.b(paramMsg, 4);
      paramMsg = new byte[4];
      System.arraycopy(paramArrayOfByte, i + 4, paramMsg, 0, 4);
      l2 = VideoPackageUtils.c(paramMsg, 4);
      VideoMsgTools.a(this.a, 1, 13, true, Long.toString(l2), Long.toString(l1), false, null, false, j, new Object[0]);
      this.b.c(11, l2, j);
      ((TroopVideoManager)this.a.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER)).a(l2);
      this.b.a(l2, 1, 2, true);
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
  
  public void b()
  {
    this.d = false;
    Object localObject = this.e;
    if (localObject != null) {
      ((Vector)localObject).clear();
    }
    localObject = f;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      f.clear();
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is clear in clearOnLineQueue");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is empty!");
    }
  }
  
  void b(long paramLong)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (this.a == null) {
        return;
      }
      long l = ((AVNotifyCenter)localObject).c(2, paramLong);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMultiRoomDestroy, discussId[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], roomMemberNum[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("QQGAudioMsgHandler", 1, ((StringBuilder)localObject).toString());
      if (l > 0L)
      {
        this.b.a(4, 2, paramLong, null, 0L);
        localObject = this.a.getCurrentAccountUin();
        this.b.a(21, 2, paramLong, 0L);
        ((DiscussionHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(paramLong);
        VideoMsgTools.a(this.a, 3000, 14, false, String.valueOf(paramLong), (String)localObject, false, null, false, new Object[0]);
      }
    }
  }
  
  public void b(long paramLong1, long paramLong2, String paramString)
  {
    if (this.a != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoMemUntInvite");
      localIntent.putExtra("groupId", paramLong1);
      localIntent.putExtra("dealMemUin", paramLong2);
      localIntent.putExtra("invitedId", paramString);
      this.a.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.a != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.ChangeVisitorSpeakMode");
      localIntent.putExtra("groupId", paramLong);
      localIntent.putExtra("visitorSpeakEnabled", paramBoolean);
      this.a.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    Object localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, 2);
    if (((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0) == 49) {
      d(paramArrayOfByte);
    }
    if (this.a != null)
    {
      localObject = new Intent("tencent.video.q2v.MultiVideo");
      this.a.getCurrentAccountUin();
      ((Intent)localObject).putExtra("type", 30);
      ((Intent)localObject).putExtra("buffer", paramArrayOfByte);
      this.a.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
      if (localObject1 != null) {
        Long.valueOf((String)localObject1).longValue();
      }
    }
    localObject1 = new byte[2];
    System.arraycopy(paramArrayOfByte, 8, localObject1, 0, 2);
    int n = (localObject1[0] & 0xFF) << 8 | (localObject1[1] & 0xFF) << 0;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onRecvMultiVideoC2SACK_0x31-retCode->tlvNum=");
      ((StringBuilder)localObject2).append(n);
      QLog.d("QQGAudioMsgHandler", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new byte[4];
    byte[] arrayOfByte = new byte[8];
    int k = 0;
    int i = 10;
    while (k < n)
    {
      System.arraycopy(paramArrayOfByte, i, localObject1, 0, 2);
      i += 2;
      int m;
      switch ((localObject1[0] & 0xFF) << 8 | (localObject1[1] & 0xFF) << 0)
      {
      default: 
        break;
      case 10: 
        System.arraycopy(paramArrayOfByte, i, localObject1, 0, 2);
        j = i + 2;
        int i1 = ((localObject1[0] & 0xFF) << 8 | (localObject1[1] & 0xFF) << 0) / 8;
        Object localObject3 = new long[i1];
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onRecvMultiVideoC2SACK_0x31-retCode->userNum=");
          ((StringBuilder)localObject3).append(i1);
          QLog.d("QQGAudioMsgHandler", 2, ((StringBuilder)localObject3).toString());
        }
        m = 0;
        for (;;)
        {
          i = j;
          if (m >= i1) {
            break;
          }
          System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, 8);
          j += 8;
          VideoPackageUtils.c(arrayOfByte, 8);
          m += 1;
        }
      case 8: 
        System.arraycopy(paramArrayOfByte, i, localObject1, 0, 2);
        j = i + 2;
        i = (localObject1[0] & 0xFF) << 8;
        m = localObject1[1];
        break;
      case 4: 
        i += 10;
        break;
      case 3: 
        System.arraycopy(paramArrayOfByte, i, localObject1, 0, 2);
        j = i + 2;
        i = (localObject1[0] & 0xFF) << 8;
        m = localObject1[1];
        i = j + (i | (m & 0xFF) << 0);
        break;
      case 2: 
      case 5: 
      case 6: 
      case 7: 
      case 9: 
        i += 6;
        break;
      }
      i += 2;
      System.arraycopy(paramArrayOfByte, i, localObject2, 0, 4);
      i += 4;
      VideoPackageUtils.c((byte[])localObject2, 4);
      k += 1;
    }
    System.arraycopy(paramArrayOfByte, i, localObject1, 0, 2);
    int j = localObject1[0];
    j = (localObject1[1] & 0xFF) << 0 | (j & 0xFF) << 8;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onRecvMultiVideoC2SACK_0x31-retCode->wReverseLen=");
      ((StringBuilder)localObject1).append(j);
      QLog.d("QQGAudioMsgHandler", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new byte[j];
    System.arraycopy(paramArrayOfByte, i + 2, localObject1, 0, j);
    long l = VideoPackageUtils.c((byte[])localObject1, j);
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onRecvMultiVideoC2SACK_0x31-retCode->uin=");
      paramArrayOfByte.append(l);
      QLog.d("QQGAudioMsgHandler", 2, paramArrayOfByte.toString());
    }
    a(paramInt, l);
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    AVLog.printAllUserLog("QQGAudioMsgHandler", "onRecvAppTipMsgData.");
    if (!a()) {
      return;
    }
    byte[] arrayOfByte1 = new byte[2];
    Object localObject = new byte[4];
    byte[] arrayOfByte2 = new byte[8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 2);
    int m = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
    if (m < 4) {
      return;
    }
    long[] arrayOfLong = null;
    int n = 0;
    int i = 0;
    int j = 0;
    int k = 2;
    long l1 = 0L;
    while (n < m)
    {
      System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, 2);
      k += 2;
      int i1 = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
      if (i1 != 1)
      {
        if (i1 != 2) {
          if (i1 != 3) {
            if (i1 != 4) {
              break label403;
            }
          }
        }
        for (;;)
        {
          System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, 2);
          k += 2;
          j = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
          if (j <= 0) {
            return;
          }
          i1 = j / 8;
          arrayOfLong = new long[i1];
          j = 0;
          while (j < i1)
          {
            System.arraycopy(paramArrayOfByte, k, arrayOfByte2, 0, 8);
            k += 8;
            arrayOfLong[j] = VideoPackageUtils.c(arrayOfByte2, 8);
            j += 1;
          }
          j = i1;
          continue;
          k += 6;
          continue;
          i = k + 2;
          System.arraycopy(paramArrayOfByte, i, localObject, 0, 4);
          k = i + 4;
          i = VideoPackageUtils.b((byte[])localObject, 4);
          if (i == 0)
          {
            b(l1);
            paramArrayOfByte = new Intent();
            paramArrayOfByte.setAction("tencent.video.q2v.membersChange");
            paramArrayOfByte.putExtra("relationType", 2);
            paramArrayOfByte.putExtra("relationId", l1);
            paramArrayOfByte.putExtra("Exit", true);
            this.a.getApp().sendBroadcast(paramArrayOfByte);
            return;
          }
        }
      }
      else
      {
        k += 2;
        System.arraycopy(paramArrayOfByte, k, localObject, 0, 4);
        k += 4;
        l1 = VideoPackageUtils.c((byte[])localObject, 4);
      }
      label403:
      n += 1;
    }
    System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, 2);
    m = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TLV-NUMBER = ");
      ((StringBuilder)localObject).append(m);
      QLog.d("QQGAudioMsgHandler", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new int[j];
    a(paramArrayOfByte, k + 2, (int[])localObject, j, m, arrayOfByte1);
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("onRecvAppTipMsgData, roomUserNum[");
    paramArrayOfByte.append(i);
    paramArrayOfByte.append("], qqUserLen[");
    paramArrayOfByte.append(j);
    paramArrayOfByte.append("]");
    QLog.w("QQGAudioMsgHandler", 1, paramArrayOfByte.toString());
    if (this.b == null) {
      return;
    }
    long l2 = Long.valueOf(this.a.getCurrentAccountUin()).longValue();
    if (i == 1)
    {
      paramArrayOfByte = arrayOfLong;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 1) && (l2 == paramArrayOfByte[0]) && (this.b.g() == 0L))
      {
        if (this.b.c(2, l1) == 0L) {
          a(l1, 1, (byte)1);
        }
        return;
      }
    }
    this.b.a(2, l1, arrayOfLong, (int[])localObject, i);
    this.b.a(21, 2, l1, 0L);
    paramArrayOfByte = new Intent();
    paramArrayOfByte.setAction("tencent.video.q2v.membersChange");
    paramArrayOfByte.putExtra("relationType", 2);
    paramArrayOfByte.putExtra("relationId", l1);
    paramArrayOfByte.putExtra("Exit", false);
    this.a.getApp().sendBroadcast(paramArrayOfByte);
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    AVLog.printAllUserLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31.");
    if (this.b == null) {
      return;
    }
    Object localObject1 = this.a;
    long l1;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
      if (localObject1 != null)
      {
        l1 = Long.valueOf((String)localObject1).longValue();
        localObject4 = localObject1;
      }
      else
      {
        l1 = 0L;
        localObject4 = localObject1;
      }
    }
    else
    {
      l1 = 0L;
      localObject4 = null;
    }
    Object localObject2 = new byte[2];
    localObject1 = new byte[4];
    System.arraycopy(paramArrayOfByte, 2, localObject1, 0, 4);
    int i = VideoPackageUtils.b((byte[])localObject1, 4);
    if (i != 0)
    {
      localObject1 = new byte[2];
      System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 2, localObject1, 0, 2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onRecvMultiVideoC2SACK_0x31| retCode wR0=");
      ((StringBuilder)localObject2).append(localObject1[0]);
      ((StringBuilder)localObject2).append(" wR1=");
      ((StringBuilder)localObject2).append(localObject1[1]);
      AVLog.printAllUserLog("QQGAudioMsgHandler", ((StringBuilder)localObject2).toString());
      if (localObject1[0] == 3)
      {
        b(paramArrayOfByte, i);
        return;
      }
      AVLog.printErrorLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31|wrong retCode.");
      return;
    }
    Object localObject3 = new byte[2];
    System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 2, localObject3, 0, 2);
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("onRecvMultiVideoC2SACK_0x31| relation type wR0=");
    ((StringBuilder)localObject5).append(localObject3[0]);
    ((StringBuilder)localObject5).append(" wR1=");
    ((StringBuilder)localObject5).append(localObject3[1]);
    AVLog.printAllUserLog("QQGAudioMsgHandler", ((StringBuilder)localObject5).toString());
    if (localObject3[0] == 1)
    {
      i = 1;
    }
    else
    {
      if (localObject3[0] == 2) {}
      for (;;)
      {
        i = 2;
        break;
        if (localObject3[0] == 3)
        {
          b(paramArrayOfByte, i);
          return;
        }
        AVLog.printErrorLog("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31|wrong relation type.");
      }
    }
    System.arraycopy(paramArrayOfByte, 8, localObject2, 0, 2);
    int k = (localObject2[0] & 0xFF) << 8 | (localObject2[1] & 0xFF) << 0;
    localObject3 = null;
    int n = 10;
    int m = 0;
    long l2 = 0L;
    int j = i;
    i = n;
    while (m < k)
    {
      System.arraycopy(paramArrayOfByte, i, localObject2, 0, 2);
      i += 2;
      n = localObject2[0];
      switch ((localObject2[1] & 0xFF) << 0 | (n & 0xFF) << 8)
      {
      default: 
        break;
      case 10: 
        System.arraycopy(paramArrayOfByte, i, localObject2, 0, 2);
        n = ((localObject2[0] & 0xFF) << 8 | (localObject2[1] & 0xFF) << 0) / 8;
        localObject3 = new long[n];
        i = a(paramArrayOfByte, i + 2, n, (long[])localObject3, l1, localObject4, j, l2);
        break;
      case 8: 
        localObject5 = localObject2;
        System.arraycopy(paramArrayOfByte, i, localObject5, 0, 2);
        i = i + 2 + ((localObject5[0] & 0xFF) << 8 | (localObject5[1] & 0xFF) << 0);
        break;
      case 5: 
      case 6: 
      case 7: 
      case 9: 
        i += 6;
        break;
      case 4: 
        i += 10;
        break;
      case 3: 
        localObject5 = localObject2;
        System.arraycopy(paramArrayOfByte, i, localObject5, 0, 2);
        i = i + 2 + ((localObject5[0] & 0xFF) << 8 | (localObject5[1] & 0xFF) << 0);
        break;
      case 2: 
        i += 6;
        break;
      }
      i += 2;
      System.arraycopy(paramArrayOfByte, i, localObject1, 0, 4);
      i += 4;
      l2 = VideoPackageUtils.c((byte[])localObject1, 4);
      m += 1;
    }
    if ((localObject3 != null) && (localObject3.length > 0))
    {
      this.b.a(j, l2, (long[])localObject3);
      this.b.a(21, j, l2, 0L);
      return;
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    AVLog.printAllUserLog("QQGAudioMsgHandler", "onRecvMultiVideoS2C_0x95.");
    if (!a()) {
      return;
    }
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.getShort();
    paramArrayOfByte.getLong();
    int i = paramArrayOfByte.getShort();
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
    this.d = true;
    paramArrayOfByte = this.e;
    if (paramArrayOfByte != null)
    {
      int j = paramArrayOfByte.size();
      if (j > 0)
      {
        i = 0;
        while (i < j)
        {
          h((byte[])this.e.elementAt(i));
          i += 1;
        }
      }
      this.e.clear();
    }
  }
  
  void f(byte[] paramArrayOfByte)
  {
    int i = (paramArrayOfByte[10] & 0xFF) + 19;
    Object localObject = new byte[8];
    System.arraycopy(paramArrayOfByte, i, localObject, 0, 8);
    long l1 = VideoPackageUtils.c((byte[])localObject, 8);
    int j = i + 8;
    localObject = new byte[4];
    System.arraycopy(paramArrayOfByte, j, localObject, 0, 4);
    i = VideoPackageUtils.b((byte[])localObject, 4);
    j += 4;
    localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, j, localObject, 0, 2);
    int k = (localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0;
    if ((k != 3) && (k != 2) && (k == 2) && (i != 10))
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("Current version is only surpport discussion and friend. RelationType=");
        paramArrayOfByte.append(k);
        QLog.d("QQGAudioMsgHandler", 2, paramArrayOfByte.toString());
      }
      return;
    }
    long l2;
    if (k == 2)
    {
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, j + 3, localObject, 0, 4);
      l2 = VideoPackageUtils.a((byte[])localObject, 4);
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onRecvMuitiInvite discussId is");
        paramArrayOfByte.append(l2);
        paramArrayOfByte.append("InviteUin:");
        paramArrayOfByte.append(l1);
        QLog.d("QQGAudioMsgHandler", 2, paramArrayOfByte.toString());
      }
      ((DiscussionHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b(l2);
      paramArrayOfByte = this.b;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(7, 2, l2, new long[] { l1 }, 1L);
      }
      paramArrayOfByte = Long.toString(l2);
      localObject = Long.toString(l1);
      ((QCallFacade)this.a.getManager(QQManagerFactory.RECENT_CALL_FACADE)).a(0, l2, (String)localObject, "");
      if (!this.a.getAVNotifyCenter().c()) {
        VideoMsgTools.a(this.a, 3000, 13, false, paramArrayOfByte, (String)localObject, false, null, true, new Object[0]);
      }
    }
    else if ((k == 1) && (i == 10))
    {
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, j + 3, localObject, 0, 4);
      l2 = VideoPackageUtils.a((byte[])localObject, 4);
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onRecvMuitiInvite, groupUin[");
        paramArrayOfByte.append(l2);
        paramArrayOfByte.append("], InviteUin[");
        paramArrayOfByte.append(l1);
        paramArrayOfByte.append("]");
        QLog.w("QQGAudioMsgHandler", 1, paramArrayOfByte.toString());
      }
      paramArrayOfByte = this.b;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.c(1, l2) == 0L))
      {
        this.b.a(5, l2, 10, 0, 0, 20, 1);
        this.b.a(8, 1, l2, new long[] { l1 }, 1L);
        this.b.a(21, 1, Long.valueOf(l2).longValue(), 0L);
      }
      VideoMsgTools.a(this.a, 1, 13, false, Long.toString(l2), Long.toString(l1), false, null, false, i, new Object[0]);
    }
    if ((k == 1) && (i == 2))
    {
      new GroupVideoWrapper(this.a).a(new QQGAudioMsgHandler.2(this));
      return;
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
    long l1 = VideoPackageUtils.c(arrayOfByte, 8);
    i += 8;
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, 4);
    int j = VideoPackageUtils.b(arrayOfByte, 4);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, i + 4, arrayOfByte, 0, 4);
    long l2 = VideoPackageUtils.c(arrayOfByte, 4);
    GVideoGrayConfig.a().a(this.a, String.valueOf(l2), new QQGAudioMsgHandler.4(this, l2, j, l1));
  }
  
  void h(byte[] paramArrayOfByte)
  {
    if (this.b != null)
    {
      if (this.a == null) {
        return;
      }
      int i = paramArrayOfByte[10];
      Object localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, (i & 0xFF) + 34, localObject, 0, 4);
      long l = VideoPackageUtils.a((byte[])localObject, 4);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dealGAudioOfflineMsg discussId is:");
      ((StringBuilder)localObject).append(l);
      QLog.d("QQGAudioMsgHandler", 1, ((StringBuilder)localObject).toString());
      if (this.b.c(2, l) > 0L)
      {
        ((DiscussionHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b(l);
        localObject = this.a.getCurrentAccountUin();
        Intent localIntent = new Intent("tencent.video.q2v.RecvMultiVideoCall");
        localIntent.putExtra("uin", (String)localObject);
        localIntent.putExtra("buffer", paramArrayOfByte);
        this.a.getApp().sendBroadcast(localIntent);
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("dealGAudioOfflineMsg sendBroadcast discussId is:");
        paramArrayOfByte.append(l);
        QLog.d("QQGAudioMsgHandler", 1, paramArrayOfByte.toString());
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage != null) {
      if (f == null) {
        return true;
      }
    }
    try
    {
      if (paramMessage.what != 1) {
        return true;
      }
      if (f.isEmpty())
      {
        if (!QLog.isColorLevel()) {
          break label92;
        }
        QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is empty!");
        return true;
      }
      f.clear();
      if (!QLog.isColorLevel()) {
        break label86;
      }
      QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is clear after 10 seconds");
      return true;
    }
    catch (Exception paramMessage)
    {
      label71:
      break label71;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "handleMessage sDoubleMeetingMsg error!");
    }
    label86:
    return true;
    label92:
    return true;
  }
  
  public void i(byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent("tencent.video.q2v.VisitorSendGift");
    localIntent.putExtra("data", paramArrayOfByte);
    this.a.getApp().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler
 * JD-Core Version:    0.7.0.1
 */