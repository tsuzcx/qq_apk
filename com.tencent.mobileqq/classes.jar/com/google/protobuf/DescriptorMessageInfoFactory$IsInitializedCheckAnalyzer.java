package com.google.protobuf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

class DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer
{
  private final Map<Descriptors.Descriptor, Boolean> a = new ConcurrentHashMap();
  private int b = 0;
  private final Stack<DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node> c = new Stack();
  private final Map<Descriptors.Descriptor, DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node> d = new HashMap();
  
  private void a(DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.StronglyConnectedComponent paramStronglyConnectedComponent)
  {
    Iterator localIterator = paramStronglyConnectedComponent.a.iterator();
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        while (!((Iterator)localObject1).hasNext())
        {
          boolean bool2 = localIterator.hasNext();
          bool1 = true;
          if (!bool2) {
            break;
          }
          localObject1 = (Descriptors.Descriptor)localIterator.next();
          if (((Descriptors.Descriptor)localObject1).k()) {
            break label148;
          }
          localObject1 = ((Descriptors.Descriptor)localObject1).f().iterator();
        }
        localObject2 = (Descriptors.FieldDescriptor)((Iterator)localObject1).next();
        if (((Descriptors.FieldDescriptor)localObject2).n()) {
          break label148;
        }
      } while (((Descriptors.FieldDescriptor)localObject2).g() != Descriptors.FieldDescriptor.JavaType.MESSAGE);
      localObject2 = (DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node)this.d.get(((Descriptors.FieldDescriptor)localObject2).y());
    } while ((((DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node)localObject2).d == paramStronglyConnectedComponent) || (!((DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node)localObject2).d.b));
    break label148;
    boolean bool1 = false;
    label148:
    paramStronglyConnectedComponent.b = bool1;
    localIterator = paramStronglyConnectedComponent.a.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Descriptors.Descriptor)localIterator.next();
      this.a.put(localObject1, Boolean.valueOf(paramStronglyConnectedComponent.b));
    }
  }
  
  private DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node b(Descriptors.Descriptor paramDescriptor)
  {
    int i = this.b;
    this.b = (i + 1);
    DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node localNode1 = new DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node(paramDescriptor, i);
    this.c.push(localNode1);
    this.d.put(paramDescriptor, localNode1);
    paramDescriptor = paramDescriptor.f().iterator();
    Object localObject;
    while (paramDescriptor.hasNext())
    {
      localObject = (Descriptors.FieldDescriptor)paramDescriptor.next();
      if (((Descriptors.FieldDescriptor)localObject).g() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
      {
        DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node localNode2 = (DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node)this.d.get(((Descriptors.FieldDescriptor)localObject).y());
        if (localNode2 == null)
        {
          localObject = b(((Descriptors.FieldDescriptor)localObject).y());
          localNode1.c = Math.min(localNode1.c, ((DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node)localObject).c);
        }
        else if (localNode2.d == null)
        {
          localNode1.c = Math.min(localNode1.c, localNode2.c);
        }
      }
    }
    if (localNode1.b == localNode1.c)
    {
      paramDescriptor = new DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.StronglyConnectedComponent(null);
      do
      {
        localObject = (DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node)this.c.pop();
        ((DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node)localObject).d = paramDescriptor;
        paramDescriptor.a.add(((DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.Node)localObject).a);
      } while (localObject != localNode1);
      a(paramDescriptor);
    }
    return localNode1;
  }
  
  public boolean a(Descriptors.Descriptor paramDescriptor)
  {
    Boolean localBoolean = (Boolean)this.a.get(paramDescriptor);
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    try
    {
      localBoolean = (Boolean)this.a.get(paramDescriptor);
      if (localBoolean != null)
      {
        bool = localBoolean.booleanValue();
        return bool;
      }
      boolean bool = b(paramDescriptor).d.b;
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer
 * JD-Core Version:    0.7.0.1
 */