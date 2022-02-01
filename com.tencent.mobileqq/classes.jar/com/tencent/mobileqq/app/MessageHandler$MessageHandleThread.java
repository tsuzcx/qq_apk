package com.tencent.mobileqq.app;

import MessageSvcPack.GroupInfo;
import MessageSvcPack.stConfNumInfo;
import RegisterProxySvcPack.RegisterPushNotice;
import abvx;
import amwe;
import android.util.Pair;
import bbko;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import msf.registerproxy.register_proxy.DiscussList;
import msf.registerproxy.register_proxy.GroupList;

class MessageHandler$MessageHandleThread
  extends Thread
{
  ArrayList<amwe> a;
  public boolean a;
  public volatile boolean b;
  
  public MessageHandler$MessageHandleThread(ArrayList<amwe> paramArrayList)
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  /* Error */
  private int a(int paramInt)
  {
    // Byte code:
    //   0: ldc 30
    //   2: invokestatic 35	bjun:a	(Ljava/lang/String;)V
    //   5: iload_1
    //   6: istore_2
    //   7: aload_0
    //   8: getfield 22	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   11: astore 4
    //   13: iload_1
    //   14: istore_2
    //   15: aload 4
    //   17: monitorenter
    //   18: iload_1
    //   19: istore_2
    //   20: aload_0
    //   21: getfield 22	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   24: invokevirtual 41	java/util/ArrayList:size	()I
    //   27: ifle +139 -> 166
    //   30: iload_1
    //   31: istore_2
    //   32: aload_0
    //   33: getfield 22	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   36: iconst_0
    //   37: invokevirtual 45	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   40: checkcast 47	amwe
    //   43: astore_3
    //   44: iconst_0
    //   45: istore_1
    //   46: aload 4
    //   48: monitorexit
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 49	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:b	Z
    //   54: aload_3
    //   55: ifnull +8 -> 63
    //   58: aload_0
    //   59: aload_3
    //   60: invokespecial 52	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:a	(Lamwe;)V
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 49	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:b	Z
    //   68: aload_0
    //   69: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   72: invokestatic 57	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
    //   75: ifnull +27 -> 102
    //   78: aload_0
    //   79: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   82: invokestatic 60	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   85: ifeq +17 -> 102
    //   88: aload_0
    //   89: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   92: invokestatic 62	com/tencent/mobileqq/app/MessageHandler:b	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   95: ifeq +7 -> 102
    //   98: aload_0
    //   99: invokespecial 65	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:c	()V
    //   102: aload_0
    //   103: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   106: invokestatic 67	com/tencent/mobileqq/app/MessageHandler:c	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   109: ifeq +15 -> 124
    //   112: aload_0
    //   113: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   116: sipush 4017
    //   119: iconst_1
    //   120: aconst_null
    //   121: invokevirtual 71	com/tencent/mobileqq/app/MessageHandler:notifyUI	(IZLjava/lang/Object;)V
    //   124: aload_0
    //   125: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   128: getfield 74	com/tencent/mobileqq/app/MessageHandler:e	Z
    //   131: ifeq +27 -> 158
    //   134: aload_0
    //   135: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   138: invokestatic 60	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   141: ifeq +17 -> 158
    //   144: aload_0
    //   145: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   148: invokestatic 62	com/tencent/mobileqq/app/MessageHandler:b	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   151: ifeq +7 -> 158
    //   154: aload_0
    //   155: invokespecial 76	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:b	()V
    //   158: invokestatic 79	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:yield	()V
    //   161: invokestatic 81	bjun:a	()V
    //   164: iload_1
    //   165: ireturn
    //   166: iload_1
    //   167: istore_2
    //   168: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +33 -> 204
    //   174: iload_1
    //   175: istore_2
    //   176: ldc 89
    //   178: iconst_2
    //   179: new 91	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   186: ldc 94
    //   188: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_0
    //   192: invokevirtual 102	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:getName	()Ljava/lang/String;
    //   195: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: iload_1
    //   205: istore_2
    //   206: aload_0
    //   207: getfield 22	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   210: ldc2_w 110
    //   213: invokevirtual 117	java/lang/Object:wait	(J)V
    //   216: iload_1
    //   217: iconst_1
    //   218: iadd
    //   219: istore_1
    //   220: aconst_null
    //   221: astore_3
    //   222: goto -176 -> 46
    //   225: iload_1
    //   226: istore_2
    //   227: aload 4
    //   229: monitorexit
    //   230: iload_1
    //   231: istore_2
    //   232: aload_3
    //   233: athrow
    //   234: astore_3
    //   235: iload_2
    //   236: istore_1
    //   237: invokestatic 81	bjun:a	()V
    //   240: iload_1
    //   241: ireturn
    //   242: astore_3
    //   243: invokestatic 81	bjun:a	()V
    //   246: aload_3
    //   247: athrow
    //   248: astore_3
    //   249: goto -12 -> 237
    //   252: astore_3
    //   253: goto -28 -> 225
    //   256: astore_3
    //   257: iload_2
    //   258: istore_1
    //   259: goto -34 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	MessageHandleThread
    //   0	262	1	paramInt	int
    //   6	252	2	i	int
    //   43	190	3	localamwe	amwe
    //   234	1	3	localException1	java.lang.Exception
    //   242	5	3	localObject1	Object
    //   248	1	3	localException2	java.lang.Exception
    //   252	1	3	localObject2	Object
    //   256	1	3	localObject3	Object
    //   11	217	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   7	13	234	java/lang/Exception
    //   15	18	234	java/lang/Exception
    //   232	234	234	java/lang/Exception
    //   7	13	242	finally
    //   15	18	242	finally
    //   49	54	242	finally
    //   58	63	242	finally
    //   63	102	242	finally
    //   102	124	242	finally
    //   124	158	242	finally
    //   158	161	242	finally
    //   232	234	242	finally
    //   49	54	248	java/lang/Exception
    //   58	63	248	java/lang/Exception
    //   63	102	248	java/lang/Exception
    //   102	124	248	java/lang/Exception
    //   124	158	248	java/lang/Exception
    //   158	161	248	java/lang/Exception
    //   46	49	252	finally
    //   20	30	256	finally
    //   32	44	256	finally
    //   168	174	256	finally
    //   176	204	256	finally
    //   206	216	256	finally
    //   227	230	256	finally
  }
  
  private void a(amwe paramamwe)
  {
    long l1 = 0L;
    int j = 0;
    int i;
    if (QLog.isColorLevel())
    {
      l2 = System.currentTimeMillis();
      if (paramamwe.jdField_a_of_type_JavaLangObject == null) {
        break label202;
      }
      i = paramamwe.jdField_a_of_type_JavaLangObject.hashCode();
      j = i;
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->MessageHandleThread Beg.  moType=" + paramamwe.jdField_a_of_type_Int + ", dataHash=@" + Integer.toHexString(i));
        l1 = l2;
        j = i;
      }
    }
    switch (paramamwe.jdField_a_of_type_Int)
    {
    }
    label202:
    do
    {
      do
      {
        for (;;)
        {
          this.this$0.app.mAutomator.d();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "registerproxy->MessageHandleThread End.  moType=" + paramamwe.jdField_a_of_type_Int + ", dataHash=@" + Integer.toHexString(j) + ", cost=" + (System.currentTimeMillis() - l1));
          }
          return;
          i = 0;
          break;
          this.this$0.a("c2c_processor").a(1002, new Object[] { paramamwe.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramamwe.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg, paramamwe.jdField_a_of_type_JavaLangObject });
          continue;
          MessageHandler.a(this.this$0, paramamwe.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramamwe.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg, paramamwe.jdField_a_of_type_JavaLangObject);
          continue;
          MessageHandler.b(this.this$0, paramamwe.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramamwe.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg, paramamwe.jdField_a_of_type_JavaLangObject);
        }
        if ((paramamwe.jdField_a_of_type_JavaLangObject != null) && ((paramamwe.jdField_a_of_type_JavaLangObject instanceof GroupInfo)))
        {
          localObject = (GroupInfo)paramamwe.jdField_a_of_type_JavaLangObject;
          localQQMessageFacade = this.this$0.app.getMessageFacade();
          l2 = ((GroupInfo)localObject).lGroupCode;
          l3 = ((GroupInfo)localObject).lMemberSeq;
          if (this.this$0.app.getMsgCache().a(String.valueOf(((GroupInfo)localObject).lGroupCode)) == 2) {}
          for (bool = true;; bool = false)
          {
            localQQMessageFacade.setReadFrom(String.valueOf(l2), 1, l3, bool);
            break;
          }
        }
      } while ((paramamwe.jdField_a_of_type_JavaLangObject == null) || (!(paramamwe.jdField_a_of_type_JavaLangObject instanceof register_proxy.GroupList)));
      localObject = (register_proxy.GroupList)paramamwe.jdField_a_of_type_JavaLangObject;
      localQQMessageFacade = this.this$0.app.getMessageFacade();
      l2 = ((register_proxy.GroupList)localObject).group_code.get();
      l3 = ((register_proxy.GroupList)localObject).member_seq.get();
      if (this.this$0.app.getMsgCache().a(String.valueOf(((register_proxy.GroupList)localObject).group_code.get())) == 2) {}
      for (bool = true;; bool = false)
      {
        localQQMessageFacade.setReadFrom(String.valueOf(l2), 1, l3, bool);
        break;
      }
      if ((paramamwe.jdField_a_of_type_JavaLangObject != null) && ((paramamwe.jdField_a_of_type_JavaLangObject instanceof stConfNumInfo)))
      {
        localObject = (stConfNumInfo)paramamwe.jdField_a_of_type_JavaLangObject;
        localQQMessageFacade = this.this$0.app.getMessageFacade();
        l2 = ((stConfNumInfo)localObject).lConfUin;
        l3 = ((stConfNumInfo)localObject).uMemberMsgSeq;
        if (this.this$0.app.getMsgCache().b(String.valueOf(((stConfNumInfo)localObject).lConfUin)) == 2) {}
        for (bool = true;; bool = false)
        {
          localQQMessageFacade.setReadFrom(String.valueOf(l2), 3000, l3, bool);
          break;
        }
      }
    } while ((paramamwe.jdField_a_of_type_JavaLangObject == null) || (!(paramamwe.jdField_a_of_type_JavaLangObject instanceof register_proxy.DiscussList)));
    Object localObject = (register_proxy.DiscussList)paramamwe.jdField_a_of_type_JavaLangObject;
    QQMessageFacade localQQMessageFacade = this.this$0.app.getMessageFacade();
    long l2 = ((register_proxy.DiscussList)localObject).discuss_code.get();
    long l3 = ((register_proxy.DiscussList)localObject).member_seq.get();
    if (this.this$0.app.getMsgCache().b(String.valueOf(((register_proxy.DiscussList)localObject).discuss_code.get())) == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localQQMessageFacade.setReadFrom(String.valueOf(l2), 3000, l3, bool);
      break;
    }
  }
  
  private void b()
  {
    synchronized (MessageHandler.a(this.this$0))
    {
      if (!MessageHandler.a(this.this$0).get())
      {
        MessageHandler.a(this.this$0).set(true);
        MessageHandler.a(this.this$0).notifyAll();
      }
      return;
    }
  }
  
  private void c()
  {
    for (;;)
    {
      synchronized (MessageHandler.a(this.this$0))
      {
        if (MessageHandler.a(this.this$0) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "registerproxy->MessageHandleThread End. NoticeEnd notify");
          }
          Long[] arrayOfLong = new Long[2];
          arrayOfLong[0] = Long.valueOf(((RegisterPushNotice)MessageHandler.a(this.this$0).first).ulTimeOutFlag);
          arrayOfLong[1] = ((Long)MessageHandler.a(this.this$0).second);
          if ((((RegisterPushNotice)MessageHandler.a(this.this$0).first).uFlag & 1L) == 1L)
          {
            bool = true;
            MessageHandler.a(this.this$0, null);
            if ((arrayOfLong[1].longValue() == 1L) || (!this.this$0.a.c()) || (!this.this$0.a.b()))
            {
              this.this$0.j();
              this.this$0.notifyUI(4013, bool, arrayOfLong);
            }
            MessageHandler.a(this.this$0).set(true);
            MessageHandler.a(this.this$0).notifyAll();
          }
        }
        else
        {
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.notifyAll();
      return;
    }
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "MessageHandleThread start, name=" + getName());
    }
    for (int i = 0; (this.jdField_a_of_type_Boolean) && ((i < 2) || (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)); i = a(i)) {}
    a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "MessageHandleThread exit, name=" + getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.MessageHandleThread
 * JD-Core Version:    0.7.0.1
 */