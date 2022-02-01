import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
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

public class aqyp
  implements Manager
{
  final aqyk jdField_a_of_type_Aqyk;
  aqyl jdField_a_of_type_Aqyl;
  public aqyq a;
  public aqyr a;
  public final aqzb a;
  public QQAppInterface a;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  final ArrayList<aqyq> jdField_a_of_type_JavaUtilArrayList;
  aqyq jdField_b_of_type_Aqyq = null;
  aqyr jdField_b_of_type_Aqyr = null;
  final Object jdField_b_of_type_JavaLangObject = new Object();
  final ArrayList<aqyr> jdField_b_of_type_JavaUtilArrayList;
  
  public aqyp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aqyq = null;
    this.jdField_a_of_type_Aqyr = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Aqzb = new aqzb(paramQQAppInterface.getAccount());
    this.jdField_a_of_type_Aqyk = new aqyk();
    this.jdField_a_of_type_Aqyl = new aqyl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    ThreadManager.post(new ConfessManager.1(this), 5, null, true);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private aqyq a(String paramString1, String paramString2, int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localaqyq = (aqyq)((Iterator)localObject).next();
          if ((localaqyq == null) || (localaqyq.jdField_a_of_type_Int != paramInt) || (!TextUtils.equals(localaqyq.jdField_b_of_type_JavaLangString, paramString1)) || (!TextUtils.equals(localaqyq.jdField_c_of_type_JavaLangString, paramString2))) {
            continue;
          }
          localObject = localaqyq;
          if (localaqyq == null)
          {
            localObject = new aqyq();
            ((aqyq)localObject).jdField_b_of_type_JavaLangString = paramString1;
            ((aqyq)localObject).jdField_c_of_type_JavaLangString = paramString2;
            ((aqyq)localObject).jdField_a_of_type_Int = paramInt;
            ((aqyq)localObject).g = 0;
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
          return localObject;
        }
      }
      aqyq localaqyq = null;
    }
  }
  
  private aqyr a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        Object localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localaqyr = (aqyr)((Iterator)localObject).next();
          if ((localaqyr == null) || (localaqyr.jdField_a_of_type_Int != paramInt) || (!TextUtils.equals(localaqyr.jdField_a_of_type_JavaLangString, paramString1)) || (!TextUtils.equals(localaqyr.jdField_d_of_type_JavaLangString, paramString2)) || (!TextUtils.equals(localaqyr.jdField_b_of_type_JavaLangString, paramString3)) || (!TextUtils.equals(localaqyr.jdField_e_of_type_JavaLangString, paramString4))) {
            continue;
          }
          localObject = localaqyr;
          if (localaqyr == null)
          {
            localObject = new aqyr();
            ((aqyr)localObject).jdField_a_of_type_JavaLangString = paramString1;
            ((aqyr)localObject).jdField_d_of_type_JavaLangString = paramString2;
            ((aqyr)localObject).jdField_b_of_type_JavaLangString = paramString3;
            ((aqyr)localObject).jdField_e_of_type_JavaLangString = paramString4;
            ((aqyr)localObject).jdField_a_of_type_Int = paramInt;
            ((aqyr)localObject).jdField_e_of_type_Int = 0;
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          }
          return localObject;
        }
      }
      aqyr localaqyr = null;
    }
  }
  
  public int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 0, new int[] { -2065 });
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 1, new int[] { -2065 });
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
  
  public aqyk a()
  {
    return this.jdField_a_of_type_Aqyk;
  }
  
  public aqyl a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessManager", 2, "getConfigSync");
    }
    this.jdField_a_of_type_Aqyl.a();
    return this.jdField_a_of_type_Aqyl;
  }
  
  public aqyq a()
  {
    return this.jdField_a_of_type_Aqyq;
  }
  
  public aqyr a()
  {
    return this.jdField_a_of_type_Aqyr;
  }
  
  public aqzb a()
  {
    if (!this.jdField_a_of_type_Aqzb.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aqzb.a();
    }
    return this.jdField_a_of_type_Aqzb;
  }
  
  public void a(RedTouchItem paramRedTouchItem)
  {
    if (paramRedTouchItem == null) {
      return;
    }
    if (!this.jdField_a_of_type_Aqzb.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aqzb.a();
    }
    if ((this.jdField_a_of_type_Aqzb.jdField_a_of_type_Long < paramRedTouchItem.lastRecvTime) || (this.jdField_a_of_type_Aqzb.jdField_a_of_type_Int != paramRedTouchItem.count)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_Aqzb.a(paramRedTouchItem);
        aqyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false);
        ((aqym)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125)).b(this.jdField_a_of_type_Aqzb);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "onFrdRecNewConfess bNeedUpdate: %s, info: %s", new Object[] { Boolean.valueOf(bool), this.jdField_a_of_type_Aqzb }));
      return;
    }
  }
  
  public void a(String paramString)
  {
    Integer localInteger = null;
    aqyq localaqyq = this.jdField_a_of_type_Aqyq;
    this.jdField_a_of_type_Aqyq = null;
    if (localaqyq != null)
    {
      this.jdField_b_of_type_Aqyq = localaqyq;
      if (localaqyq.g == 1) {
        ThreadManager.postImmediately(new ConfessManager.3(this, paramString, localaqyq), null, false);
      }
    }
    Locale localLocale;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (localaqyq != null) {
        break label90;
      }
    }
    for (;;)
    {
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveFrdRecConfessChat frdUin: %s, flag: %s", new Object[] { paramString, localInteger }));
      return;
      label90:
      localInteger = Integer.valueOf(localaqyq.g);
    }
  }
  
  public void a(String paramString, aqyq paramaqyq)
  {
    if ((paramaqyq == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramaqyq.g == 1)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 0, new int[] { -2065 });
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
                if ((localMessageForConfessNews.nTopicId == paramaqyq.jdField_a_of_type_Int) && (TextUtils.equals(paramaqyq.jdField_c_of_type_JavaLangString, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramaqyq.jdField_b_of_type_JavaLangString, localMessageForConfessNews.strRecUin)))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
          }
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeFrdConfessNews frdUin: %s confessorUin: %s topicId: %s", new Object[] { paramaqyq.jdField_b_of_type_JavaLangString, paramaqyq.jdField_c_of_type_JavaLangString, Integer.valueOf(paramaqyq.jdField_a_of_type_Int) }));
  }
  
  public void a(String paramString, aqyq paramaqyq, long paramLong1, long paramLong2)
  {
    if ((paramaqyq == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramaqyq.g == 0) {
          paramaqyq.g = a(paramString, paramaqyq.jdField_b_of_type_JavaLangString, paramaqyq.jdField_c_of_type_JavaLangString, paramaqyq.jdField_a_of_type_Int);
        }
        int i = paramaqyq.g;
        if (i == 1) {}
        try
        {
          String str = paramaqyq.a();
          if (!TextUtils.isEmpty(str))
          {
            MessageRecord localMessageRecord = bcry.a(-2065);
            localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramString, str, paramLong1, -2065, 0, paramLong2);
            localMessageRecord.isread = true;
            if (!aoci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
            }
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addFrdConfessNews frdUin: %s recUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramaqyq.jdField_b_of_type_JavaLangString, paramaqyq.jdField_c_of_type_JavaLangString, Integer.valueOf(paramaqyq.jdField_a_of_type_Int) }));
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
  
  public void a(String paramString, aqyr paramaqyr)
  {
    if ((paramaqyr == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (paramaqyr.jdField_e_of_type_Int == 1)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 1, new int[] { -2065 });
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
                if ((localMessageForConfessNews.nTopicId == paramaqyr.jdField_a_of_type_Int) && (TextUtils.equals(paramaqyr.jdField_a_of_type_JavaLangString, localMessageForConfessNews.strGroupUin)) && (TextUtils.equals(paramaqyr.jdField_e_of_type_JavaLangString, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramaqyr.jdField_b_of_type_JavaLangString, localMessageForConfessNews.senderuin)) && (TextUtils.equals(paramaqyr.jdField_d_of_type_JavaLangString, localMessageForConfessNews.strRecUin)))
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 1, localMessageRecord.msgtype, localMessageRecord.uniseq);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
          }
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeGroupConfessNews groupUin: %s, strRecUin: %s, sendUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramaqyr.jdField_a_of_type_JavaLangString, paramaqyr.jdField_d_of_type_JavaLangString, paramaqyr.jdField_b_of_type_JavaLangString, paramaqyr.jdField_e_of_type_JavaLangString, Integer.valueOf(paramaqyr.jdField_a_of_type_Int) }));
  }
  
  public void a(String paramString, aqyr paramaqyr, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramaqyr == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (paramaqyr.jdField_e_of_type_Int == 0) {
          paramaqyr.jdField_e_of_type_Int = a(paramString, paramaqyr.jdField_d_of_type_JavaLangString, paramaqyr.jdField_b_of_type_JavaLangString, paramaqyr.jdField_e_of_type_JavaLangString, paramaqyr.jdField_a_of_type_Int);
        }
        int i = paramaqyr.jdField_e_of_type_Int;
        if (i == 1) {}
        try
        {
          String str = paramaqyr.a();
          if (!TextUtils.isEmpty(str))
          {
            MessageRecord localMessageRecord = bcry.a(-2065);
            localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramaqyr.jdField_b_of_type_JavaLangString, str, paramLong1, -2065, 1, paramLong2);
            localMessageRecord.isread = true;
            localMessageRecord.shmsgseq = paramLong3;
            if (QLog.isDevelopLevel()) {
              QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 1 %s", new Object[] { Long.valueOf(paramLong3) }));
            }
            if (!aoci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
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
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews groupUin: %s recUin: %s, sendUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramaqyr.jdField_d_of_type_JavaLangString, paramaqyr.jdField_b_of_type_JavaLangString, paramaqyr.jdField_e_of_type_JavaLangString, Integer.valueOf(paramaqyr.jdField_a_of_type_Int) }));
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
        localObject2 = (aqyr)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((aqyr)localObject2).jdField_a_of_type_Int == paramInt) && (TextUtils.equals(((aqyr)localObject2).jdField_a_of_type_JavaLangString, paramString1)) && (TextUtils.equals(((aqyr)localObject2).jdField_d_of_type_JavaLangString, paramString2)) && (TextUtils.equals(((aqyr)localObject2).jdField_b_of_type_JavaLangString, paramString3)) && (TextUtils.equals(((aqyr)localObject2).jdField_e_of_type_JavaLangString, paramString4))) {
          if (((aqyr)localObject2).jdField_a_of_type_Boolean)
          {
            ((aqyr)localObject2).jdField_a_of_type_Boolean = false;
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
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 1, new int[] { -2065 });
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
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForConfessNews)localObject2).frienduin, ((MessageForConfessNews)localObject2).istroop, ((MessageForConfessNews)localObject2).uniseq, paramLong, ((MessageForConfessNews)localObject2).time);
                if (QLog.isDevelopLevel()) {
                  QLog.i("ConfessManager", 4, "checkUpdateGroupMessageForConfessNewsShmsgseq updated");
                }
              }
            }
          }
        }
      }
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 1, 6);
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
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).time);
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
    aqyq localaqyq = this.jdField_a_of_type_Aqyq;
    if ((TextUtils.isEmpty(paramString)) || (localaqyq == null) || (!TextUtils.equals(localaqyq.jdField_b_of_type_JavaLangString, paramString))) {
      bool = false;
    }
    do
    {
      return bool;
      if (localaqyq.g == 0) {
        localaqyq.g = a(paramString, localaqyq.jdField_b_of_type_JavaLangString, localaqyq.jdField_c_of_type_JavaLangString, localaqyq.jdField_a_of_type_Int);
      }
    } while (localaqyq.g == 1);
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
    this.jdField_a_of_type_Aqyq = paramIntent;
    if (paramIntent.g != 2) {
      ThreadManager.postImmediately(new ConfessManager.2(this, paramString), null, false);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterFrdRecConfessChat recUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(paramIntent.g) }));
    }
    return true;
  }
  
  public aqyl b()
  {
    return this.jdField_a_of_type_Aqyl;
  }
  
  public void b(String paramString)
  {
    Integer localInteger = null;
    aqyr localaqyr = this.jdField_a_of_type_Aqyr;
    this.jdField_a_of_type_Aqyr = null;
    if (localaqyr != null)
    {
      this.jdField_b_of_type_Aqyr = localaqyr;
      if (localaqyr.jdField_e_of_type_Int == 1) {
        ThreadManager.postImmediately(new ConfessManager.5(this, paramString, localaqyr), null, false);
      }
    }
    Locale localLocale;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (localaqyr != null) {
        break label90;
      }
    }
    for (;;)
    {
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveGroupRecConfessChat groupUin: %s, flag: %s", new Object[] { paramString, localInteger }));
      return;
      label90:
      localInteger = Integer.valueOf(localaqyr.jdField_e_of_type_Int);
    }
  }
  
  public boolean b(String paramString)
  {
    aqyr localaqyr = this.jdField_a_of_type_Aqyr;
    if ((TextUtils.isEmpty(paramString)) || (localaqyr == null) || (!TextUtils.equals(localaqyr.jdField_a_of_type_JavaLangString, paramString))) {
      return false;
    }
    if (localaqyr.jdField_e_of_type_Int == 0) {
      localaqyr.jdField_e_of_type_Int = a(paramString, localaqyr.jdField_d_of_type_JavaLangString, localaqyr.jdField_b_of_type_JavaLangString, localaqyr.jdField_e_of_type_JavaLangString, localaqyr.jdField_a_of_type_Int);
    }
    return localaqyr.jdField_e_of_type_Int == 1;
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
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    if ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str1)) || (i == 0)) {
      return false;
    }
    aqyr localaqyr = a(paramString, str4, paramIntent, str2, i);
    if (!TextUtils.isEmpty(str5)) {
      localaqyr.jdField_c_of_type_JavaLangString = str5;
    }
    localaqyr.g = str3;
    localaqyr.jdField_c_of_type_Int = j;
    localaqyr.f = str1;
    localaqyr.jdField_b_of_type_Int = k;
    localaqyr.jdField_a_of_type_Long = l;
    localaqyr.jdField_d_of_type_Int = m;
    this.jdField_a_of_type_Aqyr = localaqyr;
    if (localaqyr.jdField_e_of_type_Int != 2) {
      ThreadManager.postImmediately(new ConfessManager.4(this, paramString, localaqyr), null, false);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat recUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str4, paramIntent, str2, Integer.valueOf(i), Integer.valueOf(localaqyr.jdField_e_of_type_Int) }));
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
    this.jdField_a_of_type_Aqyq = paramIntent;
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
 * Qualified Name:     aqyp
 * JD-Core Version:    0.7.0.1
 */