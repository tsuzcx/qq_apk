package com.immersion.stickersampleapp;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.IMMRRsp;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.RspBody;

public class ImmersionHandler$ImmersionObserver
  extends ProtoUtils.TroopProtocolObserver
{
  private ImmerIConnectionProxy a;
  
  public ImmersionHandler$ImmersionObserver(boolean paramBoolean, ImmerIConnectionProxy paramImmerIConnectionProxy)
  {
    super(paramBoolean);
    this.a = paramImmerIConnectionProxy;
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new oidb_0xa4d.RspBody();
    if (paramInt == 0) {
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("HapticMediaPlayer request success.errorcode = ");
          localStringBuilder.append(paramInt);
          QLog.i("ImmersionHandler", 2, localStringBuilder.toString());
        }
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0xa4d.IMMRRsp)paramBundle.msg_immr_rsp.get();
        this.a.setConnection(new Connection(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("HapticMediaPlayer request failerrorcode = ");
      paramArrayOfByte.append(paramInt);
      QLog.e("ImmersionHandler", 2, paramArrayOfByte.toString());
    }
    this.a.setConnection(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.immersion.stickersampleapp.ImmersionHandler.ImmersionObserver
 * JD-Core Version:    0.7.0.1
 */