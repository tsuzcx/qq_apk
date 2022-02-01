package com.android.dx.cf.code;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.Type;
import java.util.ArrayList;

public abstract interface Machine
{
  public abstract void auxCstArg(Constant paramConstant);
  
  public abstract void auxInitValues(ArrayList<Constant> paramArrayList);
  
  public abstract void auxIntArg(int paramInt);
  
  public abstract void auxSwitchArg(SwitchList paramSwitchList);
  
  public abstract void auxTargetArg(int paramInt);
  
  public abstract void auxType(Type paramType);
  
  public abstract void clearArgs();
  
  public abstract Prototype getPrototype();
  
  public abstract void localArg(Frame paramFrame, int paramInt);
  
  public abstract void localInfo(boolean paramBoolean);
  
  public abstract void localTarget(int paramInt, Type paramType, LocalItem paramLocalItem);
  
  public abstract void popArgs(Frame paramFrame, int paramInt);
  
  public abstract void popArgs(Frame paramFrame, Prototype paramPrototype);
  
  public abstract void popArgs(Frame paramFrame, Type paramType);
  
  public abstract void popArgs(Frame paramFrame, Type paramType1, Type paramType2);
  
  public abstract void popArgs(Frame paramFrame, Type paramType1, Type paramType2, Type paramType3);
  
  public abstract void run(Frame paramFrame, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Machine
 * JD-Core Version:    0.7.0.1
 */