package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SlidingPercentile
{
  private static final Comparator<SlidingPercentile.Sample> INDEX_COMPARATOR = new SlidingPercentile.1();
  private static final int MAX_RECYCLED_SAMPLES = 5;
  private static final int SORT_ORDER_BY_INDEX = 1;
  private static final int SORT_ORDER_BY_VALUE = 0;
  private static final int SORT_ORDER_NONE = -1;
  private static final Comparator<SlidingPercentile.Sample> VALUE_COMPARATOR = new SlidingPercentile.2();
  private int currentSortOrder;
  private final int maxWeight;
  private int nextSampleIndex;
  private int recycledSampleCount;
  private final SlidingPercentile.Sample[] recycledSamples;
  private final ArrayList<SlidingPercentile.Sample> samples;
  private int totalWeight;
  
  public SlidingPercentile(int paramInt)
  {
    this.maxWeight = paramInt;
    this.recycledSamples = new SlidingPercentile.Sample[5];
    this.samples = new ArrayList();
    this.currentSortOrder = -1;
  }
  
  private void ensureSortedByIndex()
  {
    if (this.currentSortOrder != 1)
    {
      Collections.sort(this.samples, INDEX_COMPARATOR);
      this.currentSortOrder = 1;
    }
  }
  
  private void ensureSortedByValue()
  {
    if (this.currentSortOrder != 0)
    {
      Collections.sort(this.samples, VALUE_COMPARATOR);
      this.currentSortOrder = 0;
    }
  }
  
  public void addSample(int paramInt, float paramFloat)
  {
    ensureSortedByIndex();
    int i = this.recycledSampleCount;
    Object localObject;
    if (i > 0)
    {
      localObject = this.recycledSamples;
      i -= 1;
      this.recycledSampleCount = i;
      localObject = localObject[i];
    }
    else
    {
      localObject = new SlidingPercentile.Sample(null);
    }
    i = this.nextSampleIndex;
    this.nextSampleIndex = (i + 1);
    ((SlidingPercentile.Sample)localObject).index = i;
    ((SlidingPercentile.Sample)localObject).weight = paramInt;
    ((SlidingPercentile.Sample)localObject).value = paramFloat;
    this.samples.add(localObject);
    this.totalWeight += paramInt;
    for (;;)
    {
      paramInt = this.totalWeight;
      i = this.maxWeight;
      if (paramInt <= i) {
        break;
      }
      paramInt -= i;
      localObject = (SlidingPercentile.Sample)this.samples.get(0);
      if (((SlidingPercentile.Sample)localObject).weight <= paramInt)
      {
        this.totalWeight -= ((SlidingPercentile.Sample)localObject).weight;
        this.samples.remove(0);
        paramInt = this.recycledSampleCount;
        if (paramInt < 5)
        {
          SlidingPercentile.Sample[] arrayOfSample = this.recycledSamples;
          this.recycledSampleCount = (paramInt + 1);
          arrayOfSample[paramInt] = localObject;
        }
      }
      else
      {
        ((SlidingPercentile.Sample)localObject).weight -= paramInt;
        this.totalWeight -= paramInt;
      }
    }
  }
  
  public float getPercentile(float paramFloat)
  {
    ensureSortedByValue();
    float f = this.totalWeight;
    int i = 0;
    int j = 0;
    while (i < this.samples.size())
    {
      localObject = (SlidingPercentile.Sample)this.samples.get(i);
      j += ((SlidingPercentile.Sample)localObject).weight;
      if (j >= paramFloat * f) {
        return ((SlidingPercentile.Sample)localObject).value;
      }
      i += 1;
    }
    if (this.samples.isEmpty()) {
      return (0.0F / 0.0F);
    }
    Object localObject = this.samples;
    return ((SlidingPercentile.Sample)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.SlidingPercentile
 * JD-Core Version:    0.7.0.1
 */