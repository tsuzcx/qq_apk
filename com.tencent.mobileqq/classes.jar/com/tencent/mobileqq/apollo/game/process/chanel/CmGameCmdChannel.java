package com.tencent.mobileqq.apollo.game.process.chanel;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderRunner;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class CmGameCmdChannel
{
  private static CmGameCmdChannel jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameCmdChannel;
  private CmGameAccountHandler jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAccountHandler;
  private ApolloRenderRunner jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRenderRunner;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  final List<CmGameCmdChannel.IRequestHandler> jdField_a_of_type_JavaUtilList;
  
  private CmGameCmdChannel(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRenderRunner = new ApolloRenderRunner();
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAccountHandler = new CmGameAccountHandler(paramAppInterface);
    b();
  }
  
  public static CmGameCmdChannel a(AppInterface paramAppInterface)
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameCmdChannel == null)
      {
        jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameCmdChannel = new CmGameCmdChannel(paramAppInterface);
      }
      else
      {
        Object localObject = (AppRuntime)jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameCmdChannel.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != paramAppInterface)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("old App:");
          localStringBuilder.append(localObject);
          QLog.i("apollochannel_ApolloDataChannel", 1, localStringBuilder.toString());
          jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameCmdChannel.a();
          jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameCmdChannel = new CmGameCmdChannel(paramAppInterface);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("create new cmdChannel App:");
          ((StringBuilder)localObject).append(paramAppInterface);
          QLog.d("apollochannel_ApolloDataChannel", 1, ((StringBuilder)localObject).toString());
        }
      }
      paramAppInterface = jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameCmdChannel;
      return paramAppInterface;
    }
    finally {}
  }
  
  private void b()
  {
    if (ApolloEngine.isEngineReady())
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_ApolloDataChannel", 2, "new ApolloCmdChannel nativeSetDataChannelObj");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("apollochannel_ApolloDataChannel", 2, "new ApolloCmdChannel ApolloEngine.isEngineReady() false");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), null);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new CmGameCmdChannel.1(this));
      return;
    }
  }
  
  public String a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "{}";
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[requestData], ,cmd:");
      ((StringBuilder)???).append(paramString1);
      ((StringBuilder)???).append(",reqData:");
      ((StringBuilder)???).append(paramString2);
      ((StringBuilder)???).append(",async:");
      ((StringBuilder)???).append(paramBoolean);
      QLog.d("apollochannel_ApolloDataChannel", 2, ((StringBuilder)???).toString());
    }
    ??? = paramString1.trim();
    Object localObject2 = new CmGameCmdChannel.RequestRunnable(this, (String)???, paramString2, paramInt1, paramInt2);
    if ((!"cs.close_room.local".equals(???)) && (!"cs.make_room_min.local".equals(???)) && (!"cs.share_game_result.local".equals(???)) && (!"cs.send_b2c_redpacket.local".equals(paramString1)) && (!"cs.first_frame_drawn.local".equals(paramString1)) && (!"cs.qta_notify_test_result.local".equals(paramString1)) && (!"cs.share_pic.local".equals(paramString1)))
    {
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
    else {
      ThreadManager.post((Runnable)localObject2, 5, null, true);
    }
    return "{}";
  }
  
  public void a()
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onDestroy app:");
    ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangRefWeakReference.get());
    QLog.i("apollochannel_ApolloDataChannel", 1, ((StringBuilder)???).toString());
    this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloRenderRunner.a();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((CmGameCmdChannel.IRequestHandler)localIterator.next()).a();
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
      ??? = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAccountHandler;
      if (??? != null)
      {
        ((CmGameAccountHandler)???).a();
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAccountHandler = null;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    CmGameAccountHandler localCmGameAccountHandler = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameAccountHandler;
    if (localCmGameAccountHandler != null) {
      localCmGameAccountHandler.a(paramInt1, paramString, paramInt2);
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[callbackFromRequest], errCode:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",cmd:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",reqData:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("apollochannel_ApolloDataChannel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("cmd", paramString1);
    ((Bundle)localObject).putString("respData", paramString2);
    paramString1 = EIPCResult.createResult(paramInt1, (Bundle)localObject);
    CmGameServerQIPCModule.a().callbackResult(paramInt2, paramString1);
  }
  
  public void a(CmGameCmdChannel.IRequestHandler paramIRequestHandler)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramIRequestHandler);
      this.jdField_a_of_type_JavaUtilList.add(paramIRequestHandler);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("addCmdHandler class:");
        ((StringBuilder)???).append(paramIRequestHandler.getClass().getName());
        ((StringBuilder)???).append(", size: ");
        ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilList.size());
        QLog.d("apollochannel_ApolloDataChannel", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  public void b(CmGameCmdChannel.IRequestHandler paramIRequestHandler)
  {
    if (paramIRequestHandler == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramIRequestHandler);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("removeCmdHandler class:");
        ((StringBuilder)???).append(paramIRequestHandler.getClass().getName());
        ((StringBuilder)???).append(", size: ");
        ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilList.size());
        QLog.d("apollochannel_ApolloDataChannel", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameCmdChannel
 * JD-Core Version:    0.7.0.1
 */