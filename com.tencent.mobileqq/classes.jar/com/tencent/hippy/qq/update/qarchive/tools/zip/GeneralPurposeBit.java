package com.tencent.hippy.qq.update.qarchive.tools.zip;

public final class GeneralPurposeBit
{
  private static final int DATA_DESCRIPTOR_FLAG = 8;
  private static final int ENCRYPTION_FLAG = 1;
  private static final int STRONG_ENCRYPTION_FLAG = 64;
  public static final int UFT8_NAMES_FLAG = 2048;
  private boolean dataDescriptorFlag = false;
  private boolean encryptionFlag = false;
  private boolean languageEncodingFlag = false;
  private boolean strongEncryptionFlag = false;
  
  public static GeneralPurposeBit parse(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = ZipShort.getValue(paramArrayOfByte, paramInt);
    paramArrayOfByte = new GeneralPurposeBit();
    boolean bool2 = false;
    if ((paramInt & 0x8) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramArrayOfByte.useDataDescriptor(bool1);
    if ((paramInt & 0x800) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramArrayOfByte.useUTF8ForNames(bool1);
    if ((paramInt & 0x40) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramArrayOfByte.useStrongEncryption(bool1);
    boolean bool1 = bool2;
    if ((paramInt & 0x1) != 0) {
      bool1 = true;
    }
    paramArrayOfByte.useEncryption(bool1);
    return paramArrayOfByte;
  }
  
  public byte[] encode()
  {
    boolean bool = this.dataDescriptorFlag;
    int k = 0;
    int i;
    if (bool) {
      i = 8;
    } else {
      i = 0;
    }
    int j;
    if (this.languageEncodingFlag) {
      j = 2048;
    } else {
      j = 0;
    }
    bool = this.encryptionFlag;
    if (this.strongEncryptionFlag) {
      k = 64;
    }
    return ZipShort.getBytes(i | j | bool | k);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof GeneralPurposeBit;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (GeneralPurposeBit)paramObject;
    bool1 = bool2;
    if (paramObject.encryptionFlag == this.encryptionFlag)
    {
      bool1 = bool2;
      if (paramObject.strongEncryptionFlag == this.strongEncryptionFlag)
      {
        bool1 = bool2;
        if (paramObject.languageEncodingFlag == this.languageEncodingFlag)
        {
          bool1 = bool2;
          if (paramObject.dataDescriptorFlag == this.dataDescriptorFlag) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void useDataDescriptor(boolean paramBoolean)
  {
    this.dataDescriptorFlag = paramBoolean;
  }
  
  public void useEncryption(boolean paramBoolean)
  {
    this.encryptionFlag = paramBoolean;
  }
  
  public void useStrongEncryption(boolean paramBoolean)
  {
    this.strongEncryptionFlag = paramBoolean;
    if (paramBoolean) {
      useEncryption(true);
    }
  }
  
  public void useUTF8ForNames(boolean paramBoolean)
  {
    this.languageEncodingFlag = paramBoolean;
  }
  
  public boolean usesDataDescriptor()
  {
    return this.dataDescriptorFlag;
  }
  
  public boolean usesEncryption()
  {
    return this.encryptionFlag;
  }
  
  public boolean usesStrongEncryption()
  {
    return (this.encryptionFlag) && (this.strongEncryptionFlag);
  }
  
  public boolean usesUTF8ForNames()
  {
    return this.languageEncodingFlag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.GeneralPurposeBit
 * JD-Core Version:    0.7.0.1
 */