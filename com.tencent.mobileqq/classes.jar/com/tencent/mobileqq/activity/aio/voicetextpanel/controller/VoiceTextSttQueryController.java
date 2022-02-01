package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextSttListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.SttResultBean;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.PttSliceUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.VadHelper;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
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
import mqq.app.AppRuntime;

public class VoiceTextSttQueryController
{
  private int jdField_a_of_type_Int;
  private VoiceTextSttListener jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextSttListener;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new VoiceTextSttQueryController.1(this);
  private ITransFileController jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController;
  private String jdField_a_of_type_JavaLangString;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
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
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("vadHelper size=");
        ((StringBuilder)localObject).append(paramList.size());
        ((StringBuilder)localObject).append(" unFinishSegSize=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        ((StringBuilder)localObject).append(" isSttFinish=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        QLog.d("VoiceTextEdtiController", 2, ((StringBuilder)localObject).toString());
      }
      int i = 0;
      while (i < paramList.size())
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController = ((ITransFileController)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITransFileController.class, ""));
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
        localObject = new TransferRequest();
        ((TransferRequest)localObject).mIsUp = true;
        ((TransferRequest)localObject).mCommandId = 68;
        ((TransferRequest)localObject).mLocalPath = paramString;
        ((TransferRequest)localObject).mUniseq = ((Math.random() * 1000000.0D));
        ((TransferRequest)localObject).mPeerUin = this.jdField_a_of_type_JavaLangString;
        ((TransferRequest)localObject).mFileType = 327696;
        ((TransferRequest)localObject).mRichTag = "pttSliceToText";
        ((TransferRequest)localObject).pcmForVadPath = this.b;
        ((TransferRequest)localObject).pcmForVadNum = paramList.size();
        ((TransferRequest)localObject).pcmForVadPos = i;
        ((TransferRequest)localObject).vadSeg = ((WXVadSeg)paramList.get(i));
        ((TransferRequest)localObject).chatType = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.transferAsync((TransferRequest)localObject);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("vadHelper startrecord sendrequest pos=");
          localStringBuilder.append(i);
          QLog.d("VoiceTextEdtiController", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((TransferRequest)localObject).mUniseq));
        i += 1;
      }
    }
  }
  
  int a(int paramInt)
  {
    int i;
    if (paramInt == 3000) {
      i = 1;
    } else {
      i = 2;
    }
    if (paramInt == 0) {
      return 2;
    }
    return i;
  }
  
  String a(SttResultBean paramSttResultBean, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioVoicetextpanelModelSttResultBean[paramInt] = paramSttResultBean;
    paramSttResultBean = new StringBuffer();
    paramInt = 0;
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioVoicetextpanelModelSttResultBean;
      if (paramInt >= localObject.length) {
        break;
      }
      localObject = localObject[paramInt];
      if (localObject == null) {
        break;
      }
      paramSttResultBean.append(((SttResultBean)localObject).jdField_a_of_type_JavaLangString);
      if (!((SttResultBean)localObject).jdField_a_of_type_Boolean) {
        break;
      }
      paramInt += 1;
    }
    return paramSttResultBean.toString();
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancelAllRequest sendIds len=");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("VoiceTextEdtiController", 2, localStringBuilder.toString());
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
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioVoicetextpanelModelSttResultBean;
    if ((localObject != null) && (paramInt < localObject.length) && ((localObject[paramInt] == null) || (!localObject[paramInt].jdField_a_of_type_Boolean)))
    {
      paramSttResultBean = a(paramSttResultBean, paramInt);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextSttListener;
      if (localObject != null) {
        ((VoiceTextSttListener)localObject).a(paramSttResultBean);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "updateText fail");
    }
  }
  
  public void a(String paramString)
  {
    ThreadManagerV2.executeOnSubThread(new VoiceTextSttQueryController.2(this, paramString));
  }
  
  public void a(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (paramLong == 0L) {
        return;
      }
      Iterator localIterator = ((ITransFileController)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        int j = 0;
        int i = j;
        if (localObject != null)
        {
          i = j;
          if ((localObject instanceof PttSliceUploadProcessor))
          {
            i = j;
            if (((BaseTransProcessor)localObject).getFileStatus() != 1003L) {
              i = 1;
            }
          }
        }
        if (i != 0)
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (paramLong == ((BaseTransProcessor)localObject).mUiRequest.mUniseq))
          {
            ((BaseTransProcessor)localObject).cancel();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("PttSliceUploadProcessor cancelVoiceTextTask:");
              localStringBuilder.append(((BaseTransProcessor)localObject).mUiRequest.mUniseq);
              QLog.d("cancelpic", 2, localStringBuilder.toString());
            }
          }
        }
      }
    }
  }
  
  void a(String paramString1, AppRuntime paramAppRuntime, VoiceTextSttListener paramVoiceTextSttListener, int paramInt, String paramString2)
  {
    this.b = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelListenersVoiceTextSttListener = paramVoiceTextSttListener;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { PttSliceUploadProcessor.class });
  }
  
  public void b()
  {
    ITransFileController localITransFileController = this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController;
    if (localITransFileController != null) {
      localITransFileController.removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttQueryController
 * JD-Core Version:    0.7.0.1
 */