import NS_MOBILE_OPERATION.operation_like_rsp;
import NS_QZONE_MQMSG.QzoneMessageBoxRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.contentbox.QZoneMsgManager.1;
import cooperation.qzone.contentbox.QZoneMsgManager.2;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class blxg
  implements Manager, BusinessObserver
{
  String jdField_a_of_type_JavaLangString = null;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<QZoneMsgEntityNew> jdField_a_of_type_JavaUtilArrayList;
  private String b;
  
  public blxg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "contentbox_load_num", "1_1_1");
    }
    String[] arrayOfString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      arrayOfString = this.jdField_a_of_type_JavaLangString.split("_");
      if (arrayOfString.length == 3) {
        break label51;
      }
    }
    label51:
    while (TextUtils.isEmpty(arrayOfString[paramInt])) {
      return 2;
    }
    try
    {
      paramInt = Integer.parseInt(arrayOfString[paramInt]);
      return paramInt;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager", "getLoadNum error", localException);
    }
    return 2;
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  /* Error */
  public ArrayList<QZoneMsgEntityNew> a()
  {
    // Byte code:
    //   0: invokestatic 93	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   3: ifeq +10 -> 13
    //   6: ldc 71
    //   8: ldc 95
    //   10: invokestatic 99	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 101	blxg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: ifnull +8 -> 25
    //   20: aload_0
    //   21: getfield 101	blxg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   24: areturn
    //   25: aload_0
    //   26: invokevirtual 103	blxg:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnonnull +12 -> 43
    //   34: ldc 71
    //   36: ldc 105
    //   38: invokestatic 107	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aconst_null
    //   42: areturn
    //   43: aload_2
    //   44: invokevirtual 110	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   47: invokevirtual 116	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   50: astore_2
    //   51: aload_2
    //   52: ldc 118
    //   54: iconst_0
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: ldc 120
    //   61: ldc 122
    //   63: invokevirtual 128	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   66: astore_3
    //   67: aload_0
    //   68: new 130	java/util/ArrayList
    //   71: dup
    //   72: invokespecial 131	java/util/ArrayList:<init>	()V
    //   75: putfield 101	blxg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   78: aload_3
    //   79: ifnull +68 -> 147
    //   82: aload_3
    //   83: invokeinterface 137 1 0
    //   88: ifle +59 -> 147
    //   91: iconst_1
    //   92: istore_1
    //   93: iload_1
    //   94: aload_3
    //   95: invokeinterface 137 1 0
    //   100: if_icmpge +47 -> 147
    //   103: aload_3
    //   104: iload_1
    //   105: invokeinterface 140 2 0
    //   110: checkcast 118	cooperation/qzone/contentbox/model/QZoneMsgEntityNew
    //   113: astore 4
    //   115: aload 4
    //   117: ifnull +23 -> 140
    //   120: aload 4
    //   122: invokevirtual 143	cooperation/qzone/contentbox/model/QZoneMsgEntityNew:readArkNewsFromBuffer	()V
    //   125: aload 4
    //   127: invokevirtual 146	cooperation/qzone/contentbox/model/QZoneMsgEntityNew:readBottomItemsFromBuffer	()V
    //   130: aload_0
    //   131: getfield 101	blxg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   134: aload 4
    //   136: invokevirtual 150	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   139: pop
    //   140: iload_1
    //   141: iconst_1
    //   142: iadd
    //   143: istore_1
    //   144: goto -51 -> 93
    //   147: aload_2
    //   148: ifnull +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 153	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   155: aload_0
    //   156: getfield 101	blxg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   159: areturn
    //   160: astore_3
    //   161: aconst_null
    //   162: astore_2
    //   163: ldc 71
    //   165: iconst_1
    //   166: aload_3
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 156	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   174: aload_2
    //   175: ifnull -20 -> 155
    //   178: aload_2
    //   179: invokevirtual 153	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   182: goto -27 -> 155
    //   185: astore_3
    //   186: aconst_null
    //   187: astore_2
    //   188: aload_2
    //   189: ifnull +7 -> 196
    //   192: aload_2
    //   193: invokevirtual 153	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   196: aload_3
    //   197: athrow
    //   198: astore_3
    //   199: goto -11 -> 188
    //   202: astore_3
    //   203: goto -15 -> 188
    //   206: astore_3
    //   207: goto -44 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	blxg
    //   92	52	1	i	int
    //   29	164	2	localObject1	Object
    //   66	38	3	localList	java.util.List
    //   160	7	3	localThrowable1	java.lang.Throwable
    //   185	12	3	localObject2	Object
    //   198	1	3	localObject3	Object
    //   202	1	3	localObject4	Object
    //   206	1	3	localThrowable2	java.lang.Throwable
    //   113	22	4	localQZoneMsgEntityNew	QZoneMsgEntityNew
    // Exception table:
    //   from	to	target	type
    //   43	51	160	java/lang/Throwable
    //   43	51	185	finally
    //   51	78	198	finally
    //   82	91	198	finally
    //   93	115	198	finally
    //   120	140	198	finally
    //   163	174	202	finally
    //   51	78	206	java/lang/Throwable
    //   82	91	206	java/lang/Throwable
    //   93	115	206	java/lang/Throwable
    //   120	140	206	java/lang/Throwable
  }
  
  public void a()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "preLoadQZoneMsg()");
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      QZLog.e("QZoneMsgManager", "preLoadQZoneMsg app == null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
    } while (!QZLog.isColorLevel());
    QZLog.i("QZoneMsgManager", "msgEntity != null, not need preLoadQZoneMsg");
    return;
    blxo localblxo = new blxo(localQQAppInterface.getLongAccountUin(), "", a(0), 1);
    localblxo.a(0);
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(localQQAppInterface.getApplication(), arii.class);
    localQzoneCommonIntent.setRequest(localblxo);
    localQzoneCommonIntent.setObserver(this);
    localQQAppInterface.startServlet(localQzoneCommonIntent);
  }
  
  public void a(MQLikeCell paramMQLikeCell, long paramLong)
  {
    boolean bool = true;
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "likeFeed()");
    }
    if ((paramMQLikeCell == null) || (TextUtils.isEmpty(paramMQLikeCell.likeKey))) {
      return;
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QZLog.e("QZoneMsgManager", "likeFeed app == null");
      return;
    }
    long l = localQQAppInterface.getLongAccountUin();
    Object localObject1 = paramMQLikeCell.likeKey;
    Object localObject2 = paramMQLikeCell.likeKey;
    int i;
    Bundle localBundle;
    if (!paramMQLikeCell.liked)
    {
      i = 0;
      localObject1 = new blxn(Long.valueOf(l), (String)localObject1, (String)localObject2, i, paramMQLikeCell.appid);
      ((blxn)localObject1).a(100);
      localObject2 = new QzoneCommonIntent(localQQAppInterface.getApplication(), arii.class);
      localBundle = new Bundle();
      if (paramMQLikeCell.liked) {
        break label194;
      }
    }
    for (;;)
    {
      localBundle.putBoolean("like_key", bool);
      localBundle.putLong("entity_pushtime", paramLong);
      ((QzoneCommonIntent)localObject2).putExtras(localBundle);
      ((QzoneCommonIntent)localObject2).setRequest((blrw)localObject1);
      ((QzoneCommonIntent)localObject2).setObserver(this);
      localQQAppInterface.startServlet((NewIntent)localObject2);
      return;
      i = 1;
      break;
      label194:
      bool = false;
    }
  }
  
  public void a(MQMsg paramMQMsg)
  {
    if ((paramMQMsg == null) || (paramMQMsg.msgInteractData == null) || (paramMQMsg.msgInteractData.likeCell == null) || (TextUtils.isEmpty(paramMQMsg.msgInteractData.likeCell.likeKey))) {}
    String str;
    do
    {
      return;
      str = paramMQMsg.msgInteractData.likeCell.likeKey;
    } while (this.jdField_a_of_type_JavaUtilArrayList == null);
    int i = 0;
    label58:
    QZoneMsgEntityNew localQZoneMsgEntityNew;
    MQMsg localMQMsg;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localQZoneMsgEntityNew = (QZoneMsgEntityNew)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localQZoneMsgEntityNew != null) && (localQZoneMsgEntityNew.ArkNes_vec != null) && (localQZoneMsgEntityNew.ArkNes_vec.get(0) != null))
      {
        localMQMsg = (MQMsg)localQZoneMsgEntityNew.ArkNes_vec.get(0);
        if ((localMQMsg != null) && (localMQMsg.msgInteractData != null) && (localMQMsg.msgInteractData.likeCell != null) && (!TextUtils.isEmpty(localMQMsg.msgInteractData.likeCell.likeKey))) {
          break label169;
        }
      }
    }
    label169:
    while (!str.equals(localMQMsg.msgInteractData.likeCell.likeKey))
    {
      i += 1;
      break label58;
      break;
    }
    localMQMsg.msgInteractData.likeCell.totalLike = paramMQMsg.msgInteractData.likeCell.totalLike;
    localMQMsg.msgInteractData.totalComment = paramMQMsg.msgInteractData.totalComment;
    localMQMsg.msgInteractData.likeCell.liked = paramMQMsg.msgInteractData.likeCell.liked;
    a(localQZoneMsgEntityNew, 0);
  }
  
  public void a(QZoneMsgEntityNew paramQZoneMsgEntityNew, int paramInt)
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "saveMsgToDB()");
    }
    if (paramQZoneMsgEntityNew == null)
    {
      QZLog.e("QZoneMsgManager", "saveMsgToDB error entity==null");
      return;
    }
    this.b = paramQZoneMsgEntityNew.trace_info;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramInt = 0;
      if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label185;
      }
      if (((QZoneMsgEntityNew)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).pushTime == paramQZoneMsgEntityNew.pushTime)
      {
        paramQZoneMsgEntityNew.setId(((QZoneMsgEntityNew)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).getId());
        paramQZoneMsgEntityNew.setStatus(((QZoneMsgEntityNew)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).getStatus());
        this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, paramQZoneMsgEntityNew);
      }
    }
    label185:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, paramQZoneMsgEntityNew);
      }
      for (;;)
      {
        ThreadManager.getFileThreadHandler().post(new QZoneMsgManager.2(this, paramQZoneMsgEntityNew));
        return;
        paramInt += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        this.jdField_a_of_type_JavaUtilArrayList.add(paramQZoneMsgEntityNew);
      }
    }
  }
  
  public void b()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "refreshQZoneMsg()");
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QZLog.e("QZoneMsgManager", "refreshQZoneMsg app == null");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new QZoneMsgManager.1(this, localQQAppInterface));
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.b = null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      QZLog.e("QZoneMsgManager", "onReceive app == null");
    }
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      localObject1 = (JceStruct)paramBundle.getSerializable("key_response");
      int i = paramBundle.getInt("key_response_code");
      localObject2 = paramBundle.getString("key_response_msg");
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager", 2, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(i), localObject2, paramBundle.toString() }));
      }
      if ((localObject1 instanceof QzoneMessageBoxRsp))
      {
        localObject1 = QZoneMsgEntityNew.readFrom((QzoneMessageBoxRsp)localObject1);
        if (localObject1 != null)
        {
          paramBundle.putSerializable("key_response", (Serializable)localObject1);
          localQQAppInterface.notifyObservers(blxh.class, paramInt, true, paramBundle);
          a((QZoneMsgEntityNew)localObject1, paramInt);
          return;
        }
        localQQAppInterface.notifyObservers(blxh.class, paramInt, false, paramBundle);
        QZLog.e("QZoneMsgManager", "onReceive entity == null");
        return;
      }
      if (!(localObject1 instanceof operation_like_rsp)) {
        break;
      }
    } while (((operation_like_rsp)localObject1).ret != 0);
    paramBoolean = paramBundle.getBoolean("like_key");
    long l = paramBundle.getLong("entity_pushtime");
    if ((l > 0L) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QZoneMsgEntityNew)((Iterator)localObject1).next();
        if ((((QZoneMsgEntityNew)localObject2).pushTime == l) && (((QZoneMsgEntityNew)localObject2).ArkNes_vec != null) && (((QZoneMsgEntityNew)localObject2).ArkNes_vec.size() > 0))
        {
          ((MQMsg)((QZoneMsgEntityNew)localObject2).ArkNes_vec.get(0)).msgInteractData.likeCell.liked = paramBoolean;
          MQLikeCell localMQLikeCell;
          if (paramBoolean) {
            localMQLikeCell = ((MQMsg)((QZoneMsgEntityNew)localObject2).ArkNes_vec.get(0)).msgInteractData.likeCell;
          }
          for (localMQLikeCell.totalLike += 1;; localMQLikeCell.totalLike -= 1)
          {
            a((QZoneMsgEntityNew)localObject2, paramInt);
            break;
            localMQLikeCell = ((MQMsg)((QZoneMsgEntityNew)localObject2).ArkNes_vec.get(0)).msgInteractData.likeCell;
          }
        }
      }
    }
    localQQAppInterface.notifyObservers(blxh.class, paramInt, true, paramBundle);
    return;
    localQQAppInterface.notifyObservers(blxh.class, paramInt, false, paramBundle);
    QZLog.e("QZoneMsgManager", "onReceive jceStruct error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxg
 * JD-Core Version:    0.7.0.1
 */