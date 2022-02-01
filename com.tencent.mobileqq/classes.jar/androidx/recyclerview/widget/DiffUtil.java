package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiffUtil
{
  private static final Comparator<DiffUtil.Snake> SNAKE_COMPARATOR = new DiffUtil.1();
  
  @NonNull
  public static DiffUtil.DiffResult calculateDiff(@NonNull DiffUtil.Callback paramCallback)
  {
    return calculateDiff(paramCallback, true);
  }
  
  @NonNull
  public static DiffUtil.DiffResult calculateDiff(@NonNull DiffUtil.Callback paramCallback, boolean paramBoolean)
  {
    int i = paramCallback.getOldListSize();
    int j = paramCallback.getNewListSize();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new DiffUtil.Range(0, i, 0, j));
    i = Math.abs(i - j) + (i + j);
    j = i * 2;
    int[] arrayOfInt1 = new int[j];
    int[] arrayOfInt2 = new int[j];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      DiffUtil.Range localRange2 = (DiffUtil.Range)localArrayList2.remove(localArrayList2.size() - 1);
      DiffUtil.Snake localSnake = diffPartial(paramCallback, localRange2.oldListStart, localRange2.oldListEnd, localRange2.newListStart, localRange2.newListEnd, arrayOfInt1, arrayOfInt2, i);
      if (localSnake != null)
      {
        if (localSnake.size > 0) {
          localArrayList1.add(localSnake);
        }
        localSnake.x += localRange2.oldListStart;
        localSnake.y += localRange2.newListStart;
        DiffUtil.Range localRange1;
        if (localArrayList3.isEmpty()) {
          localRange1 = new DiffUtil.Range();
        } else {
          localRange1 = (DiffUtil.Range)localArrayList3.remove(localArrayList3.size() - 1);
        }
        localRange1.oldListStart = localRange2.oldListStart;
        localRange1.newListStart = localRange2.newListStart;
        if (localSnake.reverse)
        {
          localRange1.oldListEnd = localSnake.x;
          localRange1.newListEnd = localSnake.y;
        }
        else if (localSnake.removal)
        {
          localRange1.oldListEnd = (localSnake.x - 1);
          localRange1.newListEnd = localSnake.y;
        }
        else
        {
          localRange1.oldListEnd = localSnake.x;
          localRange1.newListEnd = (localSnake.y - 1);
        }
        localArrayList2.add(localRange1);
        if (localSnake.reverse)
        {
          if (localSnake.removal)
          {
            localRange2.oldListStart = (localSnake.x + localSnake.size + 1);
            localRange2.newListStart = (localSnake.y + localSnake.size);
          }
          else
          {
            localRange2.oldListStart = (localSnake.x + localSnake.size);
            localRange2.newListStart = (localSnake.y + localSnake.size + 1);
          }
        }
        else
        {
          localRange2.oldListStart = (localSnake.x + localSnake.size);
          localRange2.newListStart = (localSnake.y + localSnake.size);
        }
        localArrayList2.add(localRange2);
      }
      else
      {
        localArrayList3.add(localRange2);
      }
    }
    Collections.sort(localArrayList1, SNAKE_COMPARATOR);
    return new DiffUtil.DiffResult(paramCallback, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static DiffUtil.Snake diffPartial(DiffUtil.Callback paramCallback, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    paramInt2 -= paramInt1;
    int i1 = paramInt4 - paramInt3;
    if ((paramInt2 >= 1) && (i1 >= 1))
    {
      int i2 = paramInt2 - i1;
      int i3 = (paramInt2 + i1 + 1) / 2;
      paramInt4 = paramInt5 - i3 - 1;
      int i = paramInt5 + i3 + 1;
      Arrays.fill(paramArrayOfInt1, paramInt4, i, 0);
      Arrays.fill(paramArrayOfInt2, paramInt4 + i2, i + i2, paramInt2);
      if (i2 % 2 != 0) {
        i = 1;
      } else {
        i = 0;
      }
      int j = 0;
      while (j <= i3)
      {
        int k = -j;
        int m = k;
        boolean bool;
        label202:
        int n;
        while (m <= j)
        {
          if (m != k) {
            if (m != j)
            {
              paramInt4 = paramInt5 + m;
              if (paramArrayOfInt1[(paramInt4 - 1)] < paramArrayOfInt1[(paramInt4 + 1)]) {}
            }
            else
            {
              paramInt4 = paramArrayOfInt1[(paramInt5 + m - 1)] + 1;
              bool = true;
              break label202;
            }
          }
          paramInt4 = paramArrayOfInt1[(paramInt5 + m + 1)];
          bool = false;
          n = paramInt4 - m;
          while ((paramInt4 < paramInt2) && (n < i1) && (paramCallback.areItemsTheSame(paramInt1 + paramInt4, paramInt3 + n)))
          {
            paramInt4 += 1;
            n += 1;
          }
          n = paramInt5 + m;
          paramArrayOfInt1[n] = paramInt4;
          if ((i != 0) && (m >= i2 - j + 1) && (m <= i2 + j - 1) && (paramArrayOfInt1[n] >= paramArrayOfInt2[n]))
          {
            paramCallback = new DiffUtil.Snake();
            paramCallback.x = paramArrayOfInt2[n];
            paramCallback.y = (paramCallback.x - m);
            paramCallback.size = (paramArrayOfInt1[n] - paramArrayOfInt2[n]);
            paramCallback.removal = bool;
            paramCallback.reverse = false;
            return paramCallback;
          }
          m += 2;
        }
        m = k;
        while (m <= j)
        {
          int i4 = m + i2;
          if (i4 != j + i2) {
            if (i4 != k + i2)
            {
              paramInt4 = paramInt5 + i4;
              if (paramArrayOfInt2[(paramInt4 - 1)] < paramArrayOfInt2[(paramInt4 + 1)]) {}
            }
            else
            {
              paramInt4 = paramArrayOfInt2[(paramInt5 + i4 + 1)] - 1;
              bool = true;
              break label473;
            }
          }
          paramInt4 = paramArrayOfInt2[(paramInt5 + i4 - 1)];
          bool = false;
          label473:
          n = paramInt4 - i4;
          while ((paramInt4 > 0) && (n > 0) && (paramCallback.areItemsTheSame(paramInt1 + paramInt4 - 1, paramInt3 + n - 1)))
          {
            paramInt4 -= 1;
            n -= 1;
          }
          n = paramInt5 + i4;
          paramArrayOfInt2[n] = paramInt4;
          if ((i == 0) && (i4 >= k) && (i4 <= j) && (paramArrayOfInt1[n] >= paramArrayOfInt2[n]))
          {
            paramCallback = new DiffUtil.Snake();
            paramCallback.x = paramArrayOfInt2[n];
            paramCallback.y = (paramCallback.x - i4);
            paramCallback.size = (paramArrayOfInt1[n] - paramArrayOfInt2[n]);
            paramCallback.removal = bool;
            paramCallback.reverse = true;
            return paramCallback;
          }
          m += 2;
        }
        j += 1;
      }
      throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.DiffUtil
 * JD-Core Version:    0.7.0.1
 */