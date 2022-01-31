package com.google.gson.reflect;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal..Gson.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeToken<T>
{
  final int hashCode;
  final Class<? super T> rawType;
  final Type type;
  
  protected TypeToken()
  {
    this.type = getSuperclassTypeParameter(getClass());
    this.rawType = .Gson.Types.getRawType(this.type);
    this.hashCode = this.type.hashCode();
  }
  
  TypeToken(Type paramType)
  {
    this.type = .Gson.Types.canonicalize((Type).Gson.Preconditions.checkNotNull(paramType));
    this.rawType = .Gson.Types.getRawType(this.type);
    this.hashCode = this.type.hashCode();
  }
  
  private static AssertionError buildUnexpectedTypeError(Type paramType, Class<?>... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramVarArgs[i].getName()).append(", ");
      i += 1;
    }
    localStringBuilder.append("but got: ").append(paramType.getClass().getName()).append(", for type token: ").append(paramType.toString()).append('.');
    return new AssertionError(localStringBuilder.toString());
  }
  
  public static <T> TypeToken<T> get(Class<T> paramClass)
  {
    return new TypeToken(paramClass);
  }
  
  public static TypeToken<?> get(Type paramType)
  {
    return new TypeToken(paramType);
  }
  
  public static TypeToken<?> getArray(Type paramType)
  {
    return new TypeToken(.Gson.Types.arrayOf(paramType));
  }
  
  public static TypeToken<?> getParameterized(Type paramType, Type... paramVarArgs)
  {
    return new TypeToken(.Gson.Types.newParameterizedTypeWithOwner(null, paramType, paramVarArgs));
  }
  
  static Type getSuperclassTypeParameter(Class<?> paramClass)
  {
    paramClass = paramClass.getGenericSuperclass();
    if ((paramClass instanceof Class)) {
      throw new RuntimeException("Missing type parameter.");
    }
    return .Gson.Types.canonicalize(((ParameterizedType)paramClass).getActualTypeArguments()[0]);
  }
  
  private static boolean isAssignableFrom(Type paramType, GenericArrayType paramGenericArrayType)
  {
    Type localType = paramGenericArrayType.getGenericComponentType();
    if ((localType instanceof ParameterizedType))
    {
      if ((paramType instanceof GenericArrayType)) {
        paramGenericArrayType = ((GenericArrayType)paramType).getGenericComponentType();
      }
      do
      {
        return isAssignableFrom(paramGenericArrayType, (ParameterizedType)localType, new HashMap());
        paramGenericArrayType = paramType;
      } while (!(paramType instanceof Class));
      for (paramType = (Class)paramType;; paramType = paramType.getComponentType())
      {
        paramGenericArrayType = paramType;
        if (!paramType.isArray()) {
          break;
        }
      }
    }
    return true;
  }
  
  private static boolean isAssignableFrom(Type paramType, ParameterizedType paramParameterizedType, Map<String, Type> paramMap)
  {
    int j = 0;
    if (paramType == null) {
      return false;
    }
    if (paramParameterizedType.equals(paramType)) {
      return true;
    }
    Class localClass = .Gson.Types.getRawType(paramType);
    if ((paramType instanceof ParameterizedType)) {}
    for (paramType = (ParameterizedType)paramType;; paramType = null)
    {
      if (paramType != null)
      {
        Type[] arrayOfType = paramType.getActualTypeArguments();
        TypeVariable[] arrayOfTypeVariable = localClass.getTypeParameters();
        i = 0;
        while (i < arrayOfType.length)
        {
          Type localType = arrayOfType[i];
          TypeVariable localTypeVariable = arrayOfTypeVariable[i];
          while ((localType instanceof TypeVariable)) {
            localType = (Type)paramMap.get(((TypeVariable)localType).getName());
          }
          paramMap.put(localTypeVariable.getName(), localType);
          i += 1;
        }
        if (typeEquals(paramType, paramParameterizedType, paramMap)) {
          return true;
        }
      }
      paramType = localClass.getGenericInterfaces();
      int k = paramType.length;
      int i = j;
      while (i < k)
      {
        if (isAssignableFrom(paramType[i], paramParameterizedType, new HashMap(paramMap))) {
          return true;
        }
        i += 1;
      }
      return isAssignableFrom(localClass.getGenericSuperclass(), paramParameterizedType, new HashMap(paramMap));
    }
  }
  
  private static boolean matches(Type paramType1, Type paramType2, Map<String, Type> paramMap)
  {
    return (paramType2.equals(paramType1)) || (((paramType1 instanceof TypeVariable)) && (paramType2.equals(paramMap.get(((TypeVariable)paramType1).getName()))));
  }
  
  private static boolean typeEquals(ParameterizedType paramParameterizedType1, ParameterizedType paramParameterizedType2, Map<String, Type> paramMap)
  {
    int i;
    if (paramParameterizedType1.getRawType().equals(paramParameterizedType2.getRawType()))
    {
      paramParameterizedType1 = paramParameterizedType1.getActualTypeArguments();
      paramParameterizedType2 = paramParameterizedType2.getActualTypeArguments();
      i = 0;
    }
    while (i < paramParameterizedType1.length)
    {
      if (!matches(paramParameterizedType1[i], paramParameterizedType2[i], paramMap)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof TypeToken)) && (.Gson.Types.equals(this.type, ((TypeToken)paramObject).type));
  }
  
  public final Class<? super T> getRawType()
  {
    return this.rawType;
  }
  
  public final Type getType()
  {
    return this.type;
  }
  
  public final int hashCode()
  {
    return this.hashCode;
  }
  
  @Deprecated
  public boolean isAssignableFrom(TypeToken<?> paramTypeToken)
  {
    return isAssignableFrom(paramTypeToken.getType());
  }
  
  @Deprecated
  public boolean isAssignableFrom(Class<?> paramClass)
  {
    return isAssignableFrom(paramClass);
  }
  
  @Deprecated
  public boolean isAssignableFrom(Type paramType)
  {
    if (paramType == null) {
      return false;
    }
    if (this.type.equals(paramType)) {
      return true;
    }
    if ((this.type instanceof Class)) {
      return this.rawType.isAssignableFrom(.Gson.Types.getRawType(paramType));
    }
    if ((this.type instanceof ParameterizedType)) {
      return isAssignableFrom(paramType, (ParameterizedType)this.type, new HashMap());
    }
    if ((this.type instanceof GenericArrayType))
    {
      if ((this.rawType.isAssignableFrom(.Gson.Types.getRawType(paramType))) && (isAssignableFrom(paramType, (GenericArrayType)this.type))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    throw buildUnexpectedTypeError(this.type, new Class[] { Class.class, ParameterizedType.class, GenericArrayType.class });
  }
  
  public final String toString()
  {
    return .Gson.Types.typeToString(this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.reflect.TypeToken
 * JD-Core Version:    0.7.0.1
 */