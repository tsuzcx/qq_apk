package com.android.dx.cf.direct;

import com.android.dx.cf.attrib.AttAnnotationDefault;
import com.android.dx.cf.attrib.AttCode;
import com.android.dx.cf.attrib.AttConstantValue;
import com.android.dx.cf.attrib.AttDeprecated;
import com.android.dx.cf.attrib.AttEnclosingMethod;
import com.android.dx.cf.attrib.AttExceptions;
import com.android.dx.cf.attrib.AttInnerClasses;
import com.android.dx.cf.attrib.AttLineNumberTable;
import com.android.dx.cf.attrib.AttLocalVariableTable;
import com.android.dx.cf.attrib.AttLocalVariableTypeTable;
import com.android.dx.cf.attrib.AttRuntimeInvisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeInvisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttSignature;
import com.android.dx.cf.attrib.AttSourceFile;
import com.android.dx.cf.attrib.AttSynthetic;
import com.android.dx.cf.attrib.InnerClassList;
import com.android.dx.cf.code.ByteCatchList;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.cf.code.LineNumberList;
import com.android.dx.cf.code.LocalVariableList;
import com.android.dx.cf.iface.Attribute;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.cf.iface.StdAttributeList;
import com.android.dx.rop.annotation.AnnotationVisibility;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.TypedConstant;
import com.android.dx.util.ByteArray;
import com.android.dx.util.ByteArray.MyDataInputStream;
import com.android.dx.util.Hex;
import java.io.IOException;

public class StdAttributeFactory
  extends AttributeFactory
{
  public static final StdAttributeFactory THE_ONE = new StdAttributeFactory();
  
  private Attribute annotationDefault(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 < 2) {
      throwSeverelyTruncated();
    }
    return new AttAnnotationDefault(new AnnotationParser(paramDirectClassFile, paramInt1, paramInt2, paramParseObserver).parseValueAttribute(), paramInt2);
  }
  
  private Attribute code(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 < 12) {
      return throwSeverelyTruncated();
    }
    ByteArray localByteArray = paramDirectClassFile.getBytes();
    ConstantPool localConstantPool = paramDirectClassFile.getConstantPool();
    int k = localByteArray.getUnsignedShort(paramInt1);
    int m = localByteArray.getUnsignedShort(paramInt1 + 2);
    int i = localByteArray.getInt(paramInt1 + 4);
    if (paramParseObserver != null)
    {
      paramParseObserver.parsed(localByteArray, paramInt1, 2, "max_stack: " + Hex.u2(k));
      paramParseObserver.parsed(localByteArray, paramInt1 + 2, 2, "max_locals: " + Hex.u2(m));
      paramParseObserver.parsed(localByteArray, paramInt1 + 4, 4, "code_length: " + Hex.u4(i));
    }
    int j = paramInt1 + 8;
    int i1 = paramInt2 - 8;
    if (i1 < i + 4) {
      return throwTruncated();
    }
    paramInt2 = j + i;
    BytecodeArray localBytecodeArray = new BytecodeArray(localByteArray.slice(j, i + j), localConstantPool);
    if (paramParseObserver != null) {
      localBytecodeArray.forEach(new CodeObserver(localBytecodeArray.getBytes(), paramParseObserver));
    }
    int n = localByteArray.getUnsignedShort(paramInt2);
    if (n == 0) {}
    for (ByteCatchList localByteCatchList = ByteCatchList.EMPTY;; localByteCatchList = new ByteCatchList(n))
    {
      if (paramParseObserver != null) {
        paramParseObserver.parsed(localByteArray, paramInt2, 2, "exception_table_length: " + Hex.u2(n));
      }
      i = i1 - i - 2;
      if (i >= n * 8 + 2) {
        break;
      }
      return throwTruncated();
    }
    j = 0;
    paramInt2 += 2;
    if (j < n)
    {
      if (paramParseObserver != null) {
        paramParseObserver.changeIndent(1);
      }
      i1 = localByteArray.getUnsignedShort(paramInt2);
      int i2 = localByteArray.getUnsignedShort(paramInt2 + 2);
      int i3 = localByteArray.getUnsignedShort(paramInt2 + 4);
      Object localObject = (CstType)localConstantPool.get0Ok(localByteArray.getUnsignedShort(paramInt2 + 6));
      localByteCatchList.set(j, i1, i2, i3, (CstType)localObject);
      StringBuilder localStringBuilder;
      if (paramParseObserver != null)
      {
        localStringBuilder = new StringBuilder().append(Hex.u2(i1)).append("..").append(Hex.u2(i2)).append(" -> ").append(Hex.u2(i3)).append(" ");
        if (localObject != null) {
          break label544;
        }
      }
      label544:
      for (localObject = "<any>";; localObject = ((CstType)localObject).toHuman())
      {
        paramParseObserver.parsed(localByteArray, paramInt2, 8, (String)localObject);
        if (paramParseObserver != null) {
          paramParseObserver.changeIndent(-1);
        }
        j += 1;
        i -= 8;
        paramInt2 += 8;
        break;
      }
    }
    localByteCatchList.setImmutable();
    paramDirectClassFile = new AttributeListParser(paramDirectClassFile, 3, paramInt2, this);
    paramDirectClassFile.setObserver(paramParseObserver);
    paramParseObserver = paramDirectClassFile.getList();
    paramParseObserver.setImmutable();
    j = paramDirectClassFile.getEndOffset() - paramInt2;
    if (j != i) {
      return throwBadLength(paramInt2 - paramInt1 + j);
    }
    return new AttCode(k, m, localBytecodeArray, localByteCatchList, paramParseObserver);
  }
  
  private Attribute constantValue(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 != 2) {
      return throwBadLength(2);
    }
    ByteArray localByteArray = paramDirectClassFile.getBytes();
    paramDirectClassFile = (TypedConstant)paramDirectClassFile.getConstantPool().get(localByteArray.getUnsignedShort(paramInt1));
    AttConstantValue localAttConstantValue = new AttConstantValue(paramDirectClassFile);
    if (paramParseObserver != null) {
      paramParseObserver.parsed(localByteArray, paramInt1, 2, "value: " + paramDirectClassFile);
    }
    return localAttConstantValue;
  }
  
  private Attribute deprecated(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 != 0) {
      return throwBadLength(0);
    }
    return new AttDeprecated();
  }
  
  private Attribute enclosingMethod(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 != 4) {
      throwBadLength(4);
    }
    ByteArray localByteArray = paramDirectClassFile.getBytes();
    Object localObject = paramDirectClassFile.getConstantPool();
    paramDirectClassFile = (CstType)((ConstantPool)localObject).get(localByteArray.getUnsignedShort(paramInt1));
    localObject = (CstNat)((ConstantPool)localObject).get0Ok(localByteArray.getUnsignedShort(paramInt1 + 2));
    AttEnclosingMethod localAttEnclosingMethod = new AttEnclosingMethod(paramDirectClassFile, (CstNat)localObject);
    if (paramParseObserver != null)
    {
      paramParseObserver.parsed(localByteArray, paramInt1, 2, "class: " + paramDirectClassFile);
      paramParseObserver.parsed(localByteArray, paramInt1 + 2, 2, "method: " + DirectClassFile.stringOrNone(localObject));
    }
    return localAttEnclosingMethod;
  }
  
  private Attribute exceptions(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 < 2) {
      return throwSeverelyTruncated();
    }
    ByteArray localByteArray = paramDirectClassFile.getBytes();
    int i = localByteArray.getUnsignedShort(paramInt1);
    if (paramParseObserver != null) {
      paramParseObserver.parsed(localByteArray, paramInt1, 2, "number_of_exceptions: " + Hex.u2(i));
    }
    if (paramInt2 - 2 != i * 2) {
      throwBadLength(i * 2 + 2);
    }
    return new AttExceptions(paramDirectClassFile.makeTypeList(paramInt1 + 2, i));
  }
  
  private Attribute innerClasses(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 < 2) {
      return throwSeverelyTruncated();
    }
    ByteArray localByteArray = paramDirectClassFile.getBytes();
    paramDirectClassFile = paramDirectClassFile.getConstantPool();
    int i = localByteArray.getUnsignedShort(paramInt1);
    if (paramParseObserver != null) {
      paramParseObserver.parsed(localByteArray, paramInt1, 2, "number_of_classes: " + Hex.u2(i));
    }
    if (paramInt2 - 2 != i * 8) {
      throwBadLength(i * 8 + 2);
    }
    InnerClassList localInnerClassList = new InnerClassList(i);
    paramInt2 = 0;
    paramInt1 += 2;
    while (paramInt2 < i)
    {
      int j = localByteArray.getUnsignedShort(paramInt1);
      int k = localByteArray.getUnsignedShort(paramInt1 + 2);
      int m = localByteArray.getUnsignedShort(paramInt1 + 4);
      int n = localByteArray.getUnsignedShort(paramInt1 + 6);
      CstType localCstType1 = (CstType)paramDirectClassFile.get(j);
      CstType localCstType2 = (CstType)paramDirectClassFile.get0Ok(k);
      CstString localCstString = (CstString)paramDirectClassFile.get0Ok(m);
      localInnerClassList.set(paramInt2, localCstType1, localCstType2, localCstString, n);
      if (paramParseObserver != null)
      {
        paramParseObserver.parsed(localByteArray, paramInt1, 2, "inner_class: " + DirectClassFile.stringOrNone(localCstType1));
        paramParseObserver.parsed(localByteArray, paramInt1 + 2, 2, "  outer_class: " + DirectClassFile.stringOrNone(localCstType2));
        paramParseObserver.parsed(localByteArray, paramInt1 + 4, 2, "  name: " + DirectClassFile.stringOrNone(localCstString));
        paramParseObserver.parsed(localByteArray, paramInt1 + 6, 2, "  access_flags: " + AccessFlags.innerClassString(n));
      }
      paramInt2 += 1;
      paramInt1 += 8;
    }
    localInnerClassList.setImmutable();
    return new AttInnerClasses(localInnerClassList);
  }
  
  private Attribute lineNumberTable(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 < 2) {
      return throwSeverelyTruncated();
    }
    paramDirectClassFile = paramDirectClassFile.getBytes();
    int j = paramDirectClassFile.getUnsignedShort(paramInt1);
    if (paramParseObserver != null) {
      paramParseObserver.parsed(paramDirectClassFile, paramInt1, 2, "line_number_table_length: " + Hex.u2(j));
    }
    paramInt1 += 2;
    if (paramInt2 - 2 != j * 4) {
      throwBadLength(j * 4 + 2);
    }
    LineNumberList localLineNumberList = new LineNumberList(j);
    int i = 0;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt1 < j)
    {
      i = paramDirectClassFile.getUnsignedShort(paramInt2);
      int k = paramDirectClassFile.getUnsignedShort(paramInt2 + 2);
      localLineNumberList.set(paramInt1, i, k);
      if (paramParseObserver != null) {
        paramParseObserver.parsed(paramDirectClassFile, paramInt2, 4, Hex.u2(i) + " " + k);
      }
      paramInt2 += 4;
      paramInt1 += 1;
    }
    localLineNumberList.setImmutable();
    return new AttLineNumberTable(localLineNumberList);
  }
  
  private Attribute localVariableTable(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 < 2) {
      return throwSeverelyTruncated();
    }
    ByteArray localByteArray = paramDirectClassFile.getBytes();
    int i = localByteArray.getUnsignedShort(paramInt1);
    if (paramParseObserver != null) {
      paramParseObserver.parsed(localByteArray, paramInt1, 2, "local_variable_table_length: " + Hex.u2(i));
    }
    return new AttLocalVariableTable(parseLocalVariables(localByteArray.slice(paramInt1 + 2, paramInt1 + paramInt2), paramDirectClassFile.getConstantPool(), paramParseObserver, i, false));
  }
  
  private Attribute localVariableTypeTable(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 < 2) {
      return throwSeverelyTruncated();
    }
    ByteArray localByteArray = paramDirectClassFile.getBytes();
    int i = localByteArray.getUnsignedShort(paramInt1);
    if (paramParseObserver != null) {
      paramParseObserver.parsed(localByteArray, paramInt1, 2, "local_variable_type_table_length: " + Hex.u2(i));
    }
    return new AttLocalVariableTypeTable(parseLocalVariables(localByteArray.slice(paramInt1 + 2, paramInt1 + paramInt2), paramDirectClassFile.getConstantPool(), paramParseObserver, i, true));
  }
  
  private LocalVariableList parseLocalVariables(ByteArray paramByteArray, ConstantPool paramConstantPool, ParseObserver paramParseObserver, int paramInt, boolean paramBoolean)
  {
    if (paramByteArray.size() != paramInt * 10) {
      throwBadLength(paramInt * 10 + 2);
    }
    ByteArray.MyDataInputStream localMyDataInputStream = paramByteArray.makeDataInputStream();
    LocalVariableList localLocalVariableList = new LocalVariableList(paramInt);
    int i = 0;
    while (i < paramInt) {
      try
      {
        int j = localMyDataInputStream.readUnsignedShort();
        int k = localMyDataInputStream.readUnsignedShort();
        int m = localMyDataInputStream.readUnsignedShort();
        int n = localMyDataInputStream.readUnsignedShort();
        int i1 = localMyDataInputStream.readUnsignedShort();
        CstString localCstString4 = (CstString)paramConstantPool.get(m);
        CstString localCstString1 = (CstString)paramConstantPool.get(n);
        CstString localCstString2 = null;
        CstString localCstString3 = null;
        if (paramBoolean) {
          localCstString3 = localCstString1;
        }
        for (;;)
        {
          localLocalVariableList.set(i, j, k, localCstString4, localCstString2, localCstString3, i1);
          if (paramParseObserver != null) {
            paramParseObserver.parsed(paramByteArray, i * 10, 10, Hex.u2(j) + ".." + Hex.u2(j + k) + " " + Hex.u2(i1) + " " + localCstString4.toHuman() + " " + localCstString1.toHuman());
          }
          i += 1;
          break;
          localCstString2 = localCstString1;
        }
        localLocalVariableList.setImmutable();
      }
      catch (IOException paramByteArray)
      {
        throw new RuntimeException("shouldn't happen", paramByteArray);
      }
    }
    return localLocalVariableList;
  }
  
  private Attribute runtimeInvisibleAnnotations(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 < 2) {
      throwSeverelyTruncated();
    }
    return new AttRuntimeInvisibleAnnotations(new AnnotationParser(paramDirectClassFile, paramInt1, paramInt2, paramParseObserver).parseAnnotationAttribute(AnnotationVisibility.BUILD), paramInt2);
  }
  
  private Attribute runtimeInvisibleParameterAnnotations(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 < 2) {
      throwSeverelyTruncated();
    }
    return new AttRuntimeInvisibleParameterAnnotations(new AnnotationParser(paramDirectClassFile, paramInt1, paramInt2, paramParseObserver).parseParameterAttribute(AnnotationVisibility.BUILD), paramInt2);
  }
  
  private Attribute runtimeVisibleAnnotations(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 < 2) {
      throwSeverelyTruncated();
    }
    return new AttRuntimeVisibleAnnotations(new AnnotationParser(paramDirectClassFile, paramInt1, paramInt2, paramParseObserver).parseAnnotationAttribute(AnnotationVisibility.RUNTIME), paramInt2);
  }
  
  private Attribute runtimeVisibleParameterAnnotations(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 < 2) {
      throwSeverelyTruncated();
    }
    return new AttRuntimeVisibleParameterAnnotations(new AnnotationParser(paramDirectClassFile, paramInt1, paramInt2, paramParseObserver).parseParameterAttribute(AnnotationVisibility.RUNTIME), paramInt2);
  }
  
  private Attribute signature(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 != 2) {
      throwBadLength(2);
    }
    ByteArray localByteArray = paramDirectClassFile.getBytes();
    paramDirectClassFile = (CstString)paramDirectClassFile.getConstantPool().get(localByteArray.getUnsignedShort(paramInt1));
    AttSignature localAttSignature = new AttSignature(paramDirectClassFile);
    if (paramParseObserver != null) {
      paramParseObserver.parsed(localByteArray, paramInt1, 2, "signature: " + paramDirectClassFile);
    }
    return localAttSignature;
  }
  
  private Attribute sourceFile(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 != 2) {
      throwBadLength(2);
    }
    ByteArray localByteArray = paramDirectClassFile.getBytes();
    paramDirectClassFile = (CstString)paramDirectClassFile.getConstantPool().get(localByteArray.getUnsignedShort(paramInt1));
    AttSourceFile localAttSourceFile = new AttSourceFile(paramDirectClassFile);
    if (paramParseObserver != null) {
      paramParseObserver.parsed(localByteArray, paramInt1, 2, "source: " + paramDirectClassFile);
    }
    return localAttSourceFile;
  }
  
  private Attribute synthetic(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, ParseObserver paramParseObserver)
  {
    if (paramInt2 != 0) {
      return throwBadLength(0);
    }
    return new AttSynthetic();
  }
  
  private static Attribute throwBadLength(int paramInt)
  {
    throw new ParseException("bad attribute length; expected length " + Hex.u4(paramInt));
  }
  
  private static Attribute throwSeverelyTruncated()
  {
    throw new ParseException("severely truncated attribute");
  }
  
  private static Attribute throwTruncated()
  {
    throw new ParseException("truncated attribute");
  }
  
  protected Attribute parse0(DirectClassFile paramDirectClassFile, int paramInt1, String paramString, int paramInt2, int paramInt3, ParseObserver paramParseObserver)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return super.parse0(paramDirectClassFile, paramInt1, paramString, paramInt2, paramInt3, paramParseObserver);
            if (paramString == "Deprecated") {
              return deprecated(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
            }
            if (paramString == "EnclosingMethod") {
              return enclosingMethod(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
            }
            if (paramString == "InnerClasses") {
              return innerClasses(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
            }
            if (paramString == "RuntimeInvisibleAnnotations") {
              return runtimeInvisibleAnnotations(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
            }
            if (paramString == "RuntimeVisibleAnnotations") {
              return runtimeVisibleAnnotations(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
            }
            if (paramString == "Synthetic") {
              return synthetic(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
            }
            if (paramString == "Signature") {
              return signature(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
            }
          } while (paramString != "SourceFile");
          return sourceFile(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
          if (paramString == "ConstantValue") {
            return constantValue(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
          }
          if (paramString == "Deprecated") {
            return deprecated(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
          }
          if (paramString == "RuntimeInvisibleAnnotations") {
            return runtimeInvisibleAnnotations(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
          }
          if (paramString == "RuntimeVisibleAnnotations") {
            return runtimeVisibleAnnotations(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
          }
          if (paramString == "Signature") {
            return signature(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
          }
        } while (paramString != "Synthetic");
        return synthetic(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
        if (paramString == "AnnotationDefault") {
          return annotationDefault(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
        }
        if (paramString == "Code") {
          return code(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
        }
        if (paramString == "Deprecated") {
          return deprecated(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
        }
        if (paramString == "Exceptions") {
          return exceptions(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
        }
        if (paramString == "RuntimeInvisibleAnnotations") {
          return runtimeInvisibleAnnotations(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
        }
        if (paramString == "RuntimeVisibleAnnotations") {
          return runtimeVisibleAnnotations(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
        }
        if (paramString == "RuntimeInvisibleParameterAnnotations") {
          return runtimeInvisibleParameterAnnotations(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
        }
        if (paramString == "RuntimeVisibleParameterAnnotations") {
          return runtimeVisibleParameterAnnotations(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
        }
        if (paramString == "Signature") {
          return signature(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
        }
      } while (paramString != "Synthetic");
      return synthetic(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
      if (paramString == "LineNumberTable") {
        return lineNumberTable(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
      }
      if (paramString == "LocalVariableTable") {
        return localVariableTable(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
      }
    } while (paramString != "LocalVariableTypeTable");
    return localVariableTypeTable(paramDirectClassFile, paramInt2, paramInt3, paramParseObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.StdAttributeFactory
 * JD-Core Version:    0.7.0.1
 */