package com.android.dx.cf.code;

import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;

public final class Merger
{
  public static boolean isPossiblyAssignableFrom(TypeBearer paramTypeBearer1, TypeBearer paramTypeBearer2)
  {
    boolean bool = false;
    paramTypeBearer1 = paramTypeBearer1.getType();
    paramTypeBearer2 = paramTypeBearer2.getType();
    if (paramTypeBearer1.equals(paramTypeBearer2)) {
      return true;
    }
    int i = paramTypeBearer1.getBasicType();
    int j = paramTypeBearer2.getBasicType();
    if (i == 10)
    {
      paramTypeBearer1 = Type.OBJECT;
      i = 9;
    }
    for (;;)
    {
      if (j == 10)
      {
        paramTypeBearer2 = Type.OBJECT;
        j = 9;
      }
      for (;;)
      {
        if ((i != 9) || (j != 9))
        {
          if ((paramTypeBearer1.isIntlike()) && (paramTypeBearer2.isIntlike())) {
            break;
          }
          return false;
        }
        if (paramTypeBearer1 == Type.KNOWN_NULL) {
          return false;
        }
        if ((paramTypeBearer2 == Type.KNOWN_NULL) || (paramTypeBearer1 == Type.OBJECT)) {
          break;
        }
        if (paramTypeBearer1.isArray())
        {
          if (!paramTypeBearer2.isArray()) {
            return false;
          }
          Type localType1;
          Type localType2;
          do
          {
            localType1 = paramTypeBearer1.getComponentType();
            localType2 = paramTypeBearer2.getComponentType();
            if (!localType1.isArray()) {
              break;
            }
            paramTypeBearer2 = localType2;
            paramTypeBearer1 = localType1;
          } while (localType2.isArray());
          return isPossiblyAssignableFrom(localType1, localType2);
        }
        if (!paramTypeBearer2.isArray()) {
          break;
        }
        if ((paramTypeBearer1 == Type.SERIALIZABLE) || (paramTypeBearer1 == Type.CLONEABLE)) {
          bool = true;
        }
        return bool;
      }
    }
  }
  
  public static OneLocalsArray mergeLocals(OneLocalsArray paramOneLocalsArray1, OneLocalsArray paramOneLocalsArray2)
  {
    if (paramOneLocalsArray1 == paramOneLocalsArray2) {}
    Object localObject1;
    label107:
    do
    {
      return paramOneLocalsArray1;
      int j = paramOneLocalsArray1.getMaxLocals();
      if (paramOneLocalsArray2.getMaxLocals() != j) {
        throw new SimException("mismatched maxLocals values");
      }
      localObject1 = null;
      int i = 0;
      if (i < j)
      {
        TypeBearer localTypeBearer2 = paramOneLocalsArray1.getOrNull(i);
        TypeBearer localTypeBearer1 = mergeType(localTypeBearer2, paramOneLocalsArray2.getOrNull(i));
        Object localObject2 = localObject1;
        if (localTypeBearer1 != localTypeBearer2)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = paramOneLocalsArray1.copy();
          }
          if (localTypeBearer1 != null) {
            break label107;
          }
          ((OneLocalsArray)localObject2).invalidate(i);
        }
        for (;;)
        {
          i += 1;
          localObject1 = localObject2;
          break;
          ((OneLocalsArray)localObject2).set(i, localTypeBearer1);
        }
      }
    } while (localObject1 == null);
    localObject1.setImmutable();
    return localObject1;
  }
  
  public static ExecutionStack mergeStack(ExecutionStack paramExecutionStack1, ExecutionStack paramExecutionStack2)
  {
    if (paramExecutionStack1 == paramExecutionStack2) {}
    Object localObject1;
    do
    {
      return paramExecutionStack1;
      int j = paramExecutionStack1.size();
      if (paramExecutionStack2.size() != j) {
        throw new SimException("mismatched stack depths");
      }
      localObject1 = null;
      int i = 0;
      while (i < j)
      {
        TypeBearer localTypeBearer1 = paramExecutionStack1.peek(i);
        TypeBearer localTypeBearer2 = paramExecutionStack2.peek(i);
        TypeBearer localTypeBearer3 = mergeType(localTypeBearer1, localTypeBearer2);
        Object localObject2 = localObject1;
        if (localTypeBearer3 != localTypeBearer1)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = paramExecutionStack1.copy();
          }
          if (localTypeBearer3 == null) {
            try
            {
              throw new SimException("incompatible: " + localTypeBearer1 + ", " + localTypeBearer2);
            }
            catch (SimException paramExecutionStack1)
            {
              paramExecutionStack1.addContext("...while merging stack[" + Hex.u2(i) + "]");
              throw paramExecutionStack1;
            }
          }
          ((ExecutionStack)localObject2).change(i, localTypeBearer3);
        }
        i += 1;
        localObject1 = localObject2;
      }
    } while (localObject1 == null);
    localObject1.setImmutable();
    return localObject1;
  }
  
  public static TypeBearer mergeType(TypeBearer paramTypeBearer1, TypeBearer paramTypeBearer2)
  {
    TypeBearer localTypeBearer = paramTypeBearer1;
    if (paramTypeBearer1 != null)
    {
      if (!paramTypeBearer1.equals(paramTypeBearer2)) {
        break label18;
      }
      localTypeBearer = paramTypeBearer1;
    }
    label18:
    do
    {
      do
      {
        return localTypeBearer;
        if (paramTypeBearer2 == null) {
          return null;
        }
        paramTypeBearer1 = paramTypeBearer1.getType();
        paramTypeBearer2 = paramTypeBearer2.getType();
        localTypeBearer = paramTypeBearer1;
      } while (paramTypeBearer1 == paramTypeBearer2);
      if ((!paramTypeBearer1.isReference()) || (!paramTypeBearer2.isReference())) {
        break;
      }
      if (paramTypeBearer1 == Type.KNOWN_NULL) {
        return paramTypeBearer2;
      }
      localTypeBearer = paramTypeBearer1;
    } while (paramTypeBearer2 == Type.KNOWN_NULL);
    if ((paramTypeBearer1.isArray()) && (paramTypeBearer2.isArray()))
    {
      paramTypeBearer1 = mergeType(paramTypeBearer1.getComponentType(), paramTypeBearer2.getComponentType());
      if (paramTypeBearer1 == null) {
        return Type.OBJECT;
      }
      return ((Type)paramTypeBearer1).getArrayType();
    }
    return Type.OBJECT;
    if ((paramTypeBearer1.isIntlike()) && (paramTypeBearer2.isIntlike())) {
      return Type.INT;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Merger
 * JD-Core Version:    0.7.0.1
 */