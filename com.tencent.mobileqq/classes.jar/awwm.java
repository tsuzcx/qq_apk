import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.multimsg.MultiMsgManager.1;
import com.tencent.mobileqq.multimsg.MultiMsgManager.2;
import com.tencent.mobileqq.multimsg.MultiMsgManager.5;
import com.tencent.mobileqq.multimsg.MultiMsgNick;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.ServerConfigManager.ConfigType;

public class awwm
  implements Comparator<ChatMessage>
{
  private static long jdField_a_of_type_Long;
  private static awwm jdField_a_of_type_Awwm;
  public static final String a;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public int a;
  private bkfu<Integer> jdField_a_of_type_Bkfu;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public ArrayList<ChatMessage> a;
  public HashMap<ChatMessage, Boolean> a;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  public HashMap<String, String> b;
  private int jdField_c_of_type_Int = 100;
  private HashMap<Long, List<MultiMsgNick>> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private int d = 20;
  private int e;
  private int f = 100;
  private int g = 10;
  private int h;
  private int i;
  private int j;
  
  static
  {
    jdField_a_of_type_JavaLangString = anhk.ba + "fight/pic_expire.png";
  }
  
  private awwm()
  {
    this.jdField_e_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static long a()
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      return localFile.length();
    }
    return 0L;
  }
  
  public static awwm a()
  {
    if (jdField_a_of_type_Awwm == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Awwm == null) {
        jdField_a_of_type_Awwm = new awwm();
      }
      return jdField_a_of_type_Awwm;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (!new File(jdField_a_of_type_JavaLangString).exists())
    {
      bgmg.a(paramQQAppInterface.getApp(), 2130841479, jdField_a_of_type_JavaLangString);
      paramQQAppInterface = bgmg.c(jdField_a_of_type_JavaLangString);
      paramQQAppInterface = bdsh.d("chatthumb:" + paramQQAppInterface);
      bgmg.d(jdField_a_of_type_JavaLangString, paramQQAppInterface);
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  /* Error */
  private void a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +37 -> 42
    //   8: ldc 144
    //   10: iconst_2
    //   11: new 36	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   18: ldc 146
    //   20: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc 151
    //   29: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_3
    //   33: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: getfield 159	awwm:jdField_a_of_type_Bkfu	Lbkfu;
    //   46: ifnull +40 -> 86
    //   49: aload_0
    //   50: getfield 159	awwm:jdField_a_of_type_Bkfu	Lbkfu;
    //   53: lload_1
    //   54: iconst_0
    //   55: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 170	bkfu:a	(JLjava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 161	java/lang/Integer
    //   64: invokevirtual 174	java/lang/Integer:intValue	()I
    //   67: iload_3
    //   68: ixor
    //   69: istore_3
    //   70: iload_3
    //   71: ifeq +18 -> 89
    //   74: aload_0
    //   75: getfield 159	awwm:jdField_a_of_type_Bkfu	Lbkfu;
    //   78: lload_1
    //   79: iload_3
    //   80: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: invokevirtual 177	bkfu:a	(JLjava/lang/Object;)V
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: aload_0
    //   90: getfield 159	awwm:jdField_a_of_type_Bkfu	Lbkfu;
    //   93: lload_1
    //   94: invokevirtual 180	bkfu:b	(J)V
    //   97: goto -11 -> 86
    //   100: astore 4
    //   102: aload_0
    //   103: monitorexit
    //   104: aload 4
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	awwm
    //   0	107	1	paramLong	long
    //   0	107	3	paramInt	int
    //   100	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	100	finally
    //   42	70	100	finally
    //   74	86	100	finally
    //   89	97	100	finally
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, int paramInt2, @Nullable Bundle paramBundle)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)paramArrayList.get(0);
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_b_of_type_JavaLangString = paramQQAppInterface.getAccount();
    localbdzn.c = paramString;
    localbdzn.jdField_a_of_type_Int = paramInt1;
    localbdzn.jdField_b_of_type_Int = 2;
    localbdzn.jdField_a_of_type_Long = ((MessageRecord)paramArrayList.get(0)).uniseq;
    localbdzn.jdField_a_of_type_Boolean = true;
    String str;
    boolean bool;
    if (paramBundle != null)
    {
      str = paramBundle.getString("ReceiptMsgManager.EXTRA_KEY_PTT_PATH");
      localbdzn.i = str;
      localbdzn.jdField_e_of_type_Int = 1002;
      if ((paramBundle != null) && (!paramBundle.getBoolean("ReceiptMsgManager.EXTRA_KEY_PTT_COMPRESS_FINISHED"))) {
        break label222;
      }
      bool = true;
      label117:
      localbdzn.jdField_l_of_type_Boolean = bool;
      if (paramBundle == null) {
        break label228;
      }
    }
    label222:
    label228:
    for (int k = a(paramBundle.getInt("ReceiptMsgManager.EXTRA_KEY_PTT_SEND_SOURCE"));; k = 0)
    {
      localbdzn.n = k;
      localbdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)paramArrayList.get(0));
      localMessageForPtt.mInputContent = "";
      localbdzn.jdField_a_of_type_Ayyt = new awwr(paramMessageRecord, paramArrayList, paramQQAppInterface, paramString, paramInt1, paramInt2, this, null);
      localbdzn.jdField_e_of_type_Boolean = false;
      paramQQAppInterface.a().a(localbdzn);
      return;
      str = localMessageForPtt.fullLocalPath;
      break;
      bool = false;
      break label117;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, anqd paramanqd, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("MultiMsg_TAG", 4, "pack multi msg start.............................");
      QLog.d("MultiMsg_TAG", 4, paramArrayList.toString());
    }
    paramanqd = paramQQAppInterface.a().a().a(paramArrayList, paramHashMap, paramBoolean);
    if (paramanqd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "pack multi msg failed.............................");
      }
      if (paramInt2 == 2) {
        ((MessageHandler)paramQQAppInterface.a(0)).notifyUI(8031, false, Integer.valueOf(4));
      }
    }
    do
    {
      return;
      paramMessageRecord.extraflag = 32768;
      paramQQAppInterface.a().a(paramString, paramInt1, paramMessageRecord.uniseq);
      long l = paramMessageRecord.uniseq;
      ((MessageHandler)paramQQAppInterface.a(0)).notifyUI(MessageHandler.a(paramInt1), false, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "pack multi msg done.............................");
      }
      if (paramInt2 == 0) {
        paramHashMap = new awwq(paramQQAppInterface, paramMessageRecord, paramString, paramInt1);
      }
      for (;;)
      {
        if (a(paramQQAppInterface, paramanqd, paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, paramInt1, paramMessageRecord.uniseq, 1035, paramHashMap))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MultiMsg_TAG", 2, "sendMultiMsg successful, upload multi msg pack start.......................");
          return;
          if (paramInt2 == 2)
          {
            paramHashMap = new awwp(paramQQAppInterface, paramMessageRecord, paramString, paramInt1, paramArrayList, paramHashMap);
          }
          else if (paramInt2 == 5)
          {
            paramHashMap = new baht(paramQQAppInterface, paramMessageRecord, paramString, paramInt1);
          }
          else
          {
            QLog.e("MultiMsg_TAG", 1, "not support forwardMode:" + paramInt2);
            return;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg_TAG", 2, "sendMultiMsg failed.......................");
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<ayxr> paramArrayList1, int paramInt2)
  {
    ayxx localayxx = ayxn.a(8, 7);
    localayxx.a(paramArrayList1);
    localayxx.a(new awwn(this, paramInt2, paramMessageRecord, paramArrayList, paramQQAppInterface, paramString, paramInt1, paramHashMap));
    ayxn.a(localayxx, paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<bceh> paramArrayList1, bcev parambcev, int paramInt2)
  {
    bcev localbcev = parambcev;
    if (parambcev == null) {
      localbcev = bcec.a(5, 5);
    }
    localbcev.a(paramArrayList1);
    localbcev.a(new awwo(this, paramArrayList, paramMessageRecord, paramQQAppInterface, paramString, paramInt1, paramHashMap, paramInt2));
    bcec.a(localbcev, paramQQAppInterface);
  }
  
  private void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.a().a(paramString, paramInt, paramMessageRecord.uniseq);
    paramQQAppInterface.a().a(paramString, paramInt, paramMessageRecord.uniseq, 32768, -1);
    long l = paramMessageRecord.uniseq;
    ((MessageHandler)paramQQAppInterface.a(0)).notifyUI(MessageHandler.a(paramInt), false, new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  private boolean a(long paramLong)
  {
    for (;;)
    {
      try
      {
        boolean bool2;
        if (this.jdField_a_of_type_Bkfu == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "isReceiptMessageFinished map null and res: false");
          }
          bool2 = false;
          return bool2;
        }
        boolean bool1;
        if (((Integer)this.jdField_a_of_type_Bkfu.a(paramLong, Integer.valueOf(0))).intValue() == 0)
        {
          bool1 = true;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("MultiMsg_TAG", 2, "isReceiptMessageFinished res: " + bool1);
            bool2 = bool1;
          }
        }
        else
        {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, ayyt paramayyt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[sendMultiMsg]data.length = " + paramArrayOfByte.length);
    }
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_a_of_type_Boolean = true;
    localbdzn.jdField_b_of_type_Int = 131078;
    localbdzn.h = 0;
    localbdzn.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    localbdzn.jdField_b_of_type_JavaLangString = paramString1;
    localbdzn.c = paramString2;
    localbdzn.d = paramString3;
    localbdzn.jdField_a_of_type_Int = paramInt1;
    localbdzn.jdField_a_of_type_Long = paramLong;
    localbdzn.jdField_e_of_type_Int = paramInt2;
    localbdzn.r = d();
    localbdzn.jdField_a_of_type_Ayyt = paramayyt;
    paramQQAppInterface.a().a(localbdzn);
    return true;
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_Bkfu == null) {
        this.jdField_a_of_type_Bkfu = new bkfu();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "updateFinishMask mask: " + paramInt);
    }
    this.jdField_b_of_type_Int ^= paramInt;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int != 7) {
      return this.jdField_c_of_type_Int;
    }
    return 50;
  }
  
  public int a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if ((paramChatMessage1.istroop == 1) || (paramChatMessage1.istroop == 3000)) {
      if (paramChatMessage1.shmsgseq == paramChatMessage2.shmsgseq) {
        if (paramChatMessage1.getId() <= paramChatMessage2.getId()) {}
      }
    }
    do
    {
      do
      {
        do
        {
          return 1;
          if (paramChatMessage1.getId() < paramChatMessage2.getId()) {
            return -1;
          }
          return 0;
        } while (paramChatMessage1.shmsgseq > paramChatMessage2.shmsgseq);
        return -1;
        if (paramChatMessage1.time != paramChatMessage2.time) {
          break;
        }
      } while (paramChatMessage1.getId() > paramChatMessage2.getId());
      if (paramChatMessage1.getId() < paramChatMessage2.getId()) {
        return -1;
      }
      return 0;
    } while (paramChatMessage1.time > paramChatMessage2.time);
    return -1;
  }
  
  public int a(Collection<ChatMessage> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    int k = 0;
    Object localObject1;
    if (paramCollection.hasNext())
    {
      localObject1 = (ChatMessage)paramCollection.next();
      if ((localObject1 instanceof MessageForPic)) {
        k += 1;
      }
    }
    for (;;)
    {
      break;
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((MessageRecord)((Iterator)localObject1).next() instanceof MessageForPic)) {
            k += 1;
          }
        }
      }
      else
      {
        int m = k;
        if (((ChatMessage)localObject1).msgtype == -1036)
        {
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
          do
          {
            m = k;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
          } while (!(localObject2 instanceof MessageForMixedMsg));
          Object localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          m = k;
          for (;;)
          {
            k = m;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForPic)) {
              m += 1;
            }
          }
          return k;
        }
        k = m;
      }
    }
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public MessageForStructing a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, AbsStructMsg paramAbsStructMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, " favorMultiMsg start: ");
    }
    paramString2 = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = bbzh.a(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt, 0L, paramAbsStructMsg);
    paramQQAppInterface.isReMultiMsg = true;
    return (MessageForStructing)paramQQAppInterface;
  }
  
  public String a(String paramString, long paramLong, QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {}
    Object localObject;
    do
    {
      while (!paramQQAppInterface.hasNext())
      {
        do
        {
          return null;
          if (this.jdField_c_of_type_JavaUtilHashMap.size() > 0)
          {
            localObject = (List)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                MultiMsgNick localMultiMsgNick = (MultiMsgNick)((Iterator)localObject).next();
                if ((localMultiMsgNick != null) && (paramString.equals(localMultiMsgNick.uin)) && (paramLong == localMultiMsgNick.uniseq)) {
                  return localMultiMsgNick.nick;
                }
              }
            }
          }
          this.jdField_c_of_type_JavaUtilHashMap.clear();
          paramQQAppInterface = paramQQAppInterface.a().createEntityManager().query(MultiMsgNick.class, new MultiMsgNick().getTableName(), false, "uniseq = ?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
        } while ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0));
        this.jdField_c_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramQQAppInterface);
        paramQQAppInterface = paramQQAppInterface.iterator();
      }
      localObject = (MultiMsgNick)paramQQAppInterface.next();
    } while ((localObject == null) || (!paramString.equals(((MultiMsgNick)localObject).uin)) || (paramLong != ((MultiMsgNick)localObject).uniseq));
    return ((MultiMsgNick)localObject).nick;
  }
  
  public List<ChatMessage> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return a(paramQQAppInterface, paramLong, null, 0);
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt)
  {
    Object localObject = paramQQAppInterface.a().a().a(paramLong);
    if (paramString != null) {
      acwh.a(paramString, paramInt, (List)localObject, paramQQAppInterface);
    }
    paramQQAppInterface = new ArrayList();
    paramString = ((List)localObject).iterator();
    while (paramString.hasNext())
    {
      localObject = (MessageRecord)paramString.next();
      if ((localObject instanceof MessageForStructing))
      {
        MessageForStructing localMessageForStructing = (MessageForStructing)localObject;
        if (localMessageForStructing.structingMsg == null) {
          localMessageForStructing.structingMsg = bcwd.a(((MessageRecord)localObject).msgData);
        }
      }
      if ((localObject instanceof MessageForQQStoryComment)) {
        ((MessageForQQStoryComment)localObject).displayType = 1;
      }
      paramQQAppInterface.add((ChatMessage)localObject);
      if ((QLog.isColorLevel()) && ((localObject instanceof MessageForPic)))
      {
        localObject = (MessageForPic)localObject;
        QLog.d("MultiMsg_TAG", 2, "[chatPie.getMultiMsgList] = " + ((MessageForPic)localObject).toLogString() + " mr = " + ((MessageForPic)localObject).toString());
      }
    }
    return paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramSessionInfo.clone());
      return;
    }
    catch (CloneNotSupportedException paramSessionInfo) {}
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    return;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    String str2;
    Object localObject;
    int k;
    if (paramQQAppInterface != null)
    {
      String str1 = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_enable");
      paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxMsgNum");
      str2 = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxPicNum");
      localObject = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxVideoNum");
      k = bgsg.a(paramQQAppInterface.c(), "multimsg_config");
      if (k > 0) {
        this.jdField_c_of_type_Int = k;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "initLimitCount enable = " + str1 + " maxMsgNum = " + k + " maxPicNum " + str2);
      }
      if (TextUtils.isEmpty(str2)) {}
    }
    try
    {
      this.d = Integer.parseInt(str2);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      try
      {
        this.jdField_e_of_type_Int = Integer.parseInt((String)localObject);
        paramQQAppInterface = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.MultiMsgConfig.name(), "100|10|0|0");
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "initLimitCount delayConfi = " + paramQQAppInterface);
        }
        if (!TextUtils.isEmpty(paramQQAppInterface))
        {
          localObject = new Integer[4];
          Arrays.fill((Object[])localObject, Integer.valueOf(0));
          if (DeviceProfileManager.a(paramQQAppInterface, (Object[])localObject, new ankp()) >= localObject.length)
          {
            if (localObject[0].intValue() >= 0)
            {
              this.f = localObject[0].intValue();
              if (localObject[1].intValue() <= 0) {
                break label349;
              }
              k = localObject[1].intValue();
              this.g = k;
            }
            if (localObject[2].intValue() < 0) {
              break label357;
            }
            k = localObject[2].intValue();
            this.h = k;
            if (localObject[3].intValue() < 0) {
              break label365;
            }
            k = localObject[3].intValue();
            this.i = k;
          }
        }
        this.jdField_a_of_type_Boolean = true;
        return;
        paramQQAppInterface = paramQQAppInterface;
        this.d = 20;
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        for (;;)
        {
          this.jdField_e_of_type_Int = 10;
          continue;
          label349:
          k = this.g;
          continue;
          label357:
          k = this.h;
          continue;
          label365:
          k = this.i;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArrayList<ChatMessage> paramArrayList)
  {
    a(paramQQAppInterface, paramSessionInfo, paramArrayList, 0);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList);
    ((bauy)paramQQAppInterface.getManager(326)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramArrayList);
    paramQQAppInterface.a(new MultiMsgManager.1(this, localArrayList, paramQQAppInterface, paramSessionInfo, paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramQQAppInterface.a(new MultiMsgManager.5(this, paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, AbsStructMsg paramAbsStructMsg, long paramLong, boolean paramBoolean, int paramInt2)
  {
    a(paramQQAppInterface, paramString1, paramInt1, paramString2, paramAbsStructMsg, paramLong, paramBoolean, paramInt2, -1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, AbsStructMsg paramAbsStructMsg, long paramLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 4, " sendMultiMsg start uniseq =  " + paramLong);
    }
    Object localObject1;
    int k;
    Object localObject2;
    if (paramLong == 0L)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      k = 1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ChatMessage)((Iterator)localObject1).next();
        if (((localObject2 instanceof MessageForText)) || ((localObject2 instanceof MessageForLongMsg))) {
          break label820;
        }
        k = 0;
      }
    }
    label547:
    label811:
    label820:
    for (;;)
    {
      break;
      if (k != 0) {
        bcst.b(paramQQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      localObject2 = new HashMap();
      ((HashMap)localObject2).putAll(this.jdField_b_of_type_JavaUtilHashMap);
      new aikc().a(paramQQAppInterface, paramString1, localArrayList, paramInt2);
      if (paramInt2 == 1)
      {
        paramAbsStructMsg = new SessionInfo();
        paramAbsStructMsg.jdField_a_of_type_Int = paramInt1;
        paramAbsStructMsg.jdField_a_of_type_JavaLangString = paramString1;
        paramAbsStructMsg.jdField_b_of_type_JavaLangString = paramString2;
        a(paramQQAppInterface, paramAbsStructMsg, localArrayList, paramInt3);
        return;
      }
      if (paramInt2 == 2)
      {
        localObject1 = paramQQAppInterface.getCurrentAccountUin();
        k = bbxc.jdField_a_of_type_Int;
        bbxc.jdField_a_of_type_Int = k + 1;
        localObject1 = bbzh.a(paramQQAppInterface, (String)localObject1, paramString1, (String)localObject1, 1040, k, paramAbsStructMsg);
        ((MessageRecord)localObject1).msg = adrm.a(localArrayList, (Map)localObject2);
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        if (localObject1 == null)
        {
          paramAbsStructMsg.forwardID = paramInt3;
          localObject3 = bgsc.a(paramQQAppInterface, paramString1, paramInt1, paramAbsStructMsg);
        }
        if (localObject3 == null) {
          break;
        }
        ((MessageRecord)localObject3).isReMultiMsg = true;
        agjf.a().a(((MessageRecord)localObject3).uniseq, 0L, paramInt3);
        if (paramBoolean) {
          paramQQAppInterface.a().b(paramString1, paramInt1, paramLong);
        }
        Object localObject4;
        if ((paramInt2 == 0) || (paramInt2 == 2))
        {
          localObject1 = new awws();
          localObject4 = new SessionInfo();
          ((SessionInfo)localObject4).jdField_a_of_type_JavaLangString = paramString1;
          ((SessionInfo)localObject4).jdField_a_of_type_Int = paramInt1;
          if (paramInt2 == 2)
          {
            ((SessionInfo)localObject4).jdField_a_of_type_Int = 1040;
            ((SessionInfo)localObject4).g = paramInt1;
          }
          ((SessionInfo)localObject4).jdField_b_of_type_JavaLangString = paramString2;
          ((awws)localObject1).jdField_a_of_type_Int = 0;
          ((awws)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)localObject4);
          ((awws)localObject1).jdField_a_of_type_JavaUtilList = localArrayList;
          ((awws)localObject1).jdField_a_of_type_JavaUtilMap = ((Map)localObject2);
          ((awws)localObject1).jdField_b_of_type_Int = paramInt2;
          ((awws)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = paramAbsStructMsg;
          ((awws)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = ((MessageForStructing)localObject3);
          paramQQAppInterface.a().e((awws)localObject1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MultiMsg_TAG", 2, String.format("step.sendRequest:msglistSize = %d", new Object[] { Integer.valueOf(localArrayList.size()) }));
          return;
          localArrayList = new ArrayList();
          localObject1 = paramQQAppInterface.a().a().a(paramLong).iterator();
          k = 1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if ((localObject2 instanceof ChatMessage)) {
              localArrayList.add((ChatMessage)localObject2);
            }
            if (((localObject2 instanceof MessageForText)) || ((localObject2 instanceof MessageForLongMsg))) {
              break label811;
            }
            k = 0;
          }
        }
        for (;;)
        {
          break label547;
          if (k != 0) {
            bcst.b(paramQQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
          }
          localObject3 = new HashMap();
          localObject4 = localArrayList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject4).next();
            if (!((HashMap)localObject3).containsKey(localMessageRecord.senderuin))
            {
              localObject2 = localMessageRecord.getExtInfoFromExtStr("self_nickname");
              localObject1 = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = a(localMessageRecord.senderuin, localMessageRecord.msgseq, paramQQAppInterface);
              }
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                if (((String)localObject1).trim().length() != 0) {}
              }
              else
              {
                localObject2 = awwt.a(localMessageRecord.senderuin);
              }
              ((HashMap)localObject3).put(localMessageRecord.senderuin, localObject2);
            }
          }
          localObject1 = null;
          localObject2 = localObject3;
          break;
          a(paramQQAppInterface, paramString1, paramInt1, localArrayList, (HashMap)localObject2, (MessageRecord)localObject3, paramInt2);
          return;
        }
        localObject1 = null;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, ArrayList<ChatMessage> paramArrayList, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, int paramInt2)
  {
    a(paramQQAppInterface, paramString, paramInt1, paramArrayList, paramHashMap, paramMessageRecord, paramInt2, null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, ArrayList<ChatMessage> paramArrayList, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, int paramInt2, @Nullable Bundle paramBundle)
  {
    if (paramMessageRecord == null) {}
    while ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramQQAppInterface.a(new MultiMsgManager.2(this, paramArrayList, paramInt2, paramHashMap, paramMessageRecord, paramQQAppInterface, paramString, paramInt1, paramBundle));
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (int k = 0;; k = 1)
    {
      localHashMap.put("result", k + "");
      if (paramList == null) {
        break;
      }
      k = paramList.size();
      int m = a().a(paramList);
      localHashMap.put("msgCount", k + "");
      localHashMap.put("picCount", m + "");
      bctj.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
    bctj.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null) {
      return;
    }
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLongMsg)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if (paramChatMessage.uniseq == localChatMessage.uniseq)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(localChatMessage, Boolean.valueOf(paramBoolean));
          return;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, Boolean.valueOf(paramBoolean));
  }
  
  public void a(MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    if (this.i != 0) {}
    String str1;
    do
    {
      do
      {
        return;
      } while ((this.h != 0) && (ayxu.a(paramQQAppInterface, paramMessageForStructing.istroop, paramMessageForStructing.frienduin) == 1));
      str1 = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).mResid;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg_TAG", 2, "preDownloadRes failed by empty resid!");
    return;
    String str2 = paramMessageForStructing.frienduin;
    int k = paramMessageForStructing.istroop;
    long l = paramMessageForStructing.uniseq;
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "preDownloadRes begin! touin:" + str2 + ",touinType:" + k + ",uniseq:" + l + ",fileKey:" + str1);
    }
    a().a(paramQQAppInterface, str1, paramQQAppInterface.getCurrentAccountUin(), str2, str2, k, l, 1035, null);
  }
  
  /* Error */
  public void a(HashMap<String, String> paramHashMap, long paramLong, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +184 -> 185
    //   4: aload_1
    //   5: invokevirtual 533	java/util/HashMap:size	()I
    //   8: ifle +177 -> 185
    //   11: new 81	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 82	java/util/ArrayList:<init>	()V
    //   18: astore 5
    //   20: aload_1
    //   21: invokevirtual 588	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   24: invokeinterface 591 1 0
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 483 1 0
    //   36: ifeq +78 -> 114
    //   39: aload_1
    //   40: invokeinterface 487 1 0
    //   45: checkcast 593	java/util/Map$Entry
    //   48: astore 7
    //   50: aload 7
    //   52: invokeinterface 604 1 0
    //   57: checkcast 544	java/lang/String
    //   60: astore 6
    //   62: aload 7
    //   64: invokeinterface 596 1 0
    //   69: checkcast 544	java/lang/String
    //   72: astore 7
    //   74: new 539	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   77: dup
    //   78: invokespecial 565	com/tencent/mobileqq/multimsg/MultiMsgNick:<init>	()V
    //   81: astore 8
    //   83: aload 8
    //   85: aload 6
    //   87: putfield 542	com/tencent/mobileqq/multimsg/MultiMsgNick:uin	Ljava/lang/String;
    //   90: aload 8
    //   92: lload_2
    //   93: putfield 549	com/tencent/mobileqq/multimsg/MultiMsgNick:uniseq	J
    //   96: aload 8
    //   98: aload 7
    //   100: putfield 552	com/tencent/mobileqq/multimsg/MultiMsgNick:nick	Ljava/lang/String;
    //   103: aload 5
    //   105: aload 8
    //   107: invokevirtual 864	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: goto -81 -> 30
    //   114: aload 4
    //   116: invokevirtual 558	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   119: invokevirtual 564	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   122: astore 4
    //   124: aload 4
    //   126: invokevirtual 973	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 978	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   134: aload 5
    //   136: invokevirtual 772	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   139: astore 5
    //   141: aload 5
    //   143: invokeinterface 483 1 0
    //   148: ifeq +38 -> 186
    //   151: aload 4
    //   153: aload 5
    //   155: invokeinterface 487 1 0
    //   160: checkcast 539	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   163: invokevirtual 982	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   166: goto -25 -> 141
    //   169: astore 5
    //   171: aload 5
    //   173: invokevirtual 985	java/lang/Exception:printStackTrace	()V
    //   176: aload_1
    //   177: invokevirtual 988	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   180: aload 4
    //   182: invokevirtual 991	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   185: return
    //   186: aload_1
    //   187: invokevirtual 994	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   190: aload_1
    //   191: invokevirtual 988	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   194: goto -14 -> 180
    //   197: astore 4
    //   199: aload_1
    //   200: invokevirtual 988	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   203: aload 4
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	awwm
    //   0	206	1	paramHashMap	HashMap<String, String>
    //   0	206	2	paramLong	long
    //   0	206	4	paramQQAppInterface	QQAppInterface
    //   18	136	5	localObject1	Object
    //   169	3	5	localException	java.lang.Exception
    //   60	26	6	str	String
    //   48	51	7	localObject2	Object
    //   81	25	8	localMultiMsgNick	MultiMsgNick
    // Exception table:
    //   from	to	target	type
    //   130	141	169	java/lang/Exception
    //   141	166	169	java/lang/Exception
    //   186	190	169	java/lang/Exception
    //   130	141	197	finally
    //   141	166	197	finally
    //   171	176	197	finally
    //   186	190	197	finally
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (((ChatMessage)paramList.get(0)).isLongMsg()) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (ChatMessage)paramList.next();
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
          this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChatMessage localChatMessage1 = (ChatMessage)((Map.Entry)((Iterator)localObject).next()).getKey();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage2 = (ChatMessage)localIterator.next();
        if ((localChatMessage2.shmsgseq == localChatMessage1.shmsgseq) && (localChatMessage2.msgUid == localChatMessage1.msgUid)) {
          ((Iterator)localObject).remove();
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    bcst.b(paramQQAppInterface, "CliOper", "", "", "0X8006628", "0X8006628", 0, 1, 0, "", "", "", "");
    return a(paramQQAppInterface, paramLong).size() > 0;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, long paramLong, int paramInt2, ayxc paramayxc)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {}
      return false;
    }
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_a_of_type_Boolean = false;
    localbdzn.jdField_b_of_type_Int = 131078;
    localbdzn.jdField_l_of_type_JavaLangString = paramString1;
    localbdzn.jdField_b_of_type_JavaLangString = paramString2;
    localbdzn.c = paramString3;
    localbdzn.d = paramString4;
    localbdzn.jdField_a_of_type_Int = paramInt1;
    localbdzn.jdField_a_of_type_Long = paramLong;
    localbdzn.jdField_e_of_type_Int = paramInt2;
    localbdzn.jdField_a_of_type_Ayxc = paramayxc;
    paramQQAppInterface.a().a(localbdzn);
    return true;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    Object localObject;
    ChatMessage localChatMessage;
    if ((paramChatMessage instanceof MessageForLongMsg))
    {
      localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if ((localChatMessage != null) && (paramChatMessage.uniseq == localChatMessage.uniseq) && (this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage) != null)) {
          return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue();
        }
      }
      return false;
    }
    if (paramChatMessage != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet();
      if (((Set)localObject).contains(paramChatMessage)) {
        return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(paramChatMessage)).booleanValue();
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if (paramChatMessage.uniseq == localChatMessage.uniseq)
        {
          boolean bool = ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue();
          this.jdField_a_of_type_JavaUtilHashMap.remove(localChatMessage);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, Boolean.valueOf(bool));
          return bool;
        }
      }
    }
    return false;
  }
  
  public boolean a(ChatMessage paramChatMessage, int paramInt)
  {
    int m = c();
    int k;
    int n;
    if (this.jdField_a_of_type_Int == 7)
    {
      k = 1;
      n = m + k;
      if (n <= paramInt) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, String.format("isWillBeyondTotalLimit: hasCount = %d,willCheckCount = %d,willTotalCount = %d", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(n) }));
      }
      return bool;
      k = awwt.a(paramChatMessage);
      break;
    }
  }
  
  public int b()
  {
    return this.j;
  }
  
  public void b(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet();
      if (((Set)localObject).contains(paramChatMessage))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, Boolean.valueOf(paramBoolean));
        return;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if (paramChatMessage.uniseq == localChatMessage.uniseq) {
          this.jdField_a_of_type_JavaUtilHashMap.put(localChatMessage, Boolean.valueOf(paramBoolean));
        }
      }
      for (int k = 1; k == 0; k = 0)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, Boolean.valueOf(paramBoolean));
        return;
      }
    }
  }
  
  public void b(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      Collections.sort(paramList, jdField_a_of_type_Awwm);
    }
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramLong);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      Iterator localIterator1 = paramQQAppInterface.iterator();
      if (localIterator1.hasNext())
      {
        paramQQAppInterface = (ChatMessage)localIterator1.next();
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 4, " isContainedNotExistPic ChatMessage = " + paramQQAppInterface.getClass().getName());
        }
        if ((paramQQAppInterface instanceof MessageForPic)) {
          paramQQAppInterface = (MessageForPic)paramQQAppInterface;
        }
        label99:
        Iterator localIterator2;
        Object localObject;
        for (;;)
        {
          if ((paramQQAppInterface != null) && (!bdzx.a(null, paramQQAppInterface, 65537)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg_TAG", 4, " isContainedNotExistPic is = true ");
            }
            return true;
            if ((paramQQAppInterface instanceof MessageForMixedMsg))
            {
              localIterator2 = ((MessageForMixedMsg)paramQQAppInterface).msgElemList.iterator();
              localObject = null;
              label155:
              paramQQAppInterface = (QQAppInterface)localObject;
              if (!localIterator2.hasNext()) {
                continue;
              }
              paramQQAppInterface = (MessageRecord)localIterator2.next();
              if (!(paramQQAppInterface instanceof MessageForPic)) {
                break label406;
              }
            }
          }
        }
        label272:
        label403:
        label404:
        label406:
        for (paramQQAppInterface = (MessageForPic)paramQQAppInterface;; paramQQAppInterface = (QQAppInterface)localObject)
        {
          localObject = paramQQAppInterface;
          break label155;
          if (paramQQAppInterface.msgtype == -1036)
          {
            localIterator2 = ((MessageForLongMsg)paramQQAppInterface).longMsgFragmentList.iterator();
            localObject = null;
            Iterator localIterator3;
            do
            {
              do
              {
                paramQQAppInterface = (QQAppInterface)localObject;
                if (!localIterator2.hasNext()) {
                  break;
                }
                paramQQAppInterface = (MessageRecord)localIterator2.next();
              } while (!(paramQQAppInterface instanceof MessageForMixedMsg));
              localIterator3 = ((MessageForMixedMsg)paramQQAppInterface).msgElemList.iterator();
              paramQQAppInterface = (QQAppInterface)localObject;
              localObject = paramQQAppInterface;
            } while (!localIterator3.hasNext());
            localObject = (MessageRecord)localIterator3.next();
            if (!(localObject instanceof MessageForPic)) {
              break label403;
            }
            paramQQAppInterface = (MessageForPic)localObject;
          }
          for (;;)
          {
            break label272;
            if (!(paramQQAppInterface instanceof MessageForStructing)) {
              break label404;
            }
            paramQQAppInterface = ((MessageForStructing)paramQQAppInterface).structingMsg;
            if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof StructMsgForImageShare)))
            {
              localObject = ((StructMsgForImageShare)paramQQAppInterface).getFirstImageElement();
              if ((localObject != null) && (((bcxy)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
              {
                if (((bcxy)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                  ((bcxy)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)paramQQAppInterface);
                }
                ((bcxy)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((bcxy)localObject).a();
                paramQQAppInterface = ((bcxy)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
                break label99;
              }
            }
            paramQQAppInterface = null;
            break label99;
            break;
          }
          break;
        }
      }
    }
    return false;
  }
  
  public int c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    int k = 0;
    ChatMessage localChatMessage;
    int m;
    if (localIterator.hasNext())
    {
      localChatMessage = (ChatMessage)localIterator.next();
      if (!((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue()) {
        break label112;
      }
      if (this.jdField_a_of_type_Int == 7)
      {
        m = 1;
        label64:
        k = m + k;
      }
    }
    label112:
    for (;;)
    {
      break;
      m = awwt.a(localChatMessage);
      break label64;
      awwt.b("checkMap.size = %d,count= %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()), Integer.valueOf(k) });
      return k;
    }
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwm
 * JD-Core Version:    0.7.0.1
 */