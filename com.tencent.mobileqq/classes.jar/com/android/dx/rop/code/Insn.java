package com.android.dx.rop.code;

import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.ToHuman;

public abstract class Insn
  implements ToHuman
{
  private final Rop opcode;
  private final SourcePosition position;
  private final RegisterSpec result;
  private final RegisterSpecList sources;
  
  public Insn(Rop paramRop, SourcePosition paramSourcePosition, RegisterSpec paramRegisterSpec, RegisterSpecList paramRegisterSpecList)
  {
    if (paramRop == null) {
      throw new NullPointerException("opcode == null");
    }
    if (paramSourcePosition == null) {
      throw new NullPointerException("position == null");
    }
    if (paramRegisterSpecList == null) {
      throw new NullPointerException("sources == null");
    }
    this.opcode = paramRop;
    this.position = paramSourcePosition;
    this.result = paramRegisterSpec;
    this.sources = paramRegisterSpecList;
  }
  
  private static boolean equalsHandleNulls(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public abstract void accept(Insn.Visitor paramVisitor);
  
  public final boolean canThrow()
  {
    return this.opcode.canThrow();
  }
  
  public boolean contentEquals(Insn paramInsn)
  {
    return (this.opcode == paramInsn.getOpcode()) && (this.position.equals(paramInsn.getPosition())) && (getClass() == paramInsn.getClass()) && (equalsHandleNulls(this.result, paramInsn.getResult())) && (equalsHandleNulls(this.sources, paramInsn.getSources())) && (StdTypeList.equalContents(getCatches(), paramInsn.getCatches()));
  }
  
  public Insn copy()
  {
    return withRegisterOffset(0);
  }
  
  public final boolean equals(Object paramObject)
  {
    return this == paramObject;
  }
  
  public abstract TypeList getCatches();
  
  public String getInlineString()
  {
    return null;
  }
  
  public final RegisterSpec getLocalAssignment()
  {
    RegisterSpec localRegisterSpec;
    if (this.opcode.getOpcode() == 54)
    {
      localRegisterSpec = this.sources.get(0);
      if (localRegisterSpec != null) {
        break label35;
      }
    }
    label35:
    while (localRegisterSpec.getLocalItem() == null)
    {
      return null;
      localRegisterSpec = this.result;
      break;
    }
    return localRegisterSpec;
  }
  
  public final Rop getOpcode()
  {
    return this.opcode;
  }
  
  public final SourcePosition getPosition()
  {
    return this.position;
  }
  
  public final RegisterSpec getResult()
  {
    return this.result;
  }
  
  public final RegisterSpecList getSources()
  {
    return this.sources;
  }
  
  public final int hashCode()
  {
    return System.identityHashCode(this);
  }
  
  public String toHuman()
  {
    return toHumanWithInline(getInlineString());
  }
  
  protected final String toHumanWithInline(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(80);
    localStringBuffer.append(this.position);
    localStringBuffer.append(": ");
    localStringBuffer.append(this.opcode.getNickname());
    if (paramString != null)
    {
      localStringBuffer.append("(");
      localStringBuffer.append(paramString);
      localStringBuffer.append(")");
    }
    int j;
    if (this.result == null)
    {
      localStringBuffer.append(" .");
      localStringBuffer.append(" <-");
      j = this.sources.size();
      if (j != 0) {
        break label142;
      }
      localStringBuffer.append(" .");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(" ");
      localStringBuffer.append(this.result.toHuman());
      break;
      label142:
      int i = 0;
      while (i < j)
      {
        localStringBuffer.append(" ");
        localStringBuffer.append(this.sources.get(i).toHuman());
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    return toStringWithInline(getInlineString());
  }
  
  protected final String toStringWithInline(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(80);
    localStringBuffer.append("Insn{");
    localStringBuffer.append(this.position);
    localStringBuffer.append(' ');
    localStringBuffer.append(this.opcode);
    if (paramString != null)
    {
      localStringBuffer.append(' ');
      localStringBuffer.append(paramString);
    }
    localStringBuffer.append(" :: ");
    if (this.result != null)
    {
      localStringBuffer.append(this.result);
      localStringBuffer.append(" <- ");
    }
    localStringBuffer.append(this.sources);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public abstract Insn withAddedCatch(Type paramType);
  
  public abstract Insn withNewRegisters(RegisterSpec paramRegisterSpec, RegisterSpecList paramRegisterSpecList);
  
  public abstract Insn withRegisterOffset(int paramInt);
  
  public Insn withSourceLiteral()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.Insn
 * JD-Core Version:    0.7.0.1
 */