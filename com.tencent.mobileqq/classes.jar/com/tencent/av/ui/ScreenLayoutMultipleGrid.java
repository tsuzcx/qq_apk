package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ScreenLayoutMultipleGrid
  extends ScreenLayout
{
  static final int[] jdField_a_of_type_ArrayOfInt;
  static final int[][] jdField_a_of_type_Array2dOfInt;
  public static final int b;
  static final int[] b;
  public static final int c = localObject[(localObject.length - 1)][0];
  public static final int d = localObject[(localObject.length - 1)].length;
  private volatile ConcurrentHashMap<Long, VideoMemberInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    Object localObject = { 1 };
    int[] arrayOfInt1 = { 1, 2 };
    int[] arrayOfInt2 = { 2, 2 };
    int[] arrayOfInt3 = { 2, 2, 1 };
    int[] arrayOfInt4 = { 2, 2, 2 };
    int[] arrayOfInt5 = { 2, 2, 3 };
    int[] arrayOfInt6 = { 2, 3, 3 };
    int[] arrayOfInt7 = { 3, 3, 3 };
    int[] arrayOfInt8 = { 3, 3, 3, 3 };
    int[] arrayOfInt9 = { 4, 4, 4, 4 };
    jdField_a_of_type_Array2dOfInt = new int[][] { localObject, { 1, 1 }, arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, { 3, 3, 2, 2 }, { 3, 3, 3, 2 }, arrayOfInt8, { 3, 3, 3, 4 }, { 3, 3, 4, 4 }, { 3, 4, 4, 4 }, arrayOfInt9 };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 3, 4, 1, 6, 7, 8, 5, 2 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 4, 5, 1, 8, 9, 12, 6, 2, 13, 10, 14, 15, 11, 7, 3 };
    localObject = jdField_a_of_type_Array2dOfInt;
    jdField_b_of_type_Int = localObject.length;
  }
  
  protected ScreenLayoutMultipleGrid(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  private List<Rect> a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= 0) {
      return null;
    }
    int[] arrayOfInt2 = jdField_a_of_type_Array2dOfInt[(paramInt1 - 1)];
    int i2 = arrayOfInt2.length;
    int i3 = (paramInt3 + 0) / i2 - 0;
    ArrayList localArrayList = new ArrayList();
    int m;
    if (paramInt1 <= 9) {
      m = 1;
    } else {
      m = 0;
    }
    if (paramInt1 == 5) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    Object localObject2;
    if (i != 0)
    {
      k = paramInt3 / 10;
      localObject1 = new int[3];
      j = k * 3;
      localObject1[0] = j;
      localObject1[1] = j;
      k *= 6;
      localObject1[2] = (paramInt3 - k);
      localObject2 = new int[3];
      localObject2[0] = 0;
      localObject2[1] = j;
      localObject2[2] = k;
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    int[] arrayOfInt1;
    if (m != 0) {
      arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    } else {
      arrayOfInt1 = jdField_b_of_type_ArrayOfInt;
    }
    int k = 4;
    if (m != 0) {
      j = 3;
    } else {
      j = 4;
    }
    if (m != 0) {
      k = 3;
    }
    paramInt3 = 0;
    int i1 = i;
    int i = paramInt3;
    for (;;)
    {
      paramInt3 = 0;
      if (i >= j) {
        break;
      }
      if (i1 != 0) {
        m = localObject2[i];
      } else {
        m = (i3 + 0) * i;
      }
      int n;
      if (i < i2)
      {
        paramInt3 = arrayOfInt2[i];
        n = (paramInt2 + 0) / paramInt3 + 0;
      }
      else
      {
        n = 0;
      }
      int i5 = 0;
      int i4 = paramInt3;
      paramInt3 = i3;
      i3 = i5;
      while (i3 < k)
      {
        Rect localRect;
        if ((i4 > 0) && (i3 < i4))
        {
          int i6 = i3 * (n + 0);
          if (i1 != 0) {
            i5 = localObject1[i];
          } else {
            i5 = paramInt3;
          }
          localRect = new Rect(i6, m, i6 + n, m + i5);
        }
        else
        {
          localRect = null;
        }
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getViewRects, creat rect: [");
          localStringBuilder.append(i);
          localStringBuilder.append("|");
          localStringBuilder.append(i3);
          localStringBuilder.append("] :");
          localStringBuilder.append(localRect);
          QLog.w("ScreenLayoutMultipleGrid", 1, localStringBuilder.toString());
        }
        localArrayList.add(localRect);
        i3 += 1;
      }
      i += 1;
      i3 = paramInt3;
    }
    Object localObject1 = new ArrayList();
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      paramInt3 = arrayOfInt1[paramInt2];
      localObject2 = (Rect)localArrayList.get(paramInt3);
      if (localObject2 != null)
      {
        ((ArrayList)localObject1).add(localObject2);
      }
      else if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getViewRects, sort rect has wrong: ");
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(paramInt3);
        QLog.w("ScreenLayoutMultipleGrid", 1, ((StringBuilder)localObject2).toString());
      }
      paramInt2 += 1;
    }
    return localObject1;
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, ConcurrentHashMap<Long, VideoMemberInfo> paramConcurrentHashMap)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
  }
  
  public void a(SessionInfo paramSessionInfo, GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QLog.isDevelopLevel())
    {
      paramArrayOfGLVideoView = new StringBuilder();
      paramArrayOfGLVideoView.append("setSmallVideoViewLayout, wrong call！ ");
      paramArrayOfGLVideoView.append(new Throwable());
      QLog.w("ScreenLayoutMultipleGrid", 1, paramArrayOfGLVideoView.toString());
    }
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("layoutCommon, wrong call！ ");
      localStringBuilder.append(new Throwable());
      QLog.w("ScreenLayoutMultipleGrid", 1, localStringBuilder.toString());
    }
    paramArrayOfGLVideoView[0].a(0, 0, 0, 0);
    paramArrayOfGLVideoView[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfGLVideoView[0].d(-15197410);
    paramArrayOfGLVideoView[1].a(3, 3, 3, 3);
    paramArrayOfGLVideoView[1].d(-15197410);
    a(paramArrayOfGLVideoView, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayoutMultipleGrid
 * JD-Core Version:    0.7.0.1
 */