import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.1;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.2;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.3;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.5;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.6;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import java.util.Map;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class bdzb
  implements Manager
{
  public final SparseArray<bdys> a;
  public QQAppInterface a;
  protected final List<String> a;
  protected final Map<String, bdyr> a;
  protected boolean a;
  public final SparseArray<TroopAioKeywordTipInfo> b;
  public final List<String> b;
  protected boolean b;
  
  public bdzb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = 2147483647;
    for (;;)
    {
      int j;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label101;
        }
        localObject2 = (String)localIterator.next();
        j = paramString.indexOf((String)localObject2);
        if ((j < 0) || (j >= i)) {
          break label98;
        }
        if (j == 0) {
          return localObject2;
        }
      }
      Object localObject1 = localObject2;
      i = j;
      label98:
      for (;;)
      {
        break;
      }
      label101:
      Object localObject2 = localObject1;
    }
  }
  
  private String a(String paramString1, String paramString2, Integer paramInteger)
  {
    return paramString1 + "_" + paramString2 + "_" + paramInteger;
  }
  
  private List<Integer> a(MessageRecord arg1)
  {
    Object localObject1 = ???.getExtInfoFromExtStr("key_aio_keyword");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        localObject1 = (bdyr)this.jdField_a_of_type_JavaUtilMap.get(localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((bdyr)localObject1).jdField_a_of_type_JavaUtilList;
          return localObject1;
        }
      }
    }
    return null;
  }
  
  private void a(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo, bdze parambdze)
  {
    if (parambdze != null) {
      ThreadManager.getUIHandler().post(new TroopAioKeywordTipManager.5(this, parambdze, paramMessageRecord, paramTroopAioKeywordTipInfo));
    }
  }
  
  private void a(Integer paramInteger, MessageRecord paramMessageRecord, bdze parambdze)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramInteger);
    ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).a(localArrayList, new bdzd(this, paramMessageRecord, parambdze));
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    a();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
          return false;
        }
        if (!TextUtils.equals(paramMessageRecord.getExtInfoFromExtStr("key_is_checked_aio_keyword"), "1")) {
          break;
        }
        if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("key_aio_keyword")))
        {
          bool = true;
          return bool;
        }
      }
      bool = false;
    }
    Object localObject2 = b(paramMessageRecord);
    ??? = null;
    Iterator localIterator = ((List)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = a((String)localIterator.next());
      ??? = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramMessageRecord.saveExtInfoToExtStr("key_aio_keyword", (String)localObject2);
        ??? = localObject2;
      }
    }
    paramMessageRecord.saveExtInfoToExtStr("key_is_checked_aio_keyword", "1");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgFieldByUniseq(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
    if (!TextUtils.isEmpty((CharSequence)???)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean a(Integer paramInteger, int paramInt, MessageRecord paramMessageRecord)
  {
    Object localObject1;
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      localObject1 = (bdys)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInteger.intValue());
      if (localObject1 == null) {
        return false;
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaUtilList.addAll(bdyq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        this.jdField_b_of_type_Boolean = true;
      }
      paramInteger = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageRecord.getExtInfoFromExtStr("key_aio_keyword"), paramInteger);
      if ((!paramMessageRecord.isSend()) && (this.jdField_b_of_type_JavaUtilList.contains(paramInteger)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, blackUinKeyRuleId=" + paramInteger);
        }
        return false;
      }
      if ((((bdys)localObject1).b > NetConnInfoCenter.getServerTime()) || (((bdys)localObject1).c < NetConnInfoCenter.getServerTime()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, not support timelimit, currentTime=" + NetConnInfoCenter.getServerTime() + ",ruleInfo.startTime =" + ((bdys)localObject1).b + ",ruleInfo.endTime=" + ((bdys)localObject1).c);
        }
        return false;
      }
    }
    if ((((bdys)localObject1).d & paramInt) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, not support positionFlag, ruleInfo.positionFlag=" + ((bdys)localObject1).d + ", curInvokeType=" + paramInt);
      }
      return false;
    }
    if ((((bdys)localObject1).jdField_a_of_type_JavaUtilList != null) && (((bdys)localObject1).jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, ruleInfo.troopTypes == null");
      }
      paramInteger = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramMessageRecord.frienduin);
      if (!((bdys)localObject1).jdField_a_of_type_JavaUtilList.contains(Integer.valueOf((int)paramInteger.dwGroupClassExt)))
      {
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("[");
          localObject1 = ((bdys)localObject1).jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramMessageRecord.append(((Integer)((Iterator)localObject1).next()).intValue());
            paramMessageRecord.append(",");
          }
          paramMessageRecord.append("]");
          QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, not support troopType, troopTypes=" + paramMessageRecord.toString() + ",mCurType=" + paramInteger.dwGroupClassExt);
        }
        return false;
      }
    }
    return true;
  }
  
  private List<String> b(MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -1051))
    {
      paramMessageRecord = (MessageForText)paramMessageRecord;
      if (paramMessageRecord.sb == null) {
        paramMessageRecord.parse();
      }
      if (paramMessageRecord.sb != null) {
        localArrayList.add(paramMessageRecord.sb.toString().toLowerCase());
      }
    }
    do
    {
      do
      {
        do
        {
          return localArrayList;
        } while (paramMessageRecord.msgtype != -2011);
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
        if (paramMessageRecord.structingMsg == null) {
          paramMessageRecord.parse();
        }
      } while (!(paramMessageRecord.structingMsg instanceof AbsShareMsg));
      paramMessageRecord = (AbsShareMsg)paramMessageRecord.structingMsg;
      if (!TextUtils.isEmpty(paramMessageRecord.mContentTitle)) {
        localArrayList.add(paramMessageRecord.mContentTitle.toLowerCase());
      }
      if (!TextUtils.isEmpty(paramMessageRecord.mContentSummary)) {
        localArrayList.add(paramMessageRecord.mContentSummary.toLowerCase());
      }
    } while (TextUtils.isEmpty(paramMessageRecord.mMsgUrl));
    localArrayList.add(paramMessageRecord.mMsgUrl.toLowerCase());
    return localArrayList;
  }
  
  private void b(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ThreadManager.post(new TroopAioKeywordTipManager.2(this, paramList), 8, null, true);
  }
  
  public Pair<MessageRecord, Integer> a(List<MessageRecord> paramList, List<String> paramList1, int paramInt)
  {
    Iterator localIterator1 = paramList.iterator();
    Object localObject1 = null;
    paramList = null;
    Object localObject2;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        localObject2 = (MessageRecord)localIterator1.next();
        if (a((MessageRecord)localObject2))
        {
          Object localObject3 = a((MessageRecord)localObject2);
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            Iterator localIterator2 = ((List)localObject3).iterator();
            for (;;)
            {
              if (localIterator2.hasNext())
              {
                localObject3 = (Integer)localIterator2.next();
                if (((paramList1 == null) || (!paramList1.contains(((MessageRecord)localObject2).getExtInfoFromExtStr("key_aio_keyword") + "_" + localObject3))) && (a((Integer)localObject3, paramInt, (MessageRecord)localObject2)))
                {
                  localObject1 = localObject3;
                  paramList = (List<MessageRecord>)localObject2;
                  label160:
                  if (localObject1 == null) {
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return new Pair(paramList, localObject1);
      localObject2 = localObject1;
      localObject1 = paramList;
      paramList = (List<MessageRecord>)localObject2;
      break;
      localObject2 = paramList;
      paramList = (List<MessageRecord>)localObject1;
      localObject1 = localObject2;
      break label160;
      paramList1 = paramList;
      paramList = (List<MessageRecord>)localObject1;
      localObject1 = paramList1;
    }
  }
  
  public void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        oidb_0x496.AioKeyword localAioKeyword = bdyq.a();
        a(bdyq.a(localAioKeyword), bdyq.b(localAioKeyword));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString1, String paramString2, Integer paramInteger)
  {
    ThreadManager.post(new TroopAioKeywordTipManager.6(this, paramString1, paramString2, paramInteger), 8, null, true);
  }
  
  public void a(List<? extends MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ThreadManager.post(new TroopAioKeywordTipManager.1(this, paramList), 5, null, true);
  }
  
  public void a(List<bdyr> arg1, List<bdys> paramList1)
  {
    if (??? != null)
    {
      Object localObject2;
      try
      {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          localObject2 = ???.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            bdyr localbdyr = (bdyr)((Iterator)localObject2).next();
            this.jdField_a_of_type_JavaUtilList.add(localbdyr.jdField_a_of_type_JavaLangString.toLowerCase());
          }
        }
      }
      finally {}
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        ??? = ???.iterator();
        if (???.hasNext())
        {
          localObject2 = (bdyr)???.next();
          this.jdField_a_of_type_JavaUtilMap.put(((bdyr)localObject2).jdField_a_of_type_JavaLangString.toLowerCase(), localObject2);
        }
      }
    }
    if (paramList1 != null) {
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.clear();
        paramList1 = paramList1.iterator();
        if (paramList1.hasNext())
        {
          ??? = (bdys)paramList1.next();
          this.jdField_a_of_type_AndroidUtilSparseArray.put(((bdys)???).jdField_a_of_type_Int, ???);
        }
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(List<MessageRecord> paramList, List<String> paramList1, int paramInt, bdze parambdze)
  {
    ThreadManager.post(new TroopAioKeywordTipManager.3(this, paramList, paramList1, paramInt, parambdze), 8, null, true);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdzb
 * JD-Core Version:    0.7.0.1
 */