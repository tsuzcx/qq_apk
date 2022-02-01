import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessManager.1;
import com.tencent.mobileqq.confess.ConfessManager.2;
import com.tencent.mobileqq.confess.ConfessManager.3;
import com.tencent.mobileqq.confess.ConfessManager.4;
import com.tencent.mobileqq.confess.ConfessManager.5;
import com.tencent.mobileqq.confess.ConfessManager.6;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.manager.Manager;

public class aqvd
  implements Manager
{
  final aquy jdField_a_of_type_Aquy;
  aquz jdField_a_of_type_Aquz;
  public aqve a;
  public aqvf a;
  public final aqvp a;
  public QQAppInterface a;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  final ArrayList<aqve> jdField_a_of_type_JavaUtilArrayList;
  aqve jdField_b_of_type_Aqve = null;
  aqvf jdField_b_of_type_Aqvf = null;
  final Object jdField_b_of_type_JavaLangObject = new Object();
  final ArrayList<aqvf> jdField_b_of_type_JavaUtilArrayList;
  
  public aqvd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aqve = null;
    this.jdField_a_of_type_Aqvf = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Aqvp = new aqvp(paramQQAppInterface.getAccount());
    this.jdField_a_of_type_Aquy = new aquy();
    this.jdField_a_of_type_Aquz = new aquz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    ThreadManager.post(new ConfessManager.1(this), 5, null, true);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private aqve a(String paramString1, String paramString2, int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localaqve = (aqve)((Iterator)localObject).next();
          if ((localaqve == null) || (localaqve.jdField_a_of_type_Int != paramInt) || (!TextUtils.equals(localaqve.jdField_b_of_type_JavaLangString, paramString1)) || (!TextUtils.equals(localaqve.jdField_c_of_type_JavaLangString, paramString2))) {
            continue;
          }
          localObject = localaqve;
          if (localaqve == null)
          {
            localObject = new aqve();
            ((aqve)localObject).jdField_b_of_type_JavaLangString = paramString1;
            ((aqve)localObject).jdField_c_of_type_JavaLangString = paramString2;
            ((aqve)localObject).jdField_a_of_type_Int = paramInt;
            ((aqve)localObject).g = 0;
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
          return localObject;
        }
      }
      aqve localaqve = null;
    }
  }
  
  private aqvf a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        Object localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localaqvf = (aqvf)((Iterator)localObject).next();
          if ((localaqvf == null) || (localaqvf.jdField_a_of_type_Int != paramInt) || (!TextUtils.equals(localaqvf.jdField_a_of_type_JavaLangString, paramString1)) || (!TextUtils.equals(localaqvf.jdField_d_of_type_JavaLangString, paramString2)) || (!TextUtils.equals(localaqvf.jdField_b_of_type_JavaLangString, paramString3)) || (!TextUtils.equals(localaqvf.jdField_e_of_type_JavaLangString, paramString4))) {
            continue;
          }
          localObject = localaqvf;
          if (localaqvf == null)
          {
            localObject = new aqvf();
            ((aqvf)localObject).jdField_a_of_type_JavaLangString = paramString1;
            ((aqvf)localObject).jdField_d_of_type_JavaLangString = paramString2;
            ((aqvf)localObject).jdField_b_of_type_JavaLangString = paramString3;
            ((aqvf)localObject).jdField_e_of_type_JavaLangString = paramString4;
            ((aqvf)localObject).jdField_a_of_type_Int = paramInt;
            ((aqvf)localObject).jdField_e_of_type_Int = 0;
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          }
          return localObject;
        }
      }
      aqvf localaqvf = null;
    }
  }
  
  public int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages(paramString1, 0, new int[] { -2065 });
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof MessageForConfessNews));
        localObject2 = (MessageForConfessNews)localObject2;
        ((MessageForConfessNews)localObject2).parse();
      } while ((((MessageForConfessNews)localObject2).nTopicId != paramInt) || (!TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).strConfessorUin)) || (!TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)));
    }
    for (int i = 2;; i = 1)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "checkNeedAddConfessElem frdUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { paramString1, paramString3, Integer.valueOf(paramInt), Integer.valueOf(i) }));
      }
      return i;
    }
  }
  
  public int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages(paramString1, 1, new int[] { -2065 });
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof MessageForConfessNews));
        localObject2 = (MessageForConfessNews)localObject2;
        ((MessageForConfessNews)localObject2).parse();
      } while ((((MessageForConfessNews)localObject2).nTopicId != paramInt) || (!TextUtils.equals(paramString1, ((MessageForConfessNews)localObject2).strGroupUin)) || (!TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).senderuin)) || (!TextUtils.equals(paramString4, ((MessageForConfessNews)localObject2).strConfessorUin)) || (!TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)));
    }
    for (int i = 2;; i = 1)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "checkGroupNeedAddConfessElem groupUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { paramString1, paramString3, paramString4, Integer.valueOf(paramInt), Integer.valueOf(i) }));
      }
      return i;
    }
  }
  
  public aquy a()
  {
    return this.jdField_a_of_type_Aquy;
  }
  
  public aquz a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessManager", 2, "getConfigSync");
    }
    this.jdField_a_of_type_Aquz.a();
    return this.jdField_a_of_type_Aquz;
  }
  
  public aqve a()
  {
    return this.jdField_a_of_type_Aqve;
  }
  
  public aqvf a()
  {
    return this.jdField_a_of_type_Aqvf;
  }
  
  public aqvp a()
  {
    if (!this.jdField_a_of_type_Aqvp.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aqvp.a();
    }
    return this.jdField_a_of_type_Aqvp;
  }
  
  public void a(RedTouchItem paramRedTouchItem)
  {
    if (paramRedTouchItem == null) {
      return;
    }
    if (!this.jdField_a_of_type_Aqvp.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aqvp.a();
    }
    if ((this.jdField_a_of_type_Aqvp.jdField_a_of_type_Long < paramRedTouchItem.lastRecvTime) || (this.jdField_a_of_type_Aqvp.jdField_a_of_type_Int != paramRedTouchItem.count)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_Aqvp.a(paramRedTouchItem);
        aqvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false);
        ((aqva)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).b(this.jdField_a_of_type_Aqvp);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "onFrdRecNewConfess bNeedUpdate: %s, info: %s", new Object[] { Boolean.valueOf(bool), this.jdField_a_of_type_Aqvp }));
      return;
    }
  }
  
  public void a(String paramString)
  {
    Integer localInteger = null;
    aqve localaqve = this.jdField_a_of_type_Aqve;
    this.jdField_a_of_type_Aqve = null;
    if (localaqve != null)
    {
      this.jdField_b_of_type_Aqve = localaqve;
      if (localaqve.g == 1) {
        ThreadManager.postImmediately(new ConfessManager.3(this, paramString, localaqve), null, false);
      }
    }
    Locale localLocale;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (localaqve != null) {
        break label90;
      }
    }
    for (;;)
    {
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveFrdRecConfessChat frdUin: %s, flag: %s", new Object[] { paramString, localInteger }));
      return;
      label90:
      localInteger = Integer.valueOf(localaqve.g);
    }
  }
  
  public void a(String paramString, aqve paramaqve)
  {
    if ((paramaqve == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramaqve.g == 1)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages(paramString, 0, new int[] { -2065 });
          if ((paramString != null) && (paramString.size() > 0))
          {
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)paramString.next();
              if ((localMessageRecord instanceof MessageForConfessNews))
              {
                MessageForConfessNews localMessageForConfessNews = (MessageForConfessNews)localMessageRecord;
                localMessageForConfessNews.parse();
                if ((localMessageForConfessNews.nTopicId == paramaqve.jdField_a_of_type_Int) && (TextUtils.equals(paramaqve.jdField_c_of_type_JavaLangString, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramaqve.jdField_b_of_type_JavaLangString, localMessageForConfessNews.strRecUin)))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgFromCacheByUniseq(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
          }
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeFrdConfessNews frdUin: %s confessorUin: %s topicId: %s", new Object[] { paramaqve.jdField_b_of_type_JavaLangString, paramaqve.jdField_c_of_type_JavaLangString, Integer.valueOf(paramaqve.jdField_a_of_type_Int) }));
  }
  
  public void a(String paramString, aqve paramaqve, long paramLong1, long paramLong2)
  {
    if ((paramaqve == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramaqve.g == 0) {
          paramaqve.g = a(paramString, paramaqve.jdField_b_of_type_JavaLangString, paramaqve.jdField_c_of_type_JavaLangString, paramaqve.jdField_a_of_type_Int);
        }
        int i = paramaqve.g;
        if (i == 1) {}
        try
        {
          String str = paramaqve.a();
          if (!TextUtils.isEmpty(str))
          {
            MessageRecord localMessageRecord = bcsa.a(-2065);
            localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramString, str, paramLong1, -2065, 0, paramLong2);
            localMessageRecord.isread = true;
            if (!anyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(localMessageRecord, localMessageRecord.selfuin);
            }
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addFrdConfessNews frdUin: %s recUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramaqve.jdField_b_of_type_JavaLangString, paramaqve.jdField_c_of_type_JavaLangString, Integer.valueOf(paramaqve.jdField_a_of_type_Int) }));
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("ConfessManager", 1, "addFrdConfessNews error: " + localException.getMessage());
          }
        }
      }
    }
  }
  
  public void a(String paramString, aqvf paramaqvf)
  {
    if ((paramaqvf == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (paramaqvf.jdField_e_of_type_Int == 1)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages(paramString, 1, new int[] { -2065 });
          if ((paramString != null) && (paramString.size() > 0))
          {
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)paramString.next();
              if ((localMessageRecord instanceof MessageForConfessNews))
              {
                MessageForConfessNews localMessageForConfessNews = (MessageForConfessNews)localMessageRecord;
                localMessageForConfessNews.parse();
                if ((localMessageForConfessNews.nTopicId == paramaqvf.jdField_a_of_type_Int) && (TextUtils.equals(paramaqvf.jdField_a_of_type_JavaLangString, localMessageForConfessNews.strGroupUin)) && (TextUtils.equals(paramaqvf.jdField_e_of_type_JavaLangString, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramaqvf.jdField_b_of_type_JavaLangString, localMessageForConfessNews.senderuin)) && (TextUtils.equals(paramaqvf.jdField_d_of_type_JavaLangString, localMessageForConfessNews.strRecUin)))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgFromCacheByUniseq(localMessageRecord.frienduin, 1, localMessageRecord.msgtype, localMessageRecord.uniseq);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
          }
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeGroupConfessNews groupUin: %s, strRecUin: %s, sendUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramaqvf.jdField_a_of_type_JavaLangString, paramaqvf.jdField_d_of_type_JavaLangString, paramaqvf.jdField_b_of_type_JavaLangString, paramaqvf.jdField_e_of_type_JavaLangString, Integer.valueOf(paramaqvf.jdField_a_of_type_Int) }));
  }
  
  public void a(String paramString, aqvf paramaqvf, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramaqvf == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (paramaqvf.jdField_e_of_type_Int == 0) {
          paramaqvf.jdField_e_of_type_Int = a(paramString, paramaqvf.jdField_d_of_type_JavaLangString, paramaqvf.jdField_b_of_type_JavaLangString, paramaqvf.jdField_e_of_type_JavaLangString, paramaqvf.jdField_a_of_type_Int);
        }
        int i = paramaqvf.jdField_e_of_type_Int;
        if (i == 1) {}
        try
        {
          String str = paramaqvf.a();
          if (!TextUtils.isEmpty(str))
          {
            MessageRecord localMessageRecord = bcsa.a(-2065);
            localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramaqvf.jdField_b_of_type_JavaLangString, str, paramLong1, -2065, 1, paramLong2);
            localMessageRecord.isread = true;
            localMessageRecord.shmsgseq = paramLong3;
            if (QLog.isDevelopLevel()) {
              QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 1 %s", new Object[] { Long.valueOf(paramLong3) }));
            }
            if (!anyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(localMessageRecord, localMessageRecord.selfuin);
              if (QLog.isDevelopLevel()) {
                QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 2", new Object[0]));
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("ConfessManager", 1, "addGroupConfessNews error: " + localException.getMessage());
          }
        }
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews groupUin: %s recUin: %s, sendUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramaqvf.jdField_d_of_type_JavaLangString, paramaqvf.jdField_b_of_type_JavaLangString, paramaqvf.jdField_e_of_type_JavaLangString, Integer.valueOf(paramaqvf.jdField_a_of_type_Int) }));
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, paramInt).g = 2;
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "markFrdChatExtra recUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramInt).jdField_e_of_type_Int = 2;
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "markGroupChatExtra groupUin: %s recUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramString1, paramString2, paramString4, Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    Object localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    Object localObject2;
    boolean bool;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aqvf)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((aqvf)localObject2).jdField_a_of_type_Int == paramInt) && (TextUtils.equals(((aqvf)localObject2).jdField_a_of_type_JavaLangString, paramString1)) && (TextUtils.equals(((aqvf)localObject2).jdField_d_of_type_JavaLangString, paramString2)) && (TextUtils.equals(((aqvf)localObject2).jdField_b_of_type_JavaLangString, paramString3)) && (TextUtils.equals(((aqvf)localObject2).jdField_e_of_type_JavaLangString, paramString4))) {
          if (((aqvf)localObject2).jdField_a_of_type_Boolean)
          {
            ((aqvf)localObject2).jdField_a_of_type_Boolean = false;
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, "checkUpdateGroupMessageForConfessNewsShmsgseq find: " + bool + " shmsgseq: " + paramLong);
      }
      if (bool)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages(paramString1, 1, new int[] { -2065 });
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if ((localObject2 instanceof MessageForConfessNews))
            {
              localObject2 = (MessageForConfessNews)localObject2;
              ((MessageForConfessNews)localObject2).parse();
              if ((((MessageForConfessNews)localObject2).nTopicId == paramInt) && (TextUtils.equals(paramString1, ((MessageForConfessNews)localObject2).strGroupUin)) && (TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).senderuin)) && (TextUtils.equals(paramString4, ((MessageForConfessNews)localObject2).strConfessorUin)) && (TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)))
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateGroupMsgSeqAndTimeByUniseq(((MessageForConfessNews)localObject2).frienduin, ((MessageForConfessNews)localObject2).istroop, ((MessageForConfessNews)localObject2).uniseq, paramLong, ((MessageForConfessNews)localObject2).time);
                if (QLog.isDevelopLevel()) {
                  QLog.i("ConfessManager", 4, "checkUpdateGroupMessageForConfessNewsShmsgseq updated");
                }
              }
            }
          }
        }
      }
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMessages(paramString1, 1, 6);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (MessageRecord)((List)localObject1).get(i);
          if ((localObject2 instanceof MessageForConfessNews))
          {
            localObject2 = (MessageForConfessNews)localObject2;
            ((MessageForConfessNews)localObject2).parse();
            if ((((MessageForConfessNews)localObject2).nTopicId == paramInt) && (TextUtils.equals(paramString1, ((MessageForConfessNews)localObject2).strGroupUin)) && (TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).senderuin)) && (TextUtils.equals(paramString4, ((MessageForConfessNews)localObject2).strConfessorUin)) && (TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)))
            {
              int j = i + 1;
              if (j < ((List)localObject1).size())
              {
                localObject2 = (MessageRecord)((List)localObject1).get(j);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateGroupMsgSeqAndTimeByUniseq(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).time);
              }
            }
          }
          i += 1;
        }
      }
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    aqve localaqve = this.jdField_a_of_type_Aqve;
    if ((TextUtils.isEmpty(paramString)) || (localaqve == null) || (!TextUtils.equals(localaqve.jdField_b_of_type_JavaLangString, paramString))) {
      bool = false;
    }
    do
    {
      return bool;
      if (localaqve.g == 0) {
        localaqve.g = a(paramString, localaqve.jdField_b_of_type_JavaLangString, localaqve.jdField_c_of_type_JavaLangString, localaqve.jdField_a_of_type_Int);
      }
    } while (localaqve.g == 1);
    return false;
  }
  
  public boolean a(String paramString, Intent paramIntent)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIntent == null)) {
      return false;
    }
    String str1 = paramIntent.getStringExtra("key_confess_rec_uin");
    String str2 = paramIntent.getStringExtra("key_confessor_uin");
    int i = paramIntent.getIntExtra("key_confess_topicid", 0);
    String str3 = paramIntent.getStringExtra("key_confess_desc");
    String str4 = paramIntent.getStringExtra("key_confessor_nick");
    int j = paramIntent.getIntExtra("key_confessor_sex", 0);
    int k = paramIntent.getIntExtra("key_confess_bg_type", 0);
    String str5 = paramIntent.getStringExtra("key_confess_rec_nick_name");
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    if ((!TextUtils.equals(paramString, str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str3)) || (i == 0)) {
      return false;
    }
    paramIntent = a(str1, str2, i);
    if (!TextUtils.isEmpty(str5)) {
      paramIntent.jdField_a_of_type_JavaLangString = str5;
    }
    paramIntent.jdField_e_of_type_JavaLangString = str4;
    paramIntent.jdField_c_of_type_Int = j;
    paramIntent.jdField_d_of_type_JavaLangString = str3;
    paramIntent.jdField_b_of_type_Int = k;
    paramIntent.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_Aqve = paramIntent;
    if (paramIntent.g != 2) {
      ThreadManager.postImmediately(new ConfessManager.2(this, paramString), null, false);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterFrdRecConfessChat recUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(paramIntent.g) }));
    }
    return true;
  }
  
  public aquz b()
  {
    return this.jdField_a_of_type_Aquz;
  }
  
  public void b(String paramString)
  {
    Integer localInteger = null;
    aqvf localaqvf = this.jdField_a_of_type_Aqvf;
    this.jdField_a_of_type_Aqvf = null;
    if (localaqvf != null)
    {
      this.jdField_b_of_type_Aqvf = localaqvf;
      if (localaqvf.jdField_e_of_type_Int == 1) {
        ThreadManager.postImmediately(new ConfessManager.5(this, paramString, localaqvf), null, false);
      }
    }
    Locale localLocale;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (localaqvf != null) {
        break label90;
      }
    }
    for (;;)
    {
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveGroupRecConfessChat groupUin: %s, flag: %s", new Object[] { paramString, localInteger }));
      return;
      label90:
      localInteger = Integer.valueOf(localaqvf.jdField_e_of_type_Int);
    }
  }
  
  public boolean b(String paramString)
  {
    aqvf localaqvf = this.jdField_a_of_type_Aqvf;
    if ((TextUtils.isEmpty(paramString)) || (localaqvf == null) || (!TextUtils.equals(localaqvf.jdField_a_of_type_JavaLangString, paramString))) {
      return false;
    }
    if (localaqvf.jdField_e_of_type_Int == 0) {
      localaqvf.jdField_e_of_type_Int = a(paramString, localaqvf.jdField_d_of_type_JavaLangString, localaqvf.jdField_b_of_type_JavaLangString, localaqvf.jdField_e_of_type_JavaLangString, localaqvf.jdField_a_of_type_Int);
    }
    return localaqvf.jdField_e_of_type_Int == 1;
  }
  
  public boolean b(String paramString, Intent paramIntent)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return false;
    }
    int i = paramIntent.getIntExtra("key_confess_topicid", 0);
    String str1 = paramIntent.getStringExtra("key_confess_desc");
    String str2 = paramIntent.getStringExtra("key_confessor_uin");
    String str3 = paramIntent.getStringExtra("key_confessor_nick");
    int j = paramIntent.getIntExtra("key_confessor_sex", 0);
    int k = paramIntent.getIntExtra("key_confess_bg_type", 0);
    String str4 = paramIntent.getStringExtra("key_confess_rec_uin");
    String str5 = paramIntent.getStringExtra("key_confess_rec_nick_name");
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    int m = paramIntent.getIntExtra("key_confess_rec_nick_type", 0);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    if ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str1)) || (i == 0)) {
      return false;
    }
    aqvf localaqvf = a(paramString, str4, paramIntent, str2, i);
    if (!TextUtils.isEmpty(str5)) {
      localaqvf.jdField_c_of_type_JavaLangString = str5;
    }
    localaqvf.g = str3;
    localaqvf.jdField_c_of_type_Int = j;
    localaqvf.f = str1;
    localaqvf.jdField_b_of_type_Int = k;
    localaqvf.jdField_a_of_type_Long = l;
    localaqvf.jdField_d_of_type_Int = m;
    this.jdField_a_of_type_Aqvf = localaqvf;
    if (localaqvf.jdField_e_of_type_Int != 2) {
      ThreadManager.postImmediately(new ConfessManager.4(this, paramString, localaqvf), null, false);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat recUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str4, paramIntent, str2, Integer.valueOf(i), Integer.valueOf(localaqvf.jdField_e_of_type_Int) }));
    }
    return true;
  }
  
  public boolean c(String paramString, Intent paramIntent)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIntent == null)) {
      return false;
    }
    String str1 = paramIntent.getStringExtra("key_confess_rec_uin");
    String str2 = paramIntent.getStringExtra("key_confessor_uin");
    int i = paramIntent.getIntExtra("key_confess_topicid", 0);
    String str3 = paramIntent.getStringExtra("key_confessor_nick");
    int j = paramIntent.getIntExtra("key_confessor_sex", 0);
    int k = paramIntent.getIntExtra("key_confessor_friend_sex", 0);
    String str4 = paramIntent.getStringExtra("key_confess_desc");
    int m = paramIntent.getIntExtra("key_confess_bg_type", 0);
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    int n = paramIntent.getIntExtra("key_confessor_num", 0);
    if ((!TextUtils.equals(paramString, str1)) || (TextUtils.isEmpty(str4)) || (i == 0)) {
      return false;
    }
    paramIntent = a(str1, str2, i);
    paramIntent.jdField_c_of_type_Int = j;
    paramIntent.jdField_e_of_type_Int = k;
    paramIntent.jdField_d_of_type_JavaLangString = str4;
    paramIntent.jdField_e_of_type_JavaLangString = str3;
    paramIntent.jdField_b_of_type_Int = m;
    paramIntent.jdField_a_of_type_Long = l;
    paramIntent.jdField_d_of_type_Int = n;
    paramIntent.f = 1;
    this.jdField_a_of_type_Aqve = paramIntent;
    if (paramIntent.g != 2) {
      ThreadManager.postImmediately(new ConfessManager.6(this, paramString), null, false);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterFrdRankConfessChat recUin: %s, confessorUin: %s, topicId: %s, flag: %s, friendSex: %s, extra.strConfessorNick : %s", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(paramIntent.g), Integer.valueOf(k), paramIntent.jdField_e_of_type_JavaLangString }));
    }
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvd
 * JD-Core Version:    0.7.0.1
 */