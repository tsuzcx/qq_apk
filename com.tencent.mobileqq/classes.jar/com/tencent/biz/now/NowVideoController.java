package com.tencent.biz.now;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.image.QQLiveDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NowVideoController
{
  private static NowVideoController e;
  private static Rect j = new Rect();
  public boolean a = false;
  Handler b = new NowVideoController.1(this, Looper.getMainLooper());
  public boolean c = true;
  List<WeakReference<NowVideoView>> d = new ArrayList();
  private SessionInfo f;
  private QQAppInterface g;
  private Context h;
  private AbsListView i;
  
  public static NowVideoController a()
  {
    if (e == null) {
      try
      {
        if (e == null) {
          e = new NowVideoController();
        }
      }
      finally {}
    }
    return e;
  }
  
  private void g()
  {
    QLog.d("NowVideoController", 2, "Check play()");
    if (this.i == null) {
      return;
    }
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      if (((SessionInfo)localObject1).a != 0) {
        return;
      }
      localObject1 = this.i;
      int n = ((AbsListView)localObject1).getFirstVisiblePosition();
      int i1 = ((AbsListView)localObject1).getLastVisiblePosition();
      int k = n;
      while (k <= i1)
      {
        Object localObject2 = ((AbsListView)localObject1).getChildAt(k - n);
        if (localObject2 != null)
        {
          localObject2 = ((View)localObject2).findViewById(2131446473);
          if ((localObject2 instanceof NowVideoView))
          {
            localObject2 = (NowVideoView)localObject2;
            ((NowVideoView)localObject2).getGlobalVisibleRect(j);
            ((NowVideoView)localObject2).getHeight();
            int m;
            if (j.height() > 0) {
              m = 1;
            } else {
              m = 0;
            }
            if (a(((NowVideoView)localObject2).getContext(), (NowVideoView)localObject2))
            {
              if (m != 0)
              {
                ((NowVideoView)localObject2).a(true);
              }
              else
              {
                localObject2 = ((NowVideoView)localObject2).e();
                if ((localObject2 != null) && (!((QQLiveDrawable)localObject2).isPaused())) {
                  ((QQLiveDrawable)localObject2).pause();
                }
              }
            }
            else {
              ((NowVideoView)localObject2).a();
            }
          }
        }
        k += 1;
      }
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      if (!((QQAppInterface)localObject).getMessageFacade().n()) {
        return;
      }
      localObject = this.f;
      if (localObject != null)
      {
        if (((SessionInfo)localObject).a != 1008) {
          return;
        }
        localObject = this.i;
        if (localObject != null)
        {
          int k = ((AbsListView)localObject).getFirstVisiblePosition();
          int m = this.i.getLastVisiblePosition();
          this.i.postDelayed(new NowVideoController.3(this, k, m), paramLong);
        }
      }
    }
  }
  
  public void a(NowVideoView paramNowVideoView)
  {
    this.d.add(new WeakReference(paramNowVideoView));
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, SessionInfo paramSessionInfo)
  {
    this.g = paramQQAppInterface;
    this.i = paramAbsListView;
    this.h = this.i.getContext();
    this.f = paramSessionInfo;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.c = true;
      g();
      return;
    }
    this.c = false;
  }
  
  public boolean a(Context paramContext, NowVideoView paramNowVideoView)
  {
    return NetworkUtil.isWifiConnected(paramContext);
  }
  
  public void b()
  {
    this.b.removeMessages(1);
    this.b.sendEmptyMessageDelayed(1, 200L);
    if (QLog.isColorLevel()) {
      QLog.d("NowVideoController", 2, "#requestPlayCheck():# ");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowVideoController", 2, "onNetWifi2Mobile(): ====>");
    }
    QQAppInterface localQQAppInterface = this.g;
    if ((localQQAppInterface != null) && (this.i != null))
    {
      if (this.h == null) {
        return;
      }
      if (!localQQAppInterface.getMessageFacade().n()) {
        return;
      }
      this.b.removeMessages(2);
      this.b.sendEmptyMessage(2);
      e();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((NowVideoView)localWeakReference.get()).f();
      }
    }
    this.d.clear();
    this.i = null;
    this.c = true;
    this.h = null;
    this.g = null;
    this.a = false;
    this.f = null;
  }
  
  public void e()
  {
    QQAppInterface localQQAppInterface = this.g;
    if (localQQAppInterface != null)
    {
      if (!localQQAppInterface.getMessageFacade().n()) {
        return;
      }
      if ((this.i != null) && (BaseActivity.sTopActivity != null))
      {
        int k = this.i.getFirstVisiblePosition();
        int m = this.i.getLastVisiblePosition();
        BaseActivity.sTopActivity.runOnUiThread(new NowVideoController.2(this, k, m));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoController
 * JD-Core Version:    0.7.0.1
 */