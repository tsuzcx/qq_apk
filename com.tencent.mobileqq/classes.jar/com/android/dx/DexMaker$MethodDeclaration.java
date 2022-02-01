package com.android.dx;

import com.android.dx.dex.DexOptions;
import com.android.dx.dex.code.RopTranslator;
import com.android.dx.dex.file.EncodedMethod;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.type.StdTypeList;

class DexMaker$MethodDeclaration
{
  private final Code code;
  private final int flags;
  final MethodId<?, ?> method;
  
  public DexMaker$MethodDeclaration(MethodId<?, ?> paramMethodId, int paramInt)
  {
    this.method = paramMethodId;
    this.flags = paramInt;
    this.code = new Code(this);
  }
  
  boolean isDirect()
  {
    return (this.flags & 0x1000A) != 0;
  }
  
  boolean isStatic()
  {
    return (this.flags & 0x8) != 0;
  }
  
  EncodedMethod toEncodedMethod(DexOptions paramDexOptions)
  {
    paramDexOptions = RopTranslator.translate(new RopMethod(this.code.toBasicBlocks(), 0), 1, null, this.code.paramSize(), paramDexOptions);
    return new EncodedMethod(this.method.constant, this.flags, paramDexOptions, StdTypeList.EMPTY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.DexMaker.MethodDeclaration
 * JD-Core Version:    0.7.0.1
 */