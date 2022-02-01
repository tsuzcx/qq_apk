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
    im_msg_body.Elem localElem;
    do
    {
      if (!paramStringBuilder.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramStringBuilder.next();
    } while (!localElem.life_online.has());
    for (;;)
    {
      if (localElem == null) {
        return;
      }
      long l1;
      label129:
      long l2;
      label157:
      long l3;
      label184:
      long l4;
      label211:
      int j;
      int i3;
      int i4;
      Object localObject3;
      String str;
      label291:
      boolean bool;
      label326:
      int m;
      label365:
      int n;
      label404:
      int i1;
      label443:
      int i5;
      int i6;
      int i;
      label529:
      label568:
      int k;
      label607:
      label636:
      Object localObject1;
      label666:
      label696:
      Object localObject2;
      int i2;
      if ((localElem.life_online.has()) && (localElem.life_online.uint32_ack.has()) && (localElem.life_online.uint32_ack.get() == 1))
      {
        if (localElem.life_online.uint64_unique_id.has())
        {
          l1 = localElem.life_online.uint64_unique_id.get();
          if (!localElem.life_online.uint32_op.has()) {
            break label1325;
          }
          l2 = localElem.life_online.uint32_op.get();
          if (!paramMsg.msg_head.from_uin.has()) {
            break label1331;
          }
          l3 = paramMsg.msg_head.from_uin.get();
          if (!paramMsg.msg_head.to_uin.has()) {
            break label1337;
          }
          l4 = paramMsg.msg_head.to_uin.get();
          ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).sendMsgArriveReceipt(BaseApplication.getContext(), localMessageHandler.a, l1, l2, l3, l4, 1, null);
        }
      }
      else
      {
        j = 0;
        i3 = 0;
        i4 = 0;
        paramMessageInfo = "";
        localObject3 = "";
        str = "";
        if (!localElem.life_online.uint64_unique_id.has()) {
          break label1343;
        }
        l1 = localElem.life_online.uint64_unique_id.get();
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1355;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 1L) != 1L) {
          break label1349;
        }
        bool = true;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1367;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x4) != 4L) {
          break label1361;
        }
        m = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1379;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x40) != 64L) {
          break label1373;
        }
        n = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1391;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x800) != 2048L) {
          break label1385;
        }
        i1 = 1;
        i5 = (int)((localElem.life_online.uint64_bitmap.get() & 0x180) >> 7);
        i6 = (int)((localElem.life_online.uint64_bitmap.get() & 0x600) >> 9);
        if (m == 0) {
          break label1453;
        }
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1403;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x8) != 8L) {
          break label1397;
        }
        i = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1415;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x10) != 16L) {
          break label1409;
        }
        j = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1427;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x20) != 32L) {
          break label1421;
        }
        k = 1;
        if (!localElem.life_online.gdt_imp_data.has()) {
          break label1433;
        }
        paramStringBuilder = localElem.life_online.gdt_imp_data.get().toStringUtf8();
        if (!localElem.life_online.gdt_cli_data.has()) {
          break label1439;
        }
        paramMessageInfo = localElem.life_online.gdt_cli_data.get().toStringUtf8();
        if (!localElem.life_online.view_id.has()) {
          break label1446;
        }
        localObject1 = localElem.life_online.view_id.get().toStringUtf8();
        localObject2 = paramStringBuilder;
        if (paramStringBuilder.length() > 100) {
          localObject2 = paramStringBuilder.substring(0, 100);
        }
        if (paramMessageInfo.length() <= 100) {
          break label1726;
        }
        paramStringBuilder = paramMessageInfo.substring(0, 100);
        i2 = j;
      }
      label1409:
      label1415:
      label1671:
      for (;;)
      {
        label740:
        if (localElem.life_online.uint64_bitmap.has()) {
          if ((localElem.life_online.uint64_bitmap.get() & 0x1000) == 4096L)
          {
            j = 1;
            if (((j != 0) || ((paramMsg.msg_head.from_uin.has()) && (paramMsg.msg_head.from_uin.get() == 1579646438L))) && (!paramList1.isEmpty())) {
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("kandian_replace_subscribe_msg", "1");
            }
            if (i1 != 0)
            {
              if (!paramList1.isEmpty()) {
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("recent_list_advertisement_message", "1");
              }
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("isRecentAd, uint64_bitmap value is: ");
                if (!localElem.life_online.uint64_bitmap.has()) {
                  break label1586;
                }
                paramMessageInfo = Long.valueOf(localElem.life_online.uint64_bitmap.get());
                QLog.d("LifeOnlineElemDecoder", 2, paramMessageInfo);
              }
              ThreadManager.getSubThreadHandler().postDelayed(new LifeOnlineElemDecoder.1(this, localQQAppInterface), 1000L);
            }
            if (!paramList1.isEmpty())
            {
              paramMessageInfo = (MessageRecord)paramList1.get(0);
              paramMessageInfo.extLong |= 0x1;
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_msgHasRead", "false");
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_msgId", String.valueOf(l1));
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_should_report", String.valueOf(bool));
              if (m != 0)
              {
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("isAdMsg", "1");
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("ad_msgHasRead", "false");
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_msgClick", paramStringBuilder);
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_msgImp", (String)localObject2);
                paramMessageInfo = (MessageRecord)paramList1.get(0);
                if (i == 0) {
                  break label1594;
                }
                paramStringBuilder = "1";
                label1145:
                paramMessageInfo.saveExtInfoToExtStr("gdt_singleAd", paramStringBuilder);
                paramMessageInfo = (MessageRecord)paramList1.get(0);
                if (i2 == 0) {
                  break label1601;
                }
                paramStringBuilder = "1";
                paramMessageInfo.saveExtInfoToExtStr("gdt_mulAd", paramStringBuilder);
                paramMessageInfo = (MessageRecord)paramList1.get(0);
                if (k == 0) {
                  break label1608;
                }
                paramStringBuilder = "1";
                paramMessageInfo.saveExtInfoToExtStr("gdt_followAd", paramStringBuilder);
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("is_AdArrive_Msg", "1");
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_view_id", (String)localObject1);
              }
            }
            if ((n == 0) || (paramList1.isEmpty())) {
              break label1671;
            }
            paramList = paramList.iterator();
            i = 0;
            label1272:
            if (!paramList.hasNext()) {
              break label1615;
            }
            paramStringBuilder = (im_msg_body.Elem)paramList.next();
            if (!paramStringBuilder.pub_acc_info.uint32_is_inter_num.has()) {
              break label1723;
            }
            i = paramStringBuilder.pub_acc_info.uint32_is_inter_num.get();
          }
        }
        label779:
        label923:
        label1203:
        label1337:
        label1594:
        label1723:
        for (;;)
        {
          break label1272;
          l1 = 0L;
          break label129;
          l2 = 0L;
          break label157;
          l3 = 0L;
          break label184;
          l4 = 0L;
          break label211;
          label1343:
          l1 = 0L;
          break label291;
          label1349:
          bool = false;
          break label326;
          label1355:
          bool = false;
          break label326;
          label1361:
          m = 0;
          break label365;
          label1367:
          m = 0;
          break label365;
          label1373:
          n = 0;
          break label404;
          label1379:
          n = 0;
          break label404;
          label1385:
          i1 = 0;
          break label443;
          label1391:
          i1 = 0;
          break label443;
          label1397:
          i = 0;
          break label529;
          label1403:
          i = 0;
          break label529;
          j = 0;
          break label568;
          j = 0;
          break label568;
          k = 0;
          break label607;
          k = 0;
          break label607;
          paramStringBuilder = "";
          break label636;
          paramMessageInfo = "";
          break label666;
          localObject1 = "";
          break label696;
          i2 = i3;
          k = i4;
          localObject2 = localObject3;
          paramStringBuilder = paramMessageInfo;
          localObject1 = str;
          i = j;
          if (!QLog.isColorLevel()) {
            break label740;
          }
          localObject1 = new StringBuilder().append("isAdArriveMsg is false, uint64_bitmap value is: ");
          if (localElem.life_online.uint64_bitmap.has()) {}
          for (paramStringBuilder = Long.valueOf(localElem.life_online.uint64_bitmap.get());; paramStringBuilder = "null")
          {
            QLog.d("LifeOnlineElemDecoder", 2, paramStringBuilder);
            i2 = i3;
            k = i4;
            localObject2 = localObject3;
            paramStringBuilder = paramMessageInfo;
            localObject1 = str;
            i = j;
            break;
          }
          j = 0;
          break label779;
          j = 0;
          break label779;
          paramMessageInfo = "null";
          break label923;
          paramStringBuilder = "0";
          break label1145;
          label1601:
          paramStringBuilder = "0";
          break label1174;
          label1608:
          paramStringBuilder = "0";
          break label1203;
          label1615:
          paramList = (MessageRecord)paramList1.get(0);
          paramList.saveExtInfoToExtStr("welcome_msg", "true");
          if ((i != 2) && (((paramList instanceof MessageForText)) || ((paramList instanceof MessageForLongMsg)))) {
            ThreadManager.executeOnSubThread(new LifeOnlineElemDecoder.2(this, localMessageHandler, paramMsg));
          }
          if (paramList1.isEmpty()) {
            break;
          }
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("public_account_msg_unread_flag", String.valueOf(i5));
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("public_account_msg_extra_info_type", String.valueOf(i6));
          return;
        }
        label1174:
        label1325:
        label1331:
        label1726:
        i2 = j;
        label1421:
        label1427:
        label1433:
        label1439:
        label1446:
        label1453:
        label1586:
        paramStringBuilder = paramMessageInfo;
      }
      localElem = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.LifeOnlineElemDecoder
 * JD-Core Version:    0.7.0.1
 */