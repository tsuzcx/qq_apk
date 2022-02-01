package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingProgress;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CaptureComboManager
  extends QIMAsyncManager
  implements Handler.Callback, IEventReceiver
{
  public static int a = 4;
  public HashMap<String, ComboSet> b = new HashMap();
  public HashMap<String, FilterSet> c = new HashMap();
  public HashMap<String, CaptureComboFilter> d = new HashMap();
  public Handler e = null;
  public Handler f = new Handler(Looper.getMainLooper(), new CaptureComboManager.2(this));
  public ArrayList<QIMFilterCategoryItem> g = new ArrayList();
  public ArrayList<QIMFilterCategoryItem> h = new ArrayList();
  public Handler i = new Handler(Looper.getMainLooper(), this);
  public HashMap<String, ArrayList<CaptureComboManager.ComboApplyTask>> j = new HashMap();
  ArrayList<CaptureComboManager.CaptureComboListener> k = new ArrayList();
  public VideoFilterTools.ComboFilterData l = null;
  public ComboSet m;
  public FilterSet n;
  public CaptureComboManager.CaptureRecord[] o = new CaptureComboManager.CaptureRecord[5];
  int p;
  private ComboLockManager q;
  private boolean r;
  
  public CaptureComboManager()
  {
    int i1 = 0;
    for (;;)
    {
      CaptureComboManager.CaptureRecord[] arrayOfCaptureRecord = this.o;
      if (i1 >= arrayOfCaptureRecord.length) {
        break;
      }
      arrayOfCaptureRecord[i1] = new CaptureComboManager.CaptureRecord(i1);
      i1 += 1;
    }
    this.p = 0;
    this.r = false;
    this.e = new Handler(ThreadManager.getSubThreadLooper(), new CaptureComboManager.1(this));
    this.q = new ComboLockManager();
  }
  
  private static boolean d(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if ((paramQIMFilterCategoryItem != null) && (paramQIMFilterCategoryItem.j != null))
    {
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.j.iterator();
      while (paramQIMFilterCategoryItem.hasNext()) {
        if ("EMPTY".equals((String)paramQIMFilterCategoryItem.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public CaptureComboFilter a(FilterDesc paramFilterDesc)
  {
    CaptureComboFilter localCaptureComboFilter2 = (CaptureComboFilter)this.d.get(paramFilterDesc.name);
    CaptureComboFilter localCaptureComboFilter1 = localCaptureComboFilter2;
    if (localCaptureComboFilter2 == null)
    {
      localCaptureComboFilter1 = new CaptureComboFilter(paramFilterDesc);
      this.d.put(paramFilterDesc.name, localCaptureComboFilter1);
    }
    return localCaptureComboFilter1;
  }
  
  public ComboSet a(String paramString)
  {
    Object localObject2 = this.l;
    Object localObject1 = null;
    ComboSet localComboSet = null;
    if (localObject2 != null)
    {
      localObject2 = ((VideoFilterTools.ComboFilterData)localObject2).d.a.iterator();
      for (;;)
      {
        localObject1 = localComboSet;
        if (!((Iterator)localObject2).hasNext()) {
          return localObject1;
        }
        localObject1 = ((FilterCategory)((Iterator)localObject2).next()).c.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject1).next();
          if (!TextUtils.equals(localQIMFilterCategoryItem.a, paramString)) {
            break;
          }
          localComboSet = c(localQIMFilterCategoryItem);
        }
      }
    }
    return localObject1;
  }
  
  public QIMFilterCategoryItem a(ComboSet paramComboSet, ArrayList<QIMFilterCategoryItem> paramArrayList)
  {
    Object localObject2 = null;
    if ((paramComboSet != null) && ((paramComboSet.e instanceof QIMFilterCategoryItem)))
    {
      Object localObject3 = (QIMFilterCategoryItem)paramComboSet.e;
      Object localObject1;
      if (((QIMFilterCategoryItem)localObject3).j.isEmpty())
      {
        localObject1 = null;
      }
      else
      {
        Iterator localIterator1 = paramArrayList.iterator();
        paramComboSet = null;
        for (;;)
        {
          localObject1 = paramComboSet;
          if (!localIterator1.hasNext()) {
            break label143;
          }
          localObject1 = (QIMFilterCategoryItem)localIterator1.next();
          if (((QIMFilterCategoryItem)localObject1).j.size() == ((QIMFilterCategoryItem)localObject3).j.size())
          {
            Iterator localIterator2 = ((QIMFilterCategoryItem)localObject3).j.iterator();
            if (localIterator2.hasNext())
            {
              String str = (String)localIterator2.next();
              if (!((QIMFilterCategoryItem)localObject1).j.contains(str)) {
                break;
              }
              paramComboSet = (ComboSet)localObject1;
            }
          }
        }
      }
      label143:
      if (localObject1 == null)
      {
        localObject3 = ((QIMFilterCategoryItem)localObject3).j.iterator();
        paramComboSet = (ComboSet)localObject2;
        for (;;)
        {
          localObject2 = paramComboSet;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject3).next();
          localObject2 = VideoFilterTools.a().a((String)localObject2);
          if (localObject2 != null)
          {
            if (QQAVImageFilterConstants.getFilterType(((FilterDesc)localObject2).id) == 2) {
              break;
            }
            paramComboSet = (ComboSet)localObject2;
          }
        }
        if (localObject2 != null)
        {
          paramComboSet = paramArrayList.iterator();
          while (paramComboSet.hasNext())
          {
            paramArrayList = (QIMFilterCategoryItem)paramComboSet.next();
            if ((paramArrayList.j.size() == 1) && (paramArrayList.j.contains(((FilterDesc)localObject2).name))) {
              return paramArrayList;
            }
          }
        }
      }
      return localObject1;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    int i1 = this.p;
    if ((i1 & 0x3) == 3) {
      return;
    }
    this.p = (paramInt | i1);
    if ((this.p & 0x3) == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CaptureComboManager", 2, "first random");
      }
      h();
    }
  }
  
  public void a(int paramInt, Activity paramActivity)
  {
    Object localObject = VideoFilterTools.a().a(paramInt);
    if (localObject != null)
    {
      localObject = c((QIMFilterCategoryItem)localObject);
      if ((localObject != null) && (((ComboSet)localObject).b == 1))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("capture_scene", paramInt);
        ComboSet localComboSet = VideoFilterTools.a().e[paramInt];
        if (localComboSet != null) {
          b((QIMFilterCategoryItem)localComboSet.e, paramActivity, (Bundle)localObject);
        }
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("stopApplyDownload scene ");
          paramActivity.append(paramInt);
          QLog.i("QCombo", 2, paramActivity.toString());
        }
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    CaptureComboManager.CaptureRecord[] arrayOfCaptureRecord = this.o;
    int i2 = arrayOfCaptureRecord.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfCaptureRecord[i1].c(paramActivity);
      i1 += 1;
    }
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateData data is null?");
      boolean bool;
      if (paramComboFilterData == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("QCombo", 2, localStringBuilder.toString());
    }
    if (paramComboFilterData != null)
    {
      this.l = paramComboFilterData;
      this.q.a(paramComboFilterData);
      Message.obtain(this.i, 9, paramComboFilterData).sendToTarget();
    }
    a(1);
  }
  
  public void a(CaptureComboManager.CaptureComboListener paramCaptureComboListener)
  {
    synchronized (this.k)
    {
      if (!this.k.contains(paramCaptureComboListener)) {
        this.k.add(paramCaptureComboListener);
      }
      return;
    }
  }
  
  public void a(CaptureComboManager.ComboApplyTask paramComboApplyTask)
  {
    synchronized (this.j)
    {
      String str = paramComboApplyTask.a.h();
      ArrayList localArrayList2 = (ArrayList)this.j.get(str);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.j.put(str, localArrayList1);
      }
      localArrayList1.add(paramComboApplyTask);
      return;
    }
  }
  
  public void a(CaptureSet paramCaptureSet)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("downloadComboSuccess captureSet ");
      ((StringBuilder)???).append(paramCaptureSet);
      QLog.i("QCombo", 2, ((StringBuilder)???).toString());
    }
    if ((paramCaptureSet.e instanceof QIMFilterCategoryItem)) {
      synchronized (this.h)
      {
        this.h.add((QIMFilterCategoryItem)paramCaptureSet.e);
        Message.obtain(this.e, 1, 0, 7, paramCaptureSet).sendToTarget();
        return;
      }
    }
  }
  
  public void a(CaptureSet paramCaptureSet, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("downloadComboFailed captureset ");
      ((StringBuilder)???).append(paramCaptureSet);
      QLog.i("QCombo", 2, ((StringBuilder)???).toString());
    }
    if ((paramCaptureSet.e instanceof QIMFilterCategoryItem)) {
      synchronized (this.h)
      {
        this.h.add((QIMFilterCategoryItem)paramCaptureSet.e);
        Message.obtain(this.i, 1, paramInt, 7, paramCaptureSet).sendToTarget();
        return;
      }
    }
  }
  
  public void a(ComboSet paramComboSet)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((CaptureComboManager.CaptureComboListener)localIterator.next()).a(paramComboSet);
    }
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pre_capture_combo_select", 0);
    if ((!paramQIMFilterCategoryItem.f()) && (!paramQIMFilterCategoryItem.c())) {
      paramQIMFilterCategoryItem = "";
    } else {
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.a;
    }
    Object localObject = paramQIMFilterCategoryItem;
    if (paramQIMFilterCategoryItem == null) {
      localObject = "";
    }
    localSharedPreferences.edit().putString("select", (String)localObject).apply();
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, Bundle paramBundle)
  {
    int i1 = paramBundle.getInt("capture_scene", -1);
    QIMFilterCategoryItem localQIMFilterCategoryItem = VideoFilterTools.a().b(i1);
    boolean bool1;
    if ((localQIMFilterCategoryItem != null) && (TextUtils.equals(localQIMFilterCategoryItem.a, paramQIMFilterCategoryItem.a))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((localQIMFilterCategoryItem == null) && (d(paramQIMFilterCategoryItem))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3 = paramBundle.getBoolean("capture_force_enable", false);
    if (((bool1) || (bool2)) && (!bool3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureComboManager", 2, new Object[] { "applyFilters repeat, sameItem: ", Boolean.valueOf(bool1), " emptyItem:", Boolean.valueOf(bool2), " filterItem:", paramQIMFilterCategoryItem.b, " isForceEnable:", Boolean.valueOf(bool3) });
      }
      return;
    }
    paramQIMFilterCategoryItem = ((CaptureComboManager)QIMManager.a(5)).b(paramQIMFilterCategoryItem);
    paramQIMFilterCategoryItem.c(paramActivity, i1);
    paramQIMFilterCategoryItem.f = new WeakReference(paramActivity);
    i1 = paramQIMFilterCategoryItem.b;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 == 3)
        {
          a(new CaptureComboManager.ComboApplyTask(paramQIMFilterCategoryItem, paramBundle, paramActivity));
          paramActivity = Message.obtain(this.i, 7, 0, 0, paramQIMFilterCategoryItem);
          if (Looper.getMainLooper() == Looper.myLooper()) {
            a(paramActivity);
          } else {
            paramActivity.sendToTarget();
          }
        }
      }
      else
      {
        a(new CaptureComboManager.ComboApplyTask(paramQIMFilterCategoryItem, paramBundle, paramActivity));
        QIMCommonLoadingProgress.a(paramQIMFilterCategoryItem).a();
        paramQIMFilterCategoryItem.d();
      }
    }
    else {
      a(new CaptureComboManager.ComboApplyTask(paramQIMFilterCategoryItem, paramBundle, paramActivity));
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("applyFilters state = ");
      paramActivity.append(paramQIMFilterCategoryItem.b);
      QLog.i("QCombo", 2, paramActivity.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("yes to do setBeRecording");
      localStringBuilder.append(paramBoolean);
      QLog.i("CaptureComboManager", 2, localStringBuilder.toString());
    }
    this.r = paramBoolean;
  }
  
  public boolean a(Message paramMessage)
  {
    int i1 = paramMessage.what;
    Object localObject1;
    if (i1 != 7)
    {
      if (i1 != 9) {
        return false;
      }
      paramMessage = (VideoFilterTools.ComboFilterData)paramMessage.obj;
      try
      {
        localObject1 = this.k.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((CaptureComboManager.CaptureComboListener)((Iterator)localObject1).next()).a(paramMessage);
        }
        return false;
      }
      finally {}
    }
    i1 = paramMessage.arg1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MSG_APPLY error ");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramMessage.obj);
      QLog.d("QCombo", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    Object localObject3;
    int i2;
    if ((paramMessage.obj instanceof FilterSet))
    {
      paramMessage = (FilterSet)paramMessage.obj;
      if (i1 == 0) {
        QIMCommonLoadingProgress.a(paramMessage).c();
      } else {
        QIMCommonLoadingProgress.a(paramMessage).d();
      }
      localObject1 = paramMessage.h();
      localObject1 = (ArrayList)this.j.get(localObject1);
      if (localObject1 != null)
      {
        localObject2 = (ArrayList)((ArrayList)localObject1).clone();
        ((ArrayList)localObject1).clear();
        localObject1 = (QIMFilterCategoryItem)paramMessage.e;
        if (i1 == 0)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
            i1 = ((CaptureComboManager.ComboApplyTask)localObject3).b.getInt("capture_scene", -1);
            ??? = VideoFilterTools.a().b(i1);
            if ((localObject1 != null) && (??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)localObject1).a, ((QIMFilterCategoryItem)???).a)) && (!this.r))
            {
              if (QLog.isColorLevel())
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append("MSG_APPLY filter ");
                ((StringBuilder)???).append(i1);
                ((StringBuilder)???).append(" ");
                ((StringBuilder)???).append(???);
                QLog.d("QCombo", 2, ((StringBuilder)???).toString());
              }
              ((QIMCaptureVarManager)QIMManager.a(13)).a(((QIMFilterCategoryItem)???).a);
              ??? = (Activity)((CaptureComboManager.ComboApplyTask)localObject3).c.get();
              if (??? != null)
              {
                paramMessage.a((Activity)???, i1);
                synchronized (this.k)
                {
                  ??? = this.k.iterator();
                  while (((Iterator)???).hasNext()) {
                    ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, true, 0, ((CaptureComboManager.ComboApplyTask)localObject3).b);
                  }
                }
              }
            }
          }
          this.n = paramMessage;
          return false;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
          i2 = ((CaptureComboManager.ComboApplyTask)localObject3).b.getInt("capture_scene", -1);
          ??? = VideoFilterTools.a().b(i2);
          if ((localObject1 != null) && (??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)localObject1).a, ((QIMFilterCategoryItem)???).a)))
          {
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("MSG_APPLY filter ");
              ((StringBuilder)???).append(i2);
              ((StringBuilder)???).append(" ");
              ((StringBuilder)???).append(???);
              QLog.d("QCombo", 2, ((StringBuilder)???).toString());
            }
            ((QIMCaptureVarManager)QIMManager.a(13)).a(((QIMFilterCategoryItem)???).a);
            if ((Activity)((CaptureComboManager.ComboApplyTask)localObject3).c.get() != null) {
              synchronized (this.k)
              {
                ??? = this.k.iterator();
                while (((Iterator)???).hasNext()) {
                  ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, false, i1, ((CaptureComboManager.ComboApplyTask)localObject3).b);
                }
              }
            }
            QQToast.makeText(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131899589), 0).show();
          }
        }
      }
    }
    else if ((paramMessage.obj instanceof ComboSet))
    {
      paramMessage = (ComboSet)paramMessage.obj;
      if (i1 == 0) {
        QIMCommonLoadingProgress.a(paramMessage).c();
      } else {
        QIMCommonLoadingProgress.a(paramMessage).d();
      }
      localObject1 = (QIMFilterCategoryItem)paramMessage.e;
      localObject2 = paramMessage.h();
      localObject2 = (ArrayList)this.j.get(localObject2);
      if (localObject2 != null)
      {
        localObject3 = (ArrayList)((ArrayList)localObject2).clone();
        ((ArrayList)localObject2).clear();
        if (i1 == 0)
        {
          localObject2 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
            ??? = (Activity)((CaptureComboManager.ComboApplyTask)localObject3).c.get();
            if (??? != null)
            {
              i1 = ((CaptureComboManager.ComboApplyTask)localObject3).b.getInt("capture_scene", -1);
              ??? = VideoFilterTools.a().a(i1);
              if ((??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)???).a, ((QIMFilterCategoryItem)localObject1).a)))
              {
                if (QLog.isColorLevel())
                {
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("MSG_APPLY success ");
                  ((StringBuilder)???).append(i1);
                  ((StringBuilder)???).append(" ");
                  ((StringBuilder)???).append(localObject1);
                  QLog.d("QCombo", 2, ((StringBuilder)???).toString());
                }
                ((QIMCaptureVarManager)QIMManager.a(13)).b(((QIMFilterCategoryItem)localObject1).a);
                if (!CaptureComboFilter.a(paramMessage, i1)) {
                  paramMessage.a((Activity)???, i1);
                }
                synchronized (this.k)
                {
                  ??? = this.k.iterator();
                  while (((Iterator)???).hasNext()) {
                    ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, true, 0, ((CaptureComboManager.ComboApplyTask)localObject3).b);
                  }
                }
              }
            }
          }
          this.m = paramMessage;
          return false;
        }
        localObject2 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
          i2 = ((CaptureComboManager.ComboApplyTask)localObject3).b.getInt("capture_scene", -1);
          ??? = VideoFilterTools.a().a(i2);
          if ((??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)???).a, ((QIMFilterCategoryItem)localObject1).a)))
          {
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("MSG_APPLY fail ");
              ((StringBuilder)???).append(i2);
              ((StringBuilder)???).append(" ");
              ((StringBuilder)???).append(localObject1);
              QLog.d("QCombo", 2, ((StringBuilder)???).toString());
            }
            ((QIMCaptureVarManager)QIMManager.a(13)).b(((QIMFilterCategoryItem)localObject1).a);
            ??? = (Activity)((CaptureComboManager.ComboApplyTask)localObject3).c.get();
            if (??? != null) {
              synchronized (this.k)
              {
                Object localObject6 = this.k.iterator();
                while (((Iterator)localObject6).hasNext()) {
                  ((CaptureComboManager.CaptureComboListener)((Iterator)localObject6).next()).a(paramMessage, false, i1, ((CaptureComboManager.ComboApplyTask)localObject3).b);
                }
                ??? = (CaptureComboManager)QIMManager.a(5);
                localObject6 = ((CaptureComboManager)???).m;
                if (localObject6 != null) {
                  ((CaptureComboManager)???).b((QIMFilterCategoryItem)((ComboSet)localObject6).e, (Activity)???, ((CaptureComboManager.ComboApplyTask)localObject3).b);
                }
              }
            }
            QQToast.makeText(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131899591), 0).show();
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(List<FilterCategory> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preInitCombo: ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("QCombo", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = false;
    Object localObject = paramList.iterator();
    if (((Iterator)localObject).hasNext())
    {
      FilterCategory localFilterCategory = (FilterCategory)((Iterator)localObject).next();
      Iterator localIterator = localFilterCategory.c.iterator();
      boolean bool2 = bool1;
      for (;;)
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)localIterator.next();
        if (localFilterCategory.d) {
          paramList = c(localQIMFilterCategoryItem);
        } else {
          paramList = b(localQIMFilterCategoryItem);
        }
        paramList.b = paramList.c();
        if (paramList.b == 1)
        {
          paramList.c = ((int)(paramList.e() * 10000.0F));
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("preInitCombo progress: ");
            localStringBuilder.append(localQIMFilterCategoryItem.b);
            localStringBuilder.append(", progress: ");
            localStringBuilder.append(paramList.c);
            QLog.d("QCombo", 2, localStringBuilder.toString());
          }
          bool2 = true;
        }
        else if ((paramList.b != 2) && (paramList.b == 3))
        {
          paramList.c = 10000;
        }
      }
    }
    return bool1;
  }
  
  public ComboSet b(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, Bundle paramBundle)
  {
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    ComboSet localComboSet = localCaptureComboManager.c(paramQIMFilterCategoryItem);
    localComboSet.c(paramActivity, paramBundle.getInt("capture_scene", -1));
    localComboSet.f = new WeakReference(paramActivity);
    localCaptureComboManager.a(paramQIMFilterCategoryItem);
    int i1 = localComboSet.b;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 == 3)
        {
          a(new CaptureComboManager.ComboApplyTask(localComboSet, paramBundle, paramActivity));
          paramQIMFilterCategoryItem = Message.obtain(this.i, 7, 0, 0, localComboSet);
          if (Looper.getMainLooper() == Looper.myLooper()) {
            a(paramQIMFilterCategoryItem);
          } else {
            paramQIMFilterCategoryItem.sendToTarget();
          }
        }
      }
      else
      {
        a(new CaptureComboManager.ComboApplyTask(localComboSet, paramBundle, paramActivity));
        localComboSet.d();
      }
    }
    else {
      a(new CaptureComboManager.ComboApplyTask(localComboSet, paramBundle, paramActivity));
    }
    if (QLog.isColorLevel())
    {
      paramQIMFilterCategoryItem = new StringBuilder();
      paramQIMFilterCategoryItem.append("applyCombo state = ");
      paramQIMFilterCategoryItem.append(localComboSet.b);
      QLog.i("QCombo", 2, paramQIMFilterCategoryItem.toString());
    }
    return localComboSet;
  }
  
  public FilterSet b(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramQIMFilterCategoryItem.j.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = VideoFilterTools.a().a((String)localObject2);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
    }
    Object localObject2 = (FilterSet)this.c.get(paramQIMFilterCategoryItem.a);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new FilterSet(paramQIMFilterCategoryItem);
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((FilterSet)localObject1).c(a((FilterDesc)((Iterator)localObject2).next()));
      }
      this.c.put(paramQIMFilterCategoryItem.a, localObject1);
    }
    return localObject1;
  }
  
  public void b()
  {
    VideoFilterTools.a().a(BaseApplicationImpl.getContext(), null, false);
    if (QLog.isDevelopLevel()) {
      QLog.d("CaptureComboManager", 4, "initComboConfig");
    }
  }
  
  public void b(CaptureComboManager.CaptureComboListener paramCaptureComboListener)
  {
    synchronized (this.k)
    {
      this.k.remove(paramCaptureComboListener);
      return;
    }
  }
  
  public void b(CaptureSet paramCaptureSet)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("notifyDownloadBegin combo ");
      ((StringBuilder)???).append(paramCaptureSet);
      QLog.i("QCombo", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.h)
    {
      this.h.add((QIMFilterCategoryItem)paramCaptureSet.e);
      this.e.sendEmptyMessage(1);
      return;
    }
  }
  
  /* Error */
  public ComboSet c(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/aelight/camera/aioeditor/capture/data/CaptureComboManager:b	Ljava/util/HashMap;
    //   4: aload_1
    //   5: getfield 184	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:a	Ljava/lang/String;
    //   8: invokevirtual 155	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11: checkcast 195	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet
    //   14: astore 11
    //   16: aload 11
    //   18: astore 10
    //   20: aload 11
    //   22: ifnonnull +1265 -> 1287
    //   25: new 195	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 599	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:<init>	(Ljava/lang/Object;)V
    //   33: astore 12
    //   35: aload_1
    //   36: getfield 122	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:j	Ljava/util/ArrayList;
    //   39: invokevirtual 126	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   42: astore 10
    //   44: aload 10
    //   46: invokeinterface 132 1 0
    //   51: ifeq +91 -> 142
    //   54: aload 10
    //   56: invokeinterface 138 1 0
    //   61: checkcast 140	java/lang/String
    //   64: astore 11
    //   66: invokestatic 213	com/tencent/aelight/camera/aioeditor/activity/richmedia/VideoFilterTools:a	()Lcom/tencent/aelight/camera/aioeditor/activity/richmedia/VideoFilterTools;
    //   69: aload 11
    //   71: invokevirtual 216	com/tencent/aelight/camera/aioeditor/activity/richmedia/VideoFilterTools:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/richmedia/capture/data/FilterDesc;
    //   74: astore 13
    //   76: aload 13
    //   78: ifnull +17 -> 95
    //   81: aload 12
    //   83: aload_0
    //   84: aload 13
    //   86: invokevirtual 572	com/tencent/aelight/camera/aioeditor/capture/data/CaptureComboManager:a	(Lcom/tencent/mobileqq/richmedia/capture/data/FilterDesc;)Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboFilter;
    //   89: invokevirtual 600	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:c	(Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;)V
    //   92: goto -48 -> 44
    //   95: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq -54 -> 44
    //   101: new 264	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   108: astore 13
    //   110: aload 13
    //   112: ldc_w 602
    //   115: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 13
    //   121: aload 11
    //   123: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc_w 276
    //   130: iconst_2
    //   131: aload 13
    //   133: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: goto -95 -> 44
    //   142: aload_1
    //   143: getfield 605	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:k	Lorg/json/JSONArray;
    //   146: astore 10
    //   148: ldc_w 607
    //   151: astore 11
    //   153: aload 10
    //   155: ifnull +256 -> 411
    //   158: aload_1
    //   159: getfield 605	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:k	Lorg/json/JSONArray;
    //   162: invokevirtual 612	org/json/JSONArray:length	()I
    //   165: istore 8
    //   167: iconst_0
    //   168: istore 7
    //   170: iconst_0
    //   171: istore 5
    //   173: iload 5
    //   175: istore 6
    //   177: iload 7
    //   179: iload 8
    //   181: if_icmpge +233 -> 414
    //   184: aload_1
    //   185: getfield 605	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:k	Lorg/json/JSONArray;
    //   188: iload 7
    //   190: invokevirtual 616	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   193: astore 14
    //   195: iload 5
    //   197: istore 6
    //   199: aload 14
    //   201: ifnull +197 -> 398
    //   204: aload 14
    //   206: ldc_w 618
    //   209: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 15
    //   214: aload 14
    //   216: ldc_w 626
    //   219: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   222: astore 10
    //   224: aload 14
    //   226: ldc_w 628
    //   229: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   232: invokestatic 633	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   235: invokevirtual 636	java/lang/Float:floatValue	()F
    //   238: fstore_2
    //   239: aload 14
    //   241: ldc_w 638
    //   244: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   247: invokestatic 633	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   250: invokevirtual 636	java/lang/Float:floatValue	()F
    //   253: fstore_3
    //   254: aload 14
    //   256: ldc_w 607
    //   259: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   262: invokestatic 633	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   265: invokevirtual 636	java/lang/Float:floatValue	()F
    //   268: fstore 4
    //   270: new 640	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper
    //   273: dup
    //   274: invokespecial 641	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper:<init>	()V
    //   277: astore 13
    //   279: aload 13
    //   281: aload 14
    //   283: invokevirtual 645	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper:fromJSONObject	(Lorg/json/JSONObject;)V
    //   286: aload_1
    //   287: getfield 184	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:a	Ljava/lang/String;
    //   290: aload 15
    //   292: aload 10
    //   294: fload_2
    //   295: fload_3
    //   296: fload 4
    //   298: invokestatic 650	com/tencent/aelight/camera/aioeditor/capture/paster/CaptureComboPasterFactory:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FFF)Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;
    //   301: astore 14
    //   303: aload 14
    //   305: ifnull +24 -> 329
    //   308: aload 14
    //   310: aload 13
    //   312: invokevirtual 655	com/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase:a	(Lcom/tencent/mobileqq/richmedia/capture/data/SegmentKeeper;)V
    //   315: aload 12
    //   317: aload 14
    //   319: invokevirtual 600	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:c	(Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;)V
    //   322: iload 5
    //   324: istore 6
    //   326: goto +72 -> 398
    //   329: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +41 -> 373
    //   335: new 264	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   342: astore 13
    //   344: aload 13
    //   346: ldc_w 657
    //   349: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 13
    //   355: aload 10
    //   357: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: ldc_w 276
    //   364: iconst_2
    //   365: aload 13
    //   367: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: iconst_1
    //   374: istore 6
    //   376: goto +22 -> 398
    //   379: astore 10
    //   381: iconst_1
    //   382: istore 5
    //   384: goto +5 -> 389
    //   387: astore 10
    //   389: aload 10
    //   391: invokevirtual 660	java/lang/Exception:printStackTrace	()V
    //   394: iload 5
    //   396: istore 6
    //   398: iload 7
    //   400: iconst_1
    //   401: iadd
    //   402: istore 7
    //   404: iload 6
    //   406: istore 5
    //   408: goto -235 -> 173
    //   411: iconst_0
    //   412: istore 6
    //   414: aload_1
    //   415: getfield 662	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:l	Lorg/json/JSONArray;
    //   418: ifnull +191 -> 609
    //   421: aload_1
    //   422: getfield 662	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:l	Lorg/json/JSONArray;
    //   425: invokevirtual 612	org/json/JSONArray:length	()I
    //   428: istore 8
    //   430: iconst_0
    //   431: istore 7
    //   433: iload 6
    //   435: istore 5
    //   437: iload 7
    //   439: iload 8
    //   441: if_icmpge +172 -> 613
    //   444: aload_1
    //   445: getfield 662	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:l	Lorg/json/JSONArray;
    //   448: iload 7
    //   450: invokevirtual 616	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   453: astore 13
    //   455: iload 6
    //   457: istore 5
    //   459: aload 13
    //   461: ifnull +135 -> 596
    //   464: aload 13
    //   466: ldc_w 664
    //   469: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   472: astore 10
    //   474: aload 13
    //   476: ldc_w 666
    //   479: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   482: astore 13
    //   484: aload 13
    //   486: invokestatic 669	com/tencent/aelight/camera/aioeditor/capture/paster/CaptureComboPasterFactory:a	(Ljava/lang/String;)Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;
    //   489: astore 14
    //   491: aload 14
    //   493: ifnull +17 -> 510
    //   496: aload 12
    //   498: aload 14
    //   500: invokevirtual 600	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:c	(Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;)V
    //   503: iload 6
    //   505: istore 5
    //   507: goto +89 -> 596
    //   510: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq +58 -> 571
    //   516: new 264	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   523: astore 14
    //   525: aload 14
    //   527: ldc_w 671
    //   530: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 14
    //   536: aload 10
    //   538: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 14
    //   544: ldc_w 673
    //   547: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 14
    //   553: aload 13
    //   555: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: ldc_w 276
    //   562: iconst_2
    //   563: aload 14
    //   565: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: iconst_1
    //   572: istore 5
    //   574: goto +22 -> 596
    //   577: astore 10
    //   579: iconst_1
    //   580: istore 5
    //   582: goto +9 -> 591
    //   585: astore 10
    //   587: iload 6
    //   589: istore 5
    //   591: aload 10
    //   593: invokevirtual 660	java/lang/Exception:printStackTrace	()V
    //   596: iload 7
    //   598: iconst_1
    //   599: iadd
    //   600: istore 7
    //   602: iload 5
    //   604: istore 6
    //   606: goto -173 -> 433
    //   609: iload 6
    //   611: istore 5
    //   613: iload 5
    //   615: istore 6
    //   617: aload_1
    //   618: getfield 675	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:m	Lorg/json/JSONArray;
    //   621: ifnull +203 -> 824
    //   624: aload_1
    //   625: getfield 675	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:m	Lorg/json/JSONArray;
    //   628: invokevirtual 612	org/json/JSONArray:length	()I
    //   631: istore 8
    //   633: iconst_0
    //   634: istore 7
    //   636: iload 5
    //   638: istore 6
    //   640: iload 7
    //   642: iload 8
    //   644: if_icmpge +180 -> 824
    //   647: aload_1
    //   648: getfield 675	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:m	Lorg/json/JSONArray;
    //   651: iload 7
    //   653: invokevirtual 616	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   656: astore 13
    //   658: iload 5
    //   660: istore 6
    //   662: aload 13
    //   664: ifnull +147 -> 811
    //   667: aload 13
    //   669: ldc_w 664
    //   672: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   675: astore 10
    //   677: aload 13
    //   679: ldc_w 666
    //   682: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   685: astore 13
    //   687: iload 5
    //   689: istore 6
    //   691: aload 10
    //   693: invokestatic 680	com/tencent/mobileqq/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   696: ifne +115 -> 811
    //   699: aload 13
    //   701: invokestatic 682	com/tencent/aelight/camera/aioeditor/capture/paster/CaptureComboPasterFactory:b	(Ljava/lang/String;)Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;
    //   704: astore 14
    //   706: aload 14
    //   708: ifnull +17 -> 725
    //   711: aload 12
    //   713: aload 14
    //   715: invokevirtual 600	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:c	(Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;)V
    //   718: iload 5
    //   720: istore 6
    //   722: goto +89 -> 811
    //   725: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   728: ifeq +58 -> 786
    //   731: new 264	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   738: astore 14
    //   740: aload 14
    //   742: ldc_w 684
    //   745: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 14
    //   751: aload 10
    //   753: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload 14
    //   759: ldc_w 673
    //   762: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload 14
    //   768: aload 13
    //   770: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: pop
    //   774: ldc_w 276
    //   777: iconst_2
    //   778: aload 14
    //   780: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   786: iconst_1
    //   787: istore 6
    //   789: goto +22 -> 811
    //   792: astore 10
    //   794: iconst_1
    //   795: istore 5
    //   797: goto +5 -> 802
    //   800: astore 10
    //   802: aload 10
    //   804: invokevirtual 660	java/lang/Exception:printStackTrace	()V
    //   807: iload 5
    //   809: istore 6
    //   811: iload 7
    //   813: iconst_1
    //   814: iadd
    //   815: istore 7
    //   817: iload 6
    //   819: istore 5
    //   821: goto -185 -> 636
    //   824: iload 6
    //   826: istore 5
    //   828: aload_1
    //   829: getfield 686	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:n	Lorg/json/JSONArray;
    //   832: ifnull +432 -> 1264
    //   835: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   838: ifeq +65 -> 903
    //   841: new 264	java/lang/StringBuilder
    //   844: dup
    //   845: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   848: astore 10
    //   850: aload 10
    //   852: ldc_w 688
    //   855: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: pop
    //   859: aload 10
    //   861: aload_1
    //   862: getfield 686	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:n	Lorg/json/JSONArray;
    //   865: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   868: pop
    //   869: aload 10
    //   871: ldc_w 690
    //   874: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload 10
    //   880: aload_1
    //   881: getfield 686	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:n	Lorg/json/JSONArray;
    //   884: invokevirtual 612	org/json/JSONArray:length	()I
    //   887: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: ldc_w 276
    //   894: iconst_2
    //   895: aload 10
    //   897: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   900: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   903: aload_1
    //   904: getfield 686	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:n	Lorg/json/JSONArray;
    //   907: invokevirtual 612	org/json/JSONArray:length	()I
    //   910: istore 8
    //   912: iload 6
    //   914: istore 5
    //   916: iconst_0
    //   917: istore 7
    //   919: iload 8
    //   921: istore 6
    //   923: iload 7
    //   925: iload 6
    //   927: if_icmpge +337 -> 1264
    //   930: aload_1
    //   931: getfield 686	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:n	Lorg/json/JSONArray;
    //   934: iload 7
    //   936: invokevirtual 616	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   939: astore 13
    //   941: aload 13
    //   943: ifnull +312 -> 1255
    //   946: aload 13
    //   948: ldc_w 692
    //   951: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   954: astore 10
    //   956: aload 13
    //   958: ldc_w 694
    //   961: invokevirtual 698	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   964: astore 15
    //   966: aload 15
    //   968: ifnull +287 -> 1255
    //   971: new 80	java/util/ArrayList
    //   974: dup
    //   975: invokespecial 81	java/util/ArrayList:<init>	()V
    //   978: astore 14
    //   980: iconst_0
    //   981: istore 8
    //   983: iload 8
    //   985: aload 15
    //   987: invokevirtual 612	org/json/JSONArray:length	()I
    //   990: if_icmpge +33 -> 1023
    //   993: aload 15
    //   995: iload 8
    //   997: invokevirtual 701	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1000: astore 16
    //   1002: aload 16
    //   1004: invokestatic 704	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1007: ifne +289 -> 1296
    //   1010: aload 14
    //   1012: aload 16
    //   1014: invokeinterface 705 2 0
    //   1019: pop
    //   1020: goto +276 -> 1296
    //   1023: aload 13
    //   1025: ldc_w 628
    //   1028: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1031: invokestatic 633	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   1034: invokevirtual 636	java/lang/Float:floatValue	()F
    //   1037: fstore_2
    //   1038: aload 13
    //   1040: ldc_w 638
    //   1043: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1046: invokestatic 633	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   1049: invokevirtual 636	java/lang/Float:floatValue	()F
    //   1052: fstore_3
    //   1053: aload 13
    //   1055: aload 11
    //   1057: invokevirtual 624	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1060: invokestatic 633	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   1063: invokevirtual 636	java/lang/Float:floatValue	()F
    //   1066: fstore 4
    //   1068: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1071: istore 9
    //   1073: iload 9
    //   1075: ifeq +235 -> 1310
    //   1078: new 264	java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1085: astore 15
    //   1087: aload 15
    //   1089: ldc_w 707
    //   1092: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: aload 15
    //   1098: aload 10
    //   1100: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: pop
    //   1104: ldc_w 276
    //   1107: iconst_2
    //   1108: aload 15
    //   1110: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1113: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1116: goto +3 -> 1119
    //   1119: new 640	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper
    //   1122: dup
    //   1123: invokespecial 641	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper:<init>	()V
    //   1126: astore 15
    //   1128: aload 15
    //   1130: aload 13
    //   1132: invokevirtual 645	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper:fromJSONObject	(Lorg/json/JSONObject;)V
    //   1135: aload 10
    //   1137: aload 14
    //   1139: fload_2
    //   1140: fload_3
    //   1141: fload 4
    //   1143: invokestatic 710	com/tencent/aelight/camera/aioeditor/capture/paster/CaptureComboPasterFactory:a	(Ljava/lang/String;Ljava/util/List;FFF)Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;
    //   1146: astore 13
    //   1148: aload 13
    //   1150: ifnull +20 -> 1170
    //   1153: aload 13
    //   1155: aload 15
    //   1157: invokevirtual 655	com/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase:a	(Lcom/tencent/mobileqq/richmedia/capture/data/SegmentKeeper;)V
    //   1160: aload 12
    //   1162: aload 13
    //   1164: invokevirtual 600	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:c	(Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;)V
    //   1167: goto +88 -> 1255
    //   1170: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1173: ifeq +53 -> 1226
    //   1176: new 264	java/lang/StringBuilder
    //   1179: dup
    //   1180: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1183: astore 13
    //   1185: aload 13
    //   1187: ldc_w 712
    //   1190: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: pop
    //   1194: aload 13
    //   1196: aload 10
    //   1198: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: pop
    //   1202: aload 13
    //   1204: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: astore 10
    //   1209: ldc_w 276
    //   1212: iconst_2
    //   1213: aload 10
    //   1215: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1218: goto +8 -> 1226
    //   1221: astore 10
    //   1223: goto +11 -> 1234
    //   1226: iconst_1
    //   1227: istore 5
    //   1229: goto +26 -> 1255
    //   1232: astore 10
    //   1234: iconst_1
    //   1235: istore 5
    //   1237: goto +10 -> 1247
    //   1240: astore 10
    //   1242: goto +5 -> 1247
    //   1245: astore 10
    //   1247: aload 10
    //   1249: invokevirtual 660	java/lang/Exception:printStackTrace	()V
    //   1252: goto +3 -> 1255
    //   1255: iload 7
    //   1257: iconst_1
    //   1258: iadd
    //   1259: istore 7
    //   1261: goto -338 -> 923
    //   1264: iload 5
    //   1266: ifne +17 -> 1283
    //   1269: aload_0
    //   1270: getfield 54	com/tencent/aelight/camera/aioeditor/capture/data/CaptureComboManager:b	Ljava/util/HashMap;
    //   1273: aload_1
    //   1274: getfield 184	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:a	Ljava/lang/String;
    //   1277: aload 12
    //   1279: invokevirtual 164	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1282: pop
    //   1283: aload 12
    //   1285: astore 10
    //   1287: aload 10
    //   1289: aload_1
    //   1290: putfield 198	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:e	Ljava/lang/Object;
    //   1293: aload 10
    //   1295: areturn
    //   1296: iload 8
    //   1298: iconst_1
    //   1299: iadd
    //   1300: istore 8
    //   1302: goto -319 -> 983
    //   1305: astore 10
    //   1307: goto -60 -> 1247
    //   1310: goto -191 -> 1119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1313	0	this	CaptureComboManager
    //   0	1313	1	paramQIMFilterCategoryItem	QIMFilterCategoryItem
    //   238	902	2	f1	float
    //   253	888	3	f2	float
    //   268	874	4	f3	float
    //   171	1094	5	i1	int
    //   175	753	6	i2	int
    //   168	1092	7	i3	int
    //   165	1136	8	i4	int
    //   1071	3	9	bool	boolean
    //   18	338	10	localObject1	Object
    //   379	1	10	localException1	java.lang.Exception
    //   387	3	10	localException2	java.lang.Exception
    //   472	65	10	str1	String
    //   577	1	10	localException3	java.lang.Exception
    //   585	7	10	localException4	java.lang.Exception
    //   675	77	10	str2	String
    //   792	1	10	localException5	java.lang.Exception
    //   800	3	10	localException6	java.lang.Exception
    //   848	366	10	localObject2	Object
    //   1221	1	10	localException7	java.lang.Exception
    //   1232	1	10	localException8	java.lang.Exception
    //   1240	1	10	localException9	java.lang.Exception
    //   1245	3	10	localException10	java.lang.Exception
    //   1285	9	10	localObject3	Object
    //   1305	1	10	localException11	java.lang.Exception
    //   14	1042	11	localObject4	Object
    //   33	1251	12	localComboSet	ComboSet
    //   74	1129	13	localObject5	Object
    //   193	945	14	localObject6	Object
    //   212	944	15	localObject7	Object
    //   1000	13	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   329	373	379	java/lang/Exception
    //   204	303	387	java/lang/Exception
    //   308	322	387	java/lang/Exception
    //   510	571	577	java/lang/Exception
    //   464	491	585	java/lang/Exception
    //   496	503	585	java/lang/Exception
    //   725	786	792	java/lang/Exception
    //   667	687	800	java/lang/Exception
    //   691	706	800	java/lang/Exception
    //   711	718	800	java/lang/Exception
    //   1209	1218	1221	java/lang/Exception
    //   1170	1209	1232	java/lang/Exception
    //   1087	1116	1240	java/lang/Exception
    //   1119	1148	1240	java/lang/Exception
    //   1153	1167	1240	java/lang/Exception
    //   946	966	1245	java/lang/Exception
    //   971	980	1245	java/lang/Exception
    //   983	1020	1245	java/lang/Exception
    //   1023	1073	1245	java/lang/Exception
    //   1078	1087	1305	java/lang/Exception
  }
  
  public void d()
  {
    this.q.a();
  }
  
  public boolean e()
  {
    synchronized (this.h)
    {
      this.g.addAll(this.h);
      this.h.clear();
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("syncStateAndProgress ");
        ((StringBuilder)???).append(this.g.size());
        QLog.i("QCombo", 2, ((StringBuilder)???).toString());
      }
      boolean bool = false;
      int i1 = this.g.size() - 1;
      while (i1 >= 0)
      {
        Object localObject2 = (QIMFilterCategoryItem)this.g.get(i1);
        ??? = c((QIMFilterCategoryItem)localObject2);
        StringBuilder localStringBuilder;
        if (((CaptureSet)???).b == 1)
        {
          int i2 = ((CaptureSet)???).c();
          if (i2 != ((CaptureSet)???).b)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("buildComboBatch progress: ");
              localStringBuilder.append(((QIMFilterCategoryItem)localObject2).b);
              localStringBuilder.append(", progress: ");
              localStringBuilder.append(((CaptureSet)???).c);
              QLog.d("QCombo", 2, localStringBuilder.toString());
            }
            ((CaptureSet)???).b = i2;
          }
          i2 = (int)(((CaptureSet)???).e() * 10000.0F);
          if (i2 != ((CaptureSet)???).c)
          {
            ((CaptureSet)???).c = i2;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("buildComboBatch progress: ");
              ((StringBuilder)localObject2).append(i2);
              ((StringBuilder)localObject2).append(", progress: ");
              ((StringBuilder)localObject2).append(((CaptureSet)???).c);
              QLog.i("QCombo", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        else if (((CaptureSet)???).b == 2)
        {
          ((CaptureSet)???).c();
          localObject2 = (QIMFilterCategoryItem)this.g.remove(i1);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("removeComboBatch: ");
            localStringBuilder.append(((QIMFilterCategoryItem)localObject2).b);
            localStringBuilder.append(",  STATE_NEED_DOWNLOAD progress: ");
            localStringBuilder.append(((CaptureSet)???).c);
            QLog.i("QCombo", 2, localStringBuilder.toString());
          }
        }
        else
        {
          if (((CaptureSet)???).b != 3) {
            break label530;
          }
          ((CaptureSet)???).c();
          ((CaptureSet)???).c = 10000;
          localObject2 = (QIMFilterCategoryItem)this.g.remove(i1);
          QIMCommonLoadingProgress.a(???).c();
          Message.obtain(this.f, 2, ???).sendToTarget();
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("removeComboBatch: ");
            localStringBuilder.append(((QIMFilterCategoryItem)localObject2).b);
            localStringBuilder.append(", STATE_DOWNLOADED progress: ");
            localStringBuilder.append(((CaptureSet)???).c);
            QLog.i("QCombo", 2, localStringBuilder.toString());
          }
        }
        bool = true;
        label530:
        i1 -= 1;
      }
      return bool;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public VideoFilterTools.DataSet f()
  {
    if (this.l != null)
    {
      if (AEDashboardUtil.d()) {
        return this.l.e;
      }
      return this.l.d;
    }
    return null;
  }
  
  public void h()
  {
    VideoFilterTools.ComboFilterData localComboFilterData = this.l;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("randomliseData ");
      localStringBuilder.append(localComboFilterData);
      QLog.d("QCombo", 2, localStringBuilder.toString());
    }
    if (localComboFilterData != null)
    {
      localComboFilterData.b();
      a(localComboFilterData);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return a(paramMessage);
  }
  
  public ComboLockManager i()
  {
    return this.q;
  }
  
  public boolean isValidate()
  {
    return false;
  }
  
  public boolean j()
  {
    return this.r;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager
 * JD-Core Version:    0.7.0.1
 */