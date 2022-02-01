package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite
{
  private static volatile boolean a = false;
  static final ExtensionRegistryLite b = new ExtensionRegistryLite(true);
  private static final Class<?> c = ;
  private static volatile ExtensionRegistryLite d;
  private final Map<ExtensionRegistryLite.ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> e;
  
  ExtensionRegistryLite()
  {
    this.e = new HashMap();
  }
  
  ExtensionRegistryLite(ExtensionRegistryLite paramExtensionRegistryLite)
  {
    if (paramExtensionRegistryLite == b)
    {
      this.e = Collections.emptyMap();
      return;
    }
    this.e = Collections.unmodifiableMap(paramExtensionRegistryLite.e);
  }
  
  ExtensionRegistryLite(boolean paramBoolean)
  {
    this.e = Collections.emptyMap();
  }
  
  static Class<?> b()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.Extension");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  public static boolean c()
  {
    return a;
  }
  
  public static ExtensionRegistryLite d()
  {
    Object localObject = d;
    if (localObject == null) {
      try
      {
        ExtensionRegistryLite localExtensionRegistryLite2 = d;
        localObject = localExtensionRegistryLite2;
        if (localExtensionRegistryLite2 == null)
        {
          localObject = ExtensionRegistryFactory.b();
          d = (ExtensionRegistryLite)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localExtensionRegistryLite1;
  }
  
  public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> a(ContainingType paramContainingType, int paramInt)
  {
    return (GeneratedMessageLite.GeneratedExtension)this.e.get(new ExtensionRegistryLite.ObjectIntPair(paramContainingType, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ExtensionRegistryLite
 * JD-Core Version:    0.7.0.1
 */