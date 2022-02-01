package com.tencent.mobileqq.activity.recent.guidebanner;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NewerGuideBannerHandler
  extends BusinessHandler
{
  protected NewerGuideBannerHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject = null;
    paramFromServiceMsg = localObject;
    boolean bool2 = bool1;
    if (bool1)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramObject = new oidb_0x59f.RspBody();
          paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (paramObject.msg_guidelines8410.has())
          {
            paramFromServiceMsg = (oidb_0x59f.Guidelines_8410)paramObject.msg_guidelines8410.get();
            bool2 = true;
            break label148;
          }
          QLog.d("NewerGuideBannerHandler", 1, "[handlerGetNewerGuideBannerInfo] msg_guidelines8410 does not exist");
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.d("NewerGuideBannerHandler", 1, "handlerGetNewerGuideBannerInfo failed", paramFromServiceMsg);
      }
      bool2 = false;
      paramFromServiceMsg = localObject;
    }
    label148:
    paramObject = new StringBuilder();
    paramObject.append("handlerGetNewerGuideBannerInfo, result ");
    paramObject.append(bool2);
    QLog.d("NewerGuideBannerHandler", 1, paramObject.toString());
    notifyUI(0, bool2, paramFromServiceMsg);
  }
  
  void a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return NewerGuideBannerObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (TextUtils.equals("OidbSvc.0x59f_newer_guide_banner", paramFromServiceMsg.getServiceCmd()))) {
      a(paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerHandler
 * JD-Core Version:    0.7.0.1
 */