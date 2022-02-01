package com.tencent.mobileqq.activity.aio.core.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.SparseArrayCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import androidx.annotation.IntRange;
import com.tencent.mobileqq.activity.aio.NewAIOTimeReporter;
import com.tencent.mobileqq.activity.aio.NewAIOTimeReporter.HelperReportData;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.helper.DialogGenerator;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.OnActivityResultCallback;
import com.tencent.mobileqq.activity.aio.helper.OnAioAddShieldClickCallback;
import com.tencent.mobileqq.activity.aio.helper.OnHelperBusinessCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class CoreHelperProvider
{
  private final Activity a;
  private SparseArrayCompat<Long> b = new SparseArrayCompat();
  private final SparseArrayCompat<SparseArrayCompat<ILifeCycleHelper>> c = new SparseArrayCompat(23);
  private final SparseArrayCompat<IHelper> d = new SparseArrayCompat();
  private final List<OnActivityResultCallback> e = new ArrayList();
  private final List<DialogGenerator> f = new ArrayList();
  private final List<OnAioAddShieldClickCallback> g = new ArrayList();
  private final List<OnHelperBusinessCallback> h = new ArrayList();
  private final List<AIOOnTouchListener> i = new ArrayList();
  private final List<Handler.Callback> j = new ArrayList();
  private final List<OnFinishListener> k = new ArrayList();
  private final List<View.OnTouchListener> l = new ArrayList();
  private final List<View.OnClickListener> m = new ArrayList();
  private final List<TopGestureTouchEventListener> n = new ArrayList();
  private final List<AIOConfigurationListener> o = new ArrayList();
  
  public CoreHelperProvider(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    if ((paramInt1 < 8) && (paramLong >= 20L))
    {
      paramString = new NewAIOTimeReporter.HelperReportData(paramLong, paramInt1, paramInt2, paramString);
      NewAIOTimeReporter.b().a().offer(paramString);
    }
  }
  
  private void a(int paramInt, StringBuilder paramStringBuilder, ILifeCycleHelper paramILifeCycleHelper, long paramLong) {}
  
  @IntRange(from=0L, to=2L)
  public int a()
  {
    Object localObject = this.k.iterator();
    while (((Iterator)localObject).hasNext())
    {
      OnFinishListener localOnFinishListener = (OnFinishListener)((Iterator)localObject).next();
      int i1 = localOnFinishListener.bM_();
      if (i1 != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onInterceptBackEvent by ");
          ((StringBuilder)localObject).append(localOnFinishListener);
          QLog.i("HelperProvider", 2, ((StringBuilder)localObject).toString());
        }
        return i1;
      }
    }
    return 0;
  }
  
  public <T extends IHelper> T a(int paramInt)
  {
    return (IHelper)this.d.get(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((OnAioAddShieldClickCallback)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((OnActivityResultCallback)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((DialogGenerator)localIterator.next()).a(paramInt, paramDialog);
    }
  }
  
  protected void a(int paramInt, IHelper paramIHelper)
  {
    this.d.put(paramInt, paramIHelper);
  }
  
  protected void a(int paramInt, ILifeCycleHelper paramILifeCycleHelper)
  {
    this.d.put(paramInt, paramILifeCycleHelper);
    int[] arrayOfInt = paramILifeCycleHelper.interestedIn();
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = arrayOfInt[i1];
      SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.c.get(i3);
      SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
      if (localSparseArrayCompat2 == null)
      {
        localSparseArrayCompat1 = new SparseArrayCompat();
        this.c.put(i3, localSparseArrayCompat1);
      }
      localSparseArrayCompat1.put(paramInt, paramILifeCycleHelper);
      i1 += 1;
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      ((OnHelperBusinessCallback)localIterator.next()).a(paramInt, paramVarArgs);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext()) {
      ((AIOConfigurationListener)localIterator.next()).a(paramConfiguration);
    }
  }
  
  public void a(Handler.Callback paramCallback)
  {
    this.j.add(paramCallback);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((TopGestureTouchEventListener)localIterator.next()).a(paramMotionEvent);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.m.add(paramOnClickListener);
  }
  
  public void a(View paramView)
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
  }
  
  public void a(AIOConfigurationListener paramAIOConfigurationListener)
  {
    this.o.add(paramAIOConfigurationListener);
  }
  
  public void a(AIOOnTouchListener paramAIOOnTouchListener)
  {
    this.i.add(paramAIOOnTouchListener);
  }
  
  public void a(OnFinishListener paramOnFinishListener)
  {
    this.k.add(paramOnFinishListener);
  }
  
  public void a(TopGestureTouchEventListener paramTopGestureTouchEventListener)
  {
    this.n.add(paramTopGestureTouchEventListener);
  }
  
  public void a(DialogGenerator paramDialogGenerator)
  {
    this.f.add(paramDialogGenerator);
  }
  
  public void a(OnActivityResultCallback paramOnActivityResultCallback)
  {
    this.e.add(paramOnActivityResultCallback);
  }
  
  public void a(OnAioAddShieldClickCallback paramOnAioAddShieldClickCallback)
  {
    this.g.add(paramOnAioAddShieldClickCallback);
  }
  
  public void a(OnHelperBusinessCallback paramOnHelperBusinessCallback)
  {
    this.h.add(paramOnHelperBusinessCallback);
  }
  
  public boolean a(Message paramMessage)
  {
    Object localObject = this.j.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Handler.Callback localCallback = (Handler.Callback)((Iterator)localObject).next();
      if (localCallback.handleMessage(paramMessage))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("msg ");
          ((StringBuilder)localObject).append(paramMessage.what);
          ((StringBuilder)localObject).append(" has been handled by ");
          ((StringBuilder)localObject).append(localCallback);
          QLog.d("HelperProvider", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean a(BaseAIOContext paramBaseAIOContext, View paramView, MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      AIOOnTouchListener localAIOOnTouchListener = (AIOOnTouchListener)localIterator.next();
      if (localAIOOnTouchListener.a(paramBaseAIOContext, paramView, paramMotionEvent))
      {
        if (QLog.isColorLevel())
        {
          paramBaseAIOContext = new StringBuilder();
          paramBaseAIOContext.append("onTouch event:");
          paramBaseAIOContext.append(paramMotionEvent.getAction());
          paramBaseAIOContext.append(", has been consumed by");
          paramBaseAIOContext.append(localAIOOnTouchListener);
          QLog.d("HelperProvider", 2, paramBaseAIOContext.toString());
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject = this.k.iterator();
    while (((Iterator)localObject).hasNext())
    {
      OnFinishListener localOnFinishListener = (OnFinishListener)((Iterator)localObject).next();
      if (localOnFinishListener.a(paramBoolean))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onInterceptLeftBackEvent by ");
          ((StringBuilder)localObject).append(localOnFinishListener);
          QLog.i("HelperProvider", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.c.get(paramInt);
    if (localSparseArrayCompat == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = localSparseArrayCompat.size();
    int i1 = 0;
    while (i1 < i2)
    {
      long l1 = SystemClock.uptimeMillis();
      ILifeCycleHelper localILifeCycleHelper = (ILifeCycleHelper)localSparseArrayCompat.valueAt(i1);
      localILifeCycleHelper.onMoveToState(paramInt);
      long l2 = SystemClock.uptimeMillis();
      if (this.d.indexOfValue(localILifeCycleHelper) != -1) {
        a(paramInt, l2 - l1, this.d.indexOfValue(localILifeCycleHelper), localILifeCycleHelper.getTag());
      }
      a(paramInt, localStringBuilder, localILifeCycleHelper, l2 - l1);
      i1 += 1;
    }
    if (paramInt == 7) {
      this.b.clear();
    }
    localStringBuilder.length();
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      int i1 = ((TopGestureTouchEventListener)localIterator.next()).b(paramMotionEvent);
      if (i1 != 0)
      {
        if (i1 == 1) {
          return true;
        }
        if (i1 == 2) {
          return false;
        }
      }
    }
    return true;
  }
  
  public Dialog c(int paramInt)
  {
    Iterator localIterator = this.f.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      Dialog localDialog = ((DialogGenerator)localIterator.next()).a(paramInt);
      localObject = localDialog;
      if (localDialog != null) {
        localObject = localDialog;
      }
    }
    return localObject;
  }
  
  public boolean d(int paramInt)
  {
    Object localObject = this.k.iterator();
    while (((Iterator)localObject).hasNext())
    {
      OnFinishListener localOnFinishListener = (OnFinishListener)((Iterator)localObject).next();
      if (localOnFinishListener.d(paramInt))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onInterceptFinish by ");
          ((StringBuilder)localObject).append(localOnFinishListener);
          QLog.i("HelperProvider", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    return false;
  }
  
  public void e(int paramInt)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((OnFinishListener)localIterator.next()).e(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider
 * JD-Core Version:    0.7.0.1
 */