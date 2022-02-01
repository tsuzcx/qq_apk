package com.qwallet.temp.impl;

import com.qwallet.temp.IQWalletPBTemp;
import com.tencent.mobileqq.data.QWalletGoldMsgTipsElem;
import com.tencent.mobileqq.data.QWalletSubmsgtype0x66.MsgBody;
import com.tencent.mobileqq.data.QWalletSubmsgtype0x7e.MsgBody.OnlinePush;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GoldMsgTipsElem;
import tencent.im.oidb.cmd0x858.oidb_0x858.GoldMsgTipsElem;
import tencent.im.s2c.msgtype0x210.submsgtype0x66.submsgtype0x66.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x7e.submsgtype0x7e.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x7e.submsgtype0x7e.WalletMsgPush;

public class QWalletPBTempImpl
  implements IQWalletPBTemp
{
  public QWalletSubmsgtype0x66.MsgBody convertSubmsgtype0x66$MsgBody(byte[] paramArrayOfByte)
  {
    Object localObject = (submsgtype0x66.MsgBody)new submsgtype0x66.MsgBody().mergeFrom(paramArrayOfByte);
    paramArrayOfByte = new QWalletSubmsgtype0x66.MsgBody();
    if (((submsgtype0x66.MsgBody)localObject).uint32_type.has()) {
      paramArrayOfByte.pushType = ((submsgtype0x66.MsgBody)localObject).uint32_type.get();
    }
    if (((submsgtype0x66.MsgBody)localObject).bytes_push_data.has())
    {
      localObject = ((submsgtype0x66.MsgBody)localObject).bytes_push_data.get();
      if (localObject != null) {
        paramArrayOfByte.pushData = ((ByteStringMicro)localObject).toByteArray();
      }
    }
    return paramArrayOfByte;
  }
  
  public QWalletSubmsgtype0x7e.MsgBody.OnlinePush convertSubmsgtype0x7e$MsgBody$OnlinePush(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (submsgtype0x7e.MsgBody)new submsgtype0x7e.MsgBody().mergeFrom(paramArrayOfByte);
    if (paramArrayOfByte.msg_online_push.has())
    {
      Object localObject = (submsgtype0x7e.WalletMsgPush)paramArrayOfByte.msg_online_push.get();
      if (localObject != null)
      {
        boolean bool = ((submsgtype0x7e.WalletMsgPush)localObject).uint32_action.has();
        int k = -1;
        int i;
        if (bool) {
          i = ((submsgtype0x7e.WalletMsgPush)localObject).uint32_action.get();
        } else {
          i = -1;
        }
        int j;
        if (((submsgtype0x7e.WalletMsgPush)localObject).uint32_timestamp.has()) {
          j = ((submsgtype0x7e.WalletMsgPush)localObject).uint32_timestamp.get();
        } else {
          j = -1;
        }
        bool = ((submsgtype0x7e.WalletMsgPush)localObject).bytes_extend.has();
        String str4 = "";
        if (bool)
        {
          paramArrayOfByte = ((submsgtype0x7e.WalletMsgPush)localObject).bytes_extend.get();
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte = new String(paramArrayOfByte.toByteArray(), "UTF-8");
            break label151;
          }
        }
        paramArrayOfByte = "";
        label151:
        String str1;
        if (((submsgtype0x7e.WalletMsgPush)localObject).str_serialno.has()) {
          str1 = ((submsgtype0x7e.WalletMsgPush)localObject).str_serialno.get();
        } else {
          str1 = "";
        }
        String str2;
        if (((submsgtype0x7e.WalletMsgPush)localObject).str_billno.has()) {
          str2 = ((submsgtype0x7e.WalletMsgPush)localObject).str_billno.get();
        } else {
          str2 = "";
        }
        String str3;
        if (((submsgtype0x7e.WalletMsgPush)localObject).str_appinfo.has()) {
          str3 = ((submsgtype0x7e.WalletMsgPush)localObject).str_appinfo.get();
        } else {
          str3 = "";
        }
        if (((submsgtype0x7e.WalletMsgPush)localObject).uint32_amount.has()) {
          k = ((submsgtype0x7e.WalletMsgPush)localObject).uint32_amount.get();
        }
        if (((submsgtype0x7e.WalletMsgPush)localObject).str_jumpurl.has()) {
          str4 = ((submsgtype0x7e.WalletMsgPush)localObject).str_jumpurl.get();
        }
        localObject = new QWalletSubmsgtype0x7e.MsgBody.OnlinePush();
        ((QWalletSubmsgtype0x7e.MsgBody.OnlinePush)localObject).action = i;
        ((QWalletSubmsgtype0x7e.MsgBody.OnlinePush)localObject).timestamp = j;
        ((QWalletSubmsgtype0x7e.MsgBody.OnlinePush)localObject).extend = paramArrayOfByte;
        ((QWalletSubmsgtype0x7e.MsgBody.OnlinePush)localObject).serialno = str1;
        ((QWalletSubmsgtype0x7e.MsgBody.OnlinePush)localObject).appinfo = str3;
        ((QWalletSubmsgtype0x7e.MsgBody.OnlinePush)localObject).jumpurl = str4;
        ((QWalletSubmsgtype0x7e.MsgBody.OnlinePush)localObject).billno = str2;
        ((QWalletSubmsgtype0x7e.MsgBody.OnlinePush)localObject).amount = k;
        return localObject;
      }
    }
    return null;
  }
  
  public QWalletGoldMsgTipsElem convertTroopTips(Object paramObject)
  {
    boolean bool = paramObject instanceof oidb_0x858.GoldMsgTipsElem;
    int k = 0;
    Object localObject1 = "";
    Object localObject2;
    int j;
    int i;
    if (bool)
    {
      localObject2 = (oidb_0x858.GoldMsgTipsElem)paramObject;
      if (((oidb_0x858.GoldMsgTipsElem)localObject2).type.has()) {
        j = ((oidb_0x858.GoldMsgTipsElem)localObject2).type.get();
      } else {
        j = 0;
      }
      if (((oidb_0x858.GoldMsgTipsElem)localObject2).billno.has()) {
        localObject1 = ((oidb_0x858.GoldMsgTipsElem)localObject2).billno.get();
      }
      i = j;
      paramObject = localObject1;
      if (((oidb_0x858.GoldMsgTipsElem)localObject2).action.has())
      {
        k = ((oidb_0x858.GoldMsgTipsElem)localObject2).action.get();
        i = j;
        paramObject = localObject1;
      }
    }
    else if ((paramObject instanceof TroopTips0x857.GoldMsgTipsElem))
    {
      localObject2 = (TroopTips0x857.GoldMsgTipsElem)paramObject;
      if (((TroopTips0x857.GoldMsgTipsElem)localObject2).type.has()) {
        j = ((TroopTips0x857.GoldMsgTipsElem)localObject2).type.get();
      } else {
        j = 0;
      }
      if (((TroopTips0x857.GoldMsgTipsElem)localObject2).billno.has()) {
        localObject1 = ((TroopTips0x857.GoldMsgTipsElem)localObject2).billno.get();
      }
      i = j;
      paramObject = localObject1;
      if (((TroopTips0x857.GoldMsgTipsElem)localObject2).action.has())
      {
        k = ((TroopTips0x857.GoldMsgTipsElem)localObject2).action.get();
        i = j;
        paramObject = localObject1;
      }
    }
    else
    {
      i = 0;
      paramObject = localObject1;
    }
    localObject1 = new QWalletGoldMsgTipsElem();
    ((QWalletGoldMsgTipsElem)localObject1).type = i;
    ((QWalletGoldMsgTipsElem)localObject1).billno = paramObject;
    ((QWalletGoldMsgTipsElem)localObject1).action = k;
    return localObject1;
  }
  
  public QWalletGoldMsgTipsElem convertTroopTips(byte[] paramArrayOfByte)
  {
    TroopTips0x857.GoldMsgTipsElem localGoldMsgTipsElem = new TroopTips0x857.GoldMsgTipsElem();
    localGoldMsgTipsElem.mergeFrom(paramArrayOfByte);
    QWalletGoldMsgTipsElem localQWalletGoldMsgTipsElem = new QWalletGoldMsgTipsElem();
    boolean bool = localGoldMsgTipsElem.type.has();
    int j = 0;
    if (bool) {
      i = localGoldMsgTipsElem.type.get();
    } else {
      i = 0;
    }
    localQWalletGoldMsgTipsElem.type = i;
    if (localGoldMsgTipsElem.billno.has()) {
      paramArrayOfByte = localGoldMsgTipsElem.billno.get();
    } else {
      paramArrayOfByte = "";
    }
    localQWalletGoldMsgTipsElem.billno = paramArrayOfByte;
    int i = j;
    if (localGoldMsgTipsElem.action.has()) {
      i = localGoldMsgTipsElem.action.get();
    }
    localQWalletGoldMsgTipsElem.action = i;
    return localQWalletGoldMsgTipsElem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletPBTempImpl
 * JD-Core Version:    0.7.0.1
 */