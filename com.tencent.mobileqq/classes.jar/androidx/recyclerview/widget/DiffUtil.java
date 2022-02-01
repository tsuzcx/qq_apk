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
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
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
        if (localArrayList3.isEmpty())
        {
          localRange1 = new DiffUtil.Range();
          label217:
          localRange1.oldListStart = localRange2.oldListStart;
          localRange1.newListStart = localRange2.newListStart;
          if (!localSnake.reverse) {
            break label362;
          }
          localRange1.oldListEnd = localSnake.x;
          localRange1.newListEnd = localSnake.y;
          label265:
          localArrayList2.add(localRange1);
          if (!localSnake.reverse) {
            break label457;
          }
          if (!localSnake.removal) {
            break label420;
          }
          localRange2.oldListStart = (localSnake.x + localSnake.size + 1);
          localRange2.newListStart = (localSnake.y + localSnake.size);
        }
        for (;;)
        {
          localArrayList2.add(localRange2);
          break;
          localRange1 = (DiffUtil.Range)localArrayList3.remove(localArrayList3.size() - 1);
          break label217;
          label362:
          if (localSnake.removal)
          {
            localRange1.oldListEnd = (localSnake.x - 1);
            localRange1.newListEnd = localSnake.y;
            break label265;
          }
          localRange1.oldListEnd = localSnake.x;
          localRange1.newListEnd = (localSnake.y - 1);
          break label265;
          label420:
          localRange2.oldListStart = (localSnake.x + localSnake.size);
          localRange2.newListStart = (localSnake.y + localSnake.size + 1);
          continue;
          label457:
          localRange2.oldListStart = (localSnake.x + localSnake.size);
          localRange2.newListStart = (localSnake.y + localSnake.size);
        }
      }
      localArrayList3.add(localRange2);
    }
    Collections.sort(localArrayList1, SNAKE_COMPARATOR);
    return new DiffUtil.DiffResult(paramCallback, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static DiffUtil.Snake diffPartial(DiffUtil.Callback paramCallback, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    int m = paramInt2 - paramInt1;
    int n = paramInt4 - paramInt3;
    if ((paramInt2 - paramInt1 < 1) || (paramInt4 - paramInt3 < 1)) {
      return null;
    }
    int i1 = m - n;
    int i2 = (m + n + 1) / 2;
    Arrays.fill(paramArrayOfInt1, paramInt5 - i2 - 1, paramInt5 + i2 + 1, 0);
    Arrays.fill(paramArrayOfInt2, paramInt5 - i2 - 1 + i1, paramInt5 + i2 + 1 + i1, m);
    int i;
    if (i1 % 2 != 0)
    {
      paramInt4 = 1;
      i = 0;
    }
    for (;;)
    {
      if (i > i2) {
        break label664;
      }
      int j = -i;
      boolean bool;
      int k;
      for (;;)
      {
        if (j > i) {
          break label382;
        }
        if ((j == -i) || ((j != i) && (paramArrayOfInt1[(paramInt5 + j - 1)] < paramArrayOfInt1[(paramInt5 + j + 1)]))) {
          paramInt2 = paramArrayOfInt1[(paramInt5 + j + 1)];
        }
        for (bool = false;; bool = true)
        {
          k = paramInt2;
          paramInt2 -= j;
          while ((k < m) && (paramInt2 < n) && (paramCallback.areItemsTheSame(paramInt1 + k, paramInt3 + paramInt2)))
          {
            k += 1;
            paramInt2 += 1;
          }
          paramInt4 = 0;
          break;
          paramInt2 = paramArrayOfInt1[(paramInt5 + j - 1)] + 1;
        }
        paramArrayOfInt1[(paramInt5 + j)] = k;
        if ((paramInt4 != 0) && (j >= i1 - i + 1) && (j <= i1 + i - 1) && (paramArrayOfInt1[(paramInt5 + j)] >= paramArrayOfInt2[(paramInt5 + j)]))
        {
          paramCallback = new DiffUtil.Snake();
          paramCallback.x = paramArrayOfInt2[(paramInt5 + j)];
          paramCallback.y = (paramCallback.x - j);
          paramCallback.size = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          paramCallback.removal = bool;
          paramCallback.reverse = false;
          return paramCallback;
        }
        j += 2;
      }
      label382:
      j = -i;
      while (j <= i)
      {
        int i3 = j + i1;
        if ((i3 == i + i1) || ((i3 != -i + i1) && (paramArrayOfInt2[(paramInt5 + i3 - 1)] < paramArrayOfInt2[(paramInt5 + i3 + 1)]))) {
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 - 1)];
        }
        for (bool = false;; bool = true)
        {
          k = paramInt2;
          paramInt2 -= i3;
          while ((k > 0) && (paramInt2 > 0) && (paramCallback.areItemsTheSame(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i3 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i3)] = k;
        if ((paramInt4 == 0) && (j + i1 >= -i) && (j + i1 <= i) && (paramArrayOfInt1[(paramInt5 + i3)] >= paramArrayOfInt2[(paramInt5 + i3)]))
        {
          paramCallback = new DiffUtil.Snake();
          paramCallback.x = paramArrayOfInt2[(paramInt5 + i3)];
          paramCallback.y = (paramCallback.x - i3);
          paramCallback.size = (paramArrayOfInt1[(paramInt5 + i3)] - paramArrayOfInt2[(paramInt5 + i3)]);
          paramCallback.removal = bool;
          paramCallback.reverse = true;
          return paramCallback;
        }
        j += 2;
      }
      i += 1;
    }
    label664:
    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.DiffUtil
 * JD-Core Version:    0.7.0.1
 */