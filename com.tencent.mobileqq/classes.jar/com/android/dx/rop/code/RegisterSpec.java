package com.android.dx.rop.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.ToHuman;
import java.util.HashMap;

public final class RegisterSpec
  implements TypeBearer, ToHuman, Comparable<RegisterSpec>
{
  public static final String PREFIX = "v";
  private static final RegisterSpec.ForComparison theInterningItem = new RegisterSpec.ForComparison(null);
  private static final HashMap<Object, RegisterSpec> theInterns = new HashMap(1000);
  private final LocalItem local;
  private final int reg;
  private final TypeBearer type;
  
  private RegisterSpec(int paramInt, TypeBearer paramTypeBearer, LocalItem paramLocalItem)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("reg < 0");
    }
    if (paramTypeBearer == null) {
      throw new NullPointerException("type == null");
    }
    this.reg = paramInt;
    this.type = paramTypeBearer;
    this.local = paramLocalItem;
  }
  
  private boolean equals(int paramInt, TypeBearer paramTypeBearer, LocalItem paramLocalItem)
  {
    return (this.reg == paramInt) && (this.type.equals(paramTypeBearer)) && ((this.local == paramLocalItem) || ((this.local != null) && (this.local.equals(paramLocalItem))));
  }
  
  private static int hashCodeOf(int paramInt, TypeBearer paramTypeBearer, LocalItem paramLocalItem)
  {
    if (paramLocalItem != null) {}
    for (int i = paramLocalItem.hashCode();; i = 0) {
      return (i * 31 + paramTypeBearer.hashCode()) * 31 + paramInt;
    }
  }
  
  private static RegisterSpec intern(int paramInt, TypeBearer paramTypeBearer, LocalItem paramLocalItem)
  {
    synchronized (theInterns)
    {
      theInterningItem.set(paramInt, paramTypeBearer, paramLocalItem);
      paramTypeBearer = (RegisterSpec)theInterns.get(theInterningItem);
      if (paramTypeBearer != null) {
        return paramTypeBearer;
      }
      paramTypeBearer = theInterningItem.toRegisterSpec();
      theInterns.put(paramTypeBearer, paramTypeBearer);
      return paramTypeBearer;
    }
  }
  
  public static RegisterSpec make(int paramInt, TypeBearer paramTypeBearer)
  {
    return intern(paramInt, paramTypeBearer, null);
  }
  
  public static RegisterSpec make(int paramInt, TypeBearer paramTypeBearer, LocalItem paramLocalItem)
  {
    if (paramLocalItem == null) {
      throw new NullPointerException("local  == null");
    }
    return intern(paramInt, paramTypeBearer, paramLocalItem);
  }
  
  public static RegisterSpec makeLocalOptional(int paramInt, TypeBearer paramTypeBearer, LocalItem paramLocalItem)
  {
    return intern(paramInt, paramTypeBearer, paramLocalItem);
  }
  
  public static String regString(int paramInt)
  {
    return "v" + paramInt;
  }
  
  private String toString0(boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer(40);
    localStringBuffer.append(regString());
    localStringBuffer.append(":");
    if (this.local != null) {
      localStringBuffer.append(this.local.toString());
    }
    Type localType = this.type.getType();
    localStringBuffer.append(localType);
    if (localType != this.type)
    {
      localStringBuffer.append("=");
      if ((!paramBoolean) || (!(this.type instanceof CstString))) {
        break label110;
      }
      localStringBuffer.append(((CstString)this.type).toQuoted());
    }
    for (;;)
    {
      return localStringBuffer.toString();
      label110:
      if ((paramBoolean) && ((this.type instanceof Constant))) {
        localStringBuffer.append(this.type.toHuman());
      } else {
        localStringBuffer.append(this.type);
      }
    }
  }
  
  public int compareTo(RegisterSpec paramRegisterSpec)
  {
    if (this.reg < paramRegisterSpec.reg) {}
    do
    {
      return -1;
      if (this.reg > paramRegisterSpec.reg) {
        return 1;
      }
      int i = this.type.getType().compareTo(paramRegisterSpec.type.getType());
      if (i != 0) {
        return i;
      }
      if (this.local != null) {
        break;
      }
    } while (paramRegisterSpec.local != null);
    return 0;
    if (paramRegisterSpec.local == null) {
      return 1;
    }
    return this.local.compareTo(paramRegisterSpec.local);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RegisterSpec))
    {
      if ((paramObject instanceof RegisterSpec.ForComparison))
      {
        paramObject = (RegisterSpec.ForComparison)paramObject;
        return equals(RegisterSpec.ForComparison.access$100(paramObject), RegisterSpec.ForComparison.access$200(paramObject), RegisterSpec.ForComparison.access$300(paramObject));
      }
      return false;
    }
    paramObject = (RegisterSpec)paramObject;
    return equals(paramObject.reg, paramObject.type, paramObject.local);
  }
  
  public boolean equalsUsingSimpleType(RegisterSpec paramRegisterSpec)
  {
    if (!matchesVariable(paramRegisterSpec)) {}
    while (this.reg != paramRegisterSpec.reg) {
      return false;
    }
    return true;
  }
  
  public final int getBasicFrameType()
  {
    return this.type.getBasicFrameType();
  }
  
  public final int getBasicType()
  {
    return this.type.getBasicType();
  }
  
  public int getCategory()
  {
    return this.type.getType().getCategory();
  }
  
  public TypeBearer getFrameType()
  {
    return this.type.getFrameType();
  }
  
  public LocalItem getLocalItem()
  {
    return this.local;
  }
  
  public int getNextReg()
  {
    return this.reg + getCategory();
  }
  
  public int getReg()
  {
    return this.reg;
  }
  
  public Type getType()
  {
    return this.type.getType();
  }
  
  public TypeBearer getTypeBearer()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return hashCodeOf(this.reg, this.type, this.local);
  }
  
  public RegisterSpec intersect(RegisterSpec paramRegisterSpec, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this == paramRegisterSpec) {
      localObject1 = this;
    }
    LocalItem localLocalItem;
    int i;
    label72:
    Type localType;
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject1;
            localObject1 = localObject2;
          } while (paramRegisterSpec == null);
          localObject1 = localObject2;
        } while (this.reg != paramRegisterSpec.getReg());
        if ((this.local != null) && (this.local.equals(paramRegisterSpec.getLocalItem()))) {
          break label136;
        }
        localLocalItem = null;
        if (localLocalItem != this.local) {
          break label145;
        }
        i = 1;
        if (!paramBoolean) {
          break;
        }
        localObject1 = localObject2;
      } while (i == 0);
      localType = getType();
      localObject1 = localObject2;
    } while (localType != paramRegisterSpec.getType());
    if (this.type.equals(paramRegisterSpec.getTypeBearer())) {}
    for (paramRegisterSpec = this.type;; paramRegisterSpec = localType)
    {
      if ((paramRegisterSpec != this.type) || (i == 0)) {
        break label156;
      }
      return this;
      label136:
      localLocalItem = this.local;
      break;
      label145:
      i = 0;
      break label72;
    }
    label156:
    if (localLocalItem == null) {}
    for (paramRegisterSpec = make(this.reg, paramRegisterSpec);; paramRegisterSpec = make(this.reg, paramRegisterSpec, localLocalItem)) {
      return paramRegisterSpec;
    }
  }
  
  public boolean isCategory1()
  {
    return this.type.getType().isCategory1();
  }
  
  public boolean isCategory2()
  {
    return this.type.getType().isCategory2();
  }
  
  public final boolean isConstant()
  {
    return false;
  }
  
  public boolean isEvenRegister()
  {
    return (getReg() & 0x1) == 0;
  }
  
  public boolean matchesVariable(RegisterSpec paramRegisterSpec)
  {
    if (paramRegisterSpec == null) {}
    while ((!this.type.getType().equals(paramRegisterSpec.type.getType())) || ((this.local != paramRegisterSpec.local) && ((this.local == null) || (!this.local.equals(paramRegisterSpec.local))))) {
      return false;
    }
    return true;
  }
  
  public String regString()
  {
    return regString(this.reg);
  }
  
  public String toHuman()
  {
    return toString0(true);
  }
  
  public String toString()
  {
    return toString0(false);
  }
  
  public RegisterSpec withLocalItem(LocalItem paramLocalItem)
  {
    if ((this.local == paramLocalItem) || ((this.local != null) && (this.local.equals(paramLocalItem)))) {
      return this;
    }
    return makeLocalOptional(this.reg, this.type, paramLocalItem);
  }
  
  public RegisterSpec withOffset(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    return withReg(this.reg + paramInt);
  }
  
  public RegisterSpec withReg(int paramInt)
  {
    if (this.reg == paramInt) {
      return this;
    }
    return makeLocalOptional(paramInt, this.type, this.local);
  }
  
  public RegisterSpec withSimpleType()
  {
    TypeBearer localTypeBearer = this.type;
    if ((localTypeBearer instanceof Type)) {}
    Type localType2;
    for (Type localType1 = (Type)localTypeBearer;; localType1 = localTypeBearer.getType())
    {
      localType2 = localType1;
      if (localType1.isUninitialized()) {
        localType2 = localType1.getInitializedType();
      }
      if (localType2 != localTypeBearer) {
        break;
      }
      return this;
    }
    return makeLocalOptional(this.reg, localType2, this.local);
  }
  
  public RegisterSpec withType(TypeBearer paramTypeBearer)
  {
    return makeLocalOptional(this.reg, paramTypeBearer, this.local);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.RegisterSpec
 * JD-Core Version:    0.7.0.1
 */