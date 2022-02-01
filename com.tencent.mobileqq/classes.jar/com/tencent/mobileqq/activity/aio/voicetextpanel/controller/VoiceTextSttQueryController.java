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
  private String a;
  private int b;
  private AppRuntime c;
  private String d;
  private ITransFileController e;
  private AtomicInteger f = new AtomicInteger();
  private AtomicBoolean g = new AtomicBoolean(false);
  private SttResultBean[] h;
  private VoiceTextSttListener i;
  private List<Long> j = new ArrayList();
  private TransProcessorHandler k = new VoiceTextSttQueryController.1(this);
  
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
        ((StringBuilder)localObject).append(this.f.get());
        ((StringBuilder)localObject).append(" isSttFinish=");
        ((StringBuilder)localObject).append(this.g.get());
        QLog.d("VoiceTextEdtiController", 2, ((StringBuilder)localObject).toString());
      }
      int m = 0;
      while (m < paramList.size())
      {
        this.e = ((ITransFileController)this.c.getRuntimeService(ITransFileController.class, ""));
        this.e.addHandle(this.k);
        localObject = new TransferRequest();
        ((TransferRequest)localObject).mIsUp = true;
        ((TransferRequest)localObject).mCommandId = 68;
        ((TransferRequest)localObject).mLocalPath = paramString;
        ((TransferRequest)localObject).mUniseq = ((Math.random() * 1000000.0D));
        ((TransferRequest)localObject).mPeerUin = this.a;
        ((TransferRequest)localObject).mFileType = 327696;
        ((TransferRequest)localObject).mRichTag = "pttSliceToText";
        ((TransferRequest)localObject).pcmForVadPath = this.d;
        ((TransferRequest)localObject).pcmForVadNum = paramList.size();
        ((TransferRequest)localObject).pcmForVadPos = m;
        ((TransferRequest)localObject).vadSeg = ((WXVadSeg)paramList.get(m));
        ((TransferRequest)localObject).chatType = this.b;
        this.e.transferAsync((TransferRequest)localObject);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("vadHelper startrecord sendrequest pos=");
          localStringBuilder.append(m);
          QLog.d("VoiceTextEdtiController", 2, localStringBuilder.toString());
        }
        this.j.add(Long.valueOf(((TransferRequest)localObject).mUniseq));
        m += 1;
      }
    }
  }
  
  private List<WXVadSeg> c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "vadHelper  vad start");
    }
    VadHelper localVadHelper = new VadHelper();
    localVadHelper.d();
    List localList = localVadHelper.a(this.d);
    localVadHelper.b();
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "vadHelper  vad start");
    }
    return localList;
  }
  
  int a(int paramInt)
  {
    int m;
    if (paramInt == 3000) {
      m = 1;
    } else {
      m = 2;
    }
    if (paramInt == 0) {
      return 2;
    }
    return m;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancelAllRequest sendIds len=");
      localStringBuilder.append(this.j.size());
      QLog.d("VoiceTextEdtiController", 2, localStringBuilder.toString());
    }
    int m = 0;
    while (m < this.j.size())
    {
      a(this.a, ((Long)this.j.get(m)).longValue());
      m += 1;
    }
    this.j.clear();
  }
  
  public void a(VoiceTextSttListener paramVoiceTextSttListener)
  {
    this.i = paramVoiceTextSttListener;
  }
  
  void a(SttResultBean paramSttResultBean, int paramInt)
  {
    Object localObject = this.h;
    if ((localObject != null) && (paramInt < localObject.length) && ((localObject[paramInt] == null) || (!localObject[paramInt].b)))
    {
      paramSttResultBean = b(paramSttResultBean, paramInt);
      localObject = this.i;
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
      Iterator localIterator = ((ITransFileController)this.c.getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        int n = 0;
        int m = n;
        if (localObject != null)
        {
          m = n;
          if ((localObject instanceof PttSliceUploadProcessor))
          {
            m = n;
            if (((BaseTransProcessor)localObject).getFileStatus() != 1003L) {
              m = 1;
            }
          }
        }
        if (m != 0)
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
    this.d = paramString1;
    this.i = paramVoiceTextSttListener;
    this.c = paramAppRuntime;
    this.b = paramInt;
    this.a = paramString2;
    this.b = a(paramInt);
    this.k.addFilter(new Class[] { PttSliceUploadProcessor.class });
  }
  
  String b(SttResultBean paramSttResultBean, int paramInt)
  {
    this.h[paramInt] = paramSttResultBean;
    paramSttResultBean = new StringBuffer();
    paramInt = 0;
    for (;;)
    {
      Object localObject = this.h;
      if (paramInt >= localObject.length) {
        break;
      }
      localObject = localObject[paramInt];
      if (localObject == null) {
        break;
      }
      paramSttResultBean.append(((SttResultBean)localObject).a);
      if (!((SttResultBean)localObject).b) {
        break;
      }
      paramInt += 1;
    }
    return paramSttResultBean.toString();
  }
  
  public void b()
  {
    ITransFileController localITransFileController = this.e;
    if (localITransFileController != null) {
      localITransFileController.removeHandle(this.k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttQueryController
 * JD-Core Version:    0.7.0.1
 */