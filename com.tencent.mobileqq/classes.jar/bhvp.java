import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

final class bhvp
{
  private static final Comparator<bhvr> jdField_a_of_type_JavaUtilComparator = new bhvq();
  @Nullable
  final TimingLogger jdField_a_of_type_AndroidUtilTimingLogger = null;
  final List<bhvy> jdField_a_of_type_JavaUtilList;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[3];
  final int[] jdField_a_of_type_ArrayOfInt;
  @Nullable
  final bhvx[] jdField_a_of_type_ArrayOfBhvx;
  final int[] b;
  
  bhvp(int[] paramArrayOfInt, int paramInt, @Nullable bhvx[] paramArrayOfbhvx)
  {
    this.jdField_a_of_type_ArrayOfBhvx = paramArrayOfbhvx;
    paramArrayOfbhvx = new int[32768];
    this.b = paramArrayOfbhvx;
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      j = d(paramArrayOfInt[i]);
      paramArrayOfInt[i] = j;
      paramArrayOfbhvx[j] += 1;
      i += 1;
    }
    int j = 0;
    for (i = 0; j < paramArrayOfbhvx.length; i = k)
    {
      if ((paramArrayOfbhvx[j] > 0) && (a(j))) {
        paramArrayOfbhvx[j] = 0;
      }
      k = i;
      if (paramArrayOfbhvx[j] > 0) {
        k = i + 1;
      }
      j += 1;
    }
    paramArrayOfInt = new int[i];
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    j = 0;
    int m;
    for (int k = 0; j < paramArrayOfbhvx.length; k = m)
    {
      m = k;
      if (paramArrayOfbhvx[j] > 0)
      {
        paramArrayOfInt[k] = j;
        m = k + 1;
      }
      j += 1;
    }
    if (i <= paramInt)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      i = paramArrayOfInt.length;
      paramInt = n;
      while (paramInt < i)
      {
        j = paramArrayOfInt[paramInt];
        this.jdField_a_of_type_JavaUtilList.add(new bhvy(e(j), paramArrayOfbhvx[j]));
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_JavaUtilList = a(paramInt);
  }
  
  static int a(int paramInt)
  {
    return paramInt >> 10 & 0x1F;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Color.rgb(b(paramInt1, 5, 8), b(paramInt2, 5, 8), b(paramInt3, 5, 8));
  }
  
  private List<bhvy> a(int paramInt)
  {
    PriorityQueue localPriorityQueue = new PriorityQueue(paramInt, jdField_a_of_type_JavaUtilComparator);
    localPriorityQueue.offer(new bhvr(this, 0, this.jdField_a_of_type_ArrayOfInt.length - 1));
    a(localPriorityQueue, paramInt);
    return a(localPriorityQueue);
  }
  
  private List<bhvy> a(Collection<bhvr> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      bhvy localbhvy = ((bhvr)paramCollection.next()).a();
      if (!a(localbhvy)) {
        localArrayList.add(localbhvy);
      }
    }
    return localArrayList;
  }
  
  private void a(PriorityQueue<bhvr> paramPriorityQueue, int paramInt)
  {
    while (paramPriorityQueue.size() < paramInt)
    {
      bhvr localbhvr = (bhvr)paramPriorityQueue.poll();
      if ((localbhvr == null) || (!localbhvr.a())) {
        break;
      }
      paramPriorityQueue.offer(localbhvr.a());
      paramPriorityQueue.offer(localbhvr);
    }
  }
  
  static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      int j;
      while (i <= paramInt3)
      {
        paramInt1 = paramArrayOfInt[i];
        paramInt2 = b(paramInt1);
        j = a(paramInt1);
        paramArrayOfInt[i] = (c(paramInt1) | paramInt2 << 10 | j << 5);
        i += 1;
      }
      while (paramInt2 <= paramInt3)
      {
        paramInt1 = paramArrayOfInt[paramInt2];
        i = c(paramInt1);
        j = b(paramInt1);
        paramArrayOfInt[paramInt2] = (a(paramInt1) | i << 10 | j << 5);
        paramInt2 += 1;
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    paramInt = e(paramInt);
    bhvs.a(paramInt, this.jdField_a_of_type_ArrayOfFloat);
    return a(paramInt, this.jdField_a_of_type_ArrayOfFloat);
  }
  
  private boolean a(int paramInt, float[] paramArrayOfFloat)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (this.jdField_a_of_type_ArrayOfBhvx != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ArrayOfBhvx.length > 0)
      {
        j = this.jdField_a_of_type_ArrayOfBhvx.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (!this.jdField_a_of_type_ArrayOfBhvx[i].a(paramInt, paramArrayOfFloat)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean a(bhvy parambhvy)
  {
    return a(parambhvy.a(), parambhvy.a());
  }
  
  static int b(int paramInt)
  {
    return paramInt >> 5 & 0x1F;
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > paramInt2) {
      paramInt1 <<= paramInt3 - paramInt2;
    }
    for (;;)
    {
      return paramInt1 & (1 << paramInt3) - 1;
      paramInt1 >>= paramInt2 - paramInt3;
    }
  }
  
  static int c(int paramInt)
  {
    return paramInt & 0x1F;
  }
  
  private static int d(int paramInt)
  {
    return b(Color.red(paramInt), 8, 5) << 10 | b(Color.green(paramInt), 8, 5) << 5 | b(Color.blue(paramInt), 8, 5);
  }
  
  private static int e(int paramInt)
  {
    return a(a(paramInt), b(paramInt), c(paramInt));
  }
  
  List<bhvy> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvp
 * JD-Core Version:    0.7.0.1
 */