package com.android.dx.cf.code;

class Ropper$LabelAllocator
{
  int nextAvailableLabel;
  
  Ropper$LabelAllocator(int paramInt)
  {
    this.nextAvailableLabel = paramInt;
  }
  
  int getNextLabel()
  {
    int i = this.nextAvailableLabel;
    this.nextAvailableLabel = (i + 1);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Ropper.LabelAllocator
 * JD-Core Version:    0.7.0.1
 */