import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aznq
  extends akpu
{
  private agvx jdField_a_of_type_Agvx;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  public Comparator a;
  
  public aznq(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_JavaUtilComparator = new aznr(this);
  }
  
  protected int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.extraflag == 32772) {}
    for (paramMessageRecord = a(paramMessageRecord, false, paramBoolean); paramMessageRecord == null; paramMessageRecord = a(paramMessageRecord, -2006, paramBoolean)) {
      return -1;
    }
    if (paramMessageRecord.isread) {
      return 1;
    }
    return 2;
  }
  
  protected int a(String paramString, int paramInt, long paramLong)
  {
    int i = 0;
    String str = MessageRecord.getTableName(paramString, paramInt);
    str = String.format("select * from (select count() as unReadNum from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d'),%s m where m.%s>'%d' order by %s limit 1", new Object[] { str, "shmsgseq", Long.valueOf(paramLong), str, "shmsgseq", Long.valueOf(paramLong), "shmsgseq desc , _id desc" });
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = a().a(QQMessageFacade.Message.class, str, null);
    paramInt = i;
    if (paramString != null)
    {
      paramInt = i;
      if (!paramString.isEmpty()) {
        paramInt = ((QQMessageFacade.Message)paramString.get(0)).unReadNum;
      }
    }
    return paramInt;
  }
  
  protected int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 0;
    paramString = MessageRecord.getTableName(paramString, paramInt);
    aukx localaukx = a();
    String str = "( msgtype " + akpx.b() + " and isValid=1 ) and shmsgseq <= ?";
    long l = paramMessageRecord.shmsgseq;
    paramString = localaukx.a(false, paramString, new String[] { "_id" }, str, new String[] { String.valueOf(l) }, null, null, null, null);
    paramInt = i;
    if (paramString != null)
    {
      paramInt = paramString.getCount();
      paramString.close();
    }
    return paramInt;
  }
  
  protected int a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0) {
      return -1;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      a((MessageRecord)localIterator.next(), paramBoolean);
    }
    return paramList.size();
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    List localList = b(paramString, paramInt);
    MessageRecord localMessageRecord = a(paramString, paramInt, paramMessageRecord, localList);
    Object localObject = localMessageRecord;
    if (localMessageRecord == null)
    {
      localObject = localMessageRecord;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a != null)
      {
        localList.clear();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.frienduin.equals(paramString)) && (localMessageRecord.istroop == paramInt)) {
            localList.add(localMessageRecord);
          }
        }
        paramString = a(paramString, paramInt, paramMessageRecord, localList);
        localObject = paramString;
        if (paramString != null)
        {
          QLog.d("Q.msg.TroopMsgProxy", 1, "getSendingTroopMsgItem in send cache;");
          localObject = paramString;
        }
      }
    }
    return localObject;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    if ((paramMessageRecord == null) || (paramList == null) || (paramList.isEmpty()) || (paramMessageRecord.msgtype == -2006))
    {
      paramMessageRecord = null;
      return paramMessageRecord;
    }
    paramInt = paramList.size() - 1;
    label43:
    if (paramInt >= 0) {
      if (akpx.a((MessageRecord)paramList.get(paramInt), paramMessageRecord, true, true)) {
        paramString = (MessageRecord)paramList.get(paramInt);
      }
    }
    for (;;)
    {
      paramMessageRecord = paramString;
      if (paramString == null) {
        break;
      }
      paramMessageRecord = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.TroopMsgProxy", 2, "getSendingTroopMsgItem: find msg =" + paramString.getLogColorContent() + " , mr.seq = " + paramString.shmsgseq + " , mr.time = " + paramString.time + " , mr.msgtype = " + paramString.msgtype + " , extra = " + paramString.extraflag);
      return paramString;
      if ((((MessageRecord)paramList.get(paramInt)).msgtype == -2011) && (paramMessageRecord.msgtype == -2011))
      {
        if (paramMessageRecord.msgUid == ((MessageRecord)paramList.get(paramInt)).msgUid) {
          paramString = (MessageRecord)paramList.get(paramInt);
        }
      }
      else if ((((MessageRecord)paramList.get(paramInt)).msgtype == -2048) && (paramMessageRecord.msgtype == -2048))
      {
        paramString = (MessageForTroopReward)paramList.get(paramInt);
        MessageForTroopReward localMessageForTroopReward = (MessageForTroopReward)paramMessageRecord;
        if (paramString.rewardSeq == localMessageForTroopReward.rewardSeq)
        {
          paramString = (MessageRecord)paramList.get(paramInt);
          continue;
        }
      }
      paramInt -= 1;
      break label43;
      paramString = null;
    }
  }
  
  protected String a(Cursor paramCursor, SessionInfo paramSessionInfo, int paramInt)
  {
    return paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "queryTroopMessageFromDB_UnionTables, peerUin = " + paramString + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", endSeq " + paramLong2 + ",count = " + paramInt3 + ",customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt1);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfInt != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfInt.length > 0)
      {
        localObject1 = new StringBuilder(" and msgtype in ( ");
        int i = 0;
        while (i < paramArrayOfInt.length)
        {
          ((StringBuilder)localObject1).append(paramArrayOfInt[i]);
          if (i < paramArrayOfInt.length - 1) {
            ((StringBuilder)localObject1).append(" , ");
          }
          i += 1;
        }
        ((StringBuilder)localObject1).append(" ) ");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramString = bbfd.a(MessageRecord.getOldTableName(paramString, paramInt1), MessageRecord.getTableName(paramString, paramInt1), paramLong1, paramInt2, paramLong2, (String)localObject1, paramInt3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b());
    if (paramString == null) {
      paramString = new ArrayList();
    }
    do
    {
      return paramString;
      paramString = paramString.toString();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMsgProxy", 2, "queryTroopMessageFromDB_UnionTables " + paramString);
      }
      paramArrayOfInt = a().a(paramString, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString = paramArrayOfInt;
    } while (paramArrayOfInt != null);
    return new ArrayList();
  }
  
  protected List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "queryMessageByTimeOrSeq:uin=" + paramString1 + ",type=" + paramInt1 + ",seq=" + paramLong + ",count=" + paramInt2);
    }
    if (a(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    }
    if (bbfd.a(MessageRecord.getTableName(paramString1, paramInt1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b()))
    {
      paramString1 = b(paramString1, paramInt1, paramLong, paramInt2, paramString2);
      if (paramString1 != null) {
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = c(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.shmsgseq == paramLong1) && ((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.extraflag == 0)) && (!akpx.a(localMessageRecord))) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      paramString = f(paramString, paramInt, paramLong1, paramLong2);
      if ((paramString != null) && (!paramString.isEmpty())) {
        localArrayList.addAll(paramString);
      }
    }
    return localArrayList;
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy_" + MsgLruCache.TAG, 2, "getAIOMsgList peerUin: " + paramString + " type: " + paramInt + " , autoInit = " + paramBoolean1);
    }
    Object localObject1;
    int i;
    Object localObject4;
    MessageRecord localMessageRecord;
    for (;;)
    {
      synchronized (akpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        localObject1 = (List)akpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(a(paramString, paramInt));
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          break label1310;
        }
        if (!paramBoolean1) {
          break label1267;
        }
        localObject1 = new axrt();
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          i = 1;
          ((axrt)localObject1).jdField_a_of_type_Int = i;
          ((axrt)localObject1).jdField_a_of_type_JavaLangString = "select";
          ((axrt)localObject1).jdField_b_of_type_JavaLangString = "AIO";
          localObject4 = a(paramString, paramInt, (axrt)localObject1);
          if ((((axrt)localObject1).jdField_b_of_type_Int != 0) && (axrn.a()) && (axrn.a(1)))
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("param_IsMainThread", String.valueOf(((axrt)localObject1).jdField_a_of_type_Int));
            ((HashMap)localObject2).put("param_OptType", ((axrt)localObject1).jdField_a_of_type_JavaLangString);
            ((HashMap)localObject2).put("param_OptTotalCost", String.valueOf(((axrt)localObject1).jdField_a_of_type_Long));
            ((HashMap)localObject2).put("param_OptCount", String.valueOf(((axrt)localObject1).jdField_b_of_type_Int));
            ((HashMap)localObject2).put("param_OptMsgCount", String.valueOf(((axrt)localObject1).c));
            ((HashMap)localObject2).put("param_OptOneCost", String.valueOf(((axrt)localObject1).jdField_b_of_type_Long));
            ((HashMap)localObject2).put("param_OptScene", ((axrt)localObject1).jdField_b_of_type_JavaLangString);
            ((HashMap)localObject2).put("param_WalSwitch", String.valueOf(akfu.a));
            axrn.a(BaseApplication.getContext()).a(null, "actSqliteOptCost", true, ((axrt)localObject1).c, 0L, (HashMap)localObject2, null, false);
          }
          if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
            break label1254;
          }
          if ((!QLog.isColorLevel()) || (!bbkj.a())) {
            break label541;
          }
          localObject1 = new StringBuilder(((List)localObject4).size() * 48 + 28);
          ((StringBuilder)localObject1).append("getAIOMsgList, msgInfoList: ");
          localObject2 = ((List)localObject4).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append("(").append(localMessageRecord.time).append(",").append(localMessageRecord.shmsgseq).append(",").append(localMessageRecord.msgtype).append(") ");
        }
      }
      i = 0;
    }
    QLog.d("Q.msg.TroopMsgProxy", 2, ((StringBuilder)localObject1).toString());
    label541:
    new ArrayList();
    Object localObject2 = akpx.a((List)localObject4, false);
    if ((paramBoolean2) && (paramInt == 1) && (!((List)localObject2).isEmpty()) && (((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq > this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString, paramInt)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, ((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq);
      if ((((List)localObject2).size() >= ((List)localObject4).size()) || (((List)localObject2).size() >= 10)) {
        break label1138;
      }
      long l = ((MessageRecord)((List)localObject2).get(0)).shmsgseq;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt) < l)
      {
        a(paramString, paramInt, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString, paramInt, l);
      }
    }
    if ((!akpx.a(paramString, paramInt, (List)localObject2)) && (akpx.b((List)localObject2)))
    {
      localObject1 = localObject2;
      if (!akpx.c((List)localObject2)) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList : pull more long msg");
      }
      localObject1 = akpx.a((List)localObject4, false, 30);
    }
    if ((!akpx.a((List)localObject1)) && (localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject2 = b((List)localObject4, ((MessageRecord)((List)localObject1).get(0)).shmsgseq);
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        localObject1 = localObject2;
        label852:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMsgProxy", 2, "continuedList :" + ((List)localObject2).size());
        }
        Collections.sort((List)localObject2, this.jdField_a_of_type_JavaUtilComparator);
        akpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().put(a(paramString, paramInt), localObject2);
        label942:
        paramString = (List)akpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(a(paramString, paramInt));
      }
    }
    for (;;)
    {
      int k;
      int j;
      try
      {
        if ((!QLog.isColorLevel()) || (paramString == null)) {
          return paramString;
        }
        QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList from aiopool size = " + paramString.size());
        k = paramString.size();
        i = 0;
        if (i >= k) {
          return paramString;
        }
        localObject1 = (MessageRecord)paramString.get(i);
        if ((((MessageRecord)localObject1).frienduin.equals("927334240")) && (((MessageRecord)localObject1).shmsgseq == 798L) && (((MessageRecord)localObject1).msgtype == -1012))
        {
          if (i - 3 >= 0)
          {
            paramInt = i - 3;
            break label1390;
            if (paramInt >= j) {
              continue;
            }
            QLog.d("Q.msg.TroopMsgProxy", 2, "print illegel mr" + ((MessageRecord)localObject1).toString());
            paramInt += 1;
            continue;
            label1138:
            a(paramString, paramInt, false);
            break;
            localObject2 = e(paramString, paramInt, 15);
            if (QLog.isColorLevel())
            {
              localObject4 = ((List)localObject2).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                localMessageRecord = (MessageRecord)((Iterator)localObject4).next();
                QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList from DB query valid msg " + localMessageRecord.getBaseInfoString());
                continue;
              }
            }
            if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
              break label1387;
            }
            localObject1 = akpx.a((List)localObject2, true);
            break label852;
            label1254:
            localObject1 = d(paramString, paramInt, 15);
            break label852;
            label1267:
            akpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().remove(a(paramString, paramInt));
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.TroopMsgProxy", 2, "MsgPool.getPoolInstance().getAioMsgPool().remove :");
            }
            return null;
            label1310:
            if (!QLog.isColorLevel()) {
              break label942;
            }
            QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList from aiopool size = " + ((List)localObject1).size());
            break label942;
          }
          paramInt = 0;
          break label1390;
          j = k;
          continue;
        }
        i += 1;
        continue;
      }
      catch (Throwable localThrowable)
      {
        QLog.d("Q.msg.TroopMsgProxy", 2, "aiopool", localThrowable);
        return paramString;
      }
      label1387:
      label1390:
      if (i + 3 <= k) {
        j = i + 3;
      }
    }
    return paramString;
  }
  
  protected void a(SessionInfo paramSessionInfo, String paramString, int paramInt, Set<String> paramSet)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 1026: 
      paramSessionInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramString);
      paramString = paramSessionInfo.iterator();
      while (paramString.hasNext()) {
        paramSet.add(((TroopMemberInfo)paramString.next()).memberuin);
      }
      paramSessionInfo.clear();
      return;
    }
    paramSessionInfo = ((ajvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(paramString);
    paramString = paramSessionInfo.iterator();
    while (paramString.hasNext()) {
      paramSet.add(((DiscussionMemberInfo)paramString.next()).memberUin);
    }
    paramSessionInfo.clear();
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    String str1 = String.valueOf(paramLong);
    String str2 = MessageRecord.getTableName(paramString, paramInt);
    if ((akpx.a(paramInt)) && (akpx.d() != null))
    {
      a(paramString, paramInt, str2, localContentValues, String.format("isread=? and %s<=? and " + akpx.d(), new Object[] { "shmsgseq" }), new String[] { "0", str1 }, null);
      return;
    }
    a(paramString, paramInt, str2, localContentValues, String.format("isread=? and %s<=?", new Object[] { "shmsgseq" }), new String[] { "0", str1 }, null);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, aktd paramaktd, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString, paramInt, paramMessageRecord, paramBoolean3);
    if (paramMessageRecord.shmsgseq <= 0L)
    {
      if (paramMessageRecord.shmsgseq < 0L) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMsgProxy", 2, "addMessage() msg discard !!! 1: peerUin = [" + paramString + "], type = [" + paramInt + "], mr = [" + paramMessageRecord + "]");
        }
      }
      do
      {
        return;
        if (akpx.a(paramMessageRecord)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.TroopMsgProxy", 2, "addMessage() msg discard !!! 2: peerUin = [" + paramString + "], type = [" + paramInt + "], mr = [" + paramMessageRecord + "]");
      return;
    }
    a(paramString, paramInt, paramMessageRecord, paramaktd, paramBoolean1, paramBoolean2);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "insertToList " + paramMessageRecord.getBaseInfoString());
    }
    label706:
    for (;;)
    {
      Object localObject1;
      int i;
      int j;
      synchronized (akpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        Object localObject3 = d(paramString, paramInt);
        localObject1 = a(paramString, paramInt);
        a(paramString, paramInt, (String)localObject1, (List)localObject3);
        if ((paramMessageRecord.isSendFromLocal()) || ((akpx.a(paramMessageRecord)) && (paramMessageRecord.msgtype != -4012) && (paramMessageRecord.msgtype != -4009) && (paramMessageRecord.msgtype != -5001) && (paramMessageRecord.msgtype != -5021)) || (akpx.f(paramMessageRecord)))
        {
          if ((localObject3 == null) || (((List)localObject3).isEmpty()) || (((MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1)).shmsgseq <= 0L)) {
            break label618;
          }
          if ((!akpx.i(paramMessageRecord.msgtype)) || (paramMessageRecord.shmsgseq <= 0L)) {}
        }
        else
        {
          akpx.a((List)localObject3, paramMessageRecord, true);
          if ((localObject3 != null) && (((List)localObject3).size() > 40) && (!akpx.a(paramString)))
          {
            ((List)localObject3).remove(0);
            localObject3 = akpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a();
            if ((akry.a) && (((MsgLruCache)localObject3).getCacheType(localObject1) == akry.d)) {
              ((MsgLruCache)localObject3).changeCacheType(localObject1, akry.c);
            }
          }
          if ((akpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().containsKey(localObject1)) && (paramBoolean))
          {
            localObject1 = (List)akpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(localObject1);
            if (localObject1 != null) {
              break label626;
            }
            localObject1 = new ArrayList();
            if ((!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.jdField_b_of_type_Int != 3211265)) {
              break label779;
            }
            i = 1;
            if ((!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.jdField_b_of_type_Int != 655392)) {
              break label773;
            }
            j = 1;
            if ((paramMessageRecord.msgtype != -4009) && (paramMessageRecord.msgtype != -4012) && (i == 0) && (j == 0)) {
              break label706;
            }
            akpx.a((List)localObject1, paramMessageRecord, true);
            if ((paramMessageRecord.msgtype == -2006) && (agvx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramString)) && ((paramMessageRecord instanceof MessageForFoldMsg)) && (!paramMessageRecord.isSend()))
            {
              if (this.jdField_a_of_type_Agvx == null) {
                this.jdField_a_of_type_Agvx = ((agvx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125));
              }
              this.jdField_a_of_type_Agvx.a((List)localObject1, (MessageForFoldMsg)paramMessageRecord);
            }
          }
          return;
          QLog.d("Q.msg.TroopMsgProxy", 1, "insertToList " + paramMessageRecord.getUserLogString());
          continue;
        }
        paramMessageRecord.shmsgseq = ((MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1)).shmsgseq;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.TroopMsgProxy", 2, "insertToList change seq " + paramMessageRecord.getBaseInfoString());
      }
      label618:
      paramMessageRecord.shmsgseq = 0L;
      continue;
      label626:
      if ((((List)localObject1).size() > 200) && (paramMessageRecord.istroop == 1)) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
        }
        else if (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.g(paramString))
        {
          QLog.d("yellowye", 2, "list.remove(0)");
          ((List)localObject1).remove(0);
          break label785;
          if (paramMessageRecord.msgtype == -4021)
          {
            akpx.b((List)localObject1, paramMessageRecord, true);
          }
          else if (((paramMessageRecord instanceof MessageForConfessNews)) && (paramMessageRecord.msgtype == -2065) && (paramMessageRecord.istroop == 1))
          {
            akpx.a((List)localObject1, paramMessageRecord, false);
          }
          else
          {
            ((List)localObject1).add(paramMessageRecord);
            continue;
            j = 0;
            continue;
            i = 0;
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    synchronized (akpt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.msgtype == -4004) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 1, localMessageRecord.msgtype, localMessageRecord.uniseq);
        }
      }
    }
    super.a(paramString, paramInt, paramList);
  }
  
  protected void a(String paramString, int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new Thread(new TroopAndDiscMsgProxy.2(this, paramBoolean), "report_troop_aio_break"), 5, null, true);
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong1);
    int j = 0;
    if (localMessageRecord != null) {
      if (localMessageRecord.shmsgseq > 0L) {
        break label189;
      }
    }
    label189:
    for (int i = 1;; i = 0)
    {
      localMessageRecord.shmsgseq = paramLong2;
      localMessageRecord.time = paramLong3;
      if ((localMessageRecord.extraflag == 32772) || (localMessageRecord.extraflag == 32768))
      {
        localMessageRecord.extraflag = 0;
        localMessageRecord.sendFailCode = 0;
        if (!localMessageRecord.isValid)
        {
          localMessageRecord.msgtype = -2006;
          localMessageRecord.isValid = true;
        }
      }
      f(paramString, paramInt, paramLong1);
      a(paramString, paramInt, localMessageRecord);
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.TroopMsgProxy", 2, "update msgSeq set msg =" + localMessageRecord.getBaseInfoString());
        j = i;
      }
      if ((localMessageRecord == null) || (!localMessageRecord.isSendFromLocal()) || (j == 0)) {
        break;
      }
      a(paramString, paramInt, localMessageRecord, null);
      return localMessageRecord;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("shmsgseq", Long.valueOf(paramLong2));
    localContentValues.put("time", Long.valueOf(paramLong3));
    if (localMessageRecord != null)
    {
      localContentValues.put("msgtype", Integer.valueOf(localMessageRecord.msgtype));
      localContentValues.put("isValid", Boolean.valueOf(localMessageRecord.isValid));
      if (localMessageRecord.extraflag == 0)
      {
        localContentValues.put("extraflag", Integer.valueOf(0));
        localContentValues.put("sendFailCode", Integer.valueOf(0));
      }
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
    return localMessageRecord;
  }
  
  protected String b(String paramString, int paramInt)
  {
    return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where _id in (select _id from " + MessageRecord.getTableName(paramString, paramInt) + " order by shmsgseq desc limit " + 40 + ") order by shmsgseq desc, _id desc";
  }
  
  protected List<MessageRecord> b(List<MessageRecord> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (localMessageRecord.shmsgseq >= paramLong) {}
      label130:
      for (;;)
      {
        i -= 1;
        break;
        if ((localMessageRecord.isValid) && ((localMessageRecord.msgtype != -2006) || ((localMessageRecord instanceof MessageForFoldMsg)))) {}
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label130;
          }
          long l = localMessageRecord.shmsgseq;
          localArrayList.add(0, localMessageRecord);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.e();
    aukr localaukr = a().a();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String[] arrayOfString = localSQLiteDatabase.b();
    if (arrayOfString == null) {
      return;
    }
    aumb localaumb = (aumb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(201);
    int i = 0;
    label62:
    String str1;
    if (i < arrayOfString.length)
    {
      str1 = arrayOfString[i];
      if ((!str1.startsWith("mr_discusssion")) && (!str1.startsWith("mr_troop"))) {
        break label421;
      }
    }
    label330:
    Object localObject3;
    label421:
    for (Object localObject1 = "select frienduin, istroop, shmsgseq as tmpseq, issend from " + str1 + " where shmsgseq=(select max(shmsgseq) from " + str1 + ")";; localObject3 = null)
    {
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("", 2, "sql zsw =" + (String)localObject1);
        }
        localObject1 = localSQLiteDatabase.a((String)localObject1, null);
        if (localObject1 == null) {}
      }
      try
      {
        if (((Cursor)localObject1).getCount() > 0)
        {
          ((Cursor)localObject1).moveToFirst();
          long l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("tmpseq"));
          String str2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("frienduin"));
          int j = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndexOrThrow("istroop"));
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str2, j, l);
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        if (localaukr == null) {}
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
      try
      {
        localaukr.a();
        localSQLiteDatabase.a(str1, null, null);
        if (localaukr != null) {
          localaukr.c();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.msg.TroopMsgProxy", 2, "clearAllHistoryFromDB: ", localException);
        if (localObject4 == null) {
          break label330;
        }
        localObject4.b();
        break label330;
      }
      finally
      {
        if (localObject4 == null) {
          continue;
        }
        localObject4.b();
      }
      if (localaumb != null) {
        localaumb.a(str1, null, null);
      }
      i += 1;
      break label62;
      break;
    }
  }
  
  protected List<MessageRecord> f(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + apug.e(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong1 + "] msgUid[" + paramLong2 + "]");
    }
    if ((paramLong1 == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.TroopMsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq=?";
    aukx localaukx = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramString = localaukx.a(paramString, new String[] { String.valueOf(paramLong1) }, localQQAppInterface);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aznq
 * JD-Core Version:    0.7.0.1
 */