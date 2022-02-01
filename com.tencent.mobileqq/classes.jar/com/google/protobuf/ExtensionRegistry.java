package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistry
  extends ExtensionRegistryLite
{
  static final ExtensionRegistry a = new ExtensionRegistry(true);
  private final Map<String, ExtensionRegistry.ExtensionInfo> c;
  private final Map<String, ExtensionRegistry.ExtensionInfo> d;
  private final Map<ExtensionRegistry.DescriptorIntPair, ExtensionRegistry.ExtensionInfo> e;
  private final Map<ExtensionRegistry.DescriptorIntPair, ExtensionRegistry.ExtensionInfo> f;
  
  private ExtensionRegistry()
  {
    this.c = new HashMap();
    this.d = new HashMap();
    this.e = new HashMap();
    this.f = new HashMap();
  }
  
  ExtensionRegistry(boolean paramBoolean)
  {
    super(b);
    this.c = Collections.emptyMap();
    this.d = Collections.emptyMap();
    this.e = Collections.emptyMap();
    this.f = Collections.emptyMap();
  }
  
  public static ExtensionRegistry a()
  {
    return a;
  }
  
  @Deprecated
  public ExtensionRegistry.ExtensionInfo a(Descriptors.Descriptor paramDescriptor, int paramInt)
  {
    return b(paramDescriptor, paramInt);
  }
  
  public ExtensionRegistry.ExtensionInfo b(Descriptors.Descriptor paramDescriptor, int paramInt)
  {
    return (ExtensionRegistry.ExtensionInfo)this.e.get(new ExtensionRegistry.DescriptorIntPair(paramDescriptor, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ExtensionRegistry
 * JD-Core Version:    0.7.0.1
 */