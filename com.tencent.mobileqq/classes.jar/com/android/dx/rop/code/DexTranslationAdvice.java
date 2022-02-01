package com.android.dx.rop.code;

import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.type.Type;

public final class DexTranslationAdvice
  implements TranslationAdvice
{
  private static final int MIN_INVOKE_IN_ORDER = 6;
  public static final DexTranslationAdvice NO_SOURCES_IN_ORDER = new DexTranslationAdvice(true);
  public static final DexTranslationAdvice THE_ONE = new DexTranslationAdvice();
  private final boolean disableSourcesInOrder;
  
  private DexTranslationAdvice()
  {
    this.disableSourcesInOrder = false;
  }
  
  private DexTranslationAdvice(boolean paramBoolean)
  {
    this.disableSourcesInOrder = paramBoolean;
  }
  
  private int totalRopWidth(RegisterSpecList paramRegisterSpecList)
  {
    int i = 0;
    int k = paramRegisterSpecList.size();
    int j = 0;
    while (i < k)
    {
      j += paramRegisterSpecList.get(i).getCategory();
      i += 1;
    }
    return j;
  }
  
  public int getMaxOptimalRegisterCount()
  {
    return 16;
  }
  
  public boolean hasConstantOperation(Rop paramRop, RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2)
  {
    if (paramRegisterSpec1.getType() != Type.INT) {
      return false;
    }
    if (!(paramRegisterSpec2.getTypeBearer() instanceof CstInteger))
    {
      if (((paramRegisterSpec1.getTypeBearer() instanceof CstInteger)) && (paramRop.getOpcode() == 15)) {
        return ((CstInteger)paramRegisterSpec1.getTypeBearer()).fitsIn16Bits();
      }
      return false;
    }
    paramRegisterSpec1 = (CstInteger)paramRegisterSpec2.getTypeBearer();
    switch (paramRop.getOpcode())
    {
    case 19: 
    default: 
      return false;
    case 14: 
    case 16: 
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    case 22: 
      return paramRegisterSpec1.fitsIn16Bits();
    case 23: 
    case 24: 
    case 25: 
      return paramRegisterSpec1.fitsIn8Bits();
    }
    return CstInteger.make(-paramRegisterSpec1.getValue()).fitsIn16Bits();
  }
  
  public boolean requiresSourcesInOrder(Rop paramRop, RegisterSpecList paramRegisterSpecList)
  {
    return (!this.disableSourcesInOrder) && (paramRop.isCallLike()) && (totalRopWidth(paramRegisterSpecList) >= 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.DexTranslationAdvice
 * JD-Core Version:    0.7.0.1
 */