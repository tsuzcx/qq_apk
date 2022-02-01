package com.android.dx;

import com.android.dx.dex.DexOptions;
import com.android.dx.dex.file.DexFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

public final class DexMaker
{
  private final Map<TypeId<?>, DexMaker.TypeDeclaration> types = new LinkedHashMap();
  
  private ClassLoader generateClassLoader(File paramFile1, File paramFile2, ClassLoader paramClassLoader)
  {
    try
    {
      paramFile1 = (ClassLoader)Class.forName("dalvik.system.DexClassLoader").getConstructor(new Class[] { String.class, String.class, String.class, ClassLoader.class }).newInstance(new Object[] { paramFile1.getPath(), paramFile2.getAbsolutePath(), null, paramClassLoader });
      return paramFile1;
    }
    catch (ClassNotFoundException paramFile1)
    {
      throw new UnsupportedOperationException("load() requires a Dalvik VM", paramFile1);
    }
    catch (InvocationTargetException paramFile1)
    {
      throw new RuntimeException(paramFile1.getCause());
    }
    catch (InstantiationException paramFile1)
    {
      throw new AssertionError();
    }
    catch (NoSuchMethodException paramFile1)
    {
      throw new AssertionError();
    }
    catch (IllegalAccessException paramFile1)
    {
      throw new AssertionError();
    }
  }
  
  private String generateFileName()
  {
    int j = 0;
    Object localObject = this.types.keySet();
    Iterator localIterator = ((Set)localObject).iterator();
    localObject = new int[((Set)localObject).size()];
    int i = 0;
    int k;
    if (localIterator.hasNext())
    {
      DexMaker.TypeDeclaration localTypeDeclaration = getTypeDeclaration((TypeId)localIterator.next());
      Set localSet = DexMaker.TypeDeclaration.access$500(localTypeDeclaration).keySet();
      if (DexMaker.TypeDeclaration.access$200(localTypeDeclaration) == null) {
        break label177;
      }
      k = i + 1;
      localObject[i] = (DexMaker.TypeDeclaration.access$200(localTypeDeclaration).hashCode() * 31 + localSet.hashCode());
      i = k;
    }
    label177:
    for (;;)
    {
      break;
      Arrays.sort((int[])localObject);
      int m = localObject.length;
      k = 1;
      i = j;
      j = k;
      while (i < m)
      {
        j = j * 31 + localObject[i];
        i += 1;
      }
      return "Generated_" + j + ".jar";
    }
  }
  
  private DexMaker.TypeDeclaration getTypeDeclaration(TypeId<?> paramTypeId)
  {
    DexMaker.TypeDeclaration localTypeDeclaration2 = (DexMaker.TypeDeclaration)this.types.get(paramTypeId);
    DexMaker.TypeDeclaration localTypeDeclaration1 = localTypeDeclaration2;
    if (localTypeDeclaration2 == null)
    {
      localTypeDeclaration1 = new DexMaker.TypeDeclaration(paramTypeId);
      this.types.put(paramTypeId, localTypeDeclaration1);
    }
    return localTypeDeclaration1;
  }
  
  public Code declare(MethodId<?, ?> paramMethodId, int paramInt)
  {
    DexMaker.TypeDeclaration localTypeDeclaration = getTypeDeclaration(paramMethodId.declaringType);
    if (DexMaker.TypeDeclaration.access$500(localTypeDeclaration).containsKey(paramMethodId)) {
      throw new IllegalStateException("already declared: " + paramMethodId);
    }
    if ((paramInt & 0xFFFFFFC0) != 0) {
      throw new IllegalArgumentException("Unexpected flag: " + Integer.toHexString(paramInt));
    }
    int i = paramInt;
    if ((paramInt & 0x20) != 0) {
      i = paramInt & 0xFFFFFFDF | 0x20000;
    }
    if (!paramMethodId.isConstructor())
    {
      paramInt = i;
      if (!paramMethodId.isStaticInitializer()) {}
    }
    else
    {
      paramInt = i | 0x10000;
    }
    DexMaker.MethodDeclaration localMethodDeclaration = new DexMaker.MethodDeclaration(paramMethodId, paramInt);
    DexMaker.TypeDeclaration.access$500(localTypeDeclaration).put(paramMethodId, localMethodDeclaration);
    return DexMaker.MethodDeclaration.access$600(localMethodDeclaration);
  }
  
  public void declare(FieldId<?, ?> paramFieldId, int paramInt, Object paramObject)
  {
    DexMaker.TypeDeclaration localTypeDeclaration = getTypeDeclaration(paramFieldId.declaringType);
    if (DexMaker.TypeDeclaration.access$700(localTypeDeclaration).containsKey(paramFieldId)) {
      throw new IllegalStateException("already declared: " + paramFieldId);
    }
    if ((paramInt & 0xFFFFFF20) != 0) {
      throw new IllegalArgumentException("Unexpected flag: " + Integer.toHexString(paramInt));
    }
    if (((paramInt & 0x8) == 0) && (paramObject != null)) {
      throw new IllegalArgumentException("staticValue is non-null, but field is not static");
    }
    paramObject = new DexMaker.FieldDeclaration(paramFieldId, paramInt, paramObject);
    DexMaker.TypeDeclaration.access$700(localTypeDeclaration).put(paramFieldId, paramObject);
  }
  
  public void declare(TypeId<?> paramTypeId1, String paramString, int paramInt, TypeId<?> paramTypeId2, TypeId<?>... paramVarArgs)
  {
    DexMaker.TypeDeclaration localTypeDeclaration = getTypeDeclaration(paramTypeId1);
    if ((paramInt & 0xFFFFFBEE) != 0) {
      throw new IllegalArgumentException("Unexpected flag: " + Integer.toHexString(paramInt));
    }
    if (DexMaker.TypeDeclaration.access$000(localTypeDeclaration)) {
      throw new IllegalStateException("already declared: " + paramTypeId1);
    }
    DexMaker.TypeDeclaration.access$002(localTypeDeclaration, true);
    DexMaker.TypeDeclaration.access$102(localTypeDeclaration, paramInt);
    DexMaker.TypeDeclaration.access$202(localTypeDeclaration, paramTypeId2);
    DexMaker.TypeDeclaration.access$302(localTypeDeclaration, paramString);
    DexMaker.TypeDeclaration.access$402(localTypeDeclaration, new TypeList(paramVarArgs));
  }
  
  public byte[] generate()
  {
    Object localObject = new DexOptions();
    ((DexOptions)localObject).targetApiLevel = 13;
    localObject = new DexFile((DexOptions)localObject);
    Iterator localIterator = this.types.values().iterator();
    while (localIterator.hasNext()) {
      ((DexFile)localObject).add(((DexMaker.TypeDeclaration)localIterator.next()).toClassDefItem());
    }
    try
    {
      localObject = ((DexFile)localObject).toDex(null, false);
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public ClassLoader generateAndLoad(ClassLoader paramClassLoader, File paramFile)
  {
    File localFile = paramFile;
    if (paramFile == null)
    {
      paramFile = System.getProperty("dexmaker.dexcache");
      if (paramFile == null) {
        break label54;
      }
      localFile = new File(paramFile);
    }
    label54:
    do
    {
      paramFile = new File(localFile, generateFileName());
      if (!paramFile.exists()) {
        break;
      }
      return generateClassLoader(paramFile, localFile, paramClassLoader);
      paramFile = new AppDataDirGuesser().guess();
      localFile = paramFile;
    } while (paramFile != null);
    throw new IllegalArgumentException("dexcache == null (and no default could be found; consider setting the 'dexmaker.dexcache' system property)");
    byte[] arrayOfByte = generate();
    paramFile.createNewFile();
    JarOutputStream localJarOutputStream = new JarOutputStream(new FileOutputStream(paramFile));
    JarEntry localJarEntry = new JarEntry("classes.dex");
    localJarEntry.setSize(arrayOfByte.length);
    localJarOutputStream.putNextEntry(localJarEntry);
    localJarOutputStream.write(arrayOfByte);
    localJarOutputStream.closeEntry();
    localJarOutputStream.close();
    return generateClassLoader(paramFile, localFile, paramClassLoader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.DexMaker
 * JD-Core Version:    0.7.0.1
 */