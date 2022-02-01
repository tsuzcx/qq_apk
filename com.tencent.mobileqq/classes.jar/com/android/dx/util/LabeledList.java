package com.android.dx.util;

import java.util.Arrays;

public class LabeledList
  extends FixedSizeList
{
  private final IntList labelToIndex;
  
  public LabeledList(int paramInt)
  {
    super(paramInt);
    this.labelToIndex = new IntList(paramInt);
  }
  
  public LabeledList(LabeledList paramLabeledList)
  {
    super(paramLabeledList.size());
    this.labelToIndex = paramLabeledList.labelToIndex.mutableCopy();
    int j = paramLabeledList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramLabeledList.get0(i);
      if (localObject != null) {
        set0(i, localObject);
      }
      i += 1;
    }
  }
  
  private void addLabelIndex(int paramInt1, int paramInt2)
  {
    int j = this.labelToIndex.size();
    int i = 0;
    while (i <= paramInt1 - j)
    {
      this.labelToIndex.add(-1);
      i += 1;
    }
    this.labelToIndex.set(paramInt1, paramInt2);
  }
  
  private void rebuildLabelToIndex()
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      LabeledItem localLabeledItem = (LabeledItem)get0(i);
      if (localLabeledItem != null) {
        this.labelToIndex.set(localLabeledItem.getLabel(), i);
      }
      i += 1;
    }
  }
  
  private void removeLabel(int paramInt)
  {
    this.labelToIndex.set(paramInt, -1);
  }
  
  public final int[] getLabelsInOrder()
  {
    int j = size();
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      LabeledItem localLabeledItem = (LabeledItem)get0(i);
      if (localLabeledItem == null) {
        throw new NullPointerException("null at index " + i);
      }
      arrayOfInt[i] = localLabeledItem.getLabel();
      i += 1;
    }
    Arrays.sort(arrayOfInt);
    return arrayOfInt;
  }
  
  public final int getMaxLabel()
  {
    int i = this.labelToIndex.size() - 1;
    while ((i >= 0) && (this.labelToIndex.get(i) < 0)) {
      i -= 1;
    }
    i += 1;
    this.labelToIndex.shrink(i);
    return i;
  }
  
  public final int indexOfLabel(int paramInt)
  {
    if (paramInt >= this.labelToIndex.size()) {
      return -1;
    }
    return this.labelToIndex.get(paramInt);
  }
  
  protected void set(int paramInt, LabeledItem paramLabeledItem)
  {
    LabeledItem localLabeledItem = (LabeledItem)getOrNull0(paramInt);
    set0(paramInt, paramLabeledItem);
    if (localLabeledItem != null) {
      removeLabel(localLabeledItem.getLabel());
    }
    if (paramLabeledItem != null) {
      addLabelIndex(paramLabeledItem.getLabel(), paramInt);
    }
  }
  
  public void shrinkToFit()
  {
    super.shrinkToFit();
    rebuildLabelToIndex();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.LabeledList
 * JD-Core Version:    0.7.0.1
 */