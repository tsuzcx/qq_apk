package com.tencent.mobileqq.apollo.statistics.trace;

import android.util.SparseIntArray;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceMapping;
import java.util.ArrayList;

public class TraceMappingIml
  implements ITraceMapping
{
  public static SparseIntArray a = new SparseIntArray();
  
  public static int a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    int j = 0;
    int i;
    if (paramInt3 != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt2 == 0) && (!paramBoolean2))
    {
      if (i != 0) {
        return 0;
      }
      return 6;
    }
    if ((paramInt2 != 1) && (paramInt2 != 2)) {
      return 101;
    }
    if (a.get(paramInt1) == 0) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2) {
        paramInt3 = j;
      } else if (paramInt3 != 0) {
        paramInt3 = 2;
      } else {
        paramInt3 = 3;
      }
    }
    else {
      paramInt3 ^= 0x1;
    }
    a.put(paramInt1, 1);
    if (paramBoolean1)
    {
      if (paramInt2 == 1) {
        paramInt2 = 4;
      } else {
        paramInt2 = 5;
      }
    }
    else
    {
      paramInt2 = paramInt3;
      if (i == 0) {
        paramInt2 = paramInt3 + 6;
      }
    }
    paramInt3 = paramInt2;
    if (paramInt1 == 1)
    {
      paramInt3 = paramInt2;
      if (!ApolloConfigUtils.h) {
        paramInt3 = paramInt2 + 10;
      }
    }
    paramInt2 = paramInt3;
    if (paramInt1 == 1)
    {
      paramInt2 = paramInt3;
      if (!ApolloConfigUtils.k) {
        paramInt2 = paramInt3 | 0x20;
      }
    }
    return paramInt2;
  }
  
  public String a(int paramInt)
  {
    return TraceReportUtil.d(paramInt);
  }
  
  public void a()
  {
    a.clear();
  }
  
  public boolean b(int paramInt)
  {
    return ApolloConfigUtils.d.contains(Integer.valueOf(paramInt));
  }
  
  public boolean c(int paramInt)
  {
    return ApolloConfigUtils.f.contains(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.TraceMappingIml
 * JD-Core Version:    0.7.0.1
 */