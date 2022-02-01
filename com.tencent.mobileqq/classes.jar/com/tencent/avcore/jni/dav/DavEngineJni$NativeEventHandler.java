package com.tencent.avcore.jni.dav;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import nbw;
import nbz;
import ncl;
import ncm;
import ncn;

class DavEngineJni$NativeEventHandler
  extends Handler
{
  private static final String TAG = "DAVEngineJni_NativeEvent";
  protected final WeakReference<ncn> mCallback;
  protected final WeakReference<nbz> mEventLisRef;
  
  DavEngineJni$NativeEventHandler(Looper paramLooper, nbz paramnbz, ncn paramncn)
  {
    super(paramLooper);
    this.mEventLisRef = new WeakReference(paramnbz);
    this.mCallback = new WeakReference(paramncn);
  }
  
  private void onReceiveRequest(int paramInt, nbw paramnbw, nbz paramnbz)
  {
    byte[] arrayOfByte1 = paramnbw.jdField_a_of_type_ArrayOfByte;
    int i = (int)paramnbw.c;
    String str1 = paramnbw.jdField_a_of_type_JavaLangString;
    int j = paramnbw.jdField_a_of_type_Int;
    int k = paramnbw.jdField_b_of_type_Int;
    if (k == 3124) {
      i = 26;
    }
    String str2 = ncm.a(paramnbw.jdField_b_of_type_Long);
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
        paramnbz.a(i, str2, (String)localObject1, paramnbw.jdField_b_of_type_ArrayOfByte, true, str1, j, k);
        label234:
        if (ncl.c()) {
          ncl.b("onReceiveRequest", "uinType = " + i + ", extraUin = " + (String)localObject1 + ", longFronUin = " + paramnbw.jdField_b_of_type_Long);
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
      if (ncl.c()) {
        ncl.b("onReceiveRequest", "uinType = " + i + ", extraUin = " + (String)localObject1);
      }
      break;
      localObject1 = String.valueOf(paramnbw.d);
      break;
      if ((paramInt != 1) && (paramInt != 61)) {
        break label234;
      }
      paramnbz.a(i, str2, (String)localObject1, paramnbw.jdField_b_of_type_ArrayOfByte, false, str1, j, k);
      break label234;
      label549:
      continue;
      label552:
      localObject1 = null;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    nbz localnbz = (nbz)this.mEventLisRef.get();
    if (localnbz == null) {
      return;
    }
    int i = paramMessage.what;
    Object localObject1 = (nbw)paramMessage.obj;
    if (localObject1 == null)
    {
      ncl.h("DAVEngineJni_NativeEvent", "p is null");
      return;
    }
    Object localObject2 = ((nbw)localObject1).jdField_a_of_type_ArrayOfByte;
    long l1 = ((nbw)localObject1).jdField_a_of_type_Long;
    String str = ncm.a(((nbw)localObject1).jdField_b_of_type_Long);
    byte[] arrayOfByte = ((nbw)localObject1).jdField_b_of_type_ArrayOfByte;
    if ((i != 16) && (i != 100) && (i != 117) && (i != 120) && (i != 124) && (i != 125)) {
      ncl.g("DAVEngineJni_NativeEvent", "handleMessage eventId[" + i + "], info[" + l1 + "], fromUin[" + str + "]");
    }
    ncn localncn = (ncn)this.mCallback.get();
    int j;
    if ((localncn != null) && (localncn.a(i)))
    {
      j = 1;
      label191:
      if (j != 0) {
        ((nbw)localObject1).f = SystemClock.elapsedRealtime();
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
      default: 
        if (localncn != null) {
          localncn.handleMessage(paramMessage);
        }
        break;
      }
    }
    label738:
    while (j != 0)
    {
      localncn.handleMessage(paramMessage);
      return;
      j = 0;
      break label191;
      onReceiveRequest(i, (nbw)localObject1, localnbz);
      continue;
      localnbz.d(str);
      continue;
      i = (int)l1;
      localObject2 = new StringBuilder().append("SdkEventId.EV_VOIP_CLOSED, Param0[").append(((nbw)localObject1).c).append("], Param1[").append(((nbw)localObject1).d).append("], Param2[").append(((nbw)localObject1).jdField_a_of_type_JavaLangString).append("], Param3[").append(((nbw)localObject1).jdField_a_of_type_Int).append("], Param4[").append(((nbw)localObject1).jdField_b_of_type_Int).append("], Param5[").append(((nbw)localObject1).e).append("], extraBuf[");
      if (((nbw)localObject1).jdField_b_of_type_ArrayOfByte != null) {}
      for (boolean bool = true;; bool = false)
      {
        ncl.c("DAVEngineJni_NativeEvent", bool + "], reason[" + i + "]");
        switch (i)
        {
        default: 
          localnbz.a(str, i, ((nbw)localObject1).c);
          break label738;
        }
      }
      localnbz.i(str);
      continue;
      i = (int)((nbw)localObject1).c;
      int k = (int)((nbw)localObject1).d;
      l1 = ((nbw)localObject1).e;
      if (((nbw)localObject1).jdField_b_of_type_ArrayOfByte != null) {}
      for (localObject1 = new String(((nbw)localObject1).jdField_b_of_type_ArrayOfByte);; localObject1 = "")
      {
        localnbz.a(str, i, k, (String)localObject1, l1);
        break;
      }
      if (l1 == 1L)
      {
        localnbz.a(str, arrayOfByte, 1L);
      }
      else
      {
        localnbz.a(str, (byte[])localObject2, 0L);
        continue;
        localnbz.b(((nbw)localObject1).c, 0L, 100L);
        continue;
        localnbz.a(str, 12, 0L);
        continue;
        localnbz.e(str);
        continue;
        localnbz.f(str);
        continue;
        localnbz.g(str);
        continue;
        localnbz.h(str);
        continue;
        localnbz.j(str);
        continue;
        localnbz.k(str);
        continue;
        localnbz.l(str);
        continue;
        localnbz.a(i - 19, str);
        continue;
        localnbz.a(str, true);
        continue;
        localnbz.a(str, false);
        continue;
        localnbz.m(str);
        continue;
        localnbz.n(str);
        continue;
        localnbz.o(str);
        continue;
        localnbz.p(str);
        continue;
        localnbz.b(true);
        continue;
        localnbz.b(false);
        continue;
        localnbz.a((byte[])localObject2, l1);
        continue;
        localnbz.t(str);
        continue;
        localnbz.b(str, (int)l1, ((nbw)localObject1).c, ((nbw)localObject1).jdField_a_of_type_ArrayOfByte);
        continue;
        localnbz.a(str, (int)l1, ((nbw)localObject1).c, ((nbw)localObject1).jdField_a_of_type_ArrayOfByte);
        continue;
        localnbz.b(str, (byte[])localObject2, l1);
        continue;
        localnbz.d(str, (byte[])localObject2, l1);
        continue;
        localnbz.c(str, (byte[])localObject2, l1);
        continue;
        switch ((int)((nbw)localObject1).c)
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          ncl.c("DAVEngineJni_NativeEvent", "SdkEventId.EV_VOIP_OTHER_TER_CHATING_STAUTS, type[" + ((nbw)localObject1).c + "]");
          localnbz.a(str, ((nbw)localObject1).d, i);
          break;
          i = 2;
          continue;
          i = 1;
        }
        localnbz.a(str, (int)((nbw)localObject1).c, (int)((nbw)localObject1).d, ((nbw)localObject1).e);
        continue;
        localnbz.d(str, (int)l1);
        continue;
        i = (int)((nbw)localObject1).c;
        k = (int)((nbw)localObject1).d;
        long l2 = ((nbw)localObject1).e;
        if (((nbw)localObject1).jdField_b_of_type_ArrayOfByte != null) {}
        for (localObject1 = new String(((nbw)localObject1).jdField_b_of_type_ArrayOfByte);; localObject1 = "")
        {
          localnbz.a(str, (int)l1, i, k, (String)localObject1, l2);
          break;
        }
        localnbz.c(str, (int)l1);
        continue;
        localnbz.v(str);
        localnbz.h(2048);
        continue;
        localnbz.h(3);
        continue;
        localnbz.h(4);
        continue;
        localnbz.a(str, l1, (byte[])localObject2);
        continue;
        localnbz.b(str, (int)l1, ((nbw)localObject1).jdField_a_of_type_ArrayOfByte);
        continue;
        i = (int)l1;
        localnbz.e(str, i);
        if (ncl.c())
        {
          ncl.b("NativeEventHandler", "EM_SDK_EVENT_ID_GROUND_GLASS_SWITCH, nSwitch[" + i + "], fromUin[" + str + "]");
          continue;
          i = (int)l1;
          localnbz.f(str, i);
          if (ncl.c())
          {
            ncl.b("NativeEventHandler", "EM_SDK_EVENT_ID_GROUND_GLASS_WAIT_TIME, nTime[" + i + "], fromUin[" + str + "]");
            continue;
            localnbz.f((int)l1);
            continue;
            ncl.c("NativeEventHandler", "EM_SDK_EVENT_ID_CUSTOM_COMMAND, peerUin[" + str + "]");
            localnbz.a(str, ((nbw)localObject1).c, ((nbw)localObject1).d, ((nbw)localObject1).jdField_b_of_type_Int);
            continue;
            ncl.c("NativeEventHandler", "NETWORK_CHECK, peerUin[" + str + "]");
            localnbz.G();
            continue;
            localnbz.c(true);
            continue;
            localnbz.g((int)((nbw)localObject1).c);
            continue;
            localnbz.u(str);
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