package com.google.protobuf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

final class Descriptors$DescriptorPool
{
  private final Set<Descriptors.FileDescriptor> a = new HashSet();
  private boolean b;
  private final Map<String, Descriptors.GenericDescriptor> c = new HashMap();
  private final Map<Descriptors.DescriptorPool.DescriptorIntPair, Descriptors.FieldDescriptor> d = new HashMap();
  private final Map<Descriptors.DescriptorPool.DescriptorIntPair, Descriptors.EnumValueDescriptor> e = new HashMap();
  
  Descriptors$DescriptorPool(Descriptors.FileDescriptor[] paramArrayOfFileDescriptor, boolean paramBoolean)
  {
    this.b = paramBoolean;
    int i = 0;
    while (i < paramArrayOfFileDescriptor.length)
    {
      this.a.add(paramArrayOfFileDescriptor[i]);
      a(paramArrayOfFileDescriptor[i]);
      i += 1;
    }
    paramArrayOfFileDescriptor = this.a.iterator();
    while (paramArrayOfFileDescriptor.hasNext())
    {
      Descriptors.FileDescriptor localFileDescriptor = (Descriptors.FileDescriptor)paramArrayOfFileDescriptor.next();
      try
      {
        a(localFileDescriptor.e(), localFileDescriptor);
      }
      catch (Descriptors.DescriptorValidationException paramArrayOfFileDescriptor)
      {
        throw new AssertionError(paramArrayOfFileDescriptor);
      }
    }
  }
  
  private void a(Descriptors.FileDescriptor paramFileDescriptor)
  {
    paramFileDescriptor = paramFileDescriptor.i().iterator();
    while (paramFileDescriptor.hasNext())
    {
      Descriptors.FileDescriptor localFileDescriptor = (Descriptors.FileDescriptor)paramFileDescriptor.next();
      if (this.a.add(localFileDescriptor)) {
        a(localFileDescriptor);
      }
    }
  }
  
  static void d(Descriptors.GenericDescriptor paramGenericDescriptor)
  {
    String str = paramGenericDescriptor.b();
    if (str.length() != 0)
    {
      int i = 0;
      while (i < str.length())
      {
        int j = str.charAt(i);
        if (((97 > j) || (j > 122)) && ((65 > j) || (j > 90)) && (j != 95) && ((48 > j) || (j > 57) || (i <= 0)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append('"');
          localStringBuilder.append(str);
          localStringBuilder.append("\" is not a valid identifier.");
          throw new Descriptors.DescriptorValidationException(paramGenericDescriptor, localStringBuilder.toString(), null);
        }
        i += 1;
      }
      return;
    }
    paramGenericDescriptor = new Descriptors.DescriptorValidationException(paramGenericDescriptor, "Missing name.", null);
    for (;;)
    {
      throw paramGenericDescriptor;
    }
  }
  
  Descriptors.GenericDescriptor a(String paramString)
  {
    return a(paramString, Descriptors.DescriptorPool.SearchFilter.ALL_SYMBOLS);
  }
  
  Descriptors.GenericDescriptor a(String paramString, Descriptors.DescriptorPool.SearchFilter paramSearchFilter)
  {
    Object localObject = (Descriptors.GenericDescriptor)this.c.get(paramString);
    if ((localObject != null) && ((paramSearchFilter == Descriptors.DescriptorPool.SearchFilter.ALL_SYMBOLS) || ((paramSearchFilter == Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY) && (a((Descriptors.GenericDescriptor)localObject))) || ((paramSearchFilter == Descriptors.DescriptorPool.SearchFilter.AGGREGATES_ONLY) && (b((Descriptors.GenericDescriptor)localObject))))) {
      return localObject;
    }
    localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Descriptors.GenericDescriptor localGenericDescriptor = (Descriptors.GenericDescriptor)Descriptors.FileDescriptor.a((Descriptors.FileDescriptor)((Iterator)localObject).next()).c.get(paramString);
      if ((localGenericDescriptor != null) && ((paramSearchFilter == Descriptors.DescriptorPool.SearchFilter.ALL_SYMBOLS) || ((paramSearchFilter == Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY) && (a(localGenericDescriptor))) || ((paramSearchFilter == Descriptors.DescriptorPool.SearchFilter.AGGREGATES_ONLY) && (b(localGenericDescriptor))))) {
        return localGenericDescriptor;
      }
    }
    return null;
  }
  
  Descriptors.GenericDescriptor a(String paramString, Descriptors.GenericDescriptor paramGenericDescriptor, Descriptors.DescriptorPool.SearchFilter paramSearchFilter)
  {
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    if (paramString.startsWith("."))
    {
      localObject1 = paramString.substring(1);
      localObject2 = a((String)localObject1, paramSearchFilter);
    }
    else
    {
      i = paramString.indexOf('.');
      if (i == -1) {
        localObject1 = paramString;
      } else {
        localObject1 = paramString.substring(0, i);
      }
      localObject3 = new StringBuilder(paramGenericDescriptor.c());
    }
    for (;;)
    {
      int j = ((StringBuilder)localObject3).lastIndexOf(".");
      if (j == -1)
      {
        localObject2 = a(paramString, paramSearchFilter);
        localObject1 = paramString;
      }
      else
      {
        int k = j + 1;
        ((StringBuilder)localObject3).setLength(k);
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject2 = a(((StringBuilder)localObject3).toString(), Descriptors.DescriptorPool.SearchFilter.AGGREGATES_ONLY);
        if (localObject2 == null) {
          break label323;
        }
        if (i != -1)
        {
          ((StringBuilder)localObject3).setLength(k);
          ((StringBuilder)localObject3).append(paramString);
          localObject1 = a(((StringBuilder)localObject3).toString(), paramSearchFilter);
        }
        else
        {
          localObject1 = localObject2;
        }
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      if (localObject2 == null)
      {
        if ((this.b) && (paramSearchFilter == Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY))
        {
          paramGenericDescriptor = Descriptors.a();
          paramSearchFilter = new StringBuilder();
          paramSearchFilter.append("The descriptor for message type \"");
          paramSearchFilter.append(paramString);
          paramSearchFilter.append("\" can not be found and a placeholder is created for it");
          paramGenericDescriptor.warning(paramSearchFilter.toString());
          paramString = new Descriptors.Descriptor((String)localObject1);
          this.a.add(paramString.d());
          return paramString;
        }
        paramSearchFilter = new StringBuilder();
        paramSearchFilter.append('"');
        paramSearchFilter.append(paramString);
        paramSearchFilter.append("\" is not defined.");
        throw new Descriptors.DescriptorValidationException(paramGenericDescriptor, paramSearchFilter.toString(), null);
      }
      return localObject2;
      label323:
      ((StringBuilder)localObject3).setLength(j);
    }
  }
  
  void a(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
  {
    Descriptors.DescriptorPool.DescriptorIntPair localDescriptorIntPair = new Descriptors.DescriptorPool.DescriptorIntPair(paramEnumValueDescriptor.f(), paramEnumValueDescriptor.getNumber());
    paramEnumValueDescriptor = (Descriptors.EnumValueDescriptor)this.e.put(localDescriptorIntPair, paramEnumValueDescriptor);
    if (paramEnumValueDescriptor != null) {
      this.e.put(localDescriptorIntPair, paramEnumValueDescriptor);
    }
  }
  
  void a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    Object localObject = new Descriptors.DescriptorPool.DescriptorIntPair(paramFieldDescriptor.v(), paramFieldDescriptor.f());
    Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)this.d.put(localObject, paramFieldDescriptor);
    if (localFieldDescriptor == null) {
      return;
    }
    this.d.put(localObject, localFieldDescriptor);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Field number ");
    ((StringBuilder)localObject).append(paramFieldDescriptor.f());
    ((StringBuilder)localObject).append(" has already been used in \"");
    ((StringBuilder)localObject).append(paramFieldDescriptor.v().c());
    ((StringBuilder)localObject).append("\" by field \"");
    ((StringBuilder)localObject).append(localFieldDescriptor.b());
    ((StringBuilder)localObject).append("\".");
    throw new Descriptors.DescriptorValidationException(paramFieldDescriptor, ((StringBuilder)localObject).toString(), null);
  }
  
  void a(String paramString, Descriptors.FileDescriptor paramFileDescriptor)
  {
    int i = paramString.lastIndexOf('.');
    String str;
    if (i == -1)
    {
      str = paramString;
    }
    else
    {
      a(paramString.substring(0, i), paramFileDescriptor);
      str = paramString.substring(i + 1);
    }
    Descriptors.GenericDescriptor localGenericDescriptor = (Descriptors.GenericDescriptor)this.c.put(paramString, new Descriptors.DescriptorPool.PackageDescriptor(str, paramString, paramFileDescriptor));
    if (localGenericDescriptor != null)
    {
      this.c.put(paramString, localGenericDescriptor);
      if ((localGenericDescriptor instanceof Descriptors.DescriptorPool.PackageDescriptor)) {
        return;
      }
      paramString = new StringBuilder();
      paramString.append('"');
      paramString.append(str);
      paramString.append("\" is already defined (as something other than a package) in file \"");
      paramString.append(localGenericDescriptor.d().b());
      paramString.append("\".");
      throw new Descriptors.DescriptorValidationException(paramFileDescriptor, paramString.toString(), null);
    }
  }
  
  boolean a(Descriptors.GenericDescriptor paramGenericDescriptor)
  {
    return ((paramGenericDescriptor instanceof Descriptors.Descriptor)) || ((paramGenericDescriptor instanceof Descriptors.EnumDescriptor));
  }
  
  boolean b(Descriptors.GenericDescriptor paramGenericDescriptor)
  {
    return ((paramGenericDescriptor instanceof Descriptors.Descriptor)) || ((paramGenericDescriptor instanceof Descriptors.EnumDescriptor)) || ((paramGenericDescriptor instanceof Descriptors.DescriptorPool.PackageDescriptor)) || ((paramGenericDescriptor instanceof Descriptors.ServiceDescriptor));
  }
  
  void c(Descriptors.GenericDescriptor paramGenericDescriptor)
  {
    d(paramGenericDescriptor);
    String str = paramGenericDescriptor.c();
    Object localObject = (Descriptors.GenericDescriptor)this.c.put(str, paramGenericDescriptor);
    if (localObject != null)
    {
      this.c.put(str, localObject);
      if (paramGenericDescriptor.d() == ((Descriptors.GenericDescriptor)localObject).d())
      {
        int i = str.lastIndexOf('.');
        if (i == -1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append('"');
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append("\" is already defined.");
          throw new Descriptors.DescriptorValidationException(paramGenericDescriptor, ((StringBuilder)localObject).toString(), null);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append('"');
        ((StringBuilder)localObject).append(str.substring(i + 1));
        ((StringBuilder)localObject).append("\" is already defined in \"");
        ((StringBuilder)localObject).append(str.substring(0, i));
        ((StringBuilder)localObject).append("\".");
        throw new Descriptors.DescriptorValidationException(paramGenericDescriptor, ((StringBuilder)localObject).toString(), null);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('"');
      localStringBuilder.append(str);
      localStringBuilder.append("\" is already defined in file \"");
      localStringBuilder.append(((Descriptors.GenericDescriptor)localObject).d().b());
      localStringBuilder.append("\".");
      throw new Descriptors.DescriptorValidationException(paramGenericDescriptor, localStringBuilder.toString(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Descriptors.DescriptorPool
 * JD-Core Version:    0.7.0.1
 */