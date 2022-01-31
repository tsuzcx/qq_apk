import AccostSvc.Msg;
import AccostSvc.MsgItem;
import AccostSvc.RichMsg;
import AccostSvc.SvrMsg;
import AccostSvc.UserInfo;
import MessageSvcPack.AccostMsg;
import MessageSvcPack.SvcGetMsgInfo;
import MessageSvcPack.SvcResponseGetMsgV2;
import QQService.PushCardMsg;
import QQService.PushType;
import QQService.PushVoteIncreaseInfo;
import android.database.Cursor;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class amkh
  extends absm
{
  public amkh(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private RichMsg a(byte[] paramArrayOfByte)
  {
    try
    {
      RichMsg localRichMsg = new RichMsg();
      return localRichMsg;
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        localRichMsg.readFrom(paramArrayOfByte);
        return localRichMsg;
      }
      catch (Exception paramArrayOfByte) {}
      paramArrayOfByte = paramArrayOfByte;
      return null;
    }
  }
  
  private void a(long paramLong, amkk paramamkk)
  {
    ArrayList localArrayList = paramamkk.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    try
    {
      while (i < localArrayList.size())
      {
        Object localObject1 = (MsgItem)localArrayList.get(i);
        new String(((MsgItem)localObject1).MsgContent);
        if (-56 == ((MsgItem)localObject1).cType)
        {
          localObject1 = new JceInputStream(((MsgItem)localObject1).MsgContent);
          ((JceInputStream)localObject1).setServerEncoding("utf-8");
          Object localObject2 = new PushCardMsg();
          ((PushCardMsg)localObject2).readFrom((JceInputStream)localObject1);
          if (PushType.PUSH_TYPE_VOTE_INCR.value() == ((PushCardMsg)localObject2).ePushType)
          {
            localObject2 = new JceInputStream(((PushCardMsg)localObject2).vPushInfo);
            ((JceInputStream)localObject2).setServerEncoding("utf-8");
            localObject1 = new PushVoteIncreaseInfo();
            ((PushVoteIncreaseInfo)localObject1).readFrom((JceInputStream)localObject2);
            if (((PushVoteIncreaseInfo)localObject1).iIncrement > 0)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject2 = (alpk)((QQAppInterface)localObject2).a(2);
              if (localObject2 != null) {
                ((alpk)localObject2).a((PushVoteIncreaseInfo)localObject1, String.valueOf(paramLong), String.valueOf(paramamkk.jdField_a_of_type_Long));
              }
            }
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramamkk)
    {
      paramamkk.printStackTrace();
    }
  }
  
  private void a(long paramLong, amkk paramamkk, SvcGetMsgInfo paramSvcGetMsgInfo, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramamkk.jdField_a_of_type_JavaUtilArrayList;
    String str2 = paramamkk.jdField_a_of_type_JavaLangString;
    int m = 0;
    int i = -1000;
    Object localObject3;
    String str1;
    int j;
    if (m < localArrayList2.size())
    {
      localObject3 = (MsgItem)localArrayList2.get(m);
      str1 = null;
      if (((MsgItem)localObject3).MsgContent != null) {
        str1 = new String(((MsgItem)localObject3).MsgContent);
      }
      j = ((MsgItem)localObject3).cType;
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleAccostMsgItemResp msgItem.cType:" + ((MsgItem)localObject3).cType + " isReaded:" + paramBoolean);
        }
        switch (j)
        {
        default: 
          localObject1 = null;
          j = i;
          localObject3 = localObject1;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        int k;
        long l2;
        if ((((MsgItem)localObject3).MsgContent == null) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "----------handleAccostMsgItemResp msgItem.MsgContent:" + bdhe.a(((MsgItem)localObject3).MsgContent));
        localObject3 = null;
        j = i;
        continue;
        if (paramamkk.jdField_a_of_type_Int != 201) {
          continue;
        }
        localObject2 = bdex.a((String)localObject3, str2);
        if (j != -2000) {
          continue;
        }
        i = -1032;
        long l1 = l2;
        continue;
        if (j != -2002) {
          continue;
        }
        i = -1031;
        l1 = l2;
        continue;
        i = -1003;
        l1 = l2;
        continue;
        if (paramamkk.jdField_a_of_type_Int != 6) {
          continue;
        }
        a(str2, paramLong, false);
        localObject2 = bdex.a((String)localObject3, str2);
        i = -3001;
        l1 = l2;
        continue;
        l1 = l2;
        localObject2 = localObject3;
        i = j;
        if (str2 == null) {
          continue;
        }
        l1 = l2;
        localObject2 = localObject3;
        i = j;
        if (str2.length() <= 0) {
          continue;
        }
        localObject2 = bdex.a((String)localObject3, str2);
        i = -3000;
        l1 = l2;
        continue;
        if (!(localObject3 instanceof MessageForPtt)) {
          continue;
        }
        localObject2 = (MessageForPtt)localObject3;
        ((MessageForPtt)localObject2).subVersion = 2;
        ((MessageForPtt)localObject2).url = str1;
        ((MessageForPtt)localObject2).urlAtServer = str1;
        ((MessageForPtt)localObject2).itemType = 2;
        ((MessageForPtt)localObject2).fileSize = 0L;
        ((MessageForPtt)localObject2).isread = false;
        continue;
      }
      k = j;
      if (localObject3 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleAccostMsgItemResp accostMsg.eAccostType" + paramamkk.jdField_a_of_type_Int + "accostMsg.msgId: " + paramamkk.jdField_b_of_type_Long + " accostMsg.time" + paramamkk.c + " msgConten: " + bdeu.a((String)localObject3));
        }
        l2 = paramamkk.jdField_a_of_type_Long;
        if (paramamkk.jdField_a_of_type_Int != 1) {
          continue;
        }
        l1 = 9999L;
        i = j;
        localObject1 = localObject3;
        localObject3 = azaf.a(i);
        ((MessageRecord)localObject3).init(paramLong, l1, paramamkk.jdField_a_of_type_Long, (String)localObject1, paramamkk.c, i, 1001, 0L);
        ((MessageRecord)localObject3).shmsgseq = paramamkk.jdField_b_of_type_Long;
        ((MessageRecord)localObject3).isread = paramBoolean;
        if ((paramSvcGetMsgInfo != null) && (paramSvcGetMsgInfo.vReserved != null) && (paramSvcGetMsgInfo.vReserved.length >= 2))
        {
          ((MessageRecord)localObject3).longMsgCount = paramSvcGetMsgInfo.vReserved[0];
          ((MessageRecord)localObject3).longMsgIndex = paramSvcGetMsgInfo.vReserved[1];
          ((MessageRecord)localObject3).longMsgId = paramSvcGetMsgInfo.vReserved[2];
        }
        if (!(localObject3 instanceof MessageForPic)) {
          continue;
        }
        localObject1 = (MessageForPic)localObject3;
        ((MessageForPic)localObject1).subVersion = 2;
        if (i == -2000)
        {
          ((MessageForPic)localObject1).path = str1;
          ((MessageForPic)localObject1).uuid = str1;
          ((MessageForPic)localObject1).size = 0L;
          ((MessageForPic)localObject1).type = 1;
          ((MessageForPic)localObject1).isRead = false;
        }
        k = i;
        if (!alww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3, false))
        {
          localArrayList1.add(localObject3);
          k = i;
        }
      }
      m += 1;
      i = k;
      break;
      if (((MsgItem)localObject3).MsgContent != null)
      {
        localObject1 = new String(azah.a(((MsgItem)localObject3).MsgContent), "utf-8");
        break label954;
        localObject1 = bays.a(str1, 0L, 1, false, str1);
        i = -2000;
        continue;
        localObject1 = bays.a(str1, 0L, 2, false, str1);
        i = -2002;
        continue;
        a(paramLong, paramBoolean, paramamkk);
        return;
        if (localArrayList1.size() <= 0) {
          continue;
        }
        boolean bool = alww.a(localArrayList1);
        i = abti.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramamkk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramamkk.a(localArrayList1, String.valueOf(paramLong), paramBoolean);
          a("handleAccostMsgItemResp", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool), false);
          return;
        }
      }
      else
      {
        localObject2 = null;
      }
      label954:
      i = -1000;
    }
  }
  
  private void a(long paramLong1, ArrayList<AccostMsg> paramArrayList, ArrayList<amkj> paramArrayList1, ArrayList<SvcGetMsgInfo> paramArrayList2, long paramLong2, String paramString)
  {
    int i = 0;
    AccostMsg localAccostMsg;
    if (i < paramArrayList.size())
    {
      localAccostMsg = (AccostMsg)paramArrayList.get(i);
      if ((paramArrayList2 == null) || (paramArrayList2.size() <= i)) {
        break label342;
      }
    }
    label342:
    for (SvcGetMsgInfo localSvcGetMsgInfo = (SvcGetMsgInfo)paramArrayList2.get(i);; localSvcGetMsgInfo = null)
    {
      Object localObject = new amkj();
      ((amkj)localObject).jdField_a_of_type_Long = localAccostMsg.lFromMID;
      ((amkj)localObject).jdField_b_of_type_Long = localAccostMsg.lToMID;
      ((amkj)localObject).c = localAccostMsg.uMsgID;
      ((amkj)localObject).jdField_a_of_type_Short = localAccostMsg.shMsgType;
      paramArrayList1.add(localObject);
      boolean bool = a(String.valueOf(paramLong1), String.valueOf(localAccostMsg.lFromMID));
      if (QLog.isColorLevel())
      {
        alww.a("Q.msg.BaseMessageProcessor", paramString, localAccostMsg.uMsgID, String.valueOf(paramLong1), String.valueOf(localAccostMsg.lToMID));
        QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleGetAccostMessageResp fromBlackList: " + bool + "accostMsg.shMsgType: " + localAccostMsg.shMsgType);
      }
      if (!bool) {
        switch (localAccostMsg.shMsgType)
        {
        }
      }
      ArrayList localArrayList;
      do
      {
        do
        {
          i += 1;
          break;
          localObject = a(localAccostMsg.strMsg);
        } while (localObject == null);
        localArrayList = ((RichMsg)localObject).VecMsg;
      } while ((localArrayList == null) || (localArrayList.size() <= 0));
      paramLong2 = localAccostMsg.lFromMID;
      if (localAccostMsg.eAccostType == 0) {}
      for (int j = localAccostMsg.iAccostType;; j = localAccostMsg.eAccostType)
      {
        a(paramLong1, new amkk(paramLong2, j, localAccostMsg.uMsgID, localAccostMsg.iMsgTime, localArrayList, ((RichMsg)localObject).sAction), localSvcGetMsgInfo, false);
        break;
      }
      return;
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, amkk paramamkk)
  {
    ArrayList localArrayList = new ArrayList();
    long l = paramamkk.d;
    if (l == paramLong) {}
    SystemMsg localSystemMsg;
    for (int i = 1;; i = 0)
    {
      new ArrayList();
      localSystemMsg = new SystemMsg();
      localObject = new StringBuffer();
      int j = 0;
      while (j < paramamkk.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((StringBuffer)localObject).append(new String(((MsgItem)paramamkk.jdField_a_of_type_JavaUtilArrayList.get(j)).MsgContent));
        if (j < paramamkk.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          ((StringBuffer)localObject).append("\n");
        }
        j += 1;
      }
    }
    localSystemMsg.sMsg = ((StringBuffer)localObject).toString();
    localSystemMsg.auth = paramamkk.jdField_a_of_type_ArrayOfByte;
    localSystemMsg.lToMobile = paramamkk.e;
    localSystemMsg.strNickName = paramamkk.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "addFriendRequestByOldVersion, addUin=" + paramamkk.d + ", msgUid=" + paramamkk.jdField_b_of_type_Long + ", msg=" + localSystemMsg.sMsg);
    }
    Object localObject = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(String.valueOf(l));
    label320:
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      localObject = bdgc.a((Friends)localObject);
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label558;
      }
      localSystemMsg.message = (l + BaseApplication.getContext().getString(2131689663));
      localObject = new JceOutputStream();
      ((JceOutputStream)localObject).setServerEncoding("UTF-8");
      localSystemMsg.writeTo((JceOutputStream)localObject);
      localObject = bdhe.a(((JceOutputStream)localObject).toByteArray());
      if (localObject != null)
      {
        localMessageRecord = azaf.a(-1011);
        localMessageRecord.init(paramLong, 9998L, l, (String)localObject, 0L, -1011, 0, paramamkk.c);
        localMessageRecord.shmsgseq = 187L;
        localMessageRecord.msgUid = paramamkk.jdField_b_of_type_Long;
        if (paramBoolean) {
          localMessageRecord.isread = true;
        }
        if (i == 0) {
          break label593;
        }
        i = 1;
        label427:
        localMessageRecord.issend = i;
        if (alww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, true)) {
          break label599;
        }
        localArrayList.add(localMessageRecord);
      }
    }
    for (;;)
    {
      if (localArrayList.size() > 0)
      {
        i = abti.a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(9998L), 0, localArrayList, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList, String.valueOf(paramLong));
        a("addFriendRequestByOldVersion", true, i, true, false);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localArrayList);
      }
      return;
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(String.valueOf(l));
      localObject = null;
      break;
      label558:
      localSystemMsg.message = ((String)localObject + BaseApplication.getContext().getString(2131689663));
      break label320;
      label593:
      i = 0;
      break label427;
      label599:
      if (QLog.isColorLevel()) {
        QLog.d("MessageHandler", 2, "addFriendRequestByOldVersion, the message is remove by msgFilter, addUin=" + paramamkk.d + ", msgUid=" + localMessageRecord.msgUid + ", msg=" + localSystemMsg.sMsg);
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      paramObject = (SvrMsg)paramObject;
      if (paramObject.stMsg != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePushAccostMsg sMsg.stMsg is null");
    return;
    if (paramFromServiceMsg.getUin() == null)
    {
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      boolean bool = a(paramFromServiceMsg.getUin(), String.valueOf(paramObject.stMsg.lFromMID));
      if (QLog.isColorLevel()) {
        alww.a("Q.msg.BaseMessageProcessor", (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR"), paramObject.stMsg.uMsgID, paramToServiceMsg, String.valueOf(paramObject.stMsg.lFromMID));
      }
      if (!bool) {
        switch (paramObject.stMsg.shMsgType)
        {
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramObject);
      return;
      paramToServiceMsg = paramFromServiceMsg.getUin();
      break;
      if ((paramObject.bResend != 1) || (!a(paramToServiceMsg, String.valueOf(paramObject.stMsg.lFromMID), paramObject.stMsg.uMsgID)))
      {
        paramFromServiceMsg = a(paramObject.stMsg.strMsg);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.VecMsg != null))
        {
          Object localObject = paramFromServiceMsg.VecMsg;
          localObject = new amkk(paramObject.stMsg.lFromMID, paramObject.stMsg.eAccostType, paramObject.stMsg.uMsgID, paramObject.stMsg.iMsgTime, (ArrayList)localObject, paramFromServiceMsg.sAction);
          if (paramFromServiceMsg.stSender != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePushAccostMsg richMsg.stSender is null");
            }
            ((amkk)localObject).d = paramFromServiceMsg.stSender.lMobileUin;
            ((amkk)localObject).jdField_a_of_type_ArrayOfByte = paramFromServiceMsg.stSender.sig;
            ((amkk)localObject).jdField_b_of_type_JavaLangString = paramFromServiceMsg.stSender.nickname;
          }
          ((amkk)localObject).e = paramObject.stMsg.lFromMID;
          a(Long.valueOf(paramToServiceMsg).longValue(), (amkk)localObject, null, false);
          continue;
          paramFromServiceMsg = a(paramObject.stMsg.strMsg);
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg = new amkk(paramObject.stMsg.lFromMID, paramFromServiceMsg.VecMsg);
            a(Long.valueOf(paramToServiceMsg).longValue(), paramFromServiceMsg);
          }
        }
      }
    }
  }
  
  private void a(String paramString, long paramLong, boolean paramBoolean)
  {
    paramString = bfiu.a(paramString);
    String str = (String)paramString.get("appid");
    paramString = (String)paramString.get("via");
    if (TextUtils.isEmpty("via")) {
      paramString = "ANDROIDQQ.PCPUSH";
    }
    for (;;)
    {
      if (str != null) {
        bfnj.a().a(String.valueOf(paramLong), str, paramString, "100", paramBoolean);
      }
      return;
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    paramString1 = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(paramString2);
    return (paramString1 != null) && (paramString1.groupid == -1002);
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong)
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(String.valueOf(paramString1)).createEntityManager();
    paramString1 = localawgf.a(false, MessageRecord.getTableName(paramString2, 1001), null, "msgseq=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        i = paramString1.getCount();
        if (paramString1 != null) {
          paramString1.close();
        }
        paramString1 = localawgf.a(false, MessageRecord.getTableName(paramString2, 10002), null, "msgseq=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
        int j = 0;
        if (paramString1 != null) {}
        return false;
      }
      finally
      {
        try
        {
          j = paramString1.getCount();
          if (paramString1 != null) {
            paramString1.close();
          }
          if (j + i <= 0) {
            break label165;
          }
          return true;
        }
        finally
        {
          if (paramString1 == null) {
            break label163;
          }
          paramString1.close();
        }
        paramString2 = finally;
        if (paramString1 != null) {
          paramString1.close();
        }
      }
      label163:
      label165:
      int i = 0;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (SvcResponseGetMsgV2)paramObject;
    if ((paramObject == null) || (paramObject.cReplyCode != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    }
    label315:
    label321:
    label337:
    for (;;)
    {
      return;
      int i;
      label125:
      ArrayList localArrayList1;
      if (paramFromServiceMsg.getUin() == null)
      {
        paramFromServiceMsg = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        long l = paramFromServiceMsg.longValue();
        int j = paramObject.cMoreMsg;
        paramFromServiceMsg = paramObject.vCookies;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder().append("<GetMsgV4><R>--->handleGetLbsMessageResp ssoSeq:").append(paramToServiceMsg.getRequestSsoSeq()).append(" msgStruct.cReplyCode: ").append(paramObject.cReplyCode).append(" vCookies:").append(paramFromServiceMsg).append(" size:");
          if (paramFromServiceMsg == null) {
            break label315;
          }
          i = paramFromServiceMsg.length;
          QLog.d("Q.msg.BaseMessageProcessor", 2, i);
        }
        paramToServiceMsg = paramObject.vAccostMsg;
        localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = paramObject.vMsgInfos;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleGetLbsMessageResp : moreMsg: " + j + "cSyncFlag:" + paramObject.cSyncFlag);
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleGetC2CMessageResp accostMsg size: " + paramToServiceMsg.size());
          }
          a(l, paramToServiceMsg, localArrayList1, localArrayList2, 0L, "handleGetLbsMessageResp");
        }
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.length <= 0)) {
          break label321;
        }
        a(paramFromServiceMsg, paramObject.cSyncFlag);
      }
      for (;;)
      {
        if (localArrayList1.size() <= 0) {
          break label337;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(null, localArrayList1);
        return;
        paramFromServiceMsg = Long.valueOf(paramFromServiceMsg.getUin());
        break;
        i = 0;
        break label125;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleGetLbsMessageResp. final resp of LbsMessage.");
        }
      }
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.BaseMessageProcessor", 2, "<GetMsgV4><E>handleGetLbsOfflineMessageError ");
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 5001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<GetMsgV4><S>--->getLbsOfflineMsg : cChannel:4,syncFlag:" + paramInt);
    }
    a(false, false, false, 0L, new amki(this, paramArrayOfByte, paramInt));
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.BaseMessageProcessor", 2, "<GetMsgV4><E>handleGetLbsOfflineMessageTimeOut ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amkh
 * JD-Core Version:    0.7.0.1
 */