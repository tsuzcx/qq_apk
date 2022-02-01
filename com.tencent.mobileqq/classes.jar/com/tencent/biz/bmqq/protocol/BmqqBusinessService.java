package com.tencent.biz.bmqq.protocol;

import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Map;
import mqq.app.MobileQQ;

public class BmqqBusinessService
  extends BaseProtocolCoder
{
  public static int a = 0;
  private static final String[] c = { "hrtxformqq" };
  private QQAppInterface b = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  
  public static int a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[3];
    int j = paramArrayOfByte[2];
    int k = paramArrayOfByte[1];
    return (paramArrayOfByte[0] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = new Bundle();
    BmqqUserSimpleInfo localBmqqUserSimpleInfo = new BmqqUserSimpleInfo();
    byte[] arrayOfByte1 = paramFromServiceMsg.getWupBuffer();
    int i = arrayOfByte1.length - 4;
    paramFromServiceMsg = new byte[i];
    System.arraycopy(arrayOfByte1, 4, paramFromServiceMsg, 0, i);
    i = paramFromServiceMsg.length;
    int j = paramFromServiceMsg[0];
    i = paramFromServiceMsg[(i - 1)];
    arrayOfByte1 = new byte[4];
    System.arraycopy(paramFromServiceMsg, 1, arrayOfByte1, 0, 4);
    a(arrayOfByte1);
    arrayOfByte1 = new byte[4];
    System.arraycopy(paramFromServiceMsg, 5, arrayOfByte1, 0, 4);
    a(arrayOfByte1);
    arrayOfByte1 = new byte[4];
    System.arraycopy(paramFromServiceMsg, 9, arrayOfByte1, 0, 4);
    i = a(arrayOfByte1);
    arrayOfByte1 = new byte[4];
    System.arraycopy(paramFromServiceMsg, 13, arrayOfByte1, 0, 4);
    j = a(arrayOfByte1);
    arrayOfByte1 = new byte[i];
    System.arraycopy(paramFromServiceMsg, 17, arrayOfByte1, 0, i);
    mobileqq_bmqq.CorpcardRspHead localCorpcardRspHead = new mobileqq_bmqq.CorpcardRspHead();
    try
    {
      localCorpcardRspHead.mergeFrom(arrayOfByte1);
      ((mobileqq_bmqq.HRTXHead)localCorpcardRspHead.rspHead.get()).uint64_qquin.get();
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
    {
      localInvalidProtocolBufferMicroException1.printStackTrace();
    }
    byte[] arrayOfByte2 = new byte[j];
    System.arraycopy(paramFromServiceMsg, i + 17, arrayOfByte2, 0, j);
    paramFromServiceMsg = new mobileqq_bmqq.CorpcardRspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(arrayOfByte2);
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      localInvalidProtocolBufferMicroException2.printStackTrace();
    }
    long l = paramFromServiceMsg.uint64_qquin.get();
    if (l > 0L) {
      localBmqqUserSimpleInfo.mBmqqUin = Long.toString(l);
    }
    l = paramFromServiceMsg.uint64_kfuin.get();
    if (l >= 0L) {
      localBmqqUserSimpleInfo.mBmqqMasterUin = Long.toString(l);
    }
    i = ((mobileqq_bmqq.RetInfo)paramFromServiceMsg.retInfo.get()).uint32_ret_code.get();
    String str = ((mobileqq_bmqq.RetInfo)paramFromServiceMsg.retInfo.get()).err_info.get();
    localBmqqUserSimpleInfo.mBmqqNickName = paramFromServiceMsg.nickname.get();
    localBmqqUserSimpleInfo.mBmqqRemarkName = paramFromServiceMsg.remarkname.get();
    localBmqqUserSimpleInfo.mBmqqJobTitle = paramFromServiceMsg.jobs.get();
    localBmqqUserSimpleInfo.mBmqqMobileNum = paramFromServiceMsg.mobile.get();
    localBmqqUserSimpleInfo.mBmqqTelphone = paramFromServiceMsg.phone.get();
    localBmqqUserSimpleInfo.mBmqqEmail = paramFromServiceMsg.email.get();
    localBmqqUserSimpleInfo.mBmqqCompany = paramFromServiceMsg.corpname.get();
    localBmqqUserSimpleInfo.mFlag = paramFromServiceMsg.flag.get();
    paramToServiceMsg.putParcelable("info", localBmqqUserSimpleInfo);
    paramToServiceMsg.putInt("result", i);
    paramToServiceMsg.putString("errinfo", str);
    return paramToServiceMsg;
  }
  
  private byte[] a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), k, j, i };
  }
  
  private byte[] a(ToServiceMsg paramToServiceMsg)
  {
    long l1 = ((Long)paramToServiceMsg.getAttributes().get("uin")).longValue();
    long l2 = Long.valueOf(this.b.getCurrentAccountUin()).longValue();
    Object localObject = new mobileqq_bmqq.HRTXHead();
    ((mobileqq_bmqq.HRTXHead)localObject).uint64_qquin.set(l1);
    paramToServiceMsg = new mobileqq_bmqq.CorpcardReqHead();
    paramToServiceMsg.reqHead.set((MessageMicro)localObject);
    localObject = new mobileqq_bmqq.CorpcardReqBody();
    ((mobileqq_bmqq.CorpcardReqBody)localObject).uint64_qquin.set(l2);
    int i = paramToServiceMsg.toByteArray().length;
    int j = ((mobileqq_bmqq.CorpcardReqBody)localObject).toByteArray().length;
    int k = i + 17;
    int m = k + j + 1;
    byte[] arrayOfByte = new byte[m];
    arrayOfByte[0] = 91;
    System.arraycopy(a(1001), 0, arrayOfByte, 1, 4);
    int n = a;
    a = n + 1;
    System.arraycopy(a(n), 0, arrayOfByte, 5, 4);
    System.arraycopy(a(i), 0, arrayOfByte, 9, 4);
    System.arraycopy(a(j), 0, arrayOfByte, 13, 4);
    System.arraycopy(paramToServiceMsg.toByteArray(), 0, arrayOfByte, 17, i);
    System.arraycopy(((mobileqq_bmqq.CorpcardReqBody)localObject).toByteArray(), 0, arrayOfByte, k, j);
    arrayOfByte[(m - 1)] = 93;
    return arrayOfByte;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return c;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("hrtxformqq.getUsrSimpleInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public boolean enableBinaryProtocol()
  {
    return true;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return false;
  }
  
  public byte[] encodeReqMsg(ToServiceMsg paramToServiceMsg)
  {
    if ("hrtxformqq.getUsrSimpleInfo".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      paramToServiceMsg = a(paramToServiceMsg);
    } else {
      paramToServiceMsg = null;
    }
    if (paramToServiceMsg == null) {
      return null;
    }
    byte[] arrayOfByte1 = a(paramToServiceMsg.length + 4);
    byte[] arrayOfByte2 = new byte[paramToServiceMsg.length + 4];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 4);
    System.arraycopy(paramToServiceMsg, 0, arrayOfByte2, 4, paramToServiceMsg.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.BmqqBusinessService
 * JD-Core Version:    0.7.0.1
 */