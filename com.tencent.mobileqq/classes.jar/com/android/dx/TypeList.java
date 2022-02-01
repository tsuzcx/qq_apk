package com.android.dx;

import com.android.dx.rop.type.StdTypeList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class TypeList
{
  final StdTypeList ropTypes;
  final TypeId<?>[] types;
  
  TypeList(TypeId<?>[] paramArrayOfTypeId)
  {
    this.types = ((TypeId[])paramArrayOfTypeId.clone());
    this.ropTypes = new StdTypeList(paramArrayOfTypeId.length);
    int i = 0;
    while (i < paramArrayOfTypeId.length)
    {
      this.ropTypes.set(i, paramArrayOfTypeId[i].ropType);
      i += 1;
    }
  }
  
  public List<TypeId<?>> asList()
  {
    return Collections.unmodifiableList(Arrays.asList(this.types));
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof TypeList)) && (Arrays.equals(((TypeList)paramObject).types, this.types));
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.types);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.types.length)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(this.types[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.TypeList
 * JD-Core Version:    0.7.0.1
 */