package com.android.dx.cf.direct;

import com.android.dx.cf.attrib.RawAttribute;
import com.android.dx.cf.iface.Attribute;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstString;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;

public class AttributeFactory
{
  public static final int CTX_CLASS = 0;
  public static final int CTX_CODE = 3;
  public static final int CTX_COUNT = 4;
  public static final int CTX_FIELD = 1;
  public static final int CTX_METHOD = 2;
  
  public final Attribute parse(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramDirectClassFile == null) {
      throw new NullPointerException("cf == null");
    }
    if ((paramInt1 < 0) || (paramInt1 >= 4)) {
      throw new IllegalArgumentException("bad context");
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      ByteArray localByteArray = paramDirectClassFile.getBytes();
      localObject1 = localObject2;
      ConstantPool localConstantPool = paramDirectClassFile.getConstantPool();
      localObject1 = localObject2;
      int i = localByteArray.getUnsignedShort(paramInt2);
      localObject1 = localObject2;
      int j = localByteArray.getInt(paramInt2 + 2);
      localObject1 = localObject2;
      localObject2 = (CstString)localConstantPool.get(i);
      if (paramParseObserver != null)
      {
        localObject1 = localObject2;
        paramParseObserver.parsed(localByteArray, paramInt2, 2, "name: " + ((CstString)localObject2).toHuman());
        localObject1 = localObject2;
        paramParseObserver.parsed(localByteArray, paramInt2 + 2, 4, "length: " + Hex.u4(j));
      }
      localObject1 = localObject2;
      paramDirectClassFile = parse0(paramDirectClassFile, paramInt1, ((CstString)localObject2).getString(), paramInt2 + 6, j, paramParseObserver);
      return paramDirectClassFile;
    }
    catch (ParseException paramParseObserver)
    {
      localObject2 = new StringBuilder().append("...while parsing ");
      if (localObject1 == null) {}
    }
    for (paramDirectClassFile = localObject1.toHuman() + " ";; paramDirectClassFile = "")
    {
      paramParseObserver.addContext(paramDirectClassFile + "attribute at offset " + Hex.u4(paramInt2));
      throw paramParseObserver;
    }
  }
  
  protected Attribute parse0(DirectClassFile paramDirectClassFile, int paramInt1, String paramString, int paramInt2, int paramInt3, ParseObserver paramParseObserver)
  {
    ByteArray localByteArray = paramDirectClassFile.getBytes();
    paramDirectClassFile = new RawAttribute(paramString, localByteArray, paramInt2, paramInt3, paramDirectClassFile.getConstantPool());
    if (paramParseObserver != null) {
      paramParseObserver.parsed(localByteArray, paramInt2, paramInt3, "attribute data");
    }
    return paramDirectClassFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.AttributeFactory
 * JD-Core Version:    0.7.0.1
 */