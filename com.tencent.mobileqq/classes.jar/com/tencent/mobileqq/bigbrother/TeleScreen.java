package com.tencent.mobileqq.bigbrother;

import android.support.v4.util.SparseArrayCompat;

public class TeleScreen
{
  private static final TeleScreen jdField_a_of_type_ComTencentMobileqqBigbrotherTeleScreen = new TeleScreen();
  private int jdField_a_of_type_Int;
  private final SparseArrayCompat<JumpCallback> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  
  public static TeleScreen a()
  {
    return jdField_a_of_type_ComTencentMobileqqBigbrotherTeleScreen;
  }
  
  public int a(JumpCallback paramJumpCallback)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      do
      {
        this.jdField_a_of_type_Int += 1;
      } while ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_Int) != null) || (this.jdField_a_of_type_Int == 0));
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_Int, paramJumpCallback);
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    for (;;)
    {
      throw paramJumpCallback;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.delete(paramInt);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      JumpCallback localJumpCallback = (JumpCallback)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt1);
      if (localJumpCallback != null) {
        localJumpCallback.onJump(paramInt1, paramInt2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.TeleScreen
 * JD-Core Version:    0.7.0.1
 */