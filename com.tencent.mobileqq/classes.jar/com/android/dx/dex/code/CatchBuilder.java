package com.android.dx.dex.code;

import com.android.dx.rop.type.Type;
import java.util.HashSet;

public abstract interface CatchBuilder
{
  public abstract CatchTable build();
  
  public abstract HashSet<Type> getCatchTypes();
  
  public abstract boolean hasAnyCatches();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.CatchBuilder
 * JD-Core Version:    0.7.0.1
 */