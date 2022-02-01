package com.tencent.aelight.camera.aioeditor.capture.view;

import android.os.SystemClock;
import android.util.SparseArray;
import android.view.animation.AccelerateInterpolator;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class QIMCommonLoadingProgress
{
  public static final ConcurrentHashMap<String, QIMCommonLoadingProgress> a = new ConcurrentHashMap();
  public static final SparseArray<ConcurrentHashMap<String, QIMCommonLoadingProgress>> b = new SparseArray(3);
  public static final AccelerateInterpolator c = new AccelerateInterpolator();
  public byte d = 1;
  long e;
  long f = 0L;
  long g = 0L;
  float h = 1.0F;
  public ArrayList<WeakReference<QIMCommonLoadingProgress.Observer>> i = new ArrayList();
  
  static QIMCommonLoadingProgress a(int paramInt, String paramString)
  {
    Object localObject2 = (ConcurrentHashMap)b.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ConcurrentHashMap(50);
      b.put(paramInt, localObject1);
    }
    QIMCommonLoadingProgress localQIMCommonLoadingProgress = (QIMCommonLoadingProgress)((ConcurrentHashMap)localObject1).get(paramString);
    localObject2 = localQIMCommonLoadingProgress;
    if (localQIMCommonLoadingProgress == null)
    {
      localObject2 = new QIMCommonLoadingProgress();
      ((ConcurrentHashMap)localObject1).put(paramString, localObject2);
    }
    return localObject2;
  }
  
  public static QIMCommonLoadingProgress a(Object paramObject)
  {
    if ((paramObject instanceof ComboSet)) {
      return a(1, ((ComboSet)paramObject).f());
    }
    if ((paramObject instanceof PtvTemplateInfo)) {
      return a(3, ((PtvTemplateInfo)paramObject).a);
    }
    if ((paramObject instanceof MusicItemInfo)) {
      return a(2, ((MusicItemInfo)paramObject).mMusicName);
    }
    if ((paramObject instanceof FilterSet)) {
      return a(4, ((FilterSet)paramObject).f());
    }
    return null;
  }
  
  public void a()
  {
    float f1 = this.h;
    if ((f1 == 0.0F) || (f1 == 1.0F))
    {
      this.d = 2;
      this.e = SystemClock.elapsedRealtime();
      this.f = 0L;
      this.g = 0L;
      this.h = 0.01F;
      a(0.01F);
    }
  }
  
  public void a(float paramFloat)
  {
    int j = this.i.size() - 1;
    while (j >= 0)
    {
      QIMCommonLoadingProgress.Observer localObserver = (QIMCommonLoadingProgress.Observer)((WeakReference)this.i.get(j)).get();
      if (localObserver == null) {
        this.i.remove(j);
      } else {
        localObserver.a();
      }
      j -= 1;
    }
  }
  
  public void a(QIMCommonLoadingProgress.Observer paramObserver)
  {
    int j = this.i.size() - 1;
    while (j >= 0)
    {
      QIMCommonLoadingProgress.Observer localObserver = (QIMCommonLoadingProgress.Observer)((WeakReference)this.i.get(j)).get();
      if ((localObserver == null) || (localObserver == paramObserver)) {
        this.i.remove(j);
      }
      j -= 1;
    }
  }
  
  public float b()
  {
    int j = this.d;
    long l;
    float f1;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j == 3) {
          if (this.g == 0L)
          {
            this.g = SystemClock.elapsedRealtime();
          }
          else
          {
            l = SystemClock.elapsedRealtime() - this.g;
            if (l > 1L) {
              this.h = 0.0F;
            }
            this.h *= (1.0F - (float)l * 1.0F / 1.0F);
          }
        }
      }
      else
      {
        if (this.e == 0L) {
          return 0.0F;
        }
        float f2 = (float)(SystemClock.elapsedRealtime() - this.e);
        f1 = 0.01F;
        if (f2 > 4250.0F)
        {
          f1 = 0.85F;
        }
        else
        {
          f2 = f2 * 1.0F / 5000.0F;
          if (f2 >= 0.01F) {
            f1 = f2;
          }
        }
        this.h = f1;
      }
    }
    else if (this.f == 0L)
    {
      this.f = SystemClock.elapsedRealtime();
    }
    else
    {
      l = SystemClock.elapsedRealtime() - this.f;
      if (l > 1L)
      {
        this.h = 1.0F;
      }
      else
      {
        f1 = this.h;
        this.h = (f1 + (1.0F - f1) * c.getInterpolation((float)l * 1.0F / 1.0F));
      }
    }
    return this.h;
  }
  
  public void b(QIMCommonLoadingProgress.Observer paramObserver)
  {
    this.i.add(new WeakReference(paramObserver));
  }
  
  public void c()
  {
    this.d = 1;
  }
  
  public void d()
  {
    this.d = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingProgress
 * JD-Core Version:    0.7.0.1
 */