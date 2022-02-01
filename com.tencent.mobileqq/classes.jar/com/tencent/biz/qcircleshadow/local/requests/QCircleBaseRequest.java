package com.tencent.biz.qcircleshadow.local.requests;

import NS_COMM.COMM.Entry;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import org.jetbrains.annotations.NotNull;
import vvq;

public abstract class QCircleBaseRequest
  extends VSBaseRequest
{
  @NotNull
  public MessageMicro getRequestWrapper(ByteStringMicro paramByteStringMicro)
  {
    paramByteStringMicro = (PROTOCAL.StQWebReq)super.getRequestWrapper(paramByteStringMicro);
    COMM.Entry localEntry = new COMM.Entry();
    localEntry.key.set("fc-appid");
    localEntry.value.set("92");
    paramByteStringMicro.Extinfo.add(localEntry);
    localEntry = new COMM.Entry();
    localEntry.key.set("sw-plugin-qua");
    localEntry.value.set(vvq.a().a());
    paramByteStringMicro.Extinfo.add(localEntry);
    return paramByteStringMicro;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.requests.QCircleBaseRequest
 * JD-Core Version:    0.7.0.1
 */