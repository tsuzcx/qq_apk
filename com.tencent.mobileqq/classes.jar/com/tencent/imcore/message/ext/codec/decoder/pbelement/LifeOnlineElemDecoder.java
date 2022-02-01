package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.LifeOnlineAccount;
import tencent.im.msg.im_msg_body.PubAccInfo;

public class LifeOnlineElemDecoder
  extends SimplePBElemDecoder
{
  public int a()
  {
    return -1000;
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    MessageHandler localMessageHandler = localQQAppInterface.getMsgHandler();
    paramStringBuilder = paramList.iterator();
    while (paramStringBuilder.hasNext())
    {
      localElem = (im_msg_body.Elem)paramStringBuilder.next();
      if (localElem.life_online.has()) {
        break label62;
      }
    }
    im_msg_body.Elem localElem = null;
    label62:
    if (localElem == null) {
      return;
    }
    boolean bool = localElem.life_online.has();
    long l5 = 0L;
    if ((bool) && (localElem.life_online.uint32_ack.has()) && (localElem.life_online.uint32_ack.get() == 1))
    {
      if (localElem.life_online.uint64_unique_id.has()) {
        l1 = localElem.life_online.uint64_unique_id.get();
      } else {
        l1 = 0L;
      }
      long l2;
      if (localElem.life_online.uint32_op.has()) {
        l2 = localElem.life_online.uint32_op.get();
      } else {
        l2 = 0L;
      }
      long l3;
      if (paramMsg.msg_head.from_uin.has()) {
        l3 = paramMsg.msg_head.from_uin.get();
      } else {
        l3 = 0L;
      }
      long l4;
      if (paramMsg.msg_head.to_uin.has()) {
        l4 = paramMsg.msg_head.to_uin.get();
      } else {
        l4 = 0L;
      }
      ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).sendMsgArriveReceipt(BaseApplication.getContext(), localMessageHandler.n, l1, l2, l3, l4, 1, null);
    }
    long l1 = l5;
    if (localElem.life_online.uint64_unique_id.has()) {
      l1 = localElem.life_online.uint64_unique_id.get();
    }
    if ((localElem.life_online.uint64_bitmap.has()) && ((localElem.life_online.uint64_bitmap.get() & 1L) == 1L)) {
      bool = true;
    } else {
      bool = false;
    }
    int m;
    if ((localElem.life_online.uint64_bitmap.has()) && ((localElem.life_online.uint64_bitmap.get() & 0x4) == 4L)) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if ((localElem.life_online.uint64_bitmap.has()) && ((localElem.life_online.uint64_bitmap.get() & 0x40) == 64L)) {
      n = 1;
    } else {
      n = 0;
    }
    int i1;
    if ((localElem.life_online.uint64_bitmap.has()) && ((localElem.life_online.uint64_bitmap.get() & 0x800) == 2048L)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i3 = (int)((localElem.life_online.uint64_bitmap.get() & 0x180) >> 7);
    int i4 = (int)((localElem.life_online.uint64_bitmap.get() & 0x600) >> 9);
    Object localObject1 = "";
    int i;
    int j;
    int k;
    Object localObject2;
    Object localObject3;
    if (m != 0)
    {
      if ((localElem.life_online.uint64_bitmap.has()) && ((localElem.life_online.uint64_bitmap.get() & 0x8) == 8L)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((localElem.life_online.uint64_bitmap.has()) && ((localElem.life_online.uint64_bitmap.get() & 0x10) == 16L)) {
        j = 1;
      } else {
        j = 0;
      }
      if ((localElem.life_online.uint64_bitmap.has()) && ((localElem.life_online.uint64_bitmap.get() & 0x20) == 32L)) {
        k = 1;
      } else {
        k = 0;
      }
      if (localElem.life_online.gdt_imp_data.has()) {
        paramMessageInfo = localElem.life_online.gdt_imp_data.get().toStringUtf8();
      } else {
        paramMessageInfo = "";
      }
      if (localElem.life_online.gdt_cli_data.has()) {
        paramStringBuilder = localElem.life_online.gdt_cli_data.get().toStringUtf8();
      } else {
        paramStringBuilder = "";
      }
      if (localElem.life_online.view_id.has()) {
        localObject1 = localElem.life_online.view_id.get().toStringUtf8();
      }
      if (paramMessageInfo.length() > 100) {
        localObject2 = paramMessageInfo.substring(0, 100);
      } else {
        localObject2 = paramMessageInfo;
      }
      paramMessageInfo = paramStringBuilder;
      if (paramStringBuilder.length() > 100) {
        paramMessageInfo = paramStringBuilder.substring(0, 100);
      }
      localObject3 = localObject1;
      paramStringBuilder = (StringBuilder)localObject2;
      localObject1 = paramMessageInfo;
      paramMessageInfo = (MessageInfo)localObject3;
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramMessageInfo = new StringBuilder();
        paramMessageInfo.append("isAdArriveMsg is false, uint64_bitmap value is: ");
        if (localElem.life_online.uint64_bitmap.has()) {
          paramStringBuilder = Long.valueOf(localElem.life_online.uint64_bitmap.get());
        } else {
          paramStringBuilder = "null";
        }
        paramMessageInfo.append(paramStringBuilder);
        QLog.d("LifeOnlineElemDecoder", 2, paramMessageInfo.toString());
      }
      localObject2 = "";
      paramStringBuilder = (StringBuilder)localObject2;
      paramMessageInfo = paramStringBuilder;
      i = 0;
      j = 0;
      k = 0;
      localObject1 = paramStringBuilder;
      paramStringBuilder = (StringBuilder)localObject2;
    }
    int i2;
    if ((localElem.life_online.uint64_bitmap.has()) && ((localElem.life_online.uint64_bitmap.get() & 0x1000) == 4096L)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (((i2 != 0) || ((paramMsg.msg_head.from_uin.has()) && (paramMsg.msg_head.from_uin.get() == 1579646438L))) && (!paramList1.isEmpty())) {
      ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("kandian_replace_subscribe_msg", "1");
    }
    if (i1 != 0)
    {
      if (!paramList1.isEmpty()) {
        ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("recent_list_advertisement_message", "1");
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("isRecentAd, uint64_bitmap value is: ");
        if (localElem.life_online.uint64_bitmap.has()) {
          localObject2 = Long.valueOf(localElem.life_online.uint64_bitmap.get());
        } else {
          localObject2 = "null";
        }
        ((StringBuilder)localObject3).append(localObject2);
        QLog.d("LifeOnlineElemDecoder", 2, ((StringBuilder)localObject3).toString());
      }
      ThreadManager.getSubThreadHandler().postDelayed(new LifeOnlineElemDecoder.1(this, localQQAppInterface), 1000L);
    }
    if (!paramList1.isEmpty())
    {
      localObject2 = (MessageRecord)paramList1.get(0);
      ((MessageRecord)localObject2).extLong |= 0x1;
      ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_msgHasRead", "false");
      ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_msgId", String.valueOf(l1));
      ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_should_report", String.valueOf(bool));
      if (m != 0)
      {
        ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("isAdMsg", "1");
        ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("ad_msgHasRead", "false");
        ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_msgClick", (String)localObject1);
        ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_msgImp", paramStringBuilder);
        localObject2 = (MessageRecord)paramList1.get(0);
        localObject1 = "0";
        if (i != 0) {
          paramStringBuilder = "1";
        } else {
          paramStringBuilder = "0";
        }
        ((MessageRecord)localObject2).saveExtInfoToExtStr("gdt_singleAd", paramStringBuilder);
        localObject2 = (MessageRecord)paramList1.get(0);
        if (j != 0) {
          paramStringBuilder = "1";
        } else {
          paramStringBuilder = "0";
        }
        ((MessageRecord)localObject2).saveExtInfoToExtStr("gdt_mulAd", paramStringBuilder);
        localObject2 = (MessageRecord)paramList1.get(0);
        paramStringBuilder = (StringBuilder)localObject1;
        if (k != 0) {
          paramStringBuilder = "1";
        }
        ((MessageRecord)localObject2).saveExtInfoToExtStr("gdt_followAd", paramStringBuilder);
        ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("is_AdArrive_Msg", "1");
        ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_view_id", paramMessageInfo);
      }
    }
    if ((n != 0) && (!paramList1.isEmpty()))
    {
      paramList = paramList.iterator();
      i = 0;
      while (paramList.hasNext())
      {
        paramStringBuilder = (im_msg_body.Elem)paramList.next();
        if (paramStringBuilder.pub_acc_info.uint32_is_inter_num.has()) {
          i = paramStringBuilder.pub_acc_info.uint32_is_inter_num.get();
        }
      }
      paramList = (MessageRecord)paramList1.get(0);
      paramList.saveExtInfoToExtStr("welcome_msg", "true");
      if ((i != 2) && (((paramList instanceof MessageForText)) || ((paramList instanceof MessageForLongMsg)))) {
        ThreadManager.executeOnSubThread(new LifeOnlineElemDecoder.2(this, localMessageHandler, paramMsg));
      }
    }
    if (!paramList1.isEmpty())
    {
      ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("public_account_msg_unread_flag", String.valueOf(i3));
      ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("public_account_msg_extra_info_type", String.valueOf(i4));
    }
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    a(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.life_online.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.LifeOnlineElemDecoder
 * JD-Core Version:    0.7.0.1
 */