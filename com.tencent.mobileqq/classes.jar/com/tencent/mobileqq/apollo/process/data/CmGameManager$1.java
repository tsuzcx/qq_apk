package com.tencent.mobileqq.apollo.process.data;

import java.util.Comparator;

class CmGameManager$1
  implements Comparator<CmGameManager.GameRunningTask>
{
  CmGameManager$1(CmGameManager paramCmGameManager) {}
  
  public int a(CmGameManager.GameRunningTask paramGameRunningTask1, CmGameManager.GameRunningTask paramGameRunningTask2)
  {
    if (paramGameRunningTask1.a == paramGameRunningTask2.a) {
      return 0;
    }
    if (paramGameRunningTask1.a > paramGameRunningTask2.a) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameManager.1
 * JD-Core Version:    0.7.0.1
 */