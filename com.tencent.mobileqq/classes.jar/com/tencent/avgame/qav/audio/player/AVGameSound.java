package com.tencent.avgame.qav.audio.player;

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
    paramFloat1 = a(paramFloat1 * 1.0F, 0.5F, 2.0F);
    Object localObject = this.jdField_a_of_type_AndroidMediaSoundPool;
    f2 = a(f2 * paramFloat3 * (1.0F - f3), 0.0F, 1.0F);
    paramFloat2 = a(f1 * paramFloat3 * (1.0F - paramFloat2), 0.0F, 1.0F);
    int i;
    if (paramBoolean) {
      i = -1;
    } else {
      i = 0;
    }
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
  
  /* Error */
  public int a(String paramString, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/tencent/avgame/qav/audio/player/AVGameSound:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: aload_1
    //   5: invokevirtual 69	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast 78	java/lang/Integer
    //   11: astore 7
    //   13: aload 7
    //   15: ifnull +20 -> 35
    //   18: aload_0
    //   19: aload_1
    //   20: aload 7
    //   22: invokevirtual 106	java/lang/Integer:intValue	()I
    //   25: iload_2
    //   26: fload_3
    //   27: fload 4
    //   29: fload 5
    //   31: invokespecial 50	com/tencent/avgame/qav/audio/player/AVGameSound:a	(Ljava/lang/String;IZFFF)I
    //   34: ireturn
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 111	com/tencent/avgame/qav/audio/player/AVGameSound:a	(Ljava/lang/String;)I
    //   40: invokestatic 82	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: astore 7
    //   45: aload 7
    //   47: invokevirtual 106	java/lang/Integer:intValue	()I
    //   50: iconst_m1
    //   51: if_icmpne +5 -> 56
    //   54: iconst_m1
    //   55: ireturn
    //   56: new 113	com/tencent/avgame/qav/audio/player/AVGameSound$SoundInfoForLoadedCompleted
    //   59: dup
    //   60: aload_1
    //   61: iload_2
    //   62: fload_3
    //   63: fload 4
    //   65: fload 5
    //   67: invokespecial 116	com/tencent/avgame/qav/audio/player/AVGameSound$SoundInfoForLoadedCompleted:<init>	(Ljava/lang/String;ZFFF)V
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 33	com/tencent/avgame/qav/audio/player/AVGameSound:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   75: aload 7
    //   77: aload_1
    //   78: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:putIfAbsent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: aload_1
    //   83: monitorenter
    //   84: aload_1
    //   85: getstatic 121	com/tencent/avgame/qav/audio/player/AVGameSound:jdField_a_of_type_Int	I
    //   88: i2l
    //   89: invokevirtual 125	java/lang/Object:wait	(J)V
    //   92: goto +15 -> 107
    //   95: astore 7
    //   97: goto +31 -> 128
    //   100: astore 8
    //   102: aload 8
    //   104: invokevirtual 128	java/lang/Exception:printStackTrace	()V
    //   107: aload_1
    //   108: monitorexit
    //   109: aload_1
    //   110: getfield 129	com/tencent/avgame/qav/audio/player/AVGameSound$SoundInfoForLoadedCompleted:jdField_a_of_type_Int	I
    //   113: istore 6
    //   115: aload_0
    //   116: getfield 33	com/tencent/avgame/qav/audio/player/AVGameSound:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   119: aload 7
    //   121: invokevirtual 132	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: pop
    //   125: iload 6
    //   127: ireturn
    //   128: aload_1
    //   129: monitorexit
    //   130: aload 7
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	AVGameSound
    //   0	133	1	paramString	String
    //   0	133	2	paramBoolean	boolean
    //   0	133	3	paramFloat1	float
    //   0	133	4	paramFloat2	float
    //   0	133	5	paramFloat3	float
    //   113	13	6	i	int
    //   11	65	7	localInteger	Integer
    //   95	36	7	localObject	Object
    //   100	3	8	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   84	92	95	finally
    //   102	107	95	finally
    //   107	109	95	finally
    //   128	130	95	finally
    //   84	92	100	java/lang/Exception
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
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() == 0) {
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
  }
  
  public int b(String paramString)
  {
    int i;
    try
    {
      i = this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString, 0);
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[createSoundIDFromAsset] error: ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("AVGameSound", 1, localStringBuilder.toString(), paramString);
      i = -1;
    }
    int j = i;
    if (i == 0) {
      j = -1;
    }
    return j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.player.AVGameSound
 * JD-Core Version:    0.7.0.1
 */