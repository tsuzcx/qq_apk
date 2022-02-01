package com.android.dx.rop.code;

import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.Hex;

public final class Rop
{
  public static final int BRANCH_GOTO = 3;
  public static final int BRANCH_IF = 4;
  public static final int BRANCH_MAX = 6;
  public static final int BRANCH_MIN = 1;
  public static final int BRANCH_NONE = 1;
  public static final int BRANCH_RETURN = 2;
  public static final int BRANCH_SWITCH = 5;
  public static final int BRANCH_THROW = 6;
  private final int branchingness;
  private final TypeList exceptions;
  private final boolean isCallLike;
  private final String nickname;
  private final int opcode;
  private final Type result;
  private final TypeList sources;
  
  public Rop(int paramInt1, Type paramType, TypeList paramTypeList, int paramInt2, String paramString)
  {
    this(paramInt1, paramType, paramTypeList, StdTypeList.EMPTY, paramInt2, false, paramString);
  }
  
  public Rop(int paramInt1, Type paramType, TypeList paramTypeList1, TypeList paramTypeList2, int paramInt2, String paramString)
  {
    this(paramInt1, paramType, paramTypeList1, paramTypeList2, paramInt2, false, paramString);
  }
  
  public Rop(int paramInt1, Type paramType, TypeList paramTypeList1, TypeList paramTypeList2, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramType == null) {
      throw new NullPointerException("result == null");
    }
    if (paramTypeList1 == null) {
      throw new NullPointerException("sources == null");
    }
    if (paramTypeList2 == null) {
      throw new NullPointerException("exceptions == null");
    }
    if ((paramInt2 < 1) || (paramInt2 > 6)) {
      throw new IllegalArgumentException("bogus branchingness");
    }
    if ((paramTypeList2.size() != 0) && (paramInt2 != 6)) {
      throw new IllegalArgumentException("exceptions / branchingness mismatch");
    }
    this.opcode = paramInt1;
    this.result = paramType;
    this.sources = paramTypeList1;
    this.exceptions = paramTypeList2;
    this.branchingness = paramInt2;
    this.isCallLike = paramBoolean;
    this.nickname = paramString;
  }
  
  public Rop(int paramInt, Type paramType, TypeList paramTypeList1, TypeList paramTypeList2, String paramString)
  {
    this(paramInt, paramType, paramTypeList1, paramTypeList2, 6, false, paramString);
  }
  
  public Rop(int paramInt, Type paramType, TypeList paramTypeList, String paramString)
  {
    this(paramInt, paramType, paramTypeList, StdTypeList.EMPTY, 1, false, paramString);
  }
  
  public Rop(int paramInt, TypeList paramTypeList1, TypeList paramTypeList2)
  {
    this(paramInt, Type.VOID, paramTypeList1, paramTypeList2, 6, true, null);
  }
  
  public final boolean canThrow()
  {
    return this.exceptions.size() != 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Rop)) {
        return false;
      }
      paramObject = (Rop)paramObject;
    } while ((this.opcode == paramObject.opcode) && (this.branchingness == paramObject.branchingness) && (this.result == paramObject.result) && (this.sources.equals(paramObject.sources)) && (this.exceptions.equals(paramObject.exceptions)));
    return false;
  }
  
  public int getBranchingness()
  {
    return this.branchingness;
  }
  
  public TypeList getExceptions()
  {
    return this.exceptions;
  }
  
  public String getNickname()
  {
    if (this.nickname != null) {
      return this.nickname;
    }
    return toString();
  }
  
  public int getOpcode()
  {
    return this.opcode;
  }
  
  public Type getResult()
  {
    return this.result;
  }
  
  public TypeList getSources()
  {
    return this.sources;
  }
  
  public int hashCode()
  {
    return (((this.opcode * 31 + this.branchingness) * 31 + this.result.hashCode()) * 31 + this.sources.hashCode()) * 31 + this.exceptions.hashCode();
  }
  
  public boolean isCallLike()
  {
    return this.isCallLike;
  }
  
  public boolean isCommutative()
  {
    switch (this.opcode)
    {
    case 15: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer(40);
    localStringBuffer.append("Rop{");
    localStringBuffer.append(RegOps.opName(this.opcode));
    int k;
    label92:
    int i;
    if (this.result != Type.VOID)
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(this.result);
      localStringBuffer.append(" <-");
      k = this.sources.size();
      if (k != 0) {
        break label186;
      }
      localStringBuffer.append(" .");
      if (this.isCallLike) {
        localStringBuffer.append(" call");
      }
      k = this.exceptions.size();
      if (k == 0) {
        break label243;
      }
      localStringBuffer.append(" throws");
      i = j;
      label131:
      if (i >= k) {
        break label311;
      }
      localStringBuffer.append(' ');
      if (this.exceptions.getType(i) != Type.THROWABLE) {
        break label224;
      }
      localStringBuffer.append("<any>");
    }
    for (;;)
    {
      i += 1;
      break label131;
      localStringBuffer.append(" .");
      break;
      label186:
      i = 0;
      while (i < k)
      {
        localStringBuffer.append(' ');
        localStringBuffer.append(this.sources.getType(i));
        i += 1;
      }
      break label92;
      label224:
      localStringBuffer.append(this.exceptions.getType(i));
    }
    label243:
    switch (this.branchingness)
    {
    default: 
      localStringBuffer.append(" " + Hex.u1(this.branchingness));
    }
    for (;;)
    {
      label311:
      localStringBuffer.append('}');
      return localStringBuffer.toString();
      localStringBuffer.append(" flows");
      continue;
      localStringBuffer.append(" returns");
      continue;
      localStringBuffer.append(" gotos");
      continue;
      localStringBuffer.append(" ifs");
      continue;
      localStringBuffer.append(" switches");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.Rop
 * JD-Core Version:    0.7.0.1
 */