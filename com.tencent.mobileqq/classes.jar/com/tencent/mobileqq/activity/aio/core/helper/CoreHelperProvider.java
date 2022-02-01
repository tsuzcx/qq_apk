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
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private SparseArrayCompat<Long> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private final List<OnActivityResultCallback> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final SparseArrayCompat<SparseArrayCompat<ILifeCycleHelper>> jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(23);
  private final List<DialogGenerator> jdField_b_of_type_JavaUtilList = new ArrayList();
  private final SparseArrayCompat<IHelper> jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private final List<OnAioAddShieldClickCallback> jdField_c_of_type_JavaUtilList = new ArrayList();
  private final List<OnHelperBusinessCallback> d = new ArrayList();
  private final List<AIOOnTouchListener> e = new ArrayList();
  private final List<Handler.Callback> f = new ArrayList();
  private final List<OnFinishListener> g = new ArrayList();
  private final List<View.OnTouchListener> h = new ArrayList();
  private final List<View.OnClickListener> i = new ArrayList();
  private final List<TopGestureTouchEventListener> j = new ArrayList();
  private final List<AIOConfigurationListener> k = new ArrayList();
  
  public CoreHelperProvider(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    if ((paramInt1 < 8) && (paramLong >= 20L))
    {
      paramString = new NewAIOTimeReporter.HelperReportData(paramLong, paramInt1, paramInt2, paramString);
      NewAIOTimeReporter.a().a().offer(paramString);
    }
  }
  
  private void a(int paramInt, StringBuilder paramStringBuilder, ILifeCycleHelper paramILifeCycleHelper, long paramLong) {}
  
  @IntRange(from=0L, to=2L)
  public int a()
  {
    Object localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext())
    {
      OnFinishListener localOnFinishListener = (OnFinishListener)((Iterator)localObject).next();
      int m = localOnFinishListener.a();
      if (m != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onInterceptBackEvent by ");
          ((StringBuilder)localObject).append(localOnFinishListener);
          QLog.i("HelperProvider", 2, ((StringBuilder)localObject).toString());
        }
        return m;
      }
    }
    return 0;
  }
  
  public Dialog a(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
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
  
  public <T extends IHelper> T a(int paramInt)
  {
    return (IHelper)this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localSparseArrayCompat == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int n = localSparseArrayCompat.size();
    int m = 0;
    while (m < n)
    {
      long l1 = SystemClock.uptimeMillis();
      ILifeCycleHelper localILifeCycleHelper = (ILifeCycleHelper)localSparseArrayCompat.valueAt(m);
      localILifeCycleHelper.onMoveToState(paramInt);
      long l2 = SystemClock.uptimeMillis();
      if (this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.indexOfValue(localILifeCycleHelper) != -1) {
        a(paramInt, l2 - l1, this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.indexOfValue(localILifeCycleHelper), localILifeCycleHelper.getTag());
      }
      a(paramInt, localStringBuilder, localILifeCycleHelper, l2 - l1);
      m += 1;
    }
    if (paramInt == 7) {
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
    }
    localStringBuilder.length();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((OnAioAddShieldClickCallback)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((OnActivityResultCallback)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((DialogGenerator)localIterator.next()).a(paramInt, paramDialog);
    }
  }
  
  protected void a(int paramInt, IHelper paramIHelper)
  {
    this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramIHelper);
  }
  
  protected void a(int paramInt, ILifeCycleHelper paramILifeCycleHelper)
  {
    this.jdField_c_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramILifeCycleHelper);
    int[] arrayOfInt = paramILifeCycleHelper.interestedIn();
    int n = arrayOfInt.length;
    int m = 0;
    while (m < n)
    {
      int i1 = arrayOfInt[m];
      SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i1);
      SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
      if (localSparseArrayCompat2 == null)
      {
        localSparseArrayCompat1 = new SparseArrayCompat();
        this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(i1, localSparseArrayCompat1);
      }
      localSparseArrayCompat1.put(paramInt, paramILifeCycleHelper);
      m += 1;
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((OnHelperBusinessCallback)localIterator.next()).a(paramInt, paramVarArgs);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((AIOConfigurationListener)localIterator.next()).a(paramConfiguration);
    }
  }
  
  public void a(Handler.Callback paramCallback)
  {
    this.f.add(paramCallback);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((TopGestureTouchEventListener)localIterator.next()).a(paramMotionEvent);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.i.add(paramOnClickListener);
  }
  
  public void a(View paramView)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
  }
  
  public void a(AIOConfigurationListener paramAIOConfigurationListener)
  {
    this.k.add(paramAIOConfigurationListener);
  }
  
  public void a(AIOOnTouchListener paramAIOOnTouchListener)
  {
    this.e.add(paramAIOOnTouchListener);
  }
  
  public void a(OnFinishListener paramOnFinishListener)
  {
    this.g.add(paramOnFinishListener);
  }
  
  public void a(TopGestureTouchEventListener paramTopGestureTouchEventListener)
  {
    this.j.add(paramTopGestureTouchEventListener);
  }
  
  public void a(DialogGenerator paramDialogGenerator)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramDialogGenerator);
  }
  
  public void a(OnActivityResultCallback paramOnActivityResultCallback)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramOnActivityResultCallback);
  }
  
  public void a(OnAioAddShieldClickCallback paramOnAioAddShieldClickCallback)
  {
    this.jdField_c_of_type_JavaUtilList.add(paramOnAioAddShieldClickCallback);
  }
  
  public void a(OnHelperBusinessCallback paramOnHelperBusinessCallback)
  {
    this.d.add(paramOnHelperBusinessCallback);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext())
    {
      OnFinishListener localOnFinishListener = (OnFinishListener)((Iterator)localObject).next();
      if (localOnFinishListener.a(paramInt))
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
  
  public boolean a(Message paramMessage)
  {
    Object localObject = this.f.iterator();
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
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      int m = ((TopGestureTouchEventListener)localIterator.next()).a(paramMotionEvent);
      if (m != 0)
      {
        if (m == 1) {
          return true;
        }
        if (m == 2) {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean a(BaseAIOContext paramBaseAIOContext, View paramView, MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.e.iterator();
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
    Object localObject = this.g.iterator();
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
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((OnFinishListener)localIterator.next()).d(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider
 * JD-Core Version:    0.7.0.1
 */