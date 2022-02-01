import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.manager.Manager;

public class baou
  extends Observable
  implements Manager
{
  private anwt jdField_a_of_type_Anwt = new baow(this);
  private anyu jdField_a_of_type_Anyu = new baov(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public baou(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anwt);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    baou localbaou = (baou)paramQQAppInterface.getManager(38);
    if (localbaou != null) {}
    for (int i = localbaou.a();; i = 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("fetchUnReadCount", 4, String.format("getMissCallTotalCountWhenCallTabHidden, callUnReadCount[%s], isConversationTabShow[%s], isInCallList[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramQQAppInterface.o), Boolean.valueOf(paramQQAppInterface.p) }));
      }
      return i;
    }
  }
  
  private long a(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    return localBaseApplication.getSharedPreferences("voice_tab_time", 0).getLong(paramQQAppInterface, 0L);
  }
  
  public static baox a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, QQMessageFacade.Message paramMessage)
  {
    return new baox(paramQQAppInterface, paramString, paramInt1, paramInt2, paramMessage, null);
  }
  
  private QCallRecent a(MessageForVideo paramMessageForVideo)
  {
    int i = 1;
    Object localObject = paramMessageForVideo.frienduin;
    long l = paramMessageForVideo.time;
    QCallRecent localQCallRecent = a().a((String)localObject, paramMessageForVideo.istroop);
    localQCallRecent.uin = ((String)localObject);
    localQCallRecent.type = paramMessageForVideo.istroop;
    localQCallRecent.sendFlag = paramMessageForVideo.issend;
    localQCallRecent.lastCallMsg = bhnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessageForVideo.text);
    if (l > localQCallRecent.lastCallTime)
    {
      localQCallRecent.lastCallTime = l;
      localQCallRecent.isSystemCall = 0;
    }
    if ((localQCallRecent.type == 1000) || (localQCallRecent.type == 1020) || (localQCallRecent.type == 1004)) {
      localQCallRecent.troopUin = paramMessageForVideo.senderuin;
    }
    int j = localQCallRecent.missedCallCount;
    localQCallRecent.missedCallCount = d(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
    if (QLog.isDevelopLevel()) {
      QLog.d("fetchUnReadCount", 4, String.format("getMessageToRecentCall, uin[%s], type[%s], count[%s], src[%s]", new Object[] { paramMessageForVideo.frienduin, Integer.valueOf(paramMessageForVideo.istroop), Integer.valueOf(localQCallRecent.missedCallCount), Integer.valueOf(j) }));
    }
    localObject = paramMessageForVideo.msg;
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length <= 3)) {
        break label308;
      }
      if (!"1".equals(localObject[3])) {
        break label303;
      }
    }
    label303:
    label308:
    for (localQCallRecent.isVideo = i;; localQCallRecent.isVideo = 1)
    {
      localQCallRecent.isLastCallRealMissed = a(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
      localQCallRecent.callType = a(paramMessageForVideo, localQCallRecent.type);
      return localQCallRecent;
      i = 0;
      break;
    }
  }
  
  private QCallRecord a(MessageForVideo paramMessageForVideo)
  {
    if (paramMessageForVideo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCallFacade", 2, "getMessageToCallRecord message is null");
      }
      return null;
    }
    QCallRecord localQCallRecord = new QCallRecord();
    localQCallRecord.friendUin = paramMessageForVideo.frienduin;
    localQCallRecord.time = paramMessageForVideo.time;
    localQCallRecord.uinType = paramMessageForVideo.istroop;
    localQCallRecord.senderuin = paramMessageForVideo.senderuin;
    localQCallRecord.issend = paramMessageForVideo.issend;
    localQCallRecord.uniseq = paramMessageForVideo.uniseq;
    String str = paramMessageForVideo.msg;
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCallFacade", 2, "getMessageToCallRecord message's msg is null");
      }
      return null;
    }
    String[] arrayOfString = str.split("\\|");
    int i;
    label151:
    Object localObject;
    if ((arrayOfString != null) && (arrayOfString.length > 3)) {
      if ("1".equals(arrayOfString[3]))
      {
        i = 1;
        localQCallRecord.isVideo = i;
        if (arrayOfString.length <= 3) {
          break label498;
        }
        localObject = arrayOfString[0].trim();
      }
    }
    try
    {
      localQCallRecord.state = Integer.parseInt(arrayOfString[1]);
      paramMessageForVideo = (MessageForVideo)localObject;
    }
    catch (Exception paramMessageForVideo)
    {
      for (;;)
      {
        label180:
        if ((str != null) && (str.length() > 0) && (str.charAt(0) == '\026'))
        {
          paramMessageForVideo = (MessageForVideo)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("QCallFacade", 2, "getMessageToCallRecord java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg is " + str);
            paramMessageForVideo = (MessageForVideo)localObject;
          }
        }
        else
        {
          localQCallRecord.state = 5;
          paramMessageForVideo = (MessageForVideo)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("QCallFacade", 2, "getMessageToCallRecord java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg byte " + bhjx.a(str));
            paramMessageForVideo = (MessageForVideo)localObject;
          }
        }
      }
    }
    if (((localQCallRecord.state == 0) || (localQCallRecord.state == 2) || (localQCallRecord.state == 24) || (localQCallRecord.state == 46) || (localQCallRecord.state == 47) || (localQCallRecord.state == 48) || (localQCallRecord.state == 57) || (localQCallRecord.state == 9) || (localQCallRecord.state == 15)) && (paramMessageForVideo != null))
    {
      paramMessageForVideo = paramMessageForVideo.split(" ");
      if (paramMessageForVideo != null)
      {
        if (paramMessageForVideo.length <= 1) {
          break label511;
        }
        localQCallRecord.talkTime = paramMessageForVideo[1];
      }
    }
    label296:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getMessageToCallRecord:");
      if (localQCallRecord == null) {
        break label564;
      }
    }
    label564:
    for (paramMessageForVideo = localQCallRecord.toString();; paramMessageForVideo = "")
    {
      QLog.d("QCallFacade", 2, paramMessageForVideo);
      return localQCallRecord;
      i = 0;
      break;
      localQCallRecord.isVideo = 1;
      break label151;
      label498:
      paramMessageForVideo = "";
      localQCallRecord.state = 5;
      break label180;
      label511:
      if (paramMessageForVideo.length != 1) {
        break label296;
      }
      if ((2 == localQCallRecord.state) || (24 == localQCallRecord.state))
      {
        localQCallRecord.state = 12;
        break label296;
      }
      if (localQCallRecord.state != 0) {
        break label296;
      }
      localQCallRecord.state = 12;
      break label296;
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    }
  }
  
  private void a(int paramInt)
  {
    setChanged();
    notifyObservers(Integer.valueOf(paramInt));
    if (a().a())
    {
      setChanged();
      notifyObservers(Boolean.valueOf(true));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int[] arrayOfInt = adak.q;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (k != paramInt) {
        a(paramQQAppInterface, paramString, k);
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    try
    {
      BaseApplication localBaseApplication = paramQQAppInterface.getApp();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      if (paramQQAppInterface == null) {
        return;
      }
      localBaseApplication.getSharedPreferences("call_time_use_up", 0).edit().putBoolean(paramQQAppInterface + "_show_flag", paramBoolean).putString(paramQQAppInterface + "_wording", paramString).commit();
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  private void a(QCallRecent paramQCallRecent, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, String.format("saveRecentCall[%s], [%s]", new Object[] { paramString, paramQCallRecent }));
    }
    a().d(paramQCallRecent);
    if ((adak.d(paramQCallRecent.type)) && (paramQCallRecent.state == 5))
    {
      a(1);
      return;
    }
    a(0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = (baou)paramQQAppInterface.getManager(38);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.b(paramString, paramInt) > 0))
    {
      paramQQAppInterface.a(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "checkIsRealMissed friendUin:" + paramString + ",uinType:" + paramInt);
    }
    paramString = a(paramString, paramInt);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("QCallFacade", 2, "checkIsRealMissed CallRecord count 0");
        bool2 = bool1;
      }
      return bool2;
    }
    paramInt = 0;
    for (;;)
    {
      bool1 = bool2;
      if (paramInt < paramString.size())
      {
        QCallRecord localQCallRecord = (QCallRecord)paramString.get(paramInt);
        if ((localQCallRecord == null) || (localQCallRecord.type != QCallRecord.TYPE_REALRECORD)) {
          break label193;
        }
        if (!localQCallRecord.isMissCall())
        {
          bool1 = bool2;
          if (localQCallRecord.state != 1) {}
        }
        else
        {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QCallFacade", 2, "checkIsRealMissed ret:" + bool1);
      return bool1;
      label193:
      paramInt += 1;
    }
  }
  
  private void b(QCallRecent paramQCallRecent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "save " + paramQCallRecent);
    }
    a().c(paramQCallRecent);
    if ((adak.d(paramQCallRecent.type)) && (paramQCallRecent.state == 5))
    {
      a(1);
      return;
    }
    a(0);
  }
  
  private int d(String paramString, int paramInt)
  {
    List localList = a(paramString, paramInt);
    int j;
    if ((localList == null) || (localList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fetchUnReadCount", 2, String.format("getNewestMissCallCount count 0, uin[%s], type[%s]]", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
      j = 0;
    }
    int i;
    do
    {
      return j;
      j = 0;
      int k;
      for (i = 0; j < localList.size(); i = k)
      {
        QCallRecord localQCallRecord = (QCallRecord)localList.get(j);
        k = i;
        if (localQCallRecord != null)
        {
          k = i;
          if (localQCallRecord.type == QCallRecord.TYPE_REALRECORD)
          {
            if (!localQCallRecord.isMissCall()) {
              break;
            }
            k = i + 1;
          }
        }
        j += 1;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.d("fetchUnReadCount", 2, String.format("getNewestMissCallCount, uin[%s], type[%s], count[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(i) }));
    return i;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      do
      {
        do
        {
          return 0;
        } while (a().a() == null);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      } while (localObject1 == null);
      localObject1 = ((apaw)localObject1).getRecentList(false);
    } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
    Object localObject1 = ((List)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      RecentUser localRecentUser = (RecentUser)((Iterator)localObject1).next();
      if (localRecentUser.getType() == 3000)
      {
        Object localObject2 = (anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
        DiscussionMemberInfo localDiscussionMemberInfo = ((anws)localObject2).a(localRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((localDiscussionMemberInfo != null) && ((localDiscussionMemberInfo.flag & 0x1) == 1))
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("fetchUnReadCount", 4, String.format("getMissCallTotalCount, 开启了免打扰, disc[%s]", new Object[] { localRecentUser.uin }));
          continue;
        }
        localObject2 = ((anws)localObject2).a(localRecentUser.uin);
        if ((localObject2 == null) || (((DiscussionInfo)localObject2).isUIControlFlag_Hidden_RecentUser()) || (((DiscussionInfo)localObject2).isHidden()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("QCallFacade", 2, "getMissCallTotalCount, invalid discussion, uin[" + localRecentUser.uin + "], unread[" + b(localRecentUser.uin, localRecentUser.getType()) + "]");
          continue;
        }
      }
      if ((localRecentUser.getType() != 0) || ((!FriendsStatusUtil.a(localRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!aguy.a(localRecentUser.uin, localRecentUser.getType(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))) {
        i = b(localRecentUser.uin, localRecentUser.getType()) + i;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("fetchUnReadCount", 4, String.format("getMissCallTotalCount, count[%s]", new Object[] { Integer.valueOf(i) }));
    }
    return i;
  }
  
  public int a(MessageRecord paramMessageRecord, int paramInt)
  {
    int i = 0;
    if (paramMessageRecord.msgtype == -2046) {
      i = 2;
    }
    while ((paramMessageRecord.msgtype != -2026) && (!adak.d(paramInt))) {
      return i;
    }
    return 1;
  }
  
  public int a(String paramString, int paramInt)
  {
    int i = 0;
    paramString = a().b(paramString, paramInt);
    paramInt = i;
    if (paramString != null) {
      paramInt = paramString.state;
    }
    return paramInt;
  }
  
  public int a(String paramString, int paramInt, long paramLong)
  {
    int k;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fetchUnReadCount", 2, String.format("getMissCallRecordCount, uin为空, uin[%s], type[%s], time[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
      }
      k = 0;
      return k;
    }
    paramString = a().a(paramString, paramInt);
    int i = 0;
    int j = 0;
    for (;;)
    {
      for (;;)
      {
        k = i;
        try
        {
          if (j >= paramString.size()) {
            break;
          }
          QCallRecord localQCallRecord = (QCallRecord)paramString.get(j);
          if (localQCallRecord.type == QCallRecord.TYPE_DATE) {
            break label234;
          }
          k = i;
          if (!localQCallRecord.isMissCall()) {
            break;
          }
          if (localQCallRecord.time <= paramLong) {
            break label234;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("fetchUnReadCount", 4, String.format("getMissCallRecordCount, uinType[%s], qcr.time[%s], time[%s], %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(localQCallRecord.time), Long.valueOf(paramLong), localQCallRecord }));
          }
          i += 1;
        }
        catch (Exception paramString)
        {
          k = i;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QCallFacade", 2, "getMissCallRecordCount:" + paramString);
      return i;
      label234:
      j += 1;
    }
  }
  
  public baoy a()
  {
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    }
    return null;
  }
  
  public QCallRecent a(String paramString, int paramInt)
  {
    return a().b(paramString, paramInt);
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = a().a();
    if (localObject1 == null) {
      return "";
    }
    int j = 0;
    int i = 0;
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QCallRecord localQCallRecord1 = null;
    localObject1 = ((List)localObject1).iterator();
    int k;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (QCallRecent)((Iterator)localObject1).next();
      long l1;
      if (((QCallRecent)localObject2).readTime > l2) {
        l1 = ((QCallRecent)localObject2).readTime;
      }
      for (;;)
      {
        if ((((QCallRecent)localObject2).lastCallTime > l1) && (((QCallRecent)localObject2).isMissedCall()))
        {
          k = i + 1;
          if (((QCallRecent)localObject2).uin == null)
          {
            i = k;
            break;
            l1 = l2;
            continue;
          }
          localObject2 = a().a(((QCallRecent)localObject2).uin, ((QCallRecent)localObject2).type);
          int m = 0;
          i = j;
          if (m >= ((List)localObject2).size()) {
            break label461;
          }
          QCallRecord localQCallRecord2 = (QCallRecord)((List)localObject2).get(m);
          if (localQCallRecord2.type == QCallRecord.TYPE_DATE) {}
          for (;;)
          {
            label192:
            m += 1;
            break;
            if (!localQCallRecord2.isMissCall()) {
              break label461;
            }
            if (localQCallRecord2.time <= l1) {
              break label458;
            }
            if (i != 0) {
              break label455;
            }
            localQCallRecord1 = (QCallRecord)((List)localObject2).get(m);
            label238:
            i += 1;
          }
        }
      }
      k = i;
      i = j;
    }
    label455:
    label458:
    label461:
    for (j = k;; j = k)
    {
      k = j;
      j = i;
      i = k;
      break;
      localObject1 = new StringBuilder();
      if ((j == 1) || (i == 1)) {
        if (paramBoolean) {
          if (paramString != null) {
            ((StringBuilder)localObject1).append(paramString).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694975));
          }
        }
      }
      for (;;)
      {
        return ((StringBuilder)localObject1).toString();
        if ((localQCallRecord1 != null) && (localQCallRecord1.isVideo()))
        {
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695341));
        }
        else
        {
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694765));
          continue;
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694932, new Object[] { "" + i, "" + j }));
        }
      }
      break label238;
      break label192;
    }
  }
  
  public ArrayList<MessageRecord> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a().a();
    if (localObject == null) {
      return localArrayList;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)localIterator.next();
      long l1;
      label84:
      int i;
      label131:
      QCallRecord localQCallRecord;
      if (localQCallRecent.readTime > l2)
      {
        l1 = localQCallRecent.readTime;
        if ((localQCallRecent.lastCallTime <= l1) || (!localQCallRecent.isMissedCall()) || (localQCallRecent.uin == null)) {
          break label177;
        }
        List localList = a().a(localQCallRecent.uin, localQCallRecent.type);
        i = 0;
        if (i < localList.size())
        {
          localQCallRecord = (QCallRecord)localList.get(i);
          if (localQCallRecord.type != QCallRecord.TYPE_DATE) {
            break label179;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break label131;
        break;
        l1 = l2;
        break label84;
        label177:
        break;
        label179:
        if (!localQCallRecord.isMissCall()) {
          break;
        }
        if (localQCallRecord.time > l1)
        {
          if (localQCallRecent.type != 3000) {
            break label291;
          }
          localObject = bcry.a(-2016);
          ((MessageRecord)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695025);
          ((MessageRecord)localObject).frienduin = localQCallRecent.troopUin;
          ((MessageRecord)localObject).msgtype = -2016;
          ((MessageRecord)localObject).senderuin = "";
          ((MessageRecord)localObject).istroop = localQCallRecent.type;
          ((MessageRecord)localObject).time = localQCallRecord.time;
          localArrayList.add(localObject);
        }
      }
      label291:
      localObject = bcry.a(-2009);
      ((MessageRecord)localObject).frienduin = localQCallRecent.uin;
      ((MessageRecord)localObject).msgtype = -2009;
      if (localQCallRecord.isVideo()) {}
      for (((MessageRecord)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695026);; ((MessageRecord)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695024))
      {
        ((MessageRecord)localObject).senderuin = localQCallRecord.senderuin;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "getMissCallMessageRecordList = list size" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public List<QCallRecord> a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "getListRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    return a().a(paramString, paramInt);
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QCallFacade", 2, "addQCallRecentAndCallRecord issend=" + paramInt + ", discussId=" + paramLong + ", senderUin=" + paramString);
    }
    Object localObject = new QCallRecord();
    ((QCallRecord)localObject).friendUin = String.valueOf(paramLong);
    ((QCallRecord)localObject).issend = paramInt;
    ((QCallRecord)localObject).isVideo = 0;
    ((QCallRecord)localObject).time = bcrg.a();
    ((QCallRecord)localObject).type = QCallRecord.TYPE_REALRECORD;
    if (paramInt == 1)
    {
      ((QCallRecord)localObject).state = 4;
      ((QCallRecord)localObject).uinType = 3000;
      a().a((QCallRecord)localObject);
      localObject = a().a(String.valueOf(paramLong), 3000);
      ((QCallRecent)localObject).uin = String.valueOf(paramLong);
      ((QCallRecent)localObject).lastCallTime = bcrg.a();
      ((QCallRecent)localObject).type = 3000;
      ((QCallRecent)localObject).sendFlag = paramInt;
      ((QCallRecent)localObject).troopUin = String.valueOf(paramLong);
      ((QCallRecent)localObject).memberCount = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, paramLong);
      ((QCallRecent)localObject).missedCallCount = d(String.valueOf(paramLong), 3000);
      if (paramInt != 1) {
        break label275;
      }
    }
    label275:
    for (((QCallRecent)localObject).state = 4;; ((QCallRecent)localObject).state = 3)
    {
      ((QCallRecent)localObject).senderUin = paramString;
      ((QCallRecent)localObject).isLastCallRealMissed = a(String.valueOf(paramLong), 3000);
      ((QCallRecent)localObject).isSystemCall = 0;
      a((QCallRecent)localObject, "when_addQCallRecentAndCallRecord");
      return;
      ((QCallRecord)localObject).state = 3;
      break;
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QCallFacade", 2, String.format("addQCallRecent, issend[%s], discussId[%s], senderUin[%s] , pstnUserInfo[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramString1, paramString2 }));
    }
    QCallRecent localQCallRecent = a().a(String.valueOf(paramLong), 3000);
    localQCallRecent.uin = String.valueOf(paramLong);
    localQCallRecent.lastCallTime = bcrg.a();
    localQCallRecent.type = 3000;
    localQCallRecent.sendFlag = paramInt;
    localQCallRecent.troopUin = String.valueOf(paramLong);
    localQCallRecent.memberCount = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, paramLong);
    localQCallRecent.missedCallCount = d(String.valueOf(paramLong), 3000);
    if (localQCallRecent.state != 1) {
      if (paramInt != 1) {
        break label201;
      }
    }
    label201:
    for (localQCallRecent.state = 4;; localQCallRecent.state = 0)
    {
      localQCallRecent.pstnInfo = paramString2;
      localQCallRecent.senderUin = paramString1;
      localQCallRecent.isLastCallRealMissed = a(String.valueOf(paramLong), 3000);
      localQCallRecent.isSystemCall = 0;
      a(localQCallRecent, "when_addQCallRecent");
      return;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, "-1", paramString2, 2);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    i = 2;
    if (QLog.isColorLevel()) {
      QLog.e("QCallFacade", 2, String.format("addMissCallMsg, uinType[%s], discussId[%s], peerUin[%s], senderUin[%s]", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3 }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Throwable paramString2)
    {
      for (;;)
      {
        continue;
        i = 1;
      }
    }
    if (paramInt1 == 3000) {}
    for (;;)
    {
      paramString2 = new QCallRecord();
      paramString2.friendUin = paramString1;
      paramString2.issend = 0;
      paramString2.isVideo = 0;
      paramString2.time = bcrg.a();
      paramString2.type = QCallRecord.TYPE_REALRECORD;
      paramString2.state = paramInt2;
      paramString2.uinType = paramInt1;
      a().a(paramString2);
      paramString2 = a().a(paramString1, paramInt1);
      paramString2.uin = paramString1;
      paramString2.lastCallTime = bcrg.a();
      paramString2.type = paramInt1;
      paramString2.sendFlag = 0;
      paramString2.troopUin = paramString1;
      paramString2.memberCount = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, l1);
      paramString2.state = paramInt2;
      paramString2.missedCallCount = d(paramString1, paramInt1);
      paramString2.senderUin = paramString3;
      paramString2.isLastCallRealMissed = a(paramString1, paramInt1);
      paramString2.isSystemCall = 0;
      a(paramString2, "when_addMissCallMsg");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.E();
      return;
      if (paramInt1 == 1)
      {
        i = 1;
      }
      else
      {
        if (paramInt1 != 0) {
          break;
        }
        i = 3;
      }
    }
  }
  
  public void a(long paramLong)
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localBaseApplication.getSharedPreferences("voice_tab_time", 0).edit().putLong(str, paramLong).commit();
    if (QLog.isColorLevel()) {
      QLog.d("fetchUnReadCount", 2, String.format("设置saveVoiceTabTime, time[%s]", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "updateDissCall-->discussid=" + paramLong1 + " friendUin=" + paramLong2 + " b=" + paramBoolean1 + " time=" + paramLong3 + " isSend=" + paramBoolean2);
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {}
    while ((((anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(String.valueOf(paramLong1)) == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramLong2)))) {
      return;
    }
    QCallRecent localQCallRecent = a().a(String.valueOf(paramLong1), 3000);
    localQCallRecent.lastCallTime = bcrg.a();
    if (paramBoolean1) {
      localQCallRecent.state = 1;
    }
    for (;;)
    {
      a(localQCallRecent, "when_updateDissCall");
      return;
      localQCallRecent.state = 3;
      localQCallRecent.time = paramLong3;
      if (paramLong3 > 0L)
      {
        localQCallRecord = new QCallRecord();
        localQCallRecord.friendUin = String.valueOf(paramLong1);
        localQCallRecord.isVideo = 0;
        localQCallRecord.time = bcrg.a();
        localQCallRecord.talkTime = String.valueOf(paramLong3);
        localQCallRecord.type = QCallRecord.TYPE_REALRECORD;
        localQCallRecord.uinType = 3000;
        if (paramBoolean2) {
          localQCallRecord.state = 4;
        }
        for (localQCallRecord.issend = 1;; localQCallRecord.issend = 0)
        {
          a().a(localQCallRecord);
          break;
          localQCallRecord.state = 3;
        }
      }
      QCallRecord localQCallRecord = new QCallRecord();
      localQCallRecord.friendUin = String.valueOf(paramLong1);
      localQCallRecord.issend = 1;
      localQCallRecord.isVideo = 0;
      localQCallRecord.time = bcrg.a();
      localQCallRecord.type = QCallRecord.TYPE_REALRECORD;
      localQCallRecord.state = 4;
      localQCallRecord.uinType = 3000;
      a().a(localQCallRecord);
    }
  }
  
  public void a(MessageForVideo paramMessageForVideo)
  {
    paramMessageForVideo.parse();
    paramMessageForVideo = a(paramMessageForVideo);
    a(paramMessageForVideo, "when_insertMessage");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if ((paramMessageForVideo == null) || (paramMessageForVideo.type != 3000)) {
        break label146;
      }
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!paramMessageForVideo.isSend()) {
        break label139;
      }
    }
    label139:
    for (paramMessageForVideo = "1";; paramMessageForVideo = "0")
    {
      bdll.b(localQQAppInterface, "CliOper", "", "", "0X8004067", "0X8004067", 0, 0, paramMessageForVideo, "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.p)) {
        a(bcrg.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.E();
      return;
    }
    label146:
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramMessageForVideo.isSend()) {}
    for (paramMessageForVideo = "1";; paramMessageForVideo = "0")
    {
      bdll.b(localQQAppInterface, "CliOper", "", "", "Msg_tab", "Call_history_count", 0, 0, paramMessageForVideo, "", "", "");
      break;
    }
  }
  
  public void a(MessageForVideo paramMessageForVideo, boolean paramBoolean)
  {
    if (paramMessageForVideo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCallFacade", 2, "insertCallRecord updateRecentMissedCallCount: msg is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "insertCallRecord updateRecentMissedCallCount:" + paramBoolean + ", msg :" + paramMessageForVideo.toString());
    }
    Object localObject = a(paramMessageForVideo);
    a().a((QCallRecord)localObject);
    if (paramBoolean)
    {
      localObject = a().b(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
      if (localObject != null)
      {
        ((QCallRecent)localObject).missedCallCount = d(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
        if (QLog.isColorLevel()) {
          QLog.d("QCallFacade", 2, "insertCallRecord QCallRecent update MissCallCount" + ((QCallRecent)localObject).missedCallCount);
        }
        ((QCallRecent)localObject).isLastCallRealMissed = a(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
        a((QCallRecent)localObject, "when_insertCallRecord");
      }
    }
    setChanged();
    notifyObservers(a(paramMessageForVideo.frienduin, paramMessageForVideo.istroop));
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    if (paramQCallRecent == null) {
      return;
    }
    a().a(paramQCallRecent);
    a(-1);
  }
  
  public void a(String paramString)
  {
    b(paramString, 0);
    b(paramString, 1000);
    b(paramString, 1020);
    b(paramString, 1004);
    b(paramString, 1024);
    b(paramString, 8);
  }
  
  public void a(String paramString, int paramInt)
  {
    QCallRecent localQCallRecent = a().b(paramString, paramInt);
    if (localQCallRecent == null) {
      return;
    }
    long l = localQCallRecent.readTime;
    localQCallRecent.readTime = bcrg.a();
    if (QLog.isDevelopLevel()) {
      QLog.d("fetchUnReadCount", 4, String.format("updateQCallRecentReadTime, uin[%s], type[%s], readTime[%s], src[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(localQCallRecent.readTime), Long.valueOf(l) }));
    }
    a(localQCallRecent, "when_updateQCallRecentReadTime");
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, 0, 0, null, paramInt2);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    QLog.d("QCallFacade", 1, String.format("updateDoubleCallStatus, peerUin[%s], uinType[%s], extraType[%s], bindType[%s], bindId[%s], status[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString2, Integer.valueOf(paramInt4) }));
    if ((paramInt1 == 1011) || (paramInt1 == -1)) {}
    do
    {
      anyw localanyw;
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        if (paramInt1 != 0) {
          break;
        }
        localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      } while ((localanyw != null) && (!localanyw.b(paramString1)));
    } while ((paramString1 == null) || ((paramInt1 == 3000) && (((anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(paramString1) == null)));
    paramString1 = a().a(paramString1, paramInt1);
    if ((paramInt4 == 6) || (paramInt4 == 5) || (paramString1.isMissedCall())) {
      paramString1.lastCallTime = bcrg.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "updateDoubleCallStatus lastCallTime = " + paramString1.lastCallTime);
    }
    paramString1.state = paramInt4;
    paramString1.extraType = paramInt2;
    paramString1.bindId = paramString2;
    paramString1.bindType = paramInt3;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1.callType = 1;
    }
    if (paramInt4 == 0)
    {
      a(paramString1, "when_updateDoubleCallStatus");
      return;
    }
    b(paramString1);
  }
  
  @Deprecated
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    baoy localbaoy = a();
    Object localObject = new QCallRecord();
    ((QCallRecord)localObject).uinType = paramInt1;
    ((QCallRecord)localObject).state = 58;
    ((QCallRecord)localObject).contactId = paramInt2;
    ((QCallRecord)localObject).friendUin = paramString1;
    ((QCallRecord)localObject).time = paramLong;
    localbaoy.a((QCallRecord)localObject);
    localObject = localbaoy.a(paramString1, paramInt1);
    ((QCallRecent)localObject).uin = paramString1;
    ((QCallRecent)localObject).type = paramInt1;
    if (paramLong > ((QCallRecent)localObject).lastCallTime) {
      ((QCallRecent)localObject).lastCallTime = paramLong;
    }
    ((QCallRecent)localObject).contactId = paramInt2;
    ((QCallRecent)localObject).isSystemCall = 1;
    ((QCallRecent)localObject).sendFlag = 1;
    ((QCallRecent)localObject).phoneNumber = paramString2;
    localbaoy.d((QCallRecent)localObject);
    notifyObservers(a(paramString1, paramInt1));
    setChanged();
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    a().a(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    a().a(paramBoolean);
  }
  
  public int b()
  {
    Object localObject = a().a();
    if (localObject == null) {
      return 0;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((List)localObject).iterator();
    int i = 0;
    long l1;
    if (((Iterator)localObject).hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)((Iterator)localObject).next();
      if (localQCallRecent.readTime > l2)
      {
        l1 = localQCallRecent.readTime;
        label76:
        if ((localQCallRecent.lastCallTime <= l1) || (!localQCallRecent.isMissedCall())) {
          break label109;
        }
        i += 1;
      }
    }
    label109:
    for (;;)
    {
      break;
      l1 = l2;
      break label76;
      return i;
    }
  }
  
  public int b(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && (paramString.isMissedCall()))
    {
      long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      long l1 = l2;
      if (paramString.readTime > l2) {
        l1 = paramString.readTime;
      }
      return a(paramString.uin, paramString.type, l1);
    }
    return 0;
  }
  
  @Deprecated
  public void b(String paramString)
  {
    int k = 0;
    Object localObject2 = (axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    Object localObject1 = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    int i;
    label57:
    int j;
    if (localObject2 == null)
    {
      localObject2 = null;
      if (localObject2 != null)
      {
        if (TextUtils.isEmpty(((PhoneContact)localObject2).uin)) {
          break label152;
        }
        i = 1;
        if ((i == 0) || (((PhoneContact)localObject2).uin.equals("0"))) {
          break label157;
        }
        j = 1;
        label77:
        if ((j != 0) && (localObject1 != null)) {
          break label162;
        }
        localObject1 = null;
        label89:
        if ((localObject1 == null) || (!((Friends)localObject1).isFriend())) {
          break label177;
        }
        j = 1;
        label104:
        if (j == 0) {
          break label182;
        }
        localObject1 = ((PhoneContact)localObject2).uin;
        i = k;
      }
    }
    for (;;)
    {
      long l = bcrg.a();
      a((String)localObject1, i, ((PhoneContact)localObject2).contactID, l, paramString);
      return;
      localObject2 = ((axfr)localObject2).c(paramString);
      break;
      label152:
      i = 0;
      break label57;
      label157:
      j = 0;
      break label77;
      label162:
      localObject1 = ((anyw)localObject1).e(((PhoneContact)localObject2).uin);
      break label89;
      label177:
      j = 0;
      break label104;
      label182:
      if (i != 0)
      {
        localObject1 = ((PhoneContact)localObject2).mobileCode;
        i = 1006;
      }
      else
      {
        localObject1 = ((PhoneContact)localObject2).mobileNo;
        i = 56938;
      }
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QCallRecent localQCallRecent = a().b(paramString, paramInt);
    if (localQCallRecent != null) {
      a(localQCallRecent);
    }
    c(paramString, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.E();
  }
  
  public int c(String paramString, int paramInt)
  {
    Object localObject1 = a().a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("fetchUnReadCount", 2, String.format("getMissCallRecordCount fail, friendUin[%s], uinType[%s]", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
      return 0;
    }
    long l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    long l1;
    label132:
    int j;
    int i;
    label176:
    QCallRecord localQCallRecord;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (QCallRecent)((Iterator)localObject1).next();
        if ((paramString.equals(((QCallRecent)localObject2).uin)) && (paramInt == ((QCallRecent)localObject2).type)) {
          if (((QCallRecent)localObject2).readTime > l2)
          {
            l1 = ((QCallRecent)localObject2).readTime;
            if ((((QCallRecent)localObject2).lastCallTime <= l1) || (!((QCallRecent)localObject2).isMissedCall()) || (((QCallRecent)localObject2).uin == null)) {
              break label230;
            }
            localObject2 = a().a(paramString, paramInt);
            j = 0;
            i = k;
            k = i;
            if (j >= ((List)localObject2).size()) {
              continue;
            }
            localQCallRecord = (QCallRecord)((List)localObject2).get(j);
            if (localQCallRecord.type != QCallRecord.TYPE_DATE) {
              break label232;
            }
          }
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label176;
      l1 = l2;
      break label132;
      label230:
      break;
      label232:
      k = i;
      if (!localQCallRecord.isMissCall()) {
        break;
      }
      if (localQCallRecord.time > l1)
      {
        i += 1;
        continue;
        return k;
      }
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "clearAllRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    a().a(paramString, paramInt);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anwt);
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baou
 * JD-Core Version:    0.7.0.1
 */