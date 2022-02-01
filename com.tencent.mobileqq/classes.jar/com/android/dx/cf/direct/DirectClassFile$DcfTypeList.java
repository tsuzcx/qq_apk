package com.android.dx.cf.direct;

import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.StdConstantPool;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.ByteArray;

class DirectClassFile$DcfTypeList
  implements TypeList
{
  private final ByteArray bytes;
  private final StdConstantPool pool;
  private final int size;
  
  public DirectClassFile$DcfTypeList(ByteArray paramByteArray, int paramInt1, int paramInt2, StdConstantPool paramStdConstantPool, ParseObserver paramParseObserver)
  {
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("size < 0");
    }
    paramByteArray = paramByteArray.slice(paramInt1, paramInt2 * 2 + paramInt1);
    this.bytes = paramByteArray;
    this.size = paramInt2;
    this.pool = paramStdConstantPool;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      int i = paramInt1 * 2;
      int j = paramByteArray.getUnsignedShort(i);
      try
      {
        CstType localCstType = (CstType)paramStdConstantPool.get(j);
        if (paramParseObserver != null) {
          paramParseObserver.parsed(paramByteArray, i, 2, "  " + localCstType);
        }
        paramInt1 += 1;
      }
      catch (ClassCastException paramByteArray)
      {
        throw new RuntimeException("bogus class cpi", paramByteArray);
      }
    }
  }
  
  public Type getType(int paramInt)
  {
    paramInt = this.bytes.getUnsignedShort(paramInt * 2);
    return ((CstType)this.pool.get(paramInt)).getClassType();
  }
  
  public int getWordCount()
  {
    return this.size;
  }
  
  public boolean isMutable()
  {
    return false;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public TypeList withAddedType(Type paramType)
  {
    throw new UnsupportedOperationException("unsupported");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.DirectClassFile.DcfTypeList
 * JD-Core Version:    0.7.0.1
 */