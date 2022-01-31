package com.qq.im.poi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.lbspack.MqqLbsPack.LBSSig;
import tencent.im.oidb.lbspack.MqqLbsPack.ReqGetLBSPID;
import tencent.im.oidb.lbspack.MqqLbsPack.RspGetLBSPID;
import tencent.im.oidb.lbspack.MqqLbsPack.RspHead;
import tencent.im.oidb.lbspack.MqqLbsPack.SelectedUinInfo;

public class LbsPackGetPidServlet
  extends MSFServlet
{
  public static ByteStringMicro a(String paramString)
  {
    ByteStringMicro localByteStringMicro = null;
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = paramString.getBytes();; paramString = null)
    {
      if (paramString != null) {
        localByteStringMicro = ByteStringMicro.copyFrom(paramString);
      }
      return localByteStringMicro;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {}
    for (boolean bool = false;; bool = paramFromServiceMsg.isSuccess())
    {
      Bundle localBundle = new Bundle();
      Object localObject;
      if (bool)
      {
        localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
      }
      try
      {
        localObject = new MqqLbsPack.RspGetLBSPID();
        ((MqqLbsPack.RspGetLBSPID)localObject).mergeFrom(paramFromServiceMsg);
        if (((MqqLbsPack.RspGetLBSPID)localObject).msg_head.has())
        {
          int i = ((MqqLbsPack.RspHead)((MqqLbsPack.RspGetLBSPID)localObject).msg_head.get()).uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.d("LbsPackGetPidServlet", 2, "onReceive result = " + i);
          }
          localBundle.putInt("key_receive_result", i);
          paramFromServiceMsg = ((MqqLbsPack.RspGetLBSPID)localObject).msg_head.bytes_err_msg.get().toStringUtf8();
          if (paramFromServiceMsg != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("LbsPackGetPidServlet", 2, "onReceive  errMsg = " + paramFromServiceMsg);
            }
            localBundle.putString("key_erro_msg", paramFromServiceMsg);
          }
        }
        if (((MqqLbsPack.RspGetLBSPID)localObject).bytes_pid.has())
        {
          paramFromServiceMsg = ((MqqLbsPack.RspGetLBSPID)localObject).bytes_pid.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.d("LbsPackGetPidServlet", 2, "onReceive pid = " + paramFromServiceMsg);
          }
          localBundle.putString("key_pid", paramFromServiceMsg);
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
        }
      }
      notifyObserver(paramIntent, 1, bool, localBundle, LbsPackObserver.class);
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    double d1 = paramIntent.getDoubleExtra("key_longitude", 0.0D);
    double d2 = paramIntent.getDoubleExtra("key_latitude", 0.0D);
    Object localObject2 = new MqqLbsPack.LBSSig();
    ((MqqLbsPack.LBSSig)localObject2).int32_lon.set((int)(1000000.0D * d1));
    ((MqqLbsPack.LBSSig)localObject2).int32_lat.set((int)(1000000.0D * d2));
    int i = paramIntent.getIntExtra("key_time", 0);
    ((MqqLbsPack.LBSSig)localObject2).uint32_time.set(i);
    Object localObject1 = paramIntent.getStringExtra("key_verify_key");
    ((MqqLbsPack.LBSSig)localObject2).bytes_verify_key.set(a((String)localObject1));
    MqqLbsPack.SelectedUinInfo localSelectedUinInfo = new MqqLbsPack.SelectedUinInfo();
    i = paramIntent.getIntExtra("key_all_friends_flag", 0);
    localSelectedUinInfo.uint32_all_frd.set(i);
    long l = paramIntent.getLongExtra("key_group_id", 0L);
    if (l != 0L) {
      localSelectedUinInfo.uint64_group_code.set(l);
    }
    l = paramIntent.getLongExtra("key_dicuss_id", 0L);
    if (l != 0L) {
      localSelectedUinInfo.uint64_discuss_uin.set(l);
    }
    l = paramIntent.getLongExtra("key_friend_uin", 0L);
    if (l != 0L) {
      localSelectedUinInfo.uint64_uin.set(l);
    }
    localObject1 = new MqqLbsPack.ReqGetLBSPID();
    ((MqqLbsPack.ReqGetLBSPID)localObject1).int32_lon.set((int)(d1 * 1000000.0D));
    ((MqqLbsPack.ReqGetLBSPID)localObject1).int32_lat.set((int)(d2 * 1000000.0D));
    paramIntent.getLongExtra("key_poi_id", 0L);
    ((MqqLbsPack.ReqGetLBSPID)localObject1).uin_grp_dis_info.set(localSelectedUinInfo);
    ((MqqLbsPack.ReqGetLBSPID)localObject1).msg_lbs_sig.set((MessageMicro)localObject2);
    i = paramIntent.getIntExtra("key_accuracy", 0);
    ((MqqLbsPack.ReqGetLBSPID)localObject1).uint32_lbs_accuracy.set(i);
    localObject2 = paramIntent.getStringExtra("key_encrypt_sig");
    if (localObject2 != null) {
      ((MqqLbsPack.ReqGetLBSPID)localObject1).bytes_encrypt_sig.set(a((String)localObject2));
    }
    i = paramIntent.getIntExtra("key_posion_flag", 0);
    ((MqqLbsPack.ReqGetLBSPID)localObject1).uint32_qa.set(i);
    paramIntent = ((MqqLbsPack.ReqGetLBSPID)localObject1).toByteArray();
    localObject2 = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject2).putInt(paramIntent.length + 4).put(paramIntent);
    paramIntent = ((ByteBuffer)localObject2).array();
    paramPacket.setSSOCommand("LBSRedPack.ReqGetLBSPID");
    paramPacket.putSendData(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("LbsPackGetPidServlet", 2, "onSend req=" + localObject1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackGetPidServlet
 * JD-Core Version:    0.7.0.1
 */