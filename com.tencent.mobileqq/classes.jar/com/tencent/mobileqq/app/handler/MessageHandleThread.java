package com.tencent.mobileqq.app.handler;

import MessageSvcPack.GroupInfo;
import MessageSvcPack.stConfNumInfo;
import RegisterProxySvcPack.RegisterPushNotice;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import msf.registerproxy.register_proxy.DiscussList;
import msf.registerproxy.register_proxy.GroupList;

public class MessageHandleThread
  extends Thread
{
  public static long a = 180000L;
  public boolean b = true;
  public volatile boolean c = false;
  ArrayList<MessageObject> d;
  private final BaseMessageHandler e;
  private final RegisterProxyHandler f;
  
  public MessageHandleThread(RegisterProxyHandler paramRegisterProxyHandler, BaseMessageHandler paramBaseMessageHandler, ArrayList<MessageObject> paramArrayList)
  {
    this.f = paramRegisterProxyHandler;
    this.e = paramBaseMessageHandler;
    this.d = paramArrayList;
  }
  
  /* Error */
  private int a(int paramInt)
  {
    // Byte code:
    //   0: ldc 42
    //   2: invokestatic 48	com/tencent/widget/TraceUtils:traceBegin	(Ljava/lang/String;)V
    //   5: iload_1
    //   6: istore_2
    //   7: aload_0
    //   8: getfield 35	com/tencent/mobileqq/app/handler/MessageHandleThread:d	Ljava/util/ArrayList;
    //   11: astore 4
    //   13: iload_1
    //   14: istore_2
    //   15: aload 4
    //   17: monitorenter
    //   18: iload_1
    //   19: istore_2
    //   20: aload_0
    //   21: getfield 35	com/tencent/mobileqq/app/handler/MessageHandleThread:d	Ljava/util/ArrayList;
    //   24: invokevirtual 54	java/util/ArrayList:size	()I
    //   27: ifle +22 -> 49
    //   30: iload_1
    //   31: istore_2
    //   32: aload_0
    //   33: getfield 35	com/tencent/mobileqq/app/handler/MessageHandleThread:d	Ljava/util/ArrayList;
    //   36: iconst_0
    //   37: invokevirtual 58	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   40: checkcast 60	com/tencent/mobileqq/app/handler/MessageObject
    //   43: astore_3
    //   44: iconst_0
    //   45: istore_1
    //   46: goto +71 -> 117
    //   49: iload_1
    //   50: istore_2
    //   51: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +45 -> 99
    //   57: iload_1
    //   58: istore_2
    //   59: new 68	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   66: astore_3
    //   67: iload_1
    //   68: istore_2
    //   69: aload_3
    //   70: ldc 71
    //   72: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: iload_1
    //   77: istore_2
    //   78: aload_3
    //   79: aload_0
    //   80: invokevirtual 79	com/tencent/mobileqq/app/handler/MessageHandleThread:getName	()Ljava/lang/String;
    //   83: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: iload_1
    //   88: istore_2
    //   89: ldc 81
    //   91: iconst_2
    //   92: aload_3
    //   93: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: iload_1
    //   100: istore_2
    //   101: aload_0
    //   102: getfield 35	com/tencent/mobileqq/app/handler/MessageHandleThread:d	Ljava/util/ArrayList;
    //   105: getstatic 89	com/tencent/mobileqq/app/handler/MessageHandleThread:a	J
    //   108: invokevirtual 95	java/lang/Object:wait	(J)V
    //   111: iload_1
    //   112: iconst_1
    //   113: iadd
    //   114: istore_1
    //   115: aconst_null
    //   116: astore_3
    //   117: iload_1
    //   118: istore_2
    //   119: aload 4
    //   121: monitorexit
    //   122: iload_1
    //   123: istore_2
    //   124: aload_0
    //   125: iconst_1
    //   126: putfield 29	com/tencent/mobileqq/app/handler/MessageHandleThread:c	Z
    //   129: aload_3
    //   130: ifnull +10 -> 140
    //   133: iload_1
    //   134: istore_2
    //   135: aload_0
    //   136: aload_3
    //   137: invokespecial 98	com/tencent/mobileqq/app/handler/MessageHandleThread:a	(Lcom/tencent/mobileqq/app/handler/MessageObject;)V
    //   140: iload_1
    //   141: istore_2
    //   142: aload_0
    //   143: iconst_0
    //   144: putfield 29	com/tencent/mobileqq/app/handler/MessageHandleThread:c	Z
    //   147: iload_1
    //   148: istore_2
    //   149: aload_0
    //   150: getfield 31	com/tencent/mobileqq/app/handler/MessageHandleThread:f	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   153: getfield 104	com/tencent/mobileqq/app/handler/RegisterProxyHandler:g	Landroid/util/Pair;
    //   156: ifnull +33 -> 189
    //   159: iload_1
    //   160: istore_2
    //   161: aload_0
    //   162: getfield 31	com/tencent/mobileqq/app/handler/MessageHandleThread:f	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   165: invokevirtual 106	com/tencent/mobileqq/app/handler/RegisterProxyHandler:c	()Z
    //   168: ifeq +21 -> 189
    //   171: iload_1
    //   172: istore_2
    //   173: aload_0
    //   174: getfield 31	com/tencent/mobileqq/app/handler/MessageHandleThread:f	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   177: invokevirtual 108	com/tencent/mobileqq/app/handler/RegisterProxyHandler:d	()Z
    //   180: ifeq +9 -> 189
    //   183: iload_1
    //   184: istore_2
    //   185: aload_0
    //   186: invokespecial 110	com/tencent/mobileqq/app/handler/MessageHandleThread:e	()V
    //   189: iload_1
    //   190: istore_2
    //   191: aload_0
    //   192: getfield 31	com/tencent/mobileqq/app/handler/MessageHandleThread:f	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   195: invokevirtual 112	com/tencent/mobileqq/app/handler/RegisterProxyHandler:e	()Z
    //   198: ifeq +17 -> 215
    //   201: iload_1
    //   202: istore_2
    //   203: aload_0
    //   204: getfield 33	com/tencent/mobileqq/app/handler/MessageHandleThread:e	Lcom/tencent/mobileqq/app/BaseMessageHandler;
    //   207: sipush 4017
    //   210: iconst_1
    //   211: aconst_null
    //   212: invokevirtual 118	com/tencent/mobileqq/app/BaseMessageHandler:notifyUI	(IZLjava/lang/Object;)V
    //   215: iload_1
    //   216: istore_2
    //   217: aload_0
    //   218: getfield 31	com/tencent/mobileqq/app/handler/MessageHandleThread:f	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   221: getfield 121	com/tencent/mobileqq/app/handler/RegisterProxyHandler:p	Z
    //   224: ifeq +33 -> 257
    //   227: iload_1
    //   228: istore_2
    //   229: aload_0
    //   230: getfield 31	com/tencent/mobileqq/app/handler/MessageHandleThread:f	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   233: invokevirtual 106	com/tencent/mobileqq/app/handler/RegisterProxyHandler:c	()Z
    //   236: ifeq +21 -> 257
    //   239: iload_1
    //   240: istore_2
    //   241: aload_0
    //   242: getfield 31	com/tencent/mobileqq/app/handler/MessageHandleThread:f	Lcom/tencent/mobileqq/app/handler/RegisterProxyHandler;
    //   245: invokevirtual 108	com/tencent/mobileqq/app/handler/RegisterProxyHandler:d	()Z
    //   248: ifeq +9 -> 257
    //   251: iload_1
    //   252: istore_2
    //   253: aload_0
    //   254: invokespecial 123	com/tencent/mobileqq/app/handler/MessageHandleThread:d	()V
    //   257: iload_1
    //   258: istore_2
    //   259: invokestatic 126	java/lang/Thread:yield	()V
    //   262: goto +25 -> 287
    //   265: astore_3
    //   266: aload 4
    //   268: monitorexit
    //   269: aload_3
    //   270: athrow
    //   271: astore_3
    //   272: goto +20 -> 292
    //   275: astore_3
    //   276: ldc 81
    //   278: iconst_1
    //   279: ldc 128
    //   281: aload_3
    //   282: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: iload_2
    //   286: istore_1
    //   287: invokestatic 134	com/tencent/widget/TraceUtils:traceEnd	()V
    //   290: iload_1
    //   291: ireturn
    //   292: invokestatic 134	com/tencent/widget/TraceUtils:traceEnd	()V
    //   295: aload_3
    //   296: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	MessageHandleThread
    //   0	297	1	paramInt	int
    //   6	280	2	i	int
    //   43	94	3	localObject1	Object
    //   265	5	3	localObject2	Object
    //   271	1	3	localObject3	Object
    //   275	21	3	localException	java.lang.Exception
    //   11	256	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   20	30	265	finally
    //   32	44	265	finally
    //   51	57	265	finally
    //   59	67	265	finally
    //   69	76	265	finally
    //   78	87	265	finally
    //   89	99	265	finally
    //   101	111	265	finally
    //   119	122	265	finally
    //   266	269	265	finally
    //   7	13	271	finally
    //   15	18	271	finally
    //   124	129	271	finally
    //   135	140	271	finally
    //   142	147	271	finally
    //   149	159	271	finally
    //   161	171	271	finally
    //   173	183	271	finally
    //   185	189	271	finally
    //   191	201	271	finally
    //   203	215	271	finally
    //   217	227	271	finally
    //   229	239	271	finally
    //   241	251	271	finally
    //   253	257	271	finally
    //   259	262	271	finally
    //   269	271	271	finally
    //   276	285	271	finally
    //   7	13	275	java/lang/Exception
    //   15	18	275	java/lang/Exception
    //   124	129	275	java/lang/Exception
    //   135	140	275	java/lang/Exception
    //   142	147	275	java/lang/Exception
    //   149	159	275	java/lang/Exception
    //   161	171	275	java/lang/Exception
    //   173	183	275	java/lang/Exception
    //   185	189	275	java/lang/Exception
    //   191	201	275	java/lang/Exception
    //   203	215	275	java/lang/Exception
    //   217	227	275	java/lang/Exception
    //   229	239	275	java/lang/Exception
    //   241	251	275	java/lang/Exception
    //   253	257	275	java/lang/Exception
    //   259	262	275	java/lang/Exception
    //   269	271	275	java/lang/Exception
  }
  
  private void a(MessageObject paramMessageObject)
  {
    long l2;
    int j;
    long l1;
    if (QLog.isColorLevel())
    {
      l2 = System.currentTimeMillis();
      if (paramMessageObject.d != null) {
        i = paramMessageObject.d.hashCode();
      } else {
        i = 0;
      }
      j = i;
      l1 = l2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("registerproxy->MessageHandleThread Beg.  moType=");
        ((StringBuilder)localObject1).append(paramMessageObject.a);
        ((StringBuilder)localObject1).append(", dataHash=@");
        ((StringBuilder)localObject1).append(Integer.toHexString(i));
        QLog.d("MessageHandler", 2, ((StringBuilder)localObject1).toString());
        j = i;
        l1 = l2;
      }
    }
    else
    {
      l1 = 0L;
      j = 0;
    }
    Object localObject2 = this.e.b();
    Object localObject1 = (IMessageFacade)((AppInterface)localObject2).getRuntimeService(IMessageFacade.class, "");
    localObject2 = (MessageCache)((AppInterface)localObject2).getMsgCache();
    int i = paramMessageObject.a;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          Object localObject3;
          long l3;
          boolean bool;
          if (i != 4)
          {
            if (i == 5) {
              for (;;)
              {
                if ((paramMessageObject.d instanceof stConfNumInfo))
                {
                  localObject3 = (stConfNumInfo)paramMessageObject.d;
                  l2 = ((stConfNumInfo)localObject3).lConfUin;
                  l3 = ((stConfNumInfo)localObject3).uMemberMsgSeq;
                  if (((MessageCache)localObject2).D(String.valueOf(((stConfNumInfo)localObject3).lConfUin)) == 2) {
                    bool = true;
                  } else {
                    bool = false;
                  }
                  ((IMessageFacade)localObject1).setReadFrom(String.valueOf(l2), 3000, l3, bool);
                }
                else if ((paramMessageObject.d instanceof register_proxy.DiscussList))
                {
                  localObject3 = (register_proxy.DiscussList)paramMessageObject.d;
                  l2 = ((register_proxy.DiscussList)localObject3).discuss_code.get();
                  l3 = ((register_proxy.DiscussList)localObject3).member_seq.get();
                  if (((MessageCache)localObject2).D(String.valueOf(((register_proxy.DiscussList)localObject3).discuss_code.get())) == 2) {
                    bool = true;
                  } else {
                    bool = false;
                  }
                  ((IMessageFacade)localObject1).setReadFrom(String.valueOf(l2), 3000, l3, bool);
                }
              }
            }
          }
          else if ((paramMessageObject.d instanceof GroupInfo))
          {
            localObject3 = (GroupInfo)paramMessageObject.d;
            l2 = ((GroupInfo)localObject3).lGroupCode;
            l3 = ((GroupInfo)localObject3).lMemberSeq;
            if (((MessageCache)localObject2).b(String.valueOf(((GroupInfo)localObject3).lGroupCode)) == 2) {
              bool = true;
            } else {
              bool = false;
            }
            ((IMessageFacade)localObject1).setReadFrom(String.valueOf(l2), 1, l3, bool);
          }
          else if ((paramMessageObject.d instanceof register_proxy.GroupList))
          {
            localObject3 = (register_proxy.GroupList)paramMessageObject.d;
            l2 = ((register_proxy.GroupList)localObject3).group_code.get();
            l3 = ((register_proxy.GroupList)localObject3).member_seq.get();
            if (((MessageCache)localObject2).b(String.valueOf(((register_proxy.GroupList)localObject3).group_code.get())) == 2) {
              bool = true;
            } else {
              bool = false;
            }
            ((IMessageFacade)localObject1).setReadFrom(String.valueOf(l2), 1, l3, bool);
          }
        }
        else
        {
          this.e.c(paramMessageObject.b, paramMessageObject.c, paramMessageObject.d);
        }
      }
      else {
        this.e.b(paramMessageObject.b, paramMessageObject.c, paramMessageObject.d);
      }
    }
    else {
      this.e.a("c2c_processor").a(1002, new Object[] { paramMessageObject.b, paramMessageObject.c, paramMessageObject.d });
    }
    this.e.g();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("registerproxy->MessageHandleThread End.  moType=");
      ((StringBuilder)localObject1).append(paramMessageObject.a);
      ((StringBuilder)localObject1).append(", dataHash=@");
      ((StringBuilder)localObject1).append(Integer.toHexString(j));
      ((StringBuilder)localObject1).append(", cost=");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
      QLog.d("MessageHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void d()
  {
    synchronized (this.f.q)
    {
      if (!this.f.q.get())
      {
        this.f.q.set(true);
        this.f.q.notifyAll();
      }
      return;
    }
  }
  
  private void e()
  {
    synchronized (this.f.q)
    {
      if (this.f.g != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageHandler", 2, "registerproxy->MessageHandleThread End. NoticeEnd notify");
        }
        Long[] arrayOfLong = new Long[2];
        long l = ((RegisterPushNotice)this.f.g.first).ulTimeOutFlag;
        boolean bool = false;
        arrayOfLong[0] = Long.valueOf(l);
        arrayOfLong[1] = ((Long)this.f.g.second);
        if ((((RegisterPushNotice)this.f.g.first).uFlag & 1L) == 1L) {
          bool = true;
        }
        this.f.g = null;
        MessageCache localMessageCache = (MessageCache)this.e.b().getMsgCache();
        if ((arrayOfLong[1].longValue() == 1L) || (!localMessageCache.y()) || (!localMessageCache.w()))
        {
          this.e.f();
          this.e.notifyUI(4013, bool, arrayOfLong);
        }
        this.f.q.set(true);
        this.f.q.notifyAll();
      }
      return;
    }
  }
  
  public void a()
  {
    this.b = false;
    synchronized (this.d)
    {
      this.d.notifyAll();
      return;
    }
  }
  
  public boolean b()
  {
    return this.b ^ true;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MessageHandleThread start, name=");
      localStringBuilder.append(getName());
      QLog.d("MessageHandler", 2, localStringBuilder.toString());
    }
    for (int i = 0; (this.b) && ((i < 2) || (this.d.size() > 0)); i = a(i)) {}
    a();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MessageHandleThread exit, name=");
      localStringBuilder.append(getName());
      QLog.d("MessageHandler", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.MessageHandleThread
 * JD-Core Version:    0.7.0.1
 */