package com.tencent.mobileqq.apollo.process.data;

import java.util.Comparator;

class CmGameShareDataHandler$2
  implements Comparator<CmGameShareDataHandler.GameShareResult>
{
  CmGameShareDataHandler$2(CmGameShareDataHandler paramCmGameShareDataHandler) {}
  
  public int a(CmGameShareDataHandler.GameShareResult paramGameShareResult1, CmGameShareDataHandler.GameShareResult paramGameShareResult2)
  {
    if (paramGameShareResult1.a == paramGameShareResult2.a) {
      return 0;
    }
    if (paramGameShareResult1.a > paramGameShareResult2.a) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.2
 * JD-Core Version:    0.7.0.1
 */