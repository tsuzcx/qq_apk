package com.tencent.mobileqq.apollo.process.chanel;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.aioChannel.ApolloRenderRunner;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import yrb;
import yrc;

public class CmGameCmdChannel
{
  private static CmGameCmdChannel jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel;
  private ApolloRenderRunner jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloRenderRunner;
  private CmGameAccountHandler jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAccountHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  public final List a;
  
  private CmGameCmdChannel(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloRenderRunner = new ApolloRenderRunner();
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAccountHandler = new CmGameAccountHandler(paramQQAppInterface);
    b();
  }
  
  /* Error */
  public static CmGameCmdChannel a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 41	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   6: ifnonnull +23 -> 29
    //   9: new 2	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 42	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   17: putstatic 41	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   20: getstatic 41	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: getstatic 41	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   32: getfield 18	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   35: aload_0
    //   36: if_acmpeq -16 -> 20
    //   39: ldc 44
    //   41: iconst_1
    //   42: new 46	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   49: ldc 49
    //   51: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: getstatic 41	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   57: getfield 18	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: getstatic 41	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   72: invokevirtual 68	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:a	()V
    //   75: new 2	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 42	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   83: putstatic 41	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameCmdChannel	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   86: ldc 44
    //   88: iconst_1
    //   89: new 46	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   96: ldc 70
    //   98: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: goto -91 -> 20
    //   114: astore_0
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   3	20	114	finally
    //   20	24	114	finally
    //   29	111	114	finally
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
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), null);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.add(new GeneralMsgHandler());
        Collections.sort(this.jdField_a_of_type_JavaUtilList, new yrb(this));
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
    Object localObject2 = new yrc(this, (String)???, paramString2, paramInt1, paramInt2);
    if (("cs.close_room.local".equals(???)) || ("cs.make_room_min.local".equals(???)) || ("cs.share_game_result.local".equals(???)) || ("cs.invite_friends.local".equals(paramString1)) || ("cs.first_frame_drawn.local".equals(paramString1)) || ("cs.share_pic.local".equals(paramString1))) {
      ThreadManager.post((Runnable)localObject2, 5, null, true);
    }
    for (;;)
    {
      return "{}";
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post((Runnable)localObject2);
      } else {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            HandleResult localHandleResult = ((CmGameCmdChannel.IRequestHandler)((Iterator)localObject2).next()).a(paramString1, paramString2, paramInt1, paramInt2);
            if (localHandleResult != null)
            {
              if (localHandleResult.jdField_a_of_type_Boolean) {
                ((Iterator)localObject2).remove();
              }
              paramString1 = localHandleResult.jdField_a_of_type_JavaLangString;
              return paramString1;
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloRenderRunner.a();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((CmGameCmdChannel.IRequestHandler)localIterator.next()).a();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAccountHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAccountHandler.a();
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAccountHandler == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAccountHandler.a(paramInt1, paramString, paramInt2);
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
    CmGameServerQIPCModule.a().callbackResult(paramInt2, paramString1);
  }
  
  public void a(CmGameCmdChannel.IRequestHandler paramIRequestHandler)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramIRequestHandler);
      this.jdField_a_of_type_JavaUtilList.add(paramIRequestHandler);
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_ApolloDataChannel", 2, "addCmdHandler class:" + paramIRequestHandler.getClass().getName() + ", size: " + this.jdField_a_of_type_JavaUtilList.size());
      }
      return;
    }
  }
  
  public void b(CmGameCmdChannel.IRequestHandler paramIRequestHandler)
  {
    if (paramIRequestHandler == null) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramIRequestHandler);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("apollochannel_ApolloDataChannel", 2, "removeCmdHandler class:" + paramIRequestHandler.getClass().getName() + ", size: " + this.jdField_a_of_type_JavaUtilList.size());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel
 * JD-Core Version:    0.7.0.1
 */