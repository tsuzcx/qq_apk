package com.tencent.mobileqq.activity.aio.core.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.activity.aio.NewAIOTimeReporter;
import com.tencent.mobileqq.activity.aio.NewAIOTimeReporter.HelperReportData;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.DialogGenerator;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.OnActivityResultCallback;
import com.tencent.mobileqq.activity.aio.helper.OnAioAddShieldClickCallback;
import com.tencent.mobileqq.activity.aio.helper.OnHelperBusinessCallback;
import com.tencent.mobileqq.activity.aio.helper.OnTroopChatMsgChangedCallback;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class CoreHelperProvider
{
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final SparseArrayCompat<SparseArrayCompat<ILifeCycleHelper>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(18);
  private final List<OnActivityResultCallback> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final SparseArrayCompat<IHelper> jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private final List<DialogGenerator> jdField_b_of_type_JavaUtilList = new ArrayList();
  private final List<OnAioAddShieldClickCallback> c = new ArrayList();
  private final List<OnHelperBusinessCallback> d = new ArrayList();
  private final List<OnTroopChatMsgChangedCallback> e = new ArrayList();
  private final List<Handler.Callback> f = new ArrayList();
  
  public CoreHelperProvider(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    if ((paramInt1 < 7) && (paramLong >= 20L))
    {
      paramString = new NewAIOTimeReporter.HelperReportData(paramLong, paramInt1, paramInt2, paramString);
      NewAIOTimeReporter.a().a().offer(paramString);
    }
  }
  
  public Dialog a(int paramInt)
  {
    Object localObject = null;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
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
    return (IHelper)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localSparseArrayCompat == null) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder();
      int j = localSparseArrayCompat.size();
      int i = 0;
      while (i < j)
      {
        long l = SystemClock.uptimeMillis();
        ILifeCycleHelper localILifeCycleHelper = (ILifeCycleHelper)localSparseArrayCompat.valueAt(i);
        localILifeCycleHelper.onMoveToState(paramInt);
        a(paramInt, SystemClock.uptimeMillis() - l, this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.indexOfValue(localILifeCycleHelper), localILifeCycleHelper.getTag());
        i += 1;
      }
    } while (localStringBuilder.length() <= 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((OnAioAddShieldClickCallback)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((OnActivityResultCallback)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((DialogGenerator)localIterator.next()).a(paramInt, paramDialog);
    }
  }
  
  public void a(int paramInt, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((OnTroopChatMsgChangedCallback)localIterator.next()).a(paramInt, paramTroopChatPie, paramList);
    }
  }
  
  protected void a(int paramInt, IHelper paramIHelper)
  {
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramIHelper);
  }
  
  protected void a(int paramInt, ILifeCycleHelper paramILifeCycleHelper)
  {
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramILifeCycleHelper);
    int[] arrayOfInt = paramILifeCycleHelper.interestedIn();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(k);
      SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
      if (localSparseArrayCompat2 == null)
      {
        localSparseArrayCompat1 = new SparseArrayCompat();
        this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(k, localSparseArrayCompat1);
      }
      localSparseArrayCompat1.put(paramInt, paramILifeCycleHelper);
      i += 1;
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((OnHelperBusinessCallback)localIterator.next()).a(paramInt, paramVarArgs);
    }
  }
  
  public void a(Handler.Callback paramCallback)
  {
    this.f.add(paramCallback);
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
    this.c.add(paramOnAioAddShieldClickCallback);
  }
  
  public void a(OnHelperBusinessCallback paramOnHelperBusinessCallback)
  {
    this.d.add(paramOnHelperBusinessCallback);
  }
  
  public void a(OnTroopChatMsgChangedCallback paramOnTroopChatMsgChangedCallback)
  {
    this.e.add(paramOnTroopChatMsgChangedCallback);
  }
  
  public boolean a(Message paramMessage)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      if (((Handler.Callback)localIterator.next()).handleMessage(paramMessage)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider
 * JD-Core Version:    0.7.0.1
 */