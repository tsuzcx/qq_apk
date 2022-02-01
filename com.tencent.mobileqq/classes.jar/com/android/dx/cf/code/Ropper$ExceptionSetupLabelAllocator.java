package com.android.dx.cf.code;

class Ropper$ExceptionSetupLabelAllocator
  extends Ropper.LabelAllocator
{
  int maxSetupLabel;
  
  Ropper$ExceptionSetupLabelAllocator(Ropper paramRopper)
  {
    super(Ropper.access$100(paramRopper));
    this.maxSetupLabel = (Ropper.access$100(paramRopper) + Ropper.access$700(paramRopper).getCatches().size());
  }
  
  int getNextLabel()
  {
    if (this.nextAvailableLabel >= this.maxSetupLabel) {
      throw new IndexOutOfBoundsException();
    }
    int i = this.nextAvailableLabel;
    this.nextAvailableLabel = (i + 1);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Ropper.ExceptionSetupLabelAllocator
 * JD-Core Version:    0.7.0.1
 */