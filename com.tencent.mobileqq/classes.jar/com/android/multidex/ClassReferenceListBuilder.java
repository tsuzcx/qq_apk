package com.android.multidex;

import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.iface.Field;
import com.android.dx.cf.iface.FieldList;
import com.android.dx.cf.iface.Method;
import com.android.dx.cf.iface.MethodList;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstBaseMethodRef;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ClassReferenceListBuilder
{
  private static final String CLASS_EXTENSION = ".class";
  private final Set<String> classNames = new HashSet();
  private final Path path;
  
  static
  {
    if (!ClassReferenceListBuilder.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ClassReferenceListBuilder(Path paramPath)
  {
    this.path = paramPath;
  }
  
  private void addClassWithHierachy(String paramString)
  {
    if (this.classNames.contains(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        DirectClassFile localDirectClassFile = this.path.getClass(paramString + ".class");
        this.classNames.add(paramString);
        paramString = localDirectClassFile.getSuperclass();
        if (paramString != null) {
          addClassWithHierachy(paramString.getClassType().getClassName());
        }
        paramString = localDirectClassFile.getInterfaces();
        int j = paramString.size();
        int i = 0;
        while (i < j)
        {
          addClassWithHierachy(paramString.getType(i).getClassName());
          i += 1;
        }
        return;
      }
      catch (FileNotFoundException paramString) {}
    }
  }
  
  private void addDependencies(DirectClassFile paramDirectClassFile)
  {
    Object localObject1 = paramDirectClassFile.getConstantPool().getEntries();
    int j = localObject1.length;
    int i = 0;
    if (i < j)
    {
      Object localObject2 = localObject1[i];
      if ((localObject2 instanceof CstType)) {
        checkDescriptor(((CstType)localObject2).getClassType().getDescriptor());
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject2 instanceof CstFieldRef)) {
          checkDescriptor(((CstFieldRef)localObject2).getType().getDescriptor());
        } else if ((localObject2 instanceof CstBaseMethodRef)) {
          checkPrototype(((CstBaseMethodRef)localObject2).getPrototype());
        }
      }
    }
    localObject1 = paramDirectClassFile.getFields();
    j = ((FieldList)localObject1).size();
    i = 0;
    while (i < j)
    {
      checkDescriptor(((FieldList)localObject1).get(i).getDescriptor().getString());
      i += 1;
    }
    paramDirectClassFile = paramDirectClassFile.getMethods();
    j = paramDirectClassFile.size();
    i = 0;
    while (i < j)
    {
      checkPrototype(Prototype.intern(paramDirectClassFile.get(i).getDescriptor().getString()));
      i += 1;
    }
  }
  
  private void checkDescriptor(String paramString)
  {
    int i;
    if (paramString.endsWith(";"))
    {
      i = paramString.lastIndexOf('[');
      if (i < 0) {
        addClassWithHierachy(paramString.substring(1, paramString.length() - 1));
      }
    }
    else
    {
      return;
    }
    assert ((paramString.length() > i + 3) && (paramString.charAt(i + 1) == 'L'));
    addClassWithHierachy(paramString.substring(i + 2, paramString.length() - 1));
  }
  
  private void checkPrototype(Prototype paramPrototype)
  {
    checkDescriptor(paramPrototype.getReturnType().getDescriptor());
    paramPrototype = paramPrototype.getParameterTypes();
    int i = 0;
    while (i < paramPrototype.size())
    {
      checkDescriptor(paramPrototype.get(i).getDescriptor());
      i += 1;
    }
  }
  
  @Deprecated
  public static void main(String[] paramArrayOfString)
  {
    MainDexListBuilder.main(paramArrayOfString);
  }
  
  public void addRoots(ZipFile paramZipFile)
  {
    Enumeration localEnumeration = paramZipFile.entries();
    Object localObject;
    while (localEnumeration.hasMoreElements())
    {
      localObject = ((ZipEntry)localEnumeration.nextElement()).getName();
      if (((String)localObject).endsWith(".class")) {
        this.classNames.add(((String)localObject).substring(0, ((String)localObject).length() - ".class".length()));
      }
    }
    localEnumeration = paramZipFile.entries();
    while (localEnumeration.hasMoreElements())
    {
      paramZipFile = ((ZipEntry)localEnumeration.nextElement()).getName();
      if (paramZipFile.endsWith(".class")) {
        try
        {
          localObject = this.path.getClass(paramZipFile);
          addDependencies((DirectClassFile)localObject);
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          throw new IOException("Class " + paramZipFile + " is missing form original class path " + this.path, localFileNotFoundException);
        }
      }
    }
  }
  
  Set<String> getClassNames()
  {
    return this.classNames;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.multidex.ClassReferenceListBuilder
 * JD-Core Version:    0.7.0.1
 */