import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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

public class amnn
  implements Manager
{
  final amni jdField_a_of_type_Amni;
  amnj jdField_a_of_type_Amnj;
  public amno a;
  public amnp a;
  public final amnz a;
  public QQAppInterface a;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  final ArrayList<amno> jdField_a_of_type_JavaUtilArrayList;
  amno jdField_b_of_type_Amno = null;
  amnp jdField_b_of_type_Amnp = null;
  final Object jdField_b_of_type_JavaLangObject = new Object();
  final ArrayList<amnp> jdField_b_of_type_JavaUtilArrayList;
  
  public amnn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Amno = null;
    this.jdField_a_of_type_Amnp = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Amnz = new amnz(paramQQAppInterface.getAccount());
    this.jdField_a_of_type_Amni = new amni();
    this.jdField_a_of_type_Amnj = new amnj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    ThreadManager.post(new ConfessManager.1(this), 5, null, true);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private amno a(String paramString1, String paramString2, int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localamno = (amno)((Iterator)localObject).next();
          if ((localamno == null) || (localamno.jdField_a_of_type_Int != paramInt) || (!TextUtils.equals(localamno.jdField_b_of_type_JavaLangString, paramString1)) || (!TextUtils.equals(localamno.jdField_c_of_type_JavaLangString, paramString2))) {
            continue;
          }
          localObject = localamno;
          if (localamno == null)
          {
            localObject = new amno();
            ((amno)localObject).jdField_b_of_type_JavaLangString = paramString1;
            ((amno)localObject).jdField_c_of_type_JavaLangString = paramString2;
            ((amno)localObject).jdField_a_of_type_Int = paramInt;
            ((amno)localObject).g = 0;
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
          return localObject;
        }
      }
      amno localamno = null;
    }
  }
  
  private amnp a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        Object localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localamnp = (amnp)((Iterator)localObject).next();
          if ((localamnp == null) || (localamnp.jdField_a_of_type_Int != paramInt) || (!TextUtils.equals(localamnp.jdField_a_of_type_JavaLangString, paramString1)) || (!TextUtils.equals(localamnp.jdField_d_of_type_JavaLangString, paramString2)) || (!TextUtils.equals(localamnp.jdField_b_of_type_JavaLangString, paramString3)) || (!TextUtils.equals(localamnp.jdField_e_of_type_JavaLangString, paramString4))) {
            continue;
          }
          localObject = localamnp;
          if (localamnp == null)
          {
            localObject = new amnp();
            ((amnp)localObject).jdField_a_of_type_JavaLangString = paramString1;
            ((amnp)localObject).jdField_d_of_type_JavaLangString = paramString2;
            ((amnp)localObject).jdField_b_of_type_JavaLangString = paramString3;
            ((amnp)localObject).jdField_e_of_type_JavaLangString = paramString4;
            ((amnp)localObject).jdField_a_of_type_Int = paramInt;
            ((amnp)localObject).jdField_e_of_type_Int = 0;
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          }
          return localObject;
        }
      }
      amnp localamnp = null;
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
  
  public amni a()
  {
    return this.jdField_a_of_type_Amni;
  }
  
  public amnj a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessManager", 2, "getConfigSync");
    }
    this.jdField_a_of_type_Amnj.a();
    return this.jdField_a_of_type_Amnj;
  }
  
  public amno a()
  {
    return this.jdField_a_of_type_Amno;
  }
  
  public amnp a()
  {
    return this.jdField_a_of_type_Amnp;
  }
  
  public amnz a()
  {
    if (!this.jdField_a_of_type_Amnz.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Amnz.a();
    }
    return this.jdField_a_of_type_Amnz;
  }
  
  public void a(RedTouchItem paramRedTouchItem)
  {
    if (paramRedTouchItem == null) {
      return;
    }
    if (!this.jdField_a_of_type_Amnz.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Amnz.a();
    }
    if ((this.jdField_a_of_type_Amnz.jdField_a_of_type_Long < paramRedTouchItem.lastRecvTime) || (this.jdField_a_of_type_Amnz.jdField_a_of_type_Int != paramRedTouchItem.count)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_Amnz.a(paramRedTouchItem);
        amnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false);
        ((amnk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125)).b(this.jdField_a_of_type_Amnz);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "onFrdRecNewConfess bNeedUpdate: %s, info: %s", new Object[] { Boolean.valueOf(bool), this.jdField_a_of_type_Amnz }));
      return;
    }
  }
  
  public void a(String paramString)
  {
    Integer localInteger = null;
    amno localamno = this.jdField_a_of_type_Amno;
    this.jdField_a_of_type_Amno = null;
    if (localamno != null)
    {
      this.jdField_b_of_type_Amno = localamno;
      if (localamno.g == 1) {
        ThreadManager.postImmediately(new ConfessManager.3(this, paramString, localamno), null, false);
      }
    }
    Locale localLocale;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (localamno != null) {
        break label90;
      }
    }
    for (;;)
    {
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveFrdRecConfessChat frdUin: %s, flag: %s", new Object[] { paramString, localInteger }));
      return;
      label90:
      localInteger = Integer.valueOf(localamno.g);
    }
  }
  
  public void a(String paramString, amno paramamno)
  {
    if ((paramamno == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramamno.g == 1)
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
                if ((localMessageForConfessNews.nTopicId == paramamno.jdField_a_of_type_Int) && (TextUtils.equals(paramamno.jdField_c_of_type_JavaLangString, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramamno.jdField_b_of_type_JavaLangString, localMessageForConfessNews.strRecUin)))
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
    QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeFrdConfessNews frdUin: %s confessorUin: %s topicId: %s", new Object[] { paramamno.jdField_b_of_type_JavaLangString, paramamno.jdField_c_of_type_JavaLangString, Integer.valueOf(paramamno.jdField_a_of_type_Int) }));
  }
  
  public void a(String paramString, amno paramamno, long paramLong1, long paramLong2)
  {
    if ((paramamno == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramamno.g == 0) {
          paramamno.g = a(paramString, paramamno.jdField_b_of_type_JavaLangString, paramamno.jdField_c_of_type_JavaLangString, paramamno.jdField_a_of_type_Int);
        }
        int i = paramamno.g;
        if (i == 1) {}
        try
        {
          String str = paramamno.a();
          if (!TextUtils.isEmpty(str))
          {
            MessageRecord localMessageRecord = axas.a(-2065);
            localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramString, str, paramLong1, -2065, 0, paramLong2);
            localMessageRecord.isread = true;
            if (!akas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
            }
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addFrdConfessNews frdUin: %s recUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramamno.jdField_b_of_type_JavaLangString, paramamno.jdField_c_of_type_JavaLangString, Integer.valueOf(paramamno.jdField_a_of_type_Int) }));
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
  
  public void a(String paramString, amnp paramamnp)
  {
    if ((paramamnp == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (paramamnp.jdField_e_of_type_Int == 1)
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
                if ((localMessageForConfessNews.nTopicId == paramamnp.jdField_a_of_type_Int) && (TextUtils.equals(paramamnp.jdField_a_of_type_JavaLangString, localMessageForConfessNews.strGroupUin)) && (TextUtils.equals(paramamnp.jdField_e_of_type_JavaLangString, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramamnp.jdField_b_of_type_JavaLangString, localMessageForConfessNews.senderuin)) && (TextUtils.equals(paramamnp.jdField_d_of_type_JavaLangString, localMessageForConfessNews.strRecUin)))
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
    QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeGroupConfessNews groupUin: %s, strRecUin: %s, sendUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramamnp.jdField_a_of_type_JavaLangString, paramamnp.jdField_d_of_type_JavaLangString, paramamnp.jdField_b_of_type_JavaLangString, paramamnp.jdField_e_of_type_JavaLangString, Integer.valueOf(paramamnp.jdField_a_of_type_Int) }));
  }
  
  public void a(String paramString, amnp paramamnp, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramamnp == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (paramamnp.jdField_e_of_type_Int == 0) {
          paramamnp.jdField_e_of_type_Int = a(paramString, paramamnp.jdField_d_of_type_JavaLangString, paramamnp.jdField_b_of_type_JavaLangString, paramamnp.jdField_e_of_type_JavaLangString, paramamnp.jdField_a_of_type_Int);
        }
        int i = paramamnp.jdField_e_of_type_Int;
        if (i == 1) {}
        try
        {
          String str = paramamnp.a();
          if (!TextUtils.isEmpty(str))
          {
            MessageRecord localMessageRecord = axas.a(-2065);
            localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramamnp.jdField_b_of_type_JavaLangString, str, paramLong1, -2065, 1, paramLong2);
            localMessageRecord.isread = true;
            localMessageRecord.shmsgseq = paramLong3;
            if (QLog.isDevelopLevel()) {
              QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 1 %s", new Object[] { Long.valueOf(paramLong3) }));
            }
            if (!akas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false))
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
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews groupUin: %s recUin: %s, sendUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramamnp.jdField_d_of_type_JavaLangString, paramamnp.jdField_b_of_type_JavaLangString, paramamnp.jdField_e_of_type_JavaLangString, Integer.valueOf(paramamnp.jdField_a_of_type_Int) }));
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
        localObject2 = (amnp)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((amnp)localObject2).jdField_a_of_type_Int == paramInt) && (TextUtils.equals(((amnp)localObject2).jdField_a_of_type_JavaLangString, paramString1)) && (TextUtils.equals(((amnp)localObject2).jdField_d_of_type_JavaLangString, paramString2)) && (TextUtils.equals(((amnp)localObject2).jdField_b_of_type_JavaLangString, paramString3)) && (TextUtils.equals(((amnp)localObject2).jdField_e_of_type_JavaLangString, paramString4))) {
          if (((amnp)localObject2).jdField_a_of_type_Boolean)
          {
            ((amnp)localObject2).jdField_a_of_type_Boolean = false;
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
    amno localamno = this.jdField_a_of_type_Amno;
    if ((TextUtils.isEmpty(paramString)) || (localamno == null) || (!TextUtils.equals(localamno.jdField_b_of_type_JavaLangString, paramString))) {
      bool = false;
    }
    do
    {
      return bool;
      if (localamno.g == 0) {
        localamno.g = a(paramString, localamno.jdField_b_of_type_JavaLangString, localamno.jdField_c_of_type_JavaLangString, localamno.jdField_a_of_type_Int);
      }
    } while (localamno.g == 1);
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
    this.jdField_a_of_type_Amno = paramIntent;
    if (paramIntent.g != 2) {
      ThreadManager.postImmediately(new ConfessManager.2(this, paramString), null, false);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterFrdRecConfessChat recUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(paramIntent.g) }));
    }
    return true;
  }
  
  public amnj b()
  {
    return this.jdField_a_of_type_Amnj;
  }
  
  public void b(String paramString)
  {
    Integer localInteger = null;
    amnp localamnp = this.jdField_a_of_type_Amnp;
    this.jdField_a_of_type_Amnp = null;
    if (localamnp != null)
    {
      this.jdField_b_of_type_Amnp = localamnp;
      if (localamnp.jdField_e_of_type_Int == 1) {
        ThreadManager.postImmediately(new ConfessManager.5(this, paramString, localamnp), null, false);
      }
    }
    Locale localLocale;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (localamnp != null) {
        break label90;
      }
    }
    for (;;)
    {
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveGroupRecConfessChat groupUin: %s, flag: %s", new Object[] { paramString, localInteger }));
      return;
      label90:
      localInteger = Integer.valueOf(localamnp.jdField_e_of_type_Int);
    }
  }
  
  public boolean b(String paramString)
  {
    amnp localamnp = this.jdField_a_of_type_Amnp;
    if ((TextUtils.isEmpty(paramString)) || (localamnp == null) || (!TextUtils.equals(localamnp.jdField_a_of_type_JavaLangString, paramString))) {
      return false;
    }
    if (localamnp.jdField_e_of_type_Int == 0) {
      localamnp.jdField_e_of_type_Int = a(paramString, localamnp.jdField_d_of_type_JavaLangString, localamnp.jdField_b_of_type_JavaLangString, localamnp.jdField_e_of_type_JavaLangString, localamnp.jdField_a_of_type_Int);
    }
    return localamnp.jdField_e_of_type_Int == 1;
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
    amnp localamnp = a(paramString, str4, paramIntent, str2, i);
    if (!TextUtils.isEmpty(str5)) {
      localamnp.jdField_c_of_type_JavaLangString = str5;
    }
    localamnp.g = str3;
    localamnp.jdField_c_of_type_Int = j;
    localamnp.f = str1;
    localamnp.jdField_b_of_type_Int = k;
    localamnp.jdField_a_of_type_Long = l;
    localamnp.jdField_d_of_type_Int = m;
    this.jdField_a_of_type_Amnp = localamnp;
    if (localamnp.jdField_e_of_type_Int != 2) {
      ThreadManager.postImmediately(new ConfessManager.4(this, paramString, localamnp), null, false);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat recUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str4, paramIntent, str2, Integer.valueOf(i), Integer.valueOf(localamnp.jdField_e_of_type_Int) }));
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
    this.jdField_a_of_type_Amno = paramIntent;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amnn
 * JD-Core Version:    0.7.0.1
 */