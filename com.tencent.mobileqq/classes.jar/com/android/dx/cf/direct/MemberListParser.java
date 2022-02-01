package com.android.dx.cf.direct;

import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.cf.iface.StdAttributeList;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;

abstract class MemberListParser
{
  private final AttributeFactory attributeFactory;
  private final DirectClassFile cf;
  private final CstType definer;
  private int endOffset;
  private ParseObserver observer;
  private final int offset;
  
  public MemberListParser(DirectClassFile paramDirectClassFile, CstType paramCstType, int paramInt, AttributeFactory paramAttributeFactory)
  {
    if (paramDirectClassFile == null) {
      throw new NullPointerException("cf == null");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("offset < 0");
    }
    if (paramAttributeFactory == null) {
      throw new NullPointerException("attributeFactory == null");
    }
    this.cf = paramDirectClassFile;
    this.definer = paramCstType;
    this.offset = paramInt;
    this.attributeFactory = paramAttributeFactory;
    this.endOffset = -1;
  }
  
  private void parse()
  {
    int k = getAttributeContext();
    int m = getCount();
    int j = this.offset + 2;
    ByteArray localByteArray = this.cf.getBytes();
    ConstantPool localConstantPool = this.cf.getConstantPool();
    if (this.observer != null) {
      this.observer.parsed(localByteArray, this.offset, 2, humanName() + "s_count: " + Hex.u2(m));
    }
    int i = 0;
    while (i < m) {
      try
      {
        int n = localByteArray.getUnsignedShort(j);
        int i1 = localByteArray.getUnsignedShort(j + 2);
        int i2 = localByteArray.getUnsignedShort(j + 4);
        CstString localCstString1 = (CstString)localConstantPool.get(i1);
        CstString localCstString2 = (CstString)localConstantPool.get(i2);
        if (this.observer != null)
        {
          this.observer.startParsingMember(localByteArray, j, localCstString1.getString(), localCstString2.getString());
          this.observer.parsed(localByteArray, j, 0, "\n" + humanName() + "s[" + i + "]:\n");
          this.observer.changeIndent(1);
          this.observer.parsed(localByteArray, j, 2, "access_flags: " + humanAccessFlags(n));
          this.observer.parsed(localByteArray, j + 2, 2, "name: " + localCstString1.toHuman());
          this.observer.parsed(localByteArray, j + 4, 2, "descriptor: " + localCstString2.toHuman());
        }
        Object localObject = new AttributeListParser(this.cf, k, j + 6, this.attributeFactory);
        ((AttributeListParser)localObject).setObserver(this.observer);
        j = ((AttributeListParser)localObject).getEndOffset();
        localObject = ((AttributeListParser)localObject).getList();
        ((StdAttributeList)localObject).setImmutable();
        localObject = set(i, n, new CstNat(localCstString1, localCstString2), (AttributeList)localObject);
        if (this.observer != null)
        {
          this.observer.changeIndent(-1);
          this.observer.parsed(localByteArray, j, 0, "end " + humanName() + "s[" + i + "]\n");
          this.observer.endParsingMember(localByteArray, j, localCstString1.getString(), localCstString2.getString(), (Member)localObject);
        }
        i += 1;
      }
      catch (ParseException localParseException1)
      {
        localParseException1.addContext("...while parsing " + humanName() + "s[" + i + "]");
        throw localParseException1;
      }
      catch (RuntimeException localRuntimeException)
      {
        ParseException localParseException2 = new ParseException(localRuntimeException);
        localParseException2.addContext("...while parsing " + humanName() + "s[" + i + "]");
        throw localParseException2;
      }
    }
    this.endOffset = j;
  }
  
  protected abstract int getAttributeContext();
  
  protected final int getCount()
  {
    return this.cf.getBytes().getUnsignedShort(this.offset);
  }
  
  protected final CstType getDefiner()
  {
    return this.definer;
  }
  
  public int getEndOffset()
  {
    parseIfNecessary();
    return this.endOffset;
  }
  
  protected abstract String humanAccessFlags(int paramInt);
  
  protected abstract String humanName();
  
  protected final void parseIfNecessary()
  {
    if (this.endOffset < 0) {
      parse();
    }
  }
  
  protected abstract Member set(int paramInt1, int paramInt2, CstNat paramCstNat, AttributeList paramAttributeList);
  
  public final void setObserver(ParseObserver paramParseObserver)
  {
    this.observer = paramParseObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.MemberListParser
 * JD-Core Version:    0.7.0.1
 */