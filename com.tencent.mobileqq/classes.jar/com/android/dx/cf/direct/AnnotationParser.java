package com.android.dx.cf.direct;

import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.AnnotationVisibility;
import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.rop.annotation.NameValuePair;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstAnnotation;
import com.android.dx.rop.cst.CstArray;
import com.android.dx.rop.cst.CstArray.List;
import com.android.dx.rop.cst.CstBoolean;
import com.android.dx.rop.cst.CstByte;
import com.android.dx.rop.cst.CstChar;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstEnumRef;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstShort;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.ByteArray;
import com.android.dx.util.ByteArray.MyDataInputStream;
import com.android.dx.util.Hex;
import java.io.IOException;

public final class AnnotationParser
{
  private final ByteArray bytes;
  private final DirectClassFile cf;
  private final ByteArray.MyDataInputStream input;
  private final ParseObserver observer;
  private int parseCursor;
  private final ConstantPool pool;
  
  public AnnotationParser(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramDirectClassFile == null) {
      throw new NullPointerException("cf == null");
    }
    this.cf = paramDirectClassFile;
    this.pool = paramDirectClassFile.getConstantPool();
    this.observer = paramParseObserver;
    this.bytes = paramDirectClassFile.getBytes().slice(paramInt1, paramInt1 + paramInt2);
    this.input = this.bytes.makeDataInputStream();
    this.parseCursor = 0;
  }
  
  private void changeIndent(int paramInt)
  {
    this.observer.changeIndent(paramInt);
  }
  
  private Annotation parseAnnotation(AnnotationVisibility paramAnnotationVisibility)
  {
    requireLength(4);
    int i = this.input.readUnsignedShort();
    int j = this.input.readUnsignedShort();
    CstType localCstType = new CstType(Type.intern(((CstString)this.pool.get(i)).getString()));
    if (this.observer != null)
    {
      parsed(2, "type: " + localCstType.toHuman());
      parsed(2, "num_elements: " + j);
    }
    paramAnnotationVisibility = new Annotation(localCstType, paramAnnotationVisibility);
    i = 0;
    while (i < j)
    {
      if (this.observer != null)
      {
        parsed(0, "elements[" + i + "]:");
        changeIndent(1);
      }
      paramAnnotationVisibility.add(parseElement());
      if (this.observer != null) {
        changeIndent(-1);
      }
      i += 1;
    }
    paramAnnotationVisibility.setImmutable();
    return paramAnnotationVisibility;
  }
  
  private Annotations parseAnnotations(AnnotationVisibility paramAnnotationVisibility)
  {
    int j = this.input.readUnsignedShort();
    if (this.observer != null) {
      parsed(2, "num_annotations: " + Hex.u2(j));
    }
    Annotations localAnnotations = new Annotations();
    int i = 0;
    while (i < j)
    {
      if (this.observer != null)
      {
        parsed(0, "annotations[" + i + "]:");
        changeIndent(1);
      }
      localAnnotations.add(parseAnnotation(paramAnnotationVisibility));
      if (this.observer != null) {
        this.observer.changeIndent(-1);
      }
      i += 1;
    }
    localAnnotations.setImmutable();
    return localAnnotations;
  }
  
  private AnnotationsList parseAnnotationsList(AnnotationVisibility paramAnnotationVisibility)
  {
    int j = this.input.readUnsignedByte();
    if (this.observer != null) {
      parsed(1, "num_parameters: " + Hex.u1(j));
    }
    AnnotationsList localAnnotationsList = new AnnotationsList(j);
    int i = 0;
    while (i < j)
    {
      if (this.observer != null)
      {
        parsed(0, "parameter_annotations[" + i + "]:");
        changeIndent(1);
      }
      localAnnotationsList.set(i, parseAnnotations(paramAnnotationVisibility));
      if (this.observer != null) {
        this.observer.changeIndent(-1);
      }
      i += 1;
    }
    localAnnotationsList.setImmutable();
    return localAnnotationsList;
  }
  
  private Constant parseConstant()
  {
    int i = this.input.readUnsignedShort();
    Constant localConstant = this.pool.get(i);
    if (this.observer != null) {
      if (!(localConstant instanceof CstString)) {
        break label67;
      }
    }
    label67:
    for (String str = ((CstString)localConstant).toQuoted();; str = localConstant.toHuman())
    {
      parsed(2, "constant_value: " + str);
      return localConstant;
    }
  }
  
  private NameValuePair parseElement()
  {
    requireLength(5);
    int i = this.input.readUnsignedShort();
    CstString localCstString = (CstString)this.pool.get(i);
    if (this.observer != null)
    {
      parsed(2, "element_name: " + localCstString.toHuman());
      parsed(0, "value: ");
      changeIndent(1);
    }
    Constant localConstant = parseValue();
    if (this.observer != null) {
      changeIndent(-1);
    }
    return new NameValuePair(localCstString, localConstant);
  }
  
  private Constant parseValue()
  {
    int i = this.input.readUnsignedByte();
    if (this.observer != null)
    {
      localObject = new CstString(Character.toString((char)i));
      parsed(1, "tag: " + ((CstString)localObject).toQuoted());
    }
    switch (i)
    {
    default: 
      throw new ParseException("unknown annotation tag: " + Hex.u1(i));
    case 66: 
      return CstByte.make(((CstInteger)parseConstant()).getValue());
    case 67: 
      localObject = (CstInteger)parseConstant();
      ((CstInteger)localObject).getValue();
      return CstChar.make(((CstInteger)localObject).getValue());
    case 68: 
      return (CstDouble)parseConstant();
    case 70: 
      return (CstFloat)parseConstant();
    case 73: 
      return (CstInteger)parseConstant();
    case 74: 
      return (CstLong)parseConstant();
    case 83: 
      return CstShort.make(((CstInteger)parseConstant()).getValue());
    case 90: 
      return CstBoolean.make(((CstInteger)parseConstant()).getValue());
    case 99: 
      i = this.input.readUnsignedShort();
      localObject = Type.internReturnType(((CstString)this.pool.get(i)).getString());
      if (this.observer != null) {
        parsed(2, "class_info: " + ((Type)localObject).toHuman());
      }
      return new CstType((Type)localObject);
    case 115: 
      return parseConstant();
    case 101: 
      requireLength(4);
      i = this.input.readUnsignedShort();
      j = this.input.readUnsignedShort();
      localObject = (CstString)this.pool.get(i);
      CstString localCstString = (CstString)this.pool.get(j);
      if (this.observer != null)
      {
        parsed(2, "type_name: " + ((CstString)localObject).toHuman());
        parsed(2, "const_name: " + localCstString.toHuman());
      }
      return new CstEnumRef(new CstNat(localCstString, (CstString)localObject));
    case 64: 
      return new CstAnnotation(parseAnnotation(AnnotationVisibility.EMBEDDED));
    }
    requireLength(2);
    int j = this.input.readUnsignedShort();
    Object localObject = new CstArray.List(j);
    if (this.observer != null)
    {
      parsed(2, "num_values: " + j);
      changeIndent(1);
    }
    i = 0;
    while (i < j)
    {
      if (this.observer != null)
      {
        changeIndent(-1);
        parsed(0, "element_value[" + i + "]:");
        changeIndent(1);
      }
      ((CstArray.List)localObject).set(i, parseValue());
      i += 1;
    }
    if (this.observer != null) {
      changeIndent(-1);
    }
    ((CstArray.List)localObject).setImmutable();
    return new CstArray((CstArray.List)localObject);
  }
  
  private void parsed(int paramInt, String paramString)
  {
    this.observer.parsed(this.bytes, this.parseCursor, paramInt, paramString);
    this.parseCursor += paramInt;
  }
  
  private void requireLength(int paramInt)
  {
    if (this.input.available() < paramInt) {
      throw new ParseException("truncated annotation attribute");
    }
  }
  
  public Annotations parseAnnotationAttribute(AnnotationVisibility paramAnnotationVisibility)
  {
    try
    {
      paramAnnotationVisibility = parseAnnotations(paramAnnotationVisibility);
      if (this.input.available() != 0) {
        throw new ParseException("extra data in attribute");
      }
    }
    catch (IOException paramAnnotationVisibility)
    {
      throw new RuntimeException("shouldn't happen", paramAnnotationVisibility);
    }
    return paramAnnotationVisibility;
  }
  
  public AnnotationsList parseParameterAttribute(AnnotationVisibility paramAnnotationVisibility)
  {
    try
    {
      paramAnnotationVisibility = parseAnnotationsList(paramAnnotationVisibility);
      if (this.input.available() != 0) {
        throw new ParseException("extra data in attribute");
      }
    }
    catch (IOException paramAnnotationVisibility)
    {
      throw new RuntimeException("shouldn't happen", paramAnnotationVisibility);
    }
    return paramAnnotationVisibility;
  }
  
  public Constant parseValueAttribute()
  {
    try
    {
      Constant localConstant = parseValue();
      if (this.input.available() != 0) {
        throw new ParseException("extra data in attribute");
      }
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("shouldn't happen", localIOException);
    }
    return localIOException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.AnnotationParser
 * JD-Core Version:    0.7.0.1
 */