package com.tencent.avgame.gameroom.video;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import java.util.ArrayList;
import java.util.List;

public class AVGameNinePatchScreenLayout
  extends AVGameScreenLayoutStyle
{
  static final int[][] a;
  public static final int b = a.length;
  static final int[] c = { 0, 3, 4, 1, 6, 7, 8, 5, 2 };
  static final int[] d = { 0, 4, 5, 1, 8, 9, 12, 6, 2, 13, 10, 14, 15, 11, 7, 3 };
  
  static
  {
    int[] arrayOfInt1 = { 1 };
    int[] arrayOfInt2 = { 2, 2, 2 };
    int[] arrayOfInt3 = { 2, 2, 3 };
    int[] arrayOfInt4 = { 2, 3, 3 };
    int[] arrayOfInt5 = { 3, 3, 3 };
    int[] arrayOfInt6 = { 3, 3, 3, 2 };
    int[] arrayOfInt7 = { 3, 3, 3, 4 };
    int[] arrayOfInt8 = { 3, 3, 4, 4 };
    int[] arrayOfInt9 = { 4, 4, 4, 4 };
    a = new int[][] { arrayOfInt1, { 1, 1 }, { 1, 2 }, { 2, 2 }, { 2, 2, 1 }, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 3, 3, 2, 2 }, arrayOfInt6, { 3, 3, 3, 3 }, arrayOfInt7, arrayOfInt8, { 3, 4, 4, 4 }, arrayOfInt9 };
  }
  
  public AVGameNinePatchScreenLayout(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
    this.e = 1;
  }
  
  private List<Rect> a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= 0) {
      return null;
    }
    int[] arrayOfInt2 = a[(paramInt1 - 1)];
    int i3 = arrayOfInt2.length;
    int n = (paramInt3 + 0) / i3 - 0;
    ArrayList localArrayList = new ArrayList();
    int k;
    if (paramInt1 <= 9) {
      k = 1;
    } else {
      k = 0;
    }
    int i;
    if (paramInt1 == 5) {
      i = 1;
    } else {
      i = 0;
    }
    int m = 3;
    int i1;
    int j;
    Object localObject2;
    if (i != 0)
    {
      i1 = paramInt3 / 10;
      localObject1 = new int[3];
      j = i1 * 3;
      localObject1[0] = j;
      localObject1[1] = j;
      i1 *= 6;
      localObject1[2] = (paramInt3 - i1);
      localObject2 = new int[3];
      localObject2[0] = 0;
      localObject2[1] = j;
      localObject2[2] = i1;
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    int[] arrayOfInt1;
    if (k != 0) {
      arrayOfInt1 = c;
    } else {
      arrayOfInt1 = d;
    }
    if (k != 0) {
      j = 3;
    } else {
      j = 4;
    }
    if (k != 0) {
      k = m;
    } else {
      k = 4;
    }
    m = 0;
    paramInt3 = n;
    while (m < j)
    {
      if (i != 0) {
        n = localObject2[m];
      } else {
        n = (paramInt3 + 0) * m;
      }
      int i2;
      if (m < i3)
      {
        i1 = arrayOfInt2[m];
        i2 = (paramInt2 + 0) / i1 + 0;
      }
      else
      {
        i1 = 0;
        i2 = 0;
      }
      int i4 = 0;
      while (i4 < k)
      {
        Rect localRect;
        if ((i1 > 0) && (i4 < i1))
        {
          int i6 = i4 * (i2 + 0);
          int i5;
          if (i != 0) {
            i5 = localObject1[m];
          } else {
            i5 = paramInt3;
          }
          localRect = new Rect(i6, n, i6 + i2, n + i5);
        }
        else
        {
          localRect = null;
        }
        localArrayList.add(localRect);
        i4 += 1;
      }
      m += 1;
    }
    Object localObject1 = new ArrayList();
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      localObject2 = (Rect)localArrayList.get(arrayOfInt1[paramInt2]);
      if (localObject2 != null) {
        ((ArrayList)localObject1).add(localObject2);
      }
      paramInt2 += 1;
    }
    return localObject1;
  }
  
  public void a(AVGameVideoView[] paramArrayOfAVGameVideoView1, AVGameVideoView[] paramArrayOfAVGameVideoView2, int paramInt1, int paramInt2, List<MemberVideoDisplayInfo> paramList)
  {
    paramArrayOfAVGameVideoView2 = new ArrayList(8);
    int j = paramArrayOfAVGameVideoView1.length;
    int i = 0;
    while (i < j)
    {
      paramList = paramArrayOfAVGameVideoView1[i];
      if (paramList.c()) {
        paramArrayOfAVGameVideoView2.add(paramList);
      }
      i += 1;
    }
    if (paramArrayOfAVGameVideoView2.isEmpty()) {
      return;
    }
    i = paramArrayOfAVGameVideoView2.size();
    j = Math.min(i, i);
    int k = b;
    i = j;
    if (j > k) {
      i = k;
    }
    paramArrayOfAVGameVideoView1 = a(i, paramInt1, paramInt2);
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      paramList = (Rect)paramArrayOfAVGameVideoView1.get(paramInt1);
      if (paramList == null) {
        break;
      }
      ((AVGameVideoView)paramArrayOfAVGameVideoView2.get(paramInt1)).c(paramList.left, paramList.top, paramList.right, paramList.bottom);
      ((AVGameVideoView)paramArrayOfAVGameVideoView2.get(paramInt1)).a(0, 0, 0, 0);
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameNinePatchScreenLayout
 * JD-Core Version:    0.7.0.1
 */