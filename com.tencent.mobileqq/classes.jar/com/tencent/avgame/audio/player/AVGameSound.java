package com.tencent.avgame.audio.player;

import android.media.SoundPool;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AVGameSound
{
  private static int jdField_a_of_type_Int = 500;
  private float jdField_a_of_type_Float;
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private final HashMap<String, ArrayList<Integer>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ConcurrentHashMap<Integer, AVGameSound.SoundInfoForLoadedCompleted> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private float jdField_b_of_type_Float;
  private final HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  public AVGameSound()
  {
    e();
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
  }
  
  private int a(String paramString, int paramInt, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f2 = this.jdField_a_of_type_Float;
    float f3 = a(paramFloat2, 0.0F, 1.0F);
    float f1 = this.jdField_b_of_type_Float;
    paramFloat2 = a(-paramFloat2, 0.0F, 1.0F);
    paramFloat1 = a(1.0F * paramFloat1, 0.5F, 2.0F);
    Object localObject = this.jdField_a_of_type_AndroidMediaSoundPool;
    f2 = a((1.0F - f3) * (f2 * paramFloat3), 0.0F, 1.0F);
    paramFloat2 = a(f1 * paramFloat3 * (1.0F - paramFloat2), 0.0F, 1.0F);
    if (paramBoolean) {}
    for (int i = -1;; i = 0)
    {
      paramInt = ((SoundPool)localObject).play(paramInt, f2, paramFloat2, 1, i, paramFloat1);
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      localObject = localArrayList;
      if (localArrayList == null)
      {
        localObject = new ArrayList();
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
      }
      ((ArrayList)localObject).add(Integer.valueOf(paramInt));
      return paramInt;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(5, 3, 5);
    this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new AVGameSound.OnLoadCompletedListener(this));
    this.jdField_a_of_type_Float = 0.5F;
    this.jdField_b_of_type_Float = 0.5F;
  }
  
  public int a(String paramString)
  {
    Integer localInteger2 = (Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger2 = Integer.valueOf(b(paramString));
      localInteger1 = localInteger2;
      if (localInteger2.intValue() != -1)
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, localInteger2);
        localInteger1 = localInteger2;
      }
    }
    return localInteger1.intValue();
  }
  
  public int a(String paramString, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Integer localInteger = (Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if (localInteger != null) {
      return a(paramString, localInteger.intValue(), paramBoolean, paramFloat1, paramFloat2, paramFloat3);
    }
    localInteger = Integer.valueOf(a(paramString));
    if (localInteger.intValue() == -1) {
      return -1;
    }
    paramString = new AVGameSound.SoundInfoForLoadedCompleted(paramString, paramBoolean, paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(localInteger, paramString);
    try
    {
      paramString.wait(jdField_a_of_type_Int);
      int i = paramString.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localInteger);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          int i = ((Integer)localIterator2.next()).intValue();
          this.jdField_a_of_type_AndroidMediaSoundPool.pause(i);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      this.jdField_a_of_type_AndroidMediaSoundPool.stop(localInteger.intValue());
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public int b(String paramString)
  {
    int i;
    try
    {
      i = this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString, 0);
      if (i == 0) {
        return -1;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("AVGameSound", 1, "[createSoundIDFromAsset] error: " + paramString.getMessage(), paramString);
        i = -1;
      }
    }
    return i;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          int i = ((Integer)localIterator2.next()).intValue();
          this.jdField_a_of_type_AndroidMediaSoundPool.resume(i);
        }
      }
    }
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          int i = ((Integer)localIterator2.next()).intValue();
          this.jdField_a_of_type_AndroidMediaSoundPool.stop(i);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidMediaSoundPool.release();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Float = 0.5F;
    this.jdField_b_of_type_Float = 0.5F;
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.audio.player.AVGameSound
 * JD-Core Version:    0.7.0.1
 */