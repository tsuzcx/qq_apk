package com.tencent.biz.pubaccount;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.impl.PublicAccountStQWebServletImpl;
import com.tencent.biz.pubaccount.util.NetDebugUtils;
import com.tencent.biz.subscribe.servlet.CertifiedAccountAbstractServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.pb.oac.OACProfilePb.ProfileDataReq;
import com.tencent.pb.oac.OACProfilePb.ProfileDataRsp;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class PublicAccountStQWebServletWrapper
  extends PublicAccountStQWebServletImpl
{
  public static void getAccountDetail(Long paramLong, String paramString, PublicAccountStQWebServletWrapper.PublicAccountStQCallback<OACProfilePb.ProfileDataRsp> paramPublicAccountStQCallback)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new OACProfilePb.ProfileDataReq();
    paramString.puin.set(paramLong.longValue());
    paramString.attachinfo.set(str);
    sendCmd("officialaccount.clientbusilogic.DataProfile", paramString, OACProfilePb.ProfileDataRsp.class, paramPublicAccountStQCallback);
  }
  
  public static <E extends MessageMicro<?>> void sendCmd(String paramString, MessageMicro<?> paramMessageMicro, Class<E> paramClass, PublicAccountStQWebServletWrapper.PublicAccountStQCallback<E> paramPublicAccountStQCallback)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), PublicAccountStQWebServletWrapper.class);
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    localStQWebReq.Seq.set(-1L);
    localStQWebReq.qua.set(QUA.getQUA3());
    localStQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
    localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(paramMessageMicro.toByteArray()));
    paramMessageMicro = CertifiedAccountAbstractServlet.a();
    if (!TextUtils.isEmpty(paramMessageMicro)) {
      localStQWebReq.traceid.set(paramMessageMicro);
    }
    localNewIntent.putExtra("traceid", paramMessageMicro);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", localStQWebReq.toByteArray());
    localNewIntent.setObserver(new PublicAccountStQWebServletWrapper.CommonObserver(paramPublicAccountStQCallback, paramClass));
    BaseApplicationImpl.getApplication().peekAppRuntime().startServlet(localNewIntent);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramIntent = paramIntent.getStringExtra("cmd");
    NetDebugUtils.a(arrayOfByte, paramIntent);
    paramPacket.setSSOCommand(paramIntent);
    if (arrayOfByte != null) {
      paramPacket.putSendData(WupUtil.a(arrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountStQWebServletWrapper
 * JD-Core Version:    0.7.0.1
 */