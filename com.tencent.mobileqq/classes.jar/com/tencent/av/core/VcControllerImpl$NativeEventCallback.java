package com.tencent.av.core;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Message;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.AVLog;
import com.tencent.av.business.manager.report.VideoBeaconReporter;
import com.tencent.av.report.AVReport;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.av.utils.AudioDump;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.avcore.engine.dav.DavNativeEventParams;
import com.tencent.avcore.util.AVNativeEventProcessor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

@SuppressLint({"HandlerLeak"})
class VcControllerImpl$NativeEventCallback
  implements AVNativeEventProcessor
{
  private final String jdField_a_of_type_JavaLangString = "VcControllerImpl_NativeEventHandler";
  
  VcControllerImpl$NativeEventCallback(VcControllerImpl paramVcControllerImpl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    long l1;
    String str;
    boolean bool;
    for (;;)
    {
      try
      {
        i = paramMessage.what;
        localObject = (DavNativeEventParams)paramMessage.obj;
        if (localObject == null)
        {
          AVLog.printErrorLog("VcControllerImpl_NativeEventHandler", "p is null");
          return true;
        }
        paramMessage = ((DavNativeEventParams)localObject).detail;
        l1 = ((DavNativeEventParams)localObject).info;
        str = CharacterUtil.a(((DavNativeEventParams)localObject).fromUin);
        switch (i)
        {
        case 4: 
          VideoBeaconReporter.a((int)l1, ((DavNativeEventParams)localObject).extraParam0, ((DavNativeEventParams)localObject).extraParam1, ((DavNativeEventParams)localObject).extraParam2);
          break;
        case 6: 
          if (!AudioDump.a()) {
            continue;
          }
        }
      }
      finally {}
      AudioDump.a().a(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl, null);
      continue;
      long l2 = ((DavNativeEventParams)localObject).extraParam0;
      long l3 = ((DavNativeEventParams)localObject).extraParam1;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(l2, l3, l1);
      continue;
      if (((DavNativeEventParams)localObject).extraParam0 != 1L) {
        break;
      }
      bool = true;
      label246:
      int i = (int)((DavNativeEventParams)localObject).extraParam1;
      try
      {
        paramMessage = new String(((DavNativeEventParams)localObject).detail, "utf-8");
        int j = ((DavNativeEventParams)localObject).extraParam3;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(bool, i, paramMessage, j);
      }
      catch (UnsupportedEncodingException paramMessage)
      {
        for (;;)
        {
          paramMessage.printStackTrace();
          paramMessage = "";
        }
      }
      if (AVReport.a().a)
      {
        AVReport.a().k = ((DavNativeEventParams)localObject).elapsedRealtime;
      }
      else
      {
        AVReport.a().z = ((DavNativeEventParams)localObject).elapsedRealtime;
        continue;
        i = (int)((DavNativeEventParams)localObject).info;
        if (QLog.isColorLevel()) {
          QLog.d("NativeEventHandler", 2, "SharpConfigPayload. version = " + i);
        }
        BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
        TraeConfigUpdate.a().a("load", i);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onAudioData(paramMessage);
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (int)l1, paramMessage);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b((int)l1, new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c((int)l1, new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.f(new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.e(new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, new String(paramMessage));
        break;
        try
        {
          localObject = new AVFunChat.AVFunChatMessage();
          ((AVFunChat.AVFunChatMessage)localObject).mergeFrom(paramMessage);
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (AVFunChat.AVFunChatMessage)localObject);
        }
        catch (InvalidProtocolBufferMicroException paramMessage)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("VcControllerImpl", 2, "EM_AVFUNCHATTYPE_CreativeCop InvalidProtocolBufferMicroException fail", paramMessage);
        }
        catch (Throwable paramMessage) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("VcControllerImpl", 2, "EM_AVFUNCHATTYPE_CreativeCop parse fail", paramMessage);
      break;
      ReportController.b(null, "CliOper", "", "", "0X800A7A4", "0X800A7A4", 0, (int)((DavNativeEventParams)localObject).extraParam0, "", "", "", "");
      break;
      ReportController.b(null, "CliOper", "", "", "0X800A7A5", "0X800A7A5", 0, (int)((DavNativeEventParams)localObject).extraParam0, "", "", "", "");
      break;
      break;
      bool = false;
      break label246;
      switch ((int)l1)
      {
      }
    }
  }
  
  public boolean isMsgNeedExtraDeal(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl.NativeEventCallback
 * JD-Core Version:    0.7.0.1
 */