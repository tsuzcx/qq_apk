package com.android.dex;

import com.android.dex.util.Unsigned;
import java.io.Serializable;
import java.util.List;

public final class TypeList
  implements Comparable<TypeList>
{
  public static final TypeList EMPTY = new TypeList(null, Dex.EMPTY_SHORT_ARRAY);
  private final Dex dex;
  private final short[] types;
  
  public TypeList(Dex paramDex, short[] paramArrayOfShort)
  {
    this.dex = paramDex;
    this.types = paramArrayOfShort;
  }
  
  public int compareTo(TypeList paramTypeList)
  {
    int i = 0;
    while ((i < this.types.length) && (i < paramTypeList.types.length))
    {
      if (this.types[i] != paramTypeList.types[i]) {
        return Unsigned.compare(this.types[i], paramTypeList.types[i]);
      }
      i += 1;
    }
    return Unsigned.compare(this.types.length, paramTypeList.types.length);
  }
  
  public short[] getTypes()
  {
    return this.types;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = this.types.length;
    int i = 0;
    if (i < j)
    {
      if (this.dex != null) {}
      for (Object localObject = (Serializable)this.dex.typeNames().get(this.types[i]);; localObject = Short.valueOf(this.types[i]))
      {
        localStringBuilder.append(localObject);
        i += 1;
        break;
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.TypeList
 * JD-Core Version:    0.7.0.1
 */