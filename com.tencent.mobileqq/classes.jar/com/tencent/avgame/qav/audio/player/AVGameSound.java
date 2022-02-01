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
  private static int g = 500;
  private SoundPool a;
  private float b;
  private float c;
  private final HashMap<String, ArrayList<Integer>> d = new HashMap();
  private final HashMap<String, Integer> e = new HashMap();
  private ConcurrentHashMap<Integer, AVGameSound.SoundInfoForLoadedCompleted> f = new ConcurrentHashMap();
  
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
    float f2 = this.b;
    float f3 = a(paramFloat2, 0.0F, 1.0F);
    float f1 = this.c;
    paramFloat2 = a(-paramFloat2, 0.0F, 1.0F);
    paramFloat1 = a(paramFloat1 * 1.0F, 0.5F, 2.0F);
    Object localObject = this.a;
    f2 = a(f2 * paramFloat3 * (1.0F - f3), 0.0F, 1.0F);
    paramFloat2 = a(f1 * paramFloat3 * (1.0F - paramFloat2), 0.0F, 1.0F);
    int i;
    if (paramBoolean) {
      i = -1;
    } else {
      i = 0;
    }
    paramInt = ((SoundPool)localObject).play(paramInt, f2, paramFloat2, 1, i, paramFloat1);
    ArrayList localArrayList = (ArrayList)this.d.get(paramString);
    localObject = localArrayList;
    if (localArrayList == null)
    {
      localObject = new ArrayList();
      this.d.put(paramString, localObject);
    }
    ((ArrayList)localObject).add(Integer.valueOf(paramInt));
    return paramInt;
  }
  
  private void e()
  {
    this.a = new SoundPool(5, 3, 5);
    this.a.setOnLoadCompleteListener(new AVGameSound.OnLoadCompletedListener(this));
    this.b = 0.5F;
    this.c = 0.5F;
  }
  
  public int a(String paramString)
  {
    Integer localInteger2 = (Integer)this.e.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger2 = Integer.valueOf(c(paramString));
      localInteger1 = localInteger2;
      if (localInteger2.intValue() != -1)
      {
        this.e.put(paramString, localInteger2);
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
    //   1: getfield 33	com/tencent/avgame/qav/audio/player/AVGameSound:e	Ljava/util/HashMap;
    //   4: aload_1
    //   5: invokevirtual 73	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast 82	java/lang/Integer
    //   11: astore 7
    //   13: aload 7
    //   15: ifnull +20 -> 35
    //   18: aload_0
    //   19: aload_1
    //   20: aload 7
    //   22: invokevirtual 110	java/lang/Integer:intValue	()I
    //   25: iload_2
    //   26: fload_3
    //   27: fload 4
    //   29: fload 5
    //   31: invokespecial 54	com/tencent/avgame/qav/audio/player/AVGameSound:a	(Ljava/lang/String;IZFFF)I
    //   34: ireturn
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 115	com/tencent/avgame/qav/audio/player/AVGameSound:a	(Ljava/lang/String;)I
    //   40: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: astore 7
    //   45: aload 7
    //   47: invokevirtual 110	java/lang/Integer:intValue	()I
    //   50: iconst_m1
    //   51: if_icmpne +5 -> 56
    //   54: iconst_m1
    //   55: ireturn
    //   56: new 117	com/tencent/avgame/qav/audio/player/AVGameSound$SoundInfoForLoadedCompleted
    //   59: dup
    //   60: aload_1
    //   61: iload_2
    //   62: fload_3
    //   63: fload 4
    //   65: fload 5
    //   67: invokespecial 120	com/tencent/avgame/qav/audio/player/AVGameSound$SoundInfoForLoadedCompleted:<init>	(Ljava/lang/String;ZFFF)V
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 38	com/tencent/avgame/qav/audio/player/AVGameSound:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   75: aload 7
    //   77: aload_1
    //   78: invokevirtual 123	java/util/concurrent/ConcurrentHashMap:putIfAbsent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: aload_1
    //   83: monitorenter
    //   84: aload_1
    //   85: getstatic 125	com/tencent/avgame/qav/audio/player/AVGameSound:g	I
    //   88: i2l
    //   89: invokevirtual 129	java/lang/Object:wait	(J)V
    //   92: goto +15 -> 107
    //   95: astore 7
    //   97: goto +31 -> 128
    //   100: astore 8
    //   102: aload 8
    //   104: invokevirtual 132	java/lang/Exception:printStackTrace	()V
    //   107: aload_1
    //   108: monitorexit
    //   109: aload_1
    //   110: getfield 134	com/tencent/avgame/qav/audio/player/AVGameSound$SoundInfoForLoadedCompleted:f	I
    //   113: istore 6
    //   115: aload_0
    //   116: getfield 38	com/tencent/avgame/qav/audio/player/AVGameSound:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   119: aload 7
    //   121: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
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
    if (!this.d.isEmpty())
    {
      Iterator localIterator1 = this.d.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          int i = ((Integer)localIterator2.next()).intValue();
          this.a.pause(i);
        }
      }
    }
  }
  
  public void b()
  {
    if (!this.d.isEmpty())
    {
      Iterator localIterator1 = this.d.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          int i = ((Integer)localIterator2.next()).intValue();
          this.a.resume(i);
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = (ArrayList)this.d.get(paramString);
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() == 0) {
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        this.a.stop(localInteger.intValue());
      }
      this.d.remove(paramString);
    }
  }
  
  public int c(String paramString)
  {
    int i;
    try
    {
      i = this.a.load(paramString, 0);
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
  
  public void c()
  {
    if (!this.d.isEmpty())
    {
      Iterator localIterator1 = this.d.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          int i = ((Integer)localIterator2.next()).intValue();
          this.a.stop(i);
        }
      }
    }
    this.d.clear();
  }
  
  public void d()
  {
    this.a.release();
    this.d.clear();
    this.e.clear();
    this.f.clear();
    this.b = 0.5F;
    this.c = 0.5F;
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.player.AVGameSound
 * JD-Core Version:    0.7.0.1
 */