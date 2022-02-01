package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextSttListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.SttResultBean;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.PttSliceUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.VadHelper;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.WXVadSeg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VoiceTextSttQueryController
{
  private int jdField_a_of_type_Int;
  private VoiceTextSttListener jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextSttListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new VoiceTextSttQueryController.1(this);
  private ITransFileController jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController;
  private String jdField_a_of_type_JavaLangString;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private SttResultBean[] jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioVoicetextpanelModelSttResultBean;
  private String b;
  
  private List<WXVadSeg> a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "vadHelper  vad start");
    }
    VadHelper localVadHelper = new VadHelper();
    localVadHelper.d();
    List localList = localVadHelper.a(this.b);
    localVadHelper.b();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "vadHelper  vad start");
    }
    return localList;
  }
  
  private void a(String paramString, List<WXVadSeg> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "vadHelper size=" + paramList.size() + " unFinishSegSize=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " isSttFinish=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      int i = 0;
      while (i < paramList.size())
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class));
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.mIsUp = true;
        localTransferRequest.mCommandId = 68;
        localTransferRequest.mLocalPath = paramString;
        localTransferRequest.mUniseq = ((Math.random() * 1000000.0D));
        localTransferRequest.mPeerUin = this.jdField_a_of_type_JavaLangString;
        localTransferRequest.mFileType = 327696;
        localTransferRequest.mRichTag = "pttSliceToText";
        localTransferRequest.pcmForVadPath = this.b;
        localTransferRequest.pcmForVadNum = paramList.size();
        localTransferRequest.pcmForVadPos = i;
        localTransferRequest.vadSeg = ((WXVadSeg)paramList.get(i));
        localTransferRequest.chatType = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.transferAsync(localTransferRequest);
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest pos=" + i);
        }
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localTransferRequest.mUniseq));
        i += 1;
      }
    }
  }
  
  private boolean a(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null)
    {
      bool1 = bool2;
      if ((paramIHttpCommunicatorListener instanceof PttSliceUploadProcessor))
      {
        bool1 = bool2;
        if (((BaseTransProcessor)paramIHttpCommunicatorListener).getFileStatus() != 1003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  int a(int paramInt)
  {
    if (paramInt == 3000) {}
    for (int i = 1;; i = 2)
    {
      if (paramInt == 0) {
        return 2;
      }
      return i;
    }
  }
  
  String a(SttResultBean paramSttResultBean, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioVoicetextpanelModelSttResultBean[paramInt] = paramSttResultBean;
    paramSttResultBean = new StringBuffer();
    paramInt = 0;
    for (;;)
    {
      SttResultBean localSttResultBean;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioVoicetextpanelModelSttResultBean.length)
      {
        localSttResultBean = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioVoicetextpanelModelSttResultBean[paramInt];
        if (localSttResultBean != null) {
          break label42;
        }
      }
      label42:
      do
      {
        return paramSttResultBean.toString();
        paramSttResultBean.append(localSttResultBean.jdField_a_of_type_JavaLangString);
      } while (!localSttResultBean.jdField_a_of_type_Boolean);
      paramInt += 1;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "cancelAllRequest sendIds len=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      a(this.jdField_a_of_type_JavaLangString, ((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue());
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(VoiceTextSttListener paramVoiceTextSttListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextSttListener = paramVoiceTextSttListener;
  }
  
  void a(SttResultBean paramSttResultBean, int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioVoicetextpanelModelSttResultBean == null) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioVoicetextpanelModelSttResultBean.length) || ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioVoicetextpanelModelSttResultBean[paramInt] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioVoicetextpanelModelSttResultBean[paramInt].jdField_a_of_type_Boolean))) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "updateText fail");
      }
    }
    do
    {
      return;
      paramSttResultBean = a(paramSttResultBean, paramInt);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextSttListener == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextSttListener.a(paramSttResultBean);
  }
  
  public void a(String paramString)
  {
    ThreadManager.a(new VoiceTextSttQueryController.2(this, paramString));
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).getProcessMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (a((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (paramLong == ((BaseTransProcessor)localObject).mUiRequest.mUniseq))
          {
            ((BaseTransProcessor)localObject).cancel();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "PttSliceUploadProcessor cancelVoiceTextTask:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            }
          }
        }
      }
    }
  }
  
  void a(String paramString1, QQAppInterface paramQQAppInterface, VoiceTextSttListener paramVoiceTextSttListener, int paramInt, String paramString2)
  {
    this.b = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextSttListener = paramVoiceTextSttListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { PttSliceUploadProcessor.class });
  }
  
  public void b()
  {
    a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttQueryController
 * JD-Core Version:    0.7.0.1
 */