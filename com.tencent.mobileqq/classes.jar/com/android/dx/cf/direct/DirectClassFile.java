package com.android.dx.cf.direct;

import com.android.dx.cf.attrib.AttSourceFile;
import com.android.dx.cf.cst.ConstantPoolParser;
import com.android.dx.cf.iface.Attribute;
import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.ClassFile;
import com.android.dx.cf.iface.FieldList;
import com.android.dx.cf.iface.MethodList;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.cf.iface.StdAttributeList;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.StdConstantPool;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;

public class DirectClassFile
  implements ClassFile
{
  private static final int CLASS_FILE_MAGIC = -889275714;
  private static final int CLASS_FILE_MAX_MAJOR_VERSION = 51;
  private static final int CLASS_FILE_MAX_MINOR_VERSION = 0;
  private static final int CLASS_FILE_MIN_MAJOR_VERSION = 45;
  private int accessFlags;
  private AttributeFactory attributeFactory;
  private StdAttributeList attributes;
  private final ByteArray bytes;
  private FieldList fields;
  private final String filePath;
  private TypeList interfaces;
  private MethodList methods;
  private ParseObserver observer;
  private StdConstantPool pool;
  private final boolean strictParse;
  private CstType superClass;
  private CstType thisClass;
  
  public DirectClassFile(ByteArray paramByteArray, String paramString, boolean paramBoolean)
  {
    if (paramByteArray == null) {
      throw new NullPointerException("bytes == null");
    }
    if (paramString == null) {
      throw new NullPointerException("filePath == null");
    }
    this.filePath = paramString;
    this.bytes = paramByteArray;
    this.strictParse = paramBoolean;
    this.accessFlags = -1;
  }
  
  public DirectClassFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    this(new ByteArray(paramArrayOfByte), paramString, paramBoolean);
  }
  
  private boolean isGoodMagic(int paramInt)
  {
    return paramInt == -889275714;
  }
  
  private boolean isGoodVersion(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {
      if (paramInt2 == 51)
      {
        if (paramInt1 > 0) {}
      }
      else {
        while ((paramInt2 < 51) && (paramInt2 >= 45)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void parse()
  {
    try
    {
      parse0();
      return;
    }
    catch (ParseException localParseException1)
    {
      localParseException1.addContext("...while parsing " + this.filePath);
      throw localParseException1;
    }
    catch (RuntimeException localRuntimeException)
    {
      ParseException localParseException2 = new ParseException(localRuntimeException);
      localParseException2.addContext("...while parsing " + this.filePath);
      throw localParseException2;
    }
  }
  
  private void parse0()
  {
    if (this.bytes.size() < 10) {
      throw new ParseException("severely truncated class file");
    }
    if (this.observer != null)
    {
      this.observer.parsed(this.bytes, 0, 0, "begin classfile");
      this.observer.parsed(this.bytes, 0, 4, "magic: " + Hex.u4(getMagic0()));
      this.observer.parsed(this.bytes, 4, 2, "minor_version: " + Hex.u2(getMinorVersion0()));
      this.observer.parsed(this.bytes, 6, 2, "major_version: " + Hex.u2(getMajorVersion0()));
    }
    if (this.strictParse)
    {
      if (!isGoodMagic(getMagic0())) {
        throw new ParseException("bad class file magic (" + Hex.u4(getMagic0()) + ")");
      }
      if (!isGoodVersion(getMinorVersion0(), getMajorVersion0())) {
        throw new ParseException("unsupported class file version " + getMajorVersion0() + "." + getMinorVersion0());
      }
    }
    Object localObject = new ConstantPoolParser(this.bytes);
    ((ConstantPoolParser)localObject).setObserver(this.observer);
    this.pool = ((ConstantPoolParser)localObject).getPool();
    this.pool.setImmutable();
    int j = ((ConstantPoolParser)localObject).getEndOffset();
    int i = this.bytes.getUnsignedShort(j);
    int k = this.bytes.getUnsignedShort(j + 2);
    this.thisClass = ((CstType)this.pool.get(k));
    k = this.bytes.getUnsignedShort(j + 4);
    this.superClass = ((CstType)this.pool.get0Ok(k));
    k = this.bytes.getUnsignedShort(j + 6);
    if (this.observer != null)
    {
      this.observer.parsed(this.bytes, j, 2, "access_flags: " + AccessFlags.classString(i));
      this.observer.parsed(this.bytes, j + 2, 2, "this_class: " + this.thisClass);
      this.observer.parsed(this.bytes, j + 4, 2, "super_class: " + stringOrNone(this.superClass));
      this.observer.parsed(this.bytes, j + 6, 2, "interfaces_count: " + Hex.u2(k));
      if (k != 0) {
        this.observer.parsed(this.bytes, j + 8, 0, "interfaces:");
      }
    }
    j += 8;
    this.interfaces = makeTypeList(j, k);
    if (this.strictParse)
    {
      localObject = this.thisClass.getClassType().getClassName();
      if ((!this.filePath.endsWith(".class")) || (!this.filePath.startsWith((String)localObject)) || (this.filePath.length() != ((String)localObject).length() + 6)) {
        throw new ParseException("class name (" + (String)localObject + ") does not match path (" + this.filePath + ")");
      }
    }
    this.accessFlags = i;
    localObject = new FieldListParser(this, this.thisClass, k * 2 + j, this.attributeFactory);
    ((FieldListParser)localObject).setObserver(this.observer);
    this.fields = ((FieldListParser)localObject).getList();
    i = ((FieldListParser)localObject).getEndOffset();
    localObject = new MethodListParser(this, this.thisClass, i, this.attributeFactory);
    ((MethodListParser)localObject).setObserver(this.observer);
    this.methods = ((MethodListParser)localObject).getList();
    localObject = new AttributeListParser(this, 0, ((MethodListParser)localObject).getEndOffset(), this.attributeFactory);
    ((AttributeListParser)localObject).setObserver(this.observer);
    this.attributes = ((AttributeListParser)localObject).getList();
    this.attributes.setImmutable();
    i = ((AttributeListParser)localObject).getEndOffset();
    if (i != this.bytes.size()) {
      throw new ParseException("extra bytes at end of class file, at offset " + Hex.u4(i));
    }
    if (this.observer != null) {
      this.observer.parsed(this.bytes, i, 0, "end classfile");
    }
  }
  
  private void parseToEndIfNecessary()
  {
    if (this.attributes == null) {
      parse();
    }
  }
  
  private void parseToInterfacesIfNecessary()
  {
    if (this.accessFlags == -1) {
      parse();
    }
  }
  
  public static String stringOrNone(Object paramObject)
  {
    if (paramObject == null) {
      return "(none)";
    }
    return paramObject.toString();
  }
  
  public int getAccessFlags()
  {
    parseToInterfacesIfNecessary();
    return this.accessFlags;
  }
  
  public AttributeList getAttributes()
  {
    parseToEndIfNecessary();
    return this.attributes;
  }
  
  public ByteArray getBytes()
  {
    return this.bytes;
  }
  
  public ConstantPool getConstantPool()
  {
    parseToInterfacesIfNecessary();
    return this.pool;
  }
  
  public FieldList getFields()
  {
    parseToEndIfNecessary();
    return this.fields;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public TypeList getInterfaces()
  {
    parseToInterfacesIfNecessary();
    return this.interfaces;
  }
  
  public int getMagic()
  {
    parseToInterfacesIfNecessary();
    return getMagic0();
  }
  
  public int getMagic0()
  {
    return this.bytes.getInt(0);
  }
  
  public int getMajorVersion()
  {
    parseToInterfacesIfNecessary();
    return getMajorVersion0();
  }
  
  public int getMajorVersion0()
  {
    return this.bytes.getUnsignedShort(6);
  }
  
  public MethodList getMethods()
  {
    parseToEndIfNecessary();
    return this.methods;
  }
  
  public int getMinorVersion()
  {
    parseToInterfacesIfNecessary();
    return getMinorVersion0();
  }
  
  public int getMinorVersion0()
  {
    return this.bytes.getUnsignedShort(4);
  }
  
  public CstString getSourceFile()
  {
    Attribute localAttribute = getAttributes().findFirst("SourceFile");
    if ((localAttribute instanceof AttSourceFile)) {
      return ((AttSourceFile)localAttribute).getSourceFile();
    }
    return null;
  }
  
  public CstType getSuperclass()
  {
    parseToInterfacesIfNecessary();
    return this.superClass;
  }
  
  public CstType getThisClass()
  {
    parseToInterfacesIfNecessary();
    return this.thisClass;
  }
  
  public TypeList makeTypeList(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return StdTypeList.EMPTY;
    }
    if (this.pool == null) {
      throw new IllegalStateException("pool not yet initialized");
    }
    return new DirectClassFile.DcfTypeList(this.bytes, paramInt1, paramInt2, this.pool, this.observer);
  }
  
  public void setAttributeFactory(AttributeFactory paramAttributeFactory)
  {
    if (paramAttributeFactory == null) {
      throw new NullPointerException("attributeFactory == null");
    }
    this.attributeFactory = paramAttributeFactory;
  }
  
  public void setObserver(ParseObserver paramParseObserver)
  {
    this.observer = paramParseObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.DirectClassFile
 * JD-Core Version:    0.7.0.1
 */