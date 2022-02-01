package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class DefaultAllocator
  implements Allocator
{
  private static final int AVAILABLE_EXTRA_CAPACITY = 100;
  private int allocatedCount;
  private Allocation[] availableAllocations;
  private int availableCount;
  private final int individualAllocationSize;
  private final byte[] initialAllocationBlock;
  private final Allocation[] singleAllocationReleaseHolder;
  private int targetBufferSize;
  private final boolean trimOnReset;
  
  public DefaultAllocator(boolean paramBoolean, int paramInt)
  {
    this(paramBoolean, paramInt, 0);
  }
  
  public DefaultAllocator(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i = 0;
    boolean bool;
    if (paramInt1 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    if (paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    this.trimOnReset = paramBoolean;
    this.individualAllocationSize = paramInt1;
    this.availableCount = paramInt2;
    this.availableAllocations = new Allocation[paramInt2 + 100];
    if (paramInt2 > 0)
    {
      this.initialAllocationBlock = new byte[paramInt2 * paramInt1];
      while (i < paramInt2)
      {
        this.availableAllocations[i] = new Allocation(this.initialAllocationBlock, i * paramInt1);
        i += 1;
      }
    }
    this.initialAllocationBlock = null;
    this.singleAllocationReleaseHolder = new Allocation[1];
  }
  
  public Allocation allocate()
  {
    try
    {
      this.allocatedCount += 1;
      Object localObject1;
      if (this.availableCount > 0)
      {
        localObject1 = this.availableAllocations;
        int i = this.availableCount - 1;
        this.availableCount = i;
        localObject1 = localObject1[i];
        this.availableAllocations[this.availableCount] = null;
      }
      else
      {
        localObject1 = new Allocation(new byte[this.individualAllocationSize], 0);
      }
      return localObject1;
    }
    finally {}
  }
  
  public int getIndividualAllocationLength()
  {
    return this.individualAllocationSize;
  }
  
  public int getTotalBytesAllocated()
  {
    try
    {
      int i = this.allocatedCount;
      int j = this.individualAllocationSize;
      return i * j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void release(Allocation paramAllocation)
  {
    try
    {
      this.singleAllocationReleaseHolder[0] = paramAllocation;
      release(this.singleAllocationReleaseHolder);
      return;
    }
    finally
    {
      paramAllocation = finally;
      throw paramAllocation;
    }
  }
  
  public void release(Allocation[] paramArrayOfAllocation)
  {
    for (;;)
    {
      try
      {
        if (this.availableCount + paramArrayOfAllocation.length >= this.availableAllocations.length) {
          this.availableAllocations = ((Allocation[])Arrays.copyOf(this.availableAllocations, Math.max(this.availableAllocations.length * 2, this.availableCount + paramArrayOfAllocation.length)));
        }
        int j = paramArrayOfAllocation.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        localAllocation = paramArrayOfAllocation[i];
        if (localAllocation.data == this.initialAllocationBlock) {
          continue;
        }
        if (localAllocation.data.length != this.individualAllocationSize) {
          continue;
        }
      }
      finally
      {
        int i;
        Allocation localAllocation;
        Allocation[] arrayOfAllocation;
        int k;
        continue;
        throw paramArrayOfAllocation;
        continue;
        boolean bool = false;
        continue;
        bool = true;
        continue;
      }
      Assertions.checkArgument(bool);
      arrayOfAllocation = this.availableAllocations;
      k = this.availableCount;
      this.availableCount = (k + 1);
      arrayOfAllocation[k] = localAllocation;
      i += 1;
    }
    this.allocatedCount -= paramArrayOfAllocation.length;
    notifyAll();
  }
  
  public void reset()
  {
    try
    {
      if (this.trimOnReset) {
        setTargetBufferSize(0);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setTargetBufferSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (paramInt < this.targetBufferSize)
        {
          i = 1;
          this.targetBufferSize = paramInt;
          if (i != 0) {
            trim();
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public void trim()
  {
    try
    {
      int i = Util.ceilDivide(this.targetBufferSize, this.individualAllocationSize);
      int j = this.allocatedCount;
      int m = 0;
      int k = Math.max(0, i - j);
      i = this.availableCount;
      if (k >= i) {
        return;
      }
      i = k;
      if (this.initialAllocationBlock != null)
      {
        j = this.availableCount - 1;
        i = m;
        while (i <= j)
        {
          Allocation localAllocation1 = this.availableAllocations[i];
          if (localAllocation1.data == this.initialAllocationBlock)
          {
            i += 1;
          }
          else
          {
            Allocation localAllocation2 = this.availableAllocations[j];
            if (localAllocation2.data != this.initialAllocationBlock)
            {
              j -= 1;
            }
            else
            {
              this.availableAllocations[i] = localAllocation2;
              this.availableAllocations[j] = localAllocation1;
              j -= 1;
              i += 1;
            }
          }
        }
        j = Math.max(k, i);
        k = this.availableCount;
        i = j;
        if (j >= k) {
          return;
        }
      }
      Arrays.fill(this.availableAllocations, i, this.availableCount, null);
      this.availableCount = i;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DefaultAllocator
 * JD-Core Version:    0.7.0.1
 */