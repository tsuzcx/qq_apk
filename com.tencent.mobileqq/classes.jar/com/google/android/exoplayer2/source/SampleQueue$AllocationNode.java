package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.upstream.Allocation;

final class SampleQueue$AllocationNode
{
  @Nullable
  public Allocation allocation;
  public final long endPosition;
  @Nullable
  public AllocationNode next;
  public final long startPosition;
  public boolean wasInitialized;
  
  public SampleQueue$AllocationNode(long paramLong, int paramInt)
  {
    this.startPosition = paramLong;
    this.endPosition = (paramInt + paramLong);
  }
  
  public AllocationNode clear()
  {
    this.allocation = null;
    AllocationNode localAllocationNode = this.next;
    this.next = null;
    return localAllocationNode;
  }
  
  public void initialize(Allocation paramAllocation, AllocationNode paramAllocationNode)
  {
    this.allocation = paramAllocation;
    this.next = paramAllocationNode;
    this.wasInitialized = true;
  }
  
  public int translateOffset(long paramLong)
  {
    return (int)(paramLong - this.startPosition) + this.allocation.offset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SampleQueue.AllocationNode
 * JD-Core Version:    0.7.0.1
 */