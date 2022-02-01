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
  public static final SparseArray<ConcurrentHashMap<String, QIMCommonLoadingProgress>> a;
  public static final AccelerateInterpolator a;
  public static final ConcurrentHashMap<String, QIMCommonLoadingProgress> a;
  public byte a;
  float jdField_a_of_type_Float = 1.0F;
  long jdField_a_of_type_Long;
  public ArrayList<WeakReference<QIMCommonLoadingProgress.Observer>> a;
  long b = 0L;
  long c = 0L;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator = new AccelerateInterpolator();
  }
  
  public QIMCommonLoadingProgress()
  {
    this.jdField_a_of_type_Byte = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  static QIMCommonLoadingProgress a(int paramInt, String paramString)
  {
    Object localObject2 = (ConcurrentHashMap)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ConcurrentHashMap(50);
      jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
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
      return a(1, ((ComboSet)paramObject).a());
    }
    if ((paramObject instanceof PtvTemplateInfo)) {
      return a(3, ((PtvTemplateInfo)paramObject).a);
    }
    if ((paramObject instanceof MusicItemInfo)) {
      return a(2, ((MusicItemInfo)paramObject).mMusicName);
    }
    if ((paramObject instanceof FilterSet)) {
      return a(4, ((FilterSet)paramObject).a());
    }
    return null;
  }
  
  public float a()
  {
    int i = this.jdField_a_of_type_Byte;
    long l;
    float f1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          if (this.c == 0L)
          {
            this.c = SystemClock.elapsedRealtime();
          }
          else
          {
            l = SystemClock.elapsedRealtime() - this.c;
            if (l > 1L) {
              this.jdField_a_of_type_Float = 0.0F;
            }
            this.jdField_a_of_type_Float *= (1.0F - (float)l * 1.0F / 1.0F);
          }
        }
      }
      else
      {
        if (this.jdField_a_of_type_Long == 0L) {
          return 0.0F;
        }
        float f2 = (float)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
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
        this.jdField_a_of_type_Float = f1;
      }
    }
    else if (this.b == 0L)
    {
      this.b = SystemClock.elapsedRealtime();
    }
    else
    {
      l = SystemClock.elapsedRealtime() - this.b;
      if (l > 1L)
      {
        this.jdField_a_of_type_Float = 1.0F;
      }
      else
      {
        f1 = this.jdField_a_of_type_Float;
        this.jdField_a_of_type_Float = (f1 + (1.0F - f1) * jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator.getInterpolation((float)l * 1.0F / 1.0F));
      }
    }
    return this.jdField_a_of_type_Float;
  }
  
  public void a()
  {
    float f = this.jdField_a_of_type_Float;
    if ((f == 0.0F) || (f == 1.0F))
    {
      this.jdField_a_of_type_Byte = 2;
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.b = 0L;
      this.c = 0L;
      this.jdField_a_of_type_Float = 0.01F;
      a(0.01F);
    }
  }
  
  public void a(float paramFloat)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i >= 0)
    {
      QIMCommonLoadingProgress.Observer localObserver = (QIMCommonLoadingProgress.Observer)((WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get();
      if (localObserver == null) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      } else {
        localObserver.a();
      }
      i -= 1;
    }
  }
  
  public void a(QIMCommonLoadingProgress.Observer paramObserver)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i >= 0)
    {
      QIMCommonLoadingProgress.Observer localObserver = (QIMCommonLoadingProgress.Observer)((WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get();
      if ((localObserver == null) || (localObserver == paramObserver)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
      i -= 1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Byte = 1;
  }
  
  public void b(QIMCommonLoadingProgress.Observer paramObserver)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramObserver));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Byte = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingProgress
 * JD-Core Version:    0.7.0.1
 */