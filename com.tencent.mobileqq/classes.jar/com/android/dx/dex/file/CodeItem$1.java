package com.android.dx.dex.file;

import com.android.dx.dex.code.DalvCode.AssignIndicesCallback;
import com.android.dx.rop.cst.Constant;

class CodeItem$1
  implements DalvCode.AssignIndicesCallback
{
  CodeItem$1(CodeItem paramCodeItem, DexFile paramDexFile) {}
  
  public int getIndex(Constant paramConstant)
  {
    paramConstant = this.val$file.findItemOrNull(paramConstant);
    if (paramConstant == null) {
      return -1;
    }
    return paramConstant.getIndex();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.CodeItem.1
 * JD-Core Version:    0.7.0.1
 */