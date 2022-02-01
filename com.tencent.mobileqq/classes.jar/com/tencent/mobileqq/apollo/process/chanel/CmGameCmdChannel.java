package com.tencent.mobileqq.apollo.process.chanel;

import amkz;
import amlc;
import ampb;
import amqc;
import amqo;
import amqp;
import android.os.Bundle;
import android.text.TextUtils;
import bkgm;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CmGameCmdChannel
{
  private static CmGameCmdChannel jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel;
  private amkz jdField_a_of_type_Amkz;
  private amqc jdField_a_of_type_Amqc;
  private bkgm jdField_a_of_type_Bkgm;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  final List<amqp> jdField_a_of_type_JavaUtilList;
  
  private CmGameCmdChannel(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Amkz = new amkz();
    this.jdField_a_of_type_Amqc = new amqc(paramQQAppInterface);
    b();
  }
  
  /* Error */
  public static CmGameCmdChannel a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 48	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   6: ifnonnull +23 -> 29
    //   9: new 2	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 49	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   17: putstatic 48	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   20: getstatic 48	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: getstatic 48	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   32: getfield 25	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   35: invokevirtual 53	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   38: checkcast 55	com/tencent/mobileqq/app/QQAppInterface
    //   41: astore_1
    //   42: aload_1
    //   43: aload_0
    //   44: if_acmpeq -24 -> 20
    //   47: ldc 57
    //   49: iconst_1
    //   50: new 59	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   57: ldc 62
    //   59: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 79	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: getstatic 48	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   75: invokevirtual 81	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:a	()V
    //   78: new 2	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 49	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   86: putstatic 48	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   89: ldc 57
    //   91: iconst_1
    //   92: new 59	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   99: ldc 83
    //   101: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_0
    //   105: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: goto -94 -> 20
    //   117: astore_0
    //   118: ldc 2
    //   120: monitorexit
    //   121: aload_0
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramQQAppInterface	QQAppInterface
    //   41	22	1	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   3	20	117	finally
    //   20	24	117	finally
    //   29	42	117	finally
    //   47	114	117	finally
  }
  
  private void b()
  {
    if (ApolloEngine.a()) {
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_ApolloDataChannel", 2, "new ApolloCmdChannel nativeSetDataChannelObj");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkgm = new bkgm(ThreadManager.getSubThreadLooper(), null);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Collections.sort(this.jdField_a_of_type_JavaUtilList, new amqo(this));
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("apollochannel_ApolloDataChannel", 2, "new ApolloCmdChannel ApolloEngine.isEngineReady() false");
      }
    }
  }
  
  public String a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "{}";
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_ApolloDataChannel", 2, "[requestData], ,cmd:" + paramString1 + ",reqData:" + paramString2 + ",async:" + paramBoolean);
    }
    ??? = paramString1.trim();
    Object localObject2 = new CmGameCmdChannel.RequestRunable(this, (String)???, paramString2, paramInt1, paramInt2);
    if (("cs.close_room.local".equals(???)) || ("cs.make_room_min.local".equals(???)) || ("cs.share_game_result.local".equals(???)) || ("cs.invite_friends.local".equals(paramString1)) || ("cs.send_b2c_redpacket.local".equals(paramString1)) || ("cs.first_frame_drawn.local".equals(paramString1)) || ("cs.qta_notify_test_result.local".equals(paramString1)) || ("cs.share_pic.local".equals(paramString1))) {
      ThreadManager.post((Runnable)localObject2, 5, null, true);
    }
    for (;;)
    {
      return "{}";
      if (paramBoolean) {
        this.jdField_a_of_type_Bkgm.post((Runnable)localObject2);
      } else {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            amlc localamlc = ((amqp)((Iterator)localObject2).next()).a(paramString1, paramString2, paramInt1, paramInt2);
            if (localamlc != null)
            {
              if (localamlc.jdField_a_of_type_Boolean) {
                ((Iterator)localObject2).remove();
              }
              paramString1 = localamlc.jdField_a_of_type_JavaLangString;
              return paramString1;
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    QLog.i("apollochannel_ApolloDataChannel", 1, "onDestroy app:" + this.jdField_a_of_type_JavaLangRefWeakReference.get());
    this.jdField_a_of_type_Amkz.a();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((amqp)localIterator.next()).a();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bkgm.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Amqc != null)
    {
      this.jdField_a_of_type_Amqc.a();
      this.jdField_a_of_type_Amqc = null;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    while (this.jdField_a_of_type_Amqc == null) {
      return;
    }
    this.jdField_a_of_type_Amqc.a(paramInt1, paramString, paramInt2);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_ApolloDataChannel", 2, "[callbackFromRequest], errCode:" + paramInt1 + ",cmd:" + paramString1 + ",reqData:" + paramString2);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", paramString1);
    localBundle.putString("respData", paramString2);
    paramString1 = EIPCResult.createResult(paramInt1, localBundle);
    ampb.a().callbackResult(paramInt2, paramString1);
  }
  
  public void a(amqp paramamqp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramamqp);
      this.jdField_a_of_type_JavaUtilList.add(paramamqp);
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_ApolloDataChannel", 2, "addCmdHandler class:" + paramamqp.getClass().getName() + ", size: " + this.jdField_a_of_type_JavaUtilList.size());
      }
      return;
    }
  }
  
  public void b(amqp paramamqp)
  {
    if (paramamqp == null) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramamqp);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("apollochannel_ApolloDataChannel", 2, "removeCmdHandler class:" + paramamqp.getClass().getName() + ", size: " + this.jdField_a_of_type_JavaUtilList.size());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel
 * JD-Core Version:    0.7.0.1
 */