import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

final class aupd
  implements awiq
{
  aupd(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(awir paramawir)
  {
    for (;;)
    {
      try
      {
        if ((paramawir.jdField_a_of_type_Int != 0) || (paramawir.jdField_a_of_type_ArrayOfByte == null)) {
          continue;
        }
        Object localObject1 = new HashMap();
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg mr:" + localMessageRecord.toString());
          }
          Object localObject4 = new bbpd();
          ((bbpd)localObject4).jdField_a_of_type_Int = localMessageRecord.istroop;
          ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramawir.jdField_a_of_type_ArrayOfByte, (HashMap)localObject1, null, (bbpd)localObject4);
          if ((localArrayList1 == null) || (localArrayList1.size() != 1) || ((((MessageRecord)localArrayList1.get(0)).msgtype != -1000) && (((MessageRecord)localArrayList1.get(0)).msgtype != -1051) && (((MessageRecord)localArrayList1.get(0)).msgtype != -1035))) {
            continue;
          }
          localObject1 = null;
          if (((MessageRecord)localArrayList1.get(0)).msgtype == -1035)
          {
            localObject1 = (MessageRecord)localArrayList1.get(0);
            MessageRecord.copyMessageRecordStatusField((MessageRecord)localObject1, localMessageRecord);
            ((MessageRecord)localObject1).selfuin = localMessageRecord.selfuin;
            ((MessageRecord)localObject1).frienduin = localMessageRecord.frienduin;
            ((MessageRecord)localObject1).senderuin = localMessageRecord.senderuin;
            ((MessageRecord)localObject1).istroop = localMessageRecord.istroop;
            ((MessageRecord)localObject1).msgId = localMessageRecord.msgId;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
            ((aufc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(true, this.jdField_a_of_type_Int);
            if (((((MessageRecord)localArrayList1.get(0)).istroop == 1) && (localMessageRecord.istroop == 1)) || ((((MessageRecord)localArrayList1.get(0)).istroop == 3000) && (localMessageRecord.istroop == 3000) && (localObject4 != null)))
            {
              if (((bbpd)localObject4).f.jdField_a_of_type_Long != -1L) {
                ((bbpd)localObject4).f.b = this.jdField_a_of_type_Long;
              }
              if (((bbpd)localObject4).jdField_a_of_type_Bbpe.jdField_a_of_type_Long != -1L) {
                ((bbpd)localObject4).jdField_a_of_type_Bbpe.b = this.jdField_a_of_type_Long;
              }
              String str = localMessageRecord.frienduin;
              long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, localMessageRecord.istroop);
              if (QLog.isColorLevel()) {
                QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg update MessageInfo-- groupUin:" + str + "lastSeq:" + l + ",shMsgSeq:" + localMessageRecord.shmsgseq + ",msgInfo.hasFlag:" + ((bbpd)localObject4).a());
              }
              if ((localMessageRecord.shmsgseq > l) && (((bbpd)localObject4).a()))
              {
                localMessageRecord.mMessageInfo = ((bbpd)localObject4);
                localObject4 = (absl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1);
                ArrayList localArrayList2 = new ArrayList();
                localArrayList2.add(localMessageRecord);
                ((absl)localObject4).a(str, localArrayList2);
              }
            }
            if ((((MessageRecord)localArrayList1.get(0)).msgtype != -1035) || (localObject1 == null)) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(1000, true, this.jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg onDownload success end! cost:" + (System.currentTimeMillis() - this.b));
            }
            ((MessageForLongTextMsg)localMessageRecord).loading = false;
            ((aupa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, paramawir.jdField_a_of_type_Int, 1);
            return;
          }
          localMessageRecord.msg = ((MessageRecord)localArrayList1.get(0)).msg;
          localMessageRecord.saveExtInfoToExtStr("long_text_recv_state", "1");
          localMessageRecord.removeExtInfoToExtStr("long_text_msg_resid");
          continue;
          if (localObject2 == null) {
            continue;
          }
        }
        catch (Exception localException1)
        {
          localObject2 = localMessageRecord;
        }
      }
      catch (Exception localException2)
      {
        MessageRecord localMessageRecord;
        Object localObject2;
        Object localObject3 = null;
        continue;
      }
      if ((localObject2 instanceof MessageForLongTextMsg))
      {
        ((MessageForLongTextMsg)localObject2).loading = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(999, true, this.jdField_a_of_type_JavaLangString);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg onDownload exception! resultCode:" + paramawir.jdField_a_of_type_Int + ",errCode: " + paramawir.b + ",errStr:" + paramawir.jdField_a_of_type_JavaLangString + ",cost:" + (System.currentTimeMillis() - this.b));
        continue;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, localMessageRecord.msg);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, "extStr", localMessageRecord.extStr);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(999, true, this.jdField_a_of_type_JavaLangString);
        continue;
        ((MessageForLongTextMsg)localMessageRecord).loading = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(999, true, this.jdField_a_of_type_JavaLangString);
        continue;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        try
        {
          if ((localObject2 instanceof MessageForLongTextMsg))
          {
            ((MessageForLongTextMsg)localObject2).loading = false;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(999, true, this.jdField_a_of_type_JavaLangString);
          }
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg onDownload failed! resultCode:" + paramawir.jdField_a_of_type_Int + ",errCode: " + paramawir.b + ",errStr:" + paramawir.jdField_a_of_type_JavaLangString + ",cost:" + (System.currentTimeMillis() - this.b));
          }
        }
        catch (Exception localException3) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aupd
 * JD-Core Version:    0.7.0.1
 */