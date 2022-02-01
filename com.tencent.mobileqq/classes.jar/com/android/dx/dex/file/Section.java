package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;
import java.util.Collection;

public abstract class Section
{
  private final int alignment;
  private final DexFile file;
  private int fileOffset;
  private final String name;
  private boolean prepared;
  
  public Section(String paramString, DexFile paramDexFile, int paramInt)
  {
    if (paramDexFile == null) {
      throw new NullPointerException("file == null");
    }
    validateAlignment(paramInt);
    this.name = paramString;
    this.file = paramDexFile;
    this.alignment = paramInt;
    this.fileOffset = -1;
    this.prepared = false;
  }
  
  public static void validateAlignment(int paramInt)
  {
    if ((paramInt <= 0) || ((paramInt - 1 & paramInt) != 0)) {
      throw new IllegalArgumentException("invalid alignment");
    }
  }
  
  protected final void align(AnnotatedOutput paramAnnotatedOutput)
  {
    paramAnnotatedOutput.alignTo(this.alignment);
  }
  
  public abstract int getAbsoluteItemOffset(Item paramItem);
  
  public final int getAbsoluteOffset(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("relative < 0");
    }
    if (this.fileOffset < 0) {
      throw new RuntimeException("fileOffset not yet set");
    }
    return this.fileOffset + paramInt;
  }
  
  public final int getAlignment()
  {
    return this.alignment;
  }
  
  public final DexFile getFile()
  {
    return this.file;
  }
  
  public final int getFileOffset()
  {
    if (this.fileOffset < 0) {
      throw new RuntimeException("fileOffset not set");
    }
    return this.fileOffset;
  }
  
  protected final String getName()
  {
    return this.name;
  }
  
  public abstract Collection<? extends Item> items();
  
  public final void prepare()
  {
    throwIfPrepared();
    prepare0();
    this.prepared = true;
  }
  
  protected abstract void prepare0();
  
  public final int setFileOffset(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("fileOffset < 0");
    }
    if (this.fileOffset >= 0) {
      throw new RuntimeException("fileOffset already set");
    }
    int i = this.alignment - 1;
    paramInt = (i ^ 0xFFFFFFFF) & paramInt + i;
    this.fileOffset = paramInt;
    return paramInt;
  }
  
  protected final void throwIfNotPrepared()
  {
    if (!this.prepared) {
      throw new RuntimeException("not prepared");
    }
  }
  
  protected final void throwIfPrepared()
  {
    if (this.prepared) {
      throw new RuntimeException("already prepared");
    }
  }
  
  public abstract int writeSize();
  
  public final void writeTo(AnnotatedOutput paramAnnotatedOutput)
  {
    throwIfNotPrepared();
    align(paramAnnotatedOutput);
    int i = paramAnnotatedOutput.getCursor();
    if (this.fileOffset < 0)
    {
      this.fileOffset = i;
      if (paramAnnotatedOutput.annotates())
      {
        if (this.name == null) {
          break label140;
        }
        paramAnnotatedOutput.annotate(0, "\n" + this.name + ":");
      }
    }
    for (;;)
    {
      writeTo0(paramAnnotatedOutput);
      return;
      if (this.fileOffset == i) {
        break;
      }
      throw new RuntimeException("alignment mismatch: for " + this + ", at " + i + ", but expected " + this.fileOffset);
      label140:
      if (i != 0) {
        paramAnnotatedOutput.annotate(0, "\n");
      }
    }
  }
  
  protected abstract void writeTo0(AnnotatedOutput paramAnnotatedOutput);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.Section
 * JD-Core Version:    0.7.0.1
 */