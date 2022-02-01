package com.tencent.luggage.wxa.mj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding;", "", "maxWeight", "", "(I)V", "currentSortOrder", "nextSampleIndex", "recycledSampleCount", "recycledSamples", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "samples", "Ljava/util/ArrayList;", "totalWeight", "addSample", "", "weight", "value", "", "ensureSortedByIndex", "ensureSortedByValue", "getEstimateValue", "Companion", "Sample", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b.a a = new b.a(null);
  private static final Comparator<b.d> i = (Comparator)b.b.a;
  private static final Comparator<b.d> j = (Comparator)b.c.a;
  private final ArrayList<b.d> b;
  private final b.d[] c;
  private int d;
  private int e;
  private int f;
  private int g;
  private final int h;
  
  public b(int paramInt)
  {
    this.h = paramInt;
    this.c = new b.d[5];
    this.b = new ArrayList();
    this.d = -1;
  }
  
  private final void b()
  {
    if (this.d != 1)
    {
      Collections.sort((List)this.b, i);
      this.d = 1;
    }
  }
  
  public final float a()
  {
    int m = ((Collection)this.b).size();
    int k = 0;
    float f1 = 0.0F;
    while (k < m)
    {
      f1 += ((b.d)this.b.get(k)).b() / this.f * ((b.d)this.b.get(k)).c();
      k += 1;
    }
    float f2 = f1;
    if (f1 == 0.0F)
    {
      if (this.b.isEmpty()) {
        return -1.0F;
      }
      ArrayList localArrayList = this.b;
      f2 = ((b.d)localArrayList.get(localArrayList.size() - 1)).c();
    }
    return f2;
  }
  
  public final void a(int paramInt, float paramFloat)
  {
    b();
    int k = this.g;
    Object localObject;
    if (k > 0)
    {
      localObject = this.c;
      this.g = (k - 1);
      localObject = localObject[this.g];
    }
    else
    {
      localObject = new b.d();
    }
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    k = this.e;
    this.e = (k + 1);
    ((b.d)localObject).a(k);
    ((b.d)localObject).b(paramInt);
    ((b.d)localObject).a(paramFloat);
    this.b.add(localObject);
    this.f += paramInt;
    for (;;)
    {
      paramInt = this.f;
      k = this.h;
      if (paramInt <= k) {
        break;
      }
      paramInt -= k;
      localObject = this.b.get(0);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "this.samples[0]");
      localObject = (b.d)localObject;
      if (((b.d)localObject).b() <= paramInt)
      {
        this.f -= ((b.d)localObject).b();
        this.b.remove(0);
        paramInt = this.g;
        if (paramInt < 5)
        {
          b.d[] arrayOfd = this.c;
          this.g = (paramInt + 1);
          arrayOfd[paramInt] = localObject;
        }
      }
      else
      {
        ((b.d)localObject).b(((b.d)localObject).b() - paramInt);
        this.f -= paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mj.b
 * JD-Core Version:    0.7.0.1
 */