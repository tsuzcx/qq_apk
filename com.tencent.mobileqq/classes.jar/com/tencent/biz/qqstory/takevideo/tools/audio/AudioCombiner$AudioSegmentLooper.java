package com.tencent.biz.qqstory.takevideo.tools.audio;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zbf;
import zbg;

class AudioCombiner$AudioSegmentLooper
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  
  private byte[] a(List<byte[]> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    int m = paramList.size();
    if (paramList.size() == 1) {
      return (byte[])paramList.get(0);
    }
    byte[] arrayOfByte1 = new byte[paramInt];
    int k = paramInt / 2;
    short[][] arrayOfShort = (short[][])Array.newInstance(Short.TYPE, new int[] { m, k });
    paramInt = 0;
    int i;
    while (paramInt < m)
    {
      byte[] arrayOfByte2 = (byte[])paramList.get(paramInt);
      i = 0;
      if (i < k)
      {
        if (i * 2 + 1 < arrayOfByte2.length) {
          arrayOfShort[paramInt][i] = ((short)(arrayOfByte2[(i * 2)] & 0xFF | (arrayOfByte2[(i * 2 + 1)] & 0xFF) << 8));
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfShort[paramInt][i] = 0;
        }
      }
      paramInt += 1;
    }
    paramList = new short[k];
    int j = 0;
    while (j < k)
    {
      i = 0;
      int n;
      for (paramInt = 0; i < m; paramInt = n + paramInt)
      {
        n = arrayOfShort[i][j];
        i += 1;
      }
      i = paramInt;
      if (paramInt > 32767) {
        i = 32767;
      }
      paramInt = i;
      if (i < -32768) {
        paramInt = -32768;
      }
      paramList[j] = ((short)paramInt);
      j += 1;
    }
    paramInt = 0;
    while (paramInt < k)
    {
      arrayOfByte1[(paramInt * 2)] = ((byte)(paramList[paramInt] & 0xFF));
      arrayOfByte1[(paramInt * 2 + 1)] = ((byte)((paramList[paramInt] & 0xFF00) >> 8));
      paramInt += 1;
    }
    return arrayOfByte1;
  }
  
  public void run()
  {
    if (AudioCombiner.a(this.this$0) == null) {
      return;
    }
    AudioCombiner.a(this.this$0, SystemClock.elapsedRealtime());
    long l;
    ArrayList localArrayList;
    int i;
    if ((this.jdField_a_of_type_Int < AudioCombiner.a(this.this$0)) && (this.jdField_a_of_type_Boolean))
    {
      l = SystemClock.elapsedRealtime();
      localArrayList = new ArrayList();
      i = 0;
    }
    label424:
    for (;;)
    {
      for (;;)
      {
        synchronized (this.this$0)
        {
          Iterator localIterator2 = AudioCombiner.a(this.this$0).iterator();
          if (localIterator2.hasNext())
          {
            byte[] arrayOfByte = ((zbf)localIterator2.next()).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + AudioCombiner.b(this.this$0));
            if (arrayOfByte == null) {
              continue;
            }
            if (arrayOfByte.length <= i) {
              break label424;
            }
            i = arrayOfByte.length;
            localArrayList.add(arrayOfByte);
            continue;
          }
          ??? = a(localArrayList, i);
          if (AudioCombiner.a(this.this$0) != null) {
            AudioCombiner.a(this.this$0).a((byte[])???, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + AudioCombiner.b(this.this$0));
          }
          localArrayList.clear();
          System.gc();
          l = SystemClock.elapsedRealtime() - l;
          if (QLog.isColorLevel()) {
            QLog.d("AudioCombiner", 2, "cost : " + l);
          }
          if (l >= AudioCombiner.b(this.this$0)) {}
        }
        try
        {
          Thread.sleep(AudioCombiner.b(this.this$0) - l);
          this.jdField_a_of_type_Int += AudioCombiner.b(this.this$0);
          break;
          localObject1 = finally;
          throw localObject1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AudioCombiner", 2, "combiner has been Interrupted");
            }
          }
        }
      }
      Iterator localIterator1 = AudioCombiner.a(this.this$0).iterator();
      while (localIterator1.hasNext()) {
        ((zbf)localIterator1.next()).a();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AudioCombiner", 2, "audio combiner has finished. curTime : " + this.jdField_a_of_type_Int + "  duration : " + AudioCombiner.a(this.this$0) + "  isRun : " + this.jdField_a_of_type_Boolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tools.audio.AudioCombiner.AudioSegmentLooper
 * JD-Core Version:    0.7.0.1
 */