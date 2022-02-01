package com.android.dx.cf.cst;

import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstInterfaceMethodRef;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.StdConstantPool;
import com.android.dx.rop.type.Type;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import java.util.BitSet;

public final class ConstantPoolParser
{
  private final ByteArray bytes;
  private int endOffset;
  private ParseObserver observer;
  private final int[] offsets;
  private final StdConstantPool pool;
  
  public ConstantPoolParser(ByteArray paramByteArray)
  {
    int i = paramByteArray.getUnsignedShort(8);
    this.bytes = paramByteArray;
    this.pool = new StdConstantPool(i);
    this.offsets = new int[i];
    this.endOffset = -1;
  }
  
  private void determineOffsets()
  {
    int i = 10;
    int k = 1;
    if (k < this.offsets.length)
    {
      this.offsets[k] = i;
      int j = this.bytes.getUnsignedByte(i);
      switch (j)
      {
      case 2: 
      case 13: 
      case 14: 
      case 17: 
      default: 
        try
        {
          throw new ParseException("unknown tag byte: " + Hex.u1(j));
        }
        catch (ParseException localParseException)
        {
          localParseException.addContext("...while preparsing cst " + Hex.u2(k) + " at offset " + Hex.u4(i));
          throw localParseException;
        }
      case 3: 
      case 4: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
        i += 5;
        j = 1;
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 1: 
        for (;;)
        {
          k += j;
          break;
          j = 2;
          i += 9;
          continue;
          i += 3;
          j = 1;
          continue;
          j = i + (this.bytes.getUnsignedShort(i + 1) + 3);
          int m = 1;
          i = j;
          j = m;
        }
      case 15: 
        throw new ParseException("MethodHandle not supported");
      case 16: 
        throw new ParseException("MethodType not supported");
      }
      throw new ParseException("InvokeDynamic not supported");
    }
    this.endOffset = i;
  }
  
  private void parse()
  {
    int j = 1;
    determineOffsets();
    if (this.observer != null)
    {
      this.observer.parsed(this.bytes, 8, 2, "constant_pool_count: " + Hex.u2(this.offsets.length));
      this.observer.parsed(this.bytes, 10, 0, "\nconstant_pool:");
      this.observer.changeIndent(1);
    }
    BitSet localBitSet = new BitSet(this.offsets.length);
    int i = 1;
    while (i < this.offsets.length)
    {
      if ((this.offsets[i] != 0) && (this.pool.getOrNull(i) == null)) {
        parse0(i, localBitSet);
      }
      i += 1;
    }
    Object localObject;
    int n;
    int k;
    label200:
    int m;
    if (this.observer != null)
    {
      i = j;
      for (;;)
      {
        if (i < this.offsets.length)
        {
          localObject = this.pool.getOrNull(i);
          if (localObject == null)
          {
            i += 1;
          }
          else
          {
            n = this.offsets[i];
            k = this.endOffset;
            j = i + 1;
            if (j >= this.offsets.length) {
              break label368;
            }
            m = this.offsets[j];
            if (m == 0) {
              break;
            }
          }
        }
      }
    }
    label368:
    for (j = m;; j = k)
    {
      if (localBitSet.get(i)) {}
      for (localObject = Hex.u2(i) + ": utf8{\"" + ((Constant)localObject).toHuman() + "\"}";; localObject = Hex.u2(i) + ": " + localObject.toString())
      {
        this.observer.parsed(this.bytes, n, j - n, (String)localObject);
        break;
        j += 1;
        break label200;
      }
      this.observer.changeIndent(-1);
      this.observer.parsed(this.bytes, this.endOffset, 0, "end constant_pool");
      return;
    }
  }
  
  private Constant parse0(int paramInt, BitSet paramBitSet)
  {
    Object localObject = this.pool.getOrNull(paramInt);
    if (localObject != null) {
      return localObject;
    }
    int i = this.offsets[paramInt];
    for (;;)
    {
      try
      {
        int j = this.bytes.getUnsignedByte(i);
        switch (j)
        {
        case 2: 
        case 13: 
        case 14: 
        case 17: 
          throw new ParseException("unknown tag byte: " + Hex.u1(j));
        }
      }
      catch (ParseException paramBitSet)
      {
        paramBitSet.addContext("...while parsing cst " + Hex.u2(paramInt) + " at offset " + Hex.u4(i));
        throw paramBitSet;
        localObject = parseUtf8(i);
        paramBitSet.set(paramInt);
        paramBitSet = (BitSet)localObject;
        this.pool.set(paramInt, paramBitSet);
        return paramBitSet;
        paramBitSet = CstInteger.make(this.bytes.getInt(i + 1));
        continue;
        paramBitSet = CstFloat.make(this.bytes.getInt(i + 1));
        continue;
        paramBitSet = CstLong.make(this.bytes.getLong(i + 1));
        continue;
        paramBitSet = CstDouble.make(this.bytes.getLong(i + 1));
        continue;
        paramBitSet = new CstType(Type.internClassName(((CstString)parse0(this.bytes.getUnsignedShort(i + 1), paramBitSet)).getString()));
        continue;
        paramBitSet = parse0(this.bytes.getUnsignedShort(i + 1), paramBitSet);
        continue;
        paramBitSet = new CstFieldRef((CstType)parse0(this.bytes.getUnsignedShort(i + 1), paramBitSet), (CstNat)parse0(this.bytes.getUnsignedShort(i + 3), paramBitSet));
        continue;
        paramBitSet = new CstMethodRef((CstType)parse0(this.bytes.getUnsignedShort(i + 1), paramBitSet), (CstNat)parse0(this.bytes.getUnsignedShort(i + 3), paramBitSet));
        continue;
        paramBitSet = new CstInterfaceMethodRef((CstType)parse0(this.bytes.getUnsignedShort(i + 1), paramBitSet), (CstNat)parse0(this.bytes.getUnsignedShort(i + 3), paramBitSet));
        continue;
        paramBitSet = new CstNat((CstString)parse0(this.bytes.getUnsignedShort(i + 1), paramBitSet), (CstString)parse0(this.bytes.getUnsignedShort(i + 3), paramBitSet));
        continue;
        throw new ParseException("MethodHandle not supported");
      }
      catch (RuntimeException paramBitSet)
      {
        paramBitSet = new ParseException(paramBitSet);
        paramBitSet.addContext("...while parsing cst " + Hex.u2(paramInt) + " at offset " + Hex.u4(i));
        throw paramBitSet;
      }
      throw new ParseException("MethodType not supported");
      throw new ParseException("InvokeDynamic not supported");
    }
  }
  
  private void parseIfNecessary()
  {
    if (this.endOffset < 0) {
      parse();
    }
  }
  
  private CstString parseUtf8(int paramInt)
  {
    int i = this.bytes.getUnsignedShort(paramInt + 1);
    paramInt += 3;
    Object localObject = this.bytes.slice(paramInt, i + paramInt);
    try
    {
      localObject = new CstString((ByteArray)localObject);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ParseException(localIllegalArgumentException);
    }
  }
  
  public int getEndOffset()
  {
    parseIfNecessary();
    return this.endOffset;
  }
  
  public StdConstantPool getPool()
  {
    parseIfNecessary();
    return this.pool;
  }
  
  public void setObserver(ParseObserver paramParseObserver)
  {
    this.observer = paramParseObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.cst.ConstantPoolParser
 * JD-Core Version:    0.7.0.1
 */