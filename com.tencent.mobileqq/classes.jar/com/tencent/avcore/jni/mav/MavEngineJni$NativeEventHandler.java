package com.tencent.avcore.jni.mav;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.avcore.jni.data.AVUserInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mwf;
import mwm;
import mwn;
import mwv;
import mwx;
import mxb;

class MavEngineJni$NativeEventHandler
  extends Handler
{
  private static final String TAG = "MavEngineJni_NativeEvent";
  protected final WeakReference<mwx> mCallback;
  protected final WeakReference<mwm> mEventLisRef;
  final MavEngineJni.NativeEventHandler.EventCountLog mEventLogForFrameDec = new MavEngineJni.NativeEventHandler.EventCountLog(String.valueOf(61), 10000L);
  private final mwf mShareRecordParam = new mwf();
  
  MavEngineJni$NativeEventHandler(Looper paramLooper, mwm parammwm, mwx parammwx)
  {
    super(paramLooper);
    this.mEventLisRef = new WeakReference(parammwm);
    this.mCallback = new WeakReference(parammwx);
  }
  
  private void onChatMemberInfoChange(mwm parammwm, int paramInt1, byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 8)) {}
    do
    {
      return;
      paramArrayOfByte = mxb.a(paramArrayOfByte);
      if (paramArrayOfByte != null) {
        break;
      }
    } while (!mwv.c());
    mwv.c("MavEngineJni_NativeEvent", "handleMessage, fail, empty uinList");
    return;
    int j;
    if (mwv.c())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      j = paramArrayOfByte.length;
      i = 0;
      while (i < j)
      {
        long l = paramArrayOfByte[i];
        localStringBuilder.append("UserUin = ");
        localStringBuilder.append(l);
        localStringBuilder.append(", ");
        i += 1;
      }
      localStringBuilder.append("eventid = ");
      localStringBuilder.append(paramInt1);
      mwv.b("MavEngineJni_NativeEvent", localStringBuilder.toString());
    }
    int i = 0;
    if (paramInt1 == 42)
    {
      j = (int)paramLong1;
      if (j <= 100) {
        break label172;
      }
      i = 100;
    }
    for (;;)
    {
      parammwm.a(paramLong2, paramArrayOfByte, paramInt1, paramInt3, paramLong1, paramInt2, i);
      return;
      label172:
      i = j;
      if (j < 0) {
        i = 0;
      }
    }
  }
  
  private void onRecPushEncParam(mwm parammwm, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (mwv.b()) {
      mwv.a("MavEngineJni_NativeEvent", "onRecPushEncParam, relationType[" + paramInt1 + "], relationId[" + paramLong1 + "], lValue[" + paramLong2 + "], flag[" + paramInt2 + "]");
    }
    int i = this.mShareRecordParam.jdField_a_of_type_Int;
    int j = this.mShareRecordParam.jdField_b_of_type_Int;
    int k = this.mShareRecordParam.jdField_c_of_type_Int;
    int m = (int)(paramLong2 & 0xFFFFFFFF);
    int n = (int)(paramLong2 >> 32 & 0xFFFFFFFF);
    this.mShareRecordParam.jdField_a_of_type_Int = n;
    this.mShareRecordParam.jdField_b_of_type_Int = m;
    this.mShareRecordParam.jdField_c_of_type_Int = paramInt2;
    parammwm.a(paramInt1, paramLong1, this.mShareRecordParam);
    if ((mwv.c()) && ((i != this.mShareRecordParam.jdField_a_of_type_Int) || (j != this.mShareRecordParam.jdField_b_of_type_Int) || (k != this.mShareRecordParam.jdField_c_of_type_Int))) {
      mwv.b("AVShare", "onRecPushEncParam, relationType[" + paramInt1 + "], groupId[" + paramLong1 + "], param[" + this.mShareRecordParam + "]");
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    Object localObject1;
    mwm localmwm;
    do
    {
      do
      {
        return;
        localObject1 = (mwn)paramMessage.obj;
        if (localObject1 != null) {
          break;
        }
      } while (!mwv.c());
      mwv.c("MavEngineJni_NativeEvent", "handleMessage-->NativeEventParams is null");
      return;
      localmwm = (mwm)this.mEventLisRef.get();
      if (localmwm != null) {
        break;
      }
      localObject1 = (mwx)this.mCallback.get();
    } while (localObject1 == null);
    ((mwx)localObject1).handleMessage(paramMessage);
    return;
    int i1 = paramMessage.what;
    byte[] arrayOfByte1 = ((mwn)localObject1).jdField_a_of_type_ArrayOfByte;
    long l3 = ((mwn)localObject1).jdField_a_of_type_Long;
    long l1 = ((mwn)localObject1).jdField_b_of_type_Long;
    int j = ((mwn)localObject1).jdField_a_of_type_Int;
    int n = ((mwn)localObject1).jdField_b_of_type_Int;
    int k = ((mwn)localObject1).jdField_c_of_type_Int;
    int i2 = ((mwn)localObject1).d;
    int m = ((mwn)localObject1).e;
    label152:
    Object localObject2;
    boolean bool1;
    if (i1 == 61)
    {
      this.mEventLogForFrameDec.log();
      localObject2 = (mwx)this.mCallback.get();
      if (localObject2 == null) {
        break label2885;
      }
      bool1 = ((mwx)localObject2).a(i1);
      if (bool1) {
        ((mwn)localObject1).jdField_c_of_type_Long = SystemClock.elapsedRealtime();
      }
    }
    for (;;)
    {
      switch (i1)
      {
      case 9: 
      case 10: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 40: 
      case 41: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
      case 60: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
      case 68: 
      case 69: 
      case 80: 
      case 81: 
      case 82: 
      case 83: 
      case 99: 
      case 100: 
      case 105: 
      case 106: 
      case 111: 
      case 112: 
      case 113: 
      case 114: 
      case 115: 
      case 116: 
      case 117: 
      case 118: 
      case 119: 
      case 120: 
      case 123: 
      case 124: 
      case 125: 
      case 126: 
      case 127: 
      case 128: 
      case 129: 
      case 130: 
      case 131: 
      case 132: 
      case 133: 
      case 134: 
      case 135: 
      case 136: 
      case 137: 
      case 146: 
      case 147: 
      case 148: 
      case 149: 
      case 150: 
      case 151: 
      case 152: 
      case 154: 
      case 155: 
      case 156: 
      case 159: 
      case 160: 
      case 161: 
      case 162: 
      case 163: 
      case 164: 
      case 165: 
      case 166: 
      case 167: 
      case 168: 
      case 169: 
      case 170: 
      case 173: 
      case 174: 
      case 175: 
      default: 
        if (localObject2 != null) {
          ((mwx)localObject2).handleMessage(paramMessage);
        }
        break;
      }
      label914:
      while ((bool1) && (localObject2 != null))
      {
        ((mwx)localObject2).handleMessage(paramMessage);
        return;
        if ((i1 == 43) || (!mwv.c())) {
          break label152;
        }
        localObject2 = new StringBuilder().append("handleMessage, groupId[").append(l1).append("], multiAVType[").append(j).append("], multiSubType[").append(n).append("], relationType[").append(k).append("], info[").append(l3).append("], detail[");
        if (arrayOfByte1 != null) {}
        for (int i = arrayOfByte1.length;; i = -1)
        {
          mwv.b("MavEngineJni_NativeEvent", i + "], eventId[" + i1 + "], buflen[" + i2 + "], flag[" + m + "]");
          break;
        }
        localObject1 = mxb.a(arrayOfByte1);
        if ((k == 2) || (k == 1))
        {
          if (localObject1 == null) {}
          for (i = 0;; i = localObject1.length)
          {
            onRecvUserList(localmwm, 6, k, l1, (long[])localObject1, l3, j, n, i, m);
            break;
          }
        }
        if (k == 3)
        {
          onRecvDoubleVideoMeeting(localmwm, i1, k, l3, j, n);
          continue;
          localObject1 = mxb.a(arrayOfByte1);
          if (localObject1 == null) {}
          for (i = 0;; i = localObject1.length)
          {
            onRecvUserList(localmwm, 44, k, l1, (long[])localObject1, 0L, j, 0, i, m);
            break;
          }
          m = (int)l3;
          if (m >= 0)
          {
            localObject1 = null;
            if (m > 0) {
              if (arrayOfByte1 == null) {
                break label1267;
              }
            }
            label1267:
            for (i = arrayOfByte1.length / m;; i = 0)
            {
              localObject1 = mxb.a(arrayOfByte1, i);
              if (localObject1 == null) {
                break label1272;
              }
              onRecvUserList(localmwm, 44, k, l1, (ArrayList)localObject1, 0L, 0, j, m);
              break;
            }
            label1272:
            onRecvUserListFail(localmwm, k, l1, -99L);
          }
          else
          {
            onRecvUserListFail(localmwm, k, l1, m);
            continue;
            if (arrayOfByte1 == null) {
              break;
            }
            localObject1 = mxb.a(arrayOfByte1, i2);
            if (localObject1 == null)
            {
              if (!mwv.c()) {
                break;
              }
              mwv.b("MavEngineJni_NativeEvent", "handleMessage, fail, empty userInfo");
              return;
            }
            if ((((AVUserInfo)localObject1).accountType == 0) || ((((AVUserInfo)localObject1).accountType == 1) && (((AVUserInfo)localObject1).pstnStatus == 3) && (i1 == 70)) || ((((AVUserInfo)localObject1).accountType == 1) && (i1 == 71)))
            {
              localmwm.a((AVUserInfo)localObject1, l1, i1, k, l3, new int[] { j });
              continue;
              onChatMemberInfoChange(localmwm, i1, arrayOfByte1, l3, l1, j, k);
              continue;
              localmwm.d(l1, k, i1);
              continue;
              if ((arrayOfByte1 == null) || (arrayOfByte1.length < 8)) {
                break;
              }
              if (k == 1)
              {
                long l2 = mxb.a(arrayOfByte1);
                if (j != 10)
                {
                  localmwm.a((int)l3, k, l2, l1);
                  continue;
                  if ((arrayOfByte1 == null) || (arrayOfByte1.length < 8)) {
                    break;
                  }
                  localmwm.a(l1, mxb.a(arrayOfByte1), k, (int)l3);
                  continue;
                  i = 0;
                  switch ((int)l3)
                  {
                  default: 
                    if ((l3 > 200L) && (l3 < 300L)) {
                      if (arrayOfByte1 == null)
                      {
                        localObject1 = "";
                        label1644:
                        localmwm.a(l1, l3, (String)localObject1);
                      }
                    }
                    break;
                  }
                  while (i != 0)
                  {
                    localmwm.b(k, l1, i, j);
                    break;
                    if (k == 1)
                    {
                      i = 1;
                      continue;
                      i = 2;
                      continue;
                      i = 7;
                      continue;
                      i = 35;
                      continue;
                      i = 42;
                      continue;
                      i = 43;
                      continue;
                      i = 3;
                      continue;
                      localObject1 = new String(arrayOfByte1);
                      break label1644;
                      i = (int)l3;
                    }
                  }
                  if ((((mwn)localObject1).jdField_a_of_type_ArrayOfByte == null) || (((mwn)localObject1).jdField_a_of_type_ArrayOfByte.length < 16)) {
                    break;
                  }
                  localObject1 = mxb.a(((mwn)localObject1).jdField_a_of_type_ArrayOfByte, ((mwn)localObject1).jdField_a_of_type_ArrayOfByte.length);
                  if (i1 == 140) {}
                  for (boolean bool2 = true; localObject1 != null; bool2 = false)
                  {
                    if (mwv.c()) {
                      mwv.c("MavEngineJni_NativeEvent", "MemberAudioChange, uin[" + ((AVUserInfo)localObject1).account + "], accountType[" + ((AVUserInfo)localObject1).accountType + "], isMicOff[" + bool2 + "]");
                    }
                    localmwm.a(((AVUserInfo)localObject1).account, ((AVUserInfo)localObject1).accountType, ((AVUserInfo)localObject1).pstnStatus, bool2);
                    break;
                  }
                  l2 = 0L;
                  l1 = l2;
                  if (((mwn)localObject1).jdField_a_of_type_ArrayOfByte != null)
                  {
                    l1 = l2;
                    if (((mwn)localObject1).jdField_a_of_type_ArrayOfByte.length == 8) {
                      l1 = mxb.a(((mwn)localObject1).jdField_a_of_type_ArrayOfByte);
                    }
                  }
                  if (l3 != 0L) {}
                  for (bool2 = true;; bool2 = false)
                  {
                    localmwm.a(l1, bool2, false);
                    break;
                  }
                  l2 = 0L;
                  i = (int)l3;
                  l1 = l2;
                  if (((mwn)localObject1).jdField_a_of_type_ArrayOfByte != null)
                  {
                    l1 = l2;
                    if (((mwn)localObject1).jdField_a_of_type_ArrayOfByte.length == 8) {
                      l1 = mxb.a(((mwn)localObject1).jdField_a_of_type_ArrayOfByte);
                    }
                  }
                  if (mwv.c()) {
                    mwv.b("MavEngineJni_NativeEvent", "SetMicByAdmin : uin = " + l1 + ", micAuthByAdmin = " + i);
                  }
                  localmwm.a(l1, i);
                  continue;
                  j = (int)l3;
                  if ((((mwn)localObject1).jdField_a_of_type_ArrayOfByte == null) || (j == 0)) {
                    break;
                  }
                  byte[] arrayOfByte2 = ((mwn)localObject1).jdField_a_of_type_ArrayOfByte;
                  if (((mwn)localObject1).jdField_a_of_type_ArrayOfByte != null) {}
                  for (i = arrayOfByte1.length / j;; i = 0)
                  {
                    localObject1 = mxb.a(arrayOfByte2, i);
                    if ((localObject1 == null) || (((ArrayList)localObject1).size() != j)) {
                      break;
                    }
                    localmwm.a(j, (ArrayList)localObject1);
                    break label914;
                  }
                  if ((((mwn)localObject1).jdField_a_of_type_ArrayOfByte == null) || (((mwn)localObject1).jdField_a_of_type_ArrayOfByte.length != 16)) {
                    break;
                  }
                  l1 = mxb.a(((mwn)localObject1).jdField_a_of_type_ArrayOfByte);
                  arrayOfByte1 = new byte[4];
                  System.arraycopy(((mwn)localObject1).jdField_a_of_type_ArrayOfByte, 12, arrayOfByte1, 0, 4);
                  i = mxb.a(arrayOfByte1);
                  if (l3 == 1L) {}
                  for (bool2 = true;; bool2 = false)
                  {
                    if (mwv.c()) {
                      mwv.b("MavEngineJni_NativeEvent", "onGAudioUserAudioSuspectNoisy : uin = " + l1 + ", isSuspectNoisy = " + bool2 + ",validDuration = " + i);
                    }
                    localmwm.a(l1, bool2, i);
                    break;
                  }
                  localmwm.e(k, l1, j);
                  continue;
                  localmwm.e(l1, k, j);
                  continue;
                  localmwm.a(k, l1, new int[] { j });
                  continue;
                  localmwm.b(k, l1);
                  continue;
                  localmwm.a(k, l1, 17, (int)((mwn)localObject1).jdField_a_of_type_Long);
                  continue;
                  localmwm.a(k, l1, 16, (int)((mwn)localObject1).jdField_a_of_type_Long);
                  continue;
                  localmwm.a(k, l1, 15, (int)((mwn)localObject1).jdField_a_of_type_Long);
                  continue;
                  localmwm.c(l1, k, j);
                  continue;
                  if (mwv.c()) {
                    mwv.b("MavEngineJni_NativeEvent", "EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA-->Uin=" + l3 + " ,VideoSrcType=" + k);
                  }
                  localmwm.b(61, l3, k);
                  continue;
                  localmwm.a(i1, l3, l1, k);
                  continue;
                  localmwm.b(i1, l3, l1, k);
                  continue;
                  localmwm.a(84, (int)l3, k, l1, j, n);
                  continue;
                  localmwm.a(85, (int)l3, k, l1, j, n);
                  continue;
                  localmwm.a(86, (int)l3, k, l1, j, n);
                  continue;
                  localmwm.a(87, (int)l3, k, l1, j, n);
                  continue;
                  localmwm.a(88, (int)l3, k, l1, j, n);
                  continue;
                  localmwm.a(89, (int)l3, k, l1, j, n);
                  continue;
                  localmwm.c(i1, l3, l1, k);
                  continue;
                  localmwm.h(3);
                  continue;
                  localmwm.h(4);
                  continue;
                  if (arrayOfByte1 == null) {}
                  for (localObject1 = "";; localObject1 = new String(arrayOfByte1))
                  {
                    localmwm.a(l1, k, j, (int)l3, (String)localObject1);
                    break;
                  }
                  if (arrayOfByte1 == null) {}
                  for (localObject1 = "";; localObject1 = new String(arrayOfByte1))
                  {
                    localmwm.b(l1, k, j, (int)l3, (String)localObject1);
                    break;
                  }
                  localmwm.x();
                  continue;
                  localmwm.y();
                  continue;
                  if (arrayOfByte1 != null)
                  {
                    localmwm.d(mxb.a(arrayOfByte1));
                    continue;
                    if (l3 != 0L)
                    {
                      localmwm.f((int)l3);
                      continue;
                      if (arrayOfByte1 != null)
                      {
                        localmwm.b(arrayOfByte1);
                        continue;
                        localmwm.e(l3);
                        continue;
                        onRecPushEncParam(localmwm, k, l1, l3, m);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label2885:
      bool1 = false;
    }
  }
  
  void onRecvDoubleVideoMeeting(mwm parammwm, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4)
  {
    if (parammwm == null) {
      if (mwv.c()) {
        mwv.c("MavEngineJni_NativeEvent", "onRecvDoubleVideoMeeting-->mVideoController is null");
      }
    }
    do
    {
      return;
      if (mwv.c()) {
        mwv.b("MavEngineJni_NativeEvent", "onRecvDoubleVideoMeeting-->eventId=" + paramInt1 + " ,relationType=" + paramInt2 + " ,inviteUin=" + paramLong + "], multiAVType[" + paramInt3 + "], multiSubType[" + paramInt4);
      }
      if (paramInt1 == 6)
      {
        parammwm.b(paramLong, paramInt3, paramInt4);
        return;
      }
    } while ((paramInt1 == 44) || (paramInt1 != 5));
    parammwm.b(paramLong, paramInt3, paramInt4);
  }
  
  void onRecvUserList(mwm parammwm, int paramInt1, int paramInt2, long paramLong1, ArrayList<AVUserInfo> paramArrayList, long paramLong2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (parammwm == null) {
      if (mwv.c()) {
        mwv.b("MavEngineJni_NativeEvent", "onRecvUserList --> mVideoController is null");
      }
    }
    do
    {
      return;
      if (mwv.c()) {
        mwv.b("MavEngineJni_NativeEvent", "onRecvUserList.GET_ROOM_INFO, evtId[" + paramInt1 + "], relationType[" + paramInt2 + "], relationId[" + paramLong1 + "], inviteUin[" + paramLong2 + "], multiAVType[" + paramInt4 + "], multiSubType[" + paramInt3 + "], userCount[" + paramInt5 + "]");
      }
      if (paramInt1 == 44)
      {
        parammwm.a(paramLong1, paramArrayList, paramInt4, paramInt5);
        return;
      }
    } while (!mwv.c());
    mwv.c("MavEngineJni_NativeEvent", "onRecvUserList --> WRONG EVTID. evtId = " + paramInt1);
  }
  
  void onRecvUserList(mwm parammwm, int paramInt1, int paramInt2, long paramLong1, long[] paramArrayOfLong, long paramLong2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (parammwm == null) {
      if (mwv.c()) {
        mwv.c("MavEngineJni_NativeEvent", "onRecvUserList-->mVideoController is null");
      }
    }
    label193:
    label199:
    do
    {
      return;
      int i = 0;
      if (paramArrayOfLong != null) {
        i = paramArrayOfLong.length;
      }
      StringBuilder localStringBuilder;
      if (mwv.c())
      {
        localStringBuilder = new StringBuilder().append("onRecvUserList, evtId[").append(paramInt1).append("], relationType[").append(paramInt2).append("], relationId[").append(paramLong1).append("], inviteUin[").append(paramLong2).append("], multiAVType[").append(paramInt3).append("], multiSubType[").append(paramInt4).append("], userListSize[").append(i).append("], userList[");
        if (paramArrayOfLong == null) {
          break label193;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        mwv.b("MavEngineJni_NativeEvent", bool + "], flag[" + paramInt6 + "]");
        if ((paramArrayOfLong == null) && (paramInt2 == 2)) {
          break;
        }
        if (paramInt1 != 44) {
          break label199;
        }
        parammwm.a(paramLong1, paramArrayOfLong, paramInt3, paramInt5);
        return;
      }
      if (paramInt1 == 6)
      {
        parammwm.a(paramInt2, paramLong1, paramLong2, paramArrayOfLong, false, paramInt3, paramInt4, paramInt6);
        return;
      }
    } while (paramInt1 != 5);
    parammwm.a(paramInt2, paramLong1, paramLong2, paramArrayOfLong, true, paramInt3, paramInt4, paramInt6);
  }
  
  void onRecvUserListFail(mwm parammwm, int paramInt, long paramLong1, long paramLong2)
  {
    mwv.c("MavEngineJni_NativeEvent", "onRecvUserListFail, relationType[" + paramInt + "], relationId[" + paramLong1 + "], errCode[" + paramLong2 + "]");
    parammwm.b(paramInt, paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avcore.jni.mav.MavEngineJni.NativeEventHandler
 * JD-Core Version:    0.7.0.1
 */