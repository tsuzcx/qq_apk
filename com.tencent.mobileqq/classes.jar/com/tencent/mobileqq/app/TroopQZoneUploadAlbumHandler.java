package com.tencent.mobileqq.app;

import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public class TroopQZoneUploadAlbumHandler
  extends BusinessHandler
{
  Handler a;
  Messenger b = null;
  Messenger c = null;
  SparseArray<TroopQZoneUploadAlbumHandler.MonitorInfo> d = new SparseArray();
  private final ArrayList<TroopQZoneUploadAlbumHandler.CallbackPack> e = new ArrayList();
  private QQAppInterface f;
  private volatile int g = 0;
  private final LinkedBlockingQueue<Integer> h = new LinkedBlockingQueue();
  private volatile boolean i = false;
  private HandlerThread j;
  private Handler k;
  private volatile boolean l = false;
  private ServiceConnection m = new TroopQZoneUploadAlbumHandler.3(this);
  
  TroopQZoneUploadAlbumHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.f = paramQQAppInterface;
    this.a = new TroopQZoneUploadAlbumHandler.1(this, Looper.getMainLooper(), paramQQAppInterface);
  }
  
  private void a(int paramInt)
  {
    if ((this.l) && (QLog.isColorLevel())) {
      QLog.w("UploadPhoto", 2, "TroopQZoneUploadAlbumHandler 已经被销毁，不能sumbmit");
    }
    c();
    if (!this.h.contains(Integer.valueOf(paramInt))) {
      this.h.offer(Integer.valueOf(paramInt));
    }
  }
  
  private void a(int paramInt1, TroopQZoneUploadAlbumHandler.MonitorInfo paramMonitorInfo, int paramInt2, int paramInt3)
  {
    Message localMessage = this.a.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt1), paramMonitorInfo, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) };
    localMessage.sendToTarget();
  }
  
  private void b(int paramInt)
  {
    this.d.remove(paramInt);
    if (this.d.size() == 0)
    {
      b();
      return;
    }
    if (this.b == null) {
      return;
    }
    Message localMessage = Message.obtain(null, 999, paramInt, 0);
    try
    {
      this.b.send(localMessage);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  private void c()
  {
    if (this.g != 2)
    {
      if (this.g == 1) {
        return;
      }
      if (this.l)
      {
        if (QLog.isColorLevel()) {
          QLog.w("UploadPhoto", 2, "TroopQZoneUploadAlbumHandler 已经被销毁，不能doBindService");
        }
        return;
      }
      this.g = 1;
      QZoneHelper.bindQzonePublishQueueService(this.f, this.m);
    }
  }
  
  private void d()
  {
    if (this.j == null)
    {
      this.j = ThreadManager.newFreeHandlerThread("UploadPhoto", 5);
      this.j.start();
      this.k = new Handler(this.j.getLooper());
    }
    this.k.post(new TroopQZoneUploadAlbumHandler.2(this));
  }
  
  public void a()
  {
    if (this.g == 3) {
      return;
    }
    BaseApplication.getContext().unbindService(this.m);
    this.g = 3;
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    TroopQZoneUploadAlbumHandler.MonitorInfo localMonitorInfo = (TroopQZoneUploadAlbumHandler.MonitorInfo)this.d.get(paramInt2, null);
    if (localMonitorInfo == null) {
      return;
    }
    a(paramInt2, localMonitorInfo, paramInt1, paramInt3);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if (this.d.get(paramInt) == null) {
      this.d.append(paramInt, new TroopQZoneUploadAlbumHandler.MonitorInfo(this, paramString, paramLong));
    }
    a(paramInt);
  }
  
  void a(long paramLong, int paramInt1, int paramInt2)
  {
    int n = 0;
    while (n < this.e.size())
    {
      Object localObject = (TroopQZoneUploadAlbumHandler.CallbackPack)this.e.get(n);
      View localView = ((TroopQZoneUploadAlbumHandler.CallbackPack)localObject).a();
      localObject = ((TroopQZoneUploadAlbumHandler.CallbackPack)localObject).b();
      if ((localView != null) && (localObject != null))
      {
        ((TroopQZoneUploadAlbumHandler.Callback)localObject).a(localView, paramLong, paramInt1, paramInt2);
      }
      else
      {
        this.e.remove(n);
        n -= 1;
      }
      n += 1;
    }
  }
  
  public void a(View paramView, TroopQZoneUploadAlbumHandler.Callback paramCallback)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      TroopQZoneUploadAlbumHandler.CallbackPack localCallbackPack = (TroopQZoneUploadAlbumHandler.CallbackPack)localIterator.next();
      if (localCallbackPack.a() == paramView)
      {
        localCallbackPack.b = new WeakReference(paramCallback);
        return;
      }
    }
    this.e.add(new TroopQZoneUploadAlbumHandler.CallbackPack(this, paramView, paramCallback));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    Object localObject2 = paramQQAppInterface.getMessageFacade().a(paramString, 1, paramLong);
    if (localObject2 == null)
    {
      b(paramInt1);
      return;
    }
    String str = null;
    Object localObject1 = str;
    if (((MessageRecord)localObject2).msgtype == -2011)
    {
      AbsStructMsg localAbsStructMsg = ((MessageForStructing)localObject2).structingMsg;
      localObject1 = str;
      if ((localAbsStructMsg instanceof StructMsgForGeneralShare)) {
        localObject1 = (StructMsgForGeneralShare)localAbsStructMsg;
      }
    }
    if ((localObject1 != null) && (((StructMsgForGeneralShare)localObject1).getProgress() >= 0))
    {
      if ((paramInt2 == 1001) && (((MessageRecord)localObject2).extraflag != 32768))
      {
        ((StructMsgForGeneralShare)localObject1).setSummary(BaseApplication.getContext().getResources().getString(2131887775));
        ((StructMsgForGeneralShare)localObject1).setProgress(paramInt3);
        return;
      }
      str = BaseApplication.getContext().getResources().getString(2131887776);
      paramInt1 = 32772;
      if ((paramInt2 != 1000) && (paramInt2 != 1004))
      {
        if (paramInt2 == 1003)
        {
          str = BaseApplication.getContext().getResources().getString(2131887774);
          paramInt1 = 32768;
        }
        else if (paramInt2 == 1005)
        {
          str = BaseApplication.getContext().getResources().getString(2131887773);
          ((StructMsgForGeneralShare)localObject1).mMsgActionData = "";
          ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData = "";
          paramInt1 = 32770;
        }
      }
      else {
        str = BaseApplication.getContext().getResources().getString(2131887776);
      }
      ((StructMsgForGeneralShare)localObject1).setProgress(100);
      ((StructMsgForGeneralShare)localObject1).setSummary(str);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131912974));
      ((StringBuilder)localObject2).append(str);
      ((StructMsgForGeneralShare)localObject1).mMsgBrief = ((StringBuilder)localObject2).toString();
      paramQQAppInterface.getMsgCache().b(paramString, 1, paramLong);
      paramQQAppInterface.getMessageFacade().a(paramString, 1, paramLong, paramInt1, 0);
      paramQQAppInterface.getMessageFacade().a(paramString, 1, paramLong, ((StructMsgForGeneralShare)localObject1).getBytes());
      notifyUI(999, true, paramString);
      return;
    }
    b(paramInt1);
  }
  
  public boolean b()
  {
    a();
    try
    {
      QZoneHelper.stopQzonePublishQueueService(this.f.getApp());
      this.d.clear();
      return true;
    }
    catch (Exception localException)
    {
      QLog.i("UploadPhoto", 1, "", localException);
    }
    return false;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopQZoneUploadAlbumObserver.class;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("UploadPhoto", 2, "onDestroy");
    }
    this.l = true;
    this.i = true;
    this.d.clear();
    HandlerThread localHandlerThread = this.j;
    if (localHandlerThread != null) {
      localHandlerThread.interrupt();
    }
    b();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler
 * JD-Core Version:    0.7.0.1
 */