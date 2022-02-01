package com.tencent.avcore.jni.dav;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import mwi;
import mwk;
import mwv;
import mww;
import mwx;

class DavEngineJni$NativeEventHandler
  extends Handler
{
  private static final String TAG = "DAVEngineJni_NativeEvent";
  protected final WeakReference<mwx> mCallback;
  protected final WeakReference<mwk> mEventLisRef;
  
  DavEngineJni$NativeEventHandler(Looper paramLooper, mwk parammwk, mwx parammwx)
  {
    super(paramLooper);
    this.mEventLisRef = new WeakReference(parammwk);
    this.mCallback = new WeakReference(parammwx);
  }
  
  private void onReceiveRequest(int paramInt, mwi parammwi, mwk parammwk)
  {
    byte[] arrayOfByte1 = parammwi.jdField_a_of_type_ArrayOfByte;
    int i = (int)parammwi.c;
    String str1 = parammwi.jdField_a_of_type_JavaLangString;
    int j = parammwi.jdField_a_of_type_Int;
    int k = parammwi.jdField_b_of_type_Int;
    if (k == 3124) {
      i = 26;
    }
    String str2 = mww.a(parammwi.jdField_b_of_type_Long);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (i)
    {
    default: 
      localObject1 = localObject2;
    case 1: 
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    case 11: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 28: 
    case 0: 
    case 10: 
    case 12: 
    case 19: 
    case 27: 
    case 29: 
    case 4: 
    case 5: 
    case 24: 
    case 25: 
    case 26: 
      while ((paramInt == 2) || (paramInt == 60))
      {
        parammwk.a(i, str2, (String)localObject1, parammwi.jdField_b_of_type_ArrayOfByte, true, str1, j, k);
        label234:
        if (mwv.c()) {
          mwv.b("onReceiveRequest", "uinType = " + i + ", extraUin = " + (String)localObject1 + ", longFronUin = " + parammwi.jdField_b_of_type_Long);
        }
        return;
        localObject1 = null;
        continue;
        localObject1 = localObject2;
        if (arrayOfByte1 != null)
        {
          int m = arrayOfByte1[0];
          localObject1 = null;
          localObject2 = localObject1;
          if (arrayOfByte1.length > m + 1)
          {
            arrayOfByte2 = new byte[m];
            localObject2 = localObject1;
            if (arrayOfByte2 != null)
            {
              System.arraycopy(arrayOfByte1, 1, arrayOfByte2, 0, m);
              localObject2 = new String(arrayOfByte2);
            }
          }
          int n = arrayOfByte1[(m + 1)];
          if (arrayOfByte1.length <= m + n + 2) {
            break label552;
          }
          byte[] arrayOfByte2 = new byte[n];
          localObject1 = null;
          if (arrayOfByte2 != null)
          {
            System.arraycopy(arrayOfByte1, m + 2, arrayOfByte2, 0, n);
            localObject1 = new String(arrayOfByte2);
          }
          if ((localObject1 == null) || (localObject2 == null)) {
            break label549;
          }
          localObject1 = (String)localObject2 + (String)localObject1;
        }
      }
    }
    for (;;)
    {
      if (mwv.c()) {
        mwv.b("onReceiveRequest", "uinType = " + i + ", extraUin = " + (String)localObject1);
      }
      break;
      localObject1 = String.valueOf(parammwi.d);
      break;
      if ((paramInt != 1) && (paramInt != 61)) {
        break label234;
      }
      parammwk.a(i, str2, (String)localObject1, parammwi.jdField_b_of_type_ArrayOfByte, false, str1, j, k);
      break label234;
      label549:
      continue;
      label552:
      localObject1 = null;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    mwk localmwk = (mwk)this.mEventLisRef.get();
    if (localmwk == null) {
      return;
    }
    int i = paramMessage.what;
    Object localObject1 = (mwi)paramMessage.obj;
    if (localObject1 == null)
    {
      mwv.h("DAVEngineJni_NativeEvent", "p is null");
      return;
    }
    Object localObject2 = ((mwi)localObject1).jdField_a_of_type_ArrayOfByte;
    long l1 = ((mwi)localObject1).jdField_a_of_type_Long;
    String str = mww.a(((mwi)localObject1).jdField_b_of_type_Long);
    byte[] arrayOfByte = ((mwi)localObject1).jdField_b_of_type_ArrayOfByte;
    if ((i != 16) && (i != 100) && (i != 117) && (i != 120) && (i != 124) && (i != 125)) {
      mwv.g("DAVEngineJni_NativeEvent", "handleMessage eventId[" + i + "], info[" + l1 + "], fromUin[" + str + "]");
    }
    mwx localmwx = (mwx)this.mCallback.get();
    int j;
    if ((localmwx != null) && (localmwx.a(i)))
    {
      j = 1;
      label191:
      if (j != 0) {
        ((mwi)localObject1).f = SystemClock.elapsedRealtime();
      }
      switch (i)
      {
      case 5: 
      case 11: 
      case 12: 
      case 15: 
      case 17: 
      case 23: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
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
      case 70: 
      case 71: 
      case 77: 
      case 78: 
      case 79: 
      case 80: 
      case 81: 
      case 82: 
      case 84: 
      case 85: 
      case 86: 
      case 87: 
      case 88: 
      case 89: 
      case 90: 
      case 93: 
      case 94: 
      case 96: 
      case 97: 
      case 98: 
      case 99: 
      case 101: 
      case 102: 
      case 103: 
      case 104: 
      case 109: 
      case 111: 
      case 112: 
      case 115: 
      case 117: 
      case 120: 
      case 121: 
      case 122: 
      case 123: 
      default: 
        if (localmwx != null) {
          localmwx.handleMessage(paramMessage);
        }
        break;
      }
    }
    label738:
    while (j != 0)
    {
      localmwx.handleMessage(paramMessage);
      return;
      j = 0;
      break label191;
      onReceiveRequest(i, (mwi)localObject1, localmwk);
      continue;
      localmwk.d(str);
      continue;
      i = (int)l1;
      localObject2 = new StringBuilder().append("SdkEventId.EV_VOIP_CLOSED, Param0[").append(((mwi)localObject1).c).append("], Param1[").append(((mwi)localObject1).d).append("], Param2[").append(((mwi)localObject1).jdField_a_of_type_JavaLangString).append("], Param3[").append(((mwi)localObject1).jdField_a_of_type_Int).append("], Param4[").append(((mwi)localObject1).jdField_b_of_type_Int).append("], Param5[").append(((mwi)localObject1).e).append("], extraBuf[");
      if (((mwi)localObject1).jdField_b_of_type_ArrayOfByte != null) {}
      for (boolean bool = true;; bool = false)
      {
        mwv.c("DAVEngineJni_NativeEvent", bool + "], reason[" + i + "]");
        switch (i)
        {
        default: 
          localmwk.a(str, i, ((mwi)localObject1).c);
          break label738;
        }
      }
      localmwk.i(str);
      continue;
      i = (int)((mwi)localObject1).c;
      int k = (int)((mwi)localObject1).d;
      l1 = ((mwi)localObject1).e;
      if (((mwi)localObject1).jdField_b_of_type_ArrayOfByte != null) {}
      for (localObject1 = new String(((mwi)localObject1).jdField_b_of_type_ArrayOfByte);; localObject1 = "")
      {
        localmwk.a(str, i, k, (String)localObject1, l1);
        break;
      }
      if (l1 == 1L)
      {
        localmwk.a(str, arrayOfByte, 1L);
      }
      else
      {
        localmwk.a(str, (byte[])localObject2, 0L);
        continue;
        localmwk.b(((mwi)localObject1).c, 0L, 100L);
        continue;
        localmwk.a(str, 12, 0L);
        continue;
        localmwk.e(str);
        continue;
        localmwk.f(str);
        continue;
        localmwk.g(str);
        continue;
        localmwk.h(str);
        continue;
        localmwk.j(str);
        continue;
        localmwk.k(str);
        continue;
        localmwk.l(str);
        continue;
        localmwk.a(i - 19, str);
        continue;
        localmwk.a(str, true);
        continue;
        localmwk.a(str, false);
        continue;
        localmwk.m(str);
        continue;
        localmwk.n(str);
        continue;
        localmwk.o(str);
        continue;
        localmwk.p(str);
        continue;
        localmwk.b(true);
        continue;
        localmwk.b(false);
        continue;
        localmwk.a((byte[])localObject2, l1);
        continue;
        localmwk.t(str);
        continue;
        localmwk.b(str, (int)l1, ((mwi)localObject1).c, ((mwi)localObject1).jdField_a_of_type_ArrayOfByte);
        continue;
        localmwk.a(str, (int)l1, ((mwi)localObject1).c, ((mwi)localObject1).jdField_a_of_type_ArrayOfByte);
        continue;
        localmwk.b(str, (byte[])localObject2, l1);
        continue;
        localmwk.d(str, (byte[])localObject2, l1);
        continue;
        localmwk.c(str, (byte[])localObject2, l1);
        continue;
        switch ((int)((mwi)localObject1).c)
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          mwv.c("DAVEngineJni_NativeEvent", "SdkEventId.EV_VOIP_OTHER_TER_CHATING_STAUTS, type[" + ((mwi)localObject1).c + "]");
          localmwk.a(str, ((mwi)localObject1).d, i);
          break;
          i = 2;
          continue;
          i = 1;
        }
        localmwk.a(str, (int)((mwi)localObject1).c, (int)((mwi)localObject1).d, ((mwi)localObject1).e);
        continue;
        localmwk.d(str, (int)l1);
        continue;
        i = (int)((mwi)localObject1).c;
        k = (int)((mwi)localObject1).d;
        long l2 = ((mwi)localObject1).e;
        if (((mwi)localObject1).jdField_b_of_type_ArrayOfByte != null) {}
        for (localObject1 = new String(((mwi)localObject1).jdField_b_of_type_ArrayOfByte);; localObject1 = "")
        {
          localmwk.a(str, (int)l1, i, k, (String)localObject1, l2);
          break;
        }
        localmwk.c(str, (int)l1);
        continue;
        localmwk.u(str);
        localmwk.h(2048);
        continue;
        localmwk.h(3);
        continue;
        localmwk.h(4);
        continue;
        localmwk.a(str, l1, (byte[])localObject2);
        continue;
        localmwk.b(str, (int)l1, ((mwi)localObject1).jdField_a_of_type_ArrayOfByte);
        continue;
        i = (int)l1;
        localmwk.e(str, i);
        if (mwv.c())
        {
          mwv.b("NativeEventHandler", "EM_SDK_EVENT_ID_GROUND_GLASS_SWITCH, nSwitch[" + i + "], fromUin[" + str + "]");
          continue;
          i = (int)l1;
          localmwk.f(str, i);
          if (mwv.c())
          {
            mwv.b("NativeEventHandler", "EM_SDK_EVENT_ID_GROUND_GLASS_WAIT_TIME, nTime[" + i + "], fromUin[" + str + "]");
            continue;
            localmwk.f((int)l1);
            continue;
            mwv.c("NativeEventHandler", "EM_SDK_EVENT_ID_CUSTOM_COMMAND, peerUin[" + str + "]");
            localmwk.a(str, ((mwi)localObject1).c, ((mwi)localObject1).d, ((mwi)localObject1).jdField_b_of_type_Int);
            continue;
            mwv.c("NativeEventHandler", "NETWORK_CHECK, peerUin[" + str + "]");
            localmwk.G();
            continue;
            localmwk.c(true);
            continue;
            localmwk.g((int)((mwi)localObject1).c);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avcore.jni.dav.DavEngineJni.NativeEventHandler
 * JD-Core Version:    0.7.0.1
 */